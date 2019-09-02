package com.qiyukf.basesdk.c.d;

import android.content.Context;
import android.content.res.Resources;

public final class d {
    private static Context a;

    public static int a() {
        return a.getResources().getDisplayMetrics().widthPixels;
    }

    public static int a(float f) {
        return (int) ((f * a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    public static int b() {
        return a.getResources().getDisplayMetrics().heightPixels;
    }

    public static int c() {
        return Math.min(a(), b());
    }

    public static int d() {
        Resources resources = a.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }

    public static int e() {
        Resources resources = a.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }
}
