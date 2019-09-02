package cn.jpush.android.b;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0013 A:{LOOP_START, SYNTHETIC, LOOP:0: B:6:0x0013->B:23:0x0013, PHI: r1 r6 , Splitter:B:6:0x0013} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0013 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|(4:8|9|10|(2:24|12))|13|15|(2:25|18)(6:19|20|21|22|27|23)) */
    public static cn.jiguang.net.HttpResponse a(java.lang.String r5, int r6, long r7) {
        /*
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r6 < 0) goto L_0x000d;
    L_0x0006:
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r6 <= 0) goto L_0x000f;
    L_0x000d:
        r7 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
    L_0x000f:
        r6 = 0;
        r0 = 0;
        r1 = r6;
        r6 = r0;
    L_0x0013:
        r2 = new cn.jiguang.net.HttpRequest;	 Catch:{ AssertionError | Exception -> 0x0034, AssertionError | Exception -> 0x0034 }
        r2.<init>(r5);	 Catch:{ AssertionError | Exception -> 0x0034, AssertionError | Exception -> 0x0034 }
        r3 = "Connection";
        r4 = "Close";
        r2.setRequestProperty(r3, r4);	 Catch:{ AssertionError | Exception -> 0x0034, AssertionError | Exception -> 0x0034 }
        r3 = "Accept-Encoding";
        r4 = "identity";
        r2.setRequestProperty(r3, r4);	 Catch:{ AssertionError | Exception -> 0x0034, AssertionError | Exception -> 0x0034 }
        r2 = cn.jiguang.net.HttpUtils.httpGet(r0, r2);	 Catch:{ AssertionError | Exception -> 0x0034, AssertionError | Exception -> 0x0034 }
        r6 = r2.getResponseCode();	 Catch:{ AssertionError | Exception -> 0x0033, AssertionError | Exception -> 0x0033 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 != r3) goto L_0x0033;
    L_0x0032:
        return r2;
    L_0x0033:
        r6 = r2;
    L_0x0034:
        r2 = 5;
        if (r1 < r2) goto L_0x0038;
    L_0x0037:
        return r6;
    L_0x0038:
        r1 = r1 + 1;
        java.lang.Thread.sleep(r7);	 Catch:{ InterruptedException -> 0x0013 }
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.b.a.a(java.lang.String, int, long):cn.jiguang.net.HttpResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0082 A:{SYNTHETIC, Splitter:B:59:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0087 A:{Catch:{ Throwable -> 0x008a }} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036 A:{Splitter:B:8:0x0031, ExcHandler: all (r0_1 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x008f A:{SYNTHETIC, Splitter:B:68:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0082 A:{SYNTHETIC, Splitter:B:59:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0087 A:{Catch:{ Throwable -> 0x008a }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x008f A:{SYNTHETIC, Splitter:B:68:0x008f} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:10:0x0036, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:0x0037, code skipped:
            r1 = r0;
            r0 = r2;
     */
    /* JADX WARNING: Missing block: B:50:0x0073, code skipped:
            if (r5 != null) goto L_0x0075;
     */
    /* JADX WARNING: Missing block: B:51:0x0075, code skipped:
            r5.disconnect();
     */
    /* JADX WARNING: Missing block: B:52:0x0078, code skipped:
            return r3;
     */
    /* JADX WARNING: Missing block: B:70:0x0092, code skipped:
            if (r5 != null) goto L_0x0075;
     */
    private static byte[] a(java.lang.String r5) {
        /*
        r0 = 0;
        r1 = new java.net.URL;	 Catch:{ Throwable -> 0x008b, all -> 0x007d }
        r1.<init>(r5);	 Catch:{ Throwable -> 0x008b, all -> 0x007d }
        r5 = r1.openConnection();	 Catch:{ Throwable -> 0x008b, all -> 0x007d }
        r5 = (java.net.HttpURLConnection) r5;	 Catch:{ Throwable -> 0x008b, all -> 0x007d }
        r1 = "Accept-Encoding";
        r2 = "identity";
        r5.setRequestProperty(r1, r2);	 Catch:{ Throwable -> 0x007b, all -> 0x0079 }
        r1 = "Connection";
        r2 = "Close";
        r5.addRequestProperty(r1, r2);	 Catch:{ Throwable -> 0x007b, all -> 0x0079 }
        r1 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r5.setReadTimeout(r1);	 Catch:{ Throwable -> 0x007b, all -> 0x0079 }
        r1 = r5.getResponseCode();	 Catch:{ Throwable -> 0x007b, all -> 0x0079 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x006d;
    L_0x0027:
        r1 = r5.getContentLength();	 Catch:{ Throwable -> 0x007b, all -> 0x0079 }
        r2 = r5.getInputStream();	 Catch:{ Throwable -> 0x007b, all -> 0x0079 }
        if (r2 == 0) goto L_0x003d;
    L_0x0031:
        r3 = cn.jiguang.net.HttpUtils.readInputStream(r2);	 Catch:{ Throwable -> 0x003a, all -> 0x0036 }
        goto L_0x003e;
    L_0x0036:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x0080;
    L_0x003a:
        r3 = r0;
    L_0x003b:
        r0 = r2;
        goto L_0x008d;
    L_0x003d:
        r3 = r0;
    L_0x003e:
        if (r3 == 0) goto L_0x0062;
    L_0x0040:
        if (r1 != 0) goto L_0x0043;
    L_0x0042:
        goto L_0x0062;
    L_0x0043:
        r4 = 30720; // 0x7800 float:4.3048E-41 double:1.51777E-319;
        if (r1 <= r4) goto L_0x0052;
    L_0x0047:
        if (r2 == 0) goto L_0x004c;
    L_0x0049:
        r2.close();	 Catch:{ Throwable -> 0x0051 }
    L_0x004c:
        if (r5 == 0) goto L_0x0051;
    L_0x004e:
        r5.disconnect();	 Catch:{ Throwable -> 0x0051 }
    L_0x0051:
        return r0;
    L_0x0052:
        r4 = r3.length;	 Catch:{ Throwable -> 0x003b, all -> 0x0036 }
        if (r4 >= r1) goto L_0x0060;
    L_0x0055:
        if (r2 == 0) goto L_0x005a;
    L_0x0057:
        r2.close();	 Catch:{ Throwable -> 0x005f }
    L_0x005a:
        if (r5 == 0) goto L_0x005f;
    L_0x005c:
        r5.disconnect();	 Catch:{ Throwable -> 0x005f }
    L_0x005f:
        return r0;
    L_0x0060:
        r0 = r2;
        goto L_0x006e;
    L_0x0062:
        if (r2 == 0) goto L_0x0067;
    L_0x0064:
        r2.close();	 Catch:{ Throwable -> 0x006c }
    L_0x0067:
        if (r5 == 0) goto L_0x006c;
    L_0x0069:
        r5.disconnect();	 Catch:{ Throwable -> 0x006c }
    L_0x006c:
        return r0;
    L_0x006d:
        r3 = r0;
    L_0x006e:
        if (r0 == 0) goto L_0x0073;
    L_0x0070:
        r0.close();	 Catch:{ Throwable -> 0x0095 }
    L_0x0073:
        if (r5 == 0) goto L_0x0095;
    L_0x0075:
        r5.disconnect();	 Catch:{ Throwable -> 0x0095 }
        return r3;
    L_0x0079:
        r1 = move-exception;
        goto L_0x0080;
    L_0x007b:
        r3 = r0;
        goto L_0x008d;
    L_0x007d:
        r5 = move-exception;
        r1 = r5;
        r5 = r0;
    L_0x0080:
        if (r0 == 0) goto L_0x0085;
    L_0x0082:
        r0.close();	 Catch:{ Throwable -> 0x008a }
    L_0x0085:
        if (r5 == 0) goto L_0x008a;
    L_0x0087:
        r5.disconnect();	 Catch:{ Throwable -> 0x008a }
    L_0x008a:
        throw r1;
    L_0x008b:
        r5 = r0;
        r3 = r5;
    L_0x008d:
        if (r0 == 0) goto L_0x0092;
    L_0x008f:
        r0.close();	 Catch:{ Throwable -> 0x0095 }
    L_0x0092:
        if (r5 == 0) goto L_0x0095;
    L_0x0094:
        goto L_0x0075;
    L_0x0095:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.b.a.a(java.lang.String):byte[]");
    }

    public static byte[] a(String str, int i) {
        byte[] bArr = null;
        for (int i2 = 0; i2 < 2; i2++) {
            bArr = a(str);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    public static byte[] a(String str, int i, long j, int i2) {
        byte[] bArr = null;
        for (int i3 = 0; i3 < 4; i3++) {
            bArr = b(str, 5, 5000);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:92:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0096 A:{SYNTHETIC, Splitter:B:76:0x0096} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0082 A:{SYNTHETIC, Splitter:B:67:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x00d5 A:{SYNTHETIC, Splitter:B:113:0x00d5} */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x00bf A:{SYNTHETIC, Splitter:B:101:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x00c9 A:{SYNTHETIC} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x00b6 */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0096 A:{SYNTHETIC, Splitter:B:76:0x0096} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x009b  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x008d */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0082 A:{SYNTHETIC, Splitter:B:67:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x00bf A:{SYNTHETIC, Splitter:B:101:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x00c9 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0096 A:{SYNTHETIC, Splitter:B:76:0x0096} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0082 A:{SYNTHETIC, Splitter:B:67:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0074 A:{Splitter:B:14:0x002a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x00bf A:{SYNTHETIC, Splitter:B:101:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x00c9 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0096 A:{SYNTHETIC, Splitter:B:76:0x0096} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0082 A:{SYNTHETIC, Splitter:B:67:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0074 A:{Splitter:B:14:0x002a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x00d5 A:{SYNTHETIC, Splitter:B:113:0x00d5} */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x00da  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:52:0x0071, code skipped:
            if (r7 == null) goto L_0x008a;
     */
    /* JADX WARNING: Missing block: B:54:0x0074, code skipped:
            r9 = th;
     */
    /* JADX WARNING: Missing block: B:69:0x0085, code skipped:
            if (r7 == null) goto L_0x008a;
     */
    /* JADX WARNING: Missing block: B:71:0x0087, code skipped:
            r7.disconnect();
     */
    /* JADX WARNING: Missing block: B:72:0x008a, code skipped:
            r4 = r3;
            r3 = r7;
     */
    /* JADX WARNING: Missing block: B:102:?, code skipped:
            r0.close();
     */
    /* JADX WARNING: Missing block: B:105:0x00c4, code skipped:
            r3.disconnect();
     */
    /* JADX WARNING: Missing block: B:107:0x00c9, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:108:0x00ca, code skipped:
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:110:?, code skipped:
            java.lang.Thread.sleep(((long) r1) * r11);
     */
    private static byte[] b(java.lang.String r9, int r10, long r11) {
        /*
        if (r10 <= 0) goto L_0x0006;
    L_0x0002:
        r0 = 10;
        if (r10 <= r0) goto L_0x0007;
    L_0x0006:
        r10 = 1;
    L_0x0007:
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r2 < 0) goto L_0x0014;
    L_0x000d:
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0016;
    L_0x0014:
        r11 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
    L_0x0016:
        r0 = -1;
        r1 = 0;
        r2 = 0;
        r4 = r0;
        r5 = r1;
        r0 = r2;
        r3 = r0;
    L_0x001d:
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r7 = new java.net.URL;	 Catch:{ SSLPeerUnverifiedException -> 0x00b6, SSLHandshakeException -> 0x008d, Exception -> 0x007e }
        r7.<init>(r9);	 Catch:{ SSLPeerUnverifiedException -> 0x00b6, SSLHandshakeException -> 0x008d, Exception -> 0x007e }
        r7 = r7.openConnection();	 Catch:{ SSLPeerUnverifiedException -> 0x00b6, SSLHandshakeException -> 0x008d, Exception -> 0x007e }
        r7 = (java.net.HttpURLConnection) r7;	 Catch:{ SSLPeerUnverifiedException -> 0x00b6, SSLHandshakeException -> 0x008d, Exception -> 0x007e }
        r3 = "Accept-Encoding";
        r8 = "identity";
        r7.setRequestProperty(r3, r8);	 Catch:{ SSLPeerUnverifiedException -> 0x007a, SSLHandshakeException -> 0x0078, Exception -> 0x007f, all -> 0x0074 }
        r3 = "Connection";
        r8 = "Close";
        r7.addRequestProperty(r3, r8);	 Catch:{ SSLPeerUnverifiedException -> 0x007a, SSLHandshakeException -> 0x0078, Exception -> 0x007f, all -> 0x0074 }
        r3 = r7.getResponseCode();	 Catch:{ SSLPeerUnverifiedException -> 0x007a, SSLHandshakeException -> 0x0078, Exception -> 0x007f, all -> 0x0074 }
        if (r3 != r6) goto L_0x006c;
    L_0x003e:
        r4 = r7.getContentLength();	 Catch:{ SSLPeerUnverifiedException -> 0x006a, SSLHandshakeException -> 0x0068, Exception -> 0x0080, all -> 0x0074 }
        r5 = r7.getInputStream();	 Catch:{ SSLPeerUnverifiedException -> 0x0066, SSLHandshakeException -> 0x0064, Exception -> 0x0062, all -> 0x0074 }
        if (r5 == 0) goto L_0x0056;
    L_0x0048:
        r0 = cn.jiguang.net.HttpUtils.readInputStream(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0054, SSLHandshakeException -> 0x0052, Exception -> 0x0050, all -> 0x004d }
        goto L_0x0057;
    L_0x004d:
        r9 = move-exception;
        r0 = r5;
        goto L_0x0075;
    L_0x0050:
        r0 = r5;
        goto L_0x0062;
    L_0x0052:
        r0 = r5;
        goto L_0x0064;
    L_0x0054:
        r0 = r5;
        goto L_0x0066;
    L_0x0056:
        r0 = r2;
    L_0x0057:
        if (r5 == 0) goto L_0x005c;
    L_0x0059:
        r5.close();	 Catch:{ IOException -> 0x005c }
    L_0x005c:
        if (r7 == 0) goto L_0x00a1;
    L_0x005e:
        r7.disconnect();
        goto L_0x00a1;
    L_0x0062:
        r5 = r4;
        goto L_0x0080;
    L_0x0064:
        r5 = r4;
        goto L_0x0068;
    L_0x0066:
        r5 = r4;
        goto L_0x006a;
    L_0x0068:
        r4 = r3;
        goto L_0x0078;
    L_0x006a:
        r4 = r3;
        goto L_0x007a;
    L_0x006c:
        if (r0 == 0) goto L_0x0071;
    L_0x006e:
        r0.close();	 Catch:{ IOException -> 0x0071 }
    L_0x0071:
        if (r7 == 0) goto L_0x008a;
    L_0x0073:
        goto L_0x0087;
    L_0x0074:
        r9 = move-exception;
    L_0x0075:
        r3 = r7;
        goto L_0x00d3;
    L_0x0078:
        r3 = r7;
        goto L_0x008d;
    L_0x007a:
        r3 = r7;
        goto L_0x00b6;
    L_0x007c:
        r9 = move-exception;
        goto L_0x00d3;
    L_0x007e:
        r7 = r3;
    L_0x007f:
        r3 = r4;
    L_0x0080:
        if (r0 == 0) goto L_0x0085;
    L_0x0082:
        r0.close();	 Catch:{ IOException -> 0x0085 }
    L_0x0085:
        if (r7 == 0) goto L_0x008a;
    L_0x0087:
        r7.disconnect();
    L_0x008a:
        r4 = r3;
        r3 = r7;
        goto L_0x00c7;
    L_0x008d:
        r9 = "HttpManager";
        r10 = "Catch SSLHandshakeException, http client execute error!";
        cn.jpush.android.d.f.a(r9, r10);	 Catch:{ all -> 0x007c }
        if (r0 == 0) goto L_0x0099;
    L_0x0096:
        r0.close();	 Catch:{ IOException -> 0x0099 }
    L_0x0099:
        if (r3 == 0) goto L_0x009e;
    L_0x009b:
        r3.disconnect();
    L_0x009e:
        r0 = r2;
        r3 = r4;
        r4 = r5;
    L_0x00a1:
        if (r6 != r3) goto L_0x00ac;
    L_0x00a3:
        if (r4 != 0) goto L_0x00a6;
    L_0x00a5:
        return r2;
    L_0x00a6:
        r9 = r0.length;	 Catch:{ Exception -> 0x00ab }
        if (r9 >= r4) goto L_0x00aa;
    L_0x00a9:
        return r2;
    L_0x00aa:
        return r0;
    L_0x00ab:
        return r2;
    L_0x00ac:
        r9 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 != r3) goto L_0x00b1;
    L_0x00b0:
        return r2;
    L_0x00b1:
        r9 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r9 != r3) goto L_0x00b5;
    L_0x00b5:
        return r2;
    L_0x00b6:
        r6 = "HttpManager";
        r7 = "Catch SSLPeerUnverifiedException, http client execute error!";
        cn.jpush.android.d.f.d(r6, r7);	 Catch:{ all -> 0x007c }
        if (r0 == 0) goto L_0x00c2;
    L_0x00bf:
        r0.close();	 Catch:{ IOException -> 0x00c2 }
    L_0x00c2:
        if (r3 == 0) goto L_0x00c7;
    L_0x00c4:
        r3.disconnect();
    L_0x00c7:
        if (r1 < r10) goto L_0x00ca;
    L_0x00c9:
        return r2;
    L_0x00ca:
        r1 = r1 + 1;
        r6 = (long) r1;
        r6 = r6 * r11;
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x001d }
        goto L_0x001d;
    L_0x00d3:
        if (r0 == 0) goto L_0x00d8;
    L_0x00d5:
        r0.close();	 Catch:{ IOException -> 0x00d8 }
    L_0x00d8:
        if (r3 == 0) goto L_0x00dd;
    L_0x00da:
        r3.disconnect();
    L_0x00dd:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.b.a.b(java.lang.String, int, long):byte[]");
    }
}
