package com.zjwh.android_wh_physicalfitness.entity;

import java.io.Serializable;

public class UploadEntity implements CursorModel, Serializable, Comparable<UploadEntity> {
    public static final int APPEAL_STATUS_FAILED = 4;
    public static final int APPEAL_STATUS_NO = 1;
    public static final int APPEAL_STATUS_PASS = 3;
    public static final int APPEAL_STATUS_UNDER = 2;
    private String allLocJson;
    private int appealStatus;
    private String appealStatusInfo;
    private int avgStepFreq;
    private int calorie;
    private int canAppeal;
    private boolean complete;
    private String fivePointJson;
    private boolean getPrize;
    private int isCheat;
    private boolean isUpload;
    private boolean more = true;
    private int policy;
    private String prizeName;
    private int recordId;
    private String recordUrl;
    private int roomId;
    private int rrid;
    private String runec;
    private String runef;
    private String runes;
    private int selDistance;
    private int selectedUnid;
    private String signature;
    private double speed;
    private int sportType;
    private long startTime;
    private int status;
    private String statusInfo;
    private int stepFreqStatus;
    private long stopTime;
    private double totalDis;
    private long totalTime;
    private int uid;
    private int unCompleteReason;
    private String uuid;

    public int compareTo(UploadEntity uploadEntity) {
        return getStartTime() > uploadEntity.getStartTime() ? -1 : getStartTime() < uploadEntity.getStartTime() ? 1 : 0;
    }

    public String getAllLocJson() {
        return this.allLocJson;
    }

    public int getAppealStatus() {
        return this.appealStatus;
    }

    public String getAppealStatusInfo() {
        return this.appealStatusInfo;
    }

    public int getAvgStepFreq() {
        return this.avgStepFreq;
    }

    public int getCalorie() {
        return this.calorie;
    }

