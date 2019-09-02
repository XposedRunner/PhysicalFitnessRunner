package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.List;

public class SpatialRelationUtil {
    private static LatLng a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(latLng3);
        double sqrt = Math.sqrt(((ll2mc.getLongitudeE6() - ll2mc.getLongitudeE6()) * (ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6())) + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * (ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6())));
        double longitudeE6 = (((ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6()) * (ll2mc3.getLongitudeE6() - ll2mc.getLongitudeE6())) + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * (ll2mc3.getLatitudeE6() - ll2mc.getLatitudeE6()))) / (sqrt * sqrt);
        return CoordUtil.mc2ll(new GeoPoint(ll2mc.getLatitudeE6() + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * longitudeE6), ll2mc.getLongitudeE6() + ((ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6()) * longitudeE6)));
    }

    public static LatLng getNearestPointFromLine(List<LatLng> list, LatLng latLng) {
        LatLng latLng2 = null;
        if (!(list == null || list.size() == 0)) {
            if (latLng == null) {
                return null;
            }
            int i = 0;
            while (i < list.size() - 1) {
                LatLng latLng3;
                int i2 = i + 1;
                LatLng a = a((LatLng) list.get(i), (LatLng) list.get(i2), latLng);
                if ((a.latitude - ((LatLng) list.get(i)).latitude) * (a.latitude - ((LatLng) list.get(i2)).latitude) > 0.0d || (a.longitude - ((LatLng) list.get(i)).longitude) * (a.longitude - ((LatLng) list.get(i2)).longitude) > 0.0d) {
                    latLng3 = (LatLng) (DistanceUtil.getDistance(latLng, (LatLng) list.get(i)) < DistanceUtil.getDistance(latLng, (LatLng) list.get(i2)) ? list.get(i) : list.get(i2));
                } else {
                    latLng3 = a;
                }
                if (latLng2 == null || DistanceUtil.getDistance(latLng, latLng3) < DistanceUtil.getDistance(latLng, latLng2)) {
                    latLng2 = latLng3;
                }
                i = i2;
            }
        }
        return latLng2;
    }

    /* JADX WARNING: Missing block: B:11:0x0018, code skipped:
            return false;
     */
    public static boolean isCircleContainsPoint(com.baidu.mapapi.model.LatLng r3, int r4, com.baidu.mapapi.model.LatLng r5) {
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x0018;
    L_0x0003:
        if (r4 == 0) goto L_0x0018;
    L_0x0005:
        if (r5 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = com.baidu.mapapi.utils.DistanceUtil.getDistance(r3, r5);
        r3 = (double) r4;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        r3 = 1;
        if (r5 != 0) goto L_0x0017;
    L_0x0017:
        return r3;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.utils.SpatialRelationUtil.isCircleContainsPoint(com.baidu.mapapi.model.LatLng, int, com.baidu.mapapi.model.LatLng):boolean");
    }

    public static boolean isPolygonContainsPoint(List<LatLng> list, LatLng latLng) {
        boolean z = false;
        if (!(list == null || list.size() == 0)) {
            if (latLng == null) {
                return false;
            }
            int i = 0;
            while (i < list.size()) {
                if (latLng.longitude == ((LatLng) list.get(i)).longitude && latLng.latitude == ((LatLng) list.get(i)).latitude) {
                    return true;
                }
                i++;
            }
            i = list.size();
            int i2 = 0;
            int i3 = i2;
            while (i2 < i) {
                LatLng latLng2 = (LatLng) list.get(i2);
                i2++;
                LatLng latLng3 = (LatLng) list.get(i2 % i);
                if (latLng2.latitude != latLng3.latitude) {
                    if (latLng.latitude >= Math.min(latLng2.latitude, latLng3.latitude)) {
                        if (latLng.latitude <= Math.max(latLng2.latitude, latLng3.latitude)) {
                            double d = (((latLng.latitude - latLng2.latitude) * (latLng3.longitude - latLng2.longitude)) / (latLng3.latitude - latLng2.latitude)) + latLng2.longitude;
                            if (d == latLng.longitude) {
                                return true;
                            }
                            if (d < latLng.longitude) {
                                i3++;
                            }
                        }
                    }
                }
            }
            if (i3 % 2 == 1) {
                z = true;
            }
        }
        return z;
    }
}
