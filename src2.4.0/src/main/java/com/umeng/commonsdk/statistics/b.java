package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import defpackage.ah;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EnvelopeManager */
public class b {
    public static String a = null;
    public static String b = "";
    private static final String c = "EnvelopeManager";
    private static String d;
    private static boolean f;
    private int e = 0;

    private int a(Context context, Envelope envelope, String str, String str2) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&&");
        stringBuilder.append(str2);
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_envelope.log");
        return UMFrUtils.saveEnvelopeFile(context, stringBuilder.toString(), envelope.toBinary());
    }

    public static long a(Context context) {
        long j;
        String str;
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        JSONObject b = b(context);
        if (b == null || b.toString() == null || b.toString().getBytes() == null) {
            j = j2;
        } else {
            long length = (long) b.toString().getBytes().length;
            if (ULog.DEBUG) {
                str = c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("headerLen size is ");
                stringBuilder.append(length);
                Log.i(str, stringBuilder.toString());
            }
            j = j2 - length;
        }
        if (ULog.DEBUG) {
            str = c;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("free size is ");
            stringBuilder2.append(j);
            Log.i(str, stringBuilder2.toString());
        }
        return j;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e) {
            UMCrashManager.reportCrash(context, e);
        }
        return i == 0 ? Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr) : i == 1 ? Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr) : f ? Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr) : Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private JSONObject a(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put(ah.O000oOOo, i);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put(ah.O000oOOo, i);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (!(jSONObject == null || jSONObject2 == null || jSONObject.opt("header") == null || !(jSONObject.opt("header") instanceof JSONObject))) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("header");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                Object next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str = (String) next;
                    if (!(str == null || jSONObject2.opt(str) == null)) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(ah.O0000Oo0) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.e = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void a(boolean z) {
        f = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0231 A:{Catch:{ Exception -> 0x0237 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x0272 */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01fd A:{Catch:{ Exception -> 0x0203, Throwable -> 0x02a1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x020b A:{SYNTHETIC, Splitter:B:56:0x020b} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0247 A:{Catch:{ Exception -> 0x024d }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x01e1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x0264 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:42|43|(5:44|45|46|47|(1:49))|53|54|(7:56|57|(4:59|62|63|(1:65))|60|62|63|(0))|69|70|(1:72)|76|77|(1:81)|82|83|84|85|(2:89|90)|(2:97|98)|101) */
    private static org.json.JSONObject b(android.content.Context r9) {
        /*
        r0 = 0;
        r1 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2 = d;	 Catch:{ Throwable -> 0x02a1 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x02a1 }
        r3 = 1;
        r4 = 0;
        if (r2 != 0) goto L_0x001b;
    L_0x000f:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0018 }
        r5 = d;	 Catch:{ Exception -> 0x0018 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0018 }
        goto L_0x01bd;
    L_0x0018:
        r2 = r0;
        goto L_0x01bd;
    L_0x001b:
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x02a1 }
        r2.<init>();	 Catch:{ Throwable -> 0x02a1 }
        r5 = "app_signature";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppMD5Signature(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "app_sig_sha1";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppSHA1Key(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "app_sig_sha";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppHashKey(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "app_version";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "version_code";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionCode(r9);	 Catch:{ Throwable -> 0x02a1 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "idmd5";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceIdUmengMD5(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "cpu";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getCPU();	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMCCMNC(r9);	 Catch:{ Throwable -> 0x02a1 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x02a1 }
        if (r6 != 0) goto L_0x0075;
    L_0x006d:
        r6 = "mccmnc";
        r2.put(r6, r5);	 Catch:{ Throwable -> 0x02a1 }
        b = r5;	 Catch:{ Throwable -> 0x02a1 }
        goto L_0x007c;
    L_0x0075:
        r5 = "mccmnc";
        r6 = "";
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
    L_0x007c:
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSName(r9);	 Catch:{ Throwable -> 0x02a1 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x02a1 }
        if (r6 != 0) goto L_0x008b;
    L_0x0086:
        r6 = "sub_os_name";
        r2.put(r6, r5);	 Catch:{ Throwable -> 0x02a1 }
    L_0x008b:
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSVersion(r9);	 Catch:{ Throwable -> 0x02a1 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x02a1 }
        if (r6 != 0) goto L_0x009a;
    L_0x0095:
        r6 = "sub_os_version";
        r2.put(r6, r5);	 Catch:{ Throwable -> 0x02a1 }
    L_0x009a:
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceType(r9);	 Catch:{ Throwable -> 0x02a1 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x02a1 }
        if (r6 != 0) goto L_0x00a9;
    L_0x00a4:
        r6 = "device_type";
        r2.put(r6, r5);	 Catch:{ Throwable -> 0x02a1 }
    L_0x00a9:
        r5 = "package_name";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "sdk_type";
        r6 = "Android";
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "device_id";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceId(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "device_model";
        r6 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "device_board";
        r6 = android.os.Build.BOARD;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "device_brand";
        r6 = android.os.Build.BRAND;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "device_manutime";
        r6 = android.os.Build.TIME;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "device_manufacturer";
        r6 = android.os.Build.MANUFACTURER;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "device_manuid";
        r6 = android.os.Build.ID;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "device_name";
        r6 = android.os.Build.DEVICE;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "os";
        r6 = "Android";
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "os_version";
        r6 = android.os.Build.VERSION.RELEASE;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(r9);	 Catch:{ Throwable -> 0x02a1 }
        if (r5 == 0) goto L_0x0124;
    L_0x0107:
        r6 = "resolution";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02a1 }
        r7.<init>();	 Catch:{ Throwable -> 0x02a1 }
        r8 = r5[r3];	 Catch:{ Throwable -> 0x02a1 }
        r7.append(r8);	 Catch:{ Throwable -> 0x02a1 }
        r8 = "*";
        r7.append(r8);	 Catch:{ Throwable -> 0x02a1 }
        r5 = r5[r4];	 Catch:{ Throwable -> 0x02a1 }
        r7.append(r5);	 Catch:{ Throwable -> 0x02a1 }
        r5 = r7.toString();	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r6, r5);	 Catch:{ Throwable -> 0x02a1 }
    L_0x0124:
        r5 = "mc";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "timezone";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getTimeZone(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(r9);	 Catch:{ Throwable -> 0x02a1 }
        r6 = "country";
        r7 = r5[r4];	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r6, r7);	 Catch:{ Throwable -> 0x02a1 }
        r6 = "language";
        r5 = r5[r3];	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r6, r5);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "carrier";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkOperatorName(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "display_name";
        r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(r9);	 Catch:{ Throwable -> 0x02a1 }
        r6 = "Wi-Fi";
        r7 = r5[r4];	 Catch:{ Throwable -> 0x02a1 }
        r6 = r6.equals(r7);	 Catch:{ Throwable -> 0x02a1 }
        if (r6 == 0) goto L_0x0170;
    L_0x0168:
        r6 = "access";
        r7 = "wifi";
        r2.put(r6, r7);	 Catch:{ Throwable -> 0x02a1 }
        goto L_0x0189;
    L_0x0170:
        r6 = "2G/3G";
        r7 = r5[r4];	 Catch:{ Throwable -> 0x02a1 }
        r6 = r6.equals(r7);	 Catch:{ Throwable -> 0x02a1 }
        if (r6 == 0) goto L_0x0182;
    L_0x017a:
        r6 = "access";
        r7 = "2G/3G";
        r2.put(r6, r7);	 Catch:{ Throwable -> 0x02a1 }
        goto L_0x0189;
    L_0x0182:
        r6 = "access";
        r7 = "unknow";
        r2.put(r6, r7);	 Catch:{ Throwable -> 0x02a1 }
    L_0x0189:
        r6 = "";
        r7 = r5[r3];	 Catch:{ Throwable -> 0x02a1 }
        r6 = r6.equals(r7);	 Catch:{ Throwable -> 0x02a1 }
        if (r6 != 0) goto L_0x019a;
    L_0x0193:
        r6 = "access_subtype";
        r5 = r5[r3];	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r6, r5);	 Catch:{ Throwable -> 0x02a1 }
    L_0x019a:
        r5 = "com_ver";
        r6 = "2.0.2";
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = "com_type";
        r6 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
        r5 = a;	 Catch:{ Throwable -> 0x02a1 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x02a1 }
        if (r5 != 0) goto L_0x01b7;
    L_0x01b0:
        r5 = "module";
        r6 = a;	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r5, r6);	 Catch:{ Throwable -> 0x02a1 }
    L_0x01b7:
        r5 = r2.toString();	 Catch:{ Throwable -> 0x02a1 }
        d = r5;	 Catch:{ Throwable -> 0x02a1 }
    L_0x01bd:
        if (r2 != 0) goto L_0x01c0;
    L_0x01bf:
        return r0;
    L_0x01c0:
        r5 = "successful_requests";
        r6 = "successful_request";
        r6 = r1.getInt(r6, r4);	 Catch:{ Exception -> 0x01e1 }
        r2.put(r5, r6);	 Catch:{ Exception -> 0x01e1 }
        r5 = "failed_requests";
        r6 = "failed_requests";
        r6 = r1.getInt(r6, r4);	 Catch:{ Exception -> 0x01e1 }
        r2.put(r5, r6);	 Catch:{ Exception -> 0x01e1 }
        r5 = "req_time";
        r6 = "last_request_spent_ms";
        r1 = r1.getInt(r6, r4);	 Catch:{ Exception -> 0x01e1 }
        r2.put(r5, r1);	 Catch:{ Exception -> 0x01e1 }
    L_0x01e1:
        r1 = "channel";
        r5 = com.umeng.commonsdk.utils.UMUtils.getChannel(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r1, r5);	 Catch:{ Throwable -> 0x02a1 }
        r1 = "appkey";
        r5 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r9);	 Catch:{ Throwable -> 0x02a1 }
        r2.put(r1, r5);	 Catch:{ Throwable -> 0x02a1 }
        r1 = com.umeng.commonsdk.utils.UMUtils.getDeviceToken(r9);	 Catch:{ Exception -> 0x0203 }
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0203 }
        if (r5 != 0) goto L_0x0207;
    L_0x01fd:
        r5 = "devicetoken";
        r2.put(r5, r1);	 Catch:{ Exception -> 0x0203 }
        goto L_0x0207;
    L_0x0203:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r1);	 Catch:{ Throwable -> 0x02a1 }
    L_0x0207:
        r1 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;	 Catch:{ Exception -> 0x0237 }
        if (r1 == r3) goto L_0x023b;
    L_0x020b:
        r1 = "com.umeng.commonsdk.internal.utils.SDStorageAgent";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException | Throwable -> 0x022a, ClassNotFoundException | Throwable -> 0x022a }
        if (r1 == 0) goto L_0x022a;
    L_0x0213:
        r5 = "getUmtt";
        r6 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException | Throwable -> 0x022a, ClassNotFoundException | Throwable -> 0x022a }
        r7 = android.content.Context.class;
        r6[r4] = r7;	 Catch:{ ClassNotFoundException | Throwable -> 0x022a, ClassNotFoundException | Throwable -> 0x022a }
        r5 = r1.getMethod(r5, r6);	 Catch:{ ClassNotFoundException | Throwable -> 0x022a, ClassNotFoundException | Throwable -> 0x022a }
        r6 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException | Throwable -> 0x022a, ClassNotFoundException | Throwable -> 0x022a }
        r6[r4] = r9;	 Catch:{ ClassNotFoundException | Throwable -> 0x022a, ClassNotFoundException | Throwable -> 0x022a }
        r1 = r5.invoke(r1, r6);	 Catch:{ ClassNotFoundException | Throwable -> 0x022a, ClassNotFoundException | Throwable -> 0x022a }
        r1 = (java.lang.String) r1;	 Catch:{ ClassNotFoundException | Throwable -> 0x022a, ClassNotFoundException | Throwable -> 0x022a }
        goto L_0x022b;
    L_0x022a:
        r1 = r0;
    L_0x022b:
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0237 }
        if (r5 != 0) goto L_0x023b;
    L_0x0231:
        r5 = "umtt";
        r2.put(r5, r1);	 Catch:{ Exception -> 0x0237 }
        goto L_0x023b;
    L_0x0237:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r1);	 Catch:{ Throwable -> 0x02a1 }
    L_0x023b:
        r1 = "umid";
        r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r9, r1, r0);	 Catch:{ Exception -> 0x024d }
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x024d }
        if (r5 != 0) goto L_0x0251;
    L_0x0247:
        r5 = "umid";
        r2.put(r5, r1);	 Catch:{ Exception -> 0x024d }
        goto L_0x0251;
    L_0x024d:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r1);	 Catch:{ Throwable -> 0x02a1 }
    L_0x0251:
        r1 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;	 Catch:{ Exception -> 0x0264 }
        if (r1 == r3) goto L_0x0264;
    L_0x0255:
        r1 = com.umeng.commonsdk.proguard.a.b(r9);	 Catch:{ Exception -> 0x0264 }
        if (r1 == 0) goto L_0x0264;
    L_0x025b:
        r1 = "utoken";
        r3 = com.umeng.commonsdk.proguard.a.b(r9);	 Catch:{ Exception -> 0x0264 }
        r2.put(r1, r3);	 Catch:{ Exception -> 0x0264 }
    L_0x0264:
        r1 = "wrapper_type";
        r3 = com.umeng.commonsdk.statistics.a.a;	 Catch:{ Exception -> 0x0272 }
        r2.put(r1, r3);	 Catch:{ Exception -> 0x0272 }
        r1 = "wrapper_version";
        r3 = com.umeng.commonsdk.statistics.a.b;	 Catch:{ Exception -> 0x0272 }
        r2.put(r1, r3);	 Catch:{ Exception -> 0x0272 }
    L_0x0272:
        r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(r9);	 Catch:{ Throwable -> 0x02a1 }
        r1 = r1.a();	 Catch:{ Throwable -> 0x02a1 }
        if (r1 == 0) goto L_0x028d;
    L_0x027c:
        r3 = r1.length;	 Catch:{ Throwable -> 0x02a1 }
        if (r3 <= 0) goto L_0x028d;
    L_0x027f:
        r3 = "imprint";
        r1 = android.util.Base64.encodeToString(r1, r4);	 Catch:{ JSONException -> 0x0289 }
        r2.put(r3, r1);	 Catch:{ JSONException -> 0x0289 }
        goto L_0x028d;
    L_0x0289:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r1);	 Catch:{ Throwable -> 0x02a1 }
    L_0x028d:
        if (r2 == 0) goto L_0x02a5;
    L_0x028f:
        r1 = r2.length();	 Catch:{ Throwable -> 0x02a1 }
        if (r1 <= 0) goto L_0x02a5;
    L_0x0295:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x02a1 }
        r1.<init>();	 Catch:{ Throwable -> 0x02a1 }
        r3 = "header";
        r1 = r1.put(r3, r2);	 Catch:{ Throwable -> 0x02a1 }
        return r1;
    L_0x02a1:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r1);
    L_0x02a5:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.b(android.content.Context):org.json.JSONObject");
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        Throwable e;
        if (!(!ULog.DEBUG || jSONObject == null || jSONObject2 == null)) {
            String str = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("headerJSONObject size is ");
            stringBuilder.append(jSONObject.toString().getBytes().length);
            Log.i(str, stringBuilder.toString());
            str = c;
            stringBuilder = new StringBuilder();
            stringBuilder.append("bodyJSONObject size is ");
            stringBuilder.append(jSONObject2.toString().getBytes().length);
            Log.i(str, stringBuilder.toString());
        }
        JSONObject jSONObject3 = null;
        if (context == null || jSONObject2 == null) {
            return a(110, null);
        }
        JSONObject b;
        try {
            String str2;
            StringBuilder stringBuilder2;
            String encodeToString;
            Envelope a;
            b = b(context);
            if (!(b == null || jSONObject == null)) {
                b = a(b, jSONObject);
            }
            if (!(b == null || jSONObject2 == null)) {
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (next != null && (next instanceof String)) {
                        str2 = (String) next;
                        if (!(str2 == null || jSONObject2.opt(str2) == null)) {
                            try {
                                b.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (b != null) {
                stringBuilder2 = new StringBuilder();
                if (b.length() > 0) {
                    String str3;
                    String optString;
                    if (b.has(e.ai)) {
                        str3 = e.ao;
                        optString = b.optJSONObject("header").optString(e.au);
                        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(optString))) {
                            stringBuilder2.append(str3);
                            stringBuilder2.append("==");
                            stringBuilder2.append(optString);
                            stringBuilder2.append("&=");
                        }
                    }
                    if (b.has("share")) {
                        str3 = e.ap;
                        optString = b.optJSONObject("header").optString("s_sdk_v");
                        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(optString))) {
                            stringBuilder2.append(str3);
                            stringBuilder2.append("==");
                            stringBuilder2.append(optString);
                            stringBuilder2.append("&=");
                        }
                    }
                    if (b.has("analytics")) {
                        CharSequence charSequence;
                        if (b.has("dplus")) {
                            charSequence = e.an;
                        } else {
                            charSequence = e.al;
                            if (b.optJSONObject("header").has("st")) {
                                charSequence = e.ar;
                            }
                        }
                        optString = b.optJSONObject("header").optString("sdk_version");
                        if (!(TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(optString))) {
                            stringBuilder2.append(charSequence);
                            stringBuilder2.append("==");
                            stringBuilder2.append(optString);
                            stringBuilder2.append("&=");
                        }
                    }
                    if (b.has("dplus")) {
                        str3 = b.optJSONObject("header").optString("sdk_version");
                        if (b.has("analytics")) {
                            optString = e.an;
                            if (!(stringBuilder2.toString().contains(e.an) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(str3))) {
                                stringBuilder2.append(optString);
                                stringBuilder2.append("==");
                                stringBuilder2.append(str3);
                                stringBuilder2.append("&=");
                            }
                        } else {
                            optString = e.am;
                            if (!(TextUtils.isEmpty(optString) || TextUtils.isEmpty(str3))) {
                                stringBuilder2.append(optString);
                                stringBuilder2.append("==");
                                stringBuilder2.append(str3);
                                stringBuilder2.append("&=");
                            }
                        }
                    }
                    if (b.has(e.ak)) {
                        str3 = e.aq;
                        optString = b.optJSONObject("header").optString(e.aw);
                        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(optString))) {
                            stringBuilder2.append(str3);
                            stringBuilder2.append("==");
                            stringBuilder2.append(optString);
                            stringBuilder2.append("&=");
                        }
                    }
                }
                str2 = stringBuilder2.toString();
                if (TextUtils.isEmpty(str2)) {
                    return a(101, b);
                }
                if (str2.endsWith("&=")) {
                    str2 = str2.substring(0, str2.length() - 2);
                }
            } else {
                str2 = null;
            }
            if (b != null) {
                try {
                    com.umeng.commonsdk.statistics.idtracking.e a2 = com.umeng.commonsdk.statistics.idtracking.e.a(context);
                    if (a2 != null) {
                        a2.a();
                        encodeToString = Base64.encodeToString(new s().a(a2.b()), 0);
                        if (!TextUtils.isEmpty(encodeToString)) {
                            JSONObject jSONObject4 = b.getJSONObject("header");
                            jSONObject4.put(e.V, encodeToString);
                            b.put("header", jSONObject4);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (b != null) {
                if (DataHelper.largeThanMaxSize((long) b.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, b);
                }
            }
            if (b != null) {
                a = a(context, b.toString().getBytes());
                if (a == null) {
                    return a(111, b);
                }
            }
            a = null;
            if (a != null && DataHelper.largeThanMaxSize((long) a.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, b);
            }
            int a3 = a(context, a, str2, b != null ? b.optJSONObject("header").optString("app_version") : null);
            if (a3 != 0) {
                return a(a3, b);
            }
            if (ULog.DEBUG) {
                encodeToString = c;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("constructHeader size is ");
                stringBuilder2.append(b.toString().getBytes().length);
                Log.i(encodeToString, stringBuilder2.toString());
            }
            return b;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    b = new JSONObject();
                    try {
                        b.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject3 = b;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                    jSONObject3 = b;
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (jSONObject2 != null) {
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                if (jSONObject2 != null) {
                    Iterator keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        Object next2 = keys2.next();
                        if (next2 != null && (next2 instanceof String)) {
                            String str4 = (String) next2;
                            if (!(str4 == null || jSONObject2.opt(str4) == null)) {
                                try {
                                    jSONObject3.put(str4, jSONObject2.opt(str4));
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    }
                }
            }
            return a(110, jSONObject3);
        }
    }
}
