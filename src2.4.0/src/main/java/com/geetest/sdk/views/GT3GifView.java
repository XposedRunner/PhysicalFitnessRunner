package com.geetest.sdk.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.geetest.sdk.R;

public class GT3GifView extends View {
    private int O000000o;
    private Movie O00000Oo;
    private int O00000o;
    private long O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private int O0000OOo;
    private volatile boolean O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO;

    public GT3GifView(Context context) {
        this(context, null);
    }

    public GT3GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.styleable.gt3CustomTheme_gt3gifViewStyle);
    }

    public GT3GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OoO = true;
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.gt3GifView, i, R.style.gt3Widget_GifView);
        this.O000000o = obtainStyledAttributes.getResourceId(R.styleable.gt3GifView_gt3gif, -1);
        this.O0000Oo = obtainStyledAttributes.getBoolean(R.styleable.gt3GifView_gt3paused, false);
        obtainStyledAttributes.recycle();
        if (this.O000000o != -1) {
            this.O00000Oo = Movie.decodeStream(getResources().openRawResource(this.O000000o));
        }
    }

    private void O000000o(Canvas canvas) {
        this.O00000Oo.setTime(this.O00000o);
        canvas.save(1);
        canvas.scale(this.O0000O0o, this.O0000O0o);
        this.O00000Oo.draw(canvas, this.O00000oO / this.O0000O0o, this.O00000oo / this.O0000O0o);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    private void O00000Oo() {
        if (this.O0000OoO) {
            if (VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
                return;
            }
            invalidate();
        }
    }

    public final void O000000o() {
        if (this.O0000Oo) {
            this.O0000Oo = false;
            this.O00000o0 = SystemClock.uptimeMillis() - ((long) this.O00000o);
            invalidate();
        }
    }

    public int getGifResource() {
        return this.O000000o;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        if (this.O00000Oo != null) {
            if (this.O0000Oo) {
                O000000o(canvas);
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.O00000o0 == 0) {
                    this.O00000o0 = uptimeMillis;
                }
                int duration = this.O00000Oo.duration();
                if (duration == 0) {
                    duration = 1000;
                }
                this.O00000o = (int) ((uptimeMillis - this.O00000o0) % ((long) duration));
                O000000o(canvas);
                O00000Oo();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O00000oO = ((float) (getWidth() - this.O0000OOo)) / 2.0f;
        this.O00000oo = ((float) (getHeight() - this.O0000Oo0)) / 2.0f;
        this.O0000OoO = getVisibility() == 0;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    public void onMeasure(int r5, int r6) {
        /*
        r4 = this;
        r0 = r4.O00000Oo;
        if (r0 == 0) goto L_0x0053;
    L_0x0004:
        r0 = r4.O00000Oo;
        r0 = r0.width();
        r1 = r4.O00000Oo;
        r1 = r1.height();
        r2 = android.view.View.MeasureSpec.getMode(r5);
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r2 == 0) goto L_0x0023;
    L_0x0018:
        r5 = android.view.View.MeasureSpec.getSize(r5);
        if (r0 <= r5) goto L_0x0023;
    L_0x001e:
        r2 = (float) r0;
        r5 = (float) r5;
        r5 = r2 / r5;
        goto L_0x0024;
    L_0x0023:
        r5 = r3;
    L_0x0024:
        r2 = android.view.View.MeasureSpec.getMode(r6);
        if (r2 == 0) goto L_0x0035;
    L_0x002a:
        r6 = android.view.View.MeasureSpec.getSize(r6);
        if (r1 <= r6) goto L_0x0035;
    L_0x0030:
        r2 = (float) r1;
        r6 = (float) r6;
        r6 = r2 / r6;
        goto L_0x0036;
    L_0x0035:
        r6 = r3;
    L_0x0036:
        r5 = java.lang.Math.max(r5, r6);
        r3 = r3 / r5;
        r4.O0000O0o = r3;
        r5 = (float) r0;
        r6 = r4.O0000O0o;
        r5 = r5 * r6;
        r5 = (int) r5;
        r4.O0000OOo = r5;
        r5 = (float) r1;
        r6 = r4.O0000O0o;
        r5 = r5 * r6;
        r5 = (int) r5;
        r4.O0000Oo0 = r5;
        r5 = r4.O0000OOo;
        r6 = r4.O0000Oo0;
        r4.setMeasuredDimension(r5, r6);
        return;
    L_0x0053:
        r5 = r4.getSuggestedMinimumWidth();
        r6 = r4.getSuggestedMinimumHeight();
        r4.setMeasuredDimension(r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.views.GT3GifView.onMeasure(int, int):void");
    }

    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.O0000OoO = z;
        O00000Oo();
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.O0000OoO = i == 0;
        O00000Oo();
    }

    /* Access modifiers changed, original: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.O0000OoO = i == 0;
        O00000Oo();
    }

    public void setGifResource(int i) {
        this.O000000o = i;
        this.O00000Oo = Movie.decodeStream(getResources().openRawResource(this.O000000o));
        requestLayout();
    }
}
