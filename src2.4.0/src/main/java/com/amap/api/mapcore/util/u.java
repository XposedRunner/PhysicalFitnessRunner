package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

/* compiled from: BaseFileProvider */
public abstract class u {
    protected Context O000000o;
    protected ap O00000Oo;
    private o0OO0o00 O00000o;
    private String O00000o0;
    private String O00000oO = null;
    private String O00000oo;
    private String O0000O0o;
    private String O0000OOo = null;
    private String O0000Oo = null;
    private String O0000Oo0;
    private String O0000OoO = null;
    private String O0000Ooo = null;
    private String O0000o00 = null;

    public u(Context context, o0OO0o00 o0oo0o00) {
        this.O000000o = context;
        this.O00000o = o0oo0o00;
        this.O00000Oo = new ap();
    }

    private String O0000Oo() {
        if (TextUtils.isEmpty(this.O00000o0)) {
            this.O00000o0 = O000000o();
        }
        return this.O00000o0;
    }

    public abstract String O000000o();

    /* Access modifiers changed, original: protected|final */
    public final String O00000Oo() {
        if (!TextUtils.isEmpty(this.O00000oO)) {
            return this.O00000oO;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O00000o.O000000o());
        stringBuilder.append(this.O00000o.O00000Oo());
        this.O00000oO = o0OO00o0.O00000Oo(stringBuilder.toString());
        return this.O00000oO;
    }

    /* Access modifiers changed, original: protected|final */
    public final String O00000o() {
        if (!TextUtils.isEmpty(this.O0000O0o)) {
            return this.O0000O0o;
        }
        if (this.O000000o == null) {
            return "";
        }
        this.O0000O0o = this.O00000Oo.O000000o(this.O000000o.getFilesDir().getAbsolutePath()).O00000Oo(O0000Oo()).O00000Oo(O00000Oo()).O000000o();
        return this.O0000O0o;
    }

    /* Access modifiers changed, original: protected|final */
    public final String O00000o0() {
        if (!TextUtils.isEmpty(this.O00000oo)) {
            return this.O00000oo;
        }
        if (this.O000000o == null) {
            return "";
        }
        this.O00000oo = this.O00000Oo.O000000o(Environment.getExternalStorageDirectory()).O00000Oo(O0000Oo()).O00000Oo(O00000Oo()).O000000o();
        return this.O00000oo;
    }

    public final String O00000oO() {
        if (!TextUtils.isEmpty(this.O0000OOo)) {
            return this.O0000OOo;
        }
        if (this.O000000o == null) {
            return "";
        }
        Context context = this.O000000o;
        StringBuilder stringBuilder = new StringBuilder("png");
        stringBuilder.append(O00000Oo());
        this.O0000OOo = t.O000000o(context, o0OO00o0.O00000Oo(stringBuilder.toString()));
        return this.O0000OOo;
    }

    public final String O00000oo() {
        if (!TextUtils.isEmpty(this.O0000Oo)) {
            return this.O0000Oo;
        }
        this.O0000Oo = this.O00000Oo.O000000o(O00000o0()).O00000Oo("m").O000000o();
        return this.O0000Oo;
    }

    public final String O0000O0o() {
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            return this.O0000OoO;
        }
        this.O0000OoO = this.O00000Oo.O000000o(O00000o()).O00000Oo("i").O000000o();
        return this.O0000OoO;
    }

    public final String O0000OOo() {
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
            return this.O0000Ooo;
        }
        String str;
        ap apVar = this.O00000Oo;
        if (TextUtils.isEmpty(this.O0000Oo0)) {
            this.O0000Oo0 = this.O00000Oo.O000000o(O00000o0()).O00000Oo("h").O000000o();
            str = this.O0000Oo0;
        } else {
            str = this.O0000Oo0;
        }
        this.O0000Ooo = apVar.O000000o(str).O00000Oo(O00000oO()).O000000o();
        return this.O0000Ooo;
    }

    public final String O0000Oo0() {
        if (!TextUtils.isEmpty(this.O0000o00)) {
            return this.O0000o00;
        }
        this.O0000o00 = this.O00000Oo.O000000o(O00000oo()).O00000Oo(O00000oO()).O000000o();
        return this.O0000o00;
    }
}
