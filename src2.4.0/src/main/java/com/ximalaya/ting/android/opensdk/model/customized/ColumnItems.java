package com.ximalaya.ting.android.opensdk.model.customized;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.model.album.SubordinatedAlbum;
import java.util.List;

public class ColumnItems extends XimalayaResponse {
    @SerializedName("subordinated_album")
    private SubordinatedAlbum album;
    @SerializedName("can_download")
    private boolean canDownload;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("channel_play_count")
    private int channelPlayCount;
    @SerializedName("content_type")
    private int contentType;
    @SerializedName("cover_url_large")
    private String coverUrlLarge;
    @SerializedName("cover_url_middle")
    private String coverUrlMiddle;
    @SerializedName("cover_url_original")
    private String coverUrlOriginal;
    @SerializedName("cover_url_small")
    private String coverUrlSmall;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("dimensions")
    private List<CustomizedDimension> dimensions;
    @SerializedName("download_size")
    private int downloadSize;
    @SerializedName("download_url")
    private String downloadUrl;
    @SerializedName("duration")
    private int duration;
    private int id;
    @SerializedName("include_track_count")
    private int includeTrackCount;
    private String intro;
    @SerializedName("is_finished")
    private int isFinished;
    private String kind;
    @SerializedName("order_num")
    private int orderNum;
    @SerializedName("play_count")
    private int playCount;
    @SerializedName("play_size_24_m4a")
    private long playSize24M4a;
    @SerializedName("play_size_32")
    private long playSize32;
    @SerializedName("play_size_64")
    private long playSize64;
    @SerializedName("play_size_64_m4a")
    private long playSize64M4;
    @SerializedName("play_url_24_m4a")
    private String playUrl24M4a;
    @SerializedName("play_url_32")
    private String playUrl32;
    @SerializedName("play_url_64")
    private String playUrl64;
    @SerializedName("play_url_64_m4a")
    private String playUrl64M4a;
    @SerializedName("publish_at")
    private long publishAt;
    @SerializedName("short_ext_info")
    private String shortExtInfo;
    private String title;
    @SerializedName("updated_at")
    private long updatedAt;

    public SubordinatedAlbum getAlbum() {
        return this.album;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getChannelPlayCount() {
        return this.channelPlayCount;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getCoverUrlLarge() {
        return this.coverUrlLarge;
    }

    public String getCoverUrlMiddle() {
        return this.coverUrlMiddle;
    }

    public String getCoverUrlOriginal() {
        return this.coverUrlOriginal;
    }

    public String getCoverUrlSmall() {
        return this.coverUrlSmall;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public List<CustomizedDimension> getDimensions() {
        return this.dimensions;
    }

    public int getDownloadSize() {
        return this.downloadSize;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getId() {
        return this.id;
    }

    public int getIncludeTrackCount() {
        return this.includeTrackCount;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getKind() {
        return this.kind;
    }

    public int getOrderNum() {
        return this.orderNum;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public long getPlaySize24M4a() {
        return this.playSize24M4a;
    }

    public long getPlaySize32() {
        return this.playSize32;
    }

    public long getPlaySize64() {
        return this.playSize64;
    }

    public long getPlaySize64M4() {
        return this.playSize64M4;
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

    public long getPublishAt() {
        return this.publishAt;
    }

    public String getShortExtInfo() {
        return this.shortExtInfo;
    }

    public String getTitle() {
        return this.title;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public boolean isCanDownload() {
        return this.canDownload;
    }

    public int isFinished() {
        return this.isFinished;
    }

    public void setAlbum(SubordinatedAlbum subordinatedAlbum) {
        this.album = subordinatedAlbum;
    }

    public void setCanDownload(boolean z) {
        this.canDownload = z;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setChannelPlayCount(int i) {
        this.channelPlayCount = i;
    }

    public void setContentType(int i) {
        this.contentType = i;
    }

    public void setCoverUrlLarge(String str) {
        this.coverUrlLarge = str;
    }

    public void setCoverUrlMiddle(String str) {
        this.coverUrlMiddle = str;
    }

    public void setCoverUrlOriginal(String str) {
        this.coverUrlOriginal = str;
    }

    public void setCoverUrlSmall(String str) {
        this.coverUrlSmall = str;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDimensions(List<CustomizedDimension> list) {
        this.dimensions = list;
    }

    public void setDownloadSize(int i) {
        this.downloadSize = i;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setFinished(int i) {
        this.isFinished = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIncludeTrackCount(int i) {
        this.includeTrackCount = i;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setOrderNum(int i) {
        this.orderNum = i;
    }

    public void setPlayCount(int i) {
        this.playCount = i;
    }

    public void setPlaySize24M4a(long j) {
        this.playSize24M4a = j;
    }

    public void setPlaySize32(long j) {
        this.playSize32 = j;
    }

    public void setPlaySize64(long j) {
        this.playSize64 = j;
    }

    public void setPlaySize64M4(long j) {
        this.playSize64M4 = j;
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

    public void setPublishAt(long j) {
        this.publishAt = j;
    }

    public void setShortExtInfo(String str) {
        this.shortExtInfo = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ColumnItems{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", kind='");
        stringBuilder.append(this.kind);
        stringBuilder.append('\'');
        stringBuilder.append(", contentType=");
        stringBuilder.append(this.contentType);
        stringBuilder.append(", orderNum=");
        stringBuilder.append(this.orderNum);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", intro='");
        stringBuilder.append(this.intro);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlOriginal='");
        stringBuilder.append(this.coverUrlOriginal);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlLarge='");
        stringBuilder.append(this.coverUrlLarge);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlMiddle='");
        stringBuilder.append(this.coverUrlMiddle);
        stringBuilder.append('\'');
        stringBuilder.append(", playCount=");
        stringBuilder.append(this.playCount);
        stringBuilder.append(", channelPlayCount=");
        stringBuilder.append(this.channelPlayCount);
        stringBuilder.append(", includeTrackCount=");
        stringBuilder.append(this.includeTrackCount);
        stringBuilder.append(", playSize32=");
        stringBuilder.append(this.playSize32);
        stringBuilder.append(", playSize64=");
        stringBuilder.append(this.playSize64);
        stringBuilder.append(", playSize24M4a=");
        stringBuilder.append(this.playSize24M4a);
        stringBuilder.append(", playSize64M4=");
        stringBuilder.append(this.playSize64M4);
        stringBuilder.append(", canDownload=");
        stringBuilder.append(this.canDownload);
        stringBuilder.append(", downloadSize=");
        stringBuilder.append(this.downloadSize);
        stringBuilder.append(", createdAt=");
        stringBuilder.append(this.createdAt);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", playUrl32='");
        stringBuilder.append(this.playUrl32);
        stringBuilder.append('\'');
        stringBuilder.append(", playUrl64='");
        stringBuilder.append(this.playUrl64);
        stringBuilder.append('\'');
        stringBuilder.append(", playUrl24M4a='");
        stringBuilder.append(this.playUrl24M4a);
        stringBuilder.append('\'');
        stringBuilder.append(", playUrl64M4a='");
        stringBuilder.append(this.playUrl64M4a);
        stringBuilder.append('\'');
        stringBuilder.append(", downloadUrl='");
        stringBuilder.append(this.downloadUrl);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
