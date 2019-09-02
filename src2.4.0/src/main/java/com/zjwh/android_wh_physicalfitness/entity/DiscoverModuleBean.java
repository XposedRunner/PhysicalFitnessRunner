package com.zjwh.android_wh_physicalfitness.entity;

public class DiscoverModuleBean {
    private String iconUrl;
    private String jumpUrl;
    private int moduleId;
    private String moduleName;

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DiscoverModuleBean{moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", iconUrl='");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", jumpUrl='");
        stringBuilder.append(this.jumpUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", moduleName='");
        stringBuilder.append(this.moduleName);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
