package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;

public class AspectRatio implements Parcelable {
    public static final Creator<AspectRatio> CREATOR = new Creator<AspectRatio>() {
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        public AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    };
    @Nullable
    private final String mAspectRatioTitle;
    private final float mAspectRatioX;
    private final float mAspectRatioY;

    protected AspectRatio(Parcel parcel) {
        this.mAspectRatioTitle = parcel.readString();
        this.mAspectRatioX = parcel.readFloat();
        this.mAspectRatioY = parcel.readFloat();
    }

    public AspectRatio(@Nullable String str, float f, float f2) {
        this.mAspectRatioTitle = str;
        this.mAspectRatioX = f;
        this.mAspectRatioY = f2;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getAspectRatioTitle() {
        return this.mAspectRatioTitle;
    }

    public float getAspectRatioX() {
        return this.mAspectRatioX;
    }

    public float getAspectRatioY() {
        return this.mAspectRatioY;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAspectRatioTitle);
        parcel.writeFloat(this.mAspectRatioX);
        parcel.writeFloat(this.mAspectRatioY);
    }
}
