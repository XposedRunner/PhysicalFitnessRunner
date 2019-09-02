package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class BatchAlbumList extends XimalayaResponse {
    private List<Album> albums;

    public List<Album> getAlbums() {
        return this.albums;
    }

    public void setAlbums(List<Album> list) {
        this.albums = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BatchAlbumList{albums=");
        stringBuilder.append(this.albums);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
