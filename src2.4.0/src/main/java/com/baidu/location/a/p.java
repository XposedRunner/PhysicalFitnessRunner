package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import cn.jiguang.net.HttpUtils;
import com.baidu.location.Jni;
import com.baidu.location.e.b;
import com.baidu.location.e.d;
import com.baidu.location.f;
import com.baidu.location.g.c;
import com.baidu.location.g.e;
import com.baidu.location.g.i;
import com.baidu.location.g.j;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class p extends e {
    private static p q;
    String a;
    String b;
    String c;
    String d;
    int e;
    Handler f;

    private p() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 1;
        this.f = null;
        this.f = new Handler();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    public static void a(java.io.File r4, java.io.File r5) throws java.io.IOException {
        /*
        r0 = 0;
        r1 = new java.io.BufferedInputStream;	 Catch:{ all -> 0x003b }
        r2 = new java.io.FileInputStream;	 Catch:{ all -> 0x003b }
        r2.<init>(r4);	 Catch:{ all -> 0x003b }
        r1.<init>(r2);	 Catch:{ all -> 0x003b }
        r2 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0039 }
        r3 = new java.io.FileOutputStream;	 Catch:{ all -> 0x0039 }
        r3.<init>(r5);	 Catch:{ all -> 0x0039 }
        r2.<init>(r3);	 Catch:{ all -> 0x0039 }
        r5 = 5120; // 0x1400 float:7.175E-42 double:2.5296E-320;
        r5 = new byte[r5];	 Catch:{ all -> 0x0036 }
    L_0x0019:
        r0 = r1.read(r5);	 Catch:{ all -> 0x0036 }
        r3 = -1;
        if (r0 == r3) goto L_0x0025;
    L_0x0020:
        r3 = 0;
        r2.write(r5, r3, r0);	 Catch:{ all -> 0x0036 }
        goto L_0x0019;
    L_0x0025:
        r2.flush();	 Catch:{ all -> 0x0036 }
        r4.delete();	 Catch:{ all -> 0x0036 }
        if (r1 == 0) goto L_0x0030;
    L_0x002d:
        r1.close();
    L_0x0030:
        if (r2 == 0) goto L_0x0035;
    L_0x0032:
        r2.close();
    L_0x0035:
        return;
    L_0x0036:
        r4 = move-exception;
        r0 = r2;
        goto L_0x003d;
    L_0x0039:
        r4 = move-exception;
        goto L_0x003d;
    L_0x003b:
        r4 = move-exception;
        r1 = r0;
    L_0x003d:
        if (r1 == 0) goto L_0x0042;
    L_0x003f:
        r1.close();
    L_0x0042:
        if (r0 == 0) goto L_0x0047;
    L_0x0044:
        r0.close();
    L_0x0047:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.p.a(java.io.File, java.io.File):void");
    }

    private boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                String a = d.a(b.a().e());
                if (a.equals("3G") || a.equals("4G")) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.i());
        stringBuilder.append(File.separator);
        stringBuilder.append("tmp");
        File file = new File(stringBuilder.toString());
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            httpURLConnection.disconnect();
            fileOutputStream.close();
            bufferedInputStream.close();
            if (file.length() < 10240) {
                file.delete();
                return false;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(j.i());
            stringBuilder2.append(File.separator);
            stringBuilder2.append(str2);
            file.renameTo(new File(stringBuilder2.toString()));
            return true;
        } catch (Exception unused) {
            file.delete();
            return false;
        }
    }

    public static p b() {
        if (q == null) {
            q = new p();
        }
        return q;
    }

    private Handler f() {
        return this.f;
    }

    private void g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.i());
        stringBuilder.append("/grtcfrsa.dat");
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                File file2 = new File(i.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.seek(8);
                    byte[] bytes = "1980_01_01:0".getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes);
                    randomAccessFile.seek(200);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.seek(800);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(200);
            randomAccessFile.writeBoolean(true);
            if (this.e == 1) {
                randomAccessFile.writeBoolean(true);
            } else {
                randomAccessFile.writeBoolean(false);
            }
            if (this.d != null) {
                byte[] bytes2 = this.d.getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2);
            } else if (Math.abs(f.getFrameVersion() - 7.62f) < 1.0E-8f) {
                randomAccessFile.writeInt(0);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    private void h() {
        if (this.a != null) {
            new t(this).start();
        }
    }

    private boolean i() {
        if (this.c == null) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.i());
        stringBuilder.append(File.separator);
        stringBuilder.append(this.c);
        if (new File(stringBuilder.toString()).exists()) {
            return true;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("http://");
        stringBuilder2.append(this.a);
        stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder2.append(this.c);
        return a(stringBuilder2.toString(), this.c);
    }

    private void j() {
        if (this.b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j.i());
            stringBuilder.append(File.separator);
            stringBuilder.append(this.b);
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(this.a);
                stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                stringBuilder.append(this.b);
                if (a(stringBuilder.toString(), this.b)) {
                    String a = j.a(file, "SHA-256");
                    if (!(this.d == null || a == null || !j.b(a, this.d, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB"))) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(j.i());
                        stringBuilder2.append(File.separator);
                        stringBuilder2.append(f.replaceFileName);
                        File file2 = new File(stringBuilder2.toString());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        try {
                            a(file, file2);
                        } catch (Exception unused) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void a() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.62f);
        stringBuffer.append("&fw=");
        stringBuffer.append(f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(2);
        if (com.baidu.location.g.b.a().b == null) {
            stringBuffer.append("&im=");
            str = com.baidu.location.g.b.a().a;
        } else {
            stringBuffer.append("&cu=");
            str = com.baidu.location.g.b.a().b;
        }
        stringBuffer.append(str);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        str = VERSION.RELEASE;
        int i = 0;
        if (str != null && str.length() > 10) {
            str = str.substring(0, 10);
        }
        stringBuffer.append(str);
        str = null;
        try {
            if (VERSION.SDK_INT > 20) {
                String[] strArr = Build.SUPPORTED_ABIS;
                String str2 = null;
                while (i < strArr.length) {
                    if (i == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(strArr[i]);
                        stringBuilder.append(";");
                        str2 = stringBuilder.toString();
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str2);
                        stringBuilder2.append(strArr[i]);
                        stringBuilder2.append(";");
                        str2 = stringBuilder2.toString();
                    }
                    i++;
                }
                str = str2;
            } else {
                str = Build.CPU_ABI2;
            }
        } catch (Error | Exception unused) {
        }
        if (str != null) {
            stringBuffer.append("&cpuabi=");
            stringBuffer.append(str);
        }
        stringBuffer.append("&pack=");
        stringBuffer.append(com.baidu.location.g.b.d);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(j.e());
        stringBuilder3.append("?&it=");
        stringBuilder3.append(Jni.en1(stringBuffer.toString()));
        this.h = stringBuilder3.toString();
    }

    public void a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                if ("up".equals(jSONObject.getString("res"))) {
                    this.a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.c = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_rsa")) {
                        this.d = jSONObject.getString("u1_rsa");
                    }
                    f().post(new s(this));
                }
                if (jSONObject.has("ison")) {
                    this.e = jSONObject.getInt("ison");
                }
                g();
            } catch (Exception unused) {
            }
        }
        c.a().a(System.currentTimeMillis());
    }

    public void c() {
        if (System.currentTimeMillis() - c.a().b() > LogBuilder.MAX_INTERVAL) {
            f().postDelayed(new q(this), 10000);
            f().postDelayed(new r(this), 5000);
        }
    }
}
