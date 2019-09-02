package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.zjwh.android_wh_physicalfitness.R;

public class DividerView extends View {
    private static final int[] O000000o = new int[]{16843284};
    private Drawable O00000Oo;
    private final Rect O00000o = new Rect();
    private int O00000o0;
    private Drawable O00000oO;

    public DividerView(Context context) {
        super(context);
        O000000o(context);
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public DividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private int O000000o(int i) {
        int i2 = this.O00000o0;
        int mode = MeasureSpec.getMode(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i2 : MeasureSpec.getSize(i) : this.O00000o0;
    }

    private void O000000o(Context context) {
        this.O00000Oo = ContextCompat.getDrawable(context, R.drawable.list_divider_holo_light);
        if (this.O00000Oo != null) {
            setDivider(this.O00000Oo);
        }
    }

    private int O00000Oo(int i) {
        int i2 = this.O00000o0;
        int mode = MeasureSpec.getMode(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i2 : MeasureSpec.getSize(i) : this.O00000o0;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.O00000Oo;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        Rect rect;
        if (this.O00000oO != null) {
            rect = this.O00000o;
            rect.bottom = getMeasuredHeight();
            rect.top = 0;
            rect.left = 0;
            rect.right = getMeasuredWidth();
            this.O00000oO.setBounds(rect);
            this.O00000oO.draw(canvas);
        }
        rect = this.O00000o;
        rect.bottom = getMeasuredHeight() - getPaddingBottom();
        rect.top = getPaddingTop();
        rect.left = getPaddingLeft();
        rect.right = getMeasuredWidth() - getPaddingRight();
        O000000o(canvas, rect, -1);
        super.onDraw(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(O000000o(i), O00000Oo(i2));
    }

    public void setBackground(Drawable drawable) {
        this.O00000oO = drawable;
    }

    public void setDivider(Drawable drawable) {
        if (drawable != null) {
            this.O00000o0 = drawable.getIntrinsicHeight();
        } else {
            this.O00000o0 = 0;
        }
        this.O00000Oo = drawable;
    }
}
