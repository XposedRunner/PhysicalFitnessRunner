package com.ximalaya.ting.android.opensdk.model.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class RecommendTrack implements Parcelable {
    public static final Creator<RecommendTrack> CREATOR = new Creator<RecommendTrack>() {
        public RecommendTrack createFromParcel(Parcel parcel) {
            return new RecommendTrack(parcel);
        }

        public RecommendTrack[] newArray(int i) {
            return new RecommendTrack[i];
        }
    };
    @SerializedName("human_recommend_real_title")
    private String realTitle;
    @SerializedName("human_recommend_track_id")
    private long trackId;
    @SerializedName("human_recommend_track_title")
    private String trackTitle;
    private long uid;

    public RecommendTrack(Parcel parcel) {
        this.uid = parcel.readLong();
        this.trackId = parcel.readLong();
        this.realTitle = parcel.readString();
        this.trackTitle = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getRealTitle() {
        return this.realTitle;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public String getTrackTitle() {
        return this.trackTitle;
    }

    public long getUid() {
        return this.uid;
    }

    public void setRealTitle(String str) {
        this.realTitle = str;
    }

    public void setTrackId(long j) {
        this.trackId = j;
    }

    public void setTrackTitle(String str) {
        this.trackTitle = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecommendTrack [uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append(", realTitle=");
        stringBuilder.append(this.realTitle);
        stringBuilder.append(", tackTitle=");
        stringBuilder.append(this.trackTitle);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.uid);
        parcel.writeLong(this.trackId);
        parcel.writeString(this.realTitle);
        parcel.writeString(this.trackTitle);
    }
}
