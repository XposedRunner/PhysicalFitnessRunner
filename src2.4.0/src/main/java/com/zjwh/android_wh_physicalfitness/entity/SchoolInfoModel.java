package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class SchoolInfoModel {
    private String adPositionPlatform = "";
    private int members;
    private String name;
    private List<String> schoolPicUrls;

    public String getAdPositionPlatform() {
        return this.adPositionPlatform;
    }

    public int getMembers() {
        return this.members;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getSchoolPicUrls() {
        return this.schoolPicUrls;
    }

    public void setAdPositionPlatform(String str) {
        this.adPositionPlatform = str;
    }

    public void setMembers(int i) {
        this.members = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSchoolPicUrls(List<String> list) {
        this.schoolPicUrls = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SchoolInfoModel{members=");
        stringBuilder.append(this.members);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", schoolPicUrls=");
        stringBuilder.append(this.schoolPicUrls);
        stringBuilder.append(", adPositionPlatform='");
        stringBuilder.append(this.adPositionPlatform);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
