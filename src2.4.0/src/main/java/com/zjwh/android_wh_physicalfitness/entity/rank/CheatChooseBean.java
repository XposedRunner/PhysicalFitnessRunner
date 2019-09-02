package com.zjwh.android_wh_physicalfitness.entity.rank;

public class CheatChooseBean {
    private int uid;
    private String uuid;

    public CheatChooseBean(int i, String str) {
        this.uid = i;
        this.uuid = str;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CheatChooseBean{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
