package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData.HistoryTracePoint;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceDisplayOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.d.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class e extends Handler {
    private static final String a = "e";
    private static OnHistoryTraceListener b;
    private HistoryTraceDisplayOptions c;
    private BaiduMap d;
    private int e;
    private Marker f;
    private Marker g;
    private Marker h;
    private List<Polyline> i = new CopyOnWriteArrayList();

    e(Looper looper) {
        super(looper);
    }

    private void a(int i, String str) {
        if (b == null) {
            a.b(a, "OnHistoryTraceListener is null");
        } else {
            b.onRenderHistroyTrace(i, str);
        }
    }

    private void a(BitmapDescriptor bitmapDescriptor, int i, List<HistoryTracePoint> list) {
        List b = b((List) list);
        if (b == null || b.isEmpty()) {
            a.b(a, "Calculate sub section points error");
            return;
        }
        b();
        for (int i2 = 0; i2 < b.size(); i2++) {
            List list2 = (List) b.get(i2);
            if (!(list2 == null || list2.isEmpty())) {
                if (list2.size() < 2) {
                    String str = a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error points list, index = ");
                    stringBuilder.append(i2);
                    a.b(str, stringBuilder.toString());
                } else {
                    a((Polyline) this.d.addOverlay(new PolylineOptions().width(i).points(list2).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4)));
                }
            }
        }
    }

    private void a(Polyline polyline) {
        this.i.add(polyline);
    }

    private void a(LatLng latLng) {
        if (!this.c.isShowStartPositionIcon()) {
            a.b(a, "User set not render start point marker");
        } else if (latLng == null) {
            a.b(a, "Start point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_NULL, "History trace end point is null, can't render start point marker");
        } else {
            BitmapDescriptor startPositionIcon = this.c.getStartPositionIcon();
            if (startPositionIcon == null) {
                a.b(a, "There is no startPositionIcon");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                return;
            }
            this.f = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(startPositionIcon).zIndex(5));
        }
    }

    private void a(HistoryTraceData historyTraceData) {
        if (5 != this.e) {
            a.b(a, "Current order state not the complete state, render forbidden");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
        } else if (this.d == null) {
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
        } else {
            this.d.clear();
            if (this.c == null) {
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_DISPLAY_OPTIONS_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_DISPLAY_OPTIONS_NULL);
                this.c = new HistoryTraceDisplayOptions();
            }
            a(historyTraceData.getOrderStartPosition());
            b(historyTraceData.getOrderEndPosition());
            List pointsList = historyTraceData.getPointsList();
            if (!(pointsList == null || pointsList.isEmpty())) {
                c(((HistoryTracePoint) pointsList.get(0)).getPoint());
            }
            a(pointsList);
            c();
        }
    }

    private void a(List<HistoryTracePoint> list) {
        if (!this.c.isShowRoutePlan()) {
            a.b(a, "User set not render route polyline");
        } else if (list == null || list.isEmpty()) {
            a.b(a, "There is no points data");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_NULL);
        } else if (list.size() < 2) {
            a.b(a, "History trace points less than 2, can't render polyline");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_LESS, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_LESS);
        } else {
            BitmapDescriptor routeLineTexture = this.c.getRouteLineTexture();
            if (routeLineTexture == null) {
                a.b(a, "Route polyline texture is null");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_ROUTE_TEXTURE_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_ROUTE_TEXTURE_NULL);
                return;
            }
            int routeLineWidth = this.c.getRouteLineWidth();
            if (this.c.isRouteLineRenderBySubSection()) {
                b(routeLineTexture, routeLineWidth, list);
            } else {
                a(routeLineTexture, routeLineWidth, (List) list);
            }
        }
    }

    private List<List<LatLng>> b(List<HistoryTracePoint> list) {
        String str;
        String str2;
        if (list == null || list.isEmpty()) {
            str = a;
            str2 = "History trace point list is null";
        } else if (list.size() < 2) {
            str = a;
            str2 = "History trace point list size is less than 2, can't render polyline";
        } else {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size() - 1; i++) {
                HistoryTracePoint historyTracePoint = (HistoryTracePoint) list.get(i);
                if (historyTracePoint != null) {
                    HistoryTracePoint historyTracePoint2 = (HistoryTracePoint) list.get(i + 1);
                    if (historyTracePoint2 != null) {
                        arrayList.add(historyTracePoint.getPoint());
                        if (historyTracePoint2.getLocationTime() - historyTracePoint.getLocationTime() > 300) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(arrayList);
                            copyOnWriteArrayList.add(arrayList2);
                            arrayList.clear();
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.add(((HistoryTracePoint) list.get(list.size() - 1)).getPoint());
                copyOnWriteArrayList.add(arrayList);
            }
            return copyOnWriteArrayList;
        }
        a.b(str, str2);
        return null;
    }

    private void b() {
        if (!(this.i == null || this.i.isEmpty())) {
            this.i.clear();
        }
        if (this.i == null) {
            this.i = new CopyOnWriteArrayList();
        }
    }

    private void b(BitmapDescriptor bitmapDescriptor, int i, List<HistoryTracePoint> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) != null) {
                arrayList.add(((HistoryTracePoint) list.get(i2)).getPoint());
            }
        }
        Polyline polyline = (Polyline) this.d.addOverlay(new PolylineOptions().width(i).points(arrayList).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4));
        b();
        a(polyline);
    }

    private void b(LatLng latLng) {
        if (!this.c.isShowEndPositionIcon()) {
            a.b(a, "User set not render end point marker");
        } else if (latLng == null) {
            a.b(a, "End point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_NULL, "History trace end point is null, can't render start point marker");
        } else {
            BitmapDescriptor endPositionIcon = this.c.getEndPositionIcon();
            if (endPositionIcon == null) {
                a.b(a, "There is no endPositionIcon");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                return;
            }
            this.g = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(endPositionIcon).zIndex(5));
        }
    }

    private void c() {
        Builder builder = new Builder();
        if (this.f != null) {
            builder.include(this.f.getPosition());
        }
        if (this.g != null) {
            builder.include(this.g.getPosition());
        }
        if (this.h != null) {
            builder.include(this.h.getPosition());
        }
        if (!(this.i == null || this.i.isEmpty())) {
            for (int i = 0; i < this.i.size(); i++) {
                Polyline polyline = (Polyline) this.i.get(i);
                if (!(polyline == null || polyline.getPoints() == null || polyline.getPoints().isEmpty())) {
                    for (int i2 = 0; i2 < polyline.getPoints().size(); i2++) {
                        builder.include((LatLng) polyline.getPoints().get(i2));
                    }
                }
            }
        }
        LatLngBounds build = builder.build();
        if (build == null) {
            a.b(a, "Visibility span is null");
            return;
        }
        this.d.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, this.c.getPaddingLeft(), this.c.getPaddingTop(), this.c.getPaddingRight(), this.c.getPaddingBottom()));
    }

    private void c(LatLng latLng) {
        if (!this.c.isShowCarIcon()) {
            a.b(a, "User set not render car marker");
        } else if (latLng == null) {
            a.b(a, "Car point is null");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_NULL);
        } else {
            BitmapDescriptor carIcon = this.c.getCarIcon();
            if (carIcon == null) {
                a.b(a, "Car icon is null");
                a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_ICON_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_ICON_NULL);
                return;
            }
            this.h = (Marker) this.d.addOverlay(new MarkerOptions().position(latLng).icon(carIcon).flat(true).rotate(0.0f).zIndex(5).anchor(0.5f, 0.5f));
        }
    }

    public void a() {
        b = null;
        if (this.f != null) {
            this.f.remove();
            this.f = null;
        }
        if (this.g != null) {
            this.g.remove();
            this.g = null;
        }
        if (this.h != null) {
            this.h.remove();
            this.h = null;
        }
        if (!(this.i == null || this.i.isEmpty())) {
            this.i.clear();
            this.i = null;
        }
        if (this.c != null) {
            this.c.getCarIcon().recycle();
            this.c.getStartPositionIcon().recycle();
            this.c.getEndPositionIcon().recycle();
            this.c.getRouteLineTexture().recycle();
            this.c = null;
        }
        if (this.d != null) {
            this.d.clear();
        }
        removeCallbacksAndMessages(null);
    }

    public void a(HistoryTraceDisplayOptions historyTraceDisplayOptions, BaiduMap baiduMap, int i) {
        this.c = historyTraceDisplayOptions;
        this.d = baiduMap;
        this.e = i;
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        b = onHistoryTraceListener;
    }

    public void handleMessage(Message message) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Render message type = ");
        stringBuilder.append(message.what);
        a.b(str, stringBuilder.toString());
        if (message.what != 4) {
            a.b(a, "Undefine Render message");
        } else {
            a((HistoryTraceData) message.obj);
        }
    }
}
