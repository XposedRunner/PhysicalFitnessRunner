package com.geetest.sdk.views;

import com.geetest.sdk.O00O0o;
import com.geetest.sdk.R;

/* compiled from: GT3GeetestButton */
final class O00000o implements Runnable {
    final /* synthetic */ O000000o O000000o;

    O00000o(O000000o o000000o) {
        this.O000000o = o000000o;
    }

    public final void run() {
        GT3GeetestButton.this.geetestView.O00000oO();
        GT3GeetestButton.this.setBackgroundResource(R.drawable.gt3_lin_bg_shape);
        if (GT3GeetestButton.this.islogo) {
            GT3GeetestButton.this.ivGeetestLogo.setImageResource(R.mipmap.gt3logogray);
        }
        GT3GeetestButton.this.tvTestGeetest.setText(O00O0o.O00000oO());
        GT3GeetestButton.this.tvTestGeetest.setTextColor(-13092808);
        GT3GeetestButton.this.tvTestGeetest.setAlpha(1.0f);
    }
}
