package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.word.HotWord;
import com.ximalaya.ting.android.opensdk.model.word.HotWordList;
import java.util.List;

class CommonRequest$24 implements CommonRequest$IRequestCallBack<HotWordList> {
    CommonRequest$24() {
    }

    public HotWordList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<HotWord>>() {
        }.getType(), str);
        HotWordList hotWordList = new HotWordList();
        hotWordList.setHotWordList(list);
        return hotWordList;
    }
}
