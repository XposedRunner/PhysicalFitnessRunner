package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.model.SercretPubKey;

class CommonRequest$53 implements CommonRequest$IRequestCallBack<SercretPubKey> {
    CommonRequest$53() {
    }

    public SercretPubKey success(String str) throws Exception {
        return (SercretPubKey) new Gson().fromJson(str, SercretPubKey.class);
    }
}
