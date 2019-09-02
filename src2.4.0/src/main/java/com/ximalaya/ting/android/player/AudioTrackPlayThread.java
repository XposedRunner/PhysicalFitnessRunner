package com.ximalaya.ting.android.player;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.os.Build.VERSION;
import com.umeng.commonsdk.proguard.c;
import com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType;
import com.ximalaya.ting.android.player.soundtouch.SoundTouch;
import com.ximalaya.ting.android.player.soundtouch.SoundTouchDataModel;
import com.yalantis.ucrop.view.CropImageView;

public class AudioTrackPlayThread extends Thread {
    public static final int AUDIO_CHANNEL = 12;
    public static final int AUDIO_CHANNEL_NUM = 2;
    public static final int AUDIO_FORMAT = 2;
    public static final int BUFFER_TIME = 1;
    public static final int BYTES_PER_SAMPLE = 2;
    public static final int DEFAULT_MIN_BUFFER_MULTIPLICATION_FACTOR = 4;
    private static int DEF_MAX_BUFF_SIZE = 16384;
    private static int DEF_MIN_BUFF_SIZE = 8192;
    private static int NO_MORE_DECODE_DATA = -2;
    public static final int PLAYBACK_STREAM = 3;
    public static final int SAMPLE_RATE = 44100;
    public static final int WRITE_NON_BLOCKING = 1;
    private volatile boolean isPlaying = false;
    private volatile boolean isRelaseFlag = false;
    private boolean isRunning = false;
    private volatile boolean isWaiting = false;
    private long lastUpdateTime = 0;
    private volatile AudioTrack mAudioTrack;
    private byte[] mAudiodata;
    private int mBufferSize;
    private SoundTouch mSoundTouch = null;
    private float mVolume;
    private XMediaplayerJNI mXMediaplayerJNI;
    private boolean shallHandleInSoundTouch = false;
    private Object syncObject = new Object();
    private byte[] tempBuf;
    private int trackId = 0;

    public AudioTrackPlayThread(XMediaplayerJNI xMediaplayerJNI) {
        super("AudioTrackPlayThreadForPlayer");
        this.mXMediaplayerJNI = xMediaplayerJNI;
        initAudioTrack();
    }

