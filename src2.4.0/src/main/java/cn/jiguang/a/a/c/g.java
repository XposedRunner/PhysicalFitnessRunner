package cn.jiguang.a.a.c;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class g {
    /* JADX WARNING: Removed duplicated region for block: B:27:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047 A:{SYNTHETIC, Splitter:B:18:0x0047} */
    public static void a(android.content.Context r6, int r7) {
        /*
        r0 = "report_notify_state";
        r1 = 0;
        r0 = cn.jiguang.d.a.d.b(r6, r0, r1);
        r0 = (java.lang.String) r0;
        r2 = new cn.jiguang.a.a.c.g;
        r2.<init>();
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 24;
        if (r2 < r3) goto L_0x0019;
    L_0x0014:
        r2 = a(r6);
        goto L_0x001d;
    L_0x0019:
        r2 = b(r6);
    L_0x001d:
        r3 = android.text.TextUtils.isEmpty(r0);
        r4 = 1;
        r5 = 0;
        if (r3 == 0) goto L_0x0027;
    L_0x0025:
        r0 = r4;
        goto L_0x0045;
    L_0x0027:
        r3 = "ON";
        r3 = android.text.TextUtils.equals(r3, r0);
        if (r3 == 0) goto L_0x0032;
    L_0x002f:
        r3 = r4;
        r0 = r5;
        goto L_0x003f;
    L_0x0032:
        r3 = "OFF";
        r0 = android.text.TextUtils.equals(r3, r0);
        if (r0 == 0) goto L_0x003d;
    L_0x003a:
        r0 = r5;
        r3 = r0;
        goto L_0x003f;
    L_0x003d:
        r0 = r4;
        r3 = r5;
    L_0x003f:
        if (r0 != 0) goto L_0x0045;
    L_0x0041:
        if (r3 == r2) goto L_0x0044;
    L_0x0043:
        goto L_0x0025;
    L_0x0044:
        r0 = r5;
    L_0x0045:
        if (r0 == 0) goto L_0x0082;
    L_0x0047:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0082 }
        r0.<init>();	 Catch:{ Throwable -> 0x0082 }
        r3 = "notification_state";
        r0.put(r3, r2);	 Catch:{ Throwable -> 0x0082 }
        r3 = "";
        r3 = cn.jiguang.g.a.d(r6, r3);	 Catch:{ Throwable -> 0x0082 }
        r4 = "imei";
        r3 = cn.jiguang.g.a.d(r6, r3);	 Catch:{ Throwable -> 0x0082 }
        r0.put(r4, r3);	 Catch:{ Throwable -> 0x0082 }
        r3 = "device_id";
        r4 = cn.jiguang.g.a.i(r6);	 Catch:{ Throwable -> 0x0082 }
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0082 }
        r3 = "trigger_scene";
        r0.put(r3, r7);	 Catch:{ Throwable -> 0x0082 }
        r7 = "android_notification_state";
        cn.jiguang.d.d.x.a(r1, r0, r7);	 Catch:{ Throwable -> 0x0082 }
        cn.jiguang.api.JCoreInterface.report(r6, r0, r5);	 Catch:{ Throwable -> 0x0082 }
        if (r2 == 0) goto L_0x007b;
    L_0x0078:
        r7 = "ON";
        goto L_0x007d;
    L_0x007b:
        r7 = "OFF";
    L_0x007d:
        r0 = "report_notify_state";
        cn.jiguang.d.a.d.a(r6, r0, r7);	 Catch:{ Throwable -> 0x0082 }
    L_0x0082:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.g.a(android.content.Context, int):void");
    }

    @TargetApi(24)
    private static boolean a(Context context) {
        try {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean b(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            return ((Integer) Class.forName(AppOpsManager.class.getName()).getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) Class.forName(AppOpsManager.class.getName()).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() == 0;
        } catch (Throwable unused) {
            return true;
        }
    }
}
