package com.umeng.commonsdk.internal;

import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.tencent.stat.DeviceInfo;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.framework.c;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.internal.utils.l;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.e;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMInternalManager */
public class d {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("f", a.c());
            jSONObject.put("t", a.d());
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void a(Context context) {
        try {
            ULog.i("walle", new Object[]{"[internal] workEvent send envelope"});
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i_sdk_v", a.d);
            jSONObject = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, e(context));
            if (jSONObject != null && !jSONObject.has(c.c)) {
                ULog.i("walle", new Object[]{"[internal] workEvent send envelope back, result is ok"});
                a.f(context);
                j.d(context);
                com.umeng.commonsdk.proguard.c.c(context);
            }
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (context != null) {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
                a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
                a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
                a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
                a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
            }
        }
    }

    private static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    jSONObject.put(str, 1);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put(str, 0);
        }
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray;
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            if (VERSION.SDK_INT >= 14) {
                jSONObject.put("a_rv", Build.getRadioVersion());
            }
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            int i = 0;
            if (VERSION.SDK_INT >= 21) {
                jSONArray = new JSONArray();
                for (Object put : Build.SUPPORTED_32_BIT_ABIS) {
                    jSONArray.put(put);
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (VERSION.SDK_INT >= 21) {
                jSONArray = new JSONArray();
                for (Object put2 : Build.SUPPORTED_64_BIT_ABIS) {
                    jSONArray.put(put2);
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    jSONObject.put("a_s64", jSONArray);
                }
            }
            if (VERSION.SDK_INT >= 21) {
                jSONArray = new JSONArray();
                while (i < Build.SUPPORTED_ABIS.length) {
                    jSONArray.put(Build.SUPPORTED_ABIS[i]);
                    i++;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    jSONObject.put("a_sa", jSONArray);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", EnvironmentCompat.MEDIA_UNKNOWN);
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", VERSION.BASE_OS);
                jSONObject.put("a_pre", VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", VERSION.CODENAME);
            jSONObject.put("a_intl", VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void b(Context context) {
        ULog.i("walle", new Object[]{"[internal] begin by stateful--->>>"});
        if (context != null) {
            try {
                if (UMEnvelopeBuild.isReadyBuild(context, UMBusinessType.U_INTERNAL)) {
                    UMWorkDispatch.sendEvent(context, a.e, b.a(context).a(), null);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a = l.a(context);
            if (!TextUtils.isEmpty(a)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(a);
                    if (jSONObject2 != null) {
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        if (jSONObject2.has("_gdf_r")) {
                            jSONObject.put("_gdf_r", jSONObject2.opt("_gdf_r"));
                        }
                        if (jSONObject2.has("_thm_z")) {
                            jSONObject.put("_thm_z", jSONObject2.opt("_thm_z"));
                        }
                        if (jSONObject2.has("_dsk_s")) {
                            jSONObject.put("_dsk_s", jSONObject2.opt("_dsk_s"));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tot_s", a.h());
            jSONObject.put("ava_s", a.i());
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0068 */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|4|(3:8|9|(1:11))|12|13|20) */
    public static void c(android.content.Context r10) {
        /*
        if (r10 == 0) goto L_0x00c5;
    L_0x0002:
        r0 = "walle";
        r1 = 1;
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00be }
        r3 = "[internal] begin by not stateful--->>>";
        r4 = 0;
        r2[r4] = r3;	 Catch:{ Throwable -> 0x00be }
        com.umeng.commonsdk.statistics.common.ULog.i(r0, r2);	 Catch:{ Throwable -> 0x00be }
        r0 = r10.getApplicationContext();	 Catch:{ Throwable -> 0x00be }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bc }
        r10.<init>();	 Catch:{ Throwable -> 0x00bc }
        r2 = r0.getFilesDir();	 Catch:{ Throwable -> 0x00bc }
        r10.append(r2);	 Catch:{ Throwable -> 0x00bc }
        r2 = "/";
        r10.append(r2);	 Catch:{ Throwable -> 0x00bc }
        r2 = "stateless";
        r10.append(r2);	 Catch:{ Throwable -> 0x00bc }
        r2 = "/";
        r10.append(r2);	 Catch:{ Throwable -> 0x00bc }
        r2 = "umpx_internal";
        r2 = r2.getBytes();	 Catch:{ Throwable -> 0x00bc }
        r2 = android.util.Base64.encodeToString(r2, r4);	 Catch:{ Throwable -> 0x00bc }
        r10.append(r2);	 Catch:{ Throwable -> 0x00bc }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x00bc }
        r2 = 10;
        com.umeng.commonsdk.stateless.f.a(r0, r10, r2);	 Catch:{ Throwable -> 0x00bc }
        r10 = new com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;	 Catch:{ Throwable -> 0x00bc }
        r10.<init>();	 Catch:{ Throwable -> 0x00bc }
        r2 = r10.buildSLBaseHeader(r0);	 Catch:{ Throwable -> 0x00bc }
        if (r2 == 0) goto L_0x0068;
    L_0x004f:
        r3 = "header";
        r3 = r2.has(r3);	 Catch:{ Throwable -> 0x00bc }
        if (r3 == 0) goto L_0x0068;
    L_0x0057:
        r3 = "header";
        r3 = r2.opt(r3);	 Catch:{ Exception -> 0x0068 }
        r3 = (org.json.JSONObject) r3;	 Catch:{ Exception -> 0x0068 }
        if (r3 == 0) goto L_0x0068;
    L_0x0061:
        r5 = "i_sdk_v";
        r6 = "1.2.0";
        r3.put(r5, r6);	 Catch:{ Exception -> 0x0068 }
    L_0x0068:
        r3 = "walle";
        r5 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00bc }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bc }
        r6.<init>();	 Catch:{ Throwable -> 0x00bc }
        r7 = "[internal] header is ";
        r6.append(r7);	 Catch:{ Throwable -> 0x00bc }
        r7 = r2.toString();	 Catch:{ Throwable -> 0x00bc }
        r6.append(r7);	 Catch:{ Throwable -> 0x00bc }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x00bc }
        r5[r4] = r6;	 Catch:{ Throwable -> 0x00bc }
        com.umeng.commonsdk.statistics.common.ULog.i(r3, r5);	 Catch:{ Throwable -> 0x00bc }
        r3 = d(r0);	 Catch:{ Throwable -> 0x00bc }
        r5 = "walle";
        r6 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00bc }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bc }
        r7.<init>();	 Catch:{ Throwable -> 0x00bc }
        r8 = "[internal] body is ";
        r7.append(r8);	 Catch:{ Throwable -> 0x00bc }
        r8 = r3.toString();	 Catch:{ Throwable -> 0x00bc }
        r7.append(r8);	 Catch:{ Throwable -> 0x00bc }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00bc }
        r6[r4] = r7;	 Catch:{ Throwable -> 0x00bc }
        com.umeng.commonsdk.statistics.common.ULog.i(r5, r6);	 Catch:{ Throwable -> 0x00bc }
        r5 = "umpx_internal";
        r10 = r10.buildSLEnvelope(r0, r2, r3, r5);	 Catch:{ Throwable -> 0x00bc }
        r2 = "walle";
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00bc }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x00bc }
        r1[r4] = r10;	 Catch:{ Throwable -> 0x00bc }
        com.umeng.commonsdk.statistics.common.ULog.i(r2, r1);	 Catch:{ Throwable -> 0x00bc }
        goto L_0x00c5;
    L_0x00bc:
        r10 = move-exception;
        goto L_0x00c2;
    L_0x00be:
        r0 = move-exception;
        r9 = r0;
        r0 = r10;
        r10 = r9;
    L_0x00c2:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r10);
    L_0x00c5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.c(android.content.Context):void");
    }

    private static JSONObject d() {
        try {
            com.umeng.commonsdk.internal.utils.d.a a = com.umeng.commonsdk.internal.utils.d.a();
            if (a == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", a.a);
                jSONObject.put("pla", a.b);
                jSONObject.put("cpus", a.c);
                jSONObject.put("fea", a.d);
                jSONObject.put("imp", a.e);
                jSONObject.put("arc", a.f);
                jSONObject.put("var", a.g);
                jSONObject.put("par", a.h);
                jSONObject.put("rev", a.i);
                jSONObject.put("har", a.j);
                jSONObject.put("rev", a.k);
                jSONObject.put("ser", a.l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            String k;
            context = context.getApplicationContext();
            try {
                JSONArray p = p(context);
                if (p != null && p.length() > 0) {
                    jSONObject2.put("run_server", p);
                }
            } catch (Exception e) {
                try {
                    UMCrashManager.reportCrash(context, e);
                } catch (Exception unused) {
                }
            }
            try {
                k = a.k(context);
                if (!TextUtils.isEmpty(k)) {
                    jSONObject2.put("imsi", k);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
            try {
                k = a.l(context);
                if (!TextUtils.isEmpty(k)) {
                    jSONObject2.put("meid", k);
                }
            } catch (Exception e22) {
                UMCrashManager.reportCrash(context, e22);
            }
            try {
                jSONObject.put(UMModuleRegister.INNER, jSONObject2);
            } catch (JSONException e3) {
                UMCrashManager.reportCrash(context, e3);
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:157:0x01b1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x0101 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:163:0x01c2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00b5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x0112 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Can't wrap try/catch for region: R(68:2|3|4|(1:8)|11|12|(1:16)|19|20|(1:24)|27|28|31|32|35|36|(1:40)|43|44|(1:48)|51|52|(2:56|57)|58|59|(2:63|64)|65|66|69|70|(1:74)|77|78|(1:82)|85|86|(2:90|91)|92|93|(2:97|98)|99|100|103|104|(1:108)|111|112|(1:116)|119|120|(1:124)|127|128|(1:132)|135|136|(1:140)|143|144|(1:148)|151|152|(1:156)|157|158|(1:162)|163|164) */
    /* JADX WARNING: Can't wrap try/catch for region: R(44:2|(3:3|4|(1:8))|(3:11|12|(1:16))|19|20|(1:24)|27|28|31|32|(3:35|36|(1:40))|43|44|(1:48)|(8:51|52|(2:56|57)|58|59|(2:63|64)|65|66)|69|70|(1:74)|77|78|(1:82)|(8:85|86|(2:90|91)|92|93|(2:97|98)|99|100)|103|104|(1:108)|111|112|(1:116)|(3:119|120|(1:124))|127|128|(1:132)|135|136|(1:140)|(3:143|144|(1:148))|151|152|(1:156)|157|158|(1:162)|163|164) */
    /* JADX WARNING: Missing block: B:165:0x01c8, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:166:0x01c9, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
     */
    public static org.json.JSONObject e(android.content.Context r5) {
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = new org.json.JSONObject;
        r1.<init>();
        if (r5 == 0) goto L_0x01cc;
    L_0x000c:
        r5 = r5.getApplicationContext();
        r2 = p(r5);	 Catch:{ Exception -> 0x0022 }
        if (r2 == 0) goto L_0x0026;
    L_0x0016:
        r3 = r2.length();	 Catch:{ Exception -> 0x0022 }
        if (r3 <= 0) goto L_0x0026;
    L_0x001c:
        r3 = "rs";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x0022 }
        goto L_0x0026;
    L_0x0022:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x0026:
        r2 = q(r5);	 Catch:{ Exception -> 0x0038 }
        if (r2 == 0) goto L_0x003c;
    L_0x002c:
        r3 = r2.length();	 Catch:{ Exception -> 0x0038 }
        if (r3 <= 0) goto L_0x003c;
    L_0x0032:
        r3 = "bstn";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x0038 }
        goto L_0x003c;
    L_0x0038:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x003c:
        r2 = r(r5);	 Catch:{ Exception -> 0x004e }
        if (r2 == 0) goto L_0x0052;
    L_0x0042:
        r3 = r2.length();	 Catch:{ Exception -> 0x004e }
        if (r3 <= 0) goto L_0x0052;
    L_0x0048:
        r3 = "by";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x004e }
        goto L_0x0052;
    L_0x004e:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x0052:
        a(r5, r1);	 Catch:{ Exception -> 0x0056 }
        goto L_0x005a;
    L_0x0056:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x005a:
        b(r5, r1);	 Catch:{ Exception -> 0x005e }
        goto L_0x0062;
    L_0x005e:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x0062:
        r2 = a();	 Catch:{ Exception -> 0x0074 }
        if (r2 == 0) goto L_0x0078;
    L_0x0068:
        r3 = r2.length();	 Catch:{ Exception -> 0x0074 }
        if (r3 <= 0) goto L_0x0078;
    L_0x006e:
        r3 = "sd";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x0074 }
        goto L_0x0078;
    L_0x0074:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x0078:
        r2 = b();	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x008e;
    L_0x007e:
        r3 = r2.length();	 Catch:{ Exception -> 0x008a }
        if (r3 <= 0) goto L_0x008e;
    L_0x0084:
        r3 = "build";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x008a }
        goto L_0x008e;
    L_0x008a:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x008e:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00bb }
        r2.<init>();	 Catch:{ Exception -> 0x00bb }
        r3 = g(r5);	 Catch:{ Exception -> 0x00bb }
        if (r3 == 0) goto L_0x00a4;
    L_0x0099:
        r4 = r3.length();	 Catch:{ Exception -> 0x00bb }
        if (r4 <= 0) goto L_0x00a4;
    L_0x009f:
        r4 = "a_sr";
        r2.put(r4, r3);	 Catch:{ JSONException -> 0x00a4 }
    L_0x00a4:
        r3 = com.umeng.commonsdk.internal.utils.j.c(r5);	 Catch:{ Exception -> 0x00bb }
        if (r3 == 0) goto L_0x00b5;
    L_0x00aa:
        r4 = r3.length();	 Catch:{ Exception -> 0x00bb }
        if (r4 <= 0) goto L_0x00b5;
    L_0x00b0:
        r4 = "stat";
        r2.put(r4, r3);	 Catch:{ JSONException -> 0x00b5 }
    L_0x00b5:
        r3 = "sr";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x00bb }
        goto L_0x00bf;
    L_0x00bb:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x00bf:
        r2 = h(r5);	 Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x00d5;
    L_0x00c5:
        r3 = r2.length();	 Catch:{ Exception -> 0x00d1 }
        if (r3 <= 0) goto L_0x00d5;
    L_0x00cb:
        r3 = "scr";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x00d1 }
        goto L_0x00d5;
    L_0x00d1:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x00d5:
        r2 = i(r5);	 Catch:{ Exception -> 0x00e7 }
        if (r2 == 0) goto L_0x00eb;
    L_0x00db:
        r3 = r2.length();	 Catch:{ Exception -> 0x00e7 }
        if (r3 <= 0) goto L_0x00eb;
    L_0x00e1:
        r3 = "sinfo";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x00e7 }
        goto L_0x00eb;
    L_0x00e7:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x00eb:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0118 }
        r2.<init>();	 Catch:{ Exception -> 0x0118 }
        r3 = com.umeng.commonsdk.internal.utils.a.e(r5);	 Catch:{ Exception -> 0x0118 }
        if (r3 == 0) goto L_0x0101;
    L_0x00f6:
        r4 = r3.length();	 Catch:{ Exception -> 0x0118 }
        if (r4 <= 0) goto L_0x0101;
    L_0x00fc:
        r4 = "wl";
        r2.put(r4, r3);	 Catch:{ JSONException -> 0x0101 }
    L_0x0101:
        r3 = j(r5);	 Catch:{ Exception -> 0x0118 }
        if (r3 == 0) goto L_0x0112;
    L_0x0107:
        r4 = r3.length();	 Catch:{ Exception -> 0x0118 }
        if (r4 <= 0) goto L_0x0112;
    L_0x010d:
        r4 = "a_wls";
        r2.put(r4, r3);	 Catch:{ JSONException -> 0x0112 }
    L_0x0112:
        r3 = "winfo";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x0118 }
        goto L_0x011c;
    L_0x0118:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x011c:
        r2 = k(r5);	 Catch:{ Exception -> 0x012e }
        if (r2 == 0) goto L_0x0132;
    L_0x0122:
        r3 = r2.length();	 Catch:{ Exception -> 0x012e }
        if (r3 <= 0) goto L_0x0132;
    L_0x0128:
        r3 = "input";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x012e }
        goto L_0x0132;
    L_0x012e:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x0132:
        r2 = com.umeng.commonsdk.internal.utils.a.o(r5);	 Catch:{ Exception -> 0x0144 }
        if (r2 == 0) goto L_0x0148;
    L_0x0138:
        r3 = r2.length();	 Catch:{ Exception -> 0x0144 }
        if (r3 <= 0) goto L_0x0148;
    L_0x013e:
        r3 = "bt";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x0144 }
        goto L_0x0148;
    L_0x0144:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x0148:
        r2 = l(r5);	 Catch:{ Exception -> 0x015a }
        if (r2 == 0) goto L_0x015e;
    L_0x014e:
        r3 = r2.length();	 Catch:{ Exception -> 0x015a }
        if (r3 <= 0) goto L_0x015e;
    L_0x0154:
        r3 = "cam";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x015a }
        goto L_0x015e;
    L_0x015a:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x015e:
        r2 = m(r5);	 Catch:{ Exception -> 0x0170 }
        if (r2 == 0) goto L_0x0174;
    L_0x0164:
        r3 = r2.length();	 Catch:{ Exception -> 0x0170 }
        if (r3 <= 0) goto L_0x0174;
    L_0x016a:
        r3 = "appls";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x0170 }
        goto L_0x0174;
    L_0x0170:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x0174:
        r2 = n(r5);	 Catch:{ Exception -> 0x0186 }
        if (r2 == 0) goto L_0x018a;
    L_0x017a:
        r3 = r2.length();	 Catch:{ Exception -> 0x0186 }
        if (r3 <= 0) goto L_0x018a;
    L_0x0180:
        r3 = "mem";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x0186 }
        goto L_0x018a;
    L_0x0186:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x018a:
        r2 = o(r5);	 Catch:{ Exception -> 0x019c }
        if (r2 == 0) goto L_0x01a0;
    L_0x0190:
        r3 = r2.length();	 Catch:{ Exception -> 0x019c }
        if (r3 <= 0) goto L_0x01a0;
    L_0x0196:
        r3 = "lbs";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x019c }
        goto L_0x01a0;
    L_0x019c:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r2);
    L_0x01a0:
        r2 = d();	 Catch:{ Exception -> 0x01b1 }
        if (r2 == 0) goto L_0x01b1;
    L_0x01a6:
        r3 = r2.length();	 Catch:{ Exception -> 0x01b1 }
        if (r3 <= 0) goto L_0x01b1;
    L_0x01ac:
        r3 = "cpu";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x01b1 }
    L_0x01b1:
        r2 = c();	 Catch:{ Exception -> 0x01c2 }
        if (r2 == 0) goto L_0x01c2;
    L_0x01b7:
        r3 = r2.length();	 Catch:{ Exception -> 0x01c2 }
        if (r3 <= 0) goto L_0x01c2;
    L_0x01bd:
        r3 = "rom";
        r1.put(r3, r2);	 Catch:{ Exception -> 0x01c2 }
    L_0x01c2:
        r2 = "inner";
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x01c8 }
        goto L_0x01cc;
    L_0x01c8:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
    L_0x01cc:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.e(android.content.Context):org.json.JSONObject");
    }

    public static String f(Context context) {
        try {
            e a = e.a(context);
            if (a == null) {
                return null;
            }
            a.a();
            String encodeToString = Base64.encodeToString(new s().a(a.b()), 0);
            return !TextUtils.isEmpty(encodeToString) ? encodeToString : null;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    public static JSONArray g(Context context) {
        return context != null ? k.g(context.getApplicationContext()) : null;
    }

    public static JSONObject h(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", a.h(context));
                jSONObject.put("a_nav_h", a.i(context));
                if (context.getResources() != null) {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (displayMetrics != null) {
                        jSONObject.put("a_den", (double) displayMetrics.density);
                        jSONObject.put("a_dpi", displayMetrics.densityDpi);
                    }
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0092 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008d A:{SYNTHETIC, Splitter:B:15:0x008d} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0083 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:2|3|4|(1:6)(1:7)|8|(2:10|11)|12|13|(2:15|16)|17|18) */
    /* JADX WARNING: Missing block: B:19:0x00a5, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x00a6, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
     */
    public static org.json.JSONObject i(android.content.Context r5) {
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r5 == 0) goto L_0x00a9;
    L_0x0007:
        r5 = r5.getApplicationContext();
        r1 = r5.getPackageName();
        r2 = "a_fit";
        r3 = com.umeng.commonsdk.internal.utils.a.a(r5, r1);	 Catch:{ Exception -> 0x00a5 }
        r0.put(r2, r3);	 Catch:{ Exception -> 0x00a5 }
        r2 = "a_alut";
        r3 = com.umeng.commonsdk.internal.utils.a.b(r5, r1);	 Catch:{ Exception -> 0x00a5 }
        r0.put(r2, r3);	 Catch:{ Exception -> 0x00a5 }
        r2 = "a_c";
        r3 = com.umeng.commonsdk.internal.utils.a.c(r5, r1);	 Catch:{ Exception -> 0x00a5 }
        r0.put(r2, r3);	 Catch:{ Exception -> 0x00a5 }
        r2 = "a_uid";
        r1 = com.umeng.commonsdk.internal.utils.a.d(r5, r1);	 Catch:{ Exception -> 0x00a5 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x00a5 }
        r1 = com.umeng.commonsdk.internal.utils.a.a();	 Catch:{ Exception -> 0x00a5 }
        if (r1 == 0) goto L_0x0040;
    L_0x0039:
        r1 = "a_root";
        r2 = 1;
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
        goto L_0x0046;
    L_0x0040:
        r1 = "a_root";
        r2 = 0;
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
    L_0x0046:
        r1 = "tf";
        r2 = com.umeng.commonsdk.internal.utils.a.b();	 Catch:{ Exception -> 0x00a5 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
        r1 = "s_fs";
        r2 = com.umeng.commonsdk.internal.utils.a.a(r5);	 Catch:{ Exception -> 0x00a5 }
        r2 = (double) r2;	 Catch:{ Exception -> 0x00a5 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
        r1 = "a_meid";
        r2 = com.umeng.commonsdk.internal.utils.a.l(r5);	 Catch:{ Exception -> 0x00a5 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
        r1 = "a_imsi";
        r2 = com.umeng.commonsdk.internal.utils.a.k(r5);	 Catch:{ Exception -> 0x00a5 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
        r1 = "st";
        r2 = com.umeng.commonsdk.internal.utils.a.f();	 Catch:{ Exception -> 0x00a5 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
        r1 = com.umeng.commonsdk.internal.utils.k.b(r5);	 Catch:{ Exception -> 0x00a5 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x00a5 }
        if (r2 != 0) goto L_0x0083;
    L_0x007e:
        r2 = "a_iccid";
        r0.put(r2, r1);	 Catch:{ Exception -> 0x0083 }
    L_0x0083:
        r1 = com.umeng.commonsdk.internal.utils.k.c(r5);	 Catch:{ Exception -> 0x00a5 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x00a5 }
        if (r2 != 0) goto L_0x0092;
    L_0x008d:
        r2 = "a_simei";
        r0.put(r2, r1);	 Catch:{ Exception -> 0x0092 }
    L_0x0092:
        r1 = "hn";
        r2 = com.umeng.commonsdk.internal.utils.a.g();	 Catch:{ Exception -> 0x00a5 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
        r1 = "ts";
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a5 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00a5 }
        goto L_0x00a9;
    L_0x00a5:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
    L_0x00a9:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.i(android.content.Context):org.json.JSONObject");
    }

    public static JSONArray j(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            context = context.getApplicationContext();
            List<ScanResult> b = a.b(context);
            if (b != null && b.size() > 0) {
                for (ScanResult scanResult : b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_bssid", scanResult.BSSID);
                        jSONObject.put("a_ssid", scanResult.SSID);
                        jSONObject.put("a_cap", scanResult.capabilities);
                        jSONObject.put("a_fcy", scanResult.frequency);
                        jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis());
                        if (VERSION.SDK_INT >= 23) {
                            jSONObject.put("a_c0", scanResult.centerFreq0);
                            jSONObject.put("a_c1", scanResult.centerFreq1);
                            jSONObject.put("a_cw", scanResult.channelWidth);
                            if (scanResult.is80211mcResponder()) {
                                jSONObject.put("a_is80211", 1);
                            } else {
                                jSONObject.put("a_is80211", 0);
                            }
                            if (scanResult.isPasspointNetwork()) {
                                jSONObject.put("a_isppn", 1);
                            } else {
                                jSONObject.put("a_isppn", 0);
                            }
                            jSONObject.put("a_ofn", scanResult.operatorFriendlyName);
                            jSONObject.put("a_vn", scanResult.venueName);
                        }
                        jSONObject.put("a_dc", scanResult.describeContents());
                        if (jSONObject != null) {
                            jSONArray.put(jSONObject);
                        }
                    } catch (Exception e) {
                        UMCrashManager.reportCrash(context, e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray k(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            context = context.getApplicationContext();
            List<InputMethodInfo> m = a.m(context);
            if (m != null) {
                for (InputMethodInfo inputMethodInfo : m) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_id", inputMethodInfo.getId());
                        jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                        jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis());
                        if (jSONObject != null) {
                            jSONArray.put(jSONObject);
                        }
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(context, th);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray l(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            context = context.getApplicationContext();
            List<j.a> e = j.e(context);
            if (!(e == null || e.isEmpty())) {
                for (j.a aVar : e) {
                    if (aVar != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("a_w", aVar.a);
                            jSONObject.put("a_h", aVar.b);
                            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis());
                            if (jSONObject != null) {
                                jSONArray.put(jSONObject);
                            }
                        } catch (Exception e2) {
                            UMCrashManager.reportCrash(context, e2);
                        }
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray m(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            context = context.getApplicationContext();
            List<a.a> p = a.p(context);
            if (!(p == null || p.isEmpty())) {
                for (a.a aVar : p) {
                    if (aVar != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("a_pn", aVar.a);
                            jSONObject.put("a_la", aVar.b);
                            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis());
                            if (jSONObject != null) {
                                jSONArray.put(jSONObject);
                            }
                        } catch (Exception e) {
                            UMCrashManager.reportCrash(context, e);
                        }
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject n(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            context = context.getApplicationContext();
            MemoryInfo q = a.q(context);
            if (q != null) {
                try {
                    if (VERSION.SDK_INT >= 16) {
                        jSONObject.put("t", q.totalMem);
                    }
                    jSONObject.put("f", q.availMem);
                    jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis());
                } catch (Exception e) {
                    UMCrashManager.reportCrash(context, e);
                }
            }
        }
        return jSONObject;
    }

    private static JSONArray o(Context context) {
        return context != null ? com.umeng.commonsdk.proguard.c.b(context.getApplicationContext()) : null;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00af */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private static org.json.JSONArray p(android.content.Context r7) {
        /*
        r0 = 0;
        if (r7 == 0) goto L_0x00c2;
    L_0x0003:
        r1 = r7.getApplicationContext();	 Catch:{ Throwable -> 0x00be }
        r2 = "activity";
        r1 = r1.getSystemService(r2);	 Catch:{ Throwable -> 0x00be }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ Throwable -> 0x00be }
        if (r1 == 0) goto L_0x00c2;
    L_0x0011:
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = r1.getRunningServices(r2);	 Catch:{ Throwable -> 0x00be }
        if (r1 == 0) goto L_0x00c2;
    L_0x001a:
        r2 = r1.isEmpty();	 Catch:{ Throwable -> 0x00be }
        if (r2 != 0) goto L_0x00c2;
    L_0x0020:
        r2 = 0;
    L_0x0021:
        r3 = r1.size();	 Catch:{ Throwable -> 0x00be }
        if (r2 >= r3) goto L_0x0090;
    L_0x0027:
        r3 = r1.get(r2);	 Catch:{ Throwable -> 0x00be }
        if (r3 == 0) goto L_0x008d;
    L_0x002d:
        r3 = r1.get(r2);	 Catch:{ Throwable -> 0x00be }
        r3 = (android.app.ActivityManager.RunningServiceInfo) r3;	 Catch:{ Throwable -> 0x00be }
        r3 = r3.service;	 Catch:{ Throwable -> 0x00be }
        if (r3 == 0) goto L_0x008d;
    L_0x0037:
        r3 = r1.get(r2);	 Catch:{ Throwable -> 0x00be }
        r3 = (android.app.ActivityManager.RunningServiceInfo) r3;	 Catch:{ Throwable -> 0x00be }
        r3 = r3.service;	 Catch:{ Throwable -> 0x00be }
        r3 = r3.getClassName();	 Catch:{ Throwable -> 0x00be }
        if (r3 == 0) goto L_0x008d;
    L_0x0045:
        r3 = r1.get(r2);	 Catch:{ Throwable -> 0x00be }
        r3 = (android.app.ActivityManager.RunningServiceInfo) r3;	 Catch:{ Throwable -> 0x00be }
        r3 = r3.service;	 Catch:{ Throwable -> 0x00be }
        r3 = r3.getPackageName();	 Catch:{ Throwable -> 0x00be }
        if (r3 == 0) goto L_0x008d;
    L_0x0053:
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x008d }
        r3.<init>();	 Catch:{ JSONException -> 0x008d }
        r4 = "sn";
        r5 = r1.get(r2);	 Catch:{ JSONException -> 0x008d }
        r5 = (android.app.ActivityManager.RunningServiceInfo) r5;	 Catch:{ JSONException -> 0x008d }
        r5 = r5.service;	 Catch:{ JSONException -> 0x008d }
        r5 = r5.getClassName();	 Catch:{ JSONException -> 0x008d }
        r5 = r5.toString();	 Catch:{ JSONException -> 0x008d }
        r3.put(r4, r5);	 Catch:{ JSONException -> 0x008d }
        r4 = "pn";
        r5 = r1.get(r2);	 Catch:{ JSONException -> 0x008d }
        r5 = (android.app.ActivityManager.RunningServiceInfo) r5;	 Catch:{ JSONException -> 0x008d }
        r5 = r5.service;	 Catch:{ JSONException -> 0x008d }
        r5 = r5.getPackageName();	 Catch:{ JSONException -> 0x008d }
        r5 = r5.toString();	 Catch:{ JSONException -> 0x008d }
        r3.put(r4, r5);	 Catch:{ JSONException -> 0x008d }
        if (r0 != 0) goto L_0x008a;
    L_0x0084:
        r4 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x008d }
        r4.<init>();	 Catch:{ JSONException -> 0x008d }
        r0 = r4;
    L_0x008a:
        r0.put(r3);	 Catch:{ JSONException -> 0x008d }
    L_0x008d:
        r2 = r2 + 1;
        goto L_0x0021;
    L_0x0090:
        if (r0 == 0) goto L_0x00c2;
    L_0x0092:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00be }
        r1.<init>();	 Catch:{ Throwable -> 0x00be }
        r2 = "ts";
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x00a5 }
        r1.put(r2, r3);	 Catch:{ JSONException -> 0x00a5 }
        r2 = "ls";
        r1.put(r2, r0);	 Catch:{ JSONException -> 0x00a5 }
    L_0x00a5:
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00be }
        r2.<init>();	 Catch:{ Throwable -> 0x00be }
        r3 = "sers";
        r2.put(r3, r1);	 Catch:{ JSONException -> 0x00af }
    L_0x00af:
        r1 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00be }
        r1.<init>();	 Catch:{ Throwable -> 0x00be }
        r1.put(r2);	 Catch:{ Throwable -> 0x00b9 }
        r0 = r1;
        goto L_0x00c2;
    L_0x00b9:
        r0 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00bf;
    L_0x00be:
        r1 = move-exception;
    L_0x00bf:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r7, r1);
    L_0x00c2:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.p(android.content.Context):org.json.JSONArray");
    }

    private static JSONArray q(Context context) {
        JSONArray jSONArray = new JSONArray();
        JSONObject d = k.d(context);
        if (d != null) {
            try {
                String e = k.e(context);
                if (!TextUtils.isEmpty(e)) {
                    d.put(INoCaptchaComponent.sig, e);
                }
                jSONArray.put(d);
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONArray r(Context context) {
        JSONArray jSONArray = new JSONArray();
        String f = k.f(context);
        if (!TextUtils.isEmpty(f)) {
            try {
                JSONObject jSONObject = new JSONObject(f);
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONArray s(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            context = context.getApplicationContext();
            String a = k.a(context);
            Object obj = null;
            if (!TextUtils.isEmpty(a)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("bluetoothmac", a);
                    } catch (Exception unused) {
                    }
                    obj = jSONObject;
                } catch (Exception unused2) {
                }
            }
            a = k.b(context);
            if (!TextUtils.isEmpty(a)) {
                if (obj == null) {
                    try {
                        obj = new JSONObject();
                    } catch (Exception unused3) {
                    }
                }
                obj.put("iccid", a);
            }
            a = k.c(context);
            if (!TextUtils.isEmpty(a)) {
                if (obj == null) {
                    try {
                        obj = new JSONObject();
                    } catch (Exception unused4) {
                    }
                }
                obj.put("secondaryimei", a);
            }
            JSONObject d = k.d(context);
            if (d != null) {
                try {
                    String e = k.e(context);
                    if (!TextUtils.isEmpty(e)) {
                        d.put("signalscale", e);
                    }
                    if (obj == null) {
                        obj = new JSONObject();
                    }
                    obj.put("basestation", d);
                } catch (Exception unused5) {
                }
            }
            String f = k.f(context);
            if (!TextUtils.isEmpty(f)) {
                if (obj == null) {
                    try {
                        obj = new JSONObject();
                    } catch (Exception unused6) {
                    }
                }
                obj.put("battery", new JSONObject(f));
            }
            if (obj != null) {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }
}
