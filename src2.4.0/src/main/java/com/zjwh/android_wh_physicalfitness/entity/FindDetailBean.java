package com.zjwh.android_wh_physicalfitness.entity;

public class FindDetailBean {
    private CommentBean mBean;
    private int mSize;
    private String mText;
    private int mViewType;

    public CommentBean getBean() {
        return this.mBean;
    }

    public int getSize() {
        return this.mSize;
    }

    public String getText() {
        return this.mText;
    }

    public int getViewType() {
        return this.mViewType;
    }

    public void setBean(CommentBean commentBean) {
        this.mBean = commentBean;
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setViewType(int i) {
        this.mViewType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FindDetailBean{mViewType=");
        stringBuilder.append(this.mViewType);
        stringBuilder.append(", mText='");
        stringBuilder.append(this.mText);
        stringBuilder.append('\'');
        stringBuilder.append(", mSize=");
        stringBuilder.append(this.mSize);
        stringBuilder.append(", mBean=");
        stringBuilder.append(this.mBean);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
