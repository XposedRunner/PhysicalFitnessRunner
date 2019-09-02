package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: ComposeTool */
/* renamed from: bm */
public class bm {
    public static O000000o O000000o = O000000o.CUSTOM;
    public static int O00000Oo = -16777216;
    public static int O00000o = -1;
    public static int O00000o0 = 18;
    public static Typeface O00000oO = Typeface.DEFAULT;

    /* compiled from: ComposeTool */
    /* renamed from: bm$O000000o */
    public enum O000000o {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        LEFTUP,
        LEFTDOWN,
        RIGHTUP,
        RIGHTDOWN,
        CUSTOM
    }

    public static Bitmap O000000o(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        int i3 = (width / 2) - (width2 / 2);
        int i4 = (height / 2) - (height2 / 2);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null);
        if (O000000o == O000000o.CUSTOM) {
            canvas.drawBitmap(bitmap2, (float) i, (float) i2, null);
        } else if (O000000o == O000000o.UP) {
            canvas.drawBitmap(bitmap2, (float) i3, CropImageView.DEFAULT_ASPECT_RATIO, null);
        } else if (O000000o == O000000o.DOWN) {
            canvas.drawBitmap(bitmap2, (float) i3, (float) (height - height2), null);
        } else if (O000000o == O000000o.LEFT) {
            canvas.drawBitmap(bitmap2, CropImageView.DEFAULT_ASPECT_RATIO, (float) i4, null);
        } else if (O000000o == O000000o.RIGHT) {
            canvas.drawBitmap(bitmap2, (float) (width - width2), (float) i4, null);
        } else if (O000000o == O000000o.LEFTUP) {
            canvas.drawBitmap(bitmap2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null);
        } else if (O000000o == O000000o.LEFTDOWN) {
            canvas.drawBitmap(bitmap2, CropImageView.DEFAULT_ASPECT_RATIO, (float) (height - height2), null);
        } else if (O000000o == O000000o.RIGHTUP) {
            canvas.drawBitmap(bitmap2, (float) (width - width2), CropImageView.DEFAULT_ASPECT_RATIO, null);
        } else if (O000000o == O000000o.RIGHTDOWN) {
            canvas.drawBitmap(bitmap2, (float) (width - width2), (float) (height - height2), null);
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap O000000o(Bitmap bitmap, Bitmap bitmap2, boolean z, int i) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(z ? Math.max(width, width2) : (width2 + width) + i, z ? (height2 + height) + i : Math.max(height, height2), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null);
        if (z) {
            canvas.drawBitmap(bitmap2, CropImageView.DEFAULT_ASPECT_RATIO, (float) (height + i), null);
        } else {
            canvas.drawBitmap(bitmap2, (float) (width + i), CropImageView.DEFAULT_ASPECT_RATIO, null);
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap O000000o(String str, Bitmap bitmap, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = Config.ARGB_8888;
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(O00000Oo);
        textPaint.setTextSize((float) O00000o0);
        textPaint.setDither(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(O00000oO);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, width, Alignment.ALIGN_NORMAL, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, true);
        String str2 = str;
        textPaint.getTextBounds(str2, 0, str.length(), new Rect());
        Bitmap copy = bitmap.copy(config, true);
        Bitmap createBitmap = Bitmap.createBitmap(width + (i3 * 2), (height + staticLayout.getHeight()) + (i4 * 4), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(O00000o);
        float f = (float) i3;
        canvas.drawBitmap(copy, f, (float) (staticLayout.getHeight() + (i4 * 3)), null);
        canvas.translate(f, (float) i4);
        staticLayout.draw(canvas);
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }
}
