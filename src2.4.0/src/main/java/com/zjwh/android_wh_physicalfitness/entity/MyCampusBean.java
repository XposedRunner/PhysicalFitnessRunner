package com.zjwh.android_wh_physicalfitness.entity;

public class MyCampusBean {
    private boolean isSelected;
    private String name;
    private int unid;

    public String getName() {
        return this.name;
    }

    public int getUnid() {
        return this.unid;
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

    public void setUnid(int i) {
        this.unid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyCampusBean{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
