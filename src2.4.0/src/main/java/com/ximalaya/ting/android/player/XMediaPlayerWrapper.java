package com.ximalaya.ting.android.player;

import android.content.Context;
import android.text.TextUtils;
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

public class XMediaPlayerWrapper implements XMediaplayerImpl {
    private boolean isRelease;
    private boolean isUseSystemPlayer = false;
    private Context mConext;
    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnInfoListener mOnInfoListener;
    private OnPositionChangeListener mOnPositionChangeListener;
    private OnPreparedListener mOnPreparedListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private String mPlayUrl;
    public XMediaplayerImpl mXMediaplayerImpl;

    public XMediaPlayerWrapper(Context context, boolean z) {
        if (context == null) {
            throw new RuntimeException("context cannot be null!!!!!!");
        }
        this.mConext = context.getApplicationContext();
        XMediaPlayerConstants.resetCacheDir(this.mConext);
        this.isRelease = z;
        init(this.mConext, z);
    }

    public XMediaPlayerWrapper(Context context, boolean z, boolean z2) {
        if (context == null) {
            throw new RuntimeException("context cannot be null!!!!!!");
        }
        this.mConext = context.getApplicationContext();
        XMediaPlayerConstants.resetCacheDir(this.mConext);
        if (z2) {
            this.isUseSystemPlayer = true;
            this.mXMediaplayerImpl = newXMediaplayer(this.mConext, z);
            return;
        }
        init(this.mConext, z);
    }

