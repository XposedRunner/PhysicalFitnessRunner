package com.baidu.location.indoor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

public class n {
    private int A;
    private long B;
    private int C;
    private int D;
    private double E;
    private double F;
    private double G;
    private double H;
    private double I;
    private double J;
    private double K;
    private int L;
    private float M;
    private int N;
    private int O;
    private double[] P;
    private boolean Q;
    private double R;
    private String S;
    Timer a;
    public SensorEventListener b;
    private a c;
    private SensorManager d;
    private boolean e;
    private int f;
    private Sensor g;
    private Sensor h;
    private Sensor i;
    private final long j;
    private boolean k;
    private boolean l;
    private boolean m;
    private volatile int n;
    private int o;
    private float[] p;
    private float[] q;
    private double[] r;
    private int s;
    private double[] t;
    private int u;
    private int v;
    private int w;
    private double[] x;
    private int y;
    private double z;

    public interface a {
        void a(double d, double d2, double d3, long j);
    }

    private n(Context context, int i) {
        this.j = 30;
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = 1;
        this.o = 1;
        this.p = new float[3];
        this.q = new float[]{0.0f, 0.0f, 0.0f};
        this.r = new double[]{0.0d, 0.0d, 0.0d};
        this.s = 31;
        this.t = new double[this.s];
        this.u = 0;
        this.x = new double[6];
        this.y = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0.0d;
        this.F = 0.0d;
        this.G = 100.0d;
        this.H = 0.5d;
        this.I = this.H;
        this.J = 0.85d;
        this.K = 0.42d;
        this.L = -1;
        this.M = 0.0f;
        this.N = 20;
        this.O = 0;
        this.P = new double[this.N];
        this.Q = false;
        this.R = -1.0d;
        this.S = null;
        this.b = new o(this);
        this.z = 1.6d;
        this.A = 440;
        try {
            this.d = (SensorManager) context.getSystemService("sensor");
            this.f = i;
            this.g = this.d.getDefaultSensor(1);
            this.h = this.d.getDefaultSensor(3);
            if (com.baidu.location.indoor.mapversion.a.b()) {
                this.i = this.d.getDefaultSensor(4);
            }
            j();
        } catch (Exception unused) {
        }
    }

    public n(Context context, a aVar) {
        this(context, 1);
        this.c = aVar;
    }

    private double a(double d, double d2, double d3) {
        d2 -= d;
        if (d2 < -180.0d) {
            d2 += 360.0d;
        } else if (d2 > 180.0d) {
            d2 -= 360.0d;
        }
        return d + (d3 * d2);
    }

