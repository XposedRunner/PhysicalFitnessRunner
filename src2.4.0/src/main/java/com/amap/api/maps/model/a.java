package com.amap.api.maps.model;

import com.amap.api.mapcore.util.OO0o0;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: PointQuadTree */
class a {
    private final OO0o0 a;
    private final int b;
    private List<WeightedLatLng> c;
    private List<a> d;

    private a(double d, double d2, double d3, double d4, int i) {
        OO0o0 oO0o0 = new OO0o0(d, d2, d3, d4);
        this(oO0o0, i);
    }

    protected a(OO0o0 oO0o0) {
        this(oO0o0, 0);
    }

    private a(OO0o0 oO0o0, int i) {
        this.d = null;
        this.a = oO0o0;
        this.b = i;
    }

    private void a() {
        this.d = new ArrayList(4);
        this.d.add(new a(this.a.O000000o, this.a.O00000oO, this.a.O00000Oo, this.a.O00000oo, this.b + 1));
        this.d.add(new a(this.a.O00000oO, this.a.O00000o0, this.a.O00000Oo, this.a.O00000oo, this.b + 1));
        this.d.add(new a(this.a.O000000o, this.a.O00000oO, this.a.O00000oo, this.a.O00000o, this.b + 1));
        this.d.add(new a(this.a.O00000oO, this.a.O00000o0, this.a.O00000oo, this.a.O00000o, this.b + 1));
        List<WeightedLatLng> list = this.c;
        this.c = null;
        for (WeightedLatLng weightedLatLng : list) {
            a(weightedLatLng.getPoint().x, weightedLatLng.getPoint().y, weightedLatLng);
        }
    }

    private void a(double d, double d2, WeightedLatLng weightedLatLng) {
        if (this.d != null) {
            if (d2 < this.a.O00000oo) {
                if (d < this.a.O00000oO) {
                    ((a) this.d.get(0)).a(d, d2, weightedLatLng);
                } else {
                    ((a) this.d.get(1)).a(d, d2, weightedLatLng);
                }
            } else if (d < this.a.O00000oO) {
                ((a) this.d.get(2)).a(d, d2, weightedLatLng);
            } else {
                ((a) this.d.get(3)).a(d, d2, weightedLatLng);
            }
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(weightedLatLng);
        if (this.c.size() > 50 && this.b < 40) {
            a();
        }
    }

    private void a(OO0o0 oO0o0, Collection<WeightedLatLng> collection) {
        if (this.a.O000000o(oO0o0)) {
            if (this.d != null) {
                for (a a : this.d) {
                    a.a(oO0o0, collection);
                }
            } else if (this.c != null) {
                if (oO0o0.O00000Oo(this.a)) {
                    collection.addAll(this.c);
                } else {
                    for (WeightedLatLng weightedLatLng : this.c) {
                        if (oO0o0.O000000o(weightedLatLng.getPoint())) {
                            collection.add(weightedLatLng);
                        }
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public Collection<WeightedLatLng> a(OO0o0 oO0o0) {
        ArrayList arrayList = new ArrayList();
        a(oO0o0, arrayList);
        return arrayList;
    }

    /* Access modifiers changed, original: protected */
    public void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.a.O000000o(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }
}
