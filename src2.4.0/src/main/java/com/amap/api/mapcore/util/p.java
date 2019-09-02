package com.amap.api.mapcore.util;

/* compiled from: UpdateStrategy */
public abstract class p {
    p O000000o;

    public p(p pVar) {
        this.O000000o = pVar;
    }

    private boolean O00000o() {
        return this.O000000o != null ? this.O000000o.O00000o0() : true;
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

    public boolean O00000o0() {
        return !O00000o() ? false : O000000o();
    }
}
