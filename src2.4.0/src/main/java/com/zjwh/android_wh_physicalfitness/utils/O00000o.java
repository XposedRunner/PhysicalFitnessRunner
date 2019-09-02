package com.zjwh.android_wh_physicalfitness.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.view.View;

/* compiled from: AnimatorUtils */
public class O00000o {
    public static AnimatorSet O000000o(View view, float f) {
        return O000000o(view, f, null);
    }

    public static AnimatorSet O000000o(View view, float f, int i, Runnable runnable) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, f, 1.0f});
        long j = (long) i;
        animatorSet.setDuration(j);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        if (runnable != null) {
            new Handler().postDelayed(runnable, j);
        }
        return animatorSet;
    }

    public static AnimatorSet O000000o(View view, float f, Runnable runnable) {
        return O000000o(view, f, 300, runnable);
    }

    public static AnimatorSet O000000o(View view, Runnable runnable) {
        return O000000o(view, 1.125f, runnable);
    }

    public static ObjectAnimator O000000o(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.2f, 1.0f, 0.2f});
        ofFloat.setDuration(3000);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.start();
        return ofFloat;
    }

    public static AnimatorSet O00000Oo(View view) {
        return O000000o(view, 1.125f);
    }
}
