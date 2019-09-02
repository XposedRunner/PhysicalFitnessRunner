package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.AMap.CommonInfoWindowAdapter;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.OnCacheRemoveListener;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.AMap.OnIndoorBuildingActiveListener;
import com.amap.api.maps.AMap.OnInfoWindowClickListener;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMapLongClickListener;
import com.amap.api.maps.AMap.OnMapScreenShotListener;
import com.amap.api.maps.AMap.OnMapTouchListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.AMap.OnMarkerDragListener;
import com.amap.api.maps.AMap.OnMultiPointClickListener;
import com.amap.api.maps.AMap.OnMyLocationChangeListener;
import com.amap.api.maps.AMap.OnPOIClickListener;
import com.amap.api.maps.AMap.OnPolylineClickListener;
import com.amap.api.maps.AMap.onMapPrintScreenListener;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.ae.gmap.GLMapEngine;
import com.autonavi.ae.gmap.GLMapEngine.MapViewInitParam;
import com.autonavi.ae.gmap.GLMapRender;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.glinterface.MapLabelItem;
import com.autonavi.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.ae.gmap.style.StyleItem;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type;
import com.autonavi.amap.mapcore.AeUtil;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import com.autonavi.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.amap.mapcore.tools.GLConvertUtil;
import com.tencent.stat.DeviceInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: AMapDelegateImp */
public class O00o000 implements com.amap.api.mapcore.util.OO0O00o.O000000o, ca, IAMapListener {
    protected boolean O000000o = false;
    protected final O00000Oo O00000Oo;
    protected O00O0Oo O00000o;
    protected MapConfig O00000o0 = new MapConfig(true);
    OOOO0 O00000oO = null;
    protected Context O00000oo;
    protected GLMapEngine O0000O0o;
    public int O0000OOo;
    protected final Handler O0000Oo = new Handler(Looper.getMainLooper()) {
        public void handleMessage(android.os.Message r7) {
            /*
            r6 = this;
            if (r7 == 0) goto L_0x028c;
        L_0x0002:
            r0 = com.amap.api.mapcore.util.O00o000.this;
            r0 = r0.O00O0Oo;
            if (r0 == 0) goto L_0x000c;
        L_0x000a:
            goto L_0x028c;
        L_0x000c:
            r0 = r7.what;	 Catch:{ Throwable -> 0x0280 }
            r1 = 2;
            if (r0 == r1) goto L_0x0258;
        L_0x0011:
            r1 = 1;
            r2 = 0;
            switch(r0) {
                case 10: goto L_0x0240;
                case 11: goto L_0x01de;
                case 12: goto L_0x01c1;
                case 13: goto L_0x01ae;
                case 14: goto L_0x018a;
                case 15: goto L_0x00ec;
                case 16: goto L_0x00bc;
                case 17: goto L_0x0088;
                case 18: goto L_0x006d;
                case 19: goto L_0x0034;
                case 20: goto L_0x0018;
                default: goto L_0x0016;
            };
        L_0x0016:
            goto L_0x028b;
        L_0x0018:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0027 }
            r0 = r0.O000O00o;	 Catch:{ Throwable -> 0x0027 }
            r7 = r7.obj;	 Catch:{ Throwable -> 0x0027 }
            r7 = (com.amap.api.maps.model.Poi) r7;	 Catch:{ Throwable -> 0x0027 }
            r0.onPOIClick(r7);	 Catch:{ Throwable -> 0x0027 }
            goto L_0x028b;
        L_0x0027:
            r7 = move-exception;
            r0 = "AMapDelegateImp";
            r1 = "OnPOIClickListener.onPOIClick";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r7, r0, r1);	 Catch:{ Throwable -> 0x0280 }
            r7.printStackTrace();	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x0034:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O00oOooO;	 Catch:{ Throwable -> 0x0280 }
            if (r0 == 0) goto L_0x028b;
        L_0x003c:
            r0 = com.autonavi.amap.mapcore.DPoint.obtain();	 Catch:{ Throwable -> 0x0280 }
            r1 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r2 = r7.arg1;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.arg2;	 Catch:{ Throwable -> 0x0280 }
            r1.O00000Oo(r2, r7, r0);	 Catch:{ Throwable -> 0x0280 }
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0060 }
            r7 = r7.O00oOooO;	 Catch:{ Throwable -> 0x0060 }
            r1 = new com.amap.api.maps.model.LatLng;	 Catch:{ Throwable -> 0x0060 }
            r2 = r0.y;	 Catch:{ Throwable -> 0x0060 }
            r4 = r0.x;	 Catch:{ Throwable -> 0x0060 }
            r1.<init>(r2, r4);	 Catch:{ Throwable -> 0x0060 }
            r7.onMapClick(r1);	 Catch:{ Throwable -> 0x0060 }
            r0.recycle();	 Catch:{ Throwable -> 0x0060 }
            goto L_0x028b;
        L_0x0060:
            r7 = move-exception;
            r0 = "AMapDelegateImp";
            r1 = "OnMapClickListener.onMapClick";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r7, r0, r1);	 Catch:{ Throwable -> 0x0280 }
            r7.printStackTrace();	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x006d:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000OO0o;	 Catch:{ Throwable -> 0x0280 }
            if (r7 == 0) goto L_0x028b;
        L_0x0075:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000Ooo;	 Catch:{ Throwable -> 0x0280 }
            if (r7 == 0) goto L_0x028b;
        L_0x007d:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000OO0o;	 Catch:{ Throwable -> 0x0280 }
            r7.O00000o0();	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x0088:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O0000O0o;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.isInMapAnimation(r1);	 Catch:{ Throwable -> 0x0280 }
            if (r0 == 0) goto L_0x00a3;
        L_0x0092:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000Oo0;	 Catch:{ Throwable -> 0x0280 }
            if (r0 == 0) goto L_0x00a3;
        L_0x009a:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000Oo0;	 Catch:{ Throwable -> 0x0280 }
            r0.O00000Oo(r2);	 Catch:{ Throwable -> 0x0280 }
        L_0x00a3:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000Oo0;	 Catch:{ Throwable -> 0x0280 }
            if (r0 == 0) goto L_0x028b;
        L_0x00ab:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000Oo0;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.arg1;	 Catch:{ Throwable -> 0x0280 }
            if (r7 == 0) goto L_0x00b6;
        L_0x00b5:
            goto L_0x00b7;
        L_0x00b6:
            r1 = r2;
        L_0x00b7:
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x00bc:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O0000ooO;	 Catch:{ Throwable -> 0x0280 }
            if (r7 == 0) goto L_0x00d9;
        L_0x00c4:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x00ce }
            r7 = r7.O0000ooO;	 Catch:{ Throwable -> 0x00ce }
            r7.onMapLoaded();	 Catch:{ Throwable -> 0x00ce }
            goto L_0x00d9;
        L_0x00ce:
            r7 = move-exception;
            r0 = "AMapDelegateImp";
            r1 = "onMapLoaded";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r7, r0, r1);	 Catch:{ Throwable -> 0x0280 }
            r7.printStackTrace();	 Catch:{ Throwable -> 0x0280 }
        L_0x00d9:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            if (r7 == 0) goto L_0x028b;
        L_0x00e1:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            r7.O0000o0();	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x00ec:
            r0 = r7.obj;	 Catch:{ Throwable -> 0x0280 }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.arg1;	 Catch:{ Throwable -> 0x0280 }
            r1 = 0;
            if (r0 == 0) goto L_0x0153;
        L_0x00f5:
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r2 = r2.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            if (r2 == 0) goto L_0x0153;
        L_0x00fd:
            r2 = new android.graphics.Canvas;	 Catch:{ Throwable -> 0x0280 }
            r2.<init>(r0);	 Catch:{ Throwable -> 0x0280 }
            r3 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r3 = r3.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            r3 = r3.O0000Oo0();	 Catch:{ Throwable -> 0x0280 }
            if (r3 == 0) goto L_0x0111;
        L_0x010e:
            r3.onDraw(r2);	 Catch:{ Throwable -> 0x0280 }
        L_0x0111:
            r3 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r3 = r3.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            r3.O000000o(r2);	 Catch:{ Throwable -> 0x0280 }
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r2 = r2.O000O0oO;	 Catch:{ Throwable -> 0x0280 }
            if (r2 == 0) goto L_0x0138;
        L_0x0122:
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r2 = r2.O000O0oO;	 Catch:{ Throwable -> 0x0280 }
            r3 = new android.graphics.drawable.BitmapDrawable;	 Catch:{ Throwable -> 0x0280 }
            r4 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r4 = r4.O00000oo;	 Catch:{ Throwable -> 0x0280 }
            r4 = r4.getResources();	 Catch:{ Throwable -> 0x0280 }
            r3.<init>(r4, r0);	 Catch:{ Throwable -> 0x0280 }
            r2.onMapPrint(r3);	 Catch:{ Throwable -> 0x0280 }
        L_0x0138:
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r2 = r2.O000O0oo;	 Catch:{ Throwable -> 0x0280 }
            if (r2 == 0) goto L_0x017e;
        L_0x0140:
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r2 = r2.O000O0oo;	 Catch:{ Throwable -> 0x0280 }
            r2.onMapScreenShot(r0);	 Catch:{ Throwable -> 0x0280 }
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r2 = r2.O000O0oo;	 Catch:{ Throwable -> 0x0280 }
            r2.onMapScreenShot(r0, r7);	 Catch:{ Throwable -> 0x0280 }
            goto L_0x017e;
        L_0x0153:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000O0oO;	 Catch:{ Throwable -> 0x0280 }
            if (r0 == 0) goto L_0x0164;
        L_0x015b:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000O0oO;	 Catch:{ Throwable -> 0x0280 }
            r0.onMapPrint(r1);	 Catch:{ Throwable -> 0x0280 }
        L_0x0164:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000O0oo;	 Catch:{ Throwable -> 0x0280 }
            if (r0 == 0) goto L_0x017e;
        L_0x016c:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000O0oo;	 Catch:{ Throwable -> 0x0280 }
            r0.onMapScreenShot(r1);	 Catch:{ Throwable -> 0x0280 }
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O000O0oo;	 Catch:{ Throwable -> 0x0280 }
            r0.onMapScreenShot(r1, r7);	 Catch:{ Throwable -> 0x0280 }
        L_0x017e:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7.O000O0oO = r1;	 Catch:{ Throwable -> 0x0280 }
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7.O000O0oo = r1;	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x018a:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x01a1 }
            r0 = r0.O00oOooo;	 Catch:{ Throwable -> 0x01a1 }
            if (r0 == 0) goto L_0x028b;
        L_0x0192:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x01a1 }
            r0 = r0.O00oOooo;	 Catch:{ Throwable -> 0x01a1 }
            r7 = r7.obj;	 Catch:{ Throwable -> 0x01a1 }
            r7 = (android.view.MotionEvent) r7;	 Catch:{ Throwable -> 0x01a1 }
            r0.onTouch(r7);	 Catch:{ Throwable -> 0x01a1 }
            goto L_0x028b;
        L_0x01a1:
            r7 = move-exception;
            r0 = "AMapDelegateImp";
            r1 = "onTouchHandler";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r7, r0, r1);	 Catch:{ Throwable -> 0x0280 }
            r7.printStackTrace();	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x01ae:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            if (r7 == 0) goto L_0x028b;
        L_0x01b6:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            r7.O0000o00();	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x01c1:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            if (r7 == 0) goto L_0x028b;
        L_0x01c9:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r7 = r7.O000Oo00;	 Catch:{ Throwable -> 0x0280 }
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O0000O0o();	 Catch:{ Throwable -> 0x0280 }
            r0 = java.lang.Float.valueOf(r0);	 Catch:{ Throwable -> 0x0280 }
            r7.O000000o(r0);	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x01de:
            r7 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r7 = r7.getCameraPosition();	 Catch:{ Throwable -> 0x0237 }
            if (r7 == 0) goto L_0x01f7;
        L_0x01e6:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0 = r0.O000Oo00;	 Catch:{ Throwable -> 0x0237 }
            if (r0 == 0) goto L_0x01f7;
        L_0x01ee:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0 = r0.O000Oo00;	 Catch:{ Throwable -> 0x0237 }
            r0.O000000o(r7);	 Catch:{ Throwable -> 0x0237 }
        L_0x01f7:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0.O000000o(r7);	 Catch:{ Throwable -> 0x0237 }
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0 = r0.O000ooo0;	 Catch:{ Throwable -> 0x0237 }
            if (r0 == 0) goto L_0x021f;
        L_0x0204:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0.O000ooo0 = r2;	 Catch:{ Throwable -> 0x0237 }
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0 = r0.O000Oo0;	 Catch:{ Throwable -> 0x0237 }
            if (r0 == 0) goto L_0x021a;
        L_0x0211:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0 = r0.O000Oo0;	 Catch:{ Throwable -> 0x0237 }
            r0.O00000Oo(r2);	 Catch:{ Throwable -> 0x0237 }
        L_0x021a:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0.O0000O0o(r1);	 Catch:{ Throwable -> 0x0237 }
        L_0x021f:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0 = r0.O000o0O;	 Catch:{ Throwable -> 0x0237 }
            if (r0 == 0) goto L_0x0231;
        L_0x0227:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0.O0000Oo();	 Catch:{ Throwable -> 0x0237 }
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0.O000o0O = r2;	 Catch:{ Throwable -> 0x0237 }
        L_0x0231:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0237 }
            r0.O000000o(r1, r7);	 Catch:{ Throwable -> 0x0237 }
            goto L_0x028b;
        L_0x0237:
            r7 = move-exception;
            r0 = "AMapDelegateImp";
            r1 = "CameraUpdateFinish";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r7, r0, r1);	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x0240:
            r7 = r7.obj;	 Catch:{ Throwable -> 0x0280 }
            r7 = (com.amap.api.maps.model.CameraPosition) r7;	 Catch:{ Throwable -> 0x0280 }
            if (r7 == 0) goto L_0x028b;
        L_0x0246:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O0000ooo;	 Catch:{ Throwable -> 0x0280 }
            if (r0 == 0) goto L_0x028b;
        L_0x024e:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0280 }
            r0 = r0.O0000ooo;	 Catch:{ Throwable -> 0x0280 }
            r0.onCameraChange(r7);	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x0258:
            r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0280 }
            r0.<init>();	 Catch:{ Throwable -> 0x0280 }
            r1 = "Key验证失败：[";
            r0.append(r1);	 Catch:{ Throwable -> 0x0280 }
            r1 = r7.obj;	 Catch:{ Throwable -> 0x0280 }
            if (r1 == 0) goto L_0x026c;
        L_0x0266:
            r7 = r7.obj;	 Catch:{ Throwable -> 0x0280 }
            r0.append(r7);	 Catch:{ Throwable -> 0x0280 }
            goto L_0x0271;
        L_0x026c:
            r7 = com.amap.api.mapcore.util.o0O0O0o0.O00000Oo;	 Catch:{ Throwable -> 0x0280 }
            r0.append(r7);	 Catch:{ Throwable -> 0x0280 }
        L_0x0271:
            r7 = "]";
            r0.append(r7);	 Catch:{ Throwable -> 0x0280 }
            r7 = "amapsdk";
            r0 = r0.toString();	 Catch:{ Throwable -> 0x0280 }
            android.util.Log.w(r7, r0);	 Catch:{ Throwable -> 0x0280 }
            goto L_0x028b;
        L_0x0280:
            r7 = move-exception;
            r0 = "AMapDelegateImp";
            r1 = "handleMessage";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r7, r0, r1);
            r7.printStackTrace();
        L_0x028b:
            return;
        L_0x028c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00o000$AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    public int O0000Oo0;
    Point O0000OoO = new Point();
    Rect O0000Ooo = new Rect();
    float[] O0000o = new float[12];
    float[] O0000o0 = new float[16];
    protected String O0000o00 = null;
    float[] O0000o0O = new float[16];
    float[] O0000o0o = new float[16];
    String O0000oO = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
    String O0000oO0 = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
    int O0000oOO = -1;
    private OnMarkerClickListener O0000oOo;
    private OnMarkerDragListener O0000oo;
    private OnPolylineClickListener O0000oo0;
    private OnMapLoadedListener O0000ooO;
    private OnCameraChangeListener O0000ooo;
    private OnPOIClickListener O000O00o;
    private OnMapLongClickListener O000O0OO;
    private OnInfoWindowClickListener O000O0Oo;
    private o0oOo0O0 O000O0o;
    private OnMyLocationChangeListener O000O0o0;
    private onMapPrintScreenListener O000O0oO = null;
    private OnMapScreenShotListener O000O0oo = null;
    private OO000o O000OO = null;
    private AMapGestureListener O000OO00;
    private O000o00 O000OO0o;
    private UiSettings O000OOOo;
    private final O0000o0 O000OOo;
    private cc O000OOo0;
    private boolean O000OOoO = false;
    private final cb O000OOoo;
    private final O0000o00 O000Oo0;
    private fv O000Oo00;
    private final by O000Oo0O;
    private boolean O000Oo0o = false;
    private bv O000OoO;
    private int O000OoO0;
    private AMapWidgetListener O000OoOO;
    private boolean O000OoOo = false;
    private boolean O000Ooo = false;
    private boolean O000Ooo0 = false;
    private ooO0Ooo O000OooO;
    private LocationSource O000Oooo;
    private Thread O000o;
    private boolean O000o0 = false;
    private Marker O000o00 = null;
    private boolean O000o000 = false;
    private bi O000o00O = null;
    private boolean O000o00o = false;
    private boolean O000o0O = false;
    private boolean O000o0O0 = false;
    private boolean O000o0OO = false;
    private boolean O000o0Oo = true;
    private int O000o0o = 1;
    private Rect O000o0o0 = new Rect();
    private MyTrafficStyle O000o0oo = null;
    private int O000oO = 0;
    private boolean O000oO0 = false;
    private Thread O000oO00;
    private boolean O000oO0O = false;
    private boolean O000oO0o = false;
    private final O00000o0 O000oOO;
    private CustomRenderer O000oOO0;
    private int O000oOOO = -1;
    private int O000oOOo = -1;
    private OO00Oo0 O000oOo;
    private List<O0000O0o> O000oOo0 = new ArrayList();
    private OO0O00o O000oOoO;
    private Oo O000oOoo;
    private float O000oo = 0.0f;
    private GLMapRender O000oo0;
    private bw O000oo0O;
    private boolean O000oo0o = false;
    private float O000ooO = 1.0f;
    private float O000ooO0 = 1.0f;
    private boolean O000ooOO = true;
    private boolean O000ooOo = false;
    private int O000ooo = 0;
    private boolean O000ooo0 = false;
    private volatile boolean O000oooO = false;
    private volatile boolean O000oooo = false;
    private Lock O00O000o = new ReentrantLock();
    private int O00O00Oo = 0;
    private int O00O00o;
    private int O00O00o0;
    private O00000Oo O00O00oO;
    private OO00O O00O00oo;
    private bz O00O0O0o;
    private O00O00o0 O00O0OO;
    private O000o O00O0OOo;
    private boolean O00O0Oo = false;
    private O000000o O00O0Oo0 = new O000000o() {
        public void run() {
            super.run();
            try {
                O00o000.this.setTrafficEnabled(this.O00000o0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private O000000o O00O0OoO = new O000000o() {
        public void run() {
            super.run();
            try {
                O00o000.this.setCenterToPixel(O00o000.this.O00O00o0, O00o000.this.O00O00o);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private O000000o O00O0Ooo = new O000000o() {
        public void run() {
            super.run();
            O00o000.this.O00000Oo(this.O0000O0o, this.O00000o, this.O00000oO, this.O00000oo);
        }
    };
    private O000000o O00O0o = new O000000o() {
        public void run() {
            super.run();
            try {
                O00o000.this.setIndoorEnabled(this.O00000o0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private O000000o O00O0o0 = new O000000o() {
        public void run() {
            super.run();
            O00o000.this.O000000o(this.O0000O0o, this.O00000o0);
        }
    };
    private O000000o O00O0o00 = new O000000o() {
        public void run() {
            super.run();
            O00o000.this.setMapCustomEnable(this.O00000o0);
        }
    };
    private O000000o O00O0o0O = new O000000o() {
        public void run() {
            super.run();
            try {
                O00o000.this.setMapTextEnable(this.O00000o0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private O000000o O00O0o0o = new O000000o() {
        public void run() {
            super.run();
            O00o000.this.O00000Oo(this.O0000O0o, this.O00000o0);
        }
    };
    private Runnable O00O0oO0 = new Runnable() {
        public void run() {
            if (O00o000.this.O000Oo00 != null) {
                fy O0000Oo0 = O00o000.this.O000Oo00.O0000Oo0();
                if (O0000Oo0 != null) {
                    O0000Oo0.O00000o();
                }
            }
        }
    };
    private O000000o O00O0oOO = new O000000o() {
        public void run() {
            super.run();
            O00o000.this.O00000o0(this.O0000O0o, this.O00000o0);
        }
    };
    private O000000o O00O0oOo = new O000000o() {
        public void run() {
            super.run();
            try {
                O00o000.this.setMyTrafficStyle(O00o000.this.O000o0oo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private long O00O0oo = 0;
    private EAMapPlatformGestureInfo O00O0oo0 = new EAMapPlatformGestureInfo();
    private O00O0Oo O00O0ooO = null;
    private IPoint[] O00O0ooo = null;
    private boolean O00oOOoo = false;
    private OnIndoorBuildingActiveListener O00oOoOo;
    private OnMapClickListener O00oOooO;
    private OnMapTouchListener O00oOooo;
    private boolean oooOoO = false;

    /* compiled from: AMapDelegateImp */
    private static abstract class O000000o implements Runnable {
        boolean O00000Oo;
        int O00000o;
        boolean O00000o0;
        int O00000oO;
        int O00000oo;
        int O0000O0o;

        private O000000o() {
            this.O00000Oo = false;
            this.O00000o0 = false;
        }

        /* synthetic */ O000000o(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void run() {
            this.O00000Oo = false;
        }
    }

    /* compiled from: AMapDelegateImp */
    /* renamed from: com.amap.api.mapcore.util.O00o000$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ int O00000o;
        final /* synthetic */ int O00000o0;
        final /* synthetic */ boolean O00000oO;
        final /* synthetic */ boolean O00000oo;
        final /* synthetic */ StyleItem[] O0000O0o;

        AnonymousClass4(int i, int i2, int i3, int i4, boolean z, boolean z2, StyleItem[] styleItemArr) {
            this.O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
            this.O00000o = i4;
            this.O00000oO = z;
            this.O00000oo = z2;
            this.O0000O0o = styleItemArr;
        }

        public void run() {
            try {
                O00o000.this.O0000O0o.setMapModeAndStyle(this.O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp */
    class O00000Oo {
        O00000Oo() {
        }

        public void O000000o(O00O0Oo o00O0Oo) {
            if (O00o000.this.O00000o0 != null && O00o000.this.O00000o0.isIndoorEnable()) {
                final ft O0000O0o = O00o000.this.O000Oo00.O0000O0o();
                float f = 20.0f;
                if (o00O0Oo == null) {
                    try {
                        if (O00o000.this.O00oOoOo != null) {
                            O00o000.this.O00oOoOo.OnIndoorBuilding(o00O0Oo);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (O00o000.this.O00000o != null) {
                        O00o000.this.O00000o.O0000O0o = null;
                    }
                    if (O0000O0o.O00000o()) {
                        O00o000.this.O0000Oo.post(new Runnable() {
                            public void run() {
                                O0000O0o.O000000o(false);
                            }
                        });
                    }
                    O00o000.this.O00000o0.maxZoomLevel = O00o000.this.O00000o0.isSetLimitZoomLevel() ? O00o000.this.O00000o0.getMaxZoomLevel() : 20.0f;
                    try {
                        if (O00o000.this.O000OOo.isZoomControlsEnabled() && O00o000.this.O000OoOO != null) {
                            O00o000.this.O000OoOO.invalidateZoomController(O00o000.this.O00000o0.getSZ());
                        }
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (o00O0Oo != null && o00O0Oo.floor_indexs != null && o00O0Oo.floor_names != null && o00O0Oo.floor_indexs.length == o00O0Oo.floor_names.length) {
                    for (int i = 0; i < o00O0Oo.floor_indexs.length; i++) {
                        if (o00O0Oo.activeFloorIndex == o00O0Oo.floor_indexs[i]) {
                            o00O0Oo.activeFloorName = o00O0Oo.floor_names[i];
                            break;
                        }
                    }
                }
                if (o00O0Oo == null || O00o000.this.O00000o == null || O00o000.this.O00000o.activeFloorIndex == o00O0Oo.activeFloorIndex || !O0000O0o.O00000o()) {
                    if (o00O0Oo != null && (O00o000.this.O00000o == null || !O00o000.this.O00000o.poiid.equals(o00O0Oo.poiid) || O00o000.this.O00000o.O0000O0o == null)) {
                        O00o000.this.O00000o = o00O0Oo;
                        if (O00o000.this.O00000o0 != null) {
                            O00o000.this.O00000o.O0000O0o = O00o000.this.O00000o0.getMapGeoCenter();
                        }
                    }
                    try {
                        if (O00o000.this.O00oOoOo != null) {
                            O00o000.this.O00oOoOo.OnIndoorBuilding(o00O0Oo);
                        }
                        MapConfig mapConfig = O00o000.this.O00000o0;
                        if (O00o000.this.O00000o0.isSetLimitZoomLevel()) {
                            f = O00o000.this.O00000o0.getMaxZoomLevel();
                        }
                        mapConfig.maxZoomLevel = f;
                        if (O00o000.this.O000OOo.isZoomControlsEnabled() && O00o000.this.O000OoOO != null) {
                            O00o000.this.O000OoOO.invalidateZoomController(O00o000.this.O00000o0.getSZ());
                        }
                        if (O00o000.this.O000OOo.isIndoorSwitchEnabled()) {
                            if (!O0000O0o.O00000o()) {
                                O00o000.this.O000OOo.setIndoorSwitchEnabled(true);
                            }
                            O00o000.this.O0000Oo.post(new Runnable() {
                                public void run() {
                                    try {
                                        O0000O0o.O000000o(O00o000.this.O00000o.floor_names);
                                        O0000O0o.O000000o(O00o000.this.O00000o.activeFloorName);
                                        if (!O0000O0o.O00000o()) {
                                            O0000O0o.O000000o(true);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                        } else if (!O00o000.this.O000OOo.isIndoorSwitchEnabled() && O0000O0o.O00000o()) {
                            O00o000.this.O000OOo.setIndoorSwitchEnabled(false);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        }
    }

    /* compiled from: AMapDelegateImp */
    private class O00000o0 implements com.amap.api.mapcore.util.ft.O000000o {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(O00o000 o00o000, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void O000000o(int i) {
            if (O00o000.this.O00000o != null) {
                O00o000.this.O00000o.activeFloorIndex = O00o000.this.O00000o.floor_indexs[i];
                O00o000.this.O00000o.activeFloorName = O00o000.this.O00000o.floor_names[i];
                try {
                    O00o000.this.setIndoorBuildingInfo(O00o000.this.O00000o);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: AMapDelegateImp */
    private class O00000o implements Runnable {
        private Context O00000Oo;
        private OnCacheRemoveListener O00000o0;

        public O00000o(Context context, OnCacheRemoveListener onCacheRemoveListener) {
            this.O00000Oo = context;
            this.O00000o0 = onCacheRemoveListener;
        }

        public boolean equals(Object obj) {
            return obj instanceof O00000o;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A:{Catch:{ Throwable -> 0x006d }} */
        public void run() {
            /*
            r6 = this;
            r0 = 0;
            r1 = 1;
            r2 = r6.O00000Oo;	 Catch:{ Throwable -> 0x006d }
            r2 = r2.getApplicationContext();	 Catch:{ Throwable -> 0x006d }
            r3 = com.amap.api.mapcore.util.OOo000.O00000o0(r2);	 Catch:{ Throwable -> 0x006d }
            r4 = com.amap.api.mapcore.util.OOo000.O000000o(r2);	 Catch:{ Throwable -> 0x006d }
            r5 = new java.io.File;	 Catch:{ Throwable -> 0x006d }
            r5.<init>(r3);	 Catch:{ Throwable -> 0x006d }
            r3 = r5.exists();	 Catch:{ Throwable -> 0x006d }
            if (r3 == 0) goto L_0x0024;
        L_0x001b:
            r3 = com.autonavi.amap.mapcore.FileUtil.deleteFile(r5);	 Catch:{ Throwable -> 0x006d }
            if (r3 == 0) goto L_0x0022;
        L_0x0021:
            goto L_0x0024;
        L_0x0022:
            r3 = r0;
            goto L_0x0025;
        L_0x0024:
            r3 = r1;
        L_0x0025:
            if (r3 == 0) goto L_0x003a;
        L_0x0027:
            r5 = new java.io.File;	 Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            r5.<init>(r4);	 Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            r4 = com.autonavi.amap.mapcore.FileUtil.deleteFile(r5);	 Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            if (r4 == 0) goto L_0x003a;
        L_0x0032:
            r3 = r1;
            goto L_0x003b;
        L_0x0034:
            r0 = move-exception;
            r1 = r3;
            goto L_0x0085;
        L_0x0037:
            r2 = move-exception;
            r1 = r3;
            goto L_0x006e;
        L_0x003a:
            r3 = r0;
        L_0x003b:
            if (r3 == 0) goto L_0x0044;
        L_0x003d:
            r2 = com.amap.api.mapcore.util.OOo000.O00000oO(r2);	 Catch:{ Throwable -> 0x0037, all -> 0x0034 }
            if (r2 == 0) goto L_0x0044;
        L_0x0043:
            goto L_0x0045;
        L_0x0044:
            r1 = r0;
        L_0x0045:
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x006d }
            r2 = r2.O000Oo0;	 Catch:{ Throwable -> 0x006d }
            if (r2 == 0) goto L_0x0056;
        L_0x004d:
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x006d }
            r2 = r2.O000Oo0;	 Catch:{ Throwable -> 0x006d }
            r2.O0000OOo();	 Catch:{ Throwable -> 0x006d }
        L_0x0056:
            r0 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0066 }
            r0 = r0.O0000O0o;	 Catch:{ Throwable -> 0x0066 }
            if (r0 == 0) goto L_0x0084;
        L_0x005c:
            r0 = r6.O00000o0;	 Catch:{ Throwable -> 0x0066 }
            if (r0 == 0) goto L_0x0084;
        L_0x0060:
            r0 = r6.O00000o0;	 Catch:{ Throwable -> 0x0066 }
            r0.onRemoveCacheFinish(r1);	 Catch:{ Throwable -> 0x0066 }
            goto L_0x0084;
        L_0x0066:
            r0 = move-exception;
            r0.printStackTrace();
            goto L_0x0084;
        L_0x006b:
            r0 = move-exception;
            goto L_0x0085;
        L_0x006d:
            r2 = move-exception;
        L_0x006e:
            r3 = "AMapDelegateImp";
            r4 = "RemoveCacheRunnable";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r2, r3, r4);	 Catch:{ all -> 0x006b }
            r1 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0066 }
            r1 = r1.O0000O0o;	 Catch:{ Throwable -> 0x0066 }
            if (r1 == 0) goto L_0x0084;
        L_0x007b:
            r1 = r6.O00000o0;	 Catch:{ Throwable -> 0x0066 }
            if (r1 == 0) goto L_0x0084;
        L_0x007f:
            r1 = r6.O00000o0;	 Catch:{ Throwable -> 0x0066 }
            r1.onRemoveCacheFinish(r0);	 Catch:{ Throwable -> 0x0066 }
        L_0x0084:
            return;
        L_0x0085:
            r2 = com.amap.api.mapcore.util.O00o000.this;	 Catch:{ Throwable -> 0x0095 }
            r2 = r2.O0000O0o;	 Catch:{ Throwable -> 0x0095 }
            if (r2 == 0) goto L_0x0099;
        L_0x008b:
            r2 = r6.O00000o0;	 Catch:{ Throwable -> 0x0095 }
            if (r2 == 0) goto L_0x0099;
        L_0x008f:
            r2 = r6.O00000o0;	 Catch:{ Throwable -> 0x0095 }
            r2.onRemoveCacheFinish(r1);	 Catch:{ Throwable -> 0x0095 }
            goto L_0x0099;
        L_0x0095:
            r1 = move-exception;
            r1.printStackTrace();
        L_0x0099:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00o000$O00000o.run():void");
        }
    }

    public O00o000(cb cbVar, Context context, AttributeSet attributeSet) {
        this.O00000oo = context;
        this.O000oOoo = new Oo(context, this, cbVar);
        ooOOOOoo.O000000o(this.O00000oo);
        OOO0O0O.O000000o().O000000o(this.O00000oo);
        bu.O00000Oo = o0O0O0Oo.O00000o0(context);
        OO0Oo0.O000000o(this.O00000oo);
        this.O000oo0O = new bw(this);
        this.O0000O0o = new GLMapEngine(this.O00000oo, this);
        this.O000oo0 = new GLMapRender(this);
        this.O000OOoo = cbVar;
        cbVar.setRenderer(this.O000oo0);
        this.O000OOo = new O0000o0(this);
        this.O000Oo00 = new fv(this.O00000oo, this);
        this.O000Oo00.O000000o(new O00000o0(this, null));
        this.O00O00oO = new O00000Oo();
        this.O000Oo0O = new by(this);
        this.O000Oo0 = new O0000o00(this.O00000oo, this);
        this.O00000Oo = new O00000Oo(this.O00000oo, this);
        this.O000OoO = new bv(this.O00000oo, this);
        this.O000OOoo.setRenderMode(0);
        this.O000oo0.setRenderFps(15.0f);
        this.O0000O0o.setMapListener(this);
        this.O000OOo0 = new O0000Oo0(this);
        this.O000O0o = new o0oOo0O0(this);
        this.O000OO = new OO000o(this, context);
        this.O000OO0o = new O000o00(this.O00000oo);
        this.O000OO0o.O000000o(this.O000Oo00);
        this.O000OO0o.O00000Oo(this.O000OO);
        this.O000oOO = new O00000o0();
        this.O000o = new g(this.O00000oo, this);
        this.O000Oooo = new O000o0(this.O00000oo);
        this.O00O0OO = new O00O00o0(this);
        this.O00O0O0o = new bz();
        this.O000oOo = new OO00Oo0(this.O00000oo, this);
        this.O000oOoO = new OO0O00o(this.O00000oo);
        this.O000oOoO.O000000o((com.amap.api.mapcore.util.OO0O00o.O000000o) this);
        this.O00O0OOo = new O000o(this, this.O00000oo);
    }

    private void O000000o(int i, GL10 gl10) {
        if (this.O000oOOo != -1) {
            this.O000oo0.setRenderFps((float) this.O000oOOo);
            resetRenderTime();
        } else if (this.O0000O0o.isInMapAction(i) || this.O000ooOo) {
            this.O000oo0.setRenderFps(40.0f);
        } else if (this.O0000O0o.isInMapAnimation(i)) {
            this.O000oo0.setRenderFps(30.0f);
            this.O000oo0.resetTickCount(15);
        } else {
            this.O000oo0.setRenderFps(15.0f);
        }
        if (this.O00000o0.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            O0000O0o(true);
            this.O00000o0.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    private void O000000o(MotionEvent motionEvent) throws RemoteException {
        if (this.O000o000 && this.O000o00 != null && this.O000o00O != null) {
            int x = (int) motionEvent.getX();
            int y = (int) (motionEvent.getY() - 60.0f);
            LatLng O00000o0 = this.O000o00O.O00000o0();
            if (O00000o0 != null) {
                LatLng position = this.O000o00O.getPosition();
                DPoint obtain = DPoint.obtain();
                O00000Oo(x, y, obtain);
                LatLng latLng = new LatLng((position.latitude + obtain.y) - O00000o0.latitude, (position.longitude + obtain.x) - O00000o0.longitude);
                obtain.recycle();
                this.O000o00.setPosition(latLng);
                if (this.O0000oo != null) {
                    this.O0000oo.onMarkerDrag(this.O000o00);
                }
            }
        }
    }

    private void O000000o(CameraPosition cameraPosition) {
        if (this.O00000o0.getMapLanguage().equals(AMap.ENGLISH)) {
            boolean O00000Oo = O00000Oo(cameraPosition);
            if (O00000Oo != this.O000o0Oo) {
                this.O000o0Oo = O00000Oo;
                O00000Oo(1, this.O000o0Oo);
            }
        } else if (!this.O000o0Oo) {
            this.O000o0Oo = true;
            O00000Oo(1, this.O000o0Oo);
        }
    }

    private void O000000o(GL10 gl10) {
        if (this.O000o0OO) {
            boolean canStopMapRender = this.O0000O0o.canStopMapRender(1);
            Message obtainMessage = this.O0000Oo.obtainMessage(15, OOo000.O000000o(0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender;
            obtainMessage.sendToTarget();
            this.O000o0OO = false;
        }
    }

    private boolean O000000o(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    private Poi O00000Oo(int i, int i2, int i3) {
        if (!this.O000oooO) {
            return null;
        }
        try {
            ArrayList O000000o = O000000o(1, i, i2, i3);
            MapLabelItem mapLabelItem = (O000000o == null || O000000o.size() <= 0) ? null : (MapLabelItem) O000000o.get(0);
            if (mapLabelItem == null) {
                return null;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) mapLabelItem.pixel20X, (long) mapLabelItem.pixel20Y, 20);
            Poi poi = new Poi(mapLabelItem.name, new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false), mapLabelItem.poiid);
            pixelsToLatLong.recycle();
            return poi;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void O00000Oo(final MotionEvent motionEvent) {
        queueEvent(new Runnable() {
            public void run() {
                try {
                    Message obtain = Message.obtain();
                    Poi O000000o = O00o000.this.O00000Oo((int) motionEvent.getX(), (int) motionEvent.getY(), 25);
                    if (O00o000.this.O000O00o == null) {
                        O00o000.this.O00000o0(motionEvent);
                    } else if (O000000o != null) {
                        obtain.what = 20;
                        obtain.obj = O000000o;
                        O00o000.this.O0000Oo.sendMessage(obtain);
                    } else {
                        O00o000.this.O00000o0(motionEvent);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private boolean O00000Oo(CameraPosition cameraPosition) {
        boolean z = false;
        if (cameraPosition.zoom < 7.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            z = true;
        } else if (this.O00000o0 != null) {
            try {
                z = OOOO0O.O000000o(this.O00000o0.getGeoRectangle().getClipRect()) ^ 1;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return z;
    }

    private boolean O00000o(MotionEvent motionEvent) {
        if (this.O0000oo0 != null) {
            DPoint obtain = DPoint.obtain();
            O00000Oo((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
            LatLng latLng = new LatLng(obtain.y, obtain.x);
            obtain.recycle();
            if (latLng != null) {
                OooOO O000000o = this.O000Oo0O.O000000o(latLng);
                if (O000000o != null) {
                    this.O0000oo0.onPolylineClick(new Polyline((O0o00) O000000o));
                    return false;
                }
            }
        }
        return false;
    }

    private void O00000o0(final MotionEvent motionEvent) {
        this.O0000Oo.post(new Runnable() {
            public void run() {
                Message obtain = Message.obtain();
                obtain.what = 19;
                obtain.arg1 = (int) motionEvent.getX();
                obtain.arg2 = (int) motionEvent.getY();
                O00o000.this.O0000Oo.sendMessage(obtain);
            }
        });
    }

    private void O00000o0(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.isUseAnchor = this.O000Ooo0;
        if (this.O000Ooo0) {
            abstractCameraUpdateMessage.anchorX = this.O00000o0.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.O00000o0.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.O00000o0;
    }

    private boolean O00000o0(int i, int i2) {
        return this.O0000O0o != null ? this.O0000O0o.getSrvViewStateBoolValue(i, i2) : false;
    }

    private boolean O00000oO(MotionEvent motionEvent) throws RemoteException {
        if (this.O00000Oo.O00000Oo(motionEvent)) {
            bi O00000o = this.O00000Oo.O00000o();
            boolean z = true;
            if (O00000o == null) {
                return true;
            }
            try {
                Marker marker = new Marker((Oo0OOo) O00000o);
                this.O00000Oo.O000000o((Oo0OOo) O00000o);
                if (this.O0000oOo != null) {
                    boolean onMarkerClick = this.O0000oOo.onMarkerClick(marker);
                    if (!onMarkerClick) {
                        if (this.O00000Oo.O0000O0o() > 0) {
                            z = onMarkerClick;
                        }
                    }
                    return true;
                }
                O000000o((Oo0OOo) O00000o);
                if (!O00000o.O0000Oo()) {
                    LatLng O00000o0 = O00000o.O00000o0();
                    if (O00000o0 != null) {
                        Point obtain = IPoint.obtain();
                        O000000o(O00000o0.latitude, O00000o0.longitude, (IPoint) obtain);
                        O000000o(O000O0o0.O000000o(obtain));
                    }
                }
                return z;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    private boolean O00000oo(MotionEvent motionEvent) {
        if (this.O00O0OO == null) {
            return false;
        }
        IPoint obtain = IPoint.obtain();
        if (this.O0000O0o != null) {
            O000000o((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        }
        boolean O000000o = this.O00O0OO.O000000o(obtain);
        obtain.recycle();
        return O000000o;
    }

    private boolean O0000O0o(MotionEvent motionEvent) throws RemoteException {
        if (this.O000OO0o == null || !this.O000OO0o.O000000o(motionEvent)) {
            return false;
        }
        if (this.O000O0Oo != null) {
            bi O00000o = this.O00000Oo.O00000o();
            if (!O00000o.isVisible() && O00000o.isInfoWindowEnable()) {
                return true;
            }
            this.O000O0Oo.onInfoWindowClick(new Marker((Oo0OOo) O00000o));
        }
        return true;
    }

    private void O0000oo(final int i) {
        if (this.O000oooO) {
            this.O000oo0O.O000000o();
            this.O000oo0o = true;
            this.O000ooOo = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
            queueEvent(new Runnable() {
                public void run() {
                    try {
                        O00o000.this.O0000O0o.clearAllMessages(i);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void O0000ooO(int i) {
        this.O000oo0o = true;
        this.O000ooOo = false;
        if (this.O000o0) {
            this.O000o0 = false;
        }
        if (this.O000o00o) {
            this.O000o00o = false;
        }
        if (this.O000o0O0) {
            this.O000o0O0 = false;
        }
        this.O000o000 = false;
        if (!(this.O0000oo == null || this.O000o00 == null)) {
            try {
                this.O0000oo.onMarkerDragEnd(this.O000o00);
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
                th.printStackTrace();
            }
            this.O000o00 = null;
        }
        this.O000OOoo.postDelayed(new Runnable() {
            public void run() {
                O00o000.this.O000ooo = 1;
            }
        }, 300);
    }

    private void O0000ooo(int i) {
    }

    private synchronized void O000O00o() {
        synchronized (this.O000oOo0) {
            int size = this.O000oOo0.size();
            for (int i = 0; i < size; i++) {
                ((O0000O0o) this.O000oOo0.get(i)).O0000Oo().recycle();
            }
            this.O000oOo0.clear();
        }
    }

    private void O000O0OO() {
        try {
            this.O00000o0.setMapRect(OOo000.O000000o((ca) this, true));
            GLMapState mapState = this.O0000O0o.getMapState(1);
            if (mapState != null) {
                mapState.getPixel20Bound(this.O0000Ooo, getMapWidth(), getMapHeight());
                this.O00000o0.getGeoRectangle().updateRect(this.O0000Ooo, this.O00000o0.getSX(), this.O00000o0.getSY());
                this.O00000o0.setMapPerPixelUnitLength(mapState.getGLUnitWithWin(1));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void O000O0Oo() {
        if (this.O00O0oo < ((long) 2)) {
            this.O00O0oo++;
            return;
        }
        final fr O00000oo = this.O000Oo00.O00000oo();
        if (!(O00000oo == null || O00000oo.getVisibility() == 8)) {
            if (!this.O000Ooo) {
                this.O0000Oo.sendEmptyMessage(16);
                this.O000Ooo = true;
                O0000O0o(true);
            }
            this.O0000Oo.post(new Runnable() {
                public void run() {
                    if (!O00o000.this.O000OoOo) {
                        try {
                            if (O00o000.this.O00000o != null) {
                                O00o000.this.setIndoorBuildingInfo(O00o000.this.O00000o);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        O00000oo.O000000o(false);
                    }
                }
            });
        }
    }

    private void O000O0o() {
        try {
            LatLngBounds limitLatLngBounds = this.O00000o0.getLimitLatLngBounds();
            if (this.O0000O0o != null && O000000o(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(1, this.O0000O0o.getNativeInstance());
                GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, IPoint.obtain());
                GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, IPoint.obtain());
                this.O00000o0.setLimitIPoints(new IPoint[]{r2, r3});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.O00000o0.setLimitIPoints(null);
    }

    private void O000O0o0() {
        if (!this.O000oO0O) {
            try {
                if (this.O000oO00 == null) {
                    this.O000oO00 = new oO00O00o(this.O00000oo, this);
                }
                this.O000oO00.setName("AuthProThread");
                this.O000oO00.start();
                this.O000oO0O = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void O000O0oO() {
        this.O000O0o0 = null;
        this.O0000oOo = null;
        this.O0000oo0 = null;
        this.O0000oo = null;
        this.O0000ooO = null;
        this.O0000ooo = null;
        this.O00oOooO = null;
        this.O00oOooo = null;
        this.O000O00o = null;
        this.O000O0OO = null;
        this.O000O0Oo = null;
        this.O00oOoOo = null;
        this.O000O0o = null;
        this.O000O0oO = null;
        this.O000O0oo = null;
    }

    private void O00oOoOo() {
        if (!this.O000oO0) {
            try {
                this.O000o.setName("AuthThread");
                this.O000o.start();
                this.O000oO0 = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private LatLng O00oOooo() {
        if (this.O00000o0 == null) {
            return null;
        }
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) this.O00000o0.getSX(), (long) this.O00000o0.getSY(), 20);
        LatLng latLng = new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false);
        pixelsToLatLong.recycle();
        return latLng;
    }

    public float O000000o(int i) {
        return this.O00000o0 != null ? this.O00000o0.getSZ() : 0.0f;
    }

    public int O000000o(int i, Rect rect, int i2, int i3) {
        if (this.O0000O0o == null || i < 0 || rect == null) {
            return 0;
        }
        i = this.O0000O0o.getEngineIDWithType(i);
        if (this.O0000O0o.isEngineCreated(i)) {
            O000000o(i, rect.left, rect.top, rect.width(), rect.height(), i2, i3);
            return i;
        }
        int i4 = this.O00000oo.getResources().getDisplayMetrics().densityDpi;
        float f = this.O00000oo.getResources().getDisplayMetrics().density;
        this.O000ooO0 = GLMapState.calMapZoomScalefactor(i2, i3, i4);
        MapViewInitParam mapViewInitParam = new MapViewInitParam();
        mapViewInitParam.engineId = i;
        mapViewInitParam.x = rect.left;
        mapViewInitParam.y = rect.top;
        mapViewInitParam.width = rect.width();
        mapViewInitParam.height = rect.height();
        mapViewInitParam.screenWidth = i2;
        mapViewInitParam.screenHeight = i3;
        mapViewInitParam.screenScale = f;
        mapViewInitParam.textScale = this.O000ooO * f;
        mapViewInitParam.mapZoomScale = this.O000ooO0;
        this.O0000O0o.createAMapEngineWithFrame(mapViewInitParam);
        GLMapState mapState = this.O0000O0o.getMapState(i);
        mapState.setMapZoomer(this.O00000o0.getSZ());
        mapState.setCameraDegree(this.O00000o0.getSC());
        mapState.setMapAngle(this.O00000o0.getSR());
        mapState.setMapGeoCenter(this.O00000o0.getSX(), this.O00000o0.getSY());
        this.O0000O0o.setMapState(i, mapState);
        this.O0000O0o.setOvelayBundle(i, new GLOverlayBundle(i, this));
        return i;
    }

    public int O000000o(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return this.O0000O0o != null ? this.O0000O0o.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo) : 1;
    }

    public int O000000o(IMarkerAction iMarkerAction, Rect rect) {
        return 0;
    }

    public O0000O0o O000000o(BitmapDescriptor bitmapDescriptor) {
        return O000000o(bitmapDescriptor, false);
    }

    public O0000O0o O000000o(BitmapDescriptor bitmapDescriptor, boolean z) {
        if (bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled()) {
            return null;
        }
        synchronized (this.O000oOo0) {
            for (int i = 0; i < this.O000oOo0.size(); i++) {
                O0000O0o o0000O0o = (O0000O0o) this.O000oOo0.get(i);
                if (!z || o0000O0o.O0000OoO() != O00000oO()) {
                    if (o0000O0o.O0000Oo().equals(bitmapDescriptor)) {
                        return o0000O0o;
                    }
                }
            }
            return null;
        }
    }

    public LatLngBounds O000000o(LatLng latLng, float f, float f2, float f3) {
        LatLng latLng2 = latLng;
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.O00O0Oo) {
            return null;
        }
        float O000000o = OOo000.O000000o(this.O00000o0, f);
        GLMapState gLMapState = new GLMapState(1, this.O0000O0o.getNativeInstance());
        if (latLng2 != null) {
            IPoint obtain = IPoint.obtain();
            O000000o(latLng2.latitude, latLng2.longitude, obtain);
            gLMapState.setCameraDegree(f3);
            gLMapState.setMapAngle(f2);
            gLMapState.setMapGeoCenter(obtain.x, obtain.y);
            gLMapState.setMapZoomer(O000000o);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        O000000o(gLMapState, 0, 0, obtain2);
        LatLng latLng3 = new LatLng(obtain2.y, obtain2.x, false);
        O000000o(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng4 = new LatLng(obtain2.y, obtain2.x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng4).include(latLng3).build();
    }

    public GLMapEngine O000000o() {
        return this.O0000O0o;
    }

    public ArrayList<MapLabelItem> O000000o(int i, int i2, int i3, int i4) {
        if (!this.O000oooO) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] labelBuffer = this.O0000O0o.getLabelBuffer(i, i2, i3, i4);
        if (labelBuffer == null) {
            return null;
        }
        i3 = GLConvertUtil.getInt(labelBuffer, 0) >= 1 ? 1 : 0;
        int i5 = 0;
        int i6 = 4;
        while (i5 < i3) {
            int i7;
            MapLabelItem mapLabelItem = new MapLabelItem();
            int i8 = GLConvertUtil.getInt(labelBuffer, i6);
            i6 += 4;
            int i9 = GLConvertUtil.getInt(labelBuffer, i6);
            i6 += 4;
            mapLabelItem.x = i8;
            mapLabelItem.y = this.O000OOoo.getHeight() - i9;
            mapLabelItem.pixel20X = GLConvertUtil.getInt(labelBuffer, i6);
            i6 += 4;
            mapLabelItem.pixel20Y = GLConvertUtil.getInt(labelBuffer, i6);
            i6 += 4;
            mapLabelItem.pixel20Z = GLConvertUtil.getInt(labelBuffer, i6);
            i6 += 4;
            mapLabelItem.type = GLConvertUtil.getInt(labelBuffer, i6);
            i6 += 4;
            mapLabelItem.mSublayerId = GLConvertUtil.getInt(labelBuffer, i6);
            i6 += 4;
            mapLabelItem.timeStamp = GLConvertUtil.getInt(labelBuffer, i6);
            i6 += 4;
            mapLabelItem.mIsFouces = labelBuffer[i6] != (byte) 0;
            i6++;
            if (labelBuffer[i6] == (byte) 0) {
                mapLabelItem.poiid = null;
            } else {
                String str = "";
                for (i8 = 0; i8 < 20; i8++) {
                    i7 = i8 + i6;
                    if (labelBuffer[i7] == (byte) 0) {
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append((char) labelBuffer[i7]);
                    str = stringBuilder.toString();
                }
                mapLabelItem.poiid = str;
            }
            i6 += 20;
            i8 = i6 + 1;
            byte b = labelBuffer[i6];
            StringBuffer stringBuffer = new StringBuffer();
            i7 = i8;
            for (byte b2 = (byte) 0; b2 < b; b2++) {
                stringBuffer.append((char) GLConvertUtil.getShort(labelBuffer, i7));
                i7 += 2;
            }
            mapLabelItem.name = stringBuffer.toString();
            arrayList.add(mapLabelItem);
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    public void O000000o(double d, double d2, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        O000000o(d, d2, obtain);
        O000000o(obtain.x, obtain.y, fPoint);
        obtain.recycle();
    }

    public void O000000o(double d, double d2, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d, d2, 20);
        iPoint.x = latLongToPixels.x;
        iPoint.y = latLongToPixels.y;
    }

    public void O000000o(float f, float f2, IPoint iPoint) {
        iPoint.x = (int) (f + ((float) this.O00000o0.getSX()));
        iPoint.y = (int) (f2 + ((float) this.O00000o0.getSY()));
    }

    public void O000000o(int i, float f) {
        if (this.O000Oo00 != null) {
            this.O000Oo00.O000000o(Integer.valueOf(i), Float.valueOf(f));
        }
    }

    public void O000000o(int i, int i2) {
        if (this.O00O00Oo == 0 || i2 != 5) {
            this.O00O00Oo = i2;
        }
    }

    public void O000000o(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.O0000O0o != null) {
            this.O0000O0o.setServiceViewRect(i, i2, i3, i4, i5, i6, i7);
        }
    }

    public synchronized void O000000o(int i, int i2, int i3, int i4, boolean z, boolean z2, StyleItem[] styleItemArr) {
        int i5 = i3;
        synchronized (this) {
            try {
                if (this.O000oooo && this.O000oooO && this.O000000o) {
                    O0000oO0(i5);
                } else {
                    this.O00O0Ooo.O0000O0o = i;
                    this.O00O0Ooo.O00000o = i2;
                    this.O00O0Ooo.O00000oO = i5;
                    this.O00O0Ooo.O00000oo = i4;
                    this.O00O0Ooo.O00000Oo = true;
                }
            } finally {
                Object obj = r0;
            }
        }
    }

    public void O000000o(int i, int i2, PointF pointF) {
        if (this.O000oooO && !this.O000OoOo && this.O0000O0o != null) {
            IPoint obtain = IPoint.obtain();
            O000000o(i, i2, obtain);
            pointF.x = (float) (obtain.x - this.O00000o0.getSX());
            pointF.y = (float) (obtain.y - this.O00000o0.getSY());
            obtain.recycle();
        }
    }

    public void O000000o(int i, int i2, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) i, (long) i2, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    public void O000000o(int i, int i2, FPoint fPoint) {
        fPoint.x = (float) (i - this.O00000o0.getSX());
        fPoint.y = (float) (i2 - this.O00000o0.getSY());
    }

    public void O000000o(int i, int i2, IPoint iPoint) {
        if (this.O000oooO && this.O0000O0o != null) {
            GLMapState mapState = this.O0000O0o.getMapState(1);
            if (mapState != null) {
                mapState.screenToP20Point(i, i2, iPoint);
            }
        }
    }

    public void O000000o(int i, MotionEvent motionEvent) {
        try {
            this.O000o00o = false;
            O0000o00(i);
            this.O000o00O = this.O00000Oo.O000000o(motionEvent);
            if (this.O000o00O != null && this.O000o00O.isDraggable()) {
                this.O000o00 = new Marker((Oo0OOo) this.O000o00O);
                LatLng position = this.O000o00.getPosition();
                LatLng O00000o0 = this.O000o00O.O00000o0();
                if (!(position == null || O00000o0 == null)) {
                    IPoint obtain = IPoint.obtain();
                    O00000Oo(O00000o0.latitude, O00000o0.longitude, obtain);
                    obtain.y -= 60;
                    DPoint obtain2 = DPoint.obtain();
                    O00000Oo(obtain.x, obtain.y, obtain2);
                    this.O000o00.setPosition(new LatLng((position.latitude + obtain2.y) - O00000o0.latitude, (position.longitude + obtain2.x) - O00000o0.longitude));
                    this.O00000Oo.O000000o((Oo0OOo) this.O000o00O);
                    if (this.O0000oo != null) {
                        this.O0000oo.onMarkerDragStart(this.O000o00);
                    }
                    this.O000o000 = true;
                    obtain.recycle();
                    obtain2.recycle();
                }
            } else if (this.O000O0OO != null) {
                DPoint obtain3 = DPoint.obtain();
                O00000Oo((int) motionEvent.getX(), (int) motionEvent.getY(), obtain3);
                this.O000O0OO.onMapLongClick(new LatLng(obtain3.y, obtain3.x));
                this.O000o0 = true;
                obtain3.recycle();
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImp", "onLongPress");
            th.printStackTrace();
            return;
        }
        this.O000oo0.resetTickCount(30);
    }

    public void O000000o(int i, IPoint iPoint) {
        if (this.O00000o0 != null) {
            iPoint.x = this.O00000o0.getSX();
            iPoint.y = this.O00000o0.getSY();
        }
    }

    public void O000000o(int i, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (this.O000oooO && this.O0000O0o != null) {
            try {
                abstractGestureMapMessage.isUseAnchor = this.O000Ooo0;
                abstractGestureMapMessage.anchorX = this.O00000o0.getAnchorX();
                abstractGestureMapMessage.anchorY = this.O00000o0.getAnchorY();
                this.O0000O0o.addGestureMessage(i, abstractGestureMapMessage, this.O000OOo.isGestureScaleByMapCenter(), this.O00000o0.getAnchorX(), this.O00000o0.getAnchorY());
            } catch (RemoteException unused) {
            }
        }
    }

    public void O000000o(int i, GL10 gl10, int i2, int i3) {
        this.O00oOOoo = false;
        if (!this.O000oooO) {
            O000000o(i, gl10, null);
        }
        this.O0000OOo = i2;
        this.O0000Oo0 = i3;
        this.O000oO0o = true;
        this.O000o0o0 = new Rect(0, 0, i2, i3);
        this.O000OoO0 = O000000o(i, new Rect(0, 0, this.O0000OOo, this.O0000Oo0), this.O0000OOo, this.O0000Oo0);
        if (!this.O000oooo) {
            if (this.O00000o0 != null) {
                this.O00000o0.setMapZoomScale(this.O000ooO0);
                this.O00000o0.setMapWidth(i2);
                this.O00000o0.setMapHeight(i3);
            }
            this.O0000O0o.setIndoorEnable(this.O000OoO0, false);
            this.O0000O0o.setSimple3DEnable(this.O000OoO0, false);
            this.O0000O0o.initNativeTexture(this.O000OoO0);
        }
        if (this.O000oOoo != null) {
            this.O000oOoo.O000000o(new O00000o(153));
        }
        synchronized (this) {
            this.O000oooo = true;
        }
        if (this.O000Ooo0) {
            this.O00000o0.setAnchorX(Math.max(1, Math.min(this.O00O00o0, i2 - 1)));
            this.O00000o0.setAnchorY(Math.max(1, Math.min(this.O00O00o, i3 - 1)));
        } else {
            this.O00000o0.setAnchorX(i2 >> 1);
            this.O00000o0.setAnchorY(i3 >> 1);
        }
        this.O0000O0o.setProjectionCenter(this.O000OoO0, this.O00000o0.getAnchorX(), this.O00000o0.getAnchorY());
        this.O000000o = true;
        if (this.O00O0o0o.O00000Oo) {
            this.O00O0o0o.run();
        }
        if (this.O00O0Ooo.O00000Oo) {
            this.O00O0Ooo.run();
        }
        if (this.O00O0o00.O00000Oo) {
            this.O00O0o00.run();
        }
        if (this.O00O0Oo0.O00000Oo) {
            this.O00O0Oo0.run();
        }
        if (this.O00O0o0.O00000Oo) {
            this.O00O0o0.run();
        }
        if (this.O00O0oOO.O00000Oo) {
            this.O00O0oOO.run();
        }
        if (this.O00O0o0O.O00000Oo) {
            this.O00O0o0O.run();
        }
        if (this.O00O0o.O00000Oo) {
            this.O00O0o.run();
        }
        if (this.O00O0OoO.O00000Oo) {
            this.O00O0OoO.run();
        }
        if (this.O00O0oOo.O00000Oo) {
            this.O00O0oOo.run();
        }
        if (this.O000oOO0 != null) {
            this.O000oOO0.onSurfaceChanged(gl10, i2, i3);
        }
        if (this.O0000Oo != null) {
            this.O0000Oo.post(this.O00O0oO0);
        }
    }

    public synchronized void O000000o(int i, GL10 gl10, EGLConfig eGLConfig) {
        if (this.O000o0o == 3) {
            this.O000Oo00.O00000oo().O000000o(fr.O00000Oo);
        } else {
            this.O000Oo00.O00000oo().O000000o(fr.O000000o);
        }
        this.O000oooo = false;
        this.O0000OOo = this.O000OOoo.getWidth();
        this.O0000Oo0 = this.O000OOoo.getHeight();
        this.O00oOOoo = false;
        try {
            AeUtil.loadLib(this.O00000oo);
            this.O0000O0o.createAMapInstance(AeUtil.initResource(this.O00000oo));
            O0000ooo(i);
            this.O00O00oo = new OO00O();
            this.O000Oo0O.O000000o(this.O00O00oo);
            this.O000oooO = true;
            this.O0000o00 = gl10.glGetString(7937);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDElegateImp", "createSurface");
        }
        GLMapState mapState = this.O0000O0o.getMapState(1);
        if (!(mapState == null || mapState.getNativeInstance() == 0)) {
            mapState.setMapGeoCenter(this.O00000o0.getSX(), this.O00000o0.getSY());
            mapState.setMapAngle(this.O00000o0.getSR());
            mapState.setMapZoomer(this.O00000o0.getSZ());
            mapState.setCameraDegree(this.O00000o0.getSC());
        }
        this.O00O0O0o.O000000o(this.O00000oo);
        O00oOoOo();
        if (this.O000oOO0 != null) {
            this.O000oOO0.onSurfaceCreated(gl10, eGLConfig);
        }
        O0000oOo();
    }

    public void O000000o(final int i, final boolean z) {
        if (this.O000oooO && this.O000oooo) {
            resetRenderTime();
            queueEvent(new Runnable() {
                public void run() {
                    try {
                        O00o000.this.O0000O0o.setBuildingEnable(i, z);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        this.O00O0o0.O00000o0 = z;
        this.O00O0o0.O00000Oo = true;
        this.O00O0o0.O0000O0o = i;
    }

    public void O000000o(Location location) throws RemoteException {
        if (location != null) {
            try {
                if (this.O000Oo0o) {
                    if (this.O000Oooo != null) {
                        if (this.O000OooO == null) {
                            this.O000OooO = new ooO0Ooo(this, this.O00000oo);
                        }
                        if (!(location.getLongitude() == 0.0d || location.getLatitude() == 0.0d)) {
                            this.O000OooO.O000000o(location);
                        }
                        if (this.O000O0o0 != null) {
                            this.O000O0o0.onMyLocationChange(location);
                        }
                        resetRenderTime();
                        return;
                    }
                }
                if (this.O000OooO != null) {
                    this.O000OooO.O00000Oo();
                }
                this.O000OooO = null;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapDelegateImp", "showMyLocationOverlay");
                th.printStackTrace();
            }
        }
    }

    public void O000000o(O0000O0o o0000O0o) {
        if (o0000O0o != null && o0000O0o.O0000OoO() != 0) {
            synchronized (this.O000oOo0) {
                this.O000oOo0.add(o0000O0o);
            }
        }
    }

    public void O000000o(bi biVar) throws RemoteException {
        if (!(biVar == null || this.O000OO0o == null)) {
            try {
                this.O000OO0o.O000000o(biVar);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(GLMapState gLMapState, int i, int i2, DPoint dPoint) {
        if (this.O000oooO && this.O0000O0o != null) {
            Point point = new Point();
            gLMapState.screenToP20Point(i, i2, point);
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) point.x, (long) point.y, 20);
            dPoint.x = pixelsToLatLong.x;
            dPoint.y = pixelsToLatLong.y;
            pixelsToLatLong.recycle();
        }
    }

    public void O000000o(AMapWidgetListener aMapWidgetListener) {
        this.O000OoOO = aMapWidgetListener;
    }

    public void O000000o(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        if (this.O0000O0o != null && !this.O00O0Oo) {
            if (this.O000OoOo && this.O0000O0o.getStateMessageCount() > 0) {
                AbstractCameraUpdateMessage O00000o0 = O000O0o0.O00000o0();
                O00000o0.nowType = Type.changeGeoCenterZoomTiltBearing;
                O00000o0.geoPoint = new Point(this.O00000o0.getSX(), this.O00000o0.getSY());
                O00000o0.zoom = this.O00000o0.getSZ();
                O00000o0.bearing = this.O00000o0.getSR();
                O00000o0.tilt = this.O00000o0.getSC();
                this.O0000O0o.addMessage(abstractCameraUpdateMessage, false);
                while (this.O0000O0o.getStateMessageCount() > 0) {
                    abstractCameraUpdateMessage = this.O0000O0o.getStateMessage();
                    if (abstractCameraUpdateMessage != null) {
                        abstractCameraUpdateMessage.mergeCameraUpdateDelegate(O00000o0);
                    }
                }
                abstractCameraUpdateMessage = O00000o0;
            }
            resetRenderTime();
            this.O0000O0o.clearAnimations(1, false);
            abstractCameraUpdateMessage.isChangeFinished = true;
            O00000o0(abstractCameraUpdateMessage);
            this.O0000O0o.addMessage(abstractCameraUpdateMessage, false);
        }
    }

    public void O000000o(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j, CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage != null && !this.O00O0Oo && this.O0000O0o != null) {
            abstractCameraUpdateMessage.mCallback = cancelableCallback;
            abstractCameraUpdateMessage.mDuration = j;
            if (this.O000OoOo || getMapHeight() == 0 || getMapWidth() == 0) {
                try {
                    O000000o(abstractCameraUpdateMessage);
                    if (abstractCameraUpdateMessage.mCallback != null) {
                        abstractCameraUpdateMessage.mCallback.onFinish();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return;
            }
            try {
                this.O0000O0o.interruptAnimation();
                resetRenderTime();
                O00000o0(abstractCameraUpdateMessage);
                this.O0000O0o.addMessage(abstractCameraUpdateMessage, true);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void O000000o(Runnable runnable) {
        if (this.O000OOoo != null) {
            this.O000OOoo.post(runnable);
        }
    }

    public void O000000o(String str, OO0OOOO oo0oooo) {
        setCustomTextureResourcePath(str);
        if (this.O00000o0.isCustomStyleEnable() && oo0oooo != null) {
            O000000o(oo0oooo.O00000o0(), false);
        }
    }

    public void O000000o(String str, boolean z, int i) {
        if (this.O000Oo00 != null) {
            this.O000Oo00.O000000o(str, Boolean.valueOf(z), Integer.valueOf(i));
        }
        if (this.O000OOo != null) {
            this.O000OOo.requestRefreshLogo();
        }
    }

    public void O000000o(boolean z) {
        if (!this.O00O0Oo && this.O000Oo00 != null) {
            this.O000Oo00.O00000Oo(Boolean.valueOf(z));
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(boolean z, CameraPosition cameraPosition) {
        if (this.O00000o0 != null && this.O00000o0.getChangedCounter() != 0) {
            try {
                if (!this.O000ooOo && this.O0000O0o.getAnimateionsCount() == 0 && this.O0000O0o.getStateMessageCount() == 0) {
                    this.O00000o0.resetChangedCounter();
                    if (this.O000OO00 != null) {
                        this.O000OO00.onMapStable();
                    }
                    if (this.O0000ooo != null && this.O000OOoo.isEnabled()) {
                        CameraPosition cameraPosition2;
                        if (cameraPosition == null) {
                            cameraPosition2 = getCameraPosition();
                            this.O0000ooo.onCameraChangeFinish(cameraPosition2);
                        }
                        cameraPosition2 = cameraPosition;
                        this.O0000ooo.onCameraChangeFinish(cameraPosition2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void O000000o(boolean z, boolean z2) {
        if (!this.O000oooO || this.O00O0Oo) {
            this.O00O0o00.O00000Oo = true;
            this.O00O0o00.O00000o0 = z;
        } else {
            boolean z3 = z2 ? z2 : false;
            if (!TextUtils.isEmpty(this.O00000o0.getCustomStylePath()) || !TextUtils.isEmpty(this.O00000o0.getCustomStyleID())) {
                if (z) {
                    try {
                        if (!(!this.O00000o0.isProFunctionAuthEnable() || TextUtils.isEmpty(this.O00000o0.getCustomStyleID()) || this.O000oOo == null)) {
                            this.O000oOo.O000000o(this.O00000o0.getCustomStyleID());
                            this.O000oOo.O00000Oo();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (z2 || this.O000OOoO || (this.O00000o0.isCustomStyleEnable() ^ z) != 0) {
                    O000000o(z, null, z3);
                }
                this.O000OOoO = false;
            }
        }
    }

    public void O000000o(boolean z, byte[] bArr) {
        O000000o(z, bArr, false);
    }

    public void O000000o(boolean z, byte[] bArr, boolean z2) {
        this.O00000o0.setCustomStyleEnable(z);
        if (this.O00000o0.isHideLogoEnable()) {
            this.O000OOo.setLogoEnable(z ^ 1);
        }
        boolean z3 = false;
        if (z) {
            OO0OOOO O000000o;
            O00000o0(1, true);
            OO0OO0o oO0OO0o = new OO0OO0o(this.O00000oo);
            if (!(this.O000o0oo == null || this.O000o0oo.getTrafficRoadBackgroundColor() == -1)) {
                oO0OO0o.O000000o(this.O000o0oo.getTrafficRoadBackgroundColor());
            }
            if (this.O00000o0.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.O00000o0.getCustomTextureResourcePath())) {
                z3 = true;
            }
            StyleItem[] styleItemArr = null;
            if (bArr != null) {
                O000000o = oO0OO0o.O000000o(bArr, z3);
                if (O000000o != null) {
                    styleItemArr = O000000o.O00000o0();
                    if (styleItemArr != null) {
                        this.O00000o0.setUseProFunction(true);
                    }
                }
            } else {
                O000000o = null;
            }
            if (styleItemArr == null) {
                O000000o = oO0OO0o.O000000o(this.O00000o0.getCustomStylePath(), z3);
                if (O000000o != null) {
                    styleItemArr = O000000o.O00000o0();
                }
            }
            if (oO0OO0o.O000000o() != 0) {
                this.O00000o0.setCustomBackgroundColor(oO0OO0o.O000000o());
            }
            if (O000000o == null || O000000o.O00000o() == null) {
                O000000o(styleItemArr, z2);
                return;
            } else if (this.O000oOoO != null) {
                this.O000oOoO.O000000o((String) O000000o.O00000o());
                this.O000oOoO.O000000o(O000000o);
                this.O000oOoO.O00000Oo();
                return;
            } else {
                return;
            }
        }
        O00000o0(1, false);
        O000000o(1, this.O00000o0.getMapStyleMode(), this.O00000o0.getMapStyleTime(), this.O00000o0.getMapStyleState(), true, false, null);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(StyleItem[] styleItemArr, boolean z) {
        z = z || (styleItemArr != null && styleItemArr.length > 0);
        if (z) {
            O000000o(1, 0, 0, 0, true, true, styleItemArr);
            OOOOOo0.O000000o(this.O00000oo, true);
            return;
        }
        OOOOOo0.O000000o(this.O00000oo, false);
    }

    public boolean O000000o(int i, int i2, int i3) {
        if (!this.O000oooO || ((float) ((int) O00000Oo(i))) >= this.O00000o0.getMaxZoomLevel()) {
            return false;
        }
        try {
            AbstractCameraUpdateMessage O000000o;
            if (this.O000Ooo0) {
                O000000o = O000O0o0.O000000o(1.0f, null);
            } else if (this.O000OOo.isZoomInByScreenCenter()) {
                O000000o = O000O0o0.O000000o(1.0f, null);
            } else {
                this.O0000OoO.x = i2;
                this.O0000OoO.y = i3;
                O000000o = O000O0o0.O000000o(1.0f, this.O0000OoO);
            }
            O00000Oo(O000000o);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        resetRenderTime();
        return true;
    }

    public boolean O000000o(String str) throws RemoteException {
        resetRenderTime();
        return this.O000Oo0O.removeOverlay(str);
    }

    public float O00000Oo(int i) {
        return this.O00000o0 != null ? getMapConfig().getSZ() : 0.0f;
    }

    public void O00000Oo() {
        if (this.O000Oo0 != null) {
            this.O000Oo0.O0000OOo();
        }
    }

    public void O00000Oo(double d, double d2, IPoint iPoint) {
        if (this.O000oooO && this.O0000O0o != null) {
            try {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d, d2, 20);
                FPoint obtain = FPoint.obtain();
                O00000Oo(latLongToPixels.x, latLongToPixels.y, obtain);
                float f = (float) -10000;
                if (obtain.x == f && obtain.y == f) {
                    GLMapState newMapState = this.O0000O0o.getNewMapState(1);
                    newMapState.setCameraDegree(0.0f);
                    newMapState.recalculate();
                    newMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                    newMapState.recycle();
                }
                iPoint.x = (int) obtain.x;
                iPoint.y = (int) obtain.y;
                obtain.recycle();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void O00000Oo(int i, int i2) {
        if (this.O00000o0 != null) {
            this.O0000OOo = i;
            this.O0000Oo0 = i2;
            this.O00000o0.setMapWidth(i);
            this.O00000o0.setMapHeight(i2);
        }
    }

    public synchronized void O00000Oo(int i, int i2, int i3, int i4) {
        O000000o(i, i2, i3, i4, false, false, null);
    }

    public void O00000Oo(int i, int i2, DPoint dPoint) {
        if (this.O000oooO && this.O0000O0o != null) {
            GLMapState mapState = this.O0000O0o.getMapState(1);
            if (mapState != null) {
                IPoint obtain = IPoint.obtain();
                mapState.screenToP20Point(i, i2, obtain);
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) obtain.x, (long) obtain.y, 20);
                dPoint.x = pixelsToLatLong.x;
                dPoint.y = pixelsToLatLong.y;
                obtain.recycle();
                pixelsToLatLong.recycle();
            }
        }
    }

    public void O00000Oo(int i, int i2, FPoint fPoint) {
        if (this.O000oooO && this.O0000O0o != null) {
            GLMapState mapState = this.O0000O0o.getMapState(1);
            if (mapState != null) {
                mapState.p20ToScreenPoint(i, i2, fPoint);
            }
        }
    }

    public void O00000Oo(final int i, final boolean z) {
        if (this.O000oooO && this.O000oooo) {
            resetRenderTime();
            queueEvent(new Runnable() {
                public void run() {
                    if (O00o000.this.O0000O0o != null) {
                        if (z) {
                            O00o000.this.O0000O0o.setAllContentEnable(i, true);
                        } else {
                            O00o000.this.O0000O0o.setAllContentEnable(i, false);
                        }
                        O00o000.this.O0000O0o.setSimple3DEnable(i, false);
                    }
                }
            });
            return;
        }
        this.O00O0o0o.O00000o0 = z;
        this.O00O0o0o.O00000Oo = true;
        this.O00O0o0o.O0000O0o = i;
    }

    public void O00000Oo(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        O000000o(abstractCameraUpdateMessage, 250, null);
    }

    public void O00000Oo(boolean z) {
        if (!this.O00O0Oo && this.O000Oo00 != null) {
            this.O000Oo00.O000000o(Boolean.valueOf(z));
        }
    }

    public boolean O00000Oo(int i, MotionEvent motionEvent) {
        if (!this.O000oooO) {
            return false;
        }
        O000000o(i, (int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    public boolean O00000Oo(String str) {
        try {
            this.O000OoO.O000000o(str);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
        }
        return false;
    }

    public int O00000o() {
        return this.O00O0O0o != null ? this.O00O0O0o.O000000o() : 0;
    }

    public String O00000o(String str) {
        return this.O000Oo0O != null ? this.O000Oo0O.O000000o(str) : null;
    }

    public void O00000o(boolean z) {
        if (!this.O00O0Oo && this.O000Oo00 != null) {
            this.O000Oo00.O00000o(Boolean.valueOf(z));
        }
    }

    public boolean O00000o(int i) {
        return false;
    }

    public GLMapState O00000o0() {
        return this.O0000O0o != null ? this.O0000O0o.getMapState(1) : null;
    }

    public void O00000o0(int i) {
        if (this.O000oooO && ((float) ((int) O00000Oo(i))) > this.O00000o0.getMinZoomLevel()) {
            try {
                O00000Oo(O000O0o0.O00000Oo());
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    public void O00000o0(final int i, final boolean z) {
        if (this.O000oooO && this.O000oooo) {
            resetRenderTime();
            queueEvent(new Runnable() {
                public void run() {
                    try {
                        if (z) {
                            O00o000.this.O0000O0o.setBuildingTextureEnable(i, true);
                        } else {
                            O00o000.this.O0000O0o.setBuildingTextureEnable(i, false);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        this.O00O0oOO.O00000o0 = z;
        this.O00O0oOO.O00000Oo = true;
        this.O00O0oOO.O0000O0o = i;
    }

    public void O00000o0(String str) {
        synchronized (this.O000oOo0) {
            int size = this.O000oOo0.size();
            int i = -1;
            for (int i2 = 0; i2 < size; i2++) {
                if (((O0000O0o) this.O000oOo0.get(i2)).O0000o0O().equals(str)) {
                    i = i2;
                    break;
                }
            }
            if (i >= 0) {
                this.O000oOo0.remove(i);
            }
        }
    }

    public void O00000o0(boolean z) {
        if (!this.O00O0Oo && this.O000Oo00 != null) {
            this.O000Oo00.O00000o0(Boolean.valueOf(z));
        }
    }

    public boolean O00000o0(int i, MotionEvent motionEvent) {
        if (!this.O000oooO) {
            return false;
        }
        try {
            if (O0000O0o(motionEvent) || O00000oO(motionEvent) || O00000oo(motionEvent) || O00000o(motionEvent)) {
                return true;
            }
            O00000Oo(motionEvent);
            return true;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImp", "onSingleTapUp");
            th.printStackTrace();
            return true;
        }
    }

    public int O00000oO() {
        return this.O00O0O0o != null ? this.O00O0O0o.O00000Oo() : 0;
    }

    public void O00000oO(boolean z) {
        if (!this.O00O0Oo && this.O000Oo00 != null) {
            this.O000Oo00.O00000oO(Boolean.valueOf(z));
        }
    }

    public boolean O00000oO(int i) {
        return O00000o0(i, 7);
    }

    public int O00000oo(int i) {
        return this.O00O0O0o != null ? this.O00O0O0o.O000000o(i) : 0;
    }

    public CameraPosition O00000oo(boolean z) {
        try {
            if (this.O00000o0 == null) {
                return null;
            }
            DPoint obtain;
            LatLng latLng;
            if (!this.O000oooO || this.O000OoOo || this.O0000O0o == null) {
                obtain = DPoint.obtain();
                O000000o(this.O00000o0.getSX(), this.O00000o0.getSY(), obtain);
                latLng = new LatLng(obtain.y, obtain.x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng).bearing(this.O00000o0.getSR()).tilt(this.O00000o0.getSC()).zoom(this.O00000o0.getSZ()).build();
            }
            if (z) {
                obtain = DPoint.obtain();
                O00000Oo(this.O00000o0.getAnchorX(), this.O00000o0.getAnchorY(), obtain);
                LatLng latLng2 = new LatLng(obtain.y, obtain.x, false);
                obtain.recycle();
            } else {
                latLng = O00oOooo();
            }
            return CameraPosition.builder().target(latLng).bearing(this.O00000o0.getSR()).tilt(this.O00000o0.getSC()).zoom(this.O00000o0.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void O00000oo() {
        this.O000Oo0O.O00000oO();
    }

    public float O0000O0o() {
        return O00000Oo(this.O000OoO0);
    }

    public void O0000O0o(int i) {
        if (!this.O00O0Oo && this.O000Oo00 != null) {
            this.O000Oo00.O000000o(Integer.valueOf(i));
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000O0o(boolean z) {
        this.O0000Oo.obtainMessage(17, z, 0).sendToTarget();
    }

    public float O0000OOo(int i) {
        return (!this.O000oooO || this.O000OoOo || this.O0000O0o == null) ? 0.0f : this.O0000O0o.getMapState(1).getGLUnitWithWin(i);
    }

    public cd O0000OOo() {
        return this.O000OOo;
    }

    public void O0000OOo(boolean z) {
        if (!this.O00O0Oo) {
            this.O000Oo00.O00000oo(Boolean.valueOf(z));
        }
    }

    public void O0000Oo() {
        if (this.O000oooO) {
            this.O0000Oo.sendEmptyMessage(18);
        }
    }

    public void O0000Oo(int i) {
        if (this.O000Oo00 != null) {
            this.O000Oo00.O00000o0(Integer.valueOf(i));
        }
    }

    public void O0000Oo0() {
        if (this.O000OO0o != null) {
            this.O000OO0o.O00000oO();
        }
    }

    public void O0000Oo0(int i) {
        if (this.O000Oo00 != null) {
            this.O000Oo00.O00000Oo(Integer.valueOf(i));
        }
    }

    public void O0000Oo0(boolean z) {
        if (this.O00000o0 != null) {
            this.O00000o0.setHideLogoEnble(z);
            if (this.O00000o0.isCustomStyleEnable()) {
                this.O000OOo.setLogoEnable(z ^ 1);
            }
        }
    }

    public void O0000OoO(int i) {
        if (this.O000Oo00 != null) {
            this.O000Oo00.O00000o(Integer.valueOf(i));
        }
    }

    public boolean O0000OoO() {
        return this.O000Ooo0;
    }

    public float O0000Ooo(int i) {
        return this.O000Oo00 != null ? this.O000Oo00.O000000o(i) : 0.0f;
    }

    public Point O0000Ooo() {
        return this.O000Oo00 != null ? this.O000Oo00.O00000o0() : new Point();
    }

    public void O0000o() {
        if (this.O000oo0 != null) {
            this.O000oo0.resetTickCount(30);
        }
    }

    public void O0000o(int i) {
        O0000oO(i);
        if (this.O000oo0 != null) {
            this.O000oo0.renderResume();
        }
    }

    public float O0000o0(int i) {
        return this.O00000o0 != null ? this.O00000o0.getSR() : 0.0f;
    }

    public boolean O0000o0() {
        if (!(O0000O0o() < ((float) 17) || this.O00000o == null || this.O00000o.O0000O0o == null)) {
            FPoint obtain = FPoint.obtain();
            O00000Oo(this.O00000o.O0000O0o.x, this.O00000o.O0000O0o.y, obtain);
            if (this.O000o0o0.contains((int) obtain.x, (int) obtain.y)) {
                return true;
            }
        }
        return false;
    }

    public View O0000o00() {
        return this.O000OOoo instanceof View ? (View) this.O000OOoo : null;
    }

    public void O0000o00(final int i) {
        queueEvent(new Runnable() {
            public void run() {
                if (O00o000.this.O000oooO && O00o000.this.O0000O0o != null) {
                    O00o000.this.O0000O0o.setHighlightSubwayEnable(i, false);
                }
            }
        });
    }

    public float O0000o0O(int i) {
        return this.O00000o0 != null ? this.O00000o0.getSC() : 0.0f;
    }

    public int O0000o0O() {
        return this.O000oOOO;
    }

    public void O0000o0o() {
        boolean z = false;
        if (this.O00000o0.getMapRect() == null || this.O000oO0o) {
            O000O0OO();
            this.O000oO0o = false;
        }
        this.O0000O0o.getCurTileIDs(1, this.O00000o0.getCurTileIds());
        GLMapState mapState = this.O0000O0o.getMapState(1);
        if (mapState != null) {
            mapState.getViewMatrix(this.O00000o0.getViewMatrix());
            mapState.getProjectionMatrix(this.O00000o0.getProjectionMatrix());
            this.O00000o0.updateFinalMatrix();
            Point mapGeoCenter = mapState.getMapGeoCenter();
            this.O00000o0.setSX(mapGeoCenter.x);
            this.O00000o0.setSY(mapGeoCenter.y);
            this.O00000o0.setSZ(mapState.getMapZoomer());
            this.O00000o0.setSC(mapState.getCameraDegree());
            this.O00000o0.setSR(mapState.getMapAngle());
            if (this.O00000o0.isMapStateChange()) {
                this.O00000o0.setSkyHeight(mapState.getSkyHeight());
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) mapGeoCenter.x, (long) mapGeoCenter.y, 20);
                CameraPosition cameraPosition = new CameraPosition(new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false), this.O00000o0.getSZ(), this.O00000o0.getSC(), this.O00000o0.getSR());
                pixelsToLatLong.recycle();
                Message obtainMessage = this.O0000Oo.obtainMessage();
                obtainMessage.what = 10;
                obtainMessage.obj = cameraPosition;
                this.O0000Oo.sendMessage(obtainMessage);
                this.O000ooo0 = true;
                O0000Oo();
                O000O0OO();
                try {
                    if (this.O000OOo.isZoomControlsEnabled() && this.O00000o0.isNeedUpdateZoomControllerState() && this.O000OoOO != null) {
                        this.O000OoOO.invalidateZoomController(this.O00000o0.getSZ());
                    }
                    if (this.O00000o0.getChangeGridRatio() != 1.0d) {
                        O0000O0o(true);
                    }
                    if (this.O000OOo.isCompassEnabled() && (this.O00000o0.isTiltChanged() || this.O00000o0.isBearingChanged())) {
                        z = true;
                    }
                    if (z && this.O000OoOO != null) {
                        this.O000OoOO.invalidateCompassView();
                    }
                    if (this.O000OOo.isScaleControlsEnabled() && this.O000OoOO != null) {
                        this.O000OoOO.invalidateScaleView();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (!this.O000ooOo && this.O0000O0o.getAnimateionsCount() == 0 && this.O0000O0o.getStateMessageCount() == 0) {
                onChangeFinish();
            }
        }
    }

    public void O0000o0o(int i) {
        if (this.O000oo0 != null) {
            this.O000oo0.renderPause();
        }
        O0000oO(i);
    }

    public void O0000oO() {
        if (this.O000oooO && this.O000oo0 != null && !this.O000oo0.isRenderPause()) {
            requestRender();
        }
    }

    public void O0000oO(final int i) {
        queueEvent(new Runnable() {
            public void run() {
                try {
                    O00o000.this.O0000O0o.clearAllMessages(i);
                    O00o000.this.O0000O0o.clearAnimations(i, true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void O0000oO0() {
        if (this.O000oo0 != null) {
            this.O000oo0.resetTickCount(2);
        }
    }

    /* Access modifiers changed, original: protected */
    public void O0000oO0(int i) {
        if (this.O000Oo00 == null) {
            return;
        }
        if (i == 0) {
            if (this.O000Oo00.O00000o()) {
                this.O000Oo00.O0000O0o(Boolean.valueOf(false));
                this.O000Oo00.O00000oO();
            }
        } else if (!this.O000Oo00.O00000o()) {
            this.O000Oo00.O0000O0o(Boolean.valueOf(true));
            this.O000Oo00.O00000oO();
        }
    }

    public float O0000oOO() {
        return this.O000ooO0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064 A:{Catch:{ Throwable -> 0x007e }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A:{Catch:{ Throwable -> 0x007e }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A:{Catch:{ Throwable -> 0x007e }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064 A:{Catch:{ Throwable -> 0x007e }} */
    public void O0000oOO(int r15) {
        /*
        r14 = this;
        r14.O000o0o = r15;
        r0 = 5;
        r1 = 2;
        r2 = 4;
        r3 = 1;
        r4 = 0;
        if (r15 != r3) goto L_0x000d;
    L_0x0009:
        r8 = r4;
        r9 = r8;
    L_0x000b:
        r10 = r9;
        goto L_0x0028;
    L_0x000d:
        if (r15 != r1) goto L_0x0012;
    L_0x000f:
        r8 = r3;
        r9 = r4;
        goto L_0x000b;
    L_0x0012:
        r5 = 3;
        if (r15 != r5) goto L_0x0019;
    L_0x0015:
        r10 = r2;
        r9 = r3;
        r8 = r4;
        goto L_0x0028;
    L_0x0019:
        if (r15 != r2) goto L_0x001f;
    L_0x001b:
        r10 = r2;
        r8 = r4;
        r9 = r8;
        goto L_0x0028;
    L_0x001f:
        if (r15 != r0) goto L_0x0025;
    L_0x0021:
        r10 = r0;
        r8 = r1;
        r9 = r4;
        goto L_0x0028;
    L_0x0025:
        r14.O000o0o = r3;	 Catch:{ Throwable -> 0x007e }
        goto L_0x0009;
    L_0x0028:
        r15 = r14.O00000o0;	 Catch:{ Throwable -> 0x007e }
        r15.setMapStyleMode(r8);	 Catch:{ Throwable -> 0x007e }
        r15 = r14.O00000o0;	 Catch:{ Throwable -> 0x007e }
        r15.setMapStyleTime(r9);	 Catch:{ Throwable -> 0x007e }
        r15 = r14.O00000o0;	 Catch:{ Throwable -> 0x007e }
        r15.setMapStyleState(r10);	 Catch:{ Throwable -> 0x007e }
        r15 = r14.O00000o0;	 Catch:{ Throwable -> 0x007e }
        r15 = r15.isCustomStyleEnable();	 Catch:{ Throwable -> 0x007e }
        if (r15 == 0) goto L_0x0064;
    L_0x003f:
        r15 = r14.O00O0OOo;	 Catch:{ Throwable -> 0x007e }
        if (r15 == 0) goto L_0x0051;
    L_0x0043:
        r15 = r14.O00O0OOo;	 Catch:{ Throwable -> 0x007e }
        r15 = r15.O00000o();	 Catch:{ Throwable -> 0x007e }
        if (r15 == 0) goto L_0x0051;
    L_0x004b:
        r15 = r14.O00O0OOo;	 Catch:{ Throwable -> 0x007e }
        r15.O00000oO();	 Catch:{ Throwable -> 0x007e }
        goto L_0x005e;
    L_0x0051:
        r7 = 1;
        r11 = 1;
        r12 = 0;
        r13 = 0;
        r6 = r14;
        r6.O000000o(r7, r8, r9, r10, r11, r12, r13);	 Catch:{ Throwable -> 0x007e }
        r15 = r14.O00000o0;	 Catch:{ Throwable -> 0x007e }
        r15.setCustomStyleEnable(r4);	 Catch:{ Throwable -> 0x007e }
    L_0x005e:
        r15 = r14.O000OOo;	 Catch:{ Throwable -> 0x007e }
        r15.setLogoEnable(r3);	 Catch:{ Throwable -> 0x007e }
        goto L_0x007a;
    L_0x0064:
        r15 = r14.O00000o0;	 Catch:{ Throwable -> 0x007e }
        r15 = r15.getMapLanguage();	 Catch:{ Throwable -> 0x007e }
        r0 = "en";
        r15 = r15.equals(r0);	 Catch:{ Throwable -> 0x007e }
        if (r15 == 0) goto L_0x0077;
    L_0x0072:
        r15 = "zh_cn";
        r14.setMapLanguage(r15);	 Catch:{ Throwable -> 0x007e }
    L_0x0077:
        r14.O00000Oo(r3, r8, r9, r10);	 Catch:{ Throwable -> 0x007e }
    L_0x007a:
        r14.resetRenderTime();	 Catch:{ Throwable -> 0x007e }
        goto L_0x0089;
    L_0x007e:
        r15 = move-exception;
        r0 = "AMapDelegateImp";
        r1 = "setMaptype";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r15, r0, r1);
        r15.printStackTrace();
    L_0x0089:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00o000.O0000oOO(int):void");
    }

    public OO00O0o O0000oOo(int i) {
        return this.O00O00oo == null ? null : this.O00O00oo.O000000o(i);
    }

    /* Access modifiers changed, original: protected */
    public void O0000oOo() {
        AMapNativeRenderer.nativeDrawLineInit();
    }

    public void O0000oo() {
        if (this.O00O0OOo != null) {
            this.O00O0OOo.O00000Oo();
        }
    }

    public float O0000oo0(int i) {
        GLMapState gLMapState = new GLMapState(1, this.O0000O0o.getNativeInstance());
        gLMapState.setMapZoomer((float) i);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    public Context O0000oo0() {
        return this.O00000oo;
    }

    public float[] O0000ooO() {
        return this.O00000o0 != null ? this.O00000o0.getMvpMatrix() : this.O0000o0;
    }

    public OO00O O0000ooo() {
        return this.O00O00oo;
    }

    public void O00oOooO() {
        if (this.O000Oo00 != null) {
            this.O000Oo00.O00000oO();
        }
    }

    public Arc addArc(ArcOptions arcOptions) throws RemoteException {
        resetRenderTime();
        O0OOOOO O000000o = this.O000Oo0O.O000000o(arcOptions);
        return O000000o != null ? new Arc(O000000o) : null;
    }

    public BuildingOverlay addBuildingOverlay() {
        try {
            O0OOo O000000o = this.O000Oo0O.O000000o();
            if (O000000o != null) {
                return new BuildingOverlay(O000000o);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        resetRenderTime();
        O0Oo000 O000000o = this.O000Oo0O.O000000o(circleOptions);
        return O000000o != null ? new Circle(O000000o) : null;
    }

    public CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(1, O0000oo0(), this);
        if (crossOverlayOptions != null) {
            crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.getOverlayBundle(1).addOverlay(crossVectorOverlay);
            crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        }
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    public GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        return this.O000OoO.O000000o(gL3DModelOptions);
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        resetRenderTime();
        O0Oo00 O000000o = this.O000Oo0O.O000000o(groundOverlayOptions);
        return O000000o != null ? new GroundOverlay(O000000o) : null;
    }

    public Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        resetRenderTime();
        return this.O00000Oo.O000000o(markerOptions);
    }

    public ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        resetRenderTime();
        return this.O00000Oo.O000000o((ArrayList) arrayList, z);
    }

    public MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        resetRenderTime();
        IMultiPointOverlay O000000o = this.O00O0OO.O000000o(multiPointOverlayOptions);
        return O000000o != null ? new MultiPointOverlay(O000000o) : null;
    }

    public RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    public NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        resetRenderTime();
        O0Oo O000000o = this.O000Oo0O.O000000o(navigateArrowOptions);
        return O000000o != null ? new NavigateArrow(O000000o) : null;
    }

    public void addOverlayTexture(int i, GLTextureProperty gLTextureProperty) {
        if (this.O0000O0o != null) {
            GLOverlayBundle overlayBundle = this.O0000O0o.getOverlayBundle(i);
            if (overlayBundle != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
                this.O0000O0o.addOverlayTexture(i, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        }
    }

    public ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        try {
            O0o0000 O000000o = this.O000Oo0O.O000000o(particleOverlayOptions);
            if (O000000o != null) {
                return new ParticleOverlay(O000000o);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        resetRenderTime();
        O0o000 O000000o = this.O000Oo0O.O000000o(polygonOptions);
        return O000000o != null ? new Polygon(O000000o) : null;
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        resetRenderTime();
        O0o00 O000000o = this.O000Oo0O.O000000o(polylineOptions);
        return O000000o != null ? new Polyline(O000000o) : null;
    }

    public Text addText(TextOptions textOptions) throws RemoteException {
        resetRenderTime();
        return this.O00000Oo.O000000o(textOptions);
    }

    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        return this.O000Oo0.O000000o(tileOverlayOptions);
    }

    public void afterAnimation() {
        O0000Oo();
    }

    public void afterDrawFrame(int i, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        boolean z = this.O0000O0o != null && (this.O0000O0o.isInMapAction(i) || this.O0000O0o.isInMapAnimation(i));
        if (!z) {
            if (this.O000oOOo != -1) {
                this.O000oo0.setRenderFps((float) this.O000oOOo);
            } else {
                this.O000oo0.setRenderFps(15.0f);
            }
            if (this.O000ooo == 1) {
                this.O000ooo = 0;
            }
            if (this.O000oo != mapZoomer) {
                this.O000oo = mapZoomer;
            }
        }
        if (!this.O00oOOoo) {
            this.O00oOOoo = true;
        }
    }

    public void afterDrawLabel(int i, GLMapState gLMapState) {
        O0000o0o();
        if (this.O0000O0o != null) {
            this.O0000O0o.pushRendererState();
        }
        this.O000Oo0.O00000Oo();
        this.O000Oo0O.O000000o(false, this.O000oO);
        if (this.O00O0OO != null) {
            this.O00O0OO.O000000o(this.O00000o0, getViewMatrix(), getProjectionMatrix());
        }
        if (this.O000OoO != null) {
            this.O000OoO.O000000o();
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.O000000o(false);
        }
        if (this.O000OO != null) {
            this.O000OO.O00000Oo(getMapWidth(), getMapHeight());
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.popRendererState();
        }
    }

    public void afterRendererOver(int i, GLMapState gLMapState) {
        if (this.O0000O0o != null) {
            this.O0000O0o.pushRendererState();
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.O000000o(true);
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.popRendererState();
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            O00000Oo(cameraUpdate.getCameraUpdateFactoryDelegate());
        }
    }

    public void animateCameraWithCallback(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate != null) {
            animateCameraWithDurationAndCallback(cameraUpdate, 250, cancelableCallback);
        }
    }

    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        if (cameraUpdate != null) {
            O000000o(cameraUpdate.getCameraUpdateFactoryDelegate(), j, cancelableCallback);
        }
    }

    public void beforeDrawLabel(int i, GLMapState gLMapState) {
        O0000o0o();
        if (this.O0000O0o != null) {
            this.O0000O0o.pushRendererState();
        }
        this.O000Oo0O.O000000o(true, this.O000oO);
        if (this.O0000O0o != null) {
            this.O0000O0o.popRendererState();
        }
    }

    public Pair<Float, LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i == i2 && i2 == i3 && i3 == i4 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.O000oooO || this.O00O0Oo) {
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat(mapConfig.getSX(), mapConfig.getSY(), obtain);
            Pair pair = new Pair(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain.y, obtain.x));
            obtain.recycle();
            return pair;
        }
        Builder builder = new Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(1, this.O0000O0o.getNativeInstance());
        Pair O000000o = OOo000.O000000o(mapConfig, i, i2, i3, i4, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (O000000o == null) {
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        GLMapState.geo2LonLat(((IPoint) O000000o.second).x, ((IPoint) O000000o.second).y, obtain2);
        Pair pair2 = new Pair(O000000o.first, new LatLng(obtain2.y, obtain2.x));
        obtain2.recycle();
        return pair2;
    }

    public boolean canStopMapRender() {
        if (this.O0000O0o != null) {
            this.O0000O0o.canStopMapRender(1);
        }
        return true;
    }

    public void changeSurface(GL10 gl10, int i, int i2) {
        try {
            O000000o(1, gl10, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void checkMapState(GLMapState gLMapState) {
        GLMapState gLMapState2 = gLMapState;
        if (this.O00000o0 != null && !this.O00O0Oo) {
            LatLngBounds limitLatLngBounds = this.O00000o0.getLimitLatLngBounds();
            if (limitLatLngBounds != null) {
                try {
                    IPoint[] iPointArr;
                    IPoint obtain;
                    int i;
                    int i2;
                    int[] O000000o;
                    IPoint[] limitIPoints = this.O00000o0.getLimitIPoints();
                    if (limitIPoints == null) {
                        GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, IPoint.obtain());
                        GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, IPoint.obtain());
                        iPointArr = new IPoint[]{r2, r3};
                        this.O00000o0.setLimitIPoints(iPointArr);
                    } else {
                        iPointArr = limitIPoints;
                    }
                    float O00000Oo = OOo000.O00000Oo(this.O00000o0, iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, getMapWidth(), getMapHeight());
                    float mapZoomer = gLMapState.getMapZoomer();
                    if (this.O00000o0.isSetLimitZoomLevel()) {
                        float maxZoomLevel = this.O00000o0.getMaxZoomLevel();
                        float minZoomLevel = this.O00000o0.getMinZoomLevel();
                        mapZoomer = Math.max(O00000Oo, Math.min(mapZoomer, maxZoomLevel));
                        if (O00000Oo > maxZoomLevel) {
                            mapZoomer = maxZoomLevel;
                        }
                        if (mapZoomer < minZoomLevel) {
                            O00000Oo = minZoomLevel;
                            gLMapState2.setMapZoomer(O00000Oo);
                            obtain = IPoint.obtain();
                            gLMapState2.getMapGeoCenter(obtain);
                            i = obtain.x;
                            i2 = obtain.y;
                            O000000o = OOo000.O000000o(iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, this.O00000o0, gLMapState2, i, i2);
                            if (O000000o != null && O000000o.length == 2) {
                                i = O000000o[0];
                                i2 = O000000o[1];
                            }
                            gLMapState2.setMapGeoCenter(i, i2);
                            obtain.recycle();
                        }
                    } else if (O00000Oo > 0.0f && mapZoomer < O00000Oo) {
                        gLMapState2.setMapZoomer(O00000Oo);
                        obtain = IPoint.obtain();
                        gLMapState2.getMapGeoCenter(obtain);
                        i = obtain.x;
                        i2 = obtain.y;
                        O000000o = OOo000.O000000o(iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, this.O00000o0, gLMapState2, i, i2);
                        i = O000000o[0];
                        i2 = O000000o[1];
                        gLMapState2.setMapGeoCenter(i, i2);
                        obtain.recycle();
                    }
                    O00000Oo = mapZoomer;
                    gLMapState2.setMapZoomer(O00000Oo);
                    obtain = IPoint.obtain();
                    gLMapState2.getMapGeoCenter(obtain);
                    i = obtain.x;
                    i2 = obtain.y;
                    O000000o = OOo000.O000000o(iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, this.O00000o0, gLMapState2, i, i2);
                    i = O000000o[0];
                    i2 = O000000o[1];
                    gLMapState2.setMapGeoCenter(i, i2);
                    obtain.recycle();
                } catch (Throwable unused) {
                }
            } else if (this.O00000o0.isSetLimitZoomLevel()) {
                gLMapState2.setMapZoomer(Math.max(this.O00000o0.getMinZoomLevel(), Math.min(gLMapState.getMapZoomer(), this.O00000o0.getMaxZoomLevel())));
            }
        }
    }

    public void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImp", "clear");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035 A:{Catch:{ Throwable -> 0x0052 }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e A:{Catch:{ Throwable -> 0x0052 }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047 A:{Catch:{ Throwable -> 0x0052 }} */
    public void clear(boolean r3) throws android.os.RemoteException {
        /*
        r2 = this;
        r2.O0000Oo0();	 Catch:{ Throwable -> 0x0052 }
        r0 = r2.O000OooO;	 Catch:{ Throwable -> 0x0052 }
        r1 = 0;
        if (r0 == 0) goto L_0x001c;
    L_0x0008:
        if (r3 == 0) goto L_0x0017;
    L_0x000a:
        r3 = r2.O000OooO;	 Catch:{ Throwable -> 0x0052 }
        r1 = r3.O00000o0();	 Catch:{ Throwable -> 0x0052 }
        r3 = r2.O000OooO;	 Catch:{ Throwable -> 0x0052 }
        r3 = r3.O00000o();	 Catch:{ Throwable -> 0x0052 }
        goto L_0x001d;
    L_0x0017:
        r3 = r2.O000OooO;	 Catch:{ Throwable -> 0x0052 }
        r3.O00000oO();	 Catch:{ Throwable -> 0x0052 }
    L_0x001c:
        r3 = r1;
    L_0x001d:
        r0 = r2.O000Oo0O;	 Catch:{ Throwable -> 0x0052 }
        r0.O00000Oo(r3);	 Catch:{ Throwable -> 0x0052 }
        r3 = r2.O000Oo0;	 Catch:{ Throwable -> 0x0052 }
        r3.O00000o0();	 Catch:{ Throwable -> 0x0052 }
        r3 = r2.O00000Oo;	 Catch:{ Throwable -> 0x0052 }
        r3.O000000o(r1);	 Catch:{ Throwable -> 0x0052 }
        r3 = r2.O000OoO;	 Catch:{ Throwable -> 0x0052 }
        r3.O00000Oo();	 Catch:{ Throwable -> 0x0052 }
        r3 = r2.O000Oo00;	 Catch:{ Throwable -> 0x0052 }
        if (r3 == 0) goto L_0x003a;
    L_0x0035:
        r3 = r2.O000Oo00;	 Catch:{ Throwable -> 0x0052 }
        r3.O0000Ooo();	 Catch:{ Throwable -> 0x0052 }
    L_0x003a:
        r3 = r2.O00O0OO;	 Catch:{ Throwable -> 0x0052 }
        if (r3 == 0) goto L_0x0043;
    L_0x003e:
        r3 = r2.O00O0OO;	 Catch:{ Throwable -> 0x0052 }
        r3.O00000o0();	 Catch:{ Throwable -> 0x0052 }
    L_0x0043:
        r3 = r2.O0000O0o;	 Catch:{ Throwable -> 0x0052 }
        if (r3 == 0) goto L_0x004e;
    L_0x0047:
        r3 = r2.O0000O0o;	 Catch:{ Throwable -> 0x0052 }
        r0 = r2.O000OoO0;	 Catch:{ Throwable -> 0x0052 }
        r3.removeNativeAllOverlay(r0);	 Catch:{ Throwable -> 0x0052 }
    L_0x004e:
        r2.resetRenderTime();	 Catch:{ Throwable -> 0x0052 }
        goto L_0x005d;
    L_0x0052:
        r3 = move-exception;
        r0 = "AMapDelegateImp";
        r1 = "clear";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r3, r0, r1);
        r3.printStackTrace();
    L_0x005d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00o000.clear(boolean):void");
    }

    public long createGLOverlay(int i) {
        return this.O0000O0o != null ? this.O0000O0o.createOverlay(1, i) : 0;
    }

    public void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            O000000o(1, gl10, eGLConfig);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        this.O00O0Oo = true;
        try {
            if (this.O000oOoo != null) {
                this.O000oOoo.O000000o();
            }
            if (this.O00O0OO != null) {
                this.O00O0OO.O00000Oo();
            }
            if (this.O000Oooo != null) {
                this.O000Oooo.deactivate();
            }
            this.O000Oooo = null;
            this.O00O00oO = null;
            if (this.O000oo0 != null) {
                this.O000oo0.renderPause();
            }
            if (this.O00O0O0o != null) {
                this.O00O0O0o.O00000o();
            }
            if (this.O000oo0O != null) {
                this.O000oo0O.O000000o(null);
                this.O000oo0O.O00000Oo();
                this.O000oo0O = null;
            }
            if (this.O000Oo0O != null) {
                this.O000Oo0O.O00000o();
            }
            if (this.O00000Oo != null) {
                this.O00000Oo.O0000Oo0();
            }
            if (this.O000Oo0 != null) {
                this.O000Oo0.O00000oo();
            }
            O000O00o();
            if (this.O000o != null) {
                this.O000o.interrupt();
                this.O000o = null;
            }
            if (this.O000oO00 != null) {
                this.O000oO00.interrupt();
                this.O000oO00 = null;
            }
            if (this.O000oOo != null) {
                this.O000oOo.O000000o();
                this.O000oOo = null;
            }
            if (this.O000oOoO != null) {
                this.O000oOoO.O000000o(null);
                this.O000oOoO.O000000o();
                this.O000oOoO = null;
            }
            OOO0O0O.O00000Oo();
            if (this.O0000O0o != null) {
                this.O0000O0o.setMapListener(null);
                this.O0000O0o.releaseNetworkState();
                queueEvent(new Runnable() {
                    public void run() {
                        try {
                            if (O00o000.this.O00O0O0o != null) {
                                O00o000.this.O00O0O0o.O00000o0();
                            }
                            if (O00o000.this.O00O00oo != null) {
                                O00o000.this.O00O00oo.O00000Oo();
                                O00o000.this.O00O00oo = null;
                            }
                            if (O00o000.this.O0000O0o != null) {
                                O00o000.this.O0000O0o.getOverlayBundle(O00o000.this.O000OoO0).removeAll(true);
                                O00o000.this.O0000O0o.destroyAMapEngine();
                                O00o000.this.O0000O0o = null;
                            }
                            O00o000.this.O000OoO.O00000o();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                int i = 0;
                while (this.O0000O0o != null) {
                    int i2 = i + 1;
                    if (i < 20) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException unused) {
                        }
                        i = i2;
                    }
                }
            }
            if (this.O000OoO != null) {
                this.O000OoO.O00000o0();
            }
            if (this.O000OO0o != null) {
                this.O000OO0o.O00000Oo();
            }
            if (this.O000OOoo != null) {
                this.O000OOoo.O00000Oo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImp", "destroy");
            th.printStackTrace();
            return;
        }
        if (this.O000Oo00 != null) {
            this.O000Oo00.O0000OoO();
            this.O000Oo00 = null;
        }
        if (this.O000OooO != null) {
            this.O000OooO.O00000Oo();
            this.O000OooO = null;
        }
        this.O000Oooo = null;
        O000O0oO();
        this.O000o0oo = null;
        ooOOOOoo.O00000Oo();
    }

    public void destroySurface(int i) {
        this.O00O000o.lock();
        try {
            if (this.O000oooO) {
                this.O0000O0o.destroyAMapEngine();
            }
            this.O000oooO = false;
            this.O000oooo = false;
            this.O00oOOoo = false;
        } catch (Throwable th) {
            this.O00O000o.unlock();
        }
        this.O00O000o.unlock();
    }

    public void drawFrame(GL10 gl10) {
        if (!this.O00O0Oo && this.O0000O0o != null) {
            O000000o(1, gl10);
            this.O0000O0o.renderAMap();
            this.O0000O0o.pushRendererState();
            if (this.O000oOO0 != null) {
                this.O000oOO0.onDrawFrame(gl10);
            }
            if (this.O00O0OOo != null) {
                this.O00O0OOo.O000000o();
            }
            O000000o(gl10);
            O000O0Oo();
            if (!this.oooOoO) {
                this.oooOoO = true;
            }
            this.O0000O0o.popRendererState();
            if (this.O000oOoo != null) {
                this.O000oOoo.O000000o(new O00000o(153));
            }
            if (OOOO0.O000000o()) {
                try {
                    if (this.O000OOoo instanceof f) {
                        if (this.O00000oO == null) {
                            this.O00000oO = new OOOO0();
                        }
                        this.O00000oO.O00000o0();
                        if (this.O00000oO.O00000o() && !this.O00000oO.O00000Oo()) {
                            if (this.O00000oO.O000000o(((f) this.O000OOoo).getBitmap())) {
                                removecache();
                            }
                        }
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
                }
            }
        }
    }

    public Projection getAMapProjection() throws RemoteException {
        return new Projection(this.O000OOo0);
    }

    public UiSettings getAMapUiSettings() throws RemoteException {
        if (this.O000OOOo == null) {
            this.O000OOOo = new UiSettings(this.O000OOo);
        }
        return this.O000OOOo;
    }

    public AMapCameraInfo getCamerInfo() {
        return null;
    }

    public float getCameraAngle() {
        return O0000o0O(this.O000OoO0);
    }

    public CameraPosition getCameraPosition() throws RemoteException {
        return O00000oo(this.O000Ooo0);
    }

    public long getGlOverlayMgrPtr() {
        return this.O0000O0o != null ? this.O0000O0o.getGlOverlayMgrPtr(1) : 0;
    }

    public InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return new InfoWindowAnimationManager(this.O000OO);
    }

    public void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.O00000o0.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i = 0; i < 4; i++) {
                    GLMapState.geo2LonLat(clipRect[i].x, clipRect[i].y, dPointArr[i]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public Handler getMainHandler() {
        return this.O0000Oo;
    }

    public MapConfig getMapConfig() {
        return this.O00000o0;
    }

    public String getMapContentApprovalNumber() {
        if (this.O00000o0 == null || this.O00000o0.isCustomStyleEnable()) {
            return null;
        }
        String O000000o = OOOO00O.O000000o(this.O00000oo, "approval_number", DeviceInfo.TAG_MAC, "");
        return !TextUtils.isEmpty(O000000o) ? O000000o : "GS（2017）3426号 | GS（2017）2550号";
    }

    public int getMapHeight() {
        return this.O0000Oo0;
    }

    public void getMapPrintScreen(onMapPrintScreenListener onmapprintscreenlistener) {
        this.O000O0oO = onmapprintscreenlistener;
        this.O000o0OO = true;
        resetRenderTime();
    }

    public List<Marker> getMapScreenMarkers() throws RemoteException {
        return !OOo000.O00000Oo(getMapWidth(), getMapHeight()) ? new ArrayList() : this.O00000Oo.O00000oO();
    }

    public void getMapScreenShot(OnMapScreenShotListener onMapScreenShotListener) {
        this.O000O0oo = onMapScreenShotListener;
        this.O000o0OO = true;
        resetRenderTime();
    }

    public int getMapTextZIndex() throws RemoteException {
        return this.O000oO;
    }

    public int getMapType() throws RemoteException {
        return this.O000o0o;
    }

    public int getMapWidth() {
        return this.O0000OOo;
    }

    public float getMaxZoomLevel() {
        return this.O00000o0 != null ? this.O00000o0.getMaxZoomLevel() : 20.0f;
    }

    public float getMinZoomLevel() {
        return this.O00000o0 != null ? this.O00000o0.getMinZoomLevel() : 3.0f;
    }

    public Location getMyLocation() throws RemoteException {
        return this.O000Oooo != null ? this.O000O0o.O000000o : null;
    }

    public MyLocationStyle getMyLocationStyle() throws RemoteException {
        return this.O000OooO != null ? this.O000OooO.O000000o() : null;
    }

    public float[] getProjectionMatrix() {
        return this.O00000o0 != null ? this.O00000o0.getProjectionMatrix() : this.O0000o0o;
    }

    public int getRenderMode() {
        return this.O000OOoo.getRenderMode();
    }

    public String getSatelliteImageApprovalNumber() {
        String O000000o = OOOO00O.O000000o(this.O00000oo, "approval_number", "si", "");
        return !TextUtils.isEmpty(O000000o) ? O000000o : "GS（2018）984号";
    }

    public float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (256.0d * Math.pow(2.0d, (double) O0000O0o())))) * O0000oOO();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImp", "getScalePerPixel");
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getSkyHeight() {
        return this.O00000o0.getSkyHeight();
    }

    public View getView() throws RemoteException {
        return this.O000Oo00;
    }

    public float[] getViewMatrix() {
        return this.O00000o0 != null ? this.O00000o0.getViewMatrix() : this.O0000o0O;
    }

    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.O000oooO || this.O00O0Oo) {
            return mapConfig.getSZ();
        }
        Builder builder = new Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(1, this.O0000O0o.getNativeInstance());
        Pair O000000o = OOo000.O000000o(mapConfig, 0, 0, 0, 0, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        return O000000o != null ? ((Float) O000000o.first).floatValue() : gLMapState.getMapZoomer();
    }

    public boolean isIndoorEnabled() throws RemoteException {
        return this.O00000o0.isIndoorEnable();
    }

    public boolean isMaploaded() {
        return this.O000Ooo;
    }

    public boolean isMyLocationEnabled() throws RemoteException {
        return this.O000Oo0o;
    }

    public boolean isTrafficEnabled() throws RemoteException {
        return this.O00000o0.isTrafficEnabled();
    }

    public void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            O000000o(cameraUpdate.getCameraUpdateFactoryDelegate());
        }
    }

    public void onActivityPause() {
        this.O000OoOo = true;
        O0000o0o(this.O000OoO0);
    }

    public void onActivityResume() {
        this.O000OoOo = false;
        int i = this.O000OoO0;
        if (i == 0) {
            i = this.O0000O0o.getEngineIDWithType(0);
        }
        O0000o(i);
    }

    public void onChangeFinish() {
        Message obtainMessage = this.O0000Oo.obtainMessage();
        obtainMessage.what = 11;
        this.O0000Oo.sendMessage(obtainMessage);
    }

    public void onFling() {
        if (this.O000Oo0 != null) {
            this.O000Oo0.O00000Oo(true);
        }
        this.O000o0O = true;
    }

    public void onIndoorBuildingActivity(int i, byte[] bArr) {
        O00O0Oo o00O0Oo;
        if (bArr != null) {
            try {
                o00O0Oo = new O00O0Oo();
                int i2 = 0;
                byte b = bArr[0];
                o00O0Oo.O000000o = new String(bArr, 1, b, "utf-8");
                int i3 = 1 + b;
                int i4 = i3 + 1;
                byte b2 = bArr[i3];
                o00O0Oo.O00000Oo = new String(bArr, i4, b2, "utf-8");
                i4 += b2;
                int i5 = i4 + 1;
                b = bArr[i4];
                o00O0Oo.activeFloorName = new String(bArr, i5, b, "utf-8");
                i5 += b;
                o00O0Oo.activeFloorIndex = GLConvertUtil.getInt(bArr, i5);
                i5 += 4;
                i4 = i5 + 1;
                b2 = bArr[i5];
                o00O0Oo.poiid = new String(bArr, i4, b2, "utf-8");
                i4 += b2;
                i5 = i4 + 1;
                b = bArr[i4];
                o00O0Oo.O0000OOo = new String(bArr, i5, b, "utf-8");
                i5 += b;
                o00O0Oo.O00000o0 = GLConvertUtil.getInt(bArr, i5);
                i5 += 4;
                o00O0Oo.floor_indexs = new int[o00O0Oo.O00000o0];
                o00O0Oo.floor_names = new String[o00O0Oo.O00000o0];
                o00O0Oo.O00000o = new String[o00O0Oo.O00000o0];
                for (i4 = 0; i4 < o00O0Oo.O00000o0; i4++) {
                    o00O0Oo.floor_indexs[i4] = GLConvertUtil.getInt(bArr, i5);
                    i5 += 4;
                    int i6 = i5 + 1;
                    b2 = bArr[i5];
                    if (b2 > (byte) 0) {
                        o00O0Oo.floor_names[i4] = new String(bArr, i6, b2, "utf-8");
                        i6 += b2;
                    }
                    i5 = i6 + 1;
                    byte b3 = bArr[i6];
                    if (b3 > (byte) 0) {
                        o00O0Oo.O00000o[i4] = new String(bArr, i5, b3, "utf-8");
                        i5 += b3;
                    }
                }
                o00O0Oo.O00000oO = GLConvertUtil.getInt(bArr, i5);
                i5 += 4;
                if (o00O0Oo.O00000oO > 0) {
                    o00O0Oo.O00000oo = new int[o00O0Oo.O00000oO];
                    while (i2 < o00O0Oo.O00000oO) {
                        o00O0Oo.O00000oo[i2] = GLConvertUtil.getInt(bArr, i5);
                        i5 += 4;
                        i2++;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        o00O0Oo = null;
        this.O00O0ooO = o00O0Oo;
        O000000o(new Runnable() {
            public void run() {
                if (O00o000.this.O00O00oO != null) {
                    O00o000.this.O00O00oO.O000000o(O00o000.this.O00O0ooO);
                }
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O000OoOo || !this.O000oooO || !this.O000ooOO) {
            return false;
        }
        this.O00O0oo0.mGestureState = 3;
        this.O00O0oo0.mGestureType = 8;
        float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
        this.O00O0oo0.mLocation = fArr;
        int O000000o = O000000o(this.O00O0oo0);
        O0000oO0();
        switch (motionEvent.getAction() & 255) {
            case 0:
                O0000oO();
                O0000oo(O000000o);
                break;
            case 1:
                O0000ooO(O000000o);
                break;
        }
        if (motionEvent.getAction() == 2 && this.O000o000) {
            try {
                O000000o(motionEvent);
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapDelegateImp", "onDragMarker");
                th.printStackTrace();
            }
            return true;
        }
        if (this.O000oo0o) {
            try {
                this.O000oo0O.O000000o(motionEvent);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (this.O00oOooo != null) {
            this.O0000Oo.removeMessages(14);
            Message obtainMessage = this.O0000Oo.obtainMessage();
            obtainMessage.what = 14;
            obtainMessage.obj = MotionEvent.obtain(motionEvent);
            obtainMessage.sendToTarget();
        }
        return true;
    }

    public void queueEvent(Runnable runnable) {
        try {
            if (this.O0000O0o != null) {
                this.O000OOoo.queueEvent(runnable);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapdelegateImp", "queueEvent");
        }
    }

    public void reloadMap() {
    }

    public void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        if (this.O0000O0o != null) {
            this.O0000O0o.getOverlayBundle(1).removeOverlay(baseMapOverlay);
        }
    }

    public void removecache() throws RemoteException {
        removecache(null);
    }

    public void removecache(OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.O0000Oo != null && this.O0000O0o != null) {
            try {
                O00000o o00000o = new O00000o(this.O00000oo, onCacheRemoveListener);
                this.O0000Oo.removeCallbacks(o00000o);
                this.O0000Oo.post(o00000o);
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapDelegateImp", "removecache");
                th.printStackTrace();
            }
        }
    }

    public void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    public void requestRender() {
        if (this.O000oo0 != null && !this.O000oo0.isRenderPause()) {
            this.O000OOoo.requestRender();
        }
    }

    public void resetMinMaxZoomPreference() {
        this.O00000o0.resetMinMaxZoomPreference();
        try {
            if (this.O000OOo.isZoomControlsEnabled() && this.O00000o0.isNeedUpdateZoomControllerState() && this.O000OoOO != null) {
                this.O000OoOO.invalidateZoomController(this.O00000o0.getSZ());
            }
        } catch (RemoteException unused) {
        }
    }

    public void resetRenderTime() {
        if (this.O000oo0 != null) {
            this.O000oo0.resetTickCount(2);
        }
    }

    public void set3DBuildingEnabled(boolean z) throws RemoteException {
        O0000o0o(1);
        O000000o(1, z);
        O0000o(1);
    }

    public void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        if (this.O000oo0O != null) {
            this.O000OO00 = aMapGestureListener;
            this.O000oo0O.O000000o(aMapGestureListener);
        }
    }

    public void setCenterToPixel(int i, int i2) throws RemoteException {
        this.O000Ooo0 = true;
        this.O00O00o0 = i;
        this.O00O00o = i2;
        if (this.O000oooo && this.O000oooO && (this.O00000o0.getAnchorX() != this.O00O00o0 || this.O00000o0.getAnchorY() != this.O00O00o)) {
            this.O00000o0.setAnchorX(this.O00O00o0);
            this.O00000o0.setAnchorY(this.O00O00o);
            queueEvent(new Runnable() {
                public void run() {
                    try {
                        O00o000.this.O00000o0.setAnchorX(Math.max(0, Math.min(O00o000.this.O00O00o0, O00o000.this.O0000OOo)));
                        O00o000.this.O00000o0.setAnchorY(Math.max(0, Math.min(O00o000.this.O00O00o, O00o000.this.O0000Oo0)));
                        O00o000.this.O0000O0o.setProjectionCenter(1, O00o000.this.O00000o0.getAnchorX(), O00o000.this.O00000o0.getAnchorY());
                        O00o000.this.O000oO0o = true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            if (customMapStyleOptions.isEnable()) {
                O000O0o0();
            }
            this.O00O0OOo.O00000o0();
            this.O00O0OOo.O000000o(customMapStyleOptions);
        }
        resetRenderTime();
    }

    public void setCustomMapStyleID(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.O00000o0.getCustomStyleID())) {
            this.O00000o0.setCustomStyleID(str);
            this.O000OOoO = true;
        }
    }

    public void setCustomMapStylePath(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.O00000o0.getCustomStylePath())) {
            this.O00000o0.setCustomStylePath(str);
            this.O000OOoO = true;
        }
    }

    public void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.O000oOO0 = customRenderer;
    }

    public void setCustomTextureResourcePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o0.setCustomTextureResourcePath(str);
        }
    }

    public void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (!this.O00O0Oo && indoorBuildingInfo != null && indoorBuildingInfo.activeFloorName != null && indoorBuildingInfo.poiid != null) {
            this.O00000o = (O00O0Oo) indoorBuildingInfo;
            resetRenderTime();
            queueEvent(new Runnable() {
                public void run() {
                    if (O00o000.this.O0000O0o != null) {
                        O00o000.this.O0000O0o.setIndoorBuildingToBeActive(1, O00o000.this.O00000o.activeFloorName, O00o000.this.O00000o.activeFloorIndex, O00o000.this.O00000o.poiid);
                    }
                }
            });
        }
    }

    public void setIndoorEnabled(final boolean z) throws RemoteException {
        if (!this.O000oooO || this.O00O0Oo) {
            this.O00O0o.O00000o0 = z;
            this.O00O0o.O00000Oo = true;
            this.O00O0o.O0000O0o = 1;
            return;
        }
        this.O00000o0.setIndoorEnable(z);
        resetRenderTime();
        if (!z) {
            if (this.O0000O0o != null) {
                this.O0000O0o.setIndoorEnable(1, false);
            }
            this.O00000o0.maxZoomLevel = this.O00000o0.isSetLimitZoomLevel() ? this.O00000o0.getMaxZoomLevel() : 20.0f;
            if (this.O000OOo.isZoomControlsEnabled() && this.O000OoOO != null) {
                this.O000OoOO.invalidateZoomController(this.O00000o0.getSZ());
            }
        } else if (this.O0000O0o != null) {
            this.O0000O0o.setIndoorEnable(1, true);
        }
        if (this.O000OOo.isIndoorSwitchEnabled()) {
            this.O0000Oo.post(new Runnable() {
                public void run() {
                    if (z) {
                        O00o000.this.O00000Oo(true);
                    } else if (O00o000.this.O000Oo00 != null) {
                        O00o000.this.O000Oo00.O0000Oo0(Boolean.valueOf(false));
                    }
                }
            });
        }
    }

    public void setInfoWindowAdapter(CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        if (!(this.O00O0Oo || this.O000OO0o == null)) {
            this.O000OO0o.O000000o(commonInfoWindowAdapter);
        }
    }

    public void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        if (!(this.O00O0Oo || this.O000OO0o == null)) {
            this.O000OO0o.O000000o(infoWindowAdapter);
        }
    }

    public void setLoadOfflineData(final boolean z) throws RemoteException {
        queueEvent(new Runnable() {
            public void run() {
                if (O00o000.this.O0000O0o != null) {
                    O00o000.this.O0000O0o.setOfflineDataEnable(1, z);
                }
            }
        });
    }

    public void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (!this.O00O0Oo) {
                if (this.O000Oooo != null && (this.O000Oooo instanceof O000o0)) {
                    this.O000Oooo.deactivate();
                }
                this.O000Oooo = locationSource;
                if (locationSource != null) {
                    this.O000Oo00.O0000OOo(Boolean.valueOf(true));
                } else {
                    this.O000Oo00.O0000OOo(Boolean.valueOf(false));
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
        }
    }

    public void setMapCustomEnable(boolean z) {
        if (z) {
            O000O0o0();
        }
        O000000o(z, false);
    }

    /* JADX WARNING: Missing block: B:26:0x0065, code skipped:
            return;
     */
    public void setMapLanguage(java.lang.String r2) {
        /*
        r1 = this;
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 != 0) goto L_0x0065;
    L_0x0006:
        r0 = r1.O00000o0;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        goto L_0x0065;
    L_0x000b:
        r0 = r1.O00000o0;
        r0 = r0.isCustomStyleEnable();
        if (r0 == 0) goto L_0x0014;
    L_0x0013:
        return;
    L_0x0014:
        r0 = r1.O00000o0;
        r0 = r0.getMapLanguage();
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0021;
    L_0x0020:
        return;
    L_0x0021:
        r0 = "en";
        r2 = r2.equals(r0);
        r0 = 1;
        r2 = r2 ^ r0;
        if (r2 == 0) goto L_0x0036;
    L_0x002b:
        r2 = r1.O00000o0;
        r0 = "zh_cn";
        r2.setMapLanguage(r0);
        r2 = 0;
        r1.O000oO = r2;
        goto L_0x004d;
    L_0x0036:
        r2 = r1.O000o0o;
        if (r2 == r0) goto L_0x0042;
    L_0x003a:
        r1.setMapType(r0);	 Catch:{ Throwable -> 0x003e }
        goto L_0x0042;
    L_0x003e:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x0042:
        r2 = r1.O00000o0;
        r0 = "en";
        r2.setMapLanguage(r0);
        r2 = -10000; // 0xffffffffffffd8f0 float:NaN double:NaN;
        r1.O000oO = r2;
    L_0x004d:
        r2 = r1.getCameraPosition();	 Catch:{ Throwable -> 0x0055 }
        r1.O000000o(r2);	 Catch:{ Throwable -> 0x0055 }
        goto L_0x0059;
    L_0x0055:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x0059:
        r2 = r1.O000Oo0;
        r0 = r1.O00000o0;
        r0 = r0.getMapLanguage();
        r2.O000000o(r0);
        return;
    L_0x0065:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00o000.setMapLanguage(java.lang.String):void");
    }

    public void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.O00000o0.setLimitLatLngBounds(latLngBounds);
            O000O0o();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMapTextEnable(final boolean z) throws RemoteException {
        if (this.O000oooO && this.O000oooo) {
            resetRenderTime();
            queueEvent(new Runnable() {
                public void run() {
                    try {
                        O00o000.this.O0000O0o.setLabelEnable(1, z);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        this.O00O0o0O.O00000o0 = z;
        this.O00O0o0O.O00000Oo = true;
        this.O00O0o0O.O0000O0o = 1;
    }

    public void setMapTextZIndex(int i) throws RemoteException {
        this.O000oO = i;
    }

    public void setMapType(int i) throws RemoteException {
        if (i != this.O000o0o || (this.O00000o0 != null && this.O00000o0.isCustomStyleEnable())) {
            if (this.O000oOoo != null) {
                this.O000oOoo.O000000o(new O00000o(1, Integer.valueOf(i)));
            }
            this.O000o0o = i;
        }
    }

    public void setMaskLayerParams(int i, int i2, int i3, int i4, final int i5, long j) {
        try {
            if (this.O000oOO != null) {
                GLAlphaAnimation gLAlphaAnimation;
                float f = ((float) i4) / 255.0f;
                if (i5 == -1) {
                    gLAlphaAnimation = new GLAlphaAnimation(f, 0.0f);
                    gLAlphaAnimation.setAnimationListener(new AnimationListener() {
                        public void onAnimationEnd() {
                            O00o000.this.O0000Oo.post(new Runnable() {
                                public void run() {
                                    O00o000.this.O000oOOO = i5;
                                    if (O00o000.this.O000Oo00 != null) {
                                        O00o000.this.O000Oo00.O0000Oo(Boolean.valueOf(true));
                                    }
                                }
                            });
                        }

                        public void onAnimationStart() {
                        }
                    });
                } else {
                    this.O000oOOO = i5;
                    gLAlphaAnimation = new GLAlphaAnimation(0.0f, f);
                    if (f > 0.2f) {
                        if (this.O000Oo00 != null) {
                            this.O000Oo00.O0000Oo(Boolean.valueOf(false));
                        }
                    } else if (this.O000Oo00 != null) {
                        this.O000Oo00.O0000Oo(Boolean.valueOf(true));
                    }
                }
                gLAlphaAnimation.setInterpolator(new LinearInterpolator());
                gLAlphaAnimation.setDuration(j);
                this.O000oOO.O000000o(i, i2, i3, i4);
                this.O000oOO.O000000o(gLAlphaAnimation);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxZoomLevel(float f) {
        this.O00000o0.setMaxZoomLevel(f);
    }

    public void setMinZoomLevel(float f) {
        this.O00000o0.setMinZoomLevel(f);
    }

    public void setMyLocationEnabled(boolean z) throws RemoteException {
        if (!this.O00O0Oo) {
            try {
                if (this.O000Oo00 != null) {
                    this.O000Oo00.O0000OOo();
                    if (this.O000Oooo == null) {
                        this.O000Oo00.O0000OOo(Boolean.valueOf(false));
                    } else if (z) {
                        this.O000Oooo.activate(this.O000O0o);
                        this.O000Oo00.O0000OOo(Boolean.valueOf(true));
                        if (this.O000OooO == null) {
                            this.O000OooO = new ooO0Ooo(this, this.O00000oo);
                        }
                    } else {
                        if (this.O000OooO != null) {
                            this.O000OooO.O00000Oo();
                            this.O000OooO = null;
                        }
                        this.O000Oooo.deactivate();
                    }
                }
                if (!z) {
                    this.O000OOo.setMyLocationButtonEnabled(z);
                }
                this.O000Oo0o = z;
                resetRenderTime();
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapDelegateImp", "setMyLocationEnabled");
                th.printStackTrace();
            }
        }
    }

    public void setMyLocationRotateAngle(float f) throws RemoteException {
        if (this.O000OooO != null) {
            this.O000OooO.O000000o(f);
        }
    }

    public void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (!this.O00O0Oo) {
            if (this.O000OooO == null) {
                this.O000OooO = new ooO0Ooo(this, this.O00000oo);
            }
            if (this.O000OooO != null) {
                long j = (long) 1000;
                if (myLocationStyle.getInterval() < j) {
                    myLocationStyle.interval(j);
                }
                if (this.O000Oooo != null && (this.O000Oooo instanceof O000o0)) {
                    ((O000o0) this.O000Oooo).O000000o(myLocationStyle.getInterval());
                    ((O000o0) this.O000Oooo).O000000o(myLocationStyle.getMyLocationType());
                }
                this.O000OooO.O000000o(myLocationStyle);
            }
        }
    }

    public void setMyLocationType(int i) throws RemoteException {
        if (this.O000OooO != null && this.O000OooO.O000000o() != null) {
            this.O000OooO.O000000o().myLocationType(i);
            setMyLocationStyle(this.O000OooO.O000000o());
        }
    }

    public void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) throws RemoteException {
        if (!this.O00O0Oo) {
            this.O000o0oo = myTrafficStyle;
            if (this.O000oooO && this.O000oooo && myTrafficStyle != null) {
                resetRenderTime();
                queueEvent(new Runnable() {
                    public void run() {
                        try {
                            O00o000.this.O0000O0o.setTrafficStyle(1, O00o000.this.O000o0oo.getSmoothColor(), O00o000.this.O000o0oo.getSlowColor(), O00o000.this.O000o0oo.getCongestedColor(), O00o000.this.O000o0oo.getSeriousCongestedColor());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                this.O00O0oOo.O00000o0 = false;
                this.O00O0oOo.O00000Oo = true;
                this.O00O0oOo.O0000O0o = 1;
            }
        }
    }

    public void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        this.O0000ooo = onCameraChangeListener;
    }

    public void setOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        this.O00oOoOo = onIndoorBuildingActiveListener;
    }

    public void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        this.O000O0Oo = onInfoWindowClickListener;
    }

    public void setOnMapClickListener(OnMapClickListener onMapClickListener) throws RemoteException {
        this.O00oOooO = onMapClickListener;
    }

    public void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        this.O000O0OO = onMapLongClickListener;
    }

    public void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) throws RemoteException {
        this.O00oOooo = onMapTouchListener;
    }

    public void setOnMaploadedListener(OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        this.O0000ooO = onMapLoadedListener;
    }

    public void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        this.O0000oOo = onMarkerClickListener;
    }

    public void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        this.O0000oo = onMarkerDragListener;
    }

    public void setOnMultiPointClickListener(OnMultiPointClickListener onMultiPointClickListener) {
        if (this.O00O0OO != null) {
            this.O00O0OO.O000000o(onMultiPointClickListener);
        }
    }

    public void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        this.O000O0o0 = onMyLocationChangeListener;
    }

    public void setOnPOIClickListener(OnPOIClickListener onPOIClickListener) throws RemoteException {
        this.O000O00o = onPOIClickListener;
    }

    public void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        this.O0000oo0 = onPolylineClickListener;
    }

    public void setRenderFps(int i) {
        try {
            this.O000oOOo = Math.max(10, Math.min(i, 40));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRenderMode(int i) {
        if (this.O000OOoo != null) {
            this.O000OOoo.setRenderMode(i);
        }
    }

    public void setRunLowFrame(boolean z) {
        if (!z) {
            O0000oO();
        }
    }

    public void setTrafficEnabled(final boolean z) throws RemoteException {
        if (!this.O000oooO || this.O00O0Oo) {
            this.O00O0Oo0.O00000o0 = z;
            this.O00O0Oo0.O00000Oo = true;
            this.O00O0Oo0.O0000O0o = 1;
            return;
        }
        queueEvent(new Runnable(z) {
            final /* synthetic */ boolean O000000o;

            public void run() {
                try {
                    if (O00o000.this.O00000o0.isTrafficEnabled() != this.O000000o) {
                        O00o000.this.O00000o0.setTrafficEnabled(z);
                        O00o000.this.O000oo0.setTrafficMode(this.O000000o);
                        boolean z = this.O000000o;
                        O00o000.this.O0000O0o.setTrafficEnable(1, this.O000000o);
                        O00o000.this.resetRenderTime();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void setVisibilityEx(int i) {
        if (this.O000OOoo != null) {
            try {
                this.O000OOoo.setVisibility(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setZOrderOnTop(boolean z) throws RemoteException {
    }

    public void setZoomScaleParam(float f) {
        this.O000ooO0 = f;
    }

    public void stopAnimation() throws RemoteException {
        if (this.O0000O0o != null) {
            this.O0000O0o.interruptAnimation();
        }
        resetRenderTime();
    }
}
