package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.UpdateBatch;
import com.ximalaya.ting.android.opensdk.model.album.UpdateBatchList;
import java.util.List;

class CommonRequest$6 implements CommonRequest$IRequestCallBack<UpdateBatchList> {
    CommonRequest$6() {
    }

    public UpdateBatchList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<UpdateBatch>>() {
        }.getType(), str);
        UpdateBatchList updateBatchList = new UpdateBatchList();
        updateBatchList.setList(list);
        return updateBatchList;
    }
}
