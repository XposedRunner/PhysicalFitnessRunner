package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;

public final class ArcOptions extends BaseOptions implements Parcelable {
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();
    String a;
    private LatLng endpoint;
    private boolean isVisible = true;
    private LatLng passedpoint;
    private LatLng startpoint;
    private int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    private float strokeWidth = 10.0f;
    private final String type = "ArcOptions";
    private float zIndex = 0.0f;

    public int describeContents() {
        return 0;
    }

    public LatLng getEnd() {
        return this.endpoint;
    }

    public LatLng getPassed() {
        return this.passedpoint;
    }

    public LatLng getStart() {
        return this.startpoint;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.startpoint = latLng;
        this.passedpoint = latLng2;
        this.endpoint = latLng3;
        return this;
    }

    public ArcOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public ArcOptions strokeWidth(float f) {
        this.strokeWidth = f;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.startpoint != null) {
            bundle.putDouble("startlat", this.startpoint.latitude);
            bundle.putDouble("startlng", this.startpoint.longitude);
        }
        if (this.passedpoint != null) {
            bundle.putDouble("passedlat", this.passedpoint.latitude);
            bundle.putDouble("passedlng", this.passedpoint.longitude);
        }
        if (this.endpoint != null) {
            bundle.putDouble("endlat", this.endpoint.latitude);
            bundle.putDouble("endlng", this.endpoint.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte((byte) this.isVisible);
        parcel.writeString(this.a);
    }

    public ArcOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
