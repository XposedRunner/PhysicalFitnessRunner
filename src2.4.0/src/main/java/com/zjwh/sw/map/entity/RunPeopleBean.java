package com.zjwh.sw.map.entity;

public class RunPeopleBean extends SWLatLng {
    private boolean isChoose;
    private int sex;
    private int uid;
    private String uuid;

    public RunPeopleBean(double d, double d2, double d3, double d4) {
        super(d, d2, d3, d4);
    }

    public int getSex() {
        return this.sex;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isChoose() {
        return this.isChoose;
    }

    public void setChoose(boolean z) {
        this.isChoose = z;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunPeopleBean{sex=");
        stringBuilder.append(this.sex);
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append(", isChoose=");
        stringBuilder.append(this.isChoose);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
