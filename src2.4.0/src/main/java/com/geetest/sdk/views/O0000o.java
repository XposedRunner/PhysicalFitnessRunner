package com.geetest.sdk.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: GT3View */
final class O0000o implements AnimatorUpdateListener {
    final /* synthetic */ GT3View O000000o;

    O0000o(GT3View gT3View) {
        this.O000000o = gT3View;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.O000000o.O000000o = ((Integer) valueAnimator.getAnimatedValue()).intValue();
    }
}
