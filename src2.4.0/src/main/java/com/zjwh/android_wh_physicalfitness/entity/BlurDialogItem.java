package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BlurDialogItem implements Parcelable {
    public static final Creator<BlurDialogItem> CREATOR = new Creator<BlurDialogItem>() {
        public BlurDialogItem createFromParcel(Parcel parcel) {
            return new BlurDialogItem(parcel);
        }

        public BlurDialogItem[] newArray(int i) {
            return new BlurDialogItem[i];
        }
    };
    private int resId;
    private String txt;
    private int txtColor;

    public BlurDialogItem(int i, String str, int i2) {
        this.resId = i;
        this.txt = str;
        this.txtColor = i2;
    }

    protected BlurDialogItem(Parcel parcel) {
        this.resId = parcel.readInt();
        this.txt = parcel.readString();
        this.txtColor = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getResId() {
        return this.resId;
    }

    public String getTxt() {
        return this.txt;
    }

    public int getTxtColor() {
        return this.txtColor;
    }

    public void setResId(int i) {
        this.resId = i;
    }

    public void setTxt(String str) {
        this.txt = str;
    }

    public void setTxtColor(int i) {
        this.txtColor = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.resId);
        parcel.writeString(this.txt);
        parcel.writeInt(this.txtColor);
    }
}
