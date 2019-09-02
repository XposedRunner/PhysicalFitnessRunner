package com.baidu.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import cn.jiguang.net.HttpUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.location.a.c;
import com.baidu.location.a.j;
import com.baidu.location.a.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class LocationClient implements com.baidu.location.a.c.a {
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    private Boolean A = Boolean.valueOf(false);
    private Boolean B = Boolean.valueOf(false);
    private Boolean C = Boolean.valueOf(true);
    private boolean D;
    private c E = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private ServiceConnection I = new b(this);
    private long a = 0;
    private String b = null;
    private LocationClientOption c = new LocationClientOption();
    private LocationClientOption d = new LocationClientOption();
    private boolean e = false;
    private Context f = null;
    private Messenger g = null;
    private a h;
    private final Messenger i;
    private ArrayList<BDLocationListener> j = null;
    private ArrayList<BDAbstractLocationListener> k = null;
    private BDLocation l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private b p = null;
    private boolean q = false;
    private final Object r = new Object();
    private long s = 0;
    private long t = 0;
    private com.baidu.location.c.a u = null;
    private BDLocationListener v = null;
    private String w = null;
    private String x;
    private boolean y = false;
    private boolean z = true;

    private static class a extends Handler {
        private final WeakReference<LocationClient> a;

        a(Looper looper, LocationClient locationClient) {
            super(looper);
            this.a = new WeakReference(locationClient);
        }

        public void handleMessage(Message message) {
            LocationClient locationClient = (LocationClient) this.a.get();
            if (locationClient != null) {
                int i = message.what;
                Bundle data;
                Iterator it;
                if (i == 21) {
                    Bundle data2 = message.getData();
                    data2.setClassLoader(BDLocation.class.getClassLoader());
                    BDLocation bDLocation = (BDLocation) data2.getParcelable("locStr");
                    if (locationClient.G || !locationClient.F || bDLocation.getLocType() != 66) {
                        if (locationClient.G || !locationClient.F) {
                            if (!locationClient.G) {
                                locationClient.G = true;
                            }
                            locationClient.a(message, 21);
                        } else {
                            locationClient.G = true;
                        }
                    }
                } else if (i == SecExceptionCode.SEC_ERROR_STA_NO_DATA_FILE) {
                    data = message.getData();
                    i = data.getInt("loctype");
                    int i2 = data.getInt("diagtype");
                    byte[] byteArray = data.getByteArray("diagmessage");
                    if (i > 0 && i2 > 0 && byteArray != null && locationClient.k != null) {
                        it = locationClient.k.iterator();
                        while (it.hasNext()) {
                            ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i, i2, new String(byteArray, HttpUtils.ENCODING_UTF_8));
                        }
                    }
                } else if (i == SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_ENCRYPTED_DATA) {
                    data = message.getData();
                    byte[] byteArray2 = data.getByteArray("mac");
                    String str = null;
                    if (byteArray2 != null) {
                        str = new String(byteArray2, HttpUtils.ENCODING_UTF_8);
                    }
                    int i3 = data.getInt("hotspot", -1);
                    if (locationClient.k != null) {
                        it = locationClient.k.iterator();
                        while (it.hasNext()) {
                            ((BDAbstractLocationListener) it.next()).onConnectHotSpotMessage(str, i3);
                        }
                    }
                } else if (i == SecExceptionCode.SEC_ERROR_STA_KEY_ENC_INVALID_PARAM) {
                    locationClient.a((BDLocation) message.obj);
                } else if (i == SecExceptionCode.SEC_ERROR_MALDETECT) {
                    locationClient.f(message);
                } else if (i != SecExceptionCode.SEC_ERROR_SECURITYBODY) {
                    switch (i) {
                        case 1:
                            locationClient.b();
                            return;
                        case 2:
                            locationClient.c();
                            return;
                        case 3:
                            locationClient.c(message);
                            return;
                        case 4:
                            locationClient.f();
                            return;
                        case 5:
                            locationClient.e(message);
                            return;
                        case 6:
                            locationClient.h(message);
                            return;
                        case 7:
                            break;
                        case 8:
                            locationClient.d(message);
                            return;
                        case 9:
                            locationClient.a(message);
                            return;
                        case 10:
                            locationClient.b(message);
                            return;
                        case 11:
                            locationClient.e();
                            return;
                        case 12:
                            locationClient.a();
                            return;
                        default:
                            switch (i) {
                                case 26:
                                    locationClient.a(message, 26);
                                    return;
                                case 27:
                                    locationClient.i(message);
                                    return;
                                default:
                                    switch (i) {
                                        case 54:
                                            if (locationClient.c.location_change_notify) {
                                                locationClient.q = true;
                                                return;
                                            }
                                            break;
                                        case 55:
                                            if (locationClient.c.location_change_notify) {
                                                locationClient.q = false;
                                                return;
                                            }
                                            break;
                                        default:
                                            switch (i) {
                                                case SecExceptionCode.SEC_ERROR_STA_KEY_ENC_NO_KEY /*703*/:
                                                    data = message.getData();
                                                    i = data.getInt("id", 0);
                                                    if (i > 0) {
                                                        locationClient.a(i, (Notification) data.getParcelable("notification"));
                                                        return;
                                                    }
                                                    break;
                                                case SecExceptionCode.SEC_ERROR_STA_KEY_ENC_INVALID_ENCRYPTED_DATA /*704*/:
                                                    try {
                                                        locationClient.a(message.getData().getBoolean("removenotify"));
                                                        return;
                                                    } catch (Exception unused) {
                                                        break;
                                                    }
                                                default:
                                                    super.handleMessage(message);
                                                    return;
                                            }
                                    }
                            }
                    }
                } else {
                    locationClient.g(message);
                }
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(LocationClient locationClient, b bVar) {
            this();
        }

        /* JADX WARNING: Missing block: B:29:0x008f, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:31:0x0091, code skipped:
            return;
     */
        public void run() {
            /*
            r5 = this;
            r0 = com.baidu.location.LocationClient.this;
            r0 = r0.r;
            monitor-enter(r0);
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r2 = 0;
            r1.o = r2;	 Catch:{ all -> 0x0092 }
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.g;	 Catch:{ all -> 0x0092 }
            if (r1 == 0) goto L_0x0090;
        L_0x0015:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.i;	 Catch:{ all -> 0x0092 }
            if (r1 != 0) goto L_0x001e;
        L_0x001d:
            goto L_0x0090;
        L_0x001e:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.j;	 Catch:{ all -> 0x0092 }
            r2 = 1;
            if (r1 == 0) goto L_0x0033;
        L_0x0027:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.j;	 Catch:{ all -> 0x0092 }
            r1 = r1.size();	 Catch:{ all -> 0x0092 }
            if (r1 >= r2) goto L_0x0048;
        L_0x0033:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.k;	 Catch:{ all -> 0x0092 }
            if (r1 == 0) goto L_0x008e;
        L_0x003b:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.k;	 Catch:{ all -> 0x0092 }
            r1 = r1.size();	 Catch:{ all -> 0x0092 }
            if (r1 >= r2) goto L_0x0048;
        L_0x0047:
            goto L_0x008e;
        L_0x0048:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.n;	 Catch:{ all -> 0x0092 }
            if (r1 == 0) goto L_0x007e;
        L_0x0050:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.p;	 Catch:{ all -> 0x0092 }
            if (r1 != 0) goto L_0x0064;
        L_0x0058:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r2 = new com.baidu.location.LocationClient$b;	 Catch:{ all -> 0x0092 }
            r3 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r2.<init>();	 Catch:{ all -> 0x0092 }
            r1.p = r2;	 Catch:{ all -> 0x0092 }
        L_0x0064:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.h;	 Catch:{ all -> 0x0092 }
            r2 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r2 = r2.p;	 Catch:{ all -> 0x0092 }
            r3 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r3 = r3.c;	 Catch:{ all -> 0x0092 }
            r3 = r3.scanSpan;	 Catch:{ all -> 0x0092 }
            r3 = (long) r3;	 Catch:{ all -> 0x0092 }
            r1.postDelayed(r2, r3);	 Catch:{ all -> 0x0092 }
            monitor-exit(r0);	 Catch:{ all -> 0x0092 }
            return;
        L_0x007e:
            r1 = com.baidu.location.LocationClient.this;	 Catch:{ all -> 0x0092 }
            r1 = r1.h;	 Catch:{ all -> 0x0092 }
            r2 = 4;
            r1 = r1.obtainMessage(r2);	 Catch:{ all -> 0x0092 }
            r1.sendToTarget();	 Catch:{ all -> 0x0092 }
            monitor-exit(r0);	 Catch:{ all -> 0x0092 }
            return;
        L_0x008e:
            monitor-exit(r0);	 Catch:{ all -> 0x0092 }
            return;
        L_0x0090:
            monitor-exit(r0);	 Catch:{ all -> 0x0092 }
            return;
        L_0x0092:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0092 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient$b.run():void");
        }
    }

    public LocationClient(Context context) {
        this.f = context;
        this.c = new LocationClientOption();
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.f = context;
        this.c = locationClientOption;
        this.d = new LocationClientOption(locationClientOption);
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    private void a() {
        Message obtain = Message.obtain(null, 28);
        try {
            obtain.replyTo = this.i;
            this.g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(int i, Notification notification) {
        try {
            Intent intent = new Intent(this.f, f.class);
            intent.putExtra("notification", notification);
            intent.putExtra("id", i);
            intent.putExtra("command", 1);
            if (VERSION.SDK_INT >= 26) {
                this.f.startForegroundService(intent);
            } else {
                this.f.startService(intent);
            }
            this.H = true;
        } catch (Exception unused) {
        }
    }

    private void a(Message message) {
        if (message != null && message.obj != null) {
            BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
            if (this.u == null) {
                this.u = new com.baidu.location.c.a(this.f, this);
            }
            this.u.a(bDNotifyListener);
        }
    }

    private void a(Message message, int i) {
        if (this.e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                this.l = (BDLocation) data.getParcelable("locStr");
                if (this.l.getLocType() == 61) {
                    this.s = System.currentTimeMillis();
                }
                b(i);
            } catch (Exception unused) {
            }
        }
    }

    private void a(BDLocation bDLocation) {
        if (!this.z) {
            Iterator it;
            this.l = bDLocation;
            if (!this.G && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                this.F = true;
            }
            if (this.j != null) {
                it = this.j.iterator();
                while (it.hasNext()) {
                    ((BDLocationListener) it.next()).onReceiveLocation(bDLocation);
                }
            }
            if (this.k != null) {
                it = this.k.iterator();
                while (it.hasNext()) {
                    ((BDAbstractLocationListener) it.next()).onReceiveLocation(bDLocation);
                }
            }
        }
    }

    private void a(boolean z) {
        try {
            Intent intent = new Intent(this.f, f.class);
            intent.putExtra("removenotify", z);
            intent.putExtra("command", 2);
            this.f.startService(intent);
            this.H = true;
        } catch (Exception unused) {
        }
    }

    private boolean a(int i) {
        if (this.g == null || !this.e) {
            return false;
        }
        try {
            this.g.send(Message.obtain(null, i));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void b() {
        if (!this.e) {
            if (this.C.booleanValue()) {
                try {
                    new c(this).start();
                } catch (Throwable unused) {
                }
                this.C = Boolean.valueOf(false);
            }
            this.b = this.f.getPackageName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append("_bdls_v2.9");
            this.w = stringBuilder.toString();
            Intent intent = new Intent(this.f, f.class);
            try {
                intent.putExtra("debug_dev", this.D);
            } catch (Exception unused2) {
            }
            if (this.c == null) {
                this.c = new LocationClientOption();
            }
            intent.putExtra("cache_exception", this.c.isIgnoreCacheException);
            intent.putExtra("kill_process", this.c.isIgnoreKillProcess);
            try {
                this.f.bindService(intent, this.I, 1);
            } catch (Exception e) {
                e.printStackTrace();
                this.e = false;
            }
        }
    }

    private void b(int i) {
        if (this.l.getCoorType() == null) {
            this.l.setCoorType(this.c.coorType);
        }
        if (this.m || ((this.c.location_change_notify && this.l.getLocType() == 61) || this.l.getLocType() == 66 || this.l.getLocType() == 67 || this.y || this.l.getLocType() == BDLocation.TypeNetWorkLocation)) {
            Iterator it;
            if (this.j != null) {
                it = this.j.iterator();
                while (it.hasNext()) {
                    ((BDLocationListener) it.next()).onReceiveLocation(this.l);
                }
            }
            if (this.k != null) {
                it = this.k.iterator();
                while (it.hasNext()) {
                    ((BDAbstractLocationListener) it.next()).onReceiveLocation(this.l);
                }
            }
            if (this.l.getLocType() != 66 && this.l.getLocType() != 67) {
                this.m = false;
                this.t = System.currentTimeMillis();
            }
        }
    }

    private void b(Message message) {
        if (message != null && message.obj != null) {
            BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
            if (this.u != null) {
                this.u.c(bDNotifyListener);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0038 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:14|15|16|17) */
    private void c() {
        /*
        r5 = this;
        r0 = r5.e;
        if (r0 == 0) goto L_0x0067;
    L_0x0004:
        r0 = r5.g;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = 12;
        r1 = 0;
        r0 = android.os.Message.obtain(r1, r0);
        r2 = r5.i;
        r0.replyTo = r2;
        r2 = r5.g;	 Catch:{ Exception -> 0x001a }
        r2.send(r0);	 Catch:{ Exception -> 0x001a }
        goto L_0x001e;
    L_0x001a:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x001e:
        r0 = 0;
        r2 = r5.f;	 Catch:{ Exception -> 0x003a }
        r3 = r5.I;	 Catch:{ Exception -> 0x003a }
        r2.unbindService(r3);	 Catch:{ Exception -> 0x003a }
        r2 = r5.H;	 Catch:{ Exception -> 0x003a }
        if (r2 == 0) goto L_0x003a;
    L_0x002a:
        r2 = new android.content.Intent;	 Catch:{ Exception -> 0x0038 }
        r3 = r5.f;	 Catch:{ Exception -> 0x0038 }
        r4 = com.baidu.location.f.class;
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x0038 }
        r3 = r5.f;	 Catch:{ Exception -> 0x0038 }
        r3.stopService(r2);	 Catch:{ Exception -> 0x0038 }
    L_0x0038:
        r5.H = r0;	 Catch:{ Exception -> 0x003a }
    L_0x003a:
        r2 = r5.r;
        monitor-enter(r2);
        r3 = r5.o;	 Catch:{ Exception -> 0x004e }
        r4 = 1;
        if (r3 != r4) goto L_0x004e;
    L_0x0042:
        r3 = r5.h;	 Catch:{ Exception -> 0x004e }
        r4 = r5.p;	 Catch:{ Exception -> 0x004e }
        r3.removeCallbacks(r4);	 Catch:{ Exception -> 0x004e }
        r5.o = r0;	 Catch:{ Exception -> 0x004e }
        goto L_0x004e;
    L_0x004c:
        r0 = move-exception;
        goto L_0x0065;
    L_0x004e:
        monitor-exit(r2);	 Catch:{ all -> 0x004c }
        r2 = r5.u;
        if (r2 == 0) goto L_0x0058;
    L_0x0053:
        r2 = r5.u;
        r2.a();
    L_0x0058:
        r5.g = r1;
        r5.n = r0;
        r5.y = r0;
        r5.e = r0;
        r5.F = r0;
        r5.G = r0;
        return;
    L_0x0065:
        monitor-exit(r2);	 Catch:{ all -> 0x004c }
        throw r0;
    L_0x0067:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.c():void");
    }

    private void c(Message message) {
        this.n = false;
        if (message != null && message.obj != null) {
            LocationClientOption locationClientOption = (LocationClientOption) message.obj;
            if (!this.c.optionEquals(locationClientOption)) {
                if (this.c.scanSpan != locationClientOption.scanSpan) {
                    try {
                        synchronized (this.r) {
                            if (this.o) {
                                this.h.removeCallbacks(this.p);
                                this.o = false;
                            }
                            if (locationClientOption.scanSpan >= 1000 && !this.o) {
                                if (this.p == null) {
                                    this.p = new b(this, null);
                                }
                                this.h.postDelayed(this.p, (long) locationClientOption.scanSpan);
                                this.o = true;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                this.c = new LocationClientOption(locationClientOption);
                if (this.g != null) {
                    try {
                        message = Message.obtain(null, 15);
                        message.replyTo = this.i;
                        message.setData(d());
                        this.g.send(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private Bundle d() {
        if (this.c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.b);
        bundle.putString("prodName", this.c.prodName);
        bundle.putString("coorType", this.c.coorType);
        bundle.putString("addrType", this.c.addrType);
        bundle.putBoolean("openGPS", this.c.openGps);
        bundle.putBoolean("location_change_notify", this.c.location_change_notify);
        bundle.putInt("scanSpan", this.c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.c.enableSimulateGps);
        bundle.putInt("timeOut", this.c.timeOut);
        bundle.putInt("priority", this.c.priority);
        bundle.putBoolean("map", this.A.booleanValue());
        bundle.putBoolean("import", this.B.booleanValue());
        bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
        bundle.putBoolean("isneednewrgc", this.c.isNeedNewVersionRgc);
        bundle.putInt("autoNotifyMaxInterval", this.c.a());
        bundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.c.b());
        bundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
        return bundle;
    }

    private void d(Message message) {
        if (message != null && message.obj != null) {
            this.v = (BDLocationListener) message.obj;
        }
    }

    private void e() {
        if (this.g != null) {
            Message obtain = Message.obtain(null, 22);
            try {
                obtain.replyTo = this.i;
                this.g.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void e(Message message) {
        if (message != null && message.obj != null) {
            BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
            if (this.j == null) {
                this.j = new ArrayList();
            }
            if (!this.j.contains(bDLocationListener)) {
                this.j.add(bDLocationListener);
            }
        }
    }

    private void f() {
        if (this.g != null) {
            if ((System.currentTimeMillis() - this.s > 3000 || (!(this.c == null || this.c.location_change_notify) || this.n)) && (!this.y || System.currentTimeMillis() - this.t > 20000 || this.n)) {
                Message obtain = Message.obtain(null, 22);
                if (this.n) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.n);
                    this.n = false;
                    obtain.setData(bundle);
                }
                try {
                    obtain.replyTo = this.i;
                    this.g.send(obtain);
                    this.a = System.currentTimeMillis();
                    this.m = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.r) {
                if (!(this.c == null || this.c.scanSpan < 1000 || this.o)) {
                    if (this.p == null) {
                        this.p = new b(this, null);
                    }
                    this.h.postDelayed(this.p, (long) this.c.scanSpan);
                    this.o = true;
                }
            }
        }
    }

    private void f(Message message) {
        if (message != null && message.obj != null) {
            BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
            if (this.k == null) {
                this.k = new ArrayList();
            }
            if (!this.k.contains(bDAbstractLocationListener)) {
                this.k.add(bDAbstractLocationListener);
            }
        }
    }

    private void g(Message message) {
        if (message != null && message.obj != null) {
            BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
            if (this.k != null && this.k.contains(bDAbstractLocationListener)) {
                this.k.remove(bDAbstractLocationListener);
            }
        }
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    private void h(Message message) {
        if (message != null && message.obj != null) {
            BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
            if (this.j != null && this.j.contains(bDLocationListener)) {
                this.j.remove(bDLocationListener);
            }
        }
    }

    private void i(Message message) {
        try {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
            if (this.v != null && (this.c == null || !this.c.isDisableCache() || bDLocation.getLocType() != 65)) {
                this.v.onReceiveLocation(bDLocation);
            }
        } catch (Exception unused) {
        }
    }

    public void disableAssistantLocation() {
        k.a().b();
    }

    public void disableLocInForeground(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", z);
        Message obtainMessage = this.h.obtainMessage(SecExceptionCode.SEC_ERROR_STA_KEY_ENC_INVALID_ENCRYPTED_DATA);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public void enableAssistantLocation(WebView webView) {
        k.a().a(this.f, webView, this);
    }

    public void enableLocInForeground(int i, Notification notification) {
        if (i <= 0 || notification == null) {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        bundle.putParcelable("notification", notification);
        Message obtainMessage = this.h.obtainMessage(SecExceptionCode.SEC_ERROR_STA_KEY_ENC_NO_KEY);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public String getAccessKey() {
        try {
            this.x = j.b(this.f);
            if (TextUtils.isEmpty(this.x)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s", new Object[]{this.x});
        } catch (Exception unused) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.l;
    }

    public LocationClientOption getLocOption() {
        return this.c;
    }

    public String getVersion() {
        return "7.6.2";
    }

    public boolean isStarted() {
        return this.e;
    }

    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.G || this.F) && bDLocation != null) {
            Message obtainMessage = this.h.obtainMessage(SecExceptionCode.SEC_ERROR_STA_KEY_ENC_INVALID_PARAM);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(SecExceptionCode.SEC_ERROR_MALDETECT);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.h.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.h.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.h.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() {
        if (this.g == null || !this.e) {
            return false;
        }
        try {
            this.g.send(Message.obtain(null, SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_ENCRYPTED_DATA));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int requestLocation() {
        if (this.g == null || this.i == null) {
            return 1;
        }
        if ((this.j == null || this.j.size() < 1) && (this.k == null || this.k.size() < 1)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.a < 1000) {
            return 6;
        }
        this.n = true;
        Message obtainMessage = this.h.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.h.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.g == null || this.i == null) {
            return 1;
        }
        if ((this.j == null || this.j.size() < 1) && (this.k == null || this.k.size() < 1)) {
            return 2;
        }
        this.h.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void restart() {
        stop();
        this.z = false;
        this.h.sendEmptyMessageDelayed(1, 1000);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        this.d = new LocationClientOption(locationClientOption);
        Message obtainMessage = this.h.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.z = false;
        this.h.obtainMessage(1).sendToTarget();
    }

    public boolean startIndoorMode() {
        boolean a = a(110);
        if (a) {
            this.y = true;
        }
        return a;
    }

    public void stop() {
        this.z = true;
        this.h.obtainMessage(2).sendToTarget();
        this.E = null;
    }

    public boolean stopIndoorMode() {
        boolean a = a(111);
        if (a) {
            this.y = false;
        }
        return a;
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(SecExceptionCode.SEC_ERROR_SECURITYBODY);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.g == null || this.i == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain(null, 57);
            obtain.obj = location;
            this.g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
