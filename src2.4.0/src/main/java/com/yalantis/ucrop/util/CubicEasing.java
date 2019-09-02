package com.yalantis.ucrop.util;

public final class CubicEasing {
    public static float easeIn(float f, float f2, float f3, float f4) {
        f /= f4;
        return (((f3 * f) * f) * f) + f2;
    }

    public static float easeInOut(float f, float f2, float f3, float f4) {
        f /= f4 / 2.0f;
        if (f < 1.0f) {
            f3 = (((f3 / 2.0f) * f) * f) * f;
        } else {
            f -= 2.0f;
            f3 = (f3 / 2.0f) * (((f * f) * f) + 2.0f);
        }
        return f3 + f2;
    }

    public static float easeOut(float f, float f2, float f3, float f4) {
        f = (f / f4) - 1.0f;
        return (f3 * (((f * f) * f) + 1.0f)) + f2;
    }
}
