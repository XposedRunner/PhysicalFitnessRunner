package com.ximalaya.ting.android.opensdk.model.banner;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class BannerV2 extends XimalayaResponse {
    @SerializedName("album_id")
    private int albumId;
    @SerializedName("banner_content_type")
    private int bannerContentType;
    @SerializedName("banner_short_title")
    private String bannerShortTitle;
    @SerializedName("banner_title")
    private String bannerTitle;
    @SerializedName("banner_uid")
    private int bannerUid;
    @SerializedName("banner_url")
    private String bannerUrl;
    @SerializedName("column_id")
    private int columnId;
    private int id;
    private String kind;
    @SerializedName("track_id")
    private int trackId;

    public int getAlbumId() {
        return this.albumId;
    }

    public int getBannerContentType() {
        return this.bannerContentType;
    }

    public String getBannerShortTitle() {
        return this.bannerShortTitle;
    }

    public String getBannerTitle() {
        return this.bannerTitle;
    }

    public int getBannerUid() {
        return this.bannerUid;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public int getColumnId() {
        return this.columnId;
    }

    public int getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public void setAlbumId(int i) {
        this.albumId = i;
    }

    public void setBannerContentType(int i) {
        this.bannerContentType = i;
    }

    public void setBannerShortTitle(String str) {
        this.bannerShortTitle = str;
    }

    public void setBannerTitle(String str) {
        this.bannerTitle = str;
    }

    public void setBannerUid(int i) {
        this.bannerUid = i;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setColumnId(int i) {
        this.columnId = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setTrackId(int i) {
        this.trackId = i;
    }
}
