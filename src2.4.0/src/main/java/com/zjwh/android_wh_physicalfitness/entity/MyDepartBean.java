package com.zjwh.android_wh_physicalfitness.entity;

public class MyDepartBean {
    private String department;
    private int id;
    private int rootUnid;
    private boolean showClassEnum;

    public String getDepartment() {
        return this.department;
    }

    public int getId() {
        return this.id;
    }

    public int getRootUnid() {
        return this.rootUnid;
    }

    public boolean isShowClassEnum() {
        return this.showClassEnum;
    }

    public void setDepartment(String str) {
        this.department = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setRootUnid(int i) {
        this.rootUnid = i;
    }

    public void setShowClassEnum(boolean z) {
        this.showClassEnum = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyDepartBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", rootUnid=");
        stringBuilder.append(this.rootUnid);
        stringBuilder.append(", department='");
        stringBuilder.append(this.department);
        stringBuilder.append('\'');
        stringBuilder.append(", showClassEnum=");
        stringBuilder.append(this.showClassEnum);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
