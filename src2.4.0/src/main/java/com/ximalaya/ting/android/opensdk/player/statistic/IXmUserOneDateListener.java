package com.ximalaya.ting.android.opensdk.player.statistic;

public interface IXmUserOneDateListener {
    void onPlayProgress(int i, int i2, boolean z);

    void onPlayStart(int i, boolean z);

    void onPlayStop();

    void onSeekComplete(int i);

    void onSoundSwitch();

    void release();
}
