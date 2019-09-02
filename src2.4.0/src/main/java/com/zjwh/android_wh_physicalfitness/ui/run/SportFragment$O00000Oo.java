package com.zjwh.android_wh_physicalfitness.ui.run;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class SportFragment$O00000Oo extends FragmentPagerAdapter {
    final /* synthetic */ SportFragment O000000o;
    private String[] O00000Oo = new String[]{"自由模式", "随机终点", "约跑模式"};

    SportFragment$O00000Oo(SportFragment sportFragment, FragmentManager fragmentManager) {
        this.O000000o = sportFragment;
        super(fragmentManager);
    }

    public int getCount() {
        return SportFragment.O0000o0O(this.O000000o) ? 1 : 3;
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 1:
                return SportFragment.O0000O0o(this.O000000o);
            case 2:
                return SportFragment.O0000o0(this.O000000o);
            default:
                return SportFragment.O0000o00(this.O000000o);
        }
    }

    public CharSequence getPageTitle(int i) {
        return this.O00000Oo[i];
    }
}