    private synchronized void audioTrackRelease() {
        this.isPlaying = false;
        this.isRelaseFlag = true;
        Logger.log(XMediaplayerJNI.Tag, "AudioTrackPlayThread audioTrackRelease");
        if (this.mAudioTrack != null) {
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
        this.mSoundTouch = null;
    }

    /* JADX WARNING: Missing block: B:17:0x006a, code skipped:
            return;
     */
    private synchronized void audioTrackStart() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.mAudioTrack;	 Catch:{ all -> 0x006b }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);
        return;
    L_0x0007:
        r0 = r3.mAudioTrack;	 Catch:{ all -> 0x006b }
        r0 = r0.getState();	 Catch:{ all -> 0x006b }
        r1 = 1;
        if (r0 != r1) goto L_0x002f;
    L_0x0010:
        r0 = r3.mAudioTrack;	 Catch:{ all -> 0x006b }
        r0 = r0.getPlayState();	 Catch:{ all -> 0x006b }
        r2 = 3;
        if (r0 == r2) goto L_0x002f;
    L_0x0019:
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x006b }
        r2 = "AudioTrackPlayThread startPlay3";
        com.ximalaya.ting.android.player.Logger.log(r0, r2);	 Catch:{ all -> 0x006b }
        r0 = r3.mAudioTrack;	 Catch:{ all -> 0x006b }
        r0.play();	 Catch:{ all -> 0x006b }
        r3.isPlaying = r1;	 Catch:{ all -> 0x006b }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x006b }
        r1 = "AudioTrackPlayThread startPlay4";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x006b }
        goto L_0x0069;
    L_0x002f:
        r0 = r3.mAudioTrack;	 Catch:{ all -> 0x006b }
        if (r0 == 0) goto L_0x0051;
    L_0x0033:
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x006b }
        r2 = "AudioTrackPlayThread startPlay5";
        com.ximalaya.ting.android.player.Logger.log(r0, r2);	 Catch:{ all -> 0x006b }
        r0 = r3.mAudioTrack;	 Catch:{ all -> 0x006b }
        r0.release();	 Catch:{ all -> 0x006b }
        r3.initAudioTrack();	 Catch:{ all -> 0x006b }
        r0 = r3.mAudioTrack;	 Catch:{ all -> 0x006b }
        r0.play();	 Catch:{ all -> 0x006b }
        r3.isPlaying = r1;	 Catch:{ all -> 0x006b }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x006b }
        r1 = "AudioTrackPlayThread startPlay6";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x006b }
        goto L_0x0069;
    L_0x0051:
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x006b }
        r2 = "AudioTrackPlayThread startPlay7";
        com.ximalaya.ting.android.player.Logger.log(r0, r2);	 Catch:{ all -> 0x006b }
        r3.initAudioTrack();	 Catch:{ all -> 0x006b }
        r0 = r3.mAudioTrack;	 Catch:{ all -> 0x006b }
        r0.play();	 Catch:{ all -> 0x006b }
        r3.isPlaying = r1;	 Catch:{ all -> 0x006b }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x006b }
        r1 = "AudioTrackPlayThread startPlay8";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x006b }
    L_0x0069:
        monitor-exit(r3);
        return;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.AudioTrackPlayThread.audioTrackStart():void");
    }

    private int audioTrackWrite(byte[] bArr, int i) {
        boolean z = true;
        if (this.mXMediaplayerJNI.getAudioTrackPlayThread() != this) {
            this.isRelaseFlag = true;
            return 0;
        }
        int i2;
        int i3;
        String str = XMediaplayerJNI.Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioTrackPlayThread audioTrackWrite:");
        stringBuilder.append(i);
        Logger.log(str, stringBuilder.toString());
        if (this.mSoundTouch != null && this.shallHandleInSoundTouch && this.mXMediaplayerJNI.getAudioType().equals(AudioType.NORMAL_FILE)) {
            SoundTouchDataModel soundTouchDataModel = new SoundTouchDataModel(bArr, i);
            i = this.mSoundTouch.processBytes(soundTouchDataModel);
            bArr = soundTouchDataModel.outputDataBuf;
            if (i == 0 || bArr == null || bArr.length == 0) {
                return 0;
            }
        }
        z = false;
        if (this.mAudioTrack == null || this.mAudioTrack.getPlayState() != 3) {
            i2 = 0;
            i3 = i2;
        } else {
            i2 = 0;
            i3 = i2;
            while (i > 0 && this.isPlaying && bArr != null) {
                if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
                    int write = this.mAudioTrack.write(bArr, i2, i);
                    if (write <= 0) {
                        break;
                    }
                    i3 += write;
                    i2 += write;
                    i -= write;
                }
            }
        }
        if (i > 0 && !z) {
            this.tempBuf = new byte[i];
            System.arraycopy(bArr, i2, this.tempBuf, 0, i);
        }
        if (i3 > 0 && this.mXMediaplayerJNI.mOnPlayDataOutputListener != null) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            this.mXMediaplayerJNI.mOnPlayDataOutputListener.onPlayDataOutput(bArr2);
        }
        return i3;
    }

    private void flushAllDataInSoundTouch() {
        if (this.mSoundTouch != null && this.shallHandleInSoundTouch && this.mXMediaplayerJNI.getAudioType().equals(AudioType.NORMAL_FILE)) {
            Logger.log("flushAllDataInSoundTouch 0");
            SoundTouchDataModel soundTouchDataModel = new SoundTouchDataModel();
            int processBytes = this.mSoundTouch.processBytes(soundTouchDataModel);
            byte[] bArr = soundTouchDataModel.outputDataBuf;
            if (processBytes == 0 || bArr == null || bArr.length == 0) {
                Logger.log("flushAllDataInSoundTouch 1");
                return;
            }
            int i = 0;
            if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
                while (processBytes > 0 && this.isPlaying && bArr != null) {
                    if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
                        int write = this.mAudioTrack.write(bArr, i, processBytes);
                        if (write <= 0) {
                            break;
                        }
                        i += write;
                        processBytes -= write;
                    }
                }
            }
            Logger.log("flushAllDataInSoundTouch 2");
        }
    }

    private void initAudioTrack() {
        Logger.log(XMediaplayerJNI.Tag, "initAudioTrack");
        int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
        this.mBufferSize = 4 * minBufferSize;
        if (minBufferSize < DEF_MIN_BUFF_SIZE) {
            this.mBufferSize = DEF_MIN_BUFF_SIZE;
        } else if (minBufferSize > DEF_MAX_BUFF_SIZE) {
            this.mBufferSize = DEF_MAX_BUFF_SIZE;
        } else {
            this.mBufferSize = minBufferSize;
        }
        this.mAudioTrack = new AudioTrack(3, 44100, 12, 2, this.mBufferSize, 1);
        this.mAudiodata = new byte[this.mBufferSize];
    }

    @TargetApi(21)
    private static void setVolumeV21(AudioTrack audioTrack, float f) {
        if (audioTrack != null) {
            audioTrack.setVolume(f * AudioTrack.getMaxVolume());
        }
    }

    private static void setVolumeV3(AudioTrack audioTrack, float f) {
        if (audioTrack != null) {
            audioTrack.setStereoVolume(AudioTrack.getMaxVolume() * f, f * AudioTrack.getMaxVolume());
        }
    }

    public void dataReady() {
        Logger.log(XMediaplayerJNI.Tag, "AudioTrackPlayThread dataReady");
        if (this.isWaiting) {
            synchronized (this.syncObject) {
                Logger.log(XMediaplayerJNI.Tag, "AudioTrackPlayThread notify");
                this.syncObject.notify();
                this.isWaiting = false;
            }
        }
    }

    public void flushPlayData() {
        synchronized (this.syncObject) {
            this.tempBuf = null;
            if (!(this.mAudioTrack == null || this.isRelaseFlag)) {
                this.mAudioTrack.flush();
            }
        }
    }

    public void flushPlayDataAndPause() {
        pausePlay();
        flushPlayData();
    }

    public int getMinOutputBufferSize() {
        return this.mBufferSize;
    }

    public float getVolume() {
        return this.mVolume;
    }

    public boolean isPlaying() {
        return this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3;
    }

    public boolean isRelase() {
        return this.isRelaseFlag;
    }

    /* JADX WARNING: Missing block: B:12:0x0027, code skipped:
            return;
     */
    public synchronized void pausePlay() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x0028 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);
        return;
    L_0x0007:
        r0 = 0;
        r2.isPlaying = r0;	 Catch:{ all -> 0x0028 }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x0028 }
        r1 = "AudioTrackPlayThread pausePlay0";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x0028 }
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x0028 }
        r0 = r0.getPlayState();	 Catch:{ all -> 0x0028 }
        r1 = 3;
        if (r0 != r1) goto L_0x0026;
    L_0x001a:
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x0028 }
        r0.pause();	 Catch:{ all -> 0x0028 }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x0028 }
        r1 = "AudioTrackPlayThread pausePlay1";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x0028 }
    L_0x0026:
        monitor-exit(r2);
        return;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.AudioTrackPlayThread.pausePlay():void");
    }

    public synchronized void releasePlay() {
        this.isPlaying = false;
        this.isRelaseFlag = true;
        Logger.log(XMediaplayerJNI.Tag, "AudioTrackPlayThread releasePlay");
        interrupt();
        if (!this.isRunning) {
            audioTrackRelease();
        }
    }

    public void run() {
        this.isRunning = true;
        while (!this.isRelaseFlag) {
            try {
                synchronized (this.syncObject) {
                    if (!this.isRelaseFlag) {
                        int length;
                        String str;
                        if (this.tempBuf != null) {
                            System.arraycopy(this.tempBuf, 0, this.mAudiodata, 0, this.tempBuf.length);
                            length = this.tempBuf.length;
                            this.tempBuf = null;
                        } else {
                            length = this.mXMediaplayerJNI.getOutputData(this.mAudiodata, this.mAudiodata.length);
                        }
                        String str2 = XMediaplayerJNI.Tag;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("AudioTrackPlayThread result0:");
                        stringBuilder.append(length);
                        Logger.log(str2, stringBuilder.toString());
                        int i = -1;
                        if (length > 0) {
                            while (length < this.mBufferSize && !this.isRelaseFlag) {
                                byte[] bArr = new byte[(this.mBufferSize - length)];
                                if (!this.isRelaseFlag) {
                                    int outputData = this.mXMediaplayerJNI.getOutputData(bArr, bArr.length);
                                    String str3 = XMediaplayerJNI.Tag;
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("AudioTrackPlayThread result1 reLength:");
                                    stringBuilder2.append(outputData);
                                    Logger.log(str3, stringBuilder2.toString());
                                    if (outputData != NO_MORE_DECODE_DATA) {
                                        if (outputData != -1) {
                                            if (outputData > 0) {
                                                System.arraycopy(bArr, 0, this.mAudiodata, length, outputData);
                                                length += outputData;
                                                str = XMediaplayerJNI.Tag;
                                                StringBuilder stringBuilder3 = new StringBuilder();
                                                stringBuilder3.append("AudioTrackPlayThread result2:");
                                                stringBuilder3.append(outputData);
                                                Logger.log(str, stringBuilder3.toString());
                                            } else if (outputData == 0) {
                                                this.isWaiting = true;
                                                Logger.log(XMediaplayerJNI.Tag, "AudioTrackPlayThread mAudioTrack wait0");
                                                this.mXMediaplayerJNI.outputDataAppointment();
                                                if (!this.mXMediaplayerJNI.isBuffing && this.mXMediaplayerJNI.getPlayState() == 4) {
                                                    this.mXMediaplayerJNI.onInfoInner(XMediaPlayer.MEDIA_INFO_BUFFERING_START);
                                                }
                                                this.syncObject.wait(c.d);
                                                this.isWaiting = false;
                                            }
                                        }
                                        length = -1;
                                        break;
                                    }
                                    length = NO_MORE_DECODE_DATA;
                                    break;
                                }
                                break;
                            }
                        }
                        if (!this.isRelaseFlag) {
                            str = XMediaplayerJNI.Tag;
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("AudioTrackPlayThread result3:");
                            stringBuilder4.append(length);
                            Logger.log(str, stringBuilder4.toString());
                            if (length == NO_MORE_DECODE_DATA) {
                                Logger.log(XMediaplayerJNI.Tag, "AudioTrackPlayThread decode over");
                                if (this.mXMediaplayerJNI.isBuffing) {
                                    this.mXMediaplayerJNI.onInfoInner(XMediaPlayer.MEDIA_INFO_BUFFERING_END);
                                }
                                flushAllDataInSoundTouch();
                                this.mAudioTrack.stop();
                                this.mXMediaplayerJNI.onCompletionInner();
                            } else {
                                if (length != -1) {
                                    if (length == 0) {
                                        this.isWaiting = true;
                                        Logger.log(XMediaplayerJNI.Tag, "AudioTrackPlayThread wait");
                                        this.mXMediaplayerJNI.outputDataAppointment();
                                        if (!this.mXMediaplayerJNI.isBuffing && this.mXMediaplayerJNI.getPlayState() == 4) {
                                            this.mXMediaplayerJNI.onInfoInner(XMediaPlayer.MEDIA_INFO_BUFFERING_START);
                                        }
                                        this.syncObject.wait(c.d);
                                        this.isWaiting = false;
                                        i = length;
                                    } else if (length > 0) {
                                        if (this.mXMediaplayerJNI.isBuffing) {
                                            this.mXMediaplayerJNI.onInfoInner(XMediaPlayer.MEDIA_INFO_BUFFERING_END);
                                        }
                                        i = audioTrackWrite(this.mAudiodata, length);
                                        if (System.currentTimeMillis() - this.lastUpdateTime >= 1000) {
                                            this.lastUpdateTime = System.currentTimeMillis();
                                            String str4 = XMediaplayerJNI.Tag;
                                            StringBuilder stringBuilder5 = new StringBuilder();
                                            stringBuilder5.append("AudioTrackPlayThread ttseek3:");
                                            stringBuilder5.append(System.currentTimeMillis());
                                            Logger.log(str4, stringBuilder5.toString());
                                            this.mXMediaplayerJNI.mOnTimedChangeListenerInner();
                                        }
                                    }
                                }
                                if (i < 0) {
                                    this.mXMediaplayerJNI.onErrorInner(8, 1);
                                } else {
                                    while (!this.isPlaying) {
                                        this.isWaiting = true;
                                        this.syncObject.wait(c.d);
                                        this.isWaiting = false;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.isRunning = false;
        stopPlay();
        audioTrackRelease();
    }

    /* JADX WARNING: Missing block: B:18:0x0039, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:20:0x003b, code skipped:
            return;
     */
    public synchronized void setSoundTouchAllParams(float r2, float r3, float r4) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.isRelaseFlag;	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x003a;
    L_0x0005:
        r0 = com.ximalaya.ting.android.player.soundtouch.SoundTouch.ENABLE_SOUND_TOUCH;	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x003a;
    L_0x000a:
        r0 = r1.mSoundTouch;	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x0014;
    L_0x000e:
        r0 = com.ximalaya.ting.android.player.soundtouch.SoundTouch.getInstance();	 Catch:{ all -> 0x003c }
        r1.mSoundTouch = r0;	 Catch:{ all -> 0x003c }
    L_0x0014:
        r0 = 1;
        r1.shallHandleInSoundTouch = r0;	 Catch:{ all -> 0x003c }
        r0 = r1.mSoundTouch;	 Catch:{ all -> 0x003c }
        r0.setTempo(r2);	 Catch:{ all -> 0x003c }
        r0 = r1.mSoundTouch;	 Catch:{ all -> 0x003c }
        r0.setPitchSemiTones(r3);	 Catch:{ all -> 0x003c }
        r0 = r1.mSoundTouch;	 Catch:{ all -> 0x003c }
        r0.setRate(r4);	 Catch:{ all -> 0x003c }
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r2 != 0) goto L_0x0038;
    L_0x002c:
        r2 = 0;
        r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0038;
    L_0x0031:
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 != 0) goto L_0x0038;
    L_0x0035:
        r2 = 0;
        r1.shallHandleInSoundTouch = r2;	 Catch:{ all -> 0x003c }
    L_0x0038:
        monitor-exit(r1);
        return;
    L_0x003a:
        monitor-exit(r1);
        return;
    L_0x003c:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.AudioTrackPlayThread.setSoundTouchAllParams(float, float, float):void");
    }

    public void setTempo(float f) {
        setSoundTouchAllParams(f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public synchronized void setVolume(float f) {
        this.mVolume = f;
        if (!(this.mAudioTrack == null || this.isRelaseFlag)) {
            if (VERSION.SDK_INT >= 21) {
                setVolumeV21(this.mAudioTrack, f);
            } else {
                setVolumeV3(this.mAudioTrack, f);
            }
        }
    }

    /* JADX WARNING: Missing block: B:14:0x003d, code skipped:
            return;
     */
    public synchronized void startPlay() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);
        return;
    L_0x0007:
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x003e }
        r1 = "AudioTrackPlayThread startPlay0";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x003e }
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x003e }
        r0 = r0.getPlayState();	 Catch:{ all -> 0x003e }
        r1 = 3;
        if (r0 == r1) goto L_0x0021;
    L_0x0017:
        r2.audioTrackStart();	 Catch:{ all -> 0x003e }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x003e }
        r1 = "AudioTrackPlayThread startPlay1";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x003e }
    L_0x0021:
        r2.dataReady();	 Catch:{ all -> 0x003e }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x003e }
        r1 = "AudioTrackPlayThread startPlay isRunning0";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x003e }
        r0 = r2.isRunning;	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x003c;
    L_0x002f:
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x003e }
        r1 = "AudioTrackPlayThread startPlay isRunning1";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x003e }
        r0 = 1;
        r2.isRunning = r0;	 Catch:{ all -> 0x003e }
        r2.start();	 Catch:{ all -> 0x003e }
    L_0x003c:
        monitor-exit(r2);
        return;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.AudioTrackPlayThread.startPlay():void");
    }

    /* JADX WARNING: Missing block: B:12:0x002c, code skipped:
            return;
     */
    public synchronized void stopPlay() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x002d }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);
        return;
    L_0x0007:
        r0 = 0;
        r2.isPlaying = r0;	 Catch:{ all -> 0x002d }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x002d }
        r1 = "AudioTrackPlayThread stopPlay0";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x002d }
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x002d }
        r0 = r0.getPlayState();	 Catch:{ all -> 0x002d }
        r1 = 1;
        if (r0 == r1) goto L_0x002b;
    L_0x001a:
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x002d }
        r0.stop();	 Catch:{ all -> 0x002d }
        r0 = r2.mAudioTrack;	 Catch:{ all -> 0x002d }
        r0.flush();	 Catch:{ all -> 0x002d }
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x002d }
        r1 = "AudioTrackPlayThread stopPlay1";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);	 Catch:{ all -> 0x002d }
    L_0x002b:
        monitor-exit(r2);
        return;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.AudioTrackPlayThread.stopPlay():void");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(".");
        stringBuilder.append(hashCode());
        return stringBuilder.toString();
    }
}
