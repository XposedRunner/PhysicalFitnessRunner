package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;

public class LastPlayTrackList extends CommonTrackList<Track> {
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("current_page")
    private int pageid;
    @SerializedName("tag_name")
    private String tagname;

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getPageid() {
        return this.pageid;
    }

    public String getTagname() {
        return this.tagname;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setPageid(int i) {
        this.pageid = i;
    }

    public void setTagname(String str) {
        this.tagname = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LastPlayTrackList [categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", tagname=");
        stringBuilder.append(this.tagname);
        stringBuilder.append(", pageid=");
        stringBuilder.append(this.pageid);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
