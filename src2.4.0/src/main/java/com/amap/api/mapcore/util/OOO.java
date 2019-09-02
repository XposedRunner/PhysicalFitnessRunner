package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* compiled from: NinePatchTool */
public class OOO {
    private static int O000000o(byte[] bArr, int i) {
        byte b = bArr[i + 0];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        return (bArr[i + 3] << 24) | (((b & 255) | (b2 << 8)) | (b3 << 16));
    }

    private static Bitmap O000000o(InputStream inputStream) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        byte[] O000000o = O000000o(decodeStream);
        if (!NinePatch.isNinePatchChunk(O000000o)) {
            return decodeStream;
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
        decodeStream.recycle();
        Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
        declaredField.setAccessible(true);
        declaredField.set(createBitmap, O000000o);
        return createBitmap;
    }

    public static Drawable O000000o(Context context, String str) throws Exception {
        Bitmap O00000Oo = O00000Oo(context, str);
        if (O00000Oo.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), O00000Oo);
        }
        Rect rect = new Rect();
        O000000o(O00000Oo.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), O00000Oo, O00000Oo.getNinePatchChunk(), rect, null);
    }

    private static void O000000o(Bitmap bitmap, byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        int[] iArr = new int[(bitmap.getWidth() - 2)];
        int i2 = 0;
        bitmap.getPixels(iArr, 0, iArr.length, 1, bitmap.getHeight() - 1, iArr.length, 1);
        for (i = 0; i < iArr.length; i++) {
            if (-16777216 == iArr[i]) {
                O000000o(bArr2, 12, i);
                break;
            }
        }
        for (i = iArr.length - 1; i >= 0; i--) {
            if (-16777216 == iArr[i]) {
                O000000o(bArr2, 16, (iArr.length - i) - 2);
                break;
            }
        }
        iArr = new int[(bitmap.getHeight() - 2)];
        bitmap.getPixels(iArr, 0, 1, bitmap.getWidth() - 1, 0, 1, iArr.length);
        while (i2 < iArr.length) {
            if (-16777216 == iArr[i2]) {
                O000000o(bArr2, 20, i2);
                break;
            }
            i2++;
        }
        for (i = iArr.length - 1; i >= 0; i--) {
            if (-16777216 == iArr[i]) {
                O000000o(bArr2, 24, (iArr.length - i) - 2);
                return;
            }
        }
    }

    private static void O000000o(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void O000000o(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private static void O000000o(byte[] bArr, Rect rect) {
        rect.left = O000000o(bArr, 12);
        rect.right = O000000o(bArr, 16);
        rect.top = O000000o(bArr, 20);
        rect.bottom = O000000o(bArr, 24);
    }

    private static byte[] O000000o(Bitmap bitmap) throws IOException {
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int i2 = width - 2;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 1, 0, i2, 1);
        i = iArr[0] == ViewCompat.MEASURED_STATE_MASK ? 1 : 0;
        width = iArr[iArr.length - 1] == -16777216 ? 1 : 0;
        int length = iArr.length;
        int i3 = 0;
        i2 = i3;
        int i4 = i2;
        while (i3 < length) {
            if (i2 != iArr[i3]) {
                i4++;
                O000000o(byteArrayOutputStream, i3);
                i2 = iArr[i3];
            }
            i3++;
        }
        if (width != 0) {
            i4++;
            O000000o(byteArrayOutputStream, iArr.length);
        }
        length = i4 + 1;
        if (i != 0) {
            length--;
        }
        if (width != 0) {
            length--;
        }
        width = height - 2;
        int[] iArr2 = new int[width];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, width);
        width = iArr2[0] == ViewCompat.MEASURED_STATE_MASK ? 1 : 0;
        int i5 = iArr2[iArr2.length - 1] == -16777216 ? 1 : 0;
        i2 = iArr2.length;
        height = 0;
        int i6 = height;
        int i7 = i6;
        while (height < i2) {
            if (i6 != iArr2[height]) {
                i7++;
                O000000o(byteArrayOutputStream, height);
                i6 = iArr2[height];
            }
            height++;
        }
        if (i5 != 0) {
            i7++;
            O000000o(byteArrayOutputStream, iArr2.length);
        }
        i3 = i7 + 1;
        if (width != 0) {
            i3--;
        }
        if (i5 != 0) {
            i3--;
        }
        i5 = 0;
        while (true) {
            width = length * i3;
            if (i5 < width) {
                O000000o(byteArrayOutputStream, 1);
                i5++;
            } else {
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                toByteArray[0] = (byte) 1;
                toByteArray[1] = (byte) i4;
                toByteArray[2] = (byte) i7;
                toByteArray[3] = (byte) width;
                O000000o(bitmap, toByteArray);
                return toByteArray;
            }
        }
    }

    private static Bitmap O00000Oo(Context context, String str) throws Exception {
        InputStream open = OOOO0OO.O000000o(context).open(str);
        Bitmap O000000o = O000000o(open);
        open.close();
        return O000000o;
    }
}
