package com.loc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* compiled from: Aps */
public final class O0O0OOO {
    static int O000O0Oo = -1;
    public static boolean O000O0oO = true;
    private static boolean O000OOOo = false;
    private static int O000OOo = -1;
    Context O000000o = null;
    ConnectivityManager O00000Oo = null;
    O0Oo0o0 O00000o = null;
    O0OOO00 O00000o0 = null;
    O0OOO0O O00000oO = null;
    O0O0o00 O00000oo = null;
    O0Oo O0000O0o = null;
    ArrayList<ScanResult> O0000OOo = new ArrayList();
    AMapLocationClientOption O0000Oo = new AMapLocationClientOption();
    O000000o O0000Oo0 = null;
    AMapLocationServer O0000OoO = null;
    long O0000Ooo = 0;
    boolean O0000o = true;
    boolean O0000o0 = false;
    OooOO O0000o00 = null;
    O0Oo00 O0000o0O = null;
    StringBuilder O0000o0o = new StringBuilder();
    GeoLanguage O0000oO = GeoLanguage.DEFAULT;
    boolean O0000oO0 = true;
    boolean O0000oOO = true;
    boolean O0000oOo = false;
    boolean O0000oo = true;
    WifiInfo O0000oo0 = null;
    StringBuilder O0000ooO = null;
    boolean O0000ooo = false;
    O0OoOo O000O00o = null;
    boolean O000O0OO = false;
    O0OO0Oo O000O0o = null;
    String O000O0o0 = null;
    IntentFilter O000O0oo = null;
    private String O000OO = null;
    LocationManager O000OO00 = null;
    private int O000OO0o = 0;
    private String O000OOo0 = null;
    private boolean O000OOoO = true;
    O0O0o0 O00oOoOo = null;
    public boolean O00oOooO = false;
    int O00oOooo = 12;

