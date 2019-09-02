package com.zjwh.android_wh_physicalfitness.entity;

public class StuClassResModel extends MyStudentBean {
    public int cid;
    public String className;
    public int studentNum;

    public StuClassResModel() {
        setViewType(1);
    }

    public StuClassResModel(int i, String str, int i2) {
        this.cid = i;
        this.className = str;
        this.studentNum = i2;
    }

    public int getCid() {
        return this.cid;
    }

    public String getClassName() {
        return this.className;
    }

    public int getStudentNum() {
        return this.studentNum;
    }

    public void setCid(int i) {
        this.cid = i;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setStudentNum(int i) {
        this.studentNum = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StuClassResModel{cid=");
        stringBuilder.append(this.cid);
        stringBuilder.append(", className='");
        stringBuilder.append(this.className);
        stringBuilder.append('\'');
        stringBuilder.append(", studentNum=");
        stringBuilder.append(this.studentNum);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
