package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.l;
import javax.microedition.khronos.opengles.GL10;

class w implements l {
    final /* synthetic */ WearMapView a;

    w(WearMapView wearMapView) {
        this.a = wearMapView;
    }

    public void a() {
        if (this.a.e != null && this.a.e.a() != null) {
            float f = this.a.e.a().E().a;
            if (this.a.z != f) {
                CharSequence format;
                int intValue = ((Integer) WearMapView.w.get((int) f)).intValue();
                int i = ((int) (((double) intValue) / this.a.e.a().E().m)) / 2;
                this.a.q.setPadding(i, 0, i, 0);
                if (intValue >= 1000) {
                    format = String.format(" %d公里 ", new Object[]{Integer.valueOf(intValue / 1000)});
                } else {
                    format = String.format(" %d米 ", new Object[]{Integer.valueOf(intValue)});
                }
                this.a.o.setText(format);
                this.a.p.setText(format);
                this.a.z = f;
            }
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
