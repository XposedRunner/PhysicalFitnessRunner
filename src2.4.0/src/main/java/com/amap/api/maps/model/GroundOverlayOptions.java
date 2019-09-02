package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public final class GroundOverlayOptions extends BaseOptions implements Parcelable {
    private static final String CLASSNAME = "GroundOverlayOptions";
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;
    private final double NF_PI;
    private final double R;
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private String bitmapSymbol;
    private float height;
    private boolean isVisible;
    private LatLng latLng;
    private LatLngBounds latlngBounds;
    private final int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;
    private float transparency;
    private final String type;
    private float width;
    private float zIndex;

    public GroundOverlayOptions() {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.type = CLASSNAME;
        this.mVersionCode = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.type = CLASSNAME;
        this.mVersionCode = i;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = latLng;
        this.width = f;
        this.height = f2;
        this.latlngBounds = latLngBounds;
        this.bearing = f3;
        this.zIndex = f4;
        this.isVisible = z;
        this.transparency = f5;
        this.anchorU = f6;
        this.anchorV = f7;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
    }

    private GroundOverlayOptions a(LatLng latLng, float f, float f2) {
        this.latLng = latLng;
        this.width = f;
        this.height = f2;
        b();
        return this;
    }

    private void a() {
        if (this.southwest != null && this.northeast != null) {
            this.latLng = new LatLng(this.southwest.latitude + (((double) (1.0f - this.anchorV)) * (this.northeast.latitude - this.southwest.latitude)), this.southwest.longitude + (((double) this.anchorU) * (this.northeast.longitude - this.southwest.longitude)));
            this.width = (float) (((Math.cos(this.latLng.latitude * 0.01745329251994329d) * 6371000.79d) * (this.northeast.longitude - this.southwest.longitude)) * 0.01745329251994329d);
            this.height = (float) ((6371000.79d * (this.northeast.latitude - this.southwest.latitude)) * 0.01745329251994329d);
        }
    }

    private void b() {
        if (this.latLng != null) {
            double cos = ((double) this.width) / ((6371000.79d * Math.cos(this.latLng.latitude * 0.01745329251994329d)) * 0.01745329251994329d);
            double d = ((double) this.height) / 111194.94043265979d;
            try {
                this.latlngBounds = new LatLngBounds(new LatLng(this.latLng.latitude - (((double) (1.0f - this.anchorV)) * d), this.latLng.longitude - (((double) this.anchorU) * cos)), new LatLng(this.latLng.latitude + (((double) this.anchorV) * d), this.latLng.longitude + (((double) (1.0f - this.anchorU)) * cos)));
                this.southwest = this.latlngBounds.southwest;
                this.northeast = this.latlngBounds.northeast;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        if (this.latlngBounds != null) {
            a();
        } else if (this.latLng != null) {
            b();
        }
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.bearing = f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public float getBearing() {
        return this.bearing;
    }

    public LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public float getHeight() {
        return this.height;
    }

    public BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public LatLng getLocation() {
        return this.latLng;
    }

    public float getTransparency() {
        return this.transparency;
    }

    public float getWidth() {
        return this.width;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        if (this.bitmapDescriptor != null) {
            this.bitmapSymbol = this.bitmapDescriptor.getId();
        }
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f <= 0.0f) {
            Log.w(CLASSNAME, "Width must be non-negative");
        }
        return a(latLng, f, f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f <= 0.0f || f2 <= 0.0f) {
            Log.w(CLASSNAME, "Width and Height must be non-negative");
        }
        return a(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (this.latLng != null) {
            String str = CLASSNAME;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Position has already been set using position: ");
            stringBuilder.append(this.latLng);
            Log.w(str, stringBuilder.toString());
        }
        this.latlngBounds = latLngBounds;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        a();
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        if (f < 0.0f) {
            Log.w(CLASSNAME, "Transparency must be in the range [0..1]");
            f = 0.0f;
        }
        this.transparency = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeParcelable(this.bitmapDescriptor, i);
        parcel.writeParcelable(this.latLng, i);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeParcelable(this.latlngBounds, i);
        parcel.writeFloat(this.bearing);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte((byte) this.isVisible);
        parcel.writeFloat(this.transparency);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
