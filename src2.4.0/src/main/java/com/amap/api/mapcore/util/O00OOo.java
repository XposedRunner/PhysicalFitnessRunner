package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: TaskManager */
public class O00OOo {
    private static O00OOo O000000o;
    private r O00000Oo;
    private boolean O00000o = true;
    private LinkedHashMap<String, s> O00000o0 = new LinkedHashMap();

    private O00OOo(boolean z, int i) {
        if (z) {
            try {
                this.O00000Oo = r.O000000o(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static O00OOo O000000o(int i) {
        return O000000o(true, i);
    }

    private static synchronized O00OOo O000000o(boolean z, int i) {
        O00OOo o00OOo;
        synchronized (O00OOo.class) {
            try {
                if (O000000o == null) {
                    O000000o = new O00OOo(z, i);
                } else if (z && O000000o.O00000Oo == null) {
                    O000000o.O00000Oo = r.O000000o(i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            o00OOo = O000000o;
        }
        return o00OOo;
    }

    public static void O00000o0() {
        O000000o = null;
    }

    public void O000000o() {
        synchronized (this.O00000o0) {
            if (this.O00000o0.size() < 1) {
                return;
            }
            for (Entry entry : this.O00000o0.entrySet()) {
                entry.getKey();
                ((O00O0o) entry.getValue()).O000000o();
            }
            this.O00000o0.clear();
        }
    }

    public void O000000o(O00OOo0 o00OOo0) {
        synchronized (this.O00000o0) {
            O00O0o o00O0o = (O00O0o) this.O00000o0.get(o00OOo0.O00000Oo());
            if (o00O0o == null) {
                return;
            }
            o00O0o.O000000o();
            this.O00000o0.remove(o00OOo0.O00000Oo());
        }
    }

    public void O000000o(O00OOo0 o00OOo0, Context context, AMap aMap) throws o0O0oo0o {
        r rVar = this.O00000Oo;
        if (!this.O00000o0.containsKey(o00OOo0.O00000Oo())) {
            O00O0o o00O0o = new O00O0o((O0O00oO) o00OOo0, context.getApplicationContext(), aMap);
            synchronized (this.O00000o0) {
                this.O00000o0.put(o00OOo0.O00000Oo(), o00O0o);
            }
        }
        this.O00000Oo.O000000o((s) this.O00000o0.get(o00OOo0.O00000Oo()));
    }

    public void O00000Oo() {
        O000000o();
        r.O000000o();
        this.O00000Oo = null;
        O00000o0();
    }

    public void O00000Oo(O00OOo0 o00OOo0) {
        O00O0o o00O0o = (O00O0o) this.O00000o0.get(o00OOo0.O00000Oo());
        if (o00O0o != null) {
            synchronized (this.O00000o0) {
                o00O0o.O00000Oo();
                this.O00000o0.remove(o00OOo0.O00000Oo());
            }
        }
    }
}
