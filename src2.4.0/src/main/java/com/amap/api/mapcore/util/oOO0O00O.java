package com.amap.api.mapcore.util;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* compiled from: HttpUrlUtil */
public class oOO0O00O {
    private int O000000o;
    private int O00000Oo;
    private SSLContext O00000o;
    private boolean O00000o0;
    private Proxy O00000oO;
    private volatile boolean O00000oo;
    private long O0000O0o;
    private long O0000OOo;
    private O000000o O0000Oo;
    private String O0000Oo0;
    private com.amap.api.mapcore.util.ooooOO00.O000000o O0000OoO;

    /* compiled from: HttpUrlUtil */
    private static class O000000o {
        private Vector<O00000Oo> O000000o;
        private volatile O00000Oo O00000Oo;

        private O000000o() {
            this.O000000o = new Vector();
            this.O00000Oo = new O00000Oo();
        }

        public O00000Oo O000000o() {
            return this.O00000Oo;
        }

        public O00000Oo O000000o(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.O00000Oo;
            }
            for (int i = 0; i < this.O000000o.size(); i++) {
                O00000Oo o00000Oo = (O00000Oo) this.O000000o.get(i);
                if (o00000Oo != null && o00000Oo.O000000o().equals(str)) {
                    return o00000Oo;
                }
            }
            O00000Oo o00000Oo2 = new O00000Oo();
            o00000Oo2.O00000Oo(str);
            this.O000000o.add(o00000Oo2);
            return o00000Oo2;
        }

