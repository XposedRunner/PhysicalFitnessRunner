package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoDataLoadProvider */
public class O000O0OO implements oO0OoOO0<OOO, Bitmap> {
    private final O000O00o O000000o;
    private final O0O0o00<File, Bitmap> O00000Oo;
    private final OOOO00O O00000o;
    private final O0O0o0<Bitmap> O00000o0;

    public O000O0OO(oO0OoOO0<InputStream, Bitmap> oo0oooo0, oO0OoOO0<ParcelFileDescriptor, Bitmap> oo0oooo02) {
        this.O00000o0 = oo0oooo0.O00000o();
        this.O00000o = new OOOO00O(oo0oooo0.O00000o0(), oo0oooo02.O00000o0());
        this.O00000Oo = oo0oooo0.O000000o();
        this.O000000o = new O000O00o(oo0oooo0.O00000Oo(), oo0oooo02.O00000Oo());
    }

    public O0O0o00<File, Bitmap> O000000o() {
        return this.O00000Oo;
    }

    public O0O0o00<OOO, Bitmap> O00000Oo() {
        return this.O000000o;
    }

    public O0O0o0<Bitmap> O00000o() {
        return this.O00000o0;
    }

    public O0O0OO0<OOO> O00000o0() {
        return this.O00000o;
    }
}
