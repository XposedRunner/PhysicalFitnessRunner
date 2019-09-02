package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.h;
import mapsdkvi.com.gdi.bgl.android.java.EnvDrawText;

public final class Text extends Overlay {
    private static final String k = "Text";
    String a;
    LatLng b;
    int c;
    int d;
    int e;
    Typeface f;
    int g;
    int h;
    float i;
    int j;

    Text() {
        this.type = h.text;
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a() {
        if (this.f != null) {
            EnvDrawText.removeFontCache(this.f.hashCode());
        }
        return super.a();
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.b == null) {
            throw new IllegalStateException("when you add a text overlay, you must provide text and the position info.");
        }
        float f;
        bundle.putString("text", this.a);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.b);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        int i = (this.d >> 8) & 255;
        bundle.putInt("font_color", Color.argb(this.d >>> 24, this.d & 255, i, (this.d >> 16) & 255));
        i = (this.c >> 8) & 255;
        bundle.putInt("bg_color", Color.argb(this.c >>> 24, this.c & 255, i, (this.c >> 16) & 255));
        bundle.putInt("font_size", this.e);
        if (this.f != null) {
            EnvDrawText.registFontCache(this.f.hashCode(), this.f);
            bundle.putInt("type_face", this.f.hashCode());
        }
        int i2 = this.g;
        float f2 = 0.5f;
        if (i2 != 4) {
            switch (i2) {
                case 1:
                    f = 0.0f;
                    break;
                case 2:
                    f = 1.0f;
                    break;
            }
        }
        f = 0.5f;
        bundle.putFloat("align_x", f);
        i2 = this.h;
        if (i2 == 8) {
            f2 = 0.0f;
        } else if (i2 == 16) {
            f2 = 1.0f;
        }
        bundle.putFloat("align_y", f2);
        bundle.putFloat("rotate", this.i);
        bundle.putInt("update", this.j);
        return bundle;
    }

    public float getAlignX() {
        return (float) this.g;
    }

    public float getAlignY() {
        return (float) this.h;
    }

    public int getBgColor() {
        return this.c;
    }

    public int getFontColor() {
        return this.d;
    }

    public int getFontSize() {
        return this.e;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public float getRotate() {
        return this.i;
    }

    public String getText() {
        return this.a;
    }

    public Typeface getTypeface() {
        return this.f;
    }

    public void setAlign(int i, int i2) {
        this.g = i;
        this.h = i2;
        this.j = 1;
        this.listener.b(this);
    }

    public void setBgColor(int i) {
        this.c = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontColor(int i) {
        this.d = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setFontSize(int i) {
        this.e = i;
        this.j = 1;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.b = latLng;
        this.j = 1;
        this.listener.b(this);
    }

    public void setRotate(float f) {
        this.i = f;
        this.j = 1;
        this.listener.b(this);
    }

    public void setText(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("text can not be null or empty");
        }
        this.a = str;
        this.j = 1;
        this.listener.b(this);
    }

    public void setTypeface(Typeface typeface) {
        this.f = typeface;
        this.j = 1;
        this.listener.b(this);
    }
}
