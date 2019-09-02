package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;

/* compiled from: SpUtil */
public final class OO0000o {
    public static void O000000o(Context context, String str, String str2, int i) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i);
            O000000o(edit);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SpUtil", "setPrefsInt");
        }
    }

    public static void O000000o(Context context, String str, String str2, long j) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            O000000o(edit);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void O000000o(Context context, String str, String str2, String str3) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            O000000o(edit);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SpUtil", "setPrefsStr");
        }
    }

    public static void O000000o(Context context, String str, String str2, boolean z) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(str2, z);
            O000000o(edit);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SpUtil", "updatePrefsBoolean");
        }
    }

    @SuppressLint({"NewApi"})
    public static void O000000o(final Editor editor) {
        if (editor != null) {
            if (VERSION.SDK_INT >= 9) {
                editor.apply();
                return;
            }
            try {
                new AsyncTask<Void, Void, Void>() {
                    private Void O000000o() {
                        try {
                            if (editor != null) {
                                editor.commit();
                            }
                        } catch (Throwable th) {
                            O0o0000.O000000o(th, "SpUtil", "commit");
                        }
                        return null;
                    }

                    /* Access modifiers changed, original: protected|final|synthetic */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }
                }.execute(new Void[]{null, null, null});
            } catch (Throwable th) {
                O0o0000.O000000o(th, "SpUtil", "commit1");
            }
        }
    }

    public static int O00000Oo(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SpUtil", "getPrefsInt");
            return i;
        }
    }

    public static long O00000Oo(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SpUtil", "getPrefsLong");
            return j;
        }
    }

    public static String O00000Oo(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static boolean O00000Oo(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SpUtil", "getPrefsBoolean");
            return z;
        }
    }
}
