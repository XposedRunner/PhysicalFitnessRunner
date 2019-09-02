package com.ximalaya.ting.android.player.cdn;

public class CdnCollectDataForPlay {
    private long audioBytes;
    private String audioUrl;
    private String cdnDomain;
    private String cdnIP;
    private float connectedTime;
    private String downloadResult;
    private String downloadSpeed;
    private String downloadTime;
    private String downloaded;
    private String errorType;
    private String exceptionReason;
    private String fileSize;
    private boolean isTimeout;
    private String range;
    private String requestUUID;
    private String statusCode;
    private long timestamp;
    private String type;
    private String viaInfo;

    public long getAudioBytes() {
        return this.audioBytes;
    }

    public String getAudioUrl() {
        return this.audioUrl;
    }

    public String getCdnDomain() {
        return this.cdnDomain;
    }

    public String getCdnIP() {
        return this.cdnIP;
    }

    public float getConnectedTime() {
        return this.connectedTime;
    }

    public String getDownloadResult() {
        return this.downloadResult;
    }

    public String getDownloadSpeed() {
        return this.downloadSpeed;
    }

    public String getDownloadTime() {
        return this.downloadTime;
    }

    public String getDownloaded() {
        return this.downloaded;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getExceptionReason() {
        return this.exceptionReason;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public String getRange() {
        return this.range;
    }

    public String getRequestUUID() {
        return this.requestUUID;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    public String getViaInfo() {
        return this.viaInfo;
    }

    public boolean isTimeout() {
        return this.isTimeout;
    }

    public void setAudioBytes(long j) {
        this.audioBytes = j;
    }

    public void setAudioUrl(String str) {
        this.audioUrl = str;
    }

    public void setCdnDomain(String str) {
        this.cdnDomain = str;
    }

    public void setCdnIP(String str) {
        this.cdnIP = str;
    }

    public void setConnectedTime(float f) {
        this.connectedTime = f;
    }

    public void setDownloadResult(String str) {
        this.downloadResult = str;
    }

    public void setDownloadSpeed(String str) {
        this.downloadSpeed = str;
    }

    public void setDownloadTime(String str) {
        this.downloadTime = str;
    }

    public void setDownloaded(String str) {
        this.downloaded = str;
    }

    public void setErrorType(String str) {
        this.errorType = str;
    }

    public void setExceptionReason(String str) {
        this.exceptionReason = str;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }

    public void setRange(String str) {
        this.range = str;
    }

    public void setRequestUUID(String str) {
        this.requestUUID = str;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public void setTimeout(boolean z) {
        this.isTimeout = z;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setViaInfo(String str) {
        this.viaInfo = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CdnCollectDataForPlay{audioUrl='");
        stringBuilder.append(this.audioUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", audioBytes=");
        stringBuilder.append(this.audioBytes);
        stringBuilder.append(", cdnIP='");
        stringBuilder.append(this.cdnIP);
        stringBuilder.append('\'');
        stringBuilder.append(", isTimeout=");
        stringBuilder.append(this.isTimeout);
        stringBuilder.append(", downloadSpeed='");
        stringBuilder.append(this.downloadSpeed);
        stringBuilder.append('\'');
        stringBuilder.append(", exceptionReason='");
        stringBuilder.append(this.exceptionReason);
        stringBuilder.append('\'');
        stringBuilder.append(", errorType='");
        stringBuilder.append(this.errorType);
        stringBuilder.append('\'');
        stringBuilder.append(", statusCode='");
        stringBuilder.append(this.statusCode);
        stringBuilder.append('\'');
        stringBuilder.append(", viaInfo='");
        stringBuilder.append(this.viaInfo);
        stringBuilder.append('\'');
        stringBuilder.append(", connectedTime=");
        stringBuilder.append(this.connectedTime);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", type='");
        stringBuilder.append(this.type);
        stringBuilder.append('\'');
        stringBuilder.append(", range='");
        stringBuilder.append(this.range);
        stringBuilder.append('\'');
        stringBuilder.append(", fileSize='");
        stringBuilder.append(this.fileSize);
        stringBuilder.append('\'');
        stringBuilder.append(", downloaded='");
        stringBuilder.append(this.downloaded);
        stringBuilder.append('\'');
        stringBuilder.append(", downloadTime='");
        stringBuilder.append(this.downloadTime);
        stringBuilder.append('\'');
        stringBuilder.append(", downloadResult='");
        stringBuilder.append(this.downloadResult);
        stringBuilder.append('\'');
        stringBuilder.append(", cdnDomain=");
        stringBuilder.append(this.cdnDomain);
        stringBuilder.append('\'');
        stringBuilder.append(", requestUUID=");
        stringBuilder.append(this.requestUUID);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
