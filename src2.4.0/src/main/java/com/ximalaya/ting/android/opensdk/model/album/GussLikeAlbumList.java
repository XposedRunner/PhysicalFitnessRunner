package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.ArrayList;
import java.util.List;

public class GussLikeAlbumList extends XimalayaResponse {
    private List<Album> albumList = new ArrayList();

    public List<Album> getAlbumList() {
        return this.albumList;
    }

    public void setAlbumList(List<Album> list) {
        this.albumList = list;
    }
}
