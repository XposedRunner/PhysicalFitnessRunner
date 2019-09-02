package com.geetest.sdk.views;

import com.geetest.sdk.O00O0o;
import com.geetest.sdk.R;

/* compiled from: GT3GeetestButton */
final class O0000OOo implements Runnable {
    final /* synthetic */ O000000o O000000o;

    O0000OOo(O000000o o000000o) {
        this.O000000o = o000000o;
    }

    public final void run() {
        GT3GeetestButton.this.geetestView.O0000O0o();
        GT3GeetestButton.this.setBackgroundResource(R.drawable.gt3_lin_success_shape);
        GT3GeetestButton.this.tvTestGeetest.setText(O00O0o.O00000o());
        GT3GeetestButton.this.tvTestGeetest.setTextColor(-15162286);
        GT3GeetestButton.this.tvTestGeetest.setAlpha(1.0f);
        if (GT3GeetestButton.this.islogo) {
            GT3GeetestButton.this.ivGeetestLogo.setImageResource(R.mipmap.gt3logogreen);
        }
        GT3GeetestButton.this.touch = true;
    }
}
