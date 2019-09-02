package com.geetest.sdk.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.geetest.sdk.O000o;
import com.geetest.sdk.O0OOO00;

public class CoverFrameLayout extends FrameLayout {
    private static final String O000000o = "CoverFrameLayout";
    private final Context O00000Oo;
    private O000o O00000o0;

    public CoverFrameLayout(Context context, ViewGroup viewGroup, O000o o000o) {
        super(context);
        this.O00000Oo = context;
        this.O00000o0 = o000o;
        View childAt = viewGroup.getChildAt(0);
        View findFocus = childAt.findFocus();
        viewGroup.removeViewAt(0);
        addView(childAt);
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this);
        }
        getParent();
        O0OOO00.O000000o();
        viewGroup.addView(this, 0);
        if (findFocus != null) {
            findFocus.requestFocus();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.O00000o0 != null) {
                    this.O00000o0.O00000Oo(motionEvent);
                    break;
                }
                break;
            case 1:
                if (this.O00000o0 != null) {
                    this.O00000o0.O000000o(motionEvent);
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
