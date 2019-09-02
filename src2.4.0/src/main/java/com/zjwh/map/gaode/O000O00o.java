package com.zjwh.map.gaode;

import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.zjwh.sw.map.O00000o;
import com.zjwh.sw.map.O00000o0;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.lr;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: GaoDeRunPointControl */
public class O000O00o extends O00000Oo implements lr {
    BitmapDescriptor O00000o = BitmapDescriptorFactory.fromResource(R.drawable.img_point_normal_pass);
    BitmapDescriptor O00000o0 = BitmapDescriptorFactory.fromResource(R.drawable.img_point_normal);
    BitmapDescriptor O00000oO = BitmapDescriptorFactory.fromResource(R.drawable.img_point_must_normal);
    BitmapDescriptor O00000oo = BitmapDescriptorFactory.fromResource(R.drawable.img_point_must_pass);
    BitmapDescriptor O0000O0o = BitmapDescriptorFactory.fromResource(R.drawable.img_point_end);
    BitmapDescriptor O0000OOo = BitmapDescriptorFactory.fromResource(R.drawable.img_point_assign_end_normal);
    BitmapDescriptor[] O0000Oo = new BitmapDescriptor[]{BitmapDescriptorFactory.fromResource(R.drawable.run_point_first), BitmapDescriptorFactory.fromResource(R.drawable.run_point_second), BitmapDescriptorFactory.fromResource(R.drawable.run_point_third), BitmapDescriptorFactory.fromResource(R.drawable.run_point_fourth), BitmapDescriptorFactory.fromResource(R.drawable.run_point_fifth)};
    BitmapDescriptor O0000Oo0 = BitmapDescriptorFactory.fromResource(R.drawable.img_point_assign_end_pass);
    BitmapDescriptor[] O0000OoO = new BitmapDescriptor[]{BitmapDescriptorFactory.fromResource(R.drawable.run_point_first_lock), BitmapDescriptorFactory.fromResource(R.drawable.run_point_second_lock), BitmapDescriptorFactory.fromResource(R.drawable.run_point_third_lock), BitmapDescriptorFactory.fromResource(R.drawable.run_point_fourth_lock), BitmapDescriptorFactory.fromResource(R.drawable.run_point_fifth_lock)};
    int O0000Ooo = 0;
    SWLatLng O0000o00;
    private BitmapDescriptor O000O0Oo = BitmapDescriptorFactory.fromResource(R.drawable.img_point_start);

    O000O00o(MapView mapView) {
        super(mapView);
    }

    public void O000000o(SWLatLng sWLatLng) throws O00000o {
        if (this.b_ != null) {
            O000O0OO.O000000o(sWLatLng, this.a_.getContext());
            Object zIndex = new MarkerOptions().position(new LatLng(sWLatLng.getGLat(), sWLatLng.getGLon())).icon(this.O000O0Oo).zIndex(5.0f);
            zIndex.period(O00000o0.O000O0OO);
            this.b_.O000000o(zIndex);
        }
    }

