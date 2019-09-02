package com.autonavi.amap.mapcore;

import android.graphics.Point;

public class VirtualEarthProjection {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int KMA_MAX_MAP_SIZE = 268435456;
    private static final double K_EARTH_CIRCLE = 4.0075016E7d;
    private static final double K_EARTH_CIRCLE_2 = 2.0037508E7d;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 360.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -360.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;

    public static double clip(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }

    private static double degToRad(double d) {
        return d * 0.017453292519943295d;
    }

    public static Point latLongToPixels(double d, double d2, int i) {
        Point point = new Point();
        d2 = degToRad(clip(d2, -360.0d, 360.0d)) * 6378137.0d;
        d = Math.sin(degToRad(clip(d, -85.0511287798d, 85.0511287798d)));
        d = (K_EARTH_CIRCLE_2 - ((6378137.0d * Math.log((1.0d + d) / (1.0d - d))) / 2.0d)) / 0.14929106831550598d;
        point.x = (int) ((d2 + K_EARTH_CIRCLE_2) / 0.14929106831550598d);
        point.y = (int) d;
        return point;
    }

    public static Point latLongToPixels(int i, int i2, int i3) {
        return latLongToPixels(((double) i2) / 3600000.0d, ((double) i) / 3600000.0d, i3);
    }

    public static DPoint pixelsToLatLong(long j, long j2, int i) {
        DPoint obtain = DPoint.obtain();
        double d = K_EARTH_CIRCLE_2 - (((double) j2) * 0.14929106831550598d);
        obtain.x = radToDeg(((((double) j) * 0.14929106831550598d) - K_EARTH_CIRCLE_2) / 6378137.0d);
        double exp = Math.exp((d / 6378137.0d) * 2.0d);
        obtain.y = radToDeg(Math.asin((exp - 1.0d) / (1.0d + exp)));
        return obtain;
    }

    private static double radToDeg(double d) {
        return d * 57.29577951308232d;
    }
}
