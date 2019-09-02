package com.zjwh.android_wh_physicalfitness.entity.rank;

public class RankCheatBean {
    private String campusId;
    private int count;
    private String iconUrl;
    private String name;
    private int sex;

    public String getCampusId() {
        return this.campusId;
    }

    public int getCount() {
        return this.count;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public int getSex() {
        return this.sex;
    }

    public void setCampusId(String str) {
        this.campusId = str;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RankCheatBean{campusId='");
        stringBuilder.append(this.campusId);
        stringBuilder.append('\'');
        stringBuilder.append(", iconUrl='");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", sex=");
        stringBuilder.append(this.sex);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
