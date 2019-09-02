package com.geetest.sdk.views;

import android.text.TextUtils;
import com.geetest.sdk.O00O0o;
import com.geetest.sdk.R;

/* compiled from: GT3GeetestButton */
final class O0000Oo implements Runnable {
    final /* synthetic */ String O000000o;
    final /* synthetic */ String O00000Oo;
    final /* synthetic */ O000000o O00000o0;

    O0000Oo(O000000o o000000o, String str, String str2) {
        this.O00000o0 = o000000o;
        this.O000000o = str;
        this.O00000Oo = str2;
    }

    public final void run() {
        GT3GeetestButton.this.geetestView.O0000OOo();
        GT3GeetestButton.this.setBackgroundResource(R.drawable.gt3_lin_file_shape);
        if (GT3GeetestButton.this.islogo) {
            GT3GeetestButton.this.ivGeetestLogo.setImageResource(R.mipmap.gt3logogray);
        }
        GT3GeetestButton.this.tverrorcode.setText(this.O000000o);
        GT3GeetestButton.this.tverrorcode.setVisibility(0);
        if (!TextUtils.isEmpty(this.O000000o) && this.O000000o.startsWith("_") && !TextUtils.isEmpty(this.O00000Oo)) {
            GT3GeetestButton.this.tvTestGeetest.setText(this.O00000Oo);
        } else if (TextUtils.equals("", this.O000000o)) {
            GT3GeetestButton.this.tvTestGeetest.setText(this.O00000Oo);
        } else {
            GT3GeetestButton.this.tvTestGeetest.setText(O00O0o.O0000Oo0());
        }
        GT3GeetestButton.this.tverror.setVisibility(0);
        GT3GeetestButton.this.tverror.setText(O00O0o.O0000Oo());
        GT3GeetestButton.this.tvTestGeetest.setTextColor(-13092808);
        GT3GeetestButton.this.tvTestGeetest.setAlpha(0.5f);
        GT3GeetestButton.this.touch = true;
    }
}
