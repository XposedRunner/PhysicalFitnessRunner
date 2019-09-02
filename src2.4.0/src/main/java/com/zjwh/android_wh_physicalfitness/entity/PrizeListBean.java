package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PrizeListBean implements Parcelable {
    public static final Creator<PrizeListBean> CREATOR = new Creator<PrizeListBean>() {
        public PrizeListBean createFromParcel(Parcel parcel) {
            return new PrizeListBean(parcel);
        }

        public PrizeListBean[] newArray(int i) {
            return new PrizeListBean[i];
        }
    };
    private String adExposingCodes;
    private String bgColor;
    private String defineText1;
    private String defineText2;
    private String definedUrl;
    private boolean isRedeem;
    private String logoUrl;
    private String prizeName;
    private long prizeValidEndTime;
    private long prizeValidStartTime;
    private String redeemText;

    protected PrizeListBean(Parcel parcel) {
        this.prizeName = parcel.readString();
        this.prizeValidStartTime = parcel.readLong();
        this.prizeValidEndTime = parcel.readLong();
        this.logoUrl = parcel.readString();
        this.bgColor = parcel.readString();
        this.isRedeem = parcel.readByte() != (byte) 0;
        this.definedUrl = parcel.readString();
        this.defineText1 = parcel.readString();
        this.defineText2 = parcel.readString();
        this.redeemText = parcel.readString();
        this.adExposingCodes = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdExposingCodes() {
        return this.adExposingCodes;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String getDefineText1() {
        return this.defineText1;
    }

    public String getDefineText2() {
        return this.defineText2;
    }

    public String getDefinedUrl() {
        return this.definedUrl;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public String getPrizeName() {
        return this.prizeName;
    }

    public long getPrizeValidEndTime() {
        return this.prizeValidEndTime;
    }

    public long getPrizeValidStartTime() {
        return this.prizeValidStartTime;
    }

    public String getRedeemText() {
        return this.redeemText;
    }

    public boolean isRedeem() {
        return this.isRedeem;
    }

    public void setAdExposingCodes(String str) {
        this.adExposingCodes = str;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setDefineText1(String str) {
        this.defineText1 = str;
    }

    public void setDefineText2(String str) {
        this.defineText2 = str;
    }

    public void setDefinedUrl(String str) {
        this.definedUrl = str;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public void setPrizeName(String str) {
        this.prizeName = str;
    }

    public void setPrizeValidEndTime(long j) {
        this.prizeValidEndTime = j;
    }

    public void setPrizeValidStartTime(long j) {
        this.prizeValidStartTime = j;
    }

    public void setRedeem(boolean z) {
        this.isRedeem = z;
    }

    public void setRedeemText(String str) {
        this.redeemText = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PrizeListBean{prizeName='");
        stringBuilder.append(this.prizeName);
        stringBuilder.append('\'');
        stringBuilder.append(", prizeValidStartTime=");
        stringBuilder.append(this.prizeValidStartTime);
        stringBuilder.append(", prizeValidEndTime=");
        stringBuilder.append(this.prizeValidEndTime);
        stringBuilder.append(", logoUrl='");
        stringBuilder.append(this.logoUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", bgColor='");
        stringBuilder.append(this.bgColor);
        stringBuilder.append('\'');
        stringBuilder.append(", isRedeem=");
        stringBuilder.append(this.isRedeem);
        stringBuilder.append(", definedUrl='");
        stringBuilder.append(this.definedUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", defineText1='");
        stringBuilder.append(this.defineText1);
        stringBuilder.append('\'');
        stringBuilder.append(", defineText2='");
        stringBuilder.append(this.defineText2);
        stringBuilder.append('\'');
        stringBuilder.append(", redeemText='");
        stringBuilder.append(this.redeemText);
        stringBuilder.append('\'');
        stringBuilder.append(", adExposingCodes='");
        stringBuilder.append(this.adExposingCodes);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.prizeName);
        parcel.writeLong(this.prizeValidStartTime);
        parcel.writeLong(this.prizeValidEndTime);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.bgColor);
        parcel.writeByte(this.isRedeem);
        parcel.writeString(this.definedUrl);
        parcel.writeString(this.defineText1);
        parcel.writeString(this.defineText2);
        parcel.writeString(this.redeemText);
        parcel.writeString(this.adExposingCodes);
    }
}
