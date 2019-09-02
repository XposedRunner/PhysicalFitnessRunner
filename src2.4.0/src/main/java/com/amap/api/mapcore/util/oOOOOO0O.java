package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;

/* compiled from: StatisticsManager */
public class oOOOOO0O {
    private static WeakReference<oOOO00Oo> O000000o;

    public static void O000000o(final Context context) {
        ooOOOOoo.O00000o().submit(new Runnable() {
            public void run() {
                try {
                    oOOO00Oo O000000o = oOOo0000.O000000o(oOOOOO0O.O000000o);
                    oOOo0000.O000000o(context, O000000o, oO0Oo0oo.O0000OOo, 1000, 307200, "2");
                    if (O000000o.O0000O0o == null) {
                        O000000o.O0000O0o = new oo000000(new d(context, new a(new h(new j()))));
                    }
                    O000000o.O0000OOo = 3600000;
                    if (TextUtils.isEmpty(O000000o.O0000Oo0)) {
                        O000000o.O0000Oo0 = "cKey";
                    }
                    if (O000000o.O00000oo == null) {
                        O000000o.O00000oo = new n(context, O000000o.O0000OOo, O000000o.O0000Oo0, new k(30, O000000o.O000000o, new q(context, false)));
                    }
                    oOOO00o0.O000000o(O000000o);
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "stm", "usd");
                }
            }
        });
    }

    public static synchronized void O000000o(final oOOO0o00 oooo0o00, final Context context) {
        synchronized (oOOOOO0O.class) {
            ooOOOOoo.O00000o().submit(new Runnable() {
                public void run() {
                    try {
                        synchronized (oOOOOO0O.class) {
                            oOOOOO0O.O00000Oo(context, oooo0o00.O000000o());
                        }
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "stm", "as");
                    }
                }
            });
        }
    }

    private static void O00000Oo(Context context, byte[] bArr) throws IOException {
        oOOO00Oo O000000o = oOOo0000.O000000o(O000000o);
        oOOo0000.O000000o(context, O000000o, oO0Oo0oo.O0000OOo, 1000, 307200, "2");
        if (O000000o.O00000oO == null) {
            O000000o.O00000oO = new oO0000o0();
        }
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(random.nextInt(100)));
        stringBuilder.append(Long.toString(System.nanoTime()));
        try {
            oOOO00o0.O000000o(stringBuilder.toString(), bArr, O000000o);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "stm", "wts");
        }
    }
}
