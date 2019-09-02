package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* compiled from: VideoBitmapDecoder */
public class O000OO implements O000000o<ParcelFileDescriptor> {
    private static final O000000o O000000o = new O000000o();
    private static final int O00000Oo = -1;
    private int O00000o;
    private O000000o O00000o0;

    /* compiled from: VideoBitmapDecoder */
    static class O000000o {
        O000000o() {
        }

        public MediaMetadataRetriever O000000o() {
            return new MediaMetadataRetriever();
        }
    }

    public O000OO() {
        this(O000000o, -1);
    }

    public O000OO(int i) {
        this(O000000o, O000000o(i));
    }

    O000OO(O000000o o000000o) {
        this(o000000o, -1);
    }

    O000OO(O000000o o000000o, int i) {
        this.O00000o0 = o000000o;
        this.O00000o = i;
    }

    private static int O000000o(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException("Requested frame must be non-negative");
    }

    public Bitmap O000000o(ParcelFileDescriptor parcelFileDescriptor, OO000OO oo000oo, int i, int i2, O0O0O o0o0o) throws IOException {
        MediaMetadataRetriever O000000o = this.O00000o0.O000000o();
        O000000o.setDataSource(parcelFileDescriptor.getFileDescriptor());
        Bitmap frameAtTime = this.O00000o >= 0 ? O000000o.getFrameAtTime((long) this.O00000o) : O000000o.getFrameAtTime();
        O000000o.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public String O000000o() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
