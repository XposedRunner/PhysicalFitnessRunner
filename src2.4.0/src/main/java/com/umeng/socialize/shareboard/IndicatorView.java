package com.umeng.socialize.shareboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class IndicatorView extends View {
    private int O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private float O00000oO;
    private Paint O00000oo;
    private Paint O0000O0o;

    public IndicatorView(Context context) {
        super(context);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public IndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private int O000000o(int i) {
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        int paddingLeft = ((getPaddingLeft() + getPaddingRight()) + ((this.O000000o * this.O00000o0) * 2)) + (this.O00000Oo * (this.O00000o0 - 1));
        this.O00000oO = (((float) (getMeasuredWidth() - paddingLeft)) / 2.0f) + ((float) getPaddingLeft());
        return mode == 1073741824 ? Math.max(paddingLeft, i) : mode == Integer.MIN_VALUE ? Math.min(paddingLeft, i) : paddingLeft;
    }

    private int O00000Oo(int i) {
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return i;
        }
        int paddingTop = (getPaddingTop() + getPaddingBottom()) + (this.O000000o * 2);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, i) : paddingTop;
    }

    /* Access modifiers changed, original: protected */
    public int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void O000000o(int i, int i2) {
        this.O00000Oo = O000000o((float) i2);
        this.O000000o = O000000o((float) i);
    }

    public void O00000Oo(int i, int i2) {
        this.O00000oo = new Paint();
        this.O00000oo.setStyle(Style.FILL);
        this.O00000oo.setAntiAlias(true);
        this.O00000oo.setColor(i2);
        this.O0000O0o = new Paint();
        this.O0000O0o.setStyle(Style.FILL);
        this.O0000O0o.setAntiAlias(true);
        this.O0000O0o.setColor(i);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000oo != null && this.O0000O0o != null) {
            float f = this.O00000oO + ((float) this.O000000o);
            int i = 0;
            while (i < this.O00000o0) {
                canvas.drawCircle(f, (float) this.O000000o, (float) this.O000000o, i == this.O00000o ? this.O00000oo : this.O0000O0o);
                f += (float) (this.O00000Oo + (this.O000000o * 2));
                i++;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(O000000o(i), O00000Oo(i2));
    }

    public void setPageCount(int i) {
        this.O00000o0 = i;
        invalidate();
    }

    public void setSelectedPosition(int i) {
        this.O00000o = i;
        invalidate();
    }
}
