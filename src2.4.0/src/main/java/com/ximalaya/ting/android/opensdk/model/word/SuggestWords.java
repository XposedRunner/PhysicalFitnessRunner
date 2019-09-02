package com.ximalaya.ting.android.opensdk.model.word;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class SuggestWords extends XimalayaResponse {
    @SerializedName("albums")
    private List<AlbumResult> albumList;
    @SerializedName("album_total_count")
    private int albumTotalCount;
    @SerializedName("keywords")
    private List<QueryResult> keyWordList;
    @SerializedName("keyword_total_count")
    private int keywordTotalCount;

    public List<AlbumResult> getAlbumList() {
        return this.albumList;
    }

    public int getAlbumTotalCount() {
        return this.albumTotalCount;
    }

    public List<QueryResult> getKeyWordList() {
        return this.keyWordList;
    }

    public int getKeywordTotalCount() {
        return this.keywordTotalCount;
    }

    public void setAlbumList(List<AlbumResult> list) {
        this.albumList = list;
    }

    public void setAlbumTotalCount(int i) {
        this.albumTotalCount = i;
    }

    public void setKeyWordList(List<QueryResult> list) {
        this.keyWordList = list;
    }

    public void setKeywordTotalCount(int i) {
        this.keywordTotalCount = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SuggestWords [albumTotalCount=");
        stringBuilder.append(this.albumTotalCount);
        stringBuilder.append(", albumList=");
        stringBuilder.append(this.albumList);
        stringBuilder.append(", keywordTotalCount=");
        stringBuilder.append(this.keywordTotalCount);
        stringBuilder.append(", keyWordList=");
        stringBuilder.append(this.keyWordList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
