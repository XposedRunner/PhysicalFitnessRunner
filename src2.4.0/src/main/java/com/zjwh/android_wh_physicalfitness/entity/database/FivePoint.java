package com.zjwh.android_wh_physicalfitness.entity.database;

import android.support.annotation.NonNull;
import java.io.Serializable;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "five_point")
public class FivePoint implements Serializable, Comparable<FivePoint> {
    @Column(name = "flag")
    private long flag;
    @Column(isId = true, name = "id")
    private int id;
    @Column(name = "isFixed")
    private int isFixed;
    @Column(name = "isPass")
    private boolean isPass;
    @Column(name = "lat")
    private double lat;
    @Column(name = "lon")
    private double lon;
    @Column(name = "pointName")
    private String pointName;
    @Column(name = "position")
    private int position = 999;

    public FivePoint(double d, double d2, int i) {
        this.lat = d;
        this.lon = d2;
        this.isFixed = i;
    }

    public int compareTo(@NonNull FivePoint fivePoint) {
        return getPosition() - fivePoint.getPosition();
    }

    public long getFlag() {
        return this.flag;
    }

    public int getId() {
        return this.id;
    }

    public int getIsFixed() {
        return this.isFixed;
    }

    public boolean getIsPass() {
        return this.isPass;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public String getPointName() {
        return this.pointName;
    }

    public int getPosition() {
        return this.position;
    }

    public void setFlag(long j) {
        this.flag = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsFixed(int i) {
        this.isFixed = i;
    }

    public void setIsPass(boolean z) {
        this.isPass = z;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public void setPointName(String str) {
        this.pointName = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FivePoint{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", lat=");
        stringBuilder.append(this.lat);
        stringBuilder.append(", lon=");
        stringBuilder.append(this.lon);
        stringBuilder.append(", isFixed=");
        stringBuilder.append(this.isFixed);
        stringBuilder.append(", isPass=");
        stringBuilder.append(this.isPass);
        stringBuilder.append(", flag=");
        stringBuilder.append(this.flag);
        stringBuilder.append(", pointName='");
        stringBuilder.append(this.pointName);
        stringBuilder.append('\'');
        stringBuilder.append(", position=");
        stringBuilder.append(this.position);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