    private double a(double[] dArr) {
        int i = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += d3;
        }
        d2 /= (double) r3;
        while (i < r3) {
            d += (dArr[i] - d2) * (dArr[i] - d2);
            i++;
        }
        return d / ((double) (r3 - 1));
    }

    private void a(double d) {
        this.x[this.y % 6] = d;
        this.y++;
        this.y %= 6;
    }

    private synchronized void a(int i) {
        this.o = i | this.o;
    }

    private float[] a(float f, float f2, float f3) {
        float[] fArr = new float[]{(this.p[0] * 0.8f) + (0.19999999f * f), (this.p[1] * 0.8f) + (0.19999999f * f2), (0.8f * this.p[2]) + (0.19999999f * f3)};
        fArr[0] = f - this.p[0];
        fArr[1] = f2 - this.p[1];
        fArr[2] = f3 - this.p[2];
        return fArr;
    }

    private boolean b(double d) {
        for (int i = 1; i <= 5; i++) {
            if (this.x[((((this.y - 1) - i) + 6) + 6) % 6] - this.x[((this.y - 1) + 6) % 6] > d) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ int h(n nVar) {
        int i = nVar.w + 1;
        nVar.w = i;
        return i;
    }

    private boolean i() {
        for (int i = 0; i < this.N; i++) {
            if (this.P[i] > 1.0E-7d) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        try {
            List<Sensor> sensorList = this.d.getSensorList(-1);
            HashMap hashMap = new HashMap();
            int i = 0;
            hashMap.put(Integer.valueOf(1), Integer.valueOf(0));
            hashMap.put(Integer.valueOf(10), Integer.valueOf(1));
            hashMap.put(Integer.valueOf(9), Integer.valueOf(2));
            hashMap.put(Integer.valueOf(4), Integer.valueOf(3));
            hashMap.put(Integer.valueOf(2), Integer.valueOf(4));
            hashMap.put(Integer.valueOf(11), Integer.valueOf(5));
            hashMap.put(Integer.valueOf(6), Integer.valueOf(6));
            if (VERSION.SDK_INT >= 18) {
                hashMap.put(Integer.valueOf(14), Integer.valueOf(7));
                hashMap.put(Integer.valueOf(16), Integer.valueOf(8));
            }
            int size = hashMap.size();
            char[] cArr = new char[size];
            while (i < size) {
                cArr[i] = '0';
                i++;
            }
            for (Sensor type : sensorList) {
                i = type.getType();
                if (hashMap.get(Integer.valueOf(i)) != null) {
                    i = ((Integer) hashMap.get(Integer.valueOf(i))).intValue();
                    if (i < size) {
                        cArr[i] = '1';
                    }
                }
            }
            this.S = new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void k() {
        this.k = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0116  */
    /* JADX WARNING: Missing block: B:44:0x00f8, code skipped:
            if (r0.I < r0.H) goto L_0x00fd;
     */
    private void l() {
        /*
        r19 = this;
        r0 = r19;
        r1 = r0.v;
        r2 = 20;
        if (r1 >= r2) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = r0.e;
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r9 = java.lang.System.currentTimeMillis();
        r1 = 3;
        r2 = new float[r1];
        r3 = r0.q;
        r4 = 0;
        java.lang.System.arraycopy(r3, r4, r2, r4, r1);
        r3 = new double[r1];
        r5 = r0.r;
        java.lang.System.arraycopy(r5, r4, r3, r4, r1);
        r1 = r2[r4];
        r5 = r2[r4];
        r1 = r1 * r5;
        r5 = 1;
        r6 = r2[r5];
        r7 = r2[r5];
        r6 = r6 * r7;
        r1 = r1 + r6;
        r6 = 2;
        r7 = r2[r6];
        r2 = r2[r6];
        r7 = r7 * r2;
        r1 = r1 + r7;
        r1 = (double) r1;
        r1 = java.lang.Math.sqrt(r1);
        r6 = r0.t;
        r7 = r0.u;
        r6[r7] = r1;
        r0.a(r1);
        r6 = r0.D;
        r6 = r6 + r5;
        r0.D = r6;
        r6 = r0.F;
        r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r8 <= 0) goto L_0x0051;
    L_0x004e:
        r0.F = r1;
        goto L_0x0059;
    L_0x0051:
        r6 = r0.G;
        r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r8 >= 0) goto L_0x0059;
    L_0x0057:
        r0.G = r1;
    L_0x0059:
        r6 = r0.u;
        r6 = r6 + r5;
        r0.u = r6;
        r6 = r0.u;
        r7 = r0.s;
        if (r6 != r7) goto L_0x0084;
    L_0x0064:
        r0.u = r4;
        r6 = r0.t;
        r6 = r0.a(r6);
        r8 = r0.n;
        if (r8 != 0) goto L_0x007f;
    L_0x0070:
        r11 = 4599075939470750515; // 0x3fd3333333333333 float:4.172325E-8 double:0.3;
        r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
        if (r8 >= 0) goto L_0x007f;
    L_0x0079:
        r0.a(r4);
        r0.n = r4;
        goto L_0x0084;
    L_0x007f:
        r0.a(r5);
        r0.n = r5;
    L_0x0084:
        r6 = r0.B;
        r11 = r9 - r6;
        r6 = r0.A;
        r6 = (long) r6;
        r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r8 <= 0) goto L_0x012f;
    L_0x008f:
        r6 = r0.z;
        r6 = r0.b(r6);
        if (r6 == 0) goto L_0x012f;
    L_0x0097:
        r6 = r0.C;
        r6 = r6 + r5;
        r0.C = r6;
        r0.B = r9;
        r6 = r3[r4];
        r11 = r3[r4];
        r8 = r0.k;
        r13 = 0;
        if (r8 == 0) goto L_0x00c9;
    L_0x00a8:
        r8 = r0.l;
        if (r8 == 0) goto L_0x00c9;
    L_0x00ac:
        r8 = com.baidu.location.indoor.mapversion.a.b();
        if (r8 == 0) goto L_0x00c9;
    L_0x00b2:
        r6 = com.baidu.location.indoor.mapversion.a.c();
        r6 = r6[r4];
        r6 = (double) r6;
        r8 = java.lang.Double.isNaN(r6);
        if (r8 != 0) goto L_0x00c6;
    L_0x00bf:
        r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1));
        if (r8 >= 0) goto L_0x00c4;
    L_0x00c3:
        goto L_0x00c6;
    L_0x00c4:
        r4 = r5;
        goto L_0x00c9;
    L_0x00c6:
        r6 = r3[r4];
        goto L_0x00c4;
    L_0x00c9:
        r3 = r0.D;
        r8 = 40;
        if (r3 >= r8) goto L_0x00fb;
    L_0x00cf:
        r3 = r0.D;
        if (r3 <= 0) goto L_0x00fb;
    L_0x00d3:
        r13 = r0.F;
        r17 = r6;
        r5 = r0.G;
        r13 = r13 - r5;
        r5 = java.lang.Math.sqrt(r13);
        r5 = java.lang.Math.sqrt(r5);
        r7 = r0.K;
        r5 = r5 * r7;
        r0.I = r5;
        r5 = r0.I;
        r7 = r0.J;
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x00f2;
    L_0x00ef:
        r5 = r0.J;
        goto L_0x00ff;
    L_0x00f2:
        r5 = r0.I;
        r7 = r0.H;
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 >= 0) goto L_0x0101;
    L_0x00fa:
        goto L_0x00fd;
    L_0x00fb:
        r17 = r6;
    L_0x00fd:
        r5 = r0.H;
    L_0x00ff:
        r0.I = r5;
    L_0x0101:
        r3 = r0.M;
        r5 = (double) r3;
        r6 = r17 + r5;
        r13 = 4645040803167600640; // 0x4076800000000000 float:0.0 double:360.0;
        r3 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1));
        if (r3 <= 0) goto L_0x0110;
    L_0x010f:
        r6 = r6 - r13;
    L_0x0110:
        r15 = 0;
        r3 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1));
        if (r3 >= 0) goto L_0x0117;
    L_0x0116:
        r6 = r6 + r13;
    L_0x0117:
        r7 = r6;
        r3 = 1;
        r0.D = r3;
        r0.F = r1;
        r0.G = r1;
        r0.R = r7;
        r1 = r0.Q;
        if (r1 != 0) goto L_0x0127;
    L_0x0125:
        if (r4 == 0) goto L_0x012f;
    L_0x0127:
        r2 = r0.c;
        r3 = r0.I;
        r5 = r11;
        r2.a(r3, r5, r7, r9);
    L_0x012f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.n.l():void");
    }

    public void a() {
        if (!this.e) {
            if (this.g != null) {
                try {
                    this.d.registerListener(this.b, this.g, this.f);
                } catch (Exception unused) {
                    this.k = false;
                }
                this.a = new Timer("UpdateData", false);
                this.a.schedule(new p(this), 500, 30);
                this.e = true;
            }
            if (this.h != null) {
                try {
                    this.d.registerListener(this.b, this.h, this.f);
                } catch (Exception unused2) {
                    this.k = false;
                }
            }
        }
    }

    public void a(boolean z) {
        this.l = z;
        if (z && !this.m) {
            k();
            this.m = true;
        }
    }

    public void b() {
        if (this.e) {
            this.e = false;
            try {
                this.d.unregisterListener(this.b);
            } catch (Exception unused) {
            }
            this.a.cancel();
            this.a.purge();
            this.a = null;
            this.m = false;
            if (com.baidu.location.indoor.mapversion.a.b()) {
                com.baidu.location.indoor.mapversion.a.a();
            }
        }
    }

    public synchronized int c() {
        if (this.v < 20) {
            return 1;
        }
        return this.o;
    }

    public synchronized int d() {
        if (this.v < 20) {
            return -1;
        }
        return this.C;
    }

    public double e() {
        return this.R;
    }

    public synchronized void f() {
        this.o = 0;
    }

    public boolean g() {
        return this.l;
    }

    /* Access modifiers changed, original: protected */
    public String h() {
        return this.S;
    }
}
