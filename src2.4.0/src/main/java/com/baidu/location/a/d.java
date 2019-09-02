package com.baidu.location.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.location.Jni;
import com.baidu.location.f;
import com.baidu.location.g.b;
import com.baidu.location.g.e;
import com.baidu.location.g.i;
import com.baidu.location.g.j;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.connect.common.Constants;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    public static String f = "0";
    private static d j;
    private a A;
    private boolean B;
    private boolean C;
    private int D;
    private float E;
    private float F;
    private long G;
    private int H;
    private Handler I;
    private byte[] J;
    private byte[] K;
    private int L;
    private List<Byte> M;
    private boolean N;
    long a;
    Location b;
    Location c;
    StringBuilder d;
    long e;
    int g;
    double h;
    double i;
    private int k;
    private double l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;
    private double r;
    private double s;
    private double t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private long z;

    class a extends e {
        String a;

        public a() {
            this.a = null;
            this.k = new HashMap();
        }

        public void a() {
            this.h = "http://loc.map.baidu.com/cc.php";
            String encode = Jni.encode(this.a);
            this.a = null;
            this.k.put("q", encode);
        }

        public void a(String str) {
            this.a = str;
            e();
        }

        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    jSONObject.put("prod", b.d);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    d.this.e(jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    private d() {
        this.k = 1;
        this.l = 0.699999988079071d;
        this.m = "3G|4G";
        this.n = 1;
        this.o = 307200;
        this.p = 15;
        this.q = 1;
        this.r = 3.5d;
        this.s = 3.0d;
        this.t = 0.5d;
        this.u = SecExceptionCode.SEC_ERROR_STA_ENC;
        this.v = 60;
        this.w = 0;
        this.x = 60;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0;
        this.H = 500;
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.I = null;
        this.J = new byte[4];
        this.K = null;
        this.L = 0;
        this.M = null;
        this.N = false;
        this.g = 0;
        this.h = 116.22345545d;
        this.i = 40.245667323d;
        this.I = new Handler();
    }

    public static d a() {
        if (j == null) {
            j = new d();
        }
        return j;
    }

    private String a(File file, String str) {
        String uuid = UUID.randomUUID().toString();
        String str2 = "--";
        String str3 = "\r\n";
        String str4 = "multipart/form-data";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty("connection", "close");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str4);
            stringBuilder.append(";boundary=");
            stringBuilder.append(uuid);
            httpURLConnection.setRequestProperty("Content-Type", stringBuilder.toString());
            if (file != null && file.exists()) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str2);
                stringBuffer.append(uuid);
                stringBuffer.append(str3);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"");
                stringBuilder2.append(file.getName());
                stringBuilder2.append("\"");
                stringBuilder2.append(str3);
                stringBuffer.append(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Content-Type: application/octet-stream; charset=utf-8");
                stringBuilder2.append(str3);
                stringBuffer.append(stringBuilder2.toString());
                stringBuffer.append(str3);
                dataOutputStream.write(stringBuffer.toString().getBytes());
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.write(str3.getBytes());
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str2);
                stringBuilder3.append(uuid);
                stringBuilder3.append(str2);
                stringBuilder3.append(str3);
                dataOutputStream.write(stringBuilder3.toString().getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                outputStream.close();
                httpURLConnection.disconnect();
                this.y += SecExceptionCode.SEC_ERROR_DYN_ENC;
                c(this.y);
                if (responseCode == 200) {
                    return "1";
                }
            }
        } catch (IOException | MalformedURLException unused) {
        }
        return "0";
    }

    private boolean a(String str, Context context) {
        boolean z = false;
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(str)) {
                        int i = runningAppProcessInfo.importance;
                        if (i == 200 || i == 100) {
                            z = true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }

    private byte[] a(int i) {
        return new byte[]{(byte) (255 & i), (byte) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & ViewCompat.MEASURED_STATE_MASK) >> 24)};
    }

    private byte[] a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        int i = 0;
        byte[] bArr = new byte[(bytes.length + 2)];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2 = i3;
        }
        int i4 = i2 + 1;
        bArr[i2] = nextInt;
        bArr[i4] = nextInt2;
        return bArr;
    }

    private String b(String str) {
        Calendar instance = Calendar.getInstance();
        return String.format(str, new Object[]{Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5))});
    }

    private void b(int i) {
        byte[] a = a(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.M.add(Byte.valueOf(a[i2]));
        }
    }

    private void b(Location location) {
        c(location);
        h();
    }

    private void c() {
        if (!this.N) {
            this.N = true;
            d(b.d);
            j();
            d();
        }
    }

    private void c(int i) {
        if (i != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.a);
            stringBuilder.append("/grtcf.dat");
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
                randomAccessFile.seek(8);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b("%d_%02d_%02d"));
                stringBuilder2.append(":");
                stringBuilder2.append(i);
                byte[] bytes2 = stringBuilder2.toString().getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2);
                randomAccessFile.close();
            } catch (Exception unused) {
            }
        }
    }

    private void c(Location location) {
        if (System.currentTimeMillis() - this.a >= ((long) this.H) && location != null) {
            if (location != null && location.hasSpeed() && location.getSpeed() > this.E) {
                this.E = location.getSpeed();
            }
            try {
                if (this.M == null) {
                    this.M = new ArrayList();
                    i();
                    d(location);
                } else {
                    e(location);
                }
            } catch (Exception unused) {
            }
            this.L++;
        }
    }

    private void c(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.k = jSONObject.getInt("on");
                }
                if (jSONObject.has("bash")) {
                    this.l = jSONObject.getDouble("bash");
                }
                if (jSONObject.has("net")) {
                    this.m = jSONObject.getString("net");
                }
                if (jSONObject.has("tcon")) {
                    this.n = jSONObject.getInt("tcon");
                }
                if (jSONObject.has("tcsh")) {
                    this.o = jSONObject.getInt("tcsh");
                }
                if (jSONObject.has("per")) {
                    this.p = jSONObject.getInt("per");
                }
                if (jSONObject.has("chdron")) {
                    this.q = jSONObject.getInt("chdron");
                }
                if (jSONObject.has("spsh")) {
                    this.r = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.s = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.t = jSONObject.getDouble("stspsh");
                }
                if (jSONObject.has("drstsh")) {
                    this.u = jSONObject.getInt("drstsh");
                }
                if (jSONObject.has("stper")) {
                    this.v = jSONObject.getInt("stper");
                }
                if (jSONObject.has("nondron")) {
                    this.w = jSONObject.getInt("nondron");
                }
                if (jSONObject.has("nondrper")) {
                    this.x = jSONObject.getInt("nondrper");
                }
                if (jSONObject.has("uptime")) {
                    this.z = jSONObject.getLong("uptime");
                }
                k();
            } catch (JSONException unused) {
            }
        }
    }

    private void d() {
        String[] split = "7.6.2".split("\\.");
        int i = 4;
        int i2 = 0;
        int length = split.length;
        this.J[0] = (byte) 0;
        this.J[1] = (byte) 0;
        this.J[2] = (byte) 0;
        this.J[3] = (byte) 0;
        if (length < 4) {
            i = length;
        }
        while (i2 < i) {
            try {
                this.J[i2] = (byte) (255 & Integer.valueOf(split[i2]).intValue());
                i2++;
            } catch (Exception unused) {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.d);
        stringBuilder.append(":");
        stringBuilder.append(b.a().b);
        this.K = a(stringBuilder.toString());
    }

    private void d(Location location) {
        this.e = System.currentTimeMillis();
        b((int) (location.getTime() / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        int hasSpeed = location.hasSpeed() ^ 1;
        this.M.add(Byte.valueOf((location.hasBearing() ^ 1) > 0 ? (byte) 32 : (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & -33)));
        this.M.add(Byte.valueOf(hasSpeed > 0 ? Byte.MIN_VALUE : (byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & TransportMediator.KEYCODE_MEDIA_PAUSE)));
        this.b = location;
    }

    private void d(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/grtcf.dat");
        try {
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.seek(8);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.read(bArr, 0, readInt2);
                String str2 = new String(bArr);
                int i = 1;
                if (str2.contains(b("%d_%02d_%02d")) && str2.contains(":")) {
                    try {
                        String[] split = str2.split(":");
                        if (split.length > 1) {
                            this.y = Integer.valueOf(split[1]).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
                while (i <= readInt) {
                    randomAccessFile.seek((long) (i * 2048));
                    readInt2 = randomAccessFile.readInt();
                    bArr = new byte[readInt2];
                    randomAccessFile.read(bArr, 0, readInt2);
                    str2 = new String(bArr);
                    if (str != null && str2.contains(str)) {
                        c(str2);
                        break;
                    }
                    i++;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARNING: Missing block: B:30:0x0107, code skipped:
            if (r8 > 0) goto L_0x0109;
     */
    /* JADX WARNING: Missing block: B:36:0x0128, code skipped:
            if (r8 > 0) goto L_0x0109;
     */
    private void e(android.location.Location r26) {
        /*
        r25 = this;
        r0 = r25;
        r1 = r26;
        if (r1 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r2 = r26.getLongitude();
        r4 = r0.b;
        r4 = r4.getLongitude();
        r2 = r2 - r4;
        r4 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r2 = r2 * r4;
        r2 = (int) r2;
        r6 = r26.getLatitude();
        r3 = r0.b;
        r8 = r3.getLatitude();
        r6 = r6 - r8;
        r6 = r6 * r4;
        r3 = (int) r6;
        r4 = r26.hasBearing();
        r5 = 1;
        r4 = r4 ^ r5;
        r6 = r26.hasSpeed();
        r6 = r6 ^ r5;
        r7 = 0;
        if (r2 <= 0) goto L_0x0036;
    L_0x0034:
        r8 = r7;
        goto L_0x0037;
    L_0x0036:
        r8 = r5;
    L_0x0037:
        r2 = java.lang.Math.abs(r2);
        if (r3 <= 0) goto L_0x003f;
    L_0x003d:
        r9 = r7;
        goto L_0x0040;
    L_0x003f:
        r9 = r5;
    L_0x0040:
        r3 = java.lang.Math.abs(r3);
        r10 = r0.L;
        if (r10 <= r5) goto L_0x004f;
    L_0x0048:
        r5 = 0;
        r0.c = r5;
        r5 = r0.b;
        r0.c = r5;
    L_0x004f:
        r0.b = r1;
        r5 = r0.b;
        if (r5 == 0) goto L_0x00c7;
    L_0x0055:
        r5 = r0.c;
        if (r5 == 0) goto L_0x00c7;
    L_0x0059:
        r5 = r0.b;
        r10 = r5.getTime();
        r5 = r0.c;
        r12 = r5.getTime();
        r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r5 <= 0) goto L_0x00c7;
    L_0x0069:
        r5 = r0.b;
        r10 = r5.getTime();
        r5 = r0.c;
        r12 = r5.getTime();
        r14 = r10 - r12;
        r10 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r5 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r5 >= 0) goto L_0x00c7;
    L_0x007d:
        r5 = r0.b;
        r10 = r5.getTime();
        r5 = r0.c;
        r12 = r5.getTime();
        r14 = r10 - r12;
        r5 = 2;
        r5 = new float[r5];
        r10 = r0.b;
        r16 = r10.getAltitude();
        r10 = r0.b;
        r18 = r10.getLongitude();
        r10 = r0.c;
        r20 = r10.getLatitude();
        r10 = r0.c;
        r22 = r10.getLongitude();
        r24 = r5;
        android.location.Location.distanceBetween(r16, r18, r20, r22, r24);
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5[r7];
        r7 = r0.c;
        r7 = r7.getSpeed();
        r11 = (float) r14;
        r7 = r7 * r11;
        r5 = r5 - r7;
        r10 = r10 * r5;
        r14 = r14 * r14;
        r5 = (float) r14;
        r10 = r10 / r5;
        r10 = (double) r10;
        r5 = r0.F;
        r12 = (double) r5;
        r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r5 <= 0) goto L_0x00c7;
    L_0x00c4:
        r5 = (float) r10;
        r0.F = r5;
    L_0x00c7:
        r5 = r0.M;
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r10 = r7 & r2;
        r10 = (byte) r10;
        r10 = java.lang.Byte.valueOf(r10);
        r5.add(r10);
        r5 = r0.M;
        r10 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r2 = r2 & r10;
        r2 = r2 >> 8;
        r2 = (byte) r2;
        r2 = java.lang.Byte.valueOf(r2);
        r5.add(r2);
        r2 = r0.M;
        r5 = r7 & r3;
        r5 = (byte) r5;
        r5 = java.lang.Byte.valueOf(r5);
        r2.add(r5);
        r2 = r0.M;
        r3 = r3 & r10;
        r3 = r3 >> 8;
        r3 = (byte) r3;
        r3 = java.lang.Byte.valueOf(r3);
        r2.add(r3);
        if (r4 <= 0) goto L_0x0116;
    L_0x0100:
        r2 = 32;
        if (r9 <= 0) goto L_0x0107;
    L_0x0104:
        r2 = 96;
        r2 = (byte) r2;
    L_0x0107:
        if (r8 <= 0) goto L_0x010c;
    L_0x0109:
        r2 = r2 | -128;
        r2 = (byte) r2;
    L_0x010c:
        r3 = r0.M;
        r2 = java.lang.Byte.valueOf(r2);
        r3.add(r2);
        goto L_0x012b;
    L_0x0116:
        r2 = r26.getBearing();
        r3 = 1097859072; // 0x41700000 float:15.0 double:5.424144515E-315;
        r2 = r2 / r3;
        r2 = (int) r2;
        r2 = r2 & r7;
        r2 = (byte) r2;
        r2 = r2 & 31;
        r2 = (byte) r2;
        if (r9 <= 0) goto L_0x0128;
    L_0x0125:
        r2 = r2 | 64;
        r2 = (byte) r2;
    L_0x0128:
        if (r8 <= 0) goto L_0x010c;
    L_0x012a:
        goto L_0x0109;
    L_0x012b:
        if (r6 <= 0) goto L_0x0139;
    L_0x012d:
        r1 = r0.M;
        r2 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        r2 = java.lang.Byte.valueOf(r2);
        r1.add(r2);
        return;
    L_0x0139:
        r1 = r26.getSpeed();
        r1 = (double) r1;
        r3 = 4615288898129284301; // 0x400ccccccccccccd float:-1.07374184E8 double:3.6;
        r1 = r1 * r3;
        r3 = 4616189618054758400; // 0x4010000000000000 float:0.0 double:4.0;
        r1 = r1 / r3;
        r1 = (int) r1;
        r1 = r1 & r7;
        r1 = (byte) r1;
        r1 = r1 & 127;
        r1 = (byte) r1;
        r2 = r0.M;
        r1 = java.lang.Byte.valueOf(r1);
        r2.add(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.d.e(android.location.Location):void");
    }

    private void e(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/grtcf.dat");
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
            randomAccessFile.seek(2);
            int readInt = randomAccessFile.readInt();
            int i = 1;
            while (i <= readInt) {
                randomAccessFile.seek((long) (i * 2048));
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.read(bArr, 0, readInt2);
                if (new String(bArr).contains(b.d)) {
                    break;
                }
                i++;
            }
            if (i >= readInt) {
                randomAccessFile.seek(2);
                randomAccessFile.writeInt(i);
            }
            randomAccessFile.seek((long) (i * 2048));
            byte[] bytes2 = str.getBytes();
            randomAccessFile.writeInt(bytes2.length);
            randomAccessFile.write(bytes2);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0058 A:{SYNTHETIC, Splitter:B:29:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d A:{Catch:{ Exception -> 0x0060 }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0063 A:{SYNTHETIC, Splitter:B:37:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0058 A:{SYNTHETIC, Splitter:B:29:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d A:{Catch:{ Exception -> 0x0060 }} */
    private boolean e() {
        /*
        r5 = this;
        r0 = 0;
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r3.<init>();	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r4 = com.baidu.location.g.j.h();	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r3.append(r4);	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r4 = java.io.File.separator;	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r3.append(r4);	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r4 = "gflk.dat";
        r3.append(r4);	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r3 = r2.exists();	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        if (r3 != 0) goto L_0x002a;
    L_0x0027:
        r2.createNewFile();	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
    L_0x002a:
        r3 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r4 = "rw";
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x0061, all -> 0x0054 }
        r2 = r3.getChannel();	 Catch:{ Exception -> 0x0042, all -> 0x0040 }
        r4 = r2.tryLock();	 Catch:{ Exception -> 0x003e, all -> 0x003b }
        r0 = r4;
        goto L_0x0044;
    L_0x003b:
        r1 = move-exception;
        r0 = r2;
        goto L_0x0056;
    L_0x003e:
        r1 = 1;
        goto L_0x0044;
    L_0x0040:
        r1 = move-exception;
        goto L_0x0056;
    L_0x0042:
        r0 = r3;
        goto L_0x0061;
    L_0x0044:
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        r0.release();	 Catch:{ Exception -> 0x0066 }
    L_0x0049:
        if (r2 == 0) goto L_0x004e;
    L_0x004b:
        r2.close();	 Catch:{ Exception -> 0x0066 }
    L_0x004e:
        if (r3 == 0) goto L_0x0066;
    L_0x0050:
        r3.close();	 Catch:{ Exception -> 0x0066 }
        return r1;
    L_0x0054:
        r1 = move-exception;
        r3 = r0;
    L_0x0056:
        if (r0 == 0) goto L_0x005b;
    L_0x0058:
        r0.close();	 Catch:{ Exception -> 0x0060 }
    L_0x005b:
        if (r3 == 0) goto L_0x0060;
    L_0x005d:
        r3.close();	 Catch:{ Exception -> 0x0060 }
    L_0x0060:
        throw r1;
    L_0x0061:
        if (r0 == 0) goto L_0x0066;
    L_0x0063:
        r0.close();	 Catch:{ Exception -> 0x0066 }
    L_0x0066:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.d.e():boolean");
    }

    private boolean f() {
        if (this.B) {
            if (this.C) {
                if (((double) this.E) < this.t) {
                    this.D += this.p;
                    if (this.D <= this.u || System.currentTimeMillis() - this.G > ((long) (this.v * 1000))) {
                        return true;
                    }
                }
                this.D = 0;
                this.C = false;
                return true;
            } else if (((double) this.E) < this.t) {
                this.C = true;
                this.D = 0;
                this.D += this.p;
                return true;
            }
            return true;
        } else if (((double) this.E) >= this.r || ((double) this.F) >= this.s) {
            this.B = true;
            return true;
        } else if (this.w == 1 && System.currentTimeMillis() - this.G > ((long) (this.x * 1000))) {
            return true;
        }
        return false;
    }

    private void g() {
        this.M = null;
        this.e = 0;
        this.L = 0;
        this.b = null;
        this.c = null;
        this.E = 0.0f;
        this.F = 0.0f;
    }

    private void h() {
        if (this.e != 0 && System.currentTimeMillis() - this.e >= ((long) (this.p * 1000))) {
            int i = 0;
            if (f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
                g();
            } else if (this.n != 1 || f()) {
                if (b.d.equals("com.ubercab.driver")) {
                    if (e()) {
                        g();
                        return;
                    }
                } else if (!a(b.d, f.getServiceContext())) {
                    g();
                    return;
                }
                if (this.M != null) {
                    int size = this.M.size();
                    this.M.set(0, Byte.valueOf((byte) (size & 255)));
                    this.M.set(1, Byte.valueOf((byte) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & size) >> 8)));
                    this.M.set(3, Byte.valueOf((byte) (this.L & 255)));
                    byte[] bArr = new byte[size];
                    while (i < size) {
                        bArr[i] = ((Byte) this.M.get(i)).byteValue();
                        i++;
                    }
                    File file = new File(j.j(), "baidu/tempdata");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (file.exists()) {
                        File file2 = new File(file, "intime.dat");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            new f(this).start();
                        } catch (Exception unused) {
                        }
                    }
                    g();
                    this.G = System.currentTimeMillis();
                }
            } else {
                g();
            }
        }
    }

    private void i() {
        List list;
        byte b;
        int i = 0;
        this.M.add(Byte.valueOf((byte) 0));
        this.M.add(Byte.valueOf((byte) 0));
        if (f.equals("0")) {
            list = this.M;
            b = (byte) -82;
        } else {
            list = this.M;
            b = (byte) -66;
        }
        list.add(Byte.valueOf(b));
        this.M.add(Byte.valueOf((byte) 0));
        this.M.add(Byte.valueOf(this.J[0]));
        this.M.add(Byte.valueOf(this.J[1]));
        this.M.add(Byte.valueOf(this.J[2]));
        this.M.add(Byte.valueOf(this.J[3]));
        int length = this.K.length;
        this.M.add(Byte.valueOf((byte) (255 & (length + 1))));
        while (i < length) {
            this.M.add(Byte.valueOf(this.K[i]));
            i++;
        }
    }

    private void j() {
        if (System.currentTimeMillis() - this.z > LogBuilder.MAX_INTERVAL) {
            if (this.A == null) {
                this.A = new a();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(b.a().a(false));
            stringBuffer.append(a.a().d());
            this.A.a(stringBuffer.toString());
        }
        k();
    }

    private void k() {
    }

    public void a(Location location) {
        if (!this.N) {
            c();
        }
        Object obj = ((double) com.baidu.location.b.d.a().f()) < this.l * 100.0d ? 1 : null;
        if (this.k == 1 && obj != null && this.m.contains(com.baidu.location.e.d.a(com.baidu.location.e.b.a().e())) && (this.n != 1 || this.y <= this.o)) {
            this.I.post(new e(this, location));
        }
    }

    public void b() {
        if (this.N) {
            this.N = false;
            g();
        }
    }
}
