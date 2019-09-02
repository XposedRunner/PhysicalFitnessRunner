package com.baidu.location.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import java.util.ArrayList;
import java.util.Iterator;

public class a {
    private ArrayList<BDNotifyListener> a = null;
    private float b = Float.MAX_VALUE;
    private BDLocation c = null;
    private long d = 0;
    private LocationClient e = null;
    private Context f = null;
    private int g = 0;
    private long h = 0;
    private boolean i = false;
    private PendingIntent j = null;
    private AlarmManager k = null;
    private a l = null;
    private b m = new b();
    private boolean n = false;

    public class a extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (a.this.a != null && !a.this.a.isEmpty()) {
                a.this.e.requestNotifyLocation();
            }
        }
    }

    public class b implements BDLocationListener {
        public void onReceiveLocation(BDLocation bDLocation) {
            if (a.this.a != null && a.this.a.size() > 0) {
                a.this.a(bDLocation);
            }
        }
    }

    public a(Context context, LocationClient locationClient) {
        this.f = context;
        this.e = locationClient;
        this.e.registerNotifyLocationListener(this.m);
        this.k = (AlarmManager) this.f.getSystemService("alarm");
        this.l = new a();
        this.n = false;
    }

    private void a(long j) {
        try {
            if (this.j != null) {
                this.k.cancel(this.j);
            }
            this.j = PendingIntent.getBroadcast(this.f, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), AMapEngineUtils.HALF_MAX_P20_WIDTH);
            if (this.j != null) {
                this.k.set(0, System.currentTimeMillis() + j, this.j);
            }
        } catch (Exception unused) {
        }
    }

    private void a(BDLocation bDLocation) {
        BDLocation bDLocation2 = bDLocation;
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != BDLocation.TypeNetWorkLocation && bDLocation.getLocType() != 65) {
            a(120000);
        } else if (System.currentTimeMillis() - this.d >= 5000 && this.a != null) {
            this.c = bDLocation2;
            this.d = System.currentTimeMillis();
            float[] fArr = new float[1];
            Iterator it = this.a.iterator();
            float f = Float.MAX_VALUE;
            while (it.hasNext()) {
                int i;
                int i2;
                BDNotifyListener bDNotifyListener = (BDNotifyListener) it.next();
                BDNotifyListener bDNotifyListener2 = bDNotifyListener;
                Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener2.mRadius) - bDLocation.getRadius();
                if (radius > 0.0f) {
                    if (radius < f) {
                        f = radius;
                    }
                } else if (bDNotifyListener2.Notified < 3) {
                    i = 1;
                    bDNotifyListener2.Notified++;
                    bDNotifyListener2.onNotify(bDLocation2, fArr[0]);
                    if (bDNotifyListener2.Notified < 3) {
                        this.i = true;
                    }
                    i2 = i;
                }
                i = 1;
                i2 = i;
            }
            if (f < this.b) {
                this.b = f;
            }
            this.g = 0;
            c();
        }
    }

    private boolean b() {
        boolean z = false;
        if (this.a != null) {
            if (this.a.isEmpty()) {
                return false;
            }
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                if (((BDNotifyListener) it.next()).Notified < 3) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:19:0x004b, code skipped:
            if (((long) r0) > ((r8.h + ((long) r8.g)) - java.lang.System.currentTimeMillis())) goto L_0x004f;
     */
    private void c() {
        /*
        r8 = this;
        r0 = r8.b();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r8.b;
        r1 = 1167867904; // 0x459c4000 float:5000.0 double:5.7700341E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        if (r0 <= 0) goto L_0x0016;
    L_0x0012:
        r0 = 600000; // 0x927c0 float:8.40779E-40 double:2.964394E-318;
        goto L_0x002f;
    L_0x0016:
        r0 = r8.b;
        r2 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0022;
    L_0x001e:
        r0 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        goto L_0x002f;
    L_0x0022:
        r0 = r8.b;
        r2 = 1140457472; // 0x43fa0000 float:500.0 double:5.634608575E-315;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x002e;
    L_0x002a:
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        goto L_0x002f;
    L_0x002e:
        r0 = r1;
    L_0x002f:
        r2 = r8.i;
        r3 = 0;
        if (r2 == 0) goto L_0x0037;
    L_0x0034:
        r8.i = r3;
        r0 = r1;
    L_0x0037:
        r1 = r8.g;
        if (r1 == 0) goto L_0x004e;
    L_0x003b:
        r1 = r8.h;
        r4 = r8.g;
        r4 = (long) r4;
        r6 = r1 + r4;
        r1 = java.lang.System.currentTimeMillis();
        r4 = r6 - r1;
        r1 = (long) r0;
        r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r6 <= 0) goto L_0x004e;
    L_0x004d:
        goto L_0x004f;
    L_0x004e:
        r3 = 1;
    L_0x004f:
        if (r3 == 0) goto L_0x005f;
    L_0x0051:
        r8.g = r0;
        r0 = java.lang.System.currentTimeMillis();
        r8.h = r0;
        r0 = r8.g;
        r0 = (long) r0;
        r8.a(r0);
    L_0x005f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.c():void");
    }

    public int a(BDNotifyListener bDNotifyListener) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.n) {
            this.f.registerReceiver(this.l, new IntentFilter("android.com.baidu.location.TIMER.NOTIFY"), "android.permission.ACCESS_FINE_LOCATION", null);
            this.n = true;
        }
        if (bDNotifyListener.mCoorType == null) {
            return 1;
        }
        if (!bDNotifyListener.mCoorType.equals(CoordinateType.GCJ02)) {
            double d = bDNotifyListener.mLongitude;
            double d2 = bDNotifyListener.mLatitude;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bDNotifyListener.mCoorType);
            stringBuilder.append("2gcj");
            double[] coorEncrypt = Jni.coorEncrypt(d, d2, stringBuilder.toString());
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.c == null || System.currentTimeMillis() - this.d > StatisticConfig.MIN_UPLOAD_INTERVAL) {
            this.e.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.c.getLatitude(), this.c.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.c.getRadius();
            if (radius > 0.0f) {
                if (radius < this.b) {
                    this.b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.c, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.i = true;
                }
            }
        }
        c();
        return 1;
    }

    public void a() {
        if (this.j != null) {
            this.k.cancel(this.j);
        }
        this.c = null;
        this.d = 0;
        if (this.n) {
            this.f.unregisterReceiver(this.l);
        }
        this.n = false;
    }

    public void b(BDNotifyListener bDNotifyListener) {
        if (bDNotifyListener.mCoorType != null) {
            if (!bDNotifyListener.mCoorType.equals(CoordinateType.GCJ02)) {
                double d = bDNotifyListener.mLongitude;
                double d2 = bDNotifyListener.mLatitude;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bDNotifyListener.mCoorType);
                stringBuilder.append("2gcj");
                double[] coorEncrypt = Jni.coorEncrypt(d, d2, stringBuilder.toString());
                bDNotifyListener.mLongitudeC = coorEncrypt[0];
                bDNotifyListener.mLatitudeC = coorEncrypt[1];
            }
            if (this.c == null || System.currentTimeMillis() - this.d > 300000) {
                this.e.requestNotifyLocation();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.c.getLatitude(), this.c.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - this.c.getRadius();
                if (radius > 0.0f) {
                    if (radius < this.b) {
                        this.b = radius;
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(this.c, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.i = true;
                    }
                }
            }
            c();
        }
    }

    public int c(BDNotifyListener bDNotifyListener) {
        if (this.a == null) {
            return 0;
        }
        if (this.a.contains(bDNotifyListener)) {
            this.a.remove(bDNotifyListener);
        }
        if (this.a.size() == 0 && this.j != null) {
            this.k.cancel(this.j);
        }
        return 1;
    }
}
