package com.zjwh.android_wh_physicalfitness.ui.run;

import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import defpackage.gg;

class SportFragment$4 implements Runnable {
    final /* synthetic */ SportFragment O000000o;

    SportFragment$4(SportFragment sportFragment) {
        this.O000000o = sportFragment;
    }

    public void run() {
        if (this.O000000o.O0000Ooo()) {
            SportFragment.O000000o(this.O000000o, true);
            O00O0Oo0.O000000o(gg.O000OOOo, Boolean.valueOf(false));
            SportFragment.O00000o0(this.O000000o);
        }
    }
}
