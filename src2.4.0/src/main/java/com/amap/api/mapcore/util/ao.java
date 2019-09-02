package com.amap.api.mapcore.util;

/* compiled from: FileCleaner */
public final class ao {

    /* compiled from: FileCleaner */
    static class O000000o {
        public static ao O000000o = new ao();
    }

    public static ao O000000o() {
        return O000000o.O000000o;
    }

    public static void O000000o(String str) {
        try {
            t.O00000oO(str);
        } catch (Throwable th) {
            t.O000000o(th, "cf");
        }
    }

    public final void O00000Oo(final String str) {
        oO0OO000.O00000Oo().O000000o().submit(new Runnable() {
            public final void run() {
                try {
                    t.O00000oO(str);
                } catch (Throwable th) {
                    t.O000000o(th, "cfa");
                }
            }
        });
    }

    public final void O00000o0(final String str) {
        oO0OO000.O00000Oo().O000000o().submit(new Runnable() {
            public final void run() {
                try {
                    t.O00000o(str);
                } catch (Throwable th) {
                    t.O000000o(th, "cda");
                }
            }
        });
    }
}
