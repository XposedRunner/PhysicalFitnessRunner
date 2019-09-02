package com.zjwh.android_wh_physicalfitness.utils;

import android.support.v7.util.DiffUtil.Callback;
import com.zjwh.android_wh_physicalfitness.entity.FindDetailBean;
import java.util.List;

/* compiled from: CommentDiffCallback */
public class O000O0OO extends Callback {
    private final List<FindDetailBean> O000000o;
    private final List<FindDetailBean> O00000Oo;

    public O000O0OO(List<FindDetailBean> list, List<FindDetailBean> list2) {
        this.O000000o = list;
        this.O00000Oo = list2;
    }

    public boolean areContentsTheSame(int i, int i2) {
        return true;
    }

    public boolean areItemsTheSame(int i, int i2) {
        FindDetailBean findDetailBean = (FindDetailBean) this.O000000o.get(i);
        FindDetailBean findDetailBean2 = (FindDetailBean) this.O00000Oo.get(i2);
        return (findDetailBean.getBean() == null || findDetailBean2.getBean() == null || findDetailBean.getBean().getId() != findDetailBean2.getBean().getId()) ? false : true;
    }

    public int getNewListSize() {
        return this.O00000Oo.size();
    }

    public int getOldListSize() {
        return this.O000000o.size();
    }
}
