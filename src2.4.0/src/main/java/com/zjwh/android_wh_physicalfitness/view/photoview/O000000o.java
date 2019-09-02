package com.zjwh.android_wh_physicalfitness.view.photoview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: Compat */
class O000000o {
    private static final int O000000o = 16;

    O000000o() {
    }

    public static void O000000o(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            O00000Oo(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    @TargetApi(16)
    private static void O00000Oo(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
