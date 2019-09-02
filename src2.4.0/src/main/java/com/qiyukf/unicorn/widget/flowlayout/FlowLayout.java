package com.qiyukf.unicorn.widget.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    protected List<List<View>> a;
    protected List<Integer> b;
    protected List<Integer> c;
    private int d;
    private List<View> e;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = -1;
        this.e = new ArrayList();
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new MarginLayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.e.clear();
        int width = getWidth();
        i = getChildCount();
        i3 = 0;
        i4 = i3;
        int i5 = i4;
        while (i3 < i) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (((measuredWidth + i5) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.b.add(Integer.valueOf(i4));
                    this.a.add(this.e);
                    this.c.add(Integer.valueOf(i5));
                    i4 = (marginLayoutParams.topMargin + measuredHeight) + marginLayoutParams.bottomMargin;
                    this.e = new ArrayList();
                    i5 = 0;
                }
                i5 += (measuredWidth + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin;
                i4 = Math.max(i4, (measuredHeight + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin);
                this.e.add(childAt);
            }
            i3++;
        }
        this.b.add(Integer.valueOf(i4));
        this.c.add(Integer.valueOf(i5));
        this.a.add(this.e);
        i = getPaddingLeft();
        i3 = getPaddingTop();
        i4 = this.a.size();
        i5 = i3;
        i3 = i;
        i = 0;
        while (i < i4) {
            this.e = (List) this.a.get(i);
            int intValue = ((Integer) this.b.get(i)).intValue();
            measuredWidth = ((Integer) this.c.get(i)).intValue();
            switch (this.d) {
                case -1:
                    i3 = getPaddingLeft();
                    break;
                case 0:
                    i3 = (width - measuredWidth) / 2;
                    break;
                case 1:
                    i3 = width - measuredWidth;
                    break;
            }
            i3 += getPaddingLeft();
            measuredWidth = i3;
            for (i3 = 0; i3 < this.e.size(); i3++) {
                View view = (View) this.e.get(i3);
                if (view.getVisibility() != 8) {
                    MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                    int i6 = marginLayoutParams2.leftMargin + measuredWidth;
                    int i7 = marginLayoutParams2.topMargin + i5;
                    view.layout(i6, i7, view.getMeasuredWidth() + i6, view.getMeasuredHeight() + i7);
                    measuredWidth += (view.getMeasuredWidth() + marginLayoutParams2.leftMargin) + marginLayoutParams2.rightMargin;
                }
            }
            i5 += intValue;
            i++;
            i3 = measuredWidth;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = i5;
        int i7 = i6;
        int i8 = i7;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8) {
                if (i4 == childCount - 1) {
                    i6 = Math.max(i5, i6);
                    i7 += i8;
                }
                int i9 = i;
                int i10 = i2;
                i3 = size2;
            } else {
                measureChild(childAt, i, i2);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                i3 = size2;
                int measuredWidth = (childAt.getMeasuredWidth() + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin;
                size2 = (childAt.getMeasuredHeight() + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin;
                int i11 = i5 + measuredWidth;
                if (i11 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i6 = Math.max(i6, i5);
                    i7 += i8;
                    i11 = measuredWidth;
                } else {
                    size2 = Math.max(i8, size2);
                }
                if (i4 == childCount - 1) {
                    i7 += size2;
                    i8 = size2;
                    i6 = Math.max(i11, i6);
                } else {
                    i8 = size2;
                }
                i5 = i11;
            }
            i4++;
            size2 = i3;
        }
        i3 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + (i6 + getPaddingLeft());
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i3 : (i7 + getPaddingTop()) + getPaddingBottom());
    }
}
