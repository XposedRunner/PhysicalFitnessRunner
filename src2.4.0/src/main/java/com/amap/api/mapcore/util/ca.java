package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.ae.gmap.GLMapEngine;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.message.AbstractGestureMapMessage;

/* compiled from: IAMapDelegate */
public interface ca extends IAMap {
    float O000000o(int i);

    int O000000o(EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    int O000000o(IMarkerAction iMarkerAction, Rect rect);

    O0000O0o O000000o(BitmapDescriptor bitmapDescriptor);

    O0000O0o O000000o(BitmapDescriptor bitmapDescriptor, boolean z);

    LatLngBounds O000000o(LatLng latLng, float f, float f2, float f3);

    GLMapEngine O000000o();

    void O000000o(double d, double d2, FPoint fPoint);

    void O000000o(double d, double d2, IPoint iPoint);

    void O000000o(float f, float f2, IPoint iPoint);

    void O000000o(int i, float f);

    void O000000o(int i, int i2);

    void O000000o(int i, int i2, PointF pointF);

    void O000000o(int i, int i2, DPoint dPoint);

    void O000000o(int i, int i2, FPoint fPoint);

    void O000000o(int i, int i2, IPoint iPoint);

    void O000000o(int i, MotionEvent motionEvent);

    void O000000o(int i, IPoint iPoint);

    void O000000o(int i, AbstractGestureMapMessage abstractGestureMapMessage);

    void O000000o(Location location) throws RemoteException;

    void O000000o(O0000O0o o0000O0o);

    void O000000o(bi biVar) throws RemoteException;

    void O000000o(AMapWidgetListener aMapWidgetListener);

    void O000000o(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void O000000o(String str, boolean z, int i);

    void O000000o(boolean z);

    void O000000o(boolean z, boolean z2);

    void O000000o(boolean z, byte[] bArr);

    boolean O000000o(String str) throws RemoteException;

    void O00000Oo();

    void O00000Oo(double d, double d2, IPoint iPoint);

    void O00000Oo(int i, int i2);

    void O00000Oo(int i, int i2, DPoint dPoint);

    void O00000Oo(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void O00000Oo(boolean z);

    boolean O00000Oo(int i, MotionEvent motionEvent);

    boolean O00000Oo(String str);

    int O00000o();

    String O00000o(String str);

    void O00000o(boolean z);

    boolean O00000o(int i);

    GLMapState O00000o0();

    void O00000o0(int i);

    void O00000o0(String str);

    void O00000o0(boolean z);

    boolean O00000o0(int i, MotionEvent motionEvent);

    int O00000oO();

    void O00000oO(boolean z);

    boolean O00000oO(int i);

    int O00000oo(int i);

    void O00000oo();

    float O0000O0o();

    void O0000O0o(int i);

    float O0000OOo(int i);

    cd O0000OOo();

    void O0000OOo(boolean z);

    void O0000Oo();

    void O0000Oo(int i);

    void O0000Oo0();

    void O0000Oo0(int i);

    void O0000Oo0(boolean z);

    void O0000OoO(int i);

    boolean O0000OoO();

    float O0000Ooo(int i);

    Point O0000Ooo();

    void O0000o();

    float O0000o0(int i);

    boolean O0000o0();

    View O0000o00();

    float O0000o0O(int i);

    int O0000o0O();

    float O0000oOO();

    OO00O0o O0000oOo(int i);

    void O0000oo();

    float O0000oo0(int i);

    Context O0000oo0();

    float[] O0000ooO();

    OO00O O0000ooo();

    void O00oOooO();
}
