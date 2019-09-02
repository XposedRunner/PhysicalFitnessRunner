package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.HotAggregation;
import com.ximalaya.ting.android.opensdk.model.album.HotAggregationList;
import java.util.List;

class CommonRequest$40 implements CommonRequest$IRequestCallBack<HotAggregationList> {
    CommonRequest$40() {
    }

    public HotAggregationList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<HotAggregation>>() {
        }.getType(), str);
        HotAggregationList hotAggregationList = new HotAggregationList();
        hotAggregationList.setList(list);
        return hotAggregationList;
    }
}
