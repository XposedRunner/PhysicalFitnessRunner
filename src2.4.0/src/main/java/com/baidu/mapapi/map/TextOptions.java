package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;

public final class TextOptions extends OverlayOptions {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    int a;
    boolean b = true;
    Bundle c;
    private String d;
    private LatLng e;
    private int f;
    private int g = ViewCompat.MEASURED_STATE_MASK;
    private int h = 12;
    private Typeface i;
    private int j = 4;
    private int k = 32;
    private float l;

    /* Access modifiers changed, original: 0000 */
    public Overlay a() {
        Text text = new Text();
        text.x = this.b;
        text.w = this.a;
        text.y = this.c;
        text.a = this.d;
        text.b = this.e;
        text.c = this.f;
        text.d = this.g;
        text.e = this.h;
        text.f = this.i;
        text.g = this.j;
        text.h = this.k;
        text.i = this.l;
        return text;
    }

    public TextOptions align(int i, int i2) {
        this.j = i;
        this.k = i2;
        return this;
    }

    public TextOptions bgColor(int i) {
        this.f = i;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public TextOptions fontColor(int i) {
        this.g = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.h = i;
        return this;
    }

    public float getAlignX() {
        return (float) this.j;
    }

    public float getAlignY() {
        return (float) this.k;
    }

    public int getBgColor() {
        return this.f;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getFontColor() {
        return this.g;
    }

    public int getFontSize() {
        return this.h;
    }

    public LatLng getPosition() {
        return this.e;
    }

    public float getRotate() {
        return this.l;
    }

    public String getText() {
        return this.d;
    }

    public Typeface getTypeface() {
        return this.i;
    }

    public int getZIndex() {
        return this.a;
    }

    public boolean isVisible() {
        return this.b;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.e = latLng;
        return this;
    }

    public TextOptions rotate(float f) {
        this.l = f;
        return this;
    }

    public TextOptions text(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("text can not be null or empty");
        }
        this.d = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.i = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public TextOptions zIndex(int i) {
        this.a = i;
        return this;
    }
}
