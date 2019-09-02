package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: CameraUpdateFactoryDelegate */
public class O000O0o0 {
    public static AbstractCameraUpdateMessage O000000o() {
        O000O0OO o000o0oo = new O000O0OO();
        o000o0oo.nowType = Type.zoomBy;
        o000o0oo.amount = 1.0f;
        return o000o0oo;
    }

    public static AbstractCameraUpdateMessage O000000o(float f) {
        O00oOooO o00oOooO = new O00oOooO();
        o00oOooO.nowType = Type.newCameraPosition;
        o00oOooO.zoom = f;
        return o00oOooO;
    }

    public static AbstractCameraUpdateMessage O000000o(float f, float f2) {
        O000O00o o000O00o = new O000O00o();
        o000O00o.nowType = Type.scrollBy;
        o000O00o.xPixel = f;
        o000O00o.yPixel = f2;
        return o000O00o;
    }

    public static AbstractCameraUpdateMessage O000000o(float f, Point point) {
        O000O0OO o000o0oo = new O000O0OO();
        o000o0oo.nowType = Type.zoomBy;
        o000o0oo.amount = f;
        o000o0oo.focus = point;
        return o000o0oo;
    }

    public static AbstractCameraUpdateMessage O000000o(Point point) {
        O00oOooO o00oOooO = new O00oOooO();
        o00oOooO.nowType = Type.newCameraPosition;
        o00oOooO.geoPoint = point;
        return o00oOooO;
    }

    public static AbstractCameraUpdateMessage O000000o(CameraPosition cameraPosition) {
        O00oOooO o00oOooO = new O00oOooO();
        o00oOooO.nowType = Type.newCameraPosition;
        if (cameraPosition == null || cameraPosition.target == null) {
            return o00oOooO;
        }
        o00oOooO.geoPoint = VirtualEarthProjection.latLongToPixels(cameraPosition.target.latitude, cameraPosition.target.longitude, 20);
        o00oOooO.zoom = cameraPosition.zoom;
        o00oOooO.bearing = cameraPosition.bearing;
        o00oOooO.tilt = cameraPosition.tilt;
        o00oOooO.cameraPosition = cameraPosition;
        return o00oOooO;
    }

    public static AbstractCameraUpdateMessage O000000o(LatLng latLng) {
        return O000000o(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage O000000o(LatLng latLng, float f) {
        return O000000o(CameraPosition.builder().target(latLng).zoom(f).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage O000000o(LatLngBounds latLngBounds, int i) {
        O0000o o0000o = new O0000o();
        o0000o.nowType = Type.newLatLngBounds;
        o0000o.bounds = latLngBounds;
        o0000o.paddingLeft = i;
        o0000o.paddingRight = i;
        o0000o.paddingTop = i;
        o0000o.paddingBottom = i;
        return o0000o;
    }

    public static AbstractCameraUpdateMessage O000000o(LatLngBounds latLngBounds, int i, int i2, int i3) {
        O0000o o0000o = new O0000o();
        o0000o.nowType = Type.newLatLngBoundsWithSize;
        o0000o.bounds = latLngBounds;
        o0000o.paddingLeft = i3;
        o0000o.paddingRight = i3;
        o0000o.paddingTop = i3;
        o0000o.paddingBottom = i3;
        o0000o.width = i;
        o0000o.height = i2;
        return o0000o;
    }

    public static AbstractCameraUpdateMessage O000000o(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        O0000o o0000o = new O0000o();
        o0000o.nowType = Type.newLatLngBounds;
        o0000o.bounds = latLngBounds;
        o0000o.paddingLeft = i;
        o0000o.paddingRight = i2;
        o0000o.paddingTop = i3;
        o0000o.paddingBottom = i4;
        return o0000o;
    }

    public static AbstractCameraUpdateMessage O00000Oo() {
        O000O0OO o000o0oo = new O000O0OO();
        o000o0oo.nowType = Type.zoomBy;
        o000o0oo.amount = -1.0f;
        return o000o0oo;
    }

    public static AbstractCameraUpdateMessage O00000Oo(float f) {
        return O000000o(f, null);
    }

    public static AbstractCameraUpdateMessage O00000Oo(float f, Point point) {
        O00oOooO o00oOooO = new O00oOooO();
        o00oOooO.nowType = Type.newCameraPosition;
        o00oOooO.geoPoint = point;
        o00oOooO.bearing = f;
        return o00oOooO;
    }

    public static AbstractCameraUpdateMessage O00000o(float f) {
        O00oOooO o00oOooO = new O00oOooO();
        o00oOooO.nowType = Type.newCameraPosition;
        o00oOooO.bearing = f;
        return o00oOooO;
    }

    public static AbstractCameraUpdateMessage O00000o0() {
        return new O00oOooO();
    }

    public static AbstractCameraUpdateMessage O00000o0(float f) {
        O00oOooO o00oOooO = new O00oOooO();
        o00oOooO.nowType = Type.newCameraPosition;
        o00oOooO.tilt = f;
        return o00oOooO;
    }
}
