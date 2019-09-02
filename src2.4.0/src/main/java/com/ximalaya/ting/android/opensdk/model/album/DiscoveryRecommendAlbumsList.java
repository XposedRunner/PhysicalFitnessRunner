package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class DiscoveryRecommendAlbumsList extends XimalayaResponse {
    private List<DiscoveryRecommendAlbums> discoveryRecommendAlbumses;

    public List<DiscoveryRecommendAlbums> getDiscoveryRecommendAlbumses() {
        return this.discoveryRecommendAlbumses;
    }

    public void setDiscoveryRecommendAlbumses(List<DiscoveryRecommendAlbums> list) {
        this.discoveryRecommendAlbumses = list;
    }
}
