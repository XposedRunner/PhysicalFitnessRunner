package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;

public class AnnouncerTrackList extends CommonTrackList<Track> {
    @SerializedName("current_page")
    private int currentPage;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }
}
