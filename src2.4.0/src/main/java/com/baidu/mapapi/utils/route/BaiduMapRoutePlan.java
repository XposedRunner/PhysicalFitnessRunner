package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.navi.IllegalNaviArgumentException;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.b;
import com.baidu.mapapi.utils.poi.IllegalPoiSearchArgumentException;
import com.baidu.mapapi.utils.route.RouteParaOption.EBusStrategyType;

public class BaiduMapRoutePlan {
    private static boolean a = true;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e9  */
    private static void a(com.baidu.mapapi.utils.route.RouteParaOption r4, android.content.Context r5, int r6) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "http://api.map.baidu.com/direction?";
        r0.append(r1);
        r1 = "origin=";
        r0.append(r1);
        r1 = r4.a;
        r2 = com.baidu.mapapi.SDKInitializer.getCoordType();
        r3 = com.baidu.mapapi.CoordType.GCJ02;
        if (r2 != r3) goto L_0x001f;
    L_0x0019:
        if (r1 == 0) goto L_0x001f;
    L_0x001b:
        r1 = com.baidu.mapsdkplatform.comapi.util.CoordTrans.gcjToBaidu(r1);
    L_0x001f:
        r2 = r4.a;
        if (r2 == 0) goto L_0x0050;
    L_0x0023:
        r2 = r4.c;
        if (r2 == 0) goto L_0x0050;
    L_0x0027:
        r2 = r4.c;
        r3 = "";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0050;
    L_0x0031:
        r2 = "latlng:";
        r0.append(r2);
        r2 = r1.latitude;
        r0.append(r2);
        r2 = ",";
        r0.append(r2);
        r1 = r1.longitude;
        r0.append(r1);
        r1 = "|";
        r0.append(r1);
        r1 = "name:";
        r0.append(r1);
        goto L_0x0064;
    L_0x0050:
        r2 = r4.a;
        if (r2 == 0) goto L_0x0064;
    L_0x0054:
        r2 = r1.latitude;
        r0.append(r2);
        r2 = ",";
        r0.append(r2);
        r1 = r1.longitude;
        r0.append(r1);
        goto L_0x0069;
    L_0x0064:
        r1 = r4.c;
        r0.append(r1);
    L_0x0069:
        r1 = r4.b;
        r2 = com.baidu.mapapi.SDKInitializer.getCoordType();
        r3 = com.baidu.mapapi.CoordType.GCJ02;
        if (r2 != r3) goto L_0x0079;
    L_0x0073:
        if (r1 == 0) goto L_0x0079;
    L_0x0075:
        r1 = com.baidu.mapsdkplatform.comapi.util.CoordTrans.gcjToBaidu(r1);
    L_0x0079:
        r2 = "&destination=";
        r0.append(r2);
        r2 = r4.b;
        if (r2 == 0) goto L_0x00af;
    L_0x0082:
        r2 = r4.d;
        if (r2 == 0) goto L_0x00af;
    L_0x0086:
        r2 = r4.d;
        r3 = "";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x00af;
    L_0x0090:
        r2 = "latlng:";
        r0.append(r2);
        r2 = r1.latitude;
        r0.append(r2);
        r2 = ",";
        r0.append(r2);
        r1 = r1.longitude;
        r0.append(r1);
        r1 = "|";
        r0.append(r1);
        r1 = "name:";
        r0.append(r1);
        goto L_0x00c3;
    L_0x00af:
        r2 = r4.b;
        if (r2 == 0) goto L_0x00c3;
    L_0x00b3:
        r2 = r1.latitude;
        r0.append(r2);
        r2 = ",";
        r0.append(r2);
        r1 = r1.longitude;
        r0.append(r1);
        goto L_0x00c8;
    L_0x00c3:
        r1 = r4.d;
        r0.append(r1);
    L_0x00c8:
        r1 = "";
        switch(r6) {
            case 0: goto L_0x00d4;
            case 1: goto L_0x00d1;
            case 2: goto L_0x00ce;
            default: goto L_0x00cd;
        };
    L_0x00cd:
        goto L_0x00d6;
    L_0x00ce:
        r1 = "walking";
        goto L_0x00d6;
    L_0x00d1:
        r1 = "transit";
        goto L_0x00d6;
    L_0x00d4:
        r1 = "driving";
    L_0x00d6:
        r6 = "&mode=";
        r0.append(r6);
        r0.append(r1);
        r6 = "&region=";
        r0.append(r6);
        r6 = r4.getCityName();
        if (r6 == 0) goto L_0x00fb;
    L_0x00e9:
        r6 = r4.getCityName();
        r1 = "";
        r6 = r6.equals(r1);
        if (r6 == 0) goto L_0x00f6;
    L_0x00f5:
        goto L_0x00fb;
    L_0x00f6:
        r4 = r4.getCityName();
        goto L_0x00fd;
    L_0x00fb:
        r4 = "全国";
    L_0x00fd:
        r0.append(r4);
        r4 = "&output=html";
        r0.append(r4);
        r4 = "&src=";
        r0.append(r4);
        r4 = r5.getPackageName();
        r0.append(r4);
        r4 = r0.toString();
        r4 = android.net.Uri.parse(r4);
        r6 = new android.content.Intent;
        r6.<init>();
        r0 = "android.intent.action.VIEW";
        r6.setAction(r0);
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r6.setFlags(r0);
        r6.setData(r4);
        r5.startActivity(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.utils.route.BaiduMapRoutePlan.a(com.baidu.mapapi.utils.route.RouteParaOption, android.content.Context, int):void");
    }

    public static void finish(Context context) {
        if (context != null) {
            b.a(context);
        }
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        } else if (routeParaOption.b == null && routeParaOption.a == null && routeParaOption.d == null && routeParaOption.c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        } else if (routeParaOption.c == null && routeParaOption.a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        } else if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        } else if (((routeParaOption.c == null || routeParaOption.c.equals("")) && routeParaOption.a == null) || ((routeParaOption.d == null || routeParaOption.d.equals("")) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        } else {
            if (routeParaOption.f == null) {
                routeParaOption.f = EBusStrategyType.bus_recommend_way;
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(routeParaOption, context, 0);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return b.a(routeParaOption, context, 0);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (a) {
                    a(routeParaOption, context, 0);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        } else if (routeParaOption.b == null && routeParaOption.a == null && routeParaOption.d == null && routeParaOption.c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        } else if (routeParaOption.c == null && routeParaOption.a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        } else if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        } else if (((routeParaOption.c == null || routeParaOption.c.equals("")) && routeParaOption.a == null) || ((routeParaOption.d == null || routeParaOption.d.equals("")) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        } else {
            if (routeParaOption.f == null) {
                routeParaOption.f = EBusStrategyType.bus_recommend_way;
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(routeParaOption, context, 1);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return b.a(routeParaOption, context, 1);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (a) {
                    a(routeParaOption, context, 1);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        } else if (routeParaOption.b == null && routeParaOption.a == null && routeParaOption.d == null && routeParaOption.c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        } else if (routeParaOption.c == null && routeParaOption.a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        } else if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        } else if (((routeParaOption.c == null || routeParaOption.c.equals("")) && routeParaOption.a == null) || ((routeParaOption.d == null || routeParaOption.d.equals("")) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        } else {
            if (routeParaOption.f == null) {
                routeParaOption.f = EBusStrategyType.bus_recommend_way;
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(routeParaOption, context, 2);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return b.a(routeParaOption, context, 2);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (a) {
                    a(routeParaOption, context, 2);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
    }

    public static void setSupportWebRoute(boolean z) {
        a = z;
    }
}
