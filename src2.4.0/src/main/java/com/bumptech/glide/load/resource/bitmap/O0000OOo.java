package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: CenterCrop */
public class O0000OOo extends O0000O0o {
    public O0000OOo(OO000OO oo000oo) {
        super(oo000oo);
    }

    public O0000OOo(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected */
    public Bitmap O000000o(OO000OO oo000oo, Bitmap bitmap, int i, int i2) {
        Bitmap O000000o = oo000oo.O000000o(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        bitmap = O000OO0o.O000000o(O000000o, bitmap, i, i2);
        if (!(O000000o == null || O000000o == bitmap || oo000oo.O000000o(O000000o))) {
            O000000o.recycle();
        }
        return bitmap;
    }

    public String O000000o() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
