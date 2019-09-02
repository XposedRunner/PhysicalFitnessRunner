package com.baidu.mapapi.model.inner;

public class GeoPoint {
    private double a;
    private double b;

    public GeoPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.a == geoPoint.a && this.b == geoPoint.b) {
            z = true;
        }
        return z;
    }

    public double getLatitudeE6() {
        return this.a;
    }

    public double getLongitudeE6() {
        return this.b;
    }

    public void setLatitudeE6(double d) {
        this.a = d;
    }

    public void setLongitudeE6(double d) {
        this.b = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GeoPoint: Latitude: ");
        stringBuilder.append(this.a);
        stringBuilder.append(", Longitude: ");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
