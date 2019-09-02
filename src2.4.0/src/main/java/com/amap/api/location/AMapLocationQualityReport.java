package com.amap.api.location;

import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;

public class AMapLocationQualityReport implements Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;
    AMapLocationMode a = AMapLocationMode.Hight_Accuracy;
    private boolean b = false;
    private int c = 2;
    private int d = 0;
    private String e = "UNKNOWN";
    private long f = 0;
    private boolean g = false;

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|5) */
    /* JADX WARNING: Missing block: B:6:0x002c, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:0x002d, code skipped:
            com.loc.O0o0000.O000000o(r1, "AMapLocationQualityReport", "clone");
     */
    /* JADX WARNING: Missing block: B:8:0x0034, code skipped:
            return r0;
     */
    public com.amap.api.location.AMapLocationQualityReport clone() {
        /*
        r4 = this;
        r0 = new com.amap.api.location.AMapLocationQualityReport;
        r0.<init>();
        super.clone();	 Catch:{ Throwable -> 0x0008 }
    L_0x0008:
        r1 = r4.c;	 Catch:{ Throwable -> 0x002c }
        r0.setGpsStatus(r1);	 Catch:{ Throwable -> 0x002c }
        r1 = r4.d;	 Catch:{ Throwable -> 0x002c }
        r0.setGPSSatellites(r1);	 Catch:{ Throwable -> 0x002c }
        r1 = r4.b;	 Catch:{ Throwable -> 0x002c }
        r0.setWifiAble(r1);	 Catch:{ Throwable -> 0x002c }
        r1 = r4.f;	 Catch:{ Throwable -> 0x002c }
        r0.setNetUseTime(r1);	 Catch:{ Throwable -> 0x002c }
        r1 = r4.e;	 Catch:{ Throwable -> 0x002c }
        r0.setNetworkType(r1);	 Catch:{ Throwable -> 0x002c }
        r1 = r4.a;	 Catch:{ Throwable -> 0x002c }
        r0.setLocationMode(r1);	 Catch:{ Throwable -> 0x002c }
        r1 = r4.g;	 Catch:{ Throwable -> 0x002c }
        r0.setInstallHighDangerMockApp(r1);	 Catch:{ Throwable -> 0x002c }
        return r0;
    L_0x002c:
        r1 = move-exception;
        r2 = "AMapLocationQualityReport";
        r3 = "clone";
        com.loc.O0o0000.O000000o(r1, r2, r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.AMapLocationQualityReport.clone():com.amap.api.location.AMapLocationQualityReport");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    public java.lang.String getAdviseMessage() {
        /*
        r3 = this;
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = r3.a;
        r2 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving;
        if (r1 == r2) goto L_0x0032;
    L_0x000b:
        r1 = r3.c;
        if (r1 == 0) goto L_0x0024;
    L_0x000f:
        r1 = r3.c;
        switch(r1) {
            case 1: goto L_0x001e;
            case 2: goto L_0x001b;
            case 3: goto L_0x0018;
            case 4: goto L_0x0015;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x0032;
    L_0x0015:
        r1 = "您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\n";
        goto L_0x0020;
    L_0x0018:
        r1 = "您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\n";
        goto L_0x0020;
    L_0x001b:
        r1 = "您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\n";
        goto L_0x0020;
    L_0x001e:
        r1 = "您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\n";
    L_0x0020:
        r0.append(r1);
        goto L_0x0032;
    L_0x0024:
        r1 = r3.a;
        r2 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors;
        if (r1 != r2) goto L_0x0032;
    L_0x002a:
        r1 = r3.d;
        r2 = 4;
        if (r1 >= r2) goto L_0x0032;
    L_0x002f:
        r1 = "当前GPS信号弱，位置更新可能会延迟\n";
        goto L_0x0020;
    L_0x0032:
        r1 = r3.a;
        r2 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors;
        if (r1 == r2) goto L_0x005e;
    L_0x0038:
        r1 = "DISCONNECTED";
        r2 = r3.e;
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0048;
    L_0x0042:
        r1 = "您的设备未连接到网络，无法进行网络定位\n";
    L_0x0044:
        r0.append(r1);
        goto L_0x0055;
    L_0x0048:
        r1 = "2G";
        r2 = r3.e;
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0055;
    L_0x0052:
        r1 = "您的设备网络状态不太好，网络定位可能会有延迟\n";
        goto L_0x0044;
    L_0x0055:
        r1 = r3.b;
        if (r1 != 0) goto L_0x005e;
    L_0x0059:
        r1 = "您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\n";
        r0.append(r1);
    L_0x005e:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.AMapLocationQualityReport.getAdviseMessage():java.lang.String");
    }

    public int getGPSSatellites() {
        return this.d;
    }

    public int getGPSStatus() {
        return this.c;
    }

    public long getNetUseTime() {
        return this.f;
    }

    public String getNetworkType() {
        return this.e;
    }

    public boolean isInstalledHighDangerMockApp() {
        return this.g;
    }

    public boolean isWifiAble() {
        return this.b;
    }

    public void setGPSSatellites(int i) {
        this.d = i;
    }

    public void setGpsStatus(int i) {
        this.c = i;
    }

    public void setInstallHighDangerMockApp(boolean z) {
        this.g = z;
    }

    public void setLocationMode(AMapLocationMode aMapLocationMode) {
        this.a = aMapLocationMode;
    }

    public void setNetUseTime(long j) {
        this.f = j;
    }

    public void setNetworkType(String str) {
        this.e = str;
    }

    public void setWifiAble(boolean z) {
        this.b = z;
    }
}
