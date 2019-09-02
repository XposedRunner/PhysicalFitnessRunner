package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* compiled from: AuthProTask */
public class oO00O00o extends Thread {
    private static int O00000o = 3;
    private static int O00000o0 = 0;
    private static long O00000oO = 30000;
    private static boolean O0000O0o;
    private WeakReference<Context> O000000o = null;
    private ca O00000Oo;
    private O000000o O00000oo = null;
    private Handler O0000OOo = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (!oO00O00o.O0000O0o) {
                if (oO00O00o.this.O00000oo == null) {
                    oO00O00o.this.O00000oo = new O000000o(oO00O00o.this.O00000Oo, oO00O00o.this.O000000o == null ? null : (Context) oO00O00o.this.O000000o.get());
                }
                OOOo000.O000000o().O000000o(oO00O00o.this.O00000oo);
            }
        }
    };

    /* compiled from: AuthProTask */
    static class O000000o implements Runnable {
        private WeakReference<ca> O000000o = null;
        private WeakReference<Context> O00000Oo = null;
        private ooOOO00O O00000o0;

        public O000000o(ca caVar, Context context) {
            this.O000000o = new WeakReference(caVar);
            if (context != null) {
                this.O00000Oo = new WeakReference(context);
            }
        }

        private void O000000o() {
            if (this.O000000o != null && this.O000000o.get() != null) {
                final ca caVar = (ca) this.O000000o.get();
                if (caVar != null && caVar.getMapConfig() != null) {
                    caVar.queueEvent(new Runnable() {
                        public void run() {
                            if (caVar != null && caVar.getMapConfig() != null) {
                                MapConfig mapConfig = caVar.getMapConfig();
                                mapConfig.setProFunctionAuthEnable(false);
                                if (mapConfig.isUseProFunction()) {
                                    caVar.O000000o(mapConfig.isCustomStyleEnable(), true);
                                    caVar.O0000oo();
                                    OO0o000.O000000o(O000000o.this.O00000Oo == null ? null : (Context) O000000o.this.O00000Oo.get());
                                }
                            }
                        }
                    });
                }
            }
        }

        public void run() {
            try {
                if (!oO00O00o.O0000O0o) {
                    if (!(this.O00000o0 != null || this.O00000Oo == null || this.O00000Oo.get() == null)) {
                        this.O00000o0 = new ooOOO00O((Context) this.O00000Oo.get(), "");
                    }
                    oO00O00o.O00000o0();
                    if (oO00O00o.O00000o0 > oO00O00o.O00000o) {
                        oO00O00o.O0000O0o = true;
                        O000000o();
                        return;
                    }
                    if (this.O00000o0 != null) {
                        com.amap.api.mapcore.util.ooOOO00O.O000000o o000000o = (com.amap.api.mapcore.util.ooOOO00O.O000000o) this.O00000o0.O000000o();
                        if (o000000o != null) {
                            if (!o000000o.O00000o) {
                                O000000o();
                            }
                            oO00O00o.O0000O0o = true;
                        }
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "authForPro", "loadConfigData_uploadException");
            }
        }
    }

    public oO00O00o(Context context, ca caVar) {
        if (context != null) {
            this.O000000o = new WeakReference(context);
        }
        this.O00000Oo = caVar;
        O000000o();
    }

    public static void O000000o() {
        O00000o0 = 0;
        O0000O0o = false;
    }

    static /* synthetic */ int O00000o0() {
        int i = O00000o0;
        O00000o0 = i + 1;
        return i;
    }

    private void O00000oo() {
        if (!O0000O0o) {
            int i = 0;
            while (i <= O00000o) {
                i++;
                this.O0000OOo.sendEmptyMessageDelayed(0, ((long) i) * O00000oO);
            }
        }
    }

    public void interrupt() {
        this.O00000Oo = null;
        this.O000000o = null;
        if (this.O0000OOo != null) {
            this.O0000OOo.removeCallbacksAndMessages(null);
        }
        this.O0000OOo = null;
        this.O00000oo = null;
        O000000o();
        super.interrupt();
    }

    public void run() {
        try {
            O00000oo();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
        }
    }
}
