package com.zjwh.android_wh_physicalfitness.view.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;

public class ProgressView extends View {
    private static final int O000000o = 20;
    private int[] O00000Oo;
    private float O00000o;
    private float O00000o0;
    private float O00000oO;
    private float O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private Paint O0000Oo;
    private int O0000Oo0;
    private Paint O0000OoO;
    private RectF O0000Ooo;
    private O000000o O0000o00;

    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000Oo = new int[2];
        O000000o(context, attributeSet);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = new int[2];
        O000000o(context, attributeSet);
    }

    private int O000000o(int i) {
        return (int) ((((float) i) * getContext().getResources().getDisplayMetrics().density) + (0.5f * ((float) (i >= 0 ? 1 : -1))));
    }

    private int O000000o(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        return mode == 1073741824 ? i2 : mode == Integer.MIN_VALUE ? Math.min(i, i2) : i;
    }

    private void O000000o() {
        this.O0000Oo = new Paint();
        this.O0000Oo.setAntiAlias(true);
        this.O0000Oo.setStrokeWidth(this.O00000o);
        this.O0000Oo.setStyle(Style.STROKE);
        this.O0000Oo.setStrokeCap(Cap.ROUND);
        this.O0000Oo.setColor(-16777216);
        this.O0000OoO = new Paint();
        this.O0000OoO.setAntiAlias(true);
        this.O0000OoO.setStrokeWidth(this.O00000o0);
        this.O0000OoO.setStyle(Style.STROKE);
        this.O0000OoO.setStrokeCap(Cap.ROUND);
        this.O0000OoO.setColor(ContextCompat.getColor(getContext(), R.color.progress_empty));
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressView);
            this.O00000Oo[0] = obtainStyledAttributes.getInteger(4, -10439979);
            this.O00000Oo[1] = obtainStyledAttributes.getInteger(3, -7822091);
            this.O0000Oo0 = obtainStyledAttributes.getInt(5, 0);
            this.O00000o0 = obtainStyledAttributes.getDimension(1, (float) O000000o(3));
            this.O00000o = obtainStyledAttributes.getDimension(2, (float) O000000o(5));
            this.O0000o00 = O000000o.values()[obtainStyledAttributes.getInt(0, 0)];
            obtainStyledAttributes.recycle();
        } else {
            this.O00000Oo[0] = ContextCompat.getColor(context, R.color.progress_start);
            this.O00000Oo[1] = ContextCompat.getColor(context, R.color.progress_end);
            this.O0000Oo0 = 0;
            this.O0000o00 = O000000o.HORIZONTAL;
            this.O00000o0 = (float) O000000o(3);
            this.O00000o = (float) O000000o(5);
        }
        this.O0000Ooo = new RectF();
        O000000o();
    }

    public float getCurrentCount() {
        return this.O00000oo;
    }

    public float getMaxCount() {
        return this.O00000oO;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.O00000oo / this.O00000oO;
        canvas.drawArc(this.O0000Ooo, CropImageView.DEFAULT_ASPECT_RATIO, 360.0f, false, this.O0000OoO);
        canvas.drawArc(this.O0000Ooo, (float) (-90 + this.O0000Oo0), f * 360.0f, false, this.O0000Oo);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O0000O0o = getWidth();
        this.O0000OOo = getHeight();
        this.O0000Ooo.set(20.0f, 20.0f, (float) (this.O0000O0o - 20), (float) (this.O0000OOo - 20));
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        this.O0000O0o = O000000o(O000000o(200), i);
        this.O0000OOo = O000000o(O000000o(200), i2);
        setMeasuredDimension(this.O0000O0o, this.O0000OOo);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Shader sweepGradient;
        int i5 = i;
        int i6 = i2;
        super.onSizeChanged(i, i2, i3, i4);
        Shader linearGradient;
        switch (this.O0000o00) {
            case SWEEP_START_TOP:
                float f = (float) (i5 / 2);
                float f2 = (float) (i6 / 2);
                sweepGradient = new SweepGradient(f, f2, this.O00000Oo, null);
                Matrix matrix = new Matrix();
                matrix.setRotate(-90.0f, f, f2);
                sweepGradient.setLocalMatrix(matrix);
                break;
            case VERTICAL:
                float f3 = (float) (i5 / 2);
                linearGradient = new LinearGradient(f3, CropImageView.DEFAULT_ASPECT_RATIO, f3, (float) i6, this.O00000Oo, null, TileMode.MIRROR);
                break;
            case LEFT_TOP_RIGHT:
                Shader linearGradient2 = new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, (float) i6, (float) i5, CropImageView.DEFAULT_ASPECT_RATIO, this.O00000Oo, null, TileMode.MIRROR);
                break;
            case LEFT_BOTTOM_RIGHT:
                linearGradient = new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (float) i5, (float) i6, this.O00000Oo, null, TileMode.MIRROR);
                break;
            default:
                float f4 = (float) (i6 / 2);
                Shader linearGradient3 = new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, f4, (float) i5, f4, this.O00000Oo, null, TileMode.MIRROR);
                break;
        }
        this.O0000Oo.setShader(sweepGradient);
    }

    public void setColorOrientation(O000000o o000000o) {
        if (this.O0000o00 != o000000o) {
            this.O0000o00 = o000000o;
            requestLayout();
        }
    }

    public void setCurrentCount(float f) {
        if (f > this.O00000oO) {
            f = this.O00000oO;
        }
        this.O00000oo = f;
        invalidate();
    }

    public void setEmptyStrokeWidth(float f) {
        if (this.O0000OoO == null) {
            throw new NullPointerException("The EmptyPaint is null");
        } else if (f != this.O0000OoO.getStrokeWidth()) {
            this.O0000OoO.setStrokeWidth(f);
            requestLayout();
            invalidate();
        }
    }

    public void setFullStrokeWidth(float f) {
        if (this.O0000Oo == null) {
            throw new NullPointerException("The FullPaint is null");
        } else if (f != this.O0000Oo.getStrokeWidth()) {
            this.O0000Oo.setStrokeWidth(f);
            requestLayout();
            invalidate();
        }
    }

    public void setMaxCount(float f) {
        this.O00000oO = f;
    }

    public void setShaderColors(int[] iArr) {
        this.O00000Oo = iArr;
        requestLayout();
    }

    public void setStartAngle(int i) {
        if (this.O0000Oo0 != i) {
            this.O0000Oo0 = i;
            invalidate();
        }
    }
}
