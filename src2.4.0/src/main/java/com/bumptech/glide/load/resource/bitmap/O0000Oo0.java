package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler */
public abstract class O0000Oo0 implements O000000o<InputStream> {
    public static final O0000Oo0 O000000o = new O0000Oo0() {
        /* Access modifiers changed, original: protected */
        public int O000000o(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }

        public /* bridge */ /* synthetic */ Bitmap O000000o(Object obj, OO000OO oo000oo, int i, int i2, O0O0O o0o0o) throws Exception {
            return super.O000000o((InputStream) obj, oo000oo, i, i2, o0o0o);
        }

        public String O000000o() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }
    };
    public static final O0000Oo0 O00000Oo = new O0000Oo0() {
        /* Access modifiers changed, original: protected */
        public int O000000o(int i, int i2, int i3, int i4) {
            i = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            i3 = 1;
            i2 = Math.max(1, Integer.highestOneBit(i));
            if (i2 >= i) {
                i3 = 0;
            }
            return i2 << i3;
        }

        public /* bridge */ /* synthetic */ Bitmap O000000o(Object obj, OO000OO oo000oo, int i, int i2, O0O0O o0o0o) throws Exception {
            return super.O000000o((InputStream) obj, oo000oo, i, i2, o0o0o);
        }

        public String O000000o() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }
    };
    private static final String O00000o = "Downsampler";
    public static final O0000Oo0 O00000o0 = new O0000Oo0() {
        /* Access modifiers changed, original: protected */
        public int O000000o(int i, int i2, int i3, int i4) {
            return 0;
        }

        public /* bridge */ /* synthetic */ Bitmap O000000o(Object obj, OO000OO oo000oo, int i, int i2, O0O0O o0o0o) throws Exception {
            return super.O000000o((InputStream) obj, oo000oo, i, i2, o0o0o);
        }

        public String O000000o() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }
    };
    private static final Set<ImageType> O00000oO = EnumSet.of(ImageType.JPEG, ImageType.PNG_A, ImageType.PNG);
    private static final Queue<Options> O00000oo = oOOO000o.O000000o(0);
    private static final int O0000O0o = 5242880;

    private int O000000o(int i, int i2, int i3, int i4, int i5) {
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        i = (i == 90 || i == 270) ? O000000o(i3, i2, i4, i5) : O000000o(i2, i3, i4, i5);
        return Math.max(1, i == 0 ? 0 : Integer.highestOneBit(i));
    }

    private static Config O000000o(InputStream inputStream, O0O0O o0o0o) {
        if (o0o0o == O0O0O.O000000o || o0o0o == O0O0O.O00000Oo || VERSION.SDK_INT == 16) {
            return Config.ARGB_8888;
        }
        boolean z = false;
        inputStream.mark(1024);
        try {
            boolean O000000o = new ImageHeaderParser(inputStream).O000000o();
            try {
                inputStream.reset();
            } catch (IOException e) {
                if (Log.isLoggable(O00000o, 5)) {
                    Log.w(O00000o, "Cannot reset the input stream", e);
                }
            }
            z = O000000o;
        } catch (IOException e2) {
            if (Log.isLoggable(O00000o, 5)) {
                String str = O00000o;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot determine whether the image has alpha or not from header for format ");
                stringBuilder.append(o0o0o);
                Log.w(str, stringBuilder.toString(), e2);
            }
            try {
                inputStream.reset();
            } catch (IOException e3) {
                if (Log.isLoggable(O00000o, 5)) {
                    Log.w(O00000o, "Cannot reset the input stream", e3);
                }
            }
        } catch (Throwable th) {
            try {
                inputStream.reset();
            } catch (IOException e32) {
                if (Log.isLoggable(O00000o, 5)) {
                    Log.w(O00000o, "Cannot reset the input stream", e32);
                }
            }
            throw th;
        }
        return z ? Config.ARGB_8888 : Config.RGB_565;
    }

    private Bitmap O000000o(oOO0Oo00 ooo0oo00, O000O0o0 o000O0o0, Options options, OO000OO oo000oo, int i, int i2, int i3, O0O0O o0o0o) {
        Config O000000o = O000000o((InputStream) ooo0oo00, o0o0o);
        options.inSampleSize = i3;
        options.inPreferredConfig = O000000o;
        if ((options.inSampleSize == 1 || 19 <= VERSION.SDK_INT) && O000000o((InputStream) ooo0oo00)) {
            double d = (double) i3;
            O000000o(options, oo000oo.O00000Oo((int) Math.ceil(((double) i) / d), (int) Math.ceil(((double) i2) / d), O000000o));
        }
        return O00000Oo(ooo0oo00, o000O0o0, options);
    }

    private static void O000000o(Options options) {
        O00000Oo(options);
        synchronized (O00000oo) {
            O00000oo.offer(options);
        }
    }

    @TargetApi(11)
    private static void O000000o(Options options, Bitmap bitmap) {
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    private static boolean O000000o(InputStream inputStream) {
        if (19 <= VERSION.SDK_INT) {
            return true;
        }
        inputStream.mark(1024);
        try {
            boolean contains = O00000oO.contains(new ImageHeaderParser(inputStream).O00000Oo());
            try {
                inputStream.reset();
            } catch (IOException e) {
                if (Log.isLoggable(O00000o, 5)) {
                    Log.w(O00000o, "Cannot reset the input stream", e);
                }
            }
            return contains;
        } catch (IOException e2) {
            if (Log.isLoggable(O00000o, 5)) {
                Log.w(O00000o, "Cannot determine the image type from header", e2);
            }
            try {
                inputStream.reset();
            } catch (IOException e3) {
                if (Log.isLoggable(O00000o, 5)) {
                    Log.w(O00000o, "Cannot reset the input stream", e3);
                }
            }
            return false;
        } catch (Throwable th) {
            try {
                inputStream.reset();
            } catch (IOException e32) {
                if (Log.isLoggable(O00000o, 5)) {
                    Log.w(O00000o, "Cannot reset the input stream", e32);
                }
            }
            throw th;
        }
    }

    private static Bitmap O00000Oo(oOO0Oo00 ooo0oo00, O000O0o0 o000O0o0, Options options) {
        if (options.inJustDecodeBounds) {
            ooo0oo00.mark(O0000O0o);
        } else {
            o000O0o0.O000000o();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(ooo0oo00, null, options);
        try {
            if (options.inJustDecodeBounds) {
                ooo0oo00.reset();
            }
        } catch (IOException e) {
            if (Log.isLoggable(O00000o, 6)) {
                String str = O00000o;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception loading inDecodeBounds=");
                stringBuilder.append(options.inJustDecodeBounds);
                stringBuilder.append(" sample=");
                stringBuilder.append(options.inSampleSize);
                Log.e(str, stringBuilder.toString(), e);
            }
        }
        return decodeStream;
    }

    @TargetApi(11)
    private static synchronized Options O00000Oo() {
        Options options;
        synchronized (O0000Oo0.class) {
            synchronized (O00000oo) {
                options = (Options) O00000oo.poll();
            }
            if (options == null) {
                options = new Options();
                O00000Oo(options);
            }
        }
        return options;
    }

    @TargetApi(11)
    private static void O00000Oo(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    public abstract int O000000o(int i, int i2, int i3, int i4);

    public Bitmap O000000o(InputStream inputStream, OO000OO oo000oo, int i, int i2, O0O0O o0o0o) {
        Throwable th;
        Throwable th2;
        Options options;
        int i3;
        OO000OO oo000oo2 = oo000oo;
        ooooO000 O000000o = ooooO000.O000000o();
        byte[] O00000o0 = O000000o.O00000o0();
        byte[] O00000o02 = O000000o.O00000o0();
        Options O00000Oo = O00000Oo();
        O000O0o0 o000O0o0 = new O000O0o0(inputStream, O00000o02);
        oOO0O00O O000000o2 = oOO0O00O.O000000o(o000O0o0);
        oOO0Oo00 ooo0oo00 = new oOO0Oo00(O000000o2);
        try {
            O000000o2.mark(O0000O0o);
            try {
                int O00000o03 = new ImageHeaderParser(O000000o2).O00000o0();
                try {
                    O000000o2.reset();
                } catch (IOException e) {
                    if (Log.isLoggable(O00000o, 5)) {
                        Log.w(O00000o, "Cannot reset the input stream", e);
                    }
                } catch (Throwable th22) {
                    th = th22;
                    options = O00000Oo;
                    O000000o.O000000o(O00000o0);
                    O000000o.O000000o(O00000o02);
                    O000000o2.O00000o0();
                    O000000o(options);
                    throw th;
                }
                i3 = O00000o03;
            } catch (IOException th222) {
                Throwable th3 = th222;
                if (Log.isLoggable(O00000o, 5)) {
                    Log.w(O00000o, "Cannot determine the image orientation from header", th3);
                }
                O000000o2.reset();
                i3 = 0;
            } catch (Throwable th2222) {
                th = th2222;
                options = O00000Oo;
                O000000o2.reset();
                throw th;
            }
        } catch (IOException e2) {
            if (Log.isLoggable(O00000o, 5)) {
                Log.w(O00000o, "Cannot reset the input stream", e2);
            }
        } catch (Throwable th4) {
            th2222 = th4;
            options = O00000Oo;
            th = th2222;
            O000000o.O000000o(O00000o0);
            O000000o.O000000o(O00000o02);
            O000000o2.O00000o0();
            O000000o(options);
            throw th;
        }
        O00000Oo.inTempStorage = O00000o0;
        int[] O000000o3 = O000000o(ooo0oo00, o000O0o0, O00000Oo);
        int i4 = O000000o3[0];
        int i5 = O000000o3[1];
        Options options2 = O00000Oo;
        Options options3 = O00000Oo;
        int i6 = i3;
        try {
            Bitmap O000000o4 = O000000o(ooo0oo00, o000O0o0, options2, oo000oo2, i4, i5, O000000o(O000OO0o.O000000o(i3), i4, i5, i, i2), o0o0o);
            IOException O00000Oo2 = O000000o2.O00000Oo();
            if (O00000Oo2 != null) {
                try {
                    throw new RuntimeException(O00000Oo2);
                } catch (Throwable th22222) {
                    th = th22222;
                    options = options3;
                    O000000o.O000000o(O00000o0);
                    O000000o.O000000o(O00000o02);
                    O000000o2.O00000o0();
                    O000000o(options);
                    throw th;
                }
            }
            Bitmap bitmap = null;
            if (O000000o4 != null) {
                bitmap = O000OO0o.O000000o(O000000o4, oo000oo2, i6);
                if (!(O000000o4.equals(bitmap) || oo000oo2.O000000o(O000000o4))) {
                    O000000o4.recycle();
                }
            }
            O000000o.O000000o(O00000o0);
            O000000o.O000000o(O00000o02);
            O000000o2.O00000o0();
            O000000o(options3);
            return bitmap;
        } catch (Throwable th5) {
            th22222 = th5;
            options = options3;
            th = th22222;
            O000000o.O000000o(O00000o0);
            O000000o.O000000o(O00000o02);
            O000000o2.O00000o0();
            O000000o(options);
            throw th;
        }
    }

    public int[] O000000o(oOO0Oo00 ooo0oo00, O000O0o0 o000O0o0, Options options) {
        options.inJustDecodeBounds = true;
        O00000Oo(ooo0oo00, o000O0o0, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }
}
