package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

import com.zjwh.android_wh_physicalfitness.entity.music.MusicClassifyBean;
import java.util.List;

public class MusicClassifyEvent {
    private List<MusicClassifyBean> mList;

    public MusicClassifyEvent(List<MusicClassifyBean> list) {
        this.mList = list;
    }

    public List<MusicClassifyBean> getClassifyData() {
        return this.mList;
    }
}
