package com.qiyukf.nim.uikit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.util.LruCache;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.UnicornImageLoader;
import com.qiyukf.unicorn.d;

public final class a {
    private static Context a;
    private static LruCache<String, Bitmap> b = new LruCache(20);

    /* JADX WARNING: Missing block: B:6:0x001e, code skipped:
            if ((r4 instanceof android.graphics.drawable.BitmapDrawable) != false) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:12:0x003d, code skipped:
            if ((r4 instanceof android.graphics.drawable.BitmapDrawable) != false) goto L_0x0020;
     */
    public static android.graphics.Bitmap a(java.lang.String r4) {
        /*
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "staffDefault";
        r0 = r4.contains(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x0010:
        r4 = a;
        r4 = r4.getResources();
        r0 = com.qiyukf.unicorn.R.drawable.ysf_def_avatar_staff;
        r4 = r4.getDrawable(r0);
        r0 = r4 instanceof android.graphics.drawable.BitmapDrawable;
        if (r0 == 0) goto L_0x0089;
    L_0x0020:
        r4 = (android.graphics.drawable.BitmapDrawable) r4;
        r4 = r4.getBitmap();
        return r4;
    L_0x0027:
        r0 = "selfDefault";
        r0 = r4.contains(r0);
        if (r0 == 0) goto L_0x0040;
    L_0x002f:
        r4 = a;
        r4 = r4.getResources();
        r0 = com.qiyukf.unicorn.R.drawable.ysf_def_avatar_user;
        r4 = r4.getDrawable(r0);
        r0 = r4 instanceof android.graphics.drawable.BitmapDrawable;
        if (r0 == 0) goto L_0x0089;
    L_0x003f:
        goto L_0x0020;
    L_0x0040:
        r0 = "unicorn://";
        r0 = r4.startsWith(r0);
        if (r0 == 0) goto L_0x0089;
    L_0x0048:
        r0 = 0;
        r2 = "unicorn://";
        r3 = "";
        r4 = r4.replace(r2, r3);	 Catch:{ NumberFormatException -> 0x005a }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x005a }
        r4 = r4.intValue();	 Catch:{ NumberFormatException -> 0x005a }
        goto L_0x005f;
    L_0x005a:
        r4 = move-exception;
        r4.printStackTrace();
        r4 = r0;
    L_0x005f:
        if (r4 <= 0) goto L_0x0089;
    L_0x0061:
        r0 = a;	 Catch:{ NotFoundException -> 0x0076 }
        r0 = r0.getResources();	 Catch:{ NotFoundException -> 0x0076 }
        r0 = r0.getDrawable(r4);	 Catch:{ NotFoundException -> 0x0076 }
        r2 = r0 instanceof android.graphics.drawable.BitmapDrawable;	 Catch:{ NotFoundException -> 0x0076 }
        if (r2 == 0) goto L_0x0089;
    L_0x006f:
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ NotFoundException -> 0x0076 }
        r0 = r0.getBitmap();	 Catch:{ NotFoundException -> 0x0076 }
        return r0;
    L_0x0076:
        r0 = "加载本地头像资源失败";
        r2 = new java.lang.StringBuilder;
        r3 = "id :";
        r2.<init>(r3);
        r2.append(r4);
        r4 = r2.toString();
        com.qiyukf.basesdk.a.a.a(r0, r4);
    L_0x0089:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.a.a(java.lang.String):android.graphics.Bitmap");
    }

    public static Bitmap a(String str, int i, int i2) {
        Bitmap c = c(b(str, i, i2));
        if (c != null) {
            return c;
        }
        UnicornImageLoader f = d.f();
        if (f == null) {
            return null;
        }
        c = f.loadImageSync(str, i, i2);
        if (c == null || c.isRecycled()) {
            return null;
        }
        b.put(b(str, i, i2), c);
        return c;
    }

    public static void a() {
        b.evictAll();
    }

    public static void a(Context context) {
        a = context;
        com.qiyukf.basesdk.a.a.a("ImageLoaderKit", "init ImageLoaderKit completed");
    }

    public static void a(String str, int i, int i2, ImageLoaderListener imageLoaderListener) {
        final String b = b(str, i, i2);
        Bitmap c = c(b);
        if (c == null) {
            final UnicornImageLoader f = d.f();
            if (f != null) {
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                final ImageLoaderListener imageLoaderListener2 = imageLoaderListener;
                AnonymousClass2 anonymousClass2 = new Runnable() {
                    public final void run() {
                        f.loadImage(str2, i3, i4, new ImageLoaderListener() {
                            public final void onLoadComplete(@NonNull Bitmap bitmap) {
                                if (!bitmap.isRecycled()) {
                                    if (BitmapCompat.getAllocationByteCount(bitmap) <= AccessibilityEventCompat.TYPE_WINDOWS_CHANGED) {
                                        a.b.put(b, bitmap);
                                    }
                                    if (imageLoaderListener2 != null) {
                                        imageLoaderListener2.onLoadComplete(bitmap);
                                    }
                                } else if (imageLoaderListener2 != null) {
                                    imageLoaderListener2.onLoadFailed(null);
                                }
                            }

                            public final void onLoadFailed(Throwable th) {
                                if (imageLoaderListener2 != null) {
                                    imageLoaderListener2.onLoadFailed(th);
                                }
                            }
                        });
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass2.run();
                    return;
                }
                com.qiyukf.basesdk.c.a.b().post(anonymousClass2);
            }
        } else if (imageLoaderListener != null) {
            imageLoaderListener.onLoadComplete(c);
        }
    }

    public static void a(String str, ImageView imageView) {
        a(str, imageView, 0, 0);
    }

    public static void a(final String str, final ImageView imageView, int i, int i2) {
        if (b(str)) {
            imageView.setTag(str);
            a(str, i, i2, new ImageLoaderListener() {
                public final void onLoadComplete(@NonNull Bitmap bitmap) {
                    if (imageView.getTag() != null && imageView.getTag().equals(str)) {
                        imageView.setImageBitmap(bitmap);
                    }
                }

                public final void onLoadFailed(Throwable th) {
                }
            });
            return;
        }
        imageView.setTag(null);
    }

    public static void a(String str, ImageLoaderListener imageLoaderListener) {
        a(str, 0, 0, imageLoaderListener);
    }

    private static String b(String str, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("#w#");
        stringBuilder.append(i);
        stringBuilder.append("#h#");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }

    private static Bitmap c(String str) {
        Bitmap bitmap = (Bitmap) b.get(str);
        if (bitmap == null || !bitmap.isRecycled()) {
            return bitmap;
        }
        b.remove(str);
        return null;
    }
}
