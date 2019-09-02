package com.ximalaya.ting.android.opensdk.model.customized;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class CustomizedTrackList extends XimalayaResponse {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("customized_track_columns")
    private List<CustomizedTrack> customizedTracks;
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("total_page")
    private int totalPage;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<CustomizedTrack> getCustomizedTracks() {
        return this.customizedTracks;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setCustomizedTracks(List<CustomizedTrack> list) {
        this.customizedTracks = list;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomizedTrackList{customizedTracks=");
        stringBuilder.append(this.customizedTracks);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
