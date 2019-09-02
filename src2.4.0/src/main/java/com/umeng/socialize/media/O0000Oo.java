package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.yalantis.ucrop.view.CropImageView;
import defpackage.bn;
import defpackage.bq;
import defpackage.db;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UMImage */
public class O0000Oo extends O000000o {
    public static int O0000Oo = 768;
    public static int O0000OoO = 1024;
    public static int O0000Ooo = 1;
    public static int O0000o0 = 3;
    public static int O0000o00 = 2;
    public static int O0000o0O = 4;
    public static int O0000o0o = 5;
    public boolean O0000O0o = true;
    public O00000o0 O0000OOo = O00000o0.SCALE;
    public CompressFormat O0000Oo0 = CompressFormat.JPEG;
    private O00000o O0000o = null;
    private bn O0000oO;
    private O0000Oo O0000oO0;
    private int O0000oOO = 0;
    private boolean O0000oOo;

    /* compiled from: UMImage */
    interface O0000OOo {
        File O000000o();

        String O00000Oo();

        Bitmap O00000o();

        byte[] O00000o0();
    }

    /* compiled from: UMImage */
    static abstract class O00000o implements O0000OOo {
        O00000o() {
        }
    }

    /* compiled from: UMImage */
    class O000000o extends O00000o {
        private byte[] O00000Oo;

        public O000000o(byte[] bArr) {
            this.O00000Oo = bArr;
        }

        public File O000000o() {
            return com.umeng.socialize.utils.O0000Oo0.O000000o(O00000o0()) ? bq.O00000Oo(O00000o0()) : null;
        }

        public String O00000Oo() {
            return null;
        }

        public Bitmap O00000o() {
            return com.umeng.socialize.utils.O0000Oo0.O000000o(O00000o0()) ? bq.O000000o(O00000o0()) : null;
        }

        public byte[] O00000o0() {
            return this.O00000Oo;
        }
    }

    /* compiled from: UMImage */
    class O00000Oo extends O00000o {
        private Bitmap O00000Oo;

        public O00000Oo(Bitmap bitmap) {
            this.O00000Oo = bitmap;
        }

        public File O000000o() {
            return com.umeng.socialize.utils.O0000Oo0.O000000o(O00000o0()) ? bq.O00000Oo(bq.O000000o(this.O00000Oo, O0000Oo.this.O0000Oo0)) : null;
        }

        public String O00000Oo() {
            return null;
        }

        public Bitmap O00000o() {
            return this.O00000Oo;
        }

        public byte[] O00000o0() {
            return bq.O000000o(this.O00000Oo, O0000Oo.this.O0000Oo0);
        }
    }

    /* compiled from: UMImage */
    public enum O00000o0 {
        SCALE,
        QUALITY
    }

    /* compiled from: UMImage */
    class O0000O0o extends O00000o {
        private File O00000Oo;

        public O0000O0o(File file) {
            this.O00000Oo = file;
        }

        public File O000000o() {
            return this.O00000Oo;
        }

        public String O00000Oo() {
            return null;
        }

        public Bitmap O00000o() {
            return com.umeng.socialize.utils.O0000Oo0.O000000o(O00000o0()) ? bq.O000000o(O0000Oo.this.O0000o00()) : null;
        }

        public byte[] O00000o0() {
            return bq.O000000o(this.O00000Oo, O0000Oo.this.O0000Oo0);
        }
    }

    /* compiled from: UMImage */
    class O0000Oo0 extends O00000o {
        private Context O00000Oo;
        private int O00000o0 = 0;

        public O0000Oo0(Context context, int i) {
            this.O00000Oo = context;
            this.O00000o0 = i;
        }

        public File O000000o() {
            return com.umeng.socialize.utils.O0000Oo0.O000000o(O00000o0()) ? bq.O00000Oo(O00000o0()) : null;
        }

        public String O00000Oo() {
            return null;
        }

        public Bitmap O00000o() {
            return com.umeng.socialize.utils.O0000Oo0.O000000o(O00000o0()) ? bq.O000000o(O00000o0()) : null;
        }

        public byte[] O00000o0() {
            return bq.O000000o(this.O00000Oo, this.O00000o0, O0000Oo.this.O0000O0o, O0000Oo.this.O0000Oo0);
        }
    }

    /* compiled from: UMImage */
    class O0000Oo extends O00000o {
        private String O00000Oo = null;

