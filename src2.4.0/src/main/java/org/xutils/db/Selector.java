package org.xutils.db;

import android.database.Cursor;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.IOUtil;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.db.table.DbModel;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;

public final class Selector<T> {
    private int limit = 0;
    private int offset = 0;
    private List<OrderBy> orderByList;
    private final TableEntity<T> table;
    private WhereBuilder whereBuilder;

    public static class OrderBy {
        private String columnName;
        private boolean desc;

        public OrderBy(String str) {
            this.columnName = str;
        }

        public OrderBy(String str, boolean z) {
            this.columnName = str;
            this.desc = z;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\"");
            stringBuilder.append(this.columnName);
            stringBuilder.append("\"");
            stringBuilder.append(this.desc ? " DESC" : " ASC");
            return stringBuilder.toString();
        }
    }

    private Selector(TableEntity<T> tableEntity) {
        this.table = tableEntity;
    }

    static <T> Selector<T> from(TableEntity<T> tableEntity) {
        return new Selector(tableEntity);
    }

    public Selector<T> and(String str, String str2, Object obj) {
        this.whereBuilder.and(str, str2, obj);
        return this;
    }

    public Selector<T> and(WhereBuilder whereBuilder) {
        this.whereBuilder.and(whereBuilder);
        return this;
    }

    public long count() throws DbException {
        if (!this.table.tableIsExist()) {
            return 0;
        }
        String[] strArr = new String[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count(\"");
        stringBuilder.append(this.table.getId().getName());
        stringBuilder.append("\") as count");
        strArr[0] = stringBuilder.toString();
        DbModel findFirst = select(strArr).findFirst();
        return findFirst != null ? findFirst.getLong(DTransferConstants.PAGE_SIZE) : 0;
    }

    public Selector<T> expr(String str) {
        if (this.whereBuilder == null) {
            this.whereBuilder = WhereBuilder.b();
        }
        this.whereBuilder.expr(str);
        return this;
    }

    public List<T> findAll() throws DbException {
        List<T> list = null;
        if (!this.table.tableIsExist()) {
            return null;
        }
        Cursor execQuery = this.table.getDb().execQuery(toString());
        if (execQuery != null) {
            try {
                list = new ArrayList();
                while (execQuery.moveToNext()) {
                    list.add(CursorUtils.getEntity(this.table, execQuery));
                }
                IOUtil.closeQuietly(execQuery);
            } catch (Throwable th) {
                IOUtil.closeQuietly(execQuery);
            }
        }
        return list;
    }

    public T findFirst() throws DbException {
        if (!this.table.tableIsExist()) {
            return null;
        }
        limit(1);
        Cursor execQuery = this.table.getDb().execQuery(toString());
        if (execQuery != null) {
            try {
                if (execQuery.moveToNext()) {
                    Object entity = CursorUtils.getEntity(this.table, execQuery);
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

    public int getLimit() {
        return this.limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public List<OrderBy> getOrderByList() {
        return this.orderByList;
    }

    public TableEntity<T> getTable() {
        return this.table;
    }

    public WhereBuilder getWhereBuilder() {
        return this.whereBuilder;
    }

    public DbModelSelector groupBy(String str) {
        return new DbModelSelector(this, str);
    }

    public Selector<T> limit(int i) {
        this.limit = i;
        return this;
    }

    public Selector<T> offset(int i) {
        this.offset = i;
        return this;
    }

    public Selector<T> or(String str, String str2, Object obj) {
        this.whereBuilder.or(str, str2, obj);
        return this;
    }

    public Selector or(WhereBuilder whereBuilder) {
        this.whereBuilder.or(whereBuilder);
        return this;
    }

    public Selector<T> orderBy(String str) {
        if (this.orderByList == null) {
            this.orderByList = new ArrayList(5);
        }
        this.orderByList.add(new OrderBy(str));
        return this;
    }

    public Selector<T> orderBy(String str, boolean z) {
        if (this.orderByList == null) {
            this.orderByList = new ArrayList(5);
        }
        this.orderByList.add(new OrderBy(str, z));
        return this;
    }

    public DbModelSelector select(String... strArr) {
        return new DbModelSelector(this, strArr);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        stringBuilder.append("*");
        stringBuilder.append(" FROM ");
        stringBuilder.append("\"");
        stringBuilder.append(this.table.getName());
        stringBuilder.append("\"");
        if (this.whereBuilder != null && this.whereBuilder.getWhereItemSize() > 0) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(this.whereBuilder.toString());
        }
        if (this.orderByList != null && this.orderByList.size() > 0) {
            stringBuilder.append(" ORDER BY ");
            for (OrderBy orderBy : this.orderByList) {
                stringBuilder.append(orderBy.toString());
                stringBuilder.append(',');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (this.limit > 0) {
            stringBuilder.append(" LIMIT ");
            stringBuilder.append(this.limit);
            stringBuilder.append(" OFFSET ");
            stringBuilder.append(this.offset);
        }
        return stringBuilder.toString();
    }

    public Selector<T> where(String str, String str2, Object obj) {
        this.whereBuilder = WhereBuilder.b(str, str2, obj);
        return this;
    }

    public Selector<T> where(WhereBuilder whereBuilder) {
        this.whereBuilder = whereBuilder;
        return this;
    }
}