    private void init(Context context, boolean z) {
        XMediaPlayerConstants.resetCacheDir(context);
        this.isUseSystemPlayer = false;
        String cpuInfo = PlayerUtil.getCpuInfo();
        String property = System.getProperty("os.arch");
        String str;
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(cpuInfo) || TextUtils.isEmpty(property)) {
            str = XMediaplayerJNI.Tag;
            stringBuilder = new StringBuilder();
            stringBuilder.append("cpuinfo null:");
            stringBuilder.append(cpuInfo);
            stringBuilder.append("cpuArch:");
            stringBuilder.append(property);
            Logger.log(str, stringBuilder.toString());
        } else {
            if (cpuInfo.contains("Marvell") && property.contains("armv5tel")) {
                this.isUseSystemPlayer = true;
            }
            str = XMediaplayerJNI.Tag;
            stringBuilder = new StringBuilder();
            stringBuilder.append("cpuinfo:");
            stringBuilder.append(cpuInfo);
            stringBuilder.append("cpuArch:");
            stringBuilder.append(property);
            Logger.log(str, stringBuilder.toString());
        }
        this.mXMediaplayerImpl = newXMediaplayer(context, z);
    }

    private XMediaplayerImpl newXMediaplayer(Context context, boolean z) {
        if (this.isUseSystemPlayer) {
            this.mXMediaplayerImpl = new SMediaPlayer();
        } else {
            Logger.log("jniHandler newXMediaplayer XMediaPlayer");
            this.mXMediaplayerImpl = new XMediaPlayer(context, z);
        }
        return this.mXMediaplayerImpl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0096 A:{SYNTHETIC, Splitter:B:16:0x0096} */
    /* JADX WARNING: Missing block: B:9:0x008a, code skipped:
            if (r3 != null) goto L_0x008c;
     */
    /* JADX WARNING: Missing block: B:11:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:22:0x009b, code skipped:
            if (r3 != null) goto L_0x008c;
     */
    private void reUseSMediaplayer(android.content.Context r3, boolean r4) {
        /*
        r2 = this;
        r0 = 1;
        r2.isUseSystemPlayer = r0;
        r0 = r2.mXMediaplayerImpl;
        r1 = 0;
        r0.setOnBufferingUpdateListener(r1);
        r0 = r2.mXMediaplayerImpl;
        r0.setOnCompletionListener(r1);
        r0 = r2.mXMediaplayerImpl;
        r0.setOnErrorListener(r1);
        r0 = r2.mXMediaplayerImpl;
        r0.setOnInfoListener(r1);
        r0 = r2.mXMediaplayerImpl;
        r0.setOnPreparedListener(r1);
        r0 = r2.mXMediaplayerImpl;
        r0.setOnSeekCompleteListener(r1);
        r0 = r2.mXMediaplayerImpl;
        r0.setOnPositionChangeListener(r1);
        r3 = r2.newXMediaplayer(r3, r4);
        r2.mXMediaplayerImpl = r3;
        r3 = r2.mXMediaplayerImpl;
        r4 = r2.mOnBufferingUpdateListener;
        r3.setOnBufferingUpdateListener(r4);
        r3 = r2.mXMediaplayerImpl;
        r4 = r2.mOnCompletionListener;
        r3.setOnCompletionListener(r4);
        r3 = r2.mXMediaplayerImpl;
        r4 = r2.mOnErrorListener;
        r3.setOnErrorListener(r4);
        r3 = r2.mXMediaplayerImpl;
        r4 = r2.mOnInfoListener;
        r3.setOnInfoListener(r4);
        r3 = r2.mXMediaplayerImpl;
        r4 = r2.mOnPreparedListener;
        r3.setOnPreparedListener(r4);
        r3 = r2.mXMediaplayerImpl;
        r4 = r2.mOnSeekCompleteListener;
        r3.setOnSeekCompleteListener(r4);
        r3 = r2.mXMediaplayerImpl;
        r4 = r2.mOnPositionChangeListener;
        r3.setOnPositionChangeListener(r4);
        r3 = r2.mPlayUrl;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x00a3;
    L_0x0066:
        r3 = r2.mPlayUrl;
        r4 = "http";
        r3 = r3.startsWith(r4);
        if (r3 == 0) goto L_0x0078;
    L_0x0070:
        r3 = r2.mXMediaplayerImpl;
        r4 = r2.mPlayUrl;
        r3.setDataSource(r4);
        goto L_0x009e;
    L_0x0078:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x009a, all -> 0x0092 }
        r4 = r2.mPlayUrl;	 Catch:{ Exception -> 0x009a, all -> 0x0092 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x009a, all -> 0x0092 }
        r4 = r2.mXMediaplayerImpl;	 Catch:{ Exception -> 0x009b, all -> 0x0090 }
        r0 = r3.getFD();	 Catch:{ Exception -> 0x009b, all -> 0x0090 }
        r1 = r2.mPlayUrl;	 Catch:{ Exception -> 0x009b, all -> 0x0090 }
        r4.setDataSource(r0, r1);	 Catch:{ Exception -> 0x009b, all -> 0x0090 }
        if (r3 == 0) goto L_0x009e;
    L_0x008c:
        r3.close();	 Catch:{ IOException -> 0x009e }
        goto L_0x009e;
    L_0x0090:
        r4 = move-exception;
        goto L_0x0094;
    L_0x0092:
        r4 = move-exception;
        r3 = r1;
    L_0x0094:
        if (r3 == 0) goto L_0x0099;
    L_0x0096:
        r3.close();	 Catch:{ IOException -> 0x0099 }
    L_0x0099:
        throw r4;
    L_0x009a:
        r3 = r1;
    L_0x009b:
        if (r3 == 0) goto L_0x009e;
    L_0x009d:
        goto L_0x008c;
    L_0x009e:
        r3 = r2.mXMediaplayerImpl;
        r3.prepareAsync();
    L_0x00a3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.XMediaPlayerWrapper.reUseSMediaplayer(android.content.Context, boolean):void");
    }

    public AudioType getAudioType() {
        return this.mXMediaplayerImpl.getAudioType();
    }

    public int getCurrentPosition() {
        return this.mXMediaplayerImpl.getCurrentPosition();
    }

    public int getDuration() {
        return this.mXMediaplayerImpl.getDuration();
    }

    public int getPlayState() {
        return this.mXMediaplayerImpl.getPlayState();
    }

    public boolean isPlaying() {
        return this.mXMediaplayerImpl.isPlaying();
    }

    public boolean isUseSystemPlayer() {
        return this.isUseSystemPlayer;
    }

    public void pause() {
        this.mXMediaplayerImpl.pause();
    }

    public void prepareAsync() {
        this.mXMediaplayerImpl.prepareAsync();
    }

    public void release() {
        this.mXMediaplayerImpl.release();
    }

    public void removeProxy() {
        StaticConfig.setHttpConfig(null);
    }

    public void reset() {
        this.mXMediaplayerImpl.reset();
    }

    public void seekTo(int i) {
        this.mXMediaplayerImpl.seekTo(i);
    }

    public void setAudioStreamType(int i) {
        this.mXMediaplayerImpl.setAudioStreamType(i);
    }

    public void setDataSource(FileDescriptor fileDescriptor, String str) {
        this.mPlayUrl = str;
        this.mXMediaplayerImpl.setDataSource(fileDescriptor, str);
    }

    public void setDataSource(String str) {
        this.mPlayUrl = str;
        this.mXMediaplayerImpl.setDataSource(str);
    }

    public void setDownloadBufferSize(long j) {
        this.mXMediaplayerImpl.setDownloadBufferSize(j);
    }

    public void setHeadsOfReq(Map<String, String> map) {
        StaticConfig.setHeads(map);
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
        this.mXMediaplayerImpl.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
        this.mXMediaplayerImpl.setOnCompletionListener(this.mOnCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
        this.mXMediaplayerImpl.setOnErrorListener(new OnErrorListener() {
            public boolean onError(XMediaplayerImpl xMediaplayerImpl, int i, int i2) {
                if (i2 != XMediaPlayer.MEDIA_ERROR_ARCH_UNSUPPORTED) {
                    return XMediaPlayerWrapper.this.mOnErrorListener != null ? XMediaPlayerWrapper.this.mOnErrorListener.onError(XMediaPlayerWrapper.this.mXMediaplayerImpl, i, i2) : false;
                } else {
                    XMediaPlayerWrapper.this.reUseSMediaplayer(XMediaPlayerWrapper.this.mConext, XMediaPlayerWrapper.this.isRelease);
                    return true;
                }
            }
        });
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
        this.mXMediaplayerImpl.setOnInfoListener(this.mOnInfoListener);
    }

    public void setOnPlayDataOutputListener(OnPlayDataOutputListener onPlayDataOutputListener) {
        if (this.mXMediaplayerImpl != null) {
            this.mXMediaplayerImpl.setOnPlayDataOutputListener(onPlayDataOutputListener);
        }
    }

    public void setOnPositionChangeListener(OnPositionChangeListener onPositionChangeListener) {
        this.mOnPositionChangeListener = onPositionChangeListener;
        this.mXMediaplayerImpl.setOnPositionChangeListener(this.mOnPositionChangeListener);
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
        this.mXMediaplayerImpl.setOnPreparedListener(this.mOnPreparedListener);
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
        this.mXMediaplayerImpl.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
    }

    public void setPreBufferUrl(String str) {
        if (this.mXMediaplayerImpl != null) {
            this.mXMediaplayerImpl.setPreBufferUrl(str);
        }
    }

    public void setProxy(HttpConfig httpConfig) {
        StaticConfig.setHttpConfig(httpConfig);
    }

    public void setSoundTouchAllParams(float f, float f2, float f3) {
        if (this.mXMediaplayerImpl != null) {
            this.mXMediaplayerImpl.setSoundTouchAllParams(f, f2, f3);
        }
    }

    public void setTempo(float f) {
        if (this.mXMediaplayerImpl != null) {
            this.mXMediaplayerImpl.setTempo(f);
        }
    }

    public void setVolume(float f, float f2) {
        this.mXMediaplayerImpl.setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        this.mXMediaplayerImpl.setWakeMode(context, i);
    }

    public void start() {
        this.mXMediaplayerImpl.start();
    }

    public void stop() {
        this.mXMediaplayerImpl.stop();
    }
}
