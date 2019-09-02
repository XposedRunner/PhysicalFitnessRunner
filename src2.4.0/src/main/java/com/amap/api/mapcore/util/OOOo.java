package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.FileDescriptor;

/* compiled from: AbstractImageResizer */
public class OOOo extends o0ooo0OO {
    protected int O000000o;
    protected int O00000Oo;

    public OOOo(Context context, int i, int i2) {
        super(context);
        O000000o(i, i2);
    }

    public static int O000000o(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(((float) i3) / ((float) i2));
        int round2 = Math.round(((float) i4) / ((float) i));
        if (round >= round2) {
            round = round2;
        }
        while (((float) (i4 * i3)) / ((float) (round * round)) > ((float) ((i * i2) * 2))) {
            round++;
        }
        return round;
    }

    private Bitmap O000000o(int i) {
        return O000000o(this.O00000o, i, this.O000000o, this.O00000Oo, O000000o());
    }

    public static Bitmap O000000o(Resources resources, int i, int i2, int i3, o0OOoOoo o0oooooo) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = O000000o(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap O000000o(FileDescriptor fileDescriptor, int i, int i2, o0OOoOoo o0oooooo) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = O000000o(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    /* Access modifiers changed, original: protected */
    public Bitmap O000000o(Object obj) {
        return O000000o(Integer.parseInt(String.valueOf(obj)));
    }

    public void O000000o(int i, int i2) {
        this.O000000o = i;
        this.O00000Oo = i2;
    }
}
