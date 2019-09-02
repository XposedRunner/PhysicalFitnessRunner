package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.coldboot.GenreList;
import java.util.List;

class CommonRequest$61 implements CommonRequest$IRequestCallBack<GenreList> {
    CommonRequest$61() {
    }

    public GenreList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<String>>() {
        }.getType(), str);
        GenreList genreList = new GenreList();
        genreList.setGenreList(list);
        return genreList;
    }
}
