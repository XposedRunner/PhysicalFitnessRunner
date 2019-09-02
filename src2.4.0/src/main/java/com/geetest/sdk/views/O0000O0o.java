package com.geetest.sdk.views;

import com.geetest.sdk.O00O0o;
import com.geetest.sdk.R;

/* compiled from: GT3GeetestButton */
final class O0000O0o implements Runnable {
    final /* synthetic */ O000000o O000000o;

    O0000O0o(O000000o o000000o) {
        this.O000000o = o000000o;
    }

    public final void run() {
        GT3GeetestButton.this.geetestView.O00000oo();
        GT3GeetestButton.this.setBackgroundResource(R.drawable.gt3_lin_wait_shape);
        GT3GeetestButton.this.tvTestGeetest.setTextColor(-13092808);
        GT3GeetestButton.this.tvTestGeetest.setText(O00O0o.O00000o0());
        GT3GeetestButton.this.tvTestGeetest.setAlpha(0.5f);
    }
}
