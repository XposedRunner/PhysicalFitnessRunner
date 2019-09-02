package com.qiyukf.unicorn.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.qiyukf.unicorn.e.h;
import com.qiyukf.unicorn.e.l;
import java.util.Locale;

public final class a {
    private static b a;

    private static SQLiteDatabase a() {
        if (a == null) {
            com.qiyukf.basesdk.a.a.c("UnicornDB", "database is not initialized");
            return null;
        }
        try {
            return a.getWritableDatabase();
        } catch (SQLiteException e) {
            StringBuilder stringBuilder = new StringBuilder("getWritableDatabase error");
            stringBuilder.append(e);
            com.qiyukf.basesdk.a.a.a("UnicornDB", stringBuilder.toString());
            return null;
        }
    }

    public static l a(String str) {
        SQLiteDatabase a = a();
        l lVar = null;
        if (a == null) {
            return null;
        }
        Cursor rawQuery = a.rawQuery(String.format(Locale.getDefault(), "SELECT %1$s FROM staffInfo WHERE staffNimId='%2$s'", new Object[]{"staffNimId,staffName,staffAvatar", str}), null);
        if (rawQuery != null && rawQuery.moveToNext()) {
            try {
                lVar = new l(str, rawQuery.getString(1), rawQuery.getString(2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!(rawQuery == null || rawQuery.isClosed())) {
            rawQuery.close();
        }
        return lVar;
    }

    public static void a(Context context) {
        a = new b(context);
    }

    public static void a(h hVar) {
        SQLiteDatabase a = a();
        if (a != null) {
            ContentValues contentValues = new ContentValues(3);
            contentValues.put("shopId", hVar.getAccount());
            contentValues.put("shopName", hVar.getName());
            contentValues.put("shopAvatar", hVar.getAvatar());
            if (b(hVar.getAccount()) == null) {
                a.insert("shopInfo", null, contentValues);
            } else {
                a.replace("shopInfo", null, contentValues);
            }
        }
    }

    public static void a(l lVar) {
        SQLiteDatabase a = a();
        if (a != null) {
            ContentValues contentValues = new ContentValues(3);
            contentValues.put("staffNimId", lVar.getAccount());
            contentValues.put("staffName", lVar.getName());
            contentValues.put("staffAvatar", lVar.getAvatar());
            if (a(lVar.getAccount()) == null) {
                a.insert("staffInfo", null, contentValues);
            } else {
                a.replace("staffInfo", null, contentValues);
            }
        }
    }

    public static h b(String str) {
        SQLiteDatabase a = a();
        h hVar = null;
        if (a == null) {
            return null;
        }
        Cursor rawQuery = a.rawQuery(String.format(Locale.getDefault(), "SELECT %1$s FROM shopInfo WHERE shopId='%2$s'", new Object[]{"shopId,shopName,shopAvatar", str}), null);
        if (rawQuery != null && rawQuery.moveToNext()) {
            try {
                hVar = new h(str, rawQuery.getString(1), rawQuery.getString(2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!(rawQuery == null || rawQuery.isClosed())) {
            rawQuery.close();
        }
        return hVar;
    }
}
