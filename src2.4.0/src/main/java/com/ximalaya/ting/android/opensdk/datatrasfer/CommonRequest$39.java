package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.Announcer;
import com.ximalaya.ting.android.opensdk.model.album.AnnouncerListByIds;
import java.util.List;

class CommonRequest$39 implements CommonRequest$IRequestCallBack<AnnouncerListByIds> {
    CommonRequest$39() {
    }

    public AnnouncerListByIds success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Announcer>>() {
        }.getType(), str);
        AnnouncerListByIds announcerListByIds = new AnnouncerListByIds();
        announcerListByIds.setAnnouncers(list);
        return announcerListByIds;
    }
}
