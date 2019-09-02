package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;

public class UpdateBatch {
    @SerializedName("id")
    private long albumId;
    @SerializedName("last_up_track_cover_path")
    private String coverUrl;
    @SerializedName("last_up_track_id")
    private long trackId;
    @SerializedName("last_up_track_title")
    private String trackTitle;
    @SerializedName("last_up_track_at")
    private long updateAt;

    public long getAlbumId() {
        return this.albumId;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public String getTrackTitle() {
        return this.trackTitle;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setTrackId(long j) {
        this.trackId = j;
    }

    public void setTrackTitle(String str) {
        this.trackTitle = str;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UpdateBatch [albumId=");
        stringBuilder.append(this.albumId);
        stringBuilder.append(", trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append(", trackTitle=");
        stringBuilder.append(this.trackTitle);
        stringBuilder.append(", coverUrl=");
        stringBuilder.append(this.coverUrl);
        stringBuilder.append(", updateAt=");
        stringBuilder.append(this.updateAt);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