    /* compiled from: Aps */
    class O000000o extends BroadcastReceiver {
        O000000o() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (O0O0OOO.this.O00000o0 != null) {
                                O0O0OOO.this.O00000o0.O00000oO();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && O0O0OOO.this.O00000o0 != null) {
                            O0O0OOO.this.O00000o0.O00000oo();
                        }
                    }
                } catch (Throwable th) {
                    O0o0000.O000000o(th, "Aps", "onReceive");
                }
            }
        }
    }

    private static AMapLocationServer O000000o(int i, String str) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(i);
        aMapLocationServer.setLocationDetail(str);
        if (i == 15) {
            ooO0Ooo.O000000o(null, 2151);
        }
        return aMapLocationServer;
    }

    private AMapLocationServer O000000o(AMapLocationServer aMapLocationServer, O00Oo00 o00Oo00) {
        Throwable th;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        if (o00Oo00 != null) {
            try {
                if (o00Oo00.O000000o != null) {
                    if (o00Oo00.O000000o.length != 0) {
                        O0Oo o0Oo = new O0Oo();
                        String str = new String(o00Oo00.O000000o, HttpUtils.ENCODING_UTF_8);
                        if (str.contains("\"status\":\"0\"")) {
                            AMapLocationServer O000000o = o0Oo.O000000o(str, this.O000000o, o00Oo00);
                            try {
                                O000000o.h(this.O0000ooO.toString());
                                return O000000o;
                            } catch (Throwable th2) {
                                AMapLocationServer aMapLocationServer2 = O000000o;
                                th = th2;
                                aMapLocationServer = aMapLocationServer2;
                                aMapLocationServer.setErrorCode(4);
                                O0o0000.O000000o(th, "Aps", "checkResponseEntity");
                                stringBuilder = this.O0000o0o;
                                stringBuilder2 = new StringBuilder("check response exception ex is");
                                stringBuilder2.append(th.getMessage());
                                stringBuilder2.append("#0403");
                                stringBuilder.append(stringBuilder2.toString());
                                aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                                return aMapLocationServer;
                            }
                        } else if (!str.contains("</body></html>")) {
                            return null;
                        } else {
                            aMapLocationServer.setErrorCode(5);
                            if (this.O00000o0 == null || !this.O00000o0.O000000o(this.O00000Oo)) {
                                this.O0000o0o.append("请求可能被劫持了#0502");
                                ooO0Ooo.O000000o(null, 2052);
                            } else {
                                this.O0000o0o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                                ooO0Ooo.O000000o(null, 2051);
                            }
                            aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                            return aMapLocationServer;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                aMapLocationServer.setErrorCode(4);
                O0o0000.O000000o(th, "Aps", "checkResponseEntity");
                stringBuilder = this.O0000o0o;
                stringBuilder2 = new StringBuilder("check response exception ex is");
                stringBuilder2.append(th.getMessage());
                stringBuilder2.append("#0403");
                stringBuilder.append(stringBuilder2.toString());
                aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                return aMapLocationServer;
            }
        }
        aMapLocationServer.setErrorCode(4);
        this.O0000o0o.append("网络异常,请求异常#0403");
        aMapLocationServer.h(this.O0000ooO.toString());
        aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
        if (o00Oo00 != null) {
            ooO0Ooo.O000000o(o00Oo00.O00000o, 2041);
        }
        return aMapLocationServer;
    }

    @SuppressLint({"NewApi"})
    private AMapLocationServer O000000o(boolean z, boolean z2) {
        int i;
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        AMapLocationServer O000000o;
        StringBuilder stringBuilder;
        try {
            if (this.O0000o00 == null) {
                this.O0000o00 = new OooOO();
            }
            if (this.O0000Oo == null) {
                this.O0000Oo = new AMapLocationClientOption();
            }
            this.O0000o00.O000000o(this.O000000o, this.O0000Oo.isNeedAddress(), this.O0000Oo.isOffset(), this.O00000o, this.O00000o0, this.O00000Oo, this.O000O0o != null ? this.O000O0o.O00000o0() : null, this.O000O0o0);
            byte[] O000000o2 = this.O0000o00.O000000o();
            this.O0000Ooo = OO000OO.O00000o0();
            StringBuilder stringBuilder2;
            try {
                O0o0000.O00000o0(this.O000000o);
                O0Oo0 O000000o3 = this.O0000o0O.O000000o(this.O000000o, O000000o2, O0o0000.O000000o(), z2);
                O0OOo.O000000o(this.O000000o).O000000o(O000000o3);
                O00Oo00 O000000o4 = this.O0000o0O.O000000o(O000000o3);
                O0OOo.O000000o(this.O000000o).O000000o();
                String str = "";
                if (O000000o4 != null) {
                    O0OOo.O000000o(this.O000000o).O00000Oo();
                    aMapLocationServer.a((long) this.O0000o0O.O000000o());
                    if (!TextUtils.isEmpty(O000000o4.O00000o0)) {
                        StringBuilder stringBuilder3 = this.O0000o0o;
                        StringBuilder stringBuilder4 = new StringBuilder("#csid:");
                        stringBuilder4.append(O000000o4.O00000o0);
                        stringBuilder3.append(stringBuilder4.toString());
                    }
                    str = O000000o4.O00000o;
                    aMapLocationServer.h(this.O0000ooO.toString());
                }
                if (!z) {
                    O000000o = O000000o(aMapLocationServer, O000000o4);
                    if (O000000o != null) {
                        return O000000o;
                    }
                    byte[] O000000o5 = O0OOO0.O000000o(O000000o4.O000000o);
                    if (O000000o5 == null) {
                        aMapLocationServer.setErrorCode(5);
                        this.O0000o0o.append("解密数据失败#0503");
                        aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                        ooO0Ooo.O000000o(str, 2053);
                        return aMapLocationServer;
                    }
                    aMapLocationServer = this.O0000O0o.O000000o(aMapLocationServer, O000000o5);
                    if (OO000OO.O000000o(aMapLocationServer)) {
                        if (aMapLocationServer.getErrorCode() == 0 && aMapLocationServer.getLocationType() == 0) {
                            if ("-5".equals(aMapLocationServer.d()) || "1".equals(aMapLocationServer.d()) || "2".equals(aMapLocationServer.d()) || Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(aMapLocationServer.d()) || "24".equals(aMapLocationServer.d()) || "-1".equals(aMapLocationServer.d())) {
                                aMapLocationServer.setLocationType(5);
                            } else {
                                aMapLocationServer.setLocationType(6);
                            }
                        }
                        aMapLocationServer.setOffset(this.O0000oO0);
                        aMapLocationServer.a(this.O0000o);
                        aMapLocationServer.f(String.valueOf(this.O0000oO));
                    } else {
                        this.O000OO = aMapLocationServer.b();
                        ooO0Ooo.O000000o(str, !TextUtils.isEmpty(this.O000OO) ? 2062 : 2061);
                        aMapLocationServer.setErrorCode(6);
                        stringBuilder2 = this.O0000o0o;
                        stringBuilder = new StringBuilder("location faile retype:");
                        stringBuilder.append(aMapLocationServer.d());
                        stringBuilder.append(" rdesc:");
                        stringBuilder.append(TextUtils.isEmpty(this.O000OO) ? "" : this.O000OO);
                        stringBuilder.append("#0601");
                        stringBuilder2.append(stringBuilder.toString());
                        aMapLocationServer.h(this.O0000ooO.toString());
                        aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                        return aMapLocationServer;
                    }
                }
                aMapLocationServer.e("new");
                aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                this.O000O0o0 = aMapLocationServer.a();
                return aMapLocationServer;
            } catch (Throwable th) {
                String str2;
                O0OOo.O000000o(this.O000000o).O00000o();
                O0o0000.O000000o(th, "Aps", "getApsLoc req");
                ooO0Ooo.O000000o("/mobile/binary", th);
                if (OO000OO.O00000o(this.O000000o)) {
                    if (th instanceof OO00Oo0) {
                        OO00Oo0 oO00Oo0 = (OO00Oo0) th;
                        if (oO00Oo0.O000000o().contains("网络异常状态码")) {
                            stringBuilder = this.O0000o0o;
                            stringBuilder.append("网络异常，状态码错误#0404");
                            stringBuilder.append(oO00Oo0.O00000oO());
                            i = 4;
                            O000000o = O000000o(i, this.O0000o0o.toString());
                            O000000o.h(this.O0000ooO.toString());
                            return O000000o;
                        } else if (oO00Oo0.O00000oO() == 23 || Math.abs((OO000OO.O00000o0() - this.O0000Ooo) - this.O0000Oo.getHttpTimeOut()) < 500) {
                            stringBuilder2 = this.O0000o0o;
                            str2 = "网络异常，连接超时#0402";
                        }
                    }
                    stringBuilder2 = this.O0000o0o;
                    str2 = "网络异常,请求异常#0403";
                } else {
                    stringBuilder2 = this.O0000o0o;
                    str2 = "网络异常，未连接到网络，请连接网络#0401";
                }
                stringBuilder2.append(str2);
                i = 4;
                O000000o = O000000o(i, this.O0000o0o.toString());
                O000000o.h(this.O0000ooO.toString());
                return O000000o;
            }
        } catch (Throwable th2) {
            stringBuilder = this.O0000o0o;
            StringBuilder stringBuilder5 = new StringBuilder("get parames error:");
            stringBuilder5.append(th2.getMessage());
            stringBuilder5.append("#0301");
            stringBuilder.append(stringBuilder5.toString());
            ooO0Ooo.O000000o(null, 2031);
            i = 3;
            O000000o = O000000o(i, this.O0000o0o.toString());
            O000000o.h(this.O0000ooO.toString());
            return O000000o;
        }
    }

    private StringBuilder O000000o(StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder(SecExceptionCode.SEC_ERROR_STA_KEY_ENC);
        } else {
            stringBuilder.delete(0, stringBuilder.length());
        }
        stringBuilder.append(this.O00000o.O0000Ooo());
        stringBuilder.append(this.O00000o0.O0000Oo());
        return stringBuilder;
    }

    public static void O00000Oo(Context context) {
        try {
            if (O000OOo == -1 || OoO0o.O0000OOo(context)) {
                O000OOo = 1;
                OoO0o.O000000o(context);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Aps", "initAuth");
        }
    }

    private void O00000Oo(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            this.O0000OoO = aMapLocationServer;
        }
    }

    private void O0000Ooo() {
        if (this.O0000o0O != null) {
            try {
                if (this.O0000Oo == null) {
                    this.O0000Oo = new AMapLocationClientOption();
                }
                int i = 0;
                if (this.O0000Oo.getGeoLanguage() != null) {
                    switch (this.O0000Oo.getGeoLanguage()) {
                        case DEFAULT:
                            break;
                        case ZH:
                            i = 1;
                            break;
                        case EN:
                            i = 2;
                            break;
                        default:
                            break;
                    }
                }
                this.O0000o0O.O000000o(this.O0000Oo.getHttpTimeOut(), this.O0000Oo.getLocationProtocol().equals(AMapLocationProtocol.HTTPS), i);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Missing block: B:72:0x01c9, code skipped:
            if (r11.O0000oo == false) goto L_0x0210;
     */
    /* JADX WARNING: Missing block: B:77:0x020d, code skipped:
            if (r11.O0000oo == false) goto L_0x0210;
     */
    /* JADX WARNING: Missing block: B:78:0x0210, code skipped:
            r1 = "cgi";
     */
    /* JADX WARNING: Missing block: B:79:0x0213, code skipped:
            r1 = "cgiwifi";
     */
    /* JADX WARNING: Missing block: B:80:0x0215, code skipped:
            r0.append(r1);
            r0 = r0.toString();
     */
    /* JADX WARNING: Missing block: B:114:0x02ce, code skipped:
            r1 = "#";
     */
    /* JADX WARNING: Missing block: B:115:0x02d4, code skipped:
            if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x02fe;
     */
    /* JADX WARNING: Missing block: B:117:0x02da, code skipped:
            if (r0.startsWith(r1) != false) goto L_0x02eb;
     */
    /* JADX WARNING: Missing block: B:118:0x02dc, code skipped:
            r2 = new java.lang.StringBuilder();
            r2.append(r1);
            r2.append(r0);
            r0 = r2.toString();
     */
    /* JADX WARNING: Missing block: B:119:0x02eb, code skipped:
            r1 = new java.lang.StringBuilder();
            r1.append(com.loc.OO000OO.O0000Oo0());
            r1.append(r0);
            r0 = r1.toString();
     */
    /* JADX WARNING: Missing block: B:120:0x02fe, code skipped:
            return r0;
     */
    private java.lang.String O0000o0() {
        /*
        r11 = this;
        r0 = "";
        r1 = "network";
        r2 = r11.O00000o;
        r2 = r2.O00000oo();
        r3 = r11.O00000o;
        r3 = r3.O00000o0();
        r4 = r11.O0000OOo;
        r5 = 1;
        r6 = 0;
        if (r4 == 0) goto L_0x0021;
    L_0x0016:
        r4 = r11.O0000OOo;
        r4 = r4.isEmpty();
        if (r4 == 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0021;
    L_0x001f:
        r4 = r6;
        goto L_0x0022;
    L_0x0021:
        r4 = r5;
    L_0x0022:
        r7 = 0;
        if (r3 != 0) goto L_0x0157;
    L_0x0025:
        if (r4 == 0) goto L_0x0157;
    L_0x0027:
        r1 = r11.O00000Oo;
        if (r1 != 0) goto L_0x0037;
    L_0x002b:
        r1 = r11.O000000o;
        r2 = "connectivity";
        r1 = com.loc.OO000OO.O000000o(r1, r2);
        r1 = (android.net.ConnectivityManager) r1;
        r11.O00000Oo = r1;
    L_0x0037:
        r1 = r11.O000000o;
        r1 = com.loc.OO000OO.O000000o(r1);
        if (r1 == 0) goto L_0x0058;
    L_0x003f:
        r1 = r11.O00000o0;
        r1 = r1.O0000O0o();
        if (r1 != 0) goto L_0x0058;
    L_0x0047:
        r1 = 18;
        r11.O00oOooo = r1;
        r1 = r11.O0000o0o;
        r2 = "飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801";
        r1.append(r2);
        r1 = 2132; // 0x854 float:2.988E-42 double:1.0533E-320;
        com.loc.ooO0Ooo.O000000o(r7, r1);
        return r0;
    L_0x0058:
        r1 = com.loc.OO000OO.O00000o();
        r2 = 28;
        r3 = 2121; // 0x849 float:2.972E-42 double:1.048E-320;
        r4 = 12;
        if (r1 < r2) goto L_0x0097;
    L_0x0064:
        r1 = r11.O000OO00;
        if (r1 != 0) goto L_0x0078;
    L_0x0068:
        r1 = r11.O000000o;
        r1 = r1.getApplicationContext();
        r5 = "location";
        r1 = r1.getSystemService(r5);
        r1 = (android.location.LocationManager) r1;
        r11.O000OO00 = r1;
    L_0x0078:
        r1 = r11.O000OO00;
        r5 = "isLocationEnabled";
        r8 = new java.lang.Object[r6];
        r1 = com.loc.O0o.O000000o(r1, r5, r8);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 != 0) goto L_0x0097;
    L_0x008a:
        r11.O00oOooo = r4;
        r1 = r11.O0000o0o;
        r2 = "定位服务没有开启，请在设置中打开定位服务开关#1206";
        r1.append(r2);
        com.loc.ooO0Ooo.O000000o(r7, r3);
        return r0;
    L_0x0097:
        r1 = r11.O000000o;
        r1 = com.loc.OO000OO.O00000oo(r1);
        if (r1 != 0) goto L_0x00ac;
    L_0x009f:
        r11.O00oOooo = r4;
        r1 = r11.O0000o0o;
        r2 = "定位权限被禁用,请授予应用定位权限#1201";
        r1.append(r2);
        com.loc.ooO0Ooo.O000000o(r7, r3);
        return r0;
    L_0x00ac:
        r1 = com.loc.OO000OO.O00000o();
        r5 = 24;
        if (r1 < r5) goto L_0x00d5;
    L_0x00b4:
        r1 = com.loc.OO000OO.O00000o();
        if (r1 >= r2) goto L_0x00d5;
    L_0x00ba:
        r1 = r11.O000000o;
        r1 = r1.getContentResolver();
        r2 = "location_mode";
        r1 = android.provider.Settings.Secure.getInt(r1, r2, r6);
        if (r1 != 0) goto L_0x00d5;
    L_0x00c8:
        r11.O00oOooo = r4;
        r1 = r11.O0000o0o;
        r2 = "定位服务没有开启，请在设置中打开定位服务开关#1206";
        r1.append(r2);
        com.loc.ooO0Ooo.O000000o(r7, r3);
        return r0;
    L_0x00d5:
        r1 = r11.O00000o;
        r1 = r1.O0000Oo();
        r2 = r11.O00000o0;
        r2 = r2.O00000Oo();
        r5 = r11.O00000o0;
        r6 = r11.O00000Oo;
        r5 = r5.O000000o(r6);
        if (r5 == 0) goto L_0x00fa;
    L_0x00eb:
        if (r2 == 0) goto L_0x00fa;
    L_0x00ed:
        r11.O00oOooo = r4;
        r1 = r11.O0000o0o;
        r2 = "获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202";
        r1.append(r2);
        com.loc.ooO0Ooo.O000000o(r7, r3);
        return r0;
    L_0x00fa:
        if (r1 == 0) goto L_0x0117;
    L_0x00fc:
        r11.O00oOooo = r4;
        r1 = r11.O00000o0;
        r1 = r1.O0000O0o();
        if (r1 != 0) goto L_0x010e;
    L_0x0106:
        r1 = r11.O0000o0o;
        r2 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
    L_0x010a:
        r1.append(r2);
        goto L_0x0113;
    L_0x010e:
        r1 = r11.O0000o0o;
        r2 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
        goto L_0x010a;
    L_0x0113:
        com.loc.ooO0Ooo.O000000o(r7, r3);
        return r0;
    L_0x0117:
        r1 = r11.O00000o0;
        r1 = r1.O0000O0o();
        if (r1 != 0) goto L_0x0138;
    L_0x011f:
        r1 = r11.O00000o;
        r1 = r1.O0000o00();
        if (r1 != 0) goto L_0x0138;
    L_0x0127:
        r1 = 19;
        r11.O00oOooo = r1;
        r1 = r11.O0000o0o;
        r2 = "没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901";
        r1.append(r2);
        r1 = 2133; // 0x855 float:2.989E-42 double:1.054E-320;
        com.loc.ooO0Ooo.O000000o(r7, r1);
        return r0;
    L_0x0138:
        r1 = r11.O00000o0;
        r1 = r1.O0000O0o();
        if (r1 != 0) goto L_0x0148;
    L_0x0140:
        r1 = r11.O0000o0o;
        r2 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
    L_0x0144:
        r1.append(r2);
        goto L_0x014d;
    L_0x0148:
        r1 = r11.O0000o0o;
        r2 = "获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限#1302";
        goto L_0x0144;
    L_0x014d:
        r1 = 13;
        r11.O00oOooo = r1;
        r1 = 2131; // 0x853 float:2.986E-42 double:1.053E-320;
        com.loc.ooO0Ooo.O000000o(r7, r1);
        return r0;
    L_0x0157:
        r4 = r11.O00000o0;
        r4 = r4.O0000OOo();
        r11.O0000oo0 = r4;
        r4 = r11.O00000o0;
        r4 = r11.O0000oo0;
        r4 = com.loc.O0OOO00.O000000o(r4);
        r11.O0000oo = r4;
        switch(r2) {
            case 0: goto L_0x021e;
            case 1: goto L_0x01cc;
            case 2: goto L_0x017e;
            default: goto L_0x016c;
        };
    L_0x016c:
        r1 = 11;
        r11.O00oOooo = r1;
        r1 = 2111; // 0x83f float:2.958E-42 double:1.043E-320;
        com.loc.ooO0Ooo.O000000o(r7, r1);
        r1 = r11.O0000o0o;
        r2 = "get cgi failure#1101";
        r1.append(r2);
        goto L_0x02ce;
    L_0x017e:
        if (r3 == 0) goto L_0x02ce;
    L_0x0180:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = r3.O000000o;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r2 = r3.O00000Oo;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r2 = r3.O0000O0o;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r2 = r3.O0000OOo;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r2 = r3.O0000Oo0;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r0.append(r1);
        r1 = "#";
        r0.append(r1);
        r1 = r11.O0000OOo;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0213;
    L_0x01c7:
        r1 = r11.O0000oo;
        if (r1 == 0) goto L_0x0210;
    L_0x01cb:
        goto L_0x0213;
    L_0x01cc:
        if (r3 == 0) goto L_0x02ce;
    L_0x01ce:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = r3.O000000o;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r2 = r3.O00000Oo;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r2 = r3.O00000o0;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r2 = r3.O00000o;
        r0.append(r2);
        r2 = "#";
        r0.append(r2);
        r0.append(r1);
        r1 = "#";
        r0.append(r1);
        r1 = r11.O0000OOo;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0213;
    L_0x020b:
        r1 = r11.O0000oo;
        if (r1 == 0) goto L_0x0210;
    L_0x020f:
        goto L_0x0213;
    L_0x0210:
        r1 = "cgi";
        goto L_0x0215;
    L_0x0213:
        r1 = "cgiwifi";
    L_0x0215:
        r0.append(r1);
        r0 = r0.toString();
        goto L_0x02ce;
    L_0x021e:
        r2 = r11.O0000OOo;
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x022d;
    L_0x0226:
        r2 = r11.O0000oo;
        if (r2 == 0) goto L_0x022b;
    L_0x022a:
        goto L_0x022d;
    L_0x022b:
        r2 = r6;
        goto L_0x022e;
    L_0x022d:
        r2 = r5;
    L_0x022e:
        r3 = r11.O0000oo;
        r4 = 2021; // 0x7e5 float:2.832E-42 double:9.985E-321;
        r8 = 2;
        if (r3 == 0) goto L_0x024a;
    L_0x0235:
        r3 = r11.O0000OOo;
        r3 = r3.isEmpty();
        if (r3 == 0) goto L_0x024a;
    L_0x023d:
        r11.O00oOooo = r8;
        r1 = r11.O0000o0o;
        r2 = "当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201";
        r1.append(r2);
        com.loc.ooO0Ooo.O000000o(r7, r4);
        return r0;
    L_0x024a:
        r3 = r11.O0000OOo;
        r3 = r3.size();
        r9 = 2022; // 0x7e6 float:2.833E-42 double:9.99E-321;
        if (r3 != r5) goto L_0x028a;
    L_0x0254:
        r11.O00oOooo = r8;
        r3 = r11.O0000oo;
        if (r3 != 0) goto L_0x0265;
    L_0x025a:
        r1 = r11.O0000o0o;
        r2 = "当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202";
        r1.append(r2);
        com.loc.ooO0Ooo.O000000o(r7, r9);
        return r0;
    L_0x0265:
        r3 = r11.O0000OOo;
        r3 = r3.get(r6);
        r3 = (android.net.wifi.ScanResult) r3;
        r3 = r3.BSSID;
        r10 = r11.O00000o0;
        r10 = r10.O0000OOo();
        r10 = r10.getBSSID();
        r3 = r10.equals(r3);
        if (r3 == 0) goto L_0x028a;
    L_0x027f:
        r1 = r11.O0000o0o;
        r2 = "当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202";
        r1.append(r2);
        com.loc.ooO0Ooo.O000000o(r7, r4);
        return r0;
    L_0x028a:
        r0 = java.util.Locale.US;
        r3 = "#%s#";
        r4 = new java.lang.Object[r5];
        r4[r6] = r1;
        r0 = java.lang.String.format(r0, r3, r4);
        if (r2 == 0) goto L_0x02aa;
    L_0x0298:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        r0 = "wifi";
        r1.append(r0);
        r0 = r1.toString();
        goto L_0x02ce;
    L_0x02aa:
        r2 = "network";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x02ce;
    L_0x02b2:
        r0 = "";
        r11.O00oOooo = r8;
        r1 = r11.O00000o0;
        r1 = r1.O0000O0o();
        if (r1 != 0) goto L_0x02c6;
    L_0x02be:
        r1 = r11.O0000o0o;
        r2 = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
    L_0x02c2:
        r1.append(r2);
        goto L_0x02cb;
    L_0x02c6:
        r1 = r11.O0000o0o;
        r2 = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
        goto L_0x02c2;
    L_0x02cb:
        com.loc.ooO0Ooo.O000000o(r7, r9);
    L_0x02ce:
        r1 = "#";
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x02fe;
    L_0x02d6:
        r2 = r0.startsWith(r1);
        if (r2 != 0) goto L_0x02eb;
    L_0x02dc:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2.append(r0);
        r0 = r2.toString();
    L_0x02eb:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.loc.OO000OO.O0000Oo0();
        r1.append(r2);
        r1.append(r0);
        r0 = r1.toString();
    L_0x02fe:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0O0OOO.O0000o0():java.lang.String");
    }

    private void O0000o00() {
        try {
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = new O000000o();
            }
            if (this.O000O0oo == null) {
                this.O000O0oo = new IntentFilter();
                this.O000O0oo.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.O000O0oo.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.O000000o.registerReceiver(this.O0000Oo0, this.O000O0oo);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Aps", "initBroadcastListener");
        }
    }

    private boolean O0000o0O() {
        this.O0000OOo = this.O00000o0.O00000o0();
        return this.O0000OOo == null || this.O0000OOo.size() <= 0;
    }

    public final AMapLocationServer O000000o(double d, double d2) {
        try {
            String O000000o = this.O0000o0O.O000000o(this.O000000o, d, d2);
            if (O000000o.contains("\"status\":\"1\"")) {
                AMapLocationServer O000000o2 = this.O0000O0o.O000000o(O000000o);
                O000000o2.setLatitude(d);
                O000000o2.setLongitude(d2);
                return O000000o2;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final AMapLocationServer O000000o(AMapLocationServer aMapLocationServer, String... strArr) {
        this.O00oOoOo.O000000o(this.O0000oOO);
        if (strArr == null || strArr.length == 0 || strArr[0].equals("shake")) {
            return this.O00oOoOo.O000000o(aMapLocationServer);
        }
        if (strArr[0].equals("fusion")) {
            O0O0o0 o0O0o0 = this.O00oOoOo;
        }
        return aMapLocationServer;
    }

    public final AMapLocationServer O000000o(boolean z) {
        int i;
        String str;
        if (this.O000000o == null) {
            this.O0000o0o.append("context is null#0101");
            ooO0Ooo.O000000o(null, (int) GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE);
            i = 1;
        } else if (this.O00000o0.O0000Oo0()) {
            i = 15;
            str = "networkLocation has been mocked!#1502";
            return O000000o(i, str);
        } else {
            O000000o();
            if (TextUtils.isEmpty(this.O000OOo0)) {
                i = this.O00oOooo;
            } else {
                AMapLocationServer O000000o = O000000o(false, z);
                if (OO000OO.O000000o(O000000o)) {
                    this.O00000oO.O000000o(this.O0000ooO.toString());
                    this.O00000oO.O000000o(this.O00000o.O00000o0());
                    O00000Oo(O000000o);
                }
                return O000000o;
            }
        }
        str = this.O0000o0o.toString();
        return O000000o(i, str);
    }

    public final void O000000o() {
        this.O0000o0O = O0Oo00.O000000o(this.O000000o);
        O0000Ooo();
        if (this.O00000Oo == null) {
            this.O00000Oo = (ConnectivityManager) OO000OO.O000000o(this.O000000o, "connectivity");
        }
        if (this.O0000o00 == null) {
            this.O0000o00 = new OooOO();
        }
    }

    public final void O000000o(Context context) {
        try {
            if (this.O000000o == null) {
                this.O00oOoOo = new O0O0o0();
                this.O000000o = context.getApplicationContext();
                OoO0o.O00000oO(this.O000000o);
                OO000OO.O00000Oo(this.O000000o);
                if (this.O00000o0 == null) {
                    this.O00000o0 = new O0OOO00(this.O000000o, (WifiManager) OO000OO.O000000o(this.O000000o, "wifi"));
                }
                if (this.O00000o == null) {
                    this.O00000o = new O0Oo0o0(this.O000000o);
                }
                if (this.O00000oO == null) {
                    this.O00000oO = new O0OOO0O();
                }
                if (this.O0000O0o == null) {
                    this.O0000O0o = new O0Oo();
                }
                if (this.O000O0o == null) {
                    this.O000O0o = new O0OO0Oo(this.O000000o);
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Aps", "initBase");
        }
    }

    public final void O000000o(AMapLocationClientOption aMapLocationClientOption) {
        boolean isWifiScan;
        boolean isMockEnable;
        GeoLanguage geoLanguage;
        boolean isNeedAddress;
        this.O0000Oo = aMapLocationClientOption;
        if (this.O0000Oo == null) {
            this.O0000Oo = new AMapLocationClientOption();
        }
        if (this.O00000o0 != null) {
            O0OOO00 o0ooo00 = this.O00000o0;
            this.O0000Oo.isWifiActiveScan();
            isWifiScan = this.O0000Oo.isWifiScan();
            isMockEnable = this.O0000Oo.isMockEnable();
            AMapLocationClientOption aMapLocationClientOption2 = this.O0000Oo;
            o0ooo00.O000000o(isWifiScan, isMockEnable, AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        O0000Ooo();
        if (this.O00000oO != null) {
            this.O00000oO.O000000o(this.O0000Oo);
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.O000000o(this.O0000Oo);
        }
        GeoLanguage geoLanguage2 = GeoLanguage.DEFAULT;
        try {
            geoLanguage = this.O0000Oo.getGeoLanguage();
            try {
                isNeedAddress = this.O0000Oo.isNeedAddress();
            } catch (Throwable unused) {
                isNeedAddress = true;
                isWifiScan = isNeedAddress;
                isMockEnable = isWifiScan;
                this.O0000oO0 = isWifiScan;
                this.O0000o = isNeedAddress;
                this.O0000oOO = isMockEnable;
                this.O0000oO = geoLanguage;
            }
            try {
                isWifiScan = this.O0000Oo.isOffset();
                try {
                    isMockEnable = this.O0000Oo.isLocationCacheEnable();
                    try {
                        this.O0000oOo = this.O0000Oo.isOnceLocationLatest();
                        this.O000O0OO = this.O0000Oo.isSensorEnable();
                        if (!(isWifiScan == this.O0000oO0 && isNeedAddress == this.O0000o && isMockEnable == this.O0000oOO && geoLanguage == this.O0000oO)) {
                            if (this.O00000oO != null) {
                                this.O00000oO.O000000o();
                            }
                            O00000Oo(null);
                            this.O000OOoO = false;
                            if (this.O00oOoOo != null) {
                                this.O00oOoOo.O000000o();
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    isMockEnable = true;
                }
            } catch (Throwable unused4) {
                isWifiScan = true;
                isMockEnable = isWifiScan;
                this.O0000oO0 = isWifiScan;
                this.O0000o = isNeedAddress;
                this.O0000oOO = isMockEnable;
                this.O0000oO = geoLanguage;
            }
        } catch (Throwable unused5) {
            geoLanguage = geoLanguage2;
            isNeedAddress = true;
            isWifiScan = isNeedAddress;
            isMockEnable = isWifiScan;
            this.O0000oO0 = isWifiScan;
            this.O0000o = isNeedAddress;
            this.O0000oOO = isMockEnable;
            this.O0000oO = geoLanguage;
        }
        this.O0000oO0 = isWifiScan;
        this.O0000o = isNeedAddress;
        this.O0000oOO = isMockEnable;
        this.O0000oO = geoLanguage;
    }

    public final void O000000o(AMapLocationServer aMapLocationServer) {
        if (OO000OO.O000000o(aMapLocationServer)) {
            this.O00000oO.O000000o(this.O000OOo0, this.O0000ooO, aMapLocationServer, this.O000000o, true);
        }
    }

    public final void O00000Oo() {
        if (this.O000O00o == null) {
            this.O000O00o = new O0OoOo(this.O000000o);
        }
        if (this.O00000oo == null) {
            this.O00000oo = new O0O0o00(this.O000000o);
        }
        O0000o00();
        this.O00000o0.O00000Oo(false);
        this.O0000OOo = this.O00000o0.O00000o0();
        this.O00000o.O000000o(false, O0000o0O());
        this.O00000oO.O000000o(this.O000000o);
        this.O00000oo.O00000Oo();
        try {
            if (this.O000000o.checkCallingOrSelfPermission(OO0o000.O00000o0("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.O0000o0 = true;
            }
        } catch (Throwable unused) {
        }
        this.O00oOooO = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a2 A:{Catch:{ Throwable -> 0x00bc }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0111  */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer O00000o() throws java.lang.Throwable {
        /*
        r15 = this;
        r15.O00000o0();
        r0 = r15.O000000o;
        r1 = 1;
        if (r0 != 0) goto L_0x001a;
    L_0x0008:
        r0 = r15.O0000o0o;
        r2 = "context is null#0101";
        r0.append(r2);
        r0 = r15.O0000o0o;
        r0 = r0.toString();
        r0 = O000000o(r1, r0);
        return r0;
    L_0x001a:
        r0 = r15.O000OO0o;
        r0 = r0 + r1;
        r15.O000OO0o = r0;
        r0 = r15.O000OO0o;
        if (r0 != r1) goto L_0x002e;
    L_0x0023:
        r0 = r15.O00000o0;
        if (r0 == 0) goto L_0x002e;
    L_0x0027:
        r0 = r15.O00000o0;
        r2 = r15.O0000o0;
        r0.O000000o(r2);
    L_0x002e:
        r2 = r15.O0000Ooo;
        r0 = r15.O000OOoO;
        r4 = 0;
        r6 = 0;
        if (r0 != 0) goto L_0x003b;
    L_0x0037:
        r15.O000OOoO = r1;
    L_0x0039:
        r0 = r6;
        goto L_0x0064;
    L_0x003b:
        r7 = com.loc.OO000OO.O00000o0();
        r9 = r7 - r2;
        r2 = 800; // 0x320 float:1.121E-42 double:3.953E-321;
        r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x0039;
    L_0x0047:
        r0 = r15.O0000OoO;
        r0 = com.loc.OO000OO.O000000o(r0);
        if (r0 == 0) goto L_0x005c;
    L_0x004f:
        r2 = com.loc.OO000OO.O00000Oo();
        r0 = r15.O0000OoO;
        r7 = r0.getTime();
        r9 = r2 - r7;
        goto L_0x005d;
    L_0x005c:
        r9 = r4;
    L_0x005d:
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x0039;
    L_0x0063:
        r0 = r1;
    L_0x0064:
        r2 = 2;
        if (r0 == 0) goto L_0x0087;
    L_0x0067:
        r0 = r15.O0000OoO;
        r0 = com.loc.OO000OO.O000000o(r0);
        if (r0 == 0) goto L_0x0087;
    L_0x006f:
        r0 = r15.O0000oOO;
        if (r0 == 0) goto L_0x0084;
    L_0x0073:
        r0 = r15.O0000OoO;
        r0 = r0.getTime();
        r0 = com.loc.OoO0o.O00000Oo(r0);
        if (r0 == 0) goto L_0x0084;
    L_0x007f:
        r0 = r15.O0000OoO;
        r0.setLocationType(r2);
    L_0x0084:
        r0 = r15.O0000OoO;
        return r0;
    L_0x0087:
        r0 = r15.O000O00o;
        if (r0 == 0) goto L_0x009a;
    L_0x008b:
        r0 = r15.O000O0OO;
        if (r0 == 0) goto L_0x0095;
    L_0x008f:
        r0 = r15.O000O00o;
        r0.O000000o();
        goto L_0x009a;
    L_0x0095:
        r0 = r15.O000O00o;
        r0.O00000Oo();
    L_0x009a:
        r0 = r15.O0000Oo;	 Catch:{ Throwable -> 0x00bc }
        r0 = r0.isOnceLocationLatest();	 Catch:{ Throwable -> 0x00bc }
        if (r0 != 0) goto L_0x00ad;
    L_0x00a2:
        r0 = r15.O0000Oo;	 Catch:{ Throwable -> 0x00bc }
        r0 = r0.isOnceLocation();	 Catch:{ Throwable -> 0x00bc }
        if (r0 != 0) goto L_0x00ab;
    L_0x00aa:
        goto L_0x00ad;
    L_0x00ab:
        r0 = r6;
        goto L_0x00ae;
    L_0x00ad:
        r0 = r1;
    L_0x00ae:
        r3 = r15.O00000o0;	 Catch:{ Throwable -> 0x00bc }
        r3.O00000Oo(r0);	 Catch:{ Throwable -> 0x00bc }
        r0 = r15.O00000o0;	 Catch:{ Throwable -> 0x00bc }
        r0 = r0.O00000o0();	 Catch:{ Throwable -> 0x00bc }
        r15.O0000OOo = r0;	 Catch:{ Throwable -> 0x00bc }
        goto L_0x00c4;
    L_0x00bc:
        r0 = move-exception;
        r3 = "Aps";
        r7 = "getLocation getScanResultsParam";
        com.loc.O0o0000.O000000o(r0, r3, r7);
    L_0x00c4:
        r0 = r15.O00000o;	 Catch:{ Throwable -> 0x00ce }
        r3 = r15.O0000o0O();	 Catch:{ Throwable -> 0x00ce }
        r0.O000000o(r6, r3);	 Catch:{ Throwable -> 0x00ce }
        goto L_0x00d6;
    L_0x00ce:
        r0 = move-exception;
        r3 = "Aps";
        r7 = "getLocation getCgiListParam";
        com.loc.O0o0000.O000000o(r0, r3, r7);
    L_0x00d6:
        r0 = r15.O0000o0();
        r15.O000OOo0 = r0;
        r0 = r15.O000OOo0;
        r0 = android.text.TextUtils.isEmpty(r0);
        r3 = 4;
        if (r0 == 0) goto L_0x0111;
    L_0x00e5:
        r0 = r15.O00000oo;
        r0 = r0.O00000oO();
        r15.O0000OoO = r0;
        r0 = r15.O0000OoO;
        if (r0 == 0) goto L_0x0104;
    L_0x00f1:
        r0 = r15.O0000OoO;
        r1 = r15.O0000o0o;
        r1 = r1.toString();
        r0.setLocationDetail(r1);
        r0 = r15.O0000OoO;
        r0.setTrustedLevel(r3);
        r0 = r15.O0000OoO;
        return r0;
    L_0x0104:
        r0 = r15.O00oOooo;
        r1 = r15.O0000o0o;
        r1 = r1.toString();
        r0 = O000000o(r0, r1);
        return r0;
    L_0x0111:
        r0 = r15.O0000ooO;
        r0 = r15.O000000o(r0);
        r15.O0000ooO = r0;
        r0 = r15.O00000o0;
        r0 = r0.O0000Oo0();
        if (r0 == 0) goto L_0x0130;
    L_0x0121:
        r0 = 15;
        r2 = "networkLocation has been mocked!#1502";
        r0 = O000000o(r0, r2);
        r0.setMock(r1);
        r0.setTrustedLevel(r3);
        return r0;
    L_0x0130:
        r7 = r15.O0000Ooo;
        r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0138;
    L_0x0136:
        r9 = r1;
        goto L_0x0148;
    L_0x0138:
        r4 = com.loc.OO000OO.O00000o0();
        r7 = r15.O0000Ooo;
        r9 = r4 - r7;
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0147;
    L_0x0146:
        goto L_0x0136;
    L_0x0147:
        r9 = r6;
    L_0x0148:
        r7 = r15.O00000oO;
        r8 = r15.O00000o;
        r10 = r15.O0000OoO;
        r11 = r15.O00000o0;
        r12 = r15.O0000ooO;
        r13 = r15.O000OOo0;
        r14 = r15.O000000o;
        r0 = r7.O000000o(r8, r9, r10, r11, r12, r13, r14);
        r4 = com.loc.OO000OO.O000000o(r0);
        if (r4 == 0) goto L_0x0167;
    L_0x0160:
        r0.setTrustedLevel(r2);
        r15.O00000Oo(r0);
        goto L_0x01a6;
    L_0x0167:
        r0 = r15.O000000o(r6, r1);
        r15.O0000OoO = r0;
        r0 = r15.O0000OoO;
        r0 = com.loc.OO000OO.O000000o(r0);
        if (r0 == 0) goto L_0x01a6;
    L_0x0175:
        r0 = r15.O0000OoO;
        r4 = "new";
        r0.e(r4);
        r0 = r15.O00000oO;
        r4 = r15.O0000ooO;
        r4 = r4.toString();
        r0.O000000o(r4);
        r0 = r15.O00000oO;
        r4 = r15.O00000o;
        r4 = r4.O00000o0();
        r0.O000000o(r4);
        r0 = r15.O0000OoO;
        r15.O00000Oo(r0);
        r0 = r15.O000O0o;
        if (r0 == 0) goto L_0x01a6;
    L_0x019b:
        r0 = r15.O000O0o;
        r4 = r15.O00000o;
        r5 = r15.O0000OOo;
        r7 = r15.O0000OoO;
        r0.O00000o0(r4, r5, r7);
    L_0x01a6:
        r0 = r15.O00000o0;	 Catch:{ Throwable -> 0x01db }
        if (r0 == 0) goto L_0x01db;
    L_0x01aa:
        r0 = r15.O0000OoO;	 Catch:{ Throwable -> 0x01db }
        if (r0 == 0) goto L_0x01db;
    L_0x01ae:
        r0 = r15.O00000o0;	 Catch:{ Throwable -> 0x01db }
        r4 = com.loc.O0OOO00.O000000o();	 Catch:{ Throwable -> 0x01db }
        r7 = 15;
        r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1));
        if (r0 > 0) goto L_0x01c0;
    L_0x01ba:
        r0 = r15.O0000OoO;	 Catch:{ Throwable -> 0x01db }
    L_0x01bc:
        r0.setTrustedLevel(r1);	 Catch:{ Throwable -> 0x01db }
        goto L_0x01db;
    L_0x01c0:
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r7 > 0) goto L_0x01cc;
    L_0x01c6:
        r0 = r15.O0000OoO;	 Catch:{ Throwable -> 0x01db }
        r0.setTrustedLevel(r2);	 Catch:{ Throwable -> 0x01db }
        goto L_0x01db;
    L_0x01cc:
        r0 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x01d6;
    L_0x01d2:
        r0 = r15.O0000OoO;	 Catch:{ Throwable -> 0x01db }
        r1 = 3;
        goto L_0x01bc;
    L_0x01d6:
        r0 = r15.O0000OoO;	 Catch:{ Throwable -> 0x01db }
        r0.setTrustedLevel(r3);	 Catch:{ Throwable -> 0x01db }
    L_0x01db:
        r0 = r15.O000O0o;
        if (r0 == 0) goto L_0x01ea;
    L_0x01df:
        r0 = r15.O000O0o;
        r1 = r15.O00000o;
        r2 = r15.O0000OOo;
        r3 = r15.O0000OoO;
        r0.O00000Oo(r1, r2, r3);
    L_0x01ea:
        r7 = r15.O00000oO;
        r8 = r15.O000OOo0;
        r9 = r15.O0000ooO;
        r10 = r15.O0000OoO;
        r11 = r15.O000000o;
        r12 = 1;
        r7.O000000o(r8, r9, r10, r11, r12);
        r0 = r15.O0000OoO;
        r0 = com.loc.OO000OO.O000000o(r0);
        if (r0 != 0) goto L_0x0214;
    L_0x0200:
        r0 = r15.O000O0o;
        if (r0 == 0) goto L_0x0214;
    L_0x0204:
        r0 = r15.O000O0o;
        r1 = r15.O000000o;
        r1 = r15.O00000o;
        r2 = r15.O0000OOo;
        r3 = r15.O0000OoO;
        r0 = r0.O000000o(r1, r2, r3);
        r15.O0000OoO = r0;
    L_0x0214:
        r0 = r15.O0000ooO;
        r1 = r15.O0000ooO;
        r1 = r1.length();
        r0.delete(r6, r1);
        r0 = r15.O000O0OO;
        if (r0 == 0) goto L_0x0247;
    L_0x0223:
        r0 = r15.O000O00o;
        if (r0 == 0) goto L_0x0247;
    L_0x0227:
        r0 = r15.O0000OoO;
        r1 = r15.O000O00o;
        r1 = r1.O00000o0();
        r0.setAltitude(r1);
        r0 = r15.O0000OoO;
        r1 = r15.O000O00o;
        r1 = r1.O00000o();
        r0.setBearing(r1);
        r0 = r15.O0000OoO;
        r1 = r15.O000O00o;
        r1 = r1.O00000oO();
        r1 = (float) r1;
        goto L_0x0256;
    L_0x0247:
        r0 = r15.O0000OoO;
        r1 = 0;
        r0.setAltitude(r1);
        r0 = r15.O0000OoO;
        r1 = 0;
        r0.setBearing(r1);
        r0 = r15.O0000OoO;
    L_0x0256:
        r0.setSpeed(r1);
        r0 = r15.O0000OoO;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0O0OOO.O00000o():com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public final void O00000o0() {
        if (this.O0000o0o.length() > 0) {
            this.O0000o0o.delete(0, this.O0000o0o.length());
        }
    }

    public final void O00000oO() {
        try {
            O000000o(this.O000000o);
            O000000o(this.O0000Oo);
            Context context = this.O000000o;
            O0000Oo0();
            O000000o(O000000o(true, true));
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Aps", "doFusionLocation");
        }
    }

    @SuppressLint({"NewApi"})
    public final void O00000oo() {
        this.O000O0o0 = null;
        this.O0000ooo = false;
        this.O00oOooO = false;
        if (this.O000O0o != null) {
            this.O000O0o.O00000o();
        }
        if (this.O00000oo != null) {
            this.O00000oo.O000000o();
        }
        if (this.O00000oO != null) {
            this.O00000oO.O00000Oo(this.O000000o);
        }
        if (this.O00oOoOo != null) {
            this.O00oOoOo.O000000o();
        }
        if (this.O0000O0o != null) {
            this.O0000O0o = null;
        }
        OO000OO.O0000OOo();
        try {
            if (!(this.O000000o == null || this.O0000Oo0 == null)) {
                this.O000000o.unregisterReceiver(this.O0000Oo0);
            }
        } catch (Throwable th) {
            this.O0000Oo0 = null;
        }
        this.O0000Oo0 = null;
        if (this.O00000o != null) {
            this.O00000o.O0000OOo();
        }
        if (this.O00000o0 != null) {
            this.O00000o0.O0000OoO();
        }
        if (this.O0000OOo != null) {
            this.O0000OOo.clear();
        }
        if (this.O000O00o != null) {
            this.O000O00o.O00000oo();
        }
        O0OOo.O00000oO();
        this.O0000OoO = null;
        this.O000000o = null;
        this.O0000ooO = null;
        this.O000OO00 = null;
    }

    public final void O0000O0o() {
        try {
            if (this.O00000oo != null) {
                this.O00000oo.O00000o0();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Aps", "bindAMapService");
        }
    }

    public final void O0000OOo() {
        try {
            if (this.O00000oo != null) {
                this.O00000oo.O00000o();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Aps", "bindOtherService");
        }
    }

    public final AMapLocationServer O0000Oo() {
        int i;
        String str;
        if (this.O00000o0.O0000Oo0()) {
            i = 15;
            str = "networkLocation has been mocked!#1502";
        } else if (TextUtils.isEmpty(this.O000OOo0)) {
            i = this.O00oOooo;
            str = this.O0000o0o.toString();
        } else {
            AMapLocationServer O000000o = this.O00000oO.O000000o(this.O000000o, this.O000OOo0, this.O0000ooO, true);
            if (OO000OO.O000000o(O000000o)) {
                O00000Oo(O000000o);
            }
            return O000000o;
        }
        return O000000o(i, str);
    }

    public final void O0000Oo0() {
        try {
            if (!this.O0000ooo) {
                if (this.O000OOo0 != null) {
                    this.O000OOo0 = null;
                }
                if (this.O0000ooO != null) {
                    this.O0000ooO.delete(0, this.O0000ooO.length());
                }
                if (this.O0000oOo) {
                    O0000o00();
                }
                this.O00000o0.O00000Oo(this.O0000oOo);
                this.O0000OOo = this.O00000o0.O00000o0();
                this.O00000o.O000000o(true, O0000o0O());
                this.O000OOo0 = O0000o0();
                if (!TextUtils.isEmpty(this.O000OOo0)) {
                    this.O0000ooO = O000000o(this.O0000ooO);
                }
                this.O0000ooo = true;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Aps", "initFirstLocateParam");
        }
    }

    public final void O0000OoO() {
        if (this.O000O0o != null) {
            this.O000O0o.O00000Oo();
        }
    }
}
