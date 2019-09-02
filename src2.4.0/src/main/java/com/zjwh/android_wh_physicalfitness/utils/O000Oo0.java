package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import com.bumptech.glide.load.resource.bitmap.O0000O0o;
import com.yalantis.ucrop.view.CropImageView;
import defpackage.OO000OO;

/* compiled from: GrayscaleTransform */
public class O000Oo0 extends O0000O0o {
    public O000Oo0(Context context) {
        super(context);
    }

    private Bitmap O000000o(OO000OO oo000oo, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        bitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        Bitmap O000000o = oo000oo.O000000o(min, min, Config.ARGB_8888);
        if (O000000o == null) {
            O000000o = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(O000000o);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        return O000000o;
    }

    public static Bitmap O000000o(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(CropImageView.DEFAULT_ASPECT_RATIO);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, paint);
        return createBitmap;
    }

    /* Access modifiers changed, original: protected */
    public Bitmap O000000o(OO000OO oo000oo, Bitmap bitmap, int i, int i2) {
        return O000000o(oo000oo, O000000o(bitmap));
    }

    public String O000000o() {
        return getClass().getName();
    }
}
