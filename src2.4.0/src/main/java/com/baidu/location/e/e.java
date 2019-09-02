package com.baidu.location.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GnssStatus.Callback;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.a.u;
import com.baidu.location.a.w;
import com.baidu.location.a.x;
import com.baidu.location.g.j;
import com.baidu.location.indoor.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class e {
    private static String C = null;
    private static double G = 100.0d;
    public static String a = "";
    public static String b = "";
    private static e c;
    private static int p;
    private static int q;
    private static int r;
    private static long s;
    private double A = 0.0d;
    private double B = 0.0d;
    private Handler D = null;
    private int E;
    private int F;
    private long H = 0;
    private long I = 0;
    private ArrayList<ArrayList<Float>> J = new ArrayList();
    private ArrayList<ArrayList<Float>> K = new ArrayList();
    private Context d;
    private LocationManager e = null;
    private Location f;
    private c g = null;
    private e h = null;
    private GpsStatus i;
    private a j;
    private boolean k = false;
    private b l = null;
    private boolean m = false;
    private d n = null;
    private OnNmeaMessageListener o = null;
    private long t = 0;
    private boolean u = false;
    private boolean v = false;
    private String w = null;
    private boolean x = false;
    private long y = 0;
    private double z = -1.0d;

    @TargetApi(24)
    private class a extends Callback {
        private a() {
        }

        /* synthetic */ a(e eVar, f fVar) {
            this();
        }

        public void onFirstFix(int i) {
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            if (e.this.e != null) {
                e.this.I = System.currentTimeMillis();
                int satelliteCount = gnssStatus.getSatelliteCount();
                e.this.J.clear();
                e.this.K.clear();
                int i = 0;
                int i2 = 0;
                int i3 = i2;
                int i4 = i3;
                while (i < satelliteCount) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    i2++;
                    if (gnssStatus.usedInFix(i)) {
                        i3++;
                        if (gnssStatus.getConstellationType(i) == 1) {
                            i4++;
                            arrayList.add(Float.valueOf(gnssStatus.getCn0DbHz(i)));
                            arrayList.add(Float.valueOf(0.0f));
                            arrayList.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i)));
                            arrayList.add(Float.valueOf(gnssStatus.getElevationDegrees(i)));
                            arrayList.add(Float.valueOf(1.0f));
                            arrayList.add(Float.valueOf((float) gnssStatus.getSvid(i)));
                            e.this.J.add(arrayList);
                            e.this.K.add(arrayList);
                        }
                    } else if (gnssStatus.getConstellationType(i) == 1) {
                        arrayList2.add(Float.valueOf(gnssStatus.getCn0DbHz(i)));
                        arrayList2.add(Float.valueOf(0.0f));
                        arrayList2.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i)));
                        arrayList2.add(Float.valueOf(gnssStatus.getElevationDegrees(i)));
                        arrayList2.add(Float.valueOf(0.0f));
                        arrayList2.add(Float.valueOf((float) gnssStatus.getSvid(i)));
                        e.this.K.add(arrayList2);
                    }
                    i++;
                }
                e.a = e.this.l();
                e.b = e.this.m();
                e.p = i3;
                e.q = i4;
                e.r = i2;
                e.s = System.currentTimeMillis();
            }
        }

        public void onStarted() {
        }

        public void onStopped() {
            e.this.d(null);
            e.this.b(false);
            e.p = 0;
            e.q = 0;
        }
    }

    private class b implements Listener {
        private long b;

        private b() {
            this.b = 0;
        }

        /* synthetic */ b(e eVar, f fVar) {
            this();
        }

        public void onGpsStatusChanged(int i) {
            if (e.this.e != null) {
                int i2 = 0;
                if (i == 2) {
                    e.this.d(null);
                    e.this.b(false);
                    e.p = 0;
                    e.q = 0;
                } else if (i == 4 && e.this.v) {
                    try {
                        long currentTimeMillis;
                        if (e.this.i == null) {
                            e.this.i = e.this.e.getGpsStatus(null);
                        } else {
                            e.this.e.getGpsStatus(e.this.i);
                        }
                        e.this.E = 0;
                        e.this.F = 0;
                        e.this.J.clear();
                        e.this.K.clear();
                        e.this.I = System.currentTimeMillis();
                        double d = 0.0d;
                        int i3 = 0;
                        for (GpsSatellite gpsSatellite : e.this.i.getSatellites()) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            if (gpsSatellite.usedInFix()) {
                                i3++;
                                if (gpsSatellite.getPrn() <= 65) {
                                    i2++;
                                    d += (double) gpsSatellite.getSnr();
                                    arrayList.add(Float.valueOf(0.0f));
                                    arrayList.add(Float.valueOf(gpsSatellite.getSnr()));
                                    arrayList.add(Float.valueOf(gpsSatellite.getAzimuth()));
                                    arrayList.add(Float.valueOf(gpsSatellite.getElevation()));
                                    arrayList.add(Float.valueOf(1.0f));
                                    arrayList.add(Float.valueOf((float) gpsSatellite.getPrn()));
                                    e.this.J.add(arrayList);
                                    e.this.K.add(arrayList);
                                }
                            } else if (gpsSatellite.getPrn() <= 65) {
                                arrayList2.add(Float.valueOf(0.0f));
                                arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                                arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                                arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                                arrayList2.add(Float.valueOf(0.0f));
                                arrayList2.add(Float.valueOf((float) gpsSatellite.getPrn()));
                                e.this.K.add(arrayList2);
                            }
                            if (gpsSatellite.getSnr() >= ((float) j.H)) {
                                e.this.F = e.this.F + 1;
                            }
                        }
                        e.a = e.this.l();
                        e.b = e.this.m();
                        if (i2 > 0) {
                            e.q = i2;
                            e.G = d / ((double) i2);
                        }
                        if (i3 > 0) {
                            currentTimeMillis = System.currentTimeMillis();
                        } else {
                            if (System.currentTimeMillis() - this.b > 100) {
                                currentTimeMillis = System.currentTimeMillis();
                            }
                            e.s = System.currentTimeMillis();
                        }
                        this.b = currentTimeMillis;
                        e.p = i3;
                        e.s = System.currentTimeMillis();
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private class c implements LocationListener {
        private c() {
        }

        /* synthetic */ c(e eVar, f fVar) {
            this();
        }

        public void onLocationChanged(Location location) {
            e.this.y = System.currentTimeMillis();
            e.this.b(true);
            e.this.d(location);
            e.this.u = false;
        }

        public void onProviderDisabled(String str) {
            e.this.d(null);
            e.this.b(false);
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    e.this.d(null);
                    break;
                case 1:
                    e.this.t = System.currentTimeMillis();
                    e.this.u = true;
                    break;
                case 2:
                    e.this.u = false;
                    return;
                default:
                    return;
            }
            e.this.b(false);
        }
    }

    private class d implements NmeaListener {
        private d() {
        }

        /* synthetic */ d(e eVar, f fVar) {
            this();
        }

        public void onNmeaReceived(long j, String str) {
            if (e.this.b(str)) {
                e.this.a(str);
            }
        }
    }

    private class e implements LocationListener {
        private long b;

        private e() {
            this.b = 0;
        }

        /* synthetic */ e(e eVar, f fVar) {
            this();
        }

        public void onLocationChanged(Location location) {
            if (!e.this.v && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.b >= 10000 && w.a(location, false)) {
                this.b = System.currentTimeMillis();
                e.this.D.sendMessage(e.this.D.obtainMessage(4, location));
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private e() {
        if (VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.k = true;
            } catch (ClassNotFoundException unused) {
                this.k = false;
            }
        }
        this.m = false;
    }

    public static int a(String str, String str2) {
        int i = 0;
        char charAt = str2.charAt(0);
        int i2 = 0;
        while (i < str.length()) {
            if (Character.valueOf(charAt).equals(Character.valueOf(str.charAt(i)))) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (c == null) {
                c = new e();
            }
            eVar = c;
        }
        return eVar;
    }

    public static String a(Location location) {
        if (location == null) {
            return null;
        }
        float speed = (float) (((double) location.getSpeed()) * 3.6d);
        float f = -1.0f;
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        if (location.hasBearing()) {
            f = location.getBearing();
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", new Object[]{Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(f), Integer.valueOf(accuracy), Integer.valueOf(p), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(p), Integer.valueOf(q), Double.valueOf(G)});
    }

    private void a(String str, Location location) {
        if (location != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(com.baidu.location.a.a.a().d());
            str = stringBuilder.toString();
            boolean f = i.a().f();
            u.a(new a(b.a().f()));
            u.a(System.currentTimeMillis());
            u.a(new Location(location));
            u.a(str);
            if (!f) {
                w.a(u.c(), null, u.d(), str);
            }
        }
    }

    public static boolean a(Location location, Location location2, boolean z) {
        boolean z2 = false;
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z && ((j.v == 3 || !com.baidu.location.g.d.a().a(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        if (speed > j.L) {
            if (distanceTo > j.N) {
                z2 = true;
            }
            return z2;
        } else if (speed > j.K) {
            if (distanceTo > j.M) {
                z2 = true;
            }
            return z2;
        } else {
            if (distanceTo > 5.0f) {
                z2 = true;
            }
            return z2;
        }
    }

    public static String b(Location location) {
        String a = a(location);
        if (a == null) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("&g_tp=0");
        return stringBuilder.toString();
    }

    private void b(boolean z) {
        this.x = z;
        if (!(z && j())) {
        }
    }

    private boolean b(String str) {
        if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
            int i;
            byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
            int i2 = bytes[1];
            for (i = 2; i < bytes.length; i++) {
                i2 ^= bytes[i];
            }
            String format = String.format("%02x", new Object[]{Integer.valueOf(i2)});
            i2 = str.indexOf("*");
            if (i2 == -1) {
                return false;
            }
            i = i2 + 3;
            return str.length() >= i && format.equalsIgnoreCase(str.substring(i2 + 1, i));
        }
    }

    public static String c(Location location) {
        String a = a(location);
        if (a == null) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(C);
        return stringBuilder.toString();
    }

    private void d(Location location) {
        this.D.sendMessage(this.D.obtainMessage(1, location));
    }

    private void e(Location location) {
        String str = null;
        if (location != null) {
            int i = p;
            if (i == 0) {
                try {
                    i = location.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            if (i != 0 || j.m) {
                if (this.m && ((double) location.getSpeed()) == 0.0d && this.A != 0.0d && ((double) System.currentTimeMillis()) - this.B < 2000.0d) {
                    location.setSpeed((float) this.A);
                }
                this.f = location;
                location = new Location(this.f);
                i = p;
                if (this.f != null) {
                    this.f.setTime(System.currentTimeMillis());
                    float speed = (float) (((double) this.f.getSpeed()) * 3.6d);
                    if (!this.f.hasSpeed()) {
                        speed = -1.0f;
                    }
                    if (i == 0) {
                        try {
                            i = this.f.getExtras().getInt("satellites");
                        } catch (Exception unused2) {
                        }
                    }
                    str = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", new Object[]{Double.valueOf(this.f.getLongitude()), Double.valueOf(this.f.getLatitude()), Float.valueOf(speed), Float.valueOf(this.f.getBearing()), Integer.valueOf(i), Long.valueOf(r5)});
                }
                this.w = str;
                if (j() && this.f != null) {
                    boolean f;
                    if (g.a().e()) {
                        g.a().a(this.f, this.J);
                    }
                    if (!g.a().f()) {
                        f = g.a().f();
                        com.baidu.location.a.a.a().a(g());
                    }
                    if (p > 2 && w.a(this.f, true)) {
                        f = i.a().f();
                        u.a(new a(b.a().f()));
                        u.a(System.currentTimeMillis());
                        u.a(new Location(this.f));
                        u.a(com.baidu.location.a.a.a().d());
                        if (!f) {
                            x.a().b();
                        }
                    }
                }
                x.a().a(location, p);
                return;
            }
            return;
        }
        this.f = null;
    }

    public static String k() {
        long currentTimeMillis = System.currentTimeMillis() - s;
        if (currentTimeMillis < 0 || currentTimeMillis >= 3000) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", new Object[]{Integer.valueOf(r), Integer.valueOf(p)});
    }

    private String l() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.J.size() > 32 || this.J.size() == 0) {
            return stringBuilder.toString();
        }
        Iterator it = this.J.iterator();
        int i = 1;
        while (it.hasNext()) {
            if (((ArrayList) it.next()).size() == 6) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append("|");
                }
                stringBuilder.append(String.format("%.1f;", new Object[]{r4.get(0)}));
                stringBuilder.append(String.format("%.1f;", new Object[]{r4.get(1)}));
                stringBuilder.append(String.format("%.0f;", new Object[]{r4.get(2)}));
                stringBuilder.append(String.format("%.0f;", new Object[]{r4.get(3)}));
                stringBuilder.append(String.format("%.0f", new Object[]{r4.get(4)}));
            }
        }
        return stringBuilder.toString();
    }

    private String m() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.K.size() > 32 || this.K.size() == 0) {
            return stringBuilder.toString();
        }
        Iterator it = this.K.iterator();
        int i = 1;
        while (it.hasNext()) {
            if (((ArrayList) it.next()).size() == 6) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append("|");
                }
                stringBuilder.append(String.format("%.1f;", new Object[]{r4.get(0)}));
                stringBuilder.append(String.format("%.1f;", new Object[]{r4.get(1)}));
                stringBuilder.append(String.format("%.0f;", new Object[]{r4.get(2)}));
                stringBuilder.append(String.format("%.0f;", new Object[]{r4.get(3)}));
                stringBuilder.append(String.format("%.0f", new Object[]{r4.get(4)}));
            }
        }
        return stringBuilder.toString();
    }

    public void a(String str) {
        if (str.length() == 0 || !b(str)) {
            return;
        }
        if (str.startsWith("$GPPWR,") || str.startsWith("$GNGST,") || str.startsWith("$GPGST,") || str.startsWith("$GLGSV,") || str.startsWith("$GNGSV,") || str.startsWith("$BDGSV,") || str.startsWith("$GPZDA,") || str.startsWith("$GPGSA,") || str.startsWith("$GNVTG,") || str.startsWith("$GPVTG,") || str.startsWith("$GNGSA,") || str.startsWith("$GPNTR,") || str.startsWith("$GNGGA,") || str.startsWith("$GPGGA,") || str.startsWith("$GPRMC,") || str.startsWith("$GPGSV,") || str.startsWith("$BDGSA,")) {
            String[] split = str.split(",");
            a(str, ",");
            if (split != null && split.length > 0 && ((split[0].equalsIgnoreCase("$GPRMC") || split[0].equalsIgnoreCase("$GNRMC") || split[0].equalsIgnoreCase("$GLRMC") || split[0].equalsIgnoreCase("$BDRMC")) && split.length > 7 && split[7].trim().length() > 0)) {
                this.A = ((Double.valueOf(split[7]).doubleValue() * 1.852d) / 3600.0d) * 1000.0d;
                this.B = (double) System.currentTimeMillis();
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            c();
        } else {
            d();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0075 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:6|7|8|9|(1:11)(1:12)|13|(2:15|(1:17)(1:18))|19|20|21|22|23) */
    public synchronized void b() {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = com.baidu.location.f.isServing;	 Catch:{ all -> 0x007e }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r8);
        return;
    L_0x0007:
        r0 = com.baidu.location.f.getServiceContext();	 Catch:{ all -> 0x007e }
        r8.d = r0;	 Catch:{ all -> 0x007e }
        r0 = r8.d;	 Catch:{ Exception -> 0x0075 }
        r1 = "location";
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x0075 }
        r0 = (android.location.LocationManager) r0;	 Catch:{ Exception -> 0x0075 }
        r8.e = r0;	 Catch:{ Exception -> 0x0075 }
        r0 = r8.k;	 Catch:{ Exception -> 0x0075 }
        r1 = 0;
        if (r0 != 0) goto L_0x002d;
    L_0x001e:
        r0 = new com.baidu.location.e.e$b;	 Catch:{ Exception -> 0x0075 }
        r0.<init>(r8, r1);	 Catch:{ Exception -> 0x0075 }
        r8.l = r0;	 Catch:{ Exception -> 0x0075 }
        r0 = r8.e;	 Catch:{ Exception -> 0x0075 }
        r2 = r8.l;	 Catch:{ Exception -> 0x0075 }
        r0.addGpsStatusListener(r2);	 Catch:{ Exception -> 0x0075 }
        goto L_0x003b;
    L_0x002d:
        r0 = new com.baidu.location.e.e$a;	 Catch:{ Exception -> 0x0075 }
        r0.<init>(r8, r1);	 Catch:{ Exception -> 0x0075 }
        r8.j = r0;	 Catch:{ Exception -> 0x0075 }
        r0 = r8.e;	 Catch:{ Exception -> 0x0075 }
        r2 = r8.j;	 Catch:{ Exception -> 0x0075 }
        r0.registerGnssStatusCallback(r2);	 Catch:{ Exception -> 0x0075 }
    L_0x003b:
        r0 = r8.m;	 Catch:{ Exception -> 0x0075 }
        if (r0 == 0) goto L_0x0062;
    L_0x003f:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0075 }
        r2 = 24;
        if (r0 < r2) goto L_0x0054;
    L_0x0045:
        r0 = new com.baidu.location.e.f;	 Catch:{ Exception -> 0x0075 }
        r0.<init>(r8);	 Catch:{ Exception -> 0x0075 }
        r8.o = r0;	 Catch:{ Exception -> 0x0075 }
        r0 = r8.e;	 Catch:{ Exception -> 0x0075 }
        r2 = r8.o;	 Catch:{ Exception -> 0x0075 }
        r0.addNmeaListener(r2);	 Catch:{ Exception -> 0x0075 }
        goto L_0x0062;
    L_0x0054:
        r0 = new com.baidu.location.e.e$d;	 Catch:{ Exception -> 0x0075 }
        r0.<init>(r8, r1);	 Catch:{ Exception -> 0x0075 }
        r8.n = r0;	 Catch:{ Exception -> 0x0075 }
        r0 = r8.e;	 Catch:{ Exception -> 0x0075 }
        r2 = r8.n;	 Catch:{ Exception -> 0x0075 }
        r0.addNmeaListener(r2);	 Catch:{ Exception -> 0x0075 }
    L_0x0062:
        r0 = new com.baidu.location.e.e$e;	 Catch:{ Exception -> 0x0075 }
        r0.<init>(r8, r1);	 Catch:{ Exception -> 0x0075 }
        r8.h = r0;	 Catch:{ Exception -> 0x0075 }
        r2 = r8.e;	 Catch:{ Exception -> 0x0075 }
        r3 = "passive";
        r4 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
        r6 = 0;
        r7 = r8.h;	 Catch:{ Exception -> 0x0075 }
        r2.requestLocationUpdates(r3, r4, r6, r7);	 Catch:{ Exception -> 0x0075 }
    L_0x0075:
        r0 = new com.baidu.location.e.g;	 Catch:{ all -> 0x007e }
        r0.<init>(r8);	 Catch:{ all -> 0x007e }
        r8.D = r0;	 Catch:{ all -> 0x007e }
        monitor-exit(r8);
        return;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.e.b():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|4|5|6|7|8) */
    public void c() {
        /*
        r10 = this;
        r0 = com.baidu.location.g.a.a;
        r1 = "start gps...";
        android.util.Log.d(r0, r1);
        r0 = r10.v;
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r0 = new com.baidu.location.e.e$c;	 Catch:{ Exception -> 0x0037 }
        r1 = 0;
        r0.<init>(r10, r1);	 Catch:{ Exception -> 0x0037 }
        r10.g = r0;	 Catch:{ Exception -> 0x0037 }
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x0022 }
        r0.<init>();	 Catch:{ Exception -> 0x0022 }
        r1 = r10.e;	 Catch:{ Exception -> 0x0022 }
        r2 = "gps";
        r3 = "force_xtra_injection";
        r1.sendExtraCommand(r2, r3, r0);	 Catch:{ Exception -> 0x0022 }
    L_0x0022:
        r4 = r10.e;	 Catch:{ Exception -> 0x0037 }
        r5 = "gps";
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = 0;
        r9 = r10.g;	 Catch:{ Exception -> 0x0037 }
        r4.requestLocationUpdates(r5, r6, r8, r9);	 Catch:{ Exception -> 0x0037 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0037 }
        r10.H = r0;	 Catch:{ Exception -> 0x0037 }
        r0 = 1;
        r10.v = r0;	 Catch:{ Exception -> 0x0037 }
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.e.c():void");
    }

    public void d() {
        if (this.v) {
            if (this.e != null) {
                try {
                    if (this.g != null) {
                        this.e.removeUpdates(this.g);
                    }
                } catch (Exception unused) {
                }
            }
            j.d = 0;
            j.v = 0;
            this.g = null;
            this.v = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.e != null) {
            try {
                if (this.l != null) {
                    this.e.removeGpsStatusListener(this.l);
                }
                if (this.k && this.j != null) {
                    this.e.unregisterGnssStatusCallback(this.j);
                }
                if (this.m && this.n != null) {
                    this.e.removeNmeaListener(this.n);
                }
                this.e.removeUpdates(this.h);
            } catch (Exception unused) {
            }
            this.l = null;
            this.e = null;
        }
    }

    public String f() {
        if (!j() || this.f == null) {
            return null;
        }
        String replaceAll = a(this.f).replaceAll("ll", "idll").replaceAll("&d=", "&idd=").replaceAll("&s", "&ids=");
        return String.format("%s&idgps_tp=%s", new Object[]{replaceAll, this.f.getProvider()});
    }

    public String g() {
        if (this.f == null) {
            return null;
        }
        int i;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("{\"result\":{\"time\":\"");
        stringBuilder2.append(j.a());
        stringBuilder2.append("\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":");
        stringBuilder2.append("\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",");
        stringBuilder2.append("\"s\":\"%f\",\"n\":\"%d\"");
        String stringBuilder3 = stringBuilder2.toString();
        int accuracy = (int) (this.f.hasAccuracy() ? this.f.getAccuracy() : 10.0f);
        float speed = (float) (((double) this.f.getSpeed()) * 3.6d);
        if (!this.f.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArr = new double[2];
        if (com.baidu.location.g.d.a().a(this.f.getLongitude(), this.f.getLatitude())) {
            dArr = Jni.coorEncrypt(this.f.getLongitude(), this.f.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                dArr[0] = this.f.getLongitude();
                dArr[1] = this.f.getLatitude();
            }
            i = 1;
        } else {
            dArr[0] = this.f.getLongitude();
            dArr[1] = this.f.getLatitude();
            i = 0;
        }
        stringBuilder3 = String.format(Locale.CHINA, stringBuilder3, new Object[]{Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.f.getBearing()), Float.valueOf(speed), Integer.valueOf(p)});
        if (i == 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder3);
            stringBuilder.append(",\"in_cn\":\"0\"");
            stringBuilder3 = stringBuilder.toString();
        }
        if (this.f.hasAltitude()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder3);
            stringBuilder3 = String.format(Locale.CHINA, ",\"h\":%.2f}}", new Object[]{Double.valueOf(this.f.getAltitude())});
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder3);
            stringBuilder3 = "}}";
        }
        stringBuilder.append(stringBuilder3);
        return stringBuilder.toString();
    }

    public Location h() {
        return (this.f != null && Math.abs(System.currentTimeMillis() - this.f.getTime()) <= 60000) ? this.f : null;
    }

    public boolean i() {
        try {
            return !(this.f == null || this.f.getLatitude() == 0.0d || this.f.getLongitude() == 0.0d || (p <= 2 && this.f.getExtras().getInt("satellites", 3) <= 2)) || Math.abs(System.currentTimeMillis() - this.I) < 5000;
        } catch (Exception unused) {
            return (this.f == null || this.f.getLatitude() == 0.0d || this.f.getLongitude() == 0.0d) ? false : true;
        }
    }

    public boolean j() {
        if (!i() || System.currentTimeMillis() - this.y > 10000) {
            return false;
        }
        return (!this.u || System.currentTimeMillis() - this.t >= 3000) ? this.x : true;
    }
}
