package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class BlurDialogMsg implements Parcelable {
    public static final Creator<BlurDialogMsg> CREATOR = new Creator<BlurDialogMsg>() {
        public BlurDialogMsg createFromParcel(Parcel parcel) {
            return new BlurDialogMsg(parcel);
        }

        public BlurDialogMsg[] newArray(int i) {
            return new BlurDialogMsg[i];
        }
    };
    private List<BlurDialogItem> items;
    private int tip;
    private int title;
    private String validSpeed;
    private String validStep;

    protected BlurDialogMsg(Parcel parcel) {
        this.title = parcel.readInt();
        this.items = new ArrayList();
        parcel.readList(this.items, BlurDialogItem.class.getClassLoader());
        this.tip = parcel.readInt();
        this.validSpeed = parcel.readString();
        this.validStep = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public List<BlurDialogItem> getItems() {
        return this.items;
    }

    public int getTip() {
        return this.tip;
    }

    public int getTitle() {
        return this.title;
    }

    public String getValidSpeed() {
        return this.validSpeed;
    }

    public String getValidStep() {
        return this.validStep;
    }

    public void setItems(List<BlurDialogItem> list) {
        this.items = list;
    }

    public void setTip(int i) {
        this.tip = i;
    }

    public void setTitle(int i) {
        this.title = i;
    }

    public void setValidSpeed(String str) {
        this.validSpeed = str;
    }

    public void setValidStep(String str) {
        this.validStep = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.title);
        parcel.writeList(this.items);
        parcel.writeInt(this.tip);
        parcel.writeString(this.validSpeed);
        parcel.writeString(this.validStep);
    }
}