    public int getCanAppeal() {
        return this.canAppeal;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public String getFivePointJson() {
        return this.fivePointJson;
    }

    public int getIsCheat() {
        return this.isCheat;
    }

    public boolean getIsUpload() {
        return this.isUpload;
    }

    public int getPolicy() {
        return this.policy;
    }

    public String getPrizeName() {
        return this.prizeName;
    }

    public int getRecordId() {
        return this.recordId;
    }

    public String getRecordUrl() {
        return this.recordUrl;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public int getRrid() {
        return this.rrid;
    }

    public String getRunec() {
        return this.runec;
    }

    public String getRunef() {
        return this.runef;
    }

    public String getRunes() {
        return this.runes;
    }

    public int getSelDistance() {
        return this.selDistance;
    }

    public int getSelectedUnid() {
        return this.selectedUnid;
    }

    public String getSignature() {
        return this.signature;
    }

    public double getSpeed() {
        return this.speed;
    }

    public int getSportType() {
        return this.sportType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusInfo() {
        return this.statusInfo;
    }

    public int getStepFreqStatus() {
        return this.stepFreqStatus;
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public double getTotalDis() {
        return this.totalDis;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnCompleteReason() {
        return this.unCompleteReason;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean hasMore() {
        return this.more;
    }

    public boolean isGetPrize() {
        return this.getPrize;
    }

    public boolean isMore() {
        return this.more;
    }

    public void setAllLocJson(String str) {
        this.allLocJson = str;
    }

    public void setAppealStatus(int i) {
        this.appealStatus = i;
    }

    public void setAppealStatusInfo(String str) {
        this.appealStatusInfo = str;
    }

    public void setAvgStepFreq(int i) {
        this.avgStepFreq = i;
    }

    public void setCalorie(int i) {
        this.calorie = i;
    }

    public void setCanAppeal(int i) {
        this.canAppeal = i;
    }

    public void setComplete(boolean z) {
        this.complete = z;
    }

    public void setFivePointJson(String str) {
        this.fivePointJson = str;
    }

    public void setGetPrize(boolean z) {
        this.getPrize = z;
    }

    public void setIsCheat(int i) {
        this.isCheat = i;
    }

    public void setIsUpload(boolean z) {
        this.isUpload = z;
    }

    public void setMore(boolean z) {
        this.more = z;
    }

    public void setPolicy(int i) {
        this.policy = i;
    }

    public void setPrizeName(String str) {
        this.prizeName = str;
    }

    public void setRecordId(int i) {
        this.recordId = i;
    }

    public void setRecordUrl(String str) {
        this.recordUrl = str;
    }

    public void setRoomId(int i) {
        this.roomId = i;
    }

    public void setRrid(int i) {
        this.rrid = i;
    }

    public void setRunec(String str) {
        this.runec = str;
    }

    public void setRunef(String str) {
        this.runef = str;
    }

    public void setRunes(String str) {
        this.runes = str;
    }

    public void setSelDistance(int i) {
        this.selDistance = i;
    }

    public void setSelectedUnid(int i) {
        this.selectedUnid = i;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    public void setSportType(int i) {
        this.sportType = i;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setStatusInfo(String str) {
        this.statusInfo = str;
    }

    public void setStepFreqStatus(int i) {
        this.stepFreqStatus = i;
    }

    public void setStopTime(long j) {
        this.stopTime = j;
    }

    public void setTotalDis(double d) {
        this.totalDis = d;
    }

    public void setTotalTime(long j) {
        this.totalTime = j;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUnCompleteReason(int i) {
        this.unCompleteReason = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UploadEntity{allLocJson='");
        stringBuilder.append(this.allLocJson);
        stringBuilder.append('\'');
        stringBuilder.append(", sportType=");
        stringBuilder.append(this.sportType);
        stringBuilder.append(", totalTime=");
        stringBuilder.append(this.totalTime);
        stringBuilder.append(", totalDis=");
        stringBuilder.append(this.totalDis);
        stringBuilder.append(", speed=");
        stringBuilder.append(this.speed);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", stopTime=");
        stringBuilder.append(this.stopTime);
        stringBuilder.append(", fivePointJson='");
        stringBuilder.append(this.fivePointJson);
        stringBuilder.append('\'');
        stringBuilder.append(", complete=");
        stringBuilder.append(this.complete);
        stringBuilder.append(", selDistance=");
        stringBuilder.append(this.selDistance);
        stringBuilder.append(", unCompleteReason=");
        stringBuilder.append(this.unCompleteReason);
        stringBuilder.append(", recordUrl='");
        stringBuilder.append(this.recordUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", prizeName='");
        stringBuilder.append(this.prizeName);
        stringBuilder.append('\'');
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", avgStepFreq=");
        stringBuilder.append(this.avgStepFreq);
        stringBuilder.append(", isUpload=");
        stringBuilder.append(this.isUpload);
        stringBuilder.append(", getPrize=");
        stringBuilder.append(this.getPrize);
        stringBuilder.append(", uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", signature='");
        stringBuilder.append(this.signature);
        stringBuilder.append('\'');
        stringBuilder.append(", roomId=");
        stringBuilder.append(this.roomId);
        stringBuilder.append(", more=");
        stringBuilder.append(this.more);
        stringBuilder.append(", recordId=");
        stringBuilder.append(this.recordId);
        stringBuilder.append(", rrid=");
        stringBuilder.append(this.rrid);
        stringBuilder.append(", appealStatus=");
        stringBuilder.append(this.appealStatus);
        stringBuilder.append(", appealStatusInfo='");
        stringBuilder.append(this.appealStatusInfo);
        stringBuilder.append('\'');
        stringBuilder.append(", canAppeal=");
        stringBuilder.append(this.canAppeal);
        stringBuilder.append(", stepFreqStatus=");
        stringBuilder.append(this.stepFreqStatus);
        stringBuilder.append(", statusInfo='");
        stringBuilder.append(this.statusInfo);
        stringBuilder.append('\'');
        stringBuilder.append(", selectedUnid=");
        stringBuilder.append(this.selectedUnid);
        stringBuilder.append(", calorie=");
        stringBuilder.append(this.calorie);
        stringBuilder.append(", isCheat=");
        stringBuilder.append(this.isCheat);
        stringBuilder.append(", policy=");
        stringBuilder.append(this.policy);
        stringBuilder.append(", runes='");
        stringBuilder.append(this.runes);
        stringBuilder.append('\'');
        stringBuilder.append(", runef='");
        stringBuilder.append(this.runef);
        stringBuilder.append('\'');
        stringBuilder.append(", runec='");
        stringBuilder.append(this.runec);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
