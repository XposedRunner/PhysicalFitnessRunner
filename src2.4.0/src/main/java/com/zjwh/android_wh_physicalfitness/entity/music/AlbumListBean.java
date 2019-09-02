package com.zjwh.android_wh_physicalfitness.entity.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AlbumListBean implements Parcelable {
    public static final Creator<AlbumListBean> CREATOR = new Creator<AlbumListBean>() {
        public AlbumListBean createFromParcel(Parcel parcel) {
            return new AlbumListBean(parcel);
        }

        public AlbumListBean[] newArray(int i) {
            return new AlbumListBean[i];
        }
    };
    private String albumCover;
    private long albumId;
    private String albumIntro;
    private String albumTitle;
    private String announcerName;
    private long includeTrackCount;
    private boolean isPaid;

    protected AlbumListBean(Parcel parcel) {
        this.albumTitle = parcel.readString();
        this.albumIntro = parcel.readString();
        this.includeTrackCount = parcel.readLong();
        this.albumCover = parcel.readString();
        this.albumId = parcel.readLong();
        this.announcerName = parcel.readString();
        this.isPaid = parcel.readByte() != (byte) 0;
    }

    public AlbumListBean(String str, String str2, long j, String str3, long j2, String str4) {
        this.albumTitle = str;
        this.albumIntro = str2;
        this.includeTrackCount = j;
        this.albumCover = str3;
        this.albumId = j2;
        this.announcerName = str4;
        this.isPaid = true;
    }

    public int describeContents() {
        return 0;
    }

    public String getAlbumCover() {
        return this.albumCover;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public String getAlbumIntro() {
        return this.albumIntro;
    }

    public String getAlbumTitle() {
        return this.albumTitle;
    }

    public String getAnnouncerName() {
        return this.announcerName;
    }

    public long getIncludeTrackCount() {
        return this.includeTrackCount;
    }

    public boolean isPaid() {
        return this.isPaid;
    }

    public void setAlbumCover(String str) {
        this.albumCover = str;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public void setAlbumIntro(String str) {
        this.albumIntro = str;
    }

    public void setAlbumTitle(String str) {
        this.albumTitle = str;
    }

    public void setAnnouncerName(String str) {
        this.announcerName = str;
    }

    public void setIncludeTrackCount(long j) {
        this.includeTrackCount = j;
    }

    public void setPaid(boolean z) {
        this.isPaid = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.albumTitle);
        parcel.writeString(this.albumIntro);
        parcel.writeLong(this.includeTrackCount);
        parcel.writeString(this.albumCover);
        parcel.writeLong(this.albumId);
        parcel.writeString(this.announcerName);
        parcel.writeByte(this.isPaid);
    }
}
