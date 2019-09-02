package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class MainBottomBean {
    private String adExposingCodes;
    private List<MainBottomItemBean> list;

    public String getAdExposingCodes() {
        return this.adExposingCodes;
    }

    public List<MainBottomItemBean> getList() {
        return this.list;
    }

    public void setAdExposingCodes(String str) {
        this.adExposingCodes = str;
    }

    public void setList(List<MainBottomItemBean> list) {
        this.list = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MainBottomBean{adExposingCodes='");
        stringBuilder.append(this.adExposingCodes);
        stringBuilder.append('\'');
        stringBuilder.append(", list=");
        stringBuilder.append(this.list);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
