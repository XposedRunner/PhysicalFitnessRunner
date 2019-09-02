package com.baidu.location;

import com.baidu.mapsdkplatform.comapi.location.CoordinateType;

public final class LocationClientOption {
    public static final int GpsFirst = 1;
    public static final int GpsOnly = 3;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;
    protected LocationMode a;
    public String addrType = "detail";
    public float autoNotifyLocSensitivity = 0.5f;
    public int autoNotifyMaxInterval = 0;
    public int autoNotifyMinDistance = 0;
    public int autoNotifyMinTimeInterval = 0;
    public String coorType = CoordinateType.GCJ02;
    public boolean disableLocCache = true;
    public boolean enableSimulateGps = false;
    public boolean isIgnoreCacheException = true;
    public boolean isIgnoreKillProcess = true;
    public boolean isNeedAltitude = false;
    public boolean isNeedAptag = false;
    public boolean isNeedAptagd = false;
    public boolean isNeedNewVersionRgc = false;
    public boolean isNeedPoiRegion = false;
    public boolean isNeedRegular = false;
    public boolean location_change_notify = false;
    public boolean mIsNeedDeviceDirect = false;
    public boolean openGps = false;
    public int priority = 1;
    public String prodName = "SDK6.0";
    public int scanSpan = 0;
    public String serviceName = "com.baidu.location.service_v2.9";
    public int timeOut = 12000;
    public int wifiCacheTimeOut = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public enum LocationMode {
        Hight_Accuracy,
        Battery_Saving,
        Device_Sensors
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.coorType = locationClientOption.coorType;
        this.addrType = locationClientOption.addrType;
        this.openGps = locationClientOption.openGps;
        this.scanSpan = locationClientOption.scanSpan;
        this.timeOut = locationClientOption.timeOut;
        this.prodName = locationClientOption.prodName;
        this.priority = locationClientOption.priority;
        this.location_change_notify = locationClientOption.location_change_notify;
        this.serviceName = locationClientOption.serviceName;
        this.disableLocCache = locationClientOption.disableLocCache;
        this.isIgnoreCacheException = locationClientOption.isIgnoreCacheException;
        this.isIgnoreKillProcess = locationClientOption.isIgnoreKillProcess;
        this.enableSimulateGps = locationClientOption.enableSimulateGps;
        this.a = locationClientOption.a;
        this.isNeedAptag = locationClientOption.isNeedAptag;
        this.isNeedAptagd = locationClientOption.isNeedAptagd;
        this.isNeedPoiRegion = locationClientOption.isNeedPoiRegion;
        this.isNeedRegular = locationClientOption.isNeedRegular;
        this.mIsNeedDeviceDirect = locationClientOption.mIsNeedDeviceDirect;
        this.isNeedAltitude = locationClientOption.isNeedAltitude;
        this.autoNotifyMaxInterval = locationClientOption.autoNotifyMaxInterval;
        this.autoNotifyLocSensitivity = locationClientOption.autoNotifyLocSensitivity;
        this.autoNotifyMinTimeInterval = locationClientOption.autoNotifyMinTimeInterval;
        this.autoNotifyMinDistance = locationClientOption.autoNotifyMinDistance;
        this.wifiCacheTimeOut = locationClientOption.wifiCacheTimeOut;
        this.isNeedNewVersionRgc = locationClientOption.isNeedNewVersionRgc;
    }

    public void SetIgnoreCacheException(boolean z) {
        this.isIgnoreCacheException = z;
    }

    /* Access modifiers changed, original: 0000 */
    public int a() {
        return this.autoNotifyMaxInterval;
    }

    /* Access modifiers changed, original: 0000 */
    public float b() {
        return this.autoNotifyLocSensitivity;
    }

    public void disableCache(boolean z) {
        this.disableLocCache = z;
    }

    public String getAddrType() {
        return this.addrType;
    }

    public int getAutoNotifyMinDistance() {
        return this.autoNotifyMinDistance;
    }

    public int getAutoNotifyMinTimeInterval() {
        return this.autoNotifyMinTimeInterval;
    }

    public String getCoorType() {
        return this.coorType;
    }

