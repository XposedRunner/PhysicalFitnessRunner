package com.zjwh.android_wh_physicalfitness.entity;

import android.graphics.Bitmap;

public class ImageFilterBean {
    private Bitmap bitmap;
    private boolean isSelect;
    private String tvFilter;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getTvFilter() {
        return this.tvFilter;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setTvFilter(String str) {
        this.tvFilter = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImageFilterBean{tvFilter='");
        stringBuilder.append(this.tvFilter);
        stringBuilder.append('\'');
        stringBuilder.append(", bitmap=");
        stringBuilder.append(this.bitmap);
        stringBuilder.append(", isSelect=");
        stringBuilder.append(this.isSelect);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
