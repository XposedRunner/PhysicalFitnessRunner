package com.zjwh.android_wh_physicalfitness.view.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.zjwh.android_wh_physicalfitness.view.shimmer.O00000o0.O000000o;

public class ShimmerTextView extends AppCompatTextView implements O00000Oo {
    private O00000o0 O000000o;

    public ShimmerTextView(Context context) {
        super(context);
        this.O000000o = new O00000o0(this, getPaint(), null);
        this.O000000o.O000000o(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O000000o = new O00000o0(this, getPaint(), attributeSet);
        this.O000000o.O000000o(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O000000o = new O00000o0(this, getPaint(), attributeSet);
        this.O000000o.O000000o(getCurrentTextColor());
    }

    public boolean O000000o() {
        return this.O000000o.O00000Oo();
    }

    public boolean O00000Oo() {
        return this.O000000o.O00000o0();
    }

    public float getGradientX() {
        return this.O000000o.O000000o();
    }

    public int getPrimaryColor() {
        return this.O000000o.O00000o();
    }

    public int getReflectionColor() {
        return this.O000000o.O00000oO();
    }

    public void onDraw(Canvas canvas) {
        if (this.O000000o != null) {
            this.O000000o.O0000O0o();
        }
        super.onDraw(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.O000000o != null) {
            this.O000000o.O00000oo();
        }
    }

    public void setAnimationSetupCallback(O000000o o000000o) {
        this.O000000o.O000000o(o000000o);
    }

    public void setGradientX(float f) {
        this.O000000o.O000000o(f);
    }

    public void setPrimaryColor(int i) {
        this.O000000o.O000000o(i);
    }

    public void setReflectionColor(int i) {
        this.O000000o.O00000Oo(i);
    }

    public void setShimmering(boolean z) {
        this.O000000o.O000000o(z);
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
        if (this.O000000o != null) {
            this.O000000o.O000000o(getCurrentTextColor());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        if (this.O000000o != null) {
            this.O000000o.O000000o(getCurrentTextColor());
        }
    }
}
