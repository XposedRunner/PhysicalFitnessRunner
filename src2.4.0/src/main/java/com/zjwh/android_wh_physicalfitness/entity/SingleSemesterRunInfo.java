package com.zjwh.android_wh_physicalfitness.entity;

public class SingleSemesterRunInfo {
    private int semesterDis;
    private int semesterValidDis;
    private String sname;

    public int getSemesterDis() {
        return this.semesterDis;
    }

    public int getSemesterValidDis() {
        return this.semesterValidDis;
    }

    public String getSname() {
        return this.sname;
    }

    public void setSemesterDis(int i) {
        this.semesterDis = i;
    }

    public void setSemesterValidDis(int i) {
        this.semesterValidDis = i;
    }

    public void setSname(String str) {
        this.sname = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SingleSemesterRunInfo{semesterDis=");
        stringBuilder.append(this.semesterDis);
        stringBuilder.append(", semesterValidDis=");
        stringBuilder.append(this.semesterValidDis);
        stringBuilder.append(", sname='");
        stringBuilder.append(this.sname);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
