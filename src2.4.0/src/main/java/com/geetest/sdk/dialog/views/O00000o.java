package com.geetest.sdk.dialog.views;

/* compiled from: WebviewBuilder */
final class O00000o implements Runnable {
    final /* synthetic */ O000000o O000000o;

    O00000o(O000000o o000000o) {
        this.O000000o = o000000o;
    }

    public final void run() {
        if (O00000Oo.this.O0000Oo != null && !O00000Oo.this.O0000Oo.O000000o()) {
            if (O00000Oo.this.O0000o00 != null) {
                try {
                    O00000Oo.this.O0000o00.removeCallbacks(O00000Oo.this.O0000Ooo);
                    O00000Oo.this.O0000o00.removeMessages(1);
                } catch (Exception unused) {
                }
            }
            if (O00000Oo.this.O00000oO != null) {
                O00000Oo.this.O00000oO.O000000o();
            }
        }
    }
}
