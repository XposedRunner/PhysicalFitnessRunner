package com.zjwh.android_wh_physicalfitness.entity.request;

public class QCompleteUserInfo {
    private String campusId;
    private String campusName;
    private int classId;
    private String depart;
    private int departmentId;
    private int enrollmentYear;
    private int gender;
    private String gradeClass;
    private String name;
    private int type;
    private long unid;

    public QCompleteUserInfo(long j, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5) {
        this.unid = j;
        this.campusId = str;
        this.name = str2;
        this.depart = str3;
        this.campusName = str4;
        this.gradeClass = str5;
        this.classId = i;
        this.gender = i2;
        this.enrollmentYear = i3;
        this.departmentId = i4;
        this.type = i5;
    }

    public String getCampusId() {
        return this.campusId;
    }

    public String getCampusName() {
        return this.campusName;
    }

    public String getDepart() {
        return this.depart;
    }

    public int getDepartmentId() {
        return this.departmentId;
    }

    public int getEnrollmentYear() {
        return this.enrollmentYear;
    }

    public int getGender() {
        return this.gender;
    }

    public String getGradeClass() {
        return this.gradeClass;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public long getUnid() {
        return this.unid;
    }

    public void setCampusId(String str) {
        this.campusId = str;
    }

    public void setCampusName(String str) {
        this.campusName = str;
    }

    public void setDepart(String str) {
        this.depart = str;
    }

    public void setDepartmentId(int i) {
        this.departmentId = i;
    }

    public void setEnrollmentYear(int i) {
        this.enrollmentYear = i;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setGradeClass(String str) {
        this.gradeClass = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUnid(long j) {
        this.unid = j;
    }
}
