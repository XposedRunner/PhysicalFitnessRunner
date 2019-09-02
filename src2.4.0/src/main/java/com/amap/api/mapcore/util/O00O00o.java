package com.amap.api.mapcore.util;

import com.amap.api.maps.model.MultiPointItem;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: QuadTree2 */
public class O00O00o {
    private final O00O000o O000000o;
    private final int O00000Oo;
    private List<MultiPointItem> O00000o;
    private int O00000o0;
    private List<O00O00o> O00000oO;

    private O00O00o(int i, int i2, int i3, int i4, int i5) {
        this(new O00O000o(i, i2, i3, i4), i5);
    }

    protected O00O00o(O00O000o o00O000o) {
        this(o00O000o, 0);
    }

    private O00O00o(O00O000o o00O000o, int i) {
        this.O00000o0 = 30;
        this.O00000oO = null;
        this.O000000o = o00O000o;
        this.O00000Oo = i;
        this.O00000o0 = O000000o(this.O00000Oo);
    }

    private int O000000o(int i) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 30;
            case 2:
            case 3:
                return 20;
            case 4:
            case 5:
                return 10;
            default:
                return 5;
        }
    }

    private void O000000o(int i, int i2, MultiPointItem multiPointItem) {
        if (this.O00000o == null) {
            this.O00000o = new ArrayList();
        }
        if (this.O00000o.size() <= this.O00000o0 || this.O00000Oo >= 40) {
            this.O00000o.add(multiPointItem);
            return;
        }
        if (this.O00000oO == null) {
            O00000Oo();
        }
        if (this.O00000oO != null) {
            if (i2 < this.O000000o.O00000oo) {
                if (i < this.O000000o.O00000oO) {
                    ((O00O00o) this.O00000oO.get(0)).O000000o(i, i2, multiPointItem);
                } else {
                    ((O00O00o) this.O00000oO.get(1)).O000000o(i, i2, multiPointItem);
                }
            } else if (i < this.O000000o.O00000oO) {
                ((O00O00o) this.O00000oO.get(2)).O000000o(i, i2, multiPointItem);
            } else {
                ((O00O00o) this.O00000oO.get(3)).O000000o(i, i2, multiPointItem);
            }
        }
    }

    private void O000000o(O00O000o o00O000o, Collection<MultiPointItem> collection, float f, double d) {
        if (this.O000000o.O000000o(o00O000o)) {
            if (this.O00000o != null) {
                int size = (int) (((float) this.O00000o.size()) * f);
                for (int i = 0; i < size; i++) {
                    MultiPointItem multiPointItem = (MultiPointItem) this.O00000o.get(i);
                    if (o00O000o.O000000o(multiPointItem.getIPoint())) {
                        collection.add(multiPointItem);
                    }
                }
            }
            if (d > 0.0d) {
                double d2 = ((((double) this.O000000o.O00000o) - ((double) this.O000000o.O00000Oo)) * (((double) this.O000000o.O00000o0) - ((double) this.O000000o.O000000o))) / d;
                if (d2 >= ((double) 0.7f)) {
                    f = d2 > 1.0d ? 1.0f : (float) ((((4.8188d * d2) * d2) - (4.9339d * d2)) + 1.1093d);
                } else {
                    return;
                }
            }
            if (this.O00000oO != null) {
                for (O00O00o O000000o : this.O00000oO) {
                    O000000o.O000000o(o00O000o, collection, f, d);
                }
            }
        }
    }

    private void O00000Oo() {
        this.O00000oO = new ArrayList(4);
        this.O00000oO.add(new O00O00o(this.O000000o.O000000o, this.O000000o.O00000oO, this.O000000o.O00000Oo, this.O000000o.O00000oo, this.O00000Oo + 1));
        this.O00000oO.add(new O00O00o(this.O000000o.O00000oO, this.O000000o.O00000o0, this.O000000o.O00000Oo, this.O000000o.O00000oo, this.O00000Oo + 1));
        this.O00000oO.add(new O00O00o(this.O000000o.O000000o, this.O000000o.O00000oO, this.O000000o.O00000oo, this.O000000o.O00000o, this.O00000Oo + 1));
        this.O00000oO.add(new O00O00o(this.O000000o.O00000oO, this.O000000o.O00000o0, this.O000000o.O00000oo, this.O000000o.O00000o, this.O00000Oo + 1));
    }

    /* Access modifiers changed, original: protected */
    public void O000000o() {
        this.O00000oO = null;
        if (this.O00000o != null) {
            this.O00000o.clear();
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(O00O000o o00O000o, Collection<MultiPointItem> collection, double d) {
        O000000o(o00O000o, collection, 1.0f, d);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(MultiPointItem multiPointItem) {
        IPoint iPoint = multiPointItem.getIPoint();
        if (this.O000000o.O000000o(iPoint.x, iPoint.y)) {
            O000000o(iPoint.x, iPoint.y, multiPointItem);
        }
    }
}
