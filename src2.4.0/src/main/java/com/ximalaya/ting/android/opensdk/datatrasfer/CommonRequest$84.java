package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.ximalaya.ting.android.opensdk.model.history.PlayHistoryList;

class CommonRequest$84 implements CommonRequest$IRequestCallBack<PlayHistoryList> {
    CommonRequest$84() {
    }

    public PlayHistoryList success(String str) throws Exception {
        return new PlayHistoryList(str);
    }
}
