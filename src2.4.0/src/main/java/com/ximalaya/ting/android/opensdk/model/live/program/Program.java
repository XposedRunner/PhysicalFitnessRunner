package com.ximalaya.ting.android.opensdk.model.live.program;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.live.schedule.LiveAnnouncer;
import java.util.ArrayList;
import java.util.List;

public class Program implements Parcelable {
    public static final Creator<Program> CREATOR = new Creator<Program>() {
        public Program createFromParcel(Parcel parcel) {
            Program program = new Program();
            program.readFromParcel(parcel);
            return program;
        }

        public Program[] newArray(int i) {
            return new Program[i];
        }
    };
    @SerializedName("live_announcers")
    private List<LiveAnnouncer> announcerList;
    @SerializedName("back_pic_url")
    private String backPicUrl;
    @SerializedName("id")
    private long programId;
    @SerializedName("program_name")
    private String programName;
    @SerializedName("rate24_aac_url")
    private String rate24AacUrl;
    @SerializedName("rate24_ts_url")
    private String rate24TsUrl;
    @SerializedName("rate64_aac_url")
    private String rate64AacUrl;
    @SerializedName("rate64_ts_url")
    private String rate64TsUrl;
    @SerializedName("support_bitrates")
    private int[] supportBitrates;
    @SerializedName("update_at")
    private long updateAt;

    public int describeContents() {
        return 0;
    }

    public List<LiveAnnouncer> getAnnouncerList() {
        return this.announcerList;
    }

    public String getBackPicUrl() {
        return this.backPicUrl;
    }

    public long getProgramId() {
        return this.programId;
    }

    public String getProgramName() {
        return this.programName;
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

    public int[] getSupportBitrates() {
        return this.supportBitrates;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public void readFromParcel(Parcel parcel) {
        setProgramId(parcel.readLong());
        setProgramName(parcel.readString());
        setBackPicUrl(parcel.readString());
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
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, LiveAnnouncer.class.getClassLoader());
        setAnnouncerList(arrayList);
        setUpdateAt((long) parcel.readInt());
    }

    public void setAnnouncerList(List<LiveAnnouncer> list) {
        this.announcerList = list;
    }

    public void setBackPicUrl(String str) {
        this.backPicUrl = str;
    }

    public void setProgramId(long j) {
        this.programId = j;
    }

    public void setProgramName(String str) {
        this.programName = str;
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

    public void setSupportBitrates(int[] iArr) {
        this.supportBitrates = iArr;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.programId);
        parcel.writeString(this.programName);
        parcel.writeString(this.backPicUrl);
        i = this.supportBitrates == null ? 0 : this.supportBitrates.length;
        parcel.writeInt(i);
        if (i > 0) {
            parcel.writeIntArray(this.supportBitrates);
        }
        parcel.writeString(this.rate24AacUrl);
        parcel.writeString(this.rate24TsUrl);
        parcel.writeString(this.rate64AacUrl);
        parcel.writeString(this.rate64TsUrl);
        parcel.writeList(this.announcerList);
        parcel.writeLong(this.updateAt);
    }
}
