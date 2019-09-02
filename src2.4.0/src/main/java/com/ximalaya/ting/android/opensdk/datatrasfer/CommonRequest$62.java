package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.coldboot.SubGenreList;
import java.util.List;

class CommonRequest$62 implements CommonRequest$IRequestCallBack<SubGenreList> {
    CommonRequest$62() {
    }

    public SubGenreList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<String>>() {
        }.getType(), str);
        SubGenreList subGenreList = new SubGenreList();
        subGenreList.setSubgenreList(list);
        return subGenreList;
    }
}
