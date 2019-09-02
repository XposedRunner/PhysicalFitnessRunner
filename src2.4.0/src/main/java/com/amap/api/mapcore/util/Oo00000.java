package com.amap.api.mapcore.util;

/* compiled from: AbstractPool */
public abstract class Oo00000<T extends Oo000<?>> {
    protected T O000000o;

    /* Access modifiers changed, original: protected */
    public boolean O000000o(T t) {
        return true;
    }

    public T O00000Oo(T t) {
        if (t == null) {
            return null;
        }
        Oo000 t2;
        while (t2 != null) {
            Oo000 oo000 = t2.O00000oo;
            O000000o(t2);
            t2.O00000oo = this.O000000o;
            this.O000000o = t2;
            t2 = oo000;
        }
        return null;
    }
}
