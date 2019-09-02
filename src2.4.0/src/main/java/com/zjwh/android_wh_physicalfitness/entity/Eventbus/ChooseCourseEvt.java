package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class ChooseCourseEvt {
    public int cid;
    public String className;
    public int mid;
    public String teacherName;

    public ChooseCourseEvt(int i, String str, int i2, String str2) {
        this.cid = i;
        this.className = str;
        this.mid = i2;
        this.teacherName = str2;
    }
}
