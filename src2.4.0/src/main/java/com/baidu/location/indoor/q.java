package com.baidu.location.indoor;

import android.location.Location;
import android.os.Handler;
import com.baidu.location.BDLocation;

public class q {
    private a a;
    private long b = 450;
    private BDLocation c;
    private b d = null;
    private b e = null;
    private b f = new b();
    private b g = new b();
    private b h = new b();
    private b i = new b();
    private BDLocation j = null;
    private long k = -1;
    private boolean l = false;
    private Handler m = new Handler();
    private Runnable n = new r(this);
    private Runnable o = new s(this);

    public interface a {
        void a(BDLocation bDLocation);
    }

    private class b {
        public double a;
        public double b;

        public b() {
            this.a = 0.0d;
            this.b = 0.0d;
        }

        public b(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public b(b bVar) {
            this.a = bVar.a;
            this.b = bVar.b;
        }

        public b a(double d) {
            return new b(this.a * d, this.b * d);
        }

        public b a(b bVar) {
            return new b(this.a - bVar.a, this.b - bVar.b);
        }

        public b b(b bVar) {
            return new b(this.a + bVar.a, this.b + bVar.b);
        }

        public boolean b(double d) {
            double abs = Math.abs(this.a);
            double abs2 = Math.abs(this.b);
            return abs > 0.0d && abs < d && abs2 > 0.0d && abs2 < d;
        }
    }

    private b a(b bVar) {
        if (this.d == null || bVar == null) {
            return null;
        }
        bVar = this.d.a(bVar);
        this.i = this.i.b(bVar);
        b a = this.h.a(this.f);
        this.f = new b(this.h);
        this.h = new b(bVar);
        bVar = bVar.a(0.2d);
        b a2 = this.i.a(0.01d);
        return bVar.b(a2).b(a.a(-0.02d));
    }

    public void a() {
        if (this.l) {
            this.l = false;
            this.m.removeCallbacks(this.o);
            b();
        }
    }

    public void a(long j) {
        this.b = j;
    }

    public synchronized void a(BDLocation bDLocation) {
        BDLocation bDLocation2 = bDLocation;
        synchronized (this) {
            try {
                double latitude = bDLocation.getLatitude();
                double longitude = bDLocation.getLongitude();
                this.c = bDLocation2;
                this.d = new b(latitude, longitude);
                if (this.e == null) {
                }
                if (this.j == null) {
                    this.j = new BDLocation(bDLocation2);
                } else {
                    double latitude2 = this.j.getLatitude();
                    double longitude2 = this.j.getLongitude();
                    double latitude3 = bDLocation.getLatitude();
                    double longitude3 = bDLocation.getLongitude();
                    float[] fArr = new float[2];
                    double d = longitude3;
                    Location.distanceBetween(latitude2, longitude2, latitude3, longitude3, fArr);
                    if (fArr[0] > 10.0f) {
                        this.j.setLatitude(latitude3);
                        this.j.setLongitude(d);
                    } else {
                        double d2 = d;
                        this.j.setLatitude((latitude2 + latitude3) / 2.0d);
                        this.j.setLongitude((longitude2 + d2) / 2.0d);
                    }
                }
            } finally {
                Object obj = r0;
            }
        }
    }

    public void b() {
        this.k = -1;
        this.e = null;
        this.d = null;
        this.f = new b();
        this.g = new b();
        this.h = new b();
        this.i = new b();
        this.j = null;
    }

    public boolean c() {
        return this.l;
    }
}
