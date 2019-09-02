package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: UMDBUtils */
/* renamed from: al */
public class al {
    public static String O000000o(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> O000000o(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    public static void O000000o(Context context) {
        if (context != null) {
            try {
                File databasePath = context.getDatabasePath(ai.O00000Oo);
                if (databasePath != null && databasePath.exists()) {
                    databasePath.delete();
                }
                aj.O000000o(context).O000000o();
            } catch (Throwable unused) {
            }
        }
    }

    public static void O000000o(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("alter table ");
        stringBuilder.append(str);
        stringBuilder.append(" add ");
        stringBuilder.append(str2);
        stringBuilder.append(" ");
        stringBuilder.append(str3);
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public static boolean O000000o(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Throwable th;
        Cursor cursor = null;
        boolean z = false;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT * FROM ");
            stringBuilder.append(str);
            stringBuilder.append(" LIMIT 0");
            Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getColumnIndex(str2) != -1) {
                        z = true;
                    }
                } catch (Exception unused) {
                    cursor = rawQuery;
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (!(rawQuery == null || rawQuery.isClosed())) {
                rawQuery.close();
            }
        } catch (Exception unused2) {
            cursor.close();
            return z;
        } catch (Throwable th3) {
            th = th3;
            cursor.close();
            throw th;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    public static boolean O000000o(java.lang.String r4, android.database.sqlite.SQLiteDatabase r5) {
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r2.<init>();	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r3 = "select count(*) as c from sqlite_master where type ='table' and name ='";
        r2.append(r3);	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r4 = r4.trim();	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r2.append(r4);	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r4 = "' ";
        r2.append(r4);	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r4 = r2.toString();	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r4 = r5.rawQuery(r4, r1);	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r5 = r4.moveToNext();	 Catch:{ Exception -> 0x003a, all -> 0x0037 }
        if (r5 == 0) goto L_0x0031;
    L_0x0029:
        r5 = r4.getInt(r0);	 Catch:{ Exception -> 0x003a, all -> 0x0037 }
        if (r5 <= 0) goto L_0x0031;
    L_0x002f:
        r5 = 1;
        r0 = r5;
    L_0x0031:
        if (r4 == 0) goto L_0x0048;
    L_0x0033:
        r4.close();
        goto L_0x0048;
    L_0x0037:
        r5 = move-exception;
        r1 = r4;
        goto L_0x003d;
    L_0x003a:
        r1 = r4;
        goto L_0x0043;
    L_0x003c:
        r5 = move-exception;
    L_0x003d:
        if (r1 == 0) goto L_0x0042;
    L_0x003f:
        r1.close();
    L_0x0042:
        throw r5;
    L_0x0043:
        if (r1 == 0) goto L_0x0048;
    L_0x0045:
        r1.close();
    L_0x0048:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.al.O000000o(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static String O00000Oo(Context context) {
        File databasePath = context.getDatabasePath(ai.O00000Oo);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(databasePath.getParent());
        stringBuilder.append(File.separator);
        return stringBuilder.toString();
    }

    public static List<String> O00000Oo(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String O00000o0(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(al.O00000Oo(context));
        stringBuilder.append("subprocess/");
        return stringBuilder.toString();
    }
}
