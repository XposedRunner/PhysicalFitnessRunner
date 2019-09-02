package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* compiled from: StreamBitmapDataLoadProvider */
public class O000O0o implements oO0OoOO0<InputStream, Bitmap> {
    private final O000OO00 O000000o;
    private final O00000o0 O00000Oo;
    private final o0O00Oo0<Bitmap> O00000o;
    private final OOOOO0o O00000o0 = new OOOOO0o();

    public O000O0o(OO000OO oo000oo, O0O0O o0o0o) {
        this.O000000o = new O000OO00(oo000oo, o0o0o);
        this.O00000Oo = new O00000o0();
        this.O00000o = new o0O00Oo0(this.O000000o);
    }

    public O0O0o00<File, Bitmap> O000000o() {
        return this.O00000o;
    }

    public O0O0o00<InputStream, Bitmap> O00000Oo() {
        return this.O000000o;
    }

    public O0O0o0<Bitmap> O00000o() {
        return this.O00000Oo;
    }

    public O0O0OO0<InputStream> O00000o0() {
        return this.O00000o0;
    }
}
