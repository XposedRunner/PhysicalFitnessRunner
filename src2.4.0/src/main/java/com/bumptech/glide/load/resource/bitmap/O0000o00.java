package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* compiled from: FileDescriptorBitmapDecoder */
public class O0000o00 implements O0O0o00<ParcelFileDescriptor, Bitmap> {
    private final O000OO O000000o;
    private final OO000OO O00000Oo;
    private O0O0O O00000o0;

    public O0000o00(OO000OO oo000oo, O0O0O o0o0o) {
        this(new O000OO(), oo000oo, o0o0o);
    }

    public O0000o00(Context context) {
        this(O00Oo.O00000Oo(context).O00000o0(), O0O0O.O00000o);
    }

    public O0000o00(Context context, O0O0O o0o0o) {
        this(O00Oo.O00000Oo(context).O00000o0(), o0o0o);
    }

    public O0000o00(O000OO o000oo, OO000OO oo000oo, O0O0O o0o0o) {
        this.O000000o = o000oo;
        this.O00000Oo = oo000oo;
        this.O00000o0 = o0o0o;
    }

    public Oo0OOo<Bitmap> O000000o(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) throws IOException {
        return O00000o.O000000o(this.O000000o.O000000o(parcelFileDescriptor, this.O00000Oo, i, i2, this.O00000o0), this.O00000Oo);
    }

    public String O000000o() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
