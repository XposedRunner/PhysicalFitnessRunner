package com.zjwh.map.gaode;

import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.CoordinateConverter.CoordType;
import com.baidu.mapapi.model.LatLng;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.lp;
import defpackage.lw;

/* compiled from: GaoDeRunLocationControl */
public class O0000o implements lp {
    private boolean O000000o = false;
    private lw O00000Oo;
    private Context O00000o;
    private O0000Oo O00000o0;

    public O0000o(lw lwVar) {
        this.O00000Oo = lwVar;
    }

    private void O000000o(AMapLocation aMapLocation, LatLng latLng) {
        this.O00000Oo.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude(), latLng.latitude, latLng.longitude);
        this.O00000Oo.O000000o(aMapLocation.getSatellites());
    }

    public double O000000o(SWLatLng sWLatLng, SWLatLng sWLatLng2) {
        double d;
        double d2;
        CoordinateConverter coordinateConverter = new CoordinateConverter(this.O00000o);
        double gLat = sWLatLng.getGLat();
        double gLon = sWLatLng.getGLon();
        double gLat2 = sWLatLng2.getGLat();
        double gLon2 = sWLatLng2.getGLon();
        if (gLat < 1.0d || gLon < 1.0d) {
            coordinateConverter.from(CoordType.BAIDU).coord(new com.amap.api.maps.model.LatLng(sWLatLng.getBLat(), sWLatLng.getBLon()));
            com.amap.api.maps.model.LatLng convert = coordinateConverter.convert();
            d = convert.latitude;
            d2 = convert.longitude;
        } else {
            d = gLat;
            d2 = gLon;
        }
        if (gLat2 < 1.0d || gLon2 < 1.0d) {
            coordinateConverter.from(CoordType.BAIDU).coord(new com.amap.api.maps.model.LatLng(sWLatLng2.getBLat(), sWLatLng2.getBLon()));
            com.amap.api.maps.model.LatLng convert2 = coordinateConverter.convert();
            gLat2 = convert2.latitude;
            gLon2 = convert2.longitude;
        }
        return O000O0OO.O000000o(d, d2, gLat2, gLon2);
    }

    public void O000000o() {
        this.O00000Oo = null;
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o();
            this.O00000o0 = null;
        }
    }

    public void O000000o(Context context) {
        this.O00000o = context;
        this.O00000o0 = new O0000Oo();
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationPurpose(AMapLocationPurpose.Sport);
        aMapLocationClientOption.setInterval(3000);
        this.O00000o0.O000000o(context, aMapLocationClientOption, new AMapLocationListener() {
            public void onLocationChanged(AMapLocation aMapLocation) {
                try {
                    if (aMapLocation.getLatitude() >= 1.0d && aMapLocation.getLongitude() >= 1.0d) {
                        if (O0000o.this.O00000Oo != null) {
                            LatLng convert = new com.baidu.mapapi.utils.CoordinateConverter().from(com.baidu.mapapi.utils.CoordinateConverter.CoordType.COMMON).coord(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())).convert();
                            O0000o.this.O000000o(aMapLocation, convert);
                            O0000o.this.O00000Oo.O000000o();
                            if (O0000o.this.O000000o) {
                                lw O000000o = O0000o.this.O00000Oo;
                                int satellites = aMapLocation.getSatellites();
                                double latitude = aMapLocation.getLatitude();
                                double longitude = aMapLocation.getLongitude();
                                String O000000o2 = O000O0OO.O000000o(aMapLocation.getTime());
                                int locationType = aMapLocation.getLocationType();
                                float accuracy = aMapLocation.getAccuracy();
                                boolean z = aMapLocation.getLocationType() == 1;
                                O000000o.O000000o(satellites, latitude, longitude, O000000o2, locationType, accuracy, z, aMapLocation.getAltitude(), aMapLocation.getBearing(), aMapLocation.getGpsAccuracyStatus(), aMapLocation.getSpeed(), convert.latitude, convert.longitude);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, true);
    }

    public void O000000o(boolean z) {
        this.O000000o = z;
    }
}
