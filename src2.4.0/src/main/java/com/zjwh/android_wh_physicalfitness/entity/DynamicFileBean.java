package com.zjwh.android_wh_physicalfitness.entity;

public class DynamicFileBean {
    private int fileType;
    private boolean isImage;
    private String url;

    public int getFileType() {
        return this.fileType;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isImage() {
        return this.fileType == 0 || this.fileType == 1;
    }

    public void setFileType(int i) {
        this.fileType = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
