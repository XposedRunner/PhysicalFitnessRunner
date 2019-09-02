package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class SchoolsAndSemeBean {
    private boolean isSelected = false;
    private String name;
    private int rootUnid;
    private List<SemesterInfoBean> semesters;

    public String getName() {
        return this.name;
    }

    public int getRootUnid() {
        return this.rootUnid;
    }

    public List<SemesterInfoBean> getSemesters() {
        return this.semesters;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRootUnid(int i) {
        this.rootUnid = i;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setSemesters(List<SemesterInfoBean> list) {
        this.semesters = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SchoolsAndSemeBean{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", rootUnid=");
        stringBuilder.append(this.rootUnid);
        stringBuilder.append(", semesters=");
        stringBuilder.append(this.semesters);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
