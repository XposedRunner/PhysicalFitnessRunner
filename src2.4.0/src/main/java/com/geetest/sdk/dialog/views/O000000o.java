package com.geetest.sdk.dialog.views;

import com.geetest.sdk.O0000Oo0.O00000o0;

/* compiled from: SuccessView */
final class O000000o implements com.geetest.sdk.views.GT3View.O000000o {
    final /* synthetic */ com.geetest.sdk.O0000Oo0.O000000o O000000o;
    final /* synthetic */ O00000o0 O00000Oo;
    final /* synthetic */ SuccessView O00000o0;

    O000000o(SuccessView successView, com.geetest.sdk.O0000Oo0.O000000o o000000o, O00000o0 o00000o0) {
        this.O00000o0 = successView;
        this.O000000o = o000000o;
        this.O00000Oo = o00000o0;
    }

    public final void O000000o() {
        if (!this.O00000o0.O00000o0) {
            this.O000000o.postDelayed(this.O00000Oo, 10);
            this.O00000o0.O00000o0 = true;
        }
    }
}
