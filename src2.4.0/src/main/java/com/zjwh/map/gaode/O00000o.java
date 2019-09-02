package com.zjwh.map.gaode;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.zjwh.sw.map.entity.RunPeopleBean;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.lj;
import defpackage.ls;
import defpackage.lt;
import defpackage.lx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GaoDeCheatMapControl */
public class O00000o extends O00000Oo implements lj {
    private static final int O00000o0 = 5;
    private BitmapDescriptor O00000o = BitmapDescriptorFactory.fromResource(R.drawable.cheat_report_male);
    private BitmapDescriptor O00000oO = BitmapDescriptorFactory.fromResource(R.drawable.cheat_report_male_selected);
    private BitmapDescriptor O00000oo = BitmapDescriptorFactory.fromResource(R.drawable.cheat_report_female);
    private BitmapDescriptor O0000O0o = BitmapDescriptorFactory.fromResource(R.drawable.cheat_report_female_selected);
    private O0000Oo O0000OOo;
    private Polyline O0000Oo;
    private ls O0000Oo0;
    private Marker O0000OoO;
    private int O0000Ooo = 0;

    public O00000o(MapView mapView) {
        super(mapView);
    }

    public void O000000o(double d, double d2) {
        if (this.b_ != null) {
            this.b_.O000000o(d, d2, 17.0f);
        }
    }

    public void O000000o(double d, double d2, float f) {
        if (this.b_ != null) {
            this.b_.O00000Oo(d, d2, f);
        }
    }

    public void O000000o(int i, boolean z) {
        if (i != 1) {
            this.O0000OoO.setIcon(z ? this.O0000O0o : this.O00000oo);
        } else {
            this.O0000OoO.setIcon(z ? this.O00000oO : this.O00000o);
        }
        if (this.O0000Oo != null) {
            this.O0000Oo.remove();
            this.O0000Oo = null;
        }
        if (z) {
            this.O0000Ooo++;
        } else {
            this.O0000Ooo--;
        }
    }

    public void O000000o(Context context) {
        this.O0000OOo = new O0000Oo();
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setInterval(5000);
        this.O0000OOo.O000000o(context, aMapLocationClientOption, new AMapLocationListener() {
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (O00000o.this.O0000Oo0 != null) {
                    O00000o.this.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation.getBearing());
                    O00000o.this.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                }
            }
        }, false);
    }

    public void O000000o(List<SWLatLng> list) throws com.zjwh.sw.map.O00000o {
        ArrayList arrayList = new ArrayList();
        for (SWLatLng sWLatLng : list) {
            arrayList.add(new LatLng(sWLatLng.getGLat(), sWLatLng.getGLon()));
        }
        if (this.O0000Oo != null) {
            this.O0000Oo.remove();
            this.O0000Oo = null;
        }
        Object polylineOptions = new PolylineOptions();
        polylineOptions.color(-65536).setPoints(arrayList);
        this.O0000Oo = (Polyline) this.b_.O000000o(polylineOptions);
    }

    public void O000000o(List<RunPeopleBean> list, RunPeopleBean runPeopleBean, List<SWLatLng> list2) throws com.zjwh.sw.map.O00000o {
        if (runPeopleBean != null && list != null) {
            for (RunPeopleBean runPeopleBean2 : list) {
                if (O000O0OO.O000000o(runPeopleBean.getGLat(), runPeopleBean.getGLon(), runPeopleBean2.getGLat(), runPeopleBean2.getGLon()) <= 5.0d) {
                    runPeopleBean2.setChoose(true);
                }
            }
            O00000Oo((List) list);
            if (list2 != null && list2.size() > 1) {
                O000000o((List) list2);
            }
        }
    }

    public void O000000o(ls lsVar) {
        this.O0000Oo0 = lsVar;
    }

    public void O000000o(final lt ltVar) {
        if (this.b_ != null) {
            this.b_.O000000o(new lx() {
                public void O000000o() {
                }

                public void O000000o(Object obj) {
                    if (obj instanceof Marker) {
                        Marker marker = (Marker) obj;
                        O00000o.this.O0000OoO = marker;
                        int intValue = Integer.valueOf(marker.getSnippet()).intValue();
                        if (ltVar != null) {
                            ltVar.O000000o(intValue);
                        }
                        marker.setSnippet(null);
                    }
                }
            });
        }
    }

    public void O00000Oo(Bundle bundle) {
        super.O000000o(1, bundle);
    }

    public void O00000Oo(List<RunPeopleBean> list) throws com.zjwh.sw.map.O00000o {
        int i = 0;
        this.O0000Ooo = 0;
        List arrayList = new ArrayList();
        while (i < list.size()) {
            RunPeopleBean runPeopleBean = (RunPeopleBean) list.get(i);
            if (runPeopleBean.isChoose()) {
                this.O0000Ooo++;
            }
            MarkerOptions flat = new MarkerOptions().position(new LatLng(runPeopleBean.getGLat(), runPeopleBean.getGLon())).perspective(true).setFlat(true);
            if (runPeopleBean.getSex() != 1) {
                flat.icon(runPeopleBean.isChoose() ? this.O0000O0o : this.O00000oo);
            } else {
                flat.icon(runPeopleBean.isChoose() ? this.O00000oO : this.O00000o);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            flat.snippet(stringBuilder.toString());
            arrayList.add(flat);
            i++;
        }
        this.b_.O00000o();
        this.b_.O000000o(arrayList);
    }

    public int O00000o() {
        return this.O0000Ooo;
    }

    public void O00000o0() {
        super.O00000o0();
        this.O0000Oo0 = null;
        if (this.O0000OOo != null) {
            this.O0000OOo.O000000o();
            this.O0000OOo = null;
        }
    }
}
