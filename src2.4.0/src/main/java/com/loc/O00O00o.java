package com.loc;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* compiled from: SPUtil */
public final class O00O00o {
    private String O000000o;

    public O00O00o(String str) {
        if (TextUtils.isDigitsOnly(str)) {
            str = "SPUtil";
        }
        this.O000000o = OO0OOOO.O00000Oo(str);
    }

    public final void O000000o(Context context, String str, boolean z) {
        try {
            Editor edit = context.getSharedPreferences(this.O000000o, 0).edit();
            edit.putBoolean(str, z);
            if (edit != null) {
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                    return;
                }
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean O000000o(Context context, String str) {
        if (context == null) {
            return true;
        }
        try {
            return context.getSharedPreferences(this.O000000o, 0).getBoolean(str, true);
        } catch (Throwable unused) {
            return true;
        }
    }
}
