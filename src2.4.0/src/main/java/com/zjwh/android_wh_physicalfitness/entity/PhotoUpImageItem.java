package com.zjwh.android_wh_physicalfitness.entity;

import java.io.Serializable;

public class PhotoUpImageItem implements Serializable {
    private String imageId;
    private String imagePath;
    private boolean isSelected = false;

    public String getImageId() {
        return this.imageId;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setImageId(String str) {
        this.imageId = str;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
