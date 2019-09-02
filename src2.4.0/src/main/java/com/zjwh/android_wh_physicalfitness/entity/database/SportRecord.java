package com.zjwh.android_wh_physicalfitness.entity.database;

import defpackage.cu;
import java.util.List;
import org.xutils.DbManager;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.ex.DbException;

@Table(name = "sport_record")
public class SportRecord {
    @Column(name = "abnormal")
    private int abnormal;
    @Column(name = "createTime")
    private long createTime;
    @Column(isId = true, name = "id")
    private int id;
    @Column(name = "isGiveUp")
    private int isGiveUp;
    @Column(name = "isUpload")
    private boolean isUpload;
    @Column(name = "pauseTime")
    private long pauseTime;
    @Column(name = "policy")
    private int policy = -1;
    @Column(name = "restartTime")
    private long restartTime;
    @Column(name = "roomId")
    private int roomId;
    @Column(name = "runec")
    private String runec;
    @Column(name = "runef")
    private String runef;
    @Column(name = "runes")
    private String runes;
    @Column(name = "selDistance")
    private int selDistance;
    @Column(name = "sportType")
    private int sportType;
    @Column(name = "stopTime")
    private long stopTime;
    @Column(name = "timestamp")
    private long timestamp;
    @Column(name = "totalPauseTime")
    private long totalPauseTime;
    @Column(name = "uid")
    private int uid;
    @Column(name = "unid")
    private int unid;
    @Column(name = "uploadTime")
    private long uploadTime;
    @Column(name = "uuid")
    private String uuid;

    public int getAbnormal() {
        return this.abnormal;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public List<FivePoint> getFivePoint(DbManager dbManager) throws DbException {
        return dbManager.selector(FivePoint.class).where("flag", "=", Long.valueOf(this.timestamp)).orderBy(cu.O000OOo, false).findAll();
    }

    public int getId() {
        return this.id;
    }

    public int getIsGiveUp() {
        return this.isGiveUp;
    }

    public List<MyLocation> getLocList(DbManager dbManager) throws DbException {
        return dbManager.selector(MyLocation.class).where("flag", "=", Long.valueOf(this.timestamp)).orderBy("id").findAll();
    }

    public long getPauseTime() {
        return this.pauseTime;
    }

    public int getPolicy() {
        return this.policy;
    }

    public long getRestartTime() {
        return this.restartTime;
    }

    public int getRoomId() {
        return this.roomId;
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

    public List<SpeedPerTenSec> getSpeeds(DbManager dbManager) throws DbException {
        return dbManager.selector(SpeedPerTenSec.class).where("flag", "=", Long.valueOf(this.timestamp)).orderBy("id").findAll();
    }

    public int getSportType() {
        return this.sportType;
    }

    public List<StepsPerTenSec> getSteps(DbManager dbManager) throws DbException {
        return dbManager.selector(StepsPerTenSec.class).where("flag", "=", Long.valueOf(this.timestamp)).orderBy("id").findAll();
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getTotalPauseTime() {
        return this.totalPauseTime;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnid() {
        return this.unid;
    }

    public long getUploadTime() {
        return this.uploadTime;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isUpload() {
        return this.isUpload;
    }

    public void setAbnormal(int i) {
        this.abnormal = i;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsGiveUp(int i) {
        this.isGiveUp = i;
    }

    public void setPauseTime(long j) {
        this.pauseTime = j;
    }

    public void setPolicy(int i) {
        this.policy = i;
    }

    public void setRestartTime(long j) {
        this.restartTime = j;
    }

    public void setRoomId(int i) {
        this.roomId = i;
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

    public void setSportType(int i) {
        this.sportType = i;
    }

    public void setStopTime(long j) {
        this.stopTime = j;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setTotalPauseTime(long j) {
        this.totalPauseTime = j;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public void setUpload(boolean z) {
        this.isUpload = z;
    }

    public void setUploadTime(long j) {
        this.uploadTime = j;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SportRecord{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", isUpload=");
        stringBuilder.append(this.isUpload);
        stringBuilder.append(", uploadTime=");
        stringBuilder.append(this.uploadTime);
        stringBuilder.append(", createTime=");
        stringBuilder.append(this.createTime);
        stringBuilder.append(", stopTime=");
        stringBuilder.append(this.stopTime);
        stringBuilder.append(", isGiveUp=");
        stringBuilder.append(this.isGiveUp);
        stringBuilder.append(", totalPauseTime=");
        stringBuilder.append(this.totalPauseTime);
        stringBuilder.append(", pauseTime=");
        stringBuilder.append(this.pauseTime);
        stringBuilder.append(", restartTime=");
        stringBuilder.append(this.restartTime);
        stringBuilder.append(", selDistance=");
        stringBuilder.append(this.selDistance);
        stringBuilder.append(", sportType=");
        stringBuilder.append(this.sportType);
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", roomId=");
        stringBuilder.append(this.roomId);
        stringBuilder.append(", abnormal=");
        stringBuilder.append(this.abnormal);
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append(", uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append(", runes='");
        stringBuilder.append(this.runes);
        stringBuilder.append('\'');
        stringBuilder.append(", runef='");
        stringBuilder.append(this.runef);
        stringBuilder.append('\'');
        stringBuilder.append(", runec='");
        stringBuilder.append(this.runec);
        stringBuilder.append('\'');
        stringBuilder.append(", policy=");
        stringBuilder.append(this.policy);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
