package com.qiyukf.nimlib.c.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.qiyukf.basesdk.a.a;

public final class b {
    public static int a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr) {
        boolean z;
        int i = -1;
        int i2 = 0;
        while (i2 < 3) {
            boolean z2;
            int update;
            try {
                z2 = true;
                update = sQLiteDatabase.update(str, contentValues, str2, strArr);
                z = false;
            } catch (SQLiteException e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("exec sql exception: ");
                stringBuilder.append(e);
                a.a("db", stringBuilder.toString());
                z = a(e);
                update = i;
                z2 = false;
            } catch (Exception e2) {
                e2.printStackTrace();
                z = false;
                update = i;
                z2 = z;
            }
            if (z) {
                a.e("db", "locked");
            }
            if (z2 || !z) {
                return update;
            }
            i2++;
            i = update;
        }
        return i;
    }

    public static long a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        boolean z;
        long j = -1;
        int i = 0;
        while (i < 3) {
            boolean z2;
            long insert;
            try {
                z2 = true;
                insert = sQLiteDatabase.insert(str, null, contentValues);
                z = false;
            } catch (SQLiteException e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("exec sql exception: ");
                stringBuilder.append(e);
                a.a("db", stringBuilder.toString());
                z = a(e);
                insert = j;
                z2 = false;
            } catch (Exception e2) {
                e2.printStackTrace();
                z = false;
                insert = j;
                z2 = z;
            }
            if (z) {
                a.e("db", "locked");
            }
            if (z2 || !z) {
                return insert;
            }
            i++;
            j = insert;
        }
        return j;
    }

    public static final Cursor a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        for (int i = 0; i < 3; i++) {
            boolean a;
            try {
                cursor = sQLiteDatabase.rawQuery(str, null);
            } catch (SQLiteException e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("exec sql exception: ");
                stringBuilder.append(e);
                a.a("db", stringBuilder.toString());
                a = a(e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a = false;
            if (a) {
                a.e("db", "locked");
            }
            if (cursor != null || !a) {
                break;
            }
        }
        return d.a(cursor);
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("'", "''");
    }

    public static final boolean a(SQLiteException sQLiteException) {
        String message = sQLiteException.getMessage();
        return !TextUtils.isEmpty(message) && message.contains("lock");
    }

    public static long b(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        boolean z;
        long j = -1;
        int i = 0;
        while (i < 3) {
            boolean z2;
            long replace;
            try {
                z2 = true;
                replace = sQLiteDatabase.replace(str, null, contentValues);
                z = false;
            } catch (SQLiteException e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("exec sql exception: ");
                stringBuilder.append(e);
                a.a("db", stringBuilder.toString());
                z = a(e);
                replace = j;
                z2 = false;
            } catch (Exception e2) {
                e2.printStackTrace();
                z = false;
                replace = j;
                z2 = z;
            }
            if (z) {
                a.e("db", "locked");
            }
            if (z2 || !z) {
                return replace;
            }
            i++;
            j = replace;
        }
        return j;
    }
}
