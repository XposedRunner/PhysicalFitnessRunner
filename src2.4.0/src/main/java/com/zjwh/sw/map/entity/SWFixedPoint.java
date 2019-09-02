package com.zjwh.sw.map.entity;

public class SWFixedPoint extends SWLatLng implements Comparable<SWFixedPoint> {
    public static final String LOC_DESC = "locDesc";
    private String description;
    private int id;
    private int isFixed;
    private boolean isPassed;
    private String pointName;
    private int position;

    public SWFixedPoint(double d, double d2, double d3, double d4, int i, int i2, boolean z, String str) {
        super(d3, d4, d, d2);
        this.isFixed = i;
        this.position = i2;
        this.isPassed = z;
        this.pointName = str;
    }

    public SWFixedPoint(double d, double d2, double d3, double d4, int i, int i2, boolean z, String str, String str2) {
        super(d3, d4, d, d2);
        this.isFixed = i;
        this.position = i2;
        this.isPassed = z;
        this.pointName = str;
        this.description = str2;
    }

    public SWFixedPoint(double d, double d2, double d3, double d4, int i, String str) {
        super(d3, d4, d, d2);
        this.id = i;
        this.description = str;
    }

    public int compareTo(SWFixedPoint sWFixedPoint) {
        return getPosition() - sWFixedPoint.getPosition();
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.id;
    }

    public int getIsFixed() {
        return this.isFixed;
    }

    public String getPointName() {
        return this.pointName;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isPassed() {
        return this.isPassed;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsFixed(int i) {
        this.isFixed = i;
    }

    public void setPassed(boolean z) {
        this.isPassed = z;
    }

    public void setPointName(String str) {
        this.pointName = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SWFixedPoint{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", isFixed=");
        stringBuilder.append(this.isFixed);
        stringBuilder.append(", position=");
        stringBuilder.append(this.position);
        stringBuilder.append(", isPassed=");
        stringBuilder.append(this.isPassed);
        stringBuilder.append(", pointName='");
        stringBuilder.append(this.pointName);
        stringBuilder.append('\'');
        stringBuilder.append(", description='");
        stringBuilder.append(this.description);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
