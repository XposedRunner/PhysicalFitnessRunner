package com.qiyukf.nimlib.k.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.d.d;
import java.io.File;

public final class a {
    public static Bitmap a(String str, int i) {
        Options options = new Options();
        options.inPreferredConfig = Config.RGB_565;
        options.inSampleSize = i;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(String str, String str2, int i, int i2) {
        int i3 = (TextUtils.isEmpty(str2) || !new File(str2).exists()) ? false : 1;
        if (i3 != 0) {
            return false;
        }
        com.qiyukf.basesdk.c.a.a.a(ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(str, 1), i, i2, 2), str2);
        return true;
    }

    public static int[] a(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static Bitmap b(String str) {
        Bitmap a;
        r0 = new int[3][];
        r0[0] = new int[]{d.a() << 1, d.b()};
        r0[1] = new int[]{d.a(), d.b() << 1};
        r0[2] = new int[]{(int) (((double) d.a()) * 1.414d), (int) (((double) d.b()) * 1.414d)};
        int[] a2 = a(str);
        float f = 0.0f;
        float f2 = a2[1] == 0 ? 0.0f : ((float) a2[0]) / ((float) a2[1]);
        if (a2[0] != 0) {
            f = ((float) a2[1]) / ((float) a2[0]);
        }
        int[] iArr = f2 >= 5.0f ? r0[0] : f >= 5.0f ? r0[1] : r0[2];
        int i = a2[0];
        int i2 = a2[1];
        int a3 = c.a(c.a(i, i2, iArr[0], iArr[1]), i, i2);
        i = 5;
        while (true) {
            a = a(str, a3);
            if (a != null || i <= 0) {
                return a;
            }
            a3++;
            i--;
        }
        return a;
    }
}
