package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.loc.OO0Oo0.O000000o;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: CoreUtil */
public final class O0o0000 {
    static String O000000o = "http://apilocate.amap.com/mobile/binary";
    static String O00000Oo = "";
    public static String O00000o = null;
    static String O00000o0 = "001;11B;11C;11F;11G;11H;11I;11K;122;135;13J;13S;14S;157;15O;15U";
    public static String O00000oO = null;
    public static int O00000oo = 30000;
    public static String O0000O0o;
    public static String O0000OOo;
    static HashMap<String, String> O0000Oo;
    static String O0000Oo0;
    static boolean O0000OoO;
    static boolean O0000Ooo;
    private static OO0Oo0 O0000o0;
    private static final String[] O0000o00 = new String[]{"com.amap.api.location", "com.loc", "com.amap.api.fence"};
    private static boolean O0000o0O;
    private static boolean O0000o0o;

    public static Bundle O000000o(AMapLocationClientOption aMapLocationClientOption) {
        Parcelable aMapLocationClientOption2;
        Bundle bundle = new Bundle();
        if (aMapLocationClientOption2 == null) {
            aMapLocationClientOption2 = new AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption2);
            return bundle;
        } catch (Throwable th) {
            O000000o(th, "CoreUtil", "getOptionBundle");
            return bundle;
        }
    }

    public static AMapLocation O000000o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null) {
            return aMapLocation;
        }
        try {
            aMapLocation.setCountry(aMapLocation2.getCountry());
            aMapLocation.setRoad(aMapLocation2.getRoad());
            aMapLocation.setPoiName(aMapLocation2.getPoiName());
            aMapLocation.setStreet(aMapLocation2.getStreet());
            aMapLocation.setNumber(aMapLocation2.getStreetNum());
            String cityCode = aMapLocation2.getCityCode();
            String adCode = aMapLocation2.getAdCode();
            aMapLocation.setCityCode(cityCode);
            aMapLocation.setAdCode(adCode);
            aMapLocation.setCity(aMapLocation2.getCity());
            aMapLocation.setDistrict(aMapLocation2.getDistrict());
            aMapLocation.setProvince(aMapLocation2.getProvince());
            aMapLocation.setAoiName(aMapLocation2.getAoiName());
            aMapLocation.setAddress(aMapLocation2.getAddress());
            aMapLocation.setDescription(aMapLocation2.getDescription());
            if (aMapLocation.getExtras() != null) {
                aMapLocation.getExtras().putString("citycode", aMapLocation2.getCityCode());
                aMapLocation.getExtras().putString(SocialConstants.PARAM_APP_DESC, aMapLocation2.getExtras().getString(SocialConstants.PARAM_APP_DESC));
                aMapLocation.getExtras().putString("adcode", aMapLocation2.getAdCode());
                return aMapLocation;
            }
            Bundle bundle = new Bundle();
            bundle.putString("citycode", aMapLocation2.getCityCode());
            bundle.putString(SocialConstants.PARAM_APP_DESC, aMapLocation2.getExtras().getString(SocialConstants.PARAM_APP_DESC));
            bundle.putString("adcode", aMapLocation2.getAdCode());
            aMapLocation.setExtras(bundle);
            return aMapLocation;
        } catch (Throwable unused) {
        }
    }

    public static AMapLocationClientOption O000000o(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (bundle == null) {
            return aMapLocationClientOption;
        }
        try {
            bundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
            return (AMapLocationClientOption) bundle.getParcelable("opt");
        } catch (Throwable th) {
            O000000o(th, "CoreUtil", "getOptionFromBundle");
            return aMapLocationClientOption;
        }
    }

    public static OO0Oo0 O000000o(String str, String str2) {
        try {
            return new O000000o(str, str2, "AMAP_Location_SDK_Android 4.6.0").O000000o(O00000oO()).O000000o();
        } catch (Throwable th) {
            O000000o(th, "CoreUtil", "getSDKInfo");
            return null;
        }
    }

    public static String O000000o() {
        return O000000o;
    }

    public static void O000000o(Context context) {
        try {
            if (OO0o000.O00000Oo(context)) {
                O000000o = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            if (O0000Oo == null) {
                O0000Oo = new HashMap(16);
            }
            O0000Oo.clear();
            O0000Oo.put("a9a9d23668a1a7ea93de9b21d67e436a", "F13160D440C7D0229DA95450F66AF92154AC84DF088F8CA3100B2E8131D57F3DC67124D4C466056E7A3DFBE035E1B9A4B9DA4DB68AE65A43EDFD92F5C60EF0C9");
            O0000Oo.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
            O0000Oo.put("b2e8bd171989cb2c3c13bd89b4c1067a", "239CE372F804D4BE4EAFFD183668379BDF274440E6F246AB16BBE6F5D1D30DEACFBBF0C942485727FF12288228760A9E");
            O0000Oo.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
            O0000Oo.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
            O0000Oo.put("256b0f26bb2a9506be6cfdb84028ae08", "AF2228680EDC323FBA035362EB7E1E38A0C33E1CF6F6FB805EE553A230CBA754CD9552EB9B546542CBE619E8293151BE");
            String O000000o = O0OOO0.O000000o(OO00o00.O00000oo(context));
            O0000Oo0 = O000000o;
            if (O000000o != null) {
                try {
                    if (O000000o.length() != 0 && O0000Oo != null && O0000Oo.containsKey(O000000o)) {
                        String str = (String) O0000Oo.get(O000000o);
                        String str2 = null;
                        if (str != null && str.length() > 0) {
                            str2 = new String(O0OOO0.O00000o(O000000o(str), O000000o), "utf-8");
                        }
                        if (str2 != null && str2.length() > 0 && str2.contains("http:")) {
                            O00000Oo = str2;
                            O000000o = str2;
                        }
                    }
                } catch (Throwable th) {
                    O000000o(th, "CoreUtil", "checkUrl");
                }
            }
        } catch (Throwable th2) {
            O000000o(th2, "CoreUtil", "checkUrl");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a A:{Catch:{ Throwable -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x019e A:{Catch:{ Throwable -> 0x01d0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0192 A:{Catch:{ Throwable -> 0x01d0 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x005e */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0192 A:{Catch:{ Throwable -> 0x01d0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x019e A:{Catch:{ Throwable -> 0x01d0 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0071 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057 A:{Catch:{ Throwable -> 0x005e }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a A:{Catch:{ Throwable -> 0x0071 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x019e A:{Catch:{ Throwable -> 0x01d0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0192 A:{Catch:{ Throwable -> 0x01d0 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x004b */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:2|3|4|5|(1:7)|8|9|(1:11)|12|13|(1:15)|16|17|(1:19)(2:21|(1:25)(1:24))|20|26|27) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:2|3|4|5|(1:7)|8|9|(1:11)|12|13|(1:15)|16|17|(1:19)(2:21|(1:25)(1:24))|20|26|27) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:2|3|4|5|(1:7)|8|9|(1:11)|12|13|(1:15)|16|17|(1:19)(2:21|(1:25)(1:24))|20|26|27) */
    public static void O000000o(com.amap.api.location.AMapLocation r8, org.json.JSONObject r9) {
        /*
        if (r9 == 0) goto L_0x01d8;
    L_0x0002:
        if (r8 == 0) goto L_0x01d8;
    L_0x0004:
        r0 = "lat";
        r1 = r8.getLatitude();	 Catch:{ Throwable -> 0x01d0 }
        r0 = r9.optDouble(r0, r1);	 Catch:{ Throwable -> 0x01d0 }
        r2 = "lon";
        r3 = r8.getLongitude();	 Catch:{ Throwable -> 0x01d0 }
        r2 = r9.optDouble(r2, r3);	 Catch:{ Throwable -> 0x01d0 }
        r4 = "provider";
        r5 = r8.getProvider();	 Catch:{ Throwable -> 0x01d0 }
        r4 = r9.optString(r4, r5);	 Catch:{ Throwable -> 0x01d0 }
        r8.setProvider(r4);	 Catch:{ Throwable -> 0x01d0 }
        r8.setLatitude(r0);	 Catch:{ Throwable -> 0x01d0 }
        r8.setLongitude(r2);	 Catch:{ Throwable -> 0x01d0 }
        r4 = "altitude";
        r5 = r8.getAltitude();	 Catch:{ Throwable -> 0x01d0 }
        r4 = r9.optDouble(r4, r5);	 Catch:{ Throwable -> 0x01d0 }
        r8.setAltitude(r4);	 Catch:{ Throwable -> 0x01d0 }
        r4 = "accuracy";
        r4 = r9.optString(r4);	 Catch:{ Throwable -> 0x004b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x004b }
        if (r5 != 0) goto L_0x004b;
    L_0x0044:
        r4 = java.lang.Float.parseFloat(r4);	 Catch:{ Throwable -> 0x004b }
        r8.setAccuracy(r4);	 Catch:{ Throwable -> 0x004b }
    L_0x004b:
        r4 = "speed";
        r4 = r9.optString(r4);	 Catch:{ Throwable -> 0x005e }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x005e }
        if (r5 != 0) goto L_0x005e;
    L_0x0057:
        r4 = java.lang.Float.parseFloat(r4);	 Catch:{ Throwable -> 0x005e }
        r8.setSpeed(r4);	 Catch:{ Throwable -> 0x005e }
    L_0x005e:
        r4 = "bearing";
        r4 = r9.optString(r4);	 Catch:{ Throwable -> 0x0071 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0071 }
        if (r5 != 0) goto L_0x0071;
    L_0x006a:
        r4 = java.lang.Float.parseFloat(r4);	 Catch:{ Throwable -> 0x0071 }
        r8.setBearing(r4);	 Catch:{ Throwable -> 0x0071 }
    L_0x0071:
        r4 = "adcode";
        r5 = r8.getAdCode();	 Catch:{ Throwable -> 0x01d0 }
        r4 = r9.optString(r4, r5);	 Catch:{ Throwable -> 0x01d0 }
        r8.setAdCode(r4);	 Catch:{ Throwable -> 0x01d0 }
        r4 = "citycode";
        r5 = r8.getCityCode();	 Catch:{ Throwable -> 0x01d0 }
        r4 = r9.optString(r4, r5);	 Catch:{ Throwable -> 0x01d0 }
        r8.setCityCode(r4);	 Catch:{ Throwable -> 0x01d0 }
        r4 = "address";
        r5 = r8.getAddress();	 Catch:{ Throwable -> 0x01d0 }
        r4 = r9.optString(r4, r5);	 Catch:{ Throwable -> 0x01d0 }
        r8.setAddress(r4);	 Catch:{ Throwable -> 0x01d0 }
        r4 = "desc";
        r5 = "";
        r4 = r9.optString(r4, r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "country";
        r6 = r8.getCountry();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setCountry(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "province";
        r6 = r8.getProvince();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setProvince(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "city";
        r6 = r8.getCity();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setCity(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "district";
        r6 = r8.getDistrict();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setDistrict(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "road";
        r6 = r8.getRoad();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setRoad(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "street";
        r6 = r8.getStreet();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setStreet(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "number";
        r6 = r8.getStreetNum();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setNumber(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "poiname";
        r6 = r8.getPoiName();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setPoiName(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "aoiname";
        r6 = r8.getAoiName();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setAoiName(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "errorCode";
        r6 = r8.getErrorCode();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optInt(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setErrorCode(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "errorInfo";
        r6 = r8.getErrorInfo();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setErrorInfo(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "locationType";
        r6 = r8.getLocationType();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optInt(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setLocationType(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "locationDetail";
        r6 = r8.getLocationDetail();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optString(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setLocationDetail(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "time";
        r6 = r8.getTime();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optLong(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setTime(r5);	 Catch:{ Throwable -> 0x01d0 }
        r5 = "isOffset";
        r6 = r8.isOffset();	 Catch:{ Throwable -> 0x01d0 }
        r5 = r9.optBoolean(r5, r6);	 Catch:{ Throwable -> 0x01d0 }
        r8.setOffset(r5);	 Catch:{ Throwable -> 0x01d0 }
        r6 = "poiid";
        r7 = r8.getBuildingId();	 Catch:{ Throwable -> 0x01d0 }
        r6 = r9.optString(r6, r7);	 Catch:{ Throwable -> 0x01d0 }
        r8.setBuildingId(r6);	 Catch:{ Throwable -> 0x01d0 }
        r6 = "floor";
        r7 = r8.getFloor();	 Catch:{ Throwable -> 0x01d0 }
        r6 = r9.optString(r6, r7);	 Catch:{ Throwable -> 0x01d0 }
        r8.setFloor(r6);	 Catch:{ Throwable -> 0x01d0 }
        r6 = "description";
        r7 = r8.getDescription();	 Catch:{ Throwable -> 0x01d0 }
        r6 = r9.optString(r6, r7);	 Catch:{ Throwable -> 0x01d0 }
        r8.setDescription(r6);	 Catch:{ Throwable -> 0x01d0 }
        r6 = "coordType";
        r6 = r9.has(r6);	 Catch:{ Throwable -> 0x01d0 }
        if (r6 == 0) goto L_0x019e;
    L_0x0192:
        r0 = "coordType";
        r1 = "GCJ02";
        r9 = r9.optString(r0, r1);	 Catch:{ Throwable -> 0x01d0 }
    L_0x019a:
        r8.setCoordType(r9);	 Catch:{ Throwable -> 0x01d0 }
        goto L_0x01ac;
    L_0x019e:
        r9 = O000000o(r0, r2);	 Catch:{ Throwable -> 0x01d0 }
        if (r9 == 0) goto L_0x01a9;
    L_0x01a4:
        if (r5 == 0) goto L_0x01a9;
    L_0x01a6:
        r9 = "GCJ02";
        goto L_0x019a;
    L_0x01a9:
        r9 = "WGS84";
        goto L_0x019a;
    L_0x01ac:
        r9 = new android.os.Bundle;	 Catch:{ Throwable -> 0x01d0 }
        r9.<init>();	 Catch:{ Throwable -> 0x01d0 }
        r0 = "citycode";
        r1 = r8.getCityCode();	 Catch:{ Throwable -> 0x01d0 }
        r9.putString(r0, r1);	 Catch:{ Throwable -> 0x01d0 }
        r0 = "desc";
        r1 = r4.toString();	 Catch:{ Throwable -> 0x01d0 }
        r9.putString(r0, r1);	 Catch:{ Throwable -> 0x01d0 }
        r0 = "adcode";
        r1 = r8.getAdCode();	 Catch:{ Throwable -> 0x01d0 }
        r9.putString(r0, r1);	 Catch:{ Throwable -> 0x01d0 }
        r8.setExtras(r9);	 Catch:{ Throwable -> 0x01d0 }
        return;
    L_0x01d0:
        r8 = move-exception;
        r9 = "CoreUtil";
        r0 = "transformLocation";
        O000000o(r8, r9, r0);
    L_0x01d8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0o0000.O000000o(com.amap.api.location.AMapLocation, org.json.JSONObject):void");
    }

    public static void O000000o(Throwable th, String str, String str2) {
        if (!"reportError".equals(str2)) {
            try {
                if (!(th instanceof OO00Oo0)) {
                    O0000o.O00000Oo(th, str, str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Missing block: B:18:0x0035, code skipped:
            return false;
     */
    public static boolean O000000o(double r4, double r6) {
        /*
        r0 = 4634837335261839360; // 0x4052400000000000 float:0.0 double:73.0;
        r6 = r6 - r0;
        r0 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r6 = r6 / r0;
        r6 = (int) r6;
        r2 = 4615063718147915776; // 0x400c000000000000 float:0.0 double:3.5;
        r4 = r4 - r2;
        r4 = r4 / r0;
        r4 = (int) r4;
        r5 = 0;
        if (r4 < 0) goto L_0x0035;
    L_0x0012:
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r4 >= r7) goto L_0x0035;
    L_0x0016:
        if (r6 < 0) goto L_0x0035;
    L_0x0018:
        r7 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        if (r6 < r7) goto L_0x001d;
    L_0x001c:
        return r5;
    L_0x001d:
        r7 = r7 * r4;
        r7 = r7 + r6;
        r4 = 1;
        r6 = "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000";
        r6 = r6.charAt(r7);	 Catch:{ Throwable -> 0x002c }
        r7 = 49;
        if (r6 != r7) goto L_0x002b;
    L_0x002a:
        return r4;
    L_0x002b:
        return r5;
    L_0x002c:
        r5 = move-exception;
        r6 = "CoreUtil";
        r7 = "isChina";
        O000000o(r5, r6, r7);
        return r4;
    L_0x0035:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0o0000.O000000o(double, double):boolean");
    }

    private static boolean O000000o(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2))) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fc A:{SYNTHETIC} */
    public static boolean O000000o(com.amap.api.location.DPoint r33, java.util.List<com.amap.api.location.DPoint> r34) {
        /*
        r0 = r34;
        r13 = r33.getLongitude();
        r15 = r33.getLatitude();
        r17 = r33.getLatitude();
        r11 = 0;
        r1 = r0.get(r11);
        r1 = (com.amap.api.location.DPoint) r1;
        r2 = r34.size();
        r19 = 1;
        r2 = r2 + -1;
        r2 = r0.get(r2);
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x002e;
    L_0x0027:
        r1 = r0.get(r11);
        r0.add(r1);
    L_0x002e:
        r1 = r11;
        r20 = r1;
    L_0x0031:
        r2 = r34.size();
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0102;
    L_0x0039:
        r2 = r0.get(r1);
        r2 = (com.amap.api.location.DPoint) r2;
        r21 = r2.getLongitude();
        r2 = r0.get(r1);
        r2 = (com.amap.api.location.DPoint) r2;
        r23 = r2.getLatitude();
        r12 = r1 + 1;
        r1 = r0.get(r12);
        r1 = (com.amap.api.location.DPoint) r1;
        r25 = r1.getLongitude();
        r1 = r0.get(r12);
        r1 = (com.amap.api.location.DPoint) r1;
        r27 = r1.getLatitude();
        r1 = r13;
        r3 = r15;
        r5 = r21;
        r7 = r23;
        r9 = r25;
        r30 = r11;
        r29 = r12;
        r11 = r27;
        r1 = O000000o(r1, r3, r5, r7, r9, r11);
        if (r1 == 0) goto L_0x0078;
    L_0x0077:
        return r19;
    L_0x0078:
        r11 = r27 - r23;
        r1 = java.lang.Math.abs(r11);
        r3 = 4472406533629990549; // 0x3e112e0be826d695 float:-3.1514847E24 double:1.0E-9;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 < 0) goto L_0x00fc;
    L_0x0087:
        r9 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r1 = r21;
        r3 = r23;
        r5 = r13;
        r7 = r15;
        r31 = r11;
        r11 = r17;
        r1 = O000000o(r1, r3, r5, r7, r9, r11);
        if (r1 == 0) goto L_0x00a3;
    L_0x009c:
        r1 = (r23 > r27 ? 1 : (r23 == r27 ? 0 : -1));
        if (r1 <= 0) goto L_0x00fc;
    L_0x00a0:
        r20 = r20 + 1;
        goto L_0x00fc;
    L_0x00a3:
        r9 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r1 = r25;
        r3 = r27;
        r5 = r13;
        r7 = r15;
        r11 = r17;
        r1 = O000000o(r1, r3, r5, r7, r9, r11);
        if (r1 == 0) goto L_0x00bb;
    L_0x00b6:
        r1 = (r27 > r23 ? 1 : (r27 == r23 ? 0 : -1));
        if (r1 <= 0) goto L_0x00fc;
    L_0x00ba:
        goto L_0x00a0;
    L_0x00bb:
        r25 = r25 - r21;
        r1 = r17 - r15;
        r3 = r25 * r1;
        r5 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r5 = r5 - r13;
        r11 = r31 * r5;
        r3 = r3 - r11;
        r7 = 0;
        r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r9 == 0) goto L_0x00f7;
    L_0x00d0:
        r23 = r23 - r15;
        r5 = r5 * r23;
        r21 = r21 - r13;
        r1 = r1 * r21;
        r5 = r5 - r1;
        r5 = r5 / r3;
        r23 = r23 * r25;
        r21 = r21 * r31;
        r23 = r23 - r21;
        r23 = r23 / r3;
        r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r1 < 0) goto L_0x00f7;
    L_0x00e6:
        r1 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r3 > 0) goto L_0x00f7;
    L_0x00ec:
        r3 = (r23 > r7 ? 1 : (r23 == r7 ? 0 : -1));
        if (r3 < 0) goto L_0x00f7;
    L_0x00f0:
        r3 = (r23 > r1 ? 1 : (r23 == r1 ? 0 : -1));
        if (r3 > 0) goto L_0x00f7;
    L_0x00f4:
        r1 = r19;
        goto L_0x00f9;
    L_0x00f7:
        r1 = r30;
    L_0x00f9:
        if (r1 == 0) goto L_0x00fc;
    L_0x00fb:
        goto L_0x00a0;
    L_0x00fc:
        r1 = r29;
        r11 = r30;
        goto L_0x0031;
    L_0x0102:
        r30 = r11;
        r20 = r20 % 2;
        if (r20 == 0) goto L_0x010a;
    L_0x0108:
        r30 = r19;
    L_0x010a:
        return r30;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0o0000.O000000o(com.amap.api.location.DPoint, java.util.List):boolean");
    }

    private static byte[] O000000o(String str) {
        int i = 0;
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        str = str.toLowerCase(Locale.US);
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        while (i < length) {
            int i2 = 2 * i;
            bArr[i] = (byte) (OO000OO.O0000Oo0(str.substring(i2, i2 + 2)) & 255);
            i++;
        }
        return bArr;
    }

    public static OO0Oo0 O00000Oo() {
        try {
            if (O0000o0 == null) {
                O0000o0 = new O000000o("loc", "4.6.0", "AMAP_Location_SDK_Android 4.6.0").O000000o(O00000oO()).O000000o("4.6.0").O000000o();
            }
        } catch (Throwable th) {
            O000000o(th, "CoreUtil", "getSDKInfo");
        }
        return O0000o0;
    }

    public static String O00000Oo(Context context) {
        return OO0OOOO.O00000Oo(OO00o00.O00000oO(context));
    }

    public static boolean O00000o() {
        if (!O0000OoO) {
            O0000OoO = true;
            O0000Ooo = false;
        }
        return O0000Ooo;
    }

    public static String O00000o0() {
        return O00000o0;
    }

    public static void O00000o0(Context context) {
        try {
            if (OO0o000.O00000Oo(context)) {
                O000000o = "http://abroad.apilocate.amap.com/mobile/binary";
            } else if (TextUtils.isEmpty(O00000Oo)) {
                O000000o = "http://apilocate.amap.com/mobile/binary";
            } else {
                O000000o = O00000Oo;
            }
        } catch (Throwable th) {
            O000000o(th, "CoreUtil", "changeUrl");
        }
    }

    private static String[] O00000oO() {
        return (String[]) O0000o00.clone();
    }
}
