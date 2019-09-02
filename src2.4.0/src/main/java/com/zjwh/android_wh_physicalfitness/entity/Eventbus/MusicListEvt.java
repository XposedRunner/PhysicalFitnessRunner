package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.List;

public class MusicListEvt {
    private List<Track> list;
    private int startIndex;

    public MusicListEvt(List<Track> list, int i) {
        this.list = list;
        this.startIndex = i;
    }

    public List<Track> getList() {
        return this.list;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public void setList(List<Track> list) {
        this.list = list;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }
}
