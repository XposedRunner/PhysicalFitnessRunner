package com.geetest.sdk.dialog.views;

/* compiled from: WebviewBuilder */
final class O00000o0 implements Runnable {
    final /* synthetic */ int O000000o;
    final /* synthetic */ String O00000Oo;
    final /* synthetic */ O000000o O00000o0;

    O00000o0(O000000o o000000o, int i, String str) {
        this.O00000o0 = o000000o;
        this.O000000o = i;
        this.O00000Oo = str;
    }

    public final void run() {
        if (O00000Oo.this.O00000oO != null) {
            if (this.O000000o == 1) {
                O00000Oo.this.O00000oO.O000000o(this.O00000Oo);
                return;
            }
            O00000Oo.this.O00000o0();
        }
    }
}
