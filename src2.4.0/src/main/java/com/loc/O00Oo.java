package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager */
public class O00Oo {
    static int O000000o = 1000;
    static boolean O00000Oo = false;
    private static WeakReference<O00Oo00o> O00000o = null;
    static int O00000o0 = 20;
    private static int O00000oO = 10;

    public static synchronized void O000000o(int i, boolean z, int i2) {
        synchronized (O00Oo.class) {
            O000000o = i;
            O00000Oo = z;
            if (i2 < 10 || i2 > 100) {
                i2 = 20;
            }
            O00000o0 = i2;
            if (i2 / 5 > O00000oO) {
                O00000oO = O00000o0 / 5;
            }
        }
    }

    public static void O000000o(final Context context) {
        O0000o.O00000o().submit(new Runnable() {
            public final void run() {
                try {
                    O00Oo00o O000000o = O00Ooo00.O000000o(O00Oo.O00000o);
                    O00Ooo00.O000000o(context, O000000o, O0000o00.O0000Oo0, O00Oo.O000000o, 2097152, Constants.VIA_SHARE_TYPE_INFO);
                    O000000o.O0000OOo = 14400000;
                    if (O000000o.O0000O0o == null) {
                        OO0o oO0o = new OO0o(new O00000o0(new O0000O0o()));
                        O000000o.O0000O0o = new O00oo000(new O00o0(context, new O0O000o(), oO0o, new String(O0000OOo.O000000o(10)), OO00o00.O00000oo(context), OO0O0o0.O0000oo0(context), OO0O0o0.O0000o00(context), OO0O0o0.O0000OOo(context), OO0O0o0.O000000o(), Build.MANUFACTURER, Build.DEVICE, OO0O0o0.O0000ooO(context), OO00o00.O00000o0(context), Build.MODEL, OO00o00.O00000o(context), OO00o00.O00000Oo(context)));
                    }
                    if (TextUtils.isEmpty(O000000o.O0000Oo0)) {
                        O000000o.O0000Oo0 = "fKey";
                    }
                    O000000o.O00000oo = new O0O0O(context, O000000o.O0000OOo, O000000o.O0000Oo0, new O0O00o(context, O00Oo.O00000Oo, O00Oo.O00000oO * 1024, O00Oo.O00000o0 * 1024));
                    O00Oo0.O000000o(O000000o);
                } catch (Throwable th) {
                    O0000o.O00000Oo(th, "ofm", "uold");
                }
            }
        });
    }

    public static synchronized void O000000o(final O00Oo0o0 o00Oo0o0, final Context context) {
        synchronized (O00Oo.class) {
            O0000o.O00000o().submit(new Runnable() {
                public final void run() {
                    try {
                        synchronized (O00Oo.class) {
                            String l = Long.toString(System.currentTimeMillis());
                            O00Oo00o O000000o = O00Ooo00.O000000o(O00Oo.O00000o);
                            O00Ooo00.O000000o(context, O000000o, O0000o00.O0000Oo0, O00Oo.O000000o, 2097152, Constants.VIA_SHARE_TYPE_INFO);
                            if (O000000o.O00000oO == null) {
                                O000000o.O00000oO = new OO0o(new O00000o0(new O0000O0o(new O00000o0())));
                            }
                            O00Oo0.O000000o(l, o00Oo0o0.O000000o(), O000000o);
                        }
                    } catch (Throwable th) {
                        O0000o.O00000Oo(th, "ofm", "aple");
                    }
                }
            });
        }
    }
}
