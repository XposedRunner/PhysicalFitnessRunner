package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;

public class SearchTrackList extends CommonTrackList<Track> {
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("tag_name")
    private String tagName;

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }
}
