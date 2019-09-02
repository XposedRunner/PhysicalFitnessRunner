package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class MarqueeView extends AppCompatTextView {
    public MarqueeView(Context context) {
        super(context);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean isFocused() {
        return true;
    }
}
