package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.l;
import javax.microedition.khronos.opengles.GL10;

class s implements l {
    final /* synthetic */ TextureMapView a;

    s(TextureMapView textureMapView) {
        this.a = textureMapView;
    }

    public void a() {
        if (this.a.b != null && this.a.b.b() != null) {
            float f = this.a.b.b().E().a;
            if (f < this.a.b.b().b) {
                f = this.a.b.b().b;
            } else if (f > this.a.b.b().a) {
                f = this.a.b.b().a;
            }
            if (Math.abs(this.a.q - f) > 0.0f) {
                CharSequence format;
                int intValue = ((Integer) TextureMapView.p.get(Math.round(f))).intValue();
                int i = ((int) (((double) intValue) / this.a.b.b().E().m)) / 2;
                this.a.n.setPadding(i, 0, i, 0);
                if (intValue >= 1000) {
                    format = String.format(" %d公里 ", new Object[]{Integer.valueOf(intValue / 1000)});
                } else {
                    format = String.format(" %d米 ", new Object[]{Integer.valueOf(intValue)});
                }
                this.a.l.setText(format);
                this.a.m.setText(format);
                this.a.q = f;
            }
            this.a.b();
            this.a.requestLayout();
        }
    }

    public void a(Bitmap bitmap) {
    }

    public void a(MotionEvent motionEvent) {
    }

    public void a(GeoPoint geoPoint) {
    }

    public void a(ab abVar) {
    }

    public void a(String str) {
    }

    public void a(GL10 gl10, ab abVar) {
    }

    public void a(boolean z) {
    }

    public void b() {
    }

    public void b(GeoPoint geoPoint) {
    }

    public void b(ab abVar) {
    }

    public boolean b(String str) {
        return false;
    }

    public void c() {
    }

    public void c(GeoPoint geoPoint) {
    }

    public void c(ab abVar) {
    }

    public void d() {
    }

    public void d(GeoPoint geoPoint) {
    }

    public void e() {
    }

    public void e(GeoPoint geoPoint) {
    }

    public void f() {
    }
}
