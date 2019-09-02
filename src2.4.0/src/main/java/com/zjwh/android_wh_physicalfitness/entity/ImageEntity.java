package com.zjwh.android_wh_physicalfitness.entity;

public class ImageEntity {
    public String name;
    public String path;
    public long time;

    public ImageEntity(String str, String str2, long j) {
        this.path = str;
        this.name = str2;
        this.time = j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.path.equalsIgnoreCase(((ImageEntity) obj).path);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return super.equals(obj);
        }
    }
}
