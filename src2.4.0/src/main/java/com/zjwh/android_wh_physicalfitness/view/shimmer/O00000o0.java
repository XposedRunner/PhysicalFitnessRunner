package com.zjwh.android_wh_physicalfitness.view.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;

/* compiled from: ShimmerViewHelper */
public class O00000o0 {
    private static final int O000000o = -1;
    private View O00000Oo;
    private float O00000o;
    private Paint O00000o0;
    private LinearGradient O00000oO;
    private Matrix O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private O000000o O0000OoO;

    /* compiled from: ShimmerViewHelper */
    public interface O000000o {
        void O000000o(View view);
    }

    public O00000o0(View view, Paint paint, AttributeSet attributeSet) {
        this.O00000Oo = view;
        this.O00000o0 = paint;
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        this.O0000OOo = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.O00000Oo.getContext().obtainStyledAttributes(attributeSet, R.styleable.ShimmerView, 0, 0);
            if (obtainStyledAttributes != null) {
                try {
                    this.O0000OOo = obtainStyledAttributes.getColor(0, -1);
                } catch (Exception e) {
                    Log.e("ShimmerTextView", "Error while creating the view:", e);
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                }
                obtainStyledAttributes.recycle();
            }
        }
        this.O00000oo = new Matrix();
    }

    private void O0000OOo() {
        this.O00000oO = new LinearGradient((float) (-this.O00000Oo.getWidth()), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, new int[]{this.O0000O0o, this.O0000OOo, this.O0000O0o}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, 1.0f}, TileMode.CLAMP);
        this.O00000o0.setShader(this.O00000oO);
    }

    public float O000000o() {
        return this.O00000o;
    }

    public void O000000o(float f) {
        this.O00000o = f;
        this.O00000Oo.invalidate();
    }

    public void O000000o(int i) {
        this.O0000O0o = i;
        if (this.O0000Oo) {
            O0000OOo();
        }
    }

    public void O000000o(O000000o o000000o) {
        this.O0000OoO = o000000o;
    }

    public void O000000o(boolean z) {
        this.O0000Oo0 = z;
    }

    public void O00000Oo(int i) {
        this.O0000OOo = i;
        if (this.O0000Oo) {
            O0000OOo();
        }
    }

    public boolean O00000Oo() {
        return this.O0000Oo0;
    }

    public int O00000o() {
        return this.O0000O0o;
    }

    public boolean O00000o0() {
        return this.O0000Oo;
    }

    public int O00000oO() {
        return this.O0000OOo;
    }

    /* Access modifiers changed, original: protected */
    public void O00000oo() {
        O0000OOo();
        if (!this.O0000Oo) {
            this.O0000Oo = true;
            if (this.O0000OoO != null) {
                this.O0000OoO.O000000o(this.O00000Oo);
            }
        }
    }

    public void O0000O0o() {
        if (this.O0000Oo0) {
            if (this.O00000o0.getShader() == null) {
                this.O00000o0.setShader(this.O00000oO);
            }
            this.O00000oo.setTranslate(2.0f * this.O00000o, CropImageView.DEFAULT_ASPECT_RATIO);
            this.O00000oO.setLocalMatrix(this.O00000oo);
            return;
        }
        this.O00000o0.setShader(null);
    }
}
