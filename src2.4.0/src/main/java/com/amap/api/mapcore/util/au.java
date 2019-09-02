package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import java.lang.reflect.Constructor;

/* compiled from: MapGpsLocation */
public final class au {
    Context O000000o;
    LocationManager O00000Oo;
    volatile boolean O00000o = false;
    volatile long O00000o0 = 0;
    boolean O00000oO = false;
    volatile Inner_3dMap_location O00000oo = null;
    Object O0000O0o = null;
    boolean O0000OOo = false;
    LocationListener O0000Oo = new LocationListener() {
        public final void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(location);
                    inner_3dMap_location.setProvider("gps");
                    inner_3dMap_location.setLocationType(1);
                    Bundle extras = location.getExtras();
                    int i = 0;
                    if (extras != null) {
                        i = extras.getInt("satellites");
                    }
                    inner_3dMap_location.setSatellites(i);
                    inner_3dMap_location.setTime(bq.O000000o(inner_3dMap_location.getTime(), System.currentTimeMillis()));
                    au.this.O00000oo = inner_3dMap_location;
                    au.this.O00000o0 = bt.O00000Oo();
                    au.this.O00000o = true;
                } catch (Throwable th) {
                    bp.O000000o(th, "MAPGPSLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if ("gps".equals(str)) {
                    au.this.O00000o = false;
                }
            } catch (Throwable th) {
                bp.O000000o(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };
    boolean O0000Oo0 = false;

    public au(Context context) {
        if (context != null) {
            this.O000000o = context;
            O00000oO();
            try {
                if (this.O0000O0o == null && !this.O0000Oo0) {
                    Object newInstance;
                    if (this.O0000OOo) {
                        newInstance = Class.forName("com.amap.api.maps.CoordinateConverter").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    } else {
                        newInstance = Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new Class[0]).newInstance(new Object[0]);
                    }
                    this.O0000O0o = newInstance;
                    if (context == null) {
                        this.O0000Oo0 = true;
                    }
                }
            } catch (Throwable unused) {
            }
            if (this.O00000Oo == null) {
                this.O00000Oo = (LocationManager) this.O000000o.getSystemService("location");
            }
        }
    }

    private void O00000oO() {
        try {
            if (Class.forName("com.amap.api.maps.CoordinateConverter") != null) {
                this.O0000OOo = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A:{SYNTHETIC, Splitter:B:0:0x0000, ExcHandler: SecurityException (unused java.lang.SecurityException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:10:0x0028, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:0x0029, code skipped:
            com.amap.api.mapcore.util.bp.O000000o(r0, "MAPGPSLocation", "requestLocationUpdates");
     */
    /* JADX WARNING: Missing block: B:12:0x0030, code skipped:
            return;
     */
    private void O00000oo() {
        /*
        r8 = this;
        r0 = android.os.Looper.myLooper();	 Catch:{ SecurityException -> 0x0030, Throwable -> 0x0028 }
        if (r0 != 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.O000000o;	 Catch:{ SecurityException -> 0x0030, Throwable -> 0x0028 }
        r0 = r0.getMainLooper();	 Catch:{ SecurityException -> 0x0030, Throwable -> 0x0028 }
    L_0x000c:
        r7 = r0;
        r0 = new android.os.Bundle;	 Catch:{ SecurityException -> 0x0030, Throwable -> 0x0028 }
        r0.<init>();	 Catch:{ SecurityException -> 0x0030, Throwable -> 0x0028 }
        r1 = r8.O00000Oo;	 Catch:{ Throwable -> 0x001b, SecurityException -> 0x0030 }
        r2 = "gps";
        r3 = "force_xtra_injection";
        r1.sendExtraCommand(r2, r3, r0);	 Catch:{ Throwable -> 0x001b, SecurityException -> 0x0030 }
    L_0x001b:
        r1 = r8.O00000Oo;	 Catch:{ SecurityException -> 0x0030, Throwable -> 0x0028 }
        r2 = "gps";
        r3 = 800; // 0x320 float:1.121E-42 double:3.953E-321;
        r5 = 0;
        r6 = r8.O0000Oo;	 Catch:{ SecurityException -> 0x0030, Throwable -> 0x0028 }
        r1.requestLocationUpdates(r2, r3, r5, r6, r7);	 Catch:{ SecurityException -> 0x0030, Throwable -> 0x0028 }
        return;
    L_0x0028:
        r0 = move-exception;
        r1 = "MAPGPSLocation";
        r2 = "requestLocationUpdates";
        com.amap.api.mapcore.util.bp.O000000o(r0, r1, r2);
    L_0x0030:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.au.O00000oo():void");
    }

    private void O0000O0o() {
        this.O00000o = false;
        this.O00000o0 = 0;
        this.O00000oo = null;
    }

    public final void O000000o() {
        if (!this.O00000oO) {
            O00000oo();
            this.O00000oO = true;
        }
    }

    public final void O00000Oo() {
        this.O00000oO = false;
        O0000O0o();
        if (!(this.O00000Oo == null || this.O0000Oo == null)) {
            this.O00000Oo.removeUpdates(this.O0000Oo);
        }
    }

    public final Inner_3dMap_location O00000o() {
        if (this.O00000oo == null) {
            return null;
        }
        Inner_3dMap_location clone = this.O00000oo.clone();
        if (clone != null && clone.getErrorCode() == 0) {
            try {
                if (this.O0000O0o != null) {
                    if (bp.O000000o(clone.getLatitude(), clone.getLongitude())) {
                        Object O000000o;
                        Constructor constructor;
                        Object[] objArr;
                        Object[] objArr2 = new Object[]{"GPS"};
                        Class[] clsArr = new Class[]{String.class};
                        if (this.O0000OOo) {
                            O000000o = br.O000000o("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr2, clsArr);
                            constructor = Class.forName("com.amap.api.maps.model.LatLng").getConstructor(new Class[]{Double.TYPE, Double.TYPE});
                            objArr = new Object[]{Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude())};
                        } else {
                            O000000o = br.O000000o("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr2, clsArr);
                            constructor = Class.forName("com.amap.api.maps2d.model.LatLng").getConstructor(new Class[]{Double.TYPE, Double.TYPE});
                            objArr = new Object[]{Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude())};
                        }
                        Object newInstance = constructor.newInstance(objArr);
                        br.O000000o(this.O0000O0o, "coord", newInstance);
                        br.O000000o(this.O0000O0o, "from", O000000o);
                        O000000o = br.O000000o(this.O0000O0o, "convert", new Object[0]);
                        double doubleValue = ((Double) O000000o.getClass().getDeclaredField("latitude").get(O000000o)).doubleValue();
                        double doubleValue2 = ((Double) O000000o.getClass().getDeclaredField("longitude").get(O000000o)).doubleValue();
                        clone.setLatitude(doubleValue);
                        clone.setLongitude(doubleValue2);
                        return clone;
                    }
                } else if (this.O0000Oo0 && bp.O000000o(clone.getLatitude(), clone.getLongitude())) {
                    double[] O000000o2 = as.O000000o(clone.getLongitude(), clone.getLatitude());
                    if (O000000o2 != null) {
                        clone.setLatitude(O000000o2[1]);
                        clone.setLongitude(O000000o2[0]);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return clone;
    }

    public final boolean O00000o0() {
        if (this.O00000o) {
            if (bt.O00000Oo() - this.O00000o0 <= 10000) {
                return true;
            }
            this.O00000oo = null;
        }
        return false;
    }
}
