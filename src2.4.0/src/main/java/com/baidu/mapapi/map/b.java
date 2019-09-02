package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.MotionEvent;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnPolylineClickListener;
import com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.l;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;

class b implements l {
    final /* synthetic */ BaiduMap a;

    b(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    public void a() {
    }

    public void a(Bitmap bitmap) {
        if (this.a.z != null) {
            this.a.z.onSnapshotReady(bitmap);
        }
    }

    public void a(MotionEvent motionEvent) {
        if (this.a.p != null) {
            this.a.p.onTouch(motionEvent);
        }
    }

    public void a(GeoPoint geoPoint) {
        if (this.a.q != null) {
            this.a.q.onMapClick(CoordUtil.mc2ll(geoPoint));
        }
    }

    public void a(ab abVar) {
        if (this.a.J != null) {
            this.a.J.setVisibility(4);
        }
        int i = (BaiduMap.mapStatusReason & 256) == 256 ? 3 : (BaiduMap.mapStatusReason & 16) == 16 ? 2 : 1;
        if (this.a.o != null) {
            MapStatus a = MapStatus.a(abVar);
            this.a.o.onMapStatusChangeStart(a);
            this.a.o.onMapStatusChangeStart(a, i);
        }
        if (this.a.C != null) {
            this.a.C.onMapStatusChangeReason(i);
        }
        BaiduMap.mapStatusReason = 0;
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONArray("dataset").optJSONObject(0);
            GeoPoint b = this.a.i.b(jSONObject.optInt("px"), jSONObject.optInt("py"));
            int optInt = optJSONObject.optInt("ty");
            if (optInt != 17) {
                if (optInt == 18) {
                    if (this.a.y != null) {
                        this.a.y.onMyLocationClick();
                        return;
                    }
                } else if (optInt == 19) {
                    if (this.a.i != null) {
                        ab E = this.a.i.E();
                        if (E != null) {
                            E.c = 0;
                            E.b = 0;
                            BaiduMap.mapStatusReason |= 16;
                            this.a.i.a(E, (int) SecExceptionCode.SEC_ERROR_STA_ENC);
                            return;
                        }
                        return;
                    }
                } else if (optInt == 90909) {
                    str = optJSONObject.optString("marker_id");
                    if (this.a.H == null || !str.equals(this.a.I.v)) {
                        for (Overlay overlay : this.a.k) {
                            if ((overlay instanceof Marker) && overlay.v.equals(str)) {
                                if (this.a.v.isEmpty()) {
                                    a(b);
                                } else {
                                    Iterator it = this.a.v.iterator();
                                    while (it.hasNext()) {
                                        ((OnMarkerClickListener) it.next()).onMarkerClick((Marker) overlay);
                                    }
                                }
                            }
                        }
                    } else {
                        OnInfoWindowClickListener onInfoWindowClickListener = this.a.H.d;
                        if (onInfoWindowClickListener != null) {
                            onInfoWindowClickListener.onInfoWindowClick();
                            return;
                        }
                    }
                } else if (optInt == 90910) {
                    str = optJSONObject.optString("polyline_id");
                    for (Overlay overlay2 : this.a.k) {
                        if ((overlay2 instanceof Polyline) && overlay2.v.equals(str)) {
                            if (this.a.w.isEmpty()) {
                                a(b);
                            } else {
                                Iterator it2 = this.a.w.iterator();
                                while (it2.hasNext()) {
                                    ((OnPolylineClickListener) it2.next()).onPolylineClick((Polyline) overlay2);
                                }
                            }
                        }
                    }
                }
                a(b);
            } else if (this.a.q != null) {
                MapPoi mapPoi = new MapPoi();
                mapPoi.a(optJSONObject);
                this.a.q.onMapPoiClick(mapPoi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(GL10 gl10, ab abVar) {
        if (this.a.A != null) {
            this.a.A.onMapDrawFrame(MapStatus.a(abVar));
        }
    }

    public void a(boolean z) {
        if (this.a.B != null) {
            this.a.B.onBaseIndoorMapMode(z, this.a.getFocusedBaseIndoorMapInfo());
        }
    }

    public void b() {
        this.a.f = new Projection(this.a.i);
        this.a.Q = true;
        if (this.a.r != null) {
            this.a.r.onMapLoaded();
        }
    }

    public void b(GeoPoint geoPoint) {
        if (this.a.t != null) {
            this.a.t.onMapDoubleClick(CoordUtil.mc2ll(geoPoint));
        }
    }

    public void b(ab abVar) {
        if (this.a.o != null) {
            this.a.o.onMapStatusChange(MapStatus.a(abVar));
        }
    }

    public boolean b(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONArray("dataset").optJSONObject(0);
            if (optJSONObject.optInt("ty") == 90909) {
                str = optJSONObject.optString("marker_id");
                if (this.a.I == null || !str.equals(this.a.I.v)) {
                    for (Overlay overlay : this.a.k) {
                        if ((overlay instanceof Marker) && overlay.v.equals(str)) {
                            Marker marker = (Marker) overlay;
                            if (marker.f) {
                                this.a.K = marker;
                                Point toScreenLocation = this.a.f.toScreenLocation(this.a.K.a);
                                this.a.K.setPosition(this.a.f.fromScreenLocation(new Point(toScreenLocation.x, toScreenLocation.y - 60)));
                                if (this.a.x != null) {
                                    this.a.x.onMarkerDragStart(this.a.K);
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void c() {
        if (this.a.s != null) {
            this.a.s.onMapRenderFinished();
        }
    }

    public void c(GeoPoint geoPoint) {
        if (this.a.u != null) {
            this.a.u.onMapLongClick(CoordUtil.mc2ll(geoPoint));
        }
    }

    public void c(ab abVar) {
        if (this.a.J != null) {
            this.a.J.setVisibility(0);
        }
        if (this.a.o != null) {
            this.a.o.onMapStatusChangeFinish(MapStatus.a(abVar));
        }
    }

    public void d() {
        this.a.F.lock();
        try {
            if (this.a.E != null) {
                this.a.E.a();
            }
            this.a.F.unlock();
        } catch (Throwable th) {
            this.a.F.unlock();
        }
    }

    public void d(GeoPoint geoPoint) {
        if (this.a.K != null && this.a.K.f) {
            Point toScreenLocation = this.a.f.toScreenLocation(CoordUtil.mc2ll(geoPoint));
            this.a.K.setPosition(this.a.f.fromScreenLocation(new Point(toScreenLocation.x, toScreenLocation.y - 60)));
            if (this.a.x != null && this.a.K.f) {
                this.a.x.onMarkerDrag(this.a.K);
            }
        }
    }

    public void e() {
        this.a.F.lock();
        try {
            if (this.a.E != null) {
                this.a.E.a();
                this.a.i.o();
            }
            this.a.F.unlock();
        } catch (Throwable th) {
            this.a.F.unlock();
        }
    }

    public void e(GeoPoint geoPoint) {
        if (this.a.K != null && this.a.K.f) {
            Point toScreenLocation = this.a.f.toScreenLocation(CoordUtil.mc2ll(geoPoint));
            this.a.K.setPosition(this.a.f.fromScreenLocation(new Point(toScreenLocation.x, toScreenLocation.y - 60)));
            if (this.a.x != null && this.a.K.f) {
                this.a.x.onMarkerDragEnd(this.a.K);
            }
            this.a.K = null;
        }
    }

    public void f() {
        this.a.i.b(false);
        this.a.F.lock();
        try {
            if (this.a.E != null) {
                this.a.a(this.a.E);
            }
            this.a.F.unlock();
        } catch (Throwable th) {
            this.a.F.unlock();
        }
    }
}
