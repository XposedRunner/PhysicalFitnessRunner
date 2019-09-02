package com.baidu.mapsdkplatform.comapi.b.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.mapsdkplatform.comjni.util.JNIHandler;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.zip.GZIPOutputStream;

public class a {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private Context d;

    private static final class a {
        private static final a a = new a();
    }

    public static a a() {
        return a.a;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                try {
                    outputStream.close();
                    inputStream.close();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    private void a(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length - 10; i++) {
            int i2 = 10 + i;
            if (fileArr[i2] != null && fileArr[i2].exists()) {
                fileArr[i2].delete();
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x0121 */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0127 A:{SYNTHETIC, Splitter:B:91:0x0127} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0139 A:{SYNTHETIC, Splitter:B:101:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010f A:{SYNTHETIC, Splitter:B:73:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011e A:{SYNTHETIC, Splitter:B:82:0x011e} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0127 A:{SYNTHETIC, Splitter:B:91:0x0127} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0139 A:{SYNTHETIC, Splitter:B:101:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010f A:{SYNTHETIC, Splitter:B:73:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011e A:{SYNTHETIC, Splitter:B:82:0x011e} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0127 A:{SYNTHETIC, Splitter:B:91:0x0127} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0139 A:{SYNTHETIC, Splitter:B:101:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010f A:{SYNTHETIC, Splitter:B:73:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011e A:{SYNTHETIC, Splitter:B:82:0x011e} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0127 A:{SYNTHETIC, Splitter:B:91:0x0127} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0139 A:{SYNTHETIC, Splitter:B:101:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010f A:{SYNTHETIC, Splitter:B:73:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011e A:{SYNTHETIC, Splitter:B:82:0x011e} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0 A:{Splitter:B:23:0x00ac, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:39:0x00e0, code skipped:
            r10 = th;
     */
    /* JADX WARNING: Missing block: B:40:0x00e1, code skipped:
            r1 = r5;
     */
    /* JADX WARNING: Missing block: B:41:0x00e3, code skipped:
            r1 = r5;
     */
    private synchronized boolean a(java.io.File r10) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = 0;
        r1 = 0;
        r2 = r9.g();	 Catch:{ Exception -> 0x0122, all -> 0x0109 }
        if (r2 != 0) goto L_0x0010;
    L_0x0009:
        if (r2 == 0) goto L_0x000e;
    L_0x000b:
        r2.disconnect();	 Catch:{ Exception -> 0x000e }
    L_0x000e:
        monitor-exit(r9);
        return r0;
    L_0x0010:
        r2.connect();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r3 = r2.getOutputStream();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r4 = r9.b(r10);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = r9.a(r4);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r3.write(r4);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4.<init>();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = "--bd_map_sdk_cc";
        r4.append(r5);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = "\r\n";
        r4.append(r5);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = "Content-Disposition: form-data; name=\"file\"; filename=\"c.txt\"\r\n";
        r4.append(r5);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = "\r\n";
        r4.append(r5);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = r9.a(r4);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r3.write(r4);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = r10.length();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = (int) r5;	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r6.<init>(r10);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6 = new byte[r6];	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
    L_0x006a:
        r7 = r5.read(r6);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r8 = -1;
        if (r7 == r8) goto L_0x0075;
    L_0x0071:
        r4.write(r6, r0, r7);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        goto L_0x006a;
    L_0x0075:
        r6 = r4.toByteArray();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r6 = r9.a(r6);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r3.write(r6);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5.close();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4.close();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = "\r\n--bd_map_sdk_cc--\r\n";
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = r9.a(r4);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r3.write(r4);	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r3.flush();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r4 = r2.getResponseCode();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 != r5) goto L_0x00e7;
    L_0x009e:
        r4 = r2.getInputStream();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
        r5 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0125, all -> 0x00e5 }
        r6 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0125, all -> 0x00e5 }
        r6.<init>(r4);	 Catch:{ Exception -> 0x0125, all -> 0x00e5 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0125, all -> 0x00e5 }
        r1 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x00e3, all -> 0x00e0 }
        r1.<init>();	 Catch:{ Exception -> 0x00e3, all -> 0x00e0 }
    L_0x00b1:
        r6 = r5.read();	 Catch:{ Exception -> 0x00e3, all -> 0x00e0 }
        if (r6 == r8) goto L_0x00bc;
    L_0x00b7:
        r6 = (char) r6;	 Catch:{ Exception -> 0x00e3, all -> 0x00e0 }
        r1.append(r6);	 Catch:{ Exception -> 0x00e3, all -> 0x00e0 }
        goto L_0x00b1;
    L_0x00bc:
        r1 = r1.toString();	 Catch:{ Exception -> 0x00e3, all -> 0x00e0 }
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00de, all -> 0x00e0 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00de, all -> 0x00e0 }
        r1 = "status";
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x00de, all -> 0x00e0 }
        if (r1 == 0) goto L_0x00de;
    L_0x00cd:
        r1 = "status";
        r0 = r0.getInt(r1);	 Catch:{ Exception -> 0x00de, all -> 0x00e0 }
        if (r0 != 0) goto L_0x00de;
    L_0x00d5:
        r0 = r10.exists();	 Catch:{ Exception -> 0x00de, all -> 0x00e0 }
        if (r0 == 0) goto L_0x00de;
    L_0x00db:
        r10.delete();	 Catch:{ Exception -> 0x00de, all -> 0x00e0 }
    L_0x00de:
        r1 = r5;
        goto L_0x00e8;
    L_0x00e0:
        r10 = move-exception;
        r1 = r5;
        goto L_0x010d;
    L_0x00e3:
        r1 = r5;
        goto L_0x0125;
    L_0x00e5:
        r10 = move-exception;
        goto L_0x010d;
    L_0x00e7:
        r4 = r1;
    L_0x00e8:
        if (r3 == 0) goto L_0x00ed;
    L_0x00ea:
        r3.close();	 Catch:{ Exception -> 0x00ed }
    L_0x00ed:
        if (r4 == 0) goto L_0x00f7;
    L_0x00ef:
        if (r1 == 0) goto L_0x00f7;
    L_0x00f1:
        r4.close();	 Catch:{ Exception -> 0x00f7 }
        r1.close();	 Catch:{ Exception -> 0x00f7 }
    L_0x00f7:
        if (r2 == 0) goto L_0x00fc;
    L_0x00f9:
        r2.disconnect();	 Catch:{ Exception -> 0x00fc }
    L_0x00fc:
        r10 = 1;
        monitor-exit(r9);
        return r10;
    L_0x00ff:
        r10 = move-exception;
        r4 = r1;
        goto L_0x010d;
    L_0x0102:
        r4 = r1;
        goto L_0x0125;
    L_0x0104:
        r10 = move-exception;
        r3 = r1;
        goto L_0x010c;
    L_0x0107:
        r3 = r1;
        goto L_0x0124;
    L_0x0109:
        r10 = move-exception;
        r2 = r1;
        r3 = r2;
    L_0x010c:
        r4 = r3;
    L_0x010d:
        if (r3 == 0) goto L_0x0112;
    L_0x010f:
        r3.close();	 Catch:{ Exception -> 0x0112 }
    L_0x0112:
        if (r4 == 0) goto L_0x011c;
    L_0x0114:
        if (r1 == 0) goto L_0x011c;
    L_0x0116:
        r4.close();	 Catch:{ Exception -> 0x011c }
        r1.close();	 Catch:{ Exception -> 0x011c }
    L_0x011c:
        if (r2 == 0) goto L_0x0121;
    L_0x011e:
        r2.disconnect();	 Catch:{ Exception -> 0x0121 }
    L_0x0121:
        throw r10;	 Catch:{ all -> 0x012b }
    L_0x0122:
        r2 = r1;
        r3 = r2;
    L_0x0124:
        r4 = r3;
    L_0x0125:
        if (r3 == 0) goto L_0x012d;
    L_0x0127:
        r3.close();	 Catch:{ Exception -> 0x012d }
        goto L_0x012d;
    L_0x012b:
        r10 = move-exception;
        goto L_0x013d;
    L_0x012d:
        if (r4 == 0) goto L_0x0137;
    L_0x012f:
        if (r1 == 0) goto L_0x0137;
    L_0x0131:
        r4.close();	 Catch:{ Exception -> 0x0137 }
        r1.close();	 Catch:{ Exception -> 0x0137 }
    L_0x0137:
        if (r2 == 0) goto L_0x013f;
    L_0x0139:
        r2.disconnect();	 Catch:{ Exception -> 0x013f }
        goto L_0x013f;
    L_0x013d:
        monitor-exit(r9);
        throw r10;
    L_0x013f:
        monitor-exit(r9);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.b.a.a.a(java.io.File):boolean");
    }

    private byte[] a(byte[] bArr) throws Exception {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        a(byteArrayInputStream, byteArrayOutputStream);
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return bArr;
    }

    private StringBuilder b(File file) {
        String[] split = file.getName().substring(0, file.getName().length() - 4).split("_");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--bd_map_sdk_cc");
        stringBuilder.append("\r\n");
        stringBuilder.append("Content-Disposition: form-data; name=\"phoneinfo\"\r\n");
        stringBuilder.append("\r\n");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(SyncSysInfo.getPhoneInfo());
        stringBuilder2.append("&abi=");
        stringBuilder2.append(c);
        stringBuilder.append(URLDecoder.decode(stringBuilder2.toString()));
        stringBuilder.append("\r\n");
        stringBuilder.append("--bd_map_sdk_cc");
        stringBuilder.append("\r\n");
        if (!(split[0] == null || split[0].isEmpty())) {
            stringBuilder.append("Content-Disposition: form-data; name=\"packname\"\r\n");
            stringBuilder.append("\r\n");
            stringBuilder.append(split[0]);
            stringBuilder.append("\r\n");
            stringBuilder.append("--bd_map_sdk_cc");
            stringBuilder.append("\r\n");
        }
        if (!(split[1] == null || split[1].isEmpty())) {
            stringBuilder.append("Content-Disposition: form-data; name=\"version\"\r\n");
            stringBuilder.append("\r\n");
            stringBuilder.append(split[1]);
            stringBuilder.append("\r\n");
            stringBuilder.append("--bd_map_sdk_cc");
            stringBuilder.append("\r\n");
        }
        if (!(split[2] == null || split[2].isEmpty())) {
            stringBuilder.append("Content-Disposition: form-data; name=\"timestamp\"\r\n");
            stringBuilder.append("\r\n");
            stringBuilder.append(split[2]);
            stringBuilder.append("\r\n");
            stringBuilder.append("--bd_map_sdk_cc");
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("Content-Disposition: form-data; name=\"os\"\r\n");
        stringBuilder.append("\r\n");
        stringBuilder.append("android");
        stringBuilder.append("\r\n");
        stringBuilder.append("--bd_map_sdk_cc");
        stringBuilder.append("\r\n");
        return stringBuilder;
    }

    private void d() {
        if (g.a().b() != null) {
            String b = g.a().b().b();
            if (!b.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(b);
                stringBuilder.append(File.separator);
                stringBuilder.append("crash");
                String stringBuilder2 = stringBuilder.toString();
                File file = new File(stringBuilder2);
                if (file.exists() || file.mkdir()) {
                    a = stringBuilder2;
                } else {
                    a = b;
                }
            }
        }
    }

    private void e() {
        if (a != null && !a.isEmpty() && b != null && !b.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(File.separator);
            stringBuilder.append(b);
            JNIHandler.registerNativeHandler(stringBuilder.toString());
        }
    }

    private void f() {
        if (NetworkUtil.isNetworkAvailable(this.d) && NetworkUtil.isWifiState(this.d)) {
            new Thread(new b(this)).start();
        }
    }

    private HttpURLConnection g() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.map.baidu.com/lbs_sdkcc/report").openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=bd_map_sdk_cc");
            httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.setConnectTimeout(10000);
            return httpURLConnection;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(Context context) {
        if (VERSION.SDK_INT >= 21) {
            if (Build.SUPPORTED_ABIS.length > 0) {
                c = Build.SUPPORTED_ABIS[0];
            }
            this.d = context;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(h.n());
            stringBuilder.append("_");
            stringBuilder.append(h.i());
            stringBuilder.append("_");
            b = stringBuilder.toString();
            d();
            e();
            f();
        }
    }
}
