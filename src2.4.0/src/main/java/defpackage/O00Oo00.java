package defpackage;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.manager.O0000Oo0;
import com.bumptech.glide.manager.O000O00o;
import defpackage.O00o000.O00000o;
import java.io.File;
import java.io.InputStream;

/* compiled from: DrawableTypeRequest */
/* renamed from: O00Oo00 */
public class O00Oo00<ModelType> extends O00OOo<ModelType> implements O00OOOo {
    private final OOOO0OO<ModelType, InputStream> O0000O0o;
    private final OOOO0OO<ModelType, ParcelFileDescriptor> O0000OOo;
    private final O00000o O0000Oo0;

    O00Oo00(Class<ModelType> cls, OOOO0OO<ModelType, InputStream> oooo0oo, OOOO0OO<ModelType, ParcelFileDescriptor> oooo0oo2, Context context, O00Oo o00Oo, O000O00o o000O00o, O0000Oo0 o0000Oo0, O00000o o00000o) {
        ooOOOOoo O000000o = O00Oo00.O000000o(o00Oo, oooo0oo, oooo0oo2, o0oOo0O0.class, o0OoO00O.class, null);
        super(context, cls, O000000o, o00Oo, o000O00o, o0000Oo0);
        this.O0000O0o = oooo0oo;
        this.O0000OOo = oooo0oo2;
        this.O0000Oo0 = o00000o;
    }

    private static <A, Z, R> ooOOOOoo<A, OOO, Z, R> O000000o(O00Oo o00Oo, OOOO0OO<A, InputStream> oooo0oo, OOOO0OO<A, ParcelFileDescriptor> oooo0oo2, Class<Z> cls, Class<R> cls2, oO00000o<Z, R> oo00000o) {
        if (oooo0oo == null && oooo0oo2 == null) {
            return null;
        }
        oO00000o oo00000o2;
        if (oo00000o2 == null) {
            oo00000o2 = o00Oo.O000000o((Class) cls, (Class) cls2);
        }
        return new ooOOOOoo(new OOO0o0(oooo0oo, oooo0oo2), oo00000o2, o00Oo.O00000Oo(OOO.class, (Class) cls));
    }

    private O00Oo0<ModelType, InputStream, File> O0000oO0() {
        return (O00Oo0) this.O0000Oo0.O000000o(new O00Oo0(File.class, this, this.O0000O0o, InputStream.class, File.class, this.O0000Oo0));
    }

    public oO000Oo0<File> O000000o(int i, int i2) {
        return O0000oO0().O000000o(i, i2);
    }

    public <Y extends ooOOO0Oo<File>> Y O000000o(Y y) {
        return O0000oO0().O000000o(y);
    }

    public O00OO0O<ModelType> O0000Oo() {
        return (O00OO0O) this.O0000Oo0.O000000o(new O00OO0O(this, this.O0000O0o, this.O0000OOo, this.O0000Oo0));
    }

    public O00Oo0o0<ModelType> O0000o0o() {
        return (O00Oo0o0) this.O0000Oo0.O000000o(new O00Oo0o0(this, this.O0000O0o, this.O0000Oo0));
    }
}
