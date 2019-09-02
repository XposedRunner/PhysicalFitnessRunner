package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: VersionUtil */
public final class ar {
    private static Pattern O000000o;

    public static int O000000o(String str, String str2) {
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i2 = split[i].length() - split2[i].length();
                if (i2 != 0) {
                    break;
                }
                i2 = split[i].compareTo(split2[i]);
                if (i2 != 0) {
                    break;
                }
                i++;
            }
            if (i2 == 0) {
                i2 = split.length - split2.length;
            }
            return i2;
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "Utils", "compareVersion");
            return -1;
        }
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (O000000o == null) {
            O000000o = Pattern.compile("[\\d+\\.]+");
        }
        return O000000o.matcher(str).matches();
    }

    /* JADX WARNING: Missing block: B:9:0x0017, code skipped:
            return false;
     */
    public static boolean O00000Oo(java.lang.String r2, java.lang.String r3) {
        /*
        r0 = O000000o(r2);
        r1 = 0;
        if (r0 == 0) goto L_0x0017;
    L_0x0007:
        r0 = O000000o(r3);
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0017;
    L_0x000e:
        r2 = O000000o(r2, r3);
        if (r2 != 0) goto L_0x0016;
    L_0x0014:
        r2 = 1;
        return r2;
    L_0x0016:
        return r1;
    L_0x0017:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ar.O00000Oo(java.lang.String, java.lang.String):boolean");
    }
}