        public O0000Oo(String str) {
            this.O00000Oo = str;
        }

        public File O000000o() {
            return com.umeng.socialize.utils.O0000Oo0.O000000o(O00000o0()) ? bq.O00000Oo(O00000o0()) : null;
        }

        public String O00000Oo() {
            return this.O00000Oo;
        }

        public Bitmap O00000o() {
            return com.umeng.socialize.utils.O0000Oo0.O000000o(O00000o0()) ? bq.O000000o(O00000o0()) : null;
        }

        public byte[] O00000o0() {
            return bq.O000000o(this.O00000Oo);
        }
    }

    public O0000Oo(Context context, int i) {
        O000000o(context, Integer.valueOf(i));
    }

    public O0000Oo(Context context, int i, bn bnVar) {
        O000000o(context, Integer.valueOf(i), bnVar);
    }

    public O0000Oo(Context context, Bitmap bitmap) {
        O000000o(context, (Object) bitmap);
    }

    public O0000Oo(Context context, Bitmap bitmap, bn bnVar) {
        O000000o(context, bitmap, bnVar);
    }

    public O0000Oo(Context context, File file) {
        O000000o(context, (Object) file);
    }

    public O0000Oo(Context context, String str) {
        super(str);
        O000000o((Context) new WeakReference(context).get(), (Object) str);
    }

    public O0000Oo(Context context, byte[] bArr) {
        O000000o(context, (Object) bArr);
    }

    public O0000Oo(Context context, byte[] bArr, bn bnVar) {
        O000000o(context, bArr, bnVar);
    }

    private float O000000o(float f, float f2, float f3, float f4) {
        if (f <= f4 && f2 <= f4) {
            return -1.0f;
        }
        f /= f3;
        f2 /= f4;
        if (f <= f2) {
            f = f2;
        }
        return f;
    }

