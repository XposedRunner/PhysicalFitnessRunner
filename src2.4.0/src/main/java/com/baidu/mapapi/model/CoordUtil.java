package com.baidu.mapapi.model;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mapsdkplatform.comapi.util.b;
import com.baidu.mapsdkplatform.comjni.tools.a;
import java.util.List;

public class CoordUtil {
    public static LatLng Coordinate_encryptEx(float f, float f2, String str) {
        return b.a(f, f2, str);
    }

    public static LatLng decodeLocation(String str) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(b.a(str)) : b.a(str);
    }

    public static List<LatLng> decodeLocationList(String str) {
        return b.c(str);
    }

    public static List<List<LatLng>> decodeLocationList2D(String str) {
        return b.d(str);
    }

    public static LatLng decodeNodeLocation(String str) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(b.b(str)) : b.b(str);
    }

    public static double getDistance(Point point, Point point2) {
        return a.a(point, point2);
    }

    public static int getMCDistanceByOneLatLngAndRadius(LatLng latLng, int i) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? b.a(CoordTrans.gcjToBaidu(latLng), i) : b.a(latLng, i);
    }

    public static GeoPoint ll2mc(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? b.a(CoordTrans.gcjToBaidu(latLng)) : b.a(latLng);
    }

    public static Point ll2point(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? b.b(CoordTrans.gcjToBaidu(latLng)) : b.b(latLng);
    }

    public static LatLng mc2ll(GeoPoint geoPoint) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(b.a(geoPoint)) : b.a(geoPoint);
    }
}
