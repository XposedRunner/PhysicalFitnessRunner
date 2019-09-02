package org.greenrobot.eventbus;

/* compiled from: Subscription */
final class O000O00o {
    final Object O000000o;
    final O0000o O00000Oo;
    volatile boolean O00000o0 = true;

    O000O00o(Object obj, O0000o o0000o) {
        this.O000000o = obj;
        this.O00000Oo = o0000o;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof O000O00o)) {
            return false;
        }
        O000O00o o000O00o = (O000O00o) obj;
        if (this.O000000o == o000O00o.O000000o && this.O00000Oo.equals(o000O00o.O00000Oo)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.O000000o.hashCode() + this.O00000Oo.O00000oo.hashCode();
    }
}
