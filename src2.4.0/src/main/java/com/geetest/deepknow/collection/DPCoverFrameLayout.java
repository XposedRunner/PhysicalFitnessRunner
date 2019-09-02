package com.geetest.deepknow.collection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bangcle.andJni.JniLib1557756502;

@SuppressLint({"ViewConstructor"})
public class DPCoverFrameLayout extends FrameLayout {
    private final Context a;
    private b b;

    public DPCoverFrameLayout(Context context, ViewGroup viewGroup, b bVar) {
        super(context);
        this.b = bVar;
        this.a = context;
        View childAt = viewGroup.getChildAt(0);
        View findFocus = childAt.findFocus();
        viewGroup.removeViewAt(0);
        addView(childAt);
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this);
        }
        viewGroup.addView(this, 0);
        if (findFocus != null) {
            findFocus.requestFocus();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return JniLib1557756502.cZ(this, motionEvent, Integer.valueOf(34));
    }
}