        public void O00000Oo(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.O00000Oo.O000000o(str);
            }
        }
    }

    /* compiled from: HttpUrlUtil */
    private static class O00000Oo implements HostnameVerifier {
        private String O000000o;
        private String O00000Oo;

        private O00000Oo() {
        }

        public String O000000o() {
            return this.O00000Oo;
        }

        public void O000000o(String str) {
            this.O000000o = str;
        }

        public void O00000Oo(String str) {
            this.O00000Oo = str;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.O000000o) ? this.O000000o.equals(str) : !TextUtils.isEmpty(this.O00000Oo) ? defaultHostnameVerifier.verify(this.O00000Oo, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    oOO0O00O(int i, int i2, Proxy proxy, boolean z) {
        this(i, i2, proxy, z, null);
    }

    oOO0O00O(int i, int i2, Proxy proxy, boolean z, com.amap.api.mapcore.util.ooooOO00.O000000o o000000o) {
        this.O00000oo = false;
        this.O0000O0o = -1;
        this.O0000OOo = 0;
        this.O000000o = i;
        this.O00000Oo = i2;
        this.O00000oO = proxy;
        this.O00000o0 = o0OO00OO.O000000o().O00000Oo(z);
        if (o0OO00OO.O00000o0()) {
            this.O00000o0 = false;
        }
        this.O0000OoO = o000000o;
        O00000Oo();
        if (this.O00000o0) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.O00000o = instance;
            } catch (Throwable th) {
                oO0OoOO0.O000000o(th, "ht", "ne");
            }
        }
        this.O0000Oo = new O000000o();
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0121 A:{SYNTHETIC, Splitter:B:77:0x0121} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012f A:{SYNTHETIC, Splitter:B:82:0x012f} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x013d A:{SYNTHETIC, Splitter:B:87:0x013d} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x014b A:{SYNTHETIC, Splitter:B:92:0x014b} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0121 A:{SYNTHETIC, Splitter:B:77:0x0121} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012f A:{SYNTHETIC, Splitter:B:82:0x012f} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x013d A:{SYNTHETIC, Splitter:B:87:0x013d} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x014b A:{SYNTHETIC, Splitter:B:92:0x014b} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0121 A:{SYNTHETIC, Splitter:B:77:0x0121} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012f A:{SYNTHETIC, Splitter:B:82:0x012f} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x013d A:{SYNTHETIC, Splitter:B:87:0x013d} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x014b A:{SYNTHETIC, Splitter:B:92:0x014b} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0121 A:{SYNTHETIC, Splitter:B:77:0x0121} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012f A:{SYNTHETIC, Splitter:B:82:0x012f} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x013d A:{SYNTHETIC, Splitter:B:87:0x013d} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x014b A:{SYNTHETIC, Splitter:B:92:0x014b} */
    private com.amap.api.mapcore.util.oOO0Oo00 O000000o(java.net.HttpURLConnection r11, boolean r12) throws com.amap.api.mapcore.util.o0O0oo0o, java.io.IOException {
        /*
        r10 = this;
        r0 = "";
        r1 = 0;
        r11.connect();	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r2 = r11.getHeaderFields();	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r3 = r11.getResponseCode();	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r4 = 0;
        if (r2 == 0) goto L_0x0028;
    L_0x0011:
        r5 = "gsid";
        r5 = r2.get(r5);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r5 = (java.util.List) r5;	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        if (r5 == 0) goto L_0x0028;
    L_0x001b:
        r6 = r5.size();	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        if (r6 <= 0) goto L_0x0028;
    L_0x0021:
        r5 = r5.get(r4);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r0 = r5;
    L_0x0028:
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 == r5) goto L_0x0064;
    L_0x002c:
        r12 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r2.<init>();	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r4 = "网络异常原因：";
        r2.append(r4);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r11 = r11.getResponseMessage();	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r2.append(r11);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r11 = " 网络异常状态码：";
        r2.append(r11);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r2.append(r3);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r11 = "  ";
        r2.append(r11);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r2.append(r0);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r11 = " ";
        r2.append(r11);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r11 = r10.O0000Oo0;	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r2.append(r11);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r11 = r2.toString();	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r12.<init>(r11, r0);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r12.O000000o(r3);	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        throw r12;	 Catch:{ IOException -> 0x010f, all -> 0x010a }
    L_0x0064:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r3.<init>();	 Catch:{ IOException -> 0x010f, all -> 0x010a }
        r11 = r11.getInputStream();	 Catch:{ IOException -> 0x0105, all -> 0x00ff }
        r5 = new java.io.PushbackInputStream;	 Catch:{ IOException -> 0x00fd, all -> 0x00f5 }
        r6 = 2;
        r5.<init>(r11, r6);	 Catch:{ IOException -> 0x00fd, all -> 0x00f5 }
        r6 = new byte[r6];	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r5.read(r6);	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r5.unread(r6);	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r7 = r6[r4];	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r8 = 31;
        if (r7 != r8) goto L_0x0091;
    L_0x0081:
        r7 = 1;
        r6 = r6[r7];	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r7 = -117; // 0xffffffffffffff8b float:NaN double:NaN;
        if (r6 != r7) goto L_0x0091;
    L_0x0088:
        if (r12 != 0) goto L_0x0091;
    L_0x008a:
        r12 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r12.<init>(r5);	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r1 = r12;
        goto L_0x0092;
    L_0x0091:
        r1 = r5;
    L_0x0092:
        r12 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r12 = new byte[r12];	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
    L_0x0096:
        r6 = r1.read(r12);	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r7 = -1;
        if (r6 == r7) goto L_0x00a1;
    L_0x009d:
        r3.write(r12, r4, r6);	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        goto L_0x0096;
    L_0x00a1:
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0();	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r12 = new com.amap.api.mapcore.util.oOO0Oo00;	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r12.<init>();	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r4 = r3.toByteArray();	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r12.O000000o = r4;	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r12.O00000Oo = r2;	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r2 = r10.O0000Oo0;	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r12.O00000o0 = r2;	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        r12.O00000o = r0;	 Catch:{ IOException -> 0x00f3, all -> 0x00f0 }
        if (r3 == 0) goto L_0x00c5;
    L_0x00b9:
        r3.close();	 Catch:{ Throwable -> 0x00bd }
        goto L_0x00c5;
    L_0x00bd:
        r0 = move-exception;
        r2 = "ht";
        r3 = "par";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r0, r2, r3);
    L_0x00c5:
        if (r11 == 0) goto L_0x00d3;
    L_0x00c7:
        r11.close();	 Catch:{ Throwable -> 0x00cb }
        goto L_0x00d3;
    L_0x00cb:
        r11 = move-exception;
        r0 = "ht";
        r2 = "par";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r11, r0, r2);
    L_0x00d3:
        if (r5 == 0) goto L_0x00e1;
    L_0x00d5:
        r5.close();	 Catch:{ Throwable -> 0x00d9 }
        goto L_0x00e1;
    L_0x00d9:
        r11 = move-exception;
        r0 = "ht";
        r2 = "par";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r11, r0, r2);
    L_0x00e1:
        if (r1 == 0) goto L_0x00ef;
    L_0x00e3:
        r1.close();	 Catch:{ Throwable -> 0x00e7 }
        goto L_0x00ef;
    L_0x00e7:
        r11 = move-exception;
        r0 = "ht";
        r1 = "par";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r11, r0, r1);
    L_0x00ef:
        return r12;
    L_0x00f0:
        r12 = move-exception;
        r0 = r1;
        goto L_0x00f8;
    L_0x00f3:
        r12 = r1;
        goto L_0x0108;
    L_0x00f5:
        r12 = move-exception;
        r0 = r1;
        r5 = r0;
    L_0x00f8:
        r1 = r3;
        r9 = r12;
        r12 = r11;
        r11 = r9;
        goto L_0x011f;
    L_0x00fd:
        r12 = r1;
        goto L_0x0107;
    L_0x00ff:
        r11 = move-exception;
        r12 = r1;
        r0 = r12;
        r5 = r0;
        r1 = r3;
        goto L_0x011f;
    L_0x0105:
        r11 = r1;
        r12 = r11;
    L_0x0107:
        r5 = r12;
    L_0x0108:
        r1 = r3;
        goto L_0x0112;
    L_0x010a:
        r11 = move-exception;
        r12 = r1;
        r0 = r12;
        r5 = r0;
        goto L_0x011f;
    L_0x010f:
        r11 = r1;
        r12 = r11;
        r5 = r12;
    L_0x0112:
        r2 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x011a }
        r3 = "IO 操作异常 - IOException";
        r2.<init>(r3, r0);	 Catch:{ all -> 0x011a }
        throw r2;	 Catch:{ all -> 0x011a }
    L_0x011a:
        r0 = move-exception;
        r9 = r12;
        r12 = r11;
        r11 = r0;
        r0 = r9;
    L_0x011f:
        if (r1 == 0) goto L_0x012d;
    L_0x0121:
        r1.close();	 Catch:{ Throwable -> 0x0125 }
        goto L_0x012d;
    L_0x0125:
        r1 = move-exception;
        r2 = "ht";
        r3 = "par";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r1, r2, r3);
    L_0x012d:
        if (r12 == 0) goto L_0x013b;
    L_0x012f:
        r12.close();	 Catch:{ Throwable -> 0x0133 }
        goto L_0x013b;
    L_0x0133:
        r12 = move-exception;
        r1 = "ht";
        r2 = "par";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r12, r1, r2);
    L_0x013b:
        if (r5 == 0) goto L_0x0149;
    L_0x013d:
        r5.close();	 Catch:{ Throwable -> 0x0141 }
        goto L_0x0149;
    L_0x0141:
        r12 = move-exception;
        r1 = "ht";
        r2 = "par";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r12, r1, r2);
    L_0x0149:
        if (r0 == 0) goto L_0x0157;
    L_0x014b:
        r0.close();	 Catch:{ Throwable -> 0x014f }
        goto L_0x0157;
    L_0x014f:
        r12 = move-exception;
        r0 = "ht";
        r1 = "par";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r12, r0, r1);
    L_0x0157:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOO0O00O.O000000o(java.net.HttpURLConnection, boolean):com.amap.api.mapcore.util.oOO0Oo00");
    }

    private String O000000o(int i, String str, Map<String, String> map) {
        CharSequence charSequence = "";
        if (i == 1) {
            charSequence = ooooOO00.O00000Oo;
        }
        if (TextUtils.isEmpty(charSequence)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        str = parse.getHost();
        String uri = parse.buildUpon().encodedAuthority(charSequence).build().toString();
        if (map != null) {
            map.put("targetHost", str);
        }
        if (this.O00000o0) {
            this.O0000Oo.O00000Oo(charSequence);
        }
        return uri;
    }

    static String O000000o(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 == null) {
                str2 = "";
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
            }
            stringBuilder.append(URLEncoder.encode(str));
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append(URLEncoder.encode(str2));
        }
        return stringBuilder.toString();
    }

    private void O000000o(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, (String) map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.O0000Oo0);
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.O000000o);
        httpURLConnection.setReadTimeout(this.O00000Oo);
    }

    private void O00000Oo() {
        try {
            this.O0000Oo0 = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "ht", "ic");
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00be A:{SYNTHETIC, Splitter:B:65:0x00be} */
    public com.amap.api.mapcore.util.oOO0Oo00 O000000o(java.lang.String r8, boolean r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, byte[] r12, boolean r13) throws com.amap.api.mapcore.util.o0O0oo0o {
        /*
        r7 = this;
        r5 = 1;
        r6 = 0;
        r0 = r7;
        r1 = r8;
        r2 = r9;
        r3 = r10;
        r4 = r11;
        r8 = r0.O000000o(r1, r2, r3, r4, r5);	 Catch:{ ConnectException -> 0x00b0, MalformedURLException -> 0x00a4, UnknownHostException -> 0x0098, SocketException -> 0x008c, SocketTimeoutException -> 0x0080, InterruptedIOException -> 0x0078, IOException -> 0x006c, o0O0oo0o -> 0x0063, Throwable -> 0x0053 }
        if (r12 == 0) goto L_0x003e;
    L_0x000d:
        r9 = r12.length;	 Catch:{ ConnectException -> 0x003b, MalformedURLException -> 0x0038, UnknownHostException -> 0x0035, SocketException -> 0x0032, SocketTimeoutException -> 0x002f, InterruptedIOException -> 0x002d, IOException -> 0x002a, o0O0oo0o -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        if (r9 <= 0) goto L_0x003e;
    L_0x0010:
        r9 = new java.io.DataOutputStream;	 Catch:{ ConnectException -> 0x003b, MalformedURLException -> 0x0038, UnknownHostException -> 0x0035, SocketException -> 0x0032, SocketTimeoutException -> 0x002f, InterruptedIOException -> 0x002d, IOException -> 0x002a, o0O0oo0o -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        r10 = r8.getOutputStream();	 Catch:{ ConnectException -> 0x003b, MalformedURLException -> 0x0038, UnknownHostException -> 0x0035, SocketException -> 0x0032, SocketTimeoutException -> 0x002f, InterruptedIOException -> 0x002d, IOException -> 0x002a, o0O0oo0o -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        r9.<init>(r10);	 Catch:{ ConnectException -> 0x003b, MalformedURLException -> 0x0038, UnknownHostException -> 0x0035, SocketException -> 0x0032, SocketTimeoutException -> 0x002f, InterruptedIOException -> 0x002d, IOException -> 0x002a, o0O0oo0o -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        r9.write(r12);	 Catch:{ ConnectException -> 0x003b, MalformedURLException -> 0x0038, UnknownHostException -> 0x0035, SocketException -> 0x0032, SocketTimeoutException -> 0x002f, InterruptedIOException -> 0x002d, IOException -> 0x002a, o0O0oo0o -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        r9.close();	 Catch:{ ConnectException -> 0x003b, MalformedURLException -> 0x0038, UnknownHostException -> 0x0035, SocketException -> 0x0032, SocketTimeoutException -> 0x002f, InterruptedIOException -> 0x002d, IOException -> 0x002a, o0O0oo0o -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        goto L_0x003e;
    L_0x0020:
        r9 = move-exception;
        r6 = r8;
        goto L_0x00bc;
    L_0x0024:
        r9 = move-exception;
        r6 = r8;
        goto L_0x0054;
    L_0x0027:
        r9 = move-exception;
        r6 = r8;
        goto L_0x0064;
    L_0x002a:
        r9 = move-exception;
        r6 = r8;
        goto L_0x006d;
    L_0x002d:
        r6 = r8;
        goto L_0x0078;
    L_0x002f:
        r9 = move-exception;
        r6 = r8;
        goto L_0x0081;
    L_0x0032:
        r9 = move-exception;
        r6 = r8;
        goto L_0x008d;
    L_0x0035:
        r9 = move-exception;
        r6 = r8;
        goto L_0x0099;
    L_0x0038:
        r9 = move-exception;
        r6 = r8;
        goto L_0x00a5;
    L_0x003b:
        r9 = move-exception;
        r6 = r8;
        goto L_0x00b1;
    L_0x003e:
        r9 = r7.O000000o(r8, r13);	 Catch:{ ConnectException -> 0x003b, MalformedURLException -> 0x0038, UnknownHostException -> 0x0035, SocketException -> 0x0032, SocketTimeoutException -> 0x002f, InterruptedIOException -> 0x002d, IOException -> 0x002a, o0O0oo0o -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        if (r8 == 0) goto L_0x0050;
    L_0x0044:
        r8.disconnect();	 Catch:{ Throwable -> 0x0048 }
        goto L_0x0050;
    L_0x0048:
        r8 = move-exception;
        r10 = "ht";
        r11 = "mPt";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r8, r10, r11);
    L_0x0050:
        return r9;
    L_0x0051:
        r9 = move-exception;
        goto L_0x00bc;
    L_0x0053:
        r9 = move-exception;
    L_0x0054:
        r8 = "ht";
        r10 = "mPt";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r8, r10);	 Catch:{ all -> 0x0051 }
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0051 }
        r9 = "未知的错误";
        r8.<init>(r9);	 Catch:{ all -> 0x0051 }
        throw r8;	 Catch:{ all -> 0x0051 }
    L_0x0063:
        r9 = move-exception;
    L_0x0064:
        r8 = "ht";
        r10 = "mPt";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r8, r10);	 Catch:{ all -> 0x0051 }
        throw r9;	 Catch:{ all -> 0x0051 }
    L_0x006c:
        r9 = move-exception;
    L_0x006d:
        r9.printStackTrace();	 Catch:{ all -> 0x0051 }
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0051 }
        r9 = "IO 操作异常 - IOException";
        r8.<init>(r9);	 Catch:{ all -> 0x0051 }
        throw r8;	 Catch:{ all -> 0x0051 }
    L_0x0078:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0051 }
        r9 = "未知的错误";
        r8.<init>(r9);	 Catch:{ all -> 0x0051 }
        throw r8;	 Catch:{ all -> 0x0051 }
    L_0x0080:
        r9 = move-exception;
    L_0x0081:
        r9.printStackTrace();	 Catch:{ all -> 0x0051 }
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0051 }
        r9 = "socket 连接超时 - SocketTimeoutException";
        r8.<init>(r9);	 Catch:{ all -> 0x0051 }
        throw r8;	 Catch:{ all -> 0x0051 }
    L_0x008c:
        r9 = move-exception;
    L_0x008d:
        r9.printStackTrace();	 Catch:{ all -> 0x0051 }
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0051 }
        r9 = "socket 连接异常 - SocketException";
        r8.<init>(r9);	 Catch:{ all -> 0x0051 }
        throw r8;	 Catch:{ all -> 0x0051 }
    L_0x0098:
        r9 = move-exception;
    L_0x0099:
        r9.printStackTrace();	 Catch:{ all -> 0x0051 }
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0051 }
        r9 = "未知主机 - UnKnowHostException";
        r8.<init>(r9);	 Catch:{ all -> 0x0051 }
        throw r8;	 Catch:{ all -> 0x0051 }
    L_0x00a4:
        r9 = move-exception;
    L_0x00a5:
        r9.printStackTrace();	 Catch:{ all -> 0x0051 }
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0051 }
        r9 = "url异常 - MalformedURLException";
        r8.<init>(r9);	 Catch:{ all -> 0x0051 }
        throw r8;	 Catch:{ all -> 0x0051 }
    L_0x00b0:
        r9 = move-exception;
    L_0x00b1:
        r9.printStackTrace();	 Catch:{ all -> 0x0051 }
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0051 }
        r9 = "http连接失败 - ConnectionException";
        r8.<init>(r9);	 Catch:{ all -> 0x0051 }
        throw r8;	 Catch:{ all -> 0x0051 }
    L_0x00bc:
        if (r6 == 0) goto L_0x00ca;
    L_0x00be:
        r6.disconnect();	 Catch:{ Throwable -> 0x00c2 }
        goto L_0x00ca;
    L_0x00c2:
        r8 = move-exception;
        r10 = "ht";
        r11 = "mPt";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r8, r10, r11);
    L_0x00ca:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOO0O00O.O000000o(java.lang.String, boolean, java.lang.String, java.util.Map, byte[], boolean):com.amap.api.mapcore.util.oOO0Oo00");
    }

    /* Access modifiers changed, original: 0000 */
    public HttpURLConnection O000000o(String str, boolean z, String str2, Map<String, String> map, boolean z2) throws IOException {
        Map map2;
        HttpURLConnection httpURLConnection;
        o0O0o000.O00000Oo();
        if (map2 == null) {
            map2 = new HashMap();
        }
        HostnameVerifier O000000o = this.O0000Oo.O000000o();
        if (z && !TextUtils.isEmpty(str2)) {
            O000000o = this.O0000Oo.O000000o(str2);
        }
        str = O000000o(ooooOO00.O000000o, str, map2);
        if (this.O00000o0) {
            str = o0OO00OO.O000000o(str);
        }
        URL url = new URL(str);
        URLConnection O000000o2 = this.O0000OoO != null ? this.O0000OoO.O000000o(this.O00000oO, url) : null;
        if (O000000o2 == null) {
            O000000o2 = this.O00000oO != null ? url.openConnection(this.O00000oO) : url.openConnection();
        }
        if (this.O00000o0) {
            httpURLConnection = (HttpsURLConnection) O000000o2;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.O00000o.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(O000000o);
        } else {
            httpURLConnection = (HttpURLConnection) O000000o2;
        }
        if (VERSION.SDK != null && VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        O000000o(map2, httpURLConnection);
        if (z2) {
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod(Constants.HTTP_GET);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c7 A:{SYNTHETIC, Splitter:B:76:0x00c7} */
    public java.util.Map<java.lang.String, java.lang.String> O000000o(java.lang.String r7, boolean r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, java.util.Map<java.lang.String, java.lang.String> r11, boolean r12) throws com.amap.api.mapcore.util.o0O0oo0o {
        /*
        r6 = this;
        r12 = 0;
        r11 = O000000o(r11);	 Catch:{ ConnectException -> 0x00bd, MalformedURLException -> 0x00b5, UnknownHostException -> 0x00ad, SocketException -> 0x00a5, SocketTimeoutException -> 0x009d, InterruptedIOException -> 0x0095, IOException -> 0x008d, o0O0oo0o -> 0x008a, Throwable -> 0x007d }
        r0 = new java.lang.StringBuffer;	 Catch:{ ConnectException -> 0x00bd, MalformedURLException -> 0x00b5, UnknownHostException -> 0x00ad, SocketException -> 0x00a5, SocketTimeoutException -> 0x009d, InterruptedIOException -> 0x0095, IOException -> 0x008d, o0O0oo0o -> 0x008a, Throwable -> 0x007d }
        r0.<init>();	 Catch:{ ConnectException -> 0x00bd, MalformedURLException -> 0x00b5, UnknownHostException -> 0x00ad, SocketException -> 0x00a5, SocketTimeoutException -> 0x009d, InterruptedIOException -> 0x0095, IOException -> 0x008d, o0O0oo0o -> 0x008a, Throwable -> 0x007d }
        r0.append(r7);	 Catch:{ ConnectException -> 0x00bd, MalformedURLException -> 0x00b5, UnknownHostException -> 0x00ad, SocketException -> 0x00a5, SocketTimeoutException -> 0x009d, InterruptedIOException -> 0x0095, IOException -> 0x008d, o0O0oo0o -> 0x008a, Throwable -> 0x007d }
        if (r11 == 0) goto L_0x0017;
    L_0x000f:
        r7 = "?";
        r0.append(r7);	 Catch:{ ConnectException -> 0x00bd, MalformedURLException -> 0x00b5, UnknownHostException -> 0x00ad, SocketException -> 0x00a5, SocketTimeoutException -> 0x009d, InterruptedIOException -> 0x0095, IOException -> 0x008d, o0O0oo0o -> 0x008a, Throwable -> 0x007d }
        r0.append(r11);	 Catch:{ ConnectException -> 0x00bd, MalformedURLException -> 0x00b5, UnknownHostException -> 0x00ad, SocketException -> 0x00a5, SocketTimeoutException -> 0x009d, InterruptedIOException -> 0x0095, IOException -> 0x008d, o0O0oo0o -> 0x008a, Throwable -> 0x007d }
    L_0x0017:
        r1 = r0.toString();	 Catch:{ ConnectException -> 0x00bd, MalformedURLException -> 0x00b5, UnknownHostException -> 0x00ad, SocketException -> 0x00a5, SocketTimeoutException -> 0x009d, InterruptedIOException -> 0x0095, IOException -> 0x008d, o0O0oo0o -> 0x008a, Throwable -> 0x007d }
        r5 = 0;
        r0 = r6;
        r2 = r8;
        r3 = r9;
        r4 = r10;
        r7 = r0.O000000o(r1, r2, r3, r4, r5);	 Catch:{ ConnectException -> 0x00bd, MalformedURLException -> 0x00b5, UnknownHostException -> 0x00ad, SocketException -> 0x00a5, SocketTimeoutException -> 0x009d, InterruptedIOException -> 0x0095, IOException -> 0x008d, o0O0oo0o -> 0x008a, Throwable -> 0x007d }
        r8 = r7.getResponseCode();	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        r9 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r8 < r9) goto L_0x0034;
    L_0x002c:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        r9 = "http读取header失败";
        r8.<init>(r9);	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        throw r8;	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
    L_0x0034:
        r8 = new java.util.HashMap;	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        r8.<init>();	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        r9 = 0;
    L_0x003a:
        r10 = 50;
        if (r9 >= r10) goto L_0x0053;
    L_0x003e:
        r10 = r7.getHeaderFieldKey(r9);	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        if (r10 != 0) goto L_0x0045;
    L_0x0044:
        goto L_0x0053;
    L_0x0045:
        r11 = r7.getHeaderField(r10);	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        r10 = r10.toLowerCase();	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        r8.put(r10, r11);	 Catch:{ ConnectException -> 0x0079, MalformedURLException -> 0x0077, UnknownHostException -> 0x0075, SocketException -> 0x0073, SocketTimeoutException -> 0x0071, InterruptedIOException -> 0x006f, IOException -> 0x006d, o0O0oo0o -> 0x006a, Throwable -> 0x0067, all -> 0x0062 }
        r9 = r9 + 1;
        goto L_0x003a;
    L_0x0053:
        if (r7 == 0) goto L_0x0061;
    L_0x0055:
        r7.disconnect();	 Catch:{ Throwable -> 0x0059 }
        goto L_0x0061;
    L_0x0059:
        r7 = move-exception;
        r9 = "hth";
        r10 = "mgr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r7, r9, r10);
    L_0x0061:
        return r8;
    L_0x0062:
        r8 = move-exception;
        r12 = r7;
        r7 = r8;
        goto L_0x00c5;
    L_0x0067:
        r8 = move-exception;
        r12 = r7;
        goto L_0x007f;
    L_0x006a:
        r8 = move-exception;
        r12 = r7;
        goto L_0x008c;
    L_0x006d:
        r12 = r7;
        goto L_0x008d;
    L_0x006f:
        r12 = r7;
        goto L_0x0095;
    L_0x0071:
        r12 = r7;
        goto L_0x009d;
    L_0x0073:
        r12 = r7;
        goto L_0x00a5;
    L_0x0075:
        r12 = r7;
        goto L_0x00ad;
    L_0x0077:
        r12 = r7;
        goto L_0x00b5;
    L_0x0079:
        r12 = r7;
        goto L_0x00bd;
    L_0x007b:
        r7 = move-exception;
        goto L_0x00c5;
    L_0x007d:
        r7 = move-exception;
        r8 = r7;
    L_0x007f:
        r8.printStackTrace();	 Catch:{ all -> 0x007b }
        r7 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x007b }
        r8 = "未知的错误";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x008a:
        r7 = move-exception;
        r8 = r7;
    L_0x008c:
        throw r8;	 Catch:{ all -> 0x007b }
    L_0x008d:
        r7 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x007b }
        r8 = "IO 操作异常 - IOException";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x0095:
        r7 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x007b }
        r8 = "未知的错误";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x009d:
        r7 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x007b }
        r8 = "socket 连接超时 - SocketTimeoutException";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x00a5:
        r7 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x007b }
        r8 = "socket 连接异常 - SocketException";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x00ad:
        r7 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x007b }
        r8 = "未知主机 - UnKnowHostException";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x00b5:
        r7 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x007b }
        r8 = "url异常 - MalformedURLException";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x00bd:
        r7 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x007b }
        r8 = "http连接失败 - ConnectionException";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x00c5:
        if (r12 == 0) goto L_0x00d3;
    L_0x00c7:
        r12.disconnect();	 Catch:{ Throwable -> 0x00cb }
        goto L_0x00d3;
    L_0x00cb:
        r8 = move-exception;
        r9 = "hth";
        r10 = "mgr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r8, r9, r10);
    L_0x00d3:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOO0O00O.O000000o(java.lang.String, boolean, java.lang.String, java.util.Map, java.util.Map, boolean):java.util.Map");
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o() {
        this.O00000oo = true;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(long j) {
        this.O0000OOo = j;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0119 A:{SYNTHETIC, Splitter:B:73:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0130 A:{SYNTHETIC, Splitter:B:80:0x0130} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0119 A:{SYNTHETIC, Splitter:B:73:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0130 A:{SYNTHETIC, Splitter:B:80:0x0130} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0140 A:{SYNTHETIC, Splitter:B:87:0x0140} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0157 A:{SYNTHETIC, Splitter:B:94:0x0157} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0140 A:{SYNTHETIC, Splitter:B:87:0x0140} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0157 A:{SYNTHETIC, Splitter:B:94:0x0157} */
    public void O000000o(java.lang.String r9, boolean r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.util.Map<java.lang.String, java.lang.String> r13, byte[] r14, com.amap.api.mapcore.util.oOO0O000.O000000o r15) {
        /*
        r8 = this;
        if (r15 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = 0;
        r13 = O000000o(r13);	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
        r1 = new java.lang.StringBuffer;	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
        r1.<init>();	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
        r1.append(r9);	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
        if (r13 == 0) goto L_0x001a;
    L_0x0012:
        r9 = "?";
        r1.append(r9);	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
        r1.append(r13);	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
    L_0x001a:
        r9 = 1;
        r13 = 0;
        if (r14 == 0) goto L_0x0023;
    L_0x001e:
        r2 = r14.length;	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
        if (r2 <= 0) goto L_0x0023;
    L_0x0021:
        r7 = r9;
        goto L_0x0024;
    L_0x0023:
        r7 = r13;
    L_0x0024:
        r2 = r1.toString();	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
        r1 = r8;
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r6 = r7;
        r10 = r1.O000000o(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0112, all -> 0x010f }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010d }
        r11.<init>();	 Catch:{ Throwable -> 0x010d }
        r12 = "bytes=";
        r11.append(r12);	 Catch:{ Throwable -> 0x010d }
        r1 = r8.O0000OOo;	 Catch:{ Throwable -> 0x010d }
        r11.append(r1);	 Catch:{ Throwable -> 0x010d }
        r12 = "-";
        r11.append(r12);	 Catch:{ Throwable -> 0x010d }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x010d }
        r12 = "RANGE";
        r10.setRequestProperty(r12, r11);	 Catch:{ Throwable -> 0x010d }
        if (r7 == 0) goto L_0x005f;
    L_0x0050:
        r11 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x010d }
        r12 = r10.getOutputStream();	 Catch:{ Throwable -> 0x010d }
        r11.<init>(r12);	 Catch:{ Throwable -> 0x010d }
        r11.write(r14);	 Catch:{ Throwable -> 0x010d }
        r11.close();	 Catch:{ Throwable -> 0x010d }
    L_0x005f:
        r10.connect();	 Catch:{ Throwable -> 0x010d }
        r11 = r10.getResponseCode();	 Catch:{ Throwable -> 0x010d }
        r12 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r11 == r12) goto L_0x006c;
    L_0x006a:
        r12 = r9;
        goto L_0x006d;
    L_0x006c:
        r12 = r13;
    L_0x006d:
        r14 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r11 == r14) goto L_0x0072;
    L_0x0071:
        goto L_0x0073;
    L_0x0072:
        r9 = r13;
    L_0x0073:
        r9 = r9 & r12;
        if (r9 == 0) goto L_0x009b;
    L_0x0076:
        r9 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ Throwable -> 0x010d }
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010d }
        r12.<init>();	 Catch:{ Throwable -> 0x010d }
        r14 = "网络异常原因：";
        r12.append(r14);	 Catch:{ Throwable -> 0x010d }
        r14 = r10.getResponseMessage();	 Catch:{ Throwable -> 0x010d }
        r12.append(r14);	 Catch:{ Throwable -> 0x010d }
        r14 = " 网络异常状态码：";
        r12.append(r14);	 Catch:{ Throwable -> 0x010d }
        r12.append(r11);	 Catch:{ Throwable -> 0x010d }
        r11 = r12.toString();	 Catch:{ Throwable -> 0x010d }
        r9.<init>(r11);	 Catch:{ Throwable -> 0x010d }
        r15.onException(r9);	 Catch:{ Throwable -> 0x010d }
    L_0x009b:
        r9 = r10.getInputStream();	 Catch:{ Throwable -> 0x010d }
        r11 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r12 = new byte[r11];	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
    L_0x00a3:
        r14 = java.lang.Thread.interrupted();	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        if (r14 != 0) goto L_0x00dd;
    L_0x00a9:
        r14 = r8.O00000oo;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        if (r14 != 0) goto L_0x00dd;
    L_0x00ad:
        r14 = r9.read(r12, r13, r11);	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        if (r14 <= 0) goto L_0x00dd;
    L_0x00b3:
        r0 = r8.O0000O0o;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        r2 = -1;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x00c3;
    L_0x00bb:
        r0 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        r2 = r8.O0000O0o;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 >= 0) goto L_0x00dd;
    L_0x00c3:
        if (r14 != r11) goto L_0x00cb;
    L_0x00c5:
        r0 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        r15.onDownload(r12, r0);	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        goto L_0x00d5;
    L_0x00cb:
        r0 = new byte[r14];	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        java.lang.System.arraycopy(r12, r13, r0, r13, r14);	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        r1 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        r15.onDownload(r0, r1);	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
    L_0x00d5:
        r0 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        r2 = (long) r14;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        r4 = r0 + r2;
        r8.O0000OOo = r4;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        goto L_0x00a3;
    L_0x00dd:
        r11 = r8.O00000oo;	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        if (r11 == 0) goto L_0x00e5;
    L_0x00e1:
        r15.onStop();	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
        goto L_0x00e8;
    L_0x00e5:
        r15.onFinish();	 Catch:{ Throwable -> 0x0109, all -> 0x0105 }
    L_0x00e8:
        if (r9 == 0) goto L_0x00ff;
    L_0x00ea:
        r9.close();	 Catch:{ IOException -> 0x00f7, Throwable -> 0x00ee }
        goto L_0x00ff;
    L_0x00ee:
        r9 = move-exception;
        r11 = "ht";
        r12 = "mdr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r11, r12);
        goto L_0x00ff;
    L_0x00f7:
        r9 = move-exception;
        r11 = "ht";
        r12 = "mdr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r11, r12);
    L_0x00ff:
        if (r10 == 0) goto L_0x013c;
    L_0x0101:
        r10.disconnect();	 Catch:{ Throwable -> 0x0134 }
        goto L_0x013c;
    L_0x0105:
        r11 = move-exception;
        r0 = r9;
        r9 = r11;
        goto L_0x013e;
    L_0x0109:
        r11 = move-exception;
        r0 = r9;
        r9 = r11;
        goto L_0x0114;
    L_0x010d:
        r9 = move-exception;
        goto L_0x0114;
    L_0x010f:
        r9 = move-exception;
        r10 = r0;
        goto L_0x013e;
    L_0x0112:
        r9 = move-exception;
        r10 = r0;
    L_0x0114:
        r15.onException(r9);	 Catch:{ all -> 0x013d }
        if (r0 == 0) goto L_0x012e;
    L_0x0119:
        r0.close();	 Catch:{ IOException -> 0x0126, Throwable -> 0x011d }
        goto L_0x012e;
    L_0x011d:
        r9 = move-exception;
        r11 = "ht";
        r12 = "mdr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r11, r12);
        goto L_0x012e;
    L_0x0126:
        r9 = move-exception;
        r11 = "ht";
        r12 = "mdr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r11, r12);
    L_0x012e:
        if (r10 == 0) goto L_0x013c;
    L_0x0130:
        r10.disconnect();	 Catch:{ Throwable -> 0x0134 }
        goto L_0x013c;
    L_0x0134:
        r9 = move-exception;
        r10 = "ht";
        r11 = "mdr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r10, r11);
    L_0x013c:
        return;
    L_0x013d:
        r9 = move-exception;
    L_0x013e:
        if (r0 == 0) goto L_0x0155;
    L_0x0140:
        r0.close();	 Catch:{ IOException -> 0x014d, Throwable -> 0x0144 }
        goto L_0x0155;
    L_0x0144:
        r11 = move-exception;
        r12 = "ht";
        r13 = "mdr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r11, r12, r13);
        goto L_0x0155;
    L_0x014d:
        r11 = move-exception;
        r12 = "ht";
        r13 = "mdr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r11, r12, r13);
    L_0x0155:
        if (r10 == 0) goto L_0x0163;
    L_0x0157:
        r10.disconnect();	 Catch:{ Throwable -> 0x015b }
        goto L_0x0163;
    L_0x015b:
        r10 = move-exception;
        r11 = "ht";
        r12 = "mdr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r10, r11, r12);
    L_0x0163:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOO0O00O.O000000o(java.lang.String, boolean, java.lang.String, java.util.Map, java.util.Map, byte[], com.amap.api.mapcore.util.oOO0O000$O000000o):void");
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x009c A:{SYNTHETIC, Splitter:B:63:0x009c} */
    public com.amap.api.mapcore.util.oOO0Oo00 O00000Oo(java.lang.String r8, boolean r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, java.util.Map<java.lang.String, java.lang.String> r12, boolean r13) throws com.amap.api.mapcore.util.o0O0oo0o {
        /*
        r7 = this;
        r0 = 0;
        r12 = O000000o(r12);	 Catch:{ ConnectException -> 0x0092, MalformedURLException -> 0x008a, UnknownHostException -> 0x0082, SocketException -> 0x007a, SocketTimeoutException -> 0x0072, InterruptedIOException -> 0x006a, IOException -> 0x0062, o0O0oo0o -> 0x0060, Throwable -> 0x0054 }
        r1 = new java.lang.StringBuffer;	 Catch:{ ConnectException -> 0x0092, MalformedURLException -> 0x008a, UnknownHostException -> 0x0082, SocketException -> 0x007a, SocketTimeoutException -> 0x0072, InterruptedIOException -> 0x006a, IOException -> 0x0062, o0O0oo0o -> 0x0060, Throwable -> 0x0054 }
        r1.<init>();	 Catch:{ ConnectException -> 0x0092, MalformedURLException -> 0x008a, UnknownHostException -> 0x0082, SocketException -> 0x007a, SocketTimeoutException -> 0x0072, InterruptedIOException -> 0x006a, IOException -> 0x0062, o0O0oo0o -> 0x0060, Throwable -> 0x0054 }
        r1.append(r8);	 Catch:{ ConnectException -> 0x0092, MalformedURLException -> 0x008a, UnknownHostException -> 0x0082, SocketException -> 0x007a, SocketTimeoutException -> 0x0072, InterruptedIOException -> 0x006a, IOException -> 0x0062, o0O0oo0o -> 0x0060, Throwable -> 0x0054 }
        if (r12 == 0) goto L_0x0017;
    L_0x000f:
        r8 = "?";
        r1.append(r8);	 Catch:{ ConnectException -> 0x0092, MalformedURLException -> 0x008a, UnknownHostException -> 0x0082, SocketException -> 0x007a, SocketTimeoutException -> 0x0072, InterruptedIOException -> 0x006a, IOException -> 0x0062, o0O0oo0o -> 0x0060, Throwable -> 0x0054 }
        r1.append(r12);	 Catch:{ ConnectException -> 0x0092, MalformedURLException -> 0x008a, UnknownHostException -> 0x0082, SocketException -> 0x007a, SocketTimeoutException -> 0x0072, InterruptedIOException -> 0x006a, IOException -> 0x0062, o0O0oo0o -> 0x0060, Throwable -> 0x0054 }
    L_0x0017:
        r2 = r1.toString();	 Catch:{ ConnectException -> 0x0092, MalformedURLException -> 0x008a, UnknownHostException -> 0x0082, SocketException -> 0x007a, SocketTimeoutException -> 0x0072, InterruptedIOException -> 0x006a, IOException -> 0x0062, o0O0oo0o -> 0x0060, Throwable -> 0x0054 }
        r6 = 0;
        r1 = r7;
        r3 = r9;
        r4 = r10;
        r5 = r11;
        r8 = r1.O000000o(r2, r3, r4, r5, r6);	 Catch:{ ConnectException -> 0x0092, MalformedURLException -> 0x008a, UnknownHostException -> 0x0082, SocketException -> 0x007a, SocketTimeoutException -> 0x0072, InterruptedIOException -> 0x006a, IOException -> 0x0062, o0O0oo0o -> 0x0060, Throwable -> 0x0054 }
        r9 = r7.O000000o(r8, r13);	 Catch:{ ConnectException -> 0x0050, MalformedURLException -> 0x004e, UnknownHostException -> 0x004c, SocketException -> 0x004a, SocketTimeoutException -> 0x0048, InterruptedIOException -> 0x0046, IOException -> 0x0044, o0O0oo0o -> 0x0040, Throwable -> 0x003c, all -> 0x0037 }
        if (r8 == 0) goto L_0x0036;
    L_0x002a:
        r8.disconnect();	 Catch:{ Throwable -> 0x002e }
        goto L_0x0036;
    L_0x002e:
        r8 = move-exception;
        r10 = "ht";
        r11 = "mgr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r8, r10, r11);
    L_0x0036:
        return r9;
    L_0x0037:
        r9 = move-exception;
        r0 = r8;
        r8 = r9;
        goto L_0x009a;
    L_0x003c:
        r9 = move-exception;
        r0 = r8;
        r8 = r9;
        goto L_0x0055;
    L_0x0040:
        r9 = move-exception;
        r0 = r8;
        r8 = r9;
        goto L_0x0061;
    L_0x0044:
        r0 = r8;
        goto L_0x0062;
    L_0x0046:
        r0 = r8;
        goto L_0x006a;
    L_0x0048:
        r0 = r8;
        goto L_0x0072;
    L_0x004a:
        r0 = r8;
        goto L_0x007a;
    L_0x004c:
        r0 = r8;
        goto L_0x0082;
    L_0x004e:
        r0 = r8;
        goto L_0x008a;
    L_0x0050:
        r0 = r8;
        goto L_0x0092;
    L_0x0052:
        r8 = move-exception;
        goto L_0x009a;
    L_0x0054:
        r8 = move-exception;
    L_0x0055:
        r8.printStackTrace();	 Catch:{ all -> 0x0052 }
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0052 }
        r9 = "未知的错误";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0060:
        r8 = move-exception;
    L_0x0061:
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0062:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0052 }
        r9 = "IO 操作异常 - IOException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x006a:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0052 }
        r9 = "未知的错误";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0072:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0052 }
        r9 = "socket 连接超时 - SocketTimeoutException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x007a:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0052 }
        r9 = "socket 连接异常 - SocketException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0082:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0052 }
        r9 = "未知主机 - UnKnowHostException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x008a:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0052 }
        r9 = "url异常 - MalformedURLException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0092:
        r8 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x0052 }
        r9 = "http连接失败 - ConnectionException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x009a:
        if (r0 == 0) goto L_0x00a8;
    L_0x009c:
        r0.disconnect();	 Catch:{ Throwable -> 0x00a0 }
        goto L_0x00a8;
    L_0x00a0:
        r9 = move-exception;
        r10 = "ht";
        r11 = "mgr";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r10, r11);
    L_0x00a8:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOO0O00O.O00000Oo(java.lang.String, boolean, java.lang.String, java.util.Map, java.util.Map, boolean):com.amap.api.mapcore.util.oOO0Oo00");
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(long j) {
        this.O0000O0o = j;
    }
}
