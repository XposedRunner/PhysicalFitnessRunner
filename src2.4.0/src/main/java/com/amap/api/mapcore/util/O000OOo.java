package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: ScaleRotateGestureDetector */
public class O000OOo extends O000OOo0 {

    /* compiled from: ScaleRotateGestureDetector */
    public static abstract class O000000o implements com.amap.api.mapcore.util.O000OOo0.O000000o {
        public boolean O000000o(O000OOo0 o000OOo0) {
            return O000000o((O000OOo) o000OOo0);
        }

        public abstract boolean O000000o(O000OOo o000OOo);

        public boolean O00000Oo(O000OOo0 o000OOo0) {
            return O00000Oo((O000OOo) o000OOo0);
        }

        public abstract boolean O00000Oo(O000OOo o000OOo);

        public void O00000o0(O000OOo0 o000OOo0) {
            O00000o0((O000OOo) o000OOo0);
        }

        public abstract void O00000o0(O000OOo o000OOo);
    }

    public O000OOo(Context context, O000000o o000000o) {
        super(context, o000000o);
    }

    public float O0000Ooo() {
        return (float) (((Math.atan2((double) O0000Oo0(), (double) O0000OOo()) - Math.atan2((double) O00000oo(), (double) O00000oO())) * 180.0d) / 3.141592653589793d);
    }
}
