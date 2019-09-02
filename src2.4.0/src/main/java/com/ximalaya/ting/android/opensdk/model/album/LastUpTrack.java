package com.ximalaya.ting.android.opensdk.model.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class LastUpTrack implements Parcelable {
    public static Creator<LastUpTrack> CREATOR = new Creator<LastUpTrack>() {
        public LastUpTrack createFromParcel(Parcel parcel) {
            return new LastUpTrack(parcel);
        }

        public LastUpTrack[] newArray(int i) {
            return new LastUpTrack[i];
        }
    };
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("duration")
    private long duration;
    @SerializedName("track_id")
    private long trackId;
    @SerializedName("track_title")
    private String trackTitle;
    @SerializedName("updated_at")
    private long updatedAt;

    public LastUpTrack(Parcel parcel) {
        this.trackId = parcel.readLong();
        this.duration = parcel.readLong();
        this.createdAt = parcel.readLong();
        this.updatedAt = parcel.readLong();
        this.trackTitle = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public String getTrackTitle() {
        return this.trackTitle;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setTrackId(long j) {
        this.trackId = j;
    }

    public void setTrackTitle(String str) {
        this.trackTitle = str;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LastUpTrack [trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append(", trackTitle=");
        stringBuilder.append(this.trackTitle);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", createdAt=");
        stringBuilder.append(this.createdAt);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.createdAt);
        parcel.writeLong(this.updatedAt);
        parcel.writeLong(this.trackId);
        parcel.writeLong(this.duration);
        parcel.writeString(this.trackTitle);
    }
}
