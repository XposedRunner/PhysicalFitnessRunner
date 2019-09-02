package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class ClassInfoBean {
    private int rootUnid;
    private String schoolName;
    private String semesterName;
    private int semesterid;
    private List<StuClassResModel> studentAndClass;

    public int getRootUnid() {
        return this.rootUnid;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public String getSemesterName() {
        return this.semesterName;
    }

    public int getSemesterid() {
        return this.semesterid;
    }

    public List<StuClassResModel> getStudentAndClass() {
        return this.studentAndClass;
    }

    public void setRootUnid(int i) {
        this.rootUnid = i;
    }

    public void setSchoolName(String str) {
        this.schoolName = str;
    }

    public void setSemesterName(String str) {
        this.semesterName = str;
    }

    public void setSemesterid(int i) {
        this.semesterid = i;
    }

    public void setStudentAndClass(List<StuClassResModel> list) {
        this.studentAndClass = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassInfoBean{rootUnid=");
        stringBuilder.append(this.rootUnid);
        stringBuilder.append(", schoolName='");
        stringBuilder.append(this.schoolName);
        stringBuilder.append('\'');
        stringBuilder.append(", semesterid=");
        stringBuilder.append(this.semesterid);
        stringBuilder.append(", semesterName='");
        stringBuilder.append(this.semesterName);
        stringBuilder.append('\'');
        stringBuilder.append(", studentAndClass=");
        stringBuilder.append(this.studentAndClass);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
