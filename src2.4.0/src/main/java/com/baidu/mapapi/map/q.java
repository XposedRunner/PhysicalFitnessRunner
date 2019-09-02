package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;

class q implements AnimatorUpdateListener {
    final /* synthetic */ LayoutParams a;
    final /* synthetic */ SwipeDismissTouchListener b;

    q(SwipeDismissTouchListener swipeDismissTouchListener, LayoutParams layoutParams) {
        this.b = swipeDismissTouchListener;
        this.a = layoutParams;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.b.e.setLayoutParams(this.a);
    }
}
