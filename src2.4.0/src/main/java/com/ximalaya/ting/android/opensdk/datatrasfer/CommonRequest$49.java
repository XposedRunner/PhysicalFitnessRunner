package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.banner.BannersContentList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.List;

class CommonRequest$49 implements CommonRequest$IRequestCallBack<BannersContentList> {
    final /* synthetic */ String val$dataTypee;

    CommonRequest$49(String str) {
        this.val$dataTypee = str;
    }

    public BannersContentList success(String str) throws Exception {
        List list;
        BannersContentList bannersContentList;
        if (this.val$dataTypee.equalsIgnoreCase("6")) {
            list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Album>>() {
            }.getType(), str);
            bannersContentList = new BannersContentList();
            bannersContentList.setAlbumList(list);
            return bannersContentList;
        } else if (this.val$dataTypee.equalsIgnoreCase("7")) {
            list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Track>>() {
            }.getType(), str);
            bannersContentList = new BannersContentList();
            bannersContentList.setTrackList(list);
            return bannersContentList;
        } else {
            throw new XimalayaException(XimalayaException.PARSE_JSON_ERROR, "parse response json data error");
        }
    }
}
