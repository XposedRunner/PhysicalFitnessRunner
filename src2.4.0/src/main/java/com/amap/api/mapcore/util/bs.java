package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* compiled from: SpUtil */
public final class bs {
    public static int O000000o(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, 200);
        } catch (Throwable th) {
            bp.O000000o(th, "SpUtil", "getPrefsInt");
            return 200;
        }
    }

    public static String O000000o(Context context) {
        String str = "00:00:00:00:00:00";
        return context == null ? str : O00000Oo(context, "pref", "smac", str);
    }

    public static void O000000o(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            O000000o(context, "pref", "smac", str);
        }
    }

    private static void O000000o(Context context, String str, String str2, String str3) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            O000000o(edit);
        } catch (Throwable th) {
            bp.O000000o(th, "SpUtil", "setPrefsStr");
        }
    }

    @SuppressLint({"NewApi"})
    private static void O000000o(Editor editor) {
        if (editor != null) {
            if (VERSION.SDK_INT >= 9) {
                editor.apply();
            } else {
                O00000Oo(editor);
            }
        }
    }

    private static String O00000Oo(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            bp.O000000o(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    private static void O00000Oo(final Editor editor) {
        try {
            new AsyncTask<Void, Void, Void>() {
                private Void O000000o() {
                    try {
                        if (editor != null) {
                            editor.commit();
                        }
                    } catch (Throwable th) {
                        bp.O000000o(th, "SpUtil", "commit");
                    }
                    return null;
                }

                /* Access modifiers changed, original: protected|final|synthetic */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    return O000000o();
                }
            }.execute(new Void[]{null, null, null});
        } catch (Throwable th) {
            bp.O000000o(th, "SpUtil", "commit1");
        }
    }

    public static boolean O00000Oo(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, true);
        } catch (Throwable th) {
            bp.O000000o(th, "SpUtil", "getPrefsBoolean");
            return true;
        }
    }
}
