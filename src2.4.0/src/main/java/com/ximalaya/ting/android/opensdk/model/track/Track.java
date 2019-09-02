package com.ximalaya.ting.android.opensdk.model.track;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.album.Announcer;
import com.ximalaya.ting.android.opensdk.model.album.SubordinatedAlbum;

public class Track extends PlayableModel implements Parcelable {
    public static final Creator<Track> CREATOR = new Creator<Track>() {
        public Track createFromParcel(Parcel parcel) {
            Track track = new Track();
            track.readFromParcel(parcel);
            return track;
        }

        public Track[] newArray(int i) {
            return new Track[i];
        }
    };
    public static final int TRACK_QUALITY_HIGH = 1;
    public static final int TRACK_QUALITY_HIGH_PLUS = 2;
    public static final int TRACK_QUALITY_LOSSLESS = 3;
    public static final int TRACK_QUALITY_NORMAL = 0;
    public static final int TRACK_QUALITY_SMART_MODE = 100;
    public static final int TYPE_AD = 3;
    public static final int TYPE_AUDIO_EXCHANGE = 1;
    public static final int TYPE_DUBSHOW = 4;
    public static final int TYPE_LIVE = 2;
    public static final int TYPE_UNKNOW = 0;
    public static final int VIDEO_QUALITY_HIGH = 1;
    public static final int VIDEO_QUALITY_NORMAL = 0;
    @SerializedName(alternate = {"album"}, value = "subordinated_album")
    private SubordinatedAlbum album;
    private Announcer announcer;
    @SerializedName(alternate = {"is_bought"}, value = "authorized")
    private boolean authorized;
    private int blockIndex;
    private int blockNum;
    @SerializedName(alternate = {"canDownload"}, value = "can_download")
    private boolean canDownload;
    @SerializedName(alternate = {"categoryId"}, value = "category_id")
    private int categoryId;
    private long channelId;
    private String channelName;
    private int chargeFileSize;
    @SerializedName(alternate = {"commentCount"}, value = "comment_count")
    private int commentCount;
    @SerializedName(alternate = {"cover_large_path", "coverUrlLarge"}, value = "cover_url_large")
    private String coverUrlLarge;
    @SerializedName(alternate = {"cover_middle_path", "coverUrlMiddle"}, value = "cover_url_middle")
    private String coverUrlMiddle;
    @SerializedName(alternate = {"cover_small_path", "coverSmall", "coverUrlSmall"}, value = "cover_url_small")
    private String coverUrlSmall;
    @SerializedName(alternate = {"createdAt"}, value = "created_at")
    private long createdAt;
    private double discountedPrice;
    @SerializedName(alternate = {"downloadCount"}, value = "download_count")
    private int downloadCount;
    private long downloadCreated = 0;
    private int downloadQualityLevel;
    @SerializedName(alternate = {"downloadSize"}, value = "download_size")
    private long downloadSize;
    private int downloadStatus = -2;
    private long downloadTime;
    @SerializedName(alternate = {"download_path", "downloadUrl"}, value = "download_url")
    private String downloadUrl;
    private int downloadVideoQualityLevel;
    private String downloadedSaveFilePath;
    private long downloadedSize;
    private String downloadedVideoSaveFilePath;
    private int duration;
    private String endTime;
    public boolean extraa;
    @SerializedName(alternate = {"favoriteCount"}, value = "favorite_count")
    private int favoriteCount;
    @SerializedName(alternate = {"free"}, value = "is_free")
    private boolean free;
    private boolean hasCopyRight = true;
    @SerializedName(alternate = {"hasSample"}, value = "has_sample")
    private boolean hasSample;
    private int highestQualityLevel;
    private int highestVideoQualityLevel;
    private int insertSequence;
    private boolean isAutoPaused;
    private boolean isChecked;
    private boolean isLike;
    @SerializedName(alternate = {"isPaid"}, value = "is_paid")
    private boolean isPaid;
    @SerializedName(alternate = {"isTrailer"}, value = "is_trailer")
    private boolean isTrailer;
    private boolean isVideo;
    private long liveRoomId;
    @SerializedName(alternate = {"orderNum"}, value = "order_num")
    private int orderNum = -1;
    private int orderPositionInAlbum = 0;
    private int orderPositon = -1;
    @SerializedName(alternate = {"playCount"}, value = "play_count")
    private int playCount;
    private String playPathHq;
    @SerializedName(alternate = {"playSize24M4a"}, value = "play_size_24_m4a")
    private String playSize24M4a;
    @SerializedName(alternate = {"playSize32"}, value = "play_size_32")
    private int playSize32;
    @SerializedName(alternate = {"playSize64"}, value = "play_size_64")
    private int playSize64;
    @SerializedName(alternate = {"playSize64m4a"}, value = "play_size_64_m4a")
    private String playSize64m4a;
    @SerializedName(alternate = {"playSizeAmr"}, value = "play_size_amr")
    private int playSizeAmr;
    @SerializedName(alternate = {"playSource"}, value = "play_source")
    private int playSource;
    @SerializedName(alternate = {"play_path_aac_v224", "playUrl24M4a"}, value = "play_url_24_m4a")
    private String playUrl24M4a;
    @SerializedName(alternate = {"play_path_32", "playPath32", "playUrl32"}, value = "play_url_32")
    private String playUrl32;
    @SerializedName(alternate = {"play_path_64", "playPath64"}, value = "play_url_64")
    private String playUrl64;
    @SerializedName(alternate = {"play_path_aac_v164", "playUrl64M4a"}, value = "play_url_64_m4a")
    private String playUrl64M4a;
    @SerializedName(alternate = {"playUrlAmr"}, value = "play_url_amr")
    private String playUrlAmr;
    private double price;
    private int priceTypeEnum;
    private int priceTypeId;
    private long programId;
    private int protocolVersion;
    private long radioId;
    private String radioName;
    private String radioRate24AacUrl;
    private String radioRate24TsUrl;
    private String radioRate64AacUrl;
    private String radioRate64TsUrl;
    private String recSrc;
    private String recTrack;
    @SerializedName(alternate = {"sampleDuration"}, value = "sample_duration")
    private int sampleDuration;
    private long scheduleId;
    private String sequenceId;
    private int source;
    private String startTime;
    public int templateId;
    public String templateName;
    public String templateUrl;
    private long timeline;
    private long trackActivityId;
    @SerializedName(alternate = {"trackIntro"}, value = "track_intro")
    private String trackIntro;
    private int trackQualityLevel;
    private int trackStatus = -1;
    @SerializedName(alternate = {"trackTags"}, value = "track_tags")
    private String trackTags;
    @SerializedName(alternate = {"title", "trackTitle"}, value = "track_title")
    private String trackTitle;
    @SerializedName("type")
    private int type;
    private long uid;
    private boolean updateStatus;
    @SerializedName(alternate = {"updatedAt"}, value = "updated_at")
    private long updatedAt;
    private long videoDownloadSize;
    private int videoDownloadStatus = -2;
    private String videoDownloadUrl;
    private long videoDownloadedSize;
    private int videoQualityLevel;

