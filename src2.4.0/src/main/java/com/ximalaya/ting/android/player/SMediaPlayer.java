package com.ximalaya.ting.android.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
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
import java.io.IOException;
import java.util.Map;

public class SMediaPlayer implements Callback, XMediaplayerImpl {
    private static final int MSG_COMPLETE = 9;
    private static final int MSG_INCREMENTAL_PREPARE = 2;
    private static final int MSG_PAUSE = 3;
    private static final int MSG_PREPARE = 1;
    private static final int MSG_RELEASE = 5;
    private static final int MSG_RESET = 7;
    private static final int MSG_SEEK_TO = 6;
    private static final int MSG_SET_DATA_SOURCE = 8;
    private static final int MSG_START = 0;
    private static final int MSG_STOP = 4;
    private boolean hasSetDataSource = false;
    private boolean isBuffering = false;
    private boolean isPrepareing = false;
    private boolean isRelase = false;
    private boolean isSeeking = false;
    private AudioType mAudioType = AudioType.NORMAL_FILE;
    private int mCurrentPosition = 0;
    private int mDuration = 0;
    private Handler mEventHandler;
    private final Handler mHandler;
    private final HandlerThread mInternalPlaybackThread;
    public MediaPlayer mMediaPlayer = new MediaPlayer();
    private OnPositionChangeListener mOnPositionChangeListener;
    private int mPlayState;
    private String mPlayUrl;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (SMediaPlayer.this.mOnPositionChangeListener != null) {
                if (!(SMediaPlayer.this.mPlayState != 4 || SMediaPlayer.this.isBuffering || SMediaPlayer.this.isSeeking)) {
                    SMediaPlayer.this.mOnPositionChangeListener.onPositionChange(SMediaPlayer.this, SMediaPlayer.this.getCurrentPosition());
                }
                SMediaPlayer.this.mEventHandler.postDelayed(SMediaPlayer.this.runnable, 1000);
            }
        }
    };
    private long time = System.currentTimeMillis();

    public SMediaPlayer() {
        this.mMediaPlayer.setAudioStreamType(3);
        this.mEventHandler = new Handler(Looper.myLooper());
        this.mPlayState = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(":Handler");
        this.mInternalPlaybackThread = new PriorityHandlerThread(stringBuilder.toString(), -16);
        this.mInternalPlaybackThread.start();
        this.mHandler = new Handler(this.mInternalPlaybackThread.getLooper(), this);
    }

    private void printTime(String str) {
        String str2 = XMediaPlayer.Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" nowtime:");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("long:");
        stringBuilder.append(System.currentTimeMillis() - this.time);
        Logger.log(str2, stringBuilder.toString());
        this.time = System.currentTimeMillis();
    }

    private void resetState() {
        this.isSeeking = false;
        this.isBuffering = false;
        this.isPrepareing = false;
        this.mDuration = 0;
    }

    public AudioType getAudioType() {
        return this.mAudioType;
    }

    public int getCurrentPosition() {
        if (!(this.isSeeking || this.isBuffering || this.isPrepareing || this.isRelase)) {
            this.mCurrentPosition = this.mMediaPlayer.getCurrentPosition();
        }
        return this.mCurrentPosition;
    }

    public int getDuration() {
        if (this.mDuration != 0) {
            return this.mDuration;
        }
        if (!(this.isSeeking || this.isBuffering || this.isPrepareing || this.isRelase)) {
            this.mDuration = this.mMediaPlayer.getDuration();
        }
        return this.mDuration;
    }

    public int getPlayState() {
        return this.mPlayState;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    this.mPlayState = 4;
                    printTime("MSG_START start");
                    this.mMediaPlayer.start();
                    printTime("MSG_START end");
                    return true;
                case 1:
                    this.mPlayState = 2;
                    printTime("MSG_PREPARE start");
                    this.mMediaPlayer.prepareAsync();
                    printTime("MSG_PREPARE end");
                    return true;
                case 3:
                    this.mPlayState = 5;
                    this.mMediaPlayer.pause();
                    return true;
                case 4:
                    this.mPlayState = 6;
                    this.mMediaPlayer.stop();
                    return true;
                case 5:
                    this.mPlayState = 9;
                    printTime("MSG_RELEASE start");
                    this.mMediaPlayer.release();
                    printTime("MSG_RELEASE end");
                    return true;
                case 6:
                    this.mMediaPlayer.seekTo(((Integer) message.obj).intValue());
                    return true;
                case 7:
                    this.mPlayState = 0;
                    printTime("MSG_RESET start");
                    this.mMediaPlayer.reset();
                    resetState();
                    printTime("MSG_RESET end");
                    return true;
                case 8:
                    printTime("MSG_SET_DATA_SOURCE start");
                    if (message.obj != null) {
                        try {
                            this.mMediaPlayer.setDataSource(message.obj.toString());
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (SecurityException e2) {
                            e2.printStackTrace();
                        } catch (IllegalStateException e3) {
                            e3.printStackTrace();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    printTime("MSG_SET_DATA_SOURCE end");
                    return true;
                default:
                    return false;
            }
        } catch (Exception unused) {
            return true;
        }
        return true;
    }

    public boolean isPlaying() {
        return (this.isSeeking || this.isBuffering || this.isPrepareing || this.isRelase) ? false : this.mMediaPlayer.isPlaying();
    }

    public boolean isUseSystemPlayer() {
        return true;
    }

    public void pause() {
        this.mHandler.obtainMessage(3).sendToTarget();
    }

    public void prepareAsync() {
        this.isPrepareing = true;
        printTime("prepareAsync");
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public void release() {
        printTime("release");
        resetState();
        this.isRelase = true;
        if (this.mHandler != null) {
            this.mHandler.obtainMessage(5).sendToTarget();
        }
        this.mOnPositionChangeListener = null;
        if (this.mInternalPlaybackThread.getLooper() != null) {
            this.mInternalPlaybackThread.getLooper().quit();
            this.mInternalPlaybackThread.interrupt();
        }
    }

    public void removeProxy() {
        StaticConfig.setHttpConfig(null);
    }

    public void reset() {
        this.mDuration = 0;
        if (this.hasSetDataSource) {
            printTime("reset");
            this.mHandler.obtainMessage(7).sendToTarget();
        }
    }

    public void seekTo(int i) {
        this.isSeeking = true;
        this.mHandler.obtainMessage(6, Integer.valueOf(i)).sendToTarget();
    }

    public void setAudioStreamType(int i) {
        this.mMediaPlayer.setAudioStreamType(i);
    }

    public void setDataSource(FileDescriptor fileDescriptor, String str) {
        this.hasSetDataSource = true;
        try {
            this.mMediaPlayer.setDataSource(fileDescriptor);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void setDataSource(String str) {
        printTime("setDataSource");
        this.mDuration = 0;
        if (str.contains("m3u8")) {
            this.mAudioType = AudioType.M3U8_FILE;
        } else {
            this.mAudioType = AudioType.NORMAL_FILE;
        }
        this.hasSetDataSource = true;
        this.mHandler.obtainMessage(8, str).sendToTarget();
    }

    public void setDownloadBufferSize(long j) {
    }

    public void setHeadsOfReq(Map<String, String> map) {
        StaticConfig.setHeads(map);
    }

    public void setOnBufferingUpdateListener(final OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                if (onBufferingUpdateListener != null) {
                    onBufferingUpdateListener.onBufferingUpdate(SMediaPlayer.this, i);
                }
            }
        });
    }

    public void setOnCompletionListener(final OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                SMediaPlayer.this.mPlayState = 11;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(SMediaPlayer.this);
                }
            }
        });
    }

    public void setOnErrorListener(final OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                SMediaPlayer.this.resetState();
                if (onErrorListener == null) {
                    return false;
                }
                boolean onError = onErrorListener.onError(SMediaPlayer.this, i, i2);
                if (!onError) {
                    SMediaPlayer.this.mPlayState = 8;
                }
                return onError;
            }
        });
    }

    public void setOnInfoListener(final OnInfoListener onInfoListener) {
        Logger.log(XMediaplayerJNI.Tag, "SMediaPlayer setOnInfoListener");
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                String str = XMediaplayerJNI.Tag;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SMediaPlayer OnInfoListener:");
                stringBuilder.append(i);
                stringBuilder.append("extra:");
                stringBuilder.append(i2);
                Logger.log(str, stringBuilder.toString());
                switch (i) {
                    case XMediaPlayer.MEDIA_INFO_BUFFERING_START /*701*/:
                        SMediaPlayer.this.isBuffering = true;
                        break;
                    case XMediaPlayer.MEDIA_INFO_BUFFERING_END /*702*/:
                        SMediaPlayer.this.isBuffering = false;
                        break;
                }
                return onInfoListener != null ? onInfoListener.onInfo(SMediaPlayer.this, 10, i) : false;
            }
        });
    }

    public void setOnPlayDataOutputListener(OnPlayDataOutputListener onPlayDataOutputListener) {
    }

    public void setOnPositionChangeListener(OnPositionChangeListener onPositionChangeListener) {
        this.mOnPositionChangeListener = onPositionChangeListener;
        if (this.mOnPositionChangeListener != null) {
            this.mEventHandler.postDelayed(this.runnable, 1000);
        }
    }

    public void setOnPreparedListener(final OnPreparedListener onPreparedListener) {
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                SMediaPlayer.this.printTime("onPrepared");
                SMediaPlayer.this.mPlayState = 3;
                SMediaPlayer.this.isPrepareing = false;
                SMediaPlayer.this.mDuration = SMediaPlayer.this.mMediaPlayer.getDuration();
                SMediaPlayer.this.mCurrentPosition = SMediaPlayer.this.mMediaPlayer.getCurrentPosition();
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(SMediaPlayer.this);
                }
            }
        });
    }

    public void setOnSeekCompleteListener(final OnSeekCompleteListener onSeekCompleteListener) {
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                SMediaPlayer.this.isSeeking = false;
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete(SMediaPlayer.this);
                }
            }
        });
    }

    public void setPreBufferUrl(String str) {
    }

    public void setProxy(HttpConfig httpConfig) {
        StaticConfig.setHttpConfig(httpConfig);
    }

    public void setSoundTouchAllParams(float f, float f2, float f3) {
    }

    public void setTempo(float f) {
    }

    public void setVolume(float f, float f2) {
        this.mMediaPlayer.setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        this.mMediaPlayer.setWakeMode(context, i);
    }

    public void start() {
        printTime("start");
        if (this.mPlayState == 5 || this.mPlayState == 3) {
            this.mHandler.obtainMessage(0).sendToTarget();
        }
    }

    public void stop() {
        this.mHandler.obtainMessage(4).sendToTarget();
    }
}
