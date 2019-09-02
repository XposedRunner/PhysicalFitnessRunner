package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class RelativeAlbums extends XimalayaResponse {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("reletive_albums")
    private List<Album> relativeAlbumList;
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("total_page")
    private int totalPage;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<Album> getRelativeAlbumList() {
        return this.relativeAlbumList;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setRelativeAlbumList(List<Album> list) {
        this.relativeAlbumList = list;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RelativeAlbums [totalPage=");
        stringBuilder.append(this.totalPage);
        stringBuilder.append(", totalCount=");
        stringBuilder.append(this.totalCount);
        stringBuilder.append(", currentPage=");
        stringBuilder.append(this.currentPage);
        stringBuilder.append(", relativeAlbumList=");
        stringBuilder.append(this.relativeAlbumList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
