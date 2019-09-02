package com.sw.emoji;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class EmotionIndicatorView extends LinearLayout {
    private static final int O00000oo = 7;
    protected Context O000000o;
    protected ArrayList<ImageView> O00000Oo;
    protected Drawable O00000o;
    protected Drawable O00000o0;
    protected LayoutParams O00000oO;

    public EmotionIndicatorView(Context context) {
        super(context);
        O000000o(context, null);
    }

    public EmotionIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public EmotionIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    private int O000000o(float f) {
        return (int) ((f * this.O000000o.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        this.O000000o = context;
        setOrientation(0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.EmoticonsIndicatorView, 0, 0);
            try {
                this.O00000o0 = obtainStyledAttributes.getDrawable(R.styleable.EmoticonsIndicatorView_bmpSelect);
                this.O00000o = obtainStyledAttributes.getDrawable(R.styleable.EmoticonsIndicatorView_bmpNormal);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        if (this.O00000o == null) {
            this.O00000o = ContextCompat.getDrawable(context, R.drawable.shape_oval_indicator_normal);
        }
        if (this.O00000o0 == null) {
            this.O00000o0 = ContextCompat.getDrawable(context, R.drawable.shape_oval_indicator_selected);
        }
        this.O00000oO = new LayoutParams(-2, -2);
        this.O00000oO.leftMargin = O000000o(7.0f);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i) {
        if (this.O00000Oo == null) {
            this.O00000Oo = new ArrayList();
        }
        if (i > this.O00000Oo.size()) {
            int i2 = 0;
            while (i2 < i) {
                ImageView imageView = new ImageView(this.O000000o);
                imageView.setImageDrawable(i2 == 0 ? this.O00000o0 : this.O00000o);
                if (i2 == 0) {
                    addView(imageView);
                } else {
                    addView(imageView, this.O00000oO);
                }
                this.O00000Oo.add(imageView);
                i2++;
            }
        }
    }

    public void O000000o(int i, int i2) {
        if (i != i2) {
            ((ImageView) this.O00000Oo.get(i)).setImageDrawable(this.O00000o);
            ((ImageView) this.O00000Oo.get(i2)).setImageDrawable(this.O00000o0);
        }
    }
}
