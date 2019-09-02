package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;

/* compiled from: PureScreenCheckTool */
public class OOOO0 {
    private static boolean O000000o;
    private static boolean O00000Oo;
    private int O00000o = 20;
    private int O00000o0 = 0;

    public static boolean O000000o() {
        return O000000o;
    }

    public boolean O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = -1;
                for (int i2 = (int) (((float) width) / 4.0f); ((float) i2) < ((float) (width * 3)) / 4.0f; i2++) {
                    int i3 = (int) (((float) height) / 4.0f);
                    while (((float) i3) < ((float) (height * 3)) / 4.0f) {
                        int pixel = bitmap.getPixel(i2, i3);
                        if (i == -1) {
                            i = pixel;
                        }
                        if (pixel != i) {
                            O00000Oo = true;
                            return true;
                        } else if (pixel != ViewCompat.MEASURED_STATE_MASK) {
                            O00000Oo = true;
                            return true;
                        } else {
                            i3++;
                        }
                    }
                }
            } catch (Throwable th) {
                O00000Oo = true;
            }
        }
        O00000Oo = true;
        return false;
    }

    public boolean O00000Oo() {
        return O00000Oo;
    }

    public boolean O00000o() {
        return this.O00000o0 >= this.O00000o;
    }

    public void O00000o0() {
        this.O00000o0++;
    }
}
