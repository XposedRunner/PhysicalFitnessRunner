package com.zjwh.android_wh_physicalfitness.view.photoview;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* compiled from: Util */
class O00oOooO {

    /* compiled from: Util */
    /* renamed from: com.zjwh.android_wh_physicalfitness.view.photoview.O00oOooO$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] O000000o = new int[ScaleType.values().length];

        static {
            try {
                O000000o[ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    O00oOooO() {
    }

    static int O000000o(int i) {
        return (i & 65280) >> 8;
    }

    static void O000000o(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else if (f2 >= f3) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    static boolean O000000o(ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (AnonymousClass1.O000000o[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }

    static boolean O000000o(ImageView imageView) {
        return imageView.getDrawable() != null;
    }
}
