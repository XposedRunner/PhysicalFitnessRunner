package com.geetest.sdk;

import android.content.Context;

/* compiled from: GT3DensityUtil */
public final class O0OO00O {
    public static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int O00000Oo(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
