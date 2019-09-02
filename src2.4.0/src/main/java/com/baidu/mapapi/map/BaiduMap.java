package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo.SwitchFloorError;
import com.baidu.mapapi.map.MapStatus.Builder;
import com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.aa;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.mapsdkplatform.comapi.map.h;
import com.baidu.mapsdkplatform.comapi.map.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    private static final String e = "BaiduMap";
    public static int mapStatusReason;
    private OnMapDrawFrameCallback A;
    private OnBaseIndoorMapListener B;
    private OnSynchronizationListener C;
    private TileOverlay D;
    private HeatMap E;
    private Lock F = new ReentrantLock();
    private Lock G = new ReentrantLock();
    private InfoWindow H;
    private Marker I;
    private View J;
    private Marker K;
    private MyLocationData L;
    private MyLocationConfiguration M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private Point R;
    MapView a;
    TextureMapView b;
    WearMapView c;
    aa d;
    private Projection f;
    private UiSettings g;
    private j h;
    private e i;
    private ac j;
    private List<Overlay> k;
    private List<Marker> l;
    private List<Marker> m;
    private a n;
    private OnMapStatusChangeListener o;
    private OnMapTouchListener p;
    private OnMapClickListener q;
    private OnMapLoadedCallback r;
    private OnMapRenderCallback s;
    private OnMapDoubleClickListener t;
    private OnMapLongClickListener u;
    private CopyOnWriteArrayList<OnMarkerClickListener> v = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<OnPolylineClickListener> w = new CopyOnWriteArrayList();
    private OnMarkerDragListener x;
    private OnMyLocationClickListener y;
    private SnapshotReadyCallback z;

    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        boolean onMapPoiClick(MapPoi mapPoi);
    }

    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i);
    }

    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    BaiduMap(ac acVar) {
        this.j = acVar;
        this.i = this.j.b();
        this.d = aa.TextureView;
        c();
    }

    BaiduMap(j jVar) {
        this.h = jVar;
        this.i = this.h.a();
        this.d = aa.GLSurfaceView;
        c();
    }

    private Point a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",");
        int length = split.length;
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length) {
            String[] split2 = split[i].replaceAll("\"", "").split(":");
            if ("x".equals(split2[0])) {
                i2 = Integer.valueOf(split2[1]).intValue();
            }
            if ("y".equals(split2[0])) {
                i3 = Integer.valueOf(split2[1]).intValue();
            }
            i++;
        }
        return new Point(i2, i3);
    }

    private ab a(MapStatusUpdate mapStatusUpdate) {
        if (this.i == null) {
            return null;
        }
        ab E = this.i.E();
        MapStatus a = mapStatusUpdate.a(this.i, getMapStatus());
        return a == null ? null : a.b(E);
    }

    private final void a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) {
        if (myLocationData != null && myLocationConfiguration != null && isMyLocationEnabled()) {
            Bundle bundle;
            Builder zoom;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            LatLng latLng = new LatLng(myLocationData.latitude, myLocationData.longitude);
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            int i = 0;
            try {
                jSONObject.put("type", 0);
                jSONObject2.put("ptx", ll2mc.getLongitudeE6());
                jSONObject2.put("pty", ll2mc.getLatitudeE6());
                jSONObject2.put("radius", (double) ((float) CoordUtil.getMCDistanceByOneLatLngAndRadius(latLng, (int) myLocationData.accuracy)));
                float f = myLocationData.direction;
                if (myLocationConfiguration.enableDirection) {
                    f = myLocationData.direction % 360.0f;
                    if (f > 180.0f) {
                        f -= 360.0f;
                    } else if (f < -180.0f) {
                        f += 360.0f;
                    }
                } else {
                    f = -1001.0f;
                }
                jSONObject2.put("direction", (double) f);
                jSONObject2.put("iconarrownor", "NormalLocArrow");
                jSONObject2.put("iconarrownorid", 28);
                jSONObject2.put("iconarrowfoc", "FocusLocArrow");
                jSONObject2.put("iconarrowfocid", 29);
                jSONObject2.put("lineid", myLocationConfiguration.accuracyCircleStrokeColor);
                jSONObject2.put("areaid", myLocationConfiguration.accuracyCircleFillColor);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
                if (myLocationConfiguration.locationMode == LocationMode.COMPASS) {
                    jSONObject3.put("ptx", ll2mc.getLongitudeE6());
                    jSONObject3.put("pty", ll2mc.getLatitudeE6());
                    jSONObject3.put("radius", 0);
                    jSONObject3.put("direction", 0);
                    jSONObject3.put("iconarrownor", "direction_wheel");
                    jSONObject3.put("iconarrownorid", 54);
                    jSONObject3.put("iconarrowfoc", "direction_wheel");
                    jSONObject3.put("iconarrowfocid", 54);
                    jSONArray.put(jSONObject3);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (myLocationConfiguration.customMarker == null) {
                bundle = null;
            } else {
                ArrayList<BitmapDescriptor> arrayList = new ArrayList();
                arrayList.add(myLocationConfiguration.customMarker);
                Bundle bundle2 = new Bundle();
                ArrayList arrayList2 = new ArrayList();
                for (BitmapDescriptor bitmapDescriptor : arrayList) {
                    ParcelItem parcelItem = new ParcelItem();
                    Bundle bundle3 = new Bundle();
                    Bitmap bitmap = bitmapDescriptor.a;
                    ByteBuffer allocate = ByteBuffer.allocate((bitmap.getWidth() * bitmap.getHeight()) * 4);
                    bitmap.copyPixelsToBuffer(allocate);
                    bundle3.putByteArray("imgdata", allocate.array());
                    bundle3.putInt("imgindex", bitmapDescriptor.hashCode());
                    bundle3.putInt("imgH", bitmap.getHeight());
                    bundle3.putInt("imgW", bitmap.getWidth());
                    parcelItem.setBundle(bundle3);
                    arrayList2.add(parcelItem);
                }
                if (arrayList2.size() > 0) {
                    ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
                    while (i < arrayList2.size()) {
                        parcelItemArr[i] = (ParcelItem) arrayList2.get(i);
                        i++;
                    }
                    bundle2.putParcelableArray("icondata", parcelItemArr);
                }
                bundle = bundle2;
            }
            if (this.i != null) {
                this.i.a(jSONObject.toString(), bundle);
            }
            switch (e.a[myLocationConfiguration.locationMode.ordinal()]) {
                case 1:
                    zoom = new Builder().rotate(myLocationData.direction).overlook(-45.0f).target(new LatLng(myLocationData.latitude, myLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom);
                    break;
                case 2:
                    zoom = new Builder().target(new LatLng(myLocationData.latitude, myLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen);
                    break;
                case 3:
                    break;
                default:
                    return;
            }
            animateMapStatus(MapStatusUpdateFactory.newMapStatus(zoom.build()));
        }
    }

    private void c() {
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.R = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (40.0f * SysOSUtil.getDensity()));
        this.g = new UiSettings(this.i);
        this.n = new a(this);
        this.i.a(new b(this));
        this.i.a(new c(this));
        this.i.a(new d(this));
        this.N = this.i.C();
        this.O = this.i.D();
    }

    /* Access modifiers changed, original: 0000 */
    public void a() {
        if (this.i != null) {
            this.i.t();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(HeatMap heatMap) {
        this.F.lock();
        try {
            if (!(this.E == null || this.i == null || heatMap != this.E)) {
                this.E.b();
                this.E.c();
                this.E.a = null;
                this.i.o();
                this.E = null;
                this.i.n(false);
            }
            this.F.unlock();
        } catch (Throwable th) {
            this.F.unlock();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(TileOverlay tileOverlay) {
        this.G.lock();
        if (tileOverlay != null) {
            try {
                if (this.D == tileOverlay) {
                    tileOverlay.b();
                    tileOverlay.a = null;
                    if (this.i != null) {
                        this.i.e(false);
                    }
                }
            } catch (Throwable th) {
                this.D = null;
                this.G.unlock();
            }
        }
        this.D = null;
        this.G.unlock();
    }

    public void addHeatMap(HeatMap heatMap) {
        if (heatMap != null) {
            this.F.lock();
            try {
                if (heatMap != this.E) {
                    if (this.E != null) {
                        this.E.b();
                        this.E.c();
                        this.E.a = null;
                        this.i.o();
                    }
                    this.E = heatMap;
                    this.E.a = this;
                    this.i.n(true);
                    this.F.unlock();
                }
            } finally {
                this.F.unlock();
            }
        }
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        if (overlayOptions == null) {
            return null;
        }
        Overlay a = overlayOptions.a();
        a.listener = this.n;
        if (a instanceof Marker) {
            Marker marker = (Marker) a;
            if (!(marker.o == null || marker.o.size() == 0)) {
                this.l.add(marker);
                if (this.i != null) {
                    this.i.b(true);
                }
            }
            this.m.add(marker);
        }
        Bundle bundle = new Bundle();
        a.a(bundle);
        if (this.i != null) {
            this.i.b(bundle);
        }
        this.k.add(a);
        return a;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Bundle[] bundleArr = new Bundle[list.size()];
        int i = 0;
        for (OverlayOptions overlayOptions : list) {
            if (overlayOptions != null) {
                Bundle bundle = new Bundle();
                Overlay a = overlayOptions.a();
                a.listener = this.n;
                if (a instanceof Marker) {
                    Marker marker = (Marker) a;
                    if (!(marker.o == null || marker.o.size() == 0)) {
                        this.l.add(marker);
                        if (this.i != null) {
                            this.i.b(true);
                        }
                    }
                    this.m.add(marker);
                }
                this.k.add(a);
                arrayList.add(a);
                a.a(bundle);
                bundleArr[i] = bundle;
                i++;
            }
        }
        i = bundleArr.length / SecExceptionCode.SEC_ERROR_DYN_ENC;
        for (int i2 = 0; i2 < i + 1; i2++) {
            List arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < SecExceptionCode.SEC_ERROR_DYN_ENC; i3++) {
                int i4 = (i2 * SecExceptionCode.SEC_ERROR_DYN_ENC) + i3;
                if (i4 >= bundleArr.length) {
                    break;
                }
                if (bundleArr[i4] != null) {
                    arrayList2.add(bundleArr[i4]);
                }
            }
            if (this.i != null) {
                this.i.a(arrayList2);
            }
        }
        return arrayList;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return null;
        }
        if (this.D != null) {
            this.D.b();
            this.D.a = null;
        }
        if (this.i == null || !this.i.a(tileOverlayOptions.a())) {
            return null;
        }
        TileOverlay a = tileOverlayOptions.a(this);
        this.D = a;
        return a;
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, SecExceptionCode.SEC_ERROR_STA_ENC);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i) {
        if (mapStatusUpdate != null && i > 0) {
            ab a = a(mapStatusUpdate);
            if (this.i != null) {
                mapStatusReason |= 256;
                if (this.Q) {
                    this.i.a(a, i);
                } else {
                    this.i.a(a);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean b() {
        return this.i == null ? false : this.i.e();
    }

    public void changeLocationLayerOrder(boolean z) {
        this.i.c(z);
    }

    public final void clear() {
        this.k.clear();
        this.l.clear();
        this.m.clear();
        if (this.i != null) {
            this.i.b(false);
            this.i.n();
        }
        hideInfoWindow();
    }

    public final Point getCompassPosition() {
        return this.i != null ? a(this.i.h()) : null;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        return this.i.p();
    }

    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.M;
    }

    public final MyLocationData getLocationData() {
        return this.L;
    }

    public final MapStatus getMapStatus() {
        return this.i == null ? null : MapStatus.a(this.i.E());
    }

    public final LatLngBounds getMapStatusLimit() {
        return this.i == null ? null : this.i.F();
    }

    public final int getMapType() {
        int i = 1;
        if (this.i == null) {
            return 1;
        }
        if (!this.i.l()) {
            return 3;
        }
        if (this.i.k()) {
            i = 2;
        }
        return i;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        if (getMapStatus() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.m.size() == 0) {
            return null;
        }
        for (Marker marker : this.m) {
            if (latLngBounds.contains(marker.getPosition())) {
                arrayList.add(marker);
            }
        }
        return arrayList;
    }

    public final float getMaxZoomLevel() {
        return this.i == null ? 0.0f : this.i.a;
    }

    public final float getMinZoomLevel() {
        return this.i == null ? 0.0f : this.i.b;
    }

    public final Projection getProjection() {
        return this.f;
    }

    public float[] getProjectionMatrix() {
        return this.i == null ? null : this.i.N();
    }

    public final UiSettings getUiSettings() {
        return this.g;
    }

    public float[] getViewMatrix() {
        return this.i == null ? null : this.i.O();
    }

    public float getZoomToBound(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.i == null ? 0.0f : this.i.a(i, i2, i3, i4, i5, i6);
    }

    public j getmGLMapView() {
        return this.h;
    }

    public void hideInfoWindow() {
        if (this.H != null) {
            if (this.H.b != null) {
                switch (e.b[this.d.ordinal()]) {
                    case 1:
                        if (this.b != null) {
                            this.b.removeView(this.J);
                            break;
                        }
                        break;
                    case 2:
                        if (this.h != null) {
                            this.a.removeView(this.J);
                            break;
                        }
                        break;
                }
                this.J = null;
            }
            this.H = null;
            this.I.remove();
            this.I = null;
        }
    }

    public void hideSDKLayer() {
        this.i.c();
    }

    public final boolean isBaiduHeatMapEnabled() {
        return this.i == null ? false : this.i.i();
    }

    public boolean isBaseIndoorMapMode() {
        return this.i.q();
    }

    public final boolean isBuildingsEnabled() {
        return this.i == null ? false : this.i.m();
    }

    public final boolean isMyLocationEnabled() {
        return this.i == null ? false : this.i.s();
    }

    public final boolean isSupportBaiduHeatMap() {
        return this.i == null ? false : this.i.j();
    }

    public final boolean isTrafficEnabled() {
        return this.i == null ? false : this.i.g();
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.v.contains(onMarkerClickListener)) {
            this.v.remove(onMarkerClickListener);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        if (this.i != null) {
            this.i.g(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        if (this.i != null) {
            this.i.i(z);
        }
    }

    public void setCompassEnable(boolean z) {
        this.i.d(z);
    }

    public void setCompassIcon(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("compass's icon can not be null");
        }
        this.i.a(bitmap);
    }

    public void setCompassPosition(Point point) {
        if (this.i.a(point)) {
            this.R = point;
        }
    }

    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        String str5 = "^#[0-9a-fA-F]{8}$";
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                this.i.a((long) Color.parseColor("#ffffffff"), (long) Color.parseColor("#ffffffff"), (long) Color.parseColor("#ffffffff"), (long) Color.parseColor("#ffffffff"), false);
            }
        } else if (str.matches(str5) && str2.matches(str5) && str3.matches(str5) && str4.matches(str5)) {
            this.i.a((long) Color.parseColor(str), (long) Color.parseColor(str2), (long) Color.parseColor(str3), (long) Color.parseColor(str4), true);
        } else {
            Log.e(e, "the string of the input customTrafficColor is error");
            return false;
        }
        return true;
    }

    public final void setIndoorEnable(boolean z) {
        if (this.i != null) {
            this.P = z;
            this.i.k(z);
        }
        if (this.B != null && !z) {
            this.B.onBaseIndoorMapMode(false, null);
        }
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        if (mapStatusUpdate != null) {
            ab a = a(mapStatusUpdate);
            if (this.i != null) {
                this.i.a(a);
                if (this.o != null) {
                    this.o.onMapStatusChange(getMapStatus());
                }
            }
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        if (this.i != null) {
            this.i.a(latLngBounds);
            setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
        }
    }

    public final void setMapType(int i) {
        if (this.i != null) {
            e eVar;
            boolean z = false;
            switch (i) {
                case 1:
                    this.i.a(false);
                    this.i.t(this.N);
                    this.i.u(this.O);
                    this.i.f(true);
                    eVar = this.i;
                    z = this.P;
                    break;
                case 2:
                    this.i.a(true);
                    this.i.t(this.N);
                    this.i.u(this.O);
                    this.i.f(true);
                    break;
                case 3:
                    if (this.i.C()) {
                        this.i.t(false);
                    }
                    if (this.i.D()) {
                        this.i.u(false);
                    }
                    this.i.f(false);
                    eVar = this.i;
                    break;
            }
            eVar.k(z);
            if (this.h != null) {
                this.h.a(i);
            }
        }
    }

    public final void setMaxAndMinZoomLevel(float f, float f2) {
        if (f <= 21.0f && f2 >= 4.0f && f >= f2 && this.i != null) {
            this.i.a(f, f2);
        }
    }

    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        this.M = myLocationConfiguration;
        a(this.L, this.M);
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        this.L = myLocationData;
        if (this.M == null) {
            this.M = new MyLocationConfiguration(LocationMode.NORMAL, false, null);
        }
        a(myLocationData, this.M);
    }

    public final void setMyLocationEnabled(boolean z) {
        if (this.i != null) {
            this.i.m(z);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        this.B = onBaseIndoorMapListener;
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.q = onMapClickListener;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        this.t = onMapDoubleClickListener;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        this.A = onMapDrawFrameCallback;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        this.r = onMapLoadedCallback;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.u = onMapLongClickListener;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        this.s = onMapRenderCallback;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        this.o = onMapStatusChangeListener;
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        this.p = onMapTouchListener;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener != null && !this.v.contains(onMarkerClickListener)) {
            this.v.add(onMarkerClickListener);
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        this.x = onMarkerDragListener;
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        this.y = onMyLocationClickListener;
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener != null) {
            this.w.add(onPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        this.C = onSynchronizationListener;
    }

    @Deprecated
    public final void setPadding(int i, int i2, int i3, int i4) {
        if (i >= 0 && i2 >= 0 && i3 >= 0 && i4 >= 0 && this.i != null) {
            this.i.E();
            float width;
            float height;
            MapStatusUpdate newMapStatus;
            switch (e.b[this.d.ordinal()]) {
                case 1:
                    if (this.b != null) {
                        width = ((float) ((this.b.getWidth() - i) - i3)) / ((float) this.b.getWidth());
                        height = ((float) ((this.b.getHeight() - i2) - i4)) / ((float) this.b.getHeight());
                        newMapStatus = MapStatusUpdateFactory.newMapStatus(new Builder().targetScreen(new Point(((this.b.getWidth() + i) - i3) / 2, ((this.b.getHeight() + i2) - i4) / 2)).build());
                        this.i.a(new Point((int) (((float) i) + (((float) this.R.x) * width)), (int) (((float) i2) + (((float) this.R.y) * height))));
                        setMapStatus(newMapStatus);
                        this.b.setPadding(i, i2, i3, i4);
                        this.b.invalidate();
                        break;
                    }
                    return;
                case 2:
                    if (this.a != null) {
                        width = ((float) ((this.a.getWidth() - i) - i3)) / ((float) this.a.getWidth());
                        height = ((float) ((this.a.getHeight() - i2) - i4)) / ((float) this.a.getHeight());
                        newMapStatus = MapStatusUpdateFactory.newMapStatus(new Builder().targetScreen(new Point(((this.a.getWidth() + i) - i3) / 2, ((this.a.getHeight() + i2) - i4) / 2)).build());
                        this.i.a(new Point((int) (((float) i) + (((float) this.R.x) * width)), (int) (((float) i2) + (((float) this.R.y) * height))));
                        setMapStatus(newMapStatus);
                        this.a.setPadding(i, i2, i3, i4);
                        this.a.invalidate();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setPixelFormatTransparent(boolean z) {
        if (this.h != null) {
            if (z) {
                this.h.d();
            } else {
                this.h.e();
            }
        }
    }

    public final void setTrafficEnabled(boolean z) {
        if (this.i != null) {
            this.i.h(z);
        }
    }

    public final void setViewPadding(int i, int i2, int i3, int i4) {
        if (i >= 0 && i2 >= 0 && i3 >= 0 && i4 >= 0 && this.i != null) {
            switch (e.b[this.d.ordinal()]) {
                case 1:
                    if (this.b != null) {
                        this.i.a(new Point((int) (((float) i) + (((float) this.R.x) * (((float) ((this.b.getWidth() - i) - i3)) / ((float) this.b.getWidth())))), (int) (((float) i2) + (((float) this.R.y) * (((float) ((this.b.getHeight() - i2) - i4)) / ((float) this.b.getHeight()))))));
                        this.b.setPadding(i, i2, i3, i4);
                        this.b.invalidate();
                        break;
                    }
                    return;
                case 2:
                    if (this.a != null) {
                        this.i.a(new Point((int) (((float) i) + (((float) this.R.x) * (((float) ((this.a.getWidth() - i) - i3)) / ((float) this.a.getWidth())))), (int) (((float) i2) + (((float) this.R.y) * (((float) ((this.a.getHeight() - i2) - i4)) / ((float) this.a.getHeight()))))));
                        this.a.setPadding(i, i2, i3, i4);
                        this.a.invalidate();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow != null) {
            BitmapDescriptor bitmapDescriptor;
            String str;
            hideInfoWindow();
            if (infoWindow.b != null) {
                this.J = infoWindow.b;
                this.J.destroyDrawingCache();
                MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(ELayoutMode.mapMode).position(infoWindow.c).yOffset(infoWindow.e).build();
                switch (e.b[this.d.ordinal()]) {
                    case 1:
                        if (this.b != null) {
                            this.b.addView(this.J, build);
                            break;
                        }
                        break;
                    case 2:
                        if (this.h != null) {
                            this.a.addView(this.J, build);
                            break;
                        }
                        break;
                }
            }
            this.H = infoWindow;
            if (infoWindow.b == null) {
                bitmapDescriptor = infoWindow.a;
            } else if (infoWindow.f) {
                if (infoWindow.g <= 0) {
                    infoWindow.g = SysOSUtil.getDensityDpi();
                }
                bitmapDescriptor = BitmapDescriptorFactory.fromViewWithDpi(infoWindow.b, infoWindow.g);
            } else {
                bitmapDescriptor = BitmapDescriptorFactory.fromView(infoWindow.b);
            }
            int i = 0;
            Overlay a = new MarkerOptions().perspective(false).icon(bitmapDescriptor).position(infoWindow.c).zIndex(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).yOffset(infoWindow.e).a();
            a.listener = this.n;
            a.type = h.popup;
            Bundle bundle = new Bundle();
            a.a(bundle);
            if (infoWindow.b != null) {
                str = "draw_with_view";
                i = 1;
            } else {
                str = "draw_with_view";
            }
            bundle.putInt(str, i);
            if (this.i != null) {
                this.i.b(bundle);
            }
            this.k.add(a);
            this.I = (Marker) a;
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        if (this.i != null) {
            this.i.u(z);
            this.O = z;
        }
    }

    public final void showMapPoi(boolean z) {
        if (this.i != null) {
            this.i.t(z);
            this.N = z;
        }
    }

    public void showSDKLayer() {
        this.i.d();
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        this.z = snapshotReadyCallback;
        switch (e.b[this.d.ordinal()]) {
            case 1:
                if (this.j != null) {
                    this.j.a("anything", null);
                    break;
                }
                break;
            case 2:
                if (this.h != null) {
                    this.h.a("anything", null);
                    return;
                }
                break;
            default:
                return;
        }
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        this.z = snapshotReadyCallback;
        switch (e.b[this.d.ordinal()]) {
            case 1:
                if (this.j != null) {
                    this.j.a("anything", rect);
                    break;
                }
                break;
            case 2:
                if (this.h != null) {
                    this.h.a("anything", rect);
                    return;
                }
                break;
            default:
                return;
        }
    }

    public SwitchFloorError switchBaseIndoorMapFloor(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return SwitchFloorError.FLOOR_INFO_ERROR;
        }
        MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = getFocusedBaseIndoorMapInfo();
        if (focusedBaseIndoorMapInfo == null) {
            return SwitchFloorError.SWITCH_ERROR;
        }
        if (!str2.equals(focusedBaseIndoorMapInfo.a)) {
            return SwitchFloorError.FOCUSED_ID_ERROR;
        }
        ArrayList floors = focusedBaseIndoorMapInfo.getFloors();
        return (floors == null || !floors.contains(str)) ? SwitchFloorError.FLOOR_OVERLFLOW : this.i.a(str, str2) ? SwitchFloorError.SWITCH_OK : SwitchFloorError.SWITCH_ERROR;
    }
}
