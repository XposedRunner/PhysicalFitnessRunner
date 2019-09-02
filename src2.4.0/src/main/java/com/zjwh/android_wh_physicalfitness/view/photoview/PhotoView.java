package com.zjwh.android_wh_physicalfitness.view.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;

public class PhotoView extends AppCompatImageView {
    private O0000o O000000o;
    private ScaleType O00000Oo;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o0();
    }

    private void O00000o0() {
        this.O000000o = new O0000o(this);
        super.setScaleType(ScaleType.MATRIX);
        if (this.O00000Oo != null) {
            setScaleType(this.O00000Oo);
            this.O00000Oo = null;
        }
    }

    public void O000000o(float f, float f2, float f3) {
        this.O000000o.O000000o(f, f2, f3);
    }

    public void O000000o(float f, float f2, float f3, boolean z) {
        this.O000000o.O000000o(f, f2, f3, z);
    }

    public void O000000o(float f, boolean z) {
        this.O000000o.O000000o(f, z);
    }

    public void O000000o(Matrix matrix) {
        this.O000000o.O00000Oo(matrix);
    }

    @Deprecated
    public boolean O000000o() {
        return this.O000000o.O000000o();
    }

    public boolean O00000Oo() {
        return this.O000000o.O0000OOo();
    }

    public boolean O00000Oo(Matrix matrix) {
        return this.O000000o.O000000o(matrix);
    }

    public boolean O00000o(Matrix matrix) {
        return this.O000000o.O000000o(matrix);
    }

    public void O00000o0(Matrix matrix) {
        this.O000000o.O00000o0(matrix);
    }

    public O0000o getAttacher() {
        return this.O000000o;
    }

    public RectF getDisplayRect() {
        return this.O000000o.O00000Oo();
    }

    public Matrix getImageMatrix() {
        return this.O000000o.O0000Oo();
    }

    public float getMaximumScale() {
        return this.O000000o.O00000oO();
    }

    public float getMediumScale() {
        return this.O000000o.O00000o();
    }

    public float getMinimumScale() {
        return this.O000000o.O00000o0();
    }

    public float getScale() {
        return this.O000000o.O00000oo();
    }

    public ScaleType getScaleType() {
        return this.O000000o.O0000O0o();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.O000000o.O000000o(z);
    }

    /* Access modifiers changed, original: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.O000000o.O0000Oo0();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.O000000o != null) {
            this.O000000o.O0000Oo0();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.O000000o != null) {
            this.O000000o.O0000Oo0();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.O000000o != null) {
            this.O000000o.O0000Oo0();
        }
    }

    public void setMaximumScale(float f) {
        this.O000000o.O00000oo(f);
    }

    public void setMediumScale(float f) {
        this.O000000o.O00000oO(f);
    }

    public void setMinimumScale(float f) {
        this.O000000o.O00000o(f);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.O000000o.O000000o(onClickListener);
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.O000000o.O000000o(onDoubleTapListener);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.O000000o.O000000o(onLongClickListener);
    }

    public void setOnMatrixChangeListener(O00000o o00000o) {
        this.O000000o.O000000o(o00000o);
    }

    public void setOnOutsidePhotoTapListener(O0000O0o o0000O0o) {
        this.O000000o.O000000o(o0000O0o);
    }

    public void setOnPhotoTapListener(O0000OOo o0000OOo) {
        this.O000000o.O000000o(o0000OOo);
    }

    public void setOnScaleChangeListener(O0000Oo0 o0000Oo0) {
        this.O000000o.O000000o(o0000Oo0);
    }

    public void setOnSingleFlingListener(O0000Oo o0000Oo) {
        this.O000000o.O000000o(o0000Oo);
    }

    public void setOnViewDragListener(O0000o00 o0000o00) {
        this.O000000o.O000000o(o0000o00);
    }

    public void setOnViewTapListener(O0000o0 o0000o0) {
        this.O000000o.O000000o(o0000o0);
    }

    public void setRotationBy(float f) {
        this.O000000o.O00000o0(f);
    }

    public void setRotationTo(float f) {
        this.O000000o.O00000Oo(f);
    }

    public void setScale(float f) {
        this.O000000o.O0000O0o(f);
    }

    public void setScaleType(ScaleType scaleType) {
        if (this.O000000o == null) {
            this.O00000Oo = scaleType;
        } else {
            this.O000000o.O000000o(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.O000000o.O000000o(i);
    }

    public void setZoomable(boolean z) {
        this.O000000o.O00000Oo(z);
    }
}
