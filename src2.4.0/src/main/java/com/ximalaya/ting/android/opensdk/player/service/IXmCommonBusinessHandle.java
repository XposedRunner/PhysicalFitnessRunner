package com.ximalaya.ting.android.opensdk.player.service;

import com.ximalaya.ting.android.opensdk.model.track.Track;

public interface IXmCommonBusinessHandle {
    void closeApp();

    String getDownloadPlayPath(Track track);

    void isOldTrackDownload(Track track);
}
