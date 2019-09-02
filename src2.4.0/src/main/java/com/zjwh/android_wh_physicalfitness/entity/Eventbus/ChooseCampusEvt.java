package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

import com.zjwh.android_wh_physicalfitness.entity.MyDepartBean;

public class ChooseCampusEvt {
    private MyDepartBean mCampusBean;

    public ChooseCampusEvt(MyDepartBean myDepartBean) {
        this.mCampusBean = myDepartBean;
    }

    public MyDepartBean getMyDepartBean() {
        return this.mCampusBean;
    }
}
