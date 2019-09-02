package cn.jiguang.a.a.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Message;
import cn.jiguang.d.a.a;
import cn.jiguang.d.a.d;
import org.json.JSONObject;

public final class c {
    private LocationManager a;
    private e b;
    private String c = "";
    private f d;
    private final LocationListener e = new d(this);

    public c(Context context, f fVar) {
        this.a = (LocationManager) context.getSystemService("location");
        this.d = fVar;
    }

    private void a(Location location, String str, boolean z) {
        if (location != null) {
            try {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                if (e.a(latitude, longitude)) {
                    this.b = new e(latitude, longitude, location.getAltitude(), location.getBearing(), location.getAccuracy(), str, a.a(location.getTime()), z);
                    if (this.b != null) {
                        JSONObject f = this.b.f();
                        if (f != null) {
                            d.b(f.toString());
                            return;
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("latitude(");
                stringBuilder.append(latitude);
                stringBuilder.append(") or longitude(");
                stringBuilder.append(longitude);
                stringBuilder.append(") is invalid");
                a(stringBuilder.toString());
                return;
            } catch (Exception e) {
                Exception exception = e;
                StringBuilder stringBuilder2 = new StringBuilder("update exception");
                stringBuilder2.append(exception.getMessage());
                a(stringBuilder2.toString());
                return;
            }
        }
        a("update location is null");
    }

    private void a(String str) {
        this.b = new e(str);
    }

    private boolean c() {
        boolean z = false;
        try {
            if (this.a != null) {
                if (!this.a.isProviderEnabled("gps") && !this.a.isProviderEnabled("network") && !this.a.isProviderEnabled("passive")) {
                    return false;
                }
                z = true;
            }
        } catch (Exception | IllegalArgumentException | SecurityException unused) {
        }
        return z;
    }

    private void d() {
        e();
        if (this.d != null) {
            if (this.d.b != null) {
                if (this.d.b.hasMessages(1004)) {
                    this.d.b.removeMessages(1004);
                }
                if (this.d.b.hasMessages(1003)) {
                    this.d.b.removeMessages(1003);
                }
                if (this.d.b.hasMessages(1001)) {
                    this.d.b.removeMessages(1001);
                }
                if (this.d.b.hasMessages(1005)) {
                    this.d.b.removeMessages(1005);
                }
            }
            this.d.b();
            return;
        }
        cn.jiguang.e.c.c("GpsInfoManager", "cellLocationManager is null,please check it");
    }

    private void e() {
        try {
            if (this.e != null && this.a != null) {
                this.a.removeUpdates(this.e);
            }
        } catch (Throwable unused) {
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final e a() {
        return this.b;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f A:{Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006a A:{Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007b A:{Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b A:{Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006a A:{Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f A:{Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007b A:{Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b A:{Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }} */
    public final void a(android.content.Context r12) {
        /*
        r11 = this;
        r0 = r11.d;
        r0 = r0.a;
        if (r0 == 0) goto L_0x0011;
    L_0x0006:
        r12 = "skip gps collect";
    L_0x0008:
        r11.a(r12);
        r12 = r11.d;
        r12.b();
        return;
    L_0x0011:
        r0 = "android.permission.ACCESS_FINE_LOCATION";
        r12 = cn.jiguang.g.a.a(r12, r0);
        if (r12 != 0) goto L_0x001c;
    L_0x0019:
        r12 = "no permission";
        goto L_0x0008;
    L_0x001c:
        r12 = r11.c();
        if (r12 == 0) goto L_0x00ca;
    L_0x0022:
        r12 = r11.a;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        if (r12 == 0) goto L_0x0087;
    L_0x0026:
        r12 = r11.a;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r0 = "gps";
        r12 = r12.getLastKnownLocation(r0);	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r0 = r11.a;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r1 = "network";
        r0 = r0.getLastKnownLocation(r1);	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r1 = r11.a;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r2 = "passive";
        r1 = r1.getLastKnownLocation(r2);	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r2 = 0;
        if (r12 != 0) goto L_0x0044;
    L_0x0042:
        r4 = r2;
        goto L_0x0048;
    L_0x0044:
        r4 = r12.getTime();	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
    L_0x0048:
        if (r0 != 0) goto L_0x004c;
    L_0x004a:
        r6 = r2;
        goto L_0x0050;
    L_0x004c:
        r6 = r0.getTime();	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
    L_0x0050:
        if (r1 != 0) goto L_0x0054;
    L_0x0052:
        r8 = r2;
        goto L_0x0058;
    L_0x0054:
        r8 = r1.getTime();	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
    L_0x0058:
        r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r10 <= 0) goto L_0x0061;
    L_0x005c:
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0067;
    L_0x0060:
        goto L_0x0068;
    L_0x0061:
        r12 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r12 <= 0) goto L_0x0067;
    L_0x0065:
        r12 = r0;
        goto L_0x0068;
    L_0x0067:
        r12 = r1;
    L_0x0068:
        if (r12 == 0) goto L_0x006f;
    L_0x006a:
        r0 = r12.getProvider();	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        goto L_0x0071;
    L_0x006f:
        r0 = "";
    L_0x0071:
        r1 = 1;
        r11.a(r12, r0, r1);	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        if (r12 == 0) goto L_0x007f;
    L_0x007b:
        r2 = r12.getTime();	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
    L_0x007f:
        r4 = r0 - r2;
        r0 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r12 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r12 >= 0) goto L_0x008b;
    L_0x0087:
        r11.d();	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        return;
    L_0x008b:
        r12 = r11.a;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r0 = "network";
        r12 = r12.isProviderEnabled(r0);	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r0 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
        if (r12 == 0) goto L_0x00a3;
    L_0x0097:
        r12 = "network";
        r11.c = r12;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r12 = r11.d;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
    L_0x009d:
        r12 = r12.b;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r12.sendEmptyMessage(r0);	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        return;
    L_0x00a3:
        r12 = r11.a;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r1 = "gps";
        r12 = r12.isProviderEnabled(r1);	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        if (r12 == 0) goto L_0x00b4;
    L_0x00ad:
        r12 = "gps";
        r11.c = r12;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r12 = r11.d;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        goto L_0x009d;
    L_0x00b4:
        r12 = "network";
        r11.c = r12;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r12 = r11.d;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r12 = r12.b;	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        r0 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r12.sendEmptyMessage(r0);	 Catch:{ SecurityException -> 0x00c6, Exception -> 0x00c2 }
        return;
    L_0x00c2:
        r11.d();
        return;
    L_0x00c6:
        r11.d();
        return;
    L_0x00ca:
        r12 = "no enabled provider";
        r11.a(r12);
        r12 = r11.d;
        r12.b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.c.a(android.content.Context):void");
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Message message) {
        int i = 1001;
        switch (message.what) {
            case 1001:
                try {
                    if (this.c == null || !this.c.equals("network")) {
                        d();
                        return;
                    }
                    this.c = "gps";
                    e();
                    this.a.requestLocationUpdates(this.c, 2000, 0.0f, this.e);
                    this.d.b.sendEmptyMessageDelayed(1001, 10000);
                    return;
                } catch (Throwable unused) {
                    d();
                    return;
                }
            case 1003:
                break;
            case 1004:
                i = 1005;
                break;
            case 1005:
                d();
                return;
            default:
                return;
        }
        try {
            this.a.requestLocationUpdates(this.c, 2000, 0.0f, this.e);
            this.d.b.sendEmptyMessageDelayed(i, 20000);
        } catch (SecurityException unused2) {
            d();
        } catch (Throwable unused3) {
            d();
        }
    }

    public final void b() {
        this.b = null;
    }
}
