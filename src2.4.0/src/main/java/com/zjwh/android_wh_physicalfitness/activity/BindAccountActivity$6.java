package com.zjwh.android_wh_physicalfitness.activity;

import android.text.Editable;
import android.text.TextWatcher;

class BindAccountActivity$6 implements TextWatcher {
    final /* synthetic */ BindAccountActivity O000000o;

    BindAccountActivity$6(BindAccountActivity bindAccountActivity) {
        this.O000000o = bindAccountActivity;
    }

    public void afterTextChanged(Editable editable) {
        BindAccountActivity.O00000o0(this.O000000o);
        this.O000000o.O0000OOo.setVisibility(8);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
