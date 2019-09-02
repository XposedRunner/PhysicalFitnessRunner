package com.zjwh.android_wh_physicalfitness.entity;

import android.support.annotation.NonNull;

public class MainBottomItemBean implements Comparable<MainBottomItemBean> {
    public static final int MAIN_BOTTOM_COMMERCE = 10005;
    public static final int MAIN_BOTTOM_DYNAMIC = 10003;
    public static final int MAIN_BOTTOM_FIND = 10002;
    public static final int MAIN_BOTTOM_MINE = 10004;
    public static final int MAIN_BOTTOM_RUN = 10001;
    private String colorNormal;
    private String colorSelected;
    private String iconNormal;
    private String iconSelected;
    private int moduleId;
    private int order;
    private String text;

    public int compareTo(@NonNull MainBottomItemBean mainBottomItemBean) {
        return getOrder() - mainBottomItemBean.getOrder();
    }

    public String getColorNormal() {
        return this.colorNormal;
    }

    public String getColorSelected() {
        return this.colorSelected;
    }

    public String getIconNormal() {
        return this.iconNormal;
    }

    public String getIconSelected() {
        return this.iconSelected;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public int getOrder() {
        return this.order;
    }

    public String getText() {
        return this.text;
    }

    public void setColorNormal(String str) {
        this.colorNormal = str;
    }

    public void setColorSelected(String str) {
        this.colorSelected = str;
    }

    public void setIconNormal(String str) {
        this.iconNormal = str;
    }

    public void setIconSelected(String str) {
        this.iconSelected = str;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public void setText(String str) {
        this.text = str;
    }
}
