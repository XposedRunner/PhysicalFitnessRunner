package defpackage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.umeng.socialize.Config;
import com.umeng.socialize.utils.O00000Oo;

/* compiled from: UMLog */
/* renamed from: dh */
public class dh {
    private static boolean O000000o;
    private static boolean O00000Oo;

    public static void O000000o() {
        if (O00000Oo.O000000o() != null && !O00000Oo) {
            Editor edit = O00000Oo.O000000o().getSharedPreferences(ce.O000000o, 0).edit();
            edit.putBoolean("share", true);
            edit.putBoolean("isjump", Config.isJumptoAppStore);
            edit.commit();
            O00000Oo = true;
        }
    }

    public static void O000000o(boolean z) {
        if (O00000Oo.O000000o() != null) {
            O00000Oo.O000000o().getSharedPreferences(ce.O000000o, 0).edit().putBoolean(ce.O00000o0, z).apply();
        }
    }

    public static void O00000Oo() {
        if (O00000Oo.O000000o() != null && !O000000o) {
            Editor edit = O00000Oo.O000000o().getSharedPreferences(ce.O000000o, 0).edit();
            edit.putBoolean("auth", true);
            edit.putBoolean("isjump", Config.isJumptoAppStore);
            edit.commit();
            O00000Oo = true;
        }
    }

    public static boolean O00000o() {
        return O00000Oo.O000000o() != null ? O00000Oo.O000000o().getSharedPreferences(ce.O000000o, 0).getBoolean(ce.O00000o0, true) : true;
    }

    public static Bundle O00000o0() {
        Bundle bundle = new Bundle();
        if (O00000Oo.O000000o() != null) {
            SharedPreferences sharedPreferences = O00000Oo.O000000o().getSharedPreferences(ce.O000000o, 0);
            bundle.putBoolean("share", sharedPreferences.getBoolean("share", false));
            bundle.putBoolean("auth", sharedPreferences.getBoolean("auth", false));
            bundle.putBoolean("isjump", sharedPreferences.getBoolean("isjump", false));
        } else {
            bundle.putBoolean("share", false);
            bundle.putBoolean("auth", false);
            bundle.putBoolean("isjump", false);
        }
        return bundle;
    }
}
