package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: DexFileProvider */
public final class v extends u {
    public v(Context context, o0OO0o00 o0oo0o00) {
        super(context, o0oo0o00);
    }

    /* Access modifiers changed, original: protected|final */
    public final String O000000o() {
        return "h";
    }

    public final String O0000Oo() {
        Context context = this.O000000o;
        StringBuilder stringBuilder = new StringBuilder("dex");
        stringBuilder.append(o0O0o000.O0000oo0(context));
        stringBuilder.append(O00000Oo());
        return this.O00000Oo.O000000o(O00000o()).O00000Oo(o0OO00o0.O00000Oo(stringBuilder.toString())).O000000o();
    }

    public final String O0000OoO() {
        ap O000000o = this.O00000Oo.O000000o(O00000o());
        StringBuilder stringBuilder = new StringBuilder("workopt");
        stringBuilder.append(o0O0o000.O0000oo0(this.O000000o));
        return O000000o.O00000Oo(o0OO00o0.O00000Oo(stringBuilder.toString())).O000000o();
    }
}
