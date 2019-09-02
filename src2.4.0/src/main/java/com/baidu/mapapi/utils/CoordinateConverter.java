package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

public class CoordinateConverter {
    private LatLng a;
    private CoordType b;

    public enum CoordType {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    private static LatLng a(LatLng latLng) {
        return a(latLng, CoordinateType.WGS84);
    }

    private static LatLng a(LatLng latLng, String str) {
        return latLng == null ? null : CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    private static LatLng b(LatLng latLng) {
        return a(latLng, CoordinateType.GCJ02);
    }

    private static LatLng c(LatLng latLng) {
        return a(latLng, CoordinateType.BD09MC);
    }

    private static LatLng d(LatLng latLng) {
        return latLng == null ? null : CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.a == null) {
            return null;
        }
        if (this.b == null) {
            this.b = CoordType.GPS;
        }
        switch (a.a[this.b.ordinal()]) {
            case 1:
                return b(this.a);
            case 2:
                return a(this.a);
            case 3:
                return d(this.a);
            case 4:
                return c(this.a);
            default:
                return null;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }
}
