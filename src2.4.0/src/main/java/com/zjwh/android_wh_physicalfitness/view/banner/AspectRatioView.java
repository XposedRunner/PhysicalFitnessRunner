package com.zjwh.android_wh_physicalfitness.view.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;

public class AspectRatioView extends FrameLayout {
    private float O000000o;

    public AspectRatioView(Context context) {
        this(context, null, 0);
    }

    public AspectRatioView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O000000o = CropImageView.DEFAULT_ASPECT_RATIO;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AspectRatioView, i, 0);
        this.O000000o = obtainStyledAttributes.getFloat(0, 1.0f);
        if (this.O000000o == CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException("You must specify an aspect ratio when using the AspectRatioView.");
        }
        obtainStyledAttributes.recycle();
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        if (this.O000000o != CropImageView.DEFAULT_ASPECT_RATIO) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec((int) (((float) size) / this.O000000o), 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }
}
