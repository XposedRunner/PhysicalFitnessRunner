package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioList;
import java.util.List;

class CommonRequest$35 implements CommonRequest$IRequestCallBack<RadioList> {
    CommonRequest$35() {
    }

    public RadioList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Radio>>() {
        }.getType(), str);
        RadioList radioList = new RadioList();
        radioList.setRadios(list);
        return radioList;
    }
}
