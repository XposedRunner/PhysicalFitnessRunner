package com.ximalaya.ting.android.opensdk.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.live.schedule.Schedule;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.util.XiMaDataSupport;

public class PlayableModel extends XiMaDataSupport implements Parcelable {
    public static final Creator<PlayableModel> CREATOR = new Creator<PlayableModel>() {
        public PlayableModel createFromParcel(Parcel parcel) {
            return new PlayableModel(parcel);
        }

        public PlayableModel[] newArray(int i) {
            return new PlayableModel[i];
        }
    };
    public static final String KIND_LIVE_FLV = "live_flv";
    public static final String KIND_RADIO = "radio";
    public static final String KIND_SCHEDULE = "schedule";
    public static final String KIND_TRACK = "track";
    public static final String KIND_TTS = "tts";
    @SerializedName(alternate = {"trackId"}, value = "id")
    private long dataId;
    public boolean isWeikeTrack;
    private String kind;
    private int lastPlayedMills = -1;
    public long weikeLessonId;
    public long weikeRoomId;
    public String weikeTrackId;

    protected PlayableModel(Parcel parcel) {
        this.dataId = parcel.readLong();
        this.kind = parcel.readString();
        this.lastPlayedMills = parcel.readInt();
        this.isWeikeTrack = parcel.readByte() != (byte) 0;
        this.weikeRoomId = parcel.readLong();
        this.weikeLessonId = parcel.readLong();
        this.weikeTrackId = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        boolean z2 = (obj instanceof Track) && (this instanceof Track);
        boolean z3 = (obj instanceof Radio) && (this instanceof Radio);
        boolean z4 = (obj instanceof Schedule) && (this instanceof Schedule);
        boolean z5 = getClass() == obj.getClass();
        if (!z2 && !z3 && !z4 && !z5) {
            return false;
        }
        PlayableModel playableModel = (PlayableModel) obj;
        if (this.isWeikeTrack != playableModel.isWeikeTrack) {
            return false;
        }
        if (this.isWeikeTrack) {
            return TextUtils.equals(this.weikeTrackId, playableModel.weikeTrackId);
        }
        if (this.dataId != playableModel.dataId) {
            z = false;
        }
        return z;
    }

    public long getDataId() {
        return this.dataId;
    }

    public boolean getIsWeikeTrack() {
        return this.isWeikeTrack;
    }

    public String getKind() {
        return this.kind;
    }

    public int getLastPlayedMills() {
        return this.lastPlayedMills;
    }

    public long getWeikeLessonId() {
        return this.weikeLessonId;
    }

    public long getWeikeRoomId() {
        return this.weikeRoomId;
    }

    public String getWeikeTrackId() {
        return this.weikeTrackId;
    }

    public int hashCode() {
        return 31 + ((int) (this.dataId ^ (this.dataId >>> 32)));
    }

    public void readFromParcel(Parcel parcel) {
        setDataId(parcel.readLong());
        setKind(parcel.readString());
        setLastPlayedMills(parcel.readInt());
        setIsWeikeTrack(parcel.readInt() != 0);
        setWeikeRoomId(parcel.readLong());
        setWeikeLessonId(parcel.readLong());
        setWeikeTrackId(parcel.readString());
    }

    public void setDataId(long j) {
        this.dataId = j;
    }

    public void setIsWeikeTrack(boolean z) {
        this.isWeikeTrack = z;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setLastPlayedMills(int i) {
        this.lastPlayedMills = i;
    }

    public void setWeikeLessonId(long j) {
        this.weikeLessonId = j;
    }

    public void setWeikeRoomId(long j) {
        this.weikeRoomId = j;
    }

    public void setWeikeTrackId(String str) {
        this.weikeTrackId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayableModel{dataId=");
        stringBuilder.append(this.dataId);
        stringBuilder.append(", kind='");
        stringBuilder.append(this.kind);
        stringBuilder.append('\'');
        stringBuilder.append(", lastPlayedMills=");
        stringBuilder.append(this.lastPlayedMills);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.dataId);
        parcel.writeString(this.kind);
        parcel.writeInt(this.lastPlayedMills);
        parcel.writeByte(this.isWeikeTrack);
        parcel.writeLong(this.weikeRoomId);
        parcel.writeLong(this.weikeLessonId);
        parcel.writeString(this.weikeTrackId);
    }
}
