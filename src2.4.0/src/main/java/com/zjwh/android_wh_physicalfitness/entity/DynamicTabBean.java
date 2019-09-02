package com.zjwh.android_wh_physicalfitness.entity;

public class DynamicTabBean {
    private int imageResId;
    private int imageSelectResId;
    private boolean isImage;
    private String text;

    public DynamicTabBean(int i, int i2) {
        this.imageResId = i;
        this.imageSelectResId = i2;
        this.isImage = true;
    }

    public DynamicTabBean(int i, int i2, String str, boolean z) {
        this.imageResId = i;
        this.imageSelectResId = i2;
        this.text = str;
        this.isImage = z;
    }

    public DynamicTabBean(String str) {
        this.text = str;
        this.isImage = false;
    }

    public int getImageResId() {
        return this.imageResId;
    }

    public int getImageSelectResId() {
        return this.imageSelectResId;
    }

    public String getText() {
        return this.text;
    }

    public boolean isImage() {
        return this.isImage;
    }

    public void setImage(boolean z) {
        this.isImage = z;
    }

    public void setImageResId(int i) {
        this.imageResId = i;
    }

    public void setImageSelectResId(int i) {
        this.imageSelectResId = i;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DynamicTabBean{imageResId=");
        stringBuilder.append(this.imageResId);
        stringBuilder.append(", imageSelectResId=");
        stringBuilder.append(this.imageSelectResId);
        stringBuilder.append(", text='");
        stringBuilder.append(this.text);
        stringBuilder.append('\'');
        stringBuilder.append(", isImage=");
        stringBuilder.append(this.isImage);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
