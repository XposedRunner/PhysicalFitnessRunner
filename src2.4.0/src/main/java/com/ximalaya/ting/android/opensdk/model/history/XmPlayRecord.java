package com.ximalaya.ting.android.opensdk.model.history;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class XmPlayRecord extends XimalayaResponse {
    public static final int DEPRECATED_OLD_TYPE = 0;
    public static final int PLAY_TYPE_LOCAL = 1;
    public static final int PLAY_TYPE_ONLINE = 0;
    public static final int RECORD_ACTIVITY_LIVE = 3;
    public static final int RECORD_ANCHOR_LIVE = 4;
    public static final int RECORD_RADIO = 2;
    public static final int RECORD_TRACK = 1;
    private long activityId;
    private long albumId;
    private long anchorId;
    private String audio_url;
    private int blockCount;
    private long blockDuration;
    private int breakSecond;
    private int connect_device;
    private String connect_deviceName;
    private int connect_type;
    private boolean isActivity;
    private boolean isPlayTrack;
    private long liveRoomId;
    private long loadingMillisecond;
    private String mAppId;
    private String mBundleId;
    private long mClientTraffic;
    private String mDeviceId;
    private float mDuration;
    private long mEndTime;
    private long mId;
    private String mOSType = "android";
    private int mPlaySource = 25;
    private int mPlayType;
    private float mPlayedSecs;
    private String mRecSrc;
    private String mRecTrack;
    private String mSDKVersion = "1.0";
    private long mSendDataTime;
    private long mStartTime;
    private int mStartedPosition;
    private String mTraceId;
    private long materialId;
    private boolean playBackProgress;
    private String playUrl;
    @Deprecated
    private String play_type;
    private long programId;
    private long programScheduleId;
    private int recordKind;
    private String res_id;
    private long screenOffMillisecond;
    private boolean screenPlay;
    private int statType;
    private String tid;
    private String track_url;
    private String xmUploadPlayResource;

    public long getActivityId() {
        return this.activityId;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public long getAnchorId() {
        return this.anchorId;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAudio_url() {
        return this.audio_url;
    }

    public int getBlockCount() {
        return this.blockCount;
    }

    public long getBlockDuration() {
        return this.blockDuration;
    }

    public int getBreakSecond() {
        return this.breakSecond;
    }

    public String getBundleId() {
        return this.mBundleId;
    }

    public long getClientTraffic() {
        return this.mClientTraffic;
    }

    public int getConnect_device() {
        return this.connect_device;
    }

    public String getConnect_deviceName() {
        return this.connect_deviceName;
    }

    public int getConnect_type() {
        return this.connect_type;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public long getId() {
        return this.mId;
    }

    public long getLiveRoomId() {
        return this.liveRoomId;
    }

    public long getLoadingMillisecond() {
        return this.loadingMillisecond;
    }

    public long getMaterialId() {
        return this.materialId;
    }

    public String getOSType() {
        return this.mOSType;
    }

    public int getPlaySource() {
        return this.mPlaySource;
    }

    public int getPlayType() {
        return this.mPlayType;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    @Deprecated
    public String getPlay_type() {
        return this.play_type;
    }

    public float getPlayedSecs() {
        return this.mPlayedSecs;
    }

    public long getProgramId() {
        return this.programId;
    }

    public long getProgramScheduleId() {
        return this.programScheduleId;
    }

    public String getRecSrc() {
        return this.mRecSrc;
    }

    public String getRecTrack() {
        return this.mRecTrack;
    }

    public int getRecordKind() {
        return this.recordKind;
    }

    public String getRes_id() {
        return this.res_id;
    }

    public String getSDKVersion() {
        return this.mSDKVersion;
    }

    public long getScreenOffMillisecond() {
        return this.screenOffMillisecond;
    }

    public long getSendDataTime() {
        return this.mSendDataTime;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public int getStartedPosition() {
        return this.mStartedPosition;
    }

    public int getStatType() {
        return this.statType;
    }

    public String getTid() {
        return this.tid;
    }

    public String getTrack_url() {
        return this.track_url;
    }

    public String getXmUploadPlayResource() {
        return this.xmUploadPlayResource;
    }

    public String getmTraceId() {
        return this.mTraceId;
    }

    public boolean isActivity() {
        return this.isActivity;
    }

    public boolean isPlayBackProgress() {
        return this.playBackProgress;
    }

    public boolean isPlayTrack() {
        return this.isPlayTrack;
    }

    public boolean isScreenPlay() {
        return this.screenPlay;
    }

    public void setActivityId(long j) {
        this.activityId = j;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setAudio_url(String str) {
        this.audio_url = str;
    }

    public void setBlockCount(int i) {
        this.blockCount = i;
    }

    public void setBlockDuration(long j) {
        this.blockDuration = j;
    }

    public void setBreakSecond(int i) {
        this.breakSecond = i;
    }

    public void setBundleId(String str) {
        this.mBundleId = str;
    }

    public void setClientTraffic(long j) {
        this.mClientTraffic = j;
    }

    public void setConnect_device(int i) {
        this.connect_device = i;
    }

    public void setConnect_deviceName(String str) {
        this.connect_deviceName = str;
    }

    public void setConnect_type(int i) {
        this.connect_type = i;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setDuration(long j) {
        this.mDuration = ((float) j) / 1000.0f;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setIfPlayActivity(boolean z) {
        this.isActivity = z;
    }

    public void setIfPlayTrack(boolean z) {
        this.isPlayTrack = z;
    }

    public void setLiveRoomId(long j) {
        this.liveRoomId = j;
    }

    public void setLoadingMillisecond(long j) {
        this.loadingMillisecond = j;
    }

    public void setMaterialId(long j) {
        this.materialId = j;
    }

    public void setOSType(String str) {
        this.mOSType = str;
    }

    public void setPlayBackProgress(boolean z) {
        this.playBackProgress = z;
    }

    public void setPlaySource(int i) {
        this.mPlaySource = i;
    }

    public void setPlayType(int i) {
        this.mPlayType = i;
    }

    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    @Deprecated
    public void setPlay_type(String str) {
        this.play_type = str;
    }

    public void setPlayedSecs(long j) {
        this.mPlayedSecs = ((float) j) / 1000.0f;
    }

    public void setProgramId(long j) {
        this.programId = j;
    }

    public void setProgramScheduleId(long j) {
        this.programScheduleId = j;
    }

    public void setRecSrc(String str) {
        this.mRecSrc = str;
    }

    public void setRecTrack(String str) {
        this.mRecTrack = str;
    }

    public void setRecordKind(int i) {
        this.recordKind = i;
    }

    public void setRes_id(String str) {
        this.res_id = str;
    }

    public void setSDKVersion(String str) {
        this.mSDKVersion = str;
    }

    public void setScreenOffMillisecond(long j) {
        this.screenOffMillisecond = j;
    }

    public void setScreenPlay(boolean z) {
        this.screenPlay = z;
    }

    public void setSendDataTime(long j) {
        this.mSendDataTime = j;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setStartedPosition(int i) {
        this.mStartedPosition = i;
    }

    public void setStatType(int i) {
        this.statType = i;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setTrack_url(String str) {
        this.track_url = str;
    }

    public void setXmUploadPlayResource(String str) {
        this.xmUploadPlayResource = str;
    }

    public void setmTraceId(String str) {
        this.mTraceId = str;
    }
}
