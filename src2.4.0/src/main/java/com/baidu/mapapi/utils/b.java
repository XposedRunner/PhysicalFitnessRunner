package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.AppTools;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.utils.poi.DispathcPoiData;
import com.baidu.mapapi.utils.poi.PoiParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption.EBusStrategyType;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.a;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static int a = -1;
    static ServiceConnection b = new d();
    private static final String c = "com.baidu.mapapi.utils.b";
    private static a d;
    private static IComOpenClient e;
    private static int f;
    private static String g;
    private static String h;
    private static String i;
    private static List<DispathcPoiData> j = new ArrayList();
    private static LatLng k;
    private static LatLng l;
    private static String m;
    private static String n;
    private static EBusStrategyType o;
    private static String p;
    private static String q;
    private static LatLng r;
    private static int s;
    private static boolean t;
    private static boolean u;
    private static Thread v;

    public static String a() {
        return AppTools.getBaiduMapToken();
    }

    public static void a(int i, Context context) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                c(context, i);
                break;
            case 3:
                c(context);
                return;
            case 4:
                d(context);
                return;
            case 5:
                e(context);
                return;
            case 6:
                break;
            case 7:
                f(context);
                return;
            case 8:
                g(context);
                return;
            case 9:
                h(context);
                return;
            default:
                return;
        }
    }

    public static void a(Context context) {
        if (u) {
            context.unbindService(b);
            u = false;
        }
    }

    private static void a(List<DispathcPoiData> list, Context context) {
        g = context.getPackageName();
        h = b(context);
        i = "";
        if (j != null) {
            j.clear();
        }
        for (DispathcPoiData add : list) {
            j.add(add);
        }
    }

    public static boolean a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                return g();
            case 3:
                return h();
            case 4:
                return m();
            case 5:
                return j();
            case 6:
                return i();
            case 7:
                return k();
            case 8:
                return l();
            default:
                return false;
        }
    }

    public static boolean a(Context context, int i) {
        try {
            if (com.baidu.platform.comapi.a.a.a(context)) {
                t = false;
                switch (i) {
                    case 0:
                        a = 0;
                        break;
                    case 1:
                        a = 1;
                        break;
                    case 2:
                        a = 2;
                        break;
                    case 3:
                        a = 3;
                        break;
                    case 4:
                        a = 4;
                        break;
                    case 5:
                        a = 5;
                        break;
                    case 6:
                        a = 6;
                        break;
                    case 7:
                        a = 7;
                        break;
                    case 8:
                        a = 8;
                        break;
                    case 9:
                        a = 9;
                        break;
                    default:
                        break;
                }
                if (i == 9) {
                    u = false;
                }
                if (d == null || !u) {
                    b(context, i);
                    return true;
                } else if (e != null) {
                    t = true;
                    return a(i);
                } else {
                    d.a(new c(i));
                    return true;
                }
            }
            Log.d(c, "package sign verify failed");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean a(NaviParaOption naviParaOption, Context context, int i) {
        b(naviParaOption, context, i);
        return a(context, i);
    }

    public static boolean a(PoiParaOption poiParaOption, Context context, int i) {
        b(poiParaOption, context, i);
        return a(context, i);
    }

    public static boolean a(RouteParaOption routeParaOption, Context context, int i) {
        b(routeParaOption, context, i);
        return a(context, i);
    }

    public static boolean a(List<DispathcPoiData> list, Context context, int i) {
        a((List) list, context);
        return a(context, i);
    }

    public static String b(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException unused) {
            }
        } catch (NameNotFoundException unused2) {
            packageManager = null;
            applicationInfo = null;
            return (String) packageManager.getApplicationLabel(applicationInfo);
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    private static void b(Context context, int i) {
        Intent intent = new Intent();
        String a = a();
        if (a != null) {
            intent.putExtra("api_token", a);
            intent.setAction("com.baidu.map.action.OPEN_SERVICE");
            intent.setPackage("com.baidu.BaiduMap");
            if (i != 9) {
                u = context.bindService(intent, b, 1);
            }
            if (u) {
                v = new Thread(new f(context, i));
                v.setDaemon(true);
                v.start();
                return;
            }
            Log.e("baidumapsdk", "bind service failed，call openapi");
            a(i, context);
        }
    }

    private static void b(NaviParaOption naviParaOption, Context context, int i) {
        g = context.getPackageName();
        m = null;
        k = null;
        n = null;
        l = null;
        if (naviParaOption.getStartPoint() != null) {
            k = naviParaOption.getStartPoint();
        }
        if (naviParaOption.getEndPoint() != null) {
            l = naviParaOption.getEndPoint();
        }
        if (naviParaOption.getStartName() != null) {
            m = naviParaOption.getStartName();
        }
        if (naviParaOption.getEndName() != null) {
            n = naviParaOption.getEndName();
        }
    }

    private static void b(PoiParaOption poiParaOption, Context context, int i) {
        p = null;
        q = null;
        r = null;
        s = 0;
        g = context.getPackageName();
        if (poiParaOption.getUid() != null) {
            p = poiParaOption.getUid();
        }
        if (poiParaOption.getKey() != null) {
            q = poiParaOption.getKey();
        }
        if (poiParaOption.getCenter() != null) {
            r = poiParaOption.getCenter();
        }
        if (poiParaOption.getRadius() != 0) {
            s = poiParaOption.getRadius();
        }
    }

    private static void b(RouteParaOption routeParaOption, Context context, int i) {
        int i2;
        m = null;
        k = null;
        n = null;
        l = null;
        g = context.getPackageName();
        if (routeParaOption.getStartPoint() != null) {
            k = routeParaOption.getStartPoint();
        }
        if (routeParaOption.getEndPoint() != null) {
            l = routeParaOption.getEndPoint();
        }
        if (routeParaOption.getStartName() != null) {
            m = routeParaOption.getStartName();
        }
        if (routeParaOption.getEndName() != null) {
            n = routeParaOption.getEndName();
        }
        if (routeParaOption.getBusStrategyType() != null) {
            o = routeParaOption.getBusStrategyType();
        }
        switch (i) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            default:
                return;
        }
        f = i2;
    }

    private static void c(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("baidumap://map/place/detail?");
        stringBuilder.append("uid=");
        stringBuilder.append(p);
        stringBuilder.append("&show_type=");
        stringBuilder.append("detail_page");
        stringBuilder.append("&src=");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("sdk_[");
        stringBuilder2.append(g);
        stringBuilder2.append("]");
        stringBuilder.append(stringBuilder2.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARNING: Missing block: B:18:0x007d, code skipped:
            if (k != null) goto L_0x0059;
     */
    /* JADX WARNING: Missing block: B:34:0x00d8, code skipped:
            if (l != null) goto L_0x00b4;
     */
    private static void c(android.content.Context r4, int r5) {
        /*
        r0 = v;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = v;
        r0.interrupt();
    L_0x0009:
        r0 = 3;
        r0 = new java.lang.String[r0];
        r1 = 0;
        r2 = "driving";
        r0[r1] = r2;
        r1 = 1;
        r2 = "transit";
        r0[r1] = r2;
        r1 = 2;
        r2 = "walking";
        r0[r1] = r2;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "baidumap://map/direction?";
        r1.append(r2);
        r2 = "origin=";
        r1.append(r2);
        r2 = k;
        if (r2 == 0) goto L_0x003e;
    L_0x002e:
        r2 = com.baidu.mapapi.SDKInitializer.getCoordType();
        r3 = com.baidu.mapapi.CoordType.GCJ02;
        if (r2 != r3) goto L_0x003e;
    L_0x0036:
        r2 = k;
        r2 = com.baidu.mapsdkplatform.comapi.util.CoordTrans.gcjToBaidu(r2);
        k = r2;
    L_0x003e:
        r2 = m;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x006d;
    L_0x0046:
        r2 = k;
        if (r2 == 0) goto L_0x006d;
    L_0x004a:
        r2 = "name:";
        r1.append(r2);
        r2 = m;
        r1.append(r2);
        r2 = "|latlng:";
        r1.append(r2);
    L_0x0059:
        r2 = k;
        r2 = r2.latitude;
        r1.append(r2);
        r2 = ",";
        r1.append(r2);
        r2 = k;
        r2 = r2.longitude;
        r1.append(r2);
        goto L_0x0080;
    L_0x006d:
        r2 = m;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x007b;
    L_0x0075:
        r2 = m;
        r1.append(r2);
        goto L_0x0080;
    L_0x007b:
        r2 = k;
        if (r2 == 0) goto L_0x0080;
    L_0x007f:
        goto L_0x0059;
    L_0x0080:
        r2 = "&destination=";
        r1.append(r2);
        r2 = l;
        if (r2 == 0) goto L_0x0099;
    L_0x0089:
        r2 = com.baidu.mapapi.SDKInitializer.getCoordType();
        r3 = com.baidu.mapapi.CoordType.GCJ02;
        if (r2 != r3) goto L_0x0099;
    L_0x0091:
        r2 = l;
        r2 = com.baidu.mapsdkplatform.comapi.util.CoordTrans.gcjToBaidu(r2);
        l = r2;
    L_0x0099:
        r2 = n;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x00c8;
    L_0x00a1:
        r2 = l;
        if (r2 == 0) goto L_0x00c8;
    L_0x00a5:
        r2 = "name:";
        r1.append(r2);
        r2 = n;
        r1.append(r2);
        r2 = "|latlng:";
        r1.append(r2);
    L_0x00b4:
        r2 = l;
        r2 = r2.latitude;
        r1.append(r2);
        r2 = ",";
        r1.append(r2);
        r2 = l;
        r2 = r2.longitude;
        r1.append(r2);
        goto L_0x00db;
    L_0x00c8:
        r2 = n;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x00d6;
    L_0x00d0:
        r2 = n;
        r1.append(r2);
        goto L_0x00db;
    L_0x00d6:
        r2 = l;
        if (r2 == 0) goto L_0x00db;
    L_0x00da:
        goto L_0x00b4;
    L_0x00db:
        r2 = "&mode=";
        r1.append(r2);
        r5 = r0[r5];
        r1.append(r5);
        r5 = "&target=";
        r1.append(r5);
        r5 = "1";
        r1.append(r5);
        r5 = "&src=";
        r1.append(r5);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = "sdk_[";
        r5.append(r0);
        r0 = g;
        r5.append(r0);
        r0 = "]";
        r5.append(r0);
        r5 = r5.toString();
        r1.append(r5);
        r5 = r1.toString();
        r5 = android.net.Uri.parse(r5);
        r0 = new android.content.Intent;
        r1 = "android.intent.action.VIEW";
        r0.<init>(r1, r5);
        r5 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r5);
        r4.startActivity(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.utils.b.c(android.content.Context, int):void");
    }

    private static void d(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("baidumap://map/nearbysearch?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            r = CoordTrans.gcjToBaidu(r);
        }
        stringBuilder.append("center=");
        stringBuilder.append(r.latitude);
        stringBuilder.append(",");
        stringBuilder.append(r.longitude);
        stringBuilder.append("&query=");
        stringBuilder.append(q);
        stringBuilder.append("&radius=");
        stringBuilder.append(s);
        stringBuilder.append("&src=");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("sdk_[");
        stringBuilder2.append(g);
        stringBuilder2.append("]");
        stringBuilder.append(stringBuilder2.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(intent);
    }

    private static void e(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("baidumap://map/navi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        stringBuilder.append("origin=");
        stringBuilder.append(k.latitude);
        stringBuilder.append(",");
        stringBuilder.append(k.longitude);
        stringBuilder.append("&location=");
        stringBuilder.append(l.latitude);
        stringBuilder.append(",");
        stringBuilder.append(l.longitude);
        stringBuilder.append("&src=");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("sdk_[");
        stringBuilder2.append(g);
        stringBuilder2.append("]");
        stringBuilder.append(stringBuilder2.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(intent);
    }

    private static void f(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        stringBuilder.append("origin=");
        stringBuilder.append(k.latitude);
        stringBuilder.append(",");
        stringBuilder.append(k.longitude);
        stringBuilder.append("&destination=");
        stringBuilder.append(l.latitude);
        stringBuilder.append(",");
        stringBuilder.append(l.longitude);
        stringBuilder.append("&src=");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("sdk_[");
        stringBuilder2.append(g);
        stringBuilder2.append("]");
        stringBuilder.append(stringBuilder2.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(intent);
    }

    private static void g(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("baidumap://map/bikenavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        stringBuilder.append("origin=");
        stringBuilder.append(k.latitude);
        stringBuilder.append(",");
        stringBuilder.append(k.longitude);
        stringBuilder.append("&destination=");
        stringBuilder.append(l.latitude);
        stringBuilder.append(",");
        stringBuilder.append(l.longitude);
        stringBuilder.append("&src=");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("sdk_[");
        stringBuilder2.append(g);
        stringBuilder2.append("]");
        stringBuilder.append(stringBuilder2.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(intent);
    }

    private static boolean g() {
        try {
            Log.d(c, "callDispatchTakeOutRoute");
            String a = e.a("map.android.baidu.mainmap");
            if (a != null) {
                String str;
                String str2;
                String str3;
                Bundle bundle = new Bundle();
                bundle.putString("target", "route_search_page");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("route_type", f);
                bundle2.putInt("bus_strategy", o.ordinal());
                bundle2.putInt("cross_city_bus_strategy", 5);
                if (k != null) {
                    bundle2.putInt("start_type", 1);
                    bundle2.putInt("start_longitude", (int) CoordUtil.ll2mc(k).getLongitudeE6());
                    bundle2.putInt("start_latitude", (int) CoordUtil.ll2mc(k).getLatitudeE6());
                } else {
                    bundle2.putInt("start_type", 2);
                    bundle2.putInt("start_longitude", 0);
                    bundle2.putInt("start_latitude", 0);
                }
                if (m != null) {
                    str = "start_keyword";
                    str2 = m;
                } else {
                    str = "start_keyword";
                    str2 = "地图上的点";
                }
                bundle2.putString(str, str2);
                bundle2.putString("start_uid", "");
                if (l != null) {
                    bundle2.putInt("end_type", 1);
                    bundle2.putInt("end_longitude", (int) CoordUtil.ll2mc(l).getLongitudeE6());
                    bundle2.putInt("end_latitude", (int) CoordUtil.ll2mc(l).getLatitudeE6());
                } else {
                    bundle2.putInt("end_type", 2);
                    bundle2.putInt("end_longitude", 0);
                    bundle2.putInt("end_latitude", 0);
                }
                if (n != null) {
                    str = "end_keyword";
                    str3 = n;
                } else {
                    str = "end_keyword";
                    str3 = "地图上的点";
                }
                bundle2.putString(str, str3);
                bundle2.putString("end_uid", "");
                bundle.putBundle("base_params", bundle2);
                bundle2 = new Bundle();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sdk_[");
                stringBuilder.append(g);
                stringBuilder.append("]");
                bundle2.putString("launch_from", stringBuilder.toString());
                bundle.putBundle("ext_params", bundle2);
                return e.a("map.android.baidu.mainmap", a, bundle);
            }
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e) {
            Log.d(c, "callDispatchTakeOut exception", e);
            return false;
        }
    }

    private static void h(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        stringBuilder.append("origin=");
        stringBuilder.append(k.latitude);
        stringBuilder.append(",");
        stringBuilder.append(k.longitude);
        stringBuilder.append("&destination=");
        stringBuilder.append(l.latitude);
        stringBuilder.append(",");
        stringBuilder.append(l.longitude);
        stringBuilder.append("&mode=");
        stringBuilder.append("walking_ar");
        stringBuilder.append("&src=");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("sdk_[");
        stringBuilder2.append(g);
        stringBuilder2.append("]");
        stringBuilder.append(stringBuilder2.toString());
        Log.e("test", stringBuilder.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(intent);
    }

    private static boolean h() {
        try {
            Log.d(c, "callDispatchTakeOutPoiDetials");
            String a = e.a("map.android.baidu.mainmap");
            if (a != null) {
                String str;
                String str2;
                Bundle bundle = new Bundle();
                bundle.putString("target", "request_poi_detail_page");
                Bundle bundle2 = new Bundle();
                if (p != null) {
                    str = Oauth2AccessToken.KEY_UID;
                    str2 = p;
                } else {
                    str = Oauth2AccessToken.KEY_UID;
                    str2 = "";
                }
                bundle2.putString(str, str2);
                bundle.putBundle("base_params", bundle2);
                bundle2 = new Bundle();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sdk_[");
                stringBuilder.append(g);
                stringBuilder.append("]");
                bundle2.putString("launch_from", stringBuilder.toString());
                bundle.putBundle("ext_params", bundle2);
                return e.a("map.android.baidu.mainmap", a, bundle);
            }
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e) {
            Log.d(c, "callDispatchTakeOut exception", e);
        }
    }

    private static boolean i() {
        if (j == null || j.size() <= 0) {
            return false;
        }
        try {
            Log.d(c, "callDispatchPoiToBaiduMap");
            String a = e.a("map.android.baidu.mainmap");
            if (a != null) {
                Bundle bundle = new Bundle();
                bundle.putString("target", "favorite_page");
                Bundle bundle2 = new Bundle();
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                int i2 = i;
                while (i < j.size()) {
                    if (!(((DispathcPoiData) j.get(i)).name == null || ((DispathcPoiData) j.get(i)).name.equals(""))) {
                        if (((DispathcPoiData) j.get(i)).pt != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("name", ((DispathcPoiData) j.get(i)).name);
                                GeoPoint ll2mc = CoordUtil.ll2mc(((DispathcPoiData) j.get(i)).pt);
                                jSONObject.put("ptx", ll2mc.getLongitudeE6());
                                jSONObject.put("pty", ll2mc.getLatitudeE6());
                                jSONObject.put("addr", ((DispathcPoiData) j.get(i)).addr);
                                jSONObject.put(Oauth2AccessToken.KEY_UID, ((DispathcPoiData) j.get(i)).uid);
                                i2++;
                                jSONArray.put(jSONObject);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    i++;
                }
                if (i2 == 0) {
                    return false;
                }
                bundle2.putString("data", jSONArray.toString());
                bundle2.putString("from", h);
                bundle2.putString("pkg", g);
                bundle2.putString("cls", i);
                bundle2.putInt("count", i2);
                bundle.putBundle("base_params", bundle2);
                bundle2 = new Bundle();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sdk_[");
                stringBuilder.append(g);
                stringBuilder.append("]");
                bundle2.putString("launch_from", stringBuilder.toString());
                bundle.putBundle("ext_params", bundle2);
                return e.a("map.android.baidu.mainmap", a, bundle);
            }
            Log.d(c, "callDispatchPoiToBaiduMap com not found");
            return false;
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchPoiToBaiduMap exception", e2);
            return false;
        }
    }

    private static boolean j() {
        try {
            Log.d(c, "callDispatchTakeOutRouteNavi");
            String a = e.a("map.android.baidu.mainmap");
            if (a != null) {
                StringBuilder stringBuilder;
                Bundle bundle = new Bundle();
                bundle.putString("target", "navigation_page");
                Bundle bundle2 = new Bundle();
                bundle2.putString("coord_type", "bd09ll");
                bundle2.putString("type", "DIS");
                StringBuffer stringBuffer = new StringBuffer();
                if (m != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("name:");
                    stringBuilder.append(m);
                    stringBuilder.append("|");
                    stringBuffer.append(stringBuilder.toString());
                }
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    k = CoordTrans.gcjToBaidu(k);
                }
                stringBuffer.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(k.latitude), Double.valueOf(k.longitude)}));
                StringBuffer stringBuffer2 = new StringBuffer();
                if (n != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("name:");
                    stringBuilder2.append(n);
                    stringBuilder2.append("|");
                    stringBuffer2.append(stringBuilder2.toString());
                }
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    l = CoordTrans.gcjToBaidu(l);
                }
                stringBuffer2.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(l.latitude), Double.valueOf(l.longitude)}));
                bundle2.putString("origin", stringBuffer.toString());
                bundle2.putString("destination", stringBuffer2.toString());
                bundle.putBundle("base_params", bundle2);
                bundle2 = new Bundle();
                stringBuilder = new StringBuilder();
                stringBuilder.append("sdk_[");
                stringBuilder.append(g);
                stringBuilder.append("]");
                bundle2.putString("launch_from", stringBuilder.toString());
                bundle.putBundle("ext_params", bundle2);
                return e.a("map.android.baidu.mainmap", a, bundle);
            }
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e) {
            Log.d(c, "callDispatchTakeOut exception", e);
            return false;
        }
    }

    private static boolean k() {
        try {
            Log.d(c, "callDispatchTakeOutRouteNavi");
            String a = e.a("map.android.baidu.mainmap");
            if (a != null) {
                StringBuilder stringBuilder;
                Bundle bundle = new Bundle();
                bundle.putString("target", "walknavi_page");
                Bundle bundle2 = new Bundle();
                bundle2.putString("coord_type", "bd09ll");
                StringBuffer stringBuffer = new StringBuffer();
                if (m != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("name:");
                    stringBuilder.append(m);
                    stringBuilder.append("|");
                    stringBuffer.append(stringBuilder.toString());
                }
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    k = CoordTrans.gcjToBaidu(k);
                }
                stringBuffer.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(k.latitude), Double.valueOf(k.longitude)}));
                StringBuffer stringBuffer2 = new StringBuffer();
                if (n != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("name:");
                    stringBuilder2.append(n);
                    stringBuilder2.append("|");
                    stringBuffer2.append(stringBuilder2.toString());
                }
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    l = CoordTrans.gcjToBaidu(l);
                }
                stringBuffer2.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(l.latitude), Double.valueOf(l.longitude)}));
                bundle2.putString("origin", stringBuffer.toString());
                bundle2.putString("destination", stringBuffer2.toString());
                bundle.putBundle("base_params", bundle2);
                bundle2 = new Bundle();
                stringBuilder = new StringBuilder();
                stringBuilder.append("sdk_[");
                stringBuilder.append(g);
                stringBuilder.append("]");
                bundle2.putString("launch_from", stringBuilder.toString());
                bundle.putBundle("ext_params", bundle2);
                return e.a("map.android.baidu.mainmap", a, bundle);
            }
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        } catch (Exception e) {
            Log.d(c, "callDispatchTakeOut exception", e);
            return false;
        }
    }

    private static boolean l() {
        try {
            Log.d(c, "callDispatchTakeOutRouteRidingNavi");
            String a = e.a("map.android.baidu.mainmap");
            if (a != null) {
                StringBuilder stringBuilder;
                Bundle bundle = new Bundle();
                bundle.putString("target", "bikenavi_page");
                Bundle bundle2 = new Bundle();
                bundle2.putString("coord_type", "bd09ll");
                StringBuffer stringBuffer = new StringBuffer();
                if (m != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("name:");
                    stringBuilder.append(m);
                    stringBuilder.append("|");
                    stringBuffer.append(stringBuilder.toString());
                }
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    k = CoordTrans.gcjToBaidu(k);
                }
                stringBuffer.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(k.latitude), Double.valueOf(k.longitude)}));
                StringBuffer stringBuffer2 = new StringBuffer();
                if (n != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("name:");
                    stringBuilder2.append(n);
                    stringBuilder2.append("|");
                    stringBuffer2.append(stringBuilder2.toString());
                }
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    l = CoordTrans.gcjToBaidu(l);
                }
                stringBuffer2.append(String.format("latlng:%f,%f", new Object[]{Double.valueOf(l.latitude), Double.valueOf(l.longitude)}));
                bundle2.putString("origin", stringBuffer.toString());
                bundle2.putString("destination", stringBuffer2.toString());
                bundle.putBundle("base_params", bundle2);
                bundle2 = new Bundle();
                stringBuilder = new StringBuilder();
                stringBuilder.append("sdk_[");
                stringBuilder.append(g);
                stringBuilder.append("]");
                bundle2.putString("launch_from", stringBuilder.toString());
                bundle.putBundle("ext_params", bundle2);
                return e.a("map.android.baidu.mainmap", a, bundle);
            }
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e) {
            Log.d(c, "callDispatchTakeOut exception", e);
            return false;
        }
    }

    private static boolean m() {
        try {
            Log.d(c, "callDispatchTakeOutPoiNearbySearch");
            String a = e.a("map.android.baidu.mainmap");
            if (a != null) {
                String str;
                String str2;
                Bundle bundle = new Bundle();
                bundle.putString("target", "poi_search_page");
                Bundle bundle2 = new Bundle();
                if (q != null) {
                    str = "search_key";
                    str2 = q;
                } else {
                    str = "search_key";
                    str2 = "";
                }
                bundle2.putString(str, str2);
                if (r != null) {
                    bundle2.putInt("center_pt_x", (int) CoordUtil.ll2mc(r).getLongitudeE6());
                    bundle2.putInt("center_pt_y", (int) CoordUtil.ll2mc(r).getLatitudeE6());
                } else {
                    bundle2.putString("search_key", "");
                }
                if (s != 0) {
                    bundle2.putInt("search_radius", s);
                } else {
                    bundle2.putInt("search_radius", 1000);
                }
                bundle2.putBoolean("is_direct_search", true);
                bundle2.putBoolean("is_direct_area_search", true);
                bundle.putBundle("base_params", bundle2);
                bundle2 = new Bundle();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sdk_[");
                stringBuilder.append(g);
                stringBuilder.append("]");
                bundle2.putString("launch_from", stringBuilder.toString());
                bundle.putBundle("ext_params", bundle2);
                return e.a("map.android.baidu.mainmap", a, bundle);
            }
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e) {
            Log.d(c, "callDispatchTakeOut exception", e);
        }
    }
}
