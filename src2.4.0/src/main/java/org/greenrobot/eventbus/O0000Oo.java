package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost */
final class O0000Oo {
    private static final List<O0000Oo> O00000o = new ArrayList();
    Object O000000o;
    O000O00o O00000Oo;
    O0000Oo O00000o0;

    private O0000Oo(Object obj, O000O00o o000O00o) {
        this.O000000o = obj;
        this.O00000Oo = o000O00o;
    }

    static O0000Oo O000000o(O000O00o o000O00o, Object obj) {
        synchronized (O00000o) {
            int size = O00000o.size();
            if (size > 0) {
                O0000Oo o0000Oo = (O0000Oo) O00000o.remove(size - 1);
                o0000Oo.O000000o = obj;
                o0000Oo.O00000Oo = o000O00o;
                o0000Oo.O00000o0 = null;
                return o0000Oo;
            }
            return new O0000Oo(obj, o000O00o);
        }
    }

    static void O000000o(O0000Oo o0000Oo) {
        o0000Oo.O000000o = null;
        o0000Oo.O00000Oo = null;
        o0000Oo.O00000o0 = null;
        synchronized (O00000o) {
            if (O00000o.size() < 10000) {
                O00000o.add(o0000Oo);
            }
        }
    }
}
