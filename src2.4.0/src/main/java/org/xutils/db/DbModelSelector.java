package org.xutils.db;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.IOUtil;
import org.xutils.db.Selector.OrderBy;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.db.table.DbModel;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;

public final class DbModelSelector {
    private String[] columnExpressions;
    private String groupByColumnName;
    private WhereBuilder having;
    private Selector<?> selector;

    protected DbModelSelector(Selector<?> selector, String str) {
        this.selector = selector;
        this.groupByColumnName = str;
    }

    protected DbModelSelector(Selector<?> selector, String[] strArr) {
        this.selector = selector;
        this.columnExpressions = strArr;
    }

    private DbModelSelector(TableEntity<?> tableEntity) {
        this.selector = Selector.from(tableEntity);
    }

    static DbModelSelector from(TableEntity<?> tableEntity) {
        return new DbModelSelector(tableEntity);
    }

    public DbModelSelector and(String str, String str2, Object obj) {
        this.selector.and(str, str2, obj);
        return this;
    }

    public DbModelSelector and(WhereBuilder whereBuilder) {
        this.selector.and(whereBuilder);
        return this;
    }

    public DbModelSelector expr(String str) {
        this.selector.expr(str);
        return this;
    }

    public List<DbModel> findAll() throws DbException {
        TableEntity table = this.selector.getTable();
        List<DbModel> list = null;
        if (!table.tableIsExist()) {
            return null;
        }
        Cursor execQuery = table.getDb().execQuery(toString());
        if (execQuery != null) {
            try {
                list = new ArrayList();
                while (execQuery.moveToNext()) {
                    list.add(CursorUtils.getDbModel(execQuery));
                }
                IOUtil.closeQuietly(execQuery);
            } catch (Throwable th) {
                IOUtil.closeQuietly(execQuery);
            }
        }
        return list;
    }

    public DbModel findFirst() throws DbException {
        TableEntity table = this.selector.getTable();
        if (!table.tableIsExist()) {
            return null;
        }
        limit(1);
        Cursor execQuery = table.getDb().execQuery(toString());
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

    public TableEntity<?> getTable() {
        return this.selector.getTable();
    }

    public DbModelSelector groupBy(String str) {
        this.groupByColumnName = str;
        return this;
    }

    public DbModelSelector having(WhereBuilder whereBuilder) {
        this.having = whereBuilder;
        return this;
    }

    public DbModelSelector limit(int i) {
        this.selector.limit(i);
        return this;
    }

    public DbModelSelector offset(int i) {
        this.selector.offset(i);
        return this;
    }

    public DbModelSelector or(String str, String str2, Object obj) {
        this.selector.or(str, str2, obj);
        return this;
    }

    public DbModelSelector or(WhereBuilder whereBuilder) {
        this.selector.or(whereBuilder);
        return this;
    }

    public DbModelSelector orderBy(String str) {
        this.selector.orderBy(str);
        return this;
    }

    public DbModelSelector orderBy(String str, boolean z) {
        this.selector.orderBy(str, z);
        return this;
    }

    public DbModelSelector select(String... strArr) {
        this.columnExpressions = strArr;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        int i = 0;
        if (this.columnExpressions != null && this.columnExpressions.length > 0) {
            for (String append : this.columnExpressions) {
                stringBuilder.append(append);
                stringBuilder.append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else if (TextUtils.isEmpty(this.groupByColumnName)) {
            stringBuilder.append("*");
        } else {
            stringBuilder.append(this.groupByColumnName);
        }
        stringBuilder.append(" FROM ");
        stringBuilder.append("\"");
        stringBuilder.append(this.selector.getTable().getName());
        stringBuilder.append("\"");
        WhereBuilder whereBuilder = this.selector.getWhereBuilder();
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(whereBuilder.toString());
        }
        if (!TextUtils.isEmpty(this.groupByColumnName)) {
            stringBuilder.append(" GROUP BY ");
            stringBuilder.append("\"");
            stringBuilder.append(this.groupByColumnName);
            stringBuilder.append("\"");
            if (this.having != null && this.having.getWhereItemSize() > 0) {
                stringBuilder.append(" HAVING ");
                stringBuilder.append(this.having.toString());
            }
        }
        List orderByList = this.selector.getOrderByList();
        if (orderByList != null && orderByList.size() > 0) {
            while (i < orderByList.size()) {
                stringBuilder.append(" ORDER BY ");
                stringBuilder.append(((OrderBy) orderByList.get(i)).toString());
                stringBuilder.append(',');
                i++;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (this.selector.getLimit() > 0) {
            stringBuilder.append(" LIMIT ");
            stringBuilder.append(this.selector.getLimit());
            stringBuilder.append(" OFFSET ");
            stringBuilder.append(this.selector.getOffset());
        }
        return stringBuilder.toString();
    }

    public DbModelSelector where(String str, String str2, Object obj) {
        this.selector.where(str, str2, obj);
        return this;
    }

    public DbModelSelector where(WhereBuilder whereBuilder) {
        this.selector.where(whereBuilder);
        return this;
    }
}
