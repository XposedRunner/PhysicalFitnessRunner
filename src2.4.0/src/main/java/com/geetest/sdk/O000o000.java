package com.geetest.sdk;

/* compiled from: TestHttpDns */
final class O000o000 implements Runnable {
    final /* synthetic */ String O000000o;
    final /* synthetic */ O000OOo0 O00000Oo;
    final /* synthetic */ O00O0Oo O00000o0;

    O000o000(O00O0Oo o00O0Oo, String str, O000OOo0 o000OOo0) {
        this.O00000o0 = o00O0Oo;
        this.O000000o = str;
        this.O00000Oo = o000OOo0;
    }

    public final void run() {
        this.O00000o0.O00000o0.post(new O000o00(this, O00O0Oo.O000000o(this.O00000o0, this.O000000o)));
    }
}
