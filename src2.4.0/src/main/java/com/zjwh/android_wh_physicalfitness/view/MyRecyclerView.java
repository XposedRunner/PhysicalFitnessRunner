package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class MyRecyclerView extends RecyclerView {
    private int O000000o = 0;
    private int O00000Oo = 0;

    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        boolean z = false;
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                int i = x - this.O000000o;
                int i2 = y - this.O00000Oo;
                ViewParent parent = getParent();
                if (Math.abs(i) > Math.abs(i2)) {
                    z = true;
                }
                parent.requestDisallowInterceptTouchEvent(z);
                break;
        }
        this.O000000o = x;
        this.O00000Oo = y;
        return super.dispatchTouchEvent(motionEvent);
    }
}
