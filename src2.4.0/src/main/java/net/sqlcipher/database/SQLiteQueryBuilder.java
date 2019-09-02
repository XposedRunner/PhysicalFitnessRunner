package net.sqlcipher.database;

import android.text.TextUtils;
import android.util.Log;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase.CursorFactory;

public class SQLiteQueryBuilder {
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mDistinct = false;
    private CursorFactory mFactory = null;
    private Map<String, String> mProjectionMap = null;
    private boolean mStrictProjectionMap;
    private String mTables = "";
    private StringBuilder mWhereClause = null;

    private static void appendClause(StringBuilder stringBuilder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str);
            stringBuilder.append(str2);
        }
    }

    private static void appendClauseEscapeClause(StringBuilder stringBuilder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str);
            DatabaseUtils.appendEscapedSQLString(stringBuilder, str2);
        }
    }

    public static void appendColumns(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str != null) {
                if (i > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(str);
            }
        }
        stringBuilder.append(' ');
    }

    public static String buildQueryString(boolean z, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        } else if (TextUtils.isEmpty(str6) || sLimitPattern.matcher(str6).matches()) {
            StringBuilder stringBuilder = new StringBuilder(XmPlayerService.CODE_GET_SUBJECTDETAIL);
            stringBuilder.append("SELECT ");
            if (z) {
                stringBuilder.append("DISTINCT ");
            }
            if (strArr == null || strArr.length == 0) {
                stringBuilder.append("* ");
            } else {
                appendColumns(stringBuilder, strArr);
            }
            stringBuilder.append("FROM ");
            stringBuilder.append(str);
            appendClause(stringBuilder, " WHERE ", str2);
            appendClause(stringBuilder, " GROUP BY ", str3);
            appendClause(stringBuilder, " HAVING ", str4);
            appendClause(stringBuilder, " ORDER BY ", str5);
            appendClause(stringBuilder, " LIMIT ", str6);
            return stringBuilder.toString();
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("invalid LIMIT clauses:");
            stringBuilder2.append(str6);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    private String[] computeProjection(String[] strArr) {
        int i = 0;
        String[] strArr2;
        if (strArr == null || strArr.length <= 0) {
            if (this.mProjectionMap == null) {
                return null;
            }
            Set<Entry> entrySet = this.mProjectionMap.entrySet();
            strArr2 = new String[entrySet.size()];
            for (Entry entry : entrySet) {
                if (!((String) entry.getKey()).equals("_count")) {
                    int i2 = i + 1;
                    strArr2[i] = (String) entry.getValue();
                    i = i2;
                }
            }
            return strArr2;
        } else if (this.mProjectionMap == null) {
            return strArr;
        } else {
            strArr2 = new String[strArr.length];
            int length = strArr.length;
            while (i < length) {
                Object obj = strArr[i];
                String str = (String) this.mProjectionMap.get(obj);
                if (str != null) {
                    strArr2[i] = str;
                } else if (this.mStrictProjectionMap || !(obj.contains(" AS ") || obj.contains(" as "))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid column ");
                    stringBuilder.append(strArr[i]);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else {
                    strArr2[i] = obj;
                }
                i++;
            }
            return strArr2;
        }
    }

    public void appendWhere(CharSequence charSequence) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        this.mWhereClause.append(charSequence);
    }

    public void appendWhereEscapeString(String str) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
    }

    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        String[] computeProjection = computeProjection(strArr);
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = (this.mWhereClause == null || this.mWhereClause.length() <= 0) ? null : 1;
        if (obj != null) {
            stringBuilder.append(this.mWhereClause.toString());
            stringBuilder.append(')');
        }
        if (str != null && str.length() > 0) {
            if (obj != null) {
                stringBuilder.append(" AND ");
            }
            stringBuilder.append('(');
            stringBuilder.append(str);
            stringBuilder.append(')');
        }
        return buildQueryString(this.mDistinct, this.mTables, computeProjection, stringBuilder.toString(), str2, str3, str4, str5);
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(128);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                stringBuilder.append(str3);
            }
            stringBuilder.append(strArr[i]);
        }
        appendClause(stringBuilder, " ORDER BY ", str);
        appendClause(stringBuilder, " LIMIT ", str2);
        return stringBuilder.toString();
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i, String str2, String str3, String[] strArr2, String str4, String str5) {
        String str6 = str;
        String[] strArr3 = strArr;
        int length = strArr3.length;
        String[] strArr4 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str7 = strArr3[i2];
            Set<String> set2;
            if (str7.equals(str6)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("'");
                stringBuilder.append(str2);
                stringBuilder.append("' AS ");
                stringBuilder.append(str6);
                strArr4[i2] = stringBuilder.toString();
                set2 = set;
                int i3 = i;
            } else {
                String str8 = str2;
                if (i2 <= i) {
                    set2 = set;
                } else if (!set.contains(str7)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("NULL AS ");
                    stringBuilder2.append(str7);
                    strArr4[i2] = stringBuilder2.toString();
                }
                strArr4[i2] = str7;
            }
        }
        return buildQuery(strArr4, str3, strArr2, str4, str5, null, null);
    }

    public String getTables() {
        return this.mTables;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        if (this.mTables == null) {
            return null;
        }
        String buildQuery = buildQuery(strArr, str, strArr2, str2, str3, str4, str5);
        if (Log.isLoggable(TAG, 3)) {
            String str6 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Performing query: ");
            stringBuilder.append(buildQuery);
            Log.d(str6, stringBuilder.toString());
        }
        return sQLiteDatabase.rawQueryWithFactory(this.mFactory, buildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables));
    }

    public void setCursorFactory(CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setDistinct(boolean z) {
        this.mDistinct = z;
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setStrictProjectionMap(boolean z) {
        this.mStrictProjectionMap = z;
    }

    public void setTables(String str) {
        this.mTables = str;
    }
}
