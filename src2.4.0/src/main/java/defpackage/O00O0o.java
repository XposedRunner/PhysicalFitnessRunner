package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.O0000O0o;
import com.bumptech.glide.load.resource.bitmap.O0000Oo0;
import com.bumptech.glide.load.resource.bitmap.O0000o00;
import com.bumptech.glide.load.resource.bitmap.O000O00o;
import com.bumptech.glide.load.resource.bitmap.O000OO;
import com.bumptech.glide.load.resource.bitmap.O000OO00;
import defpackage.oO0OO000.O000000o;
import java.io.File;
import java.io.InputStream;

/* compiled from: BitmapRequestBuilder */
/* renamed from: O00O0o */
public class O00O0o<ModelType, TranscodeType> extends O00Oo00o<ModelType, OOO, Bitmap, TranscodeType> implements O00O0o0 {
    private final OO000OO O0000O0o;
    private O0000Oo0 O0000OOo = O0000Oo0.O000000o;
    private O0O0o00<InputStream, Bitmap> O0000Oo;
    private O0O0O O0000Oo0;
    private O0O0o00<ParcelFileDescriptor, Bitmap> O0000OoO;

    O00O0o(oO0OOo0o<ModelType, OOO, Bitmap, TranscodeType> oo0ooo0o, Class<TranscodeType> cls, O00Oo00o<ModelType, ?, ?, ?> o00Oo00o) {
        super(oo0ooo0o, cls, o00Oo00o);
        this.O0000O0o = o00Oo00o.O00000o0.O00000o0();
        this.O0000Oo0 = o00Oo00o.O00000o0.O0000Oo();
        this.O0000Oo = new O000OO00(this.O0000O0o, this.O0000Oo0);
        this.O0000OoO = new O0000o00(this.O0000O0o, this.O0000Oo0);
    }

