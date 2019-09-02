package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.utils.UMUtils;
import defpackage.ah;
import java.util.Iterator;
import org.json.JSONObject;

public class UMSLEnvelopeBuild {
    private static final String TAG = "UMSLEnvelopeBuild";
    private static String cacheSystemheader;
    private static boolean isEncryptEnabled;
    public static Context mContext;
    public static String module;

    private synchronized c constructEnvelope(Context context, byte[] bArr) {
        c a;
        int i = -1;
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "slcodex", null);
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[stateless] build envelope, codexStr is ");
        stringBuilder.append(imprintProperty);
        objArr[0] = stringBuilder.toString();
        ULog.i("walle", objArr);
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e) {
            UMCrashManager.reportCrash(context, e);
        }
        if (i == 0) {
            ULog.i("walle", "[stateless] build envelope, codexValue is 0");
            a = c.a(context, UMUtils.getAppkey(context), bArr);
        } else if (i == 1) {
            ULog.i("walle", "[stateless] build envelope, codexValue is 1");
            a = c.b(context, UMUtils.getAppkey(context), bArr);
        } else if (isEncryptEnabled) {
            ULog.i("walle", "[stateless] build envelope, isEncryptEnabled is true");
            a = c.b(context, UMUtils.getAppkey(context), bArr);
        } else {
            ULog.i("walle", "[stateless] build envelope, isEncryptEnabled is false");
            a = c.a(context, UMUtils.getAppkey(context), bArr);
        }
        return a;
    }

    private synchronized JSONObject makeErrorResult(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put(ah.O000oOOo, i);
            } catch (Exception unused) {
            }
        } else {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(ah.O000oOOo, i);
            } catch (Exception unused2) {
            }
        }
        return jSONObject;
        return jSONObject;
    }

    public static void setEncryptEnabled(boolean z) {
        isEncryptEnabled = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x021e A:{Catch:{ Exception -> 0x0223 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0257 A:{SYNTHETIC, Splitter:B:79:0x0257} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0247 */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0257 A:{SYNTHETIC, Splitter:B:79:0x0257} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0234 */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x022f A:{Catch:{ Exception -> 0x0234 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0257 A:{SYNTHETIC, Splitter:B:79:0x0257} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0223 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:50|51|52|53|(7:55|56|(4:58|61|62|(1:64))|59|61|62|(0))|65|66|(1:68)|69|70|(1:74)|75|76|(3:79|80|(3:82|83|84))|88|89|90) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:50|51|52|53|(7:55|56|(4:58|61|62|(1:64))|59|61|62|(0))|65|66|(1:68)|69|70|(1:74)|75|76|(3:79|80|(3:82|83|84))|88|89|90) */
    public synchronized org.json.JSONObject buildSLBaseHeader(android.content.Context r10) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = "walle";
        r1 = 1;
        r2 = new java.lang.Object[r1];	 Catch:{ all -> 0x02b8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02b8 }
        r3.<init>();	 Catch:{ all -> 0x02b8 }
        r4 = "[stateless] begin build hader, thread is ";
        r3.append(r4);	 Catch:{ all -> 0x02b8 }
        r4 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x02b8 }
        r3.append(r4);	 Catch:{ all -> 0x02b8 }
        r3 = r3.toString();	 Catch:{ all -> 0x02b8 }
        r4 = 0;
        r2[r4] = r3;	 Catch:{ all -> 0x02b8 }
        com.umeng.commonsdk.statistics.common.ULog.i(r0, r2);	 Catch:{ all -> 0x02b8 }
        r0 = 0;
        if (r10 != 0) goto L_0x0026;
    L_0x0024:
        monitor-exit(r9);
        return r0;
    L_0x0026:
        r10 = r10.getApplicationContext();	 Catch:{ all -> 0x02b8 }
        r2 = cacheSystemheader;	 Catch:{ Throwable -> 0x0294 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0294 }
        if (r2 != 0) goto L_0x003e;
    L_0x0032:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x003b }
        r3 = cacheSystemheader;	 Catch:{ Exception -> 0x003b }
        r2.<init>(r3);	 Catch:{ Exception -> 0x003b }
        goto L_0x01de;
    L_0x003b:
        r2 = r0;
        goto L_0x01de;
    L_0x003e:
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0294 }
        r2.<init>();	 Catch:{ Throwable -> 0x0294 }
        r3 = "app_signature";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppMD5Signature(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "app_sig_sha1";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppSHA1Key(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "app_sig_sha";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppHashKey(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "app_version";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "version_code";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionCode(r10);	 Catch:{ Throwable -> 0x0294 }
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "idmd5";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceIdUmengMD5(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "cpu";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getCPU();	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMCCMNC(r10);	 Catch:{ Throwable -> 0x0294 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0294 }
        if (r5 != 0) goto L_0x0096;
    L_0x0090:
        r5 = "mccmnc";
        r2.put(r5, r3);	 Catch:{ Throwable -> 0x0294 }
        goto L_0x009d;
    L_0x0096:
        r3 = "mccmnc";
        r5 = "";
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
    L_0x009d:
        r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSName(r10);	 Catch:{ Throwable -> 0x0294 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0294 }
        if (r5 != 0) goto L_0x00ac;
    L_0x00a7:
        r5 = "sub_os_name";
        r2.put(r5, r3);	 Catch:{ Throwable -> 0x0294 }
    L_0x00ac:
        r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSVersion(r10);	 Catch:{ Throwable -> 0x0294 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0294 }
        if (r5 != 0) goto L_0x00bb;
    L_0x00b6:
        r5 = "sub_os_version";
        r2.put(r5, r3);	 Catch:{ Throwable -> 0x0294 }
    L_0x00bb:
        r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceType(r10);	 Catch:{ Throwable -> 0x0294 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0294 }
        if (r5 != 0) goto L_0x00ca;
    L_0x00c5:
        r5 = "device_type";
        r2.put(r5, r3);	 Catch:{ Throwable -> 0x0294 }
    L_0x00ca:
        r3 = "package_name";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "sdk_type";
        r5 = "Android";
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "device_id";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceId(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "device_model";
        r5 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "device_board";
        r5 = android.os.Build.BOARD;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "device_brand";
        r5 = android.os.Build.BRAND;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "device_manutime";
        r5 = android.os.Build.TIME;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "device_manufacturer";
        r5 = android.os.Build.MANUFACTURER;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "device_manuid";
        r5 = android.os.Build.ID;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "device_name";
        r5 = android.os.Build.DEVICE;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "os";
        r5 = "Android";
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "os_version";
        r5 = android.os.Build.VERSION.RELEASE;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(r10);	 Catch:{ Throwable -> 0x0294 }
        if (r3 == 0) goto L_0x0145;
    L_0x0128:
        r5 = "resolution";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0294 }
        r6.<init>();	 Catch:{ Throwable -> 0x0294 }
        r7 = r3[r1];	 Catch:{ Throwable -> 0x0294 }
        r6.append(r7);	 Catch:{ Throwable -> 0x0294 }
        r7 = "*";
        r6.append(r7);	 Catch:{ Throwable -> 0x0294 }
        r3 = r3[r4];	 Catch:{ Throwable -> 0x0294 }
        r6.append(r3);	 Catch:{ Throwable -> 0x0294 }
        r3 = r6.toString();	 Catch:{ Throwable -> 0x0294 }
        r2.put(r5, r3);	 Catch:{ Throwable -> 0x0294 }
    L_0x0145:
        r3 = "mc";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "timezone";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getTimeZone(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(r10);	 Catch:{ Throwable -> 0x0294 }
        r5 = "country";
        r6 = r3[r4];	 Catch:{ Throwable -> 0x0294 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x0294 }
        r5 = "language";
        r3 = r3[r1];	 Catch:{ Throwable -> 0x0294 }
        r2.put(r5, r3);	 Catch:{ Throwable -> 0x0294 }
        r3 = "carrier";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkOperatorName(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "display_name";
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(r10);	 Catch:{ Throwable -> 0x0294 }
        r5 = "Wi-Fi";
        r6 = r3[r4];	 Catch:{ Throwable -> 0x0294 }
        r5 = r5.equals(r6);	 Catch:{ Throwable -> 0x0294 }
        if (r5 == 0) goto L_0x0191;
    L_0x0189:
        r5 = "access";
        r6 = "wifi";
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x0294 }
        goto L_0x01aa;
    L_0x0191:
        r5 = "2G/3G";
        r6 = r3[r4];	 Catch:{ Throwable -> 0x0294 }
        r5 = r5.equals(r6);	 Catch:{ Throwable -> 0x0294 }
        if (r5 == 0) goto L_0x01a3;
    L_0x019b:
        r5 = "access";
        r6 = "2G/3G";
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x0294 }
        goto L_0x01aa;
    L_0x01a3:
        r5 = "access";
        r6 = "unknow";
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x0294 }
    L_0x01aa:
        r5 = "";
        r6 = r3[r1];	 Catch:{ Throwable -> 0x0294 }
        r5 = r5.equals(r6);	 Catch:{ Throwable -> 0x0294 }
        if (r5 != 0) goto L_0x01bb;
    L_0x01b4:
        r5 = "access_subtype";
        r3 = r3[r1];	 Catch:{ Throwable -> 0x0294 }
        r2.put(r5, r3);	 Catch:{ Throwable -> 0x0294 }
    L_0x01bb:
        r3 = "com_ver";
        r5 = "2.0.2";
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "com_type";
        r5 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = module;	 Catch:{ Throwable -> 0x0294 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0294 }
        if (r3 != 0) goto L_0x01d8;
    L_0x01d1:
        r3 = "module";
        r5 = module;	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
    L_0x01d8:
        r3 = r2.toString();	 Catch:{ Throwable -> 0x0294 }
        cacheSystemheader = r3;	 Catch:{ Throwable -> 0x0294 }
    L_0x01de:
        if (r2 != 0) goto L_0x01e2;
    L_0x01e0:
        monitor-exit(r9);
        return r0;
    L_0x01e2:
        r3 = "channel";
        r5 = com.umeng.commonsdk.utils.UMUtils.getChannel(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = "appkey";
        r5 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r10);	 Catch:{ Throwable -> 0x0294 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0294 }
        r3 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;	 Catch:{ Exception -> 0x0223 }
        if (r3 == r1) goto L_0x0223;
    L_0x01f8:
        r3 = "com.umeng.commonsdk.internal.utils.SDStorageAgent";
        r3 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException | Throwable -> 0x0217, ClassNotFoundException | Throwable -> 0x0217 }
        if (r3 == 0) goto L_0x0217;
    L_0x0200:
        r5 = "getUmtt";
        r6 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException | Throwable -> 0x0217, ClassNotFoundException | Throwable -> 0x0217 }
        r7 = android.content.Context.class;
        r6[r4] = r7;	 Catch:{ ClassNotFoundException | Throwable -> 0x0217, ClassNotFoundException | Throwable -> 0x0217 }
        r5 = r3.getMethod(r5, r6);	 Catch:{ ClassNotFoundException | Throwable -> 0x0217, ClassNotFoundException | Throwable -> 0x0217 }
        r6 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException | Throwable -> 0x0217, ClassNotFoundException | Throwable -> 0x0217 }
        r6[r4] = r10;	 Catch:{ ClassNotFoundException | Throwable -> 0x0217, ClassNotFoundException | Throwable -> 0x0217 }
        r3 = r5.invoke(r3, r6);	 Catch:{ ClassNotFoundException | Throwable -> 0x0217, ClassNotFoundException | Throwable -> 0x0217 }
        r3 = (java.lang.String) r3;	 Catch:{ ClassNotFoundException | Throwable -> 0x0217, ClassNotFoundException | Throwable -> 0x0217 }
        goto L_0x0218;
    L_0x0217:
        r3 = r0;
    L_0x0218:
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0223 }
        if (r5 != 0) goto L_0x0223;
    L_0x021e:
        r5 = "umtt";
        r2.put(r5, r3);	 Catch:{ Exception -> 0x0223 }
    L_0x0223:
        r3 = "umid";
        r3 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r10, r3, r0);	 Catch:{ Exception -> 0x0234 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0234 }
        if (r5 != 0) goto L_0x0234;
    L_0x022f:
        r5 = "umid";
        r2.put(r5, r3);	 Catch:{ Exception -> 0x0234 }
    L_0x0234:
        r3 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;	 Catch:{ Exception -> 0x0247 }
        if (r3 == r1) goto L_0x0247;
    L_0x0238:
        r3 = com.umeng.commonsdk.proguard.a.b(r10);	 Catch:{ Exception -> 0x0247 }
        if (r3 == 0) goto L_0x0247;
    L_0x023e:
        r3 = "utoken";
        r5 = com.umeng.commonsdk.proguard.a.b(r10);	 Catch:{ Exception -> 0x0247 }
        r2.put(r3, r5);	 Catch:{ Exception -> 0x0247 }
    L_0x0247:
        r3 = "wrapper_type";
        r5 = com.umeng.commonsdk.stateless.a.a;	 Catch:{ Exception -> 0x0255 }
        r2.put(r3, r5);	 Catch:{ Exception -> 0x0255 }
        r3 = "wrapper_version";
        r5 = com.umeng.commonsdk.stateless.a.b;	 Catch:{ Exception -> 0x0255 }
        r2.put(r3, r5);	 Catch:{ Exception -> 0x0255 }
    L_0x0255:
        if (r2 == 0) goto L_0x0298;
    L_0x0257:
        r3 = r2.length();	 Catch:{ Throwable -> 0x0294 }
        if (r3 <= 0) goto L_0x0298;
    L_0x025d:
        r3 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0294 }
        r3.<init>();	 Catch:{ Throwable -> 0x0294 }
        r5 = "walle";
        r6 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0294 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0294 }
        r7.<init>();	 Catch:{ Throwable -> 0x0294 }
        r8 = "[stateless] build header end , header is ";
        r7.append(r8);	 Catch:{ Throwable -> 0x0294 }
        r8 = r2.toString();	 Catch:{ Throwable -> 0x0294 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0294 }
        r8 = ", thread is ";
        r7.append(r8);	 Catch:{ Throwable -> 0x0294 }
        r8 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0294 }
        r7.append(r8);	 Catch:{ Throwable -> 0x0294 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x0294 }
        r6[r4] = r7;	 Catch:{ Throwable -> 0x0294 }
        com.umeng.commonsdk.statistics.common.ULog.i(r5, r6);	 Catch:{ Throwable -> 0x0294 }
        r5 = "header";
        r2 = r3.put(r5, r2);	 Catch:{ Throwable -> 0x0294 }
        monitor-exit(r9);
        return r2;
    L_0x0294:
        r2 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r10, r2);	 Catch:{ all -> 0x02b8 }
    L_0x0298:
        r10 = "walle";
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x02b8 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02b8 }
        r2.<init>();	 Catch:{ all -> 0x02b8 }
        r3 = "[stateless] build header end , header is null !!! thread is ";
        r2.append(r3);	 Catch:{ all -> 0x02b8 }
        r3 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x02b8 }
        r2.append(r3);	 Catch:{ all -> 0x02b8 }
        r2 = r2.toString();	 Catch:{ all -> 0x02b8 }
        r1[r4] = r2;	 Catch:{ all -> 0x02b8 }
        com.umeng.commonsdk.statistics.common.ULog.i(r10, r1);	 Catch:{ all -> 0x02b8 }
        monitor-exit(r9);
        return r0;
    L_0x02b8:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.buildSLBaseHeader(android.content.Context):org.json.JSONObject");
    }

    public synchronized JSONObject buildSLEnvelope(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Throwable th;
        Object[] objArr;
        StringBuilder stringBuilder;
        Object[] objArr2 = new Object[1];
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[stateless] build envelope, heade is ");
        stringBuilder2.append(jSONObject.toString());
        objArr2[0] = stringBuilder2.toString();
        ULog.i("walle", objArr2);
        objArr2 = new Object[1];
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[stateless] build envelope, body is ");
        stringBuilder2.append(jSONObject2.toString());
        objArr2[0] = stringBuilder2.toString();
        ULog.i("walle", objArr2);
        objArr2 = new Object[1];
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[stateless] build envelope, thread is ");
        stringBuilder2.append(Thread.currentThread());
        objArr2[0] = stringBuilder2.toString();
        ULog.i("walle", objArr2);
        if (context == null || jSONObject == null || jSONObject2 == null || str == null) {
            ULog.i("walle", "[stateless] build envelope, context is null or header is null or body is null");
            return makeErrorResult(110, null);
        }
        Context applicationContext;
        try {
            Object[] objArr3;
            StringBuilder stringBuilder3;
            applicationContext = context.getApplicationContext();
            if (!(jSONObject == null || jSONObject2 == null)) {
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = (String) next;
                        if (!(str2 == null || jSONObject2.opt(str2) == null)) {
                            try {
                                jSONObject.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject != null) {
                try {
                    e a = e.a(applicationContext);
                    if (a != null) {
                        a.a();
                        String encodeToString = Base64.encodeToString(new s().a(a.b()), 0);
                        if (!TextUtils.isEmpty(encodeToString)) {
                            jSONObject2 = jSONObject.getJSONObject("header");
                            jSONObject2.put(com.umeng.commonsdk.proguard.e.V, encodeToString);
                            jSONObject.put("header", jSONObject2);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (jSONObject != null) {
                if (f.a((long) jSONObject.toString().getBytes().length, a.c)) {
                    objArr3 = new Object[1];
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("[stateless] build envelope, json overstep!!!! size is ");
                    stringBuilder3.append(jSONObject.toString().getBytes().length);
                    objArr3[0] = stringBuilder3.toString();
                    ULog.i("walle", objArr3);
                    return makeErrorResult(113, jSONObject);
                }
            }
            try {
                c constructEnvelope;
                objArr3 = new Object[1];
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("[stateless] build envelope, json size is ");
                stringBuilder4.append(jSONObject.toString().getBytes().length);
                objArr3[0] = stringBuilder4.toString();
                ULog.i("walle", objArr3);
                if (jSONObject != null) {
                    constructEnvelope = constructEnvelope(applicationContext, jSONObject.toString().getBytes());
                    if (constructEnvelope == null) {
                        ULog.i("walle", "[stateless] build envelope, envelope is null !!!!");
                        return makeErrorResult(111, jSONObject);
                    }
                }
                constructEnvelope = null;
                if (constructEnvelope != null) {
                    if (f.a((long) constructEnvelope.b().length, a.d)) {
                        Object[] objArr4 = new Object[1];
                        stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("[stateless] build envelope, envelope overstep!!!! size is ");
                        stringBuilder4.append(constructEnvelope.b().length);
                        objArr4[0] = stringBuilder4.toString();
                        ULog.i("walle", objArr4);
                        return makeErrorResult(114, jSONObject);
                    }
                }
                String encodeToString2 = Base64.encodeToString(str.getBytes(), 0);
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str);
                stringBuilder4.append("_");
                stringBuilder4.append(System.currentTimeMillis());
                if (f.a(applicationContext, encodeToString2, Base64.encodeToString(stringBuilder4.toString().getBytes(), 0), constructEnvelope.b())) {
                    ULog.i("walle", "[stateless] build envelope, save ok ----->>>>>");
                    objArr3 = new Object[1];
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("[stateless] envelope file size is ");
                    stringBuilder3.append(jSONObject.toString().getBytes().length);
                    objArr3[0] = stringBuilder3.toString();
                    ULog.i("walle", objArr3);
                    d dVar = new d(applicationContext);
                    d.b(d.a);
                    objArr3 = new Object[1];
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("[stateless] build envelope end, thread is ");
                    stringBuilder3.append(Thread.currentThread());
                    objArr3[0] = stringBuilder3.toString();
                    ULog.i("walle", objArr3);
                    return jSONObject;
                }
                ULog.i("walle", "[stateless] build envelope, save fail ----->>>>>");
                return makeErrorResult(101, jSONObject);
            } catch (Throwable th2) {
                th = th2;
                UMCrashManager.reportCrash(applicationContext, th);
                objArr = new Object[1];
                stringBuilder = new StringBuilder();
                stringBuilder.append("build envelope end, thread is ");
                stringBuilder.append(Thread.currentThread());
                objArr[0] = stringBuilder.toString();
                ULog.i("walle", objArr);
                return makeErrorResult(110, null);
            }
        } catch (Throwable th3) {
            applicationContext = context;
            th = th3;
            UMCrashManager.reportCrash(applicationContext, th);
            objArr = new Object[1];
            stringBuilder = new StringBuilder();
            stringBuilder.append("build envelope end, thread is ");
            stringBuilder.append(Thread.currentThread());
            objArr[0] = stringBuilder.toString();
            ULog.i("walle", objArr);
            return makeErrorResult(110, null);
        }
    }
}
