package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import java.io.OutputStream;

/* compiled from: BitmapEncoder */
public class O00000o0 implements O0O0o0<Bitmap> {
    private static final String O000000o = "BitmapEncoder";
    private static final int O00000Oo = 90;
    private int O00000o;
    private CompressFormat O00000o0;

    public O00000o0() {
        this(null, 90);
    }

    public O00000o0(CompressFormat compressFormat, int i) {
        this.O00000o0 = compressFormat;
        this.O00000o = i;
    }

    private CompressFormat O000000o(Bitmap bitmap) {
        return this.O00000o0 != null ? this.O00000o0 : bitmap.hasAlpha() ? CompressFormat.PNG : CompressFormat.JPEG;
    }

    public String O000000o() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    public boolean O000000o(Oo0OOo<Bitmap> oo0OOo, OutputStream outputStream) {
        Bitmap bitmap = (Bitmap) oo0OOo.O00000Oo();
        long O000000o = oOO0OO0O.O000000o();
        CompressFormat O000000o2 = O000000o(bitmap);
        bitmap.compress(O000000o2, this.O00000o, outputStream);
        if (Log.isLoggable(O000000o, 2)) {
            String str = O000000o;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Compressed with type: ");
            stringBuilder.append(O000000o2);
            stringBuilder.append(" of size ");
            stringBuilder.append(oOOO000o.O00000Oo(bitmap));
            stringBuilder.append(" in ");
            stringBuilder.append(oOO0OO0O.O000000o(O000000o));
            Log.v(str, stringBuilder.toString());
        }
        return true;
    }
}
