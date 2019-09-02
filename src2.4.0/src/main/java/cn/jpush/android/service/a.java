package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.f;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.data.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a {
    private static volatile a a;
    private static ExecutorService b = Executors.newSingleThreadExecutor();
    private static final Object f = new Object();
    private Handler c;
    private Context d;
    private String e;

    private a(Context context) {
        this.c = null;
        this.d = null;
        this.e = "";
        this.c = new Handler(Looper.getMainLooper());
        this.d = context;
        this.e = this.d.getPackageName();
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (f) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Missing block: B:12:0x001d, code skipped:
            return;
     */
    private synchronized void a(long r3, long r5) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.c;	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x001c;
    L_0x0005:
        r0 = new cn.jpush.android.service.c;	 Catch:{ all -> 0x001e }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x001e }
        r3 = 0;
        r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r1 > 0) goto L_0x0017;
    L_0x0010:
        r3 = r2.c;	 Catch:{ all -> 0x001e }
        r3.post(r0);	 Catch:{ all -> 0x001e }
        monitor-exit(r2);
        return;
    L_0x0017:
        r3 = r2.c;	 Catch:{ all -> 0x001e }
        r3.postDelayed(r0, r5);	 Catch:{ all -> 0x001e }
    L_0x001c:
        monitor-exit(r2);
        return;
    L_0x001e:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.a.a(long, long):void");
    }

    private void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(JPushInterface.ACTION_NOTIFICATION_RECEIVED_PROXY);
        intent.putExtra("senderId", str3);
        intent.putExtra("appId", str2);
        intent.putExtra("message", str);
        intent.putExtra("notificaion_type", 1);
        intent.addCategory(str2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(".permission.JPUSH_MESSAGE");
        context.sendOrderedBroadcast(intent, stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A:{Catch:{ all -> 0x0063 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A:{Catch:{ all -> 0x0063 }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A:{Catch:{ all -> 0x0063 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A:{Catch:{ all -> 0x0063 }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A:{SKIP} */
    private synchronized boolean a(android.content.Context r18, cn.jpush.android.data.JPushLocalNotification r19) {
        /*
        r17 = this;
        r1 = r17;
        monitor-enter(r17);
        r2 = "JPushLocalNotificationCenter";
        r3 = "add LocalNotification";
        cn.jpush.android.d.f.a(r2, r3);	 Catch:{ all -> 0x0063 }
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0063 }
        r2 = r19.getBroadcastTime();	 Catch:{ all -> 0x0063 }
        r11 = r2 - r13;
        cn.jpush.android.service.ServiceInterface.d(r18);	 Catch:{ all -> 0x0063 }
        r5 = r19.getNotificationId();	 Catch:{ all -> 0x0063 }
        r4 = cn.jpush.android.data.d.a(r18);	 Catch:{ Exception -> 0x0049 }
        r2 = 0;
        r2 = r4.a(r5, r2);	 Catch:{ Exception -> 0x0049 }
        if (r2 == 0) goto L_0x0037;
    L_0x0026:
        r7 = 1;
        r8 = 0;
        r9 = 0;
        r10 = r19.toJSON();	 Catch:{ Exception -> 0x0049 }
        r2 = r19.getBroadcastTime();	 Catch:{ Exception -> 0x0049 }
        r15 = r11;
        r11 = r2;
        r4.b(r5, r7, r8, r9, r10, r11, r13);	 Catch:{ Exception -> 0x0047 }
        goto L_0x004f;
    L_0x0037:
        r15 = r11;
        r7 = 1;
        r8 = 0;
        r9 = 0;
        r10 = r19.toJSON();	 Catch:{ Exception -> 0x0047 }
        r11 = r19.getBroadcastTime();	 Catch:{ Exception -> 0x0047 }
        r4.a(r5, r7, r8, r9, r10, r11, r13);	 Catch:{ Exception -> 0x0047 }
        goto L_0x004f;
    L_0x0047:
        r0 = move-exception;
        goto L_0x004b;
    L_0x0049:
        r0 = move-exception;
        r15 = r11;
    L_0x004b:
        r2 = r0;
        r2.printStackTrace();	 Catch:{ all -> 0x0063 }
    L_0x004f:
        r2 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r4 = r15;
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        r2 = 1;
        if (r6 >= 0) goto L_0x0061;
    L_0x0058:
        r6 = r19.getNotificationId();	 Catch:{ all -> 0x0063 }
        r1.a(r6, r4);	 Catch:{ all -> 0x0063 }
        monitor-exit(r17);
        return r2;
    L_0x0061:
        monitor-exit(r17);
        return r2;
    L_0x0063:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r17);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.a.a(android.content.Context, cn.jpush.android.data.JPushLocalNotification):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A:{SYNTHETIC, Splitter:B:30:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0080 A:{SYNTHETIC, Splitter:B:36:0x0080} */
    private synchronized void e(android.content.Context r15) {
        /*
        r14 = this;
        monitor-enter(r14);
        r11 = cn.jpush.android.data.d.a(r15);	 Catch:{ all -> 0x0089 }
        r12 = 0;
        r0 = r11.a(r12);	 Catch:{ all -> 0x0089 }
        if (r0 == 0) goto L_0x0087;
    L_0x000c:
        r0 = 0;
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x005c }
        r3 = 1;
        r13 = r11.a(r3, r1);	 Catch:{ Exception -> 0x005c }
        r0 = r13.moveToFirst();	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        if (r0 == 0) goto L_0x004a;
    L_0x001c:
        r0 = cn.jpush.android.data.d.a(r13);	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        if (r0 == 0) goto L_0x0044;
    L_0x0022:
        r1 = r0.d();	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        r2 = r14.e;	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        r3 = "";
        r14.a(r15, r1, r2, r3);	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        r1 = r0.a();	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = r0.d();	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        r7 = r0.f();	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        r9 = r0.e();	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        r0 = r11;
        r0.b(r1, r3, r4, r5, r6, r7, r9);	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
    L_0x0044:
        r0 = r13.moveToNext();	 Catch:{ Exception -> 0x0056, all -> 0x0054 }
        if (r0 != 0) goto L_0x001c;
    L_0x004a:
        if (r13 == 0) goto L_0x004f;
    L_0x004c:
        r13.close();	 Catch:{ all -> 0x0089 }
    L_0x004f:
        r11.b(r12);	 Catch:{ all -> 0x0089 }
        monitor-exit(r14);
        return;
    L_0x0054:
        r15 = move-exception;
        goto L_0x007e;
    L_0x0056:
        r15 = move-exception;
        r0 = r13;
        goto L_0x005d;
    L_0x0059:
        r15 = move-exception;
        r13 = r0;
        goto L_0x007e;
    L_0x005c:
        r15 = move-exception;
    L_0x005d:
        r1 = "JPushLocalNotificationCenter";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0059 }
        r3 = "triggerLNKillProcess: ";
        r2.<init>(r3);	 Catch:{ all -> 0x0059 }
        r15 = r15.getMessage();	 Catch:{ all -> 0x0059 }
        r2.append(r15);	 Catch:{ all -> 0x0059 }
        r15 = r2.toString();	 Catch:{ all -> 0x0059 }
        cn.jpush.android.d.f.c(r1, r15);	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x0079;
    L_0x0076:
        r0.close();	 Catch:{ all -> 0x0089 }
    L_0x0079:
        r11.b(r12);	 Catch:{ all -> 0x0089 }
        monitor-exit(r14);
        return;
    L_0x007e:
        if (r13 == 0) goto L_0x0083;
    L_0x0080:
        r13.close();	 Catch:{ all -> 0x0089 }
    L_0x0083:
        r11.b(r12);	 Catch:{ all -> 0x0089 }
        throw r15;	 Catch:{ all -> 0x0089 }
    L_0x0087:
        monitor-exit(r14);
        return;
    L_0x0089:
        r15 = move-exception;
        monitor-exit(r14);
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.a.e(android.content.Context):void");
    }

    public final synchronized boolean a(Context context, long j) {
        f.a("JPushLocalNotificationCenter", "remove LocalNotification ");
        j = (long) ((int) j);
        try {
            d a = d.a(context);
            if (a.a(j, 0) == null) {
                return false;
            }
            a.a(j);
            JPushInterface.clearNotificationById(this.d, (int) j);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification, boolean z) {
        if (z) {
            try {
                a(context, jPushLocalNotification);
            } catch (Throwable th) {
            }
        } else {
            Bundle bundle = new Bundle();
            e.a(context, bundle, "intent.MULTI_PROCESS");
            bundle.putInt("multi_type", 6);
            bundle.putSerializable("local_notification", jPushLocalNotification);
            JCoreInterface.sendAction(context, cn.jpush.android.a.a, bundle);
        }
        return true;
    }

    public final synchronized void b(Context context) {
        f.a("JPushLocalNotificationCenter", "clear all local notification ");
        int[] a = d.a(context).a();
        if (a != null && a.length > 0) {
            for (int clearNotificationById : a) {
                JPushInterface.clearNotificationById(this.d, clearNotificationById);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a A:{SYNTHETIC, Splitter:B:27:0x004a} */
    public final synchronized void c(android.content.Context r12) {
        /*
        r11 = this;
        monitor-enter(r11);
        r12 = cn.jpush.android.data.d.a(r12);	 Catch:{ all -> 0x005d }
        r0 = 0;
        r1 = r12.a(r0);	 Catch:{ all -> 0x005d }
        if (r1 == 0) goto L_0x005b;
    L_0x000c:
        r1 = 0;
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0051, all -> 0x0045 }
        r4 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r4 = r12.a(r2, r4);	 Catch:{ Exception -> 0x0051, all -> 0x0045 }
        r1 = r4.moveToFirst();	 Catch:{ Exception -> 0x0043, all -> 0x0041 }
        if (r1 == 0) goto L_0x0037;
    L_0x001e:
        r1 = cn.jpush.android.data.d.a(r4);	 Catch:{ Exception -> 0x0043, all -> 0x0041 }
        if (r1 == 0) goto L_0x0031;
    L_0x0024:
        r5 = r1.a();	 Catch:{ Exception -> 0x0043, all -> 0x0041 }
        r7 = r1.f();	 Catch:{ Exception -> 0x0043, all -> 0x0041 }
        r9 = r7 - r2;
        r11.a(r5, r9);	 Catch:{ Exception -> 0x0043, all -> 0x0041 }
    L_0x0031:
        r1 = r4.moveToNext();	 Catch:{ Exception -> 0x0043, all -> 0x0041 }
        if (r1 != 0) goto L_0x001e;
    L_0x0037:
        if (r4 == 0) goto L_0x003c;
    L_0x0039:
        r4.close();	 Catch:{ all -> 0x005d }
    L_0x003c:
        r12.b(r0);	 Catch:{ all -> 0x005d }
        monitor-exit(r11);
        return;
    L_0x0041:
        r1 = move-exception;
        goto L_0x0048;
    L_0x0043:
        r1 = r4;
        goto L_0x0051;
    L_0x0045:
        r2 = move-exception;
        r4 = r1;
        r1 = r2;
    L_0x0048:
        if (r4 == 0) goto L_0x004d;
    L_0x004a:
        r4.close();	 Catch:{ all -> 0x005d }
    L_0x004d:
        r12.b(r0);	 Catch:{ all -> 0x005d }
        throw r1;	 Catch:{ all -> 0x005d }
    L_0x0051:
        if (r1 == 0) goto L_0x0056;
    L_0x0053:
        r1.close();	 Catch:{ all -> 0x005d }
    L_0x0056:
        r12.b(r0);	 Catch:{ all -> 0x005d }
        monitor-exit(r11);
        return;
    L_0x005b:
        monitor-exit(r11);
        return;
    L_0x005d:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.a.c(android.content.Context):void");
    }

    public final void d(Context context) {
        b.execute(new b(this, context));
    }
}
