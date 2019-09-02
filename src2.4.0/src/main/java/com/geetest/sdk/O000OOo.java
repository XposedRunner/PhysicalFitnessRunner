package com.geetest.sdk;

import java.net.URL;

/* compiled from: HttpUtils */
public final class O000OOo {
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0111 A:{Catch:{ Exception -> 0x0115 }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0108 A:{Catch:{ Exception -> 0x0115 }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A:{SYNTHETIC, Splitter:B:32:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095 A:{Catch:{ Exception -> 0x0115 }} */
    public static java.lang.String O000000o(java.lang.String r10) {
        /*
        r10 = O00000Oo(r10);
        r0 = "https";
        r1 = r10.getProtocol();	 Catch:{ Exception -> 0x0115 }
        r1 = r1.toLowerCase();	 Catch:{ Exception -> 0x0115 }
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x0115 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = -1;
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = 1;
        r5 = 0;
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r7 = 0;
        if (r0 == 0) goto L_0x0099;
    L_0x001e:
        r0 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0087 }
        r0.<init>();	 Catch:{ Exception -> 0x0087 }
        r10 = r10.openConnection();	 Catch:{ Exception -> 0x0087 }
        r10 = (javax.net.ssl.HttpsURLConnection) r10;	 Catch:{ Exception -> 0x0087 }
        r5 = "GET";
        r10.setRequestMethod(r5);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r10.setDoInput(r4);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r10.setDoOutput(r7);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r10.setConnectTimeout(r6);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r10.setReadTimeout(r6);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r10.setInstanceFollowRedirects(r7);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r10.connect();	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r3 = new byte[r3];	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r4 = r10.getResponseCode();	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r5 = "responseCode-->";
        r6 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r5 = r5.concat(r6);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        com.geetest.sdk.O0OOO00.O000000o(r5);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r5 = r10.getInputStream();	 Catch:{ Exception -> 0x0081, all -> 0x007f }
    L_0x0057:
        r6 = r5.read(r3);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        if (r6 == r2) goto L_0x0068;
    L_0x005d:
        r8 = new java.lang.String;	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r9 = "UTF-8";
        r8.<init>(r3, r7, r6, r9);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r0.append(r8);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        goto L_0x0057;
    L_0x0068:
        r5.close();	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        if (r4 != r1) goto L_0x0077;
    L_0x006d:
        r0 = r0.toString();	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        if (r10 == 0) goto L_0x0076;
    L_0x0073:
        r10.disconnect();	 Catch:{ Exception -> 0x0115 }
    L_0x0076:
        return r0;
    L_0x0077:
        r0 = "";
        if (r10 == 0) goto L_0x007e;
    L_0x007b:
        r10.disconnect();	 Catch:{ Exception -> 0x0115 }
    L_0x007e:
        return r0;
    L_0x007f:
        r0 = move-exception;
        goto L_0x0093;
    L_0x0081:
        r0 = move-exception;
        r5 = r10;
        goto L_0x0088;
    L_0x0084:
        r0 = move-exception;
        r10 = r5;
        goto L_0x0093;
    L_0x0087:
        r0 = move-exception;
    L_0x0088:
        r0.printStackTrace();	 Catch:{ all -> 0x0084 }
        r10 = "";
        if (r5 == 0) goto L_0x0092;
    L_0x008f:
        r5.disconnect();	 Catch:{ Exception -> 0x0115 }
    L_0x0092:
        return r10;
    L_0x0093:
        if (r10 == 0) goto L_0x0098;
    L_0x0095:
        r10.disconnect();	 Catch:{ Exception -> 0x0115 }
    L_0x0098:
        throw r0;	 Catch:{ Exception -> 0x0115 }
    L_0x0099:
        r0 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x010c, all -> 0x0104 }
        r0.<init>();	 Catch:{ Exception -> 0x010c, all -> 0x0104 }
        r10 = r10.openConnection();	 Catch:{ Exception -> 0x010c, all -> 0x0104 }
        r10 = (java.net.HttpURLConnection) r10;	 Catch:{ Exception -> 0x010c, all -> 0x0104 }
        r5 = "GET";
        r10.setRequestMethod(r5);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r10.setDoInput(r4);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r10.setDoOutput(r7);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r10.setInstanceFollowRedirects(r7);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r10.setConnectTimeout(r6);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r10.setReadTimeout(r6);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r10.connect();	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r3 = new byte[r3];	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r5 = "responseCode-->";
        r4.<init>(r5);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r5 = r10.getResponseCode();	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r4.append(r5);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        com.geetest.sdk.O0OOO00.O000000o(r4);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r4 = r10.getInputStream();	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
    L_0x00d6:
        r5 = r4.read(r3);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        if (r5 == r2) goto L_0x00e7;
    L_0x00dc:
        r6 = new java.lang.String;	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r8 = "UTF-8";
        r6.<init>(r3, r7, r5, r8);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r0.append(r6);	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        goto L_0x00d6;
    L_0x00e7:
        r4.close();	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        r2 = r10.getResponseCode();	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        if (r2 != r1) goto L_0x00fa;
    L_0x00f0:
        r0 = r0.toString();	 Catch:{ Exception -> 0x010d, all -> 0x0102 }
        if (r10 == 0) goto L_0x00f9;
    L_0x00f6:
        r10.disconnect();	 Catch:{ Exception -> 0x0115 }
    L_0x00f9:
        return r0;
    L_0x00fa:
        r0 = "";
        if (r10 == 0) goto L_0x0101;
    L_0x00fe:
        r10.disconnect();	 Catch:{ Exception -> 0x0115 }
    L_0x0101:
        return r0;
    L_0x0102:
        r0 = move-exception;
        goto L_0x0106;
    L_0x0104:
        r0 = move-exception;
        r10 = r5;
    L_0x0106:
        if (r10 == 0) goto L_0x010b;
    L_0x0108:
        r10.disconnect();	 Catch:{ Exception -> 0x0115 }
    L_0x010b:
        throw r0;	 Catch:{ Exception -> 0x0115 }
    L_0x010c:
        r10 = r5;
    L_0x010d:
        r0 = "";
        if (r10 == 0) goto L_0x0114;
    L_0x0111:
        r10.disconnect();	 Catch:{ Exception -> 0x0115 }
    L_0x0114:
        return r0;
    L_0x0115:
        r10 = "";
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.O000OOo.O000000o(java.lang.String):java.lang.String");
    }

    private static URL O00000Oo(String str) {
        try {
            return new URL(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
