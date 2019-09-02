package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: Cleaner */
public final class aj {
    static /* synthetic */ void O000000o(aj ajVar, Context context, x xVar, v vVar) {
        oO0O00o0.O00000o0(context);
        ao.O000000o().O00000o0(xVar.O0000O0o());
        ao.O000000o().O00000o0(vVar.O0000Oo());
        ao.O000000o().O00000o0(vVar.O0000OoO());
    }

    public final void O000000o(final Context context, o0OO0o00 o0oo0o00) {
        if (context != null && o0oo0o00 != null) {
            final x xVar = new x(context, o0oo0o00);
            final v vVar = new v(context, o0oo0o00);
            oO0OO000.O00000Oo().O000000o().submit(new Runnable() {
                public final void run() {
                    try {
                        aj.O000000o(aj.this, context, xVar, vVar);
                    } catch (Throwable th) {
                        t.O000000o(th, "cfa");
                    }
                }
            });
        }
    }
}
