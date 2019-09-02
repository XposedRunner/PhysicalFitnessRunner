package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.connect.common.Constants;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
public final class s {
    private static s b;
    public Map<String, String> a = null;
    private Context c;

    private s(Context context) {
        this.c = context;
    }

    public static s a(Context context) {
        if (b == null) {
            b = new s(context);
        }
        return b;
    }

    private static HttpURLConnection a(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(str2);
            if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            x.e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection a = a(str2, str);
        if (a == null) {
            x.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Entry entry : map.entrySet()) {
                    a.setRequestProperty((String) entry.getKey(), URLEncoder.encode((String) entry.getValue(), "utf-8"));
                }
            }
            a.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            a.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = a.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            x.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    private static Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List list = (List) headerFields.get(str);
            if (list.size() > 0) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A:{Catch:{ all -> 0x004c }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A:{SYNTHETIC, Splitter:B:26:0x0043} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004f A:{SYNTHETIC, Splitter:B:33:0x004f} */
    private static byte[] b(java.net.HttpURLConnection r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x0036, all -> 0x0033 }
        r5 = r5.getInputStream();	 Catch:{ Throwable -> 0x0036, all -> 0x0033 }
        r1.<init>(r5);	 Catch:{ Throwable -> 0x0036, all -> 0x0033 }
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0031 }
        r5.<init>();	 Catch:{ Throwable -> 0x0031 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x0031 }
    L_0x0016:
        r3 = r1.read(r2);	 Catch:{ Throwable -> 0x0031 }
        if (r3 <= 0) goto L_0x0021;
    L_0x001c:
        r4 = 0;
        r5.write(r2, r4, r3);	 Catch:{ Throwable -> 0x0031 }
        goto L_0x0016;
    L_0x0021:
        r5.flush();	 Catch:{ Throwable -> 0x0031 }
        r5 = r5.toByteArray();	 Catch:{ Throwable -> 0x0031 }
        r1.close();	 Catch:{ Throwable -> 0x002c }
        goto L_0x0030;
    L_0x002c:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0030:
        return r5;
    L_0x0031:
        r5 = move-exception;
        goto L_0x0038;
    L_0x0033:
        r5 = move-exception;
        r1 = r0;
        goto L_0x004d;
    L_0x0036:
        r5 = move-exception;
        r1 = r0;
    L_0x0038:
        r2 = com.tencent.bugly.proguard.x.a(r5);	 Catch:{ all -> 0x004c }
        if (r2 != 0) goto L_0x0041;
    L_0x003e:
        r5.printStackTrace();	 Catch:{ all -> 0x004c }
    L_0x0041:
        if (r1 == 0) goto L_0x004b;
    L_0x0043:
        r1.close();	 Catch:{ Throwable -> 0x0047 }
        goto L_0x004b;
    L_0x0047:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x004b:
        return r0;
    L_0x004c:
        r5 = move-exception;
    L_0x004d:
        if (r1 == 0) goto L_0x0057;
    L_0x004f:
        r1.close();	 Catch:{ Throwable -> 0x0053 }
        goto L_0x0057;
    L_0x0053:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0057:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.s.b(java.net.HttpURLConnection):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0186 A:{Catch:{ all -> 0x0176, Throwable -> 0x01a2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0186 A:{Catch:{ all -> 0x0176, Throwable -> 0x01a2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0186 A:{Catch:{ all -> 0x0176, Throwable -> 0x01a2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0186 A:{Catch:{ all -> 0x0176, Throwable -> 0x01a2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0186 A:{Catch:{ all -> 0x0176, Throwable -> 0x01a2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0186 A:{Catch:{ all -> 0x0176, Throwable -> 0x01a2 }} */
    public final byte[] a(java.lang.String r20, byte[] r21, com.tencent.bugly.proguard.v r22, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
        r19 = this;
        r1 = r19;
        r3 = r21;
        r4 = r22;
        r5 = 0;
        r6 = 0;
        if (r20 != 0) goto L_0x0012;
    L_0x000a:
        r2 = "Failed for no URL.";
        r3 = new java.lang.Object[r6];
        com.tencent.bugly.proguard.x.e(r2, r3);
        return r5;
    L_0x0012:
        if (r3 != 0) goto L_0x0017;
    L_0x0014:
        r9 = 0;
        goto L_0x0019;
    L_0x0017:
        r9 = r3.length;
        r9 = (long) r9;
    L_0x0019:
        r11 = "request: %s, send: %d (pid=%d | tid=%d)";
        r12 = 4;
        r12 = new java.lang.Object[r12];
        r12[r6] = r20;
        r13 = java.lang.Long.valueOf(r9);
        r14 = 1;
        r12[r14] = r13;
        r13 = android.os.Process.myPid();
        r13 = java.lang.Integer.valueOf(r13);
        r15 = 2;
        r12[r15] = r13;
        r13 = 3;
        r7 = android.os.Process.myTid();
        r7 = java.lang.Integer.valueOf(r7);
        r12[r13] = r7;
        com.tencent.bugly.proguard.x.c(r11, r12);
        r11 = r20;
        r2 = r6;
        r7 = r2;
        r8 = r7;
    L_0x0045:
        if (r2 > 0) goto L_0x01bf;
    L_0x0047:
        if (r7 > 0) goto L_0x01bf;
    L_0x0049:
        if (r8 == 0) goto L_0x004d;
    L_0x004b:
        r8 = r6;
        goto L_0x007b;
    L_0x004d:
        r2 = r2 + 1;
        if (r2 <= r14) goto L_0x007b;
    L_0x0051:
        r12 = new java.lang.StringBuilder;
        r13 = "try time: ";
        r12.<init>(r13);
        r12.append(r2);
        r12 = r12.toString();
        r13 = new java.lang.Object[r6];
        com.tencent.bugly.proguard.x.c(r12, r13);
        r12 = new java.util.Random;
        r14 = java.lang.System.currentTimeMillis();
        r12.<init>(r14);
        r13 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r12 = r12.nextInt(r13);
        r12 = (long) r12;
        r14 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r5 = r12 + r14;
        android.os.SystemClock.sleep(r5);
    L_0x007b:
        r5 = r1.c;
        r5 = com.tencent.bugly.crashreport.common.info.b.f(r5);
        if (r5 != 0) goto L_0x0090;
    L_0x0083:
        r5 = "Failed to request for network not avail";
        r6 = 0;
        r12 = new java.lang.Object[r6];
        com.tencent.bugly.proguard.x.d(r5, r12);
        r5 = 0;
        r6 = 0;
        r14 = 1;
    L_0x008e:
        r15 = 2;
        goto L_0x0045;
    L_0x0090:
        r4.a(r9);
        r6 = r23;
        r5 = r1.a(r11, r3, r5, r6);
        if (r5 == 0) goto L_0x01ad;
    L_0x009b:
        r12 = r5.getResponseCode();	 Catch:{ IOException -> 0x0179 }
        r13 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r12 != r13) goto L_0x00cc;
    L_0x00a3:
        r12 = a(r5);	 Catch:{ IOException -> 0x00c6 }
        r1.a = r12;	 Catch:{ IOException -> 0x00c6 }
        r12 = b(r5);	 Catch:{ IOException -> 0x00c6 }
        if (r12 != 0) goto L_0x00b2;
    L_0x00af:
        r13 = 0;
        goto L_0x00b4;
    L_0x00b2:
        r13 = r12.length;	 Catch:{ IOException -> 0x00c6 }
        r13 = (long) r13;	 Catch:{ IOException -> 0x00c6 }
    L_0x00b4:
        r4.b(r13);	 Catch:{ IOException -> 0x00c6 }
        r5.disconnect();	 Catch:{ Throwable -> 0x00bb }
        goto L_0x00c5;
    L_0x00bb:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.x.a(r0);
        if (r2 != 0) goto L_0x00c5;
    L_0x00c2:
        r0.printStackTrace();
    L_0x00c5:
        return r12;
    L_0x00c6:
        r0 = move-exception;
        r17 = r8;
        r14 = 1;
        goto L_0x017d;
    L_0x00cc:
        r13 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r12 == r13) goto L_0x00df;
    L_0x00d0:
        r13 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r12 == r13) goto L_0x00df;
    L_0x00d4:
        r13 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r12 == r13) goto L_0x00df;
    L_0x00d8:
        r13 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r12 != r13) goto L_0x00dd;
    L_0x00dc:
        goto L_0x00df;
    L_0x00dd:
        r13 = 0;
        goto L_0x00e0;
    L_0x00df:
        r13 = 1;
    L_0x00e0:
        if (r13 == 0) goto L_0x013f;
    L_0x00e2:
        r8 = "Location";
        r8 = r5.getHeaderField(r8);	 Catch:{ IOException -> 0x0139 }
        if (r8 != 0) goto L_0x0116;
    L_0x00ea:
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x010f }
        r13 = "Failed to redirect: %d";
        r8.<init>(r13);	 Catch:{ IOException -> 0x010f }
        r8.append(r12);	 Catch:{ IOException -> 0x010f }
        r8 = r8.toString();	 Catch:{ IOException -> 0x010f }
        r12 = 0;
        r13 = new java.lang.Object[r12];	 Catch:{ IOException -> 0x010f }
        com.tencent.bugly.proguard.x.e(r8, r13);	 Catch:{ IOException -> 0x010f }
        r5.disconnect();	 Catch:{ Throwable -> 0x0103 }
    L_0x0101:
        r2 = 0;
        goto L_0x010e;
    L_0x0103:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.x.a(r0);
        if (r2 != 0) goto L_0x0101;
    L_0x010a:
        r0.printStackTrace();
        goto L_0x0101;
    L_0x010e:
        return r2;
    L_0x010f:
        r0 = move-exception;
        r8 = r7;
        r14 = 1;
        r17 = 1;
        goto L_0x017e;
    L_0x0116:
        r7 = r7 + 1;
        r2 = "redirect code: %d ,to:%s";
        r13 = 2;
        r11 = new java.lang.Object[r13];	 Catch:{ IOException -> 0x0130 }
        r14 = java.lang.Integer.valueOf(r12);	 Catch:{ IOException -> 0x0130 }
        r15 = 0;
        r11[r15] = r14;	 Catch:{ IOException -> 0x0130 }
        r14 = 1;
        r11[r14] = r8;	 Catch:{ IOException -> 0x012e }
        com.tencent.bugly.proguard.x.c(r2, r11);	 Catch:{ IOException -> 0x012e }
        r11 = r8;
        r8 = r14;
        r2 = 0;
        goto L_0x0141;
    L_0x012e:
        r0 = move-exception;
        goto L_0x0132;
    L_0x0130:
        r0 = move-exception;
        r14 = 1;
    L_0x0132:
        r2 = r0;
        r11 = r8;
        r17 = r14;
        r8 = r7;
        r7 = 0;
        goto L_0x0180;
    L_0x0139:
        r0 = move-exception;
        r14 = 1;
        r8 = r7;
        r17 = r14;
        goto L_0x017e;
    L_0x013f:
        r13 = 2;
        r14 = 1;
    L_0x0141:
        r15 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0174 }
        r13 = "response code ";
        r15.<init>(r13);	 Catch:{ IOException -> 0x0174 }
        r15.append(r12);	 Catch:{ IOException -> 0x0174 }
        r12 = r15.toString();	 Catch:{ IOException -> 0x0174 }
        r13 = 0;
        r15 = new java.lang.Object[r13];	 Catch:{ IOException -> 0x0174 }
        com.tencent.bugly.proguard.x.d(r12, r15);	 Catch:{ IOException -> 0x0174 }
        r12 = r5.getContentLength();	 Catch:{ IOException -> 0x0174 }
        r12 = (long) r12;	 Catch:{ IOException -> 0x0174 }
        r15 = 0;
        r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1));
        if (r17 >= 0) goto L_0x0162;
    L_0x0160:
        r12 = 0;
    L_0x0162:
        r4.b(r12);	 Catch:{ IOException -> 0x0174 }
        r5.disconnect();	 Catch:{ Throwable -> 0x0169 }
        goto L_0x019b;
    L_0x0169:
        r0 = move-exception;
        r5 = com.tencent.bugly.proguard.x.a(r0);
        if (r5 != 0) goto L_0x019b;
    L_0x0170:
        r0.printStackTrace();
        goto L_0x019b;
    L_0x0174:
        r0 = move-exception;
        goto L_0x017b;
    L_0x0176:
        r0 = move-exception;
        r2 = r0;
        goto L_0x019e;
    L_0x0179:
        r0 = move-exception;
        r14 = 1;
    L_0x017b:
        r17 = r8;
    L_0x017d:
        r8 = r7;
    L_0x017e:
        r7 = r2;
        r2 = r0;
    L_0x0180:
        r12 = com.tencent.bugly.proguard.x.a(r2);	 Catch:{ all -> 0x0176 }
        if (r12 != 0) goto L_0x0189;
    L_0x0186:
        r2.printStackTrace();	 Catch:{ all -> 0x0176 }
    L_0x0189:
        r5.disconnect();	 Catch:{ Throwable -> 0x018d }
        goto L_0x0197;
    L_0x018d:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.x.a(r0);
        if (r2 != 0) goto L_0x0197;
    L_0x0194:
        r0.printStackTrace();
    L_0x0197:
        r2 = r7;
        r7 = r8;
        r8 = r17;
    L_0x019b:
        r12 = 0;
        goto L_0x01bb;
    L_0x019e:
        r5.disconnect();	 Catch:{ Throwable -> 0x01a2 }
        goto L_0x01ac;
    L_0x01a2:
        r0 = move-exception;
        r3 = com.tencent.bugly.proguard.x.a(r0);
        if (r3 != 0) goto L_0x01ac;
    L_0x01a9:
        r0.printStackTrace();
    L_0x01ac:
        throw r2;
    L_0x01ad:
        r14 = 1;
        r5 = "Failed to execute post.";
        r12 = 0;
        r13 = new java.lang.Object[r12];
        com.tencent.bugly.proguard.x.c(r5, r13);
        r12 = 0;
        r4.b(r12);
    L_0x01bb:
        r5 = 0;
        r6 = 0;
        goto L_0x008e;
    L_0x01bf:
        r2 = r5;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.s.a(java.lang.String, byte[], com.tencent.bugly.proguard.v, java.util.Map):byte[]");
    }
}
