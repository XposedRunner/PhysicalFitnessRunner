package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.pay.BoughtStatu;
import com.ximalaya.ting.android.opensdk.model.pay.BoughtStatuList;
import java.util.List;

class CommonRequest$102 implements CommonRequest$IRequestCallBack<BoughtStatuList> {
    CommonRequest$102() {
    }

    public BoughtStatuList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<BoughtStatu>>() {
        }.getType(), str);
        BoughtStatuList boughtStatuList = new BoughtStatuList();
        boughtStatuList.setBoughtStatus(list);
        return boughtStatuList;
    }
}
