package com.zjwh.android_wh_physicalfitness.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.yalantis.ucrop.view.CropImageView;

public class CircleDoneSuccessView extends View {
    private Paint O000000o;
    private RectF O00000Oo;
    private int O00000o;
    private Path O00000o0;
    private String O00000oO;
    private String O00000oo;
    private float O0000O0o;
    private final double O0000OOo;
    private float O0000Oo;
    private final double O0000Oo0;
    private float O0000OoO;
    private float O0000Ooo;
    private int O0000o;
    private float O0000o0;
    private float O0000o00;
    private float O0000o0O;
    private float O0000o0o;
    private float O0000oO;
    private int O0000oO0;
    private float O0000oOO;
    private float O0000oOo;
    private float O0000oo;
    private float O0000oo0;
    private float O0000ooO;
    private boolean O0000ooo;
    private final int O000O00o;
    private boolean O000O0OO;
    private int O00oOooO;
    private final int O00oOooo;

    public CircleDoneSuccessView(Context context) {
        this(context, null);
        O00000o0();
    }

    public CircleDoneSuccessView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O000000o = new Paint(1);
        this.O00000Oo = new RectF();
        this.O00000o0 = new Path();
        this.O00000oO = "#FFFFFF";
        this.O00000oo = "#00000000";
        this.O0000OOo = Math.sin(Math.toRadians(30.0d));
        this.O0000Oo0 = Math.sin(Math.toRadians(63.0d));
        this.O0000o0O = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O0000oO0 = 0;
        this.O0000oo = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O00oOooO = 2;
        this.O00oOooo = 600;
        this.O000O00o = 40;
        this.O000O0OO = false;
        O00000o0();
    }

    private int O000000o(int i) {
        return ((int) getContext().getResources().getDisplayMetrics().density) * i;
    }

    private int O000000o(int i, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 255) {
            i2 = 255;
        }
        return (i & 16777215) | (i2 << 24);
    }

    private void O000000o(Canvas canvas) {
        O0000O0o();
        canvas.drawArc(this.O00000Oo, 202.0f, this.O0000O0o, false, this.O000000o);
        O0000OOo();
        canvas.drawArc(this.O00000Oo, 202.0f, this.O0000O0o - 360.0f, false, this.O000000o);
    }

    private void O00000Oo(Canvas canvas) {
        if (this.O0000o0O != CropImageView.DEFAULT_ASPECT_RATIO) {
            O00000oO();
            this.O00000o0.reset();
            if (this.O0000o0O <= (((float) ((this.O0000o * 2) / 3)) - this.O0000Oo) - this.O0000OoO) {
                this.O00000o0.moveTo(this.O0000OoO, this.O0000OoO + this.O0000Oo);
                this.O00000o0.lineTo(this.O0000OoO + this.O0000o0O, (this.O0000OoO + this.O0000Oo) + this.O0000o0O);
            } else if (this.O0000o0O <= this.O0000o0o) {
                this.O00000o0.moveTo(this.O0000OoO, this.O0000OoO + this.O0000Oo);
                this.O00000o0.lineTo(((float) ((this.O0000o * 2) / 3)) - this.O0000Oo, (float) ((this.O0000o * 2) / 3));
                this.O00000o0.lineTo(this.O0000o0O + this.O0000OoO, ((float) ((this.O0000o * 2) / 3)) - (this.O0000o0O - ((((float) ((2 * this.O0000o) / 3)) - this.O0000Oo) - this.O0000OoO)));
            } else {
                float f = this.O0000o0O - this.O0000o0o;
                this.O00000o0.moveTo(this.O0000OoO + f, (this.O0000OoO + this.O0000Oo) + f);
                this.O00000o0.lineTo(((float) ((this.O0000o * 2) / 3)) - this.O0000Oo, (float) ((this.O0000o * 2) / 3));
                this.O00000o0.lineTo((this.O0000o0o + this.O0000OoO) + f, ((float) ((this.O0000o * 2) / 3)) - ((this.O0000o0o - ((((float) ((2 * this.O0000o) / 3)) - this.O0000Oo) - this.O0000OoO)) + f));
            }
            canvas.drawPath(this.O00000o0, this.O000000o);
        }
    }

    private void O00000o() {
        this.O0000Oo = (float) (((double) (this.O0000o / 2)) - ((((double) this.O00000o) * this.O0000OOo) + (((double) this.O00000o) - (((double) this.O00000o) * this.O0000Oo0))));
        this.O0000OoO = ((float) (((double) this.O00000o) * (1.0d - this.O0000Oo0))) + ((float) this.O00oOooO);
        this.O0000Ooo = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O0000o00 = this.O0000OoO + ((((float) ((2 * this.O0000o) / 3)) - this.O0000Oo) * 0.33f);
        this.O0000o0 = this.O0000Ooo + ((((float) (this.O0000o / 3)) + this.O0000Oo) * 0.38f);
        this.O0000o0o = (((float) this.O0000o) - (this.O0000o00 + this.O0000o0)) - 6.0f;
        this.O0000o0O = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O0000oo = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O0000ooO = ((float) this.O00000o) * 1.6f;
        this.O0000oO = ((float) this.O00oOooO) + (((float) this.O00000o) * 0.6f);
        this.O0000oOO = ((float) this.O00oOooO) + (((float) this.O00000o) * 0.6f);
        this.O0000oOo = this.O0000oO + (((float) this.O00000o) * 0.8f);
        this.O0000oo0 = this.O0000oOO + (((float) this.O00000o) * 0.8f);
        this.O0000ooo = false;
    }

    private void O00000o0() {
        this.O000000o.setStyle(Style.STROKE);
        this.O000000o.setStrokeWidth((float) this.O00oOooO);
        this.O000000o.setColor(Color.parseColor(this.O00000oO));
        this.O00oOooO = O000000o(this.O00oOooO);
    }

    private void O00000o0(Canvas canvas) {
        if (this.O0000oo != CropImageView.DEFAULT_ASPECT_RATIO) {
            O00000oo();
            Path path = new Path();
            if (this.O0000oo <= this.O0000ooO / 2.0f) {
                path.moveTo(this.O0000oO, this.O0000oOO);
                path.lineTo(this.O0000oO + this.O0000oo, this.O0000oOO + this.O0000oo);
                canvas.drawPath(path, this.O000000o);
            } else if (this.O0000oo <= this.O0000ooO / 2.0f || this.O0000oo >= this.O0000ooO) {
                path.moveTo(this.O0000oO, this.O0000oOO);
                path.lineTo(this.O0000oO + (this.O0000ooO / 2.0f), this.O0000oOO + (this.O0000ooO / 2.0f));
                canvas.drawPath(path, this.O000000o);
                path.moveTo(this.O0000oOo, this.O0000oOO);
                path.lineTo(this.O0000oO, this.O0000oo0);
                canvas.drawPath(path, this.O000000o);
            } else {
                path.moveTo(this.O0000oO, this.O0000oOO);
                path.lineTo(this.O0000oO + (this.O0000ooO / 2.0f), this.O0000oOO + (this.O0000ooO / 2.0f));
                canvas.drawPath(path, this.O000000o);
                path.moveTo(this.O0000oOo, this.O0000oOO);
                path.lineTo(this.O0000oOo - (this.O0000oo - (this.O0000ooO / 2.0f)), this.O0000oOO + (this.O0000oo - (this.O0000ooO / 2.0f)));
                canvas.drawPath(path, this.O000000o);
            }
        }
    }

    private void O00000oO() {
        this.O000000o.setStyle(Style.STROKE);
        this.O000000o.setStrokeWidth((float) this.O00oOooO);
        this.O000000o.setStrokeCap(Cap.ROUND);
        this.O000000o.setColor(Color.parseColor(this.O00000oO));
    }

    private void O00000oo() {
        this.O000000o.setStyle(Style.FILL_AND_STROKE);
        this.O000000o.setStrokeWidth((float) this.O00oOooO);
        this.O000000o.setStrokeCap(Cap.ROUND);
        this.O000000o.setColor(Color.parseColor(this.O00000oO));
    }

    private void O0000O0o() {
        this.O000000o.setStyle(Style.STROKE);
        this.O000000o.setStrokeWidth((float) this.O00oOooO);
        this.O000000o.setColor(Color.parseColor(this.O00000oO));
    }

    private void O0000OOo() {
        this.O000000o.setStrokeWidth((float) this.O00oOooO);
        this.O000000o.setStyle(Style.STROKE);
        this.O000000o.setColor(Color.parseColor(this.O00000oO));
    }

    private void O0000Oo() {
        clearAnimation();
        ValueAnimator valueAnimator = new ValueAnimator();
        final float f = (this.O0000o0o + this.O0000o00) - this.O0000OoO;
        final float f2 = this.O0000o0o / f;
        final float f3 = 360.0f / f2;
        valueAnimator.setFloatValues(new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f});
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                CircleDoneSuccessView.this.O0000o0O = f * animatedFraction;
                if (animatedFraction <= f2) {
                    CircleDoneSuccessView.this.O0000O0o = (float) ((int) ((f2 - animatedFraction) * f3));
                } else {
                    CircleDoneSuccessView.this.O0000O0o = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                CircleDoneSuccessView.this.O0000oO0 = (int) (animatedFraction * 255.0f);
                CircleDoneSuccessView.this.invalidate();
            }
        });
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(600).start();
    }

    private void O0000Oo0() {
        this.O000000o.setStyle(Style.FILL);
        this.O000000o.setColor(Color.parseColor(this.O00000oo));
        this.O000000o.setAlpha(this.O0000oO0);
    }

    private void O0000OoO() {
        clearAnimation();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f});
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                CircleDoneSuccessView.this.O0000oo = CircleDoneSuccessView.this.O0000ooO * animatedFraction;
                CircleDoneSuccessView.this.O0000oO0 = (int) (animatedFraction * 255.0f);
                CircleDoneSuccessView.this.invalidate();
            }
        });
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(600).start();
    }

    public void O000000o() {
        this.O0000ooo = true;
        this.O000O0OO = false;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                CircleDoneSuccessView.this.O0000Oo();
            }
        }, 200);
    }

    public void O00000Oo() {
        this.O0000ooo = true;
        this.O000O0OO = true;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                CircleDoneSuccessView.this.O0000OoO();
            }
        }, 200);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O0000ooo) {
            O00000o();
        }
        O000000o(canvas);
        if (this.O000O0OO) {
            O00000o0(canvas);
        } else {
            O00000Oo(canvas);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O0000o = getWidth();
        this.O00000o = (getWidth() - (this.O00oOooO * 2)) / 2;
        this.O00000Oo.set((float) this.O00oOooO, (float) this.O00oOooO, (float) (this.O0000o - this.O00oOooO), (float) (this.O0000o - this.O00oOooO));
        this.O0000Oo = (float) (((double) (this.O0000o / 2)) - ((((double) this.O00000o) * this.O0000OOo) + (((double) this.O00000o) - (((double) this.O00000o) * this.O0000Oo0))));
        this.O0000OoO = ((float) (((double) this.O00000o) * (1.0d - this.O0000Oo0))) + ((float) this.O00oOooO);
        this.O0000Ooo = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O0000o00 = this.O0000OoO + ((((float) ((2 * this.O0000o) / 3)) - this.O0000Oo) * 0.33f);
        this.O0000o0 = this.O0000Ooo + ((((float) (this.O0000o / 3)) + this.O0000Oo) * 0.38f);
        this.O0000o0o = (((float) this.O0000o) - (this.O0000o00 + this.O0000o0)) - 6.0f;
        this.O0000ooO = ((float) this.O00000o) * 1.6f;
        this.O0000oO = ((float) this.O00oOooO) + (((float) this.O00000o) * 0.6f);
        this.O0000oOO = ((float) this.O00oOooO) + (((float) this.O00000o) * 0.6f);
        this.O0000oOo = this.O0000oO + (((float) this.O00000o) * 0.8f);
        this.O0000oo0 = this.O0000oOO + (((float) this.O00000o) * 0.8f);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (MeasureSpec.getMode(i) == Integer.MIN_VALUE && MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
            size = Math.min((O000000o(40) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, (O000000o(40) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin);
            size2 = size;
        }
        i = Math.min((size - getPaddingLeft()) - getPaddingRight(), (size2 - getPaddingBottom()) - getPaddingTop());
        setMeasuredDimension(i, i);
    }

    public void setCircleColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000oo = str;
        }
    }

    public void setStrokeColor(String str) {
        if (!TextUtils.isEmpty(this.O00000oO)) {
            this.O00000oO = str;
        }
    }

    public void setStrokeWidth(int i) {
        this.O00oOooO = O000000o(i);
    }
}
