package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder */
public class O000OO00 implements O0O0o00<InputStream, Bitmap> {
    private static final String O000000o = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    private final O0000Oo0 O00000Oo;
    private O0O0O O00000o;
    private OO000OO O00000o0;
    private String O00000oO;

    public O000OO00(OO000OO oo000oo) {
        this(oo000oo, O0O0O.O00000o);
    }

    public O000OO00(OO000OO oo000oo, O0O0O o0o0o) {
        this(O0000Oo0.O000000o, oo000oo, o0o0o);
    }

    public O000OO00(Context context) {
        this(O00Oo.O00000Oo(context).O00000o0());
    }

    public O000OO00(Context context, O0O0O o0o0o) {
        this(O00Oo.O00000Oo(context).O00000o0(), o0o0o);
    }

    public O000OO00(O0000Oo0 o0000Oo0, OO000OO oo000oo, O0O0O o0o0o) {
        this.O00000Oo = o0000Oo0;
        this.O00000o0 = oo000oo;
        this.O00000o = o0o0o;
    }

    public Oo0OOo<Bitmap> O000000o(InputStream inputStream, int i, int i2) {
        return O00000o.O000000o(this.O00000Oo.O000000o(inputStream, this.O00000o0, i, i2, this.O00000o), this.O00000o0);
    }

    public String O000000o() {
        if (this.O00000oO == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o);
            stringBuilder.append(this.O00000Oo.O000000o());
            stringBuilder.append(this.O00000o.name());
            this.O00000oO = stringBuilder.toString();
        }
        return this.O00000oO;
    }
}
