package com.ximalaya.ting.android.xmpayordersdk;

import java.util.HashMap;
import java.util.Map;

/* compiled from: XmPayOrderCallBackManager */
public class O00000o {
    private static O00000o O000000o;
    private Map<String, O000000o> O00000Oo = new HashMap();

    public static O00000o O000000o() {
        if (O000000o == null) {
            synchronized (O00000o.class) {
                if (O000000o == null) {
                    O000000o = new O00000o();
                }
            }
        }
        return O000000o;
    }

    public O000000o O000000o(String str) {
        return (O000000o) this.O00000Oo.get(str);
    }

    public void O000000o(String str, O000000o o000000o) {
        this.O00000Oo.put(str, o000000o);
    }

    public void O00000Oo() {
        this.O00000Oo.clear();
        O000000o = null;
    }
}
