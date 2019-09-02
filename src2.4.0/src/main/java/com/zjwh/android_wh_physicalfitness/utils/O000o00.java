package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Log;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ImageCompressUtils */
public class O000o00 {
    public static final int O000000o = 1;
    public static final int O00000Oo = 3;
    private static final String O00000o = "com.zjwh.android_wh_physicalfitness.utils.O000o00";
    public static String O00000o0 = "jimu_thumb";
    private final File O00000oO;
    private O0000O0o O00000oo;
    private File O0000O0o;
    private List<File> O0000OOo;
    private int O0000Oo = 0;
    private int O0000Oo0 = 3;
    private File[] O0000OoO;

    /* compiled from: ImageCompressUtils */
    public interface O00000o {
        void O000000o();

        void O000000o(File file);
    }

    /* compiled from: ImageCompressUtils */
    private class O000000o extends com.zjwh.android_wh_physicalfitness.utils.O0000O0o.O000000o<File> {
        private File O00000Oo;
        private int O00000o;
        private O00000o O00000o0;

        public O000000o(File file, int i, O00000o o00000o) {
            this.O00000o = i;
            this.O00000Oo = file;
            this.O00000o0 = o00000o;
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(File file) {
            super.O000000o(file);
            if (file == null) {
                this.O00000o0.O000000o();
            } else {
                this.O00000o0.O000000o(file);
            }
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: O00000o */
        public File O000000o() {
            try {
                return this.O00000o == 1 ? O000o00.this.O00000Oo(this.O00000Oo) : O000o00.this.O00000o0(this.O00000Oo.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: ImageCompressUtils */
    private class O00000Oo extends com.zjwh.android_wh_physicalfitness.utils.O0000O0o.O000000o<List<File>> {
        private List<File> O00000Oo;
        private int O00000o;
        private O0000O0o O00000o0;

        public O00000Oo(List<File> list, int i, O0000O0o o0000O0o) {
            this.O00000o = i;
            this.O00000Oo = list;
            this.O00000o0 = o0000O0o;
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(List<File> list) {
            super.O000000o(list);
            if (list == null) {
                this.O00000o0.O000000o();
            } else {
                this.O00000o0.O000000o(list);
            }
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: O00000o */
        public List<File> O000000o() {
            ArrayList arrayList = new ArrayList();
            for (File file : this.O00000Oo) {
                Object O000000o;
                try {
                    O000000o = this.O00000o == 1 ? O000o00.this.O00000Oo(file) : O000o00.this.O00000o0(file.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                    O000000o = null;
                }
                arrayList.add(O000000o);
            }
            return arrayList;
        }
    }

    /* compiled from: ImageCompressUtils */
    class O00000o0 implements Runnable {
        private File O00000Oo;
        private O0000O0o O00000o;
        private int O00000o0;
        private int O00000oO;

        O00000o0(File file, int i, int i2, O0000O0o o0000O0o) {
            this.O00000Oo = file;
            this.O00000o0 = i2;
            this.O00000o = o0000O0o;
            this.O00000oO = i;
        }

        public void run() {
            File O000000o;
            try {
                O000000o = O000o00.this.O0000Oo0 == 1 ? O000o00.this.O00000Oo(this.O00000Oo) : O000o00.this.O00000o0(this.O00000Oo.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
                O000000o = null;
            }
            O000o00.this.O0000OoO[this.O00000oO] = O000000o;
            O000o00.this.O0000Oo = O000o00.this.O0000Oo + 1;
            if (this.O00000o0 == O000o00.this.O0000Oo && this.O00000o != null) {
                this.O00000o.O000000o(Arrays.asList(O000o00.this.O0000OoO));
            }
        }
    }

    /* compiled from: ImageCompressUtils */
    public interface O0000O0o {
        void O000000o();

        void O000000o(List<File> list);
    }

    private O000o00(Context context) {
        this.O00000oO = O00000Oo(context);
        this.O00000oo = new O0000O0o();
    }

    private static Bitmap O000000o(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Bitmap O000000o(String str, int i, int i2) {
        int i3;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i2 || i5 > i) {
            i4 /= 2;
            i5 /= 2;
            i3 = 1;
            while (i4 / i3 > i2 && i5 / i3 > i) {
                i3 *= 2;
            }
        } else {
            i3 = 1;
        }
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        i2 = (int) Math.ceil((double) (((float) options.outHeight) / ((float) i2)));
        i = (int) Math.ceil((double) (((float) options.outWidth) / ((float) i)));
        if (i2 > 1 || i > 1) {
            if (i2 > i) {
                options.inSampleSize = i2;
            } else {
                options.inSampleSize = i;
            }
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static O000o00 O000000o(Context context) {
        Context context2 = (Context) new WeakReference(context).get();
        return context2 == null ? new O000o00(context) : new O000o00(context2);
    }

    public static File O000000o(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            return (file.mkdirs() || (file.exists() && file.isDirectory())) ? file : null;
        } else {
            if (Log.isLoggable(O00000o, 6)) {
                Log.e(O00000o, "default disk cache dir is null");
            }
            return null;
        }
    }

    private File O000000o(String str, Bitmap bitmap, long j) {
        File file = new File(str.substring(0, str.lastIndexOf("/")));
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (((long) (byteArrayOutputStream.toByteArray().length / XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE)) > j) {
            byteArrayOutputStream.reset();
            i -= 6;
            bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(str);
    }

    private File O000000o(String str, String str2, int i, int i2, int i3, long j) {
        return O000000o(str2, O000000o(i3, O000000o(str, i, i2)), j);
    }

    public static File O00000Oo(Context context) {
        return O000000o(context, O00000o0);
    }

    private synchronized File O00000Oo(File file) {
        File O000000o;
        synchronized (this) {
            int i = 1920;
            try {
                long j;
                int i2;
                String absolutePath = file.getAbsolutePath();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.O00000oO.getAbsolutePath());
                stringBuilder.append("/");
                stringBuilder.append(System.currentTimeMillis());
                stringBuilder.append(".jpg");
                String stringBuilder2 = stringBuilder.toString();
                long length = file.length() / 5;
                int O00000o = O00000o(absolutePath);
                int[] O00000Oo = O00000Oo(absolutePath);
                int i3 = 0;
                int i4;
                if (O00000Oo[0] <= O00000Oo[1]) {
                    double d = ((double) O00000Oo[0]) / ((double) O00000Oo[1]);
                    if (d <= 1.0d && d > 0.5625d) {
                        if (O00000Oo[0] <= 1920) {
                            i = O00000Oo[0];
                        }
                        j = (long) 240;
                        i4 = (O00000Oo[1] * i) / O00000Oo[0];
                        i3 = i;
                    } else if (d <= 0.5625d) {
                        i4 = O00000Oo[1] > 1080 ? 1080 : O00000Oo[1];
                        i3 = (O00000Oo[0] * i4) / O00000Oo[1];
                        j = length;
                    } else {
                        i4 = 0;
                        j = 0;
                    }
                    i2 = i4;
                } else {
                    double d2 = ((double) O00000Oo[1]) / ((double) O00000Oo[0]);
                    if (d2 <= 1.0d && d2 > 0.5625d) {
                        if (O00000Oo[1] <= 1920) {
                            i = O00000Oo[1];
                        }
                        i3 = (O00000Oo[0] * i) / O00000Oo[1];
                        j = (long) 240;
                        i2 = i;
                    } else if (d2 <= 0.5625d) {
                        i4 = 1080;
                        if (O00000Oo[0] <= 1080) {
                            i4 = O00000Oo[0];
                        }
                        i2 = (O00000Oo[1] * i4) / O00000Oo[0];
                        i3 = i4;
                        j = length;
                    } else {
                        i2 = 0;
                        j = 0;
                    }
                }
                O000000o = O000000o(absolutePath, stringBuilder2, i3, i2, O00000o, j);
            } catch (Throwable th) {
                Throwable th2 = th;
            }
        }
        return O000000o;
    }

    private int O00000o(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                attributeInt = 180;
            } else if (attributeInt == 6) {
                attributeInt = 90;
            } else if (attributeInt != 8) {
                return 0;
            } else {
                attributeInt = 270;
            }
            return attributeInt;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004d A:{Catch:{ all -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b A:{Catch:{ all -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011d A:{Catch:{ all -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b A:{Catch:{ all -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004d A:{Catch:{ all -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b A:{Catch:{ all -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e2 A:{Catch:{ all -> 0x012e }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011d A:{Catch:{ all -> 0x012e }} */
    private synchronized java.io.File O00000o0(java.lang.String r21) {
        /*
        r20 = this;
        r9 = r20;
        monitor-enter(r20);
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012e }
        r1.<init>();	 Catch:{ all -> 0x012e }
        r2 = r9.O00000oO;	 Catch:{ all -> 0x012e }
        r2 = r2.getAbsolutePath();	 Catch:{ all -> 0x012e }
        r1.append(r2);	 Catch:{ all -> 0x012e }
        r2 = "/";
        r1.append(r2);	 Catch:{ all -> 0x012e }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x012e }
        r1.append(r2);	 Catch:{ all -> 0x012e }
        r2 = ".jpg";
        r1.append(r2);	 Catch:{ all -> 0x012e }
        r3 = r1.toString();	 Catch:{ all -> 0x012e }
        r6 = r20.O00000o(r21);	 Catch:{ all -> 0x012e }
        r1 = r20.O00000Oo(r21);	 Catch:{ all -> 0x012e }
        r2 = 0;
        r1 = r1[r2];	 Catch:{ all -> 0x012e }
        r2 = r20.O00000Oo(r21);	 Catch:{ all -> 0x012e }
        r4 = 1;
        r2 = r2[r4];	 Catch:{ all -> 0x012e }
        r5 = r1 % 2;
        if (r5 != r4) goto L_0x003e;
    L_0x003c:
        r1 = r1 + 1;
    L_0x003e:
        r5 = r2 % 2;
        if (r5 != r4) goto L_0x0044;
    L_0x0042:
        r2 = r2 + 1;
    L_0x0044:
        if (r1 <= r2) goto L_0x0048;
    L_0x0046:
        r5 = r2;
        goto L_0x0049;
    L_0x0048:
        r5 = r1;
    L_0x0049:
        if (r1 <= r2) goto L_0x004d;
    L_0x004b:
        r7 = r1;
        goto L_0x004e;
    L_0x004d:
        r7 = r2;
    L_0x004e:
        r10 = (double) r5;	 Catch:{ all -> 0x012e }
        r12 = (double) r7;	 Catch:{ all -> 0x012e }
        r10 = r10 / r12;
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        r14 = 4603241769126068224; // 0x3fe2000000000000 float:0.0 double:0.5625;
        r16 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        if (r8 > 0) goto L_0x00de;
    L_0x005b:
        r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r8 <= 0) goto L_0x00de;
    L_0x005f:
        r8 = 1664; // 0x680 float:2.332E-42 double:8.22E-321;
        r10 = 4633641066610819072; // 0x404e000000000000 float:0.0 double:60.0;
        r12 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        if (r7 >= r8) goto L_0x0083;
    L_0x0067:
        r5 = r5 * r7;
        r4 = (double) r5;	 Catch:{ all -> 0x012e }
        r7 = 4655033164840828928; // 0x409a000000000000 float:0.0 double:1664.0;
        r7 = java.lang.Math.pow(r7, r12);	 Catch:{ all -> 0x012e }
        r4 = r4 / r7;
        r7 = 4639481672377565184; // 0x4062c00000000000 float:0.0 double:150.0;
        r4 = r4 * r7;
        r7 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r7 >= 0) goto L_0x007b;
    L_0x007a:
        r4 = r10;
    L_0x007b:
        r18 = r4;
        r4 = r1;
        r5 = r2;
        r1 = r18;
        goto L_0x0124;
    L_0x0083:
        r1 = 4990; // 0x137e float:6.992E-42 double:2.4654E-320;
        r14 = 4643985272004935680; // 0x4072c00000000000 float:0.0 double:300.0;
        if (r7 < r8) goto L_0x00ad;
    L_0x008c:
        if (r7 >= r1) goto L_0x00ad;
    L_0x008e:
        r5 = r5 / 2;
        r7 = r7 / 2;
        r1 = r5 * r7;
        r1 = (double) r1;	 Catch:{ all -> 0x012e }
        r10 = 4657704978096324608; // 0x40a37e0000000000 float:0.0 double:2495.0;
        r10 = java.lang.Math.pow(r10, r12);	 Catch:{ all -> 0x012e }
        r1 = r1 / r10;
        r10 = r1 * r14;
        r1 = 4633641066610819072; // 0x404e000000000000 float:0.0 double:60.0;
        r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1));
        if (r4 >= 0) goto L_0x00a8;
    L_0x00a7:
        goto L_0x00a9;
    L_0x00a8:
        r1 = r10;
    L_0x00a9:
        r4 = r5;
        r5 = r7;
        goto L_0x0124;
    L_0x00ad:
        r10 = 4657847914607935488; // 0x40a4000000000000 float:0.0 double:2560.0;
        if (r7 < r1) goto L_0x00c7;
    L_0x00b1:
        r1 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        if (r7 >= r1) goto L_0x00c7;
    L_0x00b5:
        r5 = r5 / 4;
        r7 = r7 / 4;
        r1 = r5 * r7;
        r1 = (double) r1;	 Catch:{ all -> 0x012e }
        r10 = java.lang.Math.pow(r10, r12);	 Catch:{ all -> 0x012e }
        r1 = r1 / r10;
        r1 = r1 * r14;
        r4 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1));
        if (r4 >= 0) goto L_0x011e;
    L_0x00c6:
        goto L_0x0120;
    L_0x00c7:
        r1 = r7 / 1280;
        if (r1 != 0) goto L_0x00cc;
    L_0x00cb:
        goto L_0x00ce;
    L_0x00cc:
        r4 = r7 / 1280;
    L_0x00ce:
        r5 = r5 / r4;
        r7 = r7 / r4;
        r1 = r5 * r7;
        r1 = (double) r1;	 Catch:{ all -> 0x012e }
        r10 = java.lang.Math.pow(r10, r12);	 Catch:{ all -> 0x012e }
        r1 = r1 / r10;
        r1 = r1 * r14;
        r4 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1));
        if (r4 >= 0) goto L_0x011e;
    L_0x00dd:
        goto L_0x0120;
    L_0x00de:
        r1 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r1 > 0) goto L_0x0102;
    L_0x00e2:
        r1 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r8 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1));
        if (r8 <= 0) goto L_0x0102;
    L_0x00e8:
        r1 = r7 / 1280;
        if (r1 != 0) goto L_0x00ed;
    L_0x00ec:
        goto L_0x00ef;
    L_0x00ed:
        r4 = r7 / 1280;
    L_0x00ef:
        r5 = r5 / r4;
        r7 = r7 / r4;
        r1 = r5 * r7;
        r1 = (double) r1;	 Catch:{ all -> 0x012e }
        r10 = 4705170895067414528; // 0x414c200000000000 float:0.0 double:3686400.0;
        r1 = r1 / r10;
        r10 = 4641240890982006784; // 0x4069000000000000 float:0.0 double:200.0;
        r1 = r1 * r10;
        r4 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1));
        if (r4 >= 0) goto L_0x011e;
    L_0x0101:
        goto L_0x0120;
    L_0x0102:
        r1 = 4653344314980564992; // 0x4094000000000000 float:0.0 double:1280.0;
        r10 = r1 / r10;
        r12 = r12 / r10;
        r12 = java.lang.Math.ceil(r12);	 Catch:{ all -> 0x012e }
        r4 = (int) r12;	 Catch:{ all -> 0x012e }
        r5 = r5 / r4;
        r7 = r7 / r4;
        r4 = r5 * r7;
        r12 = (double) r4;	 Catch:{ all -> 0x012e }
        r1 = r1 * r10;
        r12 = r12 / r1;
        r1 = 4647503709213818880; // 0x407f400000000000 float:0.0 double:500.0;
        r1 = r1 * r12;
        r4 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1));
        if (r4 >= 0) goto L_0x011e;
    L_0x011d:
        goto L_0x0120;
    L_0x011e:
        r16 = r1;
    L_0x0120:
        r4 = r5;
        r5 = r7;
        r1 = r16;
    L_0x0124:
        r7 = (long) r1;	 Catch:{ all -> 0x012e }
        r1 = r9;
        r2 = r21;
        r1 = r1.O000000o(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x012e }
        monitor-exit(r20);
        return r1;
    L_0x012e:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r20);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.utils.O000o00.O00000o0(java.lang.String):java.io.File");
    }

    public O000o00 O000000o(int i) {
        this.O0000Oo0 = i;
        return this;
    }

    public O000o00 O000000o(File file) {
        this.O0000O0o = file;
        return this;
    }

    public O000o00 O000000o(String str) {
        this.O0000O0o = new File(str);
        return this;
    }

    public O000o00 O000000o(List<String> list) {
        if (this.O0000OOo == null) {
            this.O0000OOo = new ArrayList();
        }
        this.O0000OOo.clear();
        for (String file : list) {
            this.O0000OOo.add(new File(file));
        }
        return this;
    }

    public void O000000o() {
        if (this.O00000oo != null) {
            O0000O0o.O000000o();
        }
    }

    public void O000000o(O00000o o00000o) {
        if (this.O0000O0o == null) {
            throw new NullPointerException("the image file cannot be null, please call .load() before this method!");
        } else if (o00000o == null) {
            throw new NullPointerException("the listener must be attached!");
        } else {
            this.O00000oo.O000000o(new O000000o(this.O0000O0o, this.O0000Oo0, o00000o));
        }
    }

    public void O000000o(O0000O0o o0000O0o) {
        if (this.O0000OOo == null) {
            throw new NullPointerException("the image file cannot be null, please call .load() before this method!");
        } else if (o0000O0o == null) {
            throw new NullPointerException("the listener must be attached!");
        } else {
            this.O00000oo.O000000o(new O00000Oo(this.O0000OOo, this.O0000Oo0, o0000O0o));
        }
    }

    public void O00000Oo(O0000O0o o0000O0o) {
        if (this.O0000OOo == null) {
            throw new NullPointerException("the image file list cannot be null, please call .load() before this method!");
        } else if (o0000O0o == null) {
            throw new NullPointerException("the listener must be attached!");
        } else {
            int size = this.O0000OOo.size();
            this.O0000OoO = new File[size];
            this.O0000Oo = 0;
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(size);
            for (int i = 0; i < size; i++) {
                newFixedThreadPool.execute(new O00000o0((File) this.O0000OOo.get(i), i, size, o0000O0o));
            }
        }
    }

    public int[] O00000Oo(String str) {
        int[] iArr = new int[2];
        Options options = new Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeFile(str, options);
        iArr[0] = options.outWidth;
        iArr[1] = options.outHeight;
        return iArr;
    }
}
