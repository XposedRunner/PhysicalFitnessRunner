package com.qiyukf.nimlib.sdk.media.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qiyukf.basesdk.a.a;
import java.io.File;

public final class AudioPlayer {
    public static final String TAG = "AudioPlayer";
    private static final int WHAT_COUNT_PLAY = 0;
    private static final int WHAT_DECODE_FAILED = 2;
    private static final int WHAT_DECODE_SUCCEED = 1;
    private AudioManager audioManager;
    private int audioStreamType;
    private String mAudioFile;
    private boolean mCanPlay;
    private Handler mHandler;
    private long mIntervalTime;
    private OnPlayListener mListener;
    private MediaPlayer mPlayer;
    OnAudioFocusChangeListener onAudioFocusChangeListener;

    public AudioPlayer(Context context) {
        this(context, null, null);
    }

    public AudioPlayer(Context context, String str, OnPlayListener onPlayListener) {
        this.mIntervalTime = 500;
        this.mCanPlay = false;
        this.audioStreamType = 0;
        this.mHandler = new Handler() {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        if (AudioPlayer.this.mListener != null) {
                            AudioPlayer.this.mListener.onPlaying((long) AudioPlayer.this.mPlayer.getCurrentPosition());
                        }
                        sendEmptyMessageDelayed(0, AudioPlayer.this.mIntervalTime);
                        return;
                    case 1:
                        AudioPlayer.this.startInner();
                        return;
                    case 2:
                        String str = AudioPlayer.TAG;
                        StringBuilder stringBuilder = new StringBuilder("convert() error: ");
                        stringBuilder.append(AudioPlayer.this.mAudioFile);
                        a.c(str, stringBuilder.toString());
                        return;
                    default:
                        return;
                }
            }
        };
        this.onAudioFocusChangeListener = new OnAudioFocusChangeListener() {
            public void onAudioFocusChange(int i) {
                StringBuilder stringBuilder = new StringBuilder("onAudioFocusChange:");
                stringBuilder.append(i);
                a.b("test", stringBuilder.toString());
                if (i != 1) {
                    switch (i) {
                        case -3:
                            if (AudioPlayer.this.isPlaying()) {
                                AudioPlayer.this.mPlayer.setVolume(0.1f, 0.1f);
                                return;
                            }
                            break;
                        case -2:
                            AudioPlayer.this.stop();
                            return;
                        case -1:
                            AudioPlayer.this.stop();
                            return;
                        default:
                            return;
                    }
                } else if (AudioPlayer.this.isPlaying()) {
                    AudioPlayer.this.mPlayer.setVolume(1.0f, 1.0f);
                }
            }
        };
        this.audioManager = (AudioManager) context.getSystemService("audio");
        this.mAudioFile = str;
        this.mListener = onPlayListener;
    }

    private boolean convert() {
        return true;
    }

    private void deleteOnExit() {
        File file = new File(this.mAudioFile);
        if (file.exists()) {
            file.deleteOnExit();
        }
    }

    private void endPlay() {
        this.audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
        if (this.mPlayer != null) {
            this.mPlayer.stop();
            this.mPlayer.release();
            this.mPlayer = null;
            this.mHandler.removeMessages(0);
        }
    }

    private boolean needConvert() {
        return false;
    }

    private void startInner() {
        AudioManager audioManager;
        this.mPlayer = new MediaPlayer();
        boolean z = false;
        this.mPlayer.setLooping(false);
        this.mPlayer.setAudioStreamType(this.audioStreamType);
        if (this.audioStreamType == 3) {
            audioManager = this.audioManager;
            z = true;
        } else {
            audioManager = this.audioManager;
        }
        audioManager.setSpeakerphoneOn(z);
        this.audioManager.requestAudioFocus(this.onAudioFocusChangeListener, this.audioStreamType, 2);
        this.mPlayer.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                a.d(AudioPlayer.TAG, "player:onPrepared");
                AudioPlayer.this.mHandler.sendEmptyMessage(0);
                if (AudioPlayer.this.mListener != null) {
                    AudioPlayer.this.mListener.onPrepared();
                }
            }
        });
        this.mPlayer.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.d(AudioPlayer.TAG, "player:onCompletion");
                AudioPlayer.this.endPlay();
                if (AudioPlayer.this.mListener != null) {
                    AudioPlayer.this.mListener.onCompletion();
                }
            }
        });
        this.mPlayer.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                a.c(AudioPlayer.TAG, "player:onOnError");
                AudioPlayer.this.endPlay();
                if (AudioPlayer.this.mListener != null) {
                    AudioPlayer.this.mListener.onError(String.format("OnErrorListener what:%d extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                }
                return true;
            }
        });
        try {
            if (this.mAudioFile != null) {
                this.mPlayer.setDataSource(this.mAudioFile);
                this.mPlayer.prepare();
                this.mPlayer.start();
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("player:start ok---->");
                stringBuilder.append(this.mAudioFile);
                a.d(str, stringBuilder.toString());
                return;
            }
            if (this.mListener != null) {
                this.mListener.onError("no datasource");
            }
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("player:onOnError Exception\n");
            stringBuilder2.append(e.toString());
            a.c(str2, stringBuilder2.toString());
            endPlay();
            if (this.mListener != null) {
                OnPlayListener onPlayListener = this.mListener;
                stringBuilder2 = new StringBuilder("Exception\n");
                stringBuilder2.append(e.toString());
                onPlayListener.onError(stringBuilder2.toString());
            }
        }
    }

    private void startPlay() {
        a.d(TAG, "start() called");
        endPlay();
        if (this.mCanPlay) {
            startInner();
            return;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                if (AudioPlayer.this.mHandler != null) {
                    AudioPlayer.this.mHandler.sendEmptyMessage(AudioPlayer.this.convert() ? 1 : 2);
                }
            }
        });
        thread.setPriority(10);
        thread.start();
    }

    public final long getCurrentPosition() {
        return this.mPlayer != null ? (long) this.mPlayer.getCurrentPosition() : 0;
    }

    public final long getDuration() {
        return this.mPlayer != null ? (long) this.mPlayer.getDuration() : 0;
    }

    public final OnPlayListener getOnPlayListener() {
        return this.mListener;
    }

    public final boolean isPlaying() {
        return this.mPlayer != null && this.mPlayer.isPlaying();
    }

    public final void seekTo(int i) {
        this.mPlayer.seekTo(i);
    }

    public final void setDataSource(String str) {
        if (!TextUtils.equals(str, this.mAudioFile)) {
            this.mAudioFile = str;
            this.mCanPlay = needConvert() ^ 1;
        }
    }

    public final void setOnPlayListener(OnPlayListener onPlayListener) {
        this.mListener = onPlayListener;
    }

    public final void start(int i) {
        this.audioStreamType = i;
        startPlay();
    }

    public final void stop() {
        if (this.mPlayer != null) {
            endPlay();
            if (this.mListener != null) {
                this.mListener.onInterrupt();
            }
        }
    }
}
