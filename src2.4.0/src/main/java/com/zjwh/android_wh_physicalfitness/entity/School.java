package com.zjwh.android_wh_physicalfitness.entity;

import java.io.Serializable;

public class School implements Serializable {
    private String firstLetter;
    private String imgFileUrl;
    private String name;
    private int unid;

    public School(String str) {
        this.firstLetter = str;
    }

    public String getFirstLetter() {
        return this.firstLetter;
    }

    public String getImgFileUrl() {
        return this.imgFileUrl;
    }

    public String getName() {
        return this.name;
    }

    public int getUnid() {
        return this.unid;
    }

    public void setFirstLetter(String str) {
        this.firstLetter = str;
    }

    public void setImgFileUrl(String str) {
        this.imgFileUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public String toString() {
        return getName();
    }
}