    public LocationMode getLocationMode() {
        return this.a;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getProdName() {
        return this.prodName;
    }

    public int getScanSpan() {
        return this.scanSpan;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public boolean isDisableCache() {
        return this.disableLocCache;
    }

    public boolean isLocationNotify() {
        return this.location_change_notify;
    }

    public boolean isOpenGps() {
        return this.openGps;
    }

    public boolean optionEquals(LocationClientOption locationClientOption) {
        return this.coorType.equals(locationClientOption.coorType) && this.addrType.equals(locationClientOption.addrType) && this.openGps == locationClientOption.openGps && this.scanSpan == locationClientOption.scanSpan && this.timeOut == locationClientOption.timeOut && this.prodName.equals(locationClientOption.prodName) && this.location_change_notify == locationClientOption.location_change_notify && this.priority == locationClientOption.priority && this.disableLocCache == locationClientOption.disableLocCache && this.isIgnoreCacheException == locationClientOption.isIgnoreCacheException && this.isNeedNewVersionRgc == locationClientOption.isNeedNewVersionRgc && this.isIgnoreKillProcess == locationClientOption.isIgnoreKillProcess && this.isNeedAptag == locationClientOption.isNeedAptag && this.isNeedAptagd == locationClientOption.isNeedAptagd && this.isNeedPoiRegion == locationClientOption.isNeedPoiRegion && this.isNeedRegular == locationClientOption.isNeedRegular && this.mIsNeedDeviceDirect == locationClientOption.mIsNeedDeviceDirect && this.autoNotifyMaxInterval == locationClientOption.autoNotifyMaxInterval && this.autoNotifyLocSensitivity == locationClientOption.autoNotifyLocSensitivity && this.autoNotifyMinTimeInterval == locationClientOption.autoNotifyMinTimeInterval && this.autoNotifyMinDistance == locationClientOption.autoNotifyMinDistance && this.wifiCacheTimeOut == locationClientOption.wifiCacheTimeOut && this.isNeedAltitude == locationClientOption.isNeedAltitude && this.a == locationClientOption.a;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:9:0x0016 in {2, 5, 7, 8} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    @java.lang.Deprecated
    public void setAddrType(java.lang.String r2) {
        /*
        r1 = this;
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 == 0) goto L_0x0007;
        return;
        r0 = "all";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0014;
        r2 = 1;
        r1.setIsNeedAddress(r2);
        return;
        r2 = 0;
        goto L_0x0010;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClientOption.setAddrType(java.lang.String):void");
    }

    public void setCoorType(String str) {
        str = str.toLowerCase();
        if (str.equals(CoordinateType.GCJ02) || str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09) || str.equals("bd09ll")) {
            this.coorType = str;
        }
    }

    public void setEnableSimulateGps(boolean z) {
        this.enableSimulateGps = z;
    }

    public void setIgnoreKillProcess(boolean z) {
        this.isIgnoreKillProcess = z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:5:0x000a in {1, 3, 4} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void setIsNeedAddress(boolean r1) {
        /*
        r0 = this;
        if (r1 == 0) goto L_0x0007;
        r1 = "all";
        r0.addrType = r1;
        return;
        r1 = "noaddr";
        goto L_0x0004;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClientOption.setIsNeedAddress(boolean):void");
    }

    public void setIsNeedAltitude(boolean z) {
        this.isNeedAltitude = z;
    }

    public void setIsNeedLocationDescribe(boolean z) {
        this.isNeedAptag = z;
    }

    public void setIsNeedLocationPoiList(boolean z) {
        this.isNeedAptagd = z;
    }

    public void setLocationMode(LocationMode locationMode) {
        switch (locationMode) {
            case Hight_Accuracy:
                this.openGps = true;
                this.priority = 1;
                break;
            case Battery_Saving:
                this.openGps = false;
                this.priority = 2;
                break;
            case Device_Sensors:
                this.priority = 3;
                this.openGps = true;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal this mode : ");
                stringBuilder.append(locationMode);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.a = locationMode;
    }

    public void setLocationNotify(boolean z) {
        this.location_change_notify = z;
    }

    public void setNeedDeviceDirect(boolean z) {
        this.mIsNeedDeviceDirect = z;
    }

    public void setNeedNewVersionRgc(boolean z) {
        this.isNeedNewVersionRgc = z;
    }

    public void setOpenAutoNotifyMode() {
        setOpenAutoNotifyMode(0, 0, 1);
    }

    public void setOpenAutoNotifyMode(int i, int i2, int i3) {
        int i4 = 180000;
        if (i > 180000) {
            i4 = i + 1000;
        }
        StringBuilder stringBuilder;
        if (i4 < 10000) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal this maxLocInterval : ");
            stringBuilder.append(i4);
            stringBuilder.append(" , maxLocInterval must >= ");
            stringBuilder.append(10000);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        float f;
        switch (i3) {
            case 1:
                f = 0.5f;
                break;
            case 2:
                f = 0.3f;
                break;
            case 3:
                f = 0.1f;
                break;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal this locSensitivity : ");
                stringBuilder.append(i3);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.autoNotifyLocSensitivity = f;
        this.autoNotifyMaxInterval = i4;
        this.autoNotifyMinTimeInterval = i;
        this.autoNotifyMinDistance = i2;
    }

    public void setOpenGps(boolean z) {
        this.openGps = z;
    }

    @Deprecated
    public void setPriority(int i) {
        if (i == 1 || i == 2) {
            this.priority = i;
        }
    }

    public void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.prodName = str;
    }

    public void setScanSpan(int i) {
        this.scanSpan = i;
    }

    @Deprecated
    public void setSema(boolean z, boolean z2, boolean z3) {
        this.isNeedAptag = z;
        this.isNeedPoiRegion = z2;
        this.isNeedRegular = z3;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setTimeOut(int i) {
        this.timeOut = i;
    }

    public void setWifiCacheTimeOut(int i) {
        if (i >= 10000) {
            this.wifiCacheTimeOut = i;
        }
    }
}
