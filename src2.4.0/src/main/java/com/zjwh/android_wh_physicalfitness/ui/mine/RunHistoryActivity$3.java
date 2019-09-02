package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.view.View;
import android.view.View.OnClickListener;

class RunHistoryActivity$3 implements OnClickListener {
    final /* synthetic */ RunHistoryActivity O000000o;

    RunHistoryActivity$3(RunHistoryActivity runHistoryActivity) {
        this.O000000o = runHistoryActivity;
    }

    public void onClick(View view) {
        if (RunHistoryActivity.O00000o0(this.O000000o).isDrawerOpen(8388613)) {
            RunHistoryActivity.O00000o0(this.O000000o).closeDrawer(8388613);
        }
    }
}
