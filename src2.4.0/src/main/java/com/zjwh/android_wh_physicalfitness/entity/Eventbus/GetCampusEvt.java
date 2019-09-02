package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

import com.zjwh.android_wh_physicalfitness.entity.RunModeModel;
import com.zjwh.android_wh_physicalfitness.entity.database.NearBySchoolBean;

public class GetCampusEvt {
    private NearBySchoolBean mNearBySchoolBean;
    private RunModeModel mRunModeModel;

    public GetCampusEvt(NearBySchoolBean nearBySchoolBean, RunModeModel runModeModel) {
        this.mNearBySchoolBean = nearBySchoolBean;
        this.mRunModeModel = runModeModel;
    }

    public NearBySchoolBean getNearBySchoolBean() {
        return this.mNearBySchoolBean;
    }

    public RunModeModel getRunModeModel() {
        return this.mRunModeModel;
    }

    public void setRunModeModel(RunModeModel runModeModel) {
        this.mRunModeModel = runModeModel;
    }
}
