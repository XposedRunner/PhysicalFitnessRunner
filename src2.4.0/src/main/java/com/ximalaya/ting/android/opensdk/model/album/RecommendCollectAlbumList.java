package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class RecommendCollectAlbumList extends XimalayaResponse {
    private List<Album> albumList;

    public List<Album> getAlbumList() {
        return this.albumList;
    }

    public void setAlbumList(List<Album> list) {
        this.albumList = list;
    }
}
