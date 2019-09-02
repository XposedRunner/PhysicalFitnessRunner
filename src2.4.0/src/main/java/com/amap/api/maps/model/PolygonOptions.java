package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions extends BaseOptions implements Parcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    String a;
    private int fillColor = ViewCompat.MEASURED_STATE_MASK;
    private List<BaseHoleOptions> holeOptions = new ArrayList();
    private boolean isHoleOptionsUpdated = false;
    private boolean isPointsUpdated = false;
    private boolean isVisible = true;
    private double[] pointList;
    private final List<LatLng> points = new ArrayList();
    private int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    private float strokeWidth = 10.0f;
    private final String type = "PolygonOptions";
    private float zIndex = 0.0f;

    public PolygonOptions add(LatLng latLng) {
        try {
            this.points.add(latLng);
            this.isPointsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        try {
            this.points.addAll(Arrays.asList(latLngArr));
            this.isPointsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        try {
            for (LatLng add : iterable) {
                this.points.add(add);
            }
            this.isPointsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public PolygonOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        try {
            for (BaseHoleOptions add : iterable) {
                this.holeOptions.add(add);
            }
            this.isHoleOptionsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public PolygonOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        try {
            this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
            this.isHoleOptionsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public List<LatLng> getPoints() {
        return this.points;
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

    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.holeOptions.clear();
            this.holeOptions.addAll(list);
            this.isHoleOptionsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.points.clear();
            this.points.addAll(list);
            this.isPointsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public PolygonOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.strokeWidth = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte((byte) this.isVisible);
        parcel.writeString(this.a);
        parcel.writeList(this.holeOptions);
    }

    public PolygonOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
