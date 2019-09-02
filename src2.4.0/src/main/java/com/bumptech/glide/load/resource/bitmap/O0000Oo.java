package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* compiled from: FileDescriptorBitmapDataLoadProvider */
public class O0000Oo implements oO0OoOO0<ParcelFileDescriptor, Bitmap> {
    private final O0O0o00<File, Bitmap> O000000o;
    private final O0000o00 O00000Oo;
    private final O0O0OO0<ParcelFileDescriptor> O00000o = o00.O00000Oo();
    private final O00000o0 O00000o0 = new O00000o0();

    public O0000Oo(OO000OO oo000oo, O0O0O o0o0o) {
        this.O000000o = new o0O00Oo0(new O000OO00(oo000oo, o0o0o));
        this.O00000Oo = new O0000o00(oo000oo, o0o0o);
    }

    public O0O0o00<File, Bitmap> O000000o() {
        return this.O000000o;
    }

    public O0O0o00<ParcelFileDescriptor, Bitmap> O00000Oo() {
        return this.O00000Oo;
    }

    public O0O0o0<Bitmap> O00000o() {
        return this.O00000o0;
    }

    public O0O0OO0<ParcelFileDescriptor> O00000o0() {
        return this.O00000o;
    }
}
