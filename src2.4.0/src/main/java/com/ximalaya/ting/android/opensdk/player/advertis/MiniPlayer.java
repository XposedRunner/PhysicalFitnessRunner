package com.ximalaya.ting.android.opensdk.player.advertis;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.os.Build.VERSION;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.Logger;
import java.io.FileDescriptor;

public class MiniPlayer {
    public static final int STATE_COMPLETED = 5;
    public static final int STATE_ERR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 3;
    public static final int STATE_PREPARED = 1;
    public static final int STATE_STARTED = 2;
    public static final int STATE_STOPPED = 4;
    private static final String TAG = "MiniPlayer";
    private Advertis mAdvertis;
    private AudioManager mAudioManager;
    private OnCompletionListener mCompletionListener;
    private float mLeftVol = 1.0f;
    private boolean mLoop = false;
    private MediaPlayer mPlayer;
    private PlayerStatusListener mPlayerStatusListener;
    private float mRightVol = 1.0f;
    private int mStatus = -1;
    private int mStreamType = 3;

    public interface PlayerStatusListener {
        void onComplete();

        boolean onError(Exception exception, int i, int i2);

        void onPause();

        void onStart();

        void onStop();
    }

    public MiniPlayer() {
        resetPlayer();
    }

    public Advertis getAdvertis() {
        return this.mAdvertis;
    }

