package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: AnalyticsConfig */
/* renamed from: u */
public class u {
    public static String O000000o = null;
    public static String O00000Oo = null;
    public static String O00000o = "";
    public static String O00000o0 = "";
    public static O00000Oo O00000oO = O00000Oo.O00000o0;
    public static boolean O00000oo = false;
    public static boolean O0000O0o = true;
    public static long O0000OOo = 30000;
    public static boolean O0000Oo;
    public static boolean O0000Oo0;
    static double[] O0000OoO;
    private static String O0000Ooo;
    private static String O0000o0;
    private static String O0000o00;
    private static int O0000o0O;

    public static String O000000o(Context context) {
        return UMUtils.getAppkey(context);
    }

    static void O000000o(Context context, int i) {
        O0000o0O = i;
        bf.O000000o(context).O000000o(O0000o0O);
    }

    static void O000000o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(an.O00oOooo, 0, "\\|");
            return;
        }
        O0000o0 = str;
        bf.O000000o(context).O000000o(O0000o0);
    }

    static void O000000o(String str) {
        O0000o00 = str;
    }

    public static double[] O000000o() {
        return O0000OoO;
    }

    public static String O00000Oo(Context context) {
        return UMUtils.getChannel(context);
    }

    public static int O00000o(Context context) {
        if (O0000o0O == 0) {
            O0000o0O = bf.O000000o(context).O00000o();
        }
        return O0000o0O;
    }

    public static String O00000o0(Context context) {
        if (TextUtils.isEmpty(O0000o0)) {
            O0000o0 = bf.O000000o(context).O00000o0();
        }
        return O0000o0;
    }
}
