package com.loc;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.MyLocationStyle;
import org.json.JSONObject;

/* compiled from: H5LocationClient */
public final class OO00O0o {
    Object O000000o = new Object();
    AMapLocationClientOption O00000Oo = null;
    private Context O00000o;
    O000000o O00000o0 = null;
    private AMapLocationClient O00000oO = null;
    private WebView O00000oo = null;
    private String O0000O0o = "AMap.Geolocation.cbk";
    private volatile boolean O0000OOo = false;

    /* compiled from: H5LocationClient */
    class O000000o implements AMapLocationListener {
        O000000o() {
        }

        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (OO00O0o.this.O0000OOo) {
                OO00O0o oO00O0o = OO00O0o.this;
                OO00O0o oO00O0o2 = OO00O0o.this;
                OO00O0o.O000000o(oO00O0o, OO00O0o.O00000Oo(aMapLocation));
            }
        }
    }

    public OO00O0o(Context context, WebView webView) {
        this.O00000o = context.getApplicationContext();
        this.O00000oo = webView;
        this.O00000o0 = new O000000o();
    }

    static /* synthetic */ void O000000o(OO00O0o oO00O0o, final String str) {
        try {
            if (oO00O0o.O00000oo != null) {
                if (VERSION.SDK_INT >= 19) {
                    WebView webView = oO00O0o.O00000oo;
                    StringBuilder stringBuilder = new StringBuilder("javascript:");
                    stringBuilder.append(oO00O0o.O0000O0o);
                    stringBuilder.append("('");
                    stringBuilder.append(str);
                    stringBuilder.append("')");
                    webView.evaluateJavascript(stringBuilder.toString(), new ValueCallback<String>() {
                        public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        }
                    });
                    return;
                }
                oO00O0o.O00000oo.post(new Runnable() {
                    public final void run() {
                        WebView O00000Oo = OO00O0o.this.O00000oo;
                        StringBuilder stringBuilder = new StringBuilder("javascript:");
                        stringBuilder.append(OO00O0o.this.O0000O0o);
                        stringBuilder.append("('");
                        stringBuilder.append(str);
                        stringBuilder.append("')");
                        O00000Oo.loadUrl(stringBuilder.toString());
                    }
                });
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "H5LocationClient", "callbackJs()");
        }
    }

    private static String O00000Oo(AMapLocation aMapLocation) {
        String str;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        if (aMapLocation == null) {
            try {
                jSONObject.put("errorCode", -1);
                str = MyLocationStyle.ERROR_INFO;
                obj = "unknownError";
            } catch (Throwable unused) {
            }
        } else if (aMapLocation.getErrorCode() == 0) {
            jSONObject.put("errorCode", 0);
            obj = new JSONObject();
            obj.put("x", aMapLocation.getLongitude());
            obj.put("y", aMapLocation.getLatitude());
            obj.put("precision", (double) aMapLocation.getAccuracy());
            obj.put("type", aMapLocation.getLocationType());
            obj.put("country", aMapLocation.getCountry());
            obj.put("province", aMapLocation.getProvince());
            obj.put("city", aMapLocation.getCity());
            obj.put("cityCode", aMapLocation.getCityCode());
            obj.put("district", aMapLocation.getDistrict());
            obj.put("adCode", aMapLocation.getAdCode());
            obj.put("street", aMapLocation.getStreet());
            obj.put("streetNum", aMapLocation.getStreetNum());
            obj.put("floor", aMapLocation.getFloor());
            obj.put("address", aMapLocation.getAddress());
            str = "result";
        } else {
            jSONObject.put("errorCode", aMapLocation.getErrorCode());
            jSONObject.put(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
            jSONObject.put("locationDetail", aMapLocation.getLocationDetail());
            return jSONObject.toString();
        }
        jSONObject.put(str, obj);
        return jSONObject.toString();
    }

    public final void O000000o() {
        if (this.O00000oo != null && this.O00000o != null && VERSION.SDK_INT >= 17 && !this.O0000OOo) {
            try {
                this.O00000oo.getSettings().setJavaScriptEnabled(true);
                this.O00000oo.addJavascriptInterface(this, "AMapAndroidLoc");
                if (!TextUtils.isEmpty(this.O00000oo.getUrl())) {
                    this.O00000oo.reload();
                }
                if (this.O00000oO == null) {
                    this.O00000oO = new AMapLocationClient(this.O00000o);
                    this.O00000oO.setLocationListener(this.O00000o0);
                }
                this.O0000OOo = true;
            } catch (Throwable unused) {
            }
        }
    }

    public final void O00000Oo() {
        synchronized (this.O000000o) {
            this.O0000OOo = false;
            if (this.O00000oO != null) {
                this.O00000oO.unRegisterLocationListener(this.O00000o0);
                this.O00000oO.stopLocation();
                this.O00000oO.onDestroy();
                this.O00000oO = null;
            }
            this.O00000Oo = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0066 A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005e A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074 A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005e A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0066 A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074 A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0057 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0066 A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005e A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074 A:{Catch:{ Throwable -> 0x007c }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:7|(1:9)|10|(13:11|12|13|14|(1:16)(1:17)|18|19|(1:21)|22|23|24|(1:27)|26)|34|35|(1:37)(1:39)|38|40|(1:42)|43|44|(1:46)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:7|(1:9)|10|(13:11|12|13|14|(1:16)(1:17)|18|19|(1:21)|22|23|24|(1:27)|26)|34|35|(1:37)(1:39)|38|40|(1:42)|43|44|(1:46)) */
    @android.webkit.JavascriptInterface
    public final void getLocation(java.lang.String r9) {
        /*
        r8 = this;
        r0 = r8.O000000o;
        monitor-enter(r0);
        r1 = r8.O0000OOo;	 Catch:{ all -> 0x0093 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x0093 }
        return;
    L_0x0009:
        r1 = r8.O00000Oo;	 Catch:{ all -> 0x0093 }
        if (r1 != 0) goto L_0x0014;
    L_0x000d:
        r1 = new com.amap.api.location.AMapLocationClientOption;	 Catch:{ all -> 0x0093 }
        r1.<init>();	 Catch:{ all -> 0x0093 }
        r8.O00000Oo = r1;	 Catch:{ all -> 0x0093 }
    L_0x0014:
        r1 = 5;
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r4 = 0;
        r5 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0054 }
        r5.<init>(r9);	 Catch:{ Throwable -> 0x0054 }
        r9 = "to";
        r6 = r5.optLong(r9, r2);	 Catch:{ Throwable -> 0x0054 }
        r9 = "useGPS";
        r2 = 1;
        r9 = r5.optInt(r9, r2);	 Catch:{ Throwable -> 0x0051 }
        if (r9 != r2) goto L_0x002e;
    L_0x002c:
        r9 = r2;
        goto L_0x002f;
    L_0x002e:
        r9 = r4;
    L_0x002f:
        r3 = "watch";
        r3 = r5.optInt(r3, r4);	 Catch:{ Throwable -> 0x0056 }
        if (r3 != r2) goto L_0x0038;
    L_0x0037:
        r4 = r2;
    L_0x0038:
        r2 = "interval";
        r2 = r5.optInt(r2, r1);	 Catch:{ Throwable -> 0x0056 }
        r1 = "callback";
        r3 = 0;
        r1 = r5.optString(r1, r3);	 Catch:{ Throwable -> 0x0057 }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0057 }
        if (r3 != 0) goto L_0x004e;
    L_0x004b:
        r8.O0000O0o = r1;	 Catch:{ Throwable -> 0x0057 }
        goto L_0x0057;
    L_0x004e:
        r1 = "AMap.Geolocation.cbk";
        goto L_0x004b;
    L_0x0051:
        r2 = r1;
        r9 = r4;
        goto L_0x0057;
    L_0x0054:
        r6 = r2;
        r9 = r4;
    L_0x0056:
        r2 = r1;
    L_0x0057:
        r1 = r8.O00000Oo;	 Catch:{ Throwable -> 0x007c }
        r1.setHttpTimeOut(r6);	 Catch:{ Throwable -> 0x007c }
        if (r9 == 0) goto L_0x0066;
    L_0x005e:
        r9 = r8.O00000Oo;	 Catch:{ Throwable -> 0x007c }
        r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;	 Catch:{ Throwable -> 0x007c }
    L_0x0062:
        r9.setLocationMode(r1);	 Catch:{ Throwable -> 0x007c }
        goto L_0x006b;
    L_0x0066:
        r9 = r8.O00000Oo;	 Catch:{ Throwable -> 0x007c }
        r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving;	 Catch:{ Throwable -> 0x007c }
        goto L_0x0062;
    L_0x006b:
        r9 = r8.O00000Oo;	 Catch:{ Throwable -> 0x007c }
        r1 = r4 ^ 1;
        r9.setOnceLocation(r1);	 Catch:{ Throwable -> 0x007c }
        if (r4 == 0) goto L_0x007c;
    L_0x0074:
        r9 = r8.O00000Oo;	 Catch:{ Throwable -> 0x007c }
        r2 = r2 * 1000;
        r1 = (long) r2;	 Catch:{ Throwable -> 0x007c }
        r9.setInterval(r1);	 Catch:{ Throwable -> 0x007c }
    L_0x007c:
        r9 = r8.O00000oO;	 Catch:{ all -> 0x0093 }
        if (r9 == 0) goto L_0x0091;
    L_0x0080:
        r9 = r8.O00000oO;	 Catch:{ all -> 0x0093 }
        r1 = r8.O00000Oo;	 Catch:{ all -> 0x0093 }
        r9.setLocationOption(r1);	 Catch:{ all -> 0x0093 }
        r9 = r8.O00000oO;	 Catch:{ all -> 0x0093 }
        r9.stopLocation();	 Catch:{ all -> 0x0093 }
        r9 = r8.O00000oO;	 Catch:{ all -> 0x0093 }
        r9.startLocation();	 Catch:{ all -> 0x0093 }
    L_0x0091:
        monitor-exit(r0);	 Catch:{ all -> 0x0093 }
        return;
    L_0x0093:
        r9 = move-exception;
        monitor-exit(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO00O0o.getLocation(java.lang.String):void");
    }

    @JavascriptInterface
    public final void stopLocation() {
        if (this.O0000OOo && this.O00000oO != null) {
            this.O00000oO.stopLocation();
        }
    }
}
