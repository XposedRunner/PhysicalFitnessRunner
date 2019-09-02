package com.loc;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Request */
public abstract class O00OOo {
    int O00000o = 20000;
    int O00000o0 = 20000;
    Proxy O00000oO = null;

    public abstract Map<String, String> O000000o();

    public final void O000000o(int i) {
        this.O00000o0 = i;
    }

    public final void O000000o(Proxy proxy) {
        this.O00000oO = proxy;
    }

    public abstract Map<String, String> O00000Oo();

    public final void O00000Oo(int i) {
        this.O00000o = i;
    }

    public byte[] O00000o() {
        return null;
    }

    public abstract String O00000o0();

    /* Access modifiers changed, original: protected */
    public String O0000OoO() {
        return "";
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O0000Ooo() {
        return !TextUtils.isEmpty(O0000OoO());
    }
}
