package com.ximalaya.ting.android.opensdk.player.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.history.XmPlayRecord;
import com.ximalaya.ting.android.opensdk.model.statistic.RecordModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.Logger;
import java.util.Map;

public class XmStatisticsManager {
    private static final int STAT_ACTIVITY_COUNT = 3;
    private static final int STAT_DATA = 0;
    private static final int STAT_RADIO_COUNT = 2;
    private static final int STAT_TRACK_COUNT = 1;
    private static volatile XmStatisticsManager sInstance;
    private static byte[] sLock = new byte[0];
    private long blockTime1;
    private long blockTime2;
    private boolean isShouldStatistic = false;
    private Context mContext;
    int mCurrPos1 = 0;
    private boolean mIsKd;
    private boolean mIsSeek;
    private int mKd;
    private XmPlayRecord mRecord;
    private RecordModel mRecordModel = null;
    private long mTotalLastBlockTime;
    private IXmUserOneDateListener mUserOneDateListener;
    private long totalPlaySec = 0;
    private IXmPlayStatisticUpload upload;
    public String xmCurPlayResource;
    public Map<String, String> xmResourceMap;
    public String xmUploadPlayResource;

    private XmStatisticsManager() {
        init();
    }

    public static XmStatisticsManager getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new XmStatisticsManager();
                }
            }
        }
        return sInstance;
    }

    private void init() {
        this.mRecord = new XmPlayRecord();
        XmPlayerControl.mPlayedDuration = 0;
    }

    private boolean statActivityNow(Track track) {
        return track != null && "radio".equals(track.getKind()) && track.getExtra();
    }

    private boolean statRadioNow(Track track) {
        return track != null && "schedule".equals(track.getKind());
    }

    private boolean statTrackNow(Track track) {
        return track != null && ("track".equals(track.getKind()) || PlayableModel.KIND_TTS.equals(track.getKind()));
    }

    private void updateXmPlayResource() {
        if (!(TextUtils.equals(this.xmCurPlayResource, this.xmUploadPlayResource) || TextUtils.isEmpty(this.xmCurPlayResource))) {
            this.xmUploadPlayResource = this.xmCurPlayResource;
        }
    }

    private void updateXmResource() {
        if (!(this.xmResourceMap == null || this.mRecord == null || !this.xmResourceMap.containsKey("tid"))) {
            this.mRecord.setTid((String) this.xmResourceMap.get("tid"));
        }
    }

    public boolean checkIsSeek(int i, int i2) {
        i2 = i - this.mCurrPos1;
        this.mCurrPos1 = i;
        if (Math.abs(i2) > 1200) {
            this.mIsSeek = true;
        } else {
            this.mIsSeek = false;
        }
        return this.mIsSeek;
    }

    public void onPlayProgress(int i, int i2, boolean z) {
        if (this.mUserOneDateListener != null) {
            this.mUserOneDateListener.onPlayProgress(i, i2, z);
        }
    }

    public void onPlayStart(int i, boolean z) {
        if (this.mUserOneDateListener != null) {
            this.mUserOneDateListener.onPlayStart(i, z);
        }
    }

    public void onPlayStop() {
        if (this.mUserOneDateListener != null) {
            this.mUserOneDateListener.onPlayStop();
        }
    }

    public void onPlayTrack(Track track, boolean z, int i, String str) {
        if (track != null && this.mRecord != null) {
            this.isShouldStatistic = true;
            long currentTimeMillis = System.currentTimeMillis();
            if (track.getDataId() != this.mRecord.getId() || (track.getDataId() == this.mRecord.getId() && XmPlayerService.getPlayerSrvice() != null && XmPlayerService.getPlayerSrvice().getXmPlayMode() == PlayMode.PLAY_MODEL_SINGLE_LOOP)) {
                this.mTotalLastBlockTime = 0;
                this.mIsKd = false;
                this.mKd = 0;
                this.blockTime1 = 0;
                this.blockTime2 = 0;
                this.mRecord.setDuration(0);
                XmPlayerControl.mPlayedDuration = 0;
                this.mRecord.setStartTime(currentTimeMillis);
                if (!TextUtils.isEmpty(str)) {
                    this.mRecord.setTrack_url(str);
                }
                StringBuilder stringBuilder;
                if ("schedule".equals(track.getKind()) || "radio".equals(track.getKind())) {
                    if (track.getExtra()) {
                        this.mRecord.setId(track.getDataId());
                        this.mRecord.setActivityId(track.getTrackActivityId());
                        this.mRecord.setIfPlayTrack(false);
                        this.mRecord.setIfPlayActivity(true);
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(track.getStartTime());
                        stringBuilder2.append("-");
                        stringBuilder2.append(track.getEndTime());
                        if (BaseUtil.isInTime(stringBuilder2.toString()) != 0) {
                            this.mRecord.setIfPlayTrack(true);
                            this.mRecord.setId(track.getDataId());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("object :track");
                            stringBuilder.append(this.mRecord.getId());
                            Logger.i("StatisticsManager", stringBuilder.toString());
                        } else {
                            if ("schedule".equals(track.getKind())) {
                                this.mRecord.setId(track.getRadioId());
                            } else if ("radio".equals(track.getKind())) {
                                this.mRecord.setId(track.getDataId());
                            }
                            this.mRecord.setIfPlayTrack(false);
                            this.mRecord.setIfPlayActivity(false);
                        }
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("object :radio");
                    stringBuilder.append(this.mRecord.getId());
                    stringBuilder.append(" isPlayTrack:");
                    stringBuilder.append(this.mRecord.isPlayTrack());
                    stringBuilder.append(" isActivity:");
                    stringBuilder.append(this.mRecord.isActivity());
                    Logger.i("StatisticsManager", stringBuilder.toString());
                } else if ("track".equals(track.getKind()) || PlayableModel.KIND_TTS.equals(track.getKind())) {
                    this.mRecord.setIfPlayTrack(true);
                    this.mRecord.setId(track.getDataId());
                    this.mRecord.setRecordKind(1);
                    if (track.getAlbum() != null) {
                        this.mRecord.setAlbumId(track.getAlbum().getAlbumId());
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("object :track");
                    stringBuilder.append(this.mRecord.getId());
                    Logger.i("StatisticsManager", stringBuilder.toString());
                } else if (PlayableModel.KIND_LIVE_FLV.equals(track.getKind())) {
                    this.mRecord.setIfPlayTrack(true);
                    this.mRecord.setId(track.getDataId());
                    this.mRecord.setLiveRoomId(track.getLiveRoomId());
                    if (track.getAnnouncer() != null) {
                        this.mRecord.setAnchorId(track.getAnnouncer().getAnnouncerId());
                    }
                    this.mRecord.setRecordKind(4);
                }
                this.mRecord.setPlayType(z ^ 1);
                if (this.upload != null && statTrackNow(track)) {
                    this.mRecord.setStatType(1);
                    this.upload.upLoadData(this.mRecord);
                } else if (this.upload != null && statRadioNow(track)) {
                    this.mRecord.setStatType(2);
                    this.upload.upLoadData(this.mRecord);
                } else if (this.upload != null && statActivityNow(track)) {
                    this.mRecord.setStatType(3);
                    this.upload.upLoadData(this.mRecord);
                }
            }
            if (this.mRecord.isPlayTrack()) {
                XmPlayerControl.mLastPostion = (long) i;
            } else {
                XmPlayerControl.mLastPostion = System.currentTimeMillis();
            }
        }
    }

    public void onSeekComplete(int i) {
        if (this.mUserOneDateListener != null) {
            this.mUserOneDateListener.onSeekComplete(i);
        }
    }

    public void onSoundSwitch() {
        if (this.mUserOneDateListener != null) {
            this.mUserOneDateListener.onSoundSwitch();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x010e A:{SYNTHETIC, Splitter:B:40:0x010e} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x010e A:{SYNTHETIC, Splitter:B:40:0x010e} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x023a  */
    /* JADX WARNING: Missing block: B:70:0x026a, code skipped:
            return;
     */
    public void onStopTrack(com.ximalaya.ting.android.opensdk.model.track.Track r21, int r22) {
        /*
        r20 = this;
        r0 = r20;
        r2 = r22;
        if (r21 == 0) goto L_0x026a;
    L_0x0006:
        r3 = r0.mRecord;
        if (r3 != 0) goto L_0x000c;
    L_0x000a:
        goto L_0x026a;
    L_0x000c:
        r3 = r0.isShouldStatistic;
        if (r3 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        r3 = 0;
        r0.isShouldStatistic = r3;
        r4 = r0.mRecord;
        r4 = r4 instanceof com.ximalaya.ting.android.opensdk.model.history.XmPlayRecord;
        if (r4 != 0) goto L_0x001b;
    L_0x001a:
        return;
    L_0x001b:
        r4 = r0.mRecord;
        r4 = r4.isPlayTrack();
        r5 = 0;
        if (r4 == 0) goto L_0x002f;
    L_0x0025:
        r4 = r0.mRecord;
        r7 = (long) r2;
        r4.setPlayedSecs(r7);
        r7 = r5;
        r9 = r7;
        goto L_0x009f;
    L_0x002f:
        r4 = new java.text.SimpleDateFormat;
        r7 = "yy:MM:dd:HH:mm";
        r8 = java.util.Locale.getDefault();
        r4.<init>(r7, r8);
        r7 = r21.getStartTime();
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 != 0) goto L_0x0086;
    L_0x0044:
        r7 = r21.getEndTime();
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 == 0) goto L_0x004f;
    L_0x004e:
        goto L_0x0086;
    L_0x004f:
        r7 = r21.getStartTime();	 Catch:{ ParseException -> 0x007e }
        r7 = r4.parse(r7);	 Catch:{ ParseException -> 0x007e }
        r7 = r7.getTime();	 Catch:{ ParseException -> 0x007e }
        r9 = java.lang.System.currentTimeMillis();	 Catch:{ ParseException -> 0x007c }
        r11 = new java.util.Date;	 Catch:{ ParseException -> 0x0080 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ ParseException -> 0x0080 }
        r11.<init>(r12);	 Catch:{ ParseException -> 0x0080 }
        r11 = r4.format(r11);	 Catch:{ ParseException -> 0x0080 }
        r4 = r4.parse(r11);	 Catch:{ ParseException -> 0x0080 }
        r11 = r4.getTime();	 Catch:{ ParseException -> 0x0080 }
        r13 = r11 - r7;
        r4 = r0.mRecord;	 Catch:{ ParseException -> 0x0080 }
        r4.setPlayedSecs(r13);	 Catch:{ ParseException -> 0x0080 }
        goto L_0x008d;
    L_0x007c:
        r9 = r5;
        goto L_0x0080;
    L_0x007e:
        r7 = r5;
        r9 = r7;
    L_0x0080:
        r4 = r0.mRecord;
        r4.setPlayedSecs(r5);
        goto L_0x008d;
    L_0x0086:
        r4 = r0.mRecord;
        r4.setPlayedSecs(r5);
        r7 = r5;
        r9 = r7;
    L_0x008d:
        r4 = r0.mRecord;
        r11 = r21.getProgramId();
        r4.setProgramId(r11);
        r4 = r0.mRecord;
        r11 = r21.getScheduleId();
        r4.setProgramScheduleId(r11);
    L_0x009f:
        r11 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.mPlayedDuration;
        r4 = (int) r11;
        r11 = r0.totalPlaySec;
        r13 = (long) r4;
        r16 = r4;
        r3 = r11 + r13;
        r0.totalPlaySec = r3;
        r3 = r0.mContext;
        r4 = "total_play_sec";
        r11 = 4;
        r3 = r3.getSharedPreferences(r4, r11);
        r4 = "listenedTimeBeforeAppraised";
        r11 = r3.getLong(r4, r5);
        r17 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = r11 * r17;
        r4 = "fjsdoifj";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r15.append(r11);
        r5 = "    ";
        r15.append(r5);
        r5 = r0.totalPlaySec;
        r15.append(r5);
        r5 = r15.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.i(r4, r5);
        r4 = r0.totalPlaySec;
        r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1));
        if (r6 <= 0) goto L_0x00fa;
    L_0x00df:
        r4 = r0.mContext;
        if (r4 == 0) goto L_0x00fa;
    L_0x00e3:
        r4 = "is_time_to_appraised";
        r5 = 0;
        r4 = r3.getBoolean(r4, r5);
        if (r4 != 0) goto L_0x00fa;
    L_0x00ec:
        r3 = r3.edit();
        r4 = "is_time_to_appraised";
        r5 = 1;
        r3 = r3.putBoolean(r4, r5);
        r3.apply();
    L_0x00fa:
        r3 = r0.mRecord;
        r3.setDuration(r13);
        r3 = r0.mRecord;
        r4 = java.lang.System.currentTimeMillis();
        r3.setSendDataTime(r4);
        r3 = 0;
        r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x012a;
    L_0x010e:
        r3 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0126 }
        r4 = "yy:MM:dd:HH:mm";
        r5 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x0126 }
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x0126 }
        r4 = r21.getEndTime();	 Catch:{ Exception -> 0x0126 }
        r3 = r3.parse(r4);	 Catch:{ Exception -> 0x0126 }
        r9 = r3.getTime();	 Catch:{ Exception -> 0x0126 }
        goto L_0x012a;
    L_0x0126:
        r9 = java.lang.System.currentTimeMillis();
    L_0x012a:
        r3 = r0.mRecord;
        r3.setEndTime(r9);
        r3 = r0.mRecord;
        r3 = r3.isPlayTrack();
        if (r3 == 0) goto L_0x0144;
    L_0x0137:
        r3 = r21.getDuration();
        if (r3 == 0) goto L_0x014f;
    L_0x013d:
        r3 = r21.getDuration();
        r3 = r16 / r3;
        goto L_0x0150;
    L_0x0144:
        r3 = r9 - r7;
        r5 = 0;
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 == 0) goto L_0x014f;
    L_0x014c:
        r13 = r13 / r3;
        r3 = (int) r13;
        goto L_0x0150;
    L_0x014f:
        r3 = 0;
    L_0x0150:
        r4 = r0.mRecord;
        r5 = (long) r3;
        r7 = r21.getDownloadSize();
        r5 = r5 * r7;
        r5 = r5 / r17;
        r4.setClientTraffic(r5);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Test statistic track onStopTrack old";
        r3.append(r4);
        r4 = r0.mRecord;
        r4 = r4.getRecSrc();
        r3.append(r4);
        r3 = r3.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.log(r3);
        r3 = r21.getRecSrc();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0194;
    L_0x0181:
        r3 = r0.mRecord;
        r4 = r21.getRecSrc();
        r3.setRecSrc(r4);
        r3 = r0.mRecord;
        r4 = r21.getRecTrack();
        r3.setRecTrack(r4);
        goto L_0x01d0;
    L_0x0194:
        r3 = r21.getAlbum();
        if (r3 == 0) goto L_0x01d0;
    L_0x019a:
        r3 = r0.mRecord;
        r4 = r21.getAlbum();
        r4 = r4.getRecSrc();
        r3.setRecSrc(r4);
        r3 = r0.mRecord;
        r4 = r21.getAlbum();
        r4 = r4.getRecTrack();
        r3.setRecTrack(r4);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Test statistic track onStopTrack new";
        r3.append(r4);
        r4 = r21.getAlbum();
        r4 = r4.getRecSrc();
        r3.append(r4);
        r3 = r3.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.log(r3);
    L_0x01d0:
        r3 = r0.mRecord;
        r1 = r21.getPlaySource();
        r3.setPlaySource(r1);
        r1 = r0.mRecordModel;
        if (r1 == 0) goto L_0x01fe;
    L_0x01dd:
        r1 = r0.mRecord;
        r3 = r0.mRecordModel;
        r3 = r3.getType();
        r1.setConnect_type(r3);
        r1 = r0.mRecord;
        r3 = r0.mRecordModel;
        r3 = r3.getDevice();
        r1.setConnect_device(r3);
        r1 = r0.mRecord;
        r3 = r0.mRecordModel;
        r3 = r3.getDeviceName();
        r1.setConnect_deviceName(r3);
    L_0x01fe:
        r1 = r0.mRecord;
        r3 = 0;
        r1.setStatType(r3);
        r1 = r0.upload;
        if (r1 != 0) goto L_0x020e;
    L_0x0208:
        r1 = com.ximalaya.ting.android.opensdk.player.statistic.OpenSdkPlayStatisticUpload.getInstance();
        r0.upload = r1;
    L_0x020e:
        r1 = "StatisticsManager";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "stop:position=";
        r3.append(r4);
        r3.append(r2);
        r4 = "durtion=";
        r3.append(r4);
        r4 = r0.mRecord;
        r4 = r4.getDuration();
        r3.append(r4);
        r3 = r3.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.i(r1, r3);
        r1 = r0.xmUploadPlayResource;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x023e;
    L_0x023a:
        r1 = r0.xmCurPlayResource;
        r0.xmUploadPlayResource = r1;
    L_0x023e:
        r1 = r0.mRecord;
        r3 = r0.mKd;
        r1.setBlockCount(r3);
        r1 = r0.mRecord;
        r3 = r0.mTotalLastBlockTime;
        r1.setBlockDuration(r3);
        r1 = r0.mRecord;
        r3 = r0.xmUploadPlayResource;
        r1.setXmUploadPlayResource(r3);
        r1 = r0.mRecord;
        r1.setStartedPosition(r2);
        r20.updateXmResource();
        r1 = r0.upload;
        r2 = r0.mRecord;
        r1.upLoadData(r2);
        r20.updateXmPlayResource();
        r1 = 0;
        com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.mPlayedDuration = r1;
        return;
    L_0x026a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.statistic.XmStatisticsManager.onStopTrack(com.ximalaya.ting.android.opensdk.model.track.Track, int):void");
    }

    public void release() {
        synchronized (sLock) {
            XmPlayerControl.mPlayedDuration = 0;
            XmPlayerControl.mLastPostion = 0;
            if (this.mUserOneDateListener != null) {
                this.mUserOneDateListener.release();
            }
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setRecordModel(RecordModel recordModel) {
        this.mRecordModel = recordModel;
    }

    public void setUploadClassName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.upload = (IXmPlayStatisticUpload) Class.forName(str).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public void setUploadHandler(IXmPlayStatisticUpload iXmPlayStatisticUpload) {
        this.upload = iXmPlayStatisticUpload;
    }

    public void setUserOneDateListener(IXmUserOneDateListener iXmUserOneDateListener) {
        this.mUserOneDateListener = iXmUserOneDateListener;
    }

    public void setmIsSeek(boolean z) {
        this.mIsSeek = z;
    }

    public void stuckStatistics(int i, int i2, int i3) {
        int i4 = i != 0 ? (i * i2) / 100 : 0;
        if (i3 > 15000 && i3 < i2 - 15000 && i > 5) {
            if (i3 >= i4) {
                this.mIsKd = true;
                if (this.mIsKd && !this.mIsSeek) {
                    this.mKd++;
                    this.blockTime1 = System.currentTimeMillis();
                }
            } else if (i3 < i4 + 3000 && this.mIsKd) {
                this.blockTime2 = System.currentTimeMillis();
                if (this.blockTime1 != 0) {
                    this.mTotalLastBlockTime += this.blockTime2 - this.blockTime1;
                    this.mIsKd = false;
                }
            }
        }
    }
}
