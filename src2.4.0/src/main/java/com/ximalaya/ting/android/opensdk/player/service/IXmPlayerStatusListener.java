package com.ximalaya.ting.android.opensdk.player.service;

import com.ximalaya.ting.android.opensdk.model.PlayableModel;

public interface IXmPlayerStatusListener {
    void onBufferProgress(int i);

    void onBufferingStart();

    void onBufferingStop();

    boolean onError(XmPlayerException xmPlayerException);

    void onPlayPause();

    void onPlayProgress(int i, int i2);

    void onPlayStart();

    void onPlayStop();

    void onSoundPlayComplete();

    void onSoundPrepared();

    void onSoundSwitch(PlayableModel playableModel, PlayableModel playableModel2);
}
