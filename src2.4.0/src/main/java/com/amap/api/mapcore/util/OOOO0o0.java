package com.amap.api.mapcore.util;

import com.amap.api.maps.model.LatLng;

/* compiled from: SegmentsIntersect */
public class OOOO0o0 {
    private static double O000000o(LatLng latLng, LatLng latLng2) {
        return (latLng.longitude * latLng2.latitude) - (latLng2.longitude * latLng.latitude);
    }

    private static double O000000o(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        return O000000o(O00000Oo(latLng3, latLng), O00000Oo(latLng2, latLng));
    }

    public static boolean O000000o(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        LatLng latLng5 = latLng;
        LatLng latLng6 = latLng2;
        LatLng latLng7 = latLng3;
        LatLng latLng8 = latLng4;
        double O000000o = O000000o(latLng7, latLng8, latLng5);
        double O000000o2 = O000000o(latLng7, latLng8, latLng6);
        double O000000o3 = O000000o(latLng, latLng2, latLng3);
        double O000000o4 = O000000o(latLng5, latLng6, latLng8);
        boolean z = ((O000000o > 0.0d && O000000o2 < 0.0d) || (O000000o < 0.0d && O000000o2 > 0.0d)) && ((O000000o3 > 0.0d && O000000o4 < 0.0d) || (O000000o3 < 0.0d && O000000o4 > 0.0d));
        return z ? true : (O000000o == 0.0d && O00000Oo(latLng7, latLng8, latLng5)) ? true : (O000000o2 == 0.0d && O00000Oo(latLng7, latLng8, latLng6)) ? true : (O000000o3 == 0.0d && O00000Oo(latLng, latLng2, latLng3)) ? true : O000000o4 == 0.0d && O00000Oo(latLng5, latLng6, latLng8);
    }

    private static LatLng O00000Oo(LatLng latLng, LatLng latLng2) {
        return new LatLng(latLng2.latitude - latLng.latitude, latLng2.longitude - latLng.longitude);
    }

    private static boolean O00000Oo(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.longitude - latLng2.longitude > 0.0d ? latLng.longitude : latLng2.longitude;
        return (((latLng.longitude - latLng2.longitude) > 0.0d ? 1 : ((latLng.longitude - latLng2.longitude) == 0.0d ? 0 : -1)) < 0 ? latLng.longitude : latLng2.longitude) <= latLng3.longitude && latLng3.longitude <= d && (latLng.latitude - latLng2.latitude < 0.0d ? latLng.latitude : latLng2.latitude) <= latLng3.latitude && latLng3.latitude <= (latLng.latitude - latLng2.latitude > 0.0d ? latLng.latitude : latLng2.latitude);
    }
}
