package org.xutils.db.sqlite;

import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;
import org.xutils.common.util.KeyValue;
import org.xutils.db.converter.ColumnConverterFactory;
import org.xutils.db.table.ColumnUtils;

public final class SqlInfo {
    private List<KeyValue> bindArgs;
    private String sql;

    public SqlInfo(String str) {
        this.sql = str;
    }

    public void addBindArg(KeyValue keyValue) {
        if (this.bindArgs == null) {
            this.bindArgs = new ArrayList();
        }
        this.bindArgs.add(keyValue);
    }

    public void addBindArgs(List<KeyValue> list) {
        if (this.bindArgs == null) {
            this.bindArgs = list;
        } else {
            this.bindArgs.addAll(list);
        }
    }

    public SQLiteStatement buildStatement(SQLiteDatabase sQLiteDatabase) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(this.sql);
        if (this.bindArgs != null) {
            for (int i = 1; i < this.bindArgs.size() + 1; i++) {
                Object convert2DbValueIfNeeded = ColumnUtils.convert2DbValueIfNeeded(((KeyValue) this.bindArgs.get(i - 1)).value);
                if (convert2DbValueIfNeeded != null) {
                    switch (ColumnConverterFactory.getColumnConverter(convert2DbValueIfNeeded.getClass()).getColumnDbType()) {
                        case INTEGER:
                            compileStatement.bindLong(i, ((Number) convert2DbValueIfNeeded).longValue());
                            break;
                        case REAL:
                            compileStatement.bindDouble(i, ((Number) convert2DbValueIfNeeded).doubleValue());
                            break;
                        case TEXT:
                            compileStatement.bindString(i, convert2DbValueIfNeeded.toString());
                            break;
                        case BLOB:
                            compileStatement.bindBlob(i, (byte[]) convert2DbValueIfNeeded);
                            break;
                        default:
                            compileStatement.bindNull(i);
                            break;
                    }
                }
                compileStatement.bindNull(i);
            }
        }
        return compileStatement;
    }

    public Object[] getBindArgs() {
        if (this.bindArgs == null) {
            return null;
        }
        Object[] objArr = new Object[this.bindArgs.size()];
        for (int i = 0; i < this.bindArgs.size(); i++) {
            objArr[i] = ColumnUtils.convert2DbValueIfNeeded(((KeyValue) this.bindArgs.get(i)).value);
        }
        return objArr;
    }

    public String[] getBindArgsAsStrArray() {
        if (this.bindArgs == null) {
            return null;
        }
        String[] strArr = new String[this.bindArgs.size()];
        for (int i = 0; i < this.bindArgs.size(); i++) {
            Object convert2DbValueIfNeeded = ColumnUtils.convert2DbValueIfNeeded(((KeyValue) this.bindArgs.get(i)).value);
            strArr[i] = convert2DbValueIfNeeded == null ? null : convert2DbValueIfNeeded.toString();
        }
        return strArr;
    }

    public String getSql() {
        return this.sql;
    }

    public void setSql(String str) {
        this.sql = str;
    }
}
