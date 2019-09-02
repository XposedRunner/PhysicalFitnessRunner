package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.manager.O00000o;
import com.bumptech.glide.manager.O00000o0;
import com.bumptech.glide.manager.O00000o0.O000000o;
import com.bumptech.glide.manager.O0000Oo;
import com.bumptech.glide.manager.O0000Oo0;
import com.bumptech.glide.manager.O000O00o;
import com.bumptech.glide.manager.O00oOooO;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

/* compiled from: RequestManager */
/* renamed from: O00o000 */
public class O00o000 implements O0000Oo {
    private final Context O000000o;
    private final O0000Oo0 O00000Oo;
    private final O000O00o O00000o;
    private final O00oOooO O00000o0;
    private final O00Oo O00000oO;
    private final O00000o O00000oo;
    private O000000o O0000O0o;

    /* compiled from: RequestManager */
    /* renamed from: O00o000$1 */
    class 1 implements Runnable {
        final /* synthetic */ O0000Oo0 O000000o;
        final /* synthetic */ O00o000 O00000Oo;

        1(O00o000 o00o000, O0000Oo0 o0000Oo0) {
        }

        public void run() {
        }
    }

    /* compiled from: RequestManager */
    /* renamed from: O00o000$O000000o */
    public interface O000000o {
        <T> void O000000o(O00Oo00o<T, ?, ?, ?> o00Oo00o);
    }

    /* compiled from: RequestManager */
    /* renamed from: O00o000$O00000Oo */
    public final class O00000Oo<A, T> {
        final /* synthetic */ O00o000 O000000o;
        private final OOOO0OO<A, T> O00000Oo;
        private final Class<T> O00000o0;

        /* compiled from: RequestManager */
        /* renamed from: O00o000$O00000Oo$O000000o */
        public final class O000000o {
            final /* synthetic */ O00000Oo O000000o;
            private final A O00000Oo;
            private final boolean O00000o;
            private final Class<A> O00000o0;

            O000000o(O00000Oo o00000Oo, Class<A> cls) {
            }

            O000000o(O00000Oo o00000Oo, A a) {
            }

            public <Z> O00Oo0<A, T, Z> O000000o(Class<Z> cls) {
                return null;
            }
        }

        O00000Oo(O00o000 o00o000, OOOO0OO<A, T> oooo0oo, Class<T> cls) {
        }

        public O000000o O000000o(Class<A> cls) {
            return null;
        }

        public O000000o O000000o(A a) {
            return null;
        }
    }

    /* compiled from: RequestManager */
    /* renamed from: O00o000$O00000o0 */
    public final class O00000o0<T> {
        final /* synthetic */ O00o000 O000000o;
        private final OOOO0OO<T, InputStream> O00000Oo;

        O00000o0(O00o000 o00o000, OOOO0OO<T, InputStream> oooo0oo) {
        }

        public O00Oo00<T> O000000o(Class<T> cls) {
            return null;
        }

        public O00Oo00<T> O000000o(T t) {
            return null;
        }
    }

    /* compiled from: RequestManager */
    /* renamed from: O00o000$O00000o */
    class O00000o {
        final /* synthetic */ O00o000 O000000o;

        O00000o(O00o000 o00o000) {
        }

        public <A, X extends O00Oo00o<A, ?, ?, ?>> X O000000o(X x) {
            return null;
        }
    }

    /* compiled from: RequestManager */
    /* renamed from: O00o000$O0000O0o */
    private static class O0000O0o implements O000000o {
        private final O000O00o O000000o;

        public O0000O0o(O000O00o o000O00o) {
        }

        public void O000000o(boolean z) {
        }
    }

    /* compiled from: RequestManager */
    /* renamed from: O00o000$O0000OOo */
    public final class O0000OOo<T> {
        final /* synthetic */ O00o000 O000000o;
        private final OOOO0OO<T, ParcelFileDescriptor> O00000Oo;

        O0000OOo(O00o000 o00o000, OOOO0OO<T, ParcelFileDescriptor> oooo0oo) {
        }

        public O00Oo00<T> O000000o(T t) {
            return null;
        }
    }

    public O00o000(Context context, O0000Oo0 o0000Oo0, O00oOooO o00oOooO) {
        this(context, o0000Oo0, o00oOooO, new O000O00o(), new O00000o());
    }

    O00o000(Context context, O0000Oo0 o0000Oo0, O00oOooO o00oOooO, O000O00o o000O00o, O00000o o00000o) {
        this.O000000o = context.getApplicationContext();
        this.O00000Oo = o0000Oo0;
        this.O00000o0 = o00oOooO;
        this.O00000o = o000O00o;
        this.O00000oO = O00Oo.O00000Oo(context);
        this.O00000oo = new O00000o(this);
        O00000o0 O000000o = o00000o.O000000o(context, new O0000O0o(o000O00o));
        if (oOOO000o.O00000o()) {
            new Handler(Looper.getMainLooper()).post(new 1(this, o0000Oo0));
        } else {
            o0000Oo0.O000000o(this);
        }
        o0000Oo0.O000000o(O000000o);
    }

