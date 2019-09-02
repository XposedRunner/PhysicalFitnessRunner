package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy */
public final class O0O0O extends O0O0OO0 {
    private int O00000Oo;
    private String O00000o;
    private long O00000o0;
    private Context O00000oO;

    public O0O0O(Context context, int i, String str, O0O0OO0 o0o0oo0) {
        super(o0o0oo0);
        this.O00000Oo = i;
        this.O00000o = str;
        this.O00000oO = context;
    }

    public final void O000000o(boolean z) {
        super.O000000o(z);
        if (z) {
            String str = this.O00000o;
            long currentTimeMillis = System.currentTimeMillis();
            this.O00000o0 = currentTimeMillis;
            O0000o00.O000000o(this.O00000oO, str, String.valueOf(currentTimeMillis));
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O000000o() {
        long j = 0;
        if (this.O00000o0 == 0) {
            String O000000o = O0000o00.O000000o(this.O00000oO, this.O00000o);
            if (!TextUtils.isEmpty(O000000o)) {
                j = Long.parseLong(O000000o);
            }
            this.O00000o0 = j;
        }
        return System.currentTimeMillis() - this.O00000o0 >= ((long) this.O00000Oo);
    }
}
