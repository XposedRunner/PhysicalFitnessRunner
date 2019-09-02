package cn.jiguang.d.d;

import cn.jiguang.net.SSLTrustManager;

public final class h {
    public static SSLTrustManager a;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A:{Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d A:{Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a A:{Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b5 A:{Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0058 */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015d A:{Splitter:B:5:0x000b, ExcHandler: AssertionError (r6_26 'e' java.lang.AssertionError A:{Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }}), Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015b A:{Splitter:B:5:0x000b, ExcHandler: Exception (r6_23 'e' java.lang.Exception A:{Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }}), Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:61:0x0159, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:63:0x015b, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:65:0x015d, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:70:0x0178, code skipped:
            r8 = new java.lang.StringBuilder("Exception - ");
            r8.append(r6.getMessage());
     */
    /* JADX WARNING: Missing block: B:71:0x018f, code skipped:
            return new cn.jiguang.d.d.ab(-2, r8.toString());
     */
    /* JADX WARNING: Missing block: B:72:0x0190, code skipped:
            r8 = new java.lang.StringBuilder("Exception - ");
            r8.append(r6.getMessage());
     */
    /* JADX WARNING: Missing block: B:73:0x01a7, code skipped:
            return new cn.jiguang.d.d.ab(-2, r8.toString());
     */
    /* JADX WARNING: Missing block: B:74:0x01a8, code skipped:
            r8 = new java.lang.StringBuilder("Catch AssertionError to avoid http close crash - ");
            r8.append(r6.getMessage());
     */
    /* JADX WARNING: Missing block: B:75:0x01bf, code skipped:
            return new cn.jiguang.d.d.ab(-2, r8.toString());
     */
    public static cn.jiguang.d.d.ab a(java.lang.String r6, java.lang.String r7, android.content.Context r8, boolean r9, int r10, int r11) {
        /*
        r9 = -2;
        r0 = "UTF-8";
        r7 = r7.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x015f }
        r7 = cn.jiguang.d.h.x.a(r7);	 Catch:{ IOException -> 0x0140 }
        r0 = new cn.jiguang.net.HttpRequest;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.<init>(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setConnectTimeout(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setReadTimeout(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = 1;
        r0.setDoOutPut(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setDoInPut(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r2 = cn.jiguang.d.h.a.a.a();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r3 = 2;
        if (r11 != r3) goto L_0x002d;
    L_0x002a:
        r4 = "0102030405060708";
        goto L_0x002f;
    L_0x002d:
        r4 = "iop203040506aPk!";
    L_0x002f:
        r7 = cn.jiguang.d.h.a.a.a(r7, r2, r4);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setBody(r7);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r4 = "Content-Length";
        r5 = r7.length;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setRequestProperty(r4, r5);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setNeedRetryIfHttpsFailed(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r4 = a;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        if (r4 != 0) goto L_0x0058;
    L_0x0047:
        r4 = cn.jiguang.service.Protocol.getCerTificate();	 Catch:{ Throwable -> 0x0058, AssertionError -> 0x015d, Exception -> 0x015b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0058, AssertionError -> 0x015d, Exception -> 0x015b }
        if (r5 != 0) goto L_0x0058;
    L_0x0051:
        r5 = new cn.jiguang.net.SSLTrustManager;	 Catch:{ Throwable -> 0x0058, AssertionError -> 0x015d, Exception -> 0x015b }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x0058, AssertionError -> 0x015d, Exception -> 0x015b }
        a = r5;	 Catch:{ Throwable -> 0x0058, AssertionError -> 0x015d, Exception -> 0x015b }
    L_0x0058:
        r4 = a;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        if (r4 == 0) goto L_0x0061;
    L_0x005c:
        r4 = a;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setSslTrustManager(r4);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
    L_0x0061:
        r4 = "Accept";
        r5 = "application/jason";
        r0.setRequestProperty(r4, r5);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r4 = "Accept-Encoding";
        r5 = "gzip";
        r0.setRequestProperty(r4, r5);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r4 = "X-App-Key";
        r5 = cn.jiguang.d.a.b(r8);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setRequestProperty(r4, r5);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        if (r11 != r3) goto L_0x008d;
    L_0x007a:
        r0.setHaveRspData(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setRspDatazip(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setNeedErrorInput(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = cn.jiguang.d.d.x.a(r2);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7 = "Authorization";
    L_0x0089:
        r0.setRequestProperty(r7, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        goto L_0x00ac;
    L_0x008d:
        r0.setHaveRspData(r1);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r0.setRspDatazip(r1);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = cn.jiguang.g.a.a(r7);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = cn.jiguang.d.d.x.a(r6, r2);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7 = "Authorization";
        r11 = new java.lang.StringBuilder;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r2 = "Basic ";
        r11.<init>(r2);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r11.append(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r11.toString();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        goto L_0x0089;
    L_0x00ac:
        r6 = "Charset";
        r7 = "UTF-8";
        r0.setRequestProperty(r6, r7);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
    L_0x00b3:
        if (r10 <= 0) goto L_0x0138;
    L_0x00b5:
        r10 = r10 + -1;
        r6 = cn.jiguang.net.HttpUtils.httpPost(r8, r0);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7 = r6.getResponseCode();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r11 = "HttpHelper";
        r2 = new java.lang.StringBuilder;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r3 = "status code:";
        r2.<init>(r3);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r2.append(r7);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r3 = " retry left:";
        r2.append(r3);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r2.append(r10);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r2 = r2.toString();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        cn.jiguang.e.c.a(r11, r2);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r11 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 == r11) goto L_0x012e;
    L_0x00de:
        r11 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r7 == r11) goto L_0x0123;
    L_0x00e2:
        r11 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        r2 = -1;
        if (r7 == r11) goto L_0x0119;
    L_0x00e7:
        r11 = 410; // 0x19a float:5.75E-43 double:2.026E-321;
        if (r7 == r11) goto L_0x0119;
    L_0x00eb:
        r11 = 429; // 0x1ad float:6.01E-43 double:2.12E-321;
        if (r7 == r11) goto L_0x0119;
    L_0x00ef:
        r11 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
        if (r7 == r11) goto L_0x010f;
    L_0x00f3:
        r11 = 3005; // 0xbbd float:4.211E-42 double:1.4847E-320;
        if (r7 == r11) goto L_0x00b3;
    L_0x00f7:
        r8 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r7 < r8) goto L_0x0105;
    L_0x00fb:
        r7 = new cn.jiguang.d.d.ab;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r6.getResponseBody();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7.<init>(r2, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        return r7;
    L_0x0105:
        r7 = new cn.jiguang.d.d.ab;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r6.getResponseBody();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7.<init>(r9, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        return r7;
    L_0x010f:
        r7 = new cn.jiguang.d.d.ab;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r6.getResponseBody();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7.<init>(r9, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        return r7;
    L_0x0119:
        r7 = new cn.jiguang.d.d.ab;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r6.getResponseBody();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7.<init>(r2, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        return r7;
    L_0x0123:
        r7 = new cn.jiguang.d.d.ab;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r8 = -3;
        r6 = r6.getResponseBody();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7.<init>(r8, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        return r7;
    L_0x012e:
        r7 = new cn.jiguang.d.d.ab;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r6.getResponseBody();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7.<init>(r1, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        return r7;
    L_0x0138:
        r6 = new cn.jiguang.d.d.ab;
        r7 = "Failed - retry enough";
        r6.<init>(r9, r7);
        return r6;
    L_0x0140:
        r6 = move-exception;
        r7 = new cn.jiguang.d.d.ab;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r8 = new java.lang.StringBuilder;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r10 = "zip err:";
        r8.<init>(r10);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r6.getMessage();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r8.append(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r8.toString();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7.<init>(r9, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        return r7;
    L_0x0159:
        r6 = move-exception;
        goto L_0x0178;
    L_0x015b:
        r6 = move-exception;
        goto L_0x0190;
    L_0x015d:
        r6 = move-exception;
        goto L_0x01a8;
    L_0x015f:
        r6 = move-exception;
        r7 = new cn.jiguang.d.d.ab;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r8 = new java.lang.StringBuilder;	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r10 = "Exception - ";
        r8.<init>(r10);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r6.getMessage();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r8.append(r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r6 = r8.toString();	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        r7.<init>(r9, r6);	 Catch:{ AssertionError -> 0x015d, Exception -> 0x015b, Throwable -> 0x0159 }
        return r7;
    L_0x0178:
        r7 = new cn.jiguang.d.d.ab;
        r8 = new java.lang.StringBuilder;
        r10 = "Exception - ";
        r8.<init>(r10);
        r6 = r6.getMessage();
        r8.append(r6);
        r6 = r8.toString();
        r7.<init>(r9, r6);
        return r7;
    L_0x0190:
        r7 = new cn.jiguang.d.d.ab;
        r8 = new java.lang.StringBuilder;
        r10 = "Exception - ";
        r8.<init>(r10);
        r6 = r6.getMessage();
        r8.append(r6);
        r6 = r8.toString();
        r7.<init>(r9, r6);
        return r7;
    L_0x01a8:
        r7 = new cn.jiguang.d.d.ab;
        r8 = new java.lang.StringBuilder;
        r10 = "Catch AssertionError to avoid http close crash - ";
        r8.<init>(r10);
        r6 = r6.getMessage();
        r8.append(r6);
        r6 = r8.toString();
        r7.<init>(r9, r6);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.d.h.a(java.lang.String, java.lang.String, android.content.Context, boolean, int, int):cn.jiguang.d.d.ab");
    }
}
