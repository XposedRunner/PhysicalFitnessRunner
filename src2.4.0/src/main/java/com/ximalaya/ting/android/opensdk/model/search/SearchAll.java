package com.ximalaya.ting.android.opensdk.model.search;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.model.album.SearchAlbumList;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioList;
import com.ximalaya.ting.android.opensdk.model.track.SearchTrackList;

public class SearchAll extends XimalayaResponse {
    @SerializedName("album_list")
    private SearchAlbumList albumList;
    @SerializedName("radio_list")
    private RadioList radioList;
    @SerializedName("track_list")
    private SearchTrackList trackList;

    public SearchAlbumList getAlbumList() {
        return this.albumList;
    }

    public RadioList getRadioList() {
        return this.radioList;
    }

    public SearchTrackList getTrackList() {
        return this.trackList;
    }

    public void setAlbumList(SearchAlbumList searchAlbumList) {
        this.albumList = searchAlbumList;
    }

    public void setRadioList(RadioList radioList) {
        this.radioList = radioList;
    }

    public void setTrackList(SearchTrackList searchTrackList) {
        this.trackList = searchTrackList;
    }
}
