package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonTrackList<T extends PlayableModel> extends XimalayaResponse {
    private Map<String, String> params;
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName(alternate = {"paid_tracks"}, value = "tracks")
    private List<T> tracks;

    public static CommonTrackList<Track> newInstance() {
        CommonTrackList commonTrackList = new CommonTrackList();
        commonTrackList.setTracks(new ArrayList());
        return commonTrackList;
    }

    public void cloneCommonTrackList(CommonTrackList commonTrackList) {
        this.params = commonTrackList.params;
        this.totalCount = commonTrackList.totalCount;
        this.totalPage = commonTrackList.totalPage;
        if (this.tracks != null) {
            this.tracks.clear();
        } else {
            this.tracks = new ArrayList();
        }
        this.tracks.addAll(commonTrackList.tracks);
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public List<T> getTracks() {
        return this.tracks;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }

    public void setTracks(List<T> list) {
        this.tracks = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommonTrackList [tracks=");
        stringBuilder.append(this.tracks);
        stringBuilder.append(", params=");
        stringBuilder.append(this.params);
        stringBuilder.append(", totalCount=");
        stringBuilder.append(this.totalCount);
        stringBuilder.append(", totalPage=");
        stringBuilder.append(this.totalPage);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void updateCommonParams(CommonTrackList commonTrackList) {
        this.params = commonTrackList.params;
        this.totalCount = commonTrackList.totalCount;
        this.totalPage = commonTrackList.totalPage;
    }

    public void updateCommonTrackList(int i, CommonTrackList commonTrackList) {
        this.params = commonTrackList.params;
        this.totalCount = commonTrackList.totalCount;
        this.totalPage = commonTrackList.totalPage;
        if (this.tracks != null) {
            this.tracks.addAll(i, commonTrackList.tracks);
        } else {
            this.tracks = commonTrackList.tracks;
        }
    }

    public void updateCommonTrackList(CommonTrackList commonTrackList) {
        this.params = commonTrackList.params;
        this.totalCount = commonTrackList.totalCount;
        this.totalPage = commonTrackList.totalPage;
        if (this.tracks != null) {
            this.tracks.addAll(commonTrackList.tracks);
        } else {
            this.tracks = commonTrackList.tracks;
        }
    }
}
