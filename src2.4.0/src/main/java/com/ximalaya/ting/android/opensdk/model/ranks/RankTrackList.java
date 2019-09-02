package com.ximalaya.ting.android.opensdk.model.ranks;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.List;

public class RankTrackList extends XimalayaResponse {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("tracks")
    private List<Track> trackList;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public List<Track> getTrackList() {
        return this.trackList;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }

    public void setTrackList(List<Track> list) {
        this.trackList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RankTrackList [totalPage=");
        stringBuilder.append(this.totalPage);
        stringBuilder.append(", totalCount=");
        stringBuilder.append(this.totalCount);
        stringBuilder.append(", currentPage=");
        stringBuilder.append(this.currentPage);
        stringBuilder.append(", trackList=");
        stringBuilder.append(this.trackList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
