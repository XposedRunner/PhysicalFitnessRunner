package com.zjwh.android_wh_physicalfitness.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class SearchSchoolActivity$1 implements TextWatcher {
    final /* synthetic */ SearchSchoolActivity O000000o;

    SearchSchoolActivity$1(SearchSchoolActivity searchSchoolActivity) {
        this.O000000o = searchSchoolActivity;
    }

    public void afterTextChanged(Editable editable) {
        String trim = this.O000000o.O000000o.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            this.O000000o.O00000Oo.setVisibility(0);
            this.O000000o.O00000oo.setVisibility(0);
            this.O000000o.O00000oO.setVisibility(4);
            return;
        }
        this.O000000o.O00000oo.setVisibility(4);
        this.O000000o.O00000Oo.setVisibility(4);
        this.O000000o.O00000oO.setVisibility(0);
        SearchSchoolActivity.O000000o(this.O000000o, trim);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
