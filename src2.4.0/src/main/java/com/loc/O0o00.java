package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.CoordUtil;
import com.amap.api.location.DPoint;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: OffsetUtil */
public final class O0o00 {
    static double O000000o = 3.141592653589793d;
    private static final List<DPoint> O00000Oo = new ArrayList(Arrays.asList(new DPoint[]{new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)}));

    private static double O000000o(double d) {
        return Math.sin((d * 3000.0d) * (O000000o / 180.0d)) * 2.0E-5d;
    }

    private static double O000000o(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint O000000o(Context context, double d, double d2) {
        return context == null ? null : O000000o(context, new DPoint(d2, d));
    }

    public static DPoint O000000o(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        String O000000o = OO0Oo00.O000000o(context, "libwgs2gcj.so");
        if (!(TextUtils.isEmpty(O000000o) || !new File(O000000o).exists() || CoordUtil.isLoadedSo())) {
            try {
                System.load(O000000o);
                CoordUtil.setLoadedSo(true);
            } catch (Throwable unused) {
            }
        }
        return O000000o(dPoint, CoordUtil.isLoadedSo());
        O0o0000.O000000o(th, "OffsetUtil", "offset");
        return O000000o(dPoint, CoordUtil.isLoadedSo());
    }

    public static DPoint O000000o(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (O0o0000.O000000o(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return O00000Oo(dPoint);
                }
                if (!O0o0000.O000000o(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), O00000Oo)) {
                    return dPoint;
                }
                DPoint O00000Oo = O00000Oo(dPoint);
                double latitude = O00000Oo.getLatitude();
                double longitude = O00000Oo.getLongitude();
                double d = longitude - 105.0d;
                double d2 = latitude - 35.0d;
                double d3 = 2.0d * d;
                double d4 = 0.1d * d;
                double d5 = d4 * d2;
                double d6 = 6.0d * d;
                double d7 = longitude;
                double sqrt = (((((((-100.0d + d3) + (3.0d * d2)) + ((0.2d * d2) * d2)) + d5) + (0.2d * Math.sqrt(Math.abs(d)))) + ((((Math.sin(d6 * O000000o) * 20.0d) + (Math.sin(d3 * O000000o) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(O000000o * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * O000000o) * 40.0d)) * 2.0d) / 3.0d)) + ((((160.0d * Math.sin((d2 / 12.0d) * O000000o)) + (Math.sin((O000000o * d2) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
                double sqrt2 = (((((((300.0d + d) + (d2 * 2.0d)) + (d4 * d)) + d5) + (0.1d * Math.sqrt(Math.abs(d)))) + ((((Math.sin(d6 * O000000o) * 20.0d) + (Math.sin(O000000o * d3) * 20.0d)) * 2.0d) / 3.0d)) + ((((20.0d * Math.sin(O000000o * d)) + (40.0d * Math.sin((d / 3.0d) * O000000o))) * 2.0d) / 3.0d)) + ((((150.0d * Math.sin((d / 12.0d) * O000000o)) + (300.0d * Math.sin((d / 30.0d) * O000000o))) * 2.0d) / 3.0d);
                longitude = (latitude / 180.0d) * O000000o;
                d = Math.sin(longitude);
                d2 = 1.0d - ((0.006693421622965943d * d) * d);
                d = Math.sqrt(d2);
                DPoint dPoint2 = new DPoint(((sqrt * 180.0d) / ((6335552.717000426d / (d2 * d)) * O000000o)) + latitude, d7 + ((sqrt2 * 180.0d) / (((6378245.0d / d) * Math.cos(longitude)) * O000000o)));
                return new DPoint((latitude * 2.0d) - dPoint2.getLatitude(), (d7 * 2.0d) - dPoint2.getLongitude());
            } catch (Throwable th) {
                O0o0000.O000000o(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    private static DPoint O000000o(DPoint dPoint, boolean z) {
        try {
            if (!O0o0000.O000000o(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double longitude;
            double latitude;
            double[] dArr = new double[2];
            if (z) {
                try {
                    if (CoordUtil.convertToGcj(new double[]{dPoint.getLongitude(), dPoint.getLatitude()}, dArr) != 0) {
                        longitude = dPoint.getLongitude();
                        latitude = dPoint.getLatitude();
                    }
                } catch (Throwable th) {
                    O0o0000.O000000o(th, "OffsetUtil", "cover part1");
                    longitude = dPoint.getLongitude();
                    latitude = dPoint.getLatitude();
                }
                return new DPoint(dArr[1], dArr[0]);
            }
            longitude = dPoint.getLongitude();
            latitude = dPoint.getLatitude();
            dArr = OO000o0.O000000o(longitude, latitude);
            return new DPoint(dArr[1], dArr[0]);
        } catch (Throwable th2) {
            O0o0000.O000000o(th2, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static double O00000Oo(double d) {
        return Math.cos((d * 3000.0d) * (O000000o / 180.0d)) * 3.0E-6d;
    }

    private static double O00000Oo(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint O00000Oo(Context context, DPoint dPoint) {
        try {
            if (!O0o0000.O000000o(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double longitude = (double) (((long) (dPoint.getLongitude() * 100000.0d)) % 36000000);
            double latitude = (double) (((long) (dPoint.getLatitude() * 100000.0d)) % 36000000);
            double d = (double) ((int) ((-O00000Oo(longitude, latitude)) + latitude));
            double d2 = (-O000000o((double) ((int) ((-O000000o(longitude, latitude)) + longitude)), d)) + longitude;
            int i = (longitude > 0.0d ? 1 : (longitude == 0.0d ? 0 : -1));
            int i2 = -1;
            d2 = (double) ((int) (d2 + ((double) (i > 0 ? 1 : -1))));
            d = (-O00000Oo(d2, d)) + latitude;
            if (latitude > 0.0d) {
                i2 = 1;
            }
            return O000000o(context, new DPoint(((double) ((int) (d + ((double) i2)))) / 100000.0d, d2 / 100000.0d));
        } catch (Throwable th) {
            O0o0000.O000000o(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static DPoint O00000Oo(DPoint dPoint) {
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        DPoint dPoint2 = null;
        for (int i = 0; i < 2; i++) {
            double longitude = dPoint.getLongitude();
            double latitude = dPoint.getLatitude();
            dPoint2 = new DPoint();
            d = longitude - d;
            d2 = latitude - d2;
            DPoint dPoint3 = new DPoint();
            double d3 = latitude;
            latitude = (d * d) + (d2 * d2);
            double sin = (Math.sin(O00000Oo(d) + Math.atan2(d2, d)) * (O000000o(d2) + Math.sqrt(latitude))) + 0.006d;
            dPoint3.setLongitude(O00000o0((Math.cos(O00000Oo(d) + Math.atan2(d2, d)) * (O000000o(d2) + Math.sqrt(latitude))) + 0.0065d));
            dPoint3.setLatitude(O00000o0(sin));
            dPoint2.setLongitude(O00000o0((longitude + d) - dPoint3.getLongitude()));
            dPoint2.setLatitude(O00000o0((d3 + d2) - dPoint3.getLatitude()));
            d = dPoint.getLongitude() - dPoint2.getLongitude();
            d2 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }

    private static double O00000o0(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }
}
