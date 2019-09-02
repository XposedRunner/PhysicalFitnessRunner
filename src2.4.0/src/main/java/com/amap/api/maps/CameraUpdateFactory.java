package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.mapcore.util.O000O0o0;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

public final class CameraUpdateFactory {
    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(O000O0o0.O00000o(f % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f, IPoint iPoint) {
        if (iPoint != null) {
            return new CameraUpdate(O000O0o0.O00000Oo(f % 360.0f, new Point(iPoint.x, iPoint.y)));
        }
        Log.w("CameraUpdateFactory", "geoPoint is null");
        return new CameraUpdate(O000O0o0.O00000o0());
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(O000O0o0.O000000o(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
        }
        Log.w("CameraUpdateFactory", "target is null");
        return new CameraUpdate(O000O0o0.O00000o0());
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(O000O0o0.O00000o0(f));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            return new CameraUpdate(O000O0o0.O000000o(cameraPosition));
        }
        Log.w("CameraUpdateFactory", "cameraPosition is null");
        return new CameraUpdate(O000O0o0.O00000o0());
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(O000O0o0.O000000o(latLng));
        }
        Log.w("CameraUpdateFactory", "latLng is null");
        return new CameraUpdate(O000O0o0.O00000o0());
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        if (latLngBounds != null) {
            return new CameraUpdate(O000O0o0.O000000o(latLngBounds, i));
        }
        Log.w("CameraUpdateFactory", "bounds is null");
        return new CameraUpdate(O000O0o0.O00000o0());
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        if (latLngBounds != null) {
            return new CameraUpdate(O000O0o0.O000000o(latLngBounds, i, i2, i3));
        }
        Log.w("CameraUpdateFactory", "bounds is null");
        return new CameraUpdate(O000O0o0.O00000o0());
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (latLngBounds != null) {
            return new CameraUpdate(O000O0o0.O000000o(latLngBounds, i, i2, i3, i4));
        }
        Log.w("CameraUpdateFactory", "bounds is null");
        return new CameraUpdate(O000O0o0.O00000o0());
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        if (latLng != null) {
            return new CameraUpdate(O000O0o0.O000000o(latLng, f));
        }
        Log.w("CameraUpdateFactory", "target is null");
        return new CameraUpdate(O000O0o0.O00000o0());
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(O000O0o0.O000000o(f, f2));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(O000O0o0.O00000Oo(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(O000O0o0.O000000o(f, point));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(O000O0o0.O000000o());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(O000O0o0.O00000Oo());
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(O000O0o0.O000000o(f));
    }
}
