package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.utils.O00000o0;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00.O0000OOo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: ImageImpl */
/* renamed from: bq */
public class bq {
    static {
        br.O000000o();
    }

    public static int O000000o(O0000Oo o0000Oo) {
        return o0000Oo.O0000Oo() == O0000Oo.O0000Ooo ? bq.O000000o(o0000Oo.O0000OoO()) : bq.O00000oO(o0000Oo.O0000o00());
    }

    private static int O000000o(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file).available();
            } catch (Throwable th) {
                O0000O0o.O000000o(O0000OOo.O0000O0o, th);
            }
        }
        return 0;
    }

    private static Bitmap O000000o(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap O000000o(byte[] bArr) {
        return bArr != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length) : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024 A:{SYNTHETIC, Splitter:B:17:0x0024} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A:{SYNTHETIC, Splitter:B:23:0x0031} */
    private static java.io.File O000000o(byte[] r3, java.io.File r4) {
        /*
        r0 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x001c }
        r1.<init>(r4);	 Catch:{ Exception -> 0x001c }
        r2 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x001c }
        r2.<init>(r1);	 Catch:{ Exception -> 0x001c }
        r2.write(r3);	 Catch:{ Exception -> 0x0017, all -> 0x0014 }
        if (r2 == 0) goto L_0x002e;
    L_0x0010:
        r2.close();	 Catch:{ IOException -> 0x0028 }
        goto L_0x002e;
    L_0x0014:
        r3 = move-exception;
        r0 = r2;
        goto L_0x002f;
    L_0x0017:
        r3 = move-exception;
        r0 = r2;
        goto L_0x001d;
    L_0x001a:
        r3 = move-exception;
        goto L_0x002f;
    L_0x001c:
        r3 = move-exception;
    L_0x001d:
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o;	 Catch:{ all -> 0x001a }
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r3);	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x002e;
    L_0x0024:
        r0.close();	 Catch:{ IOException -> 0x0028 }
        goto L_0x002e;
    L_0x0028:
        r3 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r3);
    L_0x002e:
        return r4;
    L_0x002f:
        if (r0 == 0) goto L_0x003b;
    L_0x0031:
        r0.close();	 Catch:{ IOException -> 0x0035 }
        goto L_0x003b;
    L_0x0035:
        r4 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r4);
    L_0x003b:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bq.O000000o(byte[], java.io.File):java.io.File");
    }

    public static byte[] O000000o(Context context, int i, boolean z, CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap decodeStream;
        if (z) {
            byte[] toByteArray;
            byte[] bArr = new byte[0];
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                decodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options);
                if (decodeStream != null) {
                    decodeStream.compress(compressFormat, 100, byteArrayOutputStream);
                }
                toByteArray = byteArrayOutputStream.toByteArray();
            } catch (Error e) {
                O0000O0o.O000000o(O0000OOo.O00000oO, e);
                toByteArray = bArr;
            }
            return toByteArray;
        }
        Resources resources = context.getResources();
        decodeStream = bq.O000000o(VERSION.SDK_INT >= 21 ? resources.getDrawable(i, null) : resources.getDrawable(i));
        if (decodeStream != null) {
            decodeStream.compress(compressFormat, 100, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] O000000o(Bitmap bitmap, CompressFormat compressFormat) {
        return bq.O00000Oo(bitmap, compressFormat);
    }

    public static byte[] O000000o(O0000Oo o0000Oo, int i) {
        if (o0000Oo == null) {
            return O00000o0.O000000o();
        }
        if (o0000Oo.O0000o00() == null || bq.O000000o(o0000Oo) < i) {
            return o0000Oo.O0000o00();
        }
        if (o0000Oo.O0000OOo == O0000Oo.O00000o0.QUALITY) {
            return bq.O000000o(o0000Oo.O0000o00(), i, o0000Oo.O0000Oo0);
        }
        try {
            byte[] O0000o00 = o0000Oo.O0000o00();
            if (O0000o00 == null) {
                return new byte[1];
            }
            if (O0000o00.length <= 0) {
                return o0000Oo.O0000o00();
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(O0000o00, 0, O0000o00.length);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(O0000o00, 0, O0000o00.length);
            while (byteArrayOutputStream.toByteArray().length > i) {
                double sqrt = Math.sqrt((1.0d * ((double) O0000o00.length)) / ((double) i));
                decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, (int) (((double) decodeByteArray.getWidth()) / sqrt), (int) (((double) decodeByteArray.getHeight()) / sqrt), true);
                byteArrayOutputStream.reset();
                if (decodeByteArray != null) {
                    decodeByteArray.compress(o0000Oo.O0000Oo0, 100, byteArrayOutputStream);
                    O0000o00 = byteArrayOutputStream.toByteArray();
                }
            }
            return byteArrayOutputStream.toByteArray().length > i ? null : O0000o00;
        } catch (Throwable th) {
            O0000O0o.O000000o(th);
            return O00000o0.O000000o();
        }
    }

    public static byte[] O000000o(File file, CompressFormat compressFormat) {
        return bq.O00000Oo(file, compressFormat);
    }

    public static byte[] O000000o(String str) {
        return da.O00000o0(str);
    }

    public static byte[] O000000o(byte[] bArr, int i, CompressFormat compressFormat) {
        if (bArr != null && bArr.length >= i) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            int i3 = 1;
            while (i2 == 0 && i3 <= 10) {
                int pow = (int) (100.0d * Math.pow(0.8d, (double) i3));
                if (decodeByteArray != null) {
                    decodeByteArray.compress(compressFormat, pow, byteArrayOutputStream);
                }
                if (byteArrayOutputStream == null || byteArrayOutputStream.size() >= i) {
                    byteArrayOutputStream.reset();
                    i3++;
                } else {
                    i2 = 1;
                }
            }
            if (byteArrayOutputStream != null) {
                bArr = byteArrayOutputStream.toByteArray();
                if (!decodeByteArray.isRecycled()) {
                    decodeByteArray.recycle();
                }
                if (bArr != null && bArr.length <= 0) {
                    O0000O0o.O000000o(O0000OOo.O0000Oo);
                }
                return bArr;
            }
        }
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A:{SYNTHETIC, Splitter:B:22:0x003d} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A:{SYNTHETIC, Splitter:B:29:0x004c} */
    private static byte[] O000000o(byte[] r4, android.graphics.Bitmap.CompressFormat r5) {
        /*
        r0 = 0;
        r1 = defpackage.bq.O00000o(r4);	 Catch:{ Exception -> 0x0034, all -> 0x0031 }
        r2 = 0;
        r3 = r4.length;	 Catch:{ Exception -> 0x0034, all -> 0x0031 }
        r4 = android.graphics.BitmapFactory.decodeByteArray(r4, r2, r3, r1);	 Catch:{ Exception -> 0x0034, all -> 0x0031 }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0034, all -> 0x0031 }
        r1.<init>();	 Catch:{ Exception -> 0x0034, all -> 0x0031 }
        if (r4 == 0) goto L_0x0020;
    L_0x0012:
        r2 = 100;
        r4.compress(r5, r2, r1);	 Catch:{ Exception -> 0x001e }
        r4.recycle();	 Catch:{ Exception -> 0x001e }
        java.lang.System.gc();	 Catch:{ Exception -> 0x001e }
        goto L_0x0020;
    L_0x001e:
        r4 = move-exception;
        goto L_0x0036;
    L_0x0020:
        r4 = r1.toByteArray();	 Catch:{ Exception -> 0x001e }
        if (r1 == 0) goto L_0x0048;
    L_0x0026:
        r1.close();	 Catch:{ IOException -> 0x002a }
        goto L_0x0048;
    L_0x002a:
        r5 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r5);
        goto L_0x0048;
    L_0x0031:
        r4 = move-exception;
        r1 = r0;
        goto L_0x004a;
    L_0x0034:
        r4 = move-exception;
        r1 = r0;
    L_0x0036:
        r5 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000oo;	 Catch:{ all -> 0x0049 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r5, r4);	 Catch:{ all -> 0x0049 }
        if (r1 == 0) goto L_0x0047;
    L_0x003d:
        r1.close();	 Catch:{ IOException -> 0x0041 }
        goto L_0x0047;
    L_0x0041:
        r4 = move-exception;
        r5 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r5, r4);
    L_0x0047:
        r4 = r0;
    L_0x0048:
        return r4;
    L_0x0049:
        r4 = move-exception;
    L_0x004a:
        if (r1 == 0) goto L_0x0056;
    L_0x004c:
        r1.close();	 Catch:{ IOException -> 0x0050 }
        goto L_0x0056;
    L_0x0050:
        r5 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r5);
    L_0x0056:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bq.O000000o(byte[], android.graphics.Bitmap$CompressFormat):byte[]");
    }

    public static File O00000Oo(byte[] bArr) {
        try {
            return bq.O000000o(bArr, bs.O000000o().O00000Oo());
        } catch (IOException e) {
            O0000O0o.O000000o(O0000OOo.O000000o, e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f A:{SYNTHETIC, Splitter:B:28:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0060 A:{SYNTHETIC, Splitter:B:35:0x0060} */
    private static byte[] O00000Oo(android.graphics.Bitmap r4, android.graphics.Bitmap.CompressFormat r5) {
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x006b;
    L_0x0003:
        r1 = r4.isRecycled();
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x006b;
    L_0x000a:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0047 }
        r1.<init>();	 Catch:{ Exception -> 0x0047 }
        r0 = r4.getRowBytes();	 Catch:{ Exception -> 0x0041, all -> 0x003f }
        r2 = r4.getHeight();	 Catch:{ Exception -> 0x0041, all -> 0x003f }
        r0 = r0 * r2;
        r0 = r0 / 1024;
        r2 = 100;
        r0 = (float) r0;	 Catch:{ Exception -> 0x0041, all -> 0x003f }
        r3 = defpackage.bt.O0000O0o;	 Catch:{ Exception -> 0x0041, all -> 0x003f }
        r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r3 <= 0) goto L_0x0029;
    L_0x0023:
        r3 = defpackage.bt.O0000O0o;	 Catch:{ Exception -> 0x0041, all -> 0x003f }
        r3 = r3 / r0;
        r0 = (float) r2;	 Catch:{ Exception -> 0x0041, all -> 0x003f }
        r3 = r3 * r0;
        r2 = (int) r3;	 Catch:{ Exception -> 0x0041, all -> 0x003f }
    L_0x0029:
        if (r4 == 0) goto L_0x002e;
    L_0x002b:
        r4.compress(r5, r2, r1);	 Catch:{ Exception -> 0x0041, all -> 0x003f }
    L_0x002e:
        r4 = r1.toByteArray();	 Catch:{ Exception -> 0x0041, all -> 0x003f }
        if (r1 == 0) goto L_0x003e;
    L_0x0034:
        r1.close();	 Catch:{ IOException -> 0x0038 }
        goto L_0x003e;
    L_0x0038:
        r5 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r5);
    L_0x003e:
        return r4;
    L_0x003f:
        r4 = move-exception;
        goto L_0x005e;
    L_0x0041:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0048;
    L_0x0044:
        r4 = move-exception;
        r1 = r0;
        goto L_0x005e;
    L_0x0047:
        r4 = move-exception;
    L_0x0048:
        r5 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000Oo;	 Catch:{ all -> 0x0044 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r5, r4);	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0059;
    L_0x004f:
        r0.close();	 Catch:{ IOException -> 0x0053 }
        goto L_0x0059;
    L_0x0053:
        r4 = move-exception;
        r5 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r5, r4);
    L_0x0059:
        r4 = com.umeng.socialize.utils.O00000o0.O000000o();
        return r4;
    L_0x005e:
        if (r1 == 0) goto L_0x006a;
    L_0x0060:
        r1.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x006a;
    L_0x0064:
        r5 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r5);
    L_0x006a:
        throw r4;
    L_0x006b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bq.O00000Oo(android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat):byte[]");
    }

    private static byte[] O00000Oo(File file, CompressFormat compressFormat) {
        if (file == null || !file.getAbsoluteFile().exists()) {
            return null;
        }
        byte[] O000000o = bs.O000000o().O000000o(file);
        if (!O0000Oo0.O000000o(O000000o)) {
            return null;
        }
        return bu.O0000o00[1].equals(bu.O000000o(O000000o)) ? O000000o : bq.O000000o(O000000o, compressFormat);
    }

    private static Options O00000o(byte[] bArr) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int ceil = (int) Math.ceil((double) (options.outWidth / O0000Oo.O0000Oo));
        int ceil2 = (int) Math.ceil((double) (options.outHeight / O0000Oo.O0000OoO));
        if (ceil2 <= 1 || ceil <= 1) {
            if (ceil2 > 2) {
                options.inSampleSize = ceil2;
            } else if (ceil > 2) {
                options.inSampleSize = ceil;
            }
        } else if (ceil2 > ceil) {
            options.inSampleSize = ceil2;
        } else {
            options.inSampleSize = ceil;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    public static String O00000o0(byte[] bArr) {
        return bu.O000000o(bArr);
    }

    private static int O00000oO(byte[] bArr) {
        return bArr != null ? bArr.length : 0;
    }
}
