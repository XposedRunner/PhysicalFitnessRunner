package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class SubscribeAlbumList extends XimalayaResponse {
    @SerializedName("subscribe_albums")
    private List<Album> albums;
    @SerializedName("total_count")
    private int totalCount;

    public List<Album> getAlbums() {
        return this.albums;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setAlbums(List<Album> list) {
        this.albums = list;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }
}
