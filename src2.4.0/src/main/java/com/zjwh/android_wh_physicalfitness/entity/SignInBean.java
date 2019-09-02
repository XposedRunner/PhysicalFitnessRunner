package com.zjwh.android_wh_physicalfitness.entity;

public class SignInBean {
    private String device;
    private long endTime;
    private int fitAll;
    private int minDuration;
    private String name;
    private long recordId;
    private int signStatus;
    private long signinTime;
    private long signoutTime;
    private long startTime;
    private long targetId;
    private long validTime;

    public String getDevice() {
        return this.device;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getFitAll() {
        return this.fitAll;
    }

    public int getMinDuration() {
        return this.minDuration;
    }

    public String getName() {
        return this.name;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public int getSignStatus() {
        return this.signStatus;
    }

    public long getSigninTime() {
        return this.signinTime;
    }

    public long getSignoutTime() {
        return this.signoutTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getTargetId() {
        return this.targetId;
    }

    public long getValidTime() {
        return this.validTime;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setFitAll(int i) {
        this.fitAll = i;
    }

    public void setMinDuration(int i) {
        this.minDuration = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public void setSignStatus(int i) {
        this.signStatus = i;
    }

    public void setSigninTime(long j) {
        this.signinTime = j;
    }

    public void setSignoutTime(long j) {
        this.signoutTime = j;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setTargetId(long j) {
        this.targetId = j;
    }

    public void setValidTime(long j) {
        this.validTime = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignInBean{recordId=");
        stringBuilder.append(this.recordId);
        stringBuilder.append(", targetId=");
        stringBuilder.append(this.targetId);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append(", signStatus=");
        stringBuilder.append(this.signStatus);
        stringBuilder.append(", signoutTime=");
        stringBuilder.append(this.signoutTime);
        stringBuilder.append(", signinTime=");
        stringBuilder.append(this.signinTime);
        stringBuilder.append(", device='");
        stringBuilder.append(this.device);
        stringBuilder.append('\'');
        stringBuilder.append(", validTime=");
        stringBuilder.append(this.validTime);
        stringBuilder.append(", minDuration=");
        stringBuilder.append(this.minDuration);
        stringBuilder.append(", fitAll=");
        stringBuilder.append(this.fitAll);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
