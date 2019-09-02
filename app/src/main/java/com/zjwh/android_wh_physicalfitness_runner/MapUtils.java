package com.zjwh.android_wh_physicalfitness_runner;

//import com.baidu.mapapi.model.LatLng;
//import com.baidu.mapapi.utils.DistanceUtil;

public class MapUtils {
    private MapUtils() {
    }

    private static final double LONGITUDE_ON_A_METER = 10.0 / getDistance(new LatLng(30, 104), new LatLng(30, 114));
    private static final double LATITUDE_ON_A_METER = 10.0 / getDistance(new LatLng(30, 104), new LatLng(40, 104));


//    public static double getDistance(LatLng latLng1, LatLng latLng2) {
//        return DistanceUtil.getDistance(latLng1, latLng2);
//    }

    public static LatLng nextLatLng(LatLng latLng, Angle angle, double distance) {
        double latitude = latLng.latitude + distance * Math.sin(angle.rad()) * LATITUDE_ON_A_METER;
        double longitude = latLng.longitude + distance * Math.cos(angle.rad()) * LONGITUDE_ON_A_METER;
        return new LatLng(latitude, longitude);
    }

    public static LatLng nextOffsetLatLng(LatLng latLng, Angle angle, double offset) {
        double latitude = latLng.latitude + offset * Math.sin(angle.rad() - Math.PI / 2) * LATITUDE_ON_A_METER;
        double longitude = latLng.longitude + offset * Math.cos(angle.rad() - Math.PI / 2) * LONGITUDE_ON_A_METER;
        return new LatLng(latitude, longitude);
    }

    public static double getDistance(LatLng latLng1, LatLng latLng2) {
        double d = 0.01745329251994329d;
        double[] d1 = new double[]{latLng1.longitude * d, latLng1.latitude * d, latLng2.longitude * d, latLng2.latitude * d};
        double[] d2 = new double[]{Math.sin(d1[0]), Math.sin(d1[1]), Math.sin(d1[2]), Math.sin(d1[3])};
        double[] d3 = new double[]{Math.cos(d1[0]), Math.cos(d1[1]), Math.cos(d1[2]), Math.cos(d1[3])};
        double[] d4 = new double[]{d3[0] * d3[1], d3[1] * d2[0], d2[1]};
        double[] d5 = new double[]{d3[2] * d3[3], d3[3] * d2[2], d2[3]};
        double d6 = Math.sqrt((d4[0] - d5[0]) * (d4[0] - d5[0]) + (d4[1] - d5[1]) * (d4[1] - d5[1]) + (d4[2] - d5[2]) * (d4[2] - d5[2]));
        return (Math.asin(d6 / 2.0d) * 1.27420015798544E7d);
    }


}
