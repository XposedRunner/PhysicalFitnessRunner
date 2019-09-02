package com.baidu.mapapi.map;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;

public final class CircleOptions extends OverlayOptions {
    private static final String d = "CircleOptions";
    int a;
    boolean b = true;
    Bundle c;
    private LatLng e;
    private int f = ViewCompat.MEASURED_STATE_MASK;
    private int g;
    private Stroke h;

    /* Access modifiers changed, original: 0000 */
    public Overlay a() {
        Circle circle = new Circle();
        circle.x = this.b;
        circle.w = this.a;
        circle.y = this.c;
        circle.b = this.f;
        circle.a = this.e;
        circle.c = this.g;
        circle.d = this.h;
        return circle;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("circle center can not be null");
        }
        this.e = latLng;
        return this;
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.e;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getFillColor() {
        return this.f;
    }

    public int getRadius() {
        return this.g;
    }

    public Stroke getStroke() {
        return this.h;
    }

    public int getZIndex() {
        return this.a;
    }

    public boolean isVisible() {
        return this.b;
    }

    public CircleOptions radius(int i) {
        this.g = i;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public CircleOptions zIndex(int i) {
        this.a = i;
        return this;
    }
}
