package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class AttendanceListBean {
    private List<AttendanceValidBean> fragments;
    private long signinTime;
    private int status;
    private int validTime;

    public List<AttendanceValidBean> getFragments() {
        return this.fragments;
    }

    public long getSigninTime() {
        return this.signinTime;
    }

    public int getStatus() {
        return this.status;
    }

    public int getValidTime() {
        return this.validTime;
    }

    public void setFragments(List<AttendanceValidBean> list) {
        this.fragments = list;
    }

    public void setSigninTime(long j) {
        this.signinTime = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setValidTime(int i) {
        this.validTime = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttendanceListBean{status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", signinTime=");
        stringBuilder.append(this.signinTime);
        stringBuilder.append(", fragments=");
        stringBuilder.append(this.fragments);
        stringBuilder.append(", validTime=");
        stringBuilder.append(this.validTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
