package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.ranks.Rank;
import com.ximalaya.ting.android.opensdk.model.ranks.RankList;
import java.util.List;

class CommonRequest$32 implements CommonRequest$IRequestCallBack<RankList> {
    CommonRequest$32() {
    }

    public RankList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Rank>>() {
        }.getType(), str);
        RankList rankList = new RankList();
        rankList.setRankList(list);
        return rankList;
    }
}
