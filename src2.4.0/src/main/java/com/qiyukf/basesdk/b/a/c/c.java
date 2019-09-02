package com.qiyukf.basesdk.b.a.c;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.a;

public final class c {
    private static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("vframe=");
        stringBuilder.append(1);
        return stringBuilder.toString();
    }

    public static final String a(String str) {
        if (TextUtils.isEmpty(null) || a.d() == null || TextUtils.isEmpty(a.d().nosDownload)) {
            return str;
        }
        try {
            String substring = str.substring(0, str.indexOf(HttpUtils.PATHS_SEPARATOR, str.indexOf("://") + 3));
            if (substring.endsWith(a.d().nosDownload)) {
                return str.replace(substring, null);
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* JADX WARNING: Missing block: B:20:0x0047, code skipped:
            if (r5 > 0) goto L_0x004e;
     */
    /* JADX WARNING: Missing block: B:22:0x004c, code skipped:
            if (r5 <= 0) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:23:0x004e, code skipped:
            r1 = 1;
     */
    public static final java.lang.String a(java.lang.String r4, int r5, int r6) {
        /*
        r0 = com.qiyukf.basesdk.b.a.c.d.Internal;
        if (r6 <= 0) goto L_0x0016;
    L_0x0004:
        if (r5 <= 0) goto L_0x0016;
    L_0x0006:
        if (r5 <= r6) goto L_0x000a;
    L_0x0008:
        r5 = r5 / r6;
        goto L_0x000c;
    L_0x000a:
        r5 = r6 / r5;
    L_0x000c:
        r6 = 4;
        if (r5 <= r6) goto L_0x0013;
    L_0x000f:
        r5 = com.qiyukf.basesdk.b.a.c.d.External;
    L_0x0011:
        r0 = r5;
        goto L_0x0016;
    L_0x0013:
        r5 = com.qiyukf.basesdk.b.a.c.d.Internal;
        goto L_0x0011;
    L_0x0016:
        r5 = com.qiyukf.basesdk.a.c();
        if (r5 > 0) goto L_0x0032;
    L_0x001c:
        r5 = com.qiyukf.basesdk.a.a();
        r5 = r5.getResources();
        r5 = r5.getDisplayMetrics();
        r6 = r5.widthPixels;
        r5 = r5.heightPixels;
        r5 = java.lang.Math.min(r6, r5);
        r5 = r5 / 2;
    L_0x0032:
        r6 = 1;
        r1 = 0;
        if (r5 < 0) goto L_0x004f;
    L_0x0036:
        if (r5 >= 0) goto L_0x0039;
    L_0x0038:
        goto L_0x004f;
    L_0x0039:
        r2 = com.qiyukf.basesdk.b.a.c.c.AnonymousClass1.a;
        r3 = r0.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x004a;
            case 2: goto L_0x0045;
            case 3: goto L_0x0045;
            default: goto L_0x0044;
        };
    L_0x0044:
        goto L_0x004f;
    L_0x0045:
        if (r5 <= 0) goto L_0x004f;
    L_0x0047:
        if (r5 <= 0) goto L_0x004f;
    L_0x0049:
        goto L_0x004e;
    L_0x004a:
        if (r5 > 0) goto L_0x004e;
    L_0x004c:
        if (r5 <= 0) goto L_0x004f;
    L_0x004e:
        r1 = r6;
    L_0x004f:
        if (r1 != 0) goto L_0x006d;
    L_0x0051:
        r4 = new java.lang.IllegalArgumentException;
        r6 = new java.lang.StringBuilder;
        r0 = "width=";
        r6.<init>(r0);
        r6.append(r5);
        r0 = ", height=";
        r6.append(r0);
        r6.append(r5);
        r5 = r6.toString();
        r4.<init>(r5);
        throw r4;
    L_0x006d:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r1 = "thumbnail=";
        r6.append(r1);
        r6.append(r5);
        r1 = com.qiyukf.basesdk.b.a.c.c.AnonymousClass1.a;
        r2 = r0.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x009f;
            case 2: goto L_0x009c;
            case 3: goto L_0x0099;
            default: goto L_0x0085;
        };
    L_0x0085:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r6 = "thumb: ";
        r5.<init>(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0099:
        r0 = "z";
        goto L_0x00a1;
    L_0x009c:
        r0 = "y";
        goto L_0x00a1;
    L_0x009f:
        r0 = "x";
    L_0x00a1:
        r6.append(r0);
        r6.append(r5);
        r5 = "&imageView&type=jpg";
        r6.append(r5);
        r5 = "?";
        r5 = r4.contains(r5);
        if (r5 == 0) goto L_0x00cd;
    L_0x00b4:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r4);
        r4 = "&";
    L_0x00be:
        r5.append(r4);
        r4 = r6.toString();
        r5.append(r4);
        r4 = r5.toString();
        return r4;
    L_0x00cd:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r4);
        r4 = "?";
        goto L_0x00be;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.a.c.c.a(java.lang.String, int, int):java.lang.String");
    }

    public static final String b(String str) {
        StringBuilder stringBuilder;
        if (str.contains(HttpUtils.URL_AND_PARA_SEPARATOR)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            str = HttpUtils.PARAMETERS_SEPARATOR;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            str = HttpUtils.URL_AND_PARA_SEPARATOR;
        }
        stringBuilder.append(str);
        stringBuilder.append(a());
        return stringBuilder.toString();
    }
}
