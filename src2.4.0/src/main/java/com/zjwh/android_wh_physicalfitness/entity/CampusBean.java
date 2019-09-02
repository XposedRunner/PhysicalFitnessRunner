package com.zjwh.android_wh_physicalfitness.entity;

public class CampusBean {
    private String department;
    private int id;
    private int rootUnid;

    public String getDepartment() {
        return this.department;
    }

    public int getId() {
        return this.id;
    }

    public int getRootUnid() {
        return this.rootUnid;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CampusBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", rootUnid=");
        stringBuilder.append(this.rootUnid);
        stringBuilder.append(", department='");
        stringBuilder.append(this.department);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
