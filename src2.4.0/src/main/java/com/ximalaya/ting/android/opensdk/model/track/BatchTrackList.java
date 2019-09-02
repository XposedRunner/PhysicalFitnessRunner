package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class BatchTrackList extends XimalayaResponse {
    @SerializedName("tracks")
    private List<Track> mTracks;

    public List<Track> getTracks() {
        return this.mTracks;
    }

    public void setTracks(List<Track> list) {
        this.mTracks = list;
    }
}
