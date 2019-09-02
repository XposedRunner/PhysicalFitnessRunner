package cn.jpush.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;

public abstract class f extends SQLiteOpenHelper {
    private volatile int a = 0;
    private volatile int b = 0;
    private volatile SQLiteDatabase c;
    private volatile SQLiteDatabase d;
    private final Object e = new Object();
    private final Object f = new Object();
    private final Context g;
    private final String h;
    private final int i;
    private final CursorFactory j;

    public f(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, null, 1);
        this.g = context;
        this.h = str;
        this.i = 1;
        this.j = null;
    }

    public final boolean a(boolean z) {
        if (z) {
            try {
                synchronized (this.e) {
                    getWritableDatabase();
                    this.b++;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        synchronized (this.f) {
            getReadableDatabase();
            this.a++;
        }
        return true;
    }

    public final void b(boolean z) {
        int i = 1;
        int i2;
        if (z) {
            synchronized (this.e) {
                if (this.d != null && this.d.isOpen()) {
                    i2 = this.b - 1;
                    this.b = i2;
                    if (i2 > 0) {
                        i = 0;
                    }
                }
                if (i != 0) {
                    this.b = 0;
                    if (this.d != null) {
                        this.d.close();
                    }
                    this.d = null;
                }
            }
            return;
        }
        synchronized (this.f) {
            if (this.c != null && this.c.isOpen()) {
                i2 = this.a - 1;
                this.a = i2;
                if (i2 > 0) {
                    i = 0;
                }
            }
            if (i != 0) {
                this.a = 0;
                if (this.c != null) {
                    this.c.close();
                }
                this.c = null;
            }
        }
    }

    @Deprecated
    public void close() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001e */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|13|14|(2:16|17)(1:18)) */
    public android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        /*
        r5 = this;
        r0 = r5.c;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = r5.c;
        r0 = r0.isOpen();
        if (r0 != 0) goto L_0x0072;
    L_0x000c:
        r0 = r5.f;
        monitor-enter(r0);
        r1 = r5.c;	 Catch:{ all -> 0x0075 }
        if (r1 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r5.c;	 Catch:{ all -> 0x0075 }
        r1 = r1.isOpen();	 Catch:{ all -> 0x0075 }
        if (r1 != 0) goto L_0x0071;
    L_0x001b:
        r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x001e }
    L_0x001e:
        r1 = r5.g;	 Catch:{ all -> 0x0075 }
        r2 = r5.h;	 Catch:{ all -> 0x0075 }
        r1 = r1.getDatabasePath(r2);	 Catch:{ all -> 0x0075 }
        r1 = r1.getPath();	 Catch:{ all -> 0x0075 }
        r2 = r5.j;	 Catch:{ all -> 0x0075 }
        r3 = 1;
        r2 = android.database.sqlite.SQLiteDatabase.openDatabase(r1, r2, r3);	 Catch:{ all -> 0x0075 }
        r5.c = r2;	 Catch:{ all -> 0x0075 }
        r2 = r5.c;	 Catch:{ all -> 0x0075 }
        r2 = r2.getVersion();	 Catch:{ all -> 0x0075 }
        r3 = r5.i;	 Catch:{ all -> 0x0075 }
        if (r2 == r3) goto L_0x0069;
    L_0x003d:
        r2 = new android.database.sqlite.SQLiteException;	 Catch:{ all -> 0x0075 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
        r4 = "Can't upgrade read-only database from version ";
        r3.<init>(r4);	 Catch:{ all -> 0x0075 }
        r4 = r5.c;	 Catch:{ all -> 0x0075 }
        r4 = r4.getVersion();	 Catch:{ all -> 0x0075 }
        r3.append(r4);	 Catch:{ all -> 0x0075 }
        r4 = " to ";
        r3.append(r4);	 Catch:{ all -> 0x0075 }
        r4 = r5.i;	 Catch:{ all -> 0x0075 }
        r3.append(r4);	 Catch:{ all -> 0x0075 }
        r4 = ": ";
        r3.append(r4);	 Catch:{ all -> 0x0075 }
        r3.append(r1);	 Catch:{ all -> 0x0075 }
        r1 = r3.toString();	 Catch:{ all -> 0x0075 }
        r2.<init>(r1);	 Catch:{ all -> 0x0075 }
        throw r2;	 Catch:{ all -> 0x0075 }
    L_0x0069:
        r1 = 0;
        r5.a = r1;	 Catch:{ all -> 0x0075 }
        r1 = r5.c;	 Catch:{ all -> 0x0075 }
        r5.onOpen(r1);	 Catch:{ all -> 0x0075 }
    L_0x0071:
        monitor-exit(r0);	 Catch:{ all -> 0x0075 }
    L_0x0072:
        r0 = r5.c;
        return r0;
    L_0x0075:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0075 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.f.getReadableDatabase():android.database.sqlite.SQLiteDatabase");
    }

    public SQLiteDatabase getWritableDatabase() {
        if (this.d == null || !this.d.isOpen()) {
            synchronized (this.e) {
                if (this.d == null || !this.d.isOpen()) {
                    this.b = 0;
                    this.d = super.getWritableDatabase();
                    if (VERSION.SDK_INT >= 11) {
                        this.d.enableWriteAheadLogging();
                    }
                }
            }
        }
        return this.d;
    }
}
