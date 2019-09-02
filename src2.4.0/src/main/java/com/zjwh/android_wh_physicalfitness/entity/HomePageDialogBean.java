package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HomePageDialogBean implements Parcelable {
    public static final Creator<HomePageDialogBean> CREATOR = new Creator<HomePageDialogBean>() {
        public HomePageDialogBean createFromParcel(Parcel parcel) {
            return new HomePageDialogBean(parcel);
        }

        public HomePageDialogBean[] newArray(int i) {
            return new HomePageDialogBean[i];
        }
    };
    private String adExposingCodes;
    private int bounceId;
    private int bounceType;
    private String btnText;
    private String imgUrl;
    private String irregularImgUrl;
    private String mainTitle;
    private String subTitle;
    private String targetUrl;

    protected HomePageDialogBean(Parcel parcel) {
        this.bounceId = parcel.readInt();
        this.imgUrl = parcel.readString();
        this.mainTitle = parcel.readString();
        this.subTitle = parcel.readString();
        this.btnText = parcel.readString();
        this.targetUrl = parcel.readString();
        this.bounceType = parcel.readInt();
        this.irregularImgUrl = parcel.readString();
        this.adExposingCodes = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdExposingCodes() {
        return this.adExposingCodes;
    }

    public int getBounceId() {
        return this.bounceId;
    }

    public int getBounceType() {
        return this.bounceType;
    }

    public String getBtnText() {
        return this.btnText;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getIrregularImgUrl() {
        return this.irregularImgUrl;
    }

    public String getMainTitle() {
        return this.mainTitle;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public void setAdExposingCodes(String str) {
        this.adExposingCodes = str;
    }

    public void setBounceId(int i) {
        this.bounceId = i;
    }

    public void setBounceType(int i) {
        this.bounceType = i;
    }

    public void setBtnText(String str) {
        this.btnText = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setIrregularImgUrl(String str) {
        this.irregularImgUrl = str;
    }

    public void setMainTitle(String str) {
        this.mainTitle = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTargetUrl(String str) {
        this.targetUrl = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HomePageDialogBean{bounceId=");
        stringBuilder.append(this.bounceId);
        stringBuilder.append(", imgUrl='");
        stringBuilder.append(this.imgUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", mainTitle='");
        stringBuilder.append(this.mainTitle);
        stringBuilder.append('\'');
        stringBuilder.append(", subTitle='");
        stringBuilder.append(this.subTitle);
        stringBuilder.append('\'');
        stringBuilder.append(", btnText='");
        stringBuilder.append(this.btnText);
        stringBuilder.append('\'');
        stringBuilder.append(", targetUrl='");
        stringBuilder.append(this.targetUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", bounceType=");
        stringBuilder.append(this.bounceType);
        stringBuilder.append(", irregularImgUrl='");
        stringBuilder.append(this.irregularImgUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", adExposingCodes='");
        stringBuilder.append(this.adExposingCodes);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bounceId);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.mainTitle);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.btnText);
        parcel.writeString(this.targetUrl);
        parcel.writeInt(this.bounceType);
        parcel.writeString(this.irregularImgUrl);
        parcel.writeString(this.adExposingCodes);
    }
}
