package org.xutils.db.sqlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.xutils.common.util.KeyValue;
import org.xutils.db.table.ColumnEntity;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;

public final class SqlInfoBuilder {
    private static final ConcurrentHashMap<TableEntity<?>, String> INSERT_SQL_CACHE = new ConcurrentHashMap();
    private static final ConcurrentHashMap<TableEntity<?>, String> REPLACE_SQL_CACHE = new ConcurrentHashMap();

    private SqlInfoBuilder() {
    }

    public static SqlInfo buildCreateTableSqlInfo(TableEntity<?> tableEntity) throws DbException {
        ColumnEntity id = tableEntity.getId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS ");
        stringBuilder.append("\"");
        stringBuilder.append(tableEntity.getName());
        stringBuilder.append("\"");
        stringBuilder.append(" ( ");
        if (id.isAutoId()) {
            stringBuilder.append("\"");
            stringBuilder.append(id.getName());
            stringBuilder.append("\"");
            stringBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        } else {
            stringBuilder.append("\"");
            stringBuilder.append(id.getName());
            stringBuilder.append("\"");
            stringBuilder.append(id.getColumnDbType());
            stringBuilder.append(" PRIMARY KEY, ");
        }
        for (ColumnEntity id2 : tableEntity.getColumnMap().values()) {
            if (!id2.isId()) {
                stringBuilder.append("\"");
                stringBuilder.append(id2.getName());
                stringBuilder.append("\"");
                stringBuilder.append(' ');
                stringBuilder.append(id2.getColumnDbType());
                stringBuilder.append(' ');
                stringBuilder.append(id2.getProperty());
                stringBuilder.append(',');
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(" )");
        return new SqlInfo(stringBuilder.toString());
    }

    public static SqlInfo buildDeleteSqlInfo(TableEntity<?> tableEntity, Object obj) throws DbException {
        SqlInfo sqlInfo = new SqlInfo();
        ColumnEntity id = tableEntity.getId();
        obj = id.getColumnValue(obj);
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("this entity[");
            stringBuilder.append(tableEntity.getEntityType());
            stringBuilder.append("]'s id value is null");
            throw new DbException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder("DELETE FROM ");
        stringBuilder2.append("\"");
        stringBuilder2.append(tableEntity.getName());
        stringBuilder2.append("\"");
        stringBuilder2.append(" WHERE ");
        stringBuilder2.append(WhereBuilder.b(id.getName(), "=", obj));
        sqlInfo.setSql(stringBuilder2.toString());
        return sqlInfo;
    }

    public static SqlInfo buildDeleteSqlInfo(TableEntity<?> tableEntity, WhereBuilder whereBuilder) throws DbException {
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM ");
        stringBuilder.append("\"");
        stringBuilder.append(tableEntity.getName());
        stringBuilder.append("\"");
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(whereBuilder.toString());
        }
        return new SqlInfo(stringBuilder.toString());
    }

    public static SqlInfo buildDeleteSqlInfoById(TableEntity<?> tableEntity, Object obj) throws DbException {
        SqlInfo sqlInfo = new SqlInfo();
        ColumnEntity id = tableEntity.getId();
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("this entity[");
            stringBuilder.append(tableEntity.getEntityType());
            stringBuilder.append("]'s id value is null");
            throw new DbException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder("DELETE FROM ");
        stringBuilder2.append("\"");
        stringBuilder2.append(tableEntity.getName());
        stringBuilder2.append("\"");
        stringBuilder2.append(" WHERE ");
        stringBuilder2.append(WhereBuilder.b(id.getName(), "=", obj));
        sqlInfo.setSql(stringBuilder2.toString());
        return sqlInfo;
    }

    public static SqlInfo buildInsertSqlInfo(TableEntity<?> tableEntity, Object obj) throws DbException {
        List<KeyValue> entity2KeyValueList = entity2KeyValueList(tableEntity, obj);
        if (entity2KeyValueList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        String str = (String) INSERT_SQL_CACHE.get(tableEntity);
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO ");
            stringBuilder.append("\"");
            stringBuilder.append(tableEntity.getName());
            stringBuilder.append("\"");
            stringBuilder.append(" (");
            for (KeyValue keyValue : entity2KeyValueList) {
                stringBuilder.append("\"");
                stringBuilder.append(keyValue.key);
                stringBuilder.append("\"");
                stringBuilder.append(',');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(") VALUES (");
            int size = entity2KeyValueList.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append("?,");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(")");
            str = stringBuilder.toString();
            sqlInfo.setSql(str);
            sqlInfo.addBindArgs(entity2KeyValueList);
            INSERT_SQL_CACHE.put(tableEntity, str);
        } else {
            sqlInfo.setSql(str);
            sqlInfo.addBindArgs(entity2KeyValueList);
        }
        return sqlInfo;
    }

    public static SqlInfo buildReplaceSqlInfo(TableEntity<?> tableEntity, Object obj) throws DbException {
        List<KeyValue> entity2KeyValueList = entity2KeyValueList(tableEntity, obj);
        if (entity2KeyValueList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        String str = (String) REPLACE_SQL_CACHE.get(tableEntity);
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("REPLACE INTO ");
            stringBuilder.append("\"");
            stringBuilder.append(tableEntity.getName());
            stringBuilder.append("\"");
            stringBuilder.append(" (");
            for (KeyValue keyValue : entity2KeyValueList) {
                stringBuilder.append("\"");
                stringBuilder.append(keyValue.key);
                stringBuilder.append("\"");
                stringBuilder.append(',');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(") VALUES (");
            int size = entity2KeyValueList.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append("?,");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(")");
            str = stringBuilder.toString();
            sqlInfo.setSql(str);
            sqlInfo.addBindArgs(entity2KeyValueList);
            REPLACE_SQL_CACHE.put(tableEntity, str);
        } else {
            sqlInfo.setSql(str);
            sqlInfo.addBindArgs(entity2KeyValueList);
        }
        return sqlInfo;
    }

    public static SqlInfo buildUpdateSqlInfo(TableEntity<?> tableEntity, Object obj, String... strArr) throws DbException {
        List<KeyValue> entity2KeyValueList = entity2KeyValueList(tableEntity, obj);
        HashSet hashSet = null;
        if (entity2KeyValueList.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        ColumnEntity id = tableEntity.getId();
        obj = id.getColumnValue(obj);
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("this entity[");
            stringBuilder.append(tableEntity.getEntityType());
            stringBuilder.append("]'s id value is null");
            throw new DbException(stringBuilder.toString());
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuilder stringBuilder2 = new StringBuilder("UPDATE ");
        stringBuilder2.append("\"");
        stringBuilder2.append(tableEntity.getName());
        stringBuilder2.append("\"");
        stringBuilder2.append(" SET ");
        for (KeyValue keyValue : entity2KeyValueList) {
            if (hashSet == null || hashSet.contains(keyValue.key)) {
                stringBuilder2.append("\"");
                stringBuilder2.append(keyValue.key);
                stringBuilder2.append("\"");
                stringBuilder2.append("=?,");
                sqlInfo.addBindArg(keyValue);
            }
        }
        stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
        stringBuilder2.append(" WHERE ");
        stringBuilder2.append(WhereBuilder.b(id.getName(), "=", obj));
        sqlInfo.setSql(stringBuilder2.toString());
        return sqlInfo;
    }

    public static SqlInfo buildUpdateSqlInfo(TableEntity<?> tableEntity, WhereBuilder whereBuilder, KeyValue... keyValueArr) throws DbException {
        if (keyValueArr == null || keyValueArr.length == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuilder stringBuilder = new StringBuilder("UPDATE ");
        stringBuilder.append("\"");
        stringBuilder.append(tableEntity.getName());
        stringBuilder.append("\"");
        stringBuilder.append(" SET ");
        for (KeyValue keyValue : keyValueArr) {
            stringBuilder.append("\"");
            stringBuilder.append(keyValue.key);
            stringBuilder.append("\"");
            stringBuilder.append("=?,");
            sqlInfo.addBindArg(keyValue);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(whereBuilder.toString());
        }
        sqlInfo.setSql(stringBuilder.toString());
        return sqlInfo;
    }

    private static KeyValue column2KeyValue(Object obj, ColumnEntity columnEntity) {
        return columnEntity.isAutoId() ? null : new KeyValue(columnEntity.getName(), columnEntity.getFieldValue(obj));
    }

    public static List<KeyValue> entity2KeyValueList(TableEntity<?> tableEntity, Object obj) {
        Collection<ColumnEntity> values = tableEntity.getColumnMap().values();
        ArrayList arrayList = new ArrayList(values.size());
        for (ColumnEntity column2KeyValue : values) {
            KeyValue column2KeyValue2 = column2KeyValue(obj, column2KeyValue);
            if (column2KeyValue2 != null) {
                arrayList.add(column2KeyValue2);
            }
        }
        return arrayList;
    }
}
