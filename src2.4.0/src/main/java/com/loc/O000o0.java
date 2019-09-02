package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: DynamicExceptionHandler */
public final class O000o0 implements UncaughtExceptionHandler {
    private static O000o0 O000000o;
    private UncaughtExceptionHandler O00000Oo = Thread.getDefaultUncaughtExceptionHandler();
    private OO0Oo0 O00000o;
    private Context O00000o0;

    private O000o0(Context context, OO0Oo0 oO0Oo0) {
        this.O00000o0 = context.getApplicationContext();
        this.O00000o = oO0Oo0;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static synchronized O000o0 O000000o(Context context, OO0Oo0 oO0Oo0) {
        O000o0 o000o0;
        synchronized (O000o0.class) {
            if (O000000o == null) {
                O000000o = new O000o0(context, oO0Oo0);
            }
            o000o0 = O000000o;
        }
        return o000o0;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        String O000000o = OO0o000.O000000o(th);
        try {
            if (!TextUtils.isEmpty(O000000o)) {
                if ((O000000o.contains("amapdynamic") || O000000o.contains("admic")) && O000000o.contains("com.amap.api")) {
                    O000O0o o000O0o = new O000O0o(this.O00000o0, O000o.O00000Oo());
                    if (O000000o.contains("loc")) {
                        O000o000.O000000o(o000O0o, this.O00000o0, "loc");
                    }
                    if (O000000o.contains("navi")) {
                        O000o000.O000000o(o000O0o, this.O00000o0, "navi");
                    }
                    if (O000000o.contains("sea")) {
                        O000o000.O000000o(o000O0o, this.O00000o0, "sea");
                    }
                    if (O000000o.contains("2dmap")) {
                        O000o000.O000000o(o000O0o, this.O00000o0, "2dmap");
                    }
                    if (O000000o.contains("3dmap")) {
                        O000o000.O000000o(o000O0o, this.O00000o0, "3dmap");
                    }
                } else {
                    O000O0o o000O0o2;
                    Context context;
                    String str;
                    if (O000000o.contains("com.autonavi.aps.amapapi.offline")) {
                        o000O0o2 = new O000O0o(this.O00000o0, O000o.O00000Oo());
                        context = this.O00000o0;
                        str = "OfflineLocation";
                    } else if (O000000o.contains("com.data.carrier_v4")) {
                        o000O0o2 = new O000O0o(this.O00000o0, O000o.O00000Oo());
                        context = this.O00000o0;
                        str = "Collection";
                    } else {
                        if (!O000000o.contains("com.autonavi.aps.amapapi.httpdns")) {
                            if (!O000000o.contains("com.autonavi.httpdns")) {
                                if (O000000o.contains("com.amap.api.aiunet")) {
                                    o000O0o2 = new O000O0o(this.O00000o0, O000o.O00000Oo());
                                    context = this.O00000o0;
                                    str = "aiu";
                                } else if (O000000o.contains("com.amap.co") || O000000o.contains("com.amap.opensdk.co") || O000000o.contains("com.amap.location")) {
                                    o000O0o2 = new O000O0o(this.O00000o0, O000o.O00000Oo());
                                    context = this.O00000o0;
                                    str = "co";
                                }
                            }
                        }
                        o000O0o2 = new O000O0o(this.O00000o0, O000o.O00000Oo());
                        context = this.O00000o0;
                        str = "HttpDNS";
                    }
                    O000o000.O000000o(o000O0o2, context, str);
                }
            }
        } catch (Throwable th2) {
            O0000Oo.O000000o(th2, "DynamicExceptionHandler", "uncaughtException");
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.uncaughtException(thread, th);
        }
    }
}
