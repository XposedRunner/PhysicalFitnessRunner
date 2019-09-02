package org.xutils.db;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import org.xutils.DbManager;
import org.xutils.DbManager.DaoConfig;
import org.xutils.DbManager.DbOpenListener;
import org.xutils.DbManager.DbUpgradeListener;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.KeyValue;
import org.xutils.common.util.LogUtil;
import org.xutils.db.sqlite.SqlInfo;
import org.xutils.db.sqlite.SqlInfoBuilder;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.db.table.ColumnEntity;
import org.xutils.db.table.DbBase;
import org.xutils.db.table.DbModel;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;
import org.xutils.x;

public final class DbManagerImpl extends DbBase {
    private static final HashMap<DaoConfig, DbManagerImpl> DAO_MAP = new HashMap();
    private boolean allowTransaction;
    private DaoConfig daoConfig;
    private SQLiteDatabase database;

    private DbManagerImpl(DaoConfig daoConfig) {
        if (daoConfig == null) {
            throw new IllegalArgumentException("daoConfig may not be null");
        }
        this.daoConfig = daoConfig;
        this.allowTransaction = daoConfig.isAllowTransaction();
        this.database = openOrCreateDatabase(daoConfig);
        DbOpenListener dbOpenListener = daoConfig.getDbOpenListener();
        if (dbOpenListener != null) {
            dbOpenListener.onDbOpened(this);
        }
    }

    private void beginTransaction() {
        if (this.allowTransaction) {
            this.database.beginTransaction();
        }
    }

    private void endTransaction() {
        if (this.allowTransaction) {
            this.database.endTransaction();
        }
    }

    public static synchronized DbManager getInstance(DaoConfig daoConfig) {
        DbManagerImpl dbManagerImpl;
        synchronized (DbManagerImpl.class) {
            Object daoConfig2;
            if (daoConfig2 == null) {
                try {
                    daoConfig2 = new DaoConfig();
                } catch (DbException e) {
                    LogUtil.e(e.getMessage(), e);
                } catch (Throwable th) {
                }
            }
            dbManagerImpl = (DbManagerImpl) DAO_MAP.get(daoConfig2);
            if (dbManagerImpl == null) {
                dbManagerImpl = new DbManagerImpl(daoConfig2);
                DAO_MAP.put(daoConfig2, dbManagerImpl);
            } else {
                dbManagerImpl.daoConfig = daoConfig2;
            }
            SQLiteDatabase sQLiteDatabase = dbManagerImpl.database;
            int version = sQLiteDatabase.getVersion();
            int dbVersion = daoConfig2.getDbVersion();
            if (version != dbVersion) {
                if (version != 0) {
                    DbUpgradeListener dbUpgradeListener = daoConfig2.getDbUpgradeListener();
                    if (dbUpgradeListener != null) {
                        dbUpgradeListener.onUpgrade(dbManagerImpl, version, dbVersion);
                    } else {
                        dbManagerImpl.dropDb();
                    }
                }
                sQLiteDatabase.setVersion(dbVersion);
            }
        }
        return dbManagerImpl;
    }

