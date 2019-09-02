package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.IPoint;

/* compiled from: IBounds */
public class O00O000o {
    public int O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;

    public O00O000o(int i, int i2, int i3, int i4) {
        O000000o(i, i2, i3, i4);
    }

    public void O000000o(int i, int i2, int i3, int i4) {
        this.O000000o = i;
        this.O00000Oo = i3;
        this.O00000o0 = i2;
        this.O00000o = i4;
        this.O00000oO = (i + i2) / 2;
        this.O00000oo = (i3 + i4) / 2;
    }

    public boolean O000000o(int i, int i2) {
        return this.O000000o <= i && i <= this.O00000o0 && this.O00000Oo <= i2 && i2 <= this.O00000o;
    }

    public boolean O000000o(O00O000o o00O000o) {
        return o00O000o == null ? false : O00000Oo(o00O000o.O000000o, o00O000o.O00000o0, o00O000o.O00000Oo, o00O000o.O00000o);
    }

    public boolean O000000o(IPoint iPoint) {
        return iPoint == null ? false : O000000o(iPoint.x, iPoint.y);
    }

    public boolean O00000Oo(int i, int i2, int i3, int i4) {
        return i < this.O00000o0 && this.O000000o < i2 && i3 < this.O00000o && this.O00000Oo < i4;
    }
}