    private Bitmap O000000o(Context context, int i) {
        Throwable e;
        if (i == 0 || context == null || this.O0000oO == null) {
            return null;
        }
        Closeable openRawResource;
        try {
            Closeable openRawResource2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            openRawResource = context.getResources().openRawResource(i);
            try {
                BitmapFactory.decodeStream(openRawResource, null, options);
                O000000o(openRawResource);
                int O000000o = (int) O000000o((float) options.outWidth, (float) options.outHeight, (float) O0000Oo, (float) O0000OoO);
                if (O000000o > 0) {
                    options.inSampleSize = O000000o;
                }
                options.inJustDecodeBounds = false;
                openRawResource2 = context.getResources().openRawResource(i);
            } catch (Exception e2) {
                e = e2;
                try {
                    com.umeng.socialize.utils.O0000O0o.O000000o(e);
                    O000000o(openRawResource);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    O000000o(openRawResource);
                    throw e;
                }
            }
            try {
                Bitmap O000000o2 = O000000o(BitmapFactory.decodeStream(openRawResource2, null, options), false);
                O000000o(openRawResource2);
                return O000000o2;
            } catch (Exception e3) {
                openRawResource = openRawResource2;
                e = e3;
                com.umeng.socialize.utils.O0000O0o.O000000o(e);
                O000000o(openRawResource);
                return null;
            } catch (Throwable e32) {
                openRawResource = openRawResource2;
                e = e32;
                O000000o(openRawResource);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            openRawResource = null;
            com.umeng.socialize.utils.O0000O0o.O000000o(e);
            O000000o(openRawResource);
            return null;
        } catch (Throwable th2) {
            e = th2;
            openRawResource = null;
            O000000o(openRawResource);
            throw e;
        }
    }

    private Bitmap O000000o(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float O000000o = O000000o((float) width, (float) height, (float) O0000Oo, (float) O0000OoO);
        if (O000000o < CropImageView.DEFAULT_ASPECT_RATIO) {
            return bitmap;
        }
        float f = 1.0f / O000000o;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        O00000Oo(bitmap);
        return createBitmap;
    }

    private Bitmap O000000o(Bitmap bitmap, boolean z) {
        if (this.O0000oO == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z) {
            try {
                bitmap = O000000o(bitmap);
            } catch (Exception e) {
                com.umeng.socialize.utils.O0000O0o.O000000o(e);
                return null;
            }
        }
        return this.O0000oO.O00000Oo(bitmap);
    }

    private Bitmap O000000o(byte[] bArr) {
        if (bArr == null || this.O0000oO == null) {
            return null;
        }
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int O000000o = (int) O000000o((float) options.outWidth, (float) options.outHeight, (float) O0000Oo, (float) O0000OoO);
            if (O000000o > 0) {
                options.inSampleSize = O000000o;
            }
            options.inJustDecodeBounds = false;
            return O000000o(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
        } catch (Exception e) {
            com.umeng.socialize.utils.O0000O0o.O000000o(e);
            return null;
        }
    }

    private void O000000o(Context context, Object obj) {
        O000000o(context, obj, null);
    }

    private void O000000o(Context context, Object obj, bn bnVar) {
        if (bnVar != null) {
            this.O0000oOo = true;
            this.O0000oO = bnVar;
            this.O0000oO.O000000o(context);
        }
        if (com.umeng.socialize.utils.O00000Oo.O000000o() == null) {
            com.umeng.socialize.utils.O00000Oo.O000000o(context.getApplicationContext());
        }
        if (obj instanceof File) {
            this.O0000oOO = O0000Ooo;
            this.O0000o = new O0000O0o((File) obj);
        } else if (obj instanceof String) {
            this.O0000oOO = O0000o00;
            this.O0000o = new O0000Oo((String) obj);
        } else {
            Bitmap bitmap = null;
            StringBuilder stringBuilder;
            if (obj instanceof Integer) {
                this.O0000oOO = O0000o0;
                if (O0000o0O()) {
                    bitmap = O000000o(context, ((Integer) obj).intValue());
                }
                if (bitmap != null) {
                    this.O0000o = new O00000Oo(bitmap);
                } else {
                    this.O0000o = new O0000Oo0(context.getApplicationContext(), ((Integer) obj).intValue());
                }
            } else if (obj instanceof byte[]) {
                this.O0000oOO = O0000o0o;
                if (O0000o0O()) {
                    bitmap = O000000o((byte[]) obj);
                }
                if (bitmap != null) {
                    this.O0000o = new O00000Oo(bitmap);
                } else {
                    this.O0000o = new O000000o((byte[]) obj);
                }
            } else if (obj instanceof Bitmap) {
                this.O0000oOO = O0000o0O;
                if (O0000o0O()) {
                    bitmap = O000000o((Bitmap) obj, true);
                }
                if (bitmap == null) {
                    bitmap = (Bitmap) obj;
                }
                this.O0000o = new O00000Oo(bitmap);
            } else if (obj != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(com.umeng.socialize.utils.O0000o00.O0000OOo.O0000o0);
                stringBuilder.append(obj.getClass().getSimpleName());
                com.umeng.socialize.utils.O0000O0o.O000000o(stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(com.umeng.socialize.utils.O0000o00.O0000OOo.O0000o0);
                stringBuilder.append("null");
                com.umeng.socialize.utils.O0000O0o.O000000o(stringBuilder.toString());
            }
        }
    }

    private void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                com.umeng.socialize.utils.O0000O0o.O000000o(e);
            }
        }
    }

    private void O00000Oo(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Exception e) {
                com.umeng.socialize.utils.O0000O0o.O000000o(e);
            }
        }
    }

    public void O000000o(O0000Oo o0000Oo) {
        this.O0000oO0 = o0000Oo;
    }

    public O0000Oo O00000o() {
        return this.O0000oO0;
    }

    public byte[] O0000O0o() {
        return O0000o00();
    }

    public final Map<String, Object> O0000OOo() {
        HashMap hashMap = new HashMap();
        if (O00000oO()) {
            hashMap.put(db.O0000oo, this.O00000Oo);
            hashMap.put(db.O0000ooO, O0000Oo0());
        }
        return hashMap;
    }

    public int O0000Oo() {
        return this.O0000oOO;
    }

    public com.umeng.socialize.media.UMediaObject.O000000o O0000Oo0() {
        return com.umeng.socialize.media.UMediaObject.O000000o.IMAGE;
    }

    public File O0000OoO() {
        return this.O0000o == null ? null : this.O0000o.O000000o();
    }

    public String O0000Ooo() {
        return this.O0000o == null ? null : this.O0000o.O00000Oo();
    }

    public Bitmap O0000o0() {
        return this.O0000o == null ? null : this.O0000o.O00000o();
    }

    public byte[] O0000o00() {
        return this.O0000o == null ? null : this.O0000o.O00000o0();
    }

    public boolean O0000o0O() {
        return this.O0000oOo;
    }
}
