package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import com.amap.api.location.DPoint;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: GpsLocation */
public final class OO00O0 {
    static AMapLocation O0000Oo;
    static long O0000OoO;
    static Object O0000Ooo = new Object();
    static long O0000o;
    static boolean O0000oOO;
    static boolean O0000oOo;
    Handler O000000o;
    LocationManager O00000Oo;
    long O00000o = 0;
    AMapLocationClientOption O00000o0;
    boolean O00000oO = false;
    O0O0o0 O00000oo = null;
    int O0000O0o = GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
    int O0000OOo = 80;
    AMapLocation O0000Oo0 = null;
    float O0000o0 = 0.0f;
    long O0000o00 = 0;
    Object O0000o0O = new Object();
    Object O0000o0o = new Object();
    boolean O0000oO = true;
    GeoLanguage O0000oO0 = GeoLanguage.DEFAULT;
    int O0000oo = 0;
    long O0000oo0 = 0;
    LocationListener O0000ooO = new LocationListener() {
        public final void onLocationChanged(Location location) {
            if (OO00O0.this.O000000o != null) {
                OO00O0.this.O000000o.removeMessages(8);
            }
            if (location != null) {
                try {
                    AMapLocation aMapLocation = new AMapLocation(location);
                    if (OO000OO.O000000o(aMapLocation)) {
                        aMapLocation.setProvider("gps");
                        aMapLocation.setLocationType(1);
                        if (!OO00O0.this.O00000oO && OO000OO.O000000o(aMapLocation)) {
                            ooO0Ooo.O000000o(OO00O0.this.O000O00o, OO000OO.O00000o0() - OO00O0.this.O000O0OO, O0o0000.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                            OO00O0.this.O00000oO = true;
                        }
                        if (OO000OO.O000000o(location, OO00O0.this.O0000ooo)) {
                            aMapLocation.setMock(true);
                            aMapLocation.setTrustedLevel(4);
                            if (!OO00O0.this.O00000o0.isMockEnable()) {
                                if (OO00O0.this.O0000oo > 3) {
                                    ooO0Ooo.O000000o(null, 2152);
                                    aMapLocation.setErrorCode(15);
                                    aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                                    aMapLocation.setLatitude(0.0d);
                                    aMapLocation.setLongitude(0.0d);
                                    aMapLocation.setAltitude(0.0d);
                                    aMapLocation.setSpeed(0.0f);
                                    aMapLocation.setAccuracy(0.0f);
                                    aMapLocation.setBearing(0.0f);
                                    aMapLocation.setExtras(null);
                                    OO00O0.this.O00000o0(aMapLocation);
                                    return;
                                }
                                OO00O0 oo00o0 = OO00O0.this;
                                oo00o0.O0000oo++;
                                return;
                            }
                        }
                        OO00O0.this.O0000oo = 0;
                        aMapLocation.setSatellites(OO00O0.this.O0000ooo);
                        OO00O0.O00000Oo(OO00O0.this, aMapLocation);
                        OO00O0.O00000o0(OO00O0.this, aMapLocation);
                        OO00O0 oo00o02 = OO00O0.this;
                        OO00O0.O00000Oo(aMapLocation);
                        aMapLocation = OO00O0.O00000o(OO00O0.this, aMapLocation);
                        OO00O0.O00000oO(OO00O0.this, aMapLocation);
                        OO00O0.this.O000000o(aMapLocation);
                        synchronized (OO00O0.this.O0000o0O) {
                            OO00O0.O000000o(OO00O0.this, aMapLocation, OO00O0.this.O00oOooo);
                        }
                        try {
                            if (OO000OO.O000000o(aMapLocation)) {
                                if (OO00O0.this.O0000Oo0 != null) {
                                    OO00O0.this.O0000o00 = location.getTime() - OO00O0.this.O0000Oo0.getTime();
                                    OO00O0.this.O0000o0 = OO000OO.O000000o(OO00O0.this.O0000Oo0, aMapLocation);
                                }
                                synchronized (OO00O0.this.O0000o0o) {
                                    OO00O0.this.O0000Oo0 = aMapLocation.clone();
                                }
                                OO00O0.this.O000O0o0 = null;
                                OO00O0.this.O000O0o = false;
                                OO00O0.this.O000O0oO = 0;
                            }
                        } catch (Throwable th) {
                            O0o0000.O000000o(th, "GpsLocation", "onLocationChangedLast");
                        }
                        OO00O0.this.O00000o0(aMapLocation);
                    }
                } catch (Throwable th2) {
                    O0o0000.O000000o(th2, "GpsLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if ("gps".equalsIgnoreCase(str)) {
                    OO00O0.this.O00000o = 0;
                    OO00O0.this.O0000ooo = 0;
                }
            } catch (Throwable unused) {
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                try {
                    OO00O0.this.O00000o = 0;
                    OO00O0.this.O0000ooo = 0;
                } catch (Throwable unused) {
                }
            }
        }
    };
    int O0000ooo = 0;
    private Context O000O00o;
    private long O000O0OO = 0;
    private int O000O0Oo = 0;
    private boolean O000O0o = false;
    private String O000O0o0 = null;
    private int O000O0oO = 0;
    private boolean O000O0oo = false;
    private Listener O00oOoOo = new Listener() {
        public final void onGpsStatusChanged(int i) {
            try {
                if (OO00O0.this.O00000Oo != null) {
                    OO00O0.this.O00oOooO = OO00O0.this.O00000Oo.getGpsStatus(OO00O0.this.O00oOooO);
                    int i2 = 0;
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                            OO00O0.this.O0000ooo = 0;
                            break;
                        case 3:
                            return;
                        case 4:
                            if (OO00O0.this.O00oOooO != null) {
                                Iterable satellites = OO00O0.this.O00oOooO.getSatellites();
                                if (satellites != null) {
                                    Iterator it = satellites.iterator();
                                    int maxSatellites = OO00O0.this.O00oOooO.getMaxSatellites();
                                    while (it.hasNext() && i2 < maxSatellites) {
                                        if (((GpsSatellite) it.next()).usedInFix()) {
                                            i2++;
                                        }
                                    }
                                }
                            }
                            OO00O0.this.O0000ooo = i2;
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    };
    GpsStatus O00oOooO = null;
    public AMapLocation O00oOooo = null;

    public OO00O0(Context context, Handler handler) {
        this.O000O00o = context;
        this.O000000o = handler;
        try {
            this.O00000Oo = (LocationManager) this.O000O00o.getSystemService("location");
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GpsLocation", "<init>");
        }
        this.O00000oo = new O0O0o0();
    }

    private void O000000o(int i, int i2, String str, long j) {
        try {
            if (this.O000000o != null && this.O00000o0.getLocationMode() == AMapLocationMode.Device_Sensors) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setProvider("gps");
                aMapLocation.setErrorCode(i2);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(1);
                obtain.obj = aMapLocation;
                obtain.what = i;
                this.O000000o.sendMessageDelayed(obtain, j);
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void O000000o(OO00O0 oo00o0, AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null && oo00o0.O00000o0.isNeedAddress() && OO000OO.O000000o(aMapLocation, aMapLocation2) < ((float) oo00o0.O0000O0o)) {
            O0o0000.O000000o(aMapLocation, aMapLocation2);
        }
    }

    private static boolean O000000o(LocationManager locationManager) {
        try {
            if (O0000oOO) {
                return O0000oOo;
            }
            List allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                O0000oOo = false;
            } else {
                O0000oOo = allProviders.contains("gps");
            }
            O0000oOO = true;
            return O0000oOo;
        } catch (Throwable unused) {
            return O0000oOo;
        }
    }

    private boolean O000000o(String str) {
        try {
            ArrayList O00000o = OO000OO.O00000o(str);
            ArrayList O00000o2 = OO000OO.O00000o(this.O000O0o0);
            return (O00000o == null || O00000o.size() < 8 || O00000o2 == null || O00000o2.size() < 8) ? false : OO000OO.O000000o(this.O000O0o0, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    static /* synthetic */ void O00000Oo(OO00O0 oo00o0, AMapLocation aMapLocation) {
        try {
            if (O0o0000.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && oo00o0.O00000o0.isOffset()) {
                DPoint O000000o = O0o00.O000000o(oo00o0.O000O00o, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(O000000o.getLatitude());
                aMapLocation.setLongitude(O000000o.getLongitude());
                aMapLocation.setOffset(oo00o0.O00000o0.isOffset());
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    static /* synthetic */ AMapLocation O00000o(OO00O0 oo00o0, AMapLocation aMapLocation) {
        if (!OO000OO.O000000o(aMapLocation) || oo00o0.O000O0Oo < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return oo00o0.O00000oo.O000000o(aMapLocation);
    }

    private void O00000o(AMapLocation aMapLocation) {
        if (this.O000000o != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.O000000o.sendMessage(obtain);
        }
    }

    private void O00000o0(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 15 && !AMapLocationMode.Device_Sensors.equals(this.O00000o0.getLocationMode())) {
            return;
        }
        if (!this.O00000o0.getLocationMode().equals(AMapLocationMode.Device_Sensors) || this.O00000o0.getDeviceModeDistanceFilter() <= 0.0f) {
            if (OO000OO.O00000o0() - this.O0000oo0 >= this.O00000o0.getInterval() - 200) {
                this.O0000oo0 = OO000OO.O00000o0();
                O00000o(aMapLocation);
            }
            return;
        }
        O00000o(aMapLocation);
    }

    static /* synthetic */ void O00000o0(OO00O0 oo00o0, AMapLocation aMapLocation) {
        try {
            if (oo00o0.O0000ooo >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (oo00o0.O0000ooo == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void O00000oO(OO00O0 oo00o0, AMapLocation aMapLocation) {
        if (OO000OO.O000000o(aMapLocation)) {
            oo00o0.O00000o = OO000OO.O00000o0();
            synchronized (O0000Ooo) {
                O0000OoO = OO000OO.O00000o0();
                O0000Oo = aMapLocation.clone();
            }
            oo00o0.O000O0Oo++;
        }
    }

    private static boolean O0000O0o() {
        try {
            return ((Boolean) O0o.O000000o(OO0o000.O00000o0("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), OO0o000.O00000o0("UaXNOYXZpU3RhcnRlZA=="), null, null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be A:{Catch:{ Throwable -> 0x00eb }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x008c */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private com.amap.api.location.AMapLocation O0000OOo() {
        /*
        r15 = this;
        r0 = 0;
        r1 = r15.O0000Oo0;	 Catch:{ Throwable -> 0x00eb }
        r1 = com.loc.OO000OO.O000000o(r1);	 Catch:{ Throwable -> 0x00eb }
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = com.loc.OoO0o.O00oOooO();	 Catch:{ Throwable -> 0x00eb }
        if (r1 != 0) goto L_0x0011;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = O0000O0o();	 Catch:{ Throwable -> 0x00eb }
        if (r1 == 0) goto L_0x00eb;
    L_0x0017:
        r1 = "KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk=";
        r1 = com.loc.OO0o000.O00000o0(r1);	 Catch:{ Throwable -> 0x00eb }
        r2 = "UZ2V0TmF2aUxvY2F0aW9u";
        r2 = com.loc.OO0o000.O00000o0(r2);	 Catch:{ Throwable -> 0x00eb }
        r1 = com.loc.O0o.O000000o(r1, r2, r0, r0);	 Catch:{ Throwable -> 0x00eb }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00eb }
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00eb }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x00eb }
        r1 = "time";
        r3 = r2.optLong(r1);	 Catch:{ Throwable -> 0x00eb }
        r1 = r15.O000O0oo;	 Catch:{ Throwable -> 0x00eb }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r1 = 1;
        r15.O000O0oo = r1;	 Catch:{ Throwable -> 0x00eb }
        r1 = "useNaviLoc";
        r5 = "use NaviLoc";
        com.loc.ooO0Ooo.O000000o(r1, r5);	 Catch:{ Throwable -> 0x00eb }
    L_0x0042:
        r5 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x00eb }
        r7 = r5 - r3;
        r5 = 5500; // 0x157c float:7.707E-42 double:2.7174E-320;
        r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r1 > 0) goto L_0x00eb;
    L_0x004e:
        r1 = "lat";
        r5 = 0;
        r7 = r2.optDouble(r1, r5);	 Catch:{ Throwable -> 0x00eb }
        r1 = "lng";
        r9 = r2.optDouble(r1, r5);	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        r11 = "accuracy";
        r12 = "0";
        r11 = r2.optString(r11, r12);	 Catch:{ NumberFormatException -> 0x006a }
        r11 = java.lang.Float.parseFloat(r11);	 Catch:{ NumberFormatException -> 0x006a }
        goto L_0x006b;
    L_0x006a:
        r11 = r1;
    L_0x006b:
        r12 = "altitude";
        r5 = r2.optDouble(r12, r5);	 Catch:{ Throwable -> 0x00eb }
        r12 = "bearing";
        r13 = "0";
        r12 = r2.optString(r12, r13);	 Catch:{ NumberFormatException -> 0x007e }
        r12 = java.lang.Float.parseFloat(r12);	 Catch:{ NumberFormatException -> 0x007e }
        goto L_0x007f;
    L_0x007e:
        r12 = r1;
    L_0x007f:
        r13 = "speed";
        r14 = "0";
        r2 = r2.optString(r13, r14);	 Catch:{ NumberFormatException -> 0x008c }
        r2 = java.lang.Float.parseFloat(r2);	 Catch:{ NumberFormatException -> 0x008c }
        r1 = r2;
    L_0x008c:
        r2 = new com.amap.api.location.AMapLocation;	 Catch:{ Throwable -> 0x00eb }
        r13 = "lbs";
        r2.<init>(r13);	 Catch:{ Throwable -> 0x00eb }
        r13 = 9;
        r2.setLocationType(r13);	 Catch:{ Throwable -> 0x00eb }
        r2.setLatitude(r7);	 Catch:{ Throwable -> 0x00eb }
        r2.setLongitude(r9);	 Catch:{ Throwable -> 0x00eb }
        r2.setAccuracy(r11);	 Catch:{ Throwable -> 0x00eb }
        r2.setAltitude(r5);	 Catch:{ Throwable -> 0x00eb }
        r2.setBearing(r12);	 Catch:{ Throwable -> 0x00eb }
        r2.setSpeed(r1);	 Catch:{ Throwable -> 0x00eb }
        r2.setTime(r3);	 Catch:{ Throwable -> 0x00eb }
        r5 = "GCJ02";
        r2.setCoordType(r5);	 Catch:{ Throwable -> 0x00eb }
        r5 = r15.O0000Oo0;	 Catch:{ Throwable -> 0x00eb }
        r5 = com.loc.OO000OO.O000000o(r2, r5);	 Catch:{ Throwable -> 0x00eb }
        r6 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 > 0) goto L_0x00eb;
    L_0x00be:
        r5 = r15.O0000o0o;	 Catch:{ Throwable -> 0x00eb }
        monitor-enter(r5);	 Catch:{ Throwable -> 0x00eb }
        r6 = r15.O0000Oo0;	 Catch:{ all -> 0x00e8 }
        r6.setLongitude(r9);	 Catch:{ all -> 0x00e8 }
        r6 = r15.O0000Oo0;	 Catch:{ all -> 0x00e8 }
        r6.setLatitude(r7);	 Catch:{ all -> 0x00e8 }
        r6 = r15.O0000Oo0;	 Catch:{ all -> 0x00e8 }
        r6.setAccuracy(r11);	 Catch:{ all -> 0x00e8 }
        r6 = r15.O0000Oo0;	 Catch:{ all -> 0x00e8 }
        r6.setBearing(r12);	 Catch:{ all -> 0x00e8 }
        r6 = r15.O0000Oo0;	 Catch:{ all -> 0x00e8 }
        r6.setSpeed(r1);	 Catch:{ all -> 0x00e8 }
        r1 = r15.O0000Oo0;	 Catch:{ all -> 0x00e8 }
        r1.setTime(r3);	 Catch:{ all -> 0x00e8 }
        r1 = r15.O0000Oo0;	 Catch:{ all -> 0x00e8 }
        r3 = "GCJ02";
        r1.setCoordType(r3);	 Catch:{ all -> 0x00e8 }
        monitor-exit(r5);	 Catch:{ all -> 0x00e8 }
        return r2;
    L_0x00e8:
        r1 = move-exception;
        monitor-exit(r5);	 Catch:{ Throwable -> 0x00eb }
        throw r1;	 Catch:{ Throwable -> 0x00eb }
    L_0x00eb:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO00O0.O0000OOo():com.amap.api.location.AMapLocation");
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ac A:{RETURN} */
    public final com.amap.api.location.AMapLocation O000000o(com.amap.api.location.AMapLocation r19, java.lang.String r20) {
        /*
        r18 = this;
        r1 = r18;
        r3 = r20;
        r4 = r1.O0000Oo0;
        if (r4 != 0) goto L_0x0009;
    L_0x0008:
        return r19;
    L_0x0009:
        r4 = r1.O00000o0;
        r4 = r4.isMockEnable();
        if (r4 != 0) goto L_0x001a;
    L_0x0011:
        r4 = r1.O0000Oo0;
        r4 = r4.isMock();
        if (r4 == 0) goto L_0x001a;
    L_0x0019:
        return r19;
    L_0x001a:
        r4 = r1.O0000Oo0;
        r4 = com.loc.OO000OO.O000000o(r4);
        if (r4 != 0) goto L_0x0023;
    L_0x0022:
        return r19;
    L_0x0023:
        r4 = r18.O0000OOo();
        r5 = 2;
        if (r4 == 0) goto L_0x0034;
    L_0x002a:
        r6 = com.loc.OO000OO.O000000o(r4);
        if (r6 == 0) goto L_0x0034;
    L_0x0030:
        r4.setTrustedLevel(r5);
        return r4;
    L_0x0034:
        r4 = r1.O0000Oo0;
        r4 = r4.getSpeed();
        r6 = 0;
        r7 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        r8 = 0;
        if (r7 != 0) goto L_0x005b;
    L_0x0041:
        r10 = r1.O0000o00;
        r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r7 <= 0) goto L_0x005b;
    L_0x0047:
        r10 = r1.O0000o00;
        r12 = 8;
        r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r7 >= 0) goto L_0x005b;
    L_0x004f:
        r7 = r1.O0000o0;
        r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r7 <= 0) goto L_0x005b;
    L_0x0055:
        r4 = r1.O0000o0;
        r10 = r1.O0000o00;
        r7 = (float) r10;
        r4 = r4 / r7;
    L_0x005b:
        r7 = 0;
        r10 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        if (r19 == 0) goto L_0x009f;
    L_0x0060:
        r12 = com.loc.OO000OO.O000000o(r19);
        if (r12 == 0) goto L_0x009f;
    L_0x0066:
        r12 = r19.getAccuracy();
        r13 = 1128792064; // 0x43480000 float:200.0 double:5.5769738E-315;
        r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1));
        r13 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        if (r12 >= 0) goto L_0x008c;
    L_0x0072:
        r12 = r1.O000O0oO;
        r14 = 1;
        r12 = r12 + r14;
        r1.O000O0oO = r12;
        r12 = r1.O000O0o0;
        if (r12 != 0) goto L_0x0082;
    L_0x007c:
        r12 = r1.O000O0oO;
        if (r12 < r5) goto L_0x0082;
    L_0x0080:
        r1.O000O0o = r14;
    L_0x0082:
        r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1));
        if (r4 <= 0) goto L_0x0089;
    L_0x0086:
        r12 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        goto L_0x00a0;
    L_0x0089:
        r12 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        goto L_0x00a0;
    L_0x008c:
        r12 = r1.O000O0o0;
        r12 = android.text.TextUtils.isEmpty(r12);
        if (r12 != 0) goto L_0x0098;
    L_0x0094:
        r1.O000O0o = r7;
        r1.O000O0oO = r7;
    L_0x0098:
        r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1));
        if (r4 <= 0) goto L_0x009f;
    L_0x009c:
        r12 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        goto L_0x00a0;
    L_0x009f:
        r12 = r10;
    L_0x00a0:
        r14 = com.loc.OO000OO.O00000o0();
        r5 = r1.O00000o;
        r16 = r14 - r5;
        r4 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x00ad;
    L_0x00ac:
        return r19;
    L_0x00ad:
        r4 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1));
        if (r4 < 0) goto L_0x00db;
    L_0x00b1:
        r4 = r1.O000O0o;
        if (r4 == 0) goto L_0x00c6;
    L_0x00b5:
        r3 = r1.O000000o(r3);
        if (r3 == 0) goto L_0x00c6;
    L_0x00bb:
        r2 = r1.O0000Oo0;
        r2 = r2.clone();
        r3 = 3;
        r2.setTrustedLevel(r3);
        return r2;
    L_0x00c6:
        r3 = 0;
        r1.O000O0o0 = r3;
        r1.O000O0oO = r7;
        r4 = r1.O0000o0o;
        monitor-enter(r4);
        r1.O0000Oo0 = r3;	 Catch:{ all -> 0x00d7 }
        monitor-exit(r4);	 Catch:{ all -> 0x00d7 }
        r1.O0000o00 = r8;
        r3 = 0;
        r1.O0000o0 = r3;
        return r19;
    L_0x00d7:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r4);
        throw r2;
    L_0x00db:
        r2 = r1.O000O0o0;
        if (r2 != 0) goto L_0x00e7;
    L_0x00df:
        r2 = r1.O000O0oO;
        r4 = 2;
        if (r2 < r4) goto L_0x00e8;
    L_0x00e4:
        r1.O000O0o0 = r3;
        goto L_0x00e8;
    L_0x00e7:
        r4 = 2;
    L_0x00e8:
        r2 = r1.O0000Oo0;
        r2 = r2.clone();
        r2.setTrustedLevel(r4);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO00O0.O000000o(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014 A:{Catch:{ Throwable -> 0x001b }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A:{Catch:{ Throwable -> 0x0026 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0010 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A:{Catch:{ Throwable -> 0x0026 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001b */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|(1:6)|7|8|(1:10)|11|12|(1:14)|15|17) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|(1:6)|7|8|(1:10)|11|12|(1:14)|15|17) */
    public final void O000000o() {
        /*
        r4 = this;
        r0 = r4.O00000Oo;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r4.O0000ooO;	 Catch:{ Throwable -> 0x0010 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0010 }
        r1 = r4.O0000ooO;	 Catch:{ Throwable -> 0x0010 }
        r0.removeUpdates(r1);	 Catch:{ Throwable -> 0x0010 }
    L_0x0010:
        r0 = r4.O00oOoOo;	 Catch:{ Throwable -> 0x001b }
        if (r0 == 0) goto L_0x001b;
    L_0x0014:
        r0 = r4.O00000Oo;	 Catch:{ Throwable -> 0x001b }
        r1 = r4.O00oOoOo;	 Catch:{ Throwable -> 0x001b }
        r0.removeGpsStatusListener(r1);	 Catch:{ Throwable -> 0x001b }
    L_0x001b:
        r0 = r4.O000000o;	 Catch:{ Throwable -> 0x0026 }
        if (r0 == 0) goto L_0x0026;
    L_0x001f:
        r0 = r4.O000000o;	 Catch:{ Throwable -> 0x0026 }
        r1 = 8;
        r0.removeMessages(r1);	 Catch:{ Throwable -> 0x0026 }
    L_0x0026:
        r0 = 0;
        r4.O0000ooo = r0;
        r1 = 0;
        r4.O000O0OO = r1;
        r4.O0000oo0 = r1;
        r4.O00000o = r1;
        r4.O000O0Oo = r0;
        r4.O0000oo = r0;
        r3 = r4.O00000oo;
        r3.O000000o();
        r3 = 0;
        r4.O0000Oo0 = r3;
        r4.O0000o00 = r1;
        r1 = 0;
        r4.O0000o0 = r1;
        r4.O000O0o0 = r3;
        r4.O000O0oo = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO00O0.O000000o():void");
    }

    public final void O000000o(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.O0000O0o = bundle.getInt("I_MAX_GEO_DIS");
                this.O0000OOo = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    synchronized (this.O0000o0O) {
                        this.O00oOooo = aMapLocation;
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(AMapLocation aMapLocation) {
        if (OO000OO.O000000o(aMapLocation) && this.O000000o != null && this.O00000o0.isNeedAddress()) {
            long O00000o0 = OO000OO.O00000o0();
            if (this.O00000o0.getInterval() <= 8000 || O00000o0 - this.O0000oo0 > this.O00000o0.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.O0000o0O) {
                    Handler handler;
                    if (this.O00oOooo == null) {
                        handler = this.O000000o;
                    } else {
                        if (OO000OO.O000000o(aMapLocation, this.O00oOooo) > ((float) this.O0000OOo)) {
                            handler = this.O000000o;
                        }
                    }
                    handler.sendMessage(obtain);
                }
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0099 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0100 A:{Splitter:B:10:0x0021, ExcHandler: SecurityException (r0_36 'e' java.lang.SecurityException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:44:0x0100, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:45:0x0101, code skipped:
            r8.O0000oO = false;
            com.loc.ooO0Ooo.O000000o(null, 2121);
            r9 = new java.lang.StringBuilder();
            r9.append(r0.getMessage());
            r9.append("#1201");
            O000000o(2, 12, r9.toString(), 0);
     */
    /* JADX WARNING: Missing block: B:46:0x0127, code skipped:
            return;
     */
    public final void O000000o(com.amap.api.location.AMapLocationClientOption r9) {
        /*
        r8 = this;
        r8.O00000o0 = r9;
        r9 = r8.O00000o0;
        if (r9 != 0) goto L_0x000d;
    L_0x0006:
        r9 = new com.amap.api.location.AMapLocationClientOption;
        r9.<init>();
        r8.O00000o0 = r9;
    L_0x000d:
        r9 = r8.O000O00o;	 Catch:{ Throwable -> 0x001b }
        r0 = "pref";
        r1 = "lagt";
        r2 = O0000o;	 Catch:{ Throwable -> 0x001b }
        r0 = com.loc.OO0000o.O00000Oo(r9, r0, r1, r2);	 Catch:{ Throwable -> 0x001b }
        O0000o = r0;	 Catch:{ Throwable -> 0x001b }
    L_0x001b:
        r9 = r8.O00000Oo;
        if (r9 != 0) goto L_0x0020;
    L_0x001f:
        return;
    L_0x0020:
        r9 = 0;
        r0 = com.loc.OO000OO.O00000o0();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r2 = O0000OoO;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r4 = r0 - r2;
        r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x0052;
    L_0x002f:
        r0 = O0000Oo;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = com.loc.OO000OO.O000000o(r0);	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        if (r0 == 0) goto L_0x0052;
    L_0x0037:
        r0 = r8.O00000o0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = r0.isMockEnable();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        if (r0 != 0) goto L_0x0047;
    L_0x003f:
        r0 = O0000Oo;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = r0.isMock();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        if (r0 != 0) goto L_0x0052;
    L_0x0047:
        r0 = com.loc.OO000OO.O00000o0();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r8.O00000o = r0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = O0000Oo;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r8.O00000o0(r0);	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
    L_0x0052:
        r0 = 1;
        r8.O0000oO = r0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = android.os.Looper.myLooper();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        if (r0 != 0) goto L_0x0061;
    L_0x005b:
        r0 = r8.O000O00o;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = r0.getMainLooper();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
    L_0x0061:
        r7 = r0;
        r0 = com.loc.OO000OO.O00000o0();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r8.O000O0OO = r0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = r8.O00000Oo;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = O000000o(r0);	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        if (r0 == 0) goto L_0x00ea;
    L_0x0070:
        r0 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        r2 = O0000o;	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        r4 = r0 - r2;
        r0 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 < 0) goto L_0x0099;
    L_0x007f:
        r0 = r8.O00000Oo;	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        r1 = "gps";
        r2 = "force_xtra_injection";
        r0.sendExtraCommand(r1, r2, r9);	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        r0 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        O0000o = r0;	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        r0 = r8.O000O00o;	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        r1 = "pref";
        r2 = "lagt";
        r3 = O0000o;	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
        com.loc.OO0000o.O000000o(r0, r1, r2, r3);	 Catch:{ Throwable -> 0x0099, SecurityException -> 0x0100 }
    L_0x0099:
        r0 = r8.O00000o0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = r0.getLocationMode();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = r0.equals(r1);	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        if (r0 == 0) goto L_0x00c8;
    L_0x00a7:
        r0 = r8.O00000o0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = r0.getDeviceModeDistanceFilter();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r1 = 0;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x00c8;
    L_0x00b2:
        r1 = r8.O00000Oo;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r2 = "gps";
        r0 = r8.O00000o0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r3 = r0.getInterval();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0 = r8.O00000o0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r5 = r0.getDeviceModeDistanceFilter();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r6 = r8.O0000ooO;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
    L_0x00c4:
        r1.requestLocationUpdates(r2, r3, r5, r6, r7);	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        goto L_0x00d2;
    L_0x00c8:
        r1 = r8.O00000Oo;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r2 = "gps";
        r3 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        r5 = 0;
        r6 = r8.O0000ooO;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        goto L_0x00c4;
    L_0x00d2:
        r0 = r8.O00000Oo;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r1 = r8.O00oOoOo;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r0.addGpsStatusListener(r1);	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r3 = 8;
        r4 = 14;
        r5 = "no enough satellites#1401";
        r0 = r8.O00000o0;	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r6 = r0.getHttpTimeOut();	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        r2 = r8;
        r2.O000000o(r3, r4, r5, r6);	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        return;
    L_0x00ea:
        r2 = 8;
        r3 = 14;
        r4 = "no gps provider#1402";
        r5 = 0;
        r1 = r8;
        r1.O000000o(r2, r3, r4, r5);	 Catch:{ SecurityException -> 0x0100, Throwable -> 0x00f7 }
        return;
    L_0x00f7:
        r9 = move-exception;
        r0 = "GpsLocation";
        r1 = "requestLocationUpdates part2";
        com.loc.O0o0000.O000000o(r9, r0, r1);
        return;
    L_0x0100:
        r0 = move-exception;
        r1 = 0;
        r8.O0000oO = r1;
        r1 = 2121; // 0x849 float:2.972E-42 double:1.048E-320;
        com.loc.ooO0Ooo.O000000o(r9, r1);
        r3 = 2;
        r4 = 12;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = r0.getMessage();
        r9.append(r0);
        r0 = "#1201";
        r9.append(r0);
        r5 = r9.toString();
        r6 = 0;
        r2 = r8;
        r2.O000000o(r3, r4, r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO00O0.O000000o(com.amap.api.location.AMapLocationClientOption):void");
    }

    public final void O00000Oo(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.O00000o0 = aMapLocationClientOption;
        if (!(this.O00000o0.getLocationMode() == AMapLocationMode.Device_Sensors || this.O000000o == null)) {
            this.O000000o.removeMessages(8);
        }
        if (this.O0000oO0 != this.O00000o0.getGeoLanguage()) {
            synchronized (this.O0000o0O) {
                this.O00oOooo = null;
            }
        }
        this.O0000oO0 = this.O00000o0.getGeoLanguage();
    }

    public final boolean O00000Oo() {
        return OO000OO.O00000o0() - this.O00000o <= 2800;
    }

    @SuppressLint({"NewApi"})
    public final int O00000o() {
        if (this.O00000Oo == null || !O000000o(this.O00000Oo)) {
            return 1;
        }
        if (VERSION.SDK_INT >= 19) {
            int i = Secure.getInt(this.O000O00o.getContentResolver(), "location_mode", 0);
            if (i == 0) {
                return 2;
            }
            if (i == 2) {
                return 3;
            }
        } else if (!this.O00000Oo.isProviderEnabled("gps")) {
            return 2;
        }
        return !this.O0000oO ? 4 : 0;
    }

    public final void O00000o0() {
        this.O0000oo = 0;
    }

    public final int O00000oO() {
        return this.O0000ooo;
    }

    public final boolean O00000oo() {
        return OO000OO.O00000o0() - this.O00000o > 300000;
    }
}
