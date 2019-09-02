package com.zjwh.android_wh_physicalfitness.ui.run;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class SportFragment$1 extends BroadcastReceiver {
    final /* synthetic */ SportFragment O000000o;

    SportFragment$1(SportFragment sportFragment) {
        this.O000000o = sportFragment;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            Object obj = -1;
            if (action.hashCode() == 1676589973 && action.equals("action_update_user_info")) {
                obj = null;
            }
            if (obj == null && !SportFragment.O000000o(this.O000000o)) {
                SportFragment.O00000Oo(this.O000000o);
            }
        }
    }
}
