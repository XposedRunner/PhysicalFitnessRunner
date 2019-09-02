package com.google.zxing.common.detector;

public final class MathUtils {
    private MathUtils() {
    }

    public static float distance(float f, float f2, float f3, float f4) {
        f -= f3;
        f2 -= f4;
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public static float distance(int i, int i2, int i3, int i4) {
        i -= i3;
        i2 -= i4;
        return (float) Math.sqrt((double) ((i * i) + (i2 * i2)));
    }

    public static int round(float f) {
        return (int) (f + (f < 0.0f ? -0.5f : 0.5f));
    }
}
