package com.ximalaya.ting.android.opensdk.player.advertis;

import com.google.gson.annotations.SerializedName;

public class XmAdsRecord {
    private long adItemId;
    private int adSource;
    private String androidId;
    private String appKey;
    private int appid;
    private int categoryId;
    private int frames;
    private int keywordId;
    private String logType = "soundShow";
    private String positionName = "sound_patch";
    private String radioId;
    @SerializedName("rec_src")
    private String recSrc;
    @SerializedName("rec_track")
    private String recTrack;
    private long responseId;
    private int showPlace;
    private String showToken;
    private int showType;
    private int subcategoryId;
    private long time;
    private long trackId;
    private String version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.responseId == ((XmAdsRecord) obj).responseId;
    }

    public long getAdItemId() {
        return this.adItemId;
    }

    public int getAdSource() {
        return this.adSource;
    }

    public String getAndroidId() {
        return this.androidId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public int getAppid() {
        return this.appid;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getFrames() {
        return this.frames;
    }

    public int getKeywordId() {
        return this.keywordId;
    }

    public String getLogType() {
        return this.logType;
    }

    public String getPositionName() {
        return this.positionName;
    }

    public String getRadioId() {
        return this.radioId;
    }

    public String getRecSrc() {
        return this.recSrc;
    }

    public String getRecTrack() {
        return this.recTrack;
    }

    public long getResponseId() {
        return this.responseId;
    }

    public int getShowPlace() {
        return this.showPlace;
    }

    public String getShowToken() {
        return this.showToken;
    }

    public int getShowType() {
        return this.showType;
    }

    public int getSubcategoryId() {
        return this.subcategoryId;
    }

    public long getTime() {
        return this.time;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return 31 + ((int) (this.responseId ^ (this.responseId >>> 32)));
    }

    public void setAdItemId(long j) {
        this.adItemId = j;
    }

    public void setAdSource(int i) {
        this.adSource = i;
    }

    public void setAndroidId(String str) {
        this.androidId = str;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setAppid(int i) {
        this.appid = i;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setFrames(int i) {
        this.frames = i;
    }

    public void setKeywordId(int i) {
        this.keywordId = i;
    }

    public void setLogType(String str) {
        this.logType = str;
    }

    public void setPositionName(String str) {
        this.positionName = str;
    }

    public void setRadioId(String str) {
        this.radioId = str;
    }

    public void setRecSrc(String str) {
        this.recSrc = str;
    }

    public void setRecTrack(String str) {
        this.recTrack = str;
    }

    public void setResponseId(long j) {
        this.responseId = j;
    }

    public void setShowPlace(int i) {
        this.showPlace = i;
    }

    public void setShowToken(String str) {
        this.showToken = str;
    }

    public void setShowType(int i) {
        this.showType = i;
    }

    public void setSubcategoryId(int i) {
        this.subcategoryId = i;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTrackId(long j) {
        this.trackId = j;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
