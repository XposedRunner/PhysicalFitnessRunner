package org.xutils.db.table;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.HashMap;
import org.xutils.DbManager;
import org.xutils.DbManager.TableCreateListener;
import org.xutils.common.util.IOUtil;
import org.xutils.db.sqlite.SqlInfoBuilder;
import org.xutils.ex.DbException;

public abstract class DbBase implements DbManager {
    private final HashMap<Class<?>, TableEntity<?>> tableMap = new HashMap();

    public void addColumn(Class<?> cls, String str) throws DbException {
        TableEntity table = getTable(cls);
        ColumnEntity columnEntity = (ColumnEntity) table.getColumnMap().get(str);
        if (columnEntity != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ALTER TABLE ");
            stringBuilder.append("\"");
            stringBuilder.append(table.getName());
            stringBuilder.append("\"");
            stringBuilder.append(" ADD COLUMN ");
            stringBuilder.append("\"");
            stringBuilder.append(columnEntity.getName());
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append(columnEntity.getColumnDbType());
            stringBuilder.append(" ");
            stringBuilder.append(columnEntity.getProperty());
            execNonQuery(stringBuilder.toString());
        }
    }

    /* Access modifiers changed, original: protected */
    public void createTableIfNotExist(TableEntity<?> tableEntity) throws DbException {
        if (!tableEntity.tableIsExist()) {
            synchronized (tableEntity.getClass()) {
                if (!tableEntity.tableIsExist()) {
                    execNonQuery(SqlInfoBuilder.buildCreateTableSqlInfo(tableEntity));
                    String onCreated = tableEntity.getOnCreated();
                    if (!TextUtils.isEmpty(onCreated)) {
                        execNonQuery(onCreated);
                    }
                    tableEntity.setCheckedDatabase(true);
                    TableCreateListener tableCreateListener = getDaoConfig().getTableCreateListener();
                    if (tableCreateListener != null) {
                        tableCreateListener.onTableCreated(this, tableEntity);
                    }
                }
            }
        }
    }

    public void dropDb() throws DbException {
        Cursor execQuery = execQuery("SELECT name FROM sqlite_master WHERE type='table' AND name<>'sqlite_sequence'");
        if (execQuery != null) {
            while (execQuery.moveToNext()) {
                try {
                    String string = execQuery.getString(0);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("DROP TABLE ");
                    stringBuilder.append(string);
                    execNonQuery(stringBuilder.toString());
                } catch (Throwable th) {
                    try {
                        DbException dbException = new DbException(th);
                    } catch (Throwable th2) {
                        IOUtil.closeQuietly(execQuery);
                    }
                }
            }
            synchronized (this.tableMap) {
                for (TableEntity checkedDatabase : this.tableMap.values()) {
                    checkedDatabase.setCheckedDatabase(false);
                }
                this.tableMap.clear();
            }
            IOUtil.closeQuietly(execQuery);
        }
    }

    public void dropTable(Class<?> cls) throws DbException {
        TableEntity table = getTable(cls);
        if (table.tableIsExist()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DROP TABLE \"");
            stringBuilder.append(table.getName());
            stringBuilder.append("\"");
            execNonQuery(stringBuilder.toString());
            table.setCheckedDatabase(false);
            removeTable(cls);
        }
    }

    public <T> TableEntity<T> getTable(Class<T> cls) throws DbException {
        TableEntity<T> tableEntity;
        synchronized (this.tableMap) {
            tableEntity = (TableEntity) this.tableMap.get(cls);
            if (tableEntity == null) {
                try {
                    tableEntity = new TableEntity(this, cls);
                    this.tableMap.put(cls, tableEntity);
                } catch (Throwable th) {
                    DbException dbException = new DbException(th);
                }
            }
        }
        return tableEntity;
    }

    /* Access modifiers changed, original: protected */
    public void removeTable(Class<?> cls) {
        synchronized (this.tableMap) {
            this.tableMap.remove(cls);
        }
    }
}
