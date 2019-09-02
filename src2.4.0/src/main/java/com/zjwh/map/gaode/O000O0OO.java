package com.zjwh.map.gaode;

import android.content.Context;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.CoordinateConverter.CoordType;
import com.amap.api.maps.model.LatLng;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.sw.map.entity.SWLatLng;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: GaoDeUtils */
public class O000O0OO {
    public static double O000000o(double d, double d2, double d3, double d4) {
        return (d3 <= 0.0d || d4 <= 0.0d) ? 0.0d : (double) AMapUtils.calculateLineDistance(new LatLng(d3, d4), new LatLng(d, d2));
    }

    public static SWLatLng O000000o(double d, double d2, double d3, double d4, Context context) {
        return O000000o(new SWLatLng(d, d2, d3, d4), context);
    }

    public static SWLatLng O000000o(SWLatLng sWLatLng, Context context) {
        if (sWLatLng.getGLat() < 1.0d || sWLatLng.getGLon() < 1.0d) {
            CoordinateConverter coordinateConverter = new CoordinateConverter(context);
            coordinateConverter.from(CoordType.BAIDU).coord(new LatLng(sWLatLng.getBLat(), sWLatLng.getBLon()));
            LatLng convert = coordinateConverter.convert();
            sWLatLng.setGLat(convert.latitude);
            sWLatLng.setGLon(convert.longitude);
        }
        return sWLatLng;
    }

    public static String O000000o(long j) {
        return j <= 0 ? "" : new SimpleDateFormat(O000O0o0.O0000o0, Locale.CHINA).format(Long.valueOf(j));
    }

    public static boolean O000000o() {
        return false;
    }
}
