package com.zjwh.android_wh_physicalfitness.entity;

public class ActivityTipBean {
    private String activityImgUrl;
    private String activityUrl;

    public String getActivityImgUrl() {
        return this.activityImgUrl;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public void setActivityImgUrl(String str) {
        this.activityImgUrl = str;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActivityTipBean{activityUrl='");
        stringBuilder.append(this.activityUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", activityImgUrl='");
        stringBuilder.append(this.activityImgUrl);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