    public boolean canPlayTrack() {
        return this.authorized || this.sampleDuration > 0 || this.free || !this.isPaid;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public SubordinatedAlbum getAlbum() {
        return this.album;
    }

    public Announcer getAnnouncer() {
        return this.announcer == null ? new Announcer() : this.announcer;
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    public int getBlockNum() {
        return this.blockNum;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChargeFileSize() {
        return this.chargeFileSize;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getCoverUrlLarge() {
        return this.coverUrlLarge;
    }

    public String getCoverUrlMiddle() {
        return this.coverUrlMiddle;
    }

    public String getCoverUrlSmall() {
        return this.coverUrlSmall;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public int getDownloadCount() {
        return this.downloadCount;
    }

    public long getDownloadCreated() {
        return this.downloadCreated;
    }

    public int getDownloadQualityLevel() {
        return this.downloadQualityLevel;
    }

    public long getDownloadSize() {
        return this.downloadSize;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getDownloadVideoQualityLevel() {
        return this.downloadVideoQualityLevel;
    }

    public String getDownloadedSaveFilePath() {
        return this.downloadedSaveFilePath;
    }

    public long getDownloadedSize() {
        return this.downloadedSize;
    }

    public String getDownloadedVideoSaveFilePath() {
        return this.downloadedVideoSaveFilePath;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public boolean getExtra() {
        return this.extraa;
    }

    public int getFavoriteCount() {
        return this.favoriteCount;
    }

    public int getHighestQualityLevel() {
        return this.highestQualityLevel;
    }

    public int getHighestVideoQualityLevel() {
        return this.highestVideoQualityLevel;
    }

    public int getInsertSequence() {
        return this.insertSequence;
    }

    public long getLiveRoomId() {
        return this.liveRoomId;
    }

    public int getOrderNum() {
        return this.orderNum;
    }

    public int getOrderPositionInAlbum() {
        return this.orderPositionInAlbum;
    }

    public int getOrderPositon() {
        return this.orderPositon;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public String getPlayPathHq() {
        return this.playPathHq;
    }

    public String getPlaySize24M4a() {
        return this.playSize24M4a;
    }

    public int getPlaySize32() {
        return this.playSize32;
    }

    public int getPlaySize64() {
        return this.playSize64;
    }

    public String getPlaySize64m4a() {
        return this.playSize64m4a;
    }

    public int getPlaySizeAmr() {
        return this.playSizeAmr;
    }

    public int getPlaySource() {
        return this.playSource;
    }

    public String getPlayUrl24M4a() {
        return this.playUrl24M4a;
    }

    public String getPlayUrl32() {
        return this.playUrl32;
    }

    public String getPlayUrl64() {
        return this.playUrl64;
    }

    public String getPlayUrl64M4a() {
        return this.playUrl64M4a;
    }

    public String getPlayUrlAmr() {
        return this.playUrlAmr;
    }

    public double getPrice() {
        return this.price;
    }

    public int getPriceTypeEnum() {
        return this.priceTypeEnum;
    }

    public int getPriceTypeId() {
        return this.priceTypeId;
    }

    public long getProgramId() {
        return this.programId;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public long getRadioId() {
        return this.radioId;
    }

    public String getRadioName() {
        return this.radioName;
    }

    public String getRadioRate24AacUrl() {
        return this.radioRate24AacUrl;
    }

    public String getRadioRate24TsUrl() {
        return this.radioRate24TsUrl;
    }

    public String getRadioRate64AacUrl() {
        return this.radioRate64AacUrl;
    }

    public String getRadioRate64TsUrl() {
        return this.radioRate64TsUrl;
    }

    public String getRecSrc() {
        return this.recSrc;
    }

    public String getRecTrack() {
        return this.recTrack;
    }

    public int getSampleDuration() {
        return this.sampleDuration;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public String getSequenceId() {
        return this.sequenceId;
    }

    public int getSource() {
        return this.source;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getTemplateUrl() {
        return this.templateUrl;
    }

    public long getTimeline() {
        return this.timeline;
    }

    public long getTrackActivityId() {
        return this.trackActivityId;
    }

    public String getTrackIntro() {
        return this.trackIntro;
    }

    public int getTrackQualityLevel() {
        return this.trackQualityLevel;
    }

    public int getTrackStatus() {
        return this.trackStatus;
    }

    public String getTrackTags() {
        return this.trackTags;
    }

    public String getTrackTitle() {
        return this.trackTitle;
    }

    public int getType() {
        return this.type;
    }

    public long getUid() {
        return this.uid;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getValidCover() {
        return !TextUtils.isEmpty(this.coverUrlLarge) ? this.coverUrlLarge : !TextUtils.isEmpty(this.coverUrlMiddle) ? this.coverUrlMiddle : !TextUtils.isEmpty(this.coverUrlSmall) ? this.coverUrlSmall : "";
    }

    public long getVideoDownloadSize() {
        return this.videoDownloadSize;
    }

    public int getVideoDownloadStatus() {
        return this.videoDownloadStatus;
    }

    public String getVideoDownloadUrl() {
        return this.videoDownloadUrl;
    }

    public long getVideoDownloadedSize() {
        return this.videoDownloadedSize;
    }

    public int getVideoQualityLevel() {
        return this.videoQualityLevel;
    }

    public boolean isAudition() {
        return !this.authorized && this.sampleDuration > 0 && isPayTrack();
    }

    public boolean isAuthorized() {
        return this.authorized;
    }

    public boolean isAutoPaused() {
        return this.isAutoPaused;
    }

    public boolean isCanDownload() {
        return this.canDownload;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isFree() {
        return this.free;
    }

    public boolean isHasCopyRight() {
        return this.hasCopyRight;
    }

    public boolean isHasSample() {
        return this.hasSample;
    }

    public boolean isLike() {
        return this.isLike;
    }

    public boolean isPaid() {
        return this.isPaid;
    }

    public boolean isPayTrack() {
        return !this.free && this.isPaid;
    }

    public boolean isTrailer() {
        return this.isTrailer;
    }

    public boolean isUpdateStatus() {
        return this.updateStatus;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public boolean needSaveHistory() {
        return this.type != 4;
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.trackTitle = parcel.readString();
        this.trackTags = parcel.readString();
        this.trackIntro = parcel.readString();
        this.coverUrlSmall = parcel.readString();
        this.coverUrlMiddle = parcel.readString();
        this.coverUrlLarge = parcel.readString();
        this.announcer = (Announcer) parcel.readParcelable(Announcer.class.getClassLoader());
        this.duration = parcel.readInt();
        this.playCount = parcel.readInt();
        this.favoriteCount = parcel.readInt();
        this.commentCount = parcel.readInt();
        this.downloadCount = parcel.readInt();
        this.playUrl32 = parcel.readString();
        this.playSize32 = parcel.readInt();
        this.playUrl64 = parcel.readString();
        this.playSize64 = parcel.readInt();
        this.playUrl24M4a = parcel.readString();
        this.playSize24M4a = parcel.readString();
        this.playUrl64M4a = parcel.readString();
        this.playSize64m4a = parcel.readString();
        this.orderNum = parcel.readInt();
        this.downloadUrl = parcel.readString();
        this.downloadSize = parcel.readLong();
        this.downloadedSize = parcel.readLong();
        this.album = (SubordinatedAlbum) parcel.readParcelable(SubordinatedAlbum.class.getClassLoader());
        this.source = parcel.readInt();
        this.updatedAt = parcel.readLong();
        this.createdAt = parcel.readLong();
        this.downloadedSaveFilePath = parcel.readString();
        this.startTime = parcel.readString();
        this.endTime = parcel.readString();
        this.scheduleId = parcel.readLong();
        this.radioRate24AacUrl = parcel.readString();
        this.radioRate24TsUrl = parcel.readString();
        this.radioRate64AacUrl = parcel.readString();
        this.radioRate64TsUrl = parcel.readString();
        this.programId = parcel.readLong();
        this.radioId = parcel.readLong();
        boolean z = false;
        this.isLike = parcel.readInt() == 1;
        this.isAutoPaused = parcel.readInt() == 1;
        this.radioName = parcel.readString();
        this.playSource = parcel.readInt();
        this.timeline = parcel.readLong();
        this.sequenceId = parcel.readString();
        this.playPathHq = parcel.readString();
        this.free = parcel.readInt() == 1;
        this.authorized = parcel.readInt() == 1;
        this.isPaid = parcel.readInt() == 1;
        this.price = parcel.readDouble();
        this.discountedPrice = parcel.readDouble();
        this.priceTypeId = parcel.readInt();
        this.sampleDuration = parcel.readInt();
        this.priceTypeEnum = parcel.readInt();
        this.trackActivityId = parcel.readLong();
        this.extraa = parcel.readInt() == 1;
        this.liveRoomId = parcel.readLong();
        this.playUrlAmr = parcel.readString();
        this.playSizeAmr = parcel.readInt();
        this.hasCopyRight = parcel.readInt() == 1;
        this.updateStatus = parcel.readInt() == 1;
        this.channelId = parcel.readLong();
        this.channelName = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.isVideo = z;
        this.recSrc = parcel.readString();
        this.recTrack = parcel.readString();
        this.type = parcel.readInt();
    }

    public void setAlbum(SubordinatedAlbum subordinatedAlbum) {
        this.album = subordinatedAlbum;
    }

    public void setAnnouncer(Announcer announcer) {
        this.announcer = announcer;
    }

    public void setAuthorized(boolean z) {
        this.authorized = z;
    }

    public void setAutoPaused(boolean z) {
        this.isAutoPaused = z;
    }

    public void setBlockIndex(int i) {
        this.blockIndex = i;
    }

    public void setBlockNum(int i) {
        this.blockNum = i;
    }

    public void setCanDownload(boolean z) {
        this.canDownload = z;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setChargeFileSize(int i) {
        this.chargeFileSize = i;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setCommentCount(int i) {
        this.commentCount = i;
    }

    public void setCoverUrlLarge(String str) {
        this.coverUrlLarge = str;
    }

    public void setCoverUrlMiddle(String str) {
        this.coverUrlMiddle = str;
    }

    public void setCoverUrlSmall(String str) {
        this.coverUrlSmall = str;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDiscountedPrice(double d) {
        this.discountedPrice = d;
    }

    public void setDownloadCount(int i) {
        this.downloadCount = i;
    }

    public void setDownloadCreated(long j) {
        this.downloadCreated = j;
    }

    public void setDownloadQualityLevel(int i) {
        this.downloadQualityLevel = i;
    }

    public void setDownloadSize(long j) {
        if (j != 0) {
            this.downloadSize = j;
        }
    }

    public void setDownloadSizeForDownload(long j) {
        this.downloadSize = j;
    }

    public void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setDownloadVideoQualityLevel(int i) {
        this.downloadVideoQualityLevel = i;
    }

    public void setDownloadedSaveFilePath(String str) {
        this.downloadedSaveFilePath = str;
    }

    public void setDownloadedSize(long j) {
        this.downloadedSize = j;
    }

    public void setDownloadedVideoSaveFilePath(String str) {
        this.downloadedVideoSaveFilePath = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setExtra(boolean z) {
        this.extraa = z;
    }

    public void setFavoriteCount(int i) {
        this.favoriteCount = i;
    }

    public void setFree(boolean z) {
        this.free = z;
    }

    public void setHasCopyRight(boolean z) {
        this.hasCopyRight = z;
    }

    public void setHasSample(boolean z) {
        this.hasSample = z;
    }

    public void setHighestQualityLevel(int i) {
        this.highestQualityLevel = i;
    }

    public void setHighestVideoQualityLevel(int i) {
        this.highestVideoQualityLevel = i;
    }

    public void setInsertSequence(int i) {
        this.insertSequence = i;
    }

    public void setLike(boolean z) {
        this.isLike = z;
    }

    public void setLiveRoomId(long j) {
        this.liveRoomId = j;
    }

    public void setOrderNum(int i) {
        this.orderNum = i;
    }

    public void setOrderPositionInAlbum(int i) {
        this.orderPositionInAlbum = i;
    }

    public void setOrderPositon(int i) {
        this.orderPositon = i;
    }

    public void setPaid(boolean z) {
        this.isPaid = z;
    }

    public void setPlayCount(int i) {
        this.playCount = i;
    }

    public void setPlayPathHq(String str) {
        this.playPathHq = str;
    }

    public void setPlaySize24M4a(String str) {
        this.playSize24M4a = str;
    }

    public void setPlaySize32(int i) {
        this.playSize32 = i;
    }

    public void setPlaySize64(int i) {
        this.playSize64 = i;
    }

    public void setPlaySize64m4a(String str) {
        this.playSize64m4a = str;
    }

    public void setPlaySizeAmr(int i) {
        this.playSizeAmr = i;
    }

    public void setPlaySource(int i) {
        this.playSource = i;
    }

    public void setPlayUrl24M4a(String str) {
        this.playUrl24M4a = str;
    }

    public void setPlayUrl32(String str) {
        this.playUrl32 = str;
    }

    public void setPlayUrl64(String str) {
        this.playUrl64 = str;
    }

    public void setPlayUrl64M4a(String str) {
        this.playUrl64M4a = str;
    }

    public void setPlayUrlAmr(String str) {
        this.playUrlAmr = str;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public void setPriceTypeEnum(int i) {
        this.priceTypeEnum = i;
    }

    public void setPriceTypeId(int i) {
        this.priceTypeId = i;
    }

    public void setProgramId(long j) {
        this.programId = j;
    }

    public void setProtocolVersion(int i) {
        this.protocolVersion = i;
    }

    public void setRadioId(long j) {
        this.radioId = j;
    }

    public void setRadioName(String str) {
        this.radioName = str;
    }

    public void setRadioRate24AacUrl(String str) {
        this.radioRate24AacUrl = str;
    }

    public void setRadioRate24TsUrl(String str) {
        this.radioRate24TsUrl = str;
    }

    public void setRadioRate64AacUrl(String str) {
        this.radioRate64AacUrl = str;
    }

    public void setRadioRate64TsUrl(String str) {
        this.radioRate64TsUrl = str;
    }

    public void setRecSrc(String str) {
        this.recSrc = str;
    }

    public void setRecTrack(String str) {
        this.recTrack = str;
    }

    public void setSampleDuration(int i) {
        this.sampleDuration = i;
    }

    public void setScheduleId(long j) {
        this.scheduleId = j;
    }

    public void setSequenceId(String str) {
        this.sequenceId = str;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTemplateId(int i) {
        this.templateId = i;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
    }

    public void setTemplateUrl(String str) {
        this.templateUrl = str;
    }

    public void setTimeline(long j) {
        this.timeline = j;
    }

    public void setTrackActivityId(long j) {
        this.trackActivityId = j;
    }

    public void setTrackIntro(String str) {
        this.trackIntro = str;
    }

    public void setTrackQualityLevel(int i) {
        this.trackQualityLevel = i;
    }

    public void setTrackStatus(int i) {
        this.trackStatus = i;
    }

    public void setTrackTags(String str) {
        this.trackTags = str;
    }

    public void setTrackTitle(String str) {
        this.trackTitle = str;
    }

    public void setTrailer(boolean z) {
        this.isTrailer = z;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void setUpdateStatus(boolean z) {
        this.updateStatus = z;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public void setVideo(boolean z) {
        this.isVideo = z;
    }

    public void setVideoDownloadSize(long j) {
        this.videoDownloadSize = j;
    }

    public void setVideoDownloadStatus(int i) {
        this.videoDownloadStatus = i;
    }

    public void setVideoDownloadUrl(String str) {
        this.videoDownloadUrl = str;
    }

    public void setVideoDownloadedSize(long j) {
        this.videoDownloadedSize = j;
    }

    public void setVideoQualityLevel(int i) {
        this.videoQualityLevel = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Track{");
        stringBuilder.append(super.toString());
        stringBuilder.append("trackTitle='");
        stringBuilder.append(this.trackTitle);
        stringBuilder.append('\'');
        stringBuilder.append(", trackTags='");
        stringBuilder.append(this.trackTags);
        stringBuilder.append('\'');
        stringBuilder.append(", trackIntro='");
        stringBuilder.append(this.trackIntro);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlSmall='");
        stringBuilder.append(this.coverUrlSmall);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlMiddle='");
        stringBuilder.append(this.coverUrlMiddle);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlLarge='");
        stringBuilder.append(this.coverUrlLarge);
        stringBuilder.append('\'');
        stringBuilder.append(", announcer=");
        stringBuilder.append(this.announcer);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", playCount=");
        stringBuilder.append(this.playCount);
        stringBuilder.append(", favoriteCount=");
        stringBuilder.append(this.favoriteCount);
        stringBuilder.append(", commentCount=");
        stringBuilder.append(this.commentCount);
        stringBuilder.append(", downloadCount=");
        stringBuilder.append(this.downloadCount);
        stringBuilder.append(", playUrl32='");
        stringBuilder.append(this.playUrl32);
        stringBuilder.append('\'');
        stringBuilder.append(", playSize32=");
        stringBuilder.append(this.playSize32);
        stringBuilder.append(", playUrl64='");
        stringBuilder.append(this.playUrl64);
        stringBuilder.append('\'');
        stringBuilder.append(", playSize64=");
        stringBuilder.append(this.playSize64);
        stringBuilder.append(", playUrl24M4a='");
        stringBuilder.append(this.playUrl24M4a);
        stringBuilder.append('\'');
        stringBuilder.append(", playSize24M4a='");
        stringBuilder.append(this.playSize24M4a);
        stringBuilder.append('\'');
        stringBuilder.append(", playUrl64M4a='");
        stringBuilder.append(this.playUrl64M4a);
        stringBuilder.append('\'');
        stringBuilder.append(", playSize64m4a='");
        stringBuilder.append(this.playSize64m4a);
        stringBuilder.append('\'');
        stringBuilder.append(", orderNum=");
        stringBuilder.append(this.orderNum);
        stringBuilder.append(", orderPositon=");
        stringBuilder.append(this.orderPositon);
        stringBuilder.append(", downloadTime=");
        stringBuilder.append(this.downloadTime);
        stringBuilder.append(", downloadUrl='");
        stringBuilder.append(this.downloadUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", downloadSize=");
        stringBuilder.append(this.downloadSize);
        stringBuilder.append(", source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", album=");
        stringBuilder.append(this.album);
        stringBuilder.append(", createdAt=");
        stringBuilder.append(this.createdAt);
        stringBuilder.append(", playSource=");
        stringBuilder.append(this.playSource);
        stringBuilder.append(", downloadedSaveFilePath='");
        stringBuilder.append(this.downloadedSaveFilePath);
        stringBuilder.append('\'');
        stringBuilder.append(", downloadedSize=");
        stringBuilder.append(this.downloadedSize);
        stringBuilder.append(", trackStatus=");
        stringBuilder.append(this.trackStatus);
        stringBuilder.append(", downloadStatus=");
        stringBuilder.append(this.downloadStatus);
        stringBuilder.append(", sequenceId='");
        stringBuilder.append(this.sequenceId);
        stringBuilder.append('\'');
        stringBuilder.append(", isAutoPaused=");
        stringBuilder.append(this.isAutoPaused);
        stringBuilder.append(", insertSequence=");
        stringBuilder.append(this.insertSequence);
        stringBuilder.append(", timeline=");
        stringBuilder.append(this.timeline);
        stringBuilder.append(", downloadCreated=");
        stringBuilder.append(this.downloadCreated);
        stringBuilder.append(", extra=");
        stringBuilder.append(this.extraa);
        stringBuilder.append(", startTime='");
        stringBuilder.append(this.startTime);
        stringBuilder.append('\'');
        stringBuilder.append(", endTime='");
        stringBuilder.append(this.endTime);
        stringBuilder.append('\'');
        stringBuilder.append(", scheduleId=");
        stringBuilder.append(this.scheduleId);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", radioId=");
        stringBuilder.append(this.radioId);
        stringBuilder.append(", price=");
        stringBuilder.append(this.price);
        stringBuilder.append(", discountedPrice=");
        stringBuilder.append(this.discountedPrice);
        stringBuilder.append(", free=");
        stringBuilder.append(this.free);
        stringBuilder.append(", authorized=");
        stringBuilder.append(this.authorized);
        stringBuilder.append(", isPaid=");
        stringBuilder.append(this.isPaid);
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", priceTypeId=");
        stringBuilder.append(this.priceTypeId);
        stringBuilder.append(", blockIndex=");
        stringBuilder.append(this.blockIndex);
        stringBuilder.append(", blockNum=");
        stringBuilder.append(this.blockNum);
        stringBuilder.append(", protocolVersion=");
        stringBuilder.append(this.protocolVersion);
        stringBuilder.append(", chargeFileSize=");
        stringBuilder.append(this.chargeFileSize);
        stringBuilder.append(", sampleDuration=");
        stringBuilder.append(this.sampleDuration);
        stringBuilder.append(", canDownload=");
        stringBuilder.append(this.canDownload);
        stringBuilder.append(", radioName='");
        stringBuilder.append(this.radioName);
        stringBuilder.append('\'');
        stringBuilder.append(", radioRate24AacUrl='");
        stringBuilder.append(this.radioRate24AacUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", radioRate24TsUrl='");
        stringBuilder.append(this.radioRate24TsUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", radioRate64AacUrl='");
        stringBuilder.append(this.radioRate64AacUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", radioRate64TsUrl='");
        stringBuilder.append(this.radioRate64TsUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", isLike=");
        stringBuilder.append(this.isLike);
        stringBuilder.append(", playPathHq='");
        stringBuilder.append(this.playPathHq);
        stringBuilder.append('\'');
        stringBuilder.append(", priceTypeEnum='");
        stringBuilder.append(this.priceTypeEnum);
        stringBuilder.append('\'');
        stringBuilder.append(", trackActivityId='");
        stringBuilder.append(this.trackActivityId);
        stringBuilder.append('\'');
        stringBuilder.append(", liveRoomId='");
        stringBuilder.append(this.liveRoomId);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.trackTitle);
        parcel.writeString(this.trackTags);
        parcel.writeString(this.trackIntro);
        parcel.writeString(this.coverUrlSmall);
        parcel.writeString(this.coverUrlMiddle);
        parcel.writeString(this.coverUrlLarge);
        parcel.writeParcelable(this.announcer, i);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.playCount);
        parcel.writeInt(this.favoriteCount);
        parcel.writeInt(this.commentCount);
        parcel.writeInt(this.downloadCount);
        parcel.writeString(this.playUrl32);
        parcel.writeInt(this.playSize32);
        parcel.writeString(this.playUrl64);
        parcel.writeInt(this.playSize64);
        parcel.writeString(this.playUrl24M4a);
        parcel.writeString(this.playSize24M4a);
        parcel.writeString(this.playUrl64M4a);
        parcel.writeString(this.playSize64m4a);
        parcel.writeInt(this.orderNum);
        parcel.writeString(this.downloadUrl);
        parcel.writeLong(this.downloadSize);
        parcel.writeLong(this.downloadedSize);
        parcel.writeParcelable(this.album, i);
        parcel.writeInt(this.source);
        parcel.writeLong(this.updatedAt);
        parcel.writeLong(this.createdAt);
        parcel.writeString(this.downloadedSaveFilePath);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeLong(this.scheduleId);
        parcel.writeString(this.radioRate24AacUrl);
        parcel.writeString(this.radioRate24TsUrl);
        parcel.writeString(this.radioRate64AacUrl);
        parcel.writeString(this.radioRate64TsUrl);
        parcel.writeLong(this.programId);
        parcel.writeLong(this.radioId);
        parcel.writeInt(this.isLike);
        parcel.writeInt(this.isAutoPaused);
        parcel.writeString(this.radioName);
        parcel.writeInt(this.playSource);
        parcel.writeLong(this.timeline);
        parcel.writeString(this.sequenceId);
        parcel.writeString(this.playPathHq);
        parcel.writeInt(this.free);
        parcel.writeInt(this.authorized);
        parcel.writeInt(this.isPaid);
        parcel.writeDouble(this.price);
        parcel.writeDouble(this.discountedPrice);
        parcel.writeInt(this.priceTypeId);
        parcel.writeInt(this.sampleDuration);
        parcel.writeInt(this.priceTypeEnum);
        parcel.writeLong(this.trackActivityId);
        parcel.writeInt(this.extraa);
        parcel.writeLong(this.liveRoomId);
        parcel.writeString(this.playUrlAmr);
        parcel.writeInt(this.playSizeAmr);
        parcel.writeInt(this.hasCopyRight);
        parcel.writeInt(this.updateStatus);
        parcel.writeLong(this.channelId);
        parcel.writeString(this.channelName);
        parcel.writeInt(this.isVideo);
        parcel.writeString(this.recSrc);
        parcel.writeString(this.recTrack);
        parcel.writeInt(this.type);
    }
}
