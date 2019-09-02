package com.zjwh.android_wh_physicalfitness.entity.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MusicClassifyBean implements Parcelable {
    public static final Creator<MusicClassifyBean> CREATOR = new Creator<MusicClassifyBean>() {
        public MusicClassifyBean createFromParcel(Parcel parcel) {
            return new MusicClassifyBean(parcel);
        }

        public MusicClassifyBean[] newArray(int i) {
            return new MusicClassifyBean[i];
        }
    };
    private Long classifyId;
    private String classifyName;
    private int iconId;
    private String[] tags;

    protected MusicClassifyBean(Parcel parcel) {
        this.classifyId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.classifyName = parcel.readString();
        this.iconId = parcel.readInt();
        this.tags = parcel.createStringArray();
    }

    public MusicClassifyBean(Long l, String str, int i) {
        this.classifyId = l;
        this.classifyName = str;
        this.iconId = i;
    }

    public MusicClassifyBean(Long l, String str, int i, String[] strArr) {
        this.classifyId = l;
        this.classifyName = str;
        this.iconId = i;
        this.tags = strArr;
    }

    public MusicClassifyBean(String str, int i, String[] strArr) {
        this.classifyName = str;
        this.iconId = i;
        this.tags = strArr;
    }

    public int describeContents() {
        return 0;
    }

    public Long getClassifyId() {
        return this.classifyId;
    }

    public String getClassifyName() {
        return this.classifyName;
    }

    public int getIconId() {
        return this.iconId;
    }

    public String[] getTags() {
        return this.tags;
    }

    public void setClassifyId(Long l) {
        this.classifyId = l;
    }

    public void setClassifyName(String str) {
        this.classifyName = str;
    }

    public void setIconId(int i) {
        this.iconId = i;
    }

    public void setTags(String[] strArr) {
        this.tags = strArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.classifyId);
        parcel.writeString(this.classifyName);
        parcel.writeInt(this.iconId);
        parcel.writeStringArray(this.tags);
    }
}
