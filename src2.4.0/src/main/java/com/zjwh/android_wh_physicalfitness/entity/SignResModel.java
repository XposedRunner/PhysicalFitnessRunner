package com.zjwh.android_wh_physicalfitness.entity;

public class SignResModel implements Comparable<SignResModel> {
    public String campusId;
    public String name;
    public int status;
    public int uid;

    public SignResModel(int i, String str, String str2, int i2) {
        this.uid = i;
        this.name = str;
        this.campusId = str2;
        this.status = i2;
    }

    public int compareTo(SignResModel signResModel) {
        return this.campusId.compareTo(signResModel.campusId);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignResModel{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", campusId='");
        stringBuilder.append(this.campusId);
        stringBuilder.append('\'');
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
