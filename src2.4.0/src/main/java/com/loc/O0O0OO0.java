package com.loc;

/* compiled from: UpdateStrategy */
public abstract class O0O0OO0 {
    O0O0OO0 O000000o;

    public O0O0OO0(O0O0OO0 o0o0oo0) {
        this.O000000o = o0o0oo0;
    }

    public void O000000o(int i) {
        if (this.O000000o != null) {
            this.O000000o.O000000o(i);
        }
    }

    public void O000000o(boolean z) {
        if (this.O000000o != null) {
            this.O000000o.O000000o(z);
        }
    }

    public abstract boolean O000000o();

    public int O00000Oo() {
        return Math.min(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, this.O000000o != null ? this.O000000o.O00000Oo() : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public final boolean O00000o0() {
        return !(this.O000000o != null ? this.O000000o.O00000o0() : true) ? false : O000000o();
    }
}
