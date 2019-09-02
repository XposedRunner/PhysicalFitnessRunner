package com.zjwh.android_wh_physicalfitness.entity;

public class RoomersModel {
    private String endTime;
    private boolean finished;
    private String icon;
    private boolean isIniter;
    private String name;
    private String points;
    private int runstatus;
    private int sex;
    private int uid;
    private int unid;

    public String getEndTime() {
        return this.endTime;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getPoints() {
        return this.points;
    }

    public int getRunstatus() {
        return this.runstatus;
    }

    public int getSex() {
        return this.sex;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnid() {
        return this.unid;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isIniter() {
        return this.isIniter;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setFinished(boolean z) {
        this.finished = z;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIniter(boolean z) {
        this.isIniter = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public void setRunstatus(int i) {
        this.runstatus = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }
}
