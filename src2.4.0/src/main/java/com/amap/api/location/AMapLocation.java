package com.amap.api.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.loc.O0o0000;
import com.loc.OO000OO;
import org.json.JSONObject;

public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Creator<AMapLocation> CREATOR = new Creator<AMapLocation>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            aMapLocation.h = parcel.readString();
            aMapLocation.i = parcel.readString();
            aMapLocation.w = parcel.readString();
            aMapLocation.a = parcel.readString();
            aMapLocation.e = parcel.readString();
            aMapLocation.g = parcel.readString();
            aMapLocation.k = parcel.readString();
            aMapLocation.f = parcel.readString();
            aMapLocation.p = parcel.readInt();
            aMapLocation.q = parcel.readString();
            aMapLocation.b = parcel.readString();
            boolean z = false;
            aMapLocation.A = parcel.readInt() != 0;
            aMapLocation.o = parcel.readInt() != 0;
            aMapLocation.t = parcel.readDouble();
            aMapLocation.r = parcel.readString();
            aMapLocation.s = parcel.readInt();
            aMapLocation.u = parcel.readDouble();
            if (parcel.readInt() != 0) {
                z = true;
            }
            aMapLocation.y = z;
            aMapLocation.n = parcel.readString();
            aMapLocation.j = parcel.readString();
            aMapLocation.d = parcel.readString();
            aMapLocation.l = parcel.readString();
            aMapLocation.v = parcel.readInt();
            aMapLocation.x = parcel.readInt();
            aMapLocation.m = parcel.readString();
            aMapLocation.z = parcel.readString();
            aMapLocation.B = parcel.readString();
            aMapLocation.C = parcel.readInt();
            aMapLocation.D = parcel.readInt();
            return aMapLocation;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AMapLocation[i];
        }
    };
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private boolean A = false;
    private String B = COORD_TYPE_GCJ02;
    private int C = 1;
    private int D;
    protected String a = "";
    protected String b = "";
    AMapLocationQualityReport c = new AMapLocationQualityReport();
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private boolean o = true;
    private int p = 0;
    private String q = "success";
    private String r = "";
    private int s = 0;
    private double t = 0.0d;
    private double u = 0.0d;
    private int v = 0;
    private String w = "";
    private int x = -1;
    private boolean y = false;
    private String z = "";

    public AMapLocation(Location location) {
        super(location);
        this.t = location.getLatitude();
        this.u = location.getLongitude();
    }

    public AMapLocation(String str) {
        super(str);
    }

    public AMapLocation clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation((Location) this);
        try {
            aMapLocation.setLatitude(this.t);
            aMapLocation.setLongitude(this.u);
            aMapLocation.setAdCode(this.h);
            aMapLocation.setAddress(this.i);
            aMapLocation.setAoiName(this.w);
            aMapLocation.setBuildingId(this.a);
            aMapLocation.setCity(this.e);
            aMapLocation.setCityCode(this.g);
            aMapLocation.setCountry(this.k);
            aMapLocation.setDistrict(this.f);
            aMapLocation.setErrorCode(this.p);
            aMapLocation.setErrorInfo(this.q);
            aMapLocation.setFloor(this.b);
            aMapLocation.setFixLastLocation(this.A);
            aMapLocation.setOffset(this.o);
            aMapLocation.setLocationDetail(this.r);
            aMapLocation.setLocationType(this.s);
            aMapLocation.setMock(this.y);
            aMapLocation.setNumber(this.n);
            aMapLocation.setPoiName(this.j);
            aMapLocation.setProvince(this.d);
            aMapLocation.setRoad(this.l);
            aMapLocation.setSatellites(this.v);
            aMapLocation.setGpsAccuracyStatus(this.x);
            aMapLocation.setStreet(this.m);
            aMapLocation.setDescription(this.z);
            aMapLocation.setExtras(getExtras());
            if (this.c != null) {
                aMapLocation.setLocationQualityReport(this.c.clone());
            }
            aMapLocation.setCoordType(this.B);
            aMapLocation.setTrustedLevel(this.C);
            aMapLocation.setConScenario(this.D);
            return aMapLocation;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocation", "clone");
            return aMapLocation;
        }
    }

    public int describeContents() {
        return 0;
    }

    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.h;
    }

    public String getAddress() {
        return this.i;
    }

    public double getAltitude() {
        return super.getAltitude();
    }

    public String getAoiName() {
        return this.w;
    }

    public float getBearing() {
        return super.getBearing();
    }

    public String getBuildingId() {
        return this.a;
    }

    public String getCity() {
        return this.e;
    }

    public String getCityCode() {
        return this.g;
    }

    public int getConScenario() {
        return this.D;
    }

    public String getCoordType() {
        return this.B;
    }

    public String getCountry() {
        return this.k;
    }

    public String getDescription() {
        return this.z;
    }

    public String getDistrict() {
        return this.f;
    }

    public int getErrorCode() {
        return this.p;
    }

    public String getErrorInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.q);
        if (this.p != 0) {
            stringBuilder.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            StringBuilder stringBuilder2 = new StringBuilder(",错误详细信息:");
            stringBuilder2.append(this.r);
            stringBuilder.append(stringBuilder2.toString());
        }
        return stringBuilder.toString();
    }

    public String getFloor() {
        return this.b;
    }

    public int getGpsAccuracyStatus() {
        return this.x;
    }

    public double getLatitude() {
        return this.t;
    }

    public String getLocationDetail() {
        return this.r;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.c;
    }

    public int getLocationType() {
        return this.s;
    }

    public double getLongitude() {
        return this.u;
    }

    public String getPoiName() {
        return this.j;
    }

    public String getProvider() {
        return super.getProvider();
    }

    public String getProvince() {
        return this.d;
    }

    public String getRoad() {
        return this.l;
    }

    public int getSatellites() {
        return this.v;
    }

    public float getSpeed() {
        return super.getSpeed();
    }

    public String getStreet() {
        return this.m;
    }

    public String getStreetNum() {
        return this.n;
    }

    public int getTrustedLevel() {
        return this.C;
    }

    public boolean isFixLastLocation() {
        return this.A;
    }

    public boolean isMock() {
        return this.y;
    }

    public boolean isOffset() {
        return this.o;
    }

    public void setAdCode(String str) {
        this.h = str;
    }

    public void setAddress(String str) {
        this.i = str;
    }

    public void setAoiName(String str) {
        this.w = str;
    }

    public void setBuildingId(String str) {
        this.a = str;
    }

    public void setCity(String str) {
        this.e = str;
    }

    public void setCityCode(String str) {
        this.g = str;
    }

    public void setConScenario(int i) {
        this.D = i;
    }

    public void setCoordType(String str) {
        this.B = str;
    }

    public void setCountry(String str) {
        this.k = str;
    }

    public void setDescription(String str) {
        this.z = str;
    }

    public void setDistrict(String str) {
        this.f = str;
    }

    public void setErrorCode(int i) {
        if (this.p == 0) {
            this.q = OO000OO.O00000Oo(i);
            this.p = i;
        }
    }

    public void setErrorInfo(String str) {
        this.q = str;
    }

    public void setFixLastLocation(boolean z) {
        this.A = z;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.b = str;
    }

    public void setGpsAccuracyStatus(int i) {
        this.x = i;
    }

    public void setLatitude(double d) {
        this.t = d;
    }

    public void setLocationDetail(String str) {
        this.r = str;
    }

    public void setLocationQualityReport(AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport != null) {
            this.c = aMapLocationQualityReport;
        }
    }

    public void setLocationType(int i) {
        this.s = i;
    }

    public void setLongitude(double d) {
        this.u = d;
    }

    public void setMock(boolean z) {
        this.y = z;
    }

    public void setNumber(String str) {
        this.n = str;
    }

    public void setOffset(boolean z) {
        this.o = z;
    }

    public void setPoiName(String str) {
        this.j = str;
    }

    public void setProvince(String str) {
        this.d = str;
    }

    public void setRoad(String str) {
        this.l = str;
    }

    public void setSatellites(int i) {
        this.v = i;
    }

    public void setStreet(String str) {
        this.m = str;
    }

    public void setTrustedLevel(int i) {
        this.C = i;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public org.json.JSONObject toJson(int r4) {
        /*
        r3 = this;
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00ef }
        r0.<init>();	 Catch:{ Throwable -> 0x00ef }
        switch(r4) {
            case 1: goto L_0x0009;
            case 2: goto L_0x00ab;
            case 3: goto L_0x00b4;
            default: goto L_0x0008;
        };
    L_0x0008:
        return r0;
    L_0x0009:
        r4 = "altitude";
        r1 = r3.getAltitude();	 Catch:{ Throwable -> 0x0026 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x0026 }
        r4 = "speed";
        r1 = r3.getSpeed();	 Catch:{ Throwable -> 0x0026 }
        r1 = (double) r1;	 Catch:{ Throwable -> 0x0026 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x0026 }
        r4 = "bearing";
        r1 = r3.getBearing();	 Catch:{ Throwable -> 0x0026 }
        r1 = (double) r1;	 Catch:{ Throwable -> 0x0026 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x0026 }
    L_0x0026:
        r4 = "citycode";
        r1 = r3.g;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "adcode";
        r1 = r3.h;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "country";
        r1 = r3.k;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "province";
        r1 = r3.d;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "city";
        r1 = r3.e;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "district";
        r1 = r3.f;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "road";
        r1 = r3.l;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "street";
        r1 = r3.m;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "number";
        r1 = r3.n;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "poiname";
        r1 = r3.j;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "errorCode";
        r1 = r3.p;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "errorInfo";
        r1 = r3.q;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "locationType";
        r1 = r3.s;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "locationDetail";
        r1 = r3.r;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "aoiname";
        r1 = r3.w;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "address";
        r1 = r3.i;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "poiid";
        r1 = r3.a;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "floor";
        r1 = r3.b;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "description";
        r1 = r3.z;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
    L_0x00ab:
        r4 = "time";
        r1 = r3.getTime();	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
    L_0x00b4:
        r4 = "provider";
        r1 = r3.getProvider();	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "lon";
        r1 = r3.getLongitude();	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "lat";
        r1 = r3.getLatitude();	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "accuracy";
        r1 = r3.getAccuracy();	 Catch:{ Throwable -> 0x00ef }
        r1 = (double) r1;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "isOffset";
        r1 = r3.o;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "isFixLastLocation";
        r1 = r3.A;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        r4 = "coordType";
        r1 = r3.B;	 Catch:{ Throwable -> 0x00ef }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00ef }
        return r0;
    L_0x00ef:
        r4 = move-exception;
        r0 = 0;
        r1 = "AmapLoc";
        r2 = "toStr";
        com.loc.O0o0000.O000000o(r4, r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.AMapLocation.toJson(int):org.json.JSONObject");
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i) {
        JSONObject toJson;
        try {
            toJson = toJson(i);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocation", "toStr part2");
            toJson = null;
        }
        return toJson == null ? null : toJson.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StringBuilder stringBuilder = new StringBuilder("latitude=");
            stringBuilder.append(this.t);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("longitude=");
            stringBuilder.append(this.u);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("province=");
            stringBuilder.append(this.d);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("coordType=");
            stringBuilder.append(this.B);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("city=");
            stringBuilder.append(this.e);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("district=");
            stringBuilder.append(this.f);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("cityCode=");
            stringBuilder.append(this.g);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("adCode=");
            stringBuilder.append(this.h);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("address=");
            stringBuilder.append(this.i);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("country=");
            stringBuilder.append(this.k);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("road=");
            stringBuilder.append(this.l);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("poiName=");
            stringBuilder.append(this.j);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("street=");
            stringBuilder.append(this.m);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("streetNum=");
            stringBuilder.append(this.n);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("aoiName=");
            stringBuilder.append(this.w);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("poiid=");
            stringBuilder.append(this.a);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("floor=");
            stringBuilder.append(this.b);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("errorCode=");
            stringBuilder.append(this.p);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("errorInfo=");
            stringBuilder.append(this.q);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("locationDetail=");
            stringBuilder.append(this.r);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("description=");
            stringBuilder.append(this.z);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("locationType=");
            stringBuilder.append(this.s);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("conScenario=");
            stringBuilder.append(this.D);
            stringBuffer.append(stringBuilder.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.w);
            parcel.writeString(this.a);
            parcel.writeString(this.e);
            parcel.writeString(this.g);
            parcel.writeString(this.k);
            parcel.writeString(this.f);
            parcel.writeInt(this.p);
            parcel.writeString(this.q);
            parcel.writeString(this.b);
            parcel.writeInt(this.A);
            parcel.writeInt(this.o);
            parcel.writeDouble(this.t);
            parcel.writeString(this.r);
            parcel.writeInt(this.s);
            parcel.writeDouble(this.u);
            parcel.writeInt(this.y);
            parcel.writeString(this.n);
            parcel.writeString(this.j);
            parcel.writeString(this.d);
            parcel.writeString(this.l);
            parcel.writeInt(this.v);
            parcel.writeInt(this.x);
            parcel.writeString(this.m);
            parcel.writeString(this.z);
            parcel.writeString(this.B);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocation", "writeToParcel");
        }
    }
}
