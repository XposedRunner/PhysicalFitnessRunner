package com.zjwh.android_wh_physicalfitness.entity.database;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "speed_record")
public class SpeedPerTenSec {
    @Column(name = "beginTime")
    private long beginTime;
    @Column(name = "distance")
    private double distance;
    @Column(name = "endTime")
    private long endTime;
    @Column(name = "flag")
    private long flag;
    @Column(autoGen = true, isId = true, name = "id")
    private int id;

    public SpeedPerTenSec(double d, long j, long j2, long j3) {
        this.distance = d;
        this.beginTime = j;
        this.endTime = j2;
        this.flag = j3;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public double getDistance() {
        return this.distance;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getFlag() {
        return this.flag;
    }

    public int getId() {
        return this.id;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setFlag(long j) {
        this.flag = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpeedPerTenSec{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", distance=");
        stringBuilder.append(this.distance);
        stringBuilder.append(", beginTime=");
        stringBuilder.append(this.beginTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append(", flag=");
        stringBuilder.append(this.flag);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
