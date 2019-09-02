package com.ximalaya.ting.android.opensdk.model.customized;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CustomizedSearch {
    private int categoryId;
    @SerializedName("channel_play_count")
    private int channelPlayCount;
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
    private long id;
    @SerializedName("include_track_count")
    private int includeTrackCount;
    private String intro;
    @SerializedName("is_finished")
    private int isFinished;
    @SerializedName("is_paid")
    private int isPaid;
    @SerializedName("play_count")
    private int playCount;
    @SerializedName("publish_at")
    private long publishAt;
    private String title;
    @SerializedName("updated_at")
    private long updatedAt;

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getChannelPlayCount() {
        return this.channelPlayCount;
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

    public long getId() {
        return this.id;
    }

    public int getIncludeTrackCount() {
        return this.includeTrackCount;
    }

    public String getIntro() {
        return this.intro;
    }

    public int getIsFinished() {
        return this.isFinished;
    }

    public int getIsPaid() {
        return this.isPaid;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public long getPublishAt() {
        return this.publishAt;
    }

    public String getTitle() {
        return this.title;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setChannelPlayCount(int i) {
        this.channelPlayCount = i;
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

    public void setId(long j) {
        this.id = j;
    }

    public void setIncludeTrackCount(int i) {
        this.includeTrackCount = i;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIsFinished(int i) {
        this.isFinished = i;
    }

    public void setIsPaid(int i) {
        this.isPaid = i;
    }

    public void setPlayCount(int i) {
        this.playCount = i;
    }

    public void setPublishAt(long j) {
        this.publishAt = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }
}
