package com.ximalaya.ting.android.opensdk.player.service;

import android.content.Context;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.httputil.util.freeflow.FreeFlowServiceUtil;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.player.XMediaPlayer;
import com.ximalaya.ting.android.player.XMediaPlayer.OnBufferingUpdateListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnCompletionListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnErrorListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnInfoListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnPlayDataOutputListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnPositionChangeListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnPreparedListener;
import com.ximalaya.ting.android.player.XMediaPlayer.OnSeekCompleteListener;
import com.ximalaya.ting.android.player.XMediaplayerImpl;
import com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType;
import com.yalantis.ucrop.view.CropImageView;
import java.util.HashMap;

public class XmPlayerControl {
    private static final String TAG = "XmPlayerControl";
    public static long mLastPostion;
    public static long mPlayedDuration;
    private boolean isAudioTrackChangeState = false;
    private boolean isDLNAState = false;
    private boolean isSeek = false;
    private Context mAppCtx;
    private boolean mBuffering = false;
    private Config mConfig;
    private int mDuration;
    private volatile boolean mHasPreBufferRequestBack = true;
    private String mLastUrl;
    private XMediaplayerImpl mMediaPlayer;
    private int mOffset;
    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnInfoListener mOnInfoListener;
    private OnPlayDataOutputListener mOnPlayDataOutputListener;
    private OnPositionChangeListener mOnPositionChangeListener;
    private OnPreparedListener mOnPreparedListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private float mPitch = CropImageView.DEFAULT_ASPECT_RATIO;
    private IPlaySeekListener mPlaySeekListener;
    private IXmPlayerStatusListener mPlayerStatusListener;
    private float mRate = 1.0f;
    private PlayableModel mRealPlayableModel = null;
    private int mSeekToPosition;
    private boolean mShoudPlay = true;
    private volatile int mState;
    private float mTempo = 1.0f;

    public interface IPlaySeekListener {
        void onSeekComplete(int i);
    }

    public XmPlayerControl(Context context) {
        this.mAppCtx = context.getApplicationContext();
    }

