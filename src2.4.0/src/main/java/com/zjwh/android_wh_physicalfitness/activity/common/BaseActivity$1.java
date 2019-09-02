package com.zjwh.android_wh_physicalfitness.activity.common;

import android.view.View;
import android.view.View.OnClickListener;

class BaseActivity$1 implements OnClickListener {
    final /* synthetic */ BaseActivity O000000o;

    BaseActivity$1(BaseActivity baseActivity) {
        this.O000000o = baseActivity;
    }

    public void onClick(View view) {
        this.O000000o.onBackPressed();
    }
}
