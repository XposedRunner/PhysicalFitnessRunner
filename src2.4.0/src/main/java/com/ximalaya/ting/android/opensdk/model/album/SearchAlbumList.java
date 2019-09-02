package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class SearchAlbumList extends XimalayaResponse {
    private List<Album> albums;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("tag_name")
    private String tagName;
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("total_page")
    private int totalPage;

    public List<Album> getAlbums() {
        return this.albums;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public String getTagName() {
        return this.tagName;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setAlbums(List<Album> list) {
        this.albums = list;
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

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SearchAlbumList [totalPage=");
        stringBuilder.append(this.totalPage);
        stringBuilder.append(", totalCount=");
        stringBuilder.append(this.totalCount);
        stringBuilder.append(", albums=");
        stringBuilder.append(this.albums);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
