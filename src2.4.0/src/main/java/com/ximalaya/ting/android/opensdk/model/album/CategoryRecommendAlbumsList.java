package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class CategoryRecommendAlbumsList extends XimalayaResponse {
    private List<CategoryRecommendAlbums> categoryRecommendAlbumses;

    public List<CategoryRecommendAlbums> getCategoryRecommendAlbumses() {
        return this.categoryRecommendAlbumses;
    }

    public void setCategoryRecommendAlbumses(List<CategoryRecommendAlbums> list) {
        this.categoryRecommendAlbumses = list;
    }
}
