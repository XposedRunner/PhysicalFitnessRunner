package com.ximalaya.ting.android.opensdk.model.column;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.List;

public class ColumnDetailTrack extends ColumnDetail {
    @SerializedName("column_items")
    private List<Track> trackList;

    public List<Track> getTrackList() {
        return this.trackList;
    }

    public void setTrackList(List<Track> list) {
        this.trackList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ColumnDetailTrack [trackList=");
        stringBuilder.append(this.trackList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
