package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: BitmapTransformation */
public abstract class O0000O0o implements O0OoOo<Bitmap> {
    private OO000OO O000000o;

    public O0000O0o(OO000OO oo000oo) {
        this.O000000o = oo000oo;
    }

    public O0000O0o(Context context) {
        this(O00Oo.O00000Oo(context).O00000o0());
    }

    public final Oo0OOo<Bitmap> O000000o(Oo0OOo<Bitmap> oo0OOo, int i, int i2) {
        if (oOOO000o.O000000o(i, i2)) {
            Bitmap bitmap = (Bitmap) oo0OOo.O00000Oo();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap O000000o = O000000o(this.O000000o, bitmap, i, i2);
            return bitmap.equals(O000000o) ? oo0OOo : O00000o.O000000o(O000000o, this.O000000o);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot apply transformation on width: ");
            stringBuilder.append(i);
            stringBuilder.append(" or height: ");
            stringBuilder.append(i2);
            stringBuilder.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public abstract Bitmap O000000o(OO000OO oo000oo, Bitmap bitmap, int i, int i2);
}
