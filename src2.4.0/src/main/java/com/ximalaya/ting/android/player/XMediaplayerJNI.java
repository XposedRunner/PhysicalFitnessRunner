package com.ximalaya.ting.android.player;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ximalaya.ting.android.player.XMediaPlayer.OnPlayDataOutputListener;
import com.ximalaya.ting.android.player.liveflv.FlvLiveAudioFile;
import com.ximalaya.ting.android.player.model.JNIDataModel;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.activity.common.BasePayActivity;
import defpackage.bt;
import defpackage.cu;
import java.nio.ByteBuffer;

public abstract class XMediaplayerJNI implements XMediaplayerImpl {
    public static String Tag = "XMPLAY";
    private int chargeDataRealLength = 0;
    private volatile boolean hasRelease = false;
    private boolean isAfterSetDataSourceStart = false;
    public volatile boolean isBuffing = false;
    private boolean isRelease = true;
    private volatile boolean isReseting = false;
    private boolean isSeeking = false;
    private AudioFileRequestHandler mAudioFileRequestHandler;
    private AudioTrackPlayThread mAudioTrackPlayThread;
    private AudioType mAudioType = AudioType.NORMAL_FILE;
    public Context mContext;
    private long mCurFileSize;
    public String mCurrentDataDecodeUrl = this.mPlayUrl;
    private int mCurrentSeekPosition = -1;
    private int mCurrentSeekPositionState = 0;
    private FlvLiveAudioFile mFlvLiveAudioFile;
    private boolean mHasSeek = true;
    private HlsAudioFile mHlsAudioFile;
    private long mJniHandler;
    OnPlayDataOutputListener mOnPlayDataOutputListener;
    private float mPitch = CropImageView.DEFAULT_ASPECT_RATIO;
    public String mPlayUrl;
    private float mRate = 1.0f;
    private float mTempo = 1.0f;
    public byte[] tmepBuf;

    public enum AudioType {
        NORMAL_FILE(0),
        M3U8_STATIC_FILE(1),
        HLS_FILE(2),
        M3U8_FILE(3),
        XMLY_FORMAT(4),
        FLV_FILE(5);
        
        private int value;

        private AudioType(int i) {
            this.value = 0;
            this.value = i;
        }

        public static AudioType valueOf(int i) {
            switch (i) {
                case 0:
                    return NORMAL_FILE;
                case 1:
                    return M3U8_STATIC_FILE;
                case 2:
                    return HLS_FILE;
                case 3:
                    return M3U8_FILE;
                case 4:
                    return XMLY_FORMAT;
                case 5:
                    return FLV_FILE;
                default:
                    return null;
            }
        }

        public int value() {
            return this.value;
        }
    }

    public enum NativeErrorType {
        NO_ERR(0),
        ERR_NOTOK(-1),
        ERR_DECODE_NOT_SUPPORT(-2),
        ERR_M3U8_FILE_CONTENT_INVALID(-3),
        ERR_FILE_MANAGER_INNER_ERR(-4),
        ERR_DECODEDATA_FILLIO_FAIL(-5),
        ERR_M3U8STREAM_FILLIO_FAIL(-6),
        ERR_ARCH_NOT_SUPPORT(-7),
        ERR_LIB_NOT_LOADED(-8),
        ERR_XMLY_DEC_ERR(-9),
        ERR_FLV_DEC_ERR(-10);
        
        private int value;

        private NativeErrorType(int i) {
            this.value = 0;
            this.value = i;
        }

        public static NativeErrorType valueOf(int i) {
            switch (i) {
                case -10:
                    return ERR_FLV_DEC_ERR;
                case -9:
                    return ERR_XMLY_DEC_ERR;
                case -8:
                    return ERR_LIB_NOT_LOADED;
                case -7:
                    return ERR_ARCH_NOT_SUPPORT;
                case -6:
                    return ERR_M3U8STREAM_FILLIO_FAIL;
                case -5:
                    return ERR_DECODEDATA_FILLIO_FAIL;
                case -4:
                    return ERR_FILE_MANAGER_INNER_ERR;
                case -3:
                    return ERR_M3U8_FILE_CONTENT_INVALID;
                case BasePayActivity.O0000oO0 /*-2*/:
                    return ERR_DECODE_NOT_SUPPORT;
                case -1:
                    return ERR_NOTOK;
                case 0:
                    return NO_ERR;
                default:
                    return ERR_NOTOK;
            }
        }

        public int value() {
            return this.value;
        }
    }

    static {
        if (PlayerUtil.isX86Arch()) {
            System.loadLibrary("xmediaplayer_x");
            return;
        }
        boolean isArmV7Plus = PlayerUtil.isArmV7Plus();
        String str = Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loadLibrary xmediaplayer isArmV7Plus:");
        stringBuilder.append(isArmV7Plus);
        Logger.log(str, stringBuilder.toString());
        if (isArmV7Plus) {
            Log.i("loadLibrary", "xmediaplayerv7");
            System.loadLibrary("xmediaplayerv7");
            return;
        }
        Log.i("loadLibrary", "xmediaplayer");
        System.loadLibrary("xmediaplayer");
    }

    public XMediaplayerJNI(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        this.hasRelease = false;
        this.isRelease = z;
        int MediaplayerFrameworkInit = MediaplayerFrameworkInit(context, z);
        String str = Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaplayerFrameworkInit result:");
        stringBuilder.append(MediaplayerFrameworkInit);
        Logger.log(str, stringBuilder.toString());
        if (MediaplayerFrameworkInit < 0) {
            handlePlayerStatus(NativeErrorType.ERR_ARCH_NOT_SUPPORT.value());
        }
    }

    private String getCurPlayUrl() {
        if (this.mAudioType != AudioType.M3U8_STATIC_FILE && this.mAudioType != AudioType.HLS_FILE && this.mAudioType != AudioType.M3U8_FILE) {
            return this.mPlayUrl;
        }
        if (this.mHlsAudioFile != null) {
            return this.mHlsAudioFile.getPlayUrl();
        }
        throw new RuntimeException("getCurPlayUrl 错误！");
    }

