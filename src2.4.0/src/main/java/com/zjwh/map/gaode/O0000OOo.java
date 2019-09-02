package com.zjwh.map.gaode;

import android.os.Bundle;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.zjwh.sw.map.O00000o;
import com.zjwh.sw.map.entity.SWFixedPoint;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.ll;
import defpackage.lr;
import defpackage.lv;
import defpackage.lx;
import defpackage.lz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: GaoDeDueCreateControl */
public class O0000OOo extends O00000Oo implements ll {
    private BitmapDescriptor O00000o = BitmapDescriptorFactory.fromResource(R.drawable.img_point_end);
    private BitmapDescriptor O00000o0 = BitmapDescriptorFactory.fromResource(R.drawable.img_point_must_normal);
    private Marker O00000oO = null;
    private lv O00000oo;
    private List<Marker> O0000O0o = new ArrayList();

    public O0000OOo(MapView mapView) {
        super(mapView);
    }

    public O0000OOo(MapView mapView, Map<String, String> map) {
        super(mapView);
        if (map != null) {
            BitmapDescriptor fromPath;
            if (map.containsKey(lr.O0000o0o)) {
                fromPath = BitmapDescriptorFactory.fromPath((String) map.get(lr.O0000o0o));
                if (fromPath != null) {
                    this.O00000o0 = fromPath;
                }
            }
            if (map.containsKey(lr.O00000Oo)) {
                fromPath = BitmapDescriptorFactory.fromPath((String) map.get(lr.O00000Oo));
                if (fromPath != null) {
                    this.O00000o = fromPath;
                }
            }
        }
    }

    public void O000000o(Object obj) {
        if (obj instanceof Marker) {
            for (int i = 0; i < this.O0000O0o.size(); i++) {
                Marker marker = (Marker) this.O0000O0o.get(i);
                if (marker.equals(obj)) {
                    if (this.O00000oO != null) {
                        this.O00000oO.setIcon(this.O00000o0);
                    }
                    this.O00000oO = marker;
                    if (this.O00000oo != null) {
                        Marker marker2 = (Marker) obj;
                        this.O00000oo.O000000o(marker2.getPeriod() - 1, marker2.getTitle());
                    }
                }
            }
            ((Marker) obj).setIcon(this.O00000o);
        }
    }

    public void O000000o(List<SWFixedPoint> list) throws O00000o {
        if (this.b_ != null) {
            this.O0000O0o.clear();
            List arrayList = new ArrayList();
            for (SWFixedPoint sWFixedPoint : list) {
                SWLatLng O000000o = O000O0OO.O000000o(sWFixedPoint.getGLat(), sWFixedPoint.getGLon(), sWFixedPoint.getBLat(), sWFixedPoint.getBLon(), this.a_.getContext());
                Object zIndex = new MarkerOptions().position(new LatLng(O000000o.getGLat(), O000000o.getGLon())).zIndex(5.0f);
                zIndex.icon(this.O00000o0);
                Marker marker = (Marker) this.b_.O000000o(zIndex);
                marker.setPeriod(sWFixedPoint.getId() + 1);
                marker.setTitle(sWFixedPoint.getDescription());
                this.O0000O0o.add(marker);
                arrayList.add(O000000o);
            }
            this.b_.O00000Oo(arrayList);
        }
    }

    public void O000000o(lv lvVar) {
        this.O00000oo = lvVar;
    }

    public void O000000o(lx lxVar) {
        if (this.b_ != null) {
            this.b_.O000000o(lxVar);
        }
    }

    public void O000000o(lz lzVar) {
        if (this.b_ != null) {
            this.b_.O000000o(lzVar);
        }
    }

    public void O00000Oo(Bundle bundle) {
        super.O000000o(3, bundle);
    }

    public void O00000o0() {
        super.O00000o0();
        if (this.O0000O0o != null) {
            this.O0000O0o.clear();
            this.O0000O0o = null;
        }
        if (this.O00000o0 != null) {
            this.O00000o0.recycle();
            this.O00000o0 = null;
        }
        if (this.O00000o != null) {
            this.O00000o.recycle();
            this.O00000o = null;
        }
        this.O00000oo = null;
    }
}
