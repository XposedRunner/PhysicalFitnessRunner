package cn.jpush.android;

import android.content.Context;
import cn.jiguang.api.SdkType;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public static final String a = SdkType.JPUSH.name();
    public static int b;
    public static String c;
    public static String d;
    public static Context e;
    public static boolean f;
    private static final AtomicInteger g = new AtomicInteger(-1);
    private static final Object h = new Object();

    public static boolean a(Context context) {
        return c(context) == 0;
    }

    public static Context b(Context context) {
        if (e == null && context != null) {
            e = context.getApplicationContext();
            c = context.getPackageName();
        }
        return e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00ac */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            r0 = cn.jpush.client.android.BuildConfig.VERSION_NAME;
            r2 = cn.jiguang.api.MultiSpHelper.getString(r6, "jpush_sdk_version", "");
     */
    /* JADX WARNING: Missing block: B:33:0x00a2, code skipped:
            if (r0.equals(r2) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Missing block: B:34:0x00a4, code skipped:
            android.text.TextUtils.isEmpty(r2);
     */
    /* JADX WARNING: Missing block: B:35:0x00a7, code skipped:
            cn.jiguang.api.MultiSpHelper.commitString(r6, "jpush_sdk_version", r0);
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            r0 = r6.getPackageManager().getApplicationInfo(r6.getPackageName(), 0);
     */
    /* JADX WARNING: Missing block: B:38:0x00b8, code skipped:
            if (r0 == null) goto L_0x00ba;
     */
    /* JADX WARNING: Missing block: B:39:0x00ba, code skipped:
            cn.jpush.android.d.f.d("JPushGlobal", "JPush get NULL appInfo.");
     */
    /* JADX WARNING: Missing block: B:40:0x00c2, code skipped:
            b = r0.icon;
            d = r6.getPackageManager().getApplicationLabel(r0).toString();
     */
    /* JADX WARNING: Missing block: B:41:0x00d5, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:0x00d6, code skipped:
            r3 = new java.lang.StringBuilder("get packageIconId and appName error:");
            r3.append(r0);
            cn.jpush.android.d.f.c("JPushGlobal", r3.toString());
     */
    /* JADX WARNING: Missing block: B:43:0x00e9, code skipped:
            cn.jpush.android.service.ServiceInterface.a(r6);
     */
    /* JADX WARNING: Missing block: B:44:0x00ec, code skipped:
            return 0;
     */
    private static int c(android.content.Context r6) {
        /*
        r0 = g;
        r0 = r0.get();
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = h;
        monitor-enter(r0);
        r2 = g;	 Catch:{ all -> 0x00ed }
        r2 = r2.get();	 Catch:{ all -> 0x00ed }
        if (r2 != 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r0);	 Catch:{ all -> 0x00ed }
        return r1;
    L_0x0017:
        r6 = b(r6);	 Catch:{ all -> 0x00ed }
        r2 = 1;
        if (r6 != 0) goto L_0x0025;
    L_0x001e:
        r6 = g;	 Catch:{ all -> 0x00ed }
        r6.set(r2);	 Catch:{ all -> 0x00ed }
        monitor-exit(r0);	 Catch:{ all -> 0x00ed }
        return r2;
    L_0x0025:
        r3 = "AndroidUtil";
        r4 = "action:checkValidManifest";
        cn.jpush.android.d.f.a(r3, r4);	 Catch:{ all -> 0x00ed }
        r3 = cn.jpush.android.ui.PushActivity.class;
        r3 = cn.jpush.android.d.a.b(r6, r3);	 Catch:{ all -> 0x00ed }
        if (r3 != 0) goto L_0x004f;
    L_0x0034:
        r2 = "AndroidUtil";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r4 = "AndroidManifest.xml missing required activity: ";
        r3.<init>(r4);	 Catch:{ all -> 0x00ed }
        r4 = cn.jpush.android.ui.PushActivity.class;
        r4 = r4.getCanonicalName();	 Catch:{ all -> 0x00ed }
        r3.append(r4);	 Catch:{ all -> 0x00ed }
        r3 = r3.toString();	 Catch:{ all -> 0x00ed }
    L_0x004a:
        cn.jpush.android.d.f.d(r2, r3);	 Catch:{ all -> 0x00ed }
        r2 = r1;
        goto L_0x0084;
    L_0x004f:
        r3 = cn.jpush.android.ui.PopWinActivity.class;
        r3 = cn.jpush.android.d.a.b(r6, r3);	 Catch:{ all -> 0x00ed }
        if (r3 != 0) goto L_0x0077;
    L_0x0057:
        r3 = "AndroidUtil";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r5 = "AndroidManifest.xml missing activity: ";
        r4.<init>(r5);	 Catch:{ all -> 0x00ed }
        r5 = cn.jpush.android.ui.PopWinActivity.class;
        r5 = r5.getCanonicalName();	 Catch:{ all -> 0x00ed }
        r4.append(r5);	 Catch:{ all -> 0x00ed }
        r4 = r4.toString();	 Catch:{ all -> 0x00ed }
        cn.jpush.android.d.f.c(r3, r4);	 Catch:{ all -> 0x00ed }
        r3 = "AndroidUtil";
        r4 = "You will unable to use pop-window rich push type.";
        cn.jpush.android.d.f.c(r3, r4);	 Catch:{ all -> 0x00ed }
    L_0x0077:
        r3 = "cn.jpush.android.ui.PushActivity";
        r3 = cn.jpush.android.d.a.c(r6, r3);	 Catch:{ all -> 0x00ed }
        if (r3 != 0) goto L_0x0084;
    L_0x007f:
        r2 = "AndroidUtil";
        r3 = "AndroidManifest.xml missing required intent filter for PushActivity: cn.jpush.android.ui.PushActivity";
        goto L_0x004a;
    L_0x0084:
        if (r2 != 0) goto L_0x008e;
    L_0x0086:
        r6 = g;	 Catch:{ all -> 0x00ed }
        r1 = 2;
        r6.set(r1);	 Catch:{ all -> 0x00ed }
        monitor-exit(r0);	 Catch:{ all -> 0x00ed }
        return r1;
    L_0x008e:
        r2 = g;	 Catch:{ all -> 0x00ed }
        r2.set(r1);	 Catch:{ all -> 0x00ed }
        monitor-exit(r0);	 Catch:{ all -> 0x00ed }
        r0 = "3.1.7";
        r2 = "jpush_sdk_version";
        r3 = "";
        r2 = cn.jiguang.api.MultiSpHelper.getString(r6, r2, r3);	 Catch:{ Throwable -> 0x00ac }
        r3 = r0.equals(r2);	 Catch:{ Throwable -> 0x00ac }
        if (r3 != 0) goto L_0x00a7;
    L_0x00a4:
        android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x00ac }
    L_0x00a7:
        r2 = "jpush_sdk_version";
        cn.jiguang.api.MultiSpHelper.commitString(r6, r2, r0);	 Catch:{ Throwable -> 0x00ac }
    L_0x00ac:
        r0 = r6.getPackageManager();	 Catch:{ Throwable -> 0x00d5 }
        r2 = r6.getPackageName();	 Catch:{ Throwable -> 0x00d5 }
        r0 = r0.getApplicationInfo(r2, r1);	 Catch:{ Throwable -> 0x00d5 }
        if (r0 != 0) goto L_0x00c2;
    L_0x00ba:
        r0 = "JPushGlobal";
        r2 = "JPush get NULL appInfo.";
        cn.jpush.android.d.f.d(r0, r2);	 Catch:{ Throwable -> 0x00d5 }
        goto L_0x00e9;
    L_0x00c2:
        r2 = r0.icon;	 Catch:{ Throwable -> 0x00d5 }
        b = r2;	 Catch:{ Throwable -> 0x00d5 }
        r2 = r6.getPackageManager();	 Catch:{ Throwable -> 0x00d5 }
        r0 = r2.getApplicationLabel(r0);	 Catch:{ Throwable -> 0x00d5 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00d5 }
        d = r0;	 Catch:{ Throwable -> 0x00d5 }
        goto L_0x00e9;
    L_0x00d5:
        r0 = move-exception;
        r2 = "JPushGlobal";
        r3 = new java.lang.StringBuilder;
        r4 = "get packageIconId and appName error:";
        r3.<init>(r4);
        r3.append(r0);
        r0 = r3.toString();
        cn.jpush.android.d.f.c(r2, r0);
    L_0x00e9:
        cn.jpush.android.service.ServiceInterface.a(r6);
        return r1;
    L_0x00ed:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00ed }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.c(android.content.Context):int");
    }
}
