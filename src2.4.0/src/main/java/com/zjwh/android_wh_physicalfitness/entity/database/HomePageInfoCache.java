package com.zjwh.android_wh_physicalfitness.entity.database;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "homepage_info")
public class HomePageInfoCache {
    @Column(name = "homepage_info")
    private String homepageInfoJson;
    @Column(autoGen = false, isId = true, name = "uid")
    private int uid;

    public HomePageInfoCache(int i, String str) {
        this.uid = i;
        this.homepageInfoJson = str;
    }

    public String getHomepageInfoJson() {
        return this.homepageInfoJson;
    }

    public int getUid() {
        return this.uid;
    }

    public void setHomepageInfoJson(String str) {
        this.homepageInfoJson = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HomePageInfoCache{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", homepageInfoJson='");
        stringBuilder.append(this.homepageInfoJson);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
