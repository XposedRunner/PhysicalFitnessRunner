package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

public class SyncCoordinateConverter {
    private LatLng a;
    private CoordType b;

    public enum CoordType {
        COMMON,
        BD09LL
    }

    private static LatLng a(LatLng latLng) {
        return a(latLng, CoordinateType.GCJ02);
    }

    private static LatLng a(LatLng latLng, String str) {
        return latLng == null ? null : CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    private static LatLng b(LatLng latLng) {
        return latLng == null ? null : CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.a == null) {
            return null;
        }
        if (this.b == null) {
            this.b = CoordType.BD09LL;
        }
        switch (a.a[this.b.ordinal()]) {
            case 1:
                return a(this.a);
            case 2:
                return b(this.a);
            default:
                return null;
        }
    }

    public SyncCoordinateConverter coord(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public SyncCoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }
}
