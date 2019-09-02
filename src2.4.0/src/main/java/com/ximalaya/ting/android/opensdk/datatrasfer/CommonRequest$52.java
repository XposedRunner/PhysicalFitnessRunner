package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.model.SercretPubKey;

class CommonRequest$52 implements CommonRequest$IRequestCallBack<SercretPubKey> {
    CommonRequest$52() {
    }

    public SercretPubKey success(String str) throws Exception {
        SercretPubKey sercretPubKey = (SercretPubKey) new Gson().fromJson(str, SercretPubKey.class);
        return (sercretPubKey == null || !sercretPubKey.isFallBack()) ? sercretPubKey : null;
    }
}
