package com.geetest.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: DataModel */
public final class O000o0 {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0124 A:{Catch:{ Exception -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011c A:{Catch:{ Exception -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0189 A:{Catch:{ Exception -> 0x0222 }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0181 A:{Catch:{ Exception -> 0x0222 }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011c A:{Catch:{ Exception -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0124 A:{Catch:{ Exception -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0181 A:{Catch:{ Exception -> 0x0222 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0189 A:{Catch:{ Exception -> 0x0222 }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0124 A:{Catch:{ Exception -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011c A:{Catch:{ Exception -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0189 A:{Catch:{ Exception -> 0x0222 }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0181 A:{Catch:{ Exception -> 0x0222 }} */
    public static java.lang.String O000000o(android.content.Context r14) {
        /*
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r0 = r14.getPackageManager();
        r1 = "unknown";
        r2 = "null";
        r3 = "null";
        r4 = 0;
        r5 = r14.getPackageName();	 Catch:{ NameNotFoundException -> 0x0036 }
        r5 = r0.getPackageInfo(r5, r4);	 Catch:{ NameNotFoundException -> 0x0036 }
        r6 = r5.versionCode;	 Catch:{ NameNotFoundException -> 0x0036 }
        if (r6 != 0) goto L_0x001e;
    L_0x001c:
        r6 = r4;
        goto L_0x0020;
    L_0x001e:
        r6 = r5.versionCode;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x0020:
        r7 = r5.packageName;	 Catch:{ NameNotFoundException -> 0x0033 }
        r2 = r5.versionName;	 Catch:{ NameNotFoundException -> 0x0031 }
        r1 = r14.getApplicationInfo();	 Catch:{ NameNotFoundException -> 0x002f }
        r0 = r0.getApplicationLabel(r1);	 Catch:{ NameNotFoundException -> 0x002f }
        r0 = (java.lang.String) r0;	 Catch:{ NameNotFoundException -> 0x002f }
        goto L_0x003e;
    L_0x002f:
        r0 = move-exception;
        goto L_0x003a;
    L_0x0031:
        r0 = move-exception;
        goto L_0x0039;
    L_0x0033:
        r0 = move-exception;
        r7 = r2;
        goto L_0x0039;
    L_0x0036:
        r0 = move-exception;
        r7 = r2;
        r6 = r4;
    L_0x0039:
        r2 = r1;
    L_0x003a:
        r0.printStackTrace();
        r0 = r3;
    L_0x003e:
        r1 = android.os.Build.BRAND;
        if (r1 != 0) goto L_0x0045;
    L_0x0042:
        r1 = "unknown";
        goto L_0x0047;
    L_0x0045:
        r1 = android.os.Build.BRAND;
    L_0x0047:
        r3 = android.os.Build.MODEL;
        if (r3 != 0) goto L_0x004e;
    L_0x004b:
        r3 = "unknown";
        goto L_0x0050;
    L_0x004e:
        r3 = android.os.Build.MODEL;
    L_0x0050:
        r5 = java.util.Locale.getDefault();
        r5 = r5.getLanguage();
        if (r5 != 0) goto L_0x005d;
    L_0x005a:
        r5 = "unknown";
        goto L_0x0065;
    L_0x005d:
        r5 = java.util.Locale.getDefault();
        r5 = r5.getLanguage();
    L_0x0065:
        r8 = android.os.Build.VERSION.RELEASE;
        if (r8 != 0) goto L_0x006c;
    L_0x0069:
        r8 = "unknown";
        goto L_0x006e;
    L_0x006c:
        r8 = android.os.Build.VERSION.RELEASE;
    L_0x006e:
        r9 = java.util.Locale.getDefault();
        r9 = r9.getCountry();
        if (r9 != 0) goto L_0x007b;
    L_0x0078:
        r9 = "unknown";
        goto L_0x0083;
    L_0x007b:
        r9 = java.util.Locale.getDefault();
        r9 = r9.getCountry();
    L_0x0083:
        r10 = r14.getResources();
        r10 = r10.getDisplayMetrics();
        r11 = r10.widthPixels;
        if (r11 != 0) goto L_0x0091;
    L_0x008f:
        r11 = r4;
        goto L_0x0093;
    L_0x0091:
        r11 = r10.widthPixels;
    L_0x0093:
        r12 = r10.heightPixels;
        if (r12 != 0) goto L_0x0099;
    L_0x0097:
        r10 = r4;
        goto L_0x009b;
    L_0x0099:
        r10 = r10.heightPixels;
    L_0x009b:
        r12 = new org.json.JSONObject;
        r12.<init>();
        r13 = "build";
        r6 = java.lang.String.valueOf(r6);	 Catch:{ Exception -> 0x0222 }
        r12.put(r13, r6);	 Catch:{ Exception -> 0x0222 }
        r6 = "release";
        r12.put(r6, r2);	 Catch:{ Exception -> 0x0222 }
        r2 = "br";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0222 }
        r6.<init>();	 Catch:{ Exception -> 0x0222 }
        r13 = com.geetest.sdk.O0Oo0o0.O00000o0(r14);	 Catch:{ Exception -> 0x0222 }
        r6.append(r13);	 Catch:{ Exception -> 0x0222 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0222 }
        r12.put(r2, r6);	 Catch:{ Exception -> 0x0222 }
        r2 = "bs";
        r6 = com.geetest.sdk.O0Oo0o0.O00000o(r14);	 Catch:{ Exception -> 0x0222 }
        r12.put(r2, r6);	 Catch:{ Exception -> 0x0222 }
        r2 = "carrier";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0222 }
        r6.<init>();	 Catch:{ Exception -> 0x0222 }
        r13 = com.geetest.sdk.O0Oo0o0.O00000oO(r14);	 Catch:{ Exception -> 0x0222 }
        r6.append(r13);	 Catch:{ Exception -> 0x0222 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0222 }
        r12.put(r2, r6);	 Catch:{ Exception -> 0x0222 }
        r2 = "cell";
        r6 = com.geetest.sdk.O0Oo00.O00000Oo(r14);	 Catch:{ Exception -> 0x0222 }
        r12.put(r2, r6);	 Catch:{ Exception -> 0x0222 }
        r2 = "coun";
        r12.put(r2, r9);	 Catch:{ Exception -> 0x0222 }
        r2 = "dh";
        r6 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x0222 }
        r12.put(r2, r6);	 Catch:{ Exception -> 0x0222 }
        r2 = "dm";
        r12.put(r2, r1);	 Catch:{ Exception -> 0x0222 }
        r1 = "dns";
        r2 = com.geetest.sdk.O0Oo0o0.O00000o0();	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = "dw";
        r2 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = "dn";
        r12.put(r1, r3);	 Catch:{ Exception -> 0x0222 }
        r1 = "android.permission.READ_PHONE_STATE";
        r1 = android.support.v4.content.ContextCompat.checkSelfPermission(r14, r1);	 Catch:{ Exception -> 0x0149 }
        if (r1 == 0) goto L_0x0124;
    L_0x011c:
        r1 = "imei";
        r2 = "unknown";
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0149 }
        goto L_0x0154;
    L_0x0124:
        r1 = "phone";
        r1 = r14.getSystemService(r1);	 Catch:{ Exception -> 0x0149 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0149 }
        if (r1 == 0) goto L_0x0141;
    L_0x012e:
        r2 = r1.getDeviceId();	 Catch:{ Exception -> 0x0149 }
        if (r2 != 0) goto L_0x0137;
    L_0x0134:
        r1 = "unknown";
        goto L_0x013b;
    L_0x0137:
        r1 = r1.getDeviceId();	 Catch:{ Exception -> 0x0149 }
    L_0x013b:
        r2 = "imei";
        r12.put(r2, r1);	 Catch:{ Exception -> 0x0149 }
        goto L_0x0154;
    L_0x0141:
        r1 = "imei";
        r2 = "unknown";
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0149 }
        goto L_0x0154;
    L_0x0149:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x0222 }
        r1 = "imei";
        r2 = "unknown";
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
    L_0x0154:
        r1 = "lang";
        r12.put(r1, r5);	 Catch:{ Exception -> 0x0222 }
        r1 = "mac";
        r2 = com.geetest.sdk.O0Oo0o0.O00000oo(r14);	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = "mems";
        r2 = com.geetest.sdk.O0Oo0o0.O0000O0o(r14);	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = "ostype";
        r2 = "android";
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = "osver";
        r2 = java.lang.String.valueOf(r8);	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = com.geetest.sdk.O0Oo0o0.O0000OOo(r14);	 Catch:{ Exception -> 0x0222 }
        if (r1 == 0) goto L_0x0189;
    L_0x0181:
        r1 = "py";
        r2 = "1";
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        goto L_0x0190;
    L_0x0189:
        r1 = "py";
        r2 = "0";
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
    L_0x0190:
        r1 = "ssid";
        r2 = com.geetest.sdk.O0Oo0o0.O00000Oo(r14);	 Catch:{ Exception -> 0x0222 }
        r3 = "UTF-8";
        r2 = java.net.URLEncoder.encode(r2, r3);	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = "route";
        r2 = com.geetest.sdk.O0Oo0o0.O00000oo(r14);	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = "ts";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0222 }
        r2.<init>();	 Catch:{ Exception -> 0x0222 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0222 }
        r2.append(r5);	 Catch:{ Exception -> 0x0222 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r2);	 Catch:{ Exception -> 0x0222 }
        r1 = "vendor";
        r12.put(r1, r7);	 Catch:{ Exception -> 0x0222 }
        r1 = "app";
        r2 = "UTF-8";
        r0 = java.net.URLEncoder.encode(r0, r2);	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r0);	 Catch:{ Exception -> 0x0222 }
        r0 = "gt3";
        r1 = "4.0.7";
        r12.put(r0, r1);	 Catch:{ Exception -> 0x0222 }
        r0 = "ip";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0222 }
        r2 = "{\"ipv6\":";
        r1.<init>(r2);	 Catch:{ Exception -> 0x0222 }
        r2 = com.geetest.sdk.O0Oo0o0.O000000o();	 Catch:{ Exception -> 0x0222 }
        r1.append(r2);	 Catch:{ Exception -> 0x0222 }
        r2 = com.geetest.sdk.O0Oo0o0.O00000Oo();	 Catch:{ Exception -> 0x0222 }
        r1.append(r2);	 Catch:{ Exception -> 0x0222 }
        r2 = "\"}";
        r1.append(r2);	 Catch:{ Exception -> 0x0222 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0222 }
        r12.put(r0, r1);	 Catch:{ Exception -> 0x0222 }
        r0 = "androidid";
        r1 = com.geetest.sdk.O0Oo0o0.O000000o(r14);	 Catch:{ Exception -> 0x0222 }
        r12.put(r0, r1);	 Catch:{ Exception -> 0x0222 }
        r0 = "mydata";
        r0 = r14.getSharedPreferences(r0, r4);	 Catch:{ Exception -> 0x0222 }
        r1 = "uuid";
        r2 = "uuid";
        r3 = "unknown";
        r0 = r0.getString(r2, r3);	 Catch:{ Exception -> 0x0222 }
        r12.put(r1, r0);	 Catch:{ Exception -> 0x0222 }
        r0 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0222 }
        r14 = O00000Oo(r14);	 Catch:{ Exception -> 0x0222 }
        r0.<init>(r14);	 Catch:{ Exception -> 0x0222 }
        r14 = "appList";
        r12.put(r14, r0);	 Catch:{ Exception -> 0x0222 }
        goto L_0x0226;
    L_0x0222:
        r14 = move-exception;
        r14.printStackTrace();
    L_0x0226:
        r14 = r12.toString();
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.O000o0.O000000o(android.content.Context):java.lang.String");
    }

    private static List<JSONObject> O00000Oo(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("n", packageInfo.packageName);
                jSONObject.put("v", packageInfo.versionName);
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    jSONObject.put("s", "0");
                } else {
                    jSONObject.put("s", "1");
                }
                arrayList.add(jSONObject);
            }
        } catch (Exception e) {
            O0OOO00.O000000o(e.toString());
        }
        return arrayList;
    }
}
