package com.loc;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportUtil */
public final class ooO0Ooo {
    static AMapLocation O0000O0o;
    static boolean O0000OOo;
    private static JSONArray O0000Oo;
    private static List<O00OoO0o> O0000Oo0 = new ArrayList();
    public SparseArray<Long> O000000o = new SparseArray();
    public int O00000Oo = -1;
    String[] O00000o = new String[]{"ol", "cl", "gl", "ha", "bs", "ds"};
    public long O00000o0 = 0;
    public int O00000oO = -1;
    public long O00000oo = -1;

    public static void O000000o(long j, long j2) {
        try {
            if (!O0000OOo) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("gpsTime:");
                stringBuffer.append(OO000OO.O000000o(j, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(",");
                stringBuffer.append("sysTime:");
                stringBuffer.append(OO000OO.O000000o(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(",");
                j2 = OoO0o.O000OOOo();
                String str = "0";
                if (0 != j2) {
                    str = OO000OO.O000000o(j2, "yyyy-MM-dd HH:mm:ss.SSS");
                }
                stringBuffer.append("serverTime:");
                stringBuffer.append(str);
                O000000o("checkgpstime", stringBuffer.toString());
                if (0 != j2 && Math.abs(j - j2) < 31536000000L) {
                    stringBuffer.append(", correctError");
                    O000000o("checkgpstimeerror", stringBuffer.toString());
                }
                stringBuffer.delete(0, stringBuffer.length());
                O0000OOo = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(Context context) {
        if (context != null) {
            try {
                if (OoO0o.O0000o0O()) {
                    if (O0000Oo0 != null && O0000Oo0.size() > 0) {
                        List arrayList = new ArrayList();
                        arrayList.addAll(O0000Oo0);
                        O00OoOO0.O000000o(arrayList, context);
                        O0000Oo0.clear();
                    }
                    O00000oo(context);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ReportUtil", "destroy");
            }
        }
    }

    public static void O000000o(Context context, int i, int i2, long j, long j2) {
        if (i != -1 && i2 != -1) {
            try {
                String str = "O012";
                if (context != null) {
                    if (OoO0o.O0000o0O()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("param_int_first", i);
                        jSONObject.put("param_int_second", i2);
                        jSONObject.put("param_long_first", j);
                        jSONObject.put("param_long_second", j2);
                        O000000o(context, str, jSONObject);
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ReportUtil", "reportServiceAliveTime");
            }
        }
    }

    public static void O000000o(Context context, long j, boolean z) {
        if (context != null) {
            try {
                if (OoO0o.O0000o0O()) {
                    int intValue = Long.valueOf(j).intValue();
                    String str = "domestic";
                    if (!z) {
                        str = "abroad";
                    }
                    Context context2 = context;
                    O000000o(context2, "O015", str, null, intValue, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    public static void O000000o(Context context, AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            try {
                if (!"gps".equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                    int i;
                    String str;
                    String str2 = "domestic";
                    if (O000000o(aMapLocation)) {
                        str2 = "abroad";
                    }
                    String str3 = str2;
                    String str4;
                    if (aMapLocation.getErrorCode() != 0) {
                        int errorCode = aMapLocation.getErrorCode();
                        if (errorCode != 11) {
                            switch (errorCode) {
                                case 4:
                                case 5:
                                case 6:
                                    break;
                                default:
                                    str4 = "cache";
                                    break;
                            }
                        }
                        str4 = "net";
                        i = 0;
                        str = str4;
                    } else {
                        switch (aMapLocation.getLocationType()) {
                            case 5:
                            case 6:
                                str4 = "net";
                                break;
                            default:
                                str4 = "cache";
                                break;
                        }
                        str = str4;
                        i = 1;
                    }
                    O000000o(context, "O016", str, str3, i, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ReportUtil", "reportBatting");
            }
        }
    }

    public static void O000000o(Context context, Oo0OOo oo0OOo) {
        if (context != null) {
            try {
                if (OoO0o.O0000o0O()) {
                    AMapLocation O00000o0 = oo0OOo.O00000o0();
                    if (OO000OO.O000000o((AMapLocationServer) O00000o0) && !"gps".equalsIgnoreCase(O00000o0.getProvider()) && O00000o0.getLocationType() != 1) {
                        String str;
                        int intValue = Long.valueOf(oo0OOo.O00000Oo() - oo0OOo.O000000o()).intValue();
                        Object obj = null;
                        int intValue2 = Long.valueOf(O00000o0.k()).intValue();
                        switch (O00000o0.getLocationType()) {
                            case 5:
                            case 6:
                                str = "net";
                                break;
                            default:
                                str = "cache";
                                obj = 1;
                                break;
                        }
                        String str2 = O000000o(O00000o0) ? "abroad" : "domestic";
                        if (obj == null) {
                            O000000o(context, "O014", str2, null, intValue2, intValue);
                        }
                        O000000o(context, "O013", str, str2, intValue, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ReportUtil", "reportLBSLocUseTime");
            }
        }
    }

    public static void O000000o(Context context, String str, int i) {
        try {
            O000000o(context, "O009", i, str);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ReportUtil", "reportDexLoadDexClass");
        }
    }

    private static void O000000o(Context context, String str, int i, String str2) {
        if (context != null) {
            try {
                if (OoO0o.O0000o0O()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (i != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        jSONObject.put("param_int_first", i);
                    }
                    O000000o(context, str, jSONObject);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void O000000o(Context context, String str, String str2, String str3, int i, int i2) {
        if (context != null) {
            try {
                if (OoO0o.O0000o0O()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        jSONObject.put("param_int_first", i);
                    }
                    if (i2 != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        jSONObject.put("param_int_second", i2);
                    }
                    O000000o(context, str, jSONObject);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void O000000o(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            try {
                if (OoO0o.O0000o0O()) {
                    O00OoO0o o00OoO0o = new O00OoO0o(context, "loc", "4.6.0", str);
                    o00OoO0o.O000000o(jSONObject.toString());
                    O0000Oo0.add(o00OoO0o);
                    if (O0000Oo0.size() >= 100) {
                        List arrayList = new ArrayList();
                        arrayList.addAll(O0000Oo0);
                        O00OoOO0.O000000o(arrayList, context);
                        O0000Oo0.clear();
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ReportUtil", "applyStatistics");
            }
        }
    }

    public static void O000000o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (O0000O0o == null) {
                if (OO000OO.O000000o(aMapLocation)) {
                    O0000O0o = aMapLocation.clone();
                } else {
                    O0000O0o = aMapLocation2;
                    return;
                }
            }
            if (OO000OO.O000000o(O0000O0o) && OO000OO.O000000o(aMapLocation2)) {
                aMapLocation2 = aMapLocation2.clone();
                if (!(O0000O0o.getLocationType() == 1 || O0000O0o.getLocationType() == 9 || "gps".equalsIgnoreCase(O0000O0o.getProvider()) || O0000O0o.getLocationType() == 7 || aMapLocation2.getLocationType() == 1 || aMapLocation2.getLocationType() == 9 || "gps".equalsIgnoreCase(aMapLocation2.getProvider()) || aMapLocation2.getLocationType() == 7)) {
                    long abs = Math.abs(aMapLocation2.getTime() - O0000O0o.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float O000000o = OO000OO.O000000o(O0000O0o, aMapLocation2);
                        float f = O000000o / ((float) abs);
                        if (O000000o > 30000.0f && f > 1000.0f) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(O0000O0o.getLatitude());
                            stringBuilder.append(",");
                            stringBuilder.append(O0000O0o.getLongitude());
                            stringBuilder.append(",");
                            stringBuilder.append(O0000O0o.getAccuracy());
                            stringBuilder.append(",");
                            stringBuilder.append(O0000O0o.getLocationType());
                            stringBuilder.append(",");
                            if (aMapLocation.getTime() != 0) {
                                stringBuilder.append(OO000OO.O000000o(O0000O0o.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                stringBuilder.append(O0000O0o.getTime());
                            }
                            stringBuilder.append("#");
                            stringBuilder.append(aMapLocation2.getLatitude());
                            stringBuilder.append(",");
                            stringBuilder.append(aMapLocation2.getLongitude());
                            stringBuilder.append(",");
                            stringBuilder.append(aMapLocation2.getAccuracy());
                            stringBuilder.append(",");
                            stringBuilder.append(aMapLocation2.getLocationType());
                            stringBuilder.append(",");
                            if (aMapLocation2.getTime() != 0) {
                                stringBuilder.append(OO000OO.O000000o(aMapLocation2.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                stringBuilder.append(aMapLocation2.getTime());
                            }
                            O000000o("bigshiftstatistics", stringBuilder.toString());
                            stringBuilder.delete(0, stringBuilder.length());
                        }
                    }
                }
                O0000O0o = aMapLocation2;
            }
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(String str, int i) {
        String valueOf = String.valueOf(i);
        String str2 = "";
        switch (i) {
            case GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE /*2011*/:
                str2 = "ContextIsNull";
                break;
            case 2021:
                str2 = "OnlyMainWifi";
                break;
            case GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST /*2022*/:
                str2 = "OnlyOneWifiButNotMain";
                break;
            case 2031:
                str2 = "CreateApsReqException";
                break;
            case 2041:
                str2 = "ResponseResultIsNull";
                break;
            case 2051:
                str2 = "NeedLoginNetWork\t";
                break;
            case 2052:
                str2 = "MaybeIntercepted";
                break;
            case 2053:
                str2 = "DecryptResponseException";
                break;
            case 2054:
                str2 = "ParserDataException";
                break;
            case 2061:
                str2 = "ServerRetypeError";
                break;
            case 2062:
                str2 = "ServerLocFail";
                break;
            case 2081:
                str2 = "LocalLocException";
                break;
            case 2091:
                str2 = "InitException";
                break;
            case 2101:
                str2 = "BindAPSServiceException";
                break;
            case 2102:
                str2 = "AuthClientScodeFail";
                break;
            case 2103:
                str2 = "NotConfigAPSService";
                break;
            case 2111:
                str2 = "ErrorCgiInfo";
                break;
            case 2121:
                str2 = "NotLocPermission";
                break;
            case 2131:
                str2 = "NoCgiOAndWifiInfo";
                break;
            case 2132:
                str2 = "AirPlaneModeAndWifiOff";
                break;
            case 2133:
                str2 = "NoCgiAndWifiOff";
                break;
            case 2141:
                str2 = "NoEnoughStatellites";
                break;
            case 2151:
                str2 = "MaybeMockNetLoc";
                break;
            case 2152:
                str2 = "MaybeMockGPSLoc";
                break;
        }
        O000000o(str, valueOf, str2);
    }

    public static void O000000o(String str, String str2) {
        try {
            O0000o.O00000Oo(O0o0000.O00000Oo(), str2, str);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ReportUtil", "reportLog");
        }
    }

    public static void O000000o(String str, String str2, String str3) {
        try {
            O0000o.O000000o(O0o0000.O00000Oo(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(String str, Throwable th) {
        try {
            if (th instanceof OO00Oo0) {
                O0000o.O000000o(O0o0000.O00000Oo(), str, (OO00Oo0) th);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean O000000o(Context context, OO0Oo0 oO0Oo0) {
        try {
            return O000OOo.O00000Oo(context, oO0Oo0);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean O000000o(AMapLocation aMapLocation) {
        return OO000OO.O000000o(aMapLocation) ? !O0o0000.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(O0o0000.O000000o);
    }

    public static void O00000Oo(Context context, AMapLocation aMapLocation) {
        try {
            if (OO000OO.O000000o(aMapLocation)) {
                int i;
                int i2 = 0;
                switch (aMapLocation.getLocationType()) {
                    case 1:
                        i = 0;
                        break;
                    case 2:
                    case 4:
                        i = 1;
                        i2 = i;
                        break;
                    case 8:
                        i = 3;
                        break;
                    case 9:
                        i = 2;
                        break;
                    default:
                        i = 0;
                        break;
                }
                i2 = 1;
                if (i2 != 0) {
                    if (O0000Oo == null) {
                        O0000Oo = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lon", OO000OO.O00000o0(aMapLocation.getLongitude()));
                    jSONObject.put("lat", OO000OO.O00000o0(aMapLocation.getLatitude()));
                    jSONObject.put("type", i);
                    jSONObject.put("timestamp", OO000OO.O00000Oo());
                    if (aMapLocation.getCoordType().equalsIgnoreCase(AMapLocation.COORD_TYPE_WGS84)) {
                        jSONObject.put("coordType", 1);
                    } else {
                        jSONObject.put("coordType", 2);
                    }
                    if (i == 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("accuracy", OO000OO.O00000Oo((double) aMapLocation.getAccuracy()));
                        jSONObject2.put("altitude", OO000OO.O00000Oo(aMapLocation.getAltitude()));
                        jSONObject2.put("bearing", OO000OO.O00000Oo((double) aMapLocation.getBearing()));
                        jSONObject2.put("speed", OO000OO.O00000Oo((double) aMapLocation.getSpeed()));
                        jSONObject.put("extension", jSONObject2);
                    }
                    JSONArray put = O0000Oo.put(jSONObject);
                    O0000Oo = put;
                    if (put.length() >= OoO0o.O0000o0o()) {
                        O00000oo(context);
                    }
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ReportUtil", "recordOfflineLocLog");
        }
    }

    public static void O00000Oo(Context context, String str, int i) {
        try {
            O000000o(context, "O010", i, str);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ReportUtil", "reportDexFunction");
        }
    }

    private static void O00000oo(Context context) {
        try {
            if (O0000Oo != null && O0000Oo.length() > 0) {
                O00Oo.O000000o(new O00Oo0o0(context, O0o0000.O00000Oo(), O0000Oo.toString()), context);
                O0000Oo = null;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final void O000000o(Context context, int i) {
        try {
            if (this.O00000Oo != i) {
                if (!(this.O00000Oo == -1 || this.O00000Oo == i)) {
                    this.O000000o.append(this.O00000Oo, Long.valueOf((OO000OO.O00000o0() - this.O00000o0) + ((Long) this.O000000o.get(this.O00000Oo, Long.valueOf(0))).longValue()));
                }
                this.O00000o0 = OO000OO.O00000o0() - OO0000o.O00000Oo(context, "pref", this.O00000o[i], 0);
                this.O00000Oo = i;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ReportUtil", "setLocationType");
        }
    }

    public final void O000000o(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int i;
            switch (aMapLocationClientOption.getLocationMode()) {
                case Battery_Saving:
                    i = 4;
                    break;
                case Device_Sensors:
                    i = 5;
                    break;
                case Hight_Accuracy:
                    i = 3;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (this.O00000oO != i) {
                if (!(this.O00000oO == -1 || this.O00000oO == i)) {
                    this.O000000o.append(this.O00000oO, Long.valueOf((OO000OO.O00000o0() - this.O00000oo) + ((Long) this.O000000o.get(this.O00000oO, Long.valueOf(0))).longValue()));
                }
                this.O00000oo = OO000OO.O00000o0() - OO0000o.O00000Oo(context, "pref", this.O00000o[i], 0);
                this.O00000oO = i;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ReportUtil", "setLocationMode");
        }
    }

    public final void O00000Oo(Context context) {
        try {
            long O00000o0 = OO000OO.O00000o0() - this.O00000o0;
            if (this.O00000Oo != -1) {
                this.O000000o.append(this.O00000Oo, Long.valueOf(O00000o0 + ((Long) this.O000000o.get(this.O00000Oo, Long.valueOf(0))).longValue()));
            }
            long O00000o02 = OO000OO.O00000o0() - this.O00000oo;
            if (this.O00000oO != -1) {
                this.O000000o.append(this.O00000oO, Long.valueOf(O00000o02 + ((Long) this.O000000o.get(this.O00000oO, Long.valueOf(0))).longValue()));
            }
            int i = 0;
            while (i < this.O00000o.length) {
                O00000o0 = ((Long) this.O000000o.get(i, Long.valueOf(0))).longValue();
                if (O00000o0 > 0 && O00000o0 > OO0000o.O00000Oo(context, "pref", this.O00000o[i], 0)) {
                    OO0000o.O000000o(context, "pref", this.O00000o[i], O00000o0);
                }
                i++;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public final int O00000o(Context context) {
        try {
            long O00000Oo = OO0000o.O00000Oo(context, "pref", this.O00000o[3], 0);
            long O00000Oo2 = OO0000o.O00000Oo(context, "pref", this.O00000o[4], 0);
            long O00000Oo3 = OO0000o.O00000Oo(context, "pref", this.O00000o[5], 0);
            return (O00000Oo == 0 && O00000Oo2 == 0 && O00000Oo3 == 0) ? -1 : O00000Oo > O00000Oo2 ? O00000Oo > O00000Oo3 ? 3 : 5 : O00000Oo2 > O00000Oo3 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int O00000o0(Context context) {
        try {
            long O00000Oo = OO0000o.O00000Oo(context, "pref", this.O00000o[2], 0);
            long O00000Oo2 = OO0000o.O00000Oo(context, "pref", this.O00000o[0], 0);
            long O00000Oo3 = OO0000o.O00000Oo(context, "pref", this.O00000o[1], 0);
            if (O00000Oo == 0 && O00000Oo2 == 0 && O00000Oo3 == 0) {
                return -1;
            }
            long j = O00000Oo2 - O00000Oo;
            O00000Oo2 = O00000Oo3 - O00000Oo;
            return O00000Oo > j ? O00000Oo > O00000Oo2 ? 2 : 1 : j > O00000Oo2 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void O00000oO(Context context) {
        int i = 0;
        while (i < this.O00000o.length) {
            try {
                OO0000o.O000000o(context, "pref", this.O00000o[i], 0);
                i++;
            } catch (Throwable unused) {
                return;
            }
        }
    }
}
