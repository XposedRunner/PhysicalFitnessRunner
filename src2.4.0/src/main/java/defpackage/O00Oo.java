package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.O0000OOo;
import com.bumptech.glide.load.resource.bitmap.O0000Oo;
import com.bumptech.glide.load.resource.bitmap.O0000o;
import com.bumptech.glide.load.resource.bitmap.O0000o0;
import com.bumptech.glide.load.resource.bitmap.O000O0OO;
import com.bumptech.glide.load.resource.bitmap.O000O0o;
import defpackage.OOOo00.O000000o;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/* compiled from: Glide */
/* renamed from: O00Oo */
public class O00Oo {
    private static final String O000000o = "Glide";
    private static volatile O00Oo O00000Oo;
    private final O0Oo O00000o;
    private final OOO0OO0 O00000o0;
    private final OO000OO O00000oO;
    private final OO0OOo0 O00000oo;
    private final O0O0O O0000O0o;
    private final oO0O00Oo O0000OOo = new oO0O00Oo();
    private final oO0Oo0oo O0000Oo;
    private final oO0000Oo O0000Oo0 = new oO0000Oo();
    private final O0000OOo O0000OoO;
    private final o0OOoOO0 O0000Ooo;
    private final o0OOoOO0 O0000o0;
    private final O0000o0 O0000o00;
    private final Handler O0000o0O;
    private final OOO000o O0000o0o;

    /* compiled from: Glide */
    /* renamed from: O00Oo$O000000o */
    private static class O000000o extends ooOOO00O<View, Object> {
        public O000000o(View view) {
        }

        public void O000000o(Drawable drawable) {
        }

        public void O000000o(Exception exception, Drawable drawable) {
        }

        public void O000000o(Object obj, oO00OOOo<? super Object> oo00oooo) {
        }

        public void O00000Oo(Drawable drawable) {
        }
    }

    O00Oo(O0Oo o0Oo, OO0OOo0 oO0OOo0, OO000OO oo000oo, Context context, O0O0O o0o0o) {
        this.O00000o = o0Oo;
        this.O00000oO = oo000oo;
        this.O00000oo = oO0OOo0;
        this.O0000O0o = o0o0o;
        this.O00000o0 = new OOO0OO0(context);
        this.O0000o0O = new Handler(Looper.getMainLooper());
        this.O0000o0o = new OOO000o(oO0OOo0, oo000oo, o0o0o);
        this.O0000Oo = new oO0Oo0oo();
        O000O0o o000O0o = new O000O0o(oo000oo, o0o0o);
        this.O0000Oo.O000000o(InputStream.class, Bitmap.class, o000O0o);
        O0000Oo o0000Oo = new O0000Oo(oo000oo, o0o0o);
        this.O0000Oo.O000000o(ParcelFileDescriptor.class, Bitmap.class, o0000Oo);
        O000O0OO o000o0oo = new O000O0OO(o000O0o, o0000Oo);
        this.O0000Oo.O000000o(OOO.class, Bitmap.class, o000o0oo);
        o0oO0O0o o0oo0o0o = new o0oO0O0o(context, oo000oo);
        this.O0000Oo.O000000o(InputStream.class, o0O0O00O.class, o0oo0o0o);
        this.O0000Oo.O000000o(OOO.class, o0oOo0O0.class, new o0OO0o00(o000o0oo, o0oo0o0o, oo000oo));
        this.O0000Oo.O000000o(InputStream.class, File.class, new o0oO0Ooo());
        O000000o(File.class, ParcelFileDescriptor.class, new O000000o());
        O000000o(File.class, InputStream.class, new Oo0.O000000o());
        O000000o(Integer.TYPE, ParcelFileDescriptor.class, new o0ooo0OO.O000000o());
        O000000o(Integer.TYPE, InputStream.class, new o0000000.O000000o());
        O000000o(Integer.class, ParcelFileDescriptor.class, new o0ooo0OO.O000000o());
        O000000o(Integer.class, InputStream.class, new o0000000.O000000o());
        O000000o(String.class, ParcelFileDescriptor.class, new o0OOoOoo.O000000o());
        O000000o(String.class, InputStream.class, new o000000.O000000o());
        O000000o(Uri.class, ParcelFileDescriptor.class, new OOo0000.O000000o());
        O000000o(Uri.class, InputStream.class, new o00000.O000000o());
        O000000o(URL.class, InputStream.class, new o0000.O000000o());
        O000000o(OOO0oO.class, InputStream.class, new Oo00000.O000000o());
        O000000o(byte[].class, InputStream.class, new Oo00.O000000o());
        this.O0000Oo0.O000000o(Bitmap.class, O0000o.class, new o(context.getResources(), oo000oo));
        this.O0000Oo0.O000000o(o0oOo0O0.class, o0OoO00O.class, new o0OOo000(new o(context.getResources(), oo000oo)));
        this.O0000OoO = new O0000OOo(oo000oo);
        this.O0000Ooo = new o0OOoOO0(oo000oo, this.O0000OoO);
        this.O0000o00 = new O0000o0(oo000oo);
        this.O0000o0 = new o0OOoOO0(oo000oo, this.O0000o00);
    }

