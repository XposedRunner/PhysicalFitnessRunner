package com.zjwh.android_wh_physicalfitness.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import com.yalantis.ucrop.view.CropImageView;

public class GPSSearchView extends View {
    private Paint O000000o;
    private Paint O00000Oo;
    private PathMeasure O00000o;
    private Path O00000o0;
    private volatile boolean O00000oO = false;
    private float O00000oo;
    private ValueAnimator O0000O0o;

    public GPSSearchView(Context context) {
        super(context);
        O000000o(null);
    }

    public GPSSearchView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public GPSSearchView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    private int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int O000000o(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        return mode == 1073741824 ? i2 : mode == Integer.MIN_VALUE ? Math.min(i, i2) : i;
    }

    private void O000000o(Canvas canvas) {
        canvas.drawPath(this.O00000o0, this.O000000o);
        this.O00000Oo.setStrokeWidth(((float) getWidth()) * 0.15f);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getWidth() / 2), ((float) getWidth()) * 0.425f, this.O00000Oo);
    }

    private void O000000o(AttributeSet attributeSet) {
        this.O00000o = new PathMeasure();
        this.O00000o0 = new Path();
        this.O000000o = new Paint();
        this.O000000o.setStyle(Style.FILL);
        this.O000000o.setStrokeJoin(Join.ROUND);
        this.O000000o.setStrokeCap(Cap.ROUND);
        this.O000000o.setColor(-1);
        this.O000000o.setAntiAlias(true);
        this.O00000Oo = new Paint();
        this.O00000Oo.setStrokeJoin(Join.ROUND);
        this.O00000Oo.setStrokeCap(Cap.ROUND);
        this.O00000Oo.setStyle(Style.STROKE);
        this.O00000Oo.setColor(-1);
        this.O00000Oo.setAntiAlias(true);
    }

    private void O00000Oo(Canvas canvas) {
        float width = ((float) getWidth()) * 0.25f;
        float f;
        if (this.O00000oo <= 0.8f) {
            f = 3.0f * width;
            canvas.drawArc(new RectF(width, width, f, f), -90.0f, this.O00000oo * 450.0f, true, this.O000000o);
            return;
        }
        f = 2.0f * width;
        canvas.drawCircle(f, f, (width * (1.0f - this.O00000oo)) * 5.0f, this.O000000o);
    }

    public void O000000o() {
        O00000Oo();
        this.O00000oO = true;
        this.O0000O0o = ValueAnimator.ofFloat(new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f});
        this.O0000O0o.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GPSSearchView.this.O00000oo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                GPSSearchView.this.postInvalidate();
            }
        });
        this.O0000O0o.setDuration(1000);
        this.O0000O0o.setInterpolator(new LinearInterpolator());
        this.O0000O0o.setRepeatCount(-1);
        this.O0000O0o.start();
    }

    public void O00000Oo() {
        this.O00000oO = false;
        if (this.O0000O0o != null) {
            this.O0000O0o.cancel();
            this.O0000O0o.removeAllUpdateListeners();
        }
    }

    public boolean O00000o0() {
        return this.O00000oO;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O00000Oo();
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        O000000o(canvas);
        O00000Oo(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int O000000o = O000000o(O000000o(20.0f), i);
        int O000000o2 = O000000o(O000000o(25.0f), i2);
        float f = (float) O000000o;
        float f2 = f * 0.5f;
        float f3 = (float) O000000o2;
        this.O00000o0.moveTo(f2, f3);
        float f4 = 0.75f * f3;
        float f5 = f3 * 0.36f;
        float f6 = f2;
        this.O00000o0.cubicTo(f6, f3, CropImageView.DEFAULT_ASPECT_RATIO, f4, CropImageView.DEFAULT_ASPECT_RATIO, f5);
        float f7 = f5;
        float f8 = f3;
        this.O00000o0.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, f7, f2, f3 * 1.3f, f, f5);
        this.O00000o0.cubicTo(f, f7, f, f4, f6, f8);
        this.O00000o0.close();
        this.O00000o.setPath(this.O00000o0, true);
        setMeasuredDimension(O000000o, O000000o2);
    }
}
