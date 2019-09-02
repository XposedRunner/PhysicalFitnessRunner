package com.amap.api.mapcore.util;

/* compiled from: Inlist */
public class Oo000<T extends Oo000<T>> {
    public T O00000oo;

    public static <T extends Oo000<?>> T O000000o(T t, T t2) {
        if (t2.O00000oo != null) {
            throw new IllegalArgumentException("'item' is a list");
        }
        t2.O00000oo = t;
        return t2;
    }
}
