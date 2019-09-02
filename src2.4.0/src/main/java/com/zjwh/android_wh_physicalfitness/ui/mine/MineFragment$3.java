package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class MineFragment$3 extends BroadcastReceiver {
    final /* synthetic */ MineFragment O000000o;

    MineFragment$3(MineFragment mineFragment) {
        this.O000000o = mineFragment;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            Object obj = -1;
            if (action.hashCode() == 284879839 && action.equals("action_new_message")) {
                obj = null;
            }
            if (obj == null) {
                MineFragment.O0000O0o(this.O000000o);
            }
        }
    }
}
