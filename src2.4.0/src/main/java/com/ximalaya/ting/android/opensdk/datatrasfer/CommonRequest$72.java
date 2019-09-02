package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.CategoryRecommendAlbums;
import com.ximalaya.ting.android.opensdk.model.album.CategoryRecommendAlbumsList;
import java.util.List;

class CommonRequest$72 implements CommonRequest$IRequestCallBack<CategoryRecommendAlbumsList> {
    CommonRequest$72() {
    }

    public CategoryRecommendAlbumsList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<CategoryRecommendAlbums>>() {
        }.getType(), str);
        CategoryRecommendAlbumsList categoryRecommendAlbumsList = new CategoryRecommendAlbumsList();
        categoryRecommendAlbumsList.setCategoryRecommendAlbumses(list);
        return categoryRecommendAlbumsList;
    }
}
