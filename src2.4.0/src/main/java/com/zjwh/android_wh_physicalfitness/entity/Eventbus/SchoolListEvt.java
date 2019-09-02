package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

import com.zjwh.android_wh_physicalfitness.entity.School;
import java.util.ArrayList;

public class SchoolListEvt {
    private ArrayList<School> schools;

    public SchoolListEvt(ArrayList<School> arrayList) {
        this.schools = arrayList;
    }

    public ArrayList<School> getList() {
        return this.schools;
    }
}
