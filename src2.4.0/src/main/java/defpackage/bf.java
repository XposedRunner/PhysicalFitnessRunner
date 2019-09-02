package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: SPHelper */
/* renamed from: bf */
public final class bf {
    private static bf O000000o = null;
    private static Context O00000Oo = null;
    private static final String O00000o = "mobclick_agent_user_";
    private static String O00000o0;

    /* compiled from: SPHelper */
    /* renamed from: bf$O000000o */
    private static final class O000000o {
        private static final bf O000000o = new bf();

        private O000000o() {
        }
    }

    public static synchronized bf O000000o(Context context) {
        bf O000000o;
        synchronized (bf.class) {
            if (O00000Oo == null && context != null) {
                O00000Oo = context.getApplicationContext();
            }
            if (O00000Oo != null) {
                O00000o0 = context.getPackageName();
            }
            O000000o = O000000o.O000000o;
        }
        return O000000o;
    }

    private SharedPreferences O00000oO() {
        if (O00000Oo == null) {
            return null;
        }
        Context context = O00000Oo;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O00000o);
        stringBuilder.append(O00000o0);
        return context.getSharedPreferences(stringBuilder.toString(), 0);
    }

    public void O000000o(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O00000Oo);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public void O000000o(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O00000Oo);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Editor edit = O00000oO().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }

    public String[] O000000o() {
        SharedPreferences O00000oO = O00000oO();
        if (O00000oO != null) {
            String string = O00000oO.getString("au_p", null);
            String string2 = O00000oO.getString("au_u", null);
            if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2))) {
                return new String[]{string, string2};
            }
        }
        return null;
    }

    public void O00000Oo() {
        SharedPreferences O00000oO = O00000oO();
        if (O00000oO != null) {
            O00000oO.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public int O00000o() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O00000Oo);
        return sharedPreferences != null ? sharedPreferences.getInt("vt", 0) : 0;
    }

    public String O00000o0() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(O00000Oo);
        return sharedPreferences != null ? sharedPreferences.getString("st", null) : null;
    }
}
