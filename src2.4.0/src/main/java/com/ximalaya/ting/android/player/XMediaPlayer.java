package com.ximalaya.ting.android.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.ximalaya.ting.android.player.model.HttpConfig;
import defpackage.cu;
import java.io.FileDescriptor;
import java.util.Map;

public class XMediaPlayer extends XMediaplayerJNI implements Callback {
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    public static final int MEDIA_ERROR_ARCH_UNSUPPORTED = -1011;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    private static final int MEDIA_INFO = 200;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_DOWNLOAD_RATE_CHANGED = 901;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PAUSED = 7;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_SKIPPED = 9;
    private static final int MEDIA_STARTED = 6;
    private static final int MEDIA_STOPPED = 8;
    private static final int MEDIA_SUBTITLE_DATA = 201;
    private static final int MEDIA_TIMED_CHANGE = 202;
    private static final int MEDIA_TIMED_TEXT = 99;
    private static final int MSG_COMPLETE = 9;
    private static final int MSG_INCREMENTAL_PREPARE = 2;
    private static final int MSG_INIT = 10;
    private static final int MSG_PAUSE = 3;
    private static final int MSG_PREPARE = 1;
    private static final int MSG_RELEASE = 5;
    private static final int MSG_RESET = 7;
    private static final int MSG_SEEK_TO = 6;
    private static final int MSG_SET_DATA_SOURCE = 8;
    private static final int MSG_START = 0;
    private static final int MSG_STOP = 4;
    private long lastBufferingTime = System.currentTimeMillis();
    private Context mContext;
    private EventHandler mEventHandler;
    private Handler mHandler;
    private HandlerThread mInternalPlaybackThread;
    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnInfoListener mOnInfoListener;
    private OnPreparedListener mOnPreparedListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnPositionChangeListener mOnTimedChangeListener;
    private volatile int mPlayState;
    private boolean mStayAwake;
    private WakeLock mWakeLock = null;

    public interface OnCompletionListener {
        void onCompletion(XMediaplayerImpl xMediaplayerImpl);
    }

    public interface OnPreparedListener {
        void onPrepared(XMediaplayerImpl xMediaplayerImpl);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(XMediaplayerImpl xMediaplayerImpl);
    }

    public interface OnErrorListener {
        boolean onError(XMediaplayerImpl xMediaplayerImpl, int i, int i2);
    }

