package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;

/* compiled from: MarkInfoManager */
public class oOOO0oOO {
    static WeakReference<oOOO00Oo> O000000o;

    public static void O000000o(final Context context) {
        ooOOOOoo.O00000o().submit(new Runnable() {
            public void run() {
                synchronized (oOOO0oOO.class) {
                    oOOO00Oo O000000o = oOOo0000.O000000o(oOOO0oOO.O000000o);
                    oOOo0000.O000000o(context, O000000o, oO0Oo0oo.O0000Oo, 50, 102400, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                    if (O000000o.O0000O0o == null) {
                        String O00000Oo = oOOO0oOO.O00000o0(context);
                        O000000o.O0000O0o = new c(new b(context, new j(), new o0Oo0000(new oO000O0O(new oO0000Oo())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", o0O0O0Oo.O00000Oo(context), o0O0O0Oo.O00000o0(context), O00000Oo));
                    }
                    O000000o.O0000OOo = 14400000;
                    if (TextUtils.isEmpty(O000000o.O0000Oo0)) {
                        O000000o.O0000Oo0 = "eKey";
                    }
                    if (O000000o.O00000oo == null) {
                        O000000o.O00000oo = new n(context, O000000o.O0000OOo, O000000o.O0000Oo0, new k(5, O000000o.O000000o, new q(context, false)));
                    }
                    oOOO00o0.O000000o(O000000o);
                }
            }
        });
    }

    public static void O000000o(final String str, final Context context) {
        ooOOOOoo.O00000o().submit(new Runnable() {
            public void run() {
                synchronized (oOOO0oOO.class) {
                    try {
                        String O000000o = o0OO00o0.O000000o(o0OOOO00.O000000o(str));
                        oOOO00Oo O000000o2 = oOOo0000.O000000o(oOOO0oOO.O000000o);
                        oOOo0000.O000000o(context, O000000o2, oO0Oo0oo.O0000Oo, 50, 102400, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                        if (O000000o2.O00000oO == null) {
                            O000000o2.O00000oO = new o0Oo0000(new oO000O0O(new oO0000Oo()));
                        }
                        String O000000o3 = o0OOOO00.O000000o(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(" \"timestamp\":\"");
                        stringBuilder.append(O000000o3);
                        stringBuilder.append("\",\"details\":");
                        stringBuilder.append(str);
                        oOOO00o0.O000000o(O000000o, o0OOOO00.O000000o(stringBuilder.toString()), O000000o2);
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "mam", "ap");
                    }
                }
            }
        });
    }

    private static String O00000o0(Context context) {
        String O0000oo0 = o0O0o000.O0000oo0(context);
        if (!TextUtils.isEmpty(O0000oo0)) {
            return O0000oo0;
        }
        O0000oo0 = o0O0o000.O0000OOo(context);
        if (!TextUtils.isEmpty(O0000oo0)) {
            return O0000oo0;
        }
        O0000oo0 = o0O0o000.O0000o00(context);
        return !TextUtils.isEmpty(O0000oo0) ? O0000oo0 : o0O0o000.O00000Oo(context);
    }
}
