package com.amap.api.mapcore.util;

import java.io.File;

/* compiled from: FileNumUpdateStrategy */
public class k extends p {
    private int O00000Oo;
    private String O00000o0;

    public k(int i, String str, p pVar) {
        super(pVar);
        this.O00000Oo = i;
        this.O00000o0 = str;
    }

    public int O000000o(String str) {
        int length;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            length = file.list().length;
            return length;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "fus", "gfn");
            length = 0;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o() {
        return O000000o(this.O00000o0) >= this.O00000Oo;
    }
}
