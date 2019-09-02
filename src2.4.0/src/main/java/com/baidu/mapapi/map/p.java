package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup.LayoutParams;

class p extends AnimatorListenerAdapter {
    final /* synthetic */ LayoutParams a;
    final /* synthetic */ int b;
    final /* synthetic */ SwipeDismissTouchListener c;

    p(SwipeDismissTouchListener swipeDismissTouchListener, LayoutParams layoutParams, int i) {
        this.c = swipeDismissTouchListener;
        this.a = layoutParams;
        this.b = i;
    }

    public void onAnimationEnd(Animator animator) {
        this.c.f.onDismiss(this.c.e, this.c.l);
        this.c.e.setTranslationX(0.0f);
        this.a.height = this.b;
        this.c.e.setLayoutParams(this.a);
    }
}
