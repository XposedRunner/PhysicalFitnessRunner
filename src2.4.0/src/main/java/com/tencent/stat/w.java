package com.tencent.stat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.k;

class w extends SQLiteOpenHelper {
    public w(Context context) {
        super(context, k.v(context), null, 3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    private void a(android.database.sqlite.SQLiteDatabase r10) {
        /*
        r9 = this;
        r0 = 0;
        r2 = "user";
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r1 = r10;
        r1 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x004e }
        r2 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r2.<init>();	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r3 = r1.moveToNext();	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r4 = 1;
        r5 = 0;
        if (r3 == 0) goto L_0x0033;
    L_0x001b:
        r0 = r1.getString(r5);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r1.getInt(r4);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r3 = 2;
        r1.getString(r3);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r3 = 3;
        r1.getLong(r3);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r3 = com.tencent.stat.common.k.c(r0);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r6 = "uid";
        r2.put(r6, r3);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
    L_0x0033:
        if (r0 == 0) goto L_0x0040;
    L_0x0035:
        r3 = "user";
        r6 = "uid=?";
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r4[r5] = r0;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r10.update(r3, r2, r6, r4);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
    L_0x0040:
        if (r1 == 0) goto L_0x005b;
    L_0x0042:
        r1.close();
        return;
    L_0x0046:
        r10 = move-exception;
        goto L_0x005c;
    L_0x0048:
        r10 = move-exception;
        r0 = r1;
        goto L_0x004f;
    L_0x004b:
        r10 = move-exception;
        r1 = r0;
        goto L_0x005c;
    L_0x004e:
        r10 = move-exception;
    L_0x004f:
        r1 = com.tencent.stat.n.e;	 Catch:{ all -> 0x004b }
        r1.e(r10);	 Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x005b;
    L_0x0058:
        r0.close();
    L_0x005b:
        return;
    L_0x005c:
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r1.close();
    L_0x0061:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.w.a(android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    private void b(android.database.sqlite.SQLiteDatabase r12) {
        /*
        r11 = this;
        r0 = 0;
        r2 = "events";
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r1 = r12;
        r1 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0077 }
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r0.<init>();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
    L_0x0013:
        r2 = r1.moveToNext();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r3 = 1;
        r4 = 0;
        if (r2 == 0) goto L_0x0037;
    L_0x001b:
        r6 = r1.getLong(r4);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r8 = r1.getString(r3);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r2 = 2;
        r9 = r1.getInt(r2);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r2 = 3;
        r10 = r1.getInt(r2);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r2 = new com.tencent.stat.x;	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r5 = r2;
        r5.<init>(r6, r8, r9, r10);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r0.add(r2);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        goto L_0x0013;
    L_0x0037:
        r2 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r2.<init>();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
    L_0x0040:
        r5 = r0.hasNext();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        if (r5 == 0) goto L_0x0069;
    L_0x0046:
        r5 = r0.next();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r5 = (com.tencent.stat.x) r5;	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r6 = "content";
        r7 = r5.b;	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r7 = com.tencent.stat.common.k.c(r7);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r2.put(r6, r7);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r6 = "events";
        r7 = "event_id=?";
        r8 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r9 = r5.a;	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r5 = java.lang.Long.toString(r9);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r8[r4] = r5;	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        r12.update(r6, r2, r7, r8);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
        goto L_0x0040;
    L_0x0069:
        if (r1 == 0) goto L_0x0084;
    L_0x006b:
        r1.close();
        return;
    L_0x006f:
        r12 = move-exception;
        goto L_0x0085;
    L_0x0071:
        r12 = move-exception;
        r0 = r1;
        goto L_0x0078;
    L_0x0074:
        r12 = move-exception;
        r1 = r0;
        goto L_0x0085;
    L_0x0077:
        r12 = move-exception;
    L_0x0078:
        r1 = com.tencent.stat.n.e;	 Catch:{ all -> 0x0074 }
        r1.e(r12);	 Catch:{ all -> 0x0074 }
        if (r0 == 0) goto L_0x0084;
    L_0x0081:
        r0.close();
    L_0x0084:
        return;
    L_0x0085:
        if (r1 == 0) goto L_0x008a;
    L_0x0087:
        r1.close();
    L_0x008a:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.w.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StatLogger d = n.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("upgrade DB from oldVersion ");
        stringBuilder.append(i);
        stringBuilder.append(" to newVersion ");
        stringBuilder.append(i2);
        d.debug(stringBuilder.toString());
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
        if (i == 2) {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
    }
}
