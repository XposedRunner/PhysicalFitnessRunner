package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.pay.OrderDetail;

class CommonRequest$113 implements CommonRequest$IRequestCallBack<OrderDetail> {
    CommonRequest$113() {
    }

    public OrderDetail success(String str) throws Exception {
        return (OrderDetail) BaseResponse.getResponseBodyStringToObject(new TypeToken<OrderDetail>() {
        }.getType(), str);
    }
}
