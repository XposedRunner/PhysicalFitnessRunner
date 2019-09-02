package com.loc;

import java.io.File;

/* compiled from: FileNumUpdateStrategy */
public final class O0O00o0 extends O0O0OO0 {
    private int O00000Oo;
    private String O00000o0;

    public O0O00o0(int i, String str, O0O0OO0 o0o0oo0) {
        super(o0o0oo0);
        this.O00000Oo = i;
        this.O00000o0 = str;
    }

    private static int O000000o(String str) {
        try {
            File file = new File(str);
            return !file.exists() ? 0 : file.list().length;
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "fus", "gfn");
            return 0;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O000000o() {
        return O000000o(this.O00000o0) >= this.O00000Oo;
    }
}
