package org.xutils.db.table;

import android.database.Cursor;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import org.xutils.DbManager;
import org.xutils.common.util.IOUtil;
import org.xutils.db.annotation.Table;
import org.xutils.ex.DbException;

public final class TableEntity<T> {
    private volatile boolean checkedDatabase;
    private final LinkedHashMap<String, ColumnEntity> columnMap;
    private Constructor<T> constructor;
    private final DbManager db;
    private Class<T> entityType;
    private ColumnEntity id;
    private final String name;
    private final String onCreated;

    TableEntity(DbManager dbManager, Class<T> cls) throws Throwable {
        this.db = dbManager;
        this.entityType = cls;
        this.constructor = cls.getConstructor(new Class[0]);
        this.constructor.setAccessible(true);
        Table table = (Table) cls.getAnnotation(Table.class);
        this.name = table.name();
        this.onCreated = table.onCreated();
        this.columnMap = TableUtils.findColumnMap(cls);
        for (ColumnEntity columnEntity : this.columnMap.values()) {
            if (columnEntity.isId()) {
                this.id = columnEntity;
                return;
            }
        }
    }

    public T createEntity() throws Throwable {
        return this.constructor.newInstance(new Object[0]);
    }

    public LinkedHashMap<String, ColumnEntity> getColumnMap() {
        return this.columnMap;
    }

    public DbManager getDb() {
        return this.db;
    }

    public Class<T> getEntityType() {
        return this.entityType;
    }

    public ColumnEntity getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOnCreated() {
        return this.onCreated;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isCheckedDatabase() {
        return this.checkedDatabase;
    }

    /* Access modifiers changed, original: 0000 */
    public void setCheckedDatabase(boolean z) {
        this.checkedDatabase = z;
    }

    public boolean tableIsExist() throws DbException {
        if (isCheckedDatabase()) {
            return true;
        }
        DbManager dbManager = this.db;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) AS c FROM sqlite_master WHERE type='table' AND name='");
        stringBuilder.append(this.name);
        stringBuilder.append("'");
        Cursor execQuery = dbManager.execQuery(stringBuilder.toString());
        if (execQuery != null) {
            try {
                if (!execQuery.moveToNext() || execQuery.getInt(0) <= 0) {
                    IOUtil.closeQuietly(execQuery);
                } else {
                    setCheckedDatabase(true);
                    IOUtil.closeQuietly(execQuery);
                    return true;
                }
            } catch (Throwable th) {
                IOUtil.closeQuietly(execQuery);
            }
        }
        return false;
    }

    public String toString() {
        return this.name;
    }
}
