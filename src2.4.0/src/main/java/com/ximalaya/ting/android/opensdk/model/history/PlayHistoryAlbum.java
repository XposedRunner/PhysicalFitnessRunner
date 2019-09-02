package com.ximalaya.ting.android.opensdk.model.history;

import com.google.gson.annotations.SerializedName;

public class PlayHistoryAlbum {
    @SerializedName("album_cover_url_large")
    private String albumCoverUrlLarge;
    @SerializedName("album_cover_url_middle")
    private String albumCoverUrlMiddle;
    @SerializedName("album_cover_url_small")
    private String albumCoverUrlSmall;
    @SerializedName("album_id")
    private long albumId;
    @SerializedName("album_title")
    private String albumTitle;
    @SerializedName("track_cover_url_large")
    private String trackCoverUrlLarge;
    @SerializedName("track_cover_url_middle")
    private String trackCoverUrlMiddle;
    @SerializedName("track_cover_url_small")
    private String trackCoverUrlSmall;
    @SerializedName("track_id")
    private long trackId;
    @SerializedName("track_title")
    private String trackTitle;

    public String getAlbumCoverUrlLarge() {
        return this.albumCoverUrlLarge;
    }

    public String getAlbumCoverUrlMiddle() {
        return this.albumCoverUrlMiddle;
    }

    public String getAlbumCoverUrlSmall() {
        return this.albumCoverUrlSmall;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public String getAlbumTitle() {
        return this.albumTitle;
    }

    public String getTrackCoverUrlLarge() {
        return this.trackCoverUrlLarge;
    }

    public String getTrackCoverUrlMiddle() {
        return this.trackCoverUrlMiddle;
    }

    public String getTrackCoverUrlSmall() {
        return this.trackCoverUrlSmall;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public String getTrackTitle() {
        return this.trackTitle;
    }

    public void setAlbumCoverUrlLarge(String str) {
        this.albumCoverUrlLarge = str;
    }

    public void setAlbumCoverUrlMiddle(String str) {
        this.albumCoverUrlMiddle = str;
    }

    public void setAlbumCoverUrlSmall(String str) {
        this.albumCoverUrlSmall = str;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public void setAlbumTitle(String str) {
        this.albumTitle = str;
    }

    public void setTrackCoverUrlLarge(String str) {
        this.trackCoverUrlLarge = str;
    }

    public void setTrackCoverUrlMiddle(String str) {
        this.trackCoverUrlMiddle = str;
    }

    public void setTrackCoverUrlSmall(String str) {
        this.trackCoverUrlSmall = str;
    }

    public void setTrackId(long j) {
        this.trackId = j;
    }

    public void setTrackTitle(String str) {
        this.trackTitle = str;
    }
}
