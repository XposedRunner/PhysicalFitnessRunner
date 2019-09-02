package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class TrackIdList extends XimalayaResponse {
    @SerializedName("total_count")
    private int mTotalCount;
    @SerializedName("track_ids")
    private List<TrackId> mTrackIds;

    public int getTotalCount() {
        return this.mTotalCount;
    }

    public List<TrackId> getTrackIds() {
        return this.mTrackIds;
    }
}