    public void O000000o(SWLatLng sWLatLng, SWLatLng sWLatLng2, double d, int i, double d2, double d3, int i2) throws O00000o {
        if (this.b_ != null) {
            O000O0OO.O000000o(sWLatLng, this.a_.getContext());
            O000O0OO.O000000o(sWLatLng2, this.a_.getContext());
            if (this.O0000o00 == null && i2 != -1) {
                this.O0000o00 = sWLatLng;
            }
            if (i != -1) {
                if (this.O0000Ooo >= 1 || i != i2 || Math.abs(d3) > 10.0d) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new LatLng(this.O0000o00.getGLat(), this.O0000o00.getGLon()));
                    arrayList.add(new LatLng(sWLatLng2.getGLat(), sWLatLng2.getGLon()));
                    int i3 = -16727669;
                    if (i == 3 || i == 4) {
                        i3 = -65536;
                    } else if (i == 7) {
                        i3 = -4868683;
                    }
                    this.b_.O000000o(new PolylineOptions().width(16.0f).color(i3).addAll(arrayList));
                    this.O0000Ooo = 0;
                    this.O0000o00 = sWLatLng2;
                } else {
                    this.O0000Ooo++;
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Map<String, String> map) {
        for (Entry entry : map.entrySet()) {
            BitmapDescriptor fromPath = BitmapDescriptorFactory.fromPath((String) entry.getValue());
            if (fromPath != null) {
                String str = (String) entry.getKey();
                int i = -1;
                switch (str.hashCode()) {
                    case -2035691982:
                        if (str.equals(lr.O0000o0o)) {
                            i = 4;
                            break;
                        }
                        break;
                    case -1387239603:
                        if (str.equals(lr.O0000oOo)) {
                            i = 14;
                            break;
                        }
                        break;
                    case -1203596652:
                        if (str.equals(lr.O00oOooo)) {
                            i = 10;
                            break;
                        }
                        break;
                    case -1203585139:
                        if (str.equals(lr.O0000oo)) {
                            i = 6;
                            break;
                        }
                        break;
                    case -1190694332:
                        if (str.equals(lr.O0000ooo)) {
                            i = 8;
                            break;
                        }
                        break;
                    case -916261581:
                        if (str.equals(lr.O0000oO)) {
                            i = 12;
                            break;
                        }
                        break;
                    case -716777914:
                        if (str.equals(lr.O0000oOO)) {
                            i = 13;
                            break;
                        }
                        break;
                    case -529445860:
                        if (str.equals(lr.O0000o)) {
                            i = 5;
                            break;
                        }
                        break;
                    case -71009673:
                        if (str.equals(lr.O000000o)) {
                            i = 0;
                            break;
                        }
                        break;
                    case 77950621:
                        if (str.equals(lr.O0000oO0)) {
                            i = 11;
                            break;
                        }
                        break;
                    case 116113456:
                        if (str.equals(lr.O00000Oo)) {
                            i = 1;
                            break;
                        }
                        break;
                    case 423431344:
                        if (str.equals(lr.O000O00o)) {
                            i = 16;
                            break;
                        }
                        break;
                    case 1183016950:
                        if (str.equals(lr.O0000oo0)) {
                            i = 15;
                            break;
                        }
                        break;
                    case 1349195997:
                        if (str.equals(lr.O00oOooO)) {
                            i = 9;
                            break;
                        }
                        break;
                    case 1542023870:
                        if (str.equals(lr.O0000o0O)) {
                            i = 3;
                            break;
                        }
                        break;
                    case 1711600439:
                        if (str.equals(lr.O0000ooO)) {
                            i = 7;
                            break;
                        }
                        break;
                    case 1797132826:
                        if (str.equals(lr.O000O0OO)) {
                            i = 17;
                            break;
                        }
                        break;
                    case 1946405234:
                        if (str.equals(lr.O0000o0)) {
                            i = 2;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        this.O000O0Oo = fromPath;
                        break;
                    case 1:
                        this.O0000O0o = fromPath;
                        break;
                    case 2:
                        this.O00000o0 = fromPath;
                        break;
                    case 3:
                        this.O00000o = fromPath;
                        break;
                    case 4:
                        this.O00000oO = fromPath;
                        break;
                    case 5:
                        this.O00000oo = fromPath;
                        break;
                    case 6:
                        this.O0000Oo[0] = fromPath;
                        break;
                    case 7:
                        this.O0000Oo[1] = fromPath;
                        break;
                    case 8:
                        this.O0000Oo[2] = fromPath;
                        break;
                    case 9:
                        this.O0000Oo[3] = fromPath;
                        break;
                    case 10:
                        this.O0000Oo[4] = fromPath;
                        break;
                    case 11:
                        this.O0000OoO[0] = fromPath;
                        break;
                    case 12:
                        this.O0000OoO[1] = fromPath;
                        break;
                    case 13:
                        this.O0000OoO[2] = fromPath;
                        break;
                    case 14:
                        this.O0000OoO[3] = fromPath;
                        break;
                    case 15:
                        this.O0000OoO[4] = fromPath;
                        break;
                    case 16:
                        this.O0000OOo = fromPath;
                        break;
                    case 17:
                        this.O0000Oo0 = fromPath;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void O00000Oo(SWLatLng sWLatLng) throws O00000o {
        if (this.b_ != null) {
            O000O0OO.O000000o(sWLatLng, this.a_.getContext());
            Object zIndex = new MarkerOptions().position(new LatLng(sWLatLng.getGLat(), sWLatLng.getGLon())).icon(this.O0000O0o).zIndex(5.0f);
            zIndex.period(O00000o0.O000O0OO);
            this.b_.O000000o(zIndex);
        }
    }

    public void O00000o0() {
        int length;
        super.O00000o0();
        if (this.O000O0Oo != null) {
            this.O000O0Oo.recycle();
            this.O000O0Oo = null;
        }
        if (this.O00000oo != null) {
            this.O00000oo.recycle();
            this.O00000oo = null;
        }
        if (this.O00000oO != null) {
            this.O00000oO.recycle();
            this.O00000oO = null;
        }
        if (this.O00000o0 != null) {
            this.O00000o0.recycle();
            this.O00000o0 = null;
        }
        if (this.O00000o != null) {
            this.O00000o.recycle();
            this.O00000o = null;
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.recycle();
            this.O0000O0o = null;
        }
        if (this.O0000OOo != null) {
            this.O0000OOo.recycle();
            this.O0000OOo = null;
        }
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.recycle();
            this.O0000Oo0 = null;
        }
        int i = 0;
        if (this.O0000Oo != null) {
            for (BitmapDescriptor bitmapDescriptor : this.O0000Oo) {
                if (bitmapDescriptor != null) {
                    bitmapDescriptor.recycle();
                }
            }
            this.O0000Oo = null;
        }
        if (this.O0000OoO != null) {
            BitmapDescriptor[] bitmapDescriptorArr = this.O0000OoO;
            length = bitmapDescriptorArr.length;
            while (i < length) {
                BitmapDescriptor bitmapDescriptor2 = bitmapDescriptorArr[i];
                if (bitmapDescriptor2 != null) {
                    bitmapDescriptor2.recycle();
                }
                i++;
            }
            this.O0000OoO = null;
        }
    }
}
