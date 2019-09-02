package com.umeng.commonsdk.stateless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;

/* compiled from: UMSLNetWorkSender */
public class d {
    public static final int a = 273;
    private static Context b = null;
    private static HandlerThread c = null;
    private static Handler d = null;
    private static Object e = new Object();
    private static final int f = 512;
    private static IntentFilter g;
    private static boolean h;
    private static BroadcastReceiver i = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        d.b = context.getApplicationContext();
                        if (d.b != null) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) d.b.getSystemService("connectivity");
                            if (connectivityManager != null) {
                                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                                    ULog.i("walle", "[stateless] net reveiver disconnected --->>>");
                                    d.h = false;
                                    return;
                                }
                                d.h = true;
                                ULog.i("walle", "[stateless] net reveiver ok --->>>");
                                d.b(d.a);
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
    };

    public d(Context context) {
        synchronized (e) {
            if (context != null) {
                try {
                    b = context.getApplicationContext();
                    if (b != null && c == null) {
                        c = new HandlerThread("SL-NetWorkSender");
                        c.start();
                        if (d == null) {
                            d = new Handler(c.getLooper()) {
                                public void handleMessage(Message message) {
                                    int i = message.what;
                                    if (i == d.a) {
                                        d.e();
                                    } else if (i == d.f) {
                                        d.f();
                                    }
                                }
                            };
                        }
                        if (DeviceConfig.checkPermission(b, "android.permission.ACCESS_NETWORK_STATE")) {
                            ULog.i("walle", "[stateless] begin register receiver");
                            if (g == null) {
                                g = new IntentFilter();
                                g.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                                if (i != null) {
                                    ULog.i("walle", "[stateless] register receiver ok");
                                    b.registerReceiver(i, g);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
    }

    public static void a() {
        b(f);
    }

    public static void a(int i) {
        if (h && d != null) {
            Message obtainMessage = d.obtainMessage();
            obtainMessage.what = i;
            d.sendMessage(obtainMessage);
        }
    }

    public static void b(int i) {
        try {
            if (h && d != null && !d.hasMessages(i)) {
                ULog.i("walle", "[stateless] sendMsgOnce !!!!");
                Message obtainMessage = d.obtainMessage();
                obtainMessage.what = i;
                d.sendMessage(obtainMessage);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(b, th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095 A:{Catch:{ Throwable -> 0x00a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A:{Catch:{ Throwable -> 0x00a7 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0066 */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:13|14|15|16|17|18|19|(2:21|(1:23))(2:24|25)) */
    private static void e() {
        /*
        r0 = h;
        if (r0 == 0) goto L_0x00ae;
    L_0x0004:
        r0 = b;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00ae;
    L_0x000a:
        r0 = b;	 Catch:{ Throwable -> 0x00a7 }
        r0 = com.umeng.commonsdk.stateless.f.a(r0);	 Catch:{ Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x00ad;
    L_0x0012:
        r1 = r0.getParentFile();	 Catch:{ Throwable -> 0x00a7 }
        if (r1 == 0) goto L_0x00ad;
    L_0x0018:
        r1 = r0.getParentFile();	 Catch:{ Throwable -> 0x00a7 }
        r1 = r1.getName();	 Catch:{ Throwable -> 0x00a7 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00a7 }
        if (r1 != 0) goto L_0x00ad;
    L_0x0026:
        r1 = new com.umeng.commonsdk.stateless.e;	 Catch:{ Throwable -> 0x00a7 }
        r2 = b;	 Catch:{ Throwable -> 0x00a7 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00a7 }
        if (r1 == 0) goto L_0x00a1;
    L_0x002f:
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x00a7 }
        r3 = r0.getParentFile();	 Catch:{ Throwable -> 0x00a7 }
        r3 = r3.getName();	 Catch:{ Throwable -> 0x00a7 }
        r4 = 0;
        r3 = android.util.Base64.decode(r3, r4);	 Catch:{ Throwable -> 0x00a7 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00a7 }
        r3 = "walle";
        r5 = 1;
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00a7 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a7 }
        r7.<init>();	 Catch:{ Throwable -> 0x00a7 }
        r8 = "[stateless] handleProcessNext, pathUrl is ";
        r7.append(r8);	 Catch:{ Throwable -> 0x00a7 }
        r7.append(r2);	 Catch:{ Throwable -> 0x00a7 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00a7 }
        r6[r4] = r7;	 Catch:{ Throwable -> 0x00a7 }
        com.umeng.commonsdk.statistics.common.ULog.i(r3, r6);	 Catch:{ Throwable -> 0x00a7 }
        r3 = 0;
        r6 = r0.getAbsolutePath();	 Catch:{ Exception -> 0x0066 }
        r6 = com.umeng.commonsdk.stateless.f.a(r6);	 Catch:{ Exception -> 0x0066 }
        r3 = r6;
    L_0x0066:
        r1 = r1.a(r3, r2);	 Catch:{ Throwable -> 0x00a7 }
        if (r1 == 0) goto L_0x0095;
    L_0x006c:
        r1 = "walle";
        r2 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00a7 }
        r3 = "[stateless] Send envelope file success, delete it.";
        r2[r4] = r3;	 Catch:{ Throwable -> 0x00a7 }
        com.umeng.commonsdk.statistics.common.ULog.i(r1, r2);	 Catch:{ Throwable -> 0x00a7 }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x00a7 }
        r0 = r0.getAbsolutePath();	 Catch:{ Throwable -> 0x00a7 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x00a7 }
        r0 = r1.delete();	 Catch:{ Throwable -> 0x00a7 }
        if (r0 != 0) goto L_0x00a1;
    L_0x0086:
        r0 = "walle";
        r2 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00a7 }
        r3 = "[stateless] Failed to delete already processed file. We try again after delete failed.";
        r2[r4] = r3;	 Catch:{ Throwable -> 0x00a7 }
        com.umeng.commonsdk.statistics.common.ULog.i(r0, r2);	 Catch:{ Throwable -> 0x00a7 }
        r1.delete();	 Catch:{ Throwable -> 0x00a7 }
        goto L_0x00a1;
    L_0x0095:
        r0 = "walle";
        r1 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00a7 }
        r2 = "[stateless] Send envelope file failed, abandon and wait next trigger!";
        r1[r4] = r2;	 Catch:{ Throwable -> 0x00a7 }
        com.umeng.commonsdk.statistics.common.ULog.i(r0, r1);	 Catch:{ Throwable -> 0x00a7 }
        return;
    L_0x00a1:
        r0 = 273; // 0x111 float:3.83E-43 double:1.35E-321;
        b(r0);	 Catch:{ Throwable -> 0x00a7 }
        goto L_0x00ad;
    L_0x00a7:
        r0 = move-exception;
        r1 = b;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r0);
    L_0x00ad:
        return;
    L_0x00ae:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.e():void");
    }

    private static void f() {
        if (g != null) {
            if (i != null) {
                if (b != null) {
                    b.unregisterReceiver(i);
                }
                i = null;
            }
            g = null;
        }
        if (c != null) {
            c.quit();
            if (c != null) {
                c = null;
            }
            if (d != null) {
                d = null;
            }
        }
    }
}
