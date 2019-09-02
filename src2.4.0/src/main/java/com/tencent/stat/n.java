package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.a.e;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.k;
import java.util.HashMap;
import java.util.List;

public class n {
    private static StatLogger e = k.b();
    private static n f;
    Handler a = null;
    volatile int b = 0;
    DeviceInfo c = null;
    private w d;
    private HashMap<String, String> g = new HashMap();

    private n(Context context) {
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            StatLogger statLogger = e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Launch store thread:");
            stringBuilder.append(handlerThread);
            statLogger.w(stringBuilder.toString());
            this.a = new Handler(handlerThread.getLooper());
            context = context.getApplicationContext();
            this.d = new w(context);
            this.d.getWritableDatabase();
            this.d.getReadableDatabase();
            b(context);
            c();
            f();
            this.a.post(new o(this));
        } catch (Throwable th) {
            e.e(th);
        }
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (f == null) {
                f = new n(context);
            }
            nVar = f;
        }
        return nVar;
    }

    public static n b() {
        return f;
    }

    /* JADX WARNING: Missing block: B:19:0x009a, code skipped:
            return;
     */
    private synchronized void b(int r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.b;	 Catch:{ Throwable -> 0x009d }
        if (r0 <= 0) goto L_0x0099;
    L_0x0005:
        if (r6 > 0) goto L_0x0009;
    L_0x0007:
        goto L_0x0099;
    L_0x0009:
        r0 = e;	 Catch:{ Throwable -> 0x009d }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d }
        r1.<init>();	 Catch:{ Throwable -> 0x009d }
        r2 = "Load ";
        r1.append(r2);	 Catch:{ Throwable -> 0x009d }
        r2 = r5.b;	 Catch:{ Throwable -> 0x009d }
        r2 = java.lang.Integer.toString(r2);	 Catch:{ Throwable -> 0x009d }
        r1.append(r2);	 Catch:{ Throwable -> 0x009d }
        r2 = " unsent events";
        r1.append(r2);	 Catch:{ Throwable -> 0x009d }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x009d }
        r0.i(r1);	 Catch:{ Throwable -> 0x009d }
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x009d }
        r0.<init>();	 Catch:{ Throwable -> 0x009d }
        r1 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x009d }
        r1.<init>();	 Catch:{ Throwable -> 0x009d }
        r2 = -1;
        if (r6 == r2) goto L_0x003d;
    L_0x0037:
        r2 = com.tencent.stat.StatConfig.a();	 Catch:{ Throwable -> 0x009d }
        if (r6 <= r2) goto L_0x0041;
    L_0x003d:
        r6 = com.tencent.stat.StatConfig.a();	 Catch:{ Throwable -> 0x009d }
    L_0x0041:
        r2 = r5.b;	 Catch:{ Throwable -> 0x009d }
        r2 = r2 - r6;
        r5.b = r2;	 Catch:{ Throwable -> 0x009d }
        r5.c(r1, r6);	 Catch:{ Throwable -> 0x009d }
        r2 = e;	 Catch:{ Throwable -> 0x009d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d }
        r3.<init>();	 Catch:{ Throwable -> 0x009d }
        r4 = "Peek ";
        r3.append(r4);	 Catch:{ Throwable -> 0x009d }
        r4 = r1.size();	 Catch:{ Throwable -> 0x009d }
        r4 = java.lang.Integer.toString(r4);	 Catch:{ Throwable -> 0x009d }
        r3.append(r4);	 Catch:{ Throwable -> 0x009d }
        r4 = " unsent events.";
        r3.append(r4);	 Catch:{ Throwable -> 0x009d }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x009d }
        r2.i(r3);	 Catch:{ Throwable -> 0x009d }
        r2 = r1.isEmpty();	 Catch:{ Throwable -> 0x009d }
        if (r2 != 0) goto L_0x00a3;
    L_0x0072:
        r2 = 2;
        r5.b(r1, r2);	 Catch:{ Throwable -> 0x009d }
        r2 = r1.iterator();	 Catch:{ Throwable -> 0x009d }
    L_0x007a:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x009d }
        if (r3 == 0) goto L_0x008c;
    L_0x0080:
        r3 = r2.next();	 Catch:{ Throwable -> 0x009d }
        r3 = (com.tencent.stat.x) r3;	 Catch:{ Throwable -> 0x009d }
        r3 = r3.b;	 Catch:{ Throwable -> 0x009d }
        r0.add(r3);	 Catch:{ Throwable -> 0x009d }
        goto L_0x007a;
    L_0x008c:
        r2 = com.tencent.stat.d.b();	 Catch:{ Throwable -> 0x009d }
        r3 = new com.tencent.stat.u;	 Catch:{ Throwable -> 0x009d }
        r3.<init>(r5, r1, r6);	 Catch:{ Throwable -> 0x009d }
        r2.b(r0, r3);	 Catch:{ Throwable -> 0x009d }
        goto L_0x00a3;
    L_0x0099:
        monitor-exit(r5);
        return;
    L_0x009b:
        r6 = move-exception;
        goto L_0x00a5;
    L_0x009d:
        r6 = move-exception;
        r0 = e;	 Catch:{ all -> 0x009b }
        r0.e(r6);	 Catch:{ all -> 0x009b }
    L_0x00a3:
        monitor-exit(r5);
        return;
    L_0x00a5:
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.b(int):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00c5 */
    private synchronized void b(com.tencent.stat.a.e r8, com.tencent.stat.c r9) {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = com.tencent.stat.StatConfig.getMaxStoreEventCount();	 Catch:{ all -> 0x00c6 }
        if (r0 > 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r7);
        return;
    L_0x0009:
        r0 = r7.d;	 Catch:{ Throwable -> 0x00ad }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00ad }
        r0.beginTransaction();	 Catch:{ Throwable -> 0x00ad }
        r0 = r7.b;	 Catch:{ Throwable -> 0x00ad }
        r1 = com.tencent.stat.StatConfig.getMaxStoreEventCount();	 Catch:{ Throwable -> 0x00ad }
        r2 = 0;
        if (r0 <= r1) goto L_0x0035;
    L_0x001b:
        r0 = e;	 Catch:{ Throwable -> 0x00ad }
        r1 = "Too many events stored in db.";
        r0.warn(r1);	 Catch:{ Throwable -> 0x00ad }
        r0 = r7.b;	 Catch:{ Throwable -> 0x00ad }
        r1 = r7.d;	 Catch:{ Throwable -> 0x00ad }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x00ad }
        r3 = "events";
        r4 = "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)";
        r1 = r1.delete(r3, r4, r2);	 Catch:{ Throwable -> 0x00ad }
        r0 = r0 - r1;
        r7.b = r0;	 Catch:{ Throwable -> 0x00ad }
    L_0x0035:
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00ad }
        r0.<init>();	 Catch:{ Throwable -> 0x00ad }
        r1 = r8.d();	 Catch:{ Throwable -> 0x00ad }
        r1 = com.tencent.stat.common.k.c(r1);	 Catch:{ Throwable -> 0x00ad }
        r3 = "content";
        r0.put(r3, r1);	 Catch:{ Throwable -> 0x00ad }
        r3 = "send_count";
        r4 = "0";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ad }
        r3 = "status";
        r4 = 1;
        r5 = java.lang.Integer.toString(r4);	 Catch:{ Throwable -> 0x00ad }
        r0.put(r3, r5);	 Catch:{ Throwable -> 0x00ad }
        r3 = "timestamp";
        r5 = r8.b();	 Catch:{ Throwable -> 0x00ad }
        r8 = java.lang.Long.valueOf(r5);	 Catch:{ Throwable -> 0x00ad }
        r0.put(r3, r8);	 Catch:{ Throwable -> 0x00ad }
        r8 = r7.d;	 Catch:{ Throwable -> 0x00ad }
        r8 = r8.getWritableDatabase();	 Catch:{ Throwable -> 0x00ad }
        r3 = "events";
        r2 = r8.insert(r3, r2, r0);	 Catch:{ Throwable -> 0x00ad }
        r5 = -1;
        r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r8 != 0) goto L_0x008e;
    L_0x0077:
        r8 = e;	 Catch:{ Throwable -> 0x00ad }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ad }
        r9.<init>();	 Catch:{ Throwable -> 0x00ad }
        r0 = "Failed to store event:";
        r9.append(r0);	 Catch:{ Throwable -> 0x00ad }
        r9.append(r1);	 Catch:{ Throwable -> 0x00ad }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x00ad }
        r8.error(r9);	 Catch:{ Throwable -> 0x00ad }
        goto L_0x00a1;
    L_0x008e:
        r8 = r7.b;	 Catch:{ Throwable -> 0x00ad }
        r8 = r8 + r4;
        r7.b = r8;	 Catch:{ Throwable -> 0x00ad }
        r8 = r7.d;	 Catch:{ Throwable -> 0x00ad }
        r8 = r8.getWritableDatabase();	 Catch:{ Throwable -> 0x00ad }
        r8.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00ad }
        if (r9 == 0) goto L_0x00a1;
    L_0x009e:
        r9.a();	 Catch:{ Throwable -> 0x00ad }
    L_0x00a1:
        r8 = r7.d;	 Catch:{ Throwable -> 0x00ba }
        r8 = r8.getWritableDatabase();	 Catch:{ Throwable -> 0x00ba }
    L_0x00a7:
        r8.endTransaction();	 Catch:{ Throwable -> 0x00ba }
        goto L_0x00ba;
    L_0x00ab:
        r8 = move-exception;
        goto L_0x00bc;
    L_0x00ad:
        r8 = move-exception;
        r9 = e;	 Catch:{ all -> 0x00ab }
        r9.e(r8);	 Catch:{ all -> 0x00ab }
        r8 = r7.d;	 Catch:{ Throwable -> 0x00ba }
        r8 = r8.getWritableDatabase();	 Catch:{ Throwable -> 0x00ba }
        goto L_0x00a7;
    L_0x00ba:
        monitor-exit(r7);
        return;
    L_0x00bc:
        r9 = r7.d;	 Catch:{ Throwable -> 0x00c5 }
        r9 = r9.getWritableDatabase();	 Catch:{ Throwable -> 0x00c5 }
        r9.endTransaction();	 Catch:{ Throwable -> 0x00c5 }
    L_0x00c5:
        throw r8;	 Catch:{ all -> 0x00c6 }
    L_0x00c6:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.b(com.tencent.stat.a.e, com.tencent.stat.c):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d4 A:{SYNTHETIC, Splitter:B:35:0x00d4} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cd A:{SYNTHETIC, Splitter:B:30:0x00cd} */
    private synchronized void b(com.tencent.stat.b r13) {
        /*
        r12 = this;
        monitor-enter(r12);
        r0 = 0;
        r1 = r13.a();	 Catch:{ Throwable -> 0x00c5 }
        r2 = com.tencent.stat.common.k.a(r1);	 Catch:{ Throwable -> 0x00c5 }
        r3 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00c5 }
        r3.<init>();	 Catch:{ Throwable -> 0x00c5 }
        r4 = "content";
        r5 = r13.b;	 Catch:{ Throwable -> 0x00c5 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x00c5 }
        r3.put(r4, r5);	 Catch:{ Throwable -> 0x00c5 }
        r4 = "md5sum";
        r3.put(r4, r2);	 Catch:{ Throwable -> 0x00c5 }
        r13.c = r2;	 Catch:{ Throwable -> 0x00c5 }
        r2 = "version";
        r4 = r13.d;	 Catch:{ Throwable -> 0x00c5 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x00c5 }
        r3.put(r2, r4);	 Catch:{ Throwable -> 0x00c5 }
        r2 = r12.d;	 Catch:{ Throwable -> 0x00c5 }
        r4 = r2.getReadableDatabase();	 Catch:{ Throwable -> 0x00c5 }
        r5 = "config";
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r2 = r4.query(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Throwable -> 0x00c5 }
    L_0x003e:
        r4 = r2.moveToNext();	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r5 = 1;
        r6 = 0;
        if (r4 == 0) goto L_0x0050;
    L_0x0046:
        r4 = r2.getInt(r6);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r7 = r13.a;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        if (r4 != r7) goto L_0x003e;
    L_0x004e:
        r4 = r5;
        goto L_0x0051;
    L_0x0050:
        r4 = r6;
    L_0x0051:
        if (r5 != r4) goto L_0x006d;
    L_0x0053:
        r0 = r12.d;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r4 = "config";
        r7 = "type=?";
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r13 = r13.a;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r13 = java.lang.Integer.toString(r13);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r5[r6] = r13;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r13 = r0.update(r4, r3, r7, r5);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r3 = (long) r13;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        goto L_0x0084;
    L_0x006d:
        r4 = "type";
        r13 = r13.a;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r3.put(r4, r13);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r13 = r12.d;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r13 = r13.getWritableDatabase();	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r4 = "config";
        r3 = r13.insert(r4, r0, r3);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
    L_0x0084:
        r5 = -1;
        r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r13 != 0) goto L_0x00a1;
    L_0x008a:
        r13 = e;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0.<init>();	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r3 = "Failed to store cfg:";
        r0.append(r3);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0.append(r1);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r13.e(r0);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        goto L_0x00b7;
    L_0x00a1:
        r13 = e;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0.<init>();	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r3 = "Sucessed to store cfg:";
        r0.append(r3);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0.append(r1);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
        r13.d(r0);	 Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
    L_0x00b7:
        if (r2 == 0) goto L_0x00d0;
    L_0x00b9:
        r2.close();	 Catch:{ all -> 0x00d8 }
        goto L_0x00d0;
    L_0x00bd:
        r13 = move-exception;
        goto L_0x00d2;
    L_0x00bf:
        r13 = move-exception;
        r0 = r2;
        goto L_0x00c6;
    L_0x00c2:
        r13 = move-exception;
        r2 = r0;
        goto L_0x00d2;
    L_0x00c5:
        r13 = move-exception;
    L_0x00c6:
        r1 = e;	 Catch:{ all -> 0x00c2 }
        r1.e(r13);	 Catch:{ all -> 0x00c2 }
        if (r0 == 0) goto L_0x00d0;
    L_0x00cd:
        r0.close();	 Catch:{ all -> 0x00d8 }
    L_0x00d0:
        monitor-exit(r12);
        return;
    L_0x00d2:
        if (r2 == 0) goto L_0x00da;
    L_0x00d4:
        r2.close();	 Catch:{ all -> 0x00d8 }
        goto L_0x00da;
    L_0x00d8:
        r13 = move-exception;
        goto L_0x00db;
    L_0x00da:
        throw r13;	 Catch:{ all -> 0x00d8 }
    L_0x00db:
        monitor-exit(r12);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.b(com.tencent.stat.b):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:9:0x0078, B:17:0x008c] */
    /* JADX WARNING: Missing block: B:11:0x0082, code skipped:
            r10 = e;
     */
    /* JADX WARNING: Missing block: B:13:?, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            r9.d.getWritableDatabase().endTransaction();
     */
    /* JADX WARNING: Missing block: B:28:0x00ab, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            e.e(r0);
     */
    private synchronized void b(java.util.List<com.tencent.stat.x> r10) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = e;	 Catch:{ all -> 0x00b2 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b2 }
        r1.<init>();	 Catch:{ all -> 0x00b2 }
        r2 = "Delete ";
        r1.append(r2);	 Catch:{ all -> 0x00b2 }
        r2 = r10.size();	 Catch:{ all -> 0x00b2 }
        r1.append(r2);	 Catch:{ all -> 0x00b2 }
        r2 = " sent events in thread:";
        r1.append(r2);	 Catch:{ all -> 0x00b2 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x00b2 }
        r1.append(r2);	 Catch:{ all -> 0x00b2 }
        r1 = r1.toString();	 Catch:{ all -> 0x00b2 }
        r0.i(r1);	 Catch:{ all -> 0x00b2 }
        r0 = r9.d;	 Catch:{ Throwable -> 0x008b }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x008b }
        r0.beginTransaction();	 Catch:{ Throwable -> 0x008b }
        r10 = r10.iterator();	 Catch:{ Throwable -> 0x008b }
    L_0x0034:
        r0 = r10.hasNext();	 Catch:{ Throwable -> 0x008b }
        if (r0 == 0) goto L_0x0060;
    L_0x003a:
        r0 = r10.next();	 Catch:{ Throwable -> 0x008b }
        r0 = (com.tencent.stat.x) r0;	 Catch:{ Throwable -> 0x008b }
        r1 = r9.b;	 Catch:{ Throwable -> 0x008b }
        r2 = r9.d;	 Catch:{ Throwable -> 0x008b }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x008b }
        r3 = "events";
        r4 = "event_id = ?";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x008b }
        r6 = 0;
        r7 = r0.a;	 Catch:{ Throwable -> 0x008b }
        r0 = java.lang.Long.toString(r7);	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r0;	 Catch:{ Throwable -> 0x008b }
        r0 = r2.delete(r3, r4, r5);	 Catch:{ Throwable -> 0x008b }
        r1 = r1 - r0;
        r9.b = r1;	 Catch:{ Throwable -> 0x008b }
        goto L_0x0034;
    L_0x0060:
        r10 = r9.d;	 Catch:{ Throwable -> 0x008b }
        r10 = r10.getWritableDatabase();	 Catch:{ Throwable -> 0x008b }
        r10.setTransactionSuccessful();	 Catch:{ Throwable -> 0x008b }
        r10 = r9.d;	 Catch:{ Throwable -> 0x008b }
        r10 = r10.getReadableDatabase();	 Catch:{ Throwable -> 0x008b }
        r0 = "events";
        r0 = android.database.DatabaseUtils.queryNumEntries(r10, r0);	 Catch:{ Throwable -> 0x008b }
        r10 = (int) r0;	 Catch:{ Throwable -> 0x008b }
        r9.b = r10;	 Catch:{ Throwable -> 0x008b }
        r10 = r9.d;	 Catch:{ SQLiteException -> 0x0082 }
        r10 = r10.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0082 }
        r10.endTransaction();	 Catch:{ SQLiteException -> 0x0082 }
        goto L_0x009f;
    L_0x0082:
        r10 = move-exception;
        r0 = e;	 Catch:{ all -> 0x00b2 }
    L_0x0085:
        r0.e(r10);	 Catch:{ all -> 0x00b2 }
        goto L_0x009f;
    L_0x0089:
        r10 = move-exception;
        goto L_0x00a1;
    L_0x008b:
        r10 = move-exception;
        r0 = e;	 Catch:{ all -> 0x0089 }
        r0.e(r10);	 Catch:{ all -> 0x0089 }
        r10 = r9.d;	 Catch:{ SQLiteException -> 0x009b }
        r10 = r10.getWritableDatabase();	 Catch:{ SQLiteException -> 0x009b }
        r10.endTransaction();	 Catch:{ SQLiteException -> 0x009b }
        goto L_0x009f;
    L_0x009b:
        r10 = move-exception;
        r0 = e;	 Catch:{ all -> 0x00b2 }
        goto L_0x0085;
    L_0x009f:
        monitor-exit(r9);
        return;
    L_0x00a1:
        r0 = r9.d;	 Catch:{ SQLiteException -> 0x00ab }
        r0 = r0.getWritableDatabase();	 Catch:{ SQLiteException -> 0x00ab }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00ab }
        goto L_0x00b1;
    L_0x00ab:
        r0 = move-exception;
        r1 = e;	 Catch:{ all -> 0x00b2 }
        r1.e(r0);	 Catch:{ all -> 0x00b2 }
    L_0x00b1:
        throw r10;	 Catch:{ all -> 0x00b2 }
    L_0x00b2:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.b(java.util.List):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:14:0x00f9, B:22:0x010d] */
    /* JADX WARNING: Missing block: B:16:0x0103, code skipped:
            r10 = e;
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r11 = e;
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            r9.d.getWritableDatabase().endTransaction();
     */
    /* JADX WARNING: Missing block: B:33:0x012c, code skipped:
            r11 = move-exception;
     */
    /* JADX WARNING: Missing block: B:35:?, code skipped:
            e.e(r11);
     */
    private synchronized void b(java.util.List<com.tencent.stat.x> r10, int r11) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = e;	 Catch:{ all -> 0x0133 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0133 }
        r1.<init>();	 Catch:{ all -> 0x0133 }
        r2 = "Update ";
        r1.append(r2);	 Catch:{ all -> 0x0133 }
        r2 = r10.size();	 Catch:{ all -> 0x0133 }
        r1.append(r2);	 Catch:{ all -> 0x0133 }
        r2 = " sending events to status:";
        r1.append(r2);	 Catch:{ all -> 0x0133 }
        r1.append(r11);	 Catch:{ all -> 0x0133 }
        r2 = " in thread:";
        r1.append(r2);	 Catch:{ all -> 0x0133 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0133 }
        r1.append(r2);	 Catch:{ all -> 0x0133 }
        r1 = r1.toString();	 Catch:{ all -> 0x0133 }
        r0.i(r1);	 Catch:{ all -> 0x0133 }
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x010c }
        r0.<init>();	 Catch:{ Throwable -> 0x010c }
        r1 = "status";
        r11 = java.lang.Integer.toString(r11);	 Catch:{ Throwable -> 0x010c }
        r0.put(r1, r11);	 Catch:{ Throwable -> 0x010c }
        r11 = r9.d;	 Catch:{ Throwable -> 0x010c }
        r11 = r11.getWritableDatabase();	 Catch:{ Throwable -> 0x010c }
        r11.beginTransaction();	 Catch:{ Throwable -> 0x010c }
        r10 = r10.iterator();	 Catch:{ Throwable -> 0x010c }
    L_0x004a:
        r11 = r10.hasNext();	 Catch:{ Throwable -> 0x010c }
        if (r11 == 0) goto L_0x00e1;
    L_0x0050:
        r11 = r10.next();	 Catch:{ Throwable -> 0x010c }
        r11 = (com.tencent.stat.x) r11;	 Catch:{ Throwable -> 0x010c }
        r1 = r11.d;	 Catch:{ Throwable -> 0x010c }
        r2 = 1;
        r1 = r1 + r2;
        r3 = com.tencent.stat.StatConfig.getMaxSendRetryCount();	 Catch:{ Throwable -> 0x010c }
        r4 = 0;
        if (r1 <= r3) goto L_0x007f;
    L_0x0061:
        r1 = r9.b;	 Catch:{ Throwable -> 0x010c }
        r3 = r9.d;	 Catch:{ Throwable -> 0x010c }
        r3 = r3.getWritableDatabase();	 Catch:{ Throwable -> 0x010c }
        r5 = "events";
        r6 = "event_id=?";
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x010c }
        r7 = r11.a;	 Catch:{ Throwable -> 0x010c }
        r11 = java.lang.Long.toString(r7);	 Catch:{ Throwable -> 0x010c }
        r2[r4] = r11;	 Catch:{ Throwable -> 0x010c }
        r11 = r3.delete(r5, r6, r2);	 Catch:{ Throwable -> 0x010c }
        r1 = r1 - r11;
        r9.b = r1;	 Catch:{ Throwable -> 0x010c }
        goto L_0x004a;
    L_0x007f:
        r1 = "send_count";
        r3 = r11.d;	 Catch:{ Throwable -> 0x010c }
        r3 = r3 + r2;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x010c }
        r0.put(r1, r3);	 Catch:{ Throwable -> 0x010c }
        r1 = e;	 Catch:{ Throwable -> 0x010c }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010c }
        r3.<init>();	 Catch:{ Throwable -> 0x010c }
        r5 = "Update event:";
        r3.append(r5);	 Catch:{ Throwable -> 0x010c }
        r5 = r11.a;	 Catch:{ Throwable -> 0x010c }
        r3.append(r5);	 Catch:{ Throwable -> 0x010c }
        r5 = " for content:";
        r3.append(r5);	 Catch:{ Throwable -> 0x010c }
        r3.append(r0);	 Catch:{ Throwable -> 0x010c }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x010c }
        r1.i(r3);	 Catch:{ Throwable -> 0x010c }
        r1 = r9.d;	 Catch:{ Throwable -> 0x010c }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x010c }
        r3 = "events";
        r5 = "event_id=?";
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x010c }
        r6 = r11.a;	 Catch:{ Throwable -> 0x010c }
        r11 = java.lang.Long.toString(r6);	 Catch:{ Throwable -> 0x010c }
        r2[r4] = r11;	 Catch:{ Throwable -> 0x010c }
        r11 = r1.update(r3, r0, r5, r2);	 Catch:{ Throwable -> 0x010c }
        if (r11 > 0) goto L_0x004a;
    L_0x00c5:
        r1 = e;	 Catch:{ Throwable -> 0x010c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010c }
        r2.<init>();	 Catch:{ Throwable -> 0x010c }
        r3 = "Failed to update db, error code:";
        r2.append(r3);	 Catch:{ Throwable -> 0x010c }
        r11 = java.lang.Integer.toString(r11);	 Catch:{ Throwable -> 0x010c }
        r2.append(r11);	 Catch:{ Throwable -> 0x010c }
        r11 = r2.toString();	 Catch:{ Throwable -> 0x010c }
        r1.e(r11);	 Catch:{ Throwable -> 0x010c }
        goto L_0x004a;
    L_0x00e1:
        r10 = r9.d;	 Catch:{ Throwable -> 0x010c }
        r10 = r10.getWritableDatabase();	 Catch:{ Throwable -> 0x010c }
        r10.setTransactionSuccessful();	 Catch:{ Throwable -> 0x010c }
        r10 = r9.d;	 Catch:{ Throwable -> 0x010c }
        r10 = r10.getReadableDatabase();	 Catch:{ Throwable -> 0x010c }
        r11 = "events";
        r10 = android.database.DatabaseUtils.queryNumEntries(r10, r11);	 Catch:{ Throwable -> 0x010c }
        r10 = (int) r10;	 Catch:{ Throwable -> 0x010c }
        r9.b = r10;	 Catch:{ Throwable -> 0x010c }
        r10 = r9.d;	 Catch:{ SQLiteException -> 0x0103 }
        r10 = r10.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0103 }
        r10.endTransaction();	 Catch:{ SQLiteException -> 0x0103 }
        goto L_0x0120;
    L_0x0103:
        r10 = move-exception;
        r11 = e;	 Catch:{ all -> 0x0133 }
    L_0x0106:
        r11.e(r10);	 Catch:{ all -> 0x0133 }
        goto L_0x0120;
    L_0x010a:
        r10 = move-exception;
        goto L_0x0122;
    L_0x010c:
        r10 = move-exception;
        r11 = e;	 Catch:{ all -> 0x010a }
        r11.e(r10);	 Catch:{ all -> 0x010a }
        r10 = r9.d;	 Catch:{ SQLiteException -> 0x011c }
        r10 = r10.getWritableDatabase();	 Catch:{ SQLiteException -> 0x011c }
        r10.endTransaction();	 Catch:{ SQLiteException -> 0x011c }
        goto L_0x0120;
    L_0x011c:
        r10 = move-exception;
        r11 = e;	 Catch:{ all -> 0x0133 }
        goto L_0x0106;
    L_0x0120:
        monitor-exit(r9);
        return;
    L_0x0122:
        r11 = r9.d;	 Catch:{ SQLiteException -> 0x012c }
        r11 = r11.getWritableDatabase();	 Catch:{ SQLiteException -> 0x012c }
        r11.endTransaction();	 Catch:{ SQLiteException -> 0x012c }
        goto L_0x0132;
    L_0x012c:
        r11 = move-exception;
        r0 = e;	 Catch:{ all -> 0x0133 }
        r0.e(r11);	 Catch:{ all -> 0x0133 }
    L_0x0132:
        throw r10;	 Catch:{ all -> 0x0133 }
    L_0x0133:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.b(java.util.List, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    private void c(java.util.List<com.tencent.stat.x> r13, int r14) {
        /*
        r12 = this;
        r0 = 0;
        r1 = r12.d;	 Catch:{ Throwable -> 0x0056 }
        r2 = r1.getReadableDatabase();	 Catch:{ Throwable -> 0x0056 }
        r3 = "events";
        r4 = 0;
        r5 = "status=?";
        r1 = 1;
        r6 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x0056 }
        r7 = java.lang.Integer.toString(r1);	 Catch:{ Throwable -> 0x0056 }
        r11 = 0;
        r6[r11] = r7;	 Catch:{ Throwable -> 0x0056 }
        r7 = 0;
        r8 = 0;
        r9 = "event_id";
        r10 = java.lang.Integer.toString(r14);	 Catch:{ Throwable -> 0x0056 }
        r14 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x0056 }
    L_0x0022:
        r0 = r14.moveToNext();	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        if (r0 == 0) goto L_0x0048;
    L_0x0028:
        r3 = r14.getLong(r11);	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        r0 = r14.getString(r1);	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        r5 = com.tencent.stat.common.k.d(r0);	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        r0 = 2;
        r6 = r14.getInt(r0);	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        r0 = 3;
        r7 = r14.getInt(r0);	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        r0 = new com.tencent.stat.x;	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        r2 = r0;
        r2.<init>(r3, r5, r6, r7);	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        r13.add(r0);	 Catch:{ Throwable -> 0x0051, all -> 0x004e }
        goto L_0x0022;
    L_0x0048:
        if (r14 == 0) goto L_0x0061;
    L_0x004a:
        r14.close();
        return;
    L_0x004e:
        r13 = move-exception;
        r0 = r14;
        goto L_0x0062;
    L_0x0051:
        r13 = move-exception;
        r0 = r14;
        goto L_0x0057;
    L_0x0054:
        r13 = move-exception;
        goto L_0x0062;
    L_0x0056:
        r13 = move-exception;
    L_0x0057:
        r14 = e;	 Catch:{ all -> 0x0054 }
        r14.e(r13);	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0061;
    L_0x005e:
        r0.close();
    L_0x0061:
        return;
    L_0x0062:
        if (r0 == 0) goto L_0x0067;
    L_0x0064:
        r0.close();
    L_0x0067:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.c(java.util.List, int):void");
    }

    private void e() {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            this.d.getWritableDatabase().update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            this.b = (int) DatabaseUtils.queryNumEntries(this.d.getReadableDatabase(), "events");
            StatLogger statLogger = e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Total ");
            stringBuilder.append(this.b);
            stringBuilder.append(" unsent events.");
            statLogger.i(stringBuilder.toString());
        } catch (Throwable th) {
            e.e(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    private void f() {
        /*
        r11 = this;
        r0 = 0;
        r1 = r11.d;	 Catch:{ Throwable -> 0x0033, all -> 0x002e }
        r2 = r1.getReadableDatabase();	 Catch:{ Throwable -> 0x0033, all -> 0x002e }
        r3 = "keyvalues";
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r1 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x0033, all -> 0x002e }
    L_0x0013:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x002c }
        if (r0 == 0) goto L_0x0029;
    L_0x0019:
        r0 = r11.g;	 Catch:{ Throwable -> 0x002c }
        r2 = 0;
        r2 = r1.getString(r2);	 Catch:{ Throwable -> 0x002c }
        r3 = 1;
        r3 = r1.getString(r3);	 Catch:{ Throwable -> 0x002c }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x002c }
        goto L_0x0013;
    L_0x0029:
        if (r1 == 0) goto L_0x0041;
    L_0x002b:
        goto L_0x003e;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0037;
    L_0x002e:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
        goto L_0x0043;
    L_0x0033:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
    L_0x0037:
        r2 = e;	 Catch:{ all -> 0x0042 }
        r2.e(r0);	 Catch:{ all -> 0x0042 }
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();
    L_0x0041:
        return;
    L_0x0042:
        r0 = move-exception;
    L_0x0043:
        if (r1 == 0) goto L_0x0048;
    L_0x0045:
        r1.close();
    L_0x0048:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.f():void");
    }

    public int a() {
        return this.b;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i) {
        this.a.post(new v(this, i));
    }

    /* Access modifiers changed, original: 0000 */
    public void a(e eVar, c cVar) {
        if (StatConfig.isEnableStatService()) {
            try {
                if (Thread.currentThread().getId() == this.a.getLooper().getThread().getId()) {
                    b(eVar, cVar);
                } else {
                    this.a.post(new r(this, eVar, cVar));
                }
            } catch (Throwable th) {
                e.e(th);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(b bVar) {
        if (bVar != null) {
            this.a.post(new s(this, bVar));
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(List<x> list) {
        try {
            if (Thread.currentThread().getId() == this.a.getLooper().getThread().getId()) {
                b((List) list);
            } else {
                this.a.post(new q(this, list));
            }
        } catch (SQLiteException e) {
            e.e(e);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(List<x> list, int i) {
        try {
            if (Thread.currentThread().getId() == this.a.getLooper().getThread().getId()) {
                b((List) list, i);
            } else {
                this.a.post(new p(this, list, i));
            }
        } catch (Throwable th) {
            e.e(th);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Unknown predecessor block by arg (r17_13 ?) in PHI: PHI: (r17_6 ?) = (r17_2 ?), (r17_13 ?), (r17_12 ?) binds: {(r17_2 ?)=B:62:0x0138, (r17_12 ?)=B:55:0x011b}
        	at jadx.core.dex.instructions.PhiInsn.replaceArg(PhiInsn.java:78)
        	at jadx.core.dex.visitors.ssa.SSATransform.inlinePhiInsn(SSATransform.java:392)
        	at jadx.core.dex.visitors.ssa.SSATransform.replacePhiWithMove(SSATransform.java:360)
        	at jadx.core.dex.visitors.ssa.SSATransform.fixPhiWithSameArgs(SSATransform.java:300)
        	at jadx.core.dex.visitors.ssa.SSATransform.fixUselessPhi(SSATransform.java:275)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:61)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public synchronized com.tencent.stat.DeviceInfo b(android.content.Context r20) {
        /*
        r19 = this;
        r1 = r19;
        monitor-enter(r19);
        r2 = r1.c;	 Catch:{ all -> 0x01da }
        if (r2 == 0) goto L_0x000b;	 Catch:{ all -> 0x01da }
        r2 = r1.c;	 Catch:{ all -> 0x01da }
        monitor-exit(r19);
        return r2;
        r3 = r1.d;	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r4 = r3.getReadableDatabase();	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r5 = "user";	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r6 = 0;	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r7 = 0;	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r8 = 0;	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r9 = 0;	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r10 = 0;	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r11 = 0;	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r12 = 0;	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r3 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ Throwable -> 0x01c1, all -> 0x01bd }
        r4 = r3.moveToNext();	 Catch:{ Throwable -> 0x01b8, all -> 0x01b3 }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7 = 0;
        r8 = 1;
        if (r4 == 0) goto L_0x0138;
        r4 = r3.getString(r7);	 Catch:{ Throwable -> 0x0130, all -> 0x0128 }
        r9 = com.tencent.stat.common.k.d(r4);	 Catch:{ Throwable -> 0x0130, all -> 0x0128 }
        r10 = r3.getInt(r8);	 Catch:{ Throwable -> 0x0130, all -> 0x0128 }
        r11 = 2;	 Catch:{ Throwable -> 0x0130, all -> 0x0128 }
        r12 = r3.getString(r11);	 Catch:{ Throwable -> 0x0130, all -> 0x0128 }
        r13 = 3;	 Catch:{ Throwable -> 0x0130, all -> 0x0128 }
        r13 = r3.getLong(r13);	 Catch:{ Throwable -> 0x0130, all -> 0x0128 }
        r15 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0130, all -> 0x0128 }
        r17 = r3;
        r2 = r15 / r5;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r10 == r8) goto L_0x005b;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r13 = r13 * r5;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r13 = com.tencent.stat.common.k.a(r13);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r14 = r2 * r5;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r14 = com.tencent.stat.common.k.a(r14);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r13 = r13.equals(r14);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r13 != 0) goto L_0x005b;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r13 = r8;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x005c;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r13 = r10;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r14 = com.tencent.stat.common.k.r(r20);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r12 = r12.equals(r14);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r12 != 0) goto L_0x0068;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r13 = r13 | 2;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r12 = ",";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r12 = r9.split(r12);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r12 == 0) goto L_0x0093;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r14 = r12.length;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r14 <= 0) goto L_0x0093;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r14 = r12[r7];	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r14 == 0) goto L_0x0082;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r15 = r14.length();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = 11;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r15 >= r5) goto L_0x0080;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x0082;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = r7;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x0099;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = com.tencent.stat.common.k.l(r20);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r5 == 0) goto L_0x0080;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6 = r5.length();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r15 = 10;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r6 <= r15) goto L_0x0080;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r14 = r5;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = r8;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x0099;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = com.tencent.stat.common.k.b(r20);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = r8;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r14 = r9;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r12 == 0) goto L_0x00b5;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6 = r12.length;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r6 < r11) goto L_0x00b5;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6 = r12[r8];	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.<init>();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.append(r14);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r11 = ",";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.append(r11);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.append(r6);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x00d6;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6 = com.tencent.stat.common.k.c(r20);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r6 == 0) goto L_0x00d6;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r11 = r6.length();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r11 <= 0) goto L_0x00d6;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5.<init>();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5.append(r14);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = ",";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5.append(r9);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5.append(r6);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = r5.toString();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = r8;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r11 = new com.tencent.stat.DeviceInfo;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r11.<init>(r14, r6, r13);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r1.c = r11;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6.<init>();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = com.tencent.stat.common.k.c(r9);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r11 = "uid";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6.put(r11, r9);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = "user_type";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r11 = java.lang.Integer.valueOf(r13);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6.put(r9, r11);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = "app_ver";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r11 = com.tencent.stat.common.k.r(r20);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6.put(r9, r11);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = "ts";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6.put(r9, r2);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r5 == 0) goto L_0x0119;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2 = r1.d;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r3 = "user";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = "uid=?";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = new java.lang.String[r8];	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9[r7] = r4;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2.update(r3, r6, r5, r9);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r13 == r10) goto L_0x013b;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2 = r1.d;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r3 = "user";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = 0;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2.replace(r3, r4, r6);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x013b;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r0 = move-exception;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r17 = r3;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2 = r0;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6 = r17;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x01d4;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r0 = move-exception;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r17 = r3;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2 = r0;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6 = r17;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x01c4;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r17 = r3;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r8 = r7;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r8 != 0) goto L_0x01ab;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r2 = com.tencent.stat.common.k.b(r20);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r3 = com.tencent.stat.common.k.c(r20);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r3 == 0) goto L_0x0162;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = r3.length();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        if (r4 <= 0) goto L_0x0162;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4.<init>();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4.append(r2);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = ",";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4.append(r5);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4.append(r3);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x0163;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = r2;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = r5 / r8;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r8 = com.tencent.stat.common.k.r(r20);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.<init>();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = com.tencent.stat.common.k.c(r4);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r10 = "uid";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.put(r10, r4);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = "user_type";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r10 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.put(r4, r10);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = "app_ver";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.put(r4, r8);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = "ts";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r9.put(r4, r5);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = r1.d;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = r4.getWritableDatabase();	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r5 = "user";	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r6 = 0;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4.insert(r5, r6, r9);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4 = new com.tencent.stat.DeviceInfo;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r4.<init>(r2, r3, r7);	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        r1.c = r4;	 Catch:{ Throwable -> 0x01a9, all -> 0x01a7 }
        goto L_0x01ab;
        r0 = move-exception;
        goto L_0x012b;
        r0 = move-exception;
        goto L_0x0133;
        if (r17 == 0) goto L_0x01ce;
        r4 = r17;
        r4.close();	 Catch:{ all -> 0x01da }
        goto L_0x01ce;
        r0 = move-exception;
        r4 = r3;
        r2 = r0;
        r6 = r4;
        goto L_0x01d4;
        r0 = move-exception;
        r4 = r3;
        r2 = r0;
        r6 = r4;
        goto L_0x01c4;
        r0 = move-exception;
        r6 = 0;
        r2 = r0;
        goto L_0x01d4;
        r0 = move-exception;
        r6 = 0;
        r2 = r0;
        r3 = e;	 Catch:{ all -> 0x01d2 }
        r3.e(r2);	 Catch:{ all -> 0x01d2 }
        if (r6 == 0) goto L_0x01ce;
        r6.close();	 Catch:{ all -> 0x01da }
        r2 = r1.c;	 Catch:{ all -> 0x01da }
        monitor-exit(r19);
        return r2;
        r0 = move-exception;
        goto L_0x01bf;
        if (r6 == 0) goto L_0x01d9;
        r6.close();	 Catch:{ all -> 0x01da }
        throw r2;	 Catch:{ all -> 0x01da }
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r19);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.b(android.content.Context):com.tencent.stat.DeviceInfo");
    }

    /* Access modifiers changed, original: 0000 */
    public void c() {
        this.a.post(new t(this));
    }
}
