package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

@Deprecated
public class HumanRecommendAlbumList extends XimalayaResponse {
    private List<HumanRecommendAlbum> albumList;

    public List<HumanRecommendAlbum> getAlbumList() {
        return this.albumList;
    }

    public void setAlbumList(List<HumanRecommendAlbum> list) {
        this.albumList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HumanRecommendAlbumList [albumList=");
        stringBuilder.append(this.albumList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
