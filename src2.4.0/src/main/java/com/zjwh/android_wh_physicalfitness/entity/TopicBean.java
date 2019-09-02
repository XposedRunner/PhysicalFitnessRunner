package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TopicBean implements Parcelable {
    public static final Creator<TopicBean> CREATOR = new Creator<TopicBean>() {
        public TopicBean createFromParcel(Parcel parcel) {
            return new TopicBean(parcel);
        }

        public TopicBean[] newArray(int i) {
            return new TopicBean[i];
        }
    };
    private String coverUrl;
    private int hot;
    private int id;
    private String imgUrl;
    private boolean newAdd;
    private int participateNum;
    private String summary;
    private String title;

    protected TopicBean(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.coverUrl = parcel.readString();
        this.summary = parcel.readString();
        this.hot = parcel.readInt();
        this.participateNum = parcel.readInt();
        this.imgUrl = parcel.readString();
        this.newAdd = parcel.readByte() != (byte) 0;
    }

    public int describeContents() {
        return 0;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getHot() {
        return this.hot;
    }

    public int getId() {
        return this.id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getParticipateNum() {
        return this.participateNum;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isNewAdd() {
        return this.newAdd;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setHot(int i) {
        this.hot = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setNewAdd(boolean z) {
        this.newAdd = z;
    }

    public void setParticipateNum(int i) {
        this.participateNum = i;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TopicBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrl='");
        stringBuilder.append(this.coverUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", summary='");
        stringBuilder.append(this.summary);
        stringBuilder.append('\'');
        stringBuilder.append(", hot=");
        stringBuilder.append(this.hot);
        stringBuilder.append(", participateNum=");
        stringBuilder.append(this.participateNum);
        stringBuilder.append(", imgUrl='");
        stringBuilder.append(this.imgUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", newAdd=");
        stringBuilder.append(this.newAdd);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.summary);
        parcel.writeInt(this.hot);
        parcel.writeInt(this.participateNum);
        parcel.writeString(this.imgUrl);
        parcel.writeByte(this.newAdd);
    }
}
