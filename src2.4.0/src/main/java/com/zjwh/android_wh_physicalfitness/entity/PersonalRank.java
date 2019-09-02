package com.zjwh.android_wh_physicalfitness.entity;

public class PersonalRank {
    private String bicon;
    private double dis;
    private int gender;
    private String icon;
    private String name;
    private int order;
    private String psign;
    private int uid;

    public String getBicon() {
        return this.bicon;
    }

    public double getDis() {
        return this.dis;
    }

    public int getGender() {
        return this.gender;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public int getOrder() {
        return this.order;
    }

    public String getPsign() {
        return this.psign;
    }

    public int getUid() {
        return this.uid;
    }

    public void setBicon(String str) {
        this.bicon = str;
    }

    public void setDis(double d) {
        this.dis = d;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public void setPsign(String str) {
        this.psign = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersonalRank{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", psign='");
        stringBuilder.append(this.psign);
        stringBuilder.append('\'');
        stringBuilder.append(", dis=");
        stringBuilder.append(this.dis);
        stringBuilder.append(", order=");
        stringBuilder.append(this.order);
        stringBuilder.append(", icon='");
        stringBuilder.append(this.icon);
        stringBuilder.append('\'');
        stringBuilder.append(", bicon='");
        stringBuilder.append(this.bicon);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
