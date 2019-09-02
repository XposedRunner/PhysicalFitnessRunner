package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: TransformationUtils */
public final class O000OO0o {
    public static final int O000000o = 6;
    private static final String O00000Oo = "TransformationUtils";

    private O000OO0o() {
    }

    public static int O000000o(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @TargetApi(5)
    @Deprecated
    public static int O000000o(String str) {
        try {
            return O000000o(new ExifInterface(str).getAttributeInt("Orientation", 0));
        } catch (Exception e) {
            if (Log.isLoggable(O00000Oo, 6)) {
                String str2 = O00000Oo;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to get orientation for image with path=");
                stringBuilder.append(str);
                Log.e(str2, stringBuilder.toString(), e);
            }
            return 0;
        }
    }

    private static Config O000000o(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    public static Bitmap O000000o(Bitmap bitmap, int i) {
        if (i == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e) {
            if (!Log.isLoggable(O00000Oo, 6)) {
                return bitmap;
            }
            Log.e(O00000Oo, "Exception when trying to orient image", e);
            return bitmap;
        }
    }

    public static Bitmap O000000o(Bitmap bitmap, OO000OO oo000oo, int i) {
        Matrix matrix = new Matrix();
        O000000o(i, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Config O000000o = O000000o(bitmap);
        Bitmap O000000o2 = oo000oo.O000000o(round, round2, O000000o);
        if (O000000o2 == null) {
            O000000o2 = Bitmap.createBitmap(round, round2, O000000o);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(O000000o2).drawBitmap(bitmap, matrix, new Paint(6));
        return O000000o2;
    }

    public static Bitmap O000000o(Bitmap bitmap, OO000OO oo000oo, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable(O00000Oo, 2)) {
                Log.v(O00000Oo, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int width = (int) (((float) bitmap.getWidth()) * min);
        int height = (int) (((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable(O00000Oo, 2)) {
                Log.v(O00000Oo, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Config O000000o = O000000o(bitmap);
        Bitmap O000000o2 = oo000oo.O000000o(width, height, O000000o);
        if (O000000o2 == null) {
            O000000o2 = Bitmap.createBitmap(width, height, O000000o);
        }
        O000000o(bitmap, O000000o2);
        if (Log.isLoggable(O00000Oo, 2)) {
            String str = O00000Oo;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("request: ");
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            Log.v(str, stringBuilder.toString());
            String str2 = O00000Oo;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("toFit:   ");
            stringBuilder2.append(bitmap.getWidth());
            stringBuilder2.append("x");
            stringBuilder2.append(bitmap.getHeight());
            Log.v(str2, stringBuilder2.toString());
            str2 = O00000Oo;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("toReuse: ");
            stringBuilder2.append(O000000o2.getWidth());
            stringBuilder2.append("x");
            stringBuilder2.append(O000000o2.getHeight());
            Log.v(str2, stringBuilder2.toString());
            str2 = O00000Oo;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("minPct:   ");
            stringBuilder2.append(min);
            Log.v(str2, stringBuilder2.toString());
        }
        Canvas canvas = new Canvas(O000000o2);
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return O000000o2;
    }

    public static Bitmap O000000o(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        float height;
        float width;
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            height = ((float) i2) / ((float) bitmap2.getHeight());
            width = (((float) i) - (((float) bitmap2.getWidth()) * height)) * 0.5f;
        } else {
            height = ((float) i) / ((float) bitmap2.getWidth());
            f = (((float) i2) - (((float) bitmap2.getHeight()) * height)) * 0.5f;
            width = 0.0f;
        }
        matrix.setScale(height, height);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (f + 0.5f)));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, O000000o(bitmap2));
        }
        O000000o(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    @Deprecated
    public static Bitmap O000000o(String str, Bitmap bitmap) {
        return O000000o(bitmap, O000000o(str));
    }

    static void O000000o(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    @TargetApi(12)
    public static void O000000o(Bitmap bitmap, Bitmap bitmap2) {
        if (VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
