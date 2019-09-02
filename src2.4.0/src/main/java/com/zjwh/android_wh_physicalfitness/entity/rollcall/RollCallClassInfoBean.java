package com.zjwh.android_wh_physicalfitness.entity.rollcall;

public class RollCallClassInfoBean {
    private String className;
    private int crcid;
    private String device;
    private int rollCallStatus;
    private int signStatus;
    private int studentCount;
    private String teacherName;

    public String getClassName() {
        return this.className;
    }

    public int getCrcid() {
        return this.crcid;
    }

    public String getDevice() {
        return this.device;
    }

    public int getRollCallStatus() {
        return this.rollCallStatus;
    }

    public int getSignStatus() {
        return this.signStatus;
    }

    public int getStudentCount() {
        return this.studentCount;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setCrcid(int i) {
        this.crcid = i;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setRollCallStatus(int i) {
        this.rollCallStatus = i;
    }

    public void setSignStatus(int i) {
        this.signStatus = i;
    }

    public void setStudentCount(int i) {
        this.studentCount = i;
    }

    public void setTeacherName(String str) {
        this.teacherName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RollCallClassInfoBean{className='");
        stringBuilder.append(this.className);
        stringBuilder.append('\'');
        stringBuilder.append(", teacherName='");
        stringBuilder.append(this.teacherName);
        stringBuilder.append('\'');
        stringBuilder.append(", studentCount=");
        stringBuilder.append(this.studentCount);
        stringBuilder.append(", rollCallStatus=");
        stringBuilder.append(this.rollCallStatus);
        stringBuilder.append(", signStatus=");
        stringBuilder.append(this.signStatus);
        stringBuilder.append(", device='");
        stringBuilder.append(this.device);
        stringBuilder.append('\'');
        stringBuilder.append(", crcid=");
        stringBuilder.append(this.crcid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
