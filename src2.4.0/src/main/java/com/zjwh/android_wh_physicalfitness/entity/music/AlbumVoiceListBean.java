package com.zjwh.android_wh_physicalfitness.entity.music;

import com.ximalaya.ting.android.opensdk.model.track.Track;

public class AlbumVoiceListBean extends Track {
    private int playStatus = 0;

    public int getPlayStatus() {
        return this.playStatus;
    }

    public void setPlayStatus(int i) {
        this.playStatus = i;
    }
}
