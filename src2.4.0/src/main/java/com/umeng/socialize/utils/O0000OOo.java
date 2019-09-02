package com.umeng.socialize.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import defpackage.ce;
import defpackage.db;

/* compiled from: SocializeSpUtils */
public class O0000OOo {
    public static int O000000o(Context context, String str, int i) {
        return O0000O0o(context).getInt(str, i);
    }

    public static String O000000o(Context context) {
        SharedPreferences O0000O0o = O0000O0o(context);
        return O0000O0o != null ? O0000O0o.getString("uid", null) : null;
    }

    public static void O000000o(Context context, String str, String str2) {
        O0000O0o(context).edit().putString(str, str2).commit();
    }

    public static boolean O000000o(Context context, String str) {
        SharedPreferences O0000O0o = O0000O0o(context);
        if (O0000O0o == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return O0000O0o.edit().putString("uid", str).commit();
    }

    public static long O00000Oo(Context context) {
        SharedPreferences O0000O0o = O0000O0o(context);
        return O0000O0o != null ? O0000O0o.getLong(ce.O0000ooO, 0) : 0;
    }

    public static void O00000Oo(Context context, String str, int i) {
        O0000O0o(context).edit().putInt(str, i).commit();
    }

    public static boolean O00000Oo(Context context, String str) {
        SharedPreferences O0000O0o = O0000O0o(context);
        if (O0000O0o == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return O0000O0o.edit().putString(db.O0000o0o, str).commit();
    }

    public static String O00000o(Context context) {
        SharedPreferences O0000O0o = O0000O0o(context);
        return O0000O0o != null ? O0000O0o.getString(db.O00000oo, null) : null;
    }

    public static String O00000o(Context context, String str) {
        return O0000O0o(context).getString(str, "");
    }

    public static String O00000o0(Context context) {
        SharedPreferences O0000O0o = O0000O0o(context);
        return O0000O0o != null ? O0000O0o.getString(db.O0000o0o, null) : null;
    }

    public static boolean O00000o0(Context context, String str) {
        SharedPreferences O0000O0o = O0000O0o(context);
        if (O0000O0o == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return O0000O0o.edit().putString(db.O00000oo, str).commit();
    }

    public static void O00000oO(Context context, String str) {
        O0000O0o(context).edit().remove(str).commit();
    }

    public static boolean O00000oO(Context context) {
        SharedPreferences O0000O0o = O0000O0o(context);
        return O0000O0o != null && O0000O0o.edit().putLong(ce.O0000ooO, System.currentTimeMillis()).commit();
    }

    public static synchronized String O00000oo(Context context) {
        synchronized (O0000OOo.class) {
            SharedPreferences O0000O0o = O0000O0o(context);
            if (O0000O0o == null) {
                return null;
            }
            String string = O0000O0o.getString("shareboardconfig", null);
            return string;
        }
    }

    public static synchronized boolean O00000oo(Context context, String str) {
        synchronized (O0000OOo.class) {
            SharedPreferences O0000O0o = O0000O0o(context);
            if (O0000O0o == null) {
                return false;
            }
            boolean commit = O0000O0o.edit().putString("shareboardconfig", str).commit();
            return commit;
        }
    }

    private static SharedPreferences O0000O0o(Context context) {
        return context == null ? null : context.getSharedPreferences(ce.O000000o, 0);
    }
}
