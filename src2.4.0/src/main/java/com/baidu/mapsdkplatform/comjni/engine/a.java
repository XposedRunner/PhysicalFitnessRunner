package com.baidu.mapsdkplatform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.List;

public class a {
    private static final String a = "a";
    private static SparseArray<List<Handler>> b = new SparseArray();

    public static void a(int i, int i2, int i3, long j) {
        synchronized (b) {
            List<Handler> list = (List) b.get(i);
            if (!(list == null || list.isEmpty())) {
                for (Handler obtain : list) {
                    Message.obtain(obtain, i, i2, i3, Long.valueOf(j)).sendToTarget();
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:15:0x002b, code skipped:
            return;
     */
    public static void a(int r2, android.os.Handler r3) {
        /*
        r0 = b;
        monitor-enter(r0);
        if (r3 != 0) goto L_0x0009;
    L_0x0005:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        return;
    L_0x0007:
        r2 = move-exception;
        goto L_0x002c;
    L_0x0009:
        r1 = b;	 Catch:{ all -> 0x0007 }
        r1 = r1.get(r2);	 Catch:{ all -> 0x0007 }
        r1 = (java.util.List) r1;	 Catch:{ all -> 0x0007 }
        if (r1 == 0) goto L_0x001d;
    L_0x0013:
        r2 = r1.contains(r3);	 Catch:{ all -> 0x0007 }
        if (r2 != 0) goto L_0x002a;
    L_0x0019:
        r1.add(r3);	 Catch:{ all -> 0x0007 }
        goto L_0x002a;
    L_0x001d:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0007 }
        r1.<init>();	 Catch:{ all -> 0x0007 }
        r1.add(r3);	 Catch:{ all -> 0x0007 }
        r3 = b;	 Catch:{ all -> 0x0007 }
        r3.put(r2, r1);	 Catch:{ all -> 0x0007 }
    L_0x002a:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        return;
    L_0x002c:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comjni.engine.a.a(int, android.os.Handler):void");
    }

    public static void b(int i, Handler handler) {
        synchronized (b) {
            if (handler != null) {
                try {
                    handler.removeCallbacksAndMessages(null);
                    List list = (List) b.get(i);
                    if (list != null) {
                        list.remove(handler);
                    }
                } finally {
                }
            }
        }
    }
}
