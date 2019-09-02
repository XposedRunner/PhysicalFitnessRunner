package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.pay.ObfuscatePlayInfo;
import com.ximalaya.ting.android.opensdk.model.pay.ObfuscatePlayInfoList;
import java.util.List;

class CommonRequest$13 implements CommonRequest$IRequestCallBack<ObfuscatePlayInfoList> {
    CommonRequest$13() {
    }

    public ObfuscatePlayInfoList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<ObfuscatePlayInfo>>() {
        }.getType(), str);
        ObfuscatePlayInfoList obfuscatePlayInfoList = new ObfuscatePlayInfoList();
        obfuscatePlayInfoList.setObfuscatePlayInfos(list);
        return obfuscatePlayInfoList;
    }
}
