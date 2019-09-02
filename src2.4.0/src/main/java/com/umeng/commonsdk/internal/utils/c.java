package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* compiled from: BatteryUtils */
public class c {
    private static final String a = "BatteryUtils";
    private static boolean b;
    private static Context c;
    private BroadcastReceiver d;

    /* compiled from: BatteryUtils */
    private static class a {
        private static final c a = new c();

        private a() {
        }
    }

    private c() {
        this.d = new BroadcastReceiver() {
            /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
            /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001d */
            /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x006d */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
            /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003c */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0028 */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
            /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            public void onReceive(android.content.Context r7, android.content.Intent r8) {
                /*
                r6 = this;
                r0 = r8.getAction();	 Catch:{ Throwable -> 0x0096 }
                r1 = "android.intent.action.BATTERY_CHANGED";
                r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x0096 }
                if (r0 == 0) goto L_0x009e;
            L_0x000c:
                r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0096 }
                r0.<init>();	 Catch:{ Throwable -> 0x0096 }
                r1 = "level";
                r2 = 0;
                r1 = r8.getIntExtra(r1, r2);	 Catch:{ Throwable -> 0x0096 }
                r3 = "le";
                r0.put(r3, r1);	 Catch:{ Exception -> 0x001d }
            L_0x001d:
                r1 = "voltage";
                r1 = r8.getIntExtra(r1, r2);	 Catch:{ Throwable -> 0x0096 }
                r3 = "vol";
                r0.put(r3, r1);	 Catch:{ Exception -> 0x0028 }
            L_0x0028:
                r1 = "temperature";
                r1 = r8.getIntExtra(r1, r2);	 Catch:{ Throwable -> 0x0096 }
                r3 = "temp";
                r0.put(r3, r1);	 Catch:{ Exception -> 0x003c }
                r1 = "ts";
                r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x003c }
                r0.put(r1, r3);	 Catch:{ Exception -> 0x003c }
            L_0x003c:
                r1 = "status";
                r1 = r8.getIntExtra(r1, r2);	 Catch:{ Throwable -> 0x0096 }
                r3 = 2;
                r4 = -1;
                r5 = 1;
                switch(r1) {
                    case 1: goto L_0x004e;
                    case 2: goto L_0x004d;
                    case 3: goto L_0x004e;
                    case 4: goto L_0x004b;
                    case 5: goto L_0x0049;
                    default: goto L_0x0048;
                };
            L_0x0048:
                goto L_0x004e;
            L_0x0049:
                r4 = r3;
                goto L_0x004e;
            L_0x004b:
                r4 = r2;
                goto L_0x004e;
            L_0x004d:
                r4 = r5;
            L_0x004e:
                r1 = "st";
                r0.put(r1, r4);	 Catch:{ Exception -> 0x0053 }
            L_0x0053:
                r1 = "plugged";
                r8 = r8.getIntExtra(r1, r2);	 Catch:{ Throwable -> 0x0096 }
                switch(r8) {
                    case 1: goto L_0x005e;
                    case 2: goto L_0x005f;
                    default: goto L_0x005c;
                };
            L_0x005c:
                r3 = r2;
                goto L_0x005f;
            L_0x005e:
                r3 = r5;
            L_0x005f:
                r8 = "ct";
                r0.put(r8, r3);	 Catch:{ Exception -> 0x006d }
                r8 = "ts";
                r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x006d }
                r0.put(r8, r3);	 Catch:{ Exception -> 0x006d }
            L_0x006d:
                r8 = "BatteryUtils";
                r1 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0096 }
                r3 = r0.toString();	 Catch:{ Throwable -> 0x0096 }
                r1[r2] = r3;	 Catch:{ Throwable -> 0x0096 }
                com.umeng.commonsdk.statistics.common.ULog.i(r8, r1);	 Catch:{ Throwable -> 0x0096 }
                r8 = 32771; // 0x8003 float:4.5922E-41 double:1.6191E-319;
                r1 = com.umeng.commonsdk.internal.utils.c.c;	 Catch:{ Throwable -> 0x0096 }
                r1 = com.umeng.commonsdk.internal.b.a(r1);	 Catch:{ Throwable -> 0x0096 }
                r1 = r1.a();	 Catch:{ Throwable -> 0x0096 }
                r0 = r0.toString();	 Catch:{ Throwable -> 0x0096 }
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r7, r8, r1, r0);	 Catch:{ Throwable -> 0x0096 }
                r7 = com.umeng.commonsdk.internal.utils.c.this;	 Catch:{ Throwable -> 0x0096 }
                r7.c();	 Catch:{ Throwable -> 0x0096 }
                goto L_0x009e;
            L_0x0096:
                r7 = move-exception;
                r8 = com.umeng.commonsdk.internal.utils.c.c;
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r8, r7);
            L_0x009e:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.c$AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a(Context context) {
        if (c == null && context != null) {
            c = context.getApplicationContext();
        }
        return a.a;
    }

    public synchronized boolean a() {
        return b;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            c.registerReceiver(this.d, intentFilter);
            b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(c, th);
        }
        return;
    }

    public synchronized void c() {
        try {
            c.unregisterReceiver(this.d);
            b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(c, th);
        }
        return;
    }
}
