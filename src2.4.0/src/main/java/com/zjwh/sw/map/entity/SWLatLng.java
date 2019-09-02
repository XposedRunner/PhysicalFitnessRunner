package com.zjwh.sw.map.entity;

public class SWLatLng {
    private double bLat;
    private double bLon;
    private double gLat = -1.0d;
    private double gLon = -1.0d;

    public SWLatLng(double d, double d2, double d3, double d4) {
        this.gLat = d;
        this.gLon = d2;
        this.bLat = d3;
        this.bLon = d4;
    }

    public double getBLat() {
        return this.bLat;
    }

    public double getBLon() {
        return this.bLon;
    }

    public double getGLat() {
        return this.gLat;
    }

    public double getGLon() {
        return this.gLon;
    }

    public void setBLat(double d) {
        this.bLat = d;
    }

    public void setBLon(double d) {
        this.bLon = d;
    }

    public void setGLat(double d) {
        this.gLat = d;
    }

    public void setGLon(double d) {
        this.gLon = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SWLatLng{gLat=");
        stringBuilder.append(this.gLat);
        stringBuilder.append(", gLon=");
        stringBuilder.append(this.gLon);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