    private void handleSmallBufRequest(JNIDataModel jNIDataModel) {
        if (jNIDataModel.buf.length > jNIDataModel.bufSize) {
            ByteBuffer wrap = ByteBuffer.wrap(jNIDataModel.buf);
            wrap.clear();
            wrap.position(jNIDataModel.bufSize).limit(jNIDataModel.buf.length);
            ByteBuffer slice = wrap.slice();
            this.tmepBuf = new byte[slice.remaining()];
            slice.get(this.tmepBuf);
            String str = Tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dataStreamInputFuncCallBackT length diff tJNIDataModel.bufSize:");
            stringBuilder.append(jNIDataModel.bufSize);
            Logger.log(str, stringBuilder.toString());
            str = Tag;
            stringBuilder = new StringBuilder();
            stringBuilder.append("dataStreamInputFuncCallBackT length diff tJNIDataModel.buf:");
            stringBuilder.append(jNIDataModel.buf.length);
            Logger.log(str, stringBuilder.toString());
            if (this.tmepBuf != null) {
                str = Tag;
                stringBuilder = new StringBuilder();
                stringBuilder.append("dataStreamInputFuncCallBackT length diff tmepBuf:");
                stringBuilder.append(this.tmepBuf.length);
                Logger.log(str, stringBuilder.toString());
            }
            wrap.clear();
            wrap.position(0).limit(jNIDataModel.bufSize);
            wrap = wrap.slice();
            jNIDataModel.buf = new byte[wrap.remaining()];
            wrap.get(jNIDataModel.buf);
            String str2 = Tag;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("dataStreamInputFuncCallBackT length diff tJNIDataModel.buf:");
            stringBuilder2.append(jNIDataModel.buf.length);
            Logger.log(str2, stringBuilder2.toString());
            if (this.tmepBuf != null) {
                str2 = Tag;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("dataStreamInputFuncCallBackT length diff all1:");
                stringBuilder2.append(jNIDataModel.buf.length + this.tmepBuf.length);
                Logger.log(str2, stringBuilder2.toString());
            }
        }
    }

    private void relaseAudioFile() {
        if (this.mAudioFileRequestHandler != null) {
            this.mAudioFileRequestHandler.release(AudioFileRequestHandler.RELEASE_TYPE_RESET);
        }
        if (this.mHlsAudioFile != null) {
            this.mHlsAudioFile.release();
        }
        if (this.mFlvLiveAudioFile != null) {
            this.mFlvLiveAudioFile.release();
        }
    }

    private synchronized void releaseAudioTrackPlayThread() {
        if (this.mAudioTrackPlayThread != null) {
            this.mAudioTrackPlayThread.releasePlay();
            this.mAudioTrackPlayThread = null;
        }
        Logger.log(Tag, "releaseAudioTrackPlayThread releasePlay");
    }

    public native int MediaplayerComplete(long j);

    public native int MediaplayerDestroy(long j);

    public native int MediaplayerFrameworkInit(Context context, boolean z);

    public native int MediaplayerGetCurPlayingFileType(long j);

    public native long MediaplayerGetCurrentDecodedDataTime(long j);

    public native long MediaplayerGetCurrentTime(long j);

    public native long MediaplayerGetMediaDuration(long j);

    public native int MediaplayerGetOutputData(byte[] bArr, int i, long j);

    public native long MediaplayerInit(Context context, boolean z, int i, int i2, int i3, int i4);

    public native int MediaplayerOutputDataAppointment(long j);

    public native int MediaplayerPause(long j);

    public native int MediaplayerPlay(long j);

    public native int MediaplayerPrepareAsync(long j);

    public native int MediaplayerReset(long j);

    public native int MediaplayerSeek(long j, long j2);

    public native int MediaplayerSetDataSourceInfo(String str, int i, long j, double d, double d2);

    public native int MediaplayerStop(long j);

    public int bufferedDataReachThresholdCallBackT(int i) {
        if (NativeErrorType.NO_ERR.equals(NativeErrorType.valueOf(i))) {
            getAudioTrackPlayThread().dataReady();
            Logger.log(Tag, "dataStreamInputFuncCallBackT bufferedDataReachThresholdCallBackT");
            return 1;
        }
        handlePlayerStatus(i);
        return -1;
    }

