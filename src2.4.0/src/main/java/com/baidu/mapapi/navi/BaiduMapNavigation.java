package com.baidu.mapapi.navi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduMapNavigation {
    private static boolean a = true;

    private static String a(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
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

    private static void a(NaviParaOption naviParaOption, Context context) throws IllegalNaviArgumentException {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("para or context can not be null.");
        } else if (naviParaOption.a == null || naviParaOption.c == null) {
            throw new IllegalNaviArgumentException("you must set start and end point.");
        } else {
            GeoPoint ll2mc = CoordUtil.ll2mc(naviParaOption.a);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(naviParaOption.c);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://app.navi.baidu.com/mobile/#navi/naving/");
            stringBuilder.append("&sy=0");
            stringBuilder.append("&endp=");
            stringBuilder.append("&start=");
            stringBuilder.append("&startwd=");
            stringBuilder.append("&endwd=");
            stringBuilder.append("&fromprod=map_sdk");
            stringBuilder.append("&app_version=");
            stringBuilder.append(VersionInfo.VERSION_INFO);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                String str;
                Object obj;
                jSONObject.put("type", "1");
                if (naviParaOption.b == null || naviParaOption.b.equals("")) {
                    str = "keyword";
                    obj = "";
                } else {
                    str = "keyword";
                    obj = naviParaOption.b;
                }
                jSONObject.put(str, obj);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(String.valueOf(ll2mc.getLongitudeE6()));
                stringBuilder2.append(",");
                stringBuilder2.append(String.valueOf(ll2mc.getLatitudeE6()));
                jSONObject.put("xy", stringBuilder2.toString());
                jSONArray.put(jSONObject);
                jSONObject2.put("type", "1");
                if (naviParaOption.d == null || naviParaOption.d.equals("")) {
                    jSONObject.put("keyword", "");
                } else {
                    jSONObject.put("keyword", naviParaOption.d);
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(String.valueOf(ll2mc2.getLongitudeE6()));
                stringBuilder3.append(",");
                stringBuilder3.append(String.valueOf(ll2mc2.getLatitudeE6()));
                jSONObject2.put("xy", stringBuilder3.toString());
                jSONArray.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONArray.length() > 0) {
                stringBuilder.append("&positions=");
                stringBuilder.append(jSONArray.toString());
            }
            stringBuilder.append("&ctrl_type=");
            stringBuilder.append("&mrsl=");
            stringBuilder.append("/vt=map&state=entry");
            Uri parse = Uri.parse(stringBuilder.toString());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
            intent.setData(parse);
            context.startActivity(intent);
        }
    }

    public static void finish(Context context) {
        if (context != null) {
            b.a(context);
        }
    }

    public static boolean openBaiduMapBikeNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("para or context can not be null.");
        } else if (naviParaOption.c == null || naviParaOption.a == null) {
            throw new IllegalNaviArgumentException("start point or end point can not be null.");
        } else {
            String str;
            String str2;
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                str = "baidumapsdk";
                str2 = "BaiduMap app is not installed.";
            } else if (baiduMapVersion >= 869) {
                return b.a(naviParaOption, context, 8);
            } else {
                str = "baidumapsdk";
                str2 = "Baidumap app version is too lowl.Version is greater than 8.6.6";
            }
            Log.e(str, str2);
            return false;
        }
    }

    public static boolean openBaiduMapNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("para or context can not be null.");
        } else if (naviParaOption.c == null || naviParaOption.a == null) {
            throw new IllegalNaviArgumentException("start point or end point can not be null.");
        } else {
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(naviParaOption, context);
                    return true;
                }
                throw new BaiduMapAppNotSupportNaviException("BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 830) {
                return b.a(naviParaOption, context, 5);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.2");
                if (a) {
                    a(naviParaOption, context);
                    return true;
                }
                throw new BaiduMapAppNotSupportNaviException("Baidumap app version is too lowl.Version is greater than 8.2");
            }
        }
    }

    public static boolean openBaiduMapWalkNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("para or context can not be null.");
        } else if (naviParaOption.c == null || naviParaOption.a == null) {
            throw new IllegalNaviArgumentException("start point or end point can not be null.");
        } else {
            String str;
            String str2;
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                str = "baidumapsdk";
                str2 = "BaiduMap app is not installed.";
            } else if (baiduMapVersion >= 869) {
                return b.a(naviParaOption, context, 7);
            } else {
                str = "baidumapsdk";
                str2 = "Baidumap app version is too lowl.Version is greater than 8.6.6";
            }
            Log.e(str, str2);
            return false;
        }
    }

    public static boolean openBaiduMapWalkNaviAR(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("para or context can not be null.");
        } else if (naviParaOption.c == null || naviParaOption.a == null) {
            throw new IllegalNaviArgumentException("start point or end point can not be null.");
        } else {
            String str;
            String str2;
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                str = "baidumapsdk";
                str2 = "BaiduMap app is not installed.";
            } else if (baiduMapVersion >= 869) {
                return b.a(naviParaOption, context, 9);
            } else {
                str = "baidumapsdk";
                str2 = "Baidumap app version is too lowl.Version is greater than 8.6.6";
            }
            Log.e(str, str2);
            return false;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:19:0x00d2 in {2, 7, 9, 18, 21, 23} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    @java.lang.Deprecated
    public static void openWebBaiduMapNavi(com.baidu.mapapi.navi.NaviParaOption r4, android.content.Context r5) throws com.baidu.mapapi.navi.IllegalNaviArgumentException {
        /*
        if (r4 == 0) goto L_0x00db;
        if (r5 != 0) goto L_0x0006;
        goto L_0x00db;
        r0 = r4.a;
        if (r0 == 0) goto L_0x007e;
        r0 = r4.c;
        if (r0 == 0) goto L_0x007e;
        r0 = r4.a;
        r0 = com.baidu.mapapi.model.CoordUtil.ll2mc(r0);
        r4 = r4.c;
        r4 = com.baidu.mapapi.model.CoordUtil.ll2mc(r4);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "http://daohang.map.baidu.com/mobile/#navi/naving/start=";
        r1.append(r2);
        r2 = r0.getLongitudeE6();
        r1.append(r2);
        r2 = ",";
        r1.append(r2);
        r2 = r0.getLatitudeE6();
        r1.append(r2);
        r0 = "&endp=";
        r1.append(r0);
        r2 = r4.getLongitudeE6();
        r1.append(r2);
        r0 = ",";
        r1.append(r0);
        r2 = r4.getLatitudeE6();
        r1.append(r2);
        r4 = "&fromprod=";
        r1.append(r4);
        r4 = a(r5);
        r1.append(r4);
        r4 = "/vt=map&state=entry";
        r1.append(r4);
        r4 = r1.toString();
        r4 = android.net.Uri.parse(r4);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "android.intent.action.VIEW";
        r0.setAction(r1);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r1);
        r0.setData(r4);
        r5.startActivity(r0);
        return;
        r0 = r4.b;
        if (r0 == 0) goto L_0x00d3;
        r0 = r4.b;
        r1 = "";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x00d3;
        r0 = r4.d;
        if (r0 == 0) goto L_0x00d3;
        r0 = r4.d;
        r1 = "";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x00d3;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "http://daohang.map.baidu.com/mobile/#search/search/qt=nav&sn=2$$$$$$";
        r0.append(r1);
        r1 = r4.b;
        r0.append(r1);
        r1 = "$$$$$$&en=2$$$$$$";
        r0.append(r1);
        r4 = r4.d;
        r0.append(r4);
        r4 = "$$$$$$&fromprod=";
        r0.append(r4);
        r4 = a(r5);
        r0.append(r4);
        r4 = r0.toString();
        r4 = android.net.Uri.parse(r4);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "android.intent.action.VIEW";
        r0.setAction(r1);
        goto L_0x0077;
        return;
        r4 = new com.baidu.mapapi.navi.IllegalNaviArgumentException;
        r5 = "you must set start and end point or set the start and end name.";
        r4.<init>(r5);
        throw r4;
        r4 = new com.baidu.mapapi.navi.IllegalNaviArgumentException;
        r5 = "para or context can not be null.";
        r4.<init>(r5);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.navi.BaiduMapNavigation.openWebBaiduMapNavi(com.baidu.mapapi.navi.NaviParaOption, android.content.Context):void");
    }

    public static void setSupportWebNavi(boolean z) {
        a = z;
    }
}
