package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.bp;

public class Inner_3dMap_locationOption implements Cloneable {
    static String APIKEY = "";
    private static Inner_3dMap_Enum_LocationProtocol locationProtocol = Inner_3dMap_Enum_LocationProtocol.HTTP;
    private long httpTimeOut = ((long) bp.O00000oo);
    private long interval = 2000;
    private boolean isGpsFirst = false;
    private boolean isKillProcess = false;
    private boolean isLocationCacheEnable = true;
    private boolean isMockEnable = false;
    private boolean isNeedAddress = true;
    private boolean isOffset = true;
    private boolean isOnceLocation = false;
    private boolean isOnceLocationLatest = false;
    private boolean isWifiActiveScan = true;
    private boolean isWifiScan = true;
    private boolean lastWifiActiveScan = true;
    private Inner_3dMap_Enum_LocationMode locationMode = Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    private boolean sensorEnable = false;

    public enum Inner_3dMap_Enum_LocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum Inner_3dMap_Enum_LocationProtocol {
        HTTP(0),
        HTTPS(1);
        
        private int value;

        private Inner_3dMap_Enum_LocationProtocol(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private Inner_3dMap_locationOption clone(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.interval = inner_3dMap_locationOption.interval;
        this.isOnceLocation = inner_3dMap_locationOption.isOnceLocation;
        this.locationMode = inner_3dMap_locationOption.locationMode;
        this.isMockEnable = inner_3dMap_locationOption.isMockEnable;
        this.isKillProcess = inner_3dMap_locationOption.isKillProcess;
        this.isGpsFirst = inner_3dMap_locationOption.isGpsFirst;
        this.isNeedAddress = inner_3dMap_locationOption.isNeedAddress;
        this.isWifiActiveScan = inner_3dMap_locationOption.isWifiActiveScan;
        this.httpTimeOut = inner_3dMap_locationOption.httpTimeOut;
        this.isOffset = inner_3dMap_locationOption.isOffset;
        this.isLocationCacheEnable = inner_3dMap_locationOption.isLocationCacheEnable;
        this.isOnceLocationLatest = inner_3dMap_locationOption.isOnceLocationLatest;
        this.sensorEnable = inner_3dMap_locationOption.isSensorEnable();
        this.isWifiScan = inner_3dMap_locationOption.isWifiScan();
        return this;
    }

    public static String getAPIKEY() {
        return APIKEY;
    }

    public static void setLocationProtocol(Inner_3dMap_Enum_LocationProtocol inner_3dMap_Enum_LocationProtocol) {
        locationProtocol = inner_3dMap_Enum_LocationProtocol;
    }

    public Inner_3dMap_locationOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new Inner_3dMap_locationOption().clone(this);
    }

    public long getHttpTimeOut() {
        return this.httpTimeOut;
    }

    public long getInterval() {
        return this.interval;
    }

    public Inner_3dMap_Enum_LocationMode getLocationMode() {
        return this.locationMode;
    }

    public Inner_3dMap_Enum_LocationProtocol getLocationProtocol() {
        return locationProtocol;
    }

    public boolean isGpsFirst() {
        return this.isGpsFirst;
    }

    public boolean isKillProcess() {
        return this.isKillProcess;
    }

    public boolean isLocationCacheEnable() {
        return this.isLocationCacheEnable;
    }

    public boolean isMockEnable() {
        return this.isMockEnable;
    }

    public boolean isNeedAddress() {
        return this.isNeedAddress;
    }

    public boolean isOffset() {
        return this.isOffset;
    }

    public boolean isOnceLocation() {
        return this.isOnceLocationLatest ? true : this.isOnceLocation;
    }

    public boolean isOnceLocationLatest() {
        return this.isOnceLocationLatest;
    }

    public boolean isSensorEnable() {
        return this.sensorEnable;
    }

    public boolean isWifiActiveScan() {
        return this.isWifiActiveScan;
    }

    public boolean isWifiScan() {
        return this.isWifiScan;
    }