    public static O00o000 O000000o(Activity activity) {
        return com.bumptech.glide.manager.O0000o.O000000o().O000000o(activity);
    }

    @TargetApi(11)
    public static O00o000 O000000o(Fragment fragment) {
        return com.bumptech.glide.manager.O0000o.O000000o().O000000o(fragment);
    }

    public static O00o000 O000000o(android.support.v4.app.Fragment fragment) {
        return com.bumptech.glide.manager.O0000o.O000000o().O000000o(fragment);
    }

    public static O00o000 O000000o(FragmentActivity fragmentActivity) {
        return com.bumptech.glide.manager.O0000o.O000000o().O000000o(fragmentActivity);
    }

    public static <T> OOOO0OO<T, InputStream> O000000o(Class<T> cls, Context context) {
        return O00Oo.O000000o((Class) cls, InputStream.class, context);
    }

    public static <T, Y> OOOO0OO<T, Y> O000000o(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return O00Oo.O00000Oo(context).O0000o00().O00000Oo(cls, cls2);
        }
        if (Log.isLoggable(O000000o, 3)) {
            Log.d(O000000o, "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    public static <T> OOOO0OO<T, InputStream> O000000o(T t, Context context) {
        return O00Oo.O000000o((Object) t, InputStream.class, context);
    }

    public static <T, Y> OOOO0OO<T, Y> O000000o(T t, Class<Y> cls, Context context) {
        return O00Oo.O000000o(t != null ? t.getClass() : null, (Class) cls, context);
    }

    public static File O000000o(Context context) {
        return O00Oo.O000000o(context, OO00o00.O000000o.O00000o);
    }

    public static File O000000o(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            return (file.mkdirs() || (file.exists() && file.isDirectory())) ? file : null;
        } else {
            if (Log.isLoggable(O000000o, 6)) {
                Log.e(O000000o, "default disk cache dir is null");
            }
            return null;
        }
    }

    @Deprecated
    public static void O000000o(O00OoO0o o00OoO0o) {
        if (O00Oo.O000000o()) {
            throw new IllegalArgumentException("Glide is already setup, check with isSetup() first");
        }
        O00000Oo = o00OoO0o.O000000o();
    }

    public static void O000000o(View view) {
        O00Oo.O000000o(new O000000o(view));
    }

    public static void O000000o(oO000Oo0<?> oo000oo0) {
        oo000oo0.O000000o();
    }

    public static void O000000o(ooOOO0Oo<?> ooooo0oo) {
        oOOO000o.O000000o();
        oO0Oo0O0 b_ = ooooo0oo.b_();
        if (b_ != null) {
            b_.O00000o();
            ooooo0oo.O000000o(null);
        }
    }

    @Deprecated
    public static boolean O000000o() {
        return O00000Oo != null;
    }

