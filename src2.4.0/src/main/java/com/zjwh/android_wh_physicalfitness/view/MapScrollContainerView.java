package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class MapScrollContainerView extends FrameLayout {
    public MapScrollContainerView(Context context) {
        super(context);
    }

    public MapScrollContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MapScrollContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 261) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
