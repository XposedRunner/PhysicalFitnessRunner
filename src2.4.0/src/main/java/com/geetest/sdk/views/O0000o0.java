package com.geetest.sdk.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: GT3GeetestView */
final class O0000o0 implements AnimatorUpdateListener {
    final /* synthetic */ GT3GeetestView O000000o;

    O0000o0(GT3GeetestView gT3GeetestView) {
        this.O000000o = gT3GeetestView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.O000000o.O000O0oO = ((Integer) valueAnimator.getAnimatedValue()).intValue();
    }
}
