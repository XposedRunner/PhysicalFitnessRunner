package com.zjwh.android_wh_physicalfitness.entity;

import com.zjwh.android_wh_physicalfitness.entity.database.SpeedPerTenSec;
import com.zjwh.android_wh_physicalfitness.entity.database.StepsPerTenSec;
import java.io.Serializable;
import java.util.List;

public class UploadFormatEntity implements CursorModel, Serializable, Comparable<UploadFormatEntity> {
    private String allLocJson;
    private int avgStepFreq;
    private int calorie;
    private boolean complete;
    private String fivePointJson;
    private boolean getPrize;
    private boolean isUpload;
    private boolean more = true;
    private int policy;
    private String prizeName;
    private String recordUrl;
    private int roomId;
    private int selDistance;
    private int selectedUnid;
    private String signature;
    private long speed;
    private List<SpeedPerTenSec> speedPerTenSec;
    private int sportType;
    private long startTime;
    private int status;
    private List<StepsPerTenSec> stepsPerTenSec;
    private long stopTime;
    private long totalDis;
    private int totalSteps;
    private long totalTime;
    private int uid;
    private int unCompleteReason;
    private String uuid;

    public int compareTo(UploadFormatEntity uploadFormatEntity) {
        return getStartTime() > uploadFormatEntity.getStartTime() ? -1 : getStartTime() < uploadFormatEntity.getStartTime() ? 1 : 0;
    }

    public String getAllLocJson() {
        return this.allLocJson;
    }

    public int getAvgStepFreq() {
        return this.avgStepFreq;
    }

    public int getCalorie() {
        return this.calorie;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public String getFivePointJson() {
        return this.fivePointJson;
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

    public String getRecordUrl() {
        return this.recordUrl;
    }

    public int getRoomId() {
        return this.roomId;
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

    public long getSpeed() {
        return this.speed;
    }

    public List<SpeedPerTenSec> getSpeedPerTenSec() {
        return this.speedPerTenSec;
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

    public List<StepsPerTenSec> getStepsPerTenSec() {
        return this.stepsPerTenSec;
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public long getTotalDis() {
        return this.totalDis;
    }

    public int getTotalSteps() {
        return this.totalSteps;
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

    public boolean isComplete() {
        return this.complete;
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

    public void setAvgStepFreq(int i) {
        this.avgStepFreq = i;
    }

    public void setCalorie(int i) {
        this.calorie = i;
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

    public void setRecordUrl(String str) {
        this.recordUrl = str;
    }

    public void setRoomId(int i) {
        this.roomId = i;
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
        this.speed = Math.round(d * 1000.0d);
    }

    public void setSpeedPerTenSec(List<SpeedPerTenSec> list) {
        this.speedPerTenSec = list;
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

    public void setStepsPerTenSec(List<StepsPerTenSec> list) {
        this.stepsPerTenSec = list;
    }

    public void setStopTime(long j) {
        this.stopTime = j;
    }

    public void setTotalDis(double d) {
        this.totalDis = Math.round(d * 1000.0d);
    }

    public void setTotalSteps(int i) {
        this.totalSteps = i;
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
        stringBuilder.append("UploadFormatEntity{status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", signature='");
        stringBuilder.append(this.signature);
        stringBuilder.append('\'');
        stringBuilder.append(", allLocJson='");
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
        stringBuilder.append(", selectedUnid=");
        stringBuilder.append(this.selectedUnid);
        stringBuilder.append(", selDistance=");
        stringBuilder.append(this.selDistance);
        stringBuilder.append(", unCompleteReason=");
        stringBuilder.append(this.unCompleteReason);
        stringBuilder.append(", getPrize=");
        stringBuilder.append(this.getPrize);
        stringBuilder.append(", totalSteps=");
        stringBuilder.append(this.totalSteps);
        stringBuilder.append(", avgStepFreq=");
        stringBuilder.append(this.avgStepFreq);
        stringBuilder.append(", roomId=");
        stringBuilder.append(this.roomId);
        stringBuilder.append(", calorie=");
        stringBuilder.append(this.calorie);
        stringBuilder.append(", stepsPerTenSec=");
        stringBuilder.append(this.stepsPerTenSec);
        stringBuilder.append(", speedPerTenSec=");
        stringBuilder.append(this.speedPerTenSec);
        stringBuilder.append(", recordUrl='");
        stringBuilder.append(this.recordUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", isUpload=");
        stringBuilder.append(this.isUpload);
        stringBuilder.append(", prizeName='");
        stringBuilder.append(this.prizeName);
        stringBuilder.append('\'');
        stringBuilder.append(", more=");
        stringBuilder.append(this.more);
        stringBuilder.append(", policy=");
        stringBuilder.append(this.policy);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
