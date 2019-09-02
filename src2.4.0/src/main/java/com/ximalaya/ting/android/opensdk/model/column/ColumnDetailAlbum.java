package com.ximalaya.ting.android.opensdk.model.column;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import java.util.List;

public class ColumnDetailAlbum extends ColumnDetail {
    @SerializedName("column_items")
    private List<Album> albumList;

    public List<Album> getAlbumList() {
        return this.albumList;
    }

    public void setAlbumList(List<Album> list) {
        this.albumList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ColumnDetailAlbum [albumList=");
        stringBuilder.append(this.albumList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
