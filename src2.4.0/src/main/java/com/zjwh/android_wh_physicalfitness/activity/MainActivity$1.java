package com.zjwh.android_wh_physicalfitness.activity;

import com.qiyukf.unicorn.api.UnreadCountChangeListener;
import com.zjwh.android_wh_physicalfitness.ui.mine.MineFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;

class MainActivity$1 implements UnreadCountChangeListener {
    final /* synthetic */ MainActivity O000000o;

    MainActivity$1(MainActivity mainActivity) {
        this.O000000o = mainActivity;
    }

    public void onUnreadCountChange(int i) {
        MainActivity.O000000o(this.O000000o, i);
        boolean z = false;
        boolean booleanValue = ((Boolean) O00O0Oo0.O00000o0("extra_new_message", Boolean.valueOf(false))).booleanValue();
        MineFragment mineFragment = (MineFragment) this.O000000o.getSupportFragmentManager().findFragmentByTag("fragment_tag_mine");
        if (mineFragment != null && mineFragment.O0000Ooo()) {
            mineFragment.O000000o(MainActivity.O000000o(this.O000000o) > 0);
        }
        MainActivity mainActivity = this.O000000o;
        if (MainActivity.O000000o(this.O000000o) > 0 || booleanValue) {
            z = true;
        }
        MainActivity.O000000o(mainActivity, z);
    }
}
