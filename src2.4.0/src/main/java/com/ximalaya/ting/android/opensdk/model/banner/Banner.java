package com.ximalaya.ting.android.opensdk.model.banner;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class Banner extends XimalayaResponse {
    @SerializedName("album_id")
    private long albumId;
    @SerializedName("banner_content_type")
    private int bannerContentType;
    @SerializedName("id")
    private long bannerId;
    @SerializedName("banner_redirect_url")
    private String bannerRedirectUrl;
    @SerializedName("banner_short_title")
    private String bannerShortTitle;
    @SerializedName("banner_title")
    private String bannerTitle;
    @SerializedName("banner_uid")
    private int bannerUid;
    @SerializedName("banner_url")
    private String bannerUrl;
    @SerializedName("can_share")
    private boolean canShare;
    @SerializedName("column_content_type")
    private String columnContentType;
    @SerializedName("column_id")
    private int columnId;
    @SerializedName("is_external_url")
    private boolean isExternalUrl;
    @SerializedName("third_party_url")
    private String thirdPartyUrl;
    @SerializedName("track_id")
    private long trackId;

    public long getAlbumId() {
        return this.albumId;
    }

    public int getBannerContentType() {
        return this.bannerContentType;
    }

    public long getBannerId() {
        return this.bannerId;
    }

    public String getBannerRedirectUrl() {
        return this.bannerRedirectUrl;
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

    public String getColumnContentType() {
        return this.columnContentType;
    }

    public int getColumnId() {
        return this.columnId;
    }

    public String getThirdPartyUrl() {
        return this.thirdPartyUrl;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public boolean isCanShare() {
        return this.canShare;
    }

    public boolean isExternalUrl() {
        return this.isExternalUrl;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public void setBannerContentType(int i) {
        this.bannerContentType = i;
    }

    public void setBannerId(long j) {
        this.bannerId = j;
    }

    public void setBannerRedirectUrl(String str) {
        this.bannerRedirectUrl = str;
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

    public void setCanShare(boolean z) {
        this.canShare = z;
    }

    public void setColumnContentType(String str) {
        this.columnContentType = str;
    }

    public void setColumnId(int i) {
        this.columnId = i;
    }

    public void setExternalUrl(boolean z) {
        this.isExternalUrl = z;
    }

    public void setThirdPartyUrl(String str) {
        this.thirdPartyUrl = str;
    }

    public void setTrackId(long j) {
        this.trackId = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RankBanners [bannerId=");
        stringBuilder.append(this.bannerId);
        stringBuilder.append(", bannerTitle=");
        stringBuilder.append(this.bannerTitle);
        stringBuilder.append(", bannerShortTitle=");
        stringBuilder.append(this.bannerShortTitle);
        stringBuilder.append(", bannerUrl=");
        stringBuilder.append(this.bannerUrl);
        stringBuilder.append(", bannerRedirectUrl=");
        stringBuilder.append(this.bannerRedirectUrl);
        stringBuilder.append(", canShare=");
        stringBuilder.append(this.canShare);
        stringBuilder.append(", bannerContentType=");
        stringBuilder.append(this.bannerContentType);
        stringBuilder.append(", bannerUid=");
        stringBuilder.append(this.bannerUid);
        stringBuilder.append(", trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append(", columnId=");
        stringBuilder.append(this.columnId);
        stringBuilder.append(", columnContentType=");
        stringBuilder.append(this.columnContentType);
        stringBuilder.append(", albumId=");
        stringBuilder.append(this.albumId);
        stringBuilder.append(", thirdPartyUrl=");
        stringBuilder.append(this.thirdPartyUrl);
        stringBuilder.append(", isExternalUrl=");
        stringBuilder.append(this.isExternalUrl);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
