package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class TrackBaseInfo extends XimalayaResponse {
    @SerializedName("can_download")
    private boolean canDownload;
    @SerializedName("download_size")
    private int downloadSize;
    @SerializedName("e_download_url")
    private String downloadUrl;
    private long id;
    @SerializedName("is_fallback")
    private boolean isFallback;
    @SerializedName("play_size_24_m4a")
    private int playSize24M4a;
    @SerializedName("play_size_64_m4a")
    private int playSize64M4a;
    @SerializedName("play_size_amr")
    private int playSizeAmr;
    @SerializedName("e_play_url_24_m4a")
    private String playUrl24M4a;
    @SerializedName("e_play_url_32")
    private String playUrl32;
    @SerializedName("play_size_32")
    private int playUrl32Size;
    @SerializedName("e_play_url_64")
    private String playUrl64;
    @SerializedName("e_play_url_64_m4a")
    private String playUrl64M4a;
    @SerializedName("play_size_64")
    private int playUrl64Size;
    @SerializedName("e_play_url_amr")
    private String playUrlAmr;

    public int getDownloadSize() {
        return this.downloadSize;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public long getId() {
        return this.id;
    }

    public int getPlaySize24M4a() {
        return this.playSize24M4a;
    }

    public int getPlaySize64M4a() {
        return this.playSize64M4a;
    }

    public int getPlaySizeAmr() {
        return this.playSizeAmr;
    }

    public String getPlayUrl24M4a() {
        return this.playUrl24M4a;
    }

    public String getPlayUrl32() {
        return this.playUrl32;
    }

    public int getPlayUrl32Size() {
        return this.playUrl32Size;
    }

    public String getPlayUrl64() {
        return this.playUrl64;
    }

    public String getPlayUrl64M4a() {
        return this.playUrl64M4a;
    }

    public int getPlayUrl64Size() {
        return this.playUrl64Size;
    }

    public String getPlayUrlAmr() {
        return this.playUrlAmr;
    }

    public boolean isCanDownload() {
        return this.canDownload;
    }

    public boolean isFallback() {
        return this.isFallback;
    }

    public void setCanDownload(boolean z) {
        this.canDownload = z;
    }

    public void setDownloadSize(int i) {
        this.downloadSize = i;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setFallback(boolean z) {
        this.isFallback = z;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setPlaySize24M4a(int i) {
        this.playSize24M4a = i;
    }

    public void setPlaySize64M4a(int i) {
        this.playSize64M4a = i;
    }

    public void setPlaySizeAmr(int i) {
        this.playSizeAmr = i;
    }

    public void setPlayUrl24M4a(String str) {
        this.playUrl24M4a = str;
    }

    public void setPlayUrl32(String str) {
        this.playUrl32 = str;
    }

    public void setPlayUrl32Size(int i) {
        this.playUrl32Size = i;
    }

    public void setPlayUrl64(String str) {
        this.playUrl64 = str;
    }

    public void setPlayUrl64M4a(String str) {
        this.playUrl64M4a = str;
    }

    public void setPlayUrl64Size(int i) {
        this.playUrl64Size = i;
    }

    public void setPlayUrlAmr(String str) {
        this.playUrlAmr = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackBaseInfo{isFallback=");
        stringBuilder.append(this.isFallback);
        stringBuilder.append(", playUrl24M4a='");
        stringBuilder.append(this.playUrl24M4a);
        stringBuilder.append('\'');
        stringBuilder.append(", downloadUrl='");
        stringBuilder.append(this.downloadUrl);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
