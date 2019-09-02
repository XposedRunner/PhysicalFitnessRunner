package com.zjwh.android_wh_physicalfitness.view.banner;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecentBannerAdapter */
class O00000Oo extends PagerAdapter {
    private List<View> O000000o = new ArrayList(this.O00000Oo);
    private int O00000Oo;
    private int O00000o0;

    O00000Oo(int i, List<View> list) {
        this.O000000o = list;
        this.O00000o0 = i;
        this.O00000Oo = list.size();
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public int getCount() {
        return this.O00000o0;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = (View) this.O000000o.get(i % this.O00000Oo);
        if (viewGroup.equals(view.getParent())) {
            viewGroup.removeView(view);
        }
        viewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
