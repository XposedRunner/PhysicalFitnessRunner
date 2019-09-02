package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* compiled from: BitmapResource */
public class O00000o implements Oo0OOo<Bitmap> {
    private final Bitmap O000000o;
    private final OO000OO O00000Oo;

    public O00000o(Bitmap bitmap, OO000OO oo000oo) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (oo000oo == null) {
            throw new NullPointerException("BitmapPool must not be null");
        } else {
            this.O000000o = bitmap;
            this.O00000Oo = oo000oo;
        }
    }

    public static O00000o O000000o(Bitmap bitmap, OO000OO oo000oo) {
        return bitmap == null ? null : new O00000o(bitmap, oo000oo);
    }

    /* renamed from: O000000o */
    public Bitmap O00000Oo() {
        return this.O000000o;
    }

    public void O00000o() {
        if (!this.O00000Oo.O000000o(this.O000000o)) {
            this.O000000o.recycle();
        }
    }

    public int O00000o0() {
        return oOOO000o.O00000Oo(this.O000000o);
    }
}
