package com.qiyukf.nim.uikit.common.media.picker.b;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.qiyukf.nimlib.k.b.b;

public final class a {
    public static Bitmap a(Bitmap bitmap, String str) {
        int a = b.a(str);
        if (a != 0) {
            try {
                Matrix matrix = new Matrix();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                matrix.setRotate((float) a, (float) (width / 2), (float) (height / 2));
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (OutOfMemoryError unused) {
            }
        }
        return bitmap;
    }
}
