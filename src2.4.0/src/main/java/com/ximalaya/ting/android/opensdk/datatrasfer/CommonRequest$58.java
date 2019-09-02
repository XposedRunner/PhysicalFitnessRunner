package com.ximalaya.ting.android.opensdk.datatrasfer;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.util.AsyncGson.IResult;

class CommonRequest$58 implements IResult<String> {
    final /* synthetic */ IDataCallBack val$dataCallBack;

    CommonRequest$58(IDataCallBack iDataCallBack) {
        this.val$dataCallBack = iDataCallBack;
    }

    public void postException(Exception exception) {
    }

    public void postResult(String str) {
        if (!TextUtils.isEmpty(str)) {
            CommonRequest.postStringOld(str, this.val$dataCallBack);
        }
    }
}
