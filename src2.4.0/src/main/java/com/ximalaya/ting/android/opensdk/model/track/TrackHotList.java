package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;

public class TrackHotList extends CommonTrackList<Track> {
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("tag_name")
    private String tagName;

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackHotList [currentPage=");
        stringBuilder.append(this.currentPage);
        stringBuilder.append(", categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", tagName=");
        stringBuilder.append(this.tagName);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
