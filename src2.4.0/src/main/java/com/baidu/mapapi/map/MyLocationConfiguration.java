package com.baidu.mapapi.map;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;

public class MyLocationConfiguration {
    public int accuracyCircleFillColor = 4521984;
    public int accuracyCircleStrokeColor = 4653056;
    public final BitmapDescriptor customMarker;
    public final boolean enableDirection;
    public final LocationMode locationMode;

    public enum LocationMode {
        NORMAL,
        FOLLOWING,
        COMPASS
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor) {
        if (locationMode == null) {
            locationMode = LocationMode.NORMAL;
        }
        this.locationMode = locationMode;
        this.enableDirection = z;
        this.customMarker = bitmapDescriptor;
        this.accuracyCircleFillColor = a(this.accuracyCircleFillColor);
        this.accuracyCircleStrokeColor = a(this.accuracyCircleStrokeColor);
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor, int i, int i2) {
        if (locationMode == null) {
            locationMode = LocationMode.NORMAL;
        }
        this.locationMode = locationMode;
        this.enableDirection = z;
        this.customMarker = bitmapDescriptor;
        this.accuracyCircleFillColor = a(i);
        this.accuracyCircleStrokeColor = a(i2);
    }

    private int a(int i) {
        int i2 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8;
        return Color.argb((ViewCompat.MEASURED_STATE_MASK & i) >> 24, i & 255, i2, (16711680 & i) >> 16);
    }
}
