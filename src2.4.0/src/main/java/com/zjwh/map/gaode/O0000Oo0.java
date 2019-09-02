package com.zjwh.map.gaode;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.zjwh.sw.map.O00000o;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.lm;
import defpackage.lz;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GaoDeDueWaitControl */
public class O0000Oo0 extends O00000Oo implements lm {
    private List<BitmapDescriptor> O00000o = new ArrayList();
    private BitmapDescriptor O00000o0 = BitmapDescriptorFactory.fromResource(R.drawable.img_point_end);
    private List<Marker> O00000oO = new ArrayList();

    public O0000Oo0(MapView mapView) {
        super(mapView);
    }

    public O0000Oo0(MapView mapView, String str) {
        super(mapView);
        if (str != null) {
            BitmapDescriptor fromPath = BitmapDescriptorFactory.fromPath(str);
            if (fromPath != null) {
                this.O00000o0 = fromPath;
            }
        }
    }

    public void O000000o(double d, double d2) {
        if (this.b_ != null) {
            this.b_.O000000o(d, d2, 17.0f);
        }
    }

    public void O000000o(double d, double d2, String str) throws O00000o {
        if (this.b_ != null) {
            SWLatLng O000000o = O000O0OO.O000000o(-1.0d, -1.0d, d, d2, this.a_.getContext());
            ((Marker) this.b_.O000000o(new MarkerOptions().position(new LatLng(O000000o.getGLat(), O000000o.getGLon())).icon(this.O00000o0).zIndex(5.0f))).setTitle(str);
        }
    }

    public void O000000o(Bitmap bitmap, double d, double d2) throws O00000o {
        if (this.b_ != null) {
            SWLatLng O000000o = O000O0OO.O000000o(-1.0d, -1.0d, d, d2, this.a_.getContext());
            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
            this.O00000o.add(fromBitmap);
            Object zIndex = new MarkerOptions().position(new LatLng(O000000o.getGLat(), O000000o.getGLon())).zIndex(9.0f);
            zIndex.icon(fromBitmap);
            this.O00000oO.add((Marker) this.b_.O000000o(zIndex));
        }
    }

    public void O000000o(List<SWLatLng> list) {
        if (this.b_ != null) {
            this.b_.O00000Oo((List) list);
        }
    }

    public void O000000o(lz lzVar) {
        if (this.b_ != null) {
            this.b_.O000000o(lzVar);
        }
    }

    public void O00000Oo(Bundle bundle) {
        super.O000000o(0, bundle);
    }

    public void O00000o() {
        if (this.O00000o.size() > 0) {
            for (BitmapDescriptor recycle : this.O00000o) {
                recycle.recycle();
            }
        }
        this.O00000o.clear();
        if (this.O00000oO.size() > 0) {
            for (Marker remove : this.O00000oO) {
                remove.remove();
            }
        }
        this.O00000oO.clear();
    }

    public void O00000o0() {
        super.O00000o0();
        O00000o();
        if (this.O00000oO != null) {
            this.O00000oO.clear();
            this.O00000oO = null;
        }
        if (this.O00000o0 != null) {
            this.O00000o0.recycle();
            this.O00000o0 = null;
        }
    }
}
