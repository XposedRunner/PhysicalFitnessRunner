package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.DPoint;

/* compiled from: Bounds */
public class OO0o0 {
    public final double O000000o;
    public final double O00000Oo;
    public final double O00000o;
    public final double O00000o0;
    public final double O00000oO;
    public final double O00000oo;

    public OO0o0(double d, double d2, double d3, double d4) {
        this.O000000o = d;
        this.O00000Oo = d3;
        this.O00000o0 = d2;
        this.O00000o = d4;
        this.O00000oO = (d + d2) / 2.0d;
        this.O00000oo = (d3 + d4) / 2.0d;
    }

    public boolean O000000o(double d, double d2) {
        return this.O000000o <= d && d <= this.O00000o0 && this.O00000Oo <= d2 && d2 <= this.O00000o;
    }

    public boolean O000000o(double d, double d2, double d3, double d4) {
        return d < this.O00000o0 && this.O000000o < d2 && d3 < this.O00000o && this.O00000Oo < d4;
    }

    public boolean O000000o(OO0o0 oO0o0) {
        return O000000o(oO0o0.O000000o, oO0o0.O00000o0, oO0o0.O00000Oo, oO0o0.O00000o);
    }

    public boolean O000000o(DPoint dPoint) {
        return O000000o(dPoint.x, dPoint.y);
    }

    public boolean O00000Oo(OO0o0 oO0o0) {
        return oO0o0.O000000o >= this.O000000o && oO0o0.O00000o0 <= this.O00000o0 && oO0o0.O00000Oo >= this.O00000Oo && oO0o0.O00000o <= this.O00000o;
    }
}
