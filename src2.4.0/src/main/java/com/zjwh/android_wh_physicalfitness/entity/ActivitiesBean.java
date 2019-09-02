package com.zjwh.android_wh_physicalfitness.entity;

public class ActivitiesBean {
    private int activityId;
    private int activityStatus;
    private String activityUrl;
    private String bigImageUrl;
    private String name;
    private boolean newAdd;

    public int getActivityId() {
        return this.activityId;
    }

    public int getActivityStatus() {
        return this.activityStatus;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String getBigImageUrl() {
        return this.bigImageUrl;
    }

    public String getName() {
        return this.name;
    }

    public boolean isNewAdd() {
        return this.newAdd;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }

    public void setActivityStatus(int i) {
        this.activityStatus = i;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public void setBigImageUrl(String str) {
        this.bigImageUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNewAdd(boolean z) {
        this.newAdd = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActivitiesBean{activityId=");
        stringBuilder.append(this.activityId);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", bigImageUrl='");
        stringBuilder.append(this.bigImageUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", activityUrl='");
        stringBuilder.append(this.activityUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", activityStatus=");
        stringBuilder.append(this.activityStatus);
        stringBuilder.append(", newAdd=");
        stringBuilder.append(this.newAdd);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
