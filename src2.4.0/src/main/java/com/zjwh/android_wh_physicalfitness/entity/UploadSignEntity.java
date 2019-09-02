package com.zjwh.android_wh_physicalfitness.entity;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UploadSignEntity {
    private int avgStepFreq;
    private int calorie;
    private boolean complete;
    private boolean getPrize;
    private int policy;
    private int selDistance;
    private int selectedUnid;
    private long speed;
    private int sportType;
    private long startTime;
    private int status;
    private long stopTime;
    private long totalDis;
    private int totalSteps;
    private long totalTime;
    private int uid;
    private int unCompleteReason;
    private String uuid;

    public UploadSignEntity(UploadFormatEntity uploadFormatEntity) {
        this.sportType = uploadFormatEntity.getSportType();
        this.totalTime = uploadFormatEntity.getTotalTime();
        this.totalDis = uploadFormatEntity.getTotalDis();
        this.speed = uploadFormatEntity.getSpeed();
        this.startTime = uploadFormatEntity.getStartTime();
        this.stopTime = uploadFormatEntity.getStopTime();
        this.complete = uploadFormatEntity.getComplete();
        this.selDistance = uploadFormatEntity.getSelDistance();
        this.unCompleteReason = uploadFormatEntity.getUnCompleteReason();
        this.getPrize = uploadFormatEntity.isGetPrize();
        this.status = uploadFormatEntity.getStatus();
        this.uuid = uploadFormatEntity.getUuid();
        this.uid = uploadFormatEntity.getUid();
        this.avgStepFreq = uploadFormatEntity.getAvgStepFreq();
        this.totalSteps = uploadFormatEntity.getTotalSteps();
        this.selectedUnid = uploadFormatEntity.getSelectedUnid();
        this.calorie = uploadFormatEntity.getCalorie();
        this.policy = uploadFormatEntity.getPolicy();
    }

    public int getAvgStepFreq() {
        return this.avgStepFreq;
    }

    public int getCalorie() {
        return this.calorie;
    }

    public Map<String, Object> getMapParams() {
        Field[] declaredFields = getClass().getDeclaredFields();
        if (declaredFields == null || declaredFields.length == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                hashMap.put(field.getName(), String.valueOf(field.get(this)));
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public int getPolicy() {
        return this.policy;
    }

    public int getSelDistance() {
        return this.selDistance;
    }

    public int getSelectedUnid() {
        return this.selectedUnid;
    }

    public long getSpeed() {
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

    public boolean isComplete() {
        return this.complete;
    }

    public boolean isGetPrize() {
        return this.getPrize;
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

    public void setGetPrize(boolean z) {
        this.getPrize = z;
    }

    public void setPolicy(int i) {
        this.policy = i;
    }

    public void setSelDistance(int i) {
        this.selDistance = i;
    }

    public void setSelectedUnid(int i) {
        this.selectedUnid = i;
    }

    public void setSpeed(long j) {
        this.speed = j;
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

    public void setStopTime(long j) {
        this.stopTime = j;
    }

    public void setTotalDis(long j) {
        this.totalDis = j;
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
        stringBuilder.append("UploadSignEntity{sportType=");
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
        stringBuilder.append(", complete=");
        stringBuilder.append(this.complete);
        stringBuilder.append(", selDistance=");
        stringBuilder.append(this.selDistance);
        stringBuilder.append(", unCompleteReason=");
        stringBuilder.append(this.unCompleteReason);
        stringBuilder.append(", getPrize=");
        stringBuilder.append(this.getPrize);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", totalSteps=");
        stringBuilder.append(this.totalSteps);
        stringBuilder.append(", avgStepFreq=");
        stringBuilder.append(this.avgStepFreq);
        stringBuilder.append(", selectedUnid=");
        stringBuilder.append(this.selectedUnid);
        stringBuilder.append(", calorie=");
        stringBuilder.append(this.calorie);
        stringBuilder.append(", policy=");
        stringBuilder.append(this.policy);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
