package com.amap.api.mapcore.util;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: ProjectionDelegateImp */
class O0000Oo0 implements cc {
    private ca O000000o;

    public O0000Oo0(ca caVar) {
        this.O000000o = caVar;
    }

    public TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2) throws RemoteException {
        LatLngBounds latLngBounds2 = latLngBounds;
        int i3 = i;
        if (latLngBounds2 == null || i3 < 0 || i3 > 20 || i2 <= 0) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        this.O000000o.O000000o(latLngBounds2.southwest.latitude, latLngBounds2.southwest.longitude, obtain);
        this.O000000o.O000000o(latLngBounds2.northeast.latitude, latLngBounds2.northeast.longitude, obtain2);
        int i4 = 20 - i3;
        int i5 = (obtain.x >> i4) / i2;
        int i6 = (obtain.y >> i4) / i2;
        int i7 = (obtain2.x >> i4) / i2;
        int i8 = (obtain2.y >> i4) / i2;
        int i9 = (obtain.x - ((i5 << i4) * i2)) >> i4;
        int i10 = (obtain2.y - ((i8 << i4) * i2)) >> i4;
        obtain.recycle();
        obtain2.recycle();
        return new TileProjection(i9, i10, i5, i7, i8, i6);
    }

    public LatLng fromScreenLocation(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.O000000o.O00000Oo(point.x, point.y, obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x);
        obtain.recycle();
        return latLng;
    }

    public AMapCameraInfo getCameraInfo() {
        return this.O000000o.getCamerInfo();
    }

    public LatLngBounds getMapBounds(LatLng latLng, float f) throws RemoteException {
        return (this.O000000o == null || latLng == null) ? null : this.O000000o.O000000o(latLng, f, 0.0f, 0.0f);
    }

    public VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.O000000o.getMapWidth();
        int mapHeight = this.O000000o.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        return new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    public float toMapLenWithWin(int i) {
        return i <= 0 ? 0.0f : this.O000000o.O0000OOo(i);
    }

    public PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.O000000o.O000000o(latLng.latitude, latLng.longitude, obtain);
        PointF pointF = new PointF(obtain.x, obtain.y);
        obtain.recycle();
        return pointF;
    }

    public Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        this.O000000o.O00000Oo(latLng.latitude, latLng.longitude, obtain);
        Point point = new Point(obtain.x, obtain.y);
        obtain.recycle();
        return point;
    }
}
