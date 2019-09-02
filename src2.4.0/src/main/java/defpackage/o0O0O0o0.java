package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

/* compiled from: GifFrameLoader */
/* renamed from: o0O0O0o0 */
class o0O0O0o0 {
    private final O00000Oo O000000o;
    private final O00o O00000Oo;
    private boolean O00000o;
    private final Handler O00000o0;
    private boolean O00000oO;
    private O00Oo00o<O00o, O00o, Bitmap, Bitmap> O00000oo;
    private O000000o O0000O0o;
    private boolean O0000OOo;

    /* compiled from: GifFrameLoader */
    /* renamed from: o0O0O0o0$O00000Oo */
    public interface O00000Oo {
        void O00000Oo(int i);
    }

    /* compiled from: GifFrameLoader */
    /* renamed from: o0O0O0o0$O000000o */
    static class O000000o extends oOo0oooO<Bitmap> {
        private final Handler O00000Oo;
        private final long O00000o;
        private final int O00000o0;
        private Bitmap O00000oO;

        public O000000o(Handler handler, int i, long j) {
        }

        public Bitmap O000000o() {
            return null;
        }

        public void O000000o(Bitmap bitmap, oO00OOOo<? super Bitmap> oo00oooo) {
        }
    }

    /* compiled from: GifFrameLoader */
    /* renamed from: o0O0O0o0$O00000o0 */
    private class O00000o0 implements Callback {
        public static final int O000000o = 1;
        public static final int O00000Oo = 2;
        final /* synthetic */ o0O0O0o0 O00000o0;

        private O00000o0(o0O0O0o0 o0o0o0o0) {
        }

        /* synthetic */ O00000o0(o0O0O0o0 o0o0o0o0, 1 1) {
        }

        public boolean handleMessage(Message message) {
            return false;
        }
    }

    /* compiled from: GifFrameLoader */
    /* renamed from: o0O0O0o0$O00000o */
    static class O00000o implements O0O0OO {
        private final UUID O00000Oo;

        O00000o(UUID uuid) {
        }

        public void O000000o(MessageDigest messageDigest) throws UnsupportedEncodingException {
        }

        public boolean equals(Object obj) {
            return false;
        }

        public int hashCode() {
            return 0;
        }
    }

    public o0O0O0o0(Context context, O00000Oo o00000Oo, O00o o00o, int i, int i2) {
    }

    o0O0O0o0(O00000Oo o00000Oo, O00o o00o, Handler handler, O00Oo00o<O00o, O00o, Bitmap, Bitmap> o00Oo00o) {
    }

    private static O00Oo00o<O00o, O00o, Bitmap, Bitmap> O000000o(Context context, O00o o00o, int i, int i2, OO000OO oo000oo) {
        return null;
    }

    private void O00000oO() {
    }

    public void O000000o() {
    }

    public void O000000o(O0OoOo<Bitmap> o0OoOo) {
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(O000000o o000000o) {
    }

    public void O00000Oo() {
    }

    public Bitmap O00000o() {
        return null;
    }

    public void O00000o0() {
    }
}