    private <T> O00Oo00<T> O00000Oo(Class<T> cls) {
        OOOO0OO O000000o = O00Oo.O000000o((Class) cls, this.O000000o);
        OOOO0OO O00000Oo = O00Oo.O00000Oo((Class) cls, this.O000000o);
        if (cls != null && O000000o == null && O00000Oo == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown type ");
            stringBuilder.append(cls);
            stringBuilder.append(". You must provide a Model of a type for");
            stringBuilder.append(" which there is a registered ModelLoader, if you are using a custom model, you must first call");
            stringBuilder.append(" Glide#register with a ModelLoaderFactory for your custom model class");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (O00Oo00) this.O00000oo.O000000o(new O00Oo00(cls, O000000o, O00000Oo, this.O000000o, this.O00000oO, this.O00000o, this.O00000Oo, this.O00000oo));
    }

    private static <T> Class<T> O00000o0(T t) {
        return t != null ? t.getClass() : null;
    }

    public O00Oo00<Uri> O000000o(Uri uri) {
        return (O00Oo00) O0000OoO().O00000Oo((Object) uri);
    }

    @Deprecated
    public O00Oo00<Uri> O000000o(Uri uri, String str, long j, int i) {
        return (O00Oo00) O00000Oo(uri).O00000Oo((O0O0OO) new oOO00000(str, j, i));
    }

    public O00Oo00<File> O000000o(File file) {
        return (O00Oo00) O0000o00().O00000Oo((Object) file);
    }

    public <T> O00Oo00<T> O000000o(Class<T> cls) {
        return O00000Oo((Class) cls);
    }

    public O00Oo00<Integer> O000000o(Integer num) {
        return (O00Oo00) O0000o0().O00000Oo((Object) num);
    }

    public <T> O00Oo00<T> O000000o(T t) {
        return (O00Oo00) O00000Oo(O00o000.O00000o0((Object) t)).O00000Oo((Object) t);
    }

    public O00Oo00<String> O000000o(String str) {
        return (O00Oo00) O0000Oo().O00000Oo((Object) str);
    }

    @Deprecated
    public O00Oo00<URL> O000000o(URL url) {
        return (O00Oo00) O0000o0O().O00000Oo((Object) url);
    }

    public O00Oo00<byte[]> O000000o(byte[] bArr) {
        return (O00Oo00) O0000o0o().O00000Oo((Object) bArr);
    }

    @Deprecated
    public O00Oo00<byte[]> O000000o(byte[] bArr, String str) {
        return (O00Oo00) O000000o(bArr).O00000Oo((O0O0OO) new ooooOO00(str));
    }

    public <A, T> O00000Oo<A, T> O000000o(OOOO0OO<A, T> oooo0oo, Class<T> cls) {
        return new O00000Oo(this, oooo0oo, cls);
    }

    public O00000o0<byte[]> O000000o(Oo00 oo00) {
        return new O00000o0(this, oo00);
    }

    public <T> O00000o0<T> O000000o(Oo<T> oo) {
        return new O00000o0(this, oo);
    }

    public <T> O0000OOo<T> O000000o(OOOo<T> oOOo) {
        return new O0000OOo(this, oOOo);
    }

    public void O000000o() {
        this.O00000oO.O0000OoO();
    }

    public void O000000o(int i) {
        this.O00000oO.O000000o(i);
    }

    public void O000000o(O000000o o000000o) {
        this.O0000O0o = o000000o;
    }

    public O00Oo00<Uri> O00000Oo(Uri uri) {
        return (O00Oo00) O0000Ooo().O00000Oo((Object) uri);
    }

    public boolean O00000Oo() {
        oOOO000o.O000000o();
        return this.O00000o.O000000o();
    }

    public void O00000o() {
        oOOO000o.O000000o();
        O00000o0();
        for (O00o000 O00000o0 : this.O00000o0.O000000o()) {
            O00000o0.O00000o0();
        }
    }

    public void O00000o0() {
        oOOO000o.O000000o();
        this.O00000o.O00000Oo();
    }

    public void O00000oO() {
        oOOO000o.O000000o();
        this.O00000o.O00000o0();
    }

    public void O00000oo() {
        oOOO000o.O000000o();
        O00000oO();
        for (O00o000 O00000oO : this.O00000o0.O000000o()) {
            O00000oO.O00000oO();
        }
    }

    public void O0000O0o() {
        O00000oO();
    }

    public void O0000OOo() {
        O00000o0();
    }

    public O00Oo00<String> O0000Oo() {
        return O00000Oo(String.class);
    }

    public void O0000Oo0() {
        this.O00000o.O00000o();
    }

    public O00Oo00<Uri> O0000OoO() {
        return O00000Oo(Uri.class);
    }

    public O00Oo00<Uri> O0000Ooo() {
        return (O00Oo00) this.O00000oo.O000000o(new O00Oo00(Uri.class, new Oo000(this.O000000o, O00Oo.O000000o(Uri.class, this.O000000o)), O00Oo.O00000Oo(Uri.class, this.O000000o), this.O000000o, this.O00000oO, this.O00000o, this.O00000Oo, this.O00000oo));
    }

    public O00Oo00<Integer> O0000o0() {
        return (O00Oo00) O00000Oo(Integer.class).O00000Oo(oO0o0000.O000000o(this.O000000o));
    }

    public O00Oo00<File> O0000o00() {
        return O00000Oo(File.class);
    }

    @Deprecated
    public O00Oo00<URL> O0000o0O() {
        return O00000Oo(URL.class);
    }

    public O00Oo00<byte[]> O0000o0o() {
        return (O00Oo00) O00000Oo(byte[].class).O00000Oo((O0O0OO) new ooooOO00(UUID.randomUUID().toString())).O00000Oo(O0Oo0.NONE).O00000Oo(true);
    }
}
