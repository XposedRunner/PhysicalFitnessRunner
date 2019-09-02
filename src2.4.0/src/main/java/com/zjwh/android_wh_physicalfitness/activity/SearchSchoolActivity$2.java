package com.zjwh.android_wh_physicalfitness.activity;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class SearchSchoolActivity$2 implements OnEditorActionListener {
    final /* synthetic */ SearchSchoolActivity O000000o;

    SearchSchoolActivity$2(SearchSchoolActivity searchSchoolActivity) {
        this.O000000o = searchSchoolActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3) {
            String trim = this.O000000o.O000000o.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                SearchSchoolActivity.O000000o(this.O000000o, trim);
                return false;
            }
        }
        return false;
    }
}
