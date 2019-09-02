package com.amap.api.mapcore.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* compiled from: NativeBufferAbstractPool */
public class OOO0o0 extends Oo00000<O000000o> {
    private O000000o O00000Oo;

    /* compiled from: NativeBufferAbstractPool */
    static final class O000000o extends Oo000<O000000o> {
        ByteBuffer O000000o;
        ShortBuffer O00000Oo;
        IntBuffer O00000o;
        FloatBuffer O00000o0;
        int O00000oO;

        O000000o() {
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(int i) {
            if (i < 32768) {
                i = 32768;
            }
            this.O000000o = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            this.O00000oO = i;
            this.O00000Oo = null;
            this.O00000o = null;
            this.O00000o0 = null;
        }
    }

    public O000000o O000000o(int i) {
        O000000o o000000o = (O000000o) this.O000000o;
        if (o000000o == null) {
            o000000o = new O000000o();
        } else {
            this.O000000o = o000000o.O00000oo;
            o000000o.O00000oo = null;
        }
        if (o000000o.O00000oO < i) {
            o000000o.O000000o(i);
        }
        this.O00000Oo = (O000000o) Oo000.O000000o(this.O00000Oo, o000000o);
        return o000000o;
    }

    public void O000000o() {
        this.O00000Oo = (O000000o) O00000Oo(this.O00000Oo);
    }

    public ShortBuffer O00000Oo(int i) {
        O000000o O000000o = O000000o(i * 2);
        if (O000000o.O00000Oo == null) {
            O000000o.O000000o.clear();
            O000000o.O00000Oo = O000000o.O000000o.asShortBuffer();
        } else {
            O000000o.O00000Oo.clear();
        }
        return O000000o.O00000Oo;
    }

    public FloatBuffer O00000o0(int i) {
        O000000o O000000o = O000000o(i * 4);
        if (O000000o.O00000o0 == null) {
            O000000o.O000000o.clear();
            O000000o.O00000o0 = O000000o.O000000o.asFloatBuffer();
        } else {
            O000000o.O00000o0.clear();
        }
        O000000o.O00000o0.clear();
        return O000000o.O00000o0;
    }
}
