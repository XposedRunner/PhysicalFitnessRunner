package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: ImageVideoBitmapDecoder */
public class O000O00o implements O0O0o00<OOO, Bitmap> {
    private static final String O000000o = "ImageVideoDecoder";
    private final O0O0o00<InputStream, Bitmap> O00000Oo;
    private final O0O0o00<ParcelFileDescriptor, Bitmap> O00000o0;

    public O000O00o(O0O0o00<InputStream, Bitmap> o0O0o00, O0O0o00<ParcelFileDescriptor, Bitmap> o0O0o002) {
        this.O00000Oo = o0O0o00;
        this.O00000o0 = o0O0o002;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    public Oo0OOo<android.graphics.Bitmap> O000000o(OOO r4, int r5, int r6) throws java.io.IOException {
        /*
        r3 = this;
        r0 = r4.O000000o();
        if (r0 == 0) goto L_0x001e;
    L_0x0006:
        r1 = r3.O00000Oo;	 Catch:{ IOException -> 0x000d }
        r0 = r1.O000000o(r0, r5, r6);	 Catch:{ IOException -> 0x000d }
        goto L_0x001f;
    L_0x000d:
        r0 = move-exception;
        r1 = "ImageVideoDecoder";
        r2 = 2;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x001e;
    L_0x0017:
        r1 = "ImageVideoDecoder";
        r2 = "Failed to load image from stream, trying FileDescriptor";
        android.util.Log.v(r1, r2, r0);
    L_0x001e:
        r0 = 0;
    L_0x001f:
        if (r0 != 0) goto L_0x002d;
    L_0x0021:
        r4 = r4.O00000Oo();
        if (r4 == 0) goto L_0x002d;
    L_0x0027:
        r0 = r3.O00000o0;
        r0 = r0.O000000o(r4, r5, r6);
    L_0x002d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.O000O00o.O000000o(OOO, int, int):Oo0OOo");
    }

    public String O000000o() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