    public static O00Oo O00000Oo(Context context) {
        if (O00000Oo == null) {
            synchronized (O00Oo.class) {
                if (O00000Oo == null) {
                    context = context.getApplicationContext();
                    List<oO000O0O> O000000o = new oO0Ooo00(context).O000000o();
                    O00OoO0o o00OoO0o = new O00OoO0o(context);
                    for (oO000O0O O000000o2 : O000000o) {
                        O000000o2.O000000o(context, o00OoO0o);
                    }
                    O00000Oo = o00OoO0o.O000000o();
                    for (oO000O0O O000000o3 : O000000o) {
                        O000000o3.O000000o(context, O00000Oo);
                    }
                }
            }
        }
        return O00000Oo;
    }

    public static <T> OOOO0OO<T, ParcelFileDescriptor> O00000Oo(Class<T> cls, Context context) {
        return O00Oo.O000000o((Class) cls, ParcelFileDescriptor.class, context);
    }

    public static <T> OOOO0OO<T, ParcelFileDescriptor> O00000Oo(T t, Context context) {
        return O00Oo.O000000o((Object) t, ParcelFileDescriptor.class, context);
    }

    static void O00000Oo() {
        O00000Oo = null;
    }

    public static O00o000 O00000o0(Context context) {
        return com.bumptech.glide.manager.O0000o.O000000o().O000000o(context);
    }

    private OOO0OO0 O0000o00() {
        return this.O00000o0;
    }

    /* Access modifiers changed, original: 0000 */
    public <Z, R> oO00000o<Z, R> O000000o(Class<Z> cls, Class<R> cls2) {
        return this.O0000Oo0.O000000o(cls, cls2);
    }

    /* Access modifiers changed, original: 0000 */
    public <R> ooOOO0Oo<R> O000000o(ImageView imageView, Class<R> cls) {
        return this.O0000OOo.O000000o(imageView, cls);
    }

    public void O000000o(int i) {
        oOOO000o.O000000o();
        this.O00000oo.O000000o(i);
        this.O00000oO.O000000o(i);
    }

    public void O000000o(O00Ooo00 o00Ooo00) {
        oOOO000o.O000000o();
        this.O00000oo.O000000o(o00Ooo00.O000000o());
        this.O00000oO.O000000o(o00Ooo00.O000000o());
    }

    public <T, Y> void O000000o(Class<T> cls, Class<Y> cls2, OOOO0o0<T, Y> oOOO0o0) {
        OOOO0o0 O000000o = this.O00000o0.O000000o((Class) cls, (Class) cls2, (OOOO0o0) oOOO0o0);
        if (O000000o != null) {
            O000000o.O000000o();
        }
    }

    public void O000000o(OOO00Oo.O000000o... o000000oArr) {
        this.O0000o0o.O000000o(o000000oArr);
    }

    /* Access modifiers changed, original: 0000 */
    public <T, Z> oO0OoOO0<T, Z> O00000Oo(Class<T> cls, Class<Z> cls2) {
        return this.O0000Oo.O000000o(cls, cls2);
    }

    /* Access modifiers changed, original: 0000 */
    public O0Oo O00000o() {
        return this.O00000o;
    }

    public OO000OO O00000o0() {
        return this.O00000oO;
    }

    @Deprecated
    public <T, Y> void O00000o0(Class<T> cls, Class<Y> cls2) {
        OOOO0o0 O000000o = this.O00000o0.O000000o(cls, cls2);
        if (O000000o != null) {
            O000000o.O000000o();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public O0000OOo O00000oO() {
        return this.O0000OoO;
    }

    /* Access modifiers changed, original: 0000 */
    public O0000o0 O00000oo() {
        return this.O0000o00;
    }

    /* Access modifiers changed, original: 0000 */
    public o0OOoOO0 O0000O0o() {
        return this.O0000Ooo;
    }

    /* Access modifiers changed, original: 0000 */
    public o0OOoOO0 O0000OOo() {
        return this.O0000o0;
    }

    /* Access modifiers changed, original: 0000 */
    public O0O0O O0000Oo() {
        return this.O0000O0o;
    }

    /* Access modifiers changed, original: 0000 */
    public Handler O0000Oo0() {
        return this.O0000o0O;
    }

    public void O0000OoO() {
        oOOO000o.O000000o();
        this.O00000oo.O00000o0();
        this.O00000oO.O00000Oo();
    }

    public void O0000Ooo() {
        oOOO000o.O00000Oo();
        O00000o().O000000o();
    }
}
