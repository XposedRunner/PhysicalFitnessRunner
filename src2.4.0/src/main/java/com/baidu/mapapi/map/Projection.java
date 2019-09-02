package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ab.a;
import com.baidu.mapsdkplatform.comapi.map.e;

public final class Projection {
    private e a;

    Projection(e eVar) {
        this.a = eVar;
    }

    public LatLng fromScreenLocation(Point point) {
        return (point == null || this.a == null) ? null : CoordUtil.mc2ll(this.a.b(point.x, point.y));
    }

    public float metersToEquatorPixels(float f) {
        return f <= 0.0f ? 0.0f : (float) (((double) f) / this.a.K());
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab abVar = mapStatus.a;
        return new PointF((float) (ll2mc.getLongitudeE6() - abVar.d), (float) (ll2mc.getLatitudeE6() - abVar.e));
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        a aVar = mapStatus.a.k;
        return new PointF((float) ((((ll2mc.getLongitudeE6() - ((double) aVar.a)) * 2.0d) / ((double) Math.abs(aVar.b - aVar.a))) - 1.0d), (float) (((2.0d * (ll2mc.getLatitudeE6() - ((double) aVar.d))) / ((double) Math.abs(aVar.c - aVar.d))) - 1.0d));
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.a == null) {
            return null;
        }
        return this.a.a(CoordUtil.ll2mc(latLng));
    }
}