    public int dataStreamInputFunCallBackT(JNIDataModel jNIDataModel) {
        if (!NativeErrorType.NO_ERR.equals(NativeErrorType.valueOf(jNIDataModel.status))) {
            Logger.log(Tag, "dataStreamInputFuncCallBackT readData start error:");
            handlePlayerStatus(jNIDataModel.status);
            return -1;
        } else if (this.isReseting) {
            return -2;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            String str = Tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dataStreamInputFuncCallBackT readData start:");
            stringBuilder.append(currentTimeMillis);
            Logger.log(str, stringBuilder.toString());
            if (jNIDataModel.filePath == null) {
                throw new RuntimeException("dataStreamInputFuncCallBackT tJNIDataModel.filePath==null 异常！！！");
            }
            Logger.log(Tag, "dataStreamInputFuncCallBackT fill io start");
            if (!jNIDataModel.filePath.equals(getCurPlayUrl())) {
                this.mCurrentSeekPosition = -1;
                this.mCurFileSize = 0;
                this.mCurrentSeekPositionState = 0;
                this.mHasSeek = true;
                this.tmepBuf = null;
                Logger.log(Tag, "dataStreamInputFuncCallBackT 重置");
            }
            str = Tag;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("dataStreamInputFuncCallBackT filePath:");
            stringBuilder2.append(jNIDataModel.filePath);
            Logger.log(str, stringBuilder2.toString());
            str = Tag;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("dataStreamInputFuncCallBackT seekParaTimeStampMs mCurrentSeekPositionState:");
            stringBuilder2.append(this.mCurrentSeekPositionState);
            Logger.log(str, stringBuilder2.toString());
            str = Tag;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("dataStreamInputFuncCallBackT seekParaTimeStampMs mCurrentSeekPosition:");
            stringBuilder2.append(this.mCurrentSeekPosition);
            Logger.log(str, stringBuilder2.toString());
            if (!this.mHasSeek || this.mCurrentSeekPosition == this.mCurrentSeekPositionState) {
                this.mHasSeek = false;
            } else {
                this.mCurrentSeekPosition = this.mCurrentSeekPositionState;
                str = Tag;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("dataStreamInputFuncCallBackT seekParaTimeStampMs true mCurrentSeekPosition:");
                stringBuilder2.append(this.mCurrentSeekPosition);
                Logger.log(str, stringBuilder2.toString());
                Logger.log(Tag, "dataStreamInputFuncCallBackT length diff seek true");
            }
            str = Tag;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("dataStreamInputFuncCallBackT mCurFileSize:");
            stringBuilder2.append(this.mCurFileSize);
            stringBuilder2.append("mCurrentSeekPosition:");
            stringBuilder2.append(this.mCurrentSeekPosition);
            Logger.log(str, stringBuilder2.toString());
            if (this.mCurFileSize <= 0 || ((long) this.mCurrentSeekPosition) < this.mCurFileSize || isHttpFlv()) {
                StringBuilder stringBuilder3;
                int readData;
                if (isHls()) {
                    if (this.mHlsAudioFile != null) {
                        if (this.mHasSeek || this.tmepBuf == null) {
                            this.tmepBuf = null;
                            Logger.log(Tag, "dataStreamInputFuncCallBackT M3U8_FILE");
                            if (this.mHlsAudioFile.readData(jNIDataModel) < 0) {
                                return -1;
                            }
                            this.mCurFileSize = jNIDataModel.fileSize;
                        } else {
                            jNIDataModel.buf = this.tmepBuf;
                            this.tmepBuf = null;
                            jNIDataModel.fileSize = this.mCurFileSize;
                            Logger.log(Tag, "dataStreamInputFuncCallBackT read temp buf");
                        }
                        this.mHasSeek = false;
                    } else if (XMediaPlayerConstants.isDebug) {
                        throw new RuntimeException("mHlsAudioFile==null");
                    } else {
                        Logger.log(Tag, "dataStreamInputFuncCallBackT xx 21");
                        return 0;
                    }
                } else if (!isHttpFlv()) {
                    Logger.log(Tag, "dataStreamInputFuncCallBackT NORMAL_FILE");
                    if (this.mAudioFileRequestHandler == null) {
                        if (XMediaPlayerConstants.isDebug) {
                            throw new RuntimeException("mAudioFileRequestHandler==null");
                        }
                        Logger.log(Tag, "dataStreamInputFuncCallBackT xx 19 return 0 over");
                        return 0;
                    } else if (this.mCurrentSeekPosition < 0) {
                        return -2;
                    } else {
                        readData = this.mAudioFileRequestHandler.readData(jNIDataModel, this.mHasSeek, this.mCurrentSeekPosition);
                        if (readData > 0) {
                            Logger.log(Tag, "dataStreamInputFuncCallBackT NORMAL_FILE result > 0");
                            this.mHasSeek = false;
                        } else {
                            String str2 = Tag;
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("dataStreamInputFuncCallBackT NORMAL_FILE result == ");
                            stringBuilder3.append(readData);
                            Logger.log(str2, stringBuilder3.toString());
                            return readData;
                        }
                    }
                } else if (this.mFlvLiveAudioFile != null) {
                    readData = this.mFlvLiveAudioFile.readData(jNIDataModel);
                    if (readData < 0) {
                        Logger.log(Tag, "dataStreamInputFuncCallBackT mFlvLiveAudioFile result < 0");
                        return readData;
                    } else if (readData == 0) {
                        Logger.log(Tag, "dataStreamInputFuncCallBackT mFlvLiveAudioFile result == 0");
                        return 0;
                    }
                } else if (!XMediaPlayerConstants.isDebug) {
                    return 0;
                } else {
                    throw new RuntimeException("mFlvLiveAudioFile==null");
                }
                if (jNIDataModel.buf == null) {
                    Logger.log(Tag, "dataStreamInputFuncCallBackT xx tJNIDataModel.buf==null");
                    return -1;
                }
                str = Tag;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("dataStreamInputFuncCallBackT buf.length");
                stringBuilder3.append(jNIDataModel.buf.length);
                Logger.log(str, stringBuilder3.toString());
                str = Tag;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("dataStreamInputFuncCallBackT mCurFileSize:");
                stringBuilder3.append(this.mCurFileSize);
                Logger.log(str, stringBuilder3.toString());
                str = Tag;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("dataStreamInputFuncCallBackT tJNIDataModel.buf.length:");
                stringBuilder3.append(jNIDataModel.buf.length);
                Logger.log(str, stringBuilder3.toString());
                str = Tag;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("dataStreamInputFuncCallBackT tJNIDataModel.bufSize:");
                stringBuilder3.append(jNIDataModel.bufSize);
                Logger.log(str, stringBuilder3.toString());
                handleSmallBufRequest(jNIDataModel);
                if (jNIDataModel.buf != null) {
                    this.mCurrentSeekPosition += jNIDataModel.buf.length;
                    str = Tag;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("dataStreamInputFuncCallBackT tJNIDataModel.buf.length:");
                    stringBuilder3.append(jNIDataModel.buf.length);
                    Logger.log(str, stringBuilder3.toString());
                }
                str = Tag;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("dataStreamInputFuncCallBackT mCurFileSize2:");
                stringBuilder3.append(this.mCurFileSize);
                Logger.log(str, stringBuilder3.toString());
                str = Tag;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("dataStreamInputFuncCallBackT tJNIDataModel filesize:");
                stringBuilder3.append(jNIDataModel.fileSize);
                Logger.log(str, stringBuilder3.toString());
                Logger.log(Tag, "dataStreamInputFuncCallBackT xx seekParaTimeStampMs fill io end");
                str = Tag;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("dataStreamInputFuncCallBackT readData end:");
                stringBuilder3.append(System.currentTimeMillis() - currentTimeMillis);
                Logger.log(str, stringBuilder3.toString());
                return jNIDataModel.buf.length;
            }
            Logger.log(Tag, "dataStreamInputFuncCallBackT xx return 0");
            return 0;
        }
    }

    public int dataStreamOutReadyFuncCallBackT(int i, int i2) {
        Logger.log(Tag, "dataStreamOutReadyFuncCallBackT");
        if (NativeErrorType.NO_ERR.equals(NativeErrorType.valueOf(i2))) {
            onPreparedInner();
            return 0;
        }
        handlePlayerStatus(i2);
        return -1;
    }

    public int dataStreamSeekFuncCallBackT(String str, long j, int i) {
        String str2 = Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dataStreamSeekFuncCallBackT 0 offset:");
        stringBuilder.append(j);
        Logger.log(str2, stringBuilder.toString());
        if (NativeErrorType.NO_ERR.equals(NativeErrorType.valueOf(i))) {
            if (!TextUtils.isEmpty(str)) {
                this.mCurrentDataDecodeUrl = str;
            }
            this.mHasSeek = true;
            this.mCurrentSeekPositionState = (int) j;
            str = Tag;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("dataStreamInputFuncCallBackT seekParaTimeStampMs true offset:");
            stringBuilder2.append(j);
            Logger.log(str, stringBuilder2.toString());
            return 0;
        }
        handlePlayerStatus(i);
        return -1;
    }

    public synchronized AudioTrackPlayThread getAudioTrackPlayThread() {
        if (this.mAudioTrackPlayThread != null && this.mAudioTrackPlayThread.isRelase()) {
            this.mAudioTrackPlayThread = null;
        }
        if (this.mAudioTrackPlayThread == null) {
            Logger.log(Tag, "dataStreamInputFuncCallBackT getAudioTrackPlayThread new");
            this.mAudioTrackPlayThread = new AudioTrackPlayThread(this);
            this.mAudioTrackPlayThread.setSoundTouchAllParams(this.mTempo, this.mPitch, this.mRate);
        }
        return this.mAudioTrackPlayThread;
    }

    public AudioType getAudioType() {
        return this.mAudioType;
    }

    public int getCachePercent() {
        return isHttpFlv() ? 0 : isHls() ? this.mHlsAudioFile == null ? 0 : this.mHlsAudioFile.getCachePercent() : this.mAudioFileRequestHandler == null ? 0 : this.mAudioFileRequestHandler.getCachePercent();
    }

    public int getChargeDataRealLength() {
        return this.chargeDataRealLength;
    }

    public long getCurFileSize() {
        return this.mCurFileSize;
    }

    public int getCurrentPosition() {
        return (int) MediaplayerGetCurrentTime(this.mJniHandler);
    }

    public int getDuration() {
        return (int) MediaplayerGetMediaDuration(this.mJniHandler);
    }

