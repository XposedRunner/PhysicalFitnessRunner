package com.alexvasilkov.gestures.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import defpackage.O0000o;

public class GestureImageView extends ImageView implements O00O0OOo, O00O0Oo0, O00O0o00 {
    private O0000o O000000o;
    private final O00O000o O00000Oo;
    private O000OO0o O00000o;
    private final Matrix O00000o0;

    @Deprecated
    public interface O000000o {
        void O000000o(Bitmap bitmap);
    }

    public GestureImageView(Context context) {
        this(context, null, 0);
    }

    public GestureImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = new O00O000o(this);
        this.O00000o0 = new Matrix();
        O00000Oo();
        this.O000000o.O000000o(new O00000o() {
            public void O000000o(O000O0OO o000o0oo) {
                GestureImageView.this.O000000o(o000o0oo);
            }

            public void O000000o(O000O0OO o000o0oo, O000O0OO o000o0oo2) {
                GestureImageView.this.O000000o(o000o0oo2);
            }
        });
        setScaleType(ScaleType.MATRIX);
    }

    private static Drawable O000000o(Context context, @DrawableRes int i) {
        return VERSION.SDK_INT >= 21 ? context.getDrawable(i) : context.getResources().getDrawable(i);
    }

    private void O00000Oo() {
        if (this.O000000o == null) {
            this.O000000o = new O0000o(this);
        }
    }

    @Nullable
    public Bitmap O000000o() {
        return O00O00Oo.O000000o(getDrawable(), this.O000000o.O00000Oo(), this.O000000o.O000000o());
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(O000O0OO o000o0oo) {
        o000o0oo.O000000o(this.O00000o0);
        setImageMatrix(this.O00000o0);
    }

    public void O000000o(@Nullable RectF rectF, float f) {
        this.O00000Oo.O000000o(rectF, f);
    }

    @Deprecated
    public void O000000o(O000000o o000000o) {
        if (getDrawable() != null) {
            o000000o.O000000o(O000000o());
        }
    }

    public void draw(@NonNull Canvas canvas) {
        this.O00000Oo.O000000o(canvas);
        super.draw(canvas);
        this.O00000Oo.O00000Oo(canvas);
        if (O00O0Oo.O00000o0()) {
            O000OOo0.O000000o(this, canvas);
        }
    }

    public O0000o getController() {
        return this.O000000o;
    }

    public O000OO0o getPositionAnimator() {
        if (this.O00000o == null) {
            this.O00000o = new O000OO0o(this);
        }
        return this.O00000o;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O000000o.O000000o().O000000o((i - getPaddingLeft()) - getPaddingRight(), (i2 - getPaddingTop()) - getPaddingBottom());
        this.O000000o.O00000o();
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return this.O000000o.onTouch(this, motionEvent);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        O00000Oo();
        O000O00o O000000o = this.O000000o.O000000o();
        int O0000OoO = O000000o.O0000OoO();
        int O0000Ooo = O000000o.O0000Ooo();
        if (drawable == null) {
            O000000o.O00000o0(0, 0);
        } else if (drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            O000000o.O00000o0(O000000o.O0000Oo0(), O000000o.O0000Oo());
        } else {
            O000000o.O00000o0(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (O0000OoO != O000000o.O0000OoO() || O0000Ooo != O000000o.O0000Ooo()) {
            this.O000000o.O00000oO();
        }
    }

    public void setImageResource(int i) {
        setImageDrawable(O000000o(getContext(), i));
    }
}
