package com.geetest.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: GOPHttpUtils */
public final class O0O00oO {

    /* compiled from: GOPHttpUtils */
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
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inputStream.close();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab A:{SYNTHETIC, Splitter:B:33:0x00ab} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b1 A:{Catch:{ Exception -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x012a A:{Catch:{ Exception -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0124 A:{SYNTHETIC, Splitter:B:67:0x0124} */
    public static java.lang.String O000000o(java.lang.String r8, org.json.JSONObject r9) {
        /*
        r8 = O000000o(r8);
        r0 = "https";
        r1 = r8.getProtocol();	 Catch:{ Exception -> 0x012e }
        r1 = r1.toLowerCase();	 Catch:{ Exception -> 0x012e }
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x012e }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r3 = 0;
        r4 = 0;
        r5 = 1;
        if (r0 == 0) goto L_0x00b5;
    L_0x001b:
        r0 = "TLS";
        r0 = javax.net.ssl.SSLContext.getInstance(r0);	 Catch:{ Exception -> 0x009d }
        r6 = new javax.net.ssl.TrustManager[r5];	 Catch:{ Exception -> 0x009d }
        r7 = new com.geetest.sdk.O0O00oO$O000000o;	 Catch:{ Exception -> 0x009d }
        r7.<init>(r3);	 Catch:{ Exception -> 0x009d }
        r6[r3] = r7;	 Catch:{ Exception -> 0x009d }
        r0.init(r4, r6, r4);	 Catch:{ Exception -> 0x009d }
        r0 = r0.getSocketFactory();	 Catch:{ Exception -> 0x009d }
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r0);	 Catch:{ Exception -> 0x009d }
        r0 = new com.geetest.sdk.O0O000o;	 Catch:{ Exception -> 0x009d }
        r0.<init>();	 Catch:{ Exception -> 0x009d }
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(r0);	 Catch:{ Exception -> 0x009d }
        r8 = r8.openConnection();	 Catch:{ Exception -> 0x009d }
        r8 = (javax.net.ssl.HttpsURLConnection) r8;	 Catch:{ Exception -> 0x009d }
        r8.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r8.setReadTimeout(r2);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r8.setDoInput(r5);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r8.setDoOutput(r5);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r0 = "POST";
        r8.setRequestMethod(r0);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r8.setUseCaches(r3);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r8.connect();	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        if (r9 == 0) goto L_0x0070;
    L_0x005b:
        r0 = r8.getOutputStream();	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r9 = r9.getBytes();	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r0.write(r9);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r0.flush();	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r0.close();	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
    L_0x0070:
        r9 = r8.getResponseCode();	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        if (r9 != r1) goto L_0x0084;
    L_0x0076:
        r9 = r8.getInputStream();	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r9 = O000000o(r9);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        if (r8 == 0) goto L_0x0083;
    L_0x0080:
        r8.disconnect();	 Catch:{ Exception -> 0x012e }
    L_0x0083:
        return r9;
    L_0x0084:
        r0 = "TestParam";
        r9 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        android.util.Log.i(r0, r9);	 Catch:{ Exception -> 0x0097, all -> 0x0095 }
        r9 = "";
        if (r8 == 0) goto L_0x0094;
    L_0x0091:
        r8.disconnect();	 Catch:{ Exception -> 0x012e }
    L_0x0094:
        return r9;
    L_0x0095:
        r9 = move-exception;
        goto L_0x00af;
    L_0x0097:
        r9 = move-exception;
        r4 = r8;
        goto L_0x009e;
    L_0x009a:
        r9 = move-exception;
        r8 = r4;
        goto L_0x00af;
    L_0x009d:
        r9 = move-exception;
    L_0x009e:
        r8 = "TestParam";
        r9 = r9.toString();	 Catch:{ all -> 0x009a }
        android.util.Log.i(r8, r9);	 Catch:{ all -> 0x009a }
        r8 = "";
        if (r4 == 0) goto L_0x00ae;
    L_0x00ab:
        r4.disconnect();	 Catch:{ Exception -> 0x012e }
    L_0x00ae:
        return r8;
    L_0x00af:
        if (r8 == 0) goto L_0x00b4;
    L_0x00b1:
        r8.disconnect();	 Catch:{ Exception -> 0x012e }
    L_0x00b4:
        throw r9;	 Catch:{ Exception -> 0x012e }
    L_0x00b5:
        r8 = r8.openConnection();	 Catch:{ Exception -> 0x0116 }
        r8 = (java.net.HttpURLConnection) r8;	 Catch:{ Exception -> 0x0116 }
        r8.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r8.setReadTimeout(r2);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r8.setDoInput(r5);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r8.setDoOutput(r5);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r0 = "POST";
        r8.setRequestMethod(r0);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r8.setUseCaches(r3);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r8.connect();	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        if (r9 == 0) goto L_0x00e9;
    L_0x00d4:
        r0 = r8.getOutputStream();	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r9 = r9.getBytes();	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r0.write(r9);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r0.flush();	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r0.close();	 Catch:{ Exception -> 0x0110, all -> 0x010e }
    L_0x00e9:
        r9 = r8.getResponseCode();	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        if (r9 != r1) goto L_0x00fd;
    L_0x00ef:
        r9 = r8.getInputStream();	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r9 = O000000o(r9);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        if (r8 == 0) goto L_0x00fc;
    L_0x00f9:
        r8.disconnect();	 Catch:{ Exception -> 0x012e }
    L_0x00fc:
        return r9;
    L_0x00fd:
        r0 = "TestParam";
        r9 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        android.util.Log.i(r0, r9);	 Catch:{ Exception -> 0x0110, all -> 0x010e }
        r9 = "";
        if (r8 == 0) goto L_0x010d;
    L_0x010a:
        r8.disconnect();	 Catch:{ Exception -> 0x012e }
    L_0x010d:
        return r9;
    L_0x010e:
        r9 = move-exception;
        goto L_0x0128;
    L_0x0110:
        r9 = move-exception;
        r4 = r8;
        goto L_0x0117;
    L_0x0113:
        r9 = move-exception;
        r8 = r4;
        goto L_0x0128;
    L_0x0116:
        r9 = move-exception;
    L_0x0117:
        r8 = "TestParam";
        r9 = r9.toString();	 Catch:{ all -> 0x0113 }
        android.util.Log.i(r8, r9);	 Catch:{ all -> 0x0113 }
        r8 = "";
        if (r4 == 0) goto L_0x0127;
    L_0x0124:
        r4.disconnect();	 Catch:{ Exception -> 0x012e }
    L_0x0127:
        return r8;
    L_0x0128:
        if (r8 == 0) goto L_0x012d;
    L_0x012a:
        r8.disconnect();	 Catch:{ Exception -> 0x012e }
    L_0x012d:
        throw r9;	 Catch:{ Exception -> 0x012e }
    L_0x012e:
        r8 = move-exception;
        r9 = "TestParam";
        r8 = r8.toString();
        android.util.Log.i(r9, r8);
        r8 = "";
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.O0O00oO.O000000o(java.lang.String, org.json.JSONObject):java.lang.String");
    }

    private static URL O000000o(String str) {
        try {
            return new URL(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
