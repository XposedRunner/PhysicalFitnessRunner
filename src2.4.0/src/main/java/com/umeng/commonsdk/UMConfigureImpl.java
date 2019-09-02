package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.net.HttpUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.a;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.c;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import com.umeng.commonsdk.stateless.f;
import org.json.JSONArray;
import org.json.JSONObject;

public class UMConfigureImpl {
    private static boolean a;
    private static boolean b;

    private static synchronized void a(final Context context) {
        synchronized (UMConfigureImpl.class) {
            if (context != null) {
                try {
                    if (!b) {
                        String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                        String packageName = context.getPackageName();
                        if (!(TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName))) {
                            new Thread(new Runnable() {
                                public void run() {
                                    try {
                                        JSONArray b = c.b(context);
                                        if (b != null && b.length() > 0) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append(context.getFilesDir());
                                            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                                            stringBuilder.append("stateless");
                                            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                                            stringBuilder.append(Base64.encodeToString(a.n.getBytes(), 0));
                                            f.a(context, stringBuilder.toString(), 10);
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("lbs", b);
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("tp", jSONObject);
                                            UMSLEnvelopeBuild uMSLEnvelopeBuild = new UMSLEnvelopeBuild();
                                            uMSLEnvelopeBuild.buildSLEnvelope(context, uMSLEnvelopeBuild.buildSLBaseHeader(context), jSONObject2, a.n);
                                        }
                                    } catch (Exception e) {
                                        UMCrashManager.reportCrash(context, e);
                                    }
                                }
                            }).start();
                        }
                        b = true;
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
        return;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002a */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Missing block: B:13:?, code skipped:
            com.umeng.commonsdk.statistics.common.ULog.e(com.umeng.commonsdk.framework.UMModuleRegister.INNER, new java.lang.Object[]{"get station is null "});
     */
    private static synchronized void b(final android.content.Context r7) {
        /*
        r0 = com.umeng.commonsdk.UMConfigureImpl.class;
        monitor-enter(r0);
        if (r7 == 0) goto L_0x005f;
    L_0x0005:
        r1 = 0;
        r2 = 1;
        r3 = a;	 Catch:{ Throwable -> 0x003a }
        if (r3 != 0) goto L_0x005f;
    L_0x000b:
        r3 = new java.lang.Thread;	 Catch:{ Throwable -> 0x003a }
        r4 = new com.umeng.commonsdk.UMConfigureImpl$2;	 Catch:{ Throwable -> 0x003a }
        r4.<init>(r7);	 Catch:{ Throwable -> 0x003a }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x003a }
        r3.start();	 Catch:{ Throwable -> 0x003a }
        r3 = com.umeng.commonsdk.internal.utils.b.a(r7);	 Catch:{ Throwable -> 0x002a }
        r3 = r3.a();	 Catch:{ Throwable -> 0x002a }
        if (r3 != 0) goto L_0x0035;
    L_0x0022:
        r3 = com.umeng.commonsdk.internal.utils.b.a(r7);	 Catch:{ Throwable -> 0x002a }
        r3.b();	 Catch:{ Throwable -> 0x002a }
        goto L_0x0035;
    L_0x002a:
        r3 = "internal";
        r4 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x003a }
        r5 = "get station is null ";
        r4[r1] = r5;	 Catch:{ Throwable -> 0x003a }
        com.umeng.commonsdk.statistics.common.ULog.e(r3, r4);	 Catch:{ Throwable -> 0x003a }
    L_0x0035:
        a = r2;	 Catch:{ Throwable -> 0x003a }
        goto L_0x005f;
    L_0x0038:
        r7 = move-exception;
        goto L_0x005d;
    L_0x003a:
        r3 = move-exception;
        r4 = "internal";
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0038 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0038 }
        r5.<init>();	 Catch:{ all -> 0x0038 }
        r6 = "e is ";
        r5.append(r6);	 Catch:{ all -> 0x0038 }
        r6 = r3.getMessage();	 Catch:{ all -> 0x0038 }
        r5.append(r6);	 Catch:{ all -> 0x0038 }
        r5 = r5.toString();	 Catch:{ all -> 0x0038 }
        r2[r1] = r5;	 Catch:{ all -> 0x0038 }
        com.umeng.commonsdk.statistics.common.ULog.e(r4, r2);	 Catch:{ all -> 0x0038 }
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r7, r3);	 Catch:{ all -> 0x0038 }
        goto L_0x005f;
    L_0x005d:
        monitor-exit(r0);
        throw r7;
    L_0x005f:
        monitor-exit(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigureImpl.b(android.content.Context):void");
    }

    public static void init(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            b(context);
            a(context);
        }
    }
}
