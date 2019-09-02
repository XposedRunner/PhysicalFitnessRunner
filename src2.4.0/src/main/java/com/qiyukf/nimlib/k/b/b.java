package com.qiyukf.nimlib.k.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.nim.uikit.session.viewholder.i;
import com.qiyukf.nimlib.k.c.c;
import com.qiyukf.unicorn.R;
import java.io.File;
import java.io.IOException;

public final class b {

    public static class a {
        public int a = 0;
        public int b = 0;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public static int a(String str) {
        int i = 0;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                return attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90;
            } else {
                i = 180;
                return i;
            }
        } catch (IOException unused) {
        }
    }

    public static Bitmap a() {
        try {
            return a(com.qiyukf.nimlib.b.a().getResources(), R.drawable.ysf_image_placeholder_fail);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap a(int i) {
        try {
            return a(com.qiyukf.nimlib.b.a().getResources(), i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bitmap a(Resources resources, int i) {
        Drawable drawable = resources.getDrawable(i);
        Bitmap bitmap = (drawable == null || !(drawable instanceof BitmapDrawable)) ? null : ((BitmapDrawable) drawable).getBitmap();
        return bitmap.copy(Config.RGB_565, false);
    }

    public static Bitmap a(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return null;
        }
        try {
            int a = a(str);
            if (a == 0) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate((float) a);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            if (createBitmap == null) {
                return bitmap;
            }
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARNING: Missing block: B:16:0x002b, code skipped:
            if (r3 < r6) goto L_0x002d;
     */
    public static com.qiyukf.nimlib.k.b.b.a a(float r3, float r4, float r5, float r6) {
        /*
        r0 = 0;
        r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r1 <= 0) goto L_0x003e;
    L_0x0005:
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x000a;
    L_0x0009:
        goto L_0x003e;
    L_0x000a:
        r0 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x0013;
    L_0x000e:
        r0 = 0;
        r2 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x0014;
    L_0x0013:
        r0 = 1;
    L_0x0014:
        r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r1 >= 0) goto L_0x0022;
    L_0x0018:
        r3 = r6 / r3;
        r3 = r3 * r4;
        r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r4 <= 0) goto L_0x0020;
    L_0x001f:
        goto L_0x002d;
    L_0x0020:
        r5 = r3;
        goto L_0x002d;
    L_0x0022:
        r1 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r1 <= 0) goto L_0x002f;
    L_0x0026:
        r4 = r5 / r4;
        r3 = r3 * r4;
        r4 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x0030;
    L_0x002d:
        r3 = r6;
        goto L_0x0030;
    L_0x002f:
        r5 = r4;
    L_0x0030:
        if (r0 == 0) goto L_0x0033;
    L_0x0032:
        goto L_0x0036;
    L_0x0033:
        r2 = r5;
        r5 = r3;
        r3 = r2;
    L_0x0036:
        r4 = new com.qiyukf.nimlib.k.b.b$a;
        r3 = (int) r3;
        r5 = (int) r5;
        r4.<init>(r3, r5);
        return r4;
    L_0x003e:
        r3 = new com.qiyukf.nimlib.k.b.b$a;
        r4 = (int) r6;
        r3.<init>(r4, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.k.b.b.a(float, float, float, float):com.qiyukf.nimlib.k.b.b$a");
    }

    public static File a(File file, String str) {
        String path = file.getPath();
        str = str.toLowerCase();
        Object obj = (str.contains("jpg") || str.contains("jpeg") || str.toLowerCase().contains("png") || str.toLowerCase().contains("bmp") || str.toLowerCase().contains("gif")) ? 1 : null;
        if (obj == null) {
            return null;
        }
        str = com.qiyukf.basesdk.c.a.b.a(path);
        StringBuilder stringBuilder = new StringBuilder("temp_image_");
        stringBuilder.append(d.a());
        stringBuilder.append(".");
        stringBuilder.append(str);
        File a = com.qiyukf.basesdk.c.a.a.a(c.a(stringBuilder.toString(), com.qiyukf.nimlib.k.c.b.TYPE_TEMP));
        return (a != null && a(file, a, CompressFormat.JPEG).booleanValue()) ? a : null;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x0123=Splitter:B:69:0x0123, B:85:0x0148=Splitter:B:85:0x0148} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014d A:{SYNTHETIC, Splitter:B:88:0x014d} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0128 A:{SYNTHETIC, Splitter:B:72:0x0128} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0170 A:{SYNTHETIC, Splitter:B:104:0x0170} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014d A:{SYNTHETIC, Splitter:B:88:0x014d} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0128 A:{SYNTHETIC, Splitter:B:72:0x0128} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0170 A:{SYNTHETIC, Splitter:B:104:0x0170} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0170 A:{SYNTHETIC, Splitter:B:104:0x0170} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014d A:{SYNTHETIC, Splitter:B:88:0x014d} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0128 A:{SYNTHETIC, Splitter:B:72:0x0128} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0170 A:{SYNTHETIC, Splitter:B:104:0x0170} */
    /* JADX WARNING: Missing block: B:82:0x0141, code skipped:
            if (r2.isRecycled() == false) goto L_0x0168;
     */
    /* JADX WARNING: Missing block: B:98:0x0166, code skipped:
            if (r2.isRecycled() == false) goto L_0x0168;
     */
    /* JADX WARNING: Missing block: B:99:0x0168, code skipped:
            r2.recycle();
     */
    private static java.lang.Boolean a(java.io.File r16, java.io.File r17, int r18, int r19, android.graphics.Bitmap.CompressFormat r20) {
        /*
        r1 = r18;
        r2 = r19;
        r3 = 0;
        r4 = java.lang.Boolean.valueOf(r3);
        r5 = 0;
        r6 = r16.getPath();	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r6 = com.qiyukf.nimlib.k.b.a.a(r6);	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r7 = r6[r3];	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r7 = (float) r7;	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r8 = 1;
        r6 = r6[r8];	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r6 = (float) r6;	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r9 = (float) r1;	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r10 = (float) r2;	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r6 = a(r7, r6, r9, r10);	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r7 = r16.getPath();	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r9 = r6.a;	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r10 = r6.b;	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r11 = com.qiyukf.nimlib.k.b.a.a(r7);	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r3 = r11[r3];	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r11 = r11[r8];	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r3 = com.qiyukf.nimlib.k.b.c.a(r3, r11, r9, r10);	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r3 = com.qiyukf.nimlib.k.b.a.a(r7, r3);	 Catch:{ OutOfMemoryError -> 0x0144, IOException -> 0x011f, all -> 0x011a }
        r7 = r16.getAbsolutePath();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r7 = a(r7);	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r14 = new android.graphics.Matrix;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r14.<init>();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r9 = (float) r7;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r14.postRotate(r9);	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r9 = r3.getWidth();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r9 < r2) goto L_0x0062;
    L_0x0050:
        r9 = r3.getHeight();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        if (r9 > r1) goto L_0x0062;
    L_0x0056:
        r9 = r3.getWidth();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        if (r9 < r2) goto L_0x0062;
    L_0x005c:
        r2 = r3.getHeight();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        if (r2 <= r1) goto L_0x0073;
    L_0x0062:
        r1 = r3.getWidth();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = r6.a;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        if (r1 != r2) goto L_0x0075;
    L_0x006a:
        r1 = r3.getHeight();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = r6.b;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        if (r1 == r2) goto L_0x0073;
    L_0x0072:
        goto L_0x0075;
    L_0x0073:
        r1 = r10;
        goto L_0x00a7;
    L_0x0075:
        r1 = r6.a;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r1 = (float) r1;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = r3.getWidth();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = (float) r2;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r1 = r1 / r2;
        r2 = r6.b;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = (float) r2;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r9 = r3.getHeight();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r9 = (float) r9;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = r2 / r9;
        r9 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r9 < 0) goto L_0x0099;
    L_0x008b:
        r2 = r3.getWidth();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r6.a = r2;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = r6.b;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = (float) r2;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r2 = r2 / r1;
        r2 = (int) r2;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r6.b = r2;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        goto L_0x00a7;
    L_0x0099:
        r1 = r6.a;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r1 = (float) r1;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r1 = r1 / r2;
        r1 = (int) r1;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r6.a = r1;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r1 = r3.getHeight();	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r6.b = r1;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r1 = r2;
    L_0x00a7:
        r14.postScale(r1, r1);	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        if (r7 != 0) goto L_0x00b2;
    L_0x00ac:
        r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1));
        if (r1 != 0) goto L_0x00b2;
    L_0x00b0:
        r1 = r3;
        goto L_0x00be;
    L_0x00b2:
        r10 = 0;
        r11 = 0;
        r12 = r6.a;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r13 = r6.b;	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
        r15 = 1;
        r9 = r3;
        r1 = android.graphics.Bitmap.createBitmap(r9, r10, r11, r12, r13, r14, r15);	 Catch:{ OutOfMemoryError -> 0x0116, IOException -> 0x0112, all -> 0x010d }
    L_0x00be:
        r2 = new java.io.BufferedOutputStream;	 Catch:{ OutOfMemoryError -> 0x0109, IOException -> 0x0105, all -> 0x0101 }
        r6 = new java.io.FileOutputStream;	 Catch:{ OutOfMemoryError -> 0x0109, IOException -> 0x0105, all -> 0x0101 }
        r7 = r17;
        r6.<init>(r7);	 Catch:{ OutOfMemoryError -> 0x0109, IOException -> 0x0105, all -> 0x0101 }
        r2.<init>(r6);	 Catch:{ OutOfMemoryError -> 0x0109, IOException -> 0x0105, all -> 0x0101 }
        r5 = 60;
        r6 = r20;
        r1.compress(r6, r5, r2);	 Catch:{ OutOfMemoryError -> 0x00fe, IOException -> 0x00fb, all -> 0x00f8 }
        r2.flush();	 Catch:{ OutOfMemoryError -> 0x00fe, IOException -> 0x00fb, all -> 0x00f8 }
        r5 = java.lang.Boolean.valueOf(r8);	 Catch:{ OutOfMemoryError -> 0x00fe, IOException -> 0x00fb, all -> 0x00f8 }
        r2.close();	 Catch:{ IOException -> 0x00dc }
        goto L_0x00e0;
    L_0x00dc:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00e0:
        if (r3 == 0) goto L_0x00eb;
    L_0x00e2:
        r2 = r3.isRecycled();
        if (r2 != 0) goto L_0x00eb;
    L_0x00e8:
        r3.recycle();
    L_0x00eb:
        if (r1 == 0) goto L_0x00f6;
    L_0x00ed:
        r2 = r1.isRecycled();
        if (r2 != 0) goto L_0x00f6;
    L_0x00f3:
        r1.recycle();
    L_0x00f6:
        r4 = r5;
        return r4;
    L_0x00f8:
        r0 = move-exception;
        r5 = r2;
        goto L_0x0102;
    L_0x00fb:
        r0 = move-exception;
        r5 = r2;
        goto L_0x0106;
    L_0x00fe:
        r0 = move-exception;
        r5 = r2;
        goto L_0x010a;
    L_0x0101:
        r0 = move-exception;
    L_0x0102:
        r2 = r1;
        goto L_0x016d;
    L_0x0105:
        r0 = move-exception;
    L_0x0106:
        r2 = r1;
        r1 = r0;
        goto L_0x0123;
    L_0x0109:
        r0 = move-exception;
    L_0x010a:
        r2 = r1;
        r1 = r0;
        goto L_0x0148;
    L_0x010d:
        r0 = move-exception;
        r1 = r0;
        r2 = r5;
        goto L_0x016e;
    L_0x0112:
        r0 = move-exception;
        r1 = r0;
        r2 = r5;
        goto L_0x0123;
    L_0x0116:
        r0 = move-exception;
        r1 = r0;
        r2 = r5;
        goto L_0x0148;
    L_0x011a:
        r0 = move-exception;
        r1 = r0;
        r2 = r5;
        r3 = r2;
        goto L_0x016e;
    L_0x011f:
        r0 = move-exception;
        r1 = r0;
        r2 = r5;
        r3 = r2;
    L_0x0123:
        r1.printStackTrace();	 Catch:{ all -> 0x016c }
        if (r5 == 0) goto L_0x0130;
    L_0x0128:
        r5.close();	 Catch:{ IOException -> 0x012c }
        goto L_0x0130;
    L_0x012c:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0130:
        if (r3 == 0) goto L_0x013b;
    L_0x0132:
        r1 = r3.isRecycled();
        if (r1 != 0) goto L_0x013b;
    L_0x0138:
        r3.recycle();
    L_0x013b:
        if (r2 == 0) goto L_0x016b;
    L_0x013d:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x016b;
    L_0x0143:
        goto L_0x0168;
    L_0x0144:
        r0 = move-exception;
        r1 = r0;
        r2 = r5;
        r3 = r2;
    L_0x0148:
        r1.printStackTrace();	 Catch:{ all -> 0x016c }
        if (r5 == 0) goto L_0x0155;
    L_0x014d:
        r5.close();	 Catch:{ IOException -> 0x0151 }
        goto L_0x0155;
    L_0x0151:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0155:
        if (r3 == 0) goto L_0x0160;
    L_0x0157:
        r1 = r3.isRecycled();
        if (r1 != 0) goto L_0x0160;
    L_0x015d:
        r3.recycle();
    L_0x0160:
        if (r2 == 0) goto L_0x016b;
    L_0x0162:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x016b;
    L_0x0168:
        r2.recycle();
    L_0x016b:
        return r4;
    L_0x016c:
        r0 = move-exception;
    L_0x016d:
        r1 = r0;
    L_0x016e:
        if (r5 == 0) goto L_0x0178;
    L_0x0170:
        r5.close();	 Catch:{ IOException -> 0x0174 }
        goto L_0x0178;
    L_0x0174:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0178:
        if (r3 == 0) goto L_0x0183;
    L_0x017a:
        r4 = r3.isRecycled();
        if (r4 != 0) goto L_0x0183;
    L_0x0180:
        r3.recycle();
    L_0x0183:
        if (r2 == 0) goto L_0x018e;
    L_0x0185:
        r3 = r2.isRecycled();
        if (r3 != 0) goto L_0x018e;
    L_0x018b:
        r2.recycle();
    L_0x018e:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.k.b.b.a(java.io.File, java.io.File, int, int, android.graphics.Bitmap$CompressFormat):java.lang.Boolean");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0092 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c3 A:{Splitter:B:1:0x0005, ExcHandler: Exception (e java.lang.Exception)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:42:0x00bd, code skipped:
            r13 = e;
     */
    /* JADX WARNING: Missing block: B:43:0x00be, code skipped:
            r14 = r0;
     */
    /* JADX WARNING: Missing block: B:46:0x00c3, code skipped:
            r13 = e;
     */
    /* JADX WARNING: Missing block: B:47:0x00c4, code skipped:
            r14 = r0;
     */
    private static java.lang.Boolean a(java.io.File r13, java.io.File r14, android.graphics.Bitmap.CompressFormat r15) {
        /*
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
        r1 = r13.getAbsolutePath();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r1 = com.qiyukf.nimlib.k.b.c.a(r1);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2 = r13.getPath();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r1 = com.qiyukf.nimlib.k.b.a.a(r2, r1);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        if (r1 != 0) goto L_0x0018;
    L_0x0017:
        return r0;
    L_0x0018:
        r13 = r13.getAbsolutePath();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r13 = a(r13);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2 = 1234067968; // 0x498e6200 float:1166400.0 double:6.097105876E-315;
        r3 = r1.getWidth();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r3 = (float) r3;	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r4 = r1.getHeight();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r4 = (float) r4;	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r3 = r3 * r4;
        r2 = r2 / r3;
        r2 = (double) r2;	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2 = java.lang.Math.sqrt(r2);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2 = (float) r2;
        r10 = 1;
        r11 = 70;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r13 != 0) goto L_0x0042;
    L_0x003c:
        r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r4 < 0) goto L_0x0042;
    L_0x0040:
        r13 = r1;
        goto L_0x0064;
    L_0x0042:
        r8 = new android.graphics.Matrix;	 Catch:{ OutOfMemoryError -> 0x0092, Exception -> 0x00c3 }
        r8.<init>();	 Catch:{ OutOfMemoryError -> 0x0092, Exception -> 0x00c3 }
        if (r13 == 0) goto L_0x004d;
    L_0x0049:
        r13 = (float) r13;	 Catch:{ OutOfMemoryError -> 0x0092, Exception -> 0x00c3 }
        r8.postRotate(r13);	 Catch:{ OutOfMemoryError -> 0x0092, Exception -> 0x00c3 }
    L_0x004d:
        r13 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r13 >= 0) goto L_0x0054;
    L_0x0051:
        r8.postScale(r2, r2);	 Catch:{ OutOfMemoryError -> 0x0092, Exception -> 0x00c3 }
    L_0x0054:
        r4 = 0;
        r5 = 0;
        r6 = r1.getWidth();	 Catch:{ OutOfMemoryError -> 0x0092, Exception -> 0x00c3 }
        r7 = r1.getHeight();	 Catch:{ OutOfMemoryError -> 0x0092, Exception -> 0x00c3 }
        r9 = 1;
        r3 = r1;
        r13 = android.graphics.Bitmap.createBitmap(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ OutOfMemoryError -> 0x0092, Exception -> 0x00c3 }
    L_0x0064:
        r2 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r3.<init>(r14);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r13.compress(r15, r11, r2);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2.flush();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2.close();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r14 = java.lang.Boolean.valueOf(r10);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r15 = r1.isRecycled();	 Catch:{ Exception -> 0x0090, OutOfMemoryError -> 0x008e }
        if (r15 != 0) goto L_0x0084;
    L_0x0081:
        r1.recycle();	 Catch:{ Exception -> 0x0090, OutOfMemoryError -> 0x008e }
    L_0x0084:
        r15 = r13.isRecycled();	 Catch:{ Exception -> 0x0090, OutOfMemoryError -> 0x008e }
        if (r15 != 0) goto L_0x00c8;
    L_0x008a:
        r13.recycle();	 Catch:{ Exception -> 0x0090, OutOfMemoryError -> 0x008e }
        return r14;
    L_0x008e:
        r13 = move-exception;
        goto L_0x00bf;
    L_0x0090:
        r13 = move-exception;
        goto L_0x00c5;
    L_0x0092:
        r13 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r2.<init>(r14);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r13.<init>(r2);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r1.compress(r15, r11, r13);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r13.flush();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r13.close();	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r13 = java.lang.Boolean.valueOf(r10);	 Catch:{ Exception -> 0x00c3, OutOfMemoryError -> 0x00bd }
        r14 = r1.isRecycled();	 Catch:{ Exception -> 0x00b8, OutOfMemoryError -> 0x00b3 }
        if (r14 != 0) goto L_0x00b2;
    L_0x00af:
        r1.recycle();	 Catch:{ Exception -> 0x00b8, OutOfMemoryError -> 0x00b3 }
    L_0x00b2:
        return r13;
    L_0x00b3:
        r14 = move-exception;
        r12 = r14;
        r14 = r13;
        r13 = r12;
        goto L_0x00bf;
    L_0x00b8:
        r14 = move-exception;
        r12 = r14;
        r14 = r13;
        r13 = r12;
        goto L_0x00c5;
    L_0x00bd:
        r13 = move-exception;
        r14 = r0;
    L_0x00bf:
        r13.printStackTrace();
        return r14;
    L_0x00c3:
        r13 = move-exception;
        r14 = r0;
    L_0x00c5:
        r13.printStackTrace();
    L_0x00c8:
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.k.b.b.a(java.io.File, java.io.File, android.graphics.Bitmap$CompressFormat):java.lang.Boolean");
    }

    public static String a(File file) {
        String a = c.a(file.getName(), com.qiyukf.nimlib.k.c.b.TYPE_THUMB_IMAGE);
        File a2 = com.qiyukf.basesdk.c.a.a.a(a);
        if (a2 == null) {
            return null;
        }
        if (a(file, a2, i.b(), i.c(), CompressFormat.JPEG).booleanValue()) {
            return a;
        }
        com.qiyukf.basesdk.c.a.a.b(a);
        return null;
    }
}
