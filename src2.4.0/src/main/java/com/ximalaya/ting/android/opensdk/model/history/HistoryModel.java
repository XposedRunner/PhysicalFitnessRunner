package com.ximalaya.ting.android.opensdk.model.history;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.track.Track;

public class HistoryModel implements Parcelable {
    public static final Creator<HistoryModel> CREATOR = new Creator<HistoryModel>() {
        public HistoryModel createFromParcel(Parcel parcel) {
            return new HistoryModel(parcel);
        }

        public HistoryModel[] newArray(int i) {
            return new HistoryModel[i];
        }
    };
    private long albumId;
    private long deleteTime;
    @Deprecated
    private String deviceId;
    private String deviceName;
    private int deviceType;
    private int direction;
    private long endedAt;
    private boolean isDeleted;
    public boolean isRadio;
    private boolean isSubscribe;
    private boolean isSync;
    private long listenUid;
    private int platform;
    private Radio radio;
    private long startedAt;
    private Track track;
    private int type;
    private long updateAt;

    protected HistoryModel(Parcel parcel) {
        boolean z = false;
        this.isRadio = parcel.readByte() != (byte) 0;
        this.track = (Track) parcel.readParcelable(Track.class.getClassLoader());
        this.radio = (Radio) parcel.readParcelable(Radio.class.getClassLoader());
        this.updateAt = parcel.readLong();
        this.isSync = parcel.readByte() != (byte) 0;
        this.isDeleted = parcel.readByte() != (byte) 0;
        this.deleteTime = parcel.readLong();
        this.deviceType = parcel.readInt();
        this.deviceName = parcel.readString();
        this.deviceId = parcel.readString();
        this.platform = parcel.readInt();
        this.startedAt = parcel.readLong();
        this.endedAt = parcel.readLong();
        this.direction = parcel.readInt();
        this.type = parcel.readInt();
        this.albumId = parcel.readLong();
        this.listenUid = parcel.readLong();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.isSubscribe = z;
    }

    public HistoryModel(Radio radio, boolean z) {
        this.radio = radio;
        this.updateAt = radio.getUpdateAt();
        this.isRadio = true;
        this.isSync = z;
        if (!TextUtils.isEmpty(radio.getKind())) {
            if (radio.isActivityLive()) {
                this.type = 3;
            } else {
                this.type = 2;
            }
        }
    }

    public HistoryModel(Track track, boolean z) {
        this.track = track;
        this.updateAt = track.getUpdatedAt();
        this.isRadio = false;
        this.isSync = z;
        if (!TextUtils.isEmpty(track.getKind())) {
            if (track.getKind().equals("track")) {
                this.type = 1;
            } else if (track.getKind().equals(PlayableModel.KIND_LIVE_FLV)) {
                this.type = 4;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public long getAlbumId() {
        if (!(getTrack() == null || getTrack().getAlbum() == null)) {
            this.albumId = getTrack().getAlbum().getAlbumId();
        }
        return this.albumId;
    }

    public String getAlbumTitle() {
        return this.isRadio ? this.radio.getRadioName() : this.track == null ? "" : this.track.getAlbum() != null ? this.track.getAlbum().getAlbumTitle() : this.track.getTrackTitle();
    }

    public long getDeleteTime() {
        return this.deleteTime;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getDirection() {
        return this.direction;
    }

    public long getEndedAt() {
        return this.endedAt;
    }

    public long getListenUid() {
        return this.listenUid;
    }

    public int getPlatform() {
        return this.platform;
    }

    public Radio getRadio() {
        return this.radio;
    }

    public long getStartedAt() {
        return this.startedAt;
    }

    public Track getTrack() {
        return this.track;
    }

    public int getType() {
        return this.type;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public boolean isSubscribe() {
        return this.isSubscribe;
    }

    public boolean isSync() {
        return this.isSync;
    }

    public void setDeleteTime(long j) {
        this.deleteTime = j;
    }

    public void setDeleted(boolean z) {
        this.isDeleted = z;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceInfo(String str, String str2, int i) {
        this.deviceName = str;
        this.deviceId = str2;
        this.platform = i;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public void setEndedAt(long j) {
        this.endedAt = j;
    }

    public void setListenUid(long j) {
        this.listenUid = j;
    }

    public void setPlatform(int i) {
        this.platform = i;
    }

    public void setStartEndTime(long j, long j2) {
        this.startedAt = j;
        this.endedAt = j2;
    }

    public void setStartedAt(long j) {
        this.startedAt = j;
    }

    public void setSubscribe(boolean z) {
        this.isSubscribe = z;
    }

    public void setSync(boolean z) {
        this.isSync = z;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) this.isRadio);
        parcel.writeParcelable(this.track, i);
        parcel.writeParcelable(this.radio, i);
        parcel.writeLong(this.updateAt);
        parcel.writeByte((byte) this.isSync);
        parcel.writeByte((byte) this.isDeleted);
        parcel.writeLong(this.deleteTime);
        parcel.writeInt(this.deviceType);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.deviceId);
        parcel.writeInt(this.platform);
        parcel.writeLong(this.startedAt);
        parcel.writeLong(this.endedAt);
        parcel.writeInt(this.direction);
        parcel.writeInt(this.type);
        parcel.writeLong(this.albumId);
        parcel.writeLong(this.listenUid);
        parcel.writeByte((byte) this.isSubscribe);
    }
}