    private long getLastAutoIncrementId(String str) throws DbException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT seq FROM sqlite_sequence WHERE name='");
        stringBuilder.append(str);
        stringBuilder.append("' LIMIT 1");
        Cursor execQuery = execQuery(stringBuilder.toString());
        long j = -1;
        if (execQuery != null) {
            try {
                if (execQuery.moveToNext()) {
                    j = execQuery.getLong(0);
                }
                IOUtil.closeQuietly(execQuery);
            } catch (Throwable th) {
                IOUtil.closeQuietly(execQuery);
            }
        }
        return j;
    }

    private SQLiteDatabase openOrCreateDatabase(DaoConfig daoConfig) {
        SQLiteDatabase.loadLibs(x.app());
        File dbDir = daoConfig.getDbDir();
        if (dbDir == null) {
            dbDir = new File(x.app().getDatabasePath("DB_TEST.db").getParent());
        }
        File file = (dbDir.exists() || dbDir.mkdirs()) ? new File(dbDir, daoConfig.getDbName()) : null;
        String dBpwd = daoConfig.getDBpwd();
        return TextUtils.isEmpty(dBpwd) ? SQLiteDatabase.openOrCreateDatabase(file, "", null) : SQLiteDatabase.openOrCreateDatabase(file, dBpwd, null);
    }

    private boolean saveBindingIdWithoutTransaction(TableEntity<?> tableEntity, Object obj) throws DbException {
        ColumnEntity id = tableEntity.getId();
        if (id.isAutoId()) {
            execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(tableEntity, obj));
            long lastAutoIncrementId = getLastAutoIncrementId(tableEntity.getName());
            if (lastAutoIncrementId == -1) {
                return false;
            }
            id.setAutoIdValue(obj, lastAutoIncrementId);
            return true;
        }
        execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(tableEntity, obj));
        return true;
    }

    private void saveOrUpdateWithoutTransaction(TableEntity<?> tableEntity, Object obj) throws DbException {
        ColumnEntity id = tableEntity.getId();
        if (!id.isAutoId()) {
            execNonQuery(SqlInfoBuilder.buildReplaceSqlInfo(tableEntity, obj));
        } else if (id.getColumnValue(obj) != null) {
            execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo((TableEntity) tableEntity, obj, new String[0]));
        } else {
            saveBindingIdWithoutTransaction(tableEntity, obj);
        }
    }

    private void setTransactionSuccessful() {
        if (this.allowTransaction) {
            this.database.setTransactionSuccessful();
        }
    }

    public void close() throws IOException {
        if (DAO_MAP.containsKey(this.daoConfig)) {
            DAO_MAP.remove(this.daoConfig);
            this.database.close();
        }
    }

    public int delete(Class<?> cls, WhereBuilder whereBuilder) throws DbException {
        TableEntity table = getTable(cls);
        if (!table.tableIsExist()) {
            return 0;
        }
        try {
            beginTransaction();
            int executeUpdateDelete = executeUpdateDelete(SqlInfoBuilder.buildDeleteSqlInfo(table, whereBuilder));
            setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            endTransaction();
        }
    }

    public void delete(Class<?> cls) throws DbException {
        delete(cls, null);
    }

    public void delete(Object obj) throws DbException {
        try {
            beginTransaction();
            TableEntity table;
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    table = getTable(list.get(0).getClass());
                    if (table.tableIsExist()) {
                        for (Object buildDeleteSqlInfo : list) {
                            execNonQuery(SqlInfoBuilder.buildDeleteSqlInfo(table, buildDeleteSqlInfo));
                        }
                    } else {
                        endTransaction();
                        return;
                    }
                }
                return;
            }
            table = getTable(obj.getClass());
            if (table.tableIsExist()) {
                execNonQuery(SqlInfoBuilder.buildDeleteSqlInfo(table, obj));
            } else {
                endTransaction();
                return;
            }
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    public void deleteById(Class<?> cls, Object obj) throws DbException {
        TableEntity table = getTable(cls);
        if (table.tableIsExist()) {
            try {
                beginTransaction();
                execNonQuery(SqlInfoBuilder.buildDeleteSqlInfoById(table, obj));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void execNonQuery(String str) throws DbException {
        try {
            this.database.execSQL(str);
        } catch (Throwable th) {
            DbException dbException = new DbException(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A:{SYNTHETIC, Splitter:B:20:0x002e} */
    public void execNonQuery(org.xutils.db.sqlite.SqlInfo r4) throws org.xutils.ex.DbException {
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.database;	 Catch:{ Throwable -> 0x0025 }
        r4 = r4.buildStatement(r1);	 Catch:{ Throwable -> 0x0025 }
        r4.execute();	 Catch:{ Throwable -> 0x001e, all -> 0x0019 }
        if (r4 == 0) goto L_0x0018;
    L_0x000c:
        r4.releaseReference();	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0018;
    L_0x0010:
        r4 = move-exception;
        r0 = r4.getMessage();
        org.xutils.common.util.LogUtil.e(r0, r4);
    L_0x0018:
        return;
    L_0x0019:
        r0 = move-exception;
        r2 = r0;
        r0 = r4;
        r4 = r2;
        goto L_0x002c;
    L_0x001e:
        r0 = move-exception;
        r2 = r0;
        r0 = r4;
        r4 = r2;
        goto L_0x0026;
    L_0x0023:
        r4 = move-exception;
        goto L_0x002c;
    L_0x0025:
        r4 = move-exception;
    L_0x0026:
        r1 = new org.xutils.ex.DbException;	 Catch:{ all -> 0x0023 }
        r1.<init>(r4);	 Catch:{ all -> 0x0023 }
        throw r1;	 Catch:{ all -> 0x0023 }
    L_0x002c:
        if (r0 == 0) goto L_0x003a;
    L_0x002e:
        r0.releaseReference();	 Catch:{ Throwable -> 0x0032 }
        goto L_0x003a;
    L_0x0032:
        r0 = move-exception;
        r1 = r0.getMessage();
        org.xutils.common.util.LogUtil.e(r1, r0);
    L_0x003a:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xutils.db.DbManagerImpl.execNonQuery(org.xutils.db.sqlite.SqlInfo):void");
    }

    public Cursor execQuery(String str) throws DbException {
        try {
            return this.database.rawQuery(str, null);
        } catch (Throwable th) {
            DbException dbException = new DbException(th);
        }
    }

    public Cursor execQuery(SqlInfo sqlInfo) throws DbException {
        try {
            return this.database.rawQuery(sqlInfo.getSql(), sqlInfo.getBindArgsAsStrArray());
        } catch (Throwable th) {
            DbException dbException = new DbException(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002f A:{SYNTHETIC, Splitter:B:21:0x002f} */
    public int executeUpdateDelete(java.lang.String r4) throws org.xutils.ex.DbException {
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.database;	 Catch:{ Throwable -> 0x0026 }
        r4 = r1.compileStatement(r4);	 Catch:{ Throwable -> 0x0026 }
        r0 = r4.executeUpdateDelete();	 Catch:{ Throwable -> 0x001f, all -> 0x001a }
        if (r4 == 0) goto L_0x0019;
    L_0x000d:
        r4.releaseReference();	 Catch:{ Throwable -> 0x0011 }
        goto L_0x0019;
    L_0x0011:
        r4 = move-exception;
        r1 = r4.getMessage();
        org.xutils.common.util.LogUtil.e(r1, r4);
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = move-exception;
        r2 = r0;
        r0 = r4;
        r4 = r2;
        goto L_0x002d;
    L_0x001f:
        r0 = move-exception;
        r2 = r0;
        r0 = r4;
        r4 = r2;
        goto L_0x0027;
    L_0x0024:
        r4 = move-exception;
        goto L_0x002d;
    L_0x0026:
        r4 = move-exception;
    L_0x0027:
        r1 = new org.xutils.ex.DbException;	 Catch:{ all -> 0x0024 }
        r1.<init>(r4);	 Catch:{ all -> 0x0024 }
        throw r1;	 Catch:{ all -> 0x0024 }
    L_0x002d:
        if (r0 == 0) goto L_0x003b;
    L_0x002f:
        r0.releaseReference();	 Catch:{ Throwable -> 0x0033 }
        goto L_0x003b;
    L_0x0033:
        r0 = move-exception;
        r1 = r0.getMessage();
        org.xutils.common.util.LogUtil.e(r1, r0);
    L_0x003b:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xutils.db.DbManagerImpl.executeUpdateDelete(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002f A:{SYNTHETIC, Splitter:B:21:0x002f} */
    public int executeUpdateDelete(org.xutils.db.sqlite.SqlInfo r4) throws org.xutils.ex.DbException {
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.database;	 Catch:{ Throwable -> 0x0026 }
        r4 = r4.buildStatement(r1);	 Catch:{ Throwable -> 0x0026 }
        r0 = r4.executeUpdateDelete();	 Catch:{ Throwable -> 0x001f, all -> 0x001a }
        if (r4 == 0) goto L_0x0019;
    L_0x000d:
        r4.releaseReference();	 Catch:{ Throwable -> 0x0011 }
        goto L_0x0019;
    L_0x0011:
        r4 = move-exception;
        r1 = r4.getMessage();
        org.xutils.common.util.LogUtil.e(r1, r4);
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = move-exception;
        r2 = r0;
        r0 = r4;
        r4 = r2;
        goto L_0x002d;
    L_0x001f:
        r0 = move-exception;
        r2 = r0;
        r0 = r4;
        r4 = r2;
        goto L_0x0027;
    L_0x0024:
        r4 = move-exception;
        goto L_0x002d;
    L_0x0026:
        r4 = move-exception;
    L_0x0027:
        r1 = new org.xutils.ex.DbException;	 Catch:{ all -> 0x0024 }
        r1.<init>(r4);	 Catch:{ all -> 0x0024 }
        throw r1;	 Catch:{ all -> 0x0024 }
    L_0x002d:
        if (r0 == 0) goto L_0x003b;
    L_0x002f:
        r0.releaseReference();	 Catch:{ Throwable -> 0x0033 }
        goto L_0x003b;
    L_0x0033:
        r0 = move-exception;
        r1 = r0.getMessage();
        org.xutils.common.util.LogUtil.e(r1, r0);
    L_0x003b:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xutils.db.DbManagerImpl.executeUpdateDelete(org.xutils.db.sqlite.SqlInfo):int");
    }

    public <T> List<T> findAll(Class<T> cls) throws DbException {
        return selector(cls).findAll();
    }

    public <T> T findById(Class<T> cls, Object obj) throws DbException {
        TableEntity table = getTable(cls);
        if (!table.tableIsExist()) {
            return null;
        }
        Cursor execQuery = execQuery(Selector.from(table).where(table.getId().getName(), "=", obj).limit(1).toString());
        if (execQuery != null) {
            try {
                if (execQuery.moveToNext()) {
                    Object entity = CursorUtils.getEntity(table, execQuery);
                    IOUtil.closeQuietly(execQuery);
                    return entity;
                }
                IOUtil.closeQuietly(execQuery);
            } catch (Throwable th) {
                IOUtil.closeQuietly(execQuery);
            }
        }
        return null;
    }

    public List<DbModel> findDbModelAll(SqlInfo sqlInfo) throws DbException {
        ArrayList arrayList = new ArrayList();
        Cursor execQuery = execQuery(sqlInfo);
        if (execQuery != null) {
            while (execQuery.moveToNext()) {
                try {
                    arrayList.add(CursorUtils.getDbModel(execQuery));
                } catch (Throwable th) {
                    IOUtil.closeQuietly(execQuery);
                }
            }
            IOUtil.closeQuietly(execQuery);
        }
        return arrayList;
    }

    public DbModel findDbModelFirst(SqlInfo sqlInfo) throws DbException {
        Cursor execQuery = execQuery(sqlInfo);
        if (execQuery != null) {
            try {
                if (execQuery.moveToNext()) {
                    DbModel dbModel = CursorUtils.getDbModel(execQuery);
                    IOUtil.closeQuietly(execQuery);
                    return dbModel;
                }
                IOUtil.closeQuietly(execQuery);
            } catch (Throwable th) {
                IOUtil.closeQuietly(execQuery);
            }
        }
        return null;
    }

    public <T> T findFirst(Class<T> cls) throws DbException {
        return selector(cls).findFirst();
    }

    public DaoConfig getDaoConfig() {
        return this.daoConfig;
    }

    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    public void replace(Object obj) throws DbException {
        try {
            beginTransaction();
            TableEntity table;
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    table = getTable(list.get(0).getClass());
                    createTableIfNotExist(table);
                    for (Object buildReplaceSqlInfo : list) {
                        execNonQuery(SqlInfoBuilder.buildReplaceSqlInfo(table, buildReplaceSqlInfo));
                    }
                } else {
                    return;
                }
            }
            table = getTable(obj.getClass());
            createTableIfNotExist(table);
            execNonQuery(SqlInfoBuilder.buildReplaceSqlInfo(table, obj));
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    public void save(Object obj) throws DbException {
        try {
            beginTransaction();
            TableEntity table;
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    table = getTable(list.get(0).getClass());
                    createTableIfNotExist(table);
                    for (Object buildInsertSqlInfo : list) {
                        execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(table, buildInsertSqlInfo));
                    }
                } else {
                    return;
                }
            }
            table = getTable(obj.getClass());
            createTableIfNotExist(table);
            execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(table, obj));
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    public boolean saveBindingId(Object obj) throws DbException {
        try {
            beginTransaction();
            boolean z = false;
            TableEntity table;
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (list.isEmpty()) {
                    return z;
                }
                table = getTable(list.get(z).getClass());
                createTableIfNotExist(table);
                for (Object saveBindingIdWithoutTransaction : list) {
                    if (!saveBindingIdWithoutTransaction(table, saveBindingIdWithoutTransaction)) {
                        throw new DbException("saveBindingId error, transaction will not commit!");
                    }
                }
            }
            table = getTable(obj.getClass());
            createTableIfNotExist(table);
            z = saveBindingIdWithoutTransaction(table, obj);
            setTransactionSuccessful();
            endTransaction();
            return z;
        } finally {
            endTransaction();
        }
    }

    public void saveOrUpdate(Object obj) throws DbException {
        try {
            beginTransaction();
            TableEntity table;
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    table = getTable(list.get(0).getClass());
                    createTableIfNotExist(table);
                    for (Object saveOrUpdateWithoutTransaction : list) {
                        saveOrUpdateWithoutTransaction(table, saveOrUpdateWithoutTransaction);
                    }
                } else {
                    return;
                }
            }
            table = getTable(obj.getClass());
            createTableIfNotExist(table);
            saveOrUpdateWithoutTransaction(table, obj);
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    public <T> Selector<T> selector(Class<T> cls) throws DbException {
        return Selector.from(getTable(cls));
    }

    public int update(Class<?> cls, WhereBuilder whereBuilder, KeyValue... keyValueArr) throws DbException {
        TableEntity table = getTable(cls);
        if (!table.tableIsExist()) {
            return 0;
        }
        try {
            beginTransaction();
            int executeUpdateDelete = executeUpdateDelete(SqlInfoBuilder.buildUpdateSqlInfo(table, whereBuilder, keyValueArr));
            setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            endTransaction();
        }
    }

    public void update(Object obj, String... strArr) throws DbException {
        try {
            beginTransaction();
            TableEntity table;
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    table = getTable(list.get(0).getClass());
                    if (table.tableIsExist()) {
                        for (Object buildUpdateSqlInfo : list) {
                            execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo(table, buildUpdateSqlInfo, strArr));
                        }
                    } else {
                        endTransaction();
                        return;
                    }
                }
                return;
            }
            table = getTable(obj.getClass());
            if (table.tableIsExist()) {
                execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo(table, obj, strArr));
            } else {
                endTransaction();
                return;
            }
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }
}
