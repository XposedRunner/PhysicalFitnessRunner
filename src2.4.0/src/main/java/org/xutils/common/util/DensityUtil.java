package org.xutils.common.util;

import com.yalantis.ucrop.view.CropImageView;
import org.xutils.x;

public final class DensityUtil {
    private static float density = -1.0f;
    private static int heightPixels = -1;
    private static int widthPixels = -1;

    private DensityUtil() {
    }

    public static int dip2px(float f) {
        return (int) ((f * getDensity()) + 0.5f);
    }

    public static float getDensity() {
        if (density <= CropImageView.DEFAULT_ASPECT_RATIO) {
            density = x.app().getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int getScreenHeight() {
        if (heightPixels <= 0) {
            heightPixels = x.app().getResources().getDisplayMetrics().heightPixels;
        }
        return heightPixels;
    }

    public static int getScreenWidth() {
        if (widthPixels <= 0) {
            widthPixels = x.app().getResources().getDisplayMetrics().widthPixels;
        }
        return widthPixels;
    }

    public static int px2dip(float f) {
        return (int) ((f / getDensity()) + 0.5f);
    }
}
