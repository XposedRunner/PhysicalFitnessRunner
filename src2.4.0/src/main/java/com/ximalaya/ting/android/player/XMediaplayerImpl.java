package com.ximalaya.ting.android.player;

import android.content.Context;
import com.ximalaya.ting.android.player.XMediaPlayer.OnBufferingUpdateListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnCompletionListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnErrorListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnInfoListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnPlayDataOutputListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnPositionChangeListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnPreparedListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnSeekCompleteListener;
import com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType;
import com.ximalaya.ting.android.player.model.HttpConfig;
import java.io.FileDescriptor;
import java.util.Map;

public interface XMediaplayerImpl {
    public static final int COMPLETE = 11;
    public static final int ERROR = 8;
    public static final int IDLE = 0;
    public static final int INFO = 10;
    public static final int INITIALIZED = 1;
    public static final int NOT_ARCH_SUPPORT = 12;
    public static final int PAUSED = 5;
    public static final int PLAYBACK_COMPLETED = 7;
    public static final int PREPARED = 3;
    public static final int PREPARING = 2;
    public static final int RELEASED = 9;
    public static final int STARTED = 4;
    public static final int STOPPED = 6;

    AudioType getAudioType();

    int getCurrentPosition();

    int getDuration();

    int getPlayState();

    boolean isPlaying();

    boolean isUseSystemPlayer();

    void pause();

    void prepareAsync();

    void release();

    void removeProxy();

    void reset();

    void seekTo(int i);

    void setAudioStreamType(int i);

    void setDataSource(FileDescriptor fileDescriptor, String str);

    void setDataSource(String str);

    void setDownloadBufferSize(long j);

    void setHeadsOfReq(Map<String, String> map);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPlayDataOutputListener(OnPlayDataOutputListener onPlayDataOutputListener);

    void setOnPositionChangeListener(OnPositionChangeListener onPositionChangeListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setPreBufferUrl(String str);

    void setProxy(HttpConfig httpConfig);

    void setSoundTouchAllParams(float f, float f2, float f3);

    void setTempo(float f);

    void setVolume(float f, float f2);

    void setWakeMode(Context context, int i);

    void start();

    void stop();
}
