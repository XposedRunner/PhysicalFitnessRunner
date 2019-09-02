package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class SchoolNumBackActivity$1 extends SpanSizeLookup {
    final /* synthetic */ SchoolNumBackActivity O000000o;

    SchoolNumBackActivity$1(SchoolNumBackActivity schoolNumBackActivity) {
        this.O000000o = schoolNumBackActivity;
    }

    public int getSpanSize(int i) {
        return SchoolNumBackActivity.O000000o(this.O000000o).size() <= 0 ? 2 : 1;
    }
}
