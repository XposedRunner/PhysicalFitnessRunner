package com.ximalaya.ting.android.opensdk.model.banner;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.List;

public class BannersContentList extends XimalayaResponse {
    private List<Album> albumList;
    private List<Track> trackList;

    public List<Album> getAlbumList() {
        return this.albumList;
    }

    public List<Track> getTrackList() {
        return this.trackList;
    }

    public void setAlbumList(List<Album> list) {
        this.albumList = list;
    }

    public void setTrackList(List<Track> list) {
        this.trackList = list;
    }
}
