package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.h;

public final class Circle extends Overlay {
    LatLng a;
    int b;
    int c;
    Stroke d;

    Circle() {
        this.type = h.circle;
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.a, this.c));
        Overlay.a(this.b, bundle);
        if (this.d == null) {
            bundle.putInt("has_stroke", 0);
            return bundle;
        }
        bundle.putInt("has_stroke", 1);
        bundle.putBundle("stroke", this.d.a(new Bundle()));
        return bundle;
    }

    public LatLng getCenter() {
        return this.a;
    }

    public int getFillColor() {
        return this.b;
    }

    public int getRadius() {
        return this.c;
    }

    public Stroke getStroke() {
        return this.d;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("circle center can not be null");
        }
        this.a = latLng;
        this.listener.b(this);
    }

    public void setFillColor(int i) {
        this.b = i;
        this.listener.b(this);
    }

    public void setRadius(int i) {
        this.c = i;
        this.listener.b(this);
    }

    public void setStroke(Stroke stroke) {
        this.d = stroke;
        this.listener.b(this);
    }
}
