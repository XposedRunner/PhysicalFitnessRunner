package com.zjwh.android_wh_physicalfitness.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import java.lang.reflect.Array;
import jp.co.cyberagent.android.gpuimage.O000000o;

/* compiled from: Blur */
public class O0000o0 {
    private static final int O000000o = 10;

    public static Bitmap O000000o(Context context, Bitmap bitmap) {
        return O000000o(context, bitmap, 10);
    }

    @SuppressLint({"NewApi"})
    public static Bitmap O000000o(Context context, Bitmap bitmap, int i) {
        Bitmap bitmap2 = bitmap;
        int i2 = i;
        if (VERSION.SDK_INT > 16) {
            Bitmap copy = bitmap2.copy(bitmap.getConfig(), true);
            RenderScript create = RenderScript.create(context);
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap2, MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            create2.setRadius((float) i2);
            create2.setInput(createFromBitmap);
            create2.forEach(createTyped);
            createTyped.copyTo(copy);
            create.destroy();
            createFromBitmap.destroy();
            createTyped.destroy();
            create2.destroy();
            return copy;
        }
        bitmap2 = bitmap2.copy(bitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        Bitmap bitmap3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int[] iArr;
        int i12;
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i13 = width * height;
        int[] iArr2 = new int[i13];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(width);
        stringBuilder.append(" ");
        stringBuilder.append(height);
        stringBuilder.append(" ");
        stringBuilder.append(iArr2.length);
        Log.e("pix", stringBuilder.toString());
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i14 = width - 1;
        int i15 = height - 1;
        int i16 = (i2 + i2) + 1;
        int[] iArr3 = new int[i13];
        int[] iArr4 = new int[i13];
        int[] iArr5 = new int[i13];
        int[] iArr6 = new int[Math.max(width, height)];
        int i17 = (i16 + 1) >> 1;
        i17 *= i17;
        i13 = O000000o.O00000oO * i17;
        int[] iArr7 = new int[i13];
        for (int i18 = 0; i18 < i13; i18++) {
            iArr7[i18] = i18 / i17;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, new int[]{i16, 3});
        i17 = i2 + 1;
        i13 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i13 < height) {
            bitmap3 = bitmap2;
            i3 = -i2;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            while (i3 <= i2) {
                i10 = i15;
                i11 = height;
                i15 = iArr2[i19 + Math.min(i14, Math.max(i3, 0))];
                int[] iArr9 = iArr8[i3 + i2];
                iArr9[0] = (i15 & 16711680) >> 16;
                iArr9[1] = (i15 & 65280) >> 8;
                iArr9[2] = i15 & 255;
                i15 = i17 - Math.abs(i3);
                i4 += iArr9[0] * i15;
                i5 += iArr9[1] * i15;
                i6 += iArr9[2] * i15;
                if (i3 > 0) {
                    i7 += iArr9[0];
                    i8 += iArr9[1];
                    i9 += iArr9[2];
                } else {
                    i21 += iArr9[0];
                    i22 += iArr9[1];
                    i23 += iArr9[2];
                }
                i3++;
                height = i11;
                i15 = i10;
            }
            i10 = i15;
            i11 = height;
            i15 = i2;
            i3 = 0;
            while (i3 < width) {
                iArr3[i19] = iArr7[i4];
                iArr4[i19] = iArr7[i5];
                iArr5[i19] = iArr7[i6];
                i4 -= i21;
                i5 -= i22;
                i6 -= i23;
                int[] iArr10 = iArr8[((i15 - i2) + i16) % i16];
                i21 -= iArr10[0];
                i22 -= iArr10[1];
                i23 -= iArr10[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr6[i3] = Math.min((i3 + i2) + 1, i14);
                } else {
                    iArr = iArr7;
                }
                i12 = iArr2[i20 + iArr6[i3]];
                iArr10[0] = (i12 & 16711680) >> 16;
                iArr10[1] = (i12 & 65280) >> 8;
                iArr10[2] = i12 & 255;
                i7 += iArr10[0];
                i8 += iArr10[1];
                i9 += iArr10[2];
                i4 += i7;
                i5 += i8;
                i6 += i9;
                i15 = (i15 + 1) % i16;
                iArr7 = iArr8[i15 % i16];
                i21 += iArr7[0];
                i22 += iArr7[1];
                i23 += iArr7[2];
                i7 -= iArr7[0];
                i8 -= iArr7[1];
                i9 -= iArr7[2];
                i19++;
                i3++;
                iArr7 = iArr;
            }
            iArr = iArr7;
            i20 += width;
            i13++;
            bitmap2 = bitmap3;
            height = i11;
            i15 = i10;
        }
        bitmap3 = bitmap2;
        iArr = iArr7;
        i10 = i15;
        i11 = height;
        i3 = 0;
        while (i3 < width) {
            int[] iArr11;
            int abs;
            i12 = -i2;
            i14 = i12 * width;
            i15 = 0;
            height = 0;
            i13 = 0;
            i19 = 0;
            i20 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            while (i12 <= i2) {
                iArr11 = iArr6;
                i8 = Math.max(0, i14) + i3;
                int[] iArr12 = iArr8[i12 + i2];
                iArr12[0] = iArr3[i8];
                iArr12[1] = iArr4[i8];
                iArr12[2] = iArr5[i8];
                abs = i17 - Math.abs(i12);
                i15 += iArr3[i8] * abs;
                height += iArr4[i8] * abs;
                i13 += iArr5[i8] * abs;
                if (i12 > 0) {
                    i19 += iArr12[0];
                    i20 += iArr12[1];
                    i4 += iArr12[2];
                } else {
                    i5 += iArr12[0];
                    i6 += iArr12[1];
                    i7 += iArr12[2];
                }
                abs = i10;
                if (i12 < abs) {
                    i14 += width;
                }
                i12++;
                i10 = abs;
                iArr6 = iArr11;
            }
            iArr11 = iArr6;
            abs = i10;
            i8 = i20;
            i9 = i4;
            i12 = i11;
            i14 = 0;
            i20 = i2;
            i4 = i19;
            i19 = i13;
            i13 = height;
            height = i15;
            i15 = i3;
            while (i14 < i12) {
                iArr2[i15] = (((-16777216 & iArr2[i15]) | (iArr[height] << 16)) | (iArr[i13] << 8)) | iArr[i19];
                height -= i5;
                i13 -= i6;
                i19 -= i7;
                int[] iArr13 = iArr8[((i20 - i2) + i16) % i16];
                i5 -= iArr13[0];
                i6 -= iArr13[1];
                i7 -= iArr13[2];
                if (i3 == 0) {
                    iArr11[i14] = Math.min(i14 + i17, abs) * width;
                }
                i2 = iArr11[i14] + i3;
                iArr13[0] = iArr3[i2];
                iArr13[1] = iArr4[i2];
                iArr13[2] = iArr5[i2];
                i4 += iArr13[0];
                i8 += iArr13[1];
                i9 += iArr13[2];
                height += i4;
                i13 += i8;
                i19 += i9;
                i20 = (i20 + 1) % i16;
                int[] iArr14 = iArr8[i20];
                i5 += iArr14[0];
                i6 += iArr14[1];
                i7 += iArr14[2];
                i4 -= iArr14[0];
                i8 -= iArr14[1];
                i9 -= iArr14[2];
                i15 += width;
                i14++;
                i2 = i;
            }
            i3++;
            i11 = i12;
            i10 = abs;
            iArr6 = iArr11;
            i2 = i;
        }
        i12 = i11;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(width);
        stringBuilder2.append(" ");
        stringBuilder2.append(i12);
        stringBuilder2.append(" ");
        stringBuilder2.append(iArr2.length);
        Log.e("pix", stringBuilder2.toString());
        bitmap3.setPixels(iArr2, 0, width, 0, 0, width, i12);
        return bitmap3;
    }
}
