package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;

class RunHistoryActivity$1 implements OnOffsetChangedListener {
    final /* synthetic */ RunHistoryActivity O000000o;

    RunHistoryActivity$1(RunHistoryActivity runHistoryActivity) {
        this.O000000o = runHistoryActivity;
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        this.O000000o.O000000o.setEnabled(i >= 0);
    }
}
