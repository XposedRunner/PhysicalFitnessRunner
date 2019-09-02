package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DynamicCommentBean implements Parcelable {
    public static final Creator<DynamicCommentBean> CREATOR = new Creator<DynamicCommentBean>() {
        public DynamicCommentBean createFromParcel(Parcel parcel) {
            return new DynamicCommentBean(parcel);
        }

        public DynamicCommentBean[] newArray(int i) {
            return new DynamicCommentBean[i];
        }
    };
    private String commentContent;
    private int commentId;
    private String commentName;

    public DynamicCommentBean(int i, String str, String str2) {
        this.commentId = i;
        this.commentName = str;
        this.commentContent = str2;
    }

    protected DynamicCommentBean(Parcel parcel) {
        this.commentId = parcel.readInt();
        this.commentName = parcel.readString();
        this.commentContent = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    public int getCommentId() {
        return this.commentId;
    }

    public String getCommentName() {
        return this.commentName;
    }

    public void setCommentContent(String str) {
        this.commentContent = str;
    }

    public void setCommentId(int i) {
        this.commentId = i;
    }

    public void setCommentName(String str) {
        this.commentName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DynamicCommentBean{commentId=");
        stringBuilder.append(this.commentId);
        stringBuilder.append(", commentName='");
        stringBuilder.append(this.commentName);
        stringBuilder.append('\'');
        stringBuilder.append(", commentContent='");
        stringBuilder.append(this.commentContent);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.commentId);
        parcel.writeString(this.commentName);
        parcel.writeString(this.commentContent);
    }
}
