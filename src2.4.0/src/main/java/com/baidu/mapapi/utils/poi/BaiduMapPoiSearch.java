package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.b;
import com.baidu.mapapi.utils.route.BaiduMapRoutePlan;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.pano.a;
import java.util.List;

public class BaiduMapPoiSearch {
    private static boolean a = true;

    private static void a(PoiParaOption poiParaOption, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://api.map.baidu.com/place/detail?");
        stringBuilder.append("uid=");
        stringBuilder.append(poiParaOption.a);
        stringBuilder.append("&output=html");
        stringBuilder.append("&src=");
        stringBuilder.append(context.getPackageName());
        Uri parse = Uri.parse(stringBuilder.toString());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.setData(parse);
        context.startActivity(intent);
    }

    private static void b(PoiParaOption poiParaOption, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://api.map.baidu.com/place/search?");
        stringBuilder.append("query=");
        stringBuilder.append(poiParaOption.b);
        stringBuilder.append("&location=");
        LatLng latLng = poiParaOption.c;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            latLng = CoordTrans.gcjToBaidu(latLng);
        }
        stringBuilder.append(latLng.latitude);
        stringBuilder.append(",");
        stringBuilder.append(latLng.longitude);
        stringBuilder.append("&radius=");
        stringBuilder.append(poiParaOption.d);
        stringBuilder.append("&output=html");
        stringBuilder.append("&src=");
        stringBuilder.append(context.getPackageName());
        Uri parse = Uri.parse(stringBuilder.toString());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.setData(parse);
        context.startActivity(intent);
    }

    private static void b(String str, Context context) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("pano id can not be null.");
        } else if (context == null) {
            throw new RuntimeException("context cannot be null.");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("baidumap://map/streetscape?");
            stringBuilder.append("panoid=");
            stringBuilder.append(str);
            stringBuilder.append("&pid=");
            stringBuilder.append(str);
            stringBuilder.append("&panotype=");
            stringBuilder.append("street");
            stringBuilder.append("&src=");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("sdk_[");
            stringBuilder2.append(context.getPackageName());
            stringBuilder2.append("]");
            stringBuilder.append(stringBuilder2.toString());
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
            intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
            if (intent == null || intent.resolveActivity(context.getPackageManager()) == null) {
                throw new RuntimeException("BaiduMap app is not installed.");
            }
            context.startActivity(intent);
        }
    }

    public static boolean dispatchPoiToBaiduMap(List<DispathcPoiData> list, Context context) throws Exception {
        if (list.isEmpty() || list.size() <= 0) {
            throw new NullPointerException("dispatch poidata is null");
        }
        String str;
        String str2;
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            str = "baidumapsdk";
            str2 = "BaiduMap app is not installed.";
        } else if (baiduMapVersion >= 840) {
            return b.a((List) list, context, 6);
        } else {
            str = "baidumapsdk";
            str2 = "Baidumap app version is too lowl.Version is greater than 8.4";
        }
        Log.e(str, str2);
        return false;
    }

    public static void finish(Context context) {
        if (context != null) {
            b.a(context);
        }
    }

    public static void openBaiduMapPanoShow(String str, Context context) {
        new a().a(str, new a(context));
    }

    public static boolean openBaiduMapPoiDetialsPage(PoiParaOption poiParaOption, Context context) {
        if (poiParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        } else if (poiParaOption.a == null) {
            throw new IllegalPoiSearchArgumentException("poi uid can not be null.");
        } else if (poiParaOption.a.equals("")) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi uid can not be empty string");
            return false;
        } else {
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(poiParaOption, context);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return b.a(poiParaOption, context, 3);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (a) {
                    a(poiParaOption, context);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
    }

    public static boolean openBaiduMapPoiNearbySearch(PoiParaOption poiParaOption, Context context) {
        if (poiParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        } else if (poiParaOption.b == null) {
            throw new IllegalPoiSearchArgumentException("poi search key can not be null.");
        } else if (poiParaOption.c == null) {
            throw new IllegalPoiSearchArgumentException("poi search center can not be null.");
        } else if (poiParaOption.c.longitude == 0.0d || poiParaOption.c.latitude == 0.0d) {
            throw new IllegalPoiSearchArgumentException("poi search center longitude or latitude can not be 0.");
        } else if (poiParaOption.d == 0) {
            throw new IllegalPoiSearchArgumentException("poi search radius larger than 0.");
        } else if (poiParaOption.b.equals("")) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi key can not be empty string");
            return false;
        } else {
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    b(poiParaOption, context);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return b.a(poiParaOption, context, 4);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (a) {
                    b(poiParaOption, context);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
    }

    public static void setSupportWebPoi(boolean z) {
        a = z;
    }
}
