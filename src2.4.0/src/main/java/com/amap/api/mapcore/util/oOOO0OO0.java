package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager */
public class oOOO0OO0 {
    static int O000000o = 1000;
    static boolean O00000Oo = false;
    private static WeakReference<oOOO00Oo> O00000o = null;
    static int O00000o0 = 20;
    private static int O00000oO = 10;

    @Deprecated
    public static synchronized void O000000o(int i, boolean z) {
        synchronized (oOOO0OO0.class) {
            O000000o = i;
            O00000Oo = z;
        }
    }

    public static void O000000o(final Context context) {
        ooOOOOoo.O00000o().submit(new Runnable() {
            public void run() {
                try {
                    oOOO00Oo O000000o = oOOo0000.O000000o(oOOO0OO0.O00000o);
                    oOOo0000.O000000o(context, O000000o, oO0Oo0oo.O0000Oo0, oOOO0OO0.O000000o, 2097152, Constants.VIA_SHARE_TYPE_INFO);
                    O000000o.O0000OOo = 14400000;
                    if (O000000o.O0000O0o == null) {
                        o0Oo0000 o0oo0000 = new o0Oo0000(new oO0000Oo(new oO000O0O()));
                        O000000o.O0000O0o = new c(new b(context, new j(), o0oo0000, new String(oO0Ooo00.O000000o(10)), o0O0O0Oo.O00000oo(context), o0O0o000.O0000oo0(context), o0O0o000.O0000o00(context), o0O0o000.O0000OOo(context), o0O0o000.O000000o(), Build.MANUFACTURER, Build.DEVICE, o0O0o000.O0000ooO(context), o0O0O0Oo.O00000o0(context), Build.MODEL, o0O0O0Oo.O00000o(context), o0O0O0Oo.O00000Oo(context)));
                    }
                    if (TextUtils.isEmpty(O000000o.O0000Oo0)) {
                        O000000o.O0000Oo0 = "fKey";
                    }
                    O000000o.O00000oo = new n(context, O000000o.O0000OOo, O000000o.O0000Oo0, new l(context, oOOO0OO0.O00000Oo, oOOO0OO0.O00000oO * 1024, oOOO0OO0.O00000o0 * 1024));
                    oOOO00o0.O000000o(O000000o);
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "ofm", "uold");
                }
            }
        });
    }

    public static synchronized void O000000o(final oOOO0O0o oooo0o0o, final Context context) {
        synchronized (oOOO0OO0.class) {
            ooOOOOoo.O00000o().submit(new Runnable() {
                public void run() {
                    try {
                        synchronized (oOOO0OO0.class) {
                            String l = Long.toString(System.currentTimeMillis());
                            oOOO00Oo O000000o = oOOo0000.O000000o(oOOO0OO0.O00000o);
                            oOOo0000.O000000o(context, O000000o, oO0Oo0oo.O0000Oo0, oOOO0OO0.O000000o, 2097152, Constants.VIA_SHARE_TYPE_INFO);
                            if (O000000o.O00000oO == null) {
                                O000000o.O00000oO = new o0Oo0000(new oO0000Oo(new oO000O0O(new oO0000Oo())));
                            }
                            oOOO00o0.O000000o(l, oooo0o0o.O000000o(), O000000o);
                        }
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "ofm", "aple");
                    }
                }
            });
        }
    }
}
