package org.xutils.db.sqlite;

import android.text.TextUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xutils.db.converter.ColumnConverterFactory;
import org.xutils.db.table.ColumnUtils;

public class WhereBuilder {
    private final List<String> whereItems = new ArrayList();

    private WhereBuilder() {
    }

    private void appendCondition(String str, String str2, String str3, Object obj) {
        Object str32;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.whereItems.size() > 0) {
            stringBuilder.append(" ");
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
            stringBuilder.append(" ");
        }
        stringBuilder.append("\"");
        stringBuilder.append(str2);
        stringBuilder.append("\"");
        if ("!=".equals(str32)) {
            str32 = "<>";
        } else if ("==".equals(str32)) {
            str32 = "=";
        }
        if (obj != null) {
            stringBuilder.append(" ");
            stringBuilder.append(str32);
            stringBuilder.append(" ");
            int i = 0;
            Iterable iterable = null;
            int length;
            Object next;
            if ("IN".equalsIgnoreCase(str32)) {
                if (obj instanceof Iterable) {
                    iterable = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    length = Array.getLength(obj);
                    iterable = new ArrayList(length);
                    while (i < length) {
                        iterable.add(Array.get(obj, i));
                        i++;
                    }
                }
                if (r1 != null) {
                    StringBuilder stringBuilder2 = new StringBuilder("(");
                    for (Object str322 : r1) {
                        str322 = ColumnUtils.convert2DbValueIfNeeded(str322);
                        if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(str322.getClass()))) {
                            str322 = str322.toString();
                            if (str322.indexOf(39) != -1) {
                                str322 = str322.replace("'", "''");
                            }
                            stringBuilder2.append("'");
                            stringBuilder2.append(str322);
                            stringBuilder2.append("'");
                        } else {
                            stringBuilder2.append(str322);
                        }
                        stringBuilder2.append(",");
                    }
                    stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
                    stringBuilder2.append(")");
                    stringBuilder.append(stringBuilder2.toString());
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else if ("BETWEEN".equalsIgnoreCase(str322)) {
                if (obj instanceof Iterable) {
                    iterable = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    length = Array.getLength(obj);
                    iterable = new ArrayList(length);
                    while (i < length) {
                        iterable.add(Array.get(obj, i));
                        i++;
                    }
                }
                if (iterable != null) {
                    Iterator it = iterable.iterator();
                    if (it.hasNext()) {
                        Object next2 = it.next();
                        if (it.hasNext()) {
                            next = it.next();
                            next2 = ColumnUtils.convert2DbValueIfNeeded(next2);
                            next = ColumnUtils.convert2DbValueIfNeeded(next);
                            if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(next2.getClass()))) {
                                str2 = next2.toString();
                                if (str2.indexOf(39) != -1) {
                                    str2 = str2.replace("'", "''");
                                }
                                str = next.toString();
                                if (str.indexOf(39) != -1) {
                                    str = str.replace("'", "''");
                                }
                                stringBuilder.append("'");
                                stringBuilder.append(str2);
                                stringBuilder.append("'");
                                stringBuilder.append(" AND ");
                                stringBuilder.append("'");
                                stringBuilder.append(str);
                                stringBuilder.append("'");
                            } else {
                                stringBuilder.append(next2);
                                stringBuilder.append(" AND ");
                                stringBuilder.append(next);
                            }
                        } else {
                            throw new IllegalArgumentException("value must have tow items.");
                        }
                    }
                    throw new IllegalArgumentException("value must have tow items.");
                }
                throw new IllegalArgumentException("value must be an Array or an Iterable.");
            } else {
                next = ColumnUtils.convert2DbValueIfNeeded(obj);
                if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(next.getClass()))) {
                    str = next.toString();
                    if (str.indexOf(39) != -1) {
                        str = str.replace("'", "''");
                    }
                    stringBuilder.append("'");
                    stringBuilder.append(str);
                    stringBuilder.append("'");
                } else {
                    stringBuilder.append(next);
                }
            }
        } else if ("=".equals(str322)) {
            stringBuilder.append(" IS NULL");
        } else if ("<>".equals(str322)) {
            stringBuilder.append(" IS NOT NULL");
        } else {
            stringBuilder.append(" ");
            stringBuilder.append(str322);
            stringBuilder.append(" NULL");
        }
        this.whereItems.add(stringBuilder.toString());
    }

    public static WhereBuilder b() {
        return new WhereBuilder();
    }

    public static WhereBuilder b(String str, String str2, Object obj) {
        WhereBuilder whereBuilder = new WhereBuilder();
        whereBuilder.appendCondition(null, str, str2, obj);
        return whereBuilder;
    }

    public WhereBuilder and(String str, String str2, Object obj) {
        appendCondition(this.whereItems.size() == 0 ? null : "AND", str, str2, obj);
        return this;
    }

    public WhereBuilder and(WhereBuilder whereBuilder) {
        String str = this.whereItems.size() == 0 ? " " : "AND ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(whereBuilder.toString());
        stringBuilder.append(")");
        return expr(stringBuilder.toString());
    }

    public WhereBuilder expr(String str) {
        List list = this.whereItems;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        stringBuilder.append(str);
        list.add(stringBuilder.toString());
        return this;
    }

    public int getWhereItemSize() {
        return this.whereItems.size();
    }

    public WhereBuilder or(String str, String str2, Object obj) {
        appendCondition(this.whereItems.size() == 0 ? null : "OR", str, str2, obj);
        return this;
    }

    public WhereBuilder or(WhereBuilder whereBuilder) {
        String str = this.whereItems.size() == 0 ? " " : "OR ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(whereBuilder.toString());
        stringBuilder.append(")");
        return expr(stringBuilder.toString());
    }

    public String toString() {
        if (this.whereItems.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : this.whereItems) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }
}
