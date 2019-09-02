package com.zjwh.android_wh_physicalfitness.entity;

public class ClassReqModel {
    public int cid;
    public int mid;

    public ClassReqModel(int i, int i2) {
        this.mid = i;
        this.cid = i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassReqModel{mid=");
        stringBuilder.append(this.mid);
        stringBuilder.append(", cid=");
        stringBuilder.append(this.cid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