    public interface OnInfoListener {
        boolean onInfo(XMediaplayerImpl xMediaplayerImpl, int i, int i2);
    }

    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(XMediaplayerImpl xMediaplayerImpl, int i);
    }

    public interface OnPositionChangeListener {
        void onPositionChange(XMediaplayerImpl xMediaplayerImpl, int i);
    }

    private class EventHandler extends Handler {
        private XMediaPlayer mMediaPlayer;

        public EventHandler(XMediaPlayer xMediaPlayer, Looper looper) {
            super(looper);
            this.mMediaPlayer = xMediaPlayer;
        }

        /* JADX WARNING: Missing block: B:37:0x0102, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:50:0x0141, code skipped:
            return;
     */
        public void handleMessage(android.os.Message r4) {
            /*
            r3 = this;
            r0 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r0 = r0.mPlayState;
            r1 = 12;
            if (r0 != r1) goto L_0x0018;
        L_0x000a:
            r0 = r4.what;
            r1 = 100;
            if (r0 == r1) goto L_0x0018;
        L_0x0010:
            r4 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
            r0 = "handleMessage11 mPlayState NOT_ARCH_SUPPORT";
            com.ximalaya.ting.android.player.Logger.log(r4, r0);
            return;
        L_0x0018:
            r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "handleMessage11 mPlayState:";
            r1.append(r2);
            r2 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r2 = r2.mPlayState;
            r1.append(r2);
            r1 = r1.toString();
            com.ximalaya.ting.android.player.Logger.log(r0, r1);
            r0 = r4.what;
            switch(r0) {
                case 0: goto L_0x0141;
                case 1: goto L_0x012d;
                case 2: goto L_0x0119;
                case 3: goto L_0x0103;
                case 4: goto L_0x00ef;
                default: goto L_0x0039;
            };
        L_0x0039:
            switch(r0) {
                case 6: goto L_0x0141;
                case 7: goto L_0x0141;
                case 8: goto L_0x0141;
                case 9: goto L_0x0102;
                default: goto L_0x003c;
            };
        L_0x003c:
            switch(r0) {
                case 99: goto L_0x00ee;
                case 100: goto L_0x0098;
                default: goto L_0x003f;
            };
        L_0x003f:
            switch(r0) {
                case 200: goto L_0x0080;
                case 201: goto L_0x007f;
                case 202: goto L_0x005b;
                default: goto L_0x0042;
            };
        L_0x0042:
            r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Unknown message type ";
            r1.append(r2);
            r4 = r4.what;
            r1.append(r4);
            r4 = r1.toString();
            com.ximalaya.ting.android.player.Logger.log(r0, r4);
            return;
        L_0x005b:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnTimedChangeListener;
            if (r4 == 0) goto L_0x007e;
        L_0x0063:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.isSeeking();
            if (r4 == 0) goto L_0x006c;
        L_0x006b:
            goto L_0x007e;
        L_0x006c:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnTimedChangeListener;
            r0 = r3.mMediaPlayer;
            r1 = r3.mMediaPlayer;
            r1 = r1.getCurrentPosition();
            r4.onPositionChange(r0, r1);
            return;
        L_0x007e:
            return;
        L_0x007f:
            return;
        L_0x0080:
            r0 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r0 = r0.mOnInfoListener;
            if (r0 == 0) goto L_0x0097;
        L_0x0088:
            r0 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r0 = r0.mOnInfoListener;
            r1 = r3.mMediaPlayer;
            r2 = r4.arg1;
            r4 = r4.arg2;
            r0.onInfo(r1, r2, r4);
        L_0x0097:
            return;
        L_0x0098:
            r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Error (";
            r1.append(r2);
            r2 = r4.arg1;
            r1.append(r2);
            r2 = ",";
            r1.append(r2);
            r2 = r4.arg2;
            r1.append(r2);
            r2 = ")";
            r1.append(r2);
            r1 = r1.toString();
            com.ximalaya.ting.android.player.Logger.log(r0, r1);
            r0 = 0;
            r1 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r1 = r1.mOnErrorListener;
            if (r1 == 0) goto L_0x00d8;
        L_0x00c8:
            r0 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r0 = r0.mOnErrorListener;
            r1 = r3.mMediaPlayer;
            r2 = r4.arg1;
            r4 = r4.arg2;
            r0 = r0.onError(r1, r2, r4);
        L_0x00d8:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnCompletionListener;
            if (r4 == 0) goto L_0x00ed;
        L_0x00e0:
            if (r0 != 0) goto L_0x00ed;
        L_0x00e2:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnCompletionListener;
            r0 = r3.mMediaPlayer;
            r4.onCompletion(r0);
        L_0x00ed:
            return;
        L_0x00ee:
            return;
        L_0x00ef:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnSeekCompleteListener;
            if (r4 == 0) goto L_0x0102;
        L_0x00f7:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnSeekCompleteListener;
            r0 = r3.mMediaPlayer;
            r4.onSeekComplete(r0);
        L_0x0102:
            return;
        L_0x0103:
            r0 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r0 = r0.mOnBufferingUpdateListener;
            if (r0 == 0) goto L_0x0118;
        L_0x010b:
            r0 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r0 = r0.mOnBufferingUpdateListener;
            r1 = r3.mMediaPlayer;
            r4 = r4.arg1;
            r0.onBufferingUpdate(r1, r4);
        L_0x0118:
            return;
        L_0x0119:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnCompletionListener;
            if (r4 == 0) goto L_0x012c;
        L_0x0121:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnCompletionListener;
            r0 = r3.mMediaPlayer;
            r4.onCompletion(r0);
        L_0x012c:
            return;
        L_0x012d:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnPreparedListener;
            if (r4 == 0) goto L_0x0140;
        L_0x0135:
            r4 = com.ximalaya.ting.android.player.XMediaPlayer.this;
            r4 = r4.mOnPreparedListener;
            r0 = r3.mMediaPlayer;
            r4.onPrepared(r0);
        L_0x0140:
            return;
        L_0x0141:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.XMediaPlayer$EventHandler.handleMessage(android.os.Message):void");
        }
    }

    public interface OnPlayDataOutputListener {
        void onPlayDataOutput(byte[] bArr);
    }

    public XMediaPlayer(Context context, boolean z) {
        super(context, z);
        this.mContext = context.getApplicationContext();
        init();
    }

    private void init() {
        this.mPlayState = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(":HandlerForPlayer");
        this.mInternalPlaybackThread = new PriorityHandlerThread(stringBuilder.toString(), -16);
        this.mInternalPlaybackThread.start();
        this.mHandler = new Handler(this.mInternalPlaybackThread.getLooper(), this);
        this.mHandler.obtainMessage(10).sendToTarget();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.mEventHandler = new EventHandler(this, myLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        Logger.log("Mediaplayer XMediaPlayer init()");
    }

    private void stayAwake(boolean z) {
        if (this.mWakeLock != null) {
            if (z && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
    }

    public int getCurrentPosition() {
        return this.mPlayState == 12 ? 0 : super.getCurrentPosition();
    }

    public int getDuration() {
        return this.mPlayState == 12 ? 0 : super.getDuration();
    }

    public int getPlayState() {
        return this.mPlayState;
    }

    public boolean handleMessage(Message message) {
        if (this.mPlayState == 12) {
            Logger.log(XMediaplayerJNI.Tag, "handleMessage00 mPlayState NOT_ARCH_SUPPORT");
            return true;
        }
        String str = XMediaplayerJNI.Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handleMessage00 mPlayState:");
        stringBuilder.append(this.mPlayState);
        Logger.log(str, stringBuilder.toString());
        try {
            switch (message.what) {
                case 0:
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 STARTED start");
                    this.mPlayState = 4;
                    super.start();
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 STARTED end");
                    return true;
                case 1:
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_PREPARE start");
                    this.mPlayState = 2;
                    super.prepareAsync();
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_PREPARE end");
                    return true;
                case 3:
                    if (this.mPlayState != 8) {
                        Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_PAUSE start");
                        this.mPlayState = 5;
                        super.pause();
                        Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_PAUSE end");
                    }
                    return true;
                case 4:
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_STOP start");
                    this.mPlayState = 6;
                    super.stop();
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_STOP end");
                    return true;
                case 5:
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_RELEASE start");
                    this.mPlayState = 9;
                    super.release();
                    this.mInternalPlaybackThread.getLooper().quit();
                    this.mInternalPlaybackThread.interrupt();
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_RELEASE end");
                    return true;
                case 6:
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_SEEK_TO start");
                    super.seekTo(((Integer) message.obj).intValue());
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_SEEK_TO end");
                    return true;
                case 7:
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_RESET start");
                    this.mPlayState = 0;
                    super.reset();
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_RESET end");
                    this.mPlayState = 0;
                    return true;
                case 8:
                    if (message.obj != null) {
                        super.setDataSource(message.obj.toString());
                    }
                    return true;
                case 9:
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_COMPLETE start");
                    this.mPlayState = 11;
                    super.onCompletionInner();
                    Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_COMPLETE end");
                    return true;
                case 10:
                    Logger.log(XMediaplayerJNI.Tag, "Mediaplayer handleMessage00 MSG_INIT start");
                    xmediaplayerInit();
                    Logger.log(XMediaplayerJNI.Tag, "Mediaplayer handleMessage00 MSG_INIT end");
                    return true;
                default:
                    return false;
            }
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean isPlaying() {
        boolean z = false;
        if (this.mPlayState == 12 || this.mPlayState == 3) {
            return false;
        }
        if (super.isPlaying() && this.mPlayState == 4) {
            z = true;
        }
        return z;
    }

    public boolean isUseSystemPlayer() {
        return false;
    }

    public final void mOnTimedChangeListenerInner() {
        if (this.mEventHandler != null) {
            this.mEventHandler.removeMessages(202);
            this.mEventHandler.obtainMessage(202).sendToTarget();
        }
    }

    public final void onBufferingUpdateInner(int i) {
        if (this.mEventHandler != null && System.currentTimeMillis() - this.lastBufferingTime >= 1000) {
            this.lastBufferingTime = System.currentTimeMillis();
            this.mEventHandler.removeMessages(3);
            this.mEventHandler.obtainMessage(3, i, 0).sendToTarget();
        }
    }

    public final void onCompletionInner() {
        stayAwake(false);
        this.mHandler.obtainMessage(9).sendToTarget();
        if (this.mEventHandler != null) {
            this.mEventHandler.obtainMessage(2).sendToTarget();
        }
    }

    public final void onErrorInner(int i, int i2) {
        if (i2 == MEDIA_ERROR_ARCH_UNSUPPORTED) {
            this.mPlayState = 12;
            Logger.log(XMediaplayerJNI.Tag, "onErrorInner mPlayState NOT_ARCH_SUPPORT");
        } else {
            String str = XMediaplayerJNI.Tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onErrorInner errorCode:");
            stringBuilder.append(i);
            stringBuilder.append("extra:");
            stringBuilder.append(i2);
            Logger.log(str, stringBuilder.toString());
            this.mPlayState = 8;
        }
        super.onErrorInner(i, i2);
        stayAwake(false);
        if (this.mEventHandler != null) {
            this.mEventHandler.obtainMessage(100, i, i2).sendToTarget();
        }
    }

    public final void onInfoInner(int i) {
        if (this.mPlayState == 4 || this.mPlayState == 2) {
            if (i == MEDIA_INFO_BUFFERING_START) {
                this.isBuffing = true;
            } else if (i == MEDIA_INFO_BUFFERING_END) {
                this.isBuffing = false;
            }
            if (this.mEventHandler != null) {
                this.mEventHandler.obtainMessage(200, i, i).sendToTarget();
            }
        }
    }

    public final void onPreparedInner() {
        super.onPreparedInner();
        this.mPlayState = 3;
        if (this.mEventHandler != null) {
            this.mEventHandler.obtainMessage(1).sendToTarget();
        }
    }

    public final void onSeekCompletedInner() {
        Logger.log(Tag, "onSeekCompletedInner");
        if (this.mEventHandler != null) {
            this.mEventHandler.obtainMessage(4).sendToTarget();
        }
    }

    public void pause() {
        stayAwake(false);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(0);
        this.mHandler.obtainMessage(3).sendToTarget();
    }

    public void prepareAsync() {
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public void release() {
        stayAwake(false);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnTimedChangeListener = null;
        this.mHandler.obtainMessage(5).sendToTarget();
    }

    public void removeProxy() {
        StaticConfig.setHttpConfig(null);
    }

    public void reset() {
        stayAwake(false);
        Logger.log(XMediaplayerJNI.Tag, "handleMessage00 MSG_RESET start send");
        this.mHandler.removeCallbacksAndMessages(null);
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mHandler.obtainMessage(7).sendToTarget();
    }

    public void seekTo(int i) {
        this.mHandler.removeMessages(6);
        this.mHandler.obtainMessage(6, Integer.valueOf(i)).sendToTarget();
    }

    public void setAudioStreamType(int i) {
    }

    public void setDataSource(FileDescriptor fileDescriptor, String str) {
        setDataSource(str);
    }

    public void setDataSource(String str) {
        this.mHandler.obtainMessage(8, str).sendToTarget();
    }

    public void setDownloadBufferSize(long j) {
        if (j > 0) {
            XMediaPlayerConstants.DOWNLOAD_QUEUE_SIZE = (int) (j / 65536);
        }
    }

    public void setHeadsOfReq(Map<String, String> map) {
        StaticConfig.setHeads(map);
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPositionChangeListener(OnPositionChangeListener onPositionChangeListener) {
        this.mOnTimedChangeListener = onPositionChangeListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setProxy(HttpConfig httpConfig) {
        StaticConfig.setHttpConfig(httpConfig);
    }

    public void setVolume(float f, float f2) {
        super.setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        if (context != null) {
            boolean z;
            if (this.mWakeLock != null) {
                if (this.mWakeLock.isHeld()) {
                    z = true;
                    this.mWakeLock.release();
                } else {
                    z = false;
                }
                this.mWakeLock = null;
            } else {
                z = false;
            }
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(i | cu.O000o000, MediaPlayer.class.getName());
                this.mWakeLock.setReferenceCounted(false);
                if (z) {
                    this.mWakeLock.acquire();
                }
            }
        }
    }

    public void start() {
        stayAwake(true);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(0);
        this.mHandler.obtainMessage(0).sendToTarget();
    }

    public void stop() {
        stayAwake(false);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(6);
        this.mHandler.obtainMessage(4).sendToTarget();
    }
}
