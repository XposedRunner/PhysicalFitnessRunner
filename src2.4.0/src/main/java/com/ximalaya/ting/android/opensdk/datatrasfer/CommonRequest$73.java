package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.metadata.MetaData;
import com.ximalaya.ting.android.opensdk.model.metadata.MetaDataList;
import java.util.List;

class CommonRequest$73 implements CommonRequest$IRequestCallBack<MetaDataList> {
    CommonRequest$73() {
    }

    public MetaDataList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<MetaData>>() {
        }.getType(), str);
        MetaDataList metaDataList = new MetaDataList();
        metaDataList.setMetaDatas(list);
        return metaDataList;
    }
}
