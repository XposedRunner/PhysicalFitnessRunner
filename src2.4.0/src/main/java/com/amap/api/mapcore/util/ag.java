package com.amap.api.mapcore.util;

import java.util.List;

/* compiled from: TaskRunner */
public abstract class ag {

    /* compiled from: TaskRunner */
    public interface O000000o {
        int O000000o();

        void O00000Oo();
    }

    private int O000000o(List<O000000o> list) {
        int i = 0;
        while (i < list.size()) {
            O000000o o000000o = (O000000o) list.get(i);
            if (o000000o == null) {
                return O000000o(list, i);
            }
            try {
                if (o000000o.O000000o() != 1000) {
                    return O000000o(list, i);
                }
                i++;
            } catch (Throwable unused) {
                return O000000o(list, i);
            }
        }
        return 1000;
    }

    private static int O000000o(List<O000000o> list, int i) {
        int i2 = 0;
        while (i2 < list.size() && i2 <= i) {
            O000000o o000000o = (O000000o) list.get(i2);
            if (o000000o != null) {
                try {
                    o000000o.O00000Oo();
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "po", "s0");
                }
            }
            i2++;
        }
        return 1003;
    }

    public abstract List<O000000o> O000000o();

    public abstract boolean O00000Oo();

    public final int O00000o0() {
        if (!O00000Oo()) {
            return 1004;
        }
        List O000000o = O000000o();
        return (O000000o == null || O000000o.size() == 0) ? 1001 : O000000o(O000000o);
    }
}
