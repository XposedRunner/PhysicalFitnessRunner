package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.a;
import java.util.List;

/* compiled from: BUGLY */
public final class q extends SQLiteOpenHelper {
    public static String a = "bugly_db";
    private static int b = 13;
    private Context c;
    private List<a> d;

    public q(Context context, List<a> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("_");
        com.tencent.bugly.crashreport.common.info.a.a(context).getClass();
        super(context, stringBuilder.toString(), null, b);
        this.c = context;
        this.d = list;
    }

    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            for (String str : new String[]{"t_lr", "t_ui", "t_pf"}) {
                StringBuilder stringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
                stringBuilder.append(str);
                sQLiteDatabase.execSQL(stringBuilder.toString(), new String[0]);
            }
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:11:?, code skipped:
            com.tencent.bugly.proguard.x.d("[Database] Try to get db(count: %d).", java.lang.Integer.valueOf(r2));
     */
    /* JADX WARNING: Missing block: B:12:0x0021, code skipped:
            if (r2 == 5) goto L_0x0023;
     */
    /* JADX WARNING: Missing block: B:13:0x0023, code skipped:
            com.tencent.bugly.proguard.x.e("[Database] Failed to get db.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:16:?, code skipped:
            java.lang.Thread.sleep(200);
     */
    /* JADX WARNING: Missing block: B:18:0x0030, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            r3.printStackTrace();
     */
    public final synchronized android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = 0;
        r1 = 0;
        r2 = r1;
    L_0x0004:
        if (r0 != 0) goto L_0x0037;
    L_0x0006:
        r3 = 5;
        if (r2 >= r3) goto L_0x0037;
    L_0x0009:
        r2 = r2 + 1;
        r4 = super.getReadableDatabase();	 Catch:{ Throwable -> 0x0013 }
        r0 = r4;
        goto L_0x0004;
    L_0x0011:
        r0 = move-exception;
        goto L_0x0035;
    L_0x0013:
        r4 = "[Database] Try to get db(count: %d).";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0011 }
        r6 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0011 }
        r5[r1] = r6;	 Catch:{ all -> 0x0011 }
        com.tencent.bugly.proguard.x.d(r4, r5);	 Catch:{ all -> 0x0011 }
        if (r2 != r3) goto L_0x002a;
    L_0x0023:
        r3 = "[Database] Failed to get db.";
        r4 = new java.lang.Object[r1];	 Catch:{ all -> 0x0011 }
        com.tencent.bugly.proguard.x.e(r3, r4);	 Catch:{ all -> 0x0011 }
    L_0x002a:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        java.lang.Thread.sleep(r3);	 Catch:{ InterruptedException -> 0x0030 }
        goto L_0x0004;
    L_0x0030:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0035:
        monitor-exit(r7);
        throw r0;
    L_0x0037:
        monitor-exit(r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.q.getReadableDatabase():android.database.sqlite.SQLiteDatabase");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:10:?, code skipped:
            com.tencent.bugly.proguard.x.d("[Database] Try to get db(count: %d).", java.lang.Integer.valueOf(r2));
     */
    /* JADX WARNING: Missing block: B:11:0x001f, code skipped:
            if (r2 == 5) goto L_0x0021;
     */
    /* JADX WARNING: Missing block: B:12:0x0021, code skipped:
            com.tencent.bugly.proguard.x.e("[Database] Failed to get db.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:15:?, code skipped:
            java.lang.Thread.sleep(200);
     */
    /* JADX WARNING: Missing block: B:17:0x002e, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r3.printStackTrace();
     */
    public final synchronized android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = 0;
        r1 = 0;
        r2 = r1;
    L_0x0004:
        if (r0 != 0) goto L_0x0033;
    L_0x0006:
        r3 = 5;
        if (r2 >= r3) goto L_0x0033;
    L_0x0009:
        r2 = r2 + 1;
        r4 = super.getWritableDatabase();	 Catch:{ Throwable -> 0x0011 }
        r0 = r4;
        goto L_0x0004;
    L_0x0011:
        r4 = "[Database] Try to get db(count: %d).";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x003d }
        r6 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x003d }
        r5[r1] = r6;	 Catch:{ all -> 0x003d }
        com.tencent.bugly.proguard.x.d(r4, r5);	 Catch:{ all -> 0x003d }
        if (r2 != r3) goto L_0x0028;
    L_0x0021:
        r3 = "[Database] Failed to get db.";
        r4 = new java.lang.Object[r1];	 Catch:{ all -> 0x003d }
        com.tencent.bugly.proguard.x.e(r3, r4);	 Catch:{ all -> 0x003d }
    L_0x0028:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        java.lang.Thread.sleep(r3);	 Catch:{ InterruptedException -> 0x002e }
        goto L_0x0004;
    L_0x002e:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x003d }
        goto L_0x0004;
    L_0x0033:
        if (r0 != 0) goto L_0x0040;
    L_0x0035:
        r2 = "[Database] db error delay error record 1min.";
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x003d }
        com.tencent.bugly.proguard.x.d(r2, r1);	 Catch:{ all -> 0x003d }
        goto L_0x0040;
    L_0x003d:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x0040:
        monitor-exit(r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.q.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
    }

    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_ui");
            stringBuilder.append(" ( _id");
            stringBuilder.append(" INTEGER PRIMARY KEY");
            stringBuilder.append(" , _tm");
            stringBuilder.append(" int");
            stringBuilder.append(" , _ut");
            stringBuilder.append(" int");
            stringBuilder.append(" , _tp");
            stringBuilder.append(" int");
            stringBuilder.append(" , _dt");
            stringBuilder.append(" blob");
            stringBuilder.append(" , _pc");
            stringBuilder.append(" text");
            stringBuilder.append(" ) ");
            x.c(stringBuilder.toString(), new Object[0]);
            sQLiteDatabase.execSQL(stringBuilder.toString(), new String[0]);
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_lr");
            stringBuilder.append(" ( _id");
            stringBuilder.append(" INTEGER PRIMARY KEY");
            stringBuilder.append(" , _tp");
            stringBuilder.append(" int");
            stringBuilder.append(" , _tm");
            stringBuilder.append(" int");
            stringBuilder.append(" , _pc");
            stringBuilder.append(" text");
            stringBuilder.append(" , _th");
            stringBuilder.append(" text");
            stringBuilder.append(" , _dt");
            stringBuilder.append(" blob");
            stringBuilder.append(" ) ");
            x.c(stringBuilder.toString(), new Object[0]);
            sQLiteDatabase.execSQL(stringBuilder.toString(), new String[0]);
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_pf");
            stringBuilder.append(" ( _id");
            stringBuilder.append(" integer");
            stringBuilder.append(" , _tp");
            stringBuilder.append(" text");
            stringBuilder.append(" , _tm");
            stringBuilder.append(" int");
            stringBuilder.append(" , _dt");
            stringBuilder.append(" blob");
            stringBuilder.append(",primary key(_id");
            stringBuilder.append(",_tp");
            stringBuilder.append(" )) ");
            x.c(stringBuilder.toString(), new Object[0]);
            sQLiteDatabase.execSQL(stringBuilder.toString(), new String[0]);
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_cr");
            stringBuilder.append(" ( _id");
            stringBuilder.append(" INTEGER PRIMARY KEY");
            stringBuilder.append(" , _tm");
            stringBuilder.append(" int");
            stringBuilder.append(" , _s1");
            stringBuilder.append(" text");
            stringBuilder.append(" , _up");
            stringBuilder.append(" int");
            stringBuilder.append(" , _me");
            stringBuilder.append(" int");
            stringBuilder.append(" , _uc");
            stringBuilder.append(" int");
            stringBuilder.append(" , _dt");
            stringBuilder.append(" blob");
            stringBuilder.append(" ) ");
            x.c(stringBuilder.toString(), new Object[0]);
            sQLiteDatabase.execSQL(stringBuilder.toString(), new String[0]);
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS dl_1002");
            stringBuilder.append(" (_id");
            stringBuilder.append(" integer primary key autoincrement, _dUrl");
            stringBuilder.append(" varchar(100), _sFile");
            stringBuilder.append(" varchar(100), _sLen");
            stringBuilder.append(" INTEGER, _tLen");
            stringBuilder.append(" INTEGER, _MD5");
            stringBuilder.append(" varchar(100), _DLTIME");
            stringBuilder.append(" INTEGER)");
            x.c(stringBuilder.toString(), new Object[0]);
            sQLiteDatabase.execSQL(stringBuilder.toString(), new String[0]);
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE TABLE IF NOT EXISTS ge_1002");
            stringBuilder.append(" (_id");
            stringBuilder.append(" integer primary key autoincrement, _time");
            stringBuilder.append(" INTEGER, _datas");
            stringBuilder.append(" blob)");
            x.c(stringBuilder.toString(), new Object[0]);
            sQLiteDatabase.execSQL(stringBuilder.toString(), new String[0]);
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS st_1002");
            stringBuilder.append(" ( _id");
            stringBuilder.append(" integer");
            stringBuilder.append(" , _tp");
            stringBuilder.append(" text");
            stringBuilder.append(" , _tm");
            stringBuilder.append(" int");
            stringBuilder.append(" , _dt");
            stringBuilder.append(" blob");
            stringBuilder.append(",primary key(_id");
            stringBuilder.append(",_tp");
            stringBuilder.append(" )) ");
            x.c(stringBuilder.toString(), new Object[0]);
            sQLiteDatabase.execSQL(stringBuilder.toString(), new String[0]);
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
        }
        if (this.d != null) {
            for (a onDbCreate : this.d) {
                try {
                    onDbCreate.onDbCreate(sQLiteDatabase);
                } catch (Throwable th2) {
                    if (!x.b(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:30:0x006a, code skipped:
            return;
     */
    @android.annotation.TargetApi(11)
    public final synchronized void onDowngrade(android.database.sqlite.SQLiteDatabase r6, int r7, int r8) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = com.tencent.bugly.crashreport.common.info.b.c();	 Catch:{ all -> 0x006b }
        r1 = 11;
        if (r0 < r1) goto L_0x0069;
    L_0x0009:
        r0 = "[Database] Downgrade %d to %d drop tables.";
        r1 = 2;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x006b }
        r2 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x006b }
        r3 = 0;
        r1[r3] = r2;	 Catch:{ all -> 0x006b }
        r2 = 1;
        r4 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x006b }
        r1[r2] = r4;	 Catch:{ all -> 0x006b }
        com.tencent.bugly.proguard.x.d(r0, r1);	 Catch:{ all -> 0x006b }
        r0 = r5.d;	 Catch:{ all -> 0x006b }
        if (r0 == 0) goto L_0x0044;
    L_0x0023:
        r0 = r5.d;	 Catch:{ all -> 0x006b }
        r0 = r0.iterator();	 Catch:{ all -> 0x006b }
    L_0x0029:
        r1 = r0.hasNext();	 Catch:{ all -> 0x006b }
        if (r1 == 0) goto L_0x0044;
    L_0x002f:
        r1 = r0.next();	 Catch:{ all -> 0x006b }
        r1 = (com.tencent.bugly.a) r1;	 Catch:{ all -> 0x006b }
        r1.onDbDowngrade(r6, r7, r8);	 Catch:{ Throwable -> 0x0039 }
        goto L_0x0029;
    L_0x0039:
        r1 = move-exception;
        r2 = com.tencent.bugly.proguard.x.b(r1);	 Catch:{ all -> 0x006b }
        if (r2 != 0) goto L_0x0029;
    L_0x0040:
        r1.printStackTrace();	 Catch:{ all -> 0x006b }
        goto L_0x0029;
    L_0x0044:
        r7 = r5.a(r6);	 Catch:{ all -> 0x006b }
        if (r7 == 0) goto L_0x004f;
    L_0x004a:
        r5.onCreate(r6);	 Catch:{ all -> 0x006b }
        monitor-exit(r5);
        return;
    L_0x004f:
        r6 = "[Database] Failed to drop, delete db.";
        r7 = new java.lang.Object[r3];	 Catch:{ all -> 0x006b }
        com.tencent.bugly.proguard.x.d(r6, r7);	 Catch:{ all -> 0x006b }
        r6 = r5.c;	 Catch:{ all -> 0x006b }
        r7 = a;	 Catch:{ all -> 0x006b }
        r6 = r6.getDatabasePath(r7);	 Catch:{ all -> 0x006b }
        if (r6 == 0) goto L_0x0069;
    L_0x0060:
        r7 = r6.canWrite();	 Catch:{ all -> 0x006b }
        if (r7 == 0) goto L_0x0069;
    L_0x0066:
        r6.delete();	 Catch:{ all -> 0x006b }
    L_0x0069:
        monitor-exit(r5);
        return;
    L_0x006b:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.q.onDowngrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    /* JADX WARNING: Missing block: B:28:0x0062, code skipped:
            return;
     */
    public final synchronized void onUpgrade(android.database.sqlite.SQLiteDatabase r6, int r7, int r8) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = "[Database] Upgrade %d to %d , drop tables!";
        r1 = 2;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0063 }
        r2 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0063 }
        r3 = 0;
        r1[r3] = r2;	 Catch:{ all -> 0x0063 }
        r2 = 1;
        r4 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0063 }
        r1[r2] = r4;	 Catch:{ all -> 0x0063 }
        com.tencent.bugly.proguard.x.d(r0, r1);	 Catch:{ all -> 0x0063 }
        r0 = r5.d;	 Catch:{ all -> 0x0063 }
        if (r0 == 0) goto L_0x003c;
    L_0x001b:
        r0 = r5.d;	 Catch:{ all -> 0x0063 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0063 }
    L_0x0021:
        r1 = r0.hasNext();	 Catch:{ all -> 0x0063 }
        if (r1 == 0) goto L_0x003c;
    L_0x0027:
        r1 = r0.next();	 Catch:{ all -> 0x0063 }
        r1 = (com.tencent.bugly.a) r1;	 Catch:{ all -> 0x0063 }
        r1.onDbUpgrade(r6, r7, r8);	 Catch:{ Throwable -> 0x0031 }
        goto L_0x0021;
    L_0x0031:
        r1 = move-exception;
        r2 = com.tencent.bugly.proguard.x.b(r1);	 Catch:{ all -> 0x0063 }
        if (r2 != 0) goto L_0x0021;
    L_0x0038:
        r1.printStackTrace();	 Catch:{ all -> 0x0063 }
        goto L_0x0021;
    L_0x003c:
        r7 = r5.a(r6);	 Catch:{ all -> 0x0063 }
        if (r7 == 0) goto L_0x0047;
    L_0x0042:
        r5.onCreate(r6);	 Catch:{ all -> 0x0063 }
        monitor-exit(r5);
        return;
    L_0x0047:
        r6 = "[Database] Failed to drop, delete db.";
        r7 = new java.lang.Object[r3];	 Catch:{ all -> 0x0063 }
        com.tencent.bugly.proguard.x.d(r6, r7);	 Catch:{ all -> 0x0063 }
        r6 = r5.c;	 Catch:{ all -> 0x0063 }
        r7 = a;	 Catch:{ all -> 0x0063 }
        r6 = r6.getDatabasePath(r7);	 Catch:{ all -> 0x0063 }
        if (r6 == 0) goto L_0x0061;
    L_0x0058:
        r7 = r6.canWrite();	 Catch:{ all -> 0x0063 }
        if (r7 == 0) goto L_0x0061;
    L_0x005e:
        r6.delete();	 Catch:{ all -> 0x0063 }
    L_0x0061:
        monitor-exit(r5);
        return;
    L_0x0063:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.q.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
