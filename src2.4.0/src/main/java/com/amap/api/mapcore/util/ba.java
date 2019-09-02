package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MapLocationService */
public final class ba {
    private static boolean O0000o0 = true;
    private static int O0000o00 = 200;
    Context O000000o = null;
    au O00000Oo = null;
    O00000Oo O00000o = null;
    bb O00000o0 = null;
    Handler O00000oO = null;
    Handler O00000oo = null;
    boolean O0000O0o = false;
    boolean O0000OOo = false;
    final int O0000Oo = 500;
    Inner_3dMap_locationOption O0000Oo0 = null;
    final int O0000OoO = 30;
    Object O0000Ooo = new Object();
    private JSONArray O0000o0O = null;

    /* compiled from: MapLocationService */
    public class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                ba.this.O00000Oo();
            }
        }
    }

    /* compiled from: MapLocationService */
    static class O00000Oo extends HandlerThread {
        public O00000Oo(String str) {
            super(str);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLooperPrepared() {
            super.onLooperPrepared();
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public ba(Context context, Handler handler) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                bp.O000000o(th, "LocationService", "<init>");
                return;
            }
        }
        this.O000000o = context.getApplicationContext();
        this.O00000oo = handler;
        this.O0000Oo0 = new Inner_3dMap_locationOption();
        O00000oo();
        O00000oO();
    }

    private void O000000o(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (O0000o0 && inner_3dMap_location != null && inner_3dMap_location.getErrorCode() == 0 && inner_3dMap_location.getLocationType() == 1) {
                if (this.O0000o0O == null) {
                    this.O0000o0O = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lon", inner_3dMap_location.getLongitude());
                jSONObject.put("lat", inner_3dMap_location.getLatitude());
                jSONObject.put("type", 0);
                jSONObject.put("timestamp", bt.O000000o());
                this.O0000o0O = this.O0000o0O.put(jSONObject);
                if (this.O0000o0O.length() >= O0000o00) {
                    O0000OOo();
                }
            }
        } catch (Throwable th) {
            bp.O000000o(th, "LocationService", "recordOfflineLocLog");
        }
    }

    private void O00000oO() {
        this.O00000o = new O00000Oo("locServiceAction");
        this.O00000o.setPriority(5);
        this.O00000o.start();
        this.O00000oO = new O000000o(this.O00000o.getLooper());
    }

    private void O00000oo() {
        try {
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = new Inner_3dMap_locationOption();
            }
            if (!this.O0000OOo) {
                this.O00000Oo = new au(this.O000000o);
                this.O00000o0 = new bb(this.O000000o);
                this.O00000o0.O000000o(this.O0000Oo0);
                O0000O0o();
                this.O0000OOo = true;
            }
        } catch (Throwable th) {
            bp.O000000o(th, "LocationService", "init");
        }
    }

    private void O0000O0o() {
        try {
            O0000o0 = bs.O00000Oo(this.O000000o, "maploc", "ue");
            int O000000o = bs.O000000o(this.O000000o, "maploc", "opn");
            O0000o00 = O000000o;
            if (O000000o > 500) {
                O0000o00 = 500;
            }
            if (O0000o00 < 30) {
                O0000o00 = 30;
            }
        } catch (Throwable th) {
            bp.O000000o(th, "LocationService", "getSPConfig");
        }
    }

    private synchronized void O0000OOo() {
        try {
            if (this.O0000o0O != null && this.O0000o0O.length() > 0) {
                oOOO0OO0.O000000o(new oOOO0O0o(this.O000000o, bp.O00000Oo(), this.O0000o0O.toString()), this.O000000o);
                this.O0000o0O = null;
            }
        } catch (Throwable th) {
            bp.O000000o(th, "LocationService", "writeOfflineLog");
        }
    }

    private void O0000Oo() {
        synchronized (this.O0000Ooo) {
            if (this.O00000oO != null) {
                this.O00000oO.removeMessages(1);
            }
        }
    }

    private void O0000Oo0() {
        synchronized (this.O0000Ooo) {
            if (this.O00000oO != null) {
                this.O00000oO.removeCallbacksAndMessages(null);
            }
            this.O00000oO = null;
        }
    }

    public final void O000000o() {
        try {
            O00000oo();
            if (!(this.O0000Oo0.getLocationMode().equals(Inner_3dMap_Enum_LocationMode.Battery_Saving) || this.O0000O0o)) {
                this.O0000O0o = true;
                this.O00000Oo.O000000o();
            }
            if (this.O00000oO != null) {
                this.O00000oO.sendEmptyMessage(1);
            }
        } catch (Throwable th) {
            bp.O000000o(th, "LocationService", "getLocation");
        }
    }

    public final void O000000o(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.O0000Oo0 = inner_3dMap_locationOption;
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new Inner_3dMap_locationOption();
        }
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o(inner_3dMap_locationOption);
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000Oo() {
        Inner_3dMap_location inner_3dMap_location = null;
        try {
            if (this.O0000Oo0.getLocationMode().equals(Inner_3dMap_Enum_LocationMode.Battery_Saving) && this.O0000O0o) {
                this.O00000Oo.O00000Oo();
                this.O0000O0o = false;
            }
            if (this.O00000Oo.O00000o0()) {
                inner_3dMap_location = this.O00000Oo.O00000o();
            } else if (!this.O0000Oo0.getLocationMode().equals(Inner_3dMap_Enum_LocationMode.Device_Sensors)) {
                inner_3dMap_location = this.O00000o0.O000000o();
            }
            if (!(this.O00000oo == null || inner_3dMap_location == null)) {
                Message obtain = Message.obtain();
                obtain.obj = inner_3dMap_location;
                obtain.what = 1;
                this.O00000oo.sendMessage(obtain);
            }
            O000000o(inner_3dMap_location);
        } catch (Throwable th) {
            bp.O000000o(th, "LocationService", "doGetLocation");
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001d */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final void O00000o() {
        /*
        r5 = this;
        r5.O00000o0();	 Catch:{ Throwable -> 0x0036 }
        r5.O0000Oo0();	 Catch:{ Throwable -> 0x0036 }
        r0 = r5.O00000o;	 Catch:{ Throwable -> 0x0036 }
        r1 = 0;
        if (r0 == 0) goto L_0x0026;
    L_0x000b:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0036 }
        r2 = 18;
        if (r0 < r2) goto L_0x0023;
    L_0x0011:
        r0 = r5.O00000o;	 Catch:{ Throwable -> 0x001d }
        r2 = android.os.HandlerThread.class;
        r3 = "quitSafely";
        r4 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x001d }
        com.amap.api.mapcore.util.br.O000000o(r0, r2, r3, r4);	 Catch:{ Throwable -> 0x001d }
        goto L_0x0026;
    L_0x001d:
        r0 = r5.O00000o;	 Catch:{ Throwable -> 0x0036 }
    L_0x001f:
        r0.quit();	 Catch:{ Throwable -> 0x0036 }
        goto L_0x0026;
    L_0x0023:
        r0 = r5.O00000o;	 Catch:{ Throwable -> 0x0036 }
        goto L_0x001f;
    L_0x0026:
        r0 = 0;
        r5.O00000o = r0;	 Catch:{ Throwable -> 0x0036 }
        r0 = r5.O00000o0;	 Catch:{ Throwable -> 0x0036 }
        r0.O00000Oo();	 Catch:{ Throwable -> 0x0036 }
        r5.O0000O0o = r1;	 Catch:{ Throwable -> 0x0036 }
        r5.O0000OOo = r1;	 Catch:{ Throwable -> 0x0036 }
        r5.O0000OOo();	 Catch:{ Throwable -> 0x0036 }
        return;
    L_0x0036:
        r0 = move-exception;
        r1 = "LocationService";
        r2 = "destroy";
        com.amap.api.mapcore.util.bp.O000000o(r0, r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ba.O00000o():void");
    }

    public final void O00000o0() {
        this.O0000O0o = false;
        try {
            O0000Oo();
            if (this.O00000Oo != null) {
                this.O00000Oo.O00000Oo();
            }
        } catch (Throwable th) {
            bp.O000000o(th, "LocationService", "stopLocation");
        }
    }
}
