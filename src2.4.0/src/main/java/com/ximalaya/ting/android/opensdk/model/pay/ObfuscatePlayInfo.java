package com.ximalaya.ting.android.opensdk.model.pay;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class ObfuscatePlayInfo extends XimalayaResponse {
    private int albumId;
    private String apiVersion;
    private String buyKey;
    private String domain;
    private int duration;
    private String ep;
    private String fileId;
    private boolean isAuthorized;
    private String k1;
    private String k2;
    private int sampleDuration;
    private int sampleLength;
    private int seed;
    private String title;
    private int totalLength;
    private int trackId;
    private int uid;

    public int getAlbumId() {
        return this.albumId;
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public String getBuyKey() {
        return this.buyKey;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getEp() {
        return this.ep;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getK1() {
        return this.k1;
    }

    public String getK2() {
        return this.k2;
    }

    public int getSampleDuration() {
        return this.sampleDuration;
    }

    public int getSampleLength() {
        return this.sampleLength;
    }

    public int getSeed() {
        return this.seed;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTotalLength() {
        return this.totalLength;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public int getUid() {
        return this.uid;
    }

    public boolean isIsAuthorized() {
        return this.isAuthorized;
    }

    public void setAlbumId(int i) {
        this.albumId = i;
    }

    public void setApiVersion(String str) {
        this.apiVersion = str;
    }

    public void setBuyKey(String str) {
        this.buyKey = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setEp(String str) {
        this.ep = str;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setIsAuthorized(boolean z) {
        this.isAuthorized = z;
    }

    public void setK1(String str) {
        this.k1 = str;
    }

    public void setK2(String str) {
        this.k2 = str;
    }

    public void setSampleDuration(int i) {
        this.sampleDuration = i;
    }

    public void setSampleLength(int i) {
        this.sampleLength = i;
    }

    public void setSeed(int i) {
        this.seed = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalLength(int i) {
        this.totalLength = i;
    }

    public void setTrackId(int i) {
        this.trackId = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }
}
