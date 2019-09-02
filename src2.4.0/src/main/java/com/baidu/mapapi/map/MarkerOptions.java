package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

public final class MarkerOptions extends OverlayOptions {
    int a;
    boolean b = true;
    Bundle c;
    private LatLng d;
    private BitmapDescriptor e;
    private float f = 0.5f;
    private float g = 1.0f;
    private boolean h = true;
    private boolean i = false;
    private float j;
    private String k;
    private int l;
    private boolean m = false;
    private ArrayList<BitmapDescriptor> n;
    private int o = 20;
    private float p = 1.0f;
    private float q = 1.0f;
    private float r = 1.0f;
    private int s = MarkerAnimateType.none.ordinal();
    private boolean t = false;
    private Point u;

    public enum MarkerAnimateType {
        none,
        drop,
        grow,
        jump
    }

    /* Access modifiers changed, original: 0000 */
    public Overlay a() {
        Marker marker = new Marker();
        marker.x = this.b;
        marker.w = this.a;
        marker.y = this.c;
        if (this.d == null) {
            throw new IllegalStateException("when you add marker, you must set the position");
        }
        marker.a = this.d;
        if (this.e == null && this.n == null) {
            throw new IllegalStateException("when you add marker, you must set the icon or icons");
        }
        marker.b = this.e;
        marker.c = this.f;
        marker.d = this.g;
        marker.e = this.h;
        marker.f = this.i;
        marker.g = this.j;
        marker.h = this.k;
        marker.i = this.l;
        marker.j = this.m;
        marker.o = this.n;
        marker.p = this.o;
        marker.l = this.r;
        marker.r = this.p;
        marker.s = this.q;
        marker.m = this.s;
        marker.n = this.t;
        if (this.u != null) {
            marker.u = this.u;
        }
        return marker;
    }

    public MarkerOptions alpha(float f) {
        if (f < 0.0f || f > 1.0f) {
            this.r = 1.0f;
            return this;
        }
        this.r = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            return this;
        }
        this.f = f;
        this.g = f2;
        return this;
    }

    public MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        if (markerAnimateType == null) {
            markerAnimateType = MarkerAnimateType.none;
        }
        this.s = markerAnimateType.ordinal();
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.i = z;
        return this;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public MarkerOptions fixedScreenPosition(Point point) {
        this.u = point;
        this.t = true;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.m = z;
        return this;
    }

    public float getAlpha() {
        return this.r;
    }

    public float getAnchorX() {
        return this.f;
    }

    public float getAnchorY() {
        return this.g;
    }

    public MarkerAnimateType getAnimateType() {
        switch (this.s) {
            case 1:
                return MarkerAnimateType.drop;
            case 2:
                return MarkerAnimateType.grow;
            case 3:
                return MarkerAnimateType.jump;
            default:
                return MarkerAnimateType.none;
        }
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public BitmapDescriptor getIcon() {
        return this.e;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.n;
    }

    public int getPeriod() {
        return this.o;
    }

    public LatLng getPosition() {
        return this.d;
    }

    public float getRotate() {
        return this.j;
    }

    public String getTitle() {
        return this.k;
    }

    public int getZIndex() {
        return this.a;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("marker's icon can not be null");
        }
        this.e = bitmapDescriptor;
        return this;
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("marker's icons can not be null");
        } else if (arrayList.size() == 0) {
            return this;
        } else {
            int i = 0;
            while (i < arrayList.size()) {
                if (arrayList.get(i) == null || ((BitmapDescriptor) arrayList.get(i)).a == null) {
                    return this;
                }
                i++;
            }
            this.n = arrayList;
            return this;
        }
    }

    public boolean isDraggable() {
        return this.i;
    }

    public boolean isFlat() {
        return this.m;
    }

    public boolean isPerspective() {
        return this.h;
    }

    public boolean isVisible() {
        return this.b;
    }

    public MarkerOptions period(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("marker's period must be greater than zero ");
        }
        this.o = i;
        return this;
    }

    public MarkerOptions perspective(boolean z) {
        this.h = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("marker's position can not be null");
        }
        this.d = latLng;
        return this;
    }

    public MarkerOptions rotate(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        this.j = f % 360.0f;
        return this;
    }

    public MarkerOptions scaleX(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.p = f;
        return this;
    }

    public MarkerOptions scaleY(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.q = f;
        return this;
    }

    public MarkerOptions title(String str) {
        this.k = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public MarkerOptions yOffset(int i) {
        this.l = i;
        return this;
    }

    public MarkerOptions zIndex(int i) {
        this.a = i;
        return this;
    }
}
