package com.ximalaya.ting.android.opensdk.model.advertis;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.ArrayList;
import java.util.List;

public class AdvertisList extends XimalayaResponse implements Parcelable {
    public static final Creator<AdvertisList> CREATOR = new Creator<AdvertisList>() {
        public AdvertisList createFromParcel(Parcel parcel) {
            AdvertisList advertisList = new AdvertisList();
            advertisList.readFromParcel(parcel);
            return advertisList;
        }

        public AdvertisList[] newArray(int i) {
            return new AdvertisList[i];
        }
    };
    @SerializedName("data")
    private List<Advertis> advertisList;
    private boolean duringPlay;
    private String msg;
    private long responseId;
    private int ret = -2;
    private int source;

    public int describeContents() {
        return 0;
    }

    public List<Advertis> getAdvertisList() {
        return this.advertisList;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getResponseId() {
        return this.responseId;
    }

    public int getRet() {
        return this.ret;
    }

    public int getSource() {
        return this.source;
    }

    public boolean isDuringPlay() {
        return this.duringPlay;
    }

    public void readFromParcel(Parcel parcel) {
        setResponseId(parcel.readLong());
        setRet(parcel.readInt());
        setSource(parcel.readInt());
        setMsg(parcel.readString());
        if (parcel.readInt() > 0) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Advertis.class.getClassLoader());
            setAdvertisList(arrayList);
        }
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        setDuringPlay(z);
    }

    public void setAdvertisList(List<Advertis> list) {
        this.advertisList = list;
    }

    public void setDuringPlay(boolean z) {
        this.duringPlay = z;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResponseId(long j) {
        this.responseId = j;
    }

    public void setRet(int i) {
        this.ret = i;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdvertisList [advertisList=");
        stringBuilder.append(this.advertisList);
        stringBuilder.append(", ret=");
        stringBuilder.append(this.ret);
        stringBuilder.append(", msg=");
        stringBuilder.append(this.msg);
        stringBuilder.append(", source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", responseId=");
        stringBuilder.append(this.responseId);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.responseId);
        parcel.writeInt(this.ret);
        parcel.writeInt(this.source);
        parcel.writeString(this.msg);
        i = this.advertisList == null ? 0 : this.advertisList.size();
        parcel.writeInt(i);
        if (i > 0) {
            parcel.writeList(this.advertisList);
        }
        parcel.writeInt(this.duringPlay);
    }
}
