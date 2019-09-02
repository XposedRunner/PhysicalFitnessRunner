package com.autonavi.amap.mapcore;

import android.location.Location;
import com.amap.api.mapcore.util.bp;
import com.amap.api.mapcore.util.bt;
import org.json.JSONObject;

public class Inner_3dMap_location extends Location implements Cloneable {
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
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    private String adCode = "";
    private String address = "";
    private String aoiName = "";
    protected String buildingId = "";
    private String city = "";
    private String cityCode = "";
    private String country = "";
    protected String desc = "";
    private String district = "";
    private int errorCode = 0;
    private String errorInfo = "success";
    protected String floor = "";
    private boolean isOffset = true;
    private double latitude = 0.0d;
    private String locationDetail = "";
    private int locationType = 0;
    private double longitude = 0.0d;
    private String number = "";
    private String poiName = "";
    private String province = "";
    private String road = "";
    private int satellites = 0;
    private int signalIntensity = -1;
    private String street = "";

    public Inner_3dMap_location(Location location) {
        super(location);
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }

    public Inner_3dMap_location(String str) {
        super(str);
    }

    public Inner_3dMap_location clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location((Location) this);
        inner_3dMap_location.setProvince(this.province);
        inner_3dMap_location.setCity(this.city);
        inner_3dMap_location.setDistrict(this.district);
        inner_3dMap_location.setCityCode(this.cityCode);
        inner_3dMap_location.setAdCode(this.adCode);
        inner_3dMap_location.setAddress(this.address);
        inner_3dMap_location.setPoiName(this.poiName);
        inner_3dMap_location.setCountry(this.country);
        inner_3dMap_location.setRoad(this.road);
        inner_3dMap_location.setStreet(this.street);
        inner_3dMap_location.setNumber(this.number);
        inner_3dMap_location.setOffset(this.isOffset);
        inner_3dMap_location.setErrorCode(this.errorCode);
        inner_3dMap_location.setErrorInfo(this.errorInfo);
        inner_3dMap_location.setLocationDetail(this.locationDetail);
        inner_3dMap_location.setLocationType(this.locationType);
        inner_3dMap_location.setLatitude(this.latitude);
        inner_3dMap_location.setLongitude(this.longitude);
        inner_3dMap_location.setSatellites(this.satellites);
        inner_3dMap_location.setAoiName(this.aoiName);
        inner_3dMap_location.setBuildingId(this.buildingId);
        inner_3dMap_location.setFloor(this.floor);
        inner_3dMap_location.setGpsAccuracyStatus(this.signalIntensity);
        inner_3dMap_location.setExtras(getExtras());
        return inner_3dMap_location;
    }

    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.adCode;
    }

    public String getAddress() {
        return this.address;
    }

    public double getAltitude() {
        return super.getAltitude();
    }

    public String getAoiName() {
        return this.aoiName;
    }

    public float getBearing() {
        return super.getBearing();
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDistrict() {
        return this.district;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.errorInfo);
        if (this.errorCode != 0) {
            stringBuilder.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            StringBuilder stringBuilder2 = new StringBuilder(",错误详细信息:");
            stringBuilder2.append(this.locationDetail);
            stringBuilder.append(stringBuilder2.toString());
        }
        this.errorInfo = stringBuilder.toString();
        return this.errorInfo;
    }

    public String getFloor() {
        return this.floor;
    }

    public int getGpsAccuracyStatus() {
        return this.signalIntensity;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationDetail() {
        return this.locationDetail;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public String getProvider() {
        return super.getProvider();
    }

    public String getProvince() {
        return this.province;
    }

    public String getRoad() {
        return this.road;
    }

    public int getSatellites() {
        return this.satellites;
    }

    public float getSpeed() {
        return super.getSpeed();
    }

    public String getStreet() {
        return this.street;
    }

    public String getStreetNum() {
        return this.number;
    }

    public boolean isOffset() {
        return this.isOffset;
    }

    public void setAdCode(String str) {
        this.adCode = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAoiName(String str) {
        this.aoiName = str;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setErrorCode(int i) {
        if (this.errorCode == 0) {
            this.errorInfo = bt.O00000Oo(i);
            this.errorCode = i;
        }
    }

    public void setErrorInfo(String str) {
        this.errorInfo = str;
    }

    public void setFloor(String str) {
        this.floor = str;
    }

    public void setGpsAccuracyStatus(int i) {
        this.signalIntensity = i;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLocationDetail(String str) {
        this.locationDetail = str;
    }

    public void setLocationType(int i) {
        this.locationType = i;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setOffset(boolean z) {
        this.isOffset = z;
    }

    public void setPoiName(String str) {
        this.poiName = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRoad(String str) {
        this.road = str;
    }

    public void setSatellites(int i) {
        this.satellites = i;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public org.json.JSONObject toJson(int r4) {
        /*
        r3 = this;
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00e1 }
        r0.<init>();	 Catch:{ Throwable -> 0x00e1 }
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
        r1 = r3.cityCode;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "desc";
        r1 = r3.desc;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "adcode";
        r1 = r3.adCode;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "country";
        r1 = r3.country;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "province";
        r1 = r3.province;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "city";
        r1 = r3.city;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "district";
        r1 = r3.district;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "road";
        r1 = r3.road;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "street";
        r1 = r3.street;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "number";
        r1 = r3.number;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "poiname";
        r1 = r3.poiName;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "errorCode";
        r1 = r3.errorCode;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "errorInfo";
        r1 = r3.errorInfo;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "locationType";
        r1 = r3.locationType;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "locationDetail";
        r1 = r3.locationDetail;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "aoiname";
        r1 = r3.aoiName;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "address";
        r1 = r3.address;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "poiid";
        r1 = r3.buildingId;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "floor";
        r1 = r3.floor;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
    L_0x00ab:
        r4 = "time";
        r1 = r3.getTime();	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
    L_0x00b4:
        r4 = "provider";
        r1 = r3.getProvider();	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "lon";
        r1 = r3.getLongitude();	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "lat";
        r1 = r3.getLatitude();	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "accuracy";
        r1 = r3.getAccuracy();	 Catch:{ Throwable -> 0x00e1 }
        r1 = (double) r1;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "isOffset";
        r1 = r3.isOffset;	 Catch:{ Throwable -> 0x00e1 }
        r0.put(r4, r1);	 Catch:{ Throwable -> 0x00e1 }
        return r0;
    L_0x00e1:
        r4 = move-exception;
        r0 = 0;
        r1 = "AmapLoc";
        r2 = "toStr";
        com.amap.api.mapcore.util.bp.O000000o(r4, r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.amap.mapcore.Inner_3dMap_location.toJson(int):org.json.JSONObject");
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i) {
        JSONObject toJson;
        try {
            toJson = toJson(i);
        } catch (Throwable th) {
            bp.O000000o(th, "AMapLocation", "toStr part2");
            toJson = null;
        }
        return toJson == null ? null : toJson.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StringBuilder stringBuilder = new StringBuilder("latitude=");
            stringBuilder.append(this.latitude);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("longitude=");
            stringBuilder.append(this.longitude);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("province=");
            stringBuilder.append(this.province);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("city=");
            stringBuilder.append(this.city);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("district=");
            stringBuilder.append(this.district);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("cityCode=");
            stringBuilder.append(this.cityCode);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("adCode=");
            stringBuilder.append(this.adCode);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("address=");
            stringBuilder.append(this.address);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("country=");
            stringBuilder.append(this.country);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("road=");
            stringBuilder.append(this.road);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("poiName=");
            stringBuilder.append(this.poiName);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("street=");
            stringBuilder.append(this.street);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("streetNum=");
            stringBuilder.append(this.number);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("aoiName=");
            stringBuilder.append(this.aoiName);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("poiid=");
            stringBuilder.append(this.buildingId);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("floor=");
            stringBuilder.append(this.floor);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("errorCode=");
            stringBuilder.append(this.errorCode);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("errorInfo=");
            stringBuilder.append(this.errorInfo);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("locationDetail=");
            stringBuilder.append(this.locationDetail);
            stringBuilder.append("#");
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("locationType=");
            stringBuilder.append(this.locationType);
            stringBuffer.append(stringBuilder.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
