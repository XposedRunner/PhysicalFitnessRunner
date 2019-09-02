package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;

public class InfoWindow {
    BitmapDescriptor a;
    View b;
    LatLng c;
    OnInfoWindowClickListener d;
    int e;
    boolean f = false;
    int g = SysOSUtil.getDensityDpi();

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("view and position can not be null");
        }
        this.b = view;
        this.c = latLng;
        this.e = i;
    }

    public InfoWindow(View view, LatLng latLng, int i, boolean z, int i2) {
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("view and position can not be null");
        }
        this.b = view;
        this.c = latLng;
        this.e = i;
        this.f = z;
        this.g = i2;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
        }
        this.a = bitmapDescriptor;
        this.c = latLng;
        this.d = onInfoWindowClickListener;
        this.e = i;
    }
}
