package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy */
public class n extends p {
    private int O00000Oo;
    private String O00000o;
    private long O00000o0;
    private Context O00000oO;

    public n(Context context, int i, String str, p pVar) {
        super(pVar);
        this.O00000Oo = i;
        this.O00000o = str;
        this.O00000oO = context;
    }

    private long O000000o(String str) {
        str = oO0Oo0oo.O000000o(this.O00000oO, str);
        return TextUtils.isEmpty(str) ? 0 : Long.parseLong(str);
    }

    private void O000000o(String str, long j) {
        this.O00000o0 = j;
        oO0Oo0oo.O000000o(this.O00000oO, str, String.valueOf(j));
    }

    public void O000000o(boolean z) {
        super.O000000o(z);
        if (z) {
            O000000o(this.O00000o, System.currentTimeMillis());
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o() {
        if (this.O00000o0 == 0) {
            this.O00000o0 = O000000o(this.O00000o);
        }
        return System.currentTimeMillis() - this.O00000o0 >= ((long) this.O00000Oo);
    }
}
