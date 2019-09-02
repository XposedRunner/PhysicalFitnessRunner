package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.manager.O0000Oo0;
import com.bumptech.glide.manager.O000O00o;
import com.yalantis.ucrop.view.CropImageView;
import defpackage.oO0OO000.O000000o;
import java.io.File;

/* compiled from: GenericRequestBuilder */
/* renamed from: O00Oo00o */
public class O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    protected final Class<ModelType> O000000o;
    protected final Context O00000Oo;
    protected final Class<TranscodeType> O00000o;
    protected final O00Oo O00000o0;
    protected final O000O00o O00000oO;
    protected final O0000Oo0 O00000oo;
    private oO0Ooooo<ModelType, DataType, ResourceType, TranscodeType> O0000O0o;
    private ModelType O0000OOo;
    private boolean O0000Oo;
    private O0O0OO O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private Drawable O0000o;
    private Float O0000o0;
    private oO00O0Oo<? super ModelType, TranscodeType> O0000o00;
    private O00Oo00o<?, ?, ?, TranscodeType> O0000o0O;
    private Float O0000o0o;
    private O00o0000 O0000oO;
    private Drawable O0000oO0;
    private boolean O0000oOO;
    private oO00OOo0<TranscodeType> O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private O0Oo0 O0000ooO;
    private O0OoOo<ResourceType> O0000ooo;
    private Drawable O000O00o;
    private int O000O0OO;
    private boolean O00oOooO;
    private boolean O00oOooo;

    /* compiled from: GenericRequestBuilder */
    /* renamed from: O00Oo00o$1 */
    class 1 implements Runnable {
        final /* synthetic */ oO00O00o O000000o;
        final /* synthetic */ O00Oo00o O00000Oo;

        1(O00Oo00o o00Oo00o, oO00O00o oo00o00o) {
        }

        public void run() {
        }
    }

    /* compiled from: GenericRequestBuilder */
    /* renamed from: O00Oo00o$2 */
    static /* synthetic */ class 2 {
        static final /* synthetic */ int[] O000000o = new int[ScaleType.values().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        static {
            /*
            r0 = android.widget.ImageView.ScaleType.values();
            r0 = r0.length;
            r0 = new int[r0];
            O000000o = r0;
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.widget.ImageView.ScaleType.CENTER_CROP;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.widget.ImageView.ScaleType.FIT_CENTER;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.widget.ImageView.ScaleType.FIT_START;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.widget.ImageView.ScaleType.FIT_END;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.O00Oo00o$2.<clinit>():void");
        }
    }

    O00Oo00o(Context context, Class<ModelType> cls, oO0OOo0o<ModelType, DataType, ResourceType, TranscodeType> oo0ooo0o, Class<TranscodeType> cls2, O00Oo o00Oo, O000O00o o000O00o, O0000Oo0 o0000Oo0) {
        this.O0000Oo0 = oOo00o00.O000000o();
        this.O0000o0o = Float.valueOf(1.0f);
        oO0Ooooo oo0ooooo = null;
        this.O0000oO = null;
        this.O0000oOO = true;
        this.O0000oOo = oO00Oo00.O000000o();
        this.O0000oo0 = -1;
        this.O0000oo = -1;
        this.O0000ooO = O0Oo0.RESULT;
        this.O0000ooo = o0O0000O.O00000Oo();
        this.O00000Oo = context;
        this.O000000o = cls;
        this.O00000o = cls2;
        this.O00000o0 = o00Oo;
        this.O00000oO = o000O00o;
        this.O00000oo = o0000Oo0;
        if (oo0ooo0o != null) {
            oo0ooooo = new oO0Ooooo(oo0ooo0o);
        }
        this.O0000O0o = oo0ooooo;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        } else if (cls != null && oo0ooo0o == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    O00Oo00o(oO0OOo0o<ModelType, DataType, ResourceType, TranscodeType> oo0ooo0o, Class<TranscodeType> cls, O00Oo00o<ModelType, ?, ?, ?> o00Oo00o) {
        this(o00Oo00o.O00000Oo, o00Oo00o.O000000o, oo0ooo0o, cls, o00Oo00o.O00000o0, o00Oo00o.O00000oO, o00Oo00o.O00000oo);
        this.O0000OOo = o00Oo00o.O0000OOo;
        this.O0000Oo = o00Oo00o.O0000Oo;
        this.O0000Oo0 = o00Oo00o.O0000Oo0;
        this.O0000ooO = o00Oo00o.O0000ooO;
        this.O0000oOO = o00Oo00o.O0000oOO;
    }

    private O00o0000 O000000o() {
        return this.O0000oO == O00o0000.LOW ? O00o0000.NORMAL : this.O0000oO == O00o0000.NORMAL ? O00o0000.HIGH : O00o0000.IMMEDIATE;
    }

    private oO0Oo0O0 O000000o(ooOOO0Oo<TranscodeType> ooooo0oo) {
        if (this.O0000oO == null) {
            this.O0000oO = O00o0000.NORMAL;
        }
        return O000000o(ooooo0oo, null);
    }

    private oO0Oo0O0 O000000o(ooOOO0Oo<TranscodeType> ooooo0oo, float f, O00o0000 o00o0000, oO0O0o0o oo0o0o0o) {
        oO0Ooooo oo0ooooo = this.O0000O0o;
        Object obj = this.O0000OOo;
        O0O0OO o0o0oo = this.O0000Oo0;
        Context context = this.O00000Oo;
        Drawable drawable = this.O0000o;
        int i = this.O0000OoO;
        Drawable drawable2 = this.O0000oO0;
        int i2 = this.O0000Ooo;
        Drawable drawable3 = this.O000O00o;
        int i3 = this.O000O0OO;
        oO00O0Oo oo00o0oo = this.O0000o00;
        O0Oo O00000o = this.O00000o0.O00000o();
        O0OoOo o0OoOo = this.O0000ooo;
        Class cls = this.O00000o;
        boolean z = this.O0000oOO;
        oO00OOo0 oo00ooo0 = this.O0000oOo;
        O0OoOo o0OoOo2 = o0OoOo;
        return oO000o00.O000000o(oo0ooooo, obj, o0o0oo, context, o00o0000, ooooo0oo, f, drawable, i, drawable2, i2, drawable3, i3, oo00o0oo, oo0o0o0o, O00000o, o0OoOo2, cls, z, oo00ooo0, this.O0000oo, this.O0000oo0, this.O0000ooO);
    }

    private oO0Oo0O0 O000000o(ooOOO0Oo<TranscodeType> ooooo0oo, oO00O0o0 oo00o0o0) {
        oO00O0o0 oo00o0o02;
        if (this.O0000o0O != null) {
            if (this.O00oOooo) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.O0000o0O.O0000oOo.equals(oO00Oo00.O000000o())) {
                this.O0000o0O.O0000oOo = this.O0000oOo;
            }
            if (this.O0000o0O.O0000oO == null) {
                this.O0000o0O.O0000oO = O000000o();
            }
            if (oOOO000o.O000000o(this.O0000oo, this.O0000oo0) && !oOOO000o.O000000o(this.O0000o0O.O0000oo, this.O0000o0O.O0000oo0)) {
                this.O0000o0O.O00000Oo(this.O0000oo, this.O0000oo0);
            }
            oo00o0o02 = new oO00O0o0(oo00o0o0);
            oO0Oo0O0 O000000o = O000000o(ooooo0oo, this.O0000o0o.floatValue(), this.O0000oO, oo00o0o02);
            this.O00oOooo = true;
            oO0Oo0O0 O000000o2 = this.O0000o0O.O000000o(ooooo0oo, oo00o0o02);
            this.O00oOooo = false;
            oo00o0o02.O000000o(O000000o, O000000o2);
            return oo00o0o02;
        } else if (this.O0000o0 == null) {
            return O000000o(ooooo0oo, this.O0000o0o.floatValue(), this.O0000oO, oo00o0o0);
        } else {
            oo00o0o02 = new oO00O0o0(oo00o0o0);
            oo00o0o02.O000000o(O000000o(ooooo0oo, this.O0000o0o.floatValue(), this.O0000oO, oo00o0o02), O000000o(ooooo0oo, this.O0000o0.floatValue(), O000000o(), oo00o0o02));
            return oo00o0o02;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O000000o(oO00OOo0<TranscodeType> oo00ooo0) {
        if (oo00ooo0 == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.O0000oOo = oo00ooo0;
        return this;
    }

    public ooOOO0Oo<TranscodeType> O000000o(ImageView imageView) {
        oOOO000o.O000000o();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!(this.O00oOooO || imageView.getScaleType() == null)) {
            switch (2.O000000o[imageView.getScaleType().ordinal()]) {
                case 1:
                    O0000Ooo();
                    break;
                case 2:
                case 3:
                case 4:
                    O0000OoO();
                    break;
            }
        }
        return O00000Oo(this.O00000o0.O000000o(imageView, this.O00000o));
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(int i, int i2) {
        if (oOOO000o.O000000o(i, i2)) {
            this.O0000oo = i;
            this.O0000oo0 = i2;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(O00Oo00o<?, ?, ?, TranscodeType> o00Oo00o) {
        if (equals(o00Oo00o)) {
            throw new IllegalArgumentException("You cannot set a request as a thumbnail for itself. Consider using clone() on the request you are passing to thumbnail()");
        }
        this.O0000o0O = o00Oo00o;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(O00o0000 o00o0000) {
        this.O0000oO = o00o0000;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(O0O0OO0<DataType> o0o0oo0) {
        if (this.O0000O0o != null) {
            this.O0000O0o.O000000o((O0O0OO0) o0o0oo0);
        }
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(O0O0OO o0o0oo) {
        if (o0o0oo == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.O0000Oo0 = o0o0oo;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(O0O0o0<ResourceType> o0O0o0) {
        if (this.O0000O0o != null) {
            this.O0000O0o.O000000o((O0O0o0) o0O0o0);
        }
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(O0Oo0 o0Oo0) {
        this.O0000ooO = o0Oo0;
        return this;
    }

    @Deprecated
    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(Animation animation) {
        return O000000o(new oO00o000(animation));
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(ModelType modelType) {
        this.O0000OOo = modelType;
        this.O0000Oo = true;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(oO00000o<ResourceType, TranscodeType> oo00000o) {
        if (this.O0000O0o != null) {
            this.O0000O0o.O000000o((oO00000o) oo00000o);
        }
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(oO00O0Oo<? super ModelType, TranscodeType> oo00o0oo) {
        this.O0000o00 = oo00o0oo;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(O000000o o000000o) {
        return O000000o(new oOo00o0o(o000000o));
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(boolean z) {
        this.O0000oOO = z ^ 1;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000Oo(O0OoOo<ResourceType>... o0OoOoArr) {
        this.O00oOooO = true;
        if (o0OoOoArr.length == 1) {
            this.O0000ooo = o0OoOoArr[0];
        } else {
            this.O0000ooo = new O0O0OOO((O0OoOo[]) o0OoOoArr);
        }
        return this;
    }

    public <Y extends ooOOO0Oo<TranscodeType>> Y O00000Oo(Y y) {
        oOOO000o.O000000o();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        } else if (this.O0000Oo) {
            oO0Oo0O0 b_ = y.b_();
            if (b_ != null) {
                b_.O00000o();
                this.O00000oO.O00000o0(b_);
                b_.O000000o();
            }
            b_ = O000000o((ooOOO0Oo) y);
            y.O000000o(b_);
            this.O00000oo.O000000o(y);
            this.O00000oO.O000000o(b_);
            return y;
        } else {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000o(float f) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.O0000o0 = Float.valueOf(f);
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000o(Drawable drawable) {
        this.O0000oO0 = drawable;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000o0(float f) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.O0000o0o = Float.valueOf(f);
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000oO(int i) {
        this.O0000Ooo = i;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000oO(O0O0o00<File, ResourceType> o0O0o00) {
        if (this.O0000O0o != null) {
            this.O0000O0o.O000000o((O0O0o00) o0O0o00);
        }
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000oO(Drawable drawable) {
        this.O000O00o = drawable;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000oo(int i) {
        this.O000O0OO = i;
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000oo(O0O0o00<DataType, ResourceType> o0O0o00) {
        if (this.O0000O0o != null) {
            this.O0000O0o.O00000Oo(o0O0o00);
        }
        return this;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O00000oo(Drawable drawable) {
        this.O0000o = drawable;
        return this;
    }

    public oO000Oo0<TranscodeType> O00000oo(int i, int i2) {
        oO00O00o oo00o00o = new oO00O00o(this.O00000o0.O0000Oo0(), i, i2);
        this.O00000o0.O0000Oo0().post(new 1(this, oo00o00o));
        return oo00o00o;
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O0000O0o(int i) {
        this.O0000OoO = i;
        return this;
    }

    public ooOOO0Oo<TranscodeType> O0000O0o(int i, int i2) {
        return O00000Oo(oO0O0O00.O000000o(i, i2));
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O0000OOo(int i) {
        return O000000o(new oO00o000(this.O00000Oo, i));
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000OoO() {
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000Ooo() {
    }

    public ooOOO0Oo<TranscodeType> O0000o() {
        return O0000O0o(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O0000o0() {
        return O000000o(oO00Oo00.O000000o());
    }

    /* renamed from: O0000o00 */
    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> clone() {
        try {
            O00Oo00o o00Oo00o = (O00Oo00o) super.clone();
            o00Oo00o.O0000O0o = this.O0000O0o != null ? this.O0000O0o.O0000O0o() : null;
            return o00Oo00o;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public O00Oo00o<ModelType, DataType, ResourceType, TranscodeType> O0000o0O() {
        return O00000Oo(o0O0000O.O00000Oo());
    }
}
