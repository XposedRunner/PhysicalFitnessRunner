package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: UMSysLocationCache */
public class c {
    public static final String a = "lng";
    public static final String b = "lat";
    public static final String c = "ts";
    public static final long d = 30000;
    public static final int e = 200;
    private static final String f = "UMSysLocationCache";
    private static boolean g = true;

    public static void a(final Context context) {
        ULog.i(f, "begin location");
        if (context != null) {
            try {
                new Thread(new Runnable() {
                    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
                    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A:{LOOP_START, SYNTHETIC, LOOP:0: B:0:0x0000->B:22:0x0000, Splitter:B:0:0x0000} */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
                    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|4|5|(8:11|12|13|14|15|16|26|22)(3:24|9|10)|0|1) */
                    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|19) */
                    /* JADX WARNING: Missing block: B:18:?, code skipped:
            com.umeng.commonsdk.proguard.c.a(false);
     */
                    /* JADX WARNING: Missing block: B:19:0x0052, code skipped:
            return;
     */
                    public void run() {
                        /*
                        r6 = this;
                    L_0x0000:
                        r0 = com.umeng.commonsdk.proguard.c.g;	 Catch:{ Throwable -> 0x0053 }
                        if (r0 == 0) goto L_0x0053;
                    L_0x0006:
                        r0 = 0;
                        r1 = r4;	 Catch:{ Throwable -> 0x004f }
                        r1 = com.umeng.commonsdk.proguard.c.b(r1);	 Catch:{ Throwable -> 0x004f }
                        if (r1 == 0) goto L_0x001b;
                    L_0x000f:
                        r1 = r1.length();	 Catch:{ Throwable -> 0x004f }
                        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                        if (r1 < r2) goto L_0x001b;
                    L_0x0017:
                        com.umeng.commonsdk.proguard.c.g = r0;	 Catch:{ Throwable -> 0x004f }
                        return;
                    L_0x001b:
                        r1 = "UMSysLocationCache";
                        r2 = 1;
                        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0053 }
                        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0053 }
                        r3.<init>();	 Catch:{ Throwable -> 0x0053 }
                        r4 = "location status is ok, time is ";
                        r3.append(r4);	 Catch:{ Throwable -> 0x0053 }
                        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0053 }
                        r3.append(r4);	 Catch:{ Throwable -> 0x0053 }
                        r3 = r3.toString();	 Catch:{ Throwable -> 0x0053 }
                        r2[r0] = r3;	 Catch:{ Throwable -> 0x0053 }
                        com.umeng.commonsdk.statistics.common.ULog.i(r1, r2);	 Catch:{ Throwable -> 0x0053 }
                        r0 = new com.umeng.commonsdk.proguard.b;	 Catch:{ Throwable -> 0x0053 }
                        r1 = r4;	 Catch:{ Throwable -> 0x0053 }
                        r0.<init>(r1);	 Catch:{ Throwable -> 0x0053 }
                        r1 = new com.umeng.commonsdk.proguard.c$1$1;	 Catch:{ Throwable -> 0x0053 }
                        r1.<init>(r0);	 Catch:{ Throwable -> 0x0053 }
                        r0.a(r1);	 Catch:{ Throwable -> 0x0053 }
                        r0 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
                        java.lang.Thread.sleep(r0);	 Catch:{ Exception -> 0x0000 }
                        goto L_0x0000;
                    L_0x004f:
                        com.umeng.commonsdk.proguard.c.g = r0;	 Catch:{ Throwable -> 0x0053 }
                        return;
                    L_0x0053:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.c$AnonymousClass1.run():void");
                    }
                }).start();
            } catch (Exception unused) {
            }
        }
    }

    public static JSONArray b(Context context) {
        String str;
        Object[] objArr;
        StringBuilder stringBuilder;
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_common_location", 0);
        JSONArray jSONArray = null;
        if (sharedPreferences == null) {
            return null;
        }
        String string;
        try {
            string = sharedPreferences.getString("location_json_array", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            }
        } catch (JSONException e) {
            str = f;
            objArr = new Object[1];
            stringBuilder = new StringBuilder();
            stringBuilder.append("e is ");
            stringBuilder.append(e);
            objArr[0] = stringBuilder.toString();
            ULog.i(str, objArr);
        } catch (Throwable th) {
            str = f;
            objArr = new Object[1];
            stringBuilder = new StringBuilder();
            stringBuilder.append("e is ");
            stringBuilder.append(th);
            objArr[0] = stringBuilder.toString();
            ULog.i(str, objArr);
        }
        if (jSONArray != null) {
            string = f;
            Object[] objArr2 = new Object[1];
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("get json str is ");
            stringBuilder2.append(jSONArray.toString());
            objArr2[0] = stringBuilder2.toString();
            ULog.i(string, objArr2);
        }
        return jSONArray;
    }

    public static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_common_location", 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                edit.putString("location_json_array", "");
                edit.commit();
                ULog.i(f, "delete is ok~~");
            }
        } catch (Throwable unused) {
        }
    }
}
