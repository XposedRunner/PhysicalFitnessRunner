package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;

public class TrackList extends CommonTrackList<Track> {
    @SerializedName("album_id")
    private int albumId;
    @SerializedName("album_intro")
    private String albumIntro;
    @SerializedName("album_title")
    private String albumTitle;
    @SerializedName("can_download")
    private boolean canDownload;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("cover_url_large")
    private String coverUrlLarge;
    @SerializedName("cover_url_middle")
    private String coverUrlMiddle;
    @SerializedName("cover_url_small")
    private String coverUrlSmall;
    @SerializedName("current_page")
    private int currentPage;

    public int getAlbumId() {
        return this.albumId;
    }

    public String getAlbumIntro() {
        return this.albumIntro;
    }

    public String getAlbumTitle() {
        return this.albumTitle;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getCoverUrlLarge() {
        return this.coverUrlLarge;
    }

    public String getCoverUrlMiddle() {
        return this.coverUrlMiddle;
    }

    public String getCoverUrlSmall() {
        return this.coverUrlSmall;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public boolean isCanDownload() {
        return this.canDownload;
    }

    public void setAlbumId(int i) {
        this.albumId = i;
    }

    public void setAlbumIntro(String str) {
        this.albumIntro = str;
    }

    public void setAlbumTitle(String str) {
        this.albumTitle = str;
    }

    public void setCanDownload(boolean z) {
        this.canDownload = z;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCoverUrlLarge(String str) {
        this.coverUrlLarge = str;
    }

    public void setCoverUrlMiddle(String str) {
        this.coverUrlMiddle = str;
    }

    public void setCoverUrlSmall(String str) {
        this.coverUrlSmall = str;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackList [albumId=");
        stringBuilder.append(this.albumId);
        stringBuilder.append(", albumTitle=");
        stringBuilder.append(this.albumTitle);
        stringBuilder.append(", categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", albumIntro=");
        stringBuilder.append(this.albumIntro);
        stringBuilder.append(", coverUrlSmall=");
        stringBuilder.append(this.coverUrlSmall);
        stringBuilder.append(", coverUrlMiddle=");
        stringBuilder.append(this.coverUrlMiddle);
        stringBuilder.append(", coverUrlLarge=");
        stringBuilder.append(this.coverUrlLarge);
        stringBuilder.append(", currentPage=");
        stringBuilder.append(this.currentPage);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
