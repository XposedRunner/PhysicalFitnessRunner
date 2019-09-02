package com.zjwh.android_wh_physicalfitness.entity;

import android.text.TextUtils;
import java.util.List;

public class Folder {
    public ImageEntity cover;
    public List<ImageEntity> images;
    public String name;
    public String path;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return TextUtils.equals(((Folder) obj).path, this.path);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return super.equals(obj);
        }
    }
}
