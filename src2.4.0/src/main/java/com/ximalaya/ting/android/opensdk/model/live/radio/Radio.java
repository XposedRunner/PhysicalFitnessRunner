package com.ximalaya.ting.android.opensdk.model.live.radio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;

public class Radio extends PlayableModel implements Parcelable {
    public static final Creator<Radio> CREATOR = new Creator<Radio>() {
        public Radio createFromParcel(Parcel parcel) {
            Radio radio = new Radio();
            radio.readFromParcel(parcel);
            return radio;
        }

        public Radio[] newArray(int i) {
            return new Radio[i];
        }
    };
    private long activityId;
    @SerializedName("cover_url_large")
    private String coverUrlLarge;
    @SerializedName("cover_url_small")
    private String coverUrlSmall;
    @SerializedName("end_time")
    private long endTime;
    private boolean isActivityLive = false;
    @SerializedName("update_at")
    private long programId;
    @SerializedName("program_name")
    private String programName;
    @SerializedName("radio_desc")
    private String radioDesc;
    @SerializedName("radio_name")
    private String radioName;
    @SerializedName("radio_play_count")
    private int radioPlayCount;
    @SerializedName("rate24_aac_url")
    private String rate24AacUrl;
    @SerializedName("rate24_ts_url")
    private String rate24TsUrl;
    @SerializedName("rate64_aac_url")
    private String rate64AacUrl;
    @SerializedName("rate64_ts_url")
    private String rate64TsUrl;
    @SerializedName("schedule_id")
    private long scheduleID;
    private String shareUrl;
    @SerializedName("start_time")
    private long startTime;
    @SerializedName("support_bitrates")
    private int[] supportBitrates;
    private long updateAt;

    public int describeContents() {
        return 0;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public String getCoverUrlLarge() {
        return this.coverUrlLarge;
    }

    public String getCoverUrlSmall() {
        return this.coverUrlSmall;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getProgramId() {
        return this.programId;
    }

    public String getProgramName() {
        return this.programName;
    }

    public String getRadioDesc() {
        return this.radioDesc;
    }

    public String getRadioName() {
        return this.radioName;
    }

    public int getRadioPlayCount() {
        return this.radioPlayCount;
    }

    public String getRate24AacUrl() {
        return this.rate24AacUrl;
    }

    public String getRate24TsUrl() {
        return this.rate24TsUrl;
    }

    public String getRate64AacUrl() {
        return this.rate64AacUrl;
    }

    public String getRate64TsUrl() {
        return this.rate64TsUrl;
    }

    public long getScheduleID() {
        return this.scheduleID;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int[] getSupportBitrates() {
        return this.supportBitrates;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public String getValidCover() {
        return !TextUtils.isEmpty(this.coverUrlSmall) ? this.coverUrlSmall : !TextUtils.isEmpty(this.coverUrlLarge) ? this.coverUrlLarge : "";
    }

    public boolean isActivityLive() {
        return this.isActivityLive;
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        setRadioName(parcel.readString());
        setRadioDesc(parcel.readString());
        setProgramName(parcel.readString());
        setScheduleID(parcel.readLong());
        setStartTime(parcel.readLong());
        setEndTime(parcel.readLong());
        int readInt = parcel.readInt();
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            setSupportBitrates(iArr);
        }
        setRate24AacUrl(parcel.readString());
        setRate24TsUrl(parcel.readString());
        setRate64AacUrl(parcel.readString());
        setRate64TsUrl(parcel.readString());
        setRadioPlayCount(parcel.readInt());
        setCoverUrlSmall(parcel.readString());
        setCoverUrlLarge(parcel.readString());
        setUpdateAt(parcel.readLong());
        setShareUrl(parcel.readString());
        setActivityLive(parcel.readInt() != 0);
        setActivityId(parcel.readLong());
    }

    public void setActivityId(long j) {
        this.activityId = j;
    }

    public void setActivityLive(boolean z) {
        this.isActivityLive = z;
    }

    public void setCoverUrlLarge(String str) {
        this.coverUrlLarge = str;
    }

    public void setCoverUrlSmall(String str) {
        this.coverUrlSmall = str;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setProgramId(long j) {
        this.programId = j;
    }

    public void setProgramName(String str) {
        this.programName = str;
    }

    public void setRadioDesc(String str) {
        this.radioDesc = str;
    }

    public void setRadioName(String str) {
        this.radioName = str;
    }

    public void setRadioPlayCount(int i) {
        this.radioPlayCount = i;
    }

    public void setRate24AacUrl(String str) {
        this.rate24AacUrl = str;
    }

    public void setRate24TsUrl(String str) {
        this.rate24TsUrl = str;
    }

    public void setRate64AacUrl(String str) {
        this.rate64AacUrl = str;
    }

    public void setRate64TsUrl(String str) {
        this.rate64TsUrl = str;
    }

    public void setScheduleID(long j) {
        this.scheduleID = j;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setSupportBitrates(int[] iArr) {
        this.supportBitrates = iArr;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.radioName);
        parcel.writeString(this.radioDesc);
        parcel.writeString(this.programName);
        parcel.writeLong(this.scheduleID);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        i = this.supportBitrates == null ? 0 : this.supportBitrates.length;
        parcel.writeInt(i);
        if (i > 0) {
            parcel.writeIntArray(this.supportBitrates);
        }
        parcel.writeString(this.rate24AacUrl);
        parcel.writeString(this.rate24TsUrl);
        parcel.writeString(this.rate64AacUrl);
        parcel.writeString(this.rate64TsUrl);
        parcel.writeInt(this.radioPlayCount);
        parcel.writeString(this.coverUrlSmall);
        parcel.writeString(this.coverUrlLarge);
        parcel.writeLong(this.updateAt);
        parcel.writeString(this.shareUrl);
        parcel.writeInt(this.isActivityLive);
        parcel.writeLong(this.activityId);
    }
}
