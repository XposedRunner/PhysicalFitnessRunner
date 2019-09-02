package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.httputil.XmSecretKeyUtil;
import com.ximalaya.ting.android.opensdk.model.track.TrackBaseInfo;

class CommonRequest$51 implements CommonRequest$IRequestCallBack<TrackBaseInfo> {
    CommonRequest$51() {
    }

    public TrackBaseInfo success(String str) throws Exception {
        TrackBaseInfo trackBaseInfo = (TrackBaseInfo) new Gson().fromJson(str, TrackBaseInfo.class);
        boolean z = trackBaseInfo != null && trackBaseInfo.isFallback();
        XmSecretKeyUtil.getInstance().conversionModel(trackBaseInfo, z);
        return trackBaseInfo;
    }
}
