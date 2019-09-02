package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class MultiImageObject extends BaseMediaObject {
    public static final Creator<MultiImageObject> CREATOR = new Creator<MultiImageObject>() {
        public MultiImageObject createFromParcel(Parcel parcel) {
            return new MultiImageObject(parcel);
        }

        public MultiImageObject[] newArray(int i) {
            return new MultiImageObject[i];
        }
    };
    public ArrayList<Uri> imageList;

    protected MultiImageObject(Parcel parcel) {
        super(parcel);
        this.imageList = parcel.createTypedArrayList(Uri.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<Uri> getImageList() {
        return this.imageList;
    }

    public int getObjType() {
        return 0;
    }

    public void setImageList(ArrayList<Uri> arrayList) {
        this.imageList = arrayList;
    }

    /* Access modifiers changed, original: protected */
    public BaseMediaObject toExtraMediaObject(String str) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public String toExtraMediaString() {
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.imageList);
    }
}