    public Inner_3dMap_locationOption setGpsFirst(boolean z) {
        this.isGpsFirst = z;
        return this;
    }

    public void setHttpTimeOut(long j) {
        this.httpTimeOut = j;
    }

    public Inner_3dMap_locationOption setInterval(long j) {
        if (j <= 800) {
            j = 800;
        }
        this.interval = j;
        return this;
    }

    public Inner_3dMap_locationOption setKillProcess(boolean z) {
        this.isKillProcess = z;
        return this;
    }

    public void setLocationCacheEnable(boolean z) {
        this.isLocationCacheEnable = z;
    }

    public Inner_3dMap_locationOption setLocationMode(Inner_3dMap_Enum_LocationMode inner_3dMap_Enum_LocationMode) {
        this.locationMode = inner_3dMap_Enum_LocationMode;
        return this;
    }

    public void setMockEnable(boolean z) {
        this.isMockEnable = z;
    }

    public Inner_3dMap_locationOption setNeedAddress(boolean z) {
        this.isNeedAddress = z;
        return this;
    }

    public Inner_3dMap_locationOption setOffset(boolean z) {
        this.isOffset = z;
        return this;
    }

    public Inner_3dMap_locationOption setOnceLocation(boolean z) {
        this.isOnceLocation = z;
        return this;
    }

    public void setOnceLocationLatest(boolean z) {
        this.isOnceLocationLatest = z;
    }

    public void setSensorEnable(boolean z) {
        this.sensorEnable = z;
    }

    public void setWifiActiveScan(boolean z) {
        this.isWifiActiveScan = z;
        this.lastWifiActiveScan = z;
    }

    public void setWifiScan(boolean z) {
        this.isWifiScan = z;
        this.isWifiActiveScan = this.isWifiScan ? this.lastWifiActiveScan : false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("interval:");
        stringBuilder.append(String.valueOf(this.interval));
        stringBuilder.append("#");
        stringBuilder.append("isOnceLocation:");
        stringBuilder.append(String.valueOf(this.isOnceLocation));
        stringBuilder.append("#");
        stringBuilder.append("locationMode:");
        stringBuilder.append(String.valueOf(this.locationMode));
        stringBuilder.append("#");
        stringBuilder.append("isMockEnable:");
        stringBuilder.append(String.valueOf(this.isMockEnable));
        stringBuilder.append("#");
        stringBuilder.append("isKillProcess:");
        stringBuilder.append(String.valueOf(this.isKillProcess));
        stringBuilder.append("#");
        stringBuilder.append("isGpsFirst:");
        stringBuilder.append(String.valueOf(this.isGpsFirst));
        stringBuilder.append("#");
        stringBuilder.append("isNeedAddress:");
        stringBuilder.append(String.valueOf(this.isNeedAddress));
        stringBuilder.append("#");
        stringBuilder.append("isWifiActiveScan:");
        stringBuilder.append(String.valueOf(this.isWifiActiveScan));
        stringBuilder.append("#");
        stringBuilder.append("httpTimeOut:");
        stringBuilder.append(String.valueOf(this.httpTimeOut));
        stringBuilder.append("#");
        stringBuilder.append("isOffset:");
        stringBuilder.append(String.valueOf(this.isOffset));
        stringBuilder.append("#");
        stringBuilder.append("isLocationCacheEnable:");
        stringBuilder.append(String.valueOf(this.isLocationCacheEnable));
        stringBuilder.append("#");
        stringBuilder.append("isLocationCacheEnable:");
        stringBuilder.append(String.valueOf(this.isLocationCacheEnable));
        stringBuilder.append("#");
        stringBuilder.append("isOnceLocationLatest:");
        stringBuilder.append(String.valueOf(this.isOnceLocationLatest));
        stringBuilder.append("#");
        stringBuilder.append("sensorEnable:");
        stringBuilder.append(String.valueOf(this.sensorEnable));
        stringBuilder.append("#");
        return stringBuilder.toString();
    }
}