    private O00O0o<ModelType, TranscodeType> O000000o(O0000Oo0 o0000Oo0) {
        this.O0000OOo = o0000Oo0;
        this.O0000Oo = new O000OO00(o0000Oo0, this.O0000O0o, this.O0000Oo0);
        super.O00000oo(new O000O00o(this.O0000Oo, this.O0000OoO));
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000o(float f) {
        super.O00000o(f);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O0000OOo(int i) {
        super.O0000OOo(i);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(int i, int i2) {
        super.O00000Oo(i, i2);
        return this;
    }

    public O00O0o<ModelType, TranscodeType> O000000o(O00O0o<?, TranscodeType> o00O0o) {
        super.O00000Oo((O00Oo00o) o00O0o);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(O00Oo00o<?, ?, ?, TranscodeType> o00Oo00o) {
        super.O00000Oo((O00Oo00o) o00Oo00o);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(O00o0000 o00o0000) {
        super.O00000Oo(o00o0000);
        return this;
    }

    public O00O0o<ModelType, TranscodeType> O000000o(O0O0O o0o0o) {
        this.O0000Oo0 = o0o0o;
        this.O0000Oo = new O000OO00(this.O0000OOo, this.O0000O0o, o0o0o);
        this.O0000OoO = new O0000o00(new O000OO(), this.O0000O0o, o0o0o);
        super.O00000oO(new o0O00Oo0(new O000OO00(this.O0000OOo, this.O0000O0o, o0o0o)));
        super.O00000oo(new O000O00o(this.O0000Oo, this.O0000OoO));
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(O0O0OO0<OOO> o0o0oo0) {
        super.O00000Oo((O0O0OO0) o0o0oo0);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(O0O0OO o0o0oo) {
        super.O00000Oo(o0o0oo);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000oo(O0O0o00<OOO, Bitmap> o0O0o00) {
        super.O00000oo((O0O0o00) o0O0o00);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(O0O0o0<Bitmap> o0O0o0) {
        super.O00000Oo((O0O0o0) o0O0o0);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(O0Oo0 o0Oo0) {
        super.O00000Oo(o0Oo0);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000oo(Drawable drawable) {
        super.O00000oo(drawable);
        return this;
    }

    @Deprecated
    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(Animation animation) {
        super.O00000Oo(animation);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(ModelType modelType) {
        super.O00000Oo((Object) modelType);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(oO00000o<Bitmap, TranscodeType> oo00000o) {
        super.O00000Oo((oO00000o) oo00000o);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(oO00O0Oo<? super ModelType, TranscodeType> oo00o0oo) {
        super.O00000Oo((oO00O0Oo) oo00o0oo);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(O000000o o000000o) {
        super.O00000Oo(o000000o);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(boolean z) {
        super.O00000Oo(z);
        return this;
    }

    /* renamed from: O000000o */
    public O00O0o<ModelType, TranscodeType> O00000Oo(O0OoOo<Bitmap>... o0OoOoArr) {
        super.O00000Oo((O0OoOo[]) o0OoOoArr);
        return this;
    }

    public O00O0o<ModelType, TranscodeType> O000000o(O0000O0o... o0000O0oArr) {
        super.O00000Oo((O0OoOo[]) o0000O0oArr);
        return this;
    }

    public ooOOO0Oo<TranscodeType> O000000o(ImageView imageView) {
        return super.O000000o(imageView);
    }

    /* renamed from: O00000Oo */
    public O00O0o<ModelType, TranscodeType> O00000o0(float f) {
        super.O00000o0(f);
        return this;
    }

    /* renamed from: O00000Oo */
    public O00O0o<ModelType, TranscodeType> O0000O0o(int i) {
        super.O0000O0o(i);
        return this;
    }

    /* renamed from: O00000Oo */
    public O00O0o<ModelType, TranscodeType> O00000oO(O0O0o00<File, Bitmap> o0O0o00) {
        super.O00000oO((O0O0o00) o0O0o00);
        return this;
    }

    /* renamed from: O00000Oo */
    public O00O0o<ModelType, TranscodeType> O00000oO(Drawable drawable) {
        super.O00000oO(drawable);
        return this;
    }

    public O00O0o<ModelType, TranscodeType> O00000o() {
        return O000000o(O0000Oo0.O00000o0);
    }

    /* renamed from: O00000o */
    public O00O0o<ModelType, TranscodeType> O00000oO(int i) {
        super.O00000oO(i);
        return this;
    }

    public O00O0o<ModelType, TranscodeType> O00000o(O0O0o00<ParcelFileDescriptor, Bitmap> o0O0o00) {
        this.O0000OoO = o0O0o00;
        super.O00000oo(new O000O00o(this.O0000Oo, o0O0o00));
        return this;
    }

    public O00O0o<ModelType, TranscodeType> O00000o0() {
        return O000000o(O0000Oo0.O000000o);
    }

    /* renamed from: O00000o0 */
    public O00O0o<ModelType, TranscodeType> O00000oo(int i) {
        super.O00000oo(i);
        return this;
    }

    public O00O0o<ModelType, TranscodeType> O00000o0(O0O0o00<InputStream, Bitmap> o0O0o00) {
        this.O0000Oo = o0O0o00;
        super.O00000oo(new O000O00o(o0O0o00, this.O0000OoO));
        return this;
    }

    /* renamed from: O00000o0 */
    public O00O0o<ModelType, TranscodeType> O00000o(Drawable drawable) {
        super.O00000o(drawable);
        return this;
    }

    public O00O0o<ModelType, TranscodeType> O00000oO() {
        return O000000o(O0000Oo0.O00000Oo);
    }

    /* renamed from: O00000oo */
    public O00O0o<ModelType, TranscodeType> O00000Oo() {
        return O000000o(this.O00000o0.O00000oO());
    }

    /* renamed from: O0000O0o */
    public O00O0o<ModelType, TranscodeType> O000000o() {
        return O000000o(this.O00000o0.O00000oo());
    }

    /* renamed from: O0000OOo */
    public O00O0o<ModelType, TranscodeType> O0000o0() {
        super.O0000o0();
        return this;
    }

    /* renamed from: O0000Oo */
    public O00O0o<ModelType, TranscodeType> clone() {
        return (O00O0o) super.clone();
    }

    /* renamed from: O0000Oo0 */
    public O00O0o<ModelType, TranscodeType> O0000o0O() {
        super.O0000o0O();
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000OoO() {
        O000000o();
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000Ooo() {
        O00000Oo();
    }
}
