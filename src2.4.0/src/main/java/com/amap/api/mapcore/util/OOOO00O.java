package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: PreferenceTools */
public class OOOO00O {
    public static Long O000000o(Context context, String str, String str2, Long l) {
        Object O00000Oo = O00000Oo(context, str, str2, l);
        return O00000Oo != null ? (Long) O00000Oo : l;
    }

    public static String O000000o(Context context, String str, String str2, String str3) {
        Object O00000Oo = O00000Oo(context, str, str2, str3);
        return O00000Oo != null ? (String) O00000Oo : str3;
    }

    public static void O000000o(Context context, String str, String str2, Object obj) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            if (obj instanceof String) {
                edit.putString(str2, (String) obj);
            } else if (obj instanceof Integer) {
                edit.putInt(str2, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str2, ((Float) obj).floatValue());
            } else if (obj instanceof Long) {
                edit.putLong(str2, ((Long) obj).longValue());
            } else {
                edit.putString(str2, obj.toString());
            }
            edit.apply();
        }
    }

    private static Object O00000Oo(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return obj instanceof String ? sharedPreferences.getString(str2, (String) obj) : obj instanceof Integer ? Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue())) : obj instanceof Float ? Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue())) : obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue())) : null;
    }
}
