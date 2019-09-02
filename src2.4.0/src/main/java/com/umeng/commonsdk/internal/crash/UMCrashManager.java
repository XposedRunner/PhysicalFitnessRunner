package com.umeng.commonsdk.internal.crash;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.ULog;

public class UMCrashManager {
    private static boolean isReportCrash;
    private static Object mObject = new Object();

    public static void reportCrash(final Context context, final Throwable th) {
        if (!isReportCrash) {
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("report is ");
            stringBuilder.append(isReportCrash);
            objArr[0] = stringBuilder.toString();
            ULog.i("walle-crash", objArr);
            new Thread(new Runnable() {
                /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00b8 */
                /* JADX WARNING: Can't wrap try/catch for region: R(5:3|4|(2:10|(4:12|13|14|(1:16)))|17|18) */
                public void run() {
                    /*
                    r7 = this;
                    r0 = com.umeng.commonsdk.internal.crash.UMCrashManager.mObject;	 Catch:{ Throwable -> 0x00bd }
                    monitor-enter(r0);	 Catch:{ Throwable -> 0x00bd }
                    r1 = r5;	 Catch:{ all -> 0x00ba }
                    if (r1 == 0) goto L_0x00b8;
                L_0x0009:
                    r1 = r6;	 Catch:{ all -> 0x00ba }
                    if (r1 == 0) goto L_0x00b8;
                L_0x000d:
                    r1 = com.umeng.commonsdk.internal.crash.UMCrashManager.isReportCrash;	 Catch:{ all -> 0x00ba }
                    if (r1 != 0) goto L_0x00b8;
                L_0x0013:
                    r1 = 1;
                    com.umeng.commonsdk.internal.crash.UMCrashManager.isReportCrash = r1;	 Catch:{ all -> 0x00ba }
                    r2 = "walle-crash";
                    r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x00ba }
                    r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ba }
                    r3.<init>();	 Catch:{ all -> 0x00ba }
                    r4 = "report thread is ";
                    r3.append(r4);	 Catch:{ all -> 0x00ba }
                    r4 = com.umeng.commonsdk.internal.crash.UMCrashManager.isReportCrash;	 Catch:{ all -> 0x00ba }
                    r3.append(r4);	 Catch:{ all -> 0x00ba }
                    r3 = r3.toString();	 Catch:{ all -> 0x00ba }
                    r4 = 0;
                    r1[r4] = r3;	 Catch:{ all -> 0x00ba }
                    com.umeng.commonsdk.statistics.common.ULog.i(r2, r1);	 Catch:{ all -> 0x00ba }
                    r1 = r6;	 Catch:{ all -> 0x00ba }
                    r1 = com.umeng.commonsdk.internal.crash.a.a(r1);	 Catch:{ all -> 0x00ba }
                    r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x00ba }
                    if (r2 != 0) goto L_0x00b8;
                L_0x0042:
                    r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ba }
                    r2.<init>();	 Catch:{ all -> 0x00ba }
                    r3 = r5;	 Catch:{ all -> 0x00ba }
                    r3 = r3.getFilesDir();	 Catch:{ all -> 0x00ba }
                    r2.append(r3);	 Catch:{ all -> 0x00ba }
                    r3 = "/";
                    r2.append(r3);	 Catch:{ all -> 0x00ba }
                    r3 = "stateless";
                    r2.append(r3);	 Catch:{ all -> 0x00ba }
                    r3 = "/";
                    r2.append(r3);	 Catch:{ all -> 0x00ba }
                    r3 = "umpx_internal";
                    r3 = r3.getBytes();	 Catch:{ all -> 0x00ba }
                    r3 = android.util.Base64.encodeToString(r3, r4);	 Catch:{ all -> 0x00ba }
                    r2.append(r3);	 Catch:{ all -> 0x00ba }
                    r2 = r2.toString();	 Catch:{ all -> 0x00ba }
                    r3 = r5;	 Catch:{ all -> 0x00ba }
                    r4 = 10;
                    com.umeng.commonsdk.stateless.f.a(r3, r2, r4);	 Catch:{ all -> 0x00ba }
                    r2 = new com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;	 Catch:{ all -> 0x00ba }
                    r2.<init>();	 Catch:{ all -> 0x00ba }
                    r3 = r5;	 Catch:{ all -> 0x00ba }
                    r3 = r2.buildSLBaseHeader(r3);	 Catch:{ all -> 0x00ba }
                    r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00b8 }
                    r4.<init>();	 Catch:{ JSONException -> 0x00b8 }
                    r5 = "content";
                    r4.put(r5, r1);	 Catch:{ JSONException -> 0x00b8 }
                    r1 = "ts";
                    r5 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x00b8 }
                    r4.put(r1, r5);	 Catch:{ JSONException -> 0x00b8 }
                    r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00b8 }
                    r1.<init>();	 Catch:{ JSONException -> 0x00b8 }
                    r5 = "crash";
                    r1.put(r5, r4);	 Catch:{ JSONException -> 0x00b8 }
                    r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00b8 }
                    r4.<init>();	 Catch:{ JSONException -> 0x00b8 }
                    r5 = "tp";
                    r4.put(r5, r1);	 Catch:{ JSONException -> 0x00b8 }
                    r1 = r5;	 Catch:{ JSONException -> 0x00b8 }
                    r5 = "umpx_internal";
                    r1 = r2.buildSLEnvelope(r1, r3, r4, r5);	 Catch:{ JSONException -> 0x00b8 }
                    if (r1 == 0) goto L_0x00b8;
                L_0x00b3:
                    r2 = "exception";
                    r1.has(r2);	 Catch:{ JSONException -> 0x00b8 }
                L_0x00b8:
                    monitor-exit(r0);	 Catch:{ all -> 0x00ba }
                    goto L_0x00bd;
                L_0x00ba:
                    r1 = move-exception;
                    monitor-exit(r0);	 Catch:{ all -> 0x00ba }
                    throw r1;	 Catch:{ Throwable -> 0x00bd }
                L_0x00bd:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.crash.UMCrashManager$AnonymousClass1.run():void");
                }
            }).start();
        }
    }
}
