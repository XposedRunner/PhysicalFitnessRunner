package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class AnnouncerListByIds extends XimalayaResponse {
    private List<Announcer> announcers;

    public List<Announcer> getAnnouncers() {
        return this.announcers;
    }

    public void setAnnouncers(List<Announcer> list) {
        this.announcers = list;
    }
}