    public int getOutputData(byte[] bArr, int i) {
        return (this.mAudioTrackPlayThread == null || this.hasRelease) ? -1 : MediaplayerGetOutputData(bArr, i, this.mJniHandler);
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public void handlePlayerStatus(int i) {
        NativeErrorType valueOf = NativeErrorType.valueOf(i);
        String str = Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handlePlayerStatus status:");
        stringBuilder.append(i);
        Logger.log(str, stringBuilder.toString());
        if (valueOf != null) {
            switch (valueOf) {
                case ERR_DECODEDATA_FILLIO_FAIL:
                    onErrorInner(8, XMediaPlayer.MEDIA_ERROR_IO);
                    break;
                case ERR_DECODE_NOT_SUPPORT:
                    onErrorInner(8, XMediaPlayer.MEDIA_ERROR_UNSUPPORTED);
                    break;
                case ERR_FILE_MANAGER_INNER_ERR:
                    onErrorInner(8, 100);
                    break;
                case ERR_M3U8STREAM_FILLIO_FAIL:
                    onErrorInner(8, XMediaPlayer.MEDIA_ERROR_IO);
                    break;
                case ERR_M3U8_FILE_CONTENT_INVALID:
                    onErrorInner(8, XMediaPlayer.MEDIA_ERROR_IO);
                    break;
                case ERR_NOTOK:
                    onErrorInner(8, 1);
                    break;
                case NO_ERR:
                    break;
                case ERR_ARCH_NOT_SUPPORT:
                    onErrorInner(8, XMediaPlayer.MEDIA_ERROR_ARCH_UNSUPPORTED);
                    break;
                default:
                    onErrorInner(8, XMediaPlayer.MEDIA_ERROR_IO);
                    break;
            }
        }
    }

    public boolean isHls() {
        return this.mAudioType.value() > 0 && this.mAudioType.value() < 4;
    }

    public boolean isHttpFlv() {
        return this.mAudioType == AudioType.FLV_FILE;
    }

    public boolean isPlaying() {
        Logger.log(Tag, "dataStreamInputFuncCallBackT isPlaying");
        return getAudioTrackPlayThread().isPlaying();
    }

    public boolean isSeeking() {
        return this.isSeeking;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0118 A:{SYNTHETIC, Splitter:B:46:0x0118} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0217 A:{SYNTHETIC, Splitter:B:108:0x0217} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0217 A:{SYNTHETIC, Splitter:B:108:0x0217} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0217 A:{SYNTHETIC, Splitter:B:108:0x0217} */
    /* JADX WARNING: Missing block: B:73:0x017a, code skipped:
            if (r5 == null) goto L_0x01e3;
     */
    /* JADX WARNING: Missing block: B:82:0x01ac, code skipped:
            if (r5 == null) goto L_0x01e3;
     */
    /* JADX WARNING: Missing block: B:91:0x01de, code skipped:
            if (r5 == null) goto L_0x01e3;
     */
    /* JADX WARNING: Missing block: B:93:?, code skipped:
            r5.close();
     */
    public int m3u8FileStreamInputFuncCallBackT(com.ximalaya.ting.android.player.model.JNIDataModel r14) {
        /*
        r13 = this;
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.NativeErrorType.NO_ERR;
        r1 = r14.status;
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.NativeErrorType.valueOf(r1);
        r0 = r0.equals(r1);
        r1 = -1;
        if (r0 != 0) goto L_0x0015;
    L_0x000f:
        r14 = r14.status;
        r13.handlePlayerStatus(r14);
        return r1;
    L_0x0015:
        if (r14 == 0) goto L_0x027c;
    L_0x0017:
        r0 = r14.bufSize;
        if (r0 > 0) goto L_0x001d;
    L_0x001b:
        goto L_0x027c;
    L_0x001d:
        r0 = Tag;
        r2 = "HlsReadThread downUrl0  m3u8FileStreamInputFuncCallBackT";
        com.ximalaya.ting.android.player.Logger.log(r0, r2);
        r0 = 1;
        r2 = r0;
    L_0x0026:
        r3 = r2 + -1;
        r4 = 0;
        if (r2 <= 0) goto L_0x0222;
    L_0x002b:
        r2 = 0;
        r5 = new java.lang.String[r0];	 Catch:{ MalformedURLException -> 0x01af, IOException -> 0x017d, Exception -> 0x014b, all -> 0x0147 }
        r6 = r13.mPlayUrl;	 Catch:{ MalformedURLException -> 0x01af, IOException -> 0x017d, Exception -> 0x014b, all -> 0x0147 }
        r5[r4] = r6;	 Catch:{ MalformedURLException -> 0x01af, IOException -> 0x017d, Exception -> 0x014b, all -> 0x0147 }
        r6 = 2;
        r7 = "GET";
        r5 = com.ximalaya.ting.android.player.PlayerUtil.getConnectionUseDnsCache(r5, r2, r6, r4, r7);	 Catch:{ MalformedURLException -> 0x01af, IOException -> 0x017d, Exception -> 0x014b, all -> 0x0147 }
        if (r5 != 0) goto L_0x0057;
    L_0x003b:
        r2 = Tag;
        r4 = "m3u8FileStreamInputFuncCallBackT tt 0";
        com.ximalaya.ting.android.player.Logger.log(r2, r4);
        if (r5 == 0) goto L_0x0047;
    L_0x0044:
        r5.disconnect();
    L_0x0047:
        r2 = Tag;
        r4 = "m3u8FileStreamInputFuncCallBackT tt 1";
        com.ximalaya.ting.android.player.Logger.log(r2, r4);
        r2 = Tag;
        r4 = "m3u8FileStreamInputFuncCallBackT tt 2";
        com.ximalaya.ting.android.player.Logger.log(r2, r4);
        goto L_0x01fb;
    L_0x0057:
        r6 = r5.getResponseCode();	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r7 = Tag;	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r8 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r8.<init>();	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r9 = "m3u8FileStreamInputFuncCallBackT 0 responseCode:";
        r8.append(r9);	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r8.append(r6);	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r8 = r8.toString();	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        com.ximalaya.ting.android.player.Logger.log(r7, r8);	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 == r7) goto L_0x00af;
    L_0x0075:
        r7 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r6 != r7) goto L_0x007a;
    L_0x0079:
        goto L_0x00af;
    L_0x007a:
        r7 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r6 < r7) goto L_0x0103;
    L_0x007e:
        r7 = Tag;	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r8 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r8.<init>();	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r9 = "m3u8FileStreamInputFuncCallBackT HTTP_BAD_REQUEST responseCode:";
        r8.append(r9);	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r8.append(r6);	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r6 = r8.toString();	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        com.ximalaya.ting.android.player.Logger.log(r7, r6);	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r14 = Tag;
        r0 = "m3u8FileStreamInputFuncCallBackT tt 0";
        com.ximalaya.ting.android.player.Logger.log(r14, r0);
        if (r5 == 0) goto L_0x00a0;
    L_0x009d:
        r5.disconnect();
    L_0x00a0:
        r14 = Tag;
        r0 = "m3u8FileStreamInputFuncCallBackT tt 1";
        com.ximalaya.ting.android.player.Logger.log(r14, r0);
        r14 = Tag;
        r0 = "m3u8FileStreamInputFuncCallBackT tt 2";
        com.ximalaya.ting.android.player.Logger.log(r14, r0);
        return r1;
    L_0x00af:
        r6 = Tag;	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r7 = "m3u8FileStreamInputFuncCallBackT 1";
        com.ximalaya.ting.android.player.Logger.log(r6, r7);	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r6 = r5.getInputStream();	 Catch:{ MalformedURLException -> 0x0142, IOException -> 0x013d, Exception -> 0x0138, all -> 0x0135 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r2.<init>();	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r7 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r7 = new byte[r7];	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
    L_0x00c3:
        r8 = r6.read(r7);	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        if (r8 == r1) goto L_0x00e3;
    L_0x00c9:
        r2.write(r7, r4, r8);	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r9 = Tag;	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r10 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r10.<init>();	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r11 = "m3u8FileStreamInputFuncCallBackT len:";
        r10.append(r11);	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r10.append(r8);	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r8 = r10.toString();	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        com.ximalaya.ting.android.player.Logger.log(r9, r8);	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        goto L_0x00c3;
    L_0x00e3:
        r7 = Tag;	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r9 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r9.<init>();	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r10 = "m3u8FileStreamInputFuncCallBackT len000:";
        r9.append(r10);	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r9.append(r8);	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r8 = r9.toString();	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        com.ximalaya.ting.android.player.Logger.log(r7, r8);	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r7 = r2.toByteArray();	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r14.buf = r7;	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r2.close();	 Catch:{ MalformedURLException -> 0x012e, IOException -> 0x0127, Exception -> 0x0121, all -> 0x011d }
        r2 = r6;
    L_0x0103:
        r6 = Tag;
        r7 = "m3u8FileStreamInputFuncCallBackT tt 0";
        com.ximalaya.ting.android.player.Logger.log(r6, r7);
        if (r5 == 0) goto L_0x010f;
    L_0x010c:
        r5.disconnect();
    L_0x010f:
        r5 = Tag;
        r6 = "m3u8FileStreamInputFuncCallBackT tt 1";
        com.ximalaya.ting.android.player.Logger.log(r5, r6);
        if (r2 == 0) goto L_0x01e3;
    L_0x0118:
        r2.close();	 Catch:{ IOException -> 0x01e3 }
        goto L_0x01e3;
    L_0x011d:
        r14 = move-exception;
        r2 = r6;
        goto L_0x0202;
    L_0x0121:
        r2 = move-exception;
        r12 = r6;
        r6 = r2;
        r2 = r5;
        r5 = r12;
        goto L_0x014d;
    L_0x0127:
        r2 = move-exception;
        r12 = r6;
        r6 = r2;
        r2 = r5;
        r5 = r12;
        goto L_0x017f;
    L_0x012e:
        r2 = move-exception;
        r12 = r6;
        r6 = r2;
        r2 = r5;
        r5 = r12;
        goto L_0x01b1;
    L_0x0135:
        r14 = move-exception;
        goto L_0x0202;
    L_0x0138:
        r6 = move-exception;
        r12 = r5;
        r5 = r2;
        r2 = r12;
        goto L_0x014d;
    L_0x013d:
        r6 = move-exception;
        r12 = r5;
        r5 = r2;
        r2 = r12;
        goto L_0x017f;
    L_0x0142:
        r6 = move-exception;
        r12 = r5;
        r5 = r2;
        r2 = r12;
        goto L_0x01b1;
    L_0x0147:
        r14 = move-exception;
        r5 = r2;
        goto L_0x0202;
    L_0x014b:
        r6 = move-exception;
        r5 = r2;
    L_0x014d:
        r7 = Tag;	 Catch:{ all -> 0x01fe }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01fe }
        r8.<init>();	 Catch:{ all -> 0x01fe }
        r9 = "m3u8FileStreamInputFuncCallBackT Exception:";
        r8.append(r9);	 Catch:{ all -> 0x01fe }
        r6 = r6.toString();	 Catch:{ all -> 0x01fe }
        r8.append(r6);	 Catch:{ all -> 0x01fe }
        r6 = r8.toString();	 Catch:{ all -> 0x01fe }
        com.ximalaya.ting.android.player.Logger.log(r7, r6);	 Catch:{ all -> 0x01fe }
        r6 = Tag;
        r7 = "m3u8FileStreamInputFuncCallBackT tt 0";
        com.ximalaya.ting.android.player.Logger.log(r6, r7);
        if (r2 == 0) goto L_0x0173;
    L_0x0170:
        r2.disconnect();
    L_0x0173:
        r2 = Tag;
        r6 = "m3u8FileStreamInputFuncCallBackT tt 1";
        com.ximalaya.ting.android.player.Logger.log(r2, r6);
        if (r5 == 0) goto L_0x01e3;
    L_0x017c:
        goto L_0x01e0;
    L_0x017d:
        r6 = move-exception;
        r5 = r2;
    L_0x017f:
        r7 = Tag;	 Catch:{ all -> 0x01fe }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01fe }
        r8.<init>();	 Catch:{ all -> 0x01fe }
        r9 = "m3u8FileStreamInputFuncCallBackT IOException:";
        r8.append(r9);	 Catch:{ all -> 0x01fe }
        r6 = r6.toString();	 Catch:{ all -> 0x01fe }
        r8.append(r6);	 Catch:{ all -> 0x01fe }
        r6 = r8.toString();	 Catch:{ all -> 0x01fe }
        com.ximalaya.ting.android.player.Logger.log(r7, r6);	 Catch:{ all -> 0x01fe }
        r6 = Tag;
        r7 = "m3u8FileStreamInputFuncCallBackT tt 0";
        com.ximalaya.ting.android.player.Logger.log(r6, r7);
        if (r2 == 0) goto L_0x01a5;
    L_0x01a2:
        r2.disconnect();
    L_0x01a5:
        r2 = Tag;
        r6 = "m3u8FileStreamInputFuncCallBackT tt 1";
        com.ximalaya.ting.android.player.Logger.log(r2, r6);
        if (r5 == 0) goto L_0x01e3;
    L_0x01ae:
        goto L_0x01e0;
    L_0x01af:
        r6 = move-exception;
        r5 = r2;
    L_0x01b1:
        r7 = Tag;	 Catch:{ all -> 0x01fe }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01fe }
        r8.<init>();	 Catch:{ all -> 0x01fe }
        r9 = "m3u8FileStreamInputFuncCallBackT MalformedURLException:";
        r8.append(r9);	 Catch:{ all -> 0x01fe }
        r6 = r6.toString();	 Catch:{ all -> 0x01fe }
        r8.append(r6);	 Catch:{ all -> 0x01fe }
        r6 = r8.toString();	 Catch:{ all -> 0x01fe }
        com.ximalaya.ting.android.player.Logger.log(r7, r6);	 Catch:{ all -> 0x01fe }
        r6 = Tag;
        r7 = "m3u8FileStreamInputFuncCallBackT tt 0";
        com.ximalaya.ting.android.player.Logger.log(r6, r7);
        if (r2 == 0) goto L_0x01d7;
    L_0x01d4:
        r2.disconnect();
    L_0x01d7:
        r2 = Tag;
        r6 = "m3u8FileStreamInputFuncCallBackT tt 1";
        com.ximalaya.ting.android.player.Logger.log(r2, r6);
        if (r5 == 0) goto L_0x01e3;
    L_0x01e0:
        r5.close();	 Catch:{ IOException -> 0x01e3 }
    L_0x01e3:
        r2 = Tag;
        r5 = "m3u8FileStreamInputFuncCallBackT tt 2";
        com.ximalaya.ting.android.player.Logger.log(r2, r5);
        r2 = r14.buf;
        if (r2 == 0) goto L_0x01fb;
    L_0x01ee:
        r2 = r14.buf;
        r2 = r2.length;
        if (r2 <= 0) goto L_0x01fb;
    L_0x01f3:
        r0 = Tag;
        r1 = "m3u8FileStreamInputFuncCallBackT tt 3";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        goto L_0x0222;
    L_0x01fb:
        r2 = r3;
        goto L_0x0026;
    L_0x01fe:
        r14 = move-exception;
        r12 = r5;
        r5 = r2;
        r2 = r12;
    L_0x0202:
        r0 = Tag;
        r1 = "m3u8FileStreamInputFuncCallBackT tt 0";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        if (r5 == 0) goto L_0x020e;
    L_0x020b:
        r5.disconnect();
    L_0x020e:
        r0 = Tag;
        r1 = "m3u8FileStreamInputFuncCallBackT tt 1";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        if (r2 == 0) goto L_0x021a;
    L_0x0217:
        r2.close();	 Catch:{ IOException -> 0x021a }
    L_0x021a:
        r0 = Tag;
        r1 = "m3u8FileStreamInputFuncCallBackT tt 2";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        throw r14;
    L_0x0222:
        r0 = Tag;
        r1 = "m3u8FileStreamInputFuncCallBackT tt 4";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        r0 = r14.buf;
        if (r0 == 0) goto L_0x0274;
    L_0x022d:
        r0 = r14.buf;
        r0 = r0.length;
        r1 = r14.bufSize;
        if (r0 > r1) goto L_0x0274;
    L_0x0234:
        r0 = r14.buf;
        r0 = r0.length;
        if (r0 != 0) goto L_0x023a;
    L_0x0239:
        goto L_0x0274;
    L_0x023a:
        r0 = Tag;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "m3u8FileStreamInputFuncCallBackT contentLength 5:";
        r1.append(r2);
        r2 = r14.buf;
        r2 = r2.length;
        r1.append(r2);
        r1 = r1.toString();
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        r0 = Tag;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "m3u8FileStreamInputFuncCallBackT buf:";
        r1.append(r2);
        r2 = new java.lang.String;
        r3 = r14.buf;
        r2.<init>(r3);
        r1.append(r2);
        r1 = r1.toString();
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        r14 = r14.buf;
        r14 = r14.length;
        return r14;
    L_0x0274:
        r14 = Tag;
        r0 = "m3u8FileStreamInputFuncCallBackT null end 4";
        com.ximalaya.ting.android.player.Logger.log(r14, r0);
        return r4;
    L_0x027c:
        r14 = Tag;
        r0 = "m3u8FileStreamInputFuncCallBackT tJNIDataModel null";
        com.ximalaya.ting.android.player.Logger.log(r14, r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.XMediaplayerJNI.m3u8FileStreamInputFuncCallBackT(com.ximalaya.ting.android.player.model.JNIDataModel):int");
    }

    public int m3u8ParsedNewMediaItemInfoFuncCallBackT(String[] strArr, int i, int i2) {
        if (!NativeErrorType.NO_ERR.equals(NativeErrorType.valueOf(i2))) {
            Logger.log(Tag, "m3u8ParsedNewMediaItemInfoFuncCallBackT onErrorInner");
            handlePlayerStatus(i2);
            return -1;
        } else if (this.mHlsAudioFile == null) {
            return -1;
        } else {
            String str = Tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HlsReadThread downUrl0 m3u8ParsedNewMediaItemInfoFuncCallBackT length:");
            stringBuilder.append(strArr.length);
            Logger.log(str, stringBuilder.toString());
            i = MediaplayerGetCurPlayingFileType(this.mJniHandler);
            if (i >= 0) {
                this.mAudioType = AudioType.valueOf(i);
                str = Tag;
                stringBuilder = new StringBuilder();
                stringBuilder.append("m3u8ParsedNewMediaItemInfoFuncCallBackT mAudioType0:");
                stringBuilder.append(this.mAudioType.value());
                Logger.log(str, stringBuilder.toString());
            } else {
                onErrorInner(8, 1);
                Logger.log(Tag, "m3u8ParsedNewMediaItemInfoFuncCallBackT mAudioType0 error");
            }
            this.mHlsAudioFile.addPlayUrls(strArr);
            return 0;
        }
    }

    public abstract void mOnTimedChangeListenerInner();

    public abstract void onBufferingUpdateInner(int i);

    public void onCompletionInner() {
        resetAllData();
        MediaplayerComplete(this.mJniHandler);
        Logger.log(Tag, "flushAllDataInSoundTouch dataStreamInputFuncCallBackT onCompletionInner");
        releaseAudioTrackPlayThread();
    }

    public void onErrorInner(int i, int i2) {
        Logger.log(Tag, "onErrorInner");
    }

    public abstract void onInfoInner(int i);

    public void onPreparedInner() {
        if (this.isBuffing) {
            onInfoInner(XMediaPlayer.MEDIA_INFO_BUFFERING_END);
        }
        if (MediaplayerGetCurPlayingFileType(this.mJniHandler) >= 0) {
            String str = Tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPreparedInner mAudioType:");
            stringBuilder.append(this.mAudioType.value());
            Logger.log(str, stringBuilder.toString());
            return;
        }
        onErrorInner(8, 1);
        Logger.log(Tag, "onPreparedInner mAudioType error");
    }

    public abstract void onSeekCompletedInner();

    public int outputDataAppointment() {
        return MediaplayerOutputDataAppointment(this.mJniHandler);
    }

    public void pause() {
        Logger.log(Tag, "dataStreamInputFuncCallBackT pause");
        this.isAfterSetDataSourceStart = false;
        getAudioTrackPlayThread().pausePlay();
        MediaplayerPause(this.mJniHandler);
        if (this.mFlvLiveAudioFile != null) {
            this.mFlvLiveAudioFile.release();
        }
    }

    public void prepareAsync() {
        if (this.mAudioFileRequestHandler != null && this.mAudioFileRequestHandler.isRelease()) {
            this.mAudioFileRequestHandler.restart();
        }
        Logger.log(Tag, "prepareAsync");
        if (!this.isBuffing) {
            onInfoInner(XMediaPlayer.MEDIA_INFO_BUFFERING_START);
        }
        MediaplayerPrepareAsync(this.mJniHandler);
    }

    public void release() {
        this.hasRelease = true;
        relaseAudioFile();
        while (MediaplayerReset(this.mJniHandler) < 0) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Logger.log(Tag, "dataStreamInputFuncCallBackT release");
        releaseAudioTrackPlayThread();
        resetAllData();
        MediaplayerDestroy(this.mJniHandler);
        this.tmepBuf = null;
        this.mTempo = 1.0f;
        this.mPitch = CropImageView.DEFAULT_ASPECT_RATIO;
        this.mRate = 1.0f;
    }

    public void reset() {
        getAudioTrackPlayThread().flushPlayDataAndPause();
        relaseAudioFile();
        Logger.log(Tag, "reset start");
        this.isReseting = true;
        MediaplayerReset(this.mJniHandler);
        this.isReseting = false;
        Logger.log(Tag, "reset end");
        resetAllData();
    }

    public void resetAllData() {
        this.isAfterSetDataSourceStart = false;
        this.chargeDataRealLength = 0;
        this.mHasSeek = true;
        this.tmepBuf = null;
        this.mCurrentSeekPosition = -1;
        this.mCurrentSeekPositionState = 0;
        this.mCurFileSize = 0;
        if (this.mAudioFileRequestHandler != null) {
            this.mAudioFileRequestHandler.release(AudioFileRequestHandler.RELEASE_TYPE_RESET);
            Logger.log(Tag, "resetAllData mAudioFileRequestHandler.release()");
        } else {
            Logger.log(Tag, "resetAllData mAudioFileRequestHandler null");
        }
        if (this.mHlsAudioFile != null) {
            this.mHlsAudioFile.release();
            Logger.log(Tag, "resetAllData mHlsAudioFile.release()");
        } else {
            Logger.log(Tag, "resetAllData mHlsAudioFile null");
        }
        if (this.mFlvLiveAudioFile != null) {
            this.mFlvLiveAudioFile.release();
            Logger.log(Tag, "resetAllData mFlvLiveAudioFile.release()");
        } else {
            Logger.log(Tag, "resetAllData mFlvLiveAudioFile null");
        }
        Logger.log(Tag, "dataStreamInputFuncCallBackT initAllData 重置0");
    }

    public void seekTo(int i) {
        if (!isHttpFlv()) {
            String str = Tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("seekParaTimeStampMs msec:");
            stringBuilder.append(i);
            Logger.log(str, stringBuilder.toString());
            this.isSeeking = true;
            MediaplayerSeek((long) i, this.mJniHandler);
            this.isSeeking = false;
            onSeekCompletedInner();
            mOnTimedChangeListenerInner();
            String str2 = Tag;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("ttseek2:");
            stringBuilder2.append(System.currentTimeMillis());
            Logger.log(str2, stringBuilder2.toString());
        }
    }

    public void setCurFileSize(long j) {
        this.mCurFileSize = j;
    }

    public void setDataSource(String str) {
        setDataSource(str, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102 A:{SYNTHETIC, Splitter:B:43:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f6 A:{SYNTHETIC, Splitter:B:35:0x00f6} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102 A:{SYNTHETIC, Splitter:B:43:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ed A:{Splitter:B:17:0x00d5, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:27:0x00ed, code skipped:
            r14 = th;
     */
    /* JADX WARNING: Missing block: B:28:0x00ee, code skipped:
            r0 = r1;
     */
    public void setDataSource(java.lang.String r14, java.lang.String r15) {
        /*
        r13 = this;
        r0 = 0;
        r13.mAudioFileRequestHandler = r0;
        r13.mHlsAudioFile = r0;
        r13.mFlvLiveAudioFile = r0;
        r1 = 1;
        r13.isAfterSetDataSourceStart = r1;
        r1 = Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "flushAllDataInSoundTouch setDataSource src:";
        r2.append(r3);
        r2.append(r14);
        r2 = r2.toString();
        com.ximalaya.ting.android.player.Logger.log(r1, r2);
        r1 = 0;
        r13.chargeDataRealLength = r1;
        r13.releaseAudioTrackPlayThread();
        r1 = "totalLength";
        r1 = r14.contains(r1);
        if (r1 == 0) goto L_0x005c;
    L_0x002e:
        r1 = android.net.Uri.parse(r14);
        r2 = "totalLength";
        r1 = r1.getQueryParameter(r2);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x005c;
    L_0x003e:
        r1 = java.lang.Integer.parseInt(r1);
        r13.chargeDataRealLength = r1;
        r1 = Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "chargeDataRealLength:";
        r2.append(r3);
        r3 = r13.chargeDataRealLength;
        r2.append(r3);
        r2 = r2.toString();
        com.ximalaya.ting.android.player.Logger.log(r1, r2);
    L_0x005c:
        r13.mPlayUrl = r14;
        r14 = r13.mPlayUrl;
        r1 = ".flv";
        r14 = r14.contains(r1);
        if (r14 == 0) goto L_0x0087;
    L_0x0068:
        r14 = new com.ximalaya.ting.android.player.liveflv.FlvLiveAudioFile;
        r14.<init>(r13);
        r13.mFlvLiveAudioFile = r14;
        r14 = com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType.FLV_FILE;
        r13.mAudioType = r14;
        r1 = r13.mPlayUrl;
        r14 = r13.mAudioType;
        r2 = r14.value();
        r3 = r13.mJniHandler;
        r5 = 0;
        r7 = 0;
        r0 = r13;
        r0.MediaplayerSetDataSourceInfo(r1, r2, r3, r5, r7);
        goto L_0x0142;
    L_0x0087:
        r14 = r13.mPlayUrl;
        r1 = "m3u8";
        r14 = r14.contains(r1);
        if (r14 == 0) goto L_0x00b2;
    L_0x0091:
        r14 = new com.ximalaya.ting.android.player.HlsAudioFile;
        r15 = r13.mPlayUrl;
        r14.<init>(r15, r13);
        r13.mHlsAudioFile = r14;
        r14 = com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType.M3U8_FILE;
        r13.mAudioType = r14;
        r1 = r13.mPlayUrl;
        r14 = r13.mAudioType;
        r2 = r14.value();
        r3 = r13.mJniHandler;
        r5 = 0;
        r7 = 0;
        r0 = r13;
        r0.MediaplayerSetDataSourceInfo(r1, r2, r3, r5, r7);
        goto L_0x0142;
    L_0x00b2:
        r14 = r13.mPlayUrl;
        r1 = ".xm";
        r14 = r14.endsWith(r1);
        if (r14 == 0) goto L_0x011b;
    L_0x00bc:
        r14 = new com.ximalaya.ting.android.player.AudioFileRequestHandler;
        r14.<init>(r13);
        r13.mAudioFileRequestHandler = r14;
        r14 = com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType.XMLY_FORMAT;
        r13.mAudioType = r14;
        r14 = 0;
        r1 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x00ff, all -> 0x00f3 }
        r2 = r13.mPlayUrl;	 Catch:{ IOException -> 0x00ff, all -> 0x00f3 }
        r3 = "r";
        r1.<init>(r2, r3);	 Catch:{ IOException -> 0x00ff, all -> 0x00f3 }
        r0 = 24;
        r2 = (long) r0;
        r1.seek(r2);	 Catch:{ IOException -> 0x00f0, all -> 0x00ed }
        r2 = r1.readDouble();	 Catch:{ IOException -> 0x00f0, all -> 0x00ed }
        r4 = r1.readDouble();	 Catch:{ IOException -> 0x00f1, all -> 0x00ed }
        if (r1 == 0) goto L_0x00ea;
    L_0x00e2:
        r1.close();	 Catch:{ IOException -> 0x00e6 }
        goto L_0x00ea;
    L_0x00e6:
        r14 = move-exception;
        r14.printStackTrace();
    L_0x00ea:
        r9 = r2;
        r11 = r4;
        goto L_0x010c;
    L_0x00ed:
        r14 = move-exception;
        r0 = r1;
        goto L_0x00f4;
    L_0x00f0:
        r2 = r14;
    L_0x00f1:
        r0 = r1;
        goto L_0x0100;
    L_0x00f3:
        r14 = move-exception;
    L_0x00f4:
        if (r0 == 0) goto L_0x00fe;
    L_0x00f6:
        r0.close();	 Catch:{ IOException -> 0x00fa }
        goto L_0x00fe;
    L_0x00fa:
        r15 = move-exception;
        r15.printStackTrace();
    L_0x00fe:
        throw r14;
    L_0x00ff:
        r2 = r14;
    L_0x0100:
        if (r0 == 0) goto L_0x010a;
    L_0x0102:
        r0.close();	 Catch:{ IOException -> 0x0106 }
        goto L_0x010a;
    L_0x0106:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x010a:
        r11 = r14;
        r9 = r2;
    L_0x010c:
        r5 = r13.mPlayUrl;
        r14 = r13.mAudioType;
        r6 = r14.value();
        r7 = r13.mJniHandler;
        r4 = r13;
        r4.MediaplayerSetDataSourceInfo(r5, r6, r7, r9, r11);
        goto L_0x0142;
    L_0x011b:
        if (r15 != 0) goto L_0x0125;
    L_0x011d:
        r14 = new com.ximalaya.ting.android.player.AudioFileRequestHandler;
        r14.<init>(r13);
        r13.mAudioFileRequestHandler = r14;
        goto L_0x012c;
    L_0x0125:
        r14 = new com.ximalaya.ting.android.player.AudioFileRequestHandler;
        r14.<init>(r13, r15);
        r13.mAudioFileRequestHandler = r14;
    L_0x012c:
        r14 = com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType.NORMAL_FILE;
        r13.mAudioType = r14;
        r1 = r13.mPlayUrl;
        r14 = r13.mAudioType;
        r2 = r14.value();
        r3 = r13.mJniHandler;
        r5 = 0;
        r7 = 0;
        r0 = r13;
        r0.MediaplayerSetDataSourceInfo(r1, r2, r3, r5, r7);
    L_0x0142:
        r14 = Tag;
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r0 = "setDataSource mAudioType:";
        r15.append(r0);
        r0 = r13.mAudioType;
        r0 = r0.value();
        r15.append(r0);
        r15 = r15.toString();
        com.ximalaya.ting.android.player.Logger.log(r14, r15);
        r14 = com.ximalaya.ting.android.player.PlayCacheByLRU.getInstance();
        r15 = r13.mPlayUrl;
        r14.putPlayUrl(r15);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.XMediaplayerJNI.setDataSource(java.lang.String, java.lang.String):void");
    }

    public void setOnPlayDataOutputListener(OnPlayDataOutputListener onPlayDataOutputListener) {
        this.mOnPlayDataOutputListener = onPlayDataOutputListener;
    }

    public void setPreBufferUrl(String str) {
        if (this.mAudioFileRequestHandler != null) {
            this.mAudioFileRequestHandler.setPreBufferUrl(str);
        }
    }

    public void setSoundTouchAllParams(float f, float f2, float f3) {
        this.mTempo = f;
        this.mPitch = f2;
        this.mRate = f3;
        if (this.mAudioTrackPlayThread != null) {
            this.mAudioTrackPlayThread.setSoundTouchAllParams(f, f2, f3);
        }
    }

    public void setTempo(float f) {
        this.mTempo = f;
        if (this.mAudioTrackPlayThread != null) {
            this.mAudioTrackPlayThread.setTempo(f);
        }
    }

    public void setVolume(float f, float f2) {
        AudioTrackPlayThread audioTrackPlayThread = getAudioTrackPlayThread();
        if (audioTrackPlayThread != null) {
            audioTrackPlayThread.setVolume(f);
        }
    }

    public synchronized void start() {
        String str = Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dataStreamInputFuncCallBackT start mAudioType");
        stringBuilder.append(this.mAudioType);
        Logger.log(str, stringBuilder.toString());
        if (this.mAudioType != AudioType.FLV_FILE || this.isAfterSetDataSourceStart) {
            if (this.mAudioFileRequestHandler != null && this.mAudioFileRequestHandler.isRelease()) {
                this.mAudioFileRequestHandler.restart();
            }
            getAudioTrackPlayThread().startPlay();
            MediaplayerPlay(this.mJniHandler);
        } else {
            Logger.log(Tag, "FLV_FILE start reset");
            reset();
            setDataSource(this.mPlayUrl);
            prepareAsync();
        }
        this.isAfterSetDataSourceStart = false;
    }

    public void stop() {
        Logger.log(Tag, "dataStreamInputFuncCallBackT stop");
        getAudioTrackPlayThread().stopPlay();
        relaseAudioFile();
        MediaplayerStop(this.mJniHandler);
        resetAllData();
    }

    public void xmediaplayerInit() {
        this.hasRelease = false;
        String str = Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mediaplayer Init 0000000000:");
        stringBuilder.append(this.mJniHandler);
        Logger.log(str, stringBuilder.toString());
        this.mJniHandler = MediaplayerInit(this.mContext, this.isRelease, cu.O000o0O0, 65536, bt.O000000o, bt.O000000o);
        str = Tag;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Mediaplayer Init 1:");
        stringBuilder.append(this.mJniHandler);
        Logger.log(str, stringBuilder.toString());
        str = Tag;
        stringBuilder = new StringBuilder();
        stringBuilder.append("MediaplayerInit jniHandler:");
        stringBuilder.append(this.mJniHandler);
        Logger.log(str, stringBuilder.toString());
        if (this.mJniHandler == 0) {
            handlePlayerStatus(NativeErrorType.ERR_ARCH_NOT_SUPPORT.value());
        }
        PlayCacheByLRU.getInstance().init();
    }
}
