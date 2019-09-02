package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class o extends AnimatorListenerAdapter {
    final /* synthetic */ SwipeDismissTouchListener a;

    o(SwipeDismissTouchListener swipeDismissTouchListener) {
        this.a = swipeDismissTouchListener;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a();
    }
}
