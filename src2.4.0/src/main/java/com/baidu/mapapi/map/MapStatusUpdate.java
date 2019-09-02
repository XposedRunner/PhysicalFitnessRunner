package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.e;

public final class MapStatusUpdate {
    private static final String p = "MapStatusUpdate";
    int a;
    MapStatus b;
    LatLng c;
    LatLngBounds d;
    int e;
    int f;
    float g;
    int h;
    int i;
    float j;
    Point k;
    int l = 0;
    int m = 0;
    int n = 0;
    int o = 0;

    MapStatusUpdate() {
    }

    MapStatusUpdate(int i) {
        this.a = i;
    }

    private float a(LatLngBounds latLngBounds, e eVar, int i, int i2) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
        Point a = eVar.a(ll2mc);
        Point a2 = eVar.a(ll2mc2);
        Point point = new Point(a.x - Math.abs(this.l), a.y + Math.abs(this.o));
        a = new Point(a2.x + Math.abs(this.n), a2.y - Math.abs(this.m));
        ll2mc2 = eVar.b(point.x, point.y);
        ll2mc = eVar.b(a.x, a.y);
        return eVar.a((int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), (int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), i, i2);
    }

    private MapStatusUpdate a(MapStatus mapStatus) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate();
        synchronized (this) {
            mapStatusUpdate.b = mapStatus;
            mapStatusUpdate.d = this.d;
            mapStatusUpdate.l = this.l;
            mapStatusUpdate.m = this.m;
            mapStatusUpdate.n = this.n;
            mapStatusUpdate.o = this.o;
        }
        return mapStatusUpdate;
    }

    /* JADX WARNING: Missing block: B:14:0x001b, code skipped:
            return true;
     */
    private boolean a(int r3, int r4, int r5, int r6, com.baidu.mapsdkplatform.comapi.map.e r7) {
        /*
        r2 = this;
        r7 = r7.G();
        r0 = 1;
        if (r7 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = r7.l;
        if (r3 != r1) goto L_0x001b;
    L_0x000c:
        r3 = r7.m;
        if (r4 != r3) goto L_0x001b;
    L_0x0010:
        r3 = r7.n;
        if (r5 != r3) goto L_0x001b;
    L_0x0014:
        r3 = r7.o;
        if (r6 == r3) goto L_0x0019;
    L_0x0018:
        return r0;
    L_0x0019:
        r3 = 0;
        return r3;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.MapStatusUpdate.a(int, int, int, int, com.baidu.mapsdkplatform.comapi.map.e):boolean");
    }

    private boolean a(LatLngBounds latLngBounds, e eVar) {
        LatLngBounds latLngBounds2 = latLngBounds;
        MapStatusUpdate G = eVar.G();
        if (G == null) {
            return true;
        }
        return (latLngBounds2.southwest.latitude == G.d.southwest.latitude && latLngBounds2.southwest.longitude == G.d.southwest.longitude && latLngBounds2.northeast.latitude == G.d.northeast.latitude && latLngBounds2.northeast.longitude == G.d.northeast.longitude) ? false : true;
    }

    private LatLng b(LatLngBounds latLngBounds, e eVar) {
        if (latLngBounds == null || eVar == null) {
            return null;
        }
        Point a = eVar.a(CoordUtil.ll2mc(latLngBounds.getCenter()));
        int i = this.l > this.n ? a.x - (this.l - this.n) : this.l < this.n ? a.x + (this.n - this.l) : a.x;
        int i2 = this.m < this.o ? a.y - (this.m - this.o) : this.m > this.o ? a.y + (this.o - this.m) : a.y;
        GeoPoint b = eVar.b(i, i2);
        if (b != null) {
            return CoordUtil.mc2ll(b);
        }
        Log.e(p, "New center geopoint is null");
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public MapStatus a(e eVar, MapStatus mapStatus) {
        e eVar2 = eVar;
        MapStatus mapStatus2 = mapStatus;
        if (eVar2 == null || mapStatus2 == null) {
            return null;
        }
        GeoPoint ll2mc;
        GeoPoint ll2mc2;
        int H;
        int I;
        switch (this.a) {
            case 1:
                return this.b;
            case 2:
                return new MapStatus(mapStatus2.rotate, this.c, mapStatus2.overlook, mapStatus2.zoom, mapStatus2.targetScreen, null);
            case 3:
                if (this.d == null) {
                    return null;
                }
                ll2mc = CoordUtil.ll2mc(this.d.southwest);
                ll2mc2 = CoordUtil.ll2mc(this.d.northeast);
                return new MapStatus(mapStatus2.rotate, this.d.getCenter(), mapStatus2.overlook, eVar2.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), mapStatus2.a.j.right - mapStatus2.a.j.left, mapStatus2.a.j.bottom - mapStatus2.a.j.top), mapStatus2.targetScreen, null);
            case 4:
                return new MapStatus(mapStatus2.rotate, this.c, mapStatus2.overlook, this.g, mapStatus2.targetScreen, null);
            case 5:
                ll2mc = eVar2.b((eVar.H() / 2) + this.h, (eVar.I() / 2) + this.i);
                return new MapStatus(mapStatus2.rotate, CoordUtil.mc2ll(ll2mc), mapStatus2.overlook, mapStatus2.zoom, mapStatus2.targetScreen, ll2mc.getLongitudeE6(), ll2mc.getLatitudeE6(), null);
            case 6:
                return new MapStatus(mapStatus2.rotate, mapStatus2.target, mapStatus2.overlook, mapStatus2.zoom + this.j, mapStatus2.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 7:
                return new MapStatus(mapStatus2.rotate, CoordUtil.mc2ll(eVar2.b(this.k.x, this.k.y)), mapStatus2.overlook, mapStatus2.zoom + this.j, this.k, null);
            case 8:
                return new MapStatus(mapStatus2.rotate, mapStatus2.target, mapStatus2.overlook, this.g, mapStatus2.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 9:
                if (this.d == null) {
                    return null;
                }
                ll2mc = CoordUtil.ll2mc(this.d.southwest);
                ll2mc2 = CoordUtil.ll2mc(this.d.northeast);
                return new MapStatus(mapStatus2.rotate, this.d.getCenter(), mapStatus2.overlook, eVar2.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), this.e, this.f), mapStatus2.targetScreen, null);
            case 10:
                if (this.d == null) {
                    return null;
                }
                H = (eVar.H() - this.l) - this.n;
                if (H < 0) {
                    H = eVar.H();
                    Log.e(p, "Bound paddingLeft or paddingRight too larger, please check");
                }
                I = (eVar.I() - this.m) - this.o;
                if (I < 0) {
                    I = eVar.I();
                    Log.e(p, "Bound paddingTop or paddingBottom too larger, please check");
                }
                LatLng b = b(this.d, eVar2);
                if (b == null) {
                    Log.e(p, "Bound center error");
                    return null;
                }
                float a = a(this.d, eVar2, H, I);
                boolean a2 = a(this.d, eVar2);
                boolean a3 = a(this.l, this.m, this.n, this.o, eVar2);
                if (!a2 && !a3) {
                    return eVar.G() != null ? eVar.G().b : null;
                } else {
                    MapStatus mapStatus3 = new MapStatus(mapStatus2.rotate, b, mapStatus2.overlook, a, mapStatus2.targetScreen, null);
                    eVar2.a(a(mapStatus3));
                    return mapStatus3;
                }
            case 11:
                if (this.d == null) {
                    return null;
                }
                WinRound winRound = mapStatus2.winRound;
                I = Math.abs(winRound.right - winRound.left);
                H = Math.abs(winRound.bottom - winRound.top);
                GeoPoint ll2mc3 = CoordUtil.ll2mc(this.d.southwest);
                GeoPoint ll2mc4 = CoordUtil.ll2mc(this.d.northeast);
                double longitudeE6 = ll2mc3.getLongitudeE6();
                double latitudeE6 = ll2mc4.getLatitudeE6();
                double longitudeE62 = ll2mc4.getLongitudeE6();
                double latitudeE62 = ll2mc3.getLatitudeE6();
                double d = longitudeE62;
                double d2 = latitudeE6;
                float a4 = eVar2.a((int) longitudeE6, (int) latitudeE6, (int) longitudeE62, (int) latitudeE62, (I - this.l) - this.n, (H - this.m) - Math.abs(this.o));
                if (a4 == 0.0f) {
                    return null;
                }
                Point a5 = eVar2.a(CoordUtil.ll2mc(this.d.northeast));
                Point a6 = eVar2.a(CoordUtil.ll2mc(this.d.southwest));
                if (Math.abs(a5.y) < Math.abs(this.o)) {
                    a4 -= ((float) this.o) / ((float) H);
                }
                if (longitudeE6 == d && d2 == latitudeE62) {
                    a4 = mapStatus2.zoom;
                }
                return new MapStatus(mapStatus2.rotate, CoordUtil.mc2ll(eVar2.b(I / 2, (((H - a6.y > this.o ? 0 + (H / 2) : (0 + (H / 2)) + ((this.o - (H - a6.y)) / 2)) + (this.o / 2)) - (this.m / 2)) + 50)), mapStatus2.overlook, a4, mapStatus2.targetScreen, null);
            default:
                return null;
        }
    }
}