    private void initMediaPlayerListener() {
        if (this.mOnCompletionListener == null) {
            this.mOnCompletionListener = new OnCompletionListener() {
                public void onCompletion(XMediaplayerImpl xMediaplayerImpl) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("XmPlayerControl onCompletion:");
                    stringBuilder.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder.toString());
                    if (XmPlayerControl.this.mRealPlayableModel != null) {
                        Track track = (Track) XmPlayerControl.this.mRealPlayableModel;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("XmPlayerControl onCompletion track:");
                        stringBuilder2.append(track.toString());
                        Logger.logToSd(stringBuilder2.toString());
                        if (track.isAudition()) {
                            XmPlayerControl.this.mState = 0;
                            XmPlayerControl.this.isAudioTrackChangeState = true;
                        } else {
                            XmPlayerControl.this.mState = 6;
                        }
                    } else {
                        XmPlayerControl.this.mState = 6;
                    }
                    if (XmPlayerControl.this.mPlayerStatusListener != null) {
                        XmPlayerControl.this.mPlayerStatusListener.onSoundPlayComplete();
                    }
                }
            };
        }
        if (this.mOnPreparedListener == null) {
            this.mOnPreparedListener = new OnPreparedListener() {
                public void onPrepared(XMediaplayerImpl xMediaplayerImpl) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("XmPlayerControl onPrepared:");
                    stringBuilder.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder.toString());
                    if (XmPlayerControl.this.mRealPlayableModel != null) {
                        Track track = (Track) XmPlayerControl.this.mRealPlayableModel;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("XmPlayerControl onPrepared track:");
                        stringBuilder2.append(track.toString());
                        Logger.logToSd(stringBuilder2.toString());
                    }
                    XmPlayerControl.this.mState = 2;
                    XmPlayerControl.this.mDuration = xMediaplayerImpl.getDuration();
                    if (XmPlayerControl.this.mPlayerStatusListener != null) {
                        XmPlayerControl.this.mPlayerStatusListener.onSoundPrepared();
                    }
                    if (XmPlayerControl.this.mShoudPlay) {
                        XmPlayerControl.this.play();
                    } else {
                        XmPlayerControl.this.mShoudPlay = true;
                    }
                }
            };
        }
        if (this.mOnSeekCompleteListener == null) {
            this.mOnSeekCompleteListener = new OnSeekCompleteListener() {
                public void onSeekComplete(XMediaplayerImpl xMediaplayerImpl) {
                    XmPlayerControl.this.mState;
                    if (XmPlayerControl.this.isSeek) {
                        XmPlayerControl.mLastPostion = (long) XmPlayerControl.this.mSeekToPosition;
                        if (XmPlayerControl.this.mPlaySeekListener != null) {
                            XmPlayerControl.this.mPlaySeekListener.onSeekComplete(XmPlayerControl.this.mSeekToPosition);
                        }
                        XmPlayerControl.this.isSeek = false;
                    }
                }
            };
        }
        if (this.mOnErrorListener == null) {
            this.mOnErrorListener = new OnErrorListener() {
                public boolean onError(XMediaplayerImpl xMediaplayerImpl, int i, int i2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("XmPlayerControl onError what:");
                    stringBuilder.append(i);
                    stringBuilder.append(" extra:");
                    stringBuilder.append(i2);
                    stringBuilder.append(" time:");
                    stringBuilder.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder.toString());
                    if (XmPlayerControl.this.mRealPlayableModel != null) {
                        Track track = (Track) XmPlayerControl.this.mRealPlayableModel;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("XmPlayerControl onError track:");
                        stringBuilder2.append(track.toString());
                        Logger.logToSd(stringBuilder2.toString());
                    }
                    XmPlayerControl.this.mState = 7;
                    if (XmPlayerControl.this.mPlayerStatusListener != null) {
                        XmPlayerControl.this.mPlayerStatusListener.onError(new XmPlayerException(i, i2));
                    }
                    return true;
                }
            };
        }
        if (this.mOnInfoListener == null) {
            this.mOnInfoListener = new OnInfoListener() {
                public boolean onInfo(XMediaplayerImpl xMediaplayerImpl, int i, int i2) {
                    boolean z = true;
                    if (i == XMediaPlayer.MEDIA_INFO_BUFFERING_START) {
                        XmPlayerControl.this.mBuffering = true;
                    } else if (i == XMediaPlayer.MEDIA_INFO_BUFFERING_END) {
                        XmPlayerControl.this.mBuffering = false;
                    } else {
                        z = false;
                    }
                    if (XmPlayerControl.this.mPlayerStatusListener != null) {
                        if (XmPlayerControl.this.mBuffering) {
                            XmPlayerControl.this.mPlayerStatusListener.onBufferingStart();
                        } else {
                            XmPlayerControl.this.mPlayerStatusListener.onBufferingStop();
                        }
                    }
                    return z;
                }
            };
        }
        if (this.mOnBufferingUpdateListener == null) {
            this.mOnBufferingUpdateListener = new OnBufferingUpdateListener() {
                public void onBufferingUpdate(XMediaplayerImpl xMediaplayerImpl, int i) {
                    if (XmPlayerControl.this.mPlayerStatusListener != null) {
                        XmPlayerControl.this.mPlayerStatusListener.onBufferProgress(i);
                    }
                }
            };
        }
        if (this.mOnPositionChangeListener == null) {
            this.mOnPositionChangeListener = new OnPositionChangeListener() {
                public void onPositionChange(XMediaplayerImpl xMediaplayerImpl, int i) {
                    if (xMediaplayerImpl.getAudioType().equals(AudioType.HLS_FILE)) {
                        long currentTimeMillis = System.currentTimeMillis() - XmPlayerControl.mLastPostion;
                        if (currentTimeMillis > 0) {
                            XmPlayerControl.mPlayedDuration += currentTimeMillis;
                            XmPlayerControl.mLastPostion = System.currentTimeMillis();
                        }
                        XmPlayerControl.this.mPlayerStatusListener.onPlayProgress(0, 0);
                        return;
                    }
                    int duration = xMediaplayerImpl.getDuration();
                    if (duration > 0 && XmPlayerControl.this.mPlayerStatusListener != null) {
                        int i2 = i - ((int) XmPlayerControl.mLastPostion);
                        if (i2 > 0 && i2 <= 2000) {
                            XmPlayerControl.mPlayedDuration = (XmPlayerControl.mPlayedDuration + ((long) i)) - ((long) ((int) XmPlayerControl.mLastPostion));
                        }
                        XmPlayerControl.mLastPostion = (long) i;
                        XmPlayerControl.this.mPlayerStatusListener.onPlayProgress(i, duration);
                    }
                }
            };
        }
    }

    private void initPlayerDataSource() {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = setupPlayer();
        } else {
            this.mMediaPlayer.reset();
            registListener();
        }
        this.mMediaPlayer.setDataSource(this.mLastUrl);
        this.mState = 1;
        this.mMediaPlayer.prepareAsync();
        this.mState = 9;
        if (this.mPlayerStatusListener != null) {
            this.mPlayerStatusListener.onBufferingStart();
        }
        this.mDuration = 0;
        if (XmPlayerService.getPlayerSrvice() != null && XmPlayerService.getPlayerSrvice().mListControl != null) {
            this.mRealPlayableModel = XmPlayerService.getPlayerSrvice().mListControl.getCurrentPlayableModel();
        }
    }

    private void registListener() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener);
            this.mMediaPlayer.setOnCompletionListener(this.mOnCompletionListener);
            this.mMediaPlayer.setOnPreparedListener(this.mOnPreparedListener);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
            this.mMediaPlayer.setOnErrorListener(this.mOnErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mOnInfoListener);
            this.mMediaPlayer.setOnPositionChangeListener(this.mOnPositionChangeListener);
            this.mMediaPlayer.setOnPlayDataOutputListener(this.mOnPlayDataOutputListener);
        }
    }

    private void releaseLastPlayer() {
        Exception e;
        if (this.mMediaPlayer != null) {
            try {
                unregistListener();
                this.mMediaPlayer.stop();
                try {
                    this.mMediaPlayer.release();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
                try {
                    this.mMediaPlayer.release();
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Throwable th) {
                try {
                    this.mMediaPlayer.release();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                this.mMediaPlayer = null;
                throw th;
            }
            this.mMediaPlayer = null;
        }
        return;
        e.printStackTrace();
        this.mMediaPlayer = null;
    }

    private void setNextTrackPreBufferUrl() {
        if (XmPlayerService.getPlayerSrvice() != null && XmPlayerService.getPlayerSrvice().mListControl != null) {
            Track nextPlayTrack = XmPlayerService.getPlayerSrvice().mListControl.getNextPlayTrack();
            if (nextPlayTrack != null && TextUtils.isEmpty(XmPlayerService.getPlayerSrvice().getDownloadUrl(nextPlayTrack))) {
                if (!nextPlayTrack.isPaid()) {
                    this.mMediaPlayer.setPreBufferUrl(XmPlayerService.getPlayerSrvice().getTrackUrl(nextPlayTrack));
                } else if (this.mHasPreBufferRequestBack) {
                    this.mHasPreBufferRequestBack = false;
                    CommonRequest.updateTrackForPlay(new HashMap(), new IDataCallBack<String>() {
                        public void onError(int i, String str) {
                            XmPlayerControl.this.mHasPreBufferRequestBack = true;
                        }

                        public void onSuccess(String str) {
                            XmPlayerControl.this.mHasPreBufferRequestBack = true;
                            XmPlayerControl.this.mMediaPlayer.setPreBufferUrl(str);
                        }
                    }, nextPlayTrack);
                }
            }
        }
    }

    private XMediaplayerImpl setupPlayer() {
        this.mMediaPlayer = XmMediaPlayerFactory.getMediaPlayer(this.mAppCtx);
        initMediaPlayerListener();
        registListener();
        this.mMediaPlayer.setProxy(FreeFlowServiceUtil.toHttpConfig(this.mConfig));
        this.mMediaPlayer.setSoundTouchAllParams(this.mTempo, this.mPitch, this.mRate);
        return this.mMediaPlayer;
    }

    private void unregistListener() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnBufferingUpdateListener(null);
            this.mMediaPlayer.setOnCompletionListener(null);
            this.mMediaPlayer.setOnPreparedListener(null);
            this.mMediaPlayer.setOnSeekCompleteListener(null);
            this.mMediaPlayer.setOnErrorListener(null);
            this.mMediaPlayer.setOnInfoListener(null);
            this.mMediaPlayer.setOnPositionChangeListener(null);
            this.mMediaPlayer.setOnPlayDataOutputListener(null);
        }
    }

    public String getCurPlayUrl() {
        return this.mLastUrl;
    }

    public int getCurrentPos() {
        switch (this.mState) {
            case 3:
            case 4:
            case 5:
            case 6:
                return this.mMediaPlayer.getCurrentPosition();
            default:
                return 0;
        }
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getPlayerState() {
        return this.mState;
    }

    public PlayableModel getRealPlayableModelInPlayer() {
        return this.mRealPlayableModel;
    }

    public float getTempo() {
        return this.mTempo;
    }

    public boolean init(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayerControl init 17:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        this.isAudioTrackChangeState = false;
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            this.mLastUrl = null;
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.reset();
                this.mState = 0;
                this.mDuration = 0;
            }
            return false;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("PlayerControl init 18:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        this.mOffset = i;
        if (!TextUtils.isEmpty(this.mLastUrl) && str.equals(this.mLastUrl)) {
            switch (this.mState) {
                case 0:
                case 4:
                case 7:
                case 8:
                    initPlayerDataSource();
                    break;
                case 1:
                    this.mMediaPlayer.prepareAsync();
                    this.mState = 9;
                    break;
                case 5:
                    play();
                    break;
            }
        }
        this.mLastUrl = str;
        initPlayerDataSource();
        return true;
    }

    public boolean initAndNotAutoPlay(String str, int i) {
        this.mShoudPlay = false;
        return init(str, i);
    }

    public boolean initAndPlay(String str, int i) {
        this.mShoudPlay = true;
        return init(str, i);
    }

    public boolean isBuffering() {
        return this.mBuffering;
    }

    public boolean isDLNAState() {
        return this.isDLNAState;
    }

    public boolean isOnlineSource() {
        return !TextUtils.isEmpty(this.mLastUrl) && this.mLastUrl.contains("http://");
    }

    public boolean isPlaying() {
        return this.mMediaPlayer == null ? false : this.mMediaPlayer.isPlaying();
    }

    public boolean isPlayingRadio() {
        return this.mMediaPlayer != null && AudioType.HLS_FILE.equals(this.mMediaPlayer.getAudioType());
    }

    public boolean pause() {
        return pause(true);
    }

    public boolean pause(boolean z) {
        if (this.mState != 3) {
            return false;
        }
        this.mMediaPlayer.pause();
        this.mState = 5;
        if (this.mPlayerStatusListener != null) {
            if (z) {
                this.mPlayerStatusListener.onPlayPause();
            }
            if (!this.mMediaPlayer.isPlaying()) {
                this.mPlayerStatusListener.onBufferingStop();
            }
        }
        return true;
    }

    public boolean play() {
        return play(false);
    }

    public boolean play(boolean z) {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice == null || this.mMediaPlayer == null) {
            return false;
        }
        if (z) {
            playerSrvice.setLossAudioFocus(false);
        }
        int i = this.mState;
        boolean z2 = true;
        if (i != 9) {
            switch (i) {
                case 1:
                    this.mMediaPlayer.prepareAsync();
                    this.mState = 9;
                    break;
                case 2:
                case 5:
                case 6:
                    if (!playerSrvice.isLossAudioFocus()) {
                        playerSrvice.requestAudioFocusControl();
                        if (!this.isDLNAState) {
                            this.mMediaPlayer.start();
                        }
                        if (this.mOffset > 0) {
                            this.mMediaPlayer.seekTo(this.mOffset);
                            this.mOffset = 0;
                        }
                        this.mState = 3;
                        if (this.mPlayerStatusListener != null) {
                            this.mPlayerStatusListener.onPlayStart();
                            break;
                        }
                    }
                    playerSrvice.setLossAudioFocus(false);
                    return true;
                    break;
                case 3:
                    break;
                case 4:
                    this.mMediaPlayer.prepareAsync();
                    this.mState = 9;
                    if (this.mPlayerStatusListener != null) {
                        this.mPlayerStatusListener.onPlayStart();
                        break;
                    }
                    break;
                default:
                    z2 = false;
                    break;
            }
        }
        return z2;
    }

    public void release() {
        this.mState = 8;
        releaseLastPlayer();
        this.mTempo = 1.0f;
        this.mPitch = CropImageView.DEFAULT_ASPECT_RATIO;
        this.mRate = 1.0f;
    }

    public void resetMediaPlayer() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mState = 1;
            this.mLastUrl = null;
        }
    }

    public boolean seekTo(int i) {
        Track track = (Track) this.mRealPlayableModel;
        if (!track.isAudition() || i < track.getSampleDuration() * 1000) {
            this.mSeekToPosition = i;
            this.isSeek = true;
            switch (this.mState) {
                case 0:
                    if (this.isAudioTrackChangeState) {
                        this.isAudioTrackChangeState = false;
                        int playState = this.mMediaPlayer.getPlayState();
                        if (playState == 3 || playState == 7 || playState == 4 || playState == 5 || playState == 11) {
                            this.mState = 6;
                            play();
                            this.mMediaPlayer.seekTo(i);
                        }
                        return true;
                    }
                    break;
                case 2:
                case 3:
                case 5:
                    this.mMediaPlayer.seekTo(i);
                    return true;
                case 6:
                    this.mMediaPlayer.start();
                    if (this.mPlayerStatusListener != null) {
                        this.mPlayerStatusListener.onPlayStart();
                    }
                    this.mMediaPlayer.seekTo(i);
                    return true;
                case 9:
                    break;
                default:
                    return false;
            }
            this.mOffset = i;
            return true;
        }
        pause();
        this.mOnPositionChangeListener.onPositionChange(this.mMediaPlayer, track.getSampleDuration() * 1000);
        this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
        return false;
    }

    public void setDLNAState(boolean z) {
        this.isDLNAState = z;
    }

    public void setOnPlayDataOutputListener(OnPlayDataOutputListener onPlayDataOutputListener) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnPlayDataOutputListener(onPlayDataOutputListener);
        }
        this.mOnPlayDataOutputListener = onPlayDataOutputListener;
    }

    public void setPlaySeekListener(IPlaySeekListener iPlaySeekListener) {
        this.mPlaySeekListener = iPlaySeekListener;
    }

    public void setPlayerStatusListener(IXmPlayerStatusListener iXmPlayerStatusListener) {
        this.mPlayerStatusListener = iXmPlayerStatusListener;
    }

    public void setProxy(Config config) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setProxy ");
        stringBuilder.append(config);
        Logger.d(str, stringBuilder.toString());
        this.mConfig = config;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setProxy(FreeFlowServiceUtil.toHttpConfig(config));
        }
    }

    public void setShouldPlay(boolean z) {
        this.mShoudPlay = z;
    }

    public void setSoundTouchAllParams(float f, float f2, float f3) {
        this.mTempo = f;
        this.mPitch = f2;
        this.mRate = f3;
        if (this.mMediaPlayer != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setSoundTouchAllParams2 tempo:");
            stringBuilder.append(f);
            stringBuilder.append(" pitch:");
            stringBuilder.append(f2);
            stringBuilder.append(" rate:");
            stringBuilder.append(f3);
            Logger.log(stringBuilder.toString());
            this.mMediaPlayer.setSoundTouchAllParams(f, f2, f3);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f2);
        }
    }

    public boolean stop() {
        switch (this.mState) {
            case 1:
            case 9:
                return true;
            case 2:
            case 3:
            case 5:
            case 6:
                this.mMediaPlayer.stop();
                this.mState = 4;
                if (this.mPlayerStatusListener == null) {
                    return true;
                }
                this.mPlayerStatusListener.onPlayStop();
                return true;
            default:
                return false;
        }
    }

    public void updateCurPlayUrl(String str) {
        this.mLastUrl = str;
    }
}
