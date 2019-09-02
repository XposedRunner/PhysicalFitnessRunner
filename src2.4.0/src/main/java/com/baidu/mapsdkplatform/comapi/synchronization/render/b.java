package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnSynchronizationListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo.RouteSectionInfo;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class b extends Handler {
    private static final String a = "b";
    private static RoleOptions d = null;
    private static DisplayOptions e = null;
    private static Marker f = null;
    private static volatile SyncResponseResult g = null;
    private static int h = 1000;
    private static volatile int p;
    private static LatLng r;
    private boolean A = false;
    private Thread B = new Thread(new a(this, null), "Adjust visible span");
    private boolean C = true;
    private int D = 10;
    private int E = 10;
    private LatLngBounds F = null;
    private e G;
    private volatile long H = 10000;
    private boolean I = true;
    private volatile boolean J = false;
    private volatile long K = 0;
    private volatile int L = 0;
    private List<LatLng> M = new CopyOnWriteArrayList();
    private List<BitmapDescriptor> N = new CopyOnWriteArrayList();
    private Polyline O = null;
    private List<Integer> P = new CopyOnWriteArrayList();
    private volatile boolean Q = true;
    private int R = 5;
    private String S = null;
    private String T = null;
    private boolean U = true;
    private boolean V = false;
    private volatile int W = 0;
    private volatile boolean X = false;
    private double Y = 0.0d;
    private BaiduMap b;
    private d c;
    private Marker i = null;
    private Marker j = null;
    private Marker k = null;
    private Marker l = null;
    private Marker m = null;
    private Marker n = null;
    private List<LinkPointPolyLineInfo> o = new CopyOnWriteArrayList();
    private Thread q = new Thread(new b(this, null), "Car moving");
    private int s = 0;
    private double t = 0.0d;
    private int u = 5;
    private boolean v = false;
    private volatile boolean w = false;
    private Thread x = new Thread(new c(this, null), "Passenger marker");
    private boolean y = false;
    private boolean z = true;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(b bVar, c cVar) {
            this();
        }

        public void run() {
            while (!b.this.C) {
                if (b.g != null) {
                    if (b.g.a() != null) {
                        if (!b.this.X) {
                            b.this.ak();
                            b.this.I = false;
                            b.this.a(b.this.F);
                        }
                        b.this.X = false;
                        try {
                            b.this.K = System.currentTimeMillis();
                            if (b.this.H <= 0) {
                                b.this.H = 10000;
                            }
                            Thread.sleep(b.this.H);
                        } catch (InterruptedException unused) {
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Sleep InterruptedException");
                        }
                    }
                }
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(b bVar, c cVar) {
            this();
        }

        public void run() {
            while (!b.this.Q) {
                LatLng b = b.this.ac();
                if (b == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Driver position is null, return");
                    return;
                }
                LatLng a = b.this.a(b);
                if (a == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Driver position not bind to route");
                    b.this.W = b.this.W + 1;
                    if (!b.this.v || b.this.y) {
                        String h = b.a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Driver position not bind to route times = ");
                        stringBuilder.append(b.this.W);
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(h, stringBuilder.toString());
                        if (2 <= b.this.W) {
                            LatLng startPosition;
                            if (2 >= b.h) {
                                a = b.r;
                                startPosition = b.d.getStartPosition();
                            } else if (4 == b.h) {
                                a = b.r;
                                startPosition = b.d.getEndPosition();
                            } else {
                                b.this.W = 0;
                                return;
                            }
                            double a2 = com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(a, startPosition);
                            h = b.a;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Latest driver postion to end position distance = ");
                            stringBuilder.append(a2);
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(h, stringBuilder.toString());
                            if (300.0d >= a2) {
                                if (b.this.O != null) {
                                    b.this.O.remove();
                                }
                                b.this.Q = true;
                                b.this.af();
                            }
                            b.this.W = 0;
                        }
                        b.this.b(b);
                        b.this.ag();
                        b.this.c(b);
                        return;
                    }
                    return;
                } else if (b.this.s != 0) {
                    b.this.t = b.this.ad();
                    if (b.this.t > 500.0d) {
                        b.this.b(a);
                        b.this.ag();
                        b.this.c(a);
                        b.this.e(b.p - 1);
                        b.this.L = b.p - 1;
                        return;
                    }
                    b.g.c().setPoint(null);
                    try {
                        b.this.ae();
                    } catch (Exception e) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(b.a, "Catch exception when car moving", e);
                    }
                    if (b.p >= b.this.o.size()) {
                        b.this.Q = true;
                        b.this.af();
                    }
                } else {
                    return;
                }
            }
        }
    }

    private class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(b bVar, c cVar) {
            this();
        }

        public void run() {
            BitmapDescriptor passengerIcon = b.e != null ? b.e.getPassengerIcon() : null;
            if (passengerIcon == null) {
                passengerIcon = new DisplayOptions().getPassengerIcon();
            }
            int passengerMarkerZIndex = b.e.getPassengerMarkerZIndex();
            while (!b.this.w) {
                MyLocationData locationData = b.this.b.getLocationData();
                if (locationData != null && b.this.a(locationData)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Get location data success");
                    LatLng latLng = new LatLng(locationData.latitude, locationData.longitude);
                    if (b.this.n == null) {
                        b.this.n = (Marker) b.this.b.addOverlay(new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).rotate(locationData.direction).icon(passengerIcon).zIndex(passengerMarkerZIndex));
                    } else {
                        b.this.n.setPosition(latLng);
                        b.this.n.setRotate(locationData.direction);
                    }
                }
                try {
                    Thread.sleep((long) (b.this.R * 1000));
                } catch (InterruptedException unused) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Sleep interrupt");
                }
            }
        }
    }

    private enum d {
        NO_NEED_RENDER,
        RENDER_NEW_LINE,
        UPDATE_TRAFFIC
    }

    private class e implements OnSynchronizationListener {
        private int b = 1;
        private int c = 2;
        private int d = 3;

        e() {
        }

        public void onMapStatusChangeReason(int i) {
            if (this.b == i || this.c == i) {
                long currentTimeMillis = System.currentTimeMillis() - b.this.K;
                if (currentTimeMillis <= 0) {
                    b.this.H = (long) (b.this.D * 1000);
                } else {
                    b.this.H = ((long) (b.this.D * 1000)) - (b.this.H - currentTimeMillis);
                }
                b.this.J = true;
            } else if (this.d == i) {
                b.this.H = (long) (b.this.E * 1000);
            } else {
                String h = b.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Undefined reason type: ");
                stringBuilder.append(i);
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(h, stringBuilder.toString());
            }
        }
    }

    b(Looper looper) {
        super(looper);
    }

    private void A() {
        if (this.k != null) {
            this.k.remove();
            this.k = null;
        }
        if (this.l != null) {
            this.l.remove();
            this.l = null;
        }
    }

    private void B() {
        if (this.i != null) {
            this.i.remove();
            this.i = null;
        }
        if (this.j != null) {
            this.j.remove();
            this.j = null;
        }
    }

    private void C() {
        if (this.n != null) {
            this.n.remove();
            this.n = null;
        }
    }

    private void D() {
        if (this.m != null) {
            this.m.remove();
            this.m = null;
        }
        if (f != null) {
            f.remove();
            f = null;
        }
    }

    private void E() {
        if (this.v && !this.A) {
            if (this.O != null) {
                this.O.remove();
                this.o.clear();
                this.M.clear();
                this.N.clear();
                this.P.clear();
                g = null;
            }
            this.S = null;
            this.T = null;
        }
    }

    private void F() {
        if (this.j != null) {
            this.j.remove();
            this.j = null;
        }
    }

    private void G() {
        if (f != null) {
            f.remove();
            f = null;
        }
    }

    private void H() {
        if (this.v && !this.y) {
            this.Q = true;
        }
    }

    private void I() {
        if (!e.isShowStartPositionMarker()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set start position marker not show");
            if (this.i != null) {
                this.i.remove();
                this.i = null;
            }
        } else if (this.i == null || this.v) {
            LatLng J = J();
            if (J == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No startPosition");
                return;
            }
            BitmapDescriptor startPositionIcon = e.getStartPositionIcon();
            if (startPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No startPositionIcon, use default");
                startPositionIcon = new DisplayOptions().getStartPositionIcon();
            }
            if (startPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There is no startPositionIcon");
                return;
            }
            MarkerOptions perspective = new MarkerOptions().position(J).icon(startPositionIcon).zIndex(e.getStartPositionMarkerZIndex()).perspective(false);
            if (this.i == null) {
                this.i = (Marker) this.b.addOverlay(perspective);
                return;
            }
            this.i.setIcon(startPositionIcon);
            this.i.setPosition(J);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Start position marker already render ok");
        }
    }

    private LatLng J() {
        LatLng startPosition = d.getStartPosition();
        if (startPosition == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The start position is null");
            if (this.c != null) {
                this.c.a(100001, "Start position is null");
            }
        }
        return startPosition;
    }

    private void K() {
        if (e.isShowStartPositionInfoWindow()) {
            LatLng startPosition = d.getStartPosition();
            if (startPosition == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No startPosition");
                return;
            }
            View startPositionInfoWindowView = e.getStartPositionInfoWindowView();
            if (startPositionInfoWindowView == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Start position infoWindow view is null, cannot display");
                if (this.j != null) {
                    this.j.remove();
                    this.j = null;
                }
                return;
            }
            MarkerOptions perspective = new MarkerOptions().position(startPosition).icon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView)).zIndex(e.getStartPositionInfoWindowZIndex()).alpha(0.9f).perspective(false);
            if (this.j == null) {
                this.j = (Marker) this.b.addOverlay(perspective);
                return;
            }
            this.j.setPosition(startPosition);
            this.j.setIcon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView));
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set start position infoWindow not show");
        if (this.j != null) {
            this.j.remove();
            this.j = null;
        }
    }

    private void L() {
        if (e.isShowEndPositionMarker()) {
            String str;
            String str2;
            if (this.k == null || this.v) {
                LatLng endPosition = d.getEndPosition();
                if (endPosition == null) {
                    str = a;
                    str2 = "End position coord is null";
                } else {
                    BitmapDescriptor endPositionIcon = e.getEndPositionIcon();
                    if (endPositionIcon == null) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The end position icon is null");
                        endPositionIcon = new DisplayOptions().getEndPositionIcon();
                    }
                    if (endPositionIcon == null) {
                        str = a;
                        str2 = "There is no endPositionIcon";
                    } else {
                        MarkerOptions perspective = new MarkerOptions().position(endPosition).icon(endPositionIcon).zIndex(e.getEndPositionMarkerZIndex()).perspective(false);
                        if (this.k == null) {
                            this.k = (Marker) this.b.addOverlay(perspective);
                            return;
                        }
                        this.k.setIcon(endPositionIcon);
                        this.k.setPosition(endPosition);
                        return;
                    }
                }
            }
            str = a;
            str2 = "EndPositionMarker already render ok";
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set endPositionMarker not show");
        if (this.k != null) {
            this.k.remove();
            this.k = null;
        }
    }

    private void M() {
        if (e.isShowEndPositionInfoWindow()) {
            LatLng endPosition = d.getEndPosition();
            if (endPosition == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "End position coord is null when render end position infoWindow");
                return;
            }
            View endPositionInfoWindowView = e.getEndPositionInfoWindowView();
            if (endPositionInfoWindowView == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "End position infoWindow view is null, cannot display");
                if (this.l != null) {
                    this.l.remove();
                    this.l = null;
                }
                return;
            }
            MarkerOptions perspective = new MarkerOptions().position(endPosition).icon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView)).anchor(0.5f, 1.0f).zIndex(e.getEndPositionInfoWindowZIndex()).perspective(false);
            if (this.l == null) {
                this.l = (Marker) this.b.addOverlay(perspective);
                return;
            }
            this.l.setPosition(endPosition);
            this.l.setIcon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView));
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set end position infoWindow not show");
        if (this.l != null) {
            this.l.remove();
            this.l = null;
        }
    }

    /* JADX WARNING: Missing block: B:21:0x004b, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:23:0x004d, code skipped:
            return;
     */
    private synchronized void N() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.x;	 Catch:{ all -> 0x004e }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);
        return;
    L_0x0007:
        r0 = e;	 Catch:{ all -> 0x004e }
        if (r0 == 0) goto L_0x004c;
    L_0x000b:
        r0 = e;	 Catch:{ all -> 0x004e }
        r0 = r0.isShowPassengerIcon();	 Catch:{ all -> 0x004e }
        if (r0 != 0) goto L_0x0014;
    L_0x0013:
        goto L_0x004c;
    L_0x0014:
        r0 = 0;
        r3.w = r0;	 Catch:{ all -> 0x004e }
        r0 = java.lang.Thread.State.NEW;	 Catch:{ all -> 0x004e }
        r1 = r3.x;	 Catch:{ all -> 0x004e }
        r1 = r1.getState();	 Catch:{ all -> 0x004e }
        if (r0 != r1) goto L_0x0026;
    L_0x0021:
        r0 = r3.x;	 Catch:{ all -> 0x004e }
        r0.start();	 Catch:{ all -> 0x004e }
    L_0x0026:
        r0 = r3.v;	 Catch:{ all -> 0x004e }
        if (r0 == 0) goto L_0x004a;
    L_0x002a:
        r0 = java.lang.Thread.State.TERMINATED;	 Catch:{ all -> 0x004e }
        r1 = r3.x;	 Catch:{ all -> 0x004e }
        r1 = r1.getState();	 Catch:{ all -> 0x004e }
        if (r0 != r1) goto L_0x004a;
    L_0x0034:
        r0 = 0;
        r3.x = r0;	 Catch:{ all -> 0x004e }
        r1 = new java.lang.Thread;	 Catch:{ all -> 0x004e }
        r2 = new com.baidu.mapsdkplatform.comapi.synchronization.render.b$c;	 Catch:{ all -> 0x004e }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x004e }
        r0 = "Passenger marker";
        r1.<init>(r2, r0);	 Catch:{ all -> 0x004e }
        r3.x = r1;	 Catch:{ all -> 0x004e }
        r0 = r3.x;	 Catch:{ all -> 0x004e }
        r0.start();	 Catch:{ all -> 0x004e }
    L_0x004a:
        monitor-exit(r3);
        return;
    L_0x004c:
        monitor-exit(r3);
        return;
    L_0x004e:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.render.b.N():void");
    }

    private void O() {
        if (e.isShowPassengerIcon()) {
            N();
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set not show passenger icon");
        if (this.n != null) {
            this.n.remove();
            this.n = null;
        }
    }

    private synchronized void P() {
        this.w = true;
    }

    private void Q() {
        if (!e.isShowCarMarker()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set carMarker not show");
            if (this.m != null) {
                this.m.remove();
                this.m = null;
            }
        } else if (this.m == null || this.v) {
            LatLng T = T();
            if (T == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The car(driver) position is null");
                return;
            }
            BitmapDescriptor carIcon = (!e.get3DCarMarkerEnable() || e.get3DCarMarkerIconList() == null || e.get3DCarMarkerIconList().isEmpty()) ? e.getCarIcon() : (BitmapDescriptor) e.get3DCarMarkerIconList().get(0);
            if (carIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The car icon is null, use default 2D car icon");
                carIcon = new DisplayOptions().getCarIcon();
            }
            if (carIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There is no car icon");
                return;
            }
            MarkerOptions perspective = new MarkerOptions().position(T).icon(carIcon).flat(false).rotate(0.0f).zIndex(e.getCarPositionMarkerZIndex()).anchor(0.5f, 0.5f).perspective(false);
            if (this.m == null) {
                this.m = (Marker) this.b.addOverlay(perspective);
                return;
            }
            this.m.setPosition(T);
            this.m.setIcon(carIcon);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "CarIcon already render ok");
        }
    }

    private void R() {
        if (e.isShowCarInfoWindow()) {
            View carInfoWindowView = e.getCarInfoWindowView();
            if (carInfoWindowView == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "car position infoWindow view is null, cannot display");
                if (f != null) {
                    f.remove();
                    f = null;
                }
                return;
            }
            LatLng S = S();
            if (S == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "CarPosition is null");
                return;
            }
            MarkerOptions alpha = new MarkerOptions().position(S).icon(BitmapDescriptorFactory.fromView(carInfoWindowView)).zIndex(e.getCarPositionInfoWindowZIndex()).anchor(0.5f, 1.0f).alpha(0.9f);
            if (f == null) {
                f = (Marker) this.b.addOverlay(alpha);
                return;
            }
            f.setPosition(S);
            f.setIcon(BitmapDescriptorFactory.fromView(carInfoWindowView));
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set carInfoWindow not show");
        if (f != null) {
            f.remove();
            f = null;
        }
    }

    private LatLng S() {
        return (this.m != null || g == null) ? this.m != null ? this.m.getPosition() : null : g.c().getPoint();
    }

    private LatLng T() {
        return r != null ? r : (g == null || g.c() == null || g.c().getPoint() == null) ? d.getDriverPosition() : g.c().getPoint();
    }

    private void U() {
        if (e != null) {
            if (!e.isShowRoutePlan()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set route line not show");
                if (this.O != null) {
                    this.O.remove();
                    this.O = null;
                }
            } else if (g == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No route line data");
            } else {
                d V = V();
                if (d.NO_NEED_RENDER == V) {
                    this.z = false;
                } else if (d.UPDATE_TRAFFIC == V) {
                    this.z = false;
                    W();
                } else {
                    this.z = true;
                    if (!this.Q) {
                        this.Q = true;
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Exception caught when renderRouteLine", e);
                        }
                    }
                    p = 0;
                    this.s = 0;
                    this.L = 0;
                    this.o.clear();
                    this.M.clear();
                    this.N.clear();
                    this.P.clear();
                    if (this.O != null) {
                        this.O.remove();
                        this.O = null;
                    }
                    X();
                    if (this.o == null || this.o.isEmpty()) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "LinkPointPolyline info is null");
                    } else {
                        Y();
                    }
                }
            }
        }
    }

    private d V() {
        String a = g.a().a();
        String a2 = g.b().a();
        if (this.v && !this.A) {
            this.S = null;
            this.T = null;
        }
        if (a != null && (TextUtils.isEmpty(this.S) || !this.S.equals(a) || this.O == null)) {
            this.S = a;
            this.T = a2;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route line or order state changed or no render, need render");
            return d.RENDER_NEW_LINE;
        } else if (a2 == null || this.O == null || (!TextUtils.isEmpty(this.T) && this.T.equals(a2))) {
            return d.NO_NEED_RENDER;
        } else {
            this.T = a2;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route line only need update traffic");
            return d.UPDATE_TRAFFIC;
        }
    }

    private void W() {
        ArrayList b = g.b().b();
        if (b == null || b.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Traffic status data is null");
            return;
        }
        if (!this.Q) {
            this.Q = true;
        }
        if (p - this.s >= 0) {
            try {
                int i;
                if (b.size() == this.o.size()) {
                    for (i = p - this.s; i < this.o.size(); i++) {
                        this.P.set(i, b.get(i));
                    }
                } else {
                    for (i = p - this.s; i < this.o.size(); i++) {
                        this.P.set(i, b.get((b.size() + i) - this.o.size()));
                    }
                }
                int[] iArr = new int[((this.P.size() - p) + this.s)];
                for (i = 0; i < (this.P.size() - p) + this.s; i++) {
                    iArr[i] = ((Integer) this.P.get((p + i) - this.s)).intValue();
                }
                if (iArr.length > 0) {
                    this.O.setIndexs(iArr);
                    if (this.Q) {
                        this.Q = false;
                    }
                }
            } catch (Exception e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Exception caught when updateTrafficStatus", e);
            }
        }
    }

    private void X() {
        if (g == null || g.a() == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route info or syncResponseResult is null");
            return;
        }
        List b = g.a().b();
        ArrayList b2 = g.b().b();
        if (b == null || b.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "route section info is null");
        } else if (b.isEmpty() || b2 == null || b2.isEmpty() || b2.size() == b.size()) {
            for (int i = 0; i < b.size(); i++) {
                if (b.get(i) != null) {
                    LatLng a = ((RouteSectionInfo) b.get(i)).a();
                    LatLng b3 = ((RouteSectionInfo) b.get(i)).b();
                    int a2 = a(i, b2);
                    LinkPointPolyLineInfo linkPointPolyLineInfo = new LinkPointPolyLineInfo();
                    linkPointPolyLineInfo.a(a);
                    linkPointPolyLineInfo.b(b3);
                    linkPointPolyLineInfo.a(a2);
                    this.o.add(linkPointPolyLineInfo);
                    this.M.add(a);
                }
            }
            this.M.add(((RouteSectionInfo) b.get(b.size() - 1)).b());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "route section info or traffic status info is invalid");
        }
    }

    private void Y() {
        if (!this.Q) {
            this.Q = true;
        }
        LatLng latLng = null;
        LatLng point = (g == null || g.c() == null) ? null : g.c().getPoint();
        if (point != null) {
            latLng = a(point);
        }
        if (latLng != null) {
            this.s = 0;
            try {
                this.o = this.o.subList(p, this.o.size());
                this.M = this.M.subList(p, this.M.size());
            } catch (Exception e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Caught exception when renderRoutePolyLine", e);
            }
            b(latLng);
            ag();
            c(latLng);
            this.L = p;
        }
        p = 0;
        int size = this.M.size();
        if (size >= 3) {
            for (int i = 0; i < size - 1; i++) {
                if (this.M.get(i) != null) {
                    this.P.add(Integer.valueOf(((LinkPointPolyLineInfo) this.o.get(i)).c()));
                }
            }
            if (this.N.isEmpty()) {
                this.N.addAll(e.getTrafficTextureList());
            }
            PolylineOptions zIndex = new PolylineOptions().points(this.M).dottedLine(true).width((e == null ? new DisplayOptions() : e).getRouteLineWidth()).customTextureList(this.N).textureIndex(this.P).zIndex(e.getRouteLineZIndex());
            if (!e.isShowRoutePlan()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set route line not display");
                zIndex.visible(false);
            }
            this.O = (Polyline) this.b.addOverlay(zIndex);
            if (this.Q) {
                this.Q = false;
            }
        }
    }

    private void Z() {
        if (this.m == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "CarMarker is null");
        } else if (r != null || this.o == null || this.o.isEmpty()) {
            aa();
        } else {
            r = ((LinkPointPolyLineInfo) this.o.get(0)).a();
            b(r);
            c(r);
        }
    }

    private double a(double d) {
        if (this.u == 0) {
            this.u = 5;
        }
        return (Math.abs(d) * ((double) this.u)) / this.t;
    }

    private double a(double d, double d2) {
        return d2 == Double.MAX_VALUE ? d : Math.abs((d * d2) / Math.sqrt(1.0d + (d2 * d2)));
    }

    private double a(double d, LatLng latLng) {
        return latLng.latitude - (d * latLng.longitude);
    }

    private int a(int i, ArrayList<Integer> arrayList) {
        return (arrayList == null || arrayList.isEmpty() || i >= arrayList.size()) ? 0 : ((Integer) arrayList.get(i)).intValue();
    }

    private LatLng a(LatLng latLng) {
        if (3 == h) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "WAIT_PASSENGER State, no need calculate");
            return null;
        } else if (this.o == null || this.o.isEmpty()) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mLinkPolyLineInfos size = ");
            stringBuilder.append(this.o.size());
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, stringBuilder.toString());
            return null;
        } else {
            int i = p;
            while (i < this.o.size()) {
                LatLng a = ((LinkPointPolyLineInfo) this.o.get(i)).a();
                LatLng b = ((LinkPointPolyLineInfo) this.o.get(i)).b();
                if (!a(latLng, a)) {
                    if (a(latLng, b)) {
                        this.s = d(i + 1);
                        return b;
                    }
                    boolean a2 = a(a, b, latLng);
                    boolean b2 = b(a, b, latLng);
                    if (!a2 || !b2) {
                        i++;
                    }
                }
                this.s = d(i);
                return a;
            }
            return null;
        }
    }

    private void a(float f, LatLng latLng, LatLng latLng2) {
        DisplayOptions displayOptions;
        if (e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User not set DisplayOptions, use default 2D marker");
            displayOptions = new DisplayOptions();
        } else {
            List list = e.get3DCarMarkerIconList();
            if (list == null || list.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User not set 3D car marker list, use default 2D marker");
                displayOptions = new DisplayOptions();
            } else {
                double atan2 = 180.0d * (Math.atan2(latLng2.latitude - latLng.latitude, latLng2.longitude - latLng.longitude) / 3.141592653589793d);
                if (atan2 < 0.0d) {
                    atan2 += 360.0d;
                }
                if (atan2 != this.Y) {
                    this.Y = atan2;
                    int size = list.size();
                    int i = SpatialRelationUtil.A_CIRCLE_DEGREE / size;
                    int i2 = (int) (atan2 / ((double) i));
                    if (size == i2) {
                        i2 = 0;
                    }
                    BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) list.get(i2);
                    if (!(bitmapDescriptor == null || this.m == null)) {
                        this.m.setIcon(bitmapDescriptor);
                        this.m.setRotate(((float) (atan2 - ((double) (i2 * i)))) - 1.0f);
                    }
                    return;
                }
                return;
            }
        }
        this.m.setIcon(displayOptions.getCarIcon());
        this.m.setRotate(f);
    }

    private void a(Builder builder) {
        if (e == null || e.isShowStartPositionMarkerInSpan()) {
            builder.include(J());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show startPositionMarker in span");
        }
    }

    private synchronized void a(LatLngBounds latLngBounds) {
        if (!this.J || this.X) {
            MapStatus mapStatus = this.b.getMapStatus();
            if (mapStatus == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Get map status failed");
                return;
            }
            int paddingRight;
            int paddingBottom;
            int i;
            WinRound winRound = mapStatus.winRound;
            int abs = Math.abs(winRound.right - winRound.left);
            int abs2 = Math.abs(winRound.bottom - winRound.top);
            int i2 = 50;
            if (e != null) {
                i2 = e.getPaddingLeft();
                int paddingTop = e.getPaddingTop();
                paddingRight = e.getPaddingRight();
                paddingBottom = e.getPaddingBottom();
                i = paddingRight;
                paddingRight = paddingTop;
            } else {
                paddingRight = 50;
                i = paddingRight;
                paddingBottom = i;
            }
            this.b.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds, (abs - i2) - i, (abs2 - paddingRight) - paddingBottom));
            postDelayed(new c(this, latLngBounds, i2, paddingRight, i, paddingBottom), 300);
            return;
        }
        this.J = false;
    }

    private synchronized void a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (this.b.getMapStatus() == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Get map status failed");
            return;
        }
        this.b.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds, i, i2, i3, i4));
    }

    /* JADX WARNING: Missing block: B:25:0x0045, code skipped:
            return false;
     */
    private boolean a(com.baidu.mapapi.map.MyLocationData r8) {
        /*
        r7 = this;
        r0 = 0;
        r2 = r8.latitude;	 Catch:{ NumberFormatException -> 0x0017 }
        r2 = java.lang.Double.valueOf(r2);	 Catch:{ NumberFormatException -> 0x0017 }
        r2 = r2.longValue();	 Catch:{ NumberFormatException -> 0x0017 }
        r4 = r8.longitude;	 Catch:{ NumberFormatException -> 0x0018 }
        r8 = java.lang.Double.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0018 }
        r4 = r8.longValue();	 Catch:{ NumberFormatException -> 0x0018 }
        goto L_0x0020;
    L_0x0017:
        r2 = r0;
    L_0x0018:
        r8 = a;
        r4 = "Trans latitude and longitude failed";
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(r8, r4);
        r4 = r0;
    L_0x0020:
        r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r6 = 0;
        if (r8 != 0) goto L_0x002a;
    L_0x0025:
        r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r8 != 0) goto L_0x002a;
    L_0x0029:
        return r6;
    L_0x002a:
        r0 = -90;
        r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r8 < 0) goto L_0x0045;
    L_0x0030:
        r0 = 90;
        r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r8 > 0) goto L_0x0045;
    L_0x0036:
        r0 = -180; // 0xffffffffffffff4c float:NaN double:NaN;
        r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r8 < 0) goto L_0x0045;
    L_0x003c:
        r0 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r8 <= 0) goto L_0x0043;
    L_0x0042:
        return r6;
    L_0x0043:
        r8 = 1;
        return r8;
    L_0x0045:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.render.b.a(com.baidu.mapapi.map.MyLocationData):boolean");
    }

    private boolean a(LatLng latLng, LatLng latLng2) {
        boolean z = false;
        if (latLng == null || latLng2 == null) {
            if (latLng == null && latLng2 == null) {
                z = true;
            }
            return z;
        }
        if (Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-4d && Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-4d) {
            z = true;
        }
        return z;
    }

    private boolean a(LatLng latLng, LatLng latLng2, double d) {
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        double d2 = d;
        Object obj = latLng3.latitude > latLng4.latitude ? 1 : null;
        double a = a(d2, latLng3);
        double f = f(latLng, latLng2);
        f = obj != null ? a(f, d2) : a(f, d2) * -1.0d;
        double a2 = a(f);
        double d3 = latLng3.latitude;
        while (true) {
            if ((d3 > latLng4.latitude ? 1 : null) != obj) {
                return true;
            }
            if (this.Q) {
                return false;
            }
            Object obj2;
            LatLng latLng5;
            if (Double.MAX_VALUE == d2) {
                obj2 = obj;
                latLng5 = new LatLng(d3, latLng3.longitude);
            } else {
                obj2 = obj;
                latLng5 = new LatLng(d3, (d3 - a) / d2);
            }
            b(latLng5);
            c(latLng5);
            if (!b(a2)) {
                return false;
            }
            d3 -= f;
            obj = obj2;
        }
    }

    private boolean a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.latitude;
        double d2 = latLng.longitude;
        double d3 = latLng2.latitude;
        return Math.abs(((latLng3.latitude - d) * (latLng2.longitude - d2)) - ((d3 - d) * (latLng3.longitude - d2))) < 1.0E-4d;
    }

    /* JADX WARNING: Missing block: B:18:0x003c, code skipped:
            return;
     */
    private synchronized void aa() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.q;	 Catch:{ all -> 0x003d }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);
        return;
    L_0x0007:
        r0 = 0;
        r3.Q = r0;	 Catch:{ all -> 0x003d }
        r0 = java.lang.Thread.State.NEW;	 Catch:{ all -> 0x003d }
        r1 = r3.q;	 Catch:{ all -> 0x003d }
        r1 = r1.getState();	 Catch:{ all -> 0x003d }
        if (r0 != r1) goto L_0x001b;
    L_0x0014:
        r0 = r3.q;	 Catch:{ all -> 0x003d }
        r0.start();	 Catch:{ all -> 0x003d }
        monitor-exit(r3);
        return;
    L_0x001b:
        r0 = java.lang.Thread.State.TERMINATED;	 Catch:{ all -> 0x003d }
        r1 = r3.q;	 Catch:{ all -> 0x003d }
        r1 = r1.getState();	 Catch:{ all -> 0x003d }
        if (r0 != r1) goto L_0x003b;
    L_0x0025:
        r0 = 0;
        r3.q = r0;	 Catch:{ all -> 0x003d }
        r1 = new java.lang.Thread;	 Catch:{ all -> 0x003d }
        r2 = new com.baidu.mapsdkplatform.comapi.synchronization.render.b$b;	 Catch:{ all -> 0x003d }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x003d }
        r0 = "Car moving";
        r1.<init>(r2, r0);	 Catch:{ all -> 0x003d }
        r3.q = r1;	 Catch:{ all -> 0x003d }
        r0 = r3.q;	 Catch:{ all -> 0x003d }
        r0.start();	 Catch:{ all -> 0x003d }
    L_0x003b:
        monitor-exit(r3);
        return;
    L_0x003d:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.render.b.aa():void");
    }

    private synchronized void ab() {
        this.Q = true;
    }

    private LatLng ac() {
        return (g == null || g.c() == null || g.c().getPoint() == null || this.V) ? null : g.c().getPoint();
    }

    private double ad() {
        if (this.o == null || this.o.isEmpty() || p > this.o.size()) {
            return 1.0d;
        }
        double d = 0.0d;
        for (int i = p - this.s; i < p; i++) {
            d += f(((LinkPointPolyLineInfo) this.o.get(i)).a(), ((LinkPointPolyLineInfo) this.o.get(i)).b());
        }
        return d;
    }

    private void ae() {
        if (p != 0) {
            for (int i = p - this.s; i < p; i++) {
                LatLng a = ((LinkPointPolyLineInfo) this.o.get(i)).a();
                LatLng b = ((LinkPointPolyLineInfo) this.o.get(i)).b();
                double f = f(a, b) / 2.0d;
                double d = (b.latitude - a.latitude) / f;
                double d2 = (b.longitude - a.longitude) / f;
                double e = e(a, b);
                LatLng latLng = a;
                int i2 = 1;
                while (((double) i2) <= f) {
                    double d3 = latLng.longitude;
                    double d4 = f;
                    double d5 = latLng.latitude;
                    if (0.0d == e) {
                        d3 = latLng.longitude + d2;
                    } else {
                        if (Double.MAX_VALUE != e) {
                            d3 = latLng.longitude + d2;
                        }
                        d5 = latLng.latitude + d;
                    }
                    LatLng latLng2 = new LatLng(d5, d3);
                    if (this.M != null && !this.M.isEmpty()) {
                        if (this.z) {
                            this.Q = true;
                            return;
                        }
                        this.M.set(i, latLng2);
                    }
                    if (!(this.P == null || this.P.isEmpty())) {
                        this.P.set(i, Integer.valueOf(((LinkPointPolyLineInfo) this.o.get(i)).c()));
                    }
                    if (b(latLng, latLng2)) {
                        this.L = i;
                        e(i);
                        i2++;
                        latLng = latLng2;
                        f = d4;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void af() {
        p = 0;
        this.s = 0;
        this.o.clear();
        this.M.clear();
        this.P.clear();
    }

    private void ag() {
        if (this.m != null) {
            float f = 0.0f;
            try {
                f = Double.valueOf(360.0d - g.c().getAngle()).floatValue();
            } catch (NumberFormatException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get DriverPosition Angle failed", e);
            }
            this.m.setRotate(f);
        }
    }

    private synchronized void ah() {
        this.C = true;
    }

    /* JADX WARNING: Missing block: B:22:0x0058, code skipped:
            return;
     */
    private synchronized void ai() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.B;	 Catch:{ all -> 0x0059 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);
        return;
    L_0x0007:
        r0 = r3.C;	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x000e;
    L_0x000b:
        r0 = 0;
        r3.C = r0;	 Catch:{ all -> 0x0059 }
    L_0x000e:
        r0 = java.lang.Thread.State.NEW;	 Catch:{ all -> 0x0059 }
        r1 = r3.B;	 Catch:{ all -> 0x0059 }
        r1 = r1.getState();	 Catch:{ all -> 0x0059 }
        r2 = 1;
        if (r0 != r1) goto L_0x0020;
    L_0x0019:
        r3.I = r2;	 Catch:{ all -> 0x0059 }
        r0 = r3.B;	 Catch:{ all -> 0x0059 }
        r0.start();	 Catch:{ all -> 0x0059 }
    L_0x0020:
        r0 = r3.v;	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x0035;
    L_0x0024:
        r0 = java.lang.Thread.State.TIMED_WAITING;	 Catch:{ all -> 0x0059 }
        r1 = r3.B;	 Catch:{ all -> 0x0059 }
        r1 = r1.getState();	 Catch:{ all -> 0x0059 }
        if (r0 != r1) goto L_0x0035;
    L_0x002e:
        r0 = r3.B;	 Catch:{ all -> 0x0059 }
        r0.interrupt();	 Catch:{ all -> 0x0059 }
        r3.I = r2;	 Catch:{ all -> 0x0059 }
    L_0x0035:
        r0 = java.lang.Thread.State.TERMINATED;	 Catch:{ all -> 0x0059 }
        r1 = r3.B;	 Catch:{ all -> 0x0059 }
        r1 = r1.getState();	 Catch:{ all -> 0x0059 }
        if (r0 != r1) goto L_0x0057;
    L_0x003f:
        r0 = 0;
        r3.B = r0;	 Catch:{ all -> 0x0059 }
        r3.I = r2;	 Catch:{ all -> 0x0059 }
        r1 = new java.lang.Thread;	 Catch:{ all -> 0x0059 }
        r2 = new com.baidu.mapsdkplatform.comapi.synchronization.render.b$a;	 Catch:{ all -> 0x0059 }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x0059 }
        r0 = "Adjust visible span";
        r1.<init>(r2, r0);	 Catch:{ all -> 0x0059 }
        r3.B = r1;	 Catch:{ all -> 0x0059 }
        r0 = r3.B;	 Catch:{ all -> 0x0059 }
        r0.start();	 Catch:{ all -> 0x0059 }
    L_0x0057:
        monitor-exit(r3);
        return;
    L_0x0059:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.render.b.ai():void");
    }

    private void aj() {
        this.b.setOnSynchronizationListener(this.G);
    }

    private void ak() {
        switch (h) {
            case 0:
            case 5:
                ah();
                return;
            case 1:
                al();
                return;
            case 2:
                am();
                return;
            case 3:
                an();
                return;
            case 4:
                ao();
                return;
            default:
                return;
        }
    }

    private void al() {
        Builder builder = new Builder();
        a(builder);
        d(builder);
        c(builder);
        e(builder);
        this.F = h(builder);
    }

    private void am() {
        Builder builder = new Builder();
        a(builder);
        c(builder);
        d(builder);
        e(builder);
        this.F = h(builder);
    }

    private void an() {
        Builder builder = new Builder();
        a(builder);
        c(builder);
        d(builder);
        this.F = h(builder);
    }

    private void ao() {
        Builder builder = new Builder();
        b(builder);
        c(builder);
        e(builder);
        this.F = h(builder);
    }

    private double b(LatLng latLng, LatLng latLng2, double d) {
        if (Double.MAX_VALUE == d) {
            return latLng2.latitude > latLng.latitude ? 360.0d : 180.0d;
        } else {
            double d2 = 0.0d;
            if (0.0d == d) {
                return latLng2.longitude > latLng.longitude ? 270.0d : 90.0d;
            } else {
                if ((latLng2.latitude - latLng.latitude) * d < 0.0d) {
                    d2 = 180.0d;
                }
                return ((180.0d * (Math.atan(d) / 3.141592653589793d)) + d2) - 90.0d;
            }
        }
    }

    private void b(LatLng latLng) {
        if (this.m != null) {
            this.m.setPosition(latLng);
        }
    }

    private void b(Builder builder) {
        if (e == null || e.isShowEndPositionMarkerInSpan()) {
            builder.include(d.getEndPosition());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show endPositionMarker in span");
        }
    }

    private boolean b(double d) {
        try {
            Thread.sleep(Double.valueOf((d * 1000.0d) + 50.0d).longValue());
            return true;
        } catch (InterruptedException unused) {
            return false;
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Calc sleep interval failed", e);
            return false;
        }
    }

    private boolean b(LatLng latLng, LatLng latLng2) {
        if (this.Q) {
            return false;
        }
        b(latLng);
        c(latLng);
        double e = e(latLng, latLng2);
        float b = (float) b(latLng, latLng2, e);
        if (this.m != null) {
            if (e == null || !e.get3DCarMarkerEnable()) {
                this.m.setRotate(b);
            } else {
                a(b, latLng, latLng2);
            }
        }
        boolean c = 0.0d == e ? c(latLng, latLng2) : a(latLng, latLng2, e);
        if (c) {
            r = latLng2;
        }
        return c;
    }

    private boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        LatLng latLng4 = latLng;
        LatLng latLng5 = latLng2;
        LatLng latLng6 = latLng3;
        double d = latLng4.latitude;
        double d2 = latLng4.longitude;
        double d3 = latLng5.latitude;
        double d4 = latLng5.longitude;
        double d5 = latLng6.latitude;
        double d6 = latLng6.longitude;
        return Math.min(d, d3) - 1.0E-4d <= d5 && d5 <= Math.max(d, d3) + 1.0E-4d && Math.min(d2, d4) - 1.0E-4d <= d6 && d6 <= Math.max(d2, d4) + 1.0E-4d;
    }

    private void c(int i) {
        this.y = 1000 == h;
        boolean z = (1 == h && 2 == i) || (1 == i && 2 == h);
        this.A = z;
        if (h != i) {
            h = i;
            this.v = true;
            return;
        }
        this.v = false;
    }

    private void c(LatLng latLng) {
        if (f != null) {
            f.setPosition(latLng);
        }
    }

    private void c(Builder builder) {
        if (e == null || e.isShowCarMarkerInSpan()) {
            LatLng T = (this.m == null || this.I) ? T() : this.m.getPosition();
            builder.include(T);
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show carMarker in span");
    }

    private boolean c(LatLng latLng, LatLng latLng2) {
        double d = d(latLng, latLng2);
        double a = a(d);
        for (double d2 = latLng.longitude; d2 <= latLng2.longitude; d2 += d) {
            if (this.Q) {
                return false;
            }
            LatLng latLng3 = new LatLng(latLng.latitude, d2);
            b(latLng3);
            c(latLng3);
            if (!b(a)) {
                return false;
            }
        }
        return true;
    }

    private double d(LatLng latLng, LatLng latLng2) {
        return com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, latLng2);
    }

    private synchronized int d(int i) {
        int i2;
        i2 = i - p;
        p = i;
        return i2;
    }

    private void d(Builder builder) {
        String str;
        String str2;
        if (e == null || e.isShowPassengerIconInSpan()) {
            LatLng latLng;
            if (this.n == null) {
                MyLocationData locationData = this.b.getLocationData();
                if (locationData == null) {
                    str = a;
                    str2 = "No passenger location data";
                } else if (a(locationData)) {
                    latLng = new LatLng(locationData.latitude, locationData.longitude);
                } else {
                    return;
                }
            }
            latLng = this.n.getPosition();
            builder.include(latLng);
            return;
        }
        str = a;
        str2 = "User set not show passengerMarker in span";
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
    }

    private double e(LatLng latLng, LatLng latLng2) {
        return latLng2.longitude == latLng.longitude ? Double.MAX_VALUE : (latLng2.latitude - latLng.latitude) / (latLng2.longitude - latLng.longitude);
    }

    private void e(int i) {
        if (this.M == null || this.M.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route polyline points is null when remove");
        } else if (this.M.size() <= 2 || i >= this.M.size() - 2) {
            if (this.O != null) {
                this.O.remove();
            }
        } else if (this.P == null || this.P.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No need removeTravelledPolyLine");
        } else if (!this.z) {
            try {
                List subList = this.P.subList(i, this.P.size());
                int[] iArr = new int[subList.size()];
                for (int i2 = 0; i2 < subList.size(); i2++) {
                    iArr[i2] = ((Integer) subList.get(i2)).intValue();
                }
                if (this.O != null && !this.Q) {
                    this.O.setIndexs(iArr);
                    try {
                        this.O.setPoints(this.M.subList(i, this.M.size()));
                    } catch (Exception e) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get subList of PolyLinePointList failed", e);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void e(Builder builder) {
        if (e != null && !e.isShowRoutePlanInSpan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show routeLine in span");
        } else if (this.o == null || this.o.isEmpty()) {
            g(builder);
        } else {
            f(builder);
        }
    }

    private double f(LatLng latLng, LatLng latLng2) {
        return com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, latLng2);
    }

    private void f(Builder builder) {
        for (int i = this.L; i < this.o.size(); i++) {
            builder.include(((LinkPointPolyLineInfo) this.o.get(i)).a());
        }
        builder.include(((LinkPointPolyLineInfo) this.o.get(this.o.size() - 1)).b());
    }

    private void g(Builder builder) {
        if (g == null || g.a() == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There no routeLine info, no need show in span");
            return;
        }
        List b = g.a().b();
        if (b == null || b.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There no routeLine position, no need show in span");
            return;
        }
        for (int i = 0; i < b.size(); i++) {
            builder.include(((RouteSectionInfo) b.get(i)).a());
        }
        builder.include(((RouteSectionInfo) b.get(b.size() - 1)).b());
    }

    private LatLngBounds h(Builder builder) {
        return builder.build();
    }

    private void o() {
        if (e != null) {
            if (f != null) {
                f.remove();
                f = null;
            }
            if (this.m != null) {
                this.m.remove();
                this.m = null;
            }
            if (this.i != null) {
                this.i.remove();
                this.i = null;
            }
            if (this.j != null) {
                this.j.remove();
                this.j = null;
            }
            if (this.l != null) {
                this.l.remove();
                this.l = null;
            }
            e.getStartPositionIcon().recycle();
            e.getCarIcon().recycle();
            if (e.getEndPositionIcon() != null) {
                e.getEndPositionIcon().recycle();
            }
            e = null;
        }
    }

    private void p() {
        p = 0;
        this.u = 0;
        this.Q = true;
        if (this.q != null) {
            try {
                this.q.join();
            } catch (InterruptedException unused) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "InterruptedException when release CarMoveThread");
            }
            this.q = null;
        }
    }

    private void q() {
        this.w = true;
        if (this.x != null) {
            this.x = null;
        }
    }

    private void r() {
        this.C = true;
        if (this.B != null) {
            this.B = null;
        }
    }

    private void s() {
        d = null;
        g = null;
        h = 1000;
        int i = 0;
        this.Q = false;
        this.U = true;
        this.V = false;
        this.o.clear();
        p = 0;
        r = null;
        this.s = 0;
        this.t = 0.0d;
        this.M.clear();
        this.P.clear();
        if (this.O != null) {
            this.O.remove();
            this.O = null;
        }
        while (i < this.N.size()) {
            ((BitmapDescriptor) this.N.get(i)).recycle();
            i++;
        }
        this.N.clear();
    }

    private void t() {
        P();
        H();
        ah();
        E();
        A();
        B();
        C();
        D();
        if (this.b != null) {
            this.b.clear();
        }
    }

    private void u() {
        if (z()) {
            E();
            H();
            ai();
            I();
            K();
            L();
            M();
            O();
            Q();
            R();
            U();
            Z();
        }
    }

    private void v() {
        if (z()) {
            E();
            H();
            ai();
            I();
            K();
            L();
            M();
            O();
            Q();
            R();
            U();
            Z();
        }
    }

    private void w() {
        if (z()) {
            E();
            G();
            F();
            H();
            ai();
            I();
            K();
            L();
            M();
            O();
            Q();
            R();
            Z();
        }
    }

    private void x() {
        if (z()) {
            P();
            E();
            B();
            C();
            H();
            ai();
            I();
            K();
            L();
            M();
            Q();
            R();
            U();
            Z();
        }
    }

    private void y() {
        P();
        H();
        ah();
        A();
        B();
        C();
        D();
    }

    private boolean z() {
        if (d == null || e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No render data");
            if (this.c != null) {
                this.c.a(100001, "Get render data failed");
            }
            return false;
        } else if (this.b != null) {
            return true;
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "BaiduMap is null");
            if (this.c != null) {
                this.c.a(100002, "BaiduMap instance is null.");
            }
            return false;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Marker a() {
        return this.i;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i) {
        this.D = i;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i, int i2, int i3, int i4) {
        this.X = true;
        ak();
        a(this.F, i, i2, i3, i4);
    }

    public void a(BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.b = baiduMap;
        d = roleOptions;
        e = displayOptions;
        this.G = new e();
        aj();
        r = null;
        this.b.getUiSettings().setRotateGesturesEnabled(false);
        this.b.getUiSettings().setCompassEnabled(false);
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(RoleOptions roleOptions, DisplayOptions displayOptions, SyncResponseResult syncResponseResult, int i) {
        d = roleOptions;
        e = displayOptions;
        if (e == null) {
            e = new DisplayOptions();
        }
        g = syncResponseResult;
        this.u = i;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(d dVar) {
        this.c = dVar;
    }

    /* Access modifiers changed, original: 0000 */
    public Marker b() {
        return this.k;
    }

    /* Access modifiers changed, original: 0000 */
    public void b(int i) {
        this.E = i;
    }

    /* Access modifiers changed, original: 0000 */
    public Marker c() {
        return this.m;
    }

    public void d() {
        this.V = false;
        if (this.U) {
            this.U = false;
            return;
        }
        N();
        ai();
        aa();
    }

    public void e() {
        this.V = true;
        ab();
        P();
        ah();
    }

    public void f() {
        p();
        q();
        r();
        o();
        s();
    }

    /* Access modifiers changed, original: 0000 */
    public void g() {
        this.X = true;
        ak();
        a(this.F);
    }

    public void handleMessage(Message message) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The orderState in message is: ");
        stringBuilder.append(message.what);
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, stringBuilder.toString());
        c(message.what);
        switch (message.what) {
            case 0:
                t();
                return;
            case 1:
                u();
                return;
            case 2:
                v();
                return;
            case 3:
                w();
                return;
            case 4:
                x();
                return;
            case 5:
                y();
                return;
            default:
                str = a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Undefined Message type: ");
                stringBuilder.append(message.what);
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, stringBuilder.toString());
                return;
        }
    }
}
