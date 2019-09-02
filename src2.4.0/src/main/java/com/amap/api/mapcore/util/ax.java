package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MapLocationManager */
public class ax implements Inner_3dMap_locationManagerBase {
    Context O000000o = null;
    ArrayList<Inner_3dMap_locationListener> O00000Oo = new ArrayList();
    Handler O00000o = null;
    Object O00000o0 = new Object();
    O000000o O00000oO = null;
    Handler O00000oo = null;
    Inner_3dMap_locationOption O0000O0o = new Inner_3dMap_locationOption();
    ba O0000OOo = null;
    boolean O0000Oo = false;
    Inner_3dMap_Enum_LocationMode O0000Oo0 = Inner_3dMap_Enum_LocationMode.Hight_Accuracy;

    /* compiled from: MapLocationManager */
    static class O000000o extends HandlerThread {
        ax O000000o;

        public O000000o(String str, ax axVar) {
            super(str);
            this.O000000o = axVar;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLooperPrepared() {
            try {
                this.O000000o.O0000OOo = new ba(this.O000000o.O000000o, this.O000000o.O00000o);
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public ax(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context参数不能为null");
        }
        this.O000000o = context.getApplicationContext();
        O00000oO();
    }

    private Handler O000000o(Looper looper) {
        Handler handler;
        synchronized (this.O00000o0) {
            this.O00000oo = new ay(looper, this);
            handler = this.O00000oo;
        }
        return handler;
    }

    private void O000000o(int i) {
        synchronized (this.O00000o0) {
            if (this.O00000oo != null) {
                this.O00000oo.removeMessages(i);
            }
        }
    }

    private void O000000o(int i, Object obj, long j) {
        synchronized (this.O00000o0) {
            if (this.O00000oo != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                obtain.obj = obj;
                this.O00000oo.sendMessageDelayed(obtain, j);
            }
        }
    }

    private void O00000oO() {
        try {
            this.O00000o = Looper.myLooper() == null ? new az(this.O000000o.getMainLooper(), this) : new az(this);
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "initResultHandler");
        }
        try {
            this.O00000oO = new O000000o("locaitonClientActionThread", this);
            this.O00000oO.setPriority(5);
            this.O00000oO.start();
            this.O00000oo = O000000o(this.O00000oO.getLooper());
        } catch (Throwable th2) {
            bp.O000000o(th2, "MapLocationManager", "initActionThreadAndActionHandler");
        }
    }

    private void O00000oo() {
        synchronized (this.O00000o0) {
            if (this.O00000oo != null) {
                this.O00000oo.removeCallbacksAndMessages(null);
            }
            this.O00000oo = null;
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o() {
        try {
            if (!this.O0000Oo) {
                this.O0000Oo = true;
                O000000o(1005, null, 0);
            }
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "doStartLocation");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (this.O0000Oo) {
                if (!"gps".equalsIgnoreCase(inner_3dMap_location.getProvider())) {
                    inner_3dMap_location.setProvider("lbs");
                }
                inner_3dMap_location.setAltitude(bt.O00000Oo(inner_3dMap_location.getAltitude()));
                inner_3dMap_location.setBearing(bt.O000000o(inner_3dMap_location.getBearing()));
                inner_3dMap_location.setSpeed(bt.O000000o(inner_3dMap_location.getSpeed()));
                Iterator it = this.O00000Oo.iterator();
                while (it.hasNext()) {
                    try {
                        ((Inner_3dMap_locationListener) it.next()).onLocationChanged(inner_3dMap_location);
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.O0000O0o.isOnceLocation()) {
                O00000o0();
            }
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "callBackLocation");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                bp.O000000o(th, "MapLocationManager", "doSetLocationListener");
                return;
            }
        }
        if (this.O00000Oo == null) {
            this.O00000Oo = new ArrayList();
        }
        if (!this.O00000Oo.contains(inner_3dMap_locationListener)) {
            this.O00000Oo.add(inner_3dMap_locationListener);
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.O0000O0o = inner_3dMap_locationOption;
        if (this.O0000O0o == null) {
            this.O0000O0o = new Inner_3dMap_locationOption();
        }
        if (this.O0000OOo != null) {
            this.O0000OOo.O000000o(this.O0000O0o);
        }
        if (this.O0000Oo && !this.O0000Oo0.equals(inner_3dMap_locationOption.getLocationMode())) {
            O00000o0();
            O000000o();
        }
        this.O0000Oo0 = this.O0000O0o.getLocationMode();
    }

    /* Access modifiers changed, original: final */
    public final void O00000Oo() {
        long j = 1000;
        try {
            if (this.O0000OOo != null) {
                this.O0000OOo.O000000o();
            }
            if (!this.O0000O0o.isOnceLocation()) {
                if (this.O0000O0o.getInterval() >= 1000) {
                    j = this.O0000O0o.getInterval();
                }
                O000000o(1005, null, j);
            }
        } catch (Throwable th) {
            if (!this.O0000O0o.isOnceLocation()) {
                if (this.O0000O0o.getInterval() >= 1000) {
                    j = this.O0000O0o.getInterval();
                }
                O000000o(1005, null, j);
            }
            throw th;
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000Oo(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (!this.O00000Oo.isEmpty() && this.O00000Oo.contains(inner_3dMap_locationListener)) {
                    this.O00000Oo.remove(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                bp.O000000o(th, "MapLocationManager", "doUnregisterListener");
                return;
            }
        }
        if (this.O00000Oo.isEmpty()) {
            O00000o0();
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000o() {
        O00000o0();
        if (this.O0000OOo != null) {
            this.O0000OOo.O00000o();
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.clear();
            this.O00000Oo = null;
        }
        O00000oo();
        if (this.O00000oO != null) {
            if (VERSION.SDK_INT >= 18) {
                try {
                    br.O000000o(this.O00000oO, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                }
            }
            this.O00000oO.quit();
        }
        this.O00000oO = null;
        if (this.O00000o != null) {
            this.O00000o.removeCallbacksAndMessages(null);
            this.O00000o = null;
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000o0() {
        try {
            this.O0000Oo = false;
            O000000o(1004);
            O000000o(1005);
            if (this.O0000OOo != null) {
                this.O0000OOo.O00000o0();
            }
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "doStopLocation");
        }
    }

    public void destroy() {
        try {
            O000000o(1007, null, 0);
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "stopLocation");
        }
    }

    public void setLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            O000000o(1002, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "setLocationListener");
        }
    }

    public void setLocationOption(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            O000000o(1001, inner_3dMap_locationOption, 0);
        } catch (Throwable th) {
            bp.O000000o(th, "LocationClientManager", "setLocationOption");
        }
    }

    public void startLocation() {
        try {
            O000000o(1004, null, 0);
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "startLocation");
        }
    }

    public void stopLocation() {
        try {
            O000000o(1006, null, 0);
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "stopLocation");
        }
    }

    public void unRegisterLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            O000000o(1003, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationManager", "stopLocation");
        }
    }
}
