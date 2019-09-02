package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.h;
import java.util.ArrayList;
import java.util.List;

public final class Arc extends Overlay {
    private static final String f = "Arc";
    int a;
    int b;
    LatLng c;
    LatLng d;
    LatLng e;

    Arc() {
        this.type = h.arc;
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.c);
        arrayList.add(this.d);
        arrayList.add(this.e);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.b);
        Overlay.a(arrayList, bundle);
        Overlay.a(this.a, bundle);
        return bundle;
    }

    public int getColor() {
        return this.a;
    }

    public LatLng getEndPoint() {
        return this.e;
    }

    public LatLng getMiddlePoint() {
        return this.d;
    }

    public LatLng getStartPoint() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public void setColor(int i) {
        this.a = i;
        this.listener.b(this);
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        } else if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        } else {
            this.c = latLng;
            this.d = latLng2;
            this.e = latLng3;
            this.listener.b(this);
        }
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.b = i;
            this.listener.b(this);
        }
    }
}
