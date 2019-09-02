package com.ximalaya.ting.android.opensdk.model.customized;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class CustomizedAlbumList extends XimalayaResponse {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("customized_album_columns")
    private List<CustomizedAlbum> customizedAlbumList;
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("total_page")
    private int totalPage;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<CustomizedAlbum> getCustomizedAlbumList() {
        return this.customizedAlbumList;
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

    public void setCustomizedAlbumList(List<CustomizedAlbum> list) {
        this.customizedAlbumList = list;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }
}
