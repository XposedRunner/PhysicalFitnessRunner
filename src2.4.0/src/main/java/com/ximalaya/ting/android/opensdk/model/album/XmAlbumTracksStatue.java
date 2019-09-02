package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class XmAlbumTracksStatue extends XimalayaResponse {
    @SerializedName("track_ids")
    private List<XmTrackStatue> mTrackStatues;
    @SerializedName("total_count")
    private int totalCount;

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<XmTrackStatue> getTrackStatues() {
        return this.mTrackStatues;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTrackStatues(List<XmTrackStatue> list) {
        this.mTrackStatues = list;
    }
}
