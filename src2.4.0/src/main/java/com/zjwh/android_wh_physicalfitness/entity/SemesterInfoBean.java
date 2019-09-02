package com.zjwh.android_wh_physicalfitness.entity;

public class SemesterInfoBean {
    private boolean isSelected;
    private String name;
    private int sid;

    public String getName() {
        return this.name;
    }

    public int getSid() {
        return this.sid;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setSid(int i) {
        this.sid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SemesterInfoBean{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", sid=");
        stringBuilder.append(this.sid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
