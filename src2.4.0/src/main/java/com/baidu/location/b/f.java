package com.baidu.location.b;

import android.os.Environment;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.baidu.location.e.i;
import com.baidu.location.g.a;
import com.baidu.location.g.j;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.HttpURLConnection;
import java.net.URL;

public class f implements UncaughtExceptionHandler {
    private static f a;
    private int b = 0;

    private f() {
    }

    public static f a() {
        if (a == null) {
            a = new f();
        }
        return a;
    }

    private String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    private void a(File file, String str, String str2) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(280);
            randomAccessFile.writeInt(12346);
            randomAccessFile.seek(300);
            randomAccessFile.writeLong(System.currentTimeMillis());
            byte[] bytes = str.getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.seek(600);
            bytes = str2.getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            if (!a(str, str2)) {
                randomAccessFile.seek(280);
                randomAccessFile.writeInt(1326);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !i.j()) {
            return false;
        }
        try {
            URL url = new URL(j.e);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("e0");
            stringBuffer.append(HttpUtils.EQUAL_SIGN);
            stringBuffer.append(str);
            stringBuffer.append(HttpUtils.PARAMETERS_SEPARATOR);
            stringBuffer.append("e1");
            stringBuffer.append(HttpUtils.EQUAL_SIGN);
            stringBuffer.append(str2);
            stringBuffer.append(HttpUtils.PARAMETERS_SEPARATOR);
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(a.b);
            httpURLConnection.setReadTimeout(a.b);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            httpURLConnection.setRequestProperty("Accept-Charset", HttpUtils.ENCODING_UTF_8);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
            outputStream.close();
            return httpURLConnection.getResponseCode() == 200;
        } catch (Exception unused) {
        }
    }

    public void b() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append("/traces");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append("/error_fs2.dat");
            File file = new File(stringBuilder3.toString());
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(280);
                if (1326 == randomAccessFile.readInt()) {
                    String str;
                    randomAccessFile.seek(308);
                    int readInt = randomAccessFile.readInt();
                    String str2 = null;
                    if (readInt <= 0 || readInt >= 2048) {
                        str = null;
                    } else {
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        str = new String(bArr, 0, readInt);
                    }
                    randomAccessFile.seek(600);
                    readInt = randomAccessFile.readInt();
                    if (readInt > 0 && readInt < 2048) {
                        byte[] bArr2 = new byte[readInt];
                        randomAccessFile.read(bArr2, 0, readInt);
                        str2 = new String(bArr2, 0, readInt);
                    }
                    if (a(str, str2)) {
                        randomAccessFile.seek(280);
                        randomAccessFile.writeInt(12346);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ac A:{Catch:{ Exception -> 0x00b5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8 A:{SYNTHETIC, Splitter:B:34:0x00b8} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8 A:{SYNTHETIC, Splitter:B:34:0x00b8} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8 A:{SYNTHETIC, Splitter:B:34:0x00b8} */
    public void uncaughtException(java.lang.Thread r9, java.lang.Throwable r10) {
        /*
        r8 = this;
        r9 = r8.b;
        r0 = 1;
        r9 = r9 + r0;
        r8.b = r9;
        r9 = r8.b;
        r1 = 2;
        if (r9 <= r1) goto L_0x0013;
    L_0x000b:
        r9 = android.os.Process.myPid();
        android.os.Process.killProcess(r9);
        return;
    L_0x0013:
        r1 = java.lang.System.currentTimeMillis();
        r3 = com.baidu.location.f.a.a();
        r5 = r1 - r3;
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r9 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r9 >= 0) goto L_0x0079;
    L_0x0023:
        r9 = 1089722122; // 0x40f3d70a float:7.62 double:5.38394264E-315;
        r1 = com.baidu.location.f.getFrameVersion();
        r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r9 <= 0) goto L_0x0079;
    L_0x002e:
        r9 = com.baidu.location.g.c.a();
        r1 = r9.c();
        r3 = java.lang.System.currentTimeMillis();
        r5 = r3 - r1;
        r1 = 40000; // 0x9c40 float:5.6052E-41 double:1.97626E-319;
        r9 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r9 >= 0) goto L_0x006e;
    L_0x0043:
        r9 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.baidu.location.g.j.i();
        r1.append(r2);
        r2 = java.io.File.separator;
        r1.append(r2);
        r2 = com.baidu.location.f.getJarFileName();
        r1.append(r2);
        r1 = r1.toString();
        r9.<init>(r1);
        r1 = r9.exists();
        if (r1 == 0) goto L_0x0079;
    L_0x006a:
        r9.delete();
        goto L_0x0079;
    L_0x006e:
        r9 = com.baidu.location.g.c.a();
        r1 = java.lang.System.currentTimeMillis();
        r9.b(r1);
    L_0x0079:
        r9 = 0;
        r1 = 0;
        r10 = r8.a(r10);	 Catch:{ Exception -> 0x00b4 }
        if (r10 == 0) goto L_0x008a;
    L_0x0081:
        r2 = "com.baidu.location";
        r2 = r10.contains(r2);	 Catch:{ Exception -> 0x00b5 }
        if (r2 == 0) goto L_0x008a;
    L_0x0089:
        goto L_0x008b;
    L_0x008a:
        r0 = r9;
    L_0x008b:
        r2 = com.baidu.location.g.b.a();	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.a(r9);	 Catch:{ Exception -> 0x00b5 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b5 }
        r3.<init>();	 Catch:{ Exception -> 0x00b5 }
        r3.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = com.baidu.location.a.a.a();	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.d();	 Catch:{ Exception -> 0x00b5 }
        r3.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = r3.toString();	 Catch:{ Exception -> 0x00b5 }
        if (r2 == 0) goto L_0x00b1;
    L_0x00ac:
        r2 = com.baidu.location.Jni.encode(r2);	 Catch:{ Exception -> 0x00b5 }
        goto L_0x00b2;
    L_0x00b1:
        r2 = r1;
    L_0x00b2:
        r9 = r0;
        goto L_0x00b6;
    L_0x00b4:
        r10 = r1;
    L_0x00b5:
        r2 = r1;
    L_0x00b6:
        if (r9 == 0) goto L_0x000b;
    L_0x00b8:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x000b }
        r9.<init>();	 Catch:{ Exception -> 0x000b }
        r0 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x000b }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x000b }
        r9.append(r0);	 Catch:{ Exception -> 0x000b }
        r0 = "/traces";
        r9.append(r0);	 Catch:{ Exception -> 0x000b }
        r9 = r9.toString();	 Catch:{ Exception -> 0x000b }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x000b }
        r0.<init>();	 Catch:{ Exception -> 0x000b }
        r0.append(r9);	 Catch:{ Exception -> 0x000b }
        r3 = "/error_fs2.dat";
        r0.append(r3);	 Catch:{ Exception -> 0x000b }
        r0 = r0.toString();	 Catch:{ Exception -> 0x000b }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x000b }
        r3.<init>(r0);	 Catch:{ Exception -> 0x000b }
        r0 = r3.exists();	 Catch:{ Exception -> 0x000b }
        if (r0 != 0) goto L_0x0108;
    L_0x00ed:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x000b }
        r0.<init>(r9);	 Catch:{ Exception -> 0x000b }
        r9 = r0.exists();	 Catch:{ Exception -> 0x000b }
        if (r9 != 0) goto L_0x00fb;
    L_0x00f8:
        r0.mkdirs();	 Catch:{ Exception -> 0x000b }
    L_0x00fb:
        r9 = r3.createNewFile();	 Catch:{ Exception -> 0x000b }
        if (r9 != 0) goto L_0x0102;
    L_0x0101:
        goto L_0x0103;
    L_0x0102:
        r1 = r3;
    L_0x0103:
        r8.a(r1, r2, r10);	 Catch:{ Exception -> 0x000b }
        goto L_0x000b;
    L_0x0108:
        r9 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x000b }
        r0 = "rw";
        r9.<init>(r3, r0);	 Catch:{ Exception -> 0x000b }
        r0 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r9.seek(r0);	 Catch:{ Exception -> 0x000b }
        r0 = r9.readLong();	 Catch:{ Exception -> 0x000b }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x000b }
        r6 = r4 - r0;
        r0 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r4 <= 0) goto L_0x0128;
    L_0x0125:
        r8.a(r3, r2, r10);	 Catch:{ Exception -> 0x000b }
    L_0x0128:
        r9.close();	 Catch:{ Exception -> 0x000b }
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.f.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
