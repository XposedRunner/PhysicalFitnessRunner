package com.sw.emoji;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

public abstract class AutoHeightLayout extends SoftKeyboardSizeWatchLayout implements com.sw.emoji.SoftKeyboardSizeWatchLayout.O000000o {
    private static final int O00000oO = R.id.id_autolayout;
    protected Context O000000o;
    protected int O00000Oo;
    protected boolean O00000o = false;
    protected int O00000o0;
    private O000000o O00000oo;

    public interface O000000o {
        void O000000o(int i);
    }

    public AutoHeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O000000o = context;
        this.O00000o0 = s.O00000Oo(this.O000000o);
        O000000o((com.sw.emoji.SoftKeyboardSizeWatchLayout.O000000o) this);
    }

    private int getNavigationBarHeight() {
        return getResources().getDimensionPixelSize(getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    private int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    private int getStatusBarHeight() {
        return getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public void O000000o() {
    }

    public void O000000o(int i) {
        this.O00000Oo = i;
        if (this.O00000oo != null) {
            this.O00000oo.O000000o(i);
        }
    }

    public void O00000Oo(int i) {
        if (this.O00000o0 != i) {
            this.O00000o0 = i;
            s.O000000o(this.O000000o, this.O00000o0);
            O00000o0(this.O00000o0);
        }
    }

    public abstract void O00000o0(int i);

    public void addView(View view, int i, LayoutParams layoutParams) {
        int childCount = getChildCount();
        if (childCount > 1) {
            throw new IllegalStateException("can host only one direct child");
        }
        super.addView(view, i, layoutParams);
        RelativeLayout.LayoutParams layoutParams2;
        if (childCount == 0) {
            if (view.getId() < 0) {
                view.setId(O00000oO);
            }
            layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.addRule(12);
            view.setLayoutParams(layoutParams2);
        } else if (childCount == 1) {
            layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.addRule(2, O00000oO);
            view.setLayoutParams(layoutParams2);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.O00000o = true;
        this.O0000oO = 0;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        O00000o0(this.O00000o0);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (this.O00000o) {
            this.O00000o = false;
            Rect rect = new Rect();
            ((Activity) this.O000000o).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (this.O0000oO == 0) {
                this.O0000oO = rect.bottom;
            }
            this.O00000Oo = this.O0000oO - rect.bottom;
        }
        if (this.O00000Oo != 0) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.O00000Oo, MeasureSpec.getMode(i2)));
            return;
        }
        super.onMeasure(i, i2);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.O00000Oo == 0) {
            this.O00000Oo = i2;
        }
        i = getScreenHeight();
        if (this.O00000Oo > i) {
            i += getNavigationBarHeight();
        }
        if (this.O00000Oo == i) {
            this.O00000Oo -= getStatusBarHeight();
        }
    }

    public void setOnMaxParentHeightChangeListener(O000000o o000000o) {
        this.O00000oo = o000000o;
    }
}
