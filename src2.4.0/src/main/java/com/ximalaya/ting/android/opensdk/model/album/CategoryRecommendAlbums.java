package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class CategoryRecommendAlbums extends XimalayaResponse {
    @SerializedName("albums")
    private List<Album> albumList;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("display_tag_name")
    private String disPlayTagName;
    @SerializedName("has_more")
    private boolean hasMore;
    @SerializedName("tag_name")
    private String tagName;

    public List<Album> getAlbumList() {
        return this.albumList;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getDisPlayTagName() {
        return this.disPlayTagName;
    }

    public String getTagName() {
        return this.tagName;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setAlbumList(List<Album> list) {
        this.albumList = list;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setDisPlayTagName(String str) {
        this.disPlayTagName = str;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }
}
