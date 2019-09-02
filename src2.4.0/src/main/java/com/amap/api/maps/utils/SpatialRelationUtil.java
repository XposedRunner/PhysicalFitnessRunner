package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;

public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (!(list == null || latLng == null)) {
            try {
                if (list.size() != 0) {
                    List arrayList = new ArrayList();
                    int i = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair(Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    Pair calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        return new Pair(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).x, ((DPoint) calShortestDistancePoint.second).y));
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f, double d) {
        if (!(list == null || latLng == null)) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair(Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    Pair calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f);
                    if (calShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                        if (((double) AMapUtils.calculateLineDistance(new LatLng(dPoint.x, dPoint.y), latLng)) < d) {
                            return new Pair(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).x, ((DPoint) calShortestDistancePoint.second).y));
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    /* JADX WARNING: Missing block: B:34:0x00cc, code skipped:
            return null;
     */
    public static android.util.Pair<java.lang.Integer, com.autonavi.amap.mapcore.DPoint> calShortestDistancePoint(java.util.List<com.autonavi.amap.mapcore.DPoint> r27, com.autonavi.amap.mapcore.DPoint r28, float r29) {
        /*
        r0 = r27;
        r1 = r28;
        r2 = 0;
        if (r0 == 0) goto L_0x00cc;
    L_0x0007:
        if (r1 == 0) goto L_0x00cc;
    L_0x0009:
        r3 = r27.size();
        if (r3 != 0) goto L_0x0011;
    L_0x000f:
        goto L_0x00cc;
    L_0x0011:
        r3 = r27.size();
        r4 = 2;
        if (r3 >= r4) goto L_0x0019;
    L_0x0018:
        return r2;
    L_0x0019:
        r3 = 0;
        r3 = r0.get(r3);
        r3 = (com.autonavi.amap.mapcore.DPoint) r3;
        r4 = 0;
        r6 = r27.size();
        r7 = 1;
        r8 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r7;
    L_0x002b:
        r5 = r6 + -1;
        if (r2 > r5) goto L_0x00c9;
    L_0x002f:
        r10 = r0.get(r2);
        r10 = (com.autonavi.amap.mapcore.DPoint) r10;
        if (r2 != r5) goto L_0x0047;
    L_0x0037:
        r5 = r10.equals(r1);
        if (r5 == 0) goto L_0x0047;
    L_0x003d:
        r0 = new android.util.Pair;
        r2 = java.lang.Integer.valueOf(r2);
        r0.<init>(r2, r1);
        return r0;
    L_0x0047:
        r5 = r29;
        r11 = checkRotateIsMatch(r4, r10, r5);
        if (r11 != 0) goto L_0x0053;
    L_0x004f:
        r26 = r2;
        goto L_0x00bf;
    L_0x0053:
        r11 = r4.equals(r1);
        if (r11 == 0) goto L_0x0064;
    L_0x0059:
        r0 = new android.util.Pair;
        r2 = r2 - r7;
        r2 = java.lang.Integer.valueOf(r2);
        r0.<init>(r2, r1);
        return r0;
    L_0x0064:
        r11 = r1.x;
        r13 = r1.y;
        r23 = r8;
        r7 = r4.x;
        r0 = r4.y;
        r4 = r10.x;
        r26 = r2;
        r25 = r3;
        r2 = r10.y;
        r15 = r7;
        r17 = r0;
        r19 = r4;
        r21 = r2;
        r0 = pointToSegDist(r11, r13, r15, r17, r19, r21);
        if (r25 != 0) goto L_0x0099;
    L_0x0083:
        r1 = r0.first;
        r1 = (java.lang.Double) r1;
        r8 = r1.doubleValue();
        r3 = new android.util.Pair;
        r2 = r26 + -1;
        r1 = java.lang.Integer.valueOf(r2);
        r0 = r0.second;
        r3.<init>(r1, r0);
        goto L_0x00bf;
    L_0x0099:
        r1 = r0.first;
        r1 = (java.lang.Double) r1;
        r1 = r1.doubleValue();
        r3 = (r23 > r1 ? 1 : (r23 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x00bb;
    L_0x00a5:
        r1 = r0.first;
        r1 = (java.lang.Double) r1;
        r8 = r1.doubleValue();
        r3 = new android.util.Pair;
        r2 = r26 + -1;
        r1 = java.lang.Integer.valueOf(r2);
        r0 = r0.second;
        r3.<init>(r1, r0);
        goto L_0x00bf;
    L_0x00bb:
        r8 = r23;
        r3 = r25;
    L_0x00bf:
        r2 = r26 + 1;
        r4 = r10;
        r0 = r27;
        r1 = r28;
        r7 = 1;
        goto L_0x002b;
    L_0x00c9:
        r25 = r3;
        return r25;
    L_0x00cc:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.utils.SpatialRelationUtil.calShortestDistancePoint(java.util.List, com.autonavi.amap.mapcore.DPoint, float):android.util.Pair");
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f) {
        if (f == -1.0f) {
            return true;
        }
        if (dPoint == null || dPoint2 == null) {
            return false;
        }
        float abs = Math.abs((OOo000.O000000o(dPoint, dPoint2) + 360.0f) - f) % 360.0f;
        if (abs > 180.0f) {
            abs = 360.0f - abs;
        }
        return abs < 50.0f;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d3;
        double d8 = d4;
        double d9 = d5;
        double d10 = d6;
        double d11 = d9 - d7;
        double d12 = d - d7;
        double d13 = d10 - d8;
        double d14 = d2 - d8;
        double d15 = (d11 * d12) + (d13 * d14);
        if (d15 <= 0.0d) {
            return new Pair(Double.valueOf(Math.sqrt((d12 * d12) + (d14 * d14))), new DPoint(d7, d8));
        }
        d12 = (d11 * d11) + (d13 * d13);
        double d16;
        double d17;
        if (d15 >= d12) {
            d16 = d - d9;
            d17 = d2 - d10;
            return new Pair(Double.valueOf(Math.sqrt((d16 * d16) + (d17 * d17))), new DPoint(d9, d10));
        }
        d15 /= d12;
        d7 += d11 * d15;
        d8 += d13 * d15;
        d16 = d - d7;
        d17 = d8 - d2;
        return new Pair(Double.valueOf(Math.sqrt((d16 * d16) + (d17 * d17))), new DPoint(d7, d8));
    }
}
