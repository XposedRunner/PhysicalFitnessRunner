package com.zjwh.android_wh_physicalfitness.entity.request;

import java.util.List;

public class SchoolNumBackBean {
    private String campus;
    private String campusId;
    private List<String> imageUrls;
    private String name;
    private String phone;
    private int unid;

    public SchoolNumBackBean(String str, String str2, List<String> list, String str3, String str4, int i) {
        this.campus = str;
        this.campusId = str2;
        this.imageUrls = list;
        this.name = str3;
        this.phone = str4;
        this.unid = i;
    }

    public String getCampus() {
        return this.campus;
    }

    public String getCampusId() {
        return this.campusId;
    }

    public List<String> getImageUrls() {
        return this.imageUrls;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getUnid() {
        return this.unid;
    }

    public void setCampus(String str) {
        this.campus = str;
    }

    public void setCampusId(String str) {
        this.campusId = str;
    }

    public void setImageUrls(List<String> list) {
        this.imageUrls = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SchoolNumBackBean{campus='");
        stringBuilder.append(this.campus);
        stringBuilder.append('\'');
        stringBuilder.append(", campusId='");
        stringBuilder.append(this.campusId);
        stringBuilder.append('\'');
        stringBuilder.append(", imageUrls=");
        stringBuilder.append(this.imageUrls);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", phone='");
        stringBuilder.append(this.phone);
        stringBuilder.append('\'');
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
