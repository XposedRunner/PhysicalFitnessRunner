package com.zjwh.android_wh_physicalfitness.activity;

import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;

class MainActivity$5 implements OnTabSelectedListener {
    final /* synthetic */ MainActivity O000000o;

    MainActivity$5(MainActivity mainActivity) {
        this.O000000o = mainActivity;
    }

    public void onTabReselected(Tab tab) {
    }

    public void onTabSelected(Tab tab) {
        MainActivity.O00000Oo(this.O000000o, ((Integer) tab.getTag()).intValue());
    }

    public void onTabUnselected(Tab tab) {
    }
}
