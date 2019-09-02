package com.geetest.mobinfo;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.location.BDLocation;
import com.bangcle.andJni.JniLib1557756502;
import java.io.File;
import org.json.JSONObject;

/* compiled from: IdHelper */
public class t {
    private static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v.a());
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static JSONObject a(String str, String str2, String str3, String str4, String str5, String str6) {
        return (JSONObject) JniLib1557756502.cL(str, str2, str3, str4, str5, str6, Integer.valueOf(159));
    }

    private static void a(String str, String str2) {
        JniLib1557756502.cV(str, str2, Integer.valueOf(GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL));
    }

    public static void a(String str, String str2, String str3) {
        JniLib1557756502.cV(str, str2, str3, Integer.valueOf(BDLocation.TypeNetWorkLocation));
    }

    private static String b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(str));
        stringBuilder.append(File.separator);
        stringBuilder.append("dp_sys_log.trace");
        return stringBuilder.toString();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072 A:{SYNTHETIC, Splitter:B:34:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0078 A:{SYNTHETIC, Splitter:B:39:0x0078} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:?, code skipped:
            r0.close();
     */
    private static java.lang.String c(java.lang.String r5) {
        /*
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x006e }
        r2 = a(r5);	 Catch:{ Exception -> 0x006e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x006e }
        r1 = r1.exists();	 Catch:{ Exception -> 0x006e }
        if (r1 != 0) goto L_0x0013;
    L_0x0010:
        r5 = "$unknown";
        return r5;
    L_0x0013:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x006e }
        r2 = b(r5);	 Catch:{ Exception -> 0x006e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x006e }
        r1 = r1.exists();	 Catch:{ Exception -> 0x006e }
        if (r1 != 0) goto L_0x0025;
    L_0x0022:
        r5 = "$unknown";
        return r5;
    L_0x0025:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006e }
        r2 = "";
        r1.<init>(r2);	 Catch:{ Exception -> 0x006e }
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x006e }
        r5 = b(r5);	 Catch:{ Exception -> 0x006e }
        r2.<init>(r5);	 Catch:{ Exception -> 0x006e }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
    L_0x0039:
        r0 = r2.read(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        if (r0 <= 0) goto L_0x0049;
    L_0x003f:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        r4 = 0;
        r3.<init>(r5, r4, r0);	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        r1.append(r3);	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        goto L_0x0039;
    L_0x0049:
        r2.close();	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        r5 = r1.toString();	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        if (r5 == 0) goto L_0x0059;
    L_0x0056:
        r5 = "$unknown";
        goto L_0x0061;
    L_0x0059:
        r5 = r1.toString();	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        r5 = com.geetest.mobinfo.l.b(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
    L_0x0061:
        if (r2 == 0) goto L_0x0066;
    L_0x0063:
        r2.close();	 Catch:{ Exception -> 0x0066 }
    L_0x0066:
        return r5;
    L_0x0067:
        r5 = move-exception;
        r0 = r2;
        goto L_0x0076;
    L_0x006a:
        r0 = r2;
        goto L_0x006e;
    L_0x006c:
        r5 = move-exception;
        goto L_0x0076;
    L_0x006e:
        r5 = "$unknown";
        if (r0 == 0) goto L_0x0075;
    L_0x0072:
        r0.close();	 Catch:{ Exception -> 0x0075 }
    L_0x0075:
        return r5;
    L_0x0076:
        if (r0 == 0) goto L_0x007b;
    L_0x0078:
        r0.close();	 Catch:{ Exception -> 0x007b }
    L_0x007b:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.mobinfo.t.c(java.lang.String):java.lang.String");
    }
}
