package com.ximalaya.ting.android.opensdk.model.banner;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class VehicleBanners extends XimalayaResponse {
    @SerializedName("id")
    private long bannerId;
    @SerializedName("banner_title")
    private String bannerTitle;
    @SerializedName("banner_url")
    private String bannerUrl;
    @SerializedName("track_id")
    private String trackId;

    public long getBannerId() {
        return this.bannerId;
    }

    public String getBannerTitle() {
        return this.bannerTitle;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getTrackId() {
        return this.trackId;
    }

    public void setBannerId(long j) {
        this.bannerId = j;
    }

    public void setBannerTitle(String str) {
        this.bannerTitle = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setTrackId(String str) {
        this.trackId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VehicleBanners [bannerId=");
        stringBuilder.append(this.bannerId);
        stringBuilder.append(", bannerTitle=");
        stringBuilder.append(this.bannerTitle);
        stringBuilder.append(", bannerUrl=");
        stringBuilder.append(this.bannerUrl);
        stringBuilder.append(", trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
