package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.h;
import java.util.List;

public final class Polygon extends Overlay {
    Stroke a;
    int b;
    List<LatLng> c;

    Polygon() {
        this.type = h.polygon;
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) this.c.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        Overlay.a(this.c, bundle);
        Overlay.a(this.b, bundle);
        if (this.a == null) {
            bundle.putInt("has_stroke", 0);
            return bundle;
        }
        bundle.putInt("has_stroke", 1);
        bundle.putBundle("stroke", this.a.a(new Bundle()));
        return bundle;
    }

    public int getFillColor() {
        return this.b;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public Stroke getStroke() {
        return this.a;
    }

    public void setFillColor(int i) {
        this.b = i;
        this.listener.b(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null");
        } else if (list.size() <= 2) {
            throw new IllegalArgumentException("points count can not less than three");
        } else if (list.contains(null)) {
            throw new IllegalArgumentException("points list can not contains null");
        } else {
            int i = 0;
            while (i < list.size()) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < list.size(); i3++) {
                    if (((LatLng) list.get(i)) == ((LatLng) list.get(i3))) {
                        throw new IllegalArgumentException("points list can not has same points");
                    }
                }
                i = i2;
            }
            this.c = list;
            this.listener.b(this);
        }
    }

    public void setStroke(Stroke stroke) {
        this.a = stroke;
        this.listener.b(this);
    }
}
