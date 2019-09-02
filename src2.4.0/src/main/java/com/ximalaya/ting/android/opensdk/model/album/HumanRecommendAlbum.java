package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;
import java.util.List;

@Deprecated
public class HumanRecommendAlbum {
    @SerializedName("albums")
    private List<Album> albumList;
    @SerializedName("category_id")
    private long categoryId;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("human_recommend_category_name")
    private String humanRecommendCategoryName;

    public List<Album> getAlbumList() {
        return this.albumList;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getHumanRecommendCategoryName() {
        return this.humanRecommendCategoryName;
    }

    public void setAlbumList(List<Album> list) {
        this.albumList = list;
    }

    public void setCategoryId(long j) {
        this.categoryId = j;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setHumanRecommendCategoryName(String str) {
        this.humanRecommendCategoryName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HumanRecommendAlbum [categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", categoryName=");
        stringBuilder.append(this.categoryName);
        stringBuilder.append(", humanRecommendCategoryName=");
        stringBuilder.append(this.humanRecommendCategoryName);
        stringBuilder.append(", albumList=");
        stringBuilder.append(this.albumList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
