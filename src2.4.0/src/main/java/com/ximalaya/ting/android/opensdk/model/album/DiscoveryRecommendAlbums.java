package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class DiscoveryRecommendAlbums extends XimalayaResponse {
    @SerializedName("albums")
    private List<Album> albumList;
    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("display_category_name")
    private String displayCategoryName;
    @SerializedName("need_show_high_quality_tag")
    private boolean needAddHighQualityTag;

    public List<Album> getAlbumList() {
        return this.albumList;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getDisplayCategoryName() {
        return this.displayCategoryName;
    }

    public boolean isNeedAddHighQualityTag() {
        return this.needAddHighQualityTag;
    }

    public void setAlbumList(List<Album> list) {
        this.albumList = list;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setDisplayCategoryName(String str) {
        this.displayCategoryName = str;
    }
}
