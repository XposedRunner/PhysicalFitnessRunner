package com.amap.api.trace;

public class TraceLocation {
    private double a;
    private double b;
    private float c;
    private float d;
    private long e;

    public TraceLocation(double d, double d2, float f, float f2, long j) {
        this.a = a(d);
        this.b = a(d2);
        this.c = (float) ((int) ((f * 3600.0f) / 1000.0f));
        this.d = (float) ((int) f2);
        this.e = j;
    }

    private static double a(double d) {
        return ((double) Math.round(d * 1000000.0d)) / 1000000.0d;
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.d = this.d;
        traceLocation.a = this.a;
        traceLocation.b = this.b;
        traceLocation.c = this.c;
        traceLocation.e = this.e;
        return traceLocation;
    }

    public float getBearing() {
        return this.d;
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public float getSpeed() {
        return this.c;
    }

    public long getTime() {
        return this.e;
    }

    public void setBearing(float f) {
        this.d = (float) ((int) f);
    }

    public void setLatitude(double d) {
        this.a = a(d);
    }

    public void setLongitude(double d) {
        this.b = a(d);
    }

    public void setSpeed(float f) {
        this.c = (float) ((int) ((f * 3600.0f) / 1000.0f));
    }

    public void setTime(long j) {
        this.e = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(",longtitude ");
        stringBuilder.append(this.b);
        stringBuilder.append(",speed ");
        stringBuilder.append(this.c);
        stringBuilder.append(",bearing ");
        stringBuilder.append(this.d);
        stringBuilder.append(",time ");
        stringBuilder.append(this.e);
        return stringBuilder.toString();
    }
}
