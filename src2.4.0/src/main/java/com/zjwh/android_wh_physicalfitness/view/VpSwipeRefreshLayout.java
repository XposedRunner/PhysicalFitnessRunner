package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class VpSwipeRefreshLayout extends SwipeRefreshLayout {
    private float O000000o;
    private float O00000Oo;
    private boolean O00000o0;

    public VpSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.O000000o = motionEvent.getY();
                this.O00000Oo = motionEvent.getX();
                this.O00000o0 = false;
                break;
            case 1:
            case 3:
                this.O00000o0 = false;
                break;
            case 2:
                if (this.O00000o0) {
                    return false;
                }
                float y = motionEvent.getY();
                float abs = Math.abs(motionEvent.getX() - this.O00000Oo);
                y = Math.abs(y - this.O000000o);
                if (abs > ((float) null) && abs > y) {
                    this.O00000o0 = true;
                    return false;
                }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
