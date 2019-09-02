package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.umeng.socialize.utils.O0000o0;
import com.umeng.socialize.utils.O0000o00;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ResContainer */
/* renamed from: cd */
public final class cd {
    private static cd O000000o = null;
    private static String O00000oO = "";
    private Map<String, Integer> O00000Oo = new HashMap();
    private Map<String, O000000o> O00000o;
    private Context O00000o0 = null;

    /* compiled from: ResContainer */
    /* renamed from: cd$O000000o */
    public static class O000000o {
        public String O000000o;
        public String O00000Oo;
        public int O00000o;
        public boolean O00000o0 = false;

        public O000000o(String str, String str2) {
            this.O000000o = str;
            this.O00000Oo = str2;
        }
    }

    private cd(Context context) {
        this.O00000o0 = context.getApplicationContext();
    }

    public cd(Context context, Map<String, O000000o> map) {
        this.O00000o = map;
        this.O00000o0 = context;
    }

    public static int O000000o(Context context, String str, String str2) {
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(O00000oO)) {
            O00000oO = context.getPackageName();
        }
        int identifier = resources.getIdentifier(str2, str, O00000oO);
        if (identifier > 0) {
            return identifier;
        }
        throw new RuntimeException(O0000o00.O000000o(O0000o00.O000000o(O00000oO, str, str2), O0000o0.O0000oo0));
    }

    public static synchronized cd O000000o(Context context) {
        cd cdVar;
        synchronized (cd.class) {
            if (O000000o == null) {
                O000000o = new cd(context);
            }
            cdVar = O000000o;
        }
        return cdVar;
    }

    public static String O000000o(Context context, String str) {
        return context.getString(cd.O000000o(context, "string", str));
    }

    public int O000000o(String str) {
        return cd.O000000o(this.O00000o0, "layout", str);
    }

    public synchronized Map<String, O000000o> O000000o() {
        if (this.O00000o == null) {
            return this.O00000o;
        }
        for (String str : this.O00000o.keySet()) {
            O000000o o000000o = (O000000o) this.O00000o.get(str);
            o000000o.O00000o = cd.O000000o(this.O00000o0, o000000o.O000000o, o000000o.O00000Oo);
            o000000o.O00000o0 = true;
        }
        return this.O00000o;
    }

    public int O00000Oo(String str) {
        return cd.O000000o(this.O00000o0, "id", str);
    }

    public int O00000o(String str) {
        return cd.O000000o(this.O00000o0, "style", str);
    }

    public int O00000o0(String str) {
        return cd.O000000o(this.O00000o0, "drawable", str);
    }

    public int O00000oO(String str) {
        return cd.O000000o(this.O00000o0, "string", str);
    }

    public int O00000oo(String str) {
        return cd.O000000o(this.O00000o0, "color", str);
    }

    public int O0000O0o(String str) {
        return cd.O000000o(this.O00000o0, "dimen", str);
    }

    public int O0000OOo(String str) {
        return cd.O000000o(this.O00000o0, "raw", str);
    }

    public int O0000Oo(String str) {
        return cd.O000000o(this.O00000o0, "styleable", str);
    }

    public int O0000Oo0(String str) {
        return cd.O000000o(this.O00000o0, "anim", str);
    }
}
