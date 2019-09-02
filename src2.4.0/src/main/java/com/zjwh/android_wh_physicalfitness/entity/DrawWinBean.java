package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class DrawWinBean implements Parcelable {
    public static final Creator<DrawWinBean> CREATOR = new Creator<DrawWinBean>() {
        public DrawWinBean createFromParcel(Parcel parcel) {
            return new DrawWinBean(parcel);
        }

        public DrawWinBean[] newArray(int i) {
            return new DrawWinBean[i];
        }
    };
    private String drawResult;
    private boolean isGetPrize;
    private List<PrizeListBean> prizeList;

    protected DrawWinBean(Parcel parcel) {
        this.isGetPrize = parcel.readByte() != (byte) 0;
        this.drawResult = parcel.readString();
        this.prizeList = new ArrayList();
        parcel.readList(this.prizeList, PrizeListBean.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getDrawResult() {
        return this.drawResult;
    }

    public List<PrizeListBean> getPrizeList() {
        return this.prizeList;
    }

    public boolean isGetPrize() {
        return this.isGetPrize;
    }

    public void setDrawResult(String str) {
        this.drawResult = str;
    }

    public void setGetPrize(boolean z) {
        this.isGetPrize = z;
    }

    public void setPrizeList(List<PrizeListBean> list) {
        this.prizeList = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isGetPrize);
        parcel.writeString(this.drawResult);
        parcel.writeList(this.prizeList);
    }
}
