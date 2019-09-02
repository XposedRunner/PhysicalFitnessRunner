package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: StatisticsUtil */
public class OOOOOo0 {
    private static String O000000o(boolean z) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\"Quest\":");
            stringBuilder.append(z);
            stringBuilder.append("}");
            return stringBuilder.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void O000000o(Context context, boolean z) {
        try {
            String O000000o = O000000o(z);
            oOOO0o00 oooo0o00 = new oOOO0o00(context, "3dmap", "6.8.0", "O001");
            oooo0o00.O000000o(O000000o);
            oOOOOO0O.O000000o(oooo0o00, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