    public int getCurrPos() {
        switch (this.mStatus) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return this.mPlayer.getCurrentPosition();
            default:
                return 0;
        }
    }

    public int getDuration() {
        switch (this.mStatus) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return this.mPlayer.getDuration();
            default:
                return 0;
        }
    }

    public MediaPlayer getMediaPlayer() {
        return this.mPlayer;
    }

    @TargetApi(9)
    public int getSessionId() {
        return VERSION.SDK_INT >= 9 ? this.mPlayer.getAudioSessionId() : 0;
    }

    public int getStatus() {
        return this.mStatus;
    }

    @Deprecated
    public void init(Context context, Uri uri) {
        try {
            resetPlayer();
            this.mPlayer.setDataSource(context, uri);
            this.mPlayer.prepare();
            this.mStatus = 1;
        } catch (Exception e) {
            e.printStackTrace();
            this.mStatus = -1;
        }
    }

    @Deprecated
    public void init(Context context, Uri uri, int i, int i2) {
        try {
            resetPlayer();
            this.mPlayer.setDataSource(context, uri);
            this.mPlayer.prepare();
            this.mStatus = 1;
        } catch (Exception e) {
            e.printStackTrace();
            this.mStatus = -1;
        }
    }

    public void init(FileDescriptor fileDescriptor, int i, final boolean[] zArr) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("init seek ");
        stringBuilder.append(i);
        Logger.e(str, stringBuilder.toString());
        try {
            resetPlayer();
            this.mPlayer.setDataSource(fileDescriptor);
            this.mPlayer.prepare();
            this.mPlayer.setOnSeekCompleteListener(new OnSeekCompleteListener() {
                public void onSeekComplete(MediaPlayer mediaPlayer) {
                    if (zArr != null && zArr.length > 0) {
                        zArr[0] = true;
                    }
                }
            });
            if (i > 0) {
                this.mPlayer.seekTo(i);
            }
            this.mStatus = 1;
        } catch (Exception e) {
            e.printStackTrace();
            this.mStatus = -1;
            if (zArr != null && zArr.length > 0) {
                zArr[0] = true;
            }
        }
    }

    public void init(FileDescriptor fileDescriptor, long j, long j2) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("init offset ");
        stringBuilder.append(j);
        stringBuilder.append(", length ");
        stringBuilder.append(j2);
        Logger.e(str, stringBuilder.toString());
        try {
            resetPlayer();
            this.mPlayer.setDataSource(fileDescriptor, j, j2);
            this.mPlayer.prepare();
            this.mStatus = 1;
        } catch (Exception e) {
            e.printStackTrace();
            this.mStatus = -1;
        }
    }

    public void init(String str) throws Exception {
        resetPlayer();
        this.mPlayer.setDataSource(str);
        this.mPlayer.prepare();
        this.mStatus = 1;
    }

    public void init(String str, Advertis advertis) throws Exception {
        resetPlayer();
        this.mPlayer.setDataSource(str);
        this.mPlayer.prepare();
        this.mStatus = 1;
        this.mAdvertis = advertis;
        if (XmPlayerService.getPlayerSrvice() != null) {
            try {
                this.mAudioManager = (AudioManager) XmPlayerService.getPlayerSrvice().getSystemService("audio");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isPaused() {
        return this.mStatus == 3;
    }

    public boolean isPlaying() {
        return this.mStatus == 2;
    }

    public boolean isStop() {
        return this.mStatus == 4;
    }

    public void pausePlay() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ad pausePlay 0:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        try {
            if (this.mStatus == 2) {
                this.mPlayer.pause();
                this.mStatus = 3;
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onPause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.mStatus = -1;
            if (this.mPlayerStatusListener != null) {
                this.mPlayerStatusListener.onError(e, 0, 0);
            }
        }
    }

    public void release() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AD release 0:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        try {
            if (this.mPlayer != null) {
                if (this.mStatus == 2) {
                    this.mPlayer.stop();
                    if (this.mPlayerStatusListener != null) {
                        this.mPlayerStatusListener.onStop();
                    }
                }
                this.mPlayer.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mPlayerStatusListener != null) {
                this.mPlayerStatusListener.onError(e, 0, 0);
            }
        }
        this.mAdvertis = null;
        this.mPlayer = null;
    }

    public void resetPlayer() {
        try {
            if (this.mPlayer == null) {
                this.mPlayer = new MediaPlayer();
                this.mStatus = 0;
                this.mPlayer.setOnErrorListener(new OnErrorListener() {
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        MiniPlayer.this.mStatus = -1;
                        if (MiniPlayer.this.mPlayerStatusListener != null) {
                            MiniPlayer.this.mPlayerStatusListener.onError(null, i, i2);
                        }
                        return true;
                    }
                });
                this.mPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        MiniPlayer.this.mStatus = 5;
                        if (MiniPlayer.this.mCompletionListener != null) {
                            MiniPlayer.this.mCompletionListener.onCompletion(mediaPlayer);
                        }
                        if (MiniPlayer.this.mPlayerStatusListener != null) {
                            MiniPlayer.this.mPlayerStatusListener.onComplete();
                        }
                    }
                });
            }
            if (this.mStatus == 2) {
                this.mPlayer.stop();
                this.mStatus = 4;
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onStop();
                }
            }
            this.mPlayer.reset();
            this.mPlayer.setLooping(this.mLoop);
            this.mPlayer.setVolume(this.mLeftVol, this.mRightVol);
            this.mStatus = 0;
        } catch (Exception e) {
            e.printStackTrace();
            this.mStatus = -1;
            if (this.mPlayerStatusListener != null) {
                this.mPlayerStatusListener.onError(e, 0, 0);
            }
        }
    }

    public void restart() {
        try {
            switch (this.mStatus) {
                case 1:
                case 5:
                    this.mPlayer.start();
                    this.mStatus = 2;
                    if (this.mPlayerStatusListener != null) {
                        this.mPlayerStatusListener.onStart();
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                    this.mPlayer.stop();
                    this.mPlayer.prepare();
                    this.mPlayer.start();
                    this.mStatus = 2;
                    if (this.mPlayerStatusListener != null) {
                        this.mPlayerStatusListener.onStart();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.mStatus = -1;
            if (this.mPlayerStatusListener != null) {
                this.mPlayerStatusListener.onError(e, 0, 0);
            }
        }
    }

    public void setAdvertis(Advertis advertis) {
        this.mAdvertis = advertis;
    }

    public void setAudioStreamType(int i) {
        this.mStreamType = i;
    }

    public void setLooping(boolean z) {
        this.mLoop = z;
        if (this.mStatus != -1) {
            this.mPlayer.setLooping(z);
        }
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mCompletionListener = onCompletionListener;
    }

    public void setPlayerStatueListener(PlayerStatusListener playerStatusListener) {
        this.mPlayerStatusListener = playerStatusListener;
    }

    public void setVolume(float f, float f2) {
        this.mLeftVol = f;
        this.mRightVol = f2;
        if (this.mStatus != -1) {
            this.mPlayer.setVolume(this.mLeftVol, this.mRightVol);
        }
    }

    public void startPlay() {
        try {
            if (this.mAdvertis == null || this.mAdvertis.getVolume() == 0) {
                setVolume(1.0f, 1.0f);
            } else {
                float volume = ((float) this.mAdvertis.getVolume()) / 100.0f;
                setVolume(volume, volume);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("playAd 1:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            if (!(this.mStatus == 1 || this.mStatus == 3)) {
                if (this.mStatus != 5) {
                    if (this.mStatus == 4) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("playAd 3:");
                        stringBuilder.append(System.currentTimeMillis());
                        Logger.logToSd(stringBuilder.toString());
                        this.mPlayer.prepare();
                        this.mPlayer.start();
                        this.mStatus = 2;
                        if (this.mPlayerStatusListener != null) {
                            this.mPlayerStatusListener.onStart();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("playAd 2:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            this.mPlayer.start();
            this.mStatus = 2;
            if (this.mPlayerStatusListener != null) {
                this.mPlayerStatusListener.onStart();
            }
        } catch (Exception e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("playAd 4:");
            stringBuilder2.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder2.toString());
            e.printStackTrace();
            this.mStatus = -1;
            if (this.mPlayerStatusListener != null) {
                this.mPlayerStatusListener.onError(e, 0, 0);
            }
        }
    }

    public void stopPlay() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AD stopPlay 0:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        try {
            if (this.mStatus == 2) {
                this.mPlayer.stop();
                this.mStatus = 4;
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onStop();
                }
            } else {
                this.mPlayer.reset();
                this.mStatus = 0;
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onStop();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.mStatus = -1;
            if (this.mPlayerStatusListener != null) {
                this.mPlayerStatusListener.onError(e, 0, 0);
            }
        }
        this.mAdvertis = null;
    }
}
