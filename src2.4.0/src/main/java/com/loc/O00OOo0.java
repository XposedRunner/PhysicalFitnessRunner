package com.loc;

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
public final class O00OOo0 {
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
    private com.loc.O00O0o.O000000o O0000OoO;

    /* compiled from: HttpUrlUtil */
    private static class O000000o {
        private Vector<O00000Oo> O000000o;
        private volatile O00000Oo O00000Oo;

        private O000000o() {
            this.O000000o = new Vector();
            this.O00000Oo = new O00000Oo();
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final O00000Oo O000000o() {
            return this.O00000Oo;
        }

        public final O00000Oo O000000o(String str) {
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

        public final void O00000Oo(String str) {
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

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final String O000000o() {
            return this.O00000Oo;
        }

        public final void O000000o(String str) {
            this.O000000o = str;
        }

        public final void O00000Oo(String str) {
            this.O00000Oo = str;
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.O000000o) ? this.O000000o.equals(str) : !TextUtils.isEmpty(this.O00000Oo) ? defaultHostnameVerifier.verify(this.O00000Oo, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    O00OOo0(int i, int i2, Proxy proxy, boolean z) {
        this(i, i2, proxy, z, (byte) 0);
    }

    private O00OOo0(int i, int i2, Proxy proxy, boolean z, byte b) {
        this.O00000oo = false;
        this.O0000O0o = -1;
        this.O0000OOo = 0;
        this.O000000o = i;
        this.O00000Oo = i2;
        this.O00000oO = proxy;
        this.O00000o0 = OO0OO0o.O000000o().O00000Oo(z);
        if (OO0OO0o.O00000Oo()) {
            this.O00000o0 = false;
        }
        this.O0000OoO = null;
        try {
            this.O0000Oo0 = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "ht", "ic");
        }
        if (this.O00000o0) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.O00000o = instance;
            } catch (Throwable th2) {
                O0000Oo.O000000o(th2, "ht", "ne");
            }
        }
        this.O0000Oo = new O000000o();
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0118 A:{SYNTHETIC, Splitter:B:77:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0126 A:{SYNTHETIC, Splitter:B:82:0x0126} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0134 A:{SYNTHETIC, Splitter:B:87:0x0134} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0142 A:{SYNTHETIC, Splitter:B:92:0x0142} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0118 A:{SYNTHETIC, Splitter:B:77:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0126 A:{SYNTHETIC, Splitter:B:82:0x0126} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0134 A:{SYNTHETIC, Splitter:B:87:0x0134} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0142 A:{SYNTHETIC, Splitter:B:92:0x0142} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0118 A:{SYNTHETIC, Splitter:B:77:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0126 A:{SYNTHETIC, Splitter:B:82:0x0126} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0134 A:{SYNTHETIC, Splitter:B:87:0x0134} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0142 A:{SYNTHETIC, Splitter:B:92:0x0142} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0118 A:{SYNTHETIC, Splitter:B:77:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0126 A:{SYNTHETIC, Splitter:B:82:0x0126} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0134 A:{SYNTHETIC, Splitter:B:87:0x0134} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0142 A:{SYNTHETIC, Splitter:B:92:0x0142} */
    private com.loc.O00Oo00 O000000o(java.net.HttpURLConnection r11) throws com.loc.OO00Oo0, java.io.IOException {
        /*
        r10 = this;
        r0 = "";
        r1 = 0;
        r11.connect();	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r2 = r11.getHeaderFields();	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r3 = r11.getResponseCode();	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r4 = 0;
        if (r2 == 0) goto L_0x0028;
    L_0x0011:
        r5 = "gsid";
        r5 = r2.get(r5);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r5 = (java.util.List) r5;	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        if (r5 == 0) goto L_0x0028;
    L_0x001b:
        r6 = r5.size();	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        if (r6 <= 0) goto L_0x0028;
    L_0x0021:
        r5 = r5.get(r4);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r0 = r5;
    L_0x0028:
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 == r5) goto L_0x0061;
    L_0x002c:
        r2 = new com.loc.OO00Oo0;	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r5 = "网络异常原因：";
        r4.<init>(r5);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r11 = r11.getResponseMessage();	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r4.append(r11);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r11 = " 网络异常状态码：";
        r4.append(r11);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r4.append(r3);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r11 = "  ";
        r4.append(r11);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r4.append(r0);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r11 = " ";
        r4.append(r11);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r11 = r10.O0000Oo0;	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r4.append(r11);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r11 = r4.toString();	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r2.<init>(r11, r0);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r2.O000000o(r3);	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        throw r2;	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
    L_0x0061:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r3.<init>();	 Catch:{ IOException -> 0x0107, all -> 0x0102 }
        r11 = r11.getInputStream();	 Catch:{ IOException -> 0x00fd, all -> 0x00f7 }
        r5 = new java.io.PushbackInputStream;	 Catch:{ IOException -> 0x00f5, all -> 0x00f0 }
        r6 = 2;
        r5.<init>(r11, r6);	 Catch:{ IOException -> 0x00f5, all -> 0x00f0 }
        r6 = new byte[r6];	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r5.read(r6);	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r5.unread(r6);	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r7 = r6[r4];	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r8 = 31;
        if (r7 != r8) goto L_0x008c;
    L_0x007e:
        r7 = 1;
        r6 = r6[r7];	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r7 = -117; // 0xffffffffffffff8b float:NaN double:NaN;
        if (r6 != r7) goto L_0x008c;
    L_0x0085:
        r6 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r6.<init>(r5);	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r1 = r6;
        goto L_0x008d;
    L_0x008c:
        r1 = r5;
    L_0x008d:
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6 = new byte[r6];	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
    L_0x0091:
        r7 = r1.read(r6);	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r8 = -1;
        if (r7 == r8) goto L_0x009c;
    L_0x0098:
        r3.write(r6, r4, r7);	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        goto L_0x0091;
    L_0x009c:
        com.loc.O0000o.O00000o0();	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r4 = new com.loc.O00Oo00;	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r4.<init>();	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r6 = r3.toByteArray();	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r4.O000000o = r6;	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r4.O00000Oo = r2;	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r2 = r10.O0000Oo0;	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r4.O00000o0 = r2;	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        r4.O00000o = r0;	 Catch:{ IOException -> 0x00ee, all -> 0x00eb }
        if (r3 == 0) goto L_0x00c0;
    L_0x00b4:
        r3.close();	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x00c0;
    L_0x00b8:
        r0 = move-exception;
        r2 = "ht";
        r3 = "par";
        com.loc.O0000Oo.O000000o(r0, r2, r3);
    L_0x00c0:
        if (r11 == 0) goto L_0x00ce;
    L_0x00c2:
        r11.close();	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x00ce;
    L_0x00c6:
        r11 = move-exception;
        r0 = "ht";
        r2 = "par";
        com.loc.O0000Oo.O000000o(r11, r0, r2);
    L_0x00ce:
        if (r5 == 0) goto L_0x00dc;
    L_0x00d0:
        r5.close();	 Catch:{ Throwable -> 0x00d4 }
        goto L_0x00dc;
    L_0x00d4:
        r11 = move-exception;
        r0 = "ht";
        r2 = "par";
        com.loc.O0000Oo.O000000o(r11, r0, r2);
    L_0x00dc:
        if (r1 == 0) goto L_0x00ea;
    L_0x00de:
        r1.close();	 Catch:{ Throwable -> 0x00e2 }
        return r4;
    L_0x00e2:
        r11 = move-exception;
        r0 = "ht";
        r1 = "par";
        com.loc.O0000Oo.O000000o(r11, r0, r1);
    L_0x00ea:
        return r4;
    L_0x00eb:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00f3;
    L_0x00ee:
        r2 = r1;
        goto L_0x0100;
    L_0x00f0:
        r0 = move-exception;
        r2 = r1;
        r5 = r2;
    L_0x00f3:
        r1 = r3;
        goto L_0x0113;
    L_0x00f5:
        r2 = r1;
        goto L_0x00ff;
    L_0x00f7:
        r11 = move-exception;
        r0 = r1;
        r2 = r0;
        r5 = r2;
        r1 = r3;
        goto L_0x0116;
    L_0x00fd:
        r11 = r1;
        r2 = r11;
    L_0x00ff:
        r5 = r2;
    L_0x0100:
        r1 = r3;
        goto L_0x010a;
    L_0x0102:
        r11 = move-exception;
        r0 = r1;
        r2 = r0;
        r5 = r2;
        goto L_0x0116;
    L_0x0107:
        r11 = r1;
        r2 = r11;
        r5 = r2;
    L_0x010a:
        r3 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0112 }
        r4 = "IO 操作异常 - IOException";
        r3.<init>(r4, r0);	 Catch:{ all -> 0x0112 }
        throw r3;	 Catch:{ all -> 0x0112 }
    L_0x0112:
        r0 = move-exception;
    L_0x0113:
        r9 = r0;
        r0 = r11;
        r11 = r9;
    L_0x0116:
        if (r1 == 0) goto L_0x0124;
    L_0x0118:
        r1.close();	 Catch:{ Throwable -> 0x011c }
        goto L_0x0124;
    L_0x011c:
        r1 = move-exception;
        r3 = "ht";
        r4 = "par";
        com.loc.O0000Oo.O000000o(r1, r3, r4);
    L_0x0124:
        if (r0 == 0) goto L_0x0132;
    L_0x0126:
        r0.close();	 Catch:{ Throwable -> 0x012a }
        goto L_0x0132;
    L_0x012a:
        r0 = move-exception;
        r1 = "ht";
        r3 = "par";
        com.loc.O0000Oo.O000000o(r0, r1, r3);
    L_0x0132:
        if (r5 == 0) goto L_0x0140;
    L_0x0134:
        r5.close();	 Catch:{ Throwable -> 0x0138 }
        goto L_0x0140;
    L_0x0138:
        r0 = move-exception;
        r1 = "ht";
        r3 = "par";
        com.loc.O0000Oo.O000000o(r0, r1, r3);
    L_0x0140:
        if (r2 == 0) goto L_0x014e;
    L_0x0142:
        r2.close();	 Catch:{ Throwable -> 0x0146 }
        goto L_0x014e;
    L_0x0146:
        r0 = move-exception;
        r1 = "ht";
        r2 = "par";
        com.loc.O0000Oo.O000000o(r0, r1, r2);
    L_0x014e:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00OOo0.O000000o(java.net.HttpURLConnection):com.loc.O00Oo00");
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

    private HttpURLConnection O000000o(String str, boolean z, String str2, Map<String, String> map, boolean z2) throws IOException {
        Map map2;
        URLConnection O000000o;
        HttpURLConnection httpURLConnection;
        OO0O0o0.O00000Oo();
        if (map2 == null) {
            map2 = new HashMap();
        }
        HostnameVerifier O000000o2 = this.O0000Oo.O000000o();
        if (z && !TextUtils.isEmpty(str2)) {
            O000000o2 = this.O0000Oo.O000000o(str2);
        }
        CharSequence charSequence = "";
        if (O00O0o.O000000o == 1) {
            charSequence = O00O0o.O00000Oo;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            str = parse.buildUpon().encodedAuthority(charSequence).build().toString();
            if (map2 != null) {
                map2.put("targetHost", host);
            }
            if (this.O00000o0) {
                this.O0000Oo.O00000Oo(charSequence);
            }
        }
        if (this.O00000o0) {
            str = OO0OO0o.O000000o(str);
        }
        URL url = new URL(str);
        if (this.O0000OoO != null) {
            com.loc.O00O0o.O000000o o000000o = this.O0000OoO;
            Proxy proxy = this.O00000oO;
            O000000o = o000000o.O000000o();
        } else {
            O000000o = null;
        }
        if (O000000o == null) {
            O000000o = this.O00000oO != null ? url.openConnection(this.O00000oO) : url.openConnection();
        }
        if (this.O00000o0) {
            httpURLConnection = (HttpsURLConnection) O000000o;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.O00000o.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(O000000o2);
        } else {
            httpURLConnection = (HttpURLConnection) O000000o;
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
            return httpURLConnection;
        }
        httpURLConnection.setRequestMethod(Constants.HTTP_GET);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
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
            O0000Oo.O000000o(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.O000000o);
        httpURLConnection.setReadTimeout(this.O00000Oo);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bf A:{SYNTHETIC, Splitter:B:66:0x00bf} */
    public final com.loc.O00Oo00 O000000o(java.lang.String r8, boolean r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, byte[] r12) throws com.loc.OO00Oo0 {
        /*
        r7 = this;
        r5 = 1;
        r6 = 0;
        r0 = r7;
        r1 = r8;
        r2 = r9;
        r3 = r10;
        r4 = r11;
        r8 = r0.O000000o(r1, r2, r3, r4, r5);	 Catch:{ ConnectException -> 0x00b1, MalformedURLException -> 0x00a5, UnknownHostException -> 0x0099, SocketException -> 0x008d, SocketTimeoutException -> 0x0081, InterruptedIOException -> 0x0079, IOException -> 0x006d, OO00Oo0 -> 0x0064, Throwable -> 0x0054 }
        if (r12 == 0) goto L_0x003d;
    L_0x000d:
        r9 = r12.length;	 Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, OO00Oo0 -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        if (r9 <= 0) goto L_0x003d;
    L_0x0010:
        r9 = new java.io.DataOutputStream;	 Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, OO00Oo0 -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        r10 = r8.getOutputStream();	 Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, OO00Oo0 -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        r9.<init>(r10);	 Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, OO00Oo0 -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        r9.write(r12);	 Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, OO00Oo0 -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        r9.close();	 Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, OO00Oo0 -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        goto L_0x003d;
    L_0x0020:
        r9 = move-exception;
        r6 = r8;
        goto L_0x00bd;
    L_0x0024:
        r9 = move-exception;
        r6 = r8;
        goto L_0x0055;
    L_0x0027:
        r9 = move-exception;
        r6 = r8;
        goto L_0x0065;
    L_0x002a:
        r9 = move-exception;
        r6 = r8;
        goto L_0x006e;
    L_0x002d:
        r9 = move-exception;
        r6 = r8;
        goto L_0x0082;
    L_0x0030:
        r9 = move-exception;
        r6 = r8;
        goto L_0x008e;
    L_0x0033:
        r9 = move-exception;
        r6 = r8;
        goto L_0x009a;
    L_0x0036:
        r9 = move-exception;
        r6 = r8;
        goto L_0x00a6;
    L_0x0039:
        r9 = move-exception;
        r6 = r8;
        goto L_0x00b2;
    L_0x003d:
        r9 = r7.O000000o(r8);	 Catch:{ ConnectException -> 0x0039, MalformedURLException -> 0x0036, UnknownHostException -> 0x0033, SocketException -> 0x0030, SocketTimeoutException -> 0x002d, InterruptedIOException -> 0x0050, IOException -> 0x002a, OO00Oo0 -> 0x0027, Throwable -> 0x0024, all -> 0x0020 }
        if (r8 == 0) goto L_0x004f;
    L_0x0043:
        r8.disconnect();	 Catch:{ Throwable -> 0x0047 }
        return r9;
    L_0x0047:
        r8 = move-exception;
        r10 = "ht";
        r11 = "mPt";
        com.loc.O0000Oo.O000000o(r8, r10, r11);
    L_0x004f:
        return r9;
    L_0x0050:
        r6 = r8;
        goto L_0x0079;
    L_0x0052:
        r9 = move-exception;
        goto L_0x00bd;
    L_0x0054:
        r9 = move-exception;
    L_0x0055:
        r8 = "ht";
        r10 = "mPt";
        com.loc.O0000Oo.O000000o(r9, r8, r10);	 Catch:{ all -> 0x0052 }
        r8 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0052 }
        r9 = "未知的错误";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0064:
        r9 = move-exception;
    L_0x0065:
        r8 = "ht";
        r10 = "mPt";
        com.loc.O0000Oo.O000000o(r9, r8, r10);	 Catch:{ all -> 0x0052 }
        throw r9;	 Catch:{ all -> 0x0052 }
    L_0x006d:
        r9 = move-exception;
    L_0x006e:
        r9.printStackTrace();	 Catch:{ all -> 0x0052 }
        r8 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0052 }
        r9 = "IO 操作异常 - IOException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0079:
        r8 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0052 }
        r9 = "未知的错误";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0081:
        r9 = move-exception;
    L_0x0082:
        r9.printStackTrace();	 Catch:{ all -> 0x0052 }
        r8 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0052 }
        r9 = "socket 连接超时 - SocketTimeoutException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x008d:
        r9 = move-exception;
    L_0x008e:
        r9.printStackTrace();	 Catch:{ all -> 0x0052 }
        r8 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0052 }
        r9 = "socket 连接异常 - SocketException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x0099:
        r9 = move-exception;
    L_0x009a:
        r9.printStackTrace();	 Catch:{ all -> 0x0052 }
        r8 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0052 }
        r9 = "未知主机 - UnKnowHostException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x00a5:
        r9 = move-exception;
    L_0x00a6:
        r9.printStackTrace();	 Catch:{ all -> 0x0052 }
        r8 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0052 }
        r9 = "url异常 - MalformedURLException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x00b1:
        r9 = move-exception;
    L_0x00b2:
        r9.printStackTrace();	 Catch:{ all -> 0x0052 }
        r8 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x0052 }
        r9 = "http连接失败 - ConnectionException";
        r8.<init>(r9);	 Catch:{ all -> 0x0052 }
        throw r8;	 Catch:{ all -> 0x0052 }
    L_0x00bd:
        if (r6 == 0) goto L_0x00cb;
    L_0x00bf:
        r6.disconnect();	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x00cb;
    L_0x00c3:
        r8 = move-exception;
        r10 = "ht";
        r11 = "mPt";
        com.loc.O0000Oo.O000000o(r8, r10, r11);
    L_0x00cb:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00OOo0.O000000o(java.lang.String, boolean, java.lang.String, java.util.Map, byte[]):com.loc.O00Oo00");
    }

    /* Access modifiers changed, original: final */
    public final void O000000o() {
        this.O0000OOo = 0;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0123 A:{SYNTHETIC, Splitter:B:84:0x0123} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0131 A:{SYNTHETIC, Splitter:B:89:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0123 A:{SYNTHETIC, Splitter:B:84:0x0123} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0131 A:{SYNTHETIC, Splitter:B:89:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010e A:{SYNTHETIC, Splitter:B:74:0x010e} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011c A:{SYNTHETIC, Splitter:B:79:0x011c} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0109 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:66|65|71|72|(2:74|75)|(2:79|80)|81) */
    /* JADX WARNING: Missing block: B:82:0x0120, code skipped:
            r9 = th;
     */
    public final void O000000o(java.lang.String r9, boolean r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.util.Map<java.lang.String, java.lang.String> r13, byte[] r14, com.loc.O00OOOo.O000000o r15) {
        /*
        r8 = this;
        if (r15 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = 0;
        r13 = O000000o(r13);	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
        r1 = new java.lang.StringBuffer;	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
        r1.<init>();	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
        r1.append(r9);	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
        if (r13 == 0) goto L_0x001a;
    L_0x0012:
        r9 = "?";
        r1.append(r9);	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
        r1.append(r13);	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
    L_0x001a:
        r9 = 1;
        r13 = 0;
        if (r14 == 0) goto L_0x0023;
    L_0x001e:
        r2 = r14.length;	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
        if (r2 <= 0) goto L_0x0023;
    L_0x0021:
        r7 = r9;
        goto L_0x0024;
    L_0x0023:
        r7 = r13;
    L_0x0024:
        r2 = r1.toString();	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
        r1 = r8;
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r6 = r7;
        r10 = r1.O000000o(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0108, all -> 0x0105 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0109 }
        r12 = "bytes=";
        r11.<init>(r12);	 Catch:{ Throwable -> 0x0109 }
        r1 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0109 }
        r11.append(r1);	 Catch:{ Throwable -> 0x0109 }
        r12 = "-";
        r11.append(r12);	 Catch:{ Throwable -> 0x0109 }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x0109 }
        r12 = "RANGE";
        r10.setRequestProperty(r12, r11);	 Catch:{ Throwable -> 0x0109 }
        if (r7 == 0) goto L_0x005c;
    L_0x004d:
        r11 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x0109 }
        r12 = r10.getOutputStream();	 Catch:{ Throwable -> 0x0109 }
        r11.<init>(r12);	 Catch:{ Throwable -> 0x0109 }
        r11.write(r14);	 Catch:{ Throwable -> 0x0109 }
        r11.close();	 Catch:{ Throwable -> 0x0109 }
    L_0x005c:
        r10.connect();	 Catch:{ Throwable -> 0x0109 }
        r11 = r10.getResponseCode();	 Catch:{ Throwable -> 0x0109 }
        r12 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r11 == r12) goto L_0x0069;
    L_0x0067:
        r12 = r9;
        goto L_0x006a;
    L_0x0069:
        r12 = r13;
    L_0x006a:
        r14 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r11 == r14) goto L_0x006f;
    L_0x006e:
        goto L_0x0070;
    L_0x006f:
        r9 = r13;
    L_0x0070:
        r9 = r9 & r12;
        if (r9 == 0) goto L_0x0095;
    L_0x0073:
        r9 = new com.loc.OO00Oo0;	 Catch:{ Throwable -> 0x0109 }
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0109 }
        r14 = "网络异常原因：";
        r12.<init>(r14);	 Catch:{ Throwable -> 0x0109 }
        r14 = r10.getResponseMessage();	 Catch:{ Throwable -> 0x0109 }
        r12.append(r14);	 Catch:{ Throwable -> 0x0109 }
        r14 = " 网络异常状态码：";
        r12.append(r14);	 Catch:{ Throwable -> 0x0109 }
        r12.append(r11);	 Catch:{ Throwable -> 0x0109 }
        r11 = r12.toString();	 Catch:{ Throwable -> 0x0109 }
        r9.<init>(r11);	 Catch:{ Throwable -> 0x0109 }
        r15.O00000o0();	 Catch:{ Throwable -> 0x0109 }
    L_0x0095:
        r9 = r10.getInputStream();	 Catch:{ Throwable -> 0x0109 }
        r11 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r12 = new byte[r11];	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
    L_0x009d:
        r14 = java.lang.Thread.interrupted();	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        if (r14 != 0) goto L_0x00d7;
    L_0x00a3:
        r14 = r8.O00000oo;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        if (r14 != 0) goto L_0x00d7;
    L_0x00a7:
        r14 = r9.read(r12, r13, r11);	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        if (r14 <= 0) goto L_0x00d7;
    L_0x00ad:
        r0 = r8.O0000O0o;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        r2 = -1;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x00bd;
    L_0x00b5:
        r0 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        r2 = r8.O0000O0o;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 >= 0) goto L_0x00d7;
    L_0x00bd:
        if (r14 != r11) goto L_0x00c5;
    L_0x00bf:
        r0 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        r15.O000000o(r12, r0);	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        goto L_0x00cf;
    L_0x00c5:
        r0 = new byte[r14];	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        java.lang.System.arraycopy(r12, r13, r0, r13, r14);	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        r1 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        r15.O000000o(r0, r1);	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
    L_0x00cf:
        r0 = r8.O0000OOo;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        r2 = (long) r14;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        r4 = r0 + r2;
        r8.O0000OOo = r4;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        goto L_0x009d;
    L_0x00d7:
        r11 = r8.O00000oo;	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        if (r11 == 0) goto L_0x00df;
    L_0x00db:
        r15.O00000oO();	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
        goto L_0x00e2;
    L_0x00df:
        r15.O00000o();	 Catch:{ Throwable -> 0x0103, all -> 0x00ff }
    L_0x00e2:
        if (r9 == 0) goto L_0x00f0;
    L_0x00e4:
        r9.close();	 Catch:{ IOException | Throwable -> 0x00e8, IOException | Throwable -> 0x00e8 }
        goto L_0x00f0;
    L_0x00e8:
        r9 = move-exception;
        r11 = "ht";
        r12 = "mdr";
        com.loc.O0000Oo.O000000o(r9, r11, r12);
    L_0x00f0:
        if (r10 == 0) goto L_0x011f;
    L_0x00f2:
        r10.disconnect();	 Catch:{ Throwable -> 0x00f6 }
        return;
    L_0x00f6:
        r9 = move-exception;
        r10 = "ht";
        r11 = "mdr";
        com.loc.O0000Oo.O000000o(r9, r10, r11);
        return;
    L_0x00ff:
        r11 = move-exception;
        r0 = r9;
        r9 = r11;
        goto L_0x0121;
    L_0x0103:
        r0 = r9;
        goto L_0x0109;
    L_0x0105:
        r9 = move-exception;
        r10 = r0;
        goto L_0x0121;
    L_0x0108:
        r10 = r0;
    L_0x0109:
        r15.O00000o0();	 Catch:{ all -> 0x0120 }
        if (r0 == 0) goto L_0x011a;
    L_0x010e:
        r0.close();	 Catch:{ IOException | Throwable -> 0x0112, IOException | Throwable -> 0x0112 }
        goto L_0x011a;
    L_0x0112:
        r9 = move-exception;
        r11 = "ht";
        r12 = "mdr";
        com.loc.O0000Oo.O000000o(r9, r11, r12);
    L_0x011a:
        if (r10 == 0) goto L_0x011f;
    L_0x011c:
        r10.disconnect();	 Catch:{ Throwable -> 0x00f6 }
    L_0x011f:
        return;
    L_0x0120:
        r9 = move-exception;
    L_0x0121:
        if (r0 == 0) goto L_0x012f;
    L_0x0123:
        r0.close();	 Catch:{ IOException | Throwable -> 0x0127, IOException | Throwable -> 0x0127 }
        goto L_0x012f;
    L_0x0127:
        r11 = move-exception;
        r12 = "ht";
        r13 = "mdr";
        com.loc.O0000Oo.O000000o(r11, r12, r13);
    L_0x012f:
        if (r10 == 0) goto L_0x013d;
    L_0x0131:
        r10.disconnect();	 Catch:{ Throwable -> 0x0135 }
        goto L_0x013d;
    L_0x0135:
        r10 = move-exception;
        r11 = "ht";
        r12 = "mdr";
        com.loc.O0000Oo.O000000o(r10, r11, r12);
    L_0x013d:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00OOo0.O000000o(java.lang.String, boolean, java.lang.String, java.util.Map, java.util.Map, byte[], com.loc.O00OOOo$O000000o):void");
    }

    /* Access modifiers changed, original: final */
    public final void O00000Oo() {
        this.O0000O0o = -1;
    }
}
