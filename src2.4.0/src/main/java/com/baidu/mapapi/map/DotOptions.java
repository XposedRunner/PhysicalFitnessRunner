package com.baidu.mapapi.map;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;

public final class DotOptions extends OverlayOptions {
    int a;
    boolean b = true;
    Bundle c;
    private LatLng d;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private int f = 5;

    /* Access modifiers changed, original: 0000 */
    public Overlay a() {
        Dot dot = new Dot();
        dot.x = this.b;
        dot.w = this.a;
        dot.y = this.c;
        dot.b = this.e;
        dot.a = this.d;
        dot.c = this.f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("dot center can not be null");
        }
        this.d = latLng;
        return this;
    }

    public DotOptions color(int i) {
        this.e = i;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.d;
    }

    public int getColor() {
        return this.e;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getRadius() {
        return this.f;
    }

    public int getZIndex() {
        return this.a;
    }

    public boolean isVisible() {
        return this.b;
    }

    public DotOptions radius(int i) {
        if (i > 0) {
            this.f = i;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public DotOptions zIndex(int i) {
        this.a = i;
        return this;
    }
}
