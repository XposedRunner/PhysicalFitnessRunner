package com.qiyukf.nim.uikit.common.media.picker.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.d;

public class CheckboxImageView extends ImageView {
    private int[] a;
    private boolean b;

    public CheckboxImageView(Context context) {
        super(context);
        a();
    }

    public CheckboxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CheckboxImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @TargetApi(21)
    public CheckboxImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    private void a() {
        setBackgroundResource(R.drawable.ysf_circle_shape_bg);
        this.a = new int[2];
        this.a[0] = getResources().getColor(R.color.ysf_picker_unselected_color);
        this.a[1] = getResources().getColor(R.color.ysf_theme_color_normal);
        UICustomization uICustomization = d.e().uiCustomization;
        if (uICustomization != null && uICustomization.buttonBackgroundColorList > 0) {
            try {
                ColorStateList colorStateList = getResources().getColorStateList(uICustomization.buttonBackgroundColorList);
                if (colorStateList != null) {
                    this.a[1] = colorStateList.getColorForState(View.ENABLED_STATE_SET, colorStateList.getDefaultColor());
                }
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("ui customization error: ");
                stringBuilder.append(e.toString());
                a.c("CIV", stringBuilder.toString());
            }
        }
    }

    public final void a(boolean z) {
        this.b = z;
        int i = z ? this.a[1] : this.a[0];
        if (getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) getBackground()).setColor(i);
        } else if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
        invalidate();
    }
}
