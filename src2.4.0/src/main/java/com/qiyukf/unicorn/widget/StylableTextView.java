package com.qiyukf.unicorn.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.d;

public class StylableTextView extends TextView {
    private ColorStateList a;

    public StylableTextView(Context context) {
        super(context);
        a(context);
    }

    public StylableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public StylableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(21)
    public StylableTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void a() {
        int color;
        if (this.a == null) {
            Resources resources;
            int i;
            if (!isEnabled()) {
                resources = getResources();
                i = R.color.ysf_theme_color_disabled;
            } else if (isPressed()) {
                resources = getResources();
                i = R.color.ysf_theme_color_pressed;
            } else {
                resources = getResources();
                i = R.color.ysf_theme_color_normal;
            }
            color = resources.getColor(i);
            if (getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) getBackground()).setColor(color);
            } else if (getBackground() instanceof ShapeDrawable) {
                ((ShapeDrawable) getBackground()).getPaint().setColor(color);
            }
        }
        if (this.a != null) {
            color = this.a.getColorForState(getDrawableState(), this.a.getDefaultColor());
            if (getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) getBackground()).setColor(color);
            } else if (getBackground() instanceof ShapeDrawable) {
                ((ShapeDrawable) getBackground()).getPaint().setColor(color);
            }
        }
    }

    private void a(Context context) {
        setBackgroundResource(R.drawable.ysf_theme_button_shape);
        setTextColor(-1);
        UICustomization uICustomization = d.e().uiCustomization;
        if (uICustomization == null) {
            this.a = ContextCompat.getColorStateList(context, R.color.ysf_button_color_state_list);
            a();
            return;
        }
        try {
            if (uICustomization.buttonBackgroundColorList > 0) {
                this.a = ContextCompat.getColorStateList(context, uICustomization.buttonBackgroundColorList);
                a();
            }
            if (uICustomization.buttonTextColor != 0) {
                setTextColor(uICustomization.buttonTextColor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("ui customization error: ");
            stringBuilder.append(e.toString());
            a.c("STV", stringBuilder.toString());
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        a();
    }
}
