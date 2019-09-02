package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class ChooseClassEvt {
    private int classId;
    private String className;
    private int departId;
    private String department;

    public ChooseClassEvt(int i, String str, int i2, String str2) {
        this.departId = i;
        this.department = str;
        this.classId = i2;
        this.className = str2;
    }

    public int getClassId() {
        return this.classId;
    }

    public String getClassName() {
        return this.className;
    }

    public int getDepartId() {
        return this.departId;
    }

    public String getDepartment() {
        return this.department;
    }
}
