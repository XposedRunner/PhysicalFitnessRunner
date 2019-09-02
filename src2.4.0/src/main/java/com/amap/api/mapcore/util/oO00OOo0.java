package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: DynamicExceptionHandler */
public class oO00OOo0 implements UncaughtExceptionHandler {
    private static oO00OOo0 O000000o;
    private UncaughtExceptionHandler O00000Oo = Thread.getDefaultUncaughtExceptionHandler();
    private o0OO0o00 O00000o;
    private Context O00000o0;

    private oO00OOo0(Context context, o0OO0o00 o0oo0o00) {
        this.O00000o0 = context.getApplicationContext();
        this.O00000o = o0oo0o00;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static synchronized oO00OOo0 O000000o(Context context, o0OO0o00 o0oo0o00) {
        oO00OOo0 oo00ooo0;
        synchronized (oO00OOo0.class) {
            if (O000000o == null) {
                O000000o = new oO00OOo0(context, o0oo0o00);
            }
            oo00ooo0 = O000000o;
        }
        return oo00ooo0;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Throwable th) {
        String O000000o = o0OOOO00.O000000o(th);
        try {
            if (!TextUtils.isEmpty(O000000o)) {
                if ((O000000o.contains("amapdynamic") || O000000o.contains("admic")) && O000000o.contains("com.amap.api")) {
                    oO0O0o0o oo0o0o0o = new oO0O0o0o(this.O00000o0, oO00Oo00.O000000o());
                    if (O000000o.contains("loc")) {
                        oO00OOOo.O000000o(oo0o0o0o, this.O00000o0, "loc");
                    }
                    if (O000000o.contains("navi")) {
                        oO00OOOo.O000000o(oo0o0o0o, this.O00000o0, "navi");
                    }
                    if (O000000o.contains("sea")) {
                        oO00OOOo.O000000o(oo0o0o0o, this.O00000o0, "sea");
                    }
                    if (O000000o.contains("2dmap")) {
                        oO00OOOo.O000000o(oo0o0o0o, this.O00000o0, "2dmap");
                    }
                    if (O000000o.contains("3dmap")) {
                        oO00OOOo.O000000o(oo0o0o0o, this.O00000o0, "3dmap");
                    }
                } else if (O000000o.contains("com.autonavi.aps.amapapi.offline")) {
                    oO00OOOo.O000000o(new oO0O0o0o(this.O00000o0, oO00Oo00.O000000o()), this.O00000o0, "OfflineLocation");
                } else if (O000000o.contains("com.data.carrier_v4")) {
                    oO00OOOo.O000000o(new oO0O0o0o(this.O00000o0, oO00Oo00.O000000o()), this.O00000o0, "Collection");
                } else {
                    if (!O000000o.contains("com.autonavi.aps.amapapi.httpdns")) {
                        if (!O000000o.contains("com.autonavi.httpdns")) {
                            if (O000000o.contains("com.amap.api.aiunet")) {
                                oO00OOOo.O000000o(new oO0O0o0o(this.O00000o0, oO00Oo00.O000000o()), this.O00000o0, "aiu");
                                return;
                            } else if (O000000o.contains("com.amap.co") || O000000o.contains("com.amap.opensdk.co") || O000000o.contains("com.amap.location")) {
                                oO00OOOo.O000000o(new oO0O0o0o(this.O00000o0, oO00Oo00.O000000o()), this.O00000o0, "co");
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    oO00OOOo.O000000o(new oO0O0o0o(this.O00000o0, oO00Oo00.O000000o()), this.O00000o0, "HttpDNS");
                }
            }
        } catch (Throwable th2) {
            oO0OoOO0.O000000o(th2, "DynamicExceptionHandler", "uncaughtException");
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        O000000o(th);
        if (this.O00000Oo != null) {
            this.O00000Oo.uncaughtException(thread, th);
        }
    }
}
