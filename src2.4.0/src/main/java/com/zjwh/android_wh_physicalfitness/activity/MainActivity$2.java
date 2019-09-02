package com.zjwh.android_wh_physicalfitness.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import defpackage.jf;

class MainActivity$2 extends BroadcastReceiver {
    final /* synthetic */ MainActivity O000000o;

    MainActivity$2(MainActivity mainActivity) {
        this.O000000o = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            boolean z = true;
            int hashCode = action.hashCode();
            boolean z2 = true;
            if (hashCode != -433191873) {
                if (hashCode != 284879839) {
                    if (hashCode == 1676589973 && action.equals("action_update_user_info")) {
                        z = true;
                    }
                } else if (action.equals("action_new_message")) {
                    z = true;
                }
            } else if (action.equals(jf.O000000o)) {
                z = false;
            }
            switch (z) {
                case false:
                    MainActivity.O00000Oo(this.O000000o);
                    break;
                case true:
                    boolean booleanExtra = intent.getBooleanExtra("extra_new_message", false);
                    MainActivity mainActivity = this.O000000o;
                    if (!booleanExtra && MainActivity.O000000o(this.O000000o) <= 0) {
                        z2 = false;
                    }
                    MainActivity.O000000o(mainActivity, z2);
                    MainActivity.O00000Oo(this.O000000o, intent.getBooleanExtra("extra_new_discover", false));
                    O00O0Oo0.O000000o("extra_new_message", Boolean.valueOf(booleanExtra));
                    break;
                case true:
                    this.O000000o.O00000o().O00000oO();
                    break;
            }
        }
    }
}
