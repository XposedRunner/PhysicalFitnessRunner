package com.geetest.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.X509TrustManager;

/* compiled from: HttpUtils */
public class O0OOOo0 {
    public static CookieManager O000000o = null;
    public static CookieManager O00000Oo = null;
    private static final String O00000o = "O0OOOo0";
    public static String O00000o0 = "";

    /* compiled from: HttpUtils */
    private static class O000000o implements X509TrustManager {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    private static String O000000o(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    String str = new String(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                    return str;
                }
            } catch (IOException e) {
                StringBuilder stringBuilder = new StringBuilder("read stream error: ");
                stringBuilder.append(e.toString());
                O0OOO00.O000000o(stringBuilder.toString());
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x015c A:{Catch:{ Exception -> 0x0275 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0271 A:{Catch:{ Exception -> 0x0275 }} */
    public static java.lang.String O000000o(java.lang.String r9, boolean r10, java.util.Map<java.lang.String, java.lang.String> r11, byte[] r12, android.net.Network r13, java.lang.String r14) {
        /*
        r0 = O000000o(r9);
        r1 = "https";
        r2 = r0.getProtocol();	 Catch:{ Exception -> 0x0275 }
        r2 = r2.toLowerCase();	 Catch:{ Exception -> 0x0275 }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x0275 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        r4 = 21;
        r5 = 0;
        if (r1 == 0) goto L_0x0160;
    L_0x001b:
        r1 = "TLS";
        r1 = javax.net.ssl.SSLContext.getInstance(r1);	 Catch:{ Exception -> 0x0127 }
        r6 = 1;
        r6 = new javax.net.ssl.TrustManager[r6];	 Catch:{ Exception -> 0x0127 }
        r7 = new com.geetest.sdk.O0OOOo0$O000000o;	 Catch:{ Exception -> 0x0127 }
        r8 = 0;
        r7.<init>(r8);	 Catch:{ Exception -> 0x0127 }
        r6[r8] = r7;	 Catch:{ Exception -> 0x0127 }
        r1.init(r5, r6, r5);	 Catch:{ Exception -> 0x0127 }
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0127 }
        r7 = 19;
        if (r6 > r7) goto L_0x003f;
    L_0x0035:
        r6 = new com.geetest.sdk.O0OOOOO;	 Catch:{ Exception -> 0x0127 }
        r1 = r1.getSocketFactory();	 Catch:{ Exception -> 0x0127 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x0127 }
        goto L_0x0043;
    L_0x003f:
        r6 = r1.getSocketFactory();	 Catch:{ Exception -> 0x0127 }
    L_0x0043:
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r6);	 Catch:{ Exception -> 0x0127 }
        r1 = new com.geetest.sdk.O0OOo;	 Catch:{ Exception -> 0x0127 }
        r1.<init>();	 Catch:{ Exception -> 0x0127 }
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(r1);	 Catch:{ Exception -> 0x0127 }
        if (r13 == 0) goto L_0x0062;
    L_0x0050:
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0127 }
        if (r1 < r4) goto L_0x005b;
    L_0x0054:
        r1 = r13.openConnection(r0);	 Catch:{ Exception -> 0x0127 }
        r1 = (javax.net.ssl.HttpsURLConnection) r1;	 Catch:{ Exception -> 0x0127 }
        goto L_0x0068;
    L_0x005b:
        r1 = r0.openConnection();	 Catch:{ Exception -> 0x0127 }
        r1 = (javax.net.ssl.HttpsURLConnection) r1;	 Catch:{ Exception -> 0x0127 }
        goto L_0x0068;
    L_0x0062:
        r1 = r0.openConnection();	 Catch:{ Exception -> 0x0127 }
        r1 = (javax.net.ssl.HttpsURLConnection) r1;	 Catch:{ Exception -> 0x0127 }
    L_0x0068:
        r5 = r1;
        O000000o(r5, r10, r11);	 Catch:{ Exception -> 0x0127 }
        O00000Oo(r5, r14);	 Catch:{ Exception -> 0x0127 }
        O000000o(r5);	 Catch:{ Exception -> 0x0127 }
        r5.connect();	 Catch:{ Exception -> 0x0127 }
        O000000o(r5, r14);	 Catch:{ Exception -> 0x0127 }
        if (r10 == 0) goto L_0x008c;
    L_0x007a:
        if (r12 == 0) goto L_0x008c;
    L_0x007c:
        r11 = r12.length;	 Catch:{ Exception -> 0x0127 }
        if (r11 <= 0) goto L_0x008c;
    L_0x007f:
        r11 = r5.getOutputStream();	 Catch:{ Exception -> 0x0127 }
        r11.write(r12);	 Catch:{ Exception -> 0x0127 }
        r11.flush();	 Catch:{ Exception -> 0x0127 }
        r11.close();	 Catch:{ Exception -> 0x0127 }
    L_0x008c:
        r11 = r5.getResponseCode();	 Catch:{ Exception -> 0x0127 }
        if (r10 == 0) goto L_0x00d1;
    L_0x0092:
        if (r12 != 0) goto L_0x00d1;
    L_0x0094:
        if (r11 != r3) goto L_0x00d1;
    L_0x0096:
        if (r13 == 0) goto L_0x00b2;
    L_0x0098:
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0127 }
        if (r10 < r4) goto L_0x00d1;
    L_0x009c:
        r10 = "Location";
        r10 = r5.getHeaderField(r10);	 Catch:{ Exception -> 0x0127 }
        r11 = new java.net.URL;	 Catch:{ Exception -> 0x0127 }
        r11.<init>(r10);	 Catch:{ Exception -> 0x0127 }
        r10 = r13.openConnection(r11);	 Catch:{ Exception -> 0x0127 }
        r10 = (javax.net.ssl.HttpsURLConnection) r10;	 Catch:{ Exception -> 0x0127 }
        r11 = r10.getResponseCode();	 Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
        goto L_0x00c7;
    L_0x00b2:
        r10 = "Location";
        r10 = r5.getHeaderField(r10);	 Catch:{ Exception -> 0x0127 }
        r11 = new java.net.URL;	 Catch:{ Exception -> 0x0127 }
        r11.<init>(r10);	 Catch:{ Exception -> 0x0127 }
        r10 = r11.openConnection();	 Catch:{ Exception -> 0x0127 }
        r10 = (javax.net.ssl.HttpsURLConnection) r10;	 Catch:{ Exception -> 0x0127 }
        r11 = r10.getResponseCode();	 Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
    L_0x00c7:
        r5 = r10;
        goto L_0x00d1;
    L_0x00c9:
        r9 = move-exception;
        r5 = r10;
        goto L_0x015a;
    L_0x00cd:
        r11 = move-exception;
        r5 = r10;
        r10 = r11;
        goto L_0x0128;
    L_0x00d1:
        r10 = "responseCode:";
        r12 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0127 }
        r10 = r10.concat(r12);	 Catch:{ Exception -> 0x0127 }
        com.geetest.sdk.O0OOO00.O000000o(r10);	 Catch:{ Exception -> 0x0127 }
        if (r11 != r2) goto L_0x00ee;
    L_0x00e0:
        r10 = r5.getInputStream();	 Catch:{ Exception -> 0x0127 }
        r10 = O000000o(r10);	 Catch:{ Exception -> 0x0127 }
        if (r5 == 0) goto L_0x00ed;
    L_0x00ea:
        r5.disconnect();	 Catch:{ Exception -> 0x0275 }
    L_0x00ed:
        return r10;
    L_0x00ee:
        O00000o0 = r9;	 Catch:{ Exception -> 0x0127 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0127 }
        r12 = "url: ";
        r10.<init>(r12);	 Catch:{ Exception -> 0x0127 }
        r10.append(r9);	 Catch:{ Exception -> 0x0127 }
        r12 = " responseCode";
        r10.append(r12);	 Catch:{ Exception -> 0x0127 }
        r10.append(r11);	 Catch:{ Exception -> 0x0127 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0127 }
        com.geetest.sdk.O0OOO00.O000000o(r10);	 Catch:{ Exception -> 0x0127 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0127 }
        r12 = "GT3_Error_Info: url: ";
        r10.<init>(r12);	 Catch:{ Exception -> 0x0127 }
        r10.append(r9);	 Catch:{ Exception -> 0x0127 }
        r12 = " responseCode";
        r10.append(r12);	 Catch:{ Exception -> 0x0127 }
        r10.append(r11);	 Catch:{ Exception -> 0x0127 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0127 }
        if (r5 == 0) goto L_0x0124;
    L_0x0121:
        r5.disconnect();	 Catch:{ Exception -> 0x0275 }
    L_0x0124:
        return r10;
    L_0x0125:
        r9 = move-exception;
        goto L_0x015a;
    L_0x0127:
        r10 = move-exception;
    L_0x0128:
        r10.printStackTrace();	 Catch:{ all -> 0x0125 }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0125 }
        r12 = "request error:";
        r11.<init>(r12);	 Catch:{ all -> 0x0125 }
        r12 = r10.toString();	 Catch:{ all -> 0x0125 }
        r11.append(r12);	 Catch:{ all -> 0x0125 }
        r11 = r11.toString();	 Catch:{ all -> 0x0125 }
        com.geetest.sdk.O0OOO00.O000000o(r11);	 Catch:{ all -> 0x0125 }
        O00000o0 = r9;	 Catch:{ all -> 0x0125 }
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0125 }
        r11 = "GT3_Error_Info: request error:";
        r9.<init>(r11);	 Catch:{ all -> 0x0125 }
        r10 = r10.toString();	 Catch:{ all -> 0x0125 }
        r9.append(r10);	 Catch:{ all -> 0x0125 }
        r9 = r9.toString();	 Catch:{ all -> 0x0125 }
        if (r5 == 0) goto L_0x0159;
    L_0x0156:
        r5.disconnect();	 Catch:{ Exception -> 0x0275 }
    L_0x0159:
        return r9;
    L_0x015a:
        if (r5 == 0) goto L_0x015f;
    L_0x015c:
        r5.disconnect();	 Catch:{ Exception -> 0x0275 }
    L_0x015f:
        throw r9;	 Catch:{ Exception -> 0x0275 }
    L_0x0160:
        if (r13 == 0) goto L_0x017a;
    L_0x0162:
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0177 }
        if (r1 < r4) goto L_0x016d;
    L_0x0166:
        r1 = r13.openConnection(r0);	 Catch:{ Exception -> 0x0177 }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ Exception -> 0x0177 }
        goto L_0x0180;
    L_0x016d:
        r1 = r0.openConnection();	 Catch:{ Exception -> 0x0177 }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ Exception -> 0x0177 }
        goto L_0x0180;
    L_0x0174:
        r9 = move-exception;
        goto L_0x026f;
    L_0x0177:
        r10 = move-exception;
        goto L_0x023d;
    L_0x017a:
        r1 = r0.openConnection();	 Catch:{ Exception -> 0x0177 }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ Exception -> 0x0177 }
    L_0x0180:
        r5 = r1;
        O000000o(r5, r10, r11);	 Catch:{ Exception -> 0x0177 }
        O00000Oo(r5, r14);	 Catch:{ Exception -> 0x0177 }
        O000000o(r5);	 Catch:{ Exception -> 0x0177 }
        O000000o(r5, r14);	 Catch:{ Exception -> 0x0177 }
        r5.connect();	 Catch:{ Exception -> 0x0177 }
        if (r10 == 0) goto L_0x01a4;
    L_0x0192:
        if (r12 == 0) goto L_0x01a4;
    L_0x0194:
        r11 = r12.length;	 Catch:{ Exception -> 0x0177 }
        if (r11 <= 0) goto L_0x01a4;
    L_0x0197:
        r11 = r5.getOutputStream();	 Catch:{ Exception -> 0x0177 }
        r11.write(r12);	 Catch:{ Exception -> 0x0177 }
        r11.flush();	 Catch:{ Exception -> 0x0177 }
        r11.close();	 Catch:{ Exception -> 0x0177 }
    L_0x01a4:
        r11 = r5.getResponseCode();	 Catch:{ Exception -> 0x0177 }
        if (r10 == 0) goto L_0x01e9;
    L_0x01aa:
        if (r12 != 0) goto L_0x01e9;
    L_0x01ac:
        if (r11 != r3) goto L_0x01e9;
    L_0x01ae:
        if (r13 == 0) goto L_0x01ca;
    L_0x01b0:
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0177 }
        if (r10 < r4) goto L_0x01e9;
    L_0x01b4:
        r10 = "Location";
        r10 = r5.getHeaderField(r10);	 Catch:{ Exception -> 0x0177 }
        r11 = new java.net.URL;	 Catch:{ Exception -> 0x0177 }
        r11.<init>(r10);	 Catch:{ Exception -> 0x0177 }
        r10 = r13.openConnection(r11);	 Catch:{ Exception -> 0x0177 }
        r10 = (java.net.HttpURLConnection) r10;	 Catch:{ Exception -> 0x0177 }
        r11 = r10.getResponseCode();	 Catch:{ Exception -> 0x01e5, all -> 0x01e1 }
        goto L_0x01df;
    L_0x01ca:
        r10 = "Location";
        r10 = r5.getHeaderField(r10);	 Catch:{ Exception -> 0x0177 }
        r11 = new java.net.URL;	 Catch:{ Exception -> 0x0177 }
        r11.<init>(r10);	 Catch:{ Exception -> 0x0177 }
        r10 = r11.openConnection();	 Catch:{ Exception -> 0x0177 }
        r10 = (java.net.HttpURLConnection) r10;	 Catch:{ Exception -> 0x0177 }
        r11 = r10.getResponseCode();	 Catch:{ Exception -> 0x01e5, all -> 0x01e1 }
    L_0x01df:
        r5 = r10;
        goto L_0x01e9;
    L_0x01e1:
        r9 = move-exception;
        r5 = r10;
        goto L_0x026f;
    L_0x01e5:
        r11 = move-exception;
        r5 = r10;
        r10 = r11;
        goto L_0x023d;
    L_0x01e9:
        r10 = "responseCode:";
        r12 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0177 }
        r10 = r10.concat(r12);	 Catch:{ Exception -> 0x0177 }
        com.geetest.sdk.O0OOO00.O000000o(r10);	 Catch:{ Exception -> 0x0177 }
        if (r11 != r2) goto L_0x0206;
    L_0x01f8:
        r10 = r5.getInputStream();	 Catch:{ Exception -> 0x0177 }
        r10 = O000000o(r10);	 Catch:{ Exception -> 0x0177 }
        if (r5 == 0) goto L_0x0205;
    L_0x0202:
        r5.disconnect();	 Catch:{ Exception -> 0x0275 }
    L_0x0205:
        return r10;
    L_0x0206:
        O00000o0 = r9;	 Catch:{ Exception -> 0x0177 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0177 }
        r12 = "url: ";
        r10.<init>(r12);	 Catch:{ Exception -> 0x0177 }
        r10.append(r9);	 Catch:{ Exception -> 0x0177 }
        r12 = " responseCode";
        r10.append(r12);	 Catch:{ Exception -> 0x0177 }
        r10.append(r11);	 Catch:{ Exception -> 0x0177 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0177 }
        com.geetest.sdk.O0OOO00.O000000o(r10);	 Catch:{ Exception -> 0x0177 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0177 }
        r12 = "GT3_Error_Info: url: ";
        r10.<init>(r12);	 Catch:{ Exception -> 0x0177 }
        r10.append(r9);	 Catch:{ Exception -> 0x0177 }
        r12 = " responseCode";
        r10.append(r12);	 Catch:{ Exception -> 0x0177 }
        r10.append(r11);	 Catch:{ Exception -> 0x0177 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0177 }
        if (r5 == 0) goto L_0x023c;
    L_0x0239:
        r5.disconnect();	 Catch:{ Exception -> 0x0275 }
    L_0x023c:
        return r10;
    L_0x023d:
        r10.printStackTrace();	 Catch:{ all -> 0x0174 }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0174 }
        r12 = "request error:";
        r11.<init>(r12);	 Catch:{ all -> 0x0174 }
        r12 = r10.toString();	 Catch:{ all -> 0x0174 }
        r11.append(r12);	 Catch:{ all -> 0x0174 }
        r11 = r11.toString();	 Catch:{ all -> 0x0174 }
        com.geetest.sdk.O0OOO00.O000000o(r11);	 Catch:{ all -> 0x0174 }
        O00000o0 = r9;	 Catch:{ all -> 0x0174 }
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0174 }
        r11 = "GT3_Error_Info: request error:";
        r9.<init>(r11);	 Catch:{ all -> 0x0174 }
        r10 = r10.toString();	 Catch:{ all -> 0x0174 }
        r9.append(r10);	 Catch:{ all -> 0x0174 }
        r9 = r9.toString();	 Catch:{ all -> 0x0174 }
        if (r5 == 0) goto L_0x026e;
    L_0x026b:
        r5.disconnect();	 Catch:{ Exception -> 0x0275 }
    L_0x026e:
        return r9;
    L_0x026f:
        if (r5 == 0) goto L_0x0274;
    L_0x0271:
        r5.disconnect();	 Catch:{ Exception -> 0x0275 }
    L_0x0274:
        throw r9;	 Catch:{ Exception -> 0x0275 }
    L_0x0275:
        r9 = move-exception;
        r9.printStackTrace();
        r10 = new java.lang.StringBuilder;
        r11 = "url:";
        r10.<init>(r11);
        r10.append(r0);
        r11 = ",error:";
        r10.append(r11);
        r11 = r9.toString();
        r10.append(r11);
        r10 = r10.toString();
        com.geetest.sdk.O0OOO00.O000000o(r10);
        r10 = new java.lang.StringBuilder;
        r11 = "GT3_Error_Info: url:";
        r10.<init>(r11);
        r10.append(r0);
        r11 = ",error:";
        r10.append(r11);
        r9 = r9.toString();
        r10.append(r9);
        r9 = r10.toString();
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.O0OOOo0.O000000o(java.lang.String, boolean, java.util.Map, byte[], android.net.Network, java.lang.String):java.lang.String");
    }

    private static URL O000000o(String str) {
        try {
            return new URL(str);
        } catch (Exception e) {
            String str2 = O00000o;
            StringBuilder stringBuilder = new StringBuilder("error:");
            stringBuilder.append(e.toString());
            Log.i(str2, stringBuilder.toString());
            return null;
        }
    }

    private static void O000000o(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            Map requestProperties = httpURLConnection.getRequestProperties();
            if (requestProperties != null && requestProperties.size() > 0) {
                for (Entry entry : requestProperties.entrySet()) {
                    String str = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < list.size(); i++) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append((String) list.get(i));
                        stringBuilder2.append(",");
                        stringBuilder.append(stringBuilder2.toString());
                    }
                    StringBuilder stringBuilder3 = new StringBuilder("Header key: ");
                    stringBuilder3.append(str);
                    stringBuilder3.append(" value: ");
                    stringBuilder3.append(stringBuilder.toString());
                    O0OOO00.O000000o(stringBuilder3.toString());
                }
            }
        }
    }

    private static void O000000o(HttpURLConnection httpURLConnection, String str) {
        Map headerFields;
        List<String> list;
        if (TextUtils.equals("API1", str)) {
            O00000Oo = new CookieManager();
            if (httpURLConnection != null) {
                headerFields = httpURLConnection.getHeaderFields();
                if (!(headerFields == null || headerFields.get("Set-Cookie") == null)) {
                    list = (List) headerFields.get("Set-Cookie");
                    if (list != null) {
                        for (String str2 : list) {
                            O00000Oo.getCookieStore().add(null, (HttpCookie) HttpCookie.parse(str2).get(0));
                        }
                    }
                }
            }
        } else if (TextUtils.equals("Gettype", str2)) {
            O000000o = new CookieManager();
            if (httpURLConnection != null) {
                headerFields = httpURLConnection.getHeaderFields();
                if (!(headerFields == null || headerFields.get("Set-Cookie") == null)) {
                    list = (List) headerFields.get("Set-Cookie");
                    if (list != null) {
                        for (String str22 : list) {
                            O000000o.getCookieStore().add(null, (HttpCookie) HttpCookie.parse(str22).get(0));
                        }
                    }
                }
            }
        }
    }

    private static void O000000o(HttpURLConnection httpURLConnection, boolean z, Map<String, String> map) {
        if (z) {
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
        } else {
            httpURLConnection.setRequestMethod(Constants.HTTP_GET);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
        }
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        if (map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private static void O00000Oo(HttpURLConnection httpURLConnection, String str) {
        if (TextUtils.equals(str, "Ajax") || TextUtils.equals(str, "GetCoder")) {
            if (O000000o != null && O000000o.getCookieStore().getCookies().size() > 0) {
                httpURLConnection.setRequestProperty("Cookie", TextUtils.join(";", O000000o.getCookieStore().getCookies()));
            }
        } else if (TextUtils.equals(str, "API2Coder") && O00000Oo != null && O00000Oo.getCookieStore().getCookies().size() > 0) {
            httpURLConnection.setRequestProperty("Cookie", TextUtils.join(";", O00000Oo.getCookieStore().getCookies()));
        }
    }
}
