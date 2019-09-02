package com.ximalaya.ting.android.opensdk.model.word;

import com.google.gson.annotations.SerializedName;

public class AlbumResult {
    @SerializedName("id")
    private long albumId;
    @SerializedName("album_title")
    private String albumTitle;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("cover_url_small")
    private String coverUrlSmall;
    @SerializedName("highlight_album_title")
    private String hightlightAlbumTitle;

    public long getAlbumId() {
        return this.albumId;
    }

    public String getAlbumTitle() {
        return this.albumTitle;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getCoverUrlSmall() {
        return this.coverUrlSmall;
    }

    public String getHightlightAlbumTitle() {
        return this.hightlightAlbumTitle;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public void setAlbumTitle(String str) {
        this.albumTitle = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCoverUrlSmall(String str) {
        this.coverUrlSmall = str;
    }

    public void setHightlightAlbumTitle(String str) {
        this.hightlightAlbumTitle = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AlbumResult [albumId=");
        stringBuilder.append(this.albumId);
        stringBuilder.append(", albumTitle=");
        stringBuilder.append(this.albumTitle);
        stringBuilder.append(", hightlightAlbumTitle=");
        stringBuilder.append(this.hightlightAlbumTitle);
        stringBuilder.append(", categoryName=");
        stringBuilder.append(this.categoryName);
        stringBuilder.append(", coverUrlSmall=");
        stringBuilder.append(this.coverUrlSmall);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
