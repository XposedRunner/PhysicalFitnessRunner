package com.zjwh.android_wh_physicalfitness.entity.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "my_location")
public class MyLocation implements Parcelable {
    public static final Creator<MyLocation> CREATOR = new Creator<MyLocation>() {
        public MyLocation createFromParcel(Parcel parcel) {
            return new MyLocation(parcel);
        }

        public MyLocation[] newArray(int i) {
            return new MyLocation[i];
        }
    };
    @SerializedName(alternate = {"avgspeed"}, value = "avgSpeed")
    @Column(name = "avgSpeed")
    private double avgSpeed;
    @Column(name = "bdA")
    private double bdA;
    @Column(name = "bdD")
    private float bdD;
    @Column(name = "bdG")
    private int bdG;
    @Column(name = "bdS")
    private float bdS;
    @Column(name = "count")
    private int count;
    @Column(name = "flag")
    private long flag;
    @Column(name = "gLat")
    private double gLat = -1.0d;
    @Column(name = "gLng")
    private double gLng = -1.0d;
    @SerializedName(alternate = {"gaintime"}, value = "gainTime")
    @Column(name = "gainTime")
    private String gainTime;
    @Column(autoGen = true, isId = true, name = "id")
    private int id;
    @Column(name = "lat")
    private double lat;
    @Column(name = "lng")
    private double lng;
    @SerializedName(alternate = {"locationtype"}, value = "locType")
    @Column(name = "locType")
    private int locType;
    @Column(name = "radius")
    private float radius;
    @Column(name = "speed")
    private double speed;
    @Column(name = "state")
    private int state;
    @Column(name = "stepDistance")
    private double stepDistance;
    @SerializedName(alternate = {"totaldis"}, value = "totalDis")
    @Column(name = "totalDis")
    private double totalDis;
    @SerializedName(alternate = {"totaltime"}, value = "totalTime")
    @Column(name = "totalTime")
    private long totalTime;
    @Column(name = "type")
    private int type;

    public MyLocation(double d, double d2, String str, int i, double d3, float f, int i2, float f2, int i3, double d4, double d5) {
        this.gLng = d2;
        this.gLat = d;
        this.lng = d5;
        this.lat = d4;
        this.gainTime = str;
        this.count = i;
        this.bdA = d3;
        this.bdD = f;
        this.bdG = i2;
        this.bdS = f2;
        this.state = i3;
    }

    protected MyLocation(Parcel parcel) {
        this.id = parcel.readInt();
        this.lng = parcel.readDouble();
        this.lat = parcel.readDouble();
        this.gainTime = parcel.readString();
        this.type = parcel.readInt();
        this.avgSpeed = parcel.readDouble();
        this.speed = parcel.readDouble();
        this.locType = parcel.readInt();
        this.radius = parcel.readFloat();
        this.totalTime = parcel.readLong();
        this.totalDis = parcel.readDouble();
        this.flag = parcel.readLong();
        this.count = parcel.readInt();
        this.bdA = parcel.readDouble();
        this.bdD = parcel.readFloat();
        this.bdG = parcel.readInt();
        this.bdS = parcel.readFloat();
        this.state = parcel.readInt();
        this.stepDistance = parcel.readDouble();
        this.gLng = parcel.readDouble();
        this.gLat = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public double getAvgSpeed() {
        return this.avgSpeed;
    }

    public double getBdA() {
        return this.bdA;
    }

    public float getBdD() {
        return this.bdD;
    }

    public int getBdG() {
        return this.bdG;
    }

    public float getBdS() {
        return this.bdS;
    }

    public int getCount() {
        return this.count;
    }

    public long getFlag() {
        return this.flag;
    }

    public String getGainTime() {
        return this.gainTime;
    }

    public int getId() {
        return this.id;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public int getLocType() {
        return this.locType;
    }

    public float getRadius() {
        return this.radius;
    }

    public double getSpeed() {
        return this.speed;
    }

    public int getState() {
        return this.state;
    }

    public double getStepDistance() {
        return this.stepDistance;
    }

    public double getTotalDis() {
        return this.totalDis;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public int getType() {
        return this.type;
    }

    public double getgLat() {
        return this.gLat;
    }

    public double getgLng() {
        return this.gLng;
    }

    public void setAvgSpeed(double d) {
        this.avgSpeed = d;
    }

    public void setBdA(double d) {
        this.bdA = d;
    }

    public void setBdD(float f) {
        this.bdD = f;
    }

    public void setBdG(int i) {
        this.bdG = i;
    }

    public void setBdS(float f) {
        this.bdS = f;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setFlag(long j) {
        this.flag = j;
    }

    public void setGainTime(String str) {
        this.gainTime = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public void setLocType(int i) {
        this.locType = i;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setStepDistance(double d) {
        this.stepDistance = d;
    }

    public void setTotalDis(double d) {
        this.totalDis = d;
    }

    public void setTotalTime(long j) {
        this.totalTime = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setgLat(double d) {
        this.gLat = d;
    }

    public void setgLng(double d) {
        this.gLng = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyLocation{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", lng=");
        stringBuilder.append(this.lng);
        stringBuilder.append(", lat=");
        stringBuilder.append(this.lat);
        stringBuilder.append(", gainTime='");
        stringBuilder.append(this.gainTime);
        stringBuilder.append('\'');
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", avgSpeed=");
        stringBuilder.append(this.avgSpeed);
        stringBuilder.append(", speed=");
        stringBuilder.append(this.speed);
        stringBuilder.append(", locType=");
        stringBuilder.append(this.locType);
        stringBuilder.append(", radius=");
        stringBuilder.append(this.radius);
        stringBuilder.append(", totalTime=");
        stringBuilder.append(this.totalTime);
        stringBuilder.append(", totalDis=");
        stringBuilder.append(this.totalDis);
        stringBuilder.append(", flag=");
        stringBuilder.append(this.flag);
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", bdA=");
        stringBuilder.append(this.bdA);
        stringBuilder.append(", bdD=");
        stringBuilder.append(this.bdD);
        stringBuilder.append(", bdG=");
        stringBuilder.append(this.bdG);
        stringBuilder.append(", bdS=");
        stringBuilder.append(this.bdS);
        stringBuilder.append(", state=");
        stringBuilder.append(this.state);
        stringBuilder.append(", stepDistance=");
        stringBuilder.append(this.stepDistance);
        stringBuilder.append(", gLng=");
        stringBuilder.append(this.gLng);
        stringBuilder.append(", gLat=");
        stringBuilder.append(this.gLat);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeDouble(this.lng);
        parcel.writeDouble(this.lat);
        parcel.writeString(this.gainTime);
        parcel.writeInt(this.type);
        parcel.writeDouble(this.avgSpeed);
        parcel.writeDouble(this.speed);
        parcel.writeInt(this.locType);
        parcel.writeFloat(this.radius);
        parcel.writeLong(this.totalTime);
        parcel.writeDouble(this.totalDis);
        parcel.writeLong(this.flag);
        parcel.writeInt(this.count);
        parcel.writeDouble(this.bdA);
        parcel.writeFloat(this.bdD);
        parcel.writeInt(this.bdG);
        parcel.writeFloat(this.bdS);
        parcel.writeInt(this.state);
        parcel.writeDouble(this.stepDistance);
        parcel.writeDouble(this.gLng);
        parcel.writeDouble(this.gLat);
    }
}
