package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: InternalConfig */
/* renamed from: aa */
public class aa {
    private static String[] O000000o = new String[2];

    public static void O000000o(Context context, String str, String str2) {
        O000000o[0] = str;
        O000000o[1] = str2;
        if (context != null) {
            bf.O000000o(context).O000000o(str, str2);
        }
    }

    public static String[] O000000o(Context context) {
        if (!TextUtils.isEmpty(O000000o[0]) && !TextUtils.isEmpty(O000000o[1])) {
            return O000000o;
        }
        if (context != null) {
            String[] O000000o = bf.O000000o(context).O000000o();
            if (O000000o != null) {
                O000000o[0] = O000000o[0];
                O000000o[1] = O000000o[1];
                return O000000o;
            }
        }
        return null;
    }

    public static void O00000Oo(Context context) {
        O000000o[0] = null;
        O000000o[1] = null;
        if (context != null) {
            bf.O000000o(context).O00000Oo();
        }
    }
}
