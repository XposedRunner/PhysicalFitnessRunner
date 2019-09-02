package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: VersionUtil */
public class oO0OO00o {
    private static Pattern O000000o;

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (O000000o == null) {
            O000000o = Pattern.compile("[\\d+\\.]+");
        }
        return O000000o.matcher(str).matches();
    }
}
