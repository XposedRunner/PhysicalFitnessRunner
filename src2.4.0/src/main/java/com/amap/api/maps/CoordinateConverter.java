package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.O000O0o;
import com.amap.api.mapcore.util.OOOO0O;
import com.amap.api.mapcore.util.ooOOOOoo;
import com.amap.api.maps.model.LatLng;

public class CoordinateConverter {
    private Context a;
    private CoordType b = null;
    private LatLng c = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.a = context;
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return OOOO0O.O000000o(d, d2);
    }

    public LatLng convert() {
        LatLng latLng = null;
        if (this.b == null || this.c == null) {
            return null;
        }
        try {
            switch (this.b) {
                case BAIDU:
                    latLng = O000O0o.O000000o(this.c);
                    break;
                case MAPBAR:
                    latLng = O000O0o.O00000Oo(this.a, this.c);
                    break;
                case MAPABC:
                case SOSOMAP:
                case ALIYUN:
                case GOOGLE:
                    latLng = this.c;
                    break;
                case GPS:
                    latLng = O000O0o.O000000o(this.a, this.c);
                    break;
                default:
                    break;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ooOOOOoo.O00000o0(th, "CoordinateConverter", "convert");
            latLng = this.c;
        }
        return latLng;
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }
}
