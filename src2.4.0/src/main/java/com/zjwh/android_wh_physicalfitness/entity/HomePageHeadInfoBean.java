package com.zjwh.android_wh_physicalfitness.entity;

import com.google.gson.annotations.SerializedName;

public class HomePageHeadInfoBean {
    @SerializedName(alternate = {"bicon"}, value = "bIcon")
    private String bIcon;
    private String campusName;
    private String departmentName;
    private int enrollmentYear;
    private int fansNum;
    private int gender;
    private String icon;
    private int interestNum;
    private int interestStatus;
    private String name;
    private String perSign;
    private int praiseNum;

    public String getCampusName() {
        return this.campusName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public int getEnrollmentYear() {
        return this.enrollmentYear;
    }

    public int getFansNum() {
        return this.fansNum;
    }

    public int getGender() {
        return this.gender;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getInterestNum() {
        return this.interestNum;
    }

    public int getInterestStatus() {
        return this.interestStatus;
    }

    public String getName() {
        return this.name;
    }

    public String getPerSign() {
        return this.perSign;
    }

    public int getPraiseNum() {
        return this.praiseNum;
    }

    public String getbIcon() {
        return this.bIcon;
    }

    public void setCampusName(String str) {
        this.campusName = str;
    }

    public void setDepartmentName(String str) {
        this.departmentName = str;
    }

    public void setEnrollmentYear(int i) {
        this.enrollmentYear = i;
    }

    public void setFansNum(int i) {
        this.fansNum = i;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setInterestNum(int i) {
        this.interestNum = i;
    }

    public void setInterestStatus(int i) {
        this.interestStatus = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPerSign(String str) {
        this.perSign = str;
    }

    public void setPraiseNum(int i) {
        this.praiseNum = i;
    }

    public void setbIcon(String str) {
        this.bIcon = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HomePageHeadInfoBean{gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", perSign='");
        stringBuilder.append(this.perSign);
        stringBuilder.append('\'');
        stringBuilder.append(", campusName='");
        stringBuilder.append(this.campusName);
        stringBuilder.append('\'');
        stringBuilder.append(", departmentName='");
        stringBuilder.append(this.departmentName);
        stringBuilder.append('\'');
        stringBuilder.append(", enrollmentYear=");
        stringBuilder.append(this.enrollmentYear);
        stringBuilder.append(", icon='");
        stringBuilder.append(this.icon);
        stringBuilder.append('\'');
        stringBuilder.append(", bIcon='");
        stringBuilder.append(this.bIcon);
        stringBuilder.append('\'');
        stringBuilder.append(", fansNum=");
        stringBuilder.append(this.fansNum);
        stringBuilder.append(", interestNum=");
        stringBuilder.append(this.interestNum);
        stringBuilder.append(", praiseNum=");
        stringBuilder.append(this.praiseNum);
        stringBuilder.append(", interestStatus=");
        stringBuilder.append(this.interestStatus);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
