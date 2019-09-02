package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapsdkplatform.comapi.synchronization.d.a;

public class e {
    private static final String a = "e";
    private f b = f.a();

    public e(Context context, BaiduMap baiduMap) {
        this.b.a(baiduMap);
    }

    public void a() {
        if (this.b != null) {
            this.b.e();
        }
    }

    public void a(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.b != null) {
            this.b.a(i, i2, i3, i4);
        }
    }

    public void a(d dVar) {
        if (this.b != null) {
            this.b.a(dVar);
        }
    }

    public void b() {
        if (this.b != null) {
            this.b.f();
        }
    }

    public void b(int i) {
        if (this.b != null) {
            this.b.d(i);
        }
    }

    public Marker c() {
        if (this.b != null) {
            return this.b.b();
        }
        a.b(a, "The mSyncRenderStrategic created failed");
        return null;
    }

    public void c(int i) {
        if (this.b != null) {
            this.b.b(i);
        }
    }

    public Marker d() {
        if (this.b != null) {
            return this.b.c();
        }
        a.b(a, "The mSyncRenderStrategic created failed");
        return null;
    }

    public void d(int i) {
        if (this.b != null) {
            this.b.c(i);
        }
    }

    public Marker e() {
        if (this.b != null) {
            return this.b.d();
        }
        a.b(a, "The mSyncRenderStrategic created failed");
        return null;
    }

    public void f() {
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
    }

    public void g() {
        if (this.b != null) {
            this.b.h();
        }
    }
}
