package com.autonavi.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.nio.ByteBuffer;

public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    public static final int CHAR_MAX = 256;
    public static final int MIN_DIFF_SIZE = 4;
    private float baseLine = 0.0f;
    private float startX = 0.0f;
    private int textFontsize = -1;
    private int textFontsizeTrue = -1;
    private Paint textPaint = null;

    public TextTextureGenerator() {
        createTextParam();
    }

    private void createTextParam() {
        float f;
        float f2;
        this.textFontsizeTrue = this.textFontsize - 2;
        this.textPaint = newPaint(null, this.textFontsizeTrue, 49);
        float f3 = ((float) (this.textFontsize - this.textFontsizeTrue)) / 2.0f;
        this.startX = f3;
        try {
            FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            f = fontMetrics.descent;
            try {
                f2 = fontMetrics.ascent;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            f = 7.3242188f;
            f2 = -27.832031f;
            this.baseLine = (((((float) this.textFontsizeTrue) - (f + f2)) / 2.0f) + f3) + 0.5f;
        }
        this.baseLine = (((((float) this.textFontsizeTrue) - (f + f2)) / 2.0f) + f3) + 0.5f;
    }

    public static float getFontHeight(Paint paint) {
        FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    public static int getNearstSize2N(int i) {
        int i2 = 1;
        while (i > i2) {
            i2 *= 2;
        }
        return i2;
    }

    private static Paint newPaint(String str, int i, int i2) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize((float) i);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT);
        switch (i2) {
            case 49:
                textPaint.setTextAlign(Align.LEFT);
                break;
            case 50:
                textPaint.setTextAlign(Align.RIGHT);
                break;
            case 51:
                textPaint.setTextAlign(Align.CENTER);
                break;
            default:
                textPaint.setTextAlign(Align.LEFT);
                break;
        }
        return textPaint;
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        for (int i = 0; i < length; i++) {
            Paint paint = this.textPaint;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((char) iArr[i]);
            stringBuilder.append("");
            fArr[0] = paint.measureText(stringBuilder.toString());
            bArr[i] = (byte) ((int) (fArr[0] + ((float) (this.textFontsize - this.textFontsizeTrue))));
        }
        return bArr;
    }

    public byte[] getTextPixelBuffer(int i, int i2) {
        if (this.textFontsize != i2) {
            this.textFontsize = i2;
            createTextParam();
        }
        try {
            char[] cArr = new char[1];
            char c = (char) i;
            cArr[0] = c;
            float f = this.baseLine;
            Bitmap createBitmap = Bitmap.createBitmap(this.textFontsize, this.textFontsize, Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            byte[] bArr = new byte[(this.textFontsize * this.textFontsize)];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.textPaint.measureText(String.valueOf(c));
            if (cArr[0] > 0 && cArr[0] < 256) {
                f -= 1.5f;
            }
            float f2 = f;
            Align textAlign = this.textPaint.getTextAlign();
            measureText -= (float) this.textFontsizeTrue;
            if (textAlign == Align.CENTER || measureText < 4.0f) {
                canvas.drawText(cArr, 0, 1, this.startX, f2, this.textPaint);
            } else {
                this.textPaint.setTextAlign(Align.CENTER);
                this.textPaint.setTextSize(((float) this.textFontsizeTrue) - measureText);
                canvas.drawText(cArr, 0, 1, (((float) this.textFontsizeTrue) - measureText) / 2.0f, f2, this.textPaint);
                this.textPaint.setTextAlign(textAlign);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            createBitmap.recycle();
            return bArr;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }
}
