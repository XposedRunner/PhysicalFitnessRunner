package com.ximalaya.ting.android.opensdk.model.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.util.XiMaDataSupport;

public class Announcer extends XiMaDataSupport implements Parcelable {
    public static final Creator<Announcer> CREATOR = new Creator<Announcer>() {
        public Announcer createFromParcel(Parcel parcel) {
            Announcer announcer = new Announcer();
            announcer.readFromParcel(parcel);
            return announcer;
        }

        public Announcer[] newArray(int i) {
            return new Announcer[i];
        }
    };
    private int anchorGrade;
    @SerializedName("id")
    private long announcerId;
    @SerializedName("announcer_position")
    private String announcerPosition;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("follower_count")
    private long followerCount;
    @SerializedName("following_count")
    private long followingCount;
    private String kind;
    private String nickname;
    @SerializedName("released_album_count")
    private long releasedAlbumCount;
    @SerializedName("released_track_count")
    private long releasedTrackCount;
    @SerializedName("vcategory_id")
    private long vCategoryId;
    private String vdesc;
    @SerializedName("is_verified")
    private boolean verified;
    private int verifyType;
    private String vsignature;

    public int describeContents() {
        return 0;
    }

    public int getAnchorGrade() {
        return this.anchorGrade;
    }

    public long getAnnouncerId() {
        return this.announcerId;
    }

    public String getAnnouncerPosition() {
        return this.announcerPosition;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public long getFollowerCount() {
        return this.followerCount;
    }

    public long getFollowingCount() {
        return this.followingCount;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNickname() {
        return this.nickname;
    }

    public long getReleasedAlbumCount() {
        return this.releasedAlbumCount;
    }

    public long getReleasedTrackCount() {
        return this.releasedTrackCount;
    }

    public String getVdesc() {
        return this.vdesc;
    }

    public int getVerifyType() {
        return this.verifyType;
    }

    public String getVsignature() {
        return this.vsignature;
    }

    public long getvCategoryId() {
        return this.vCategoryId;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void readFromParcel(Parcel parcel) {
        this.announcerId = parcel.readLong();
        this.nickname = parcel.readString();
        this.avatarUrl = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.verified = zArr[0];
        this.kind = parcel.readString();
        this.vCategoryId = parcel.readLong();
        this.vdesc = parcel.readString();
        this.vsignature = parcel.readString();
        this.announcerPosition = parcel.readString();
        this.followerCount = parcel.readLong();
        this.followingCount = parcel.readLong();
        this.releasedAlbumCount = parcel.readLong();
        this.releasedTrackCount = parcel.readLong();
        this.anchorGrade = parcel.readInt();
        this.verifyType = parcel.readInt();
    }

    public void setAnchorGrade(int i) {
        this.anchorGrade = i;
    }

    public void setAnnouncerId(long j) {
        this.announcerId = j;
    }

    public void setAnnouncerPosition(String str) {
        this.announcerPosition = str;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setFollowerCount(long j) {
        this.followerCount = j;
    }

    public void setFollowingCount(long j) {
        this.followingCount = j;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setReleasedAlbumCount(long j) {
        this.releasedAlbumCount = j;
    }

    public void setReleasedTrackCount(long j) {
        this.releasedTrackCount = j;
    }

    public void setVdesc(String str) {
        this.vdesc = str;
    }

    public void setVerified(boolean z) {
        this.verified = z;
    }

    public void setVerifyType(int i) {
        this.verifyType = i;
    }

    public void setVsignature(String str) {
        this.vsignature = str;
    }

    public void setvCategoryId(long j) {
        this.vCategoryId = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Announcer [id=");
        stringBuilder.append(this.announcerId);
        stringBuilder.append(", nickname=");
        stringBuilder.append(this.nickname);
        stringBuilder.append(", avatarUrl=");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append(", isVerified=");
        stringBuilder.append(this.verified);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.announcerId);
        parcel.writeString(this.nickname);
        parcel.writeString(this.avatarUrl);
        parcel.writeBooleanArray(new boolean[]{this.verified});
        parcel.writeString(this.kind);
        parcel.writeLong(this.vCategoryId);
        parcel.writeString(this.vdesc);
        parcel.writeString(this.vsignature);
        parcel.writeString(this.announcerPosition);
        parcel.writeLong(this.followerCount);
        parcel.writeLong(this.followingCount);
        parcel.writeLong(this.releasedAlbumCount);
        parcel.writeLong(this.releasedTrackCount);
        parcel.writeInt(this.anchorGrade);
        parcel.writeInt(this.verifyType);
    }
}
