package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.ParcelFileDescriptor;
import defpackage.O00o000.O00000o;
import java.io.InputStream;

/* compiled from: BitmapTypeRequest */
/* renamed from: O00OO0O */
public class O00OO0O<ModelType> extends O00O0o<ModelType, Bitmap> {
    private final OOOO0OO<ModelType, InputStream> O0000O0o;
    private final OOOO0OO<ModelType, ParcelFileDescriptor> O0000OOo;
    private final O00000o O0000Oo;
    private final O00Oo O0000Oo0;

    O00OO0O(O00Oo00o<ModelType, ?, ?, ?> o00Oo00o, OOOO0OO<ModelType, InputStream> oooo0oo, OOOO0OO<ModelType, ParcelFileDescriptor> oooo0oo2, O00000o o00000o) {
        super(O00OO0O.O000000o(o00Oo00o.O00000o0, oooo0oo, oooo0oo2, Bitmap.class, null), Bitmap.class, o00Oo00o);
        this.O0000O0o = oooo0oo;
        this.O0000OOo = oooo0oo2;
        this.O0000Oo0 = o00Oo00o.O00000o0;
        this.O0000Oo = o00000o;
    }

    private static <A, R> ooOOOOoo<A, OOO, Bitmap, R> O000000o(O00Oo o00Oo, OOOO0OO<A, InputStream> oooo0oo, OOOO0OO<A, ParcelFileDescriptor> oooo0oo2, Class<R> cls, oO00000o<Bitmap, R> oo00000o) {
        if (oooo0oo == null && oooo0oo2 == null) {
            return null;
        }
        oO00000o oo00000o2;
        if (oo00000o2 == null) {
            oo00000o2 = o00Oo.O000000o(Bitmap.class, (Class) cls);
        }
        return new ooOOOOoo(new OOO0o0(oooo0oo, oooo0oo2), oo00000o2, o00Oo.O00000Oo(OOO.class, Bitmap.class));
    }

    public O00O0o<ModelType, byte[]> O000000o(CompressFormat compressFormat, int i) {
        return O000000o(new o0OOOO00(compressFormat, i), byte[].class);
    }

    public <R> O00O0o<ModelType, R> O000000o(oO00000o<Bitmap, R> oo00000o, Class<R> cls) {
        return (O00O0o) this.O0000Oo.O000000o(new O00O0o(O00OO0O.O000000o(this.O0000Oo0, this.O0000O0o, this.O0000OOo, cls, oo00000o), cls, this));
    }

    public O00O0o<ModelType, byte[]> O0000o0o() {
        return O000000o(new o0OOOO00(), byte[].class);
    }
}
