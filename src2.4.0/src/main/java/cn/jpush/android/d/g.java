package cn.jpush.android.d;

import android.content.Context;
import cn.jpush.android.data.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g {
    public static Queue<c> a;

    /* JADX WARNING: Missing block: B:15:0x001e, code skipped:
            return;
     */
    private static synchronized void a(android.content.Context r2, java.lang.String r3) {
        /*
        r0 = cn.jpush.android.d.g.class;
        monitor-enter(r0);
        if (r2 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r0);
        return;
    L_0x0007:
        r2 = r2.getFilesDir();	 Catch:{ all -> 0x001f }
        if (r2 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r0);
        return;
    L_0x000f:
        r1 = new java.io.File;	 Catch:{ all -> 0x001f }
        r1.<init>(r2, r3);	 Catch:{ all -> 0x001f }
        r2 = r1.exists();	 Catch:{ all -> 0x001f }
        if (r2 == 0) goto L_0x001d;
    L_0x001a:
        r1.delete();	 Catch:{ all -> 0x001f }
    L_0x001d:
        monitor-exit(r0);
        return;
    L_0x001f:
        r2 = move-exception;
        monitor-exit(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.d.g.a(android.content.Context, java.lang.String):void");
    }

    private static synchronized <T> void a(Context context, String str, ArrayList<T> arrayList) {
        StringBuilder stringBuilder;
        synchronized (g.class) {
            if (context == null) {
            } else if (arrayList == null) {
            } else {
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
                    objectOutputStream.writeObject(arrayList);
                    objectOutputStream.close();
                } catch (FileNotFoundException e) {
                    stringBuilder = new StringBuilder("save Objects FileNotFoundException error:");
                    stringBuilder.append(e.getMessage());
                    f.c("MsgQueueUtils", stringBuilder.toString());
                } catch (IOException e2) {
                    stringBuilder = new StringBuilder("save Objects IOException error:");
                    stringBuilder.append(e2.getMessage());
                    f.c("MsgQueueUtils", stringBuilder.toString());
                }
            }
        }
    }

    public static boolean a(Context context, c cVar) {
        if (a == null) {
            a = new ConcurrentLinkedQueue();
            try {
                ArrayList b = b(context, "msg_queue");
                if (!(b == null || b.isEmpty())) {
                    Iterator it = b.iterator();
                    while (it.hasNext()) {
                        a.offer((c) it.next());
                    }
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("init lastMsgQueue failed:");
                stringBuilder.append(e.getMessage());
                f.c("MsgQueueUtils", stringBuilder.toString());
            }
        }
        if (context == null) {
            f.c("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (cVar == null) {
            f.c("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (a.contains(cVar)) {
            return true;
        }
        if (a.size() >= 200) {
            a.poll();
        }
        a.offer(cVar);
        try {
            ArrayList b2 = b(context, "msg_queue");
            if (b2 == null) {
                b2 = new ArrayList();
            }
            if (b2.size() >= 50) {
                b2.remove(0);
            }
            b2.add(cVar);
            a(context, "msg_queue", b2);
            return false;
        } catch (Exception e2) {
            StringBuilder stringBuilder2 = new StringBuilder("msg save in sp failed:");
            stringBuilder2.append(e2.getMessage());
            f.c("MsgQueueUtils", stringBuilder2.toString());
            return false;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0037 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0034 A:{SYNTHETIC, Splitter:B:30:0x0034} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002c A:{SYNTHETIC, Splitter:B:22:0x002c} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0027 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:17|16|19|20|(2:22|23)|24|26|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|15|(0)|32|33) */
    /* JADX WARNING: Missing block: B:18:0x0025, code skipped:
            r5 = th;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r1.close();
     */
    private static synchronized <T> java.util.ArrayList<T> b(android.content.Context r5, java.lang.String r6) {
        /*
        r0 = cn.jpush.android.d.g.class;
        monitor-enter(r0);
        r1 = 0;
        if (r5 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r0);
        return r1;
    L_0x0008:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0038 }
        r2.<init>();	 Catch:{ all -> 0x0038 }
        r3 = new java.io.ObjectInputStream;	 Catch:{ Exception -> 0x0027 }
        r4 = r5.openFileInput(r6);	 Catch:{ Exception -> 0x0027 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0027 }
        r1 = r3.readObject();	 Catch:{ Exception -> 0x0023, all -> 0x0020 }
        r1 = (java.util.ArrayList) r1;	 Catch:{ Exception -> 0x0023, all -> 0x0020 }
        r3.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0030;
    L_0x0020:
        r5 = move-exception;
        r1 = r3;
        goto L_0x0032;
    L_0x0023:
        r1 = r3;
        goto L_0x0027;
    L_0x0025:
        r5 = move-exception;
        goto L_0x0032;
    L_0x0027:
        a(r5, r6);	 Catch:{ all -> 0x0025 }
        if (r1 == 0) goto L_0x002f;
    L_0x002c:
        r1.close();	 Catch:{ IOException -> 0x002f }
    L_0x002f:
        r1 = r2;
    L_0x0030:
        monitor-exit(r0);
        return r1;
    L_0x0032:
        if (r1 == 0) goto L_0x0037;
    L_0x0034:
        r1.close();	 Catch:{ IOException -> 0x0037 }
    L_0x0037:
        throw r5;	 Catch:{ all -> 0x0038 }
    L_0x0038:
        r5 = move-exception;
        monitor-exit(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.d.g.b(android.content.Context, java.lang.String):java.util.ArrayList");
    }
}
