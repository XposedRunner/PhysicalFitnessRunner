package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* compiled from: SPUtil */
public class oO0O0Oo0 {
    private String O000000o;

    public oO0O0Oo0(String str) {
        if (TextUtils.isDigitsOnly(str)) {
            str = "SPUtil";
        }
        this.O000000o = o0OO00o0.O00000Oo(str);
    }

    private void O000000o(Editor editor) {
        if (editor != null) {
            if (VERSION.SDK_INT >= 9) {
                editor.apply();
            } else {
                editor.commit();
            }
        }
    }

    public void O000000o(Context context, String str, boolean z) {
        try {
            Editor edit = context.getSharedPreferences(this.O000000o, 0).edit();
            edit.putBoolean(str, z);
            O000000o(edit);
        } catch (Throwable unused) {
        }
    }

    public boolean O00000Oo(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        boolean z2;
        try {
            z2 = context.getSharedPreferences(this.O000000o, 0).getBoolean(str, z);
        } catch (Throwable unused) {
            z2 = z;
        }
        return z2;
    }
}
