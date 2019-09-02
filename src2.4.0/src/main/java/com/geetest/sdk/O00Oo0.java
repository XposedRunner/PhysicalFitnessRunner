package com.geetest.sdk;

/* compiled from: Pair */
public final class O00Oo0<F, S> {
    public F O000000o = null;
    public S O00000Oo = null;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof O00Oo0)) {
            return false;
        }
        try {
            O00Oo0 o00Oo0 = (O00Oo0) obj;
            return this.O000000o.equals(o00Oo0.O000000o) && this.O00000Oo.equals(o00Oo0.O00000Oo);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return ((527 + this.O000000o.hashCode()) * 31) + this.O00000Oo.hashCode();
    }
}
