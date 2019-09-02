package com.qiyukf.unicorn.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.unicorn.d;
import java.io.File;

public final class b extends SQLiteOpenHelper {

    interface a {
        String[] a();

        String[] b();
    }

    public b(Context context) {
        String str = "unicorn.db";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getApplicationInfo().dataDir);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(d.d());
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(stringBuilder2);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(str);
        this(context, stringBuilder3.toString());
    }

    private b(Context context, String str) {
        super(context, str, null, 1);
    }

    private static void a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        for (String execSQL : strArr) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    private a[] a() {
        return new a[]{new a() {
            public final String[] a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS staffInfo(staffNimId Varchar(32) NOT NULL, staffName Varchar(256), staffAvatar Varchar(256))", "CREATE UNIQUE INDEX IF NOT EXISTS staffInfo_staffNimId_index ON staffInfo(staffNimId)"};
            }

            public final String[] b() {
                return new String[0];
            }
        }, new a() {
            public final String[] a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS shopInfo(shopId Varchar(32) NOT NULL, shopName Varchar(256), shopAvatar Varchar(256))", "CREATE UNIQUE INDEX IF NOT EXISTS shopInfo_shopId_index ON shopInfo(shopId)"};
            }

            public final String[] b() {
                return new String[0];
            }
        }};
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a[] a = a();
        for (int i = 0; i < 2; i++) {
            a(sQLiteDatabase, a[i].a());
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            a[] a = a();
            for (int i3 = 0; i3 < 2; i3++) {
                a(sQLiteDatabase, a[i3].b());
            }
            i++;
        }
    }
}
