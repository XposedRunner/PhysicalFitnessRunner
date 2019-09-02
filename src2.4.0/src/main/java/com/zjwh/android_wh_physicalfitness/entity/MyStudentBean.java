package com.zjwh.android_wh_physicalfitness.entity;

public class MyStudentBean {
    private String title;
    private int viewType;

    public String getTitle() {
        return this.title;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyStudentBean{viewType=");
        stringBuilder.append(this.viewType);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
