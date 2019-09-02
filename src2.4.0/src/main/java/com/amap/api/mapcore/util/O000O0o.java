package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.CoordUtil;
import com.autonavi.amap.mapcore.DPoint;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: OffsetUtil */
public class O000O0o {
    static double O000000o = 3.141592653589793d;
    public static double O00000Oo = 6378245.0d;
    private static boolean O00000o = false;
    public static double O00000o0 = 0.006693421622965943d;
    private static final double[] O00000oO = new double[]{25.575374d, 120.391111d};
    private static final double[] O00000oo = new double[]{21.405235d, 121.649046d};
    private static final List<LatLng> O0000O0o = new ArrayList(Arrays.asList(new LatLng[]{new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)}));

    private static double O000000o(double d) {
        return Math.sin((d * 3000.0d) * (O000000o / 180.0d)) * 2.0E-5d;
    }

    public static double O000000o(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static double O000000o(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    public static LatLng O000000o(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!OOOO0O.O000000o(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        String O000000o = o0OOoOO0.O000000o(context, "libwgs2gcj.so");
        if (!(TextUtils.isEmpty(O000000o) || !new File(O000000o).exists() || O00000o)) {
            try {
                System.load(O000000o);
                O00000o = true;
            } catch (Throwable th) {
                o0OOoOO0.O000000o(context, th);
            }
        }
        DPoint O000000o2 = O000000o(DPoint.obtain(latLng.longitude, latLng.latitude), O00000o);
        LatLng latLng2 = new LatLng(O000000o2.y, O000000o2.x, false);
        O000000o2.recycle();
        return latLng2;
    }

    public static LatLng O000000o(LatLng latLng) {
        if (latLng != null) {
            try {
                DPoint O000000o;
                if (OOOO0O.O000000o(latLng.latitude, latLng.longitude)) {
                    O000000o = O000000o(latLng.longitude, latLng.latitude, 2);
                    LatLng latLng2 = new LatLng(O000000o.y, O000000o.x, false);
                    O000000o.recycle();
                    return latLng2;
                } else if (!O00000o0(latLng.latitude, latLng.longitude)) {
                    return latLng;
                } else {
                    O000000o = O000000o(latLng.longitude, latLng.latitude, 2);
                    return O0000OOo(O000000o.y, O000000o.x);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static DPoint O000000o(double d, double d2, double d3, double d4) {
        DPoint obtain = DPoint.obtain();
        d3 = d - d3;
        d4 = d2 - d4;
        DPoint O0000O0o = O0000O0o(d3, d4);
        obtain.x = O000000o((d + d3) - O0000O0o.x, 8);
        obtain.y = O000000o((d2 + d4) - O0000O0o.y, 8);
        return obtain;
    }

    private static DPoint O000000o(double d, double d2, int i) {
        DPoint dPoint = null;
        double d3 = 0.006401062d;
        double d4 = 0.0060424805d;
        int i2 = i;
        for (int i3 = 0; i3 < i2; i3++) {
            dPoint = O000000o(d, d2, d3, d4);
            d3 = d - dPoint.x;
            d4 = d2 - dPoint.y;
        }
        return dPoint;
    }

    private static DPoint O000000o(DPoint dPoint, boolean z) {
        double[] dArr;
        try {
            if (!OOOO0O.O000000o(dPoint.y, dPoint.x)) {
                return dPoint;
            }
            dArr = new double[2];
            if (z) {
                if (CoordUtil.convertToGcj(new double[]{dPoint.x, dPoint.y}, dArr) != 0) {
                    dArr = as.O000000o(dPoint.x, dPoint.y);
                }
            } else {
                dArr = as.O000000o(dPoint.x, dPoint.y);
            }
            dPoint.recycle();
            return DPoint.obtain(dArr[0], dArr[1]);
        } catch (Throwable unused) {
            return dPoint;
        }
    }

    private static double O00000Oo(double d) {
        return Math.cos((d * 3000.0d) * (O000000o / 180.0d)) * 3.0E-6d;
    }

    public static double O00000Oo(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static LatLng O00000Oo(Context context, LatLng latLng) {
        try {
            if (!OOOO0O.O000000o(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            DPoint O00000oo = O00000oo(latLng.longitude, latLng.latitude);
            LatLng O000000o = O000000o(context, new LatLng(O00000oo.y, O00000oo.x, false));
            O00000oo.recycle();
            return O000000o;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    public static double O00000o(double d, double d2) {
        double d3 = 2.0d * d;
        return (((((((-100.0d + d3) + (3.0d * d2)) + ((0.2d * d2) * d2)) + ((0.1d * d) * d2)) + (0.2d * Math.sqrt(Math.abs(d)))) + ((((Math.sin((6.0d * d) * O000000o) * 20.0d) + (Math.sin(d3 * O000000o) * 20.0d)) * 2.0d) / 3.0d)) + ((((20.0d * Math.sin(O000000o * d2)) + (40.0d * Math.sin((d2 / 3.0d) * O000000o))) * 2.0d) / 3.0d)) + ((((160.0d * Math.sin((d2 / 12.0d) * O000000o)) + (320.0d * Math.sin((d2 * O000000o) / 30.0d))) * 2.0d) / 3.0d);
    }

    public static boolean O00000o0(double d, double d2) {
        return OOo000.O000000o(new LatLng(d, d2), O0000O0o);
    }

    public static double O00000oO(double d, double d2) {
        double d3 = 0.1d * d;
        return (((((((300.0d + d) + (2.0d * d2)) + (d3 * d)) + (d3 * d2)) + (0.1d * Math.sqrt(Math.abs(d)))) + ((((Math.sin((6.0d * d) * O000000o) * 20.0d) + (Math.sin((2.0d * d) * O000000o) * 20.0d)) * 2.0d) / 3.0d)) + ((((20.0d * Math.sin(O000000o * d)) + (40.0d * Math.sin((d / 3.0d) * O000000o))) * 2.0d) / 3.0d)) + ((((150.0d * Math.sin((d / 12.0d) * O000000o)) + (300.0d * Math.sin((d / 30.0d) * O000000o))) * 2.0d) / 3.0d);
    }

    private static DPoint O00000oo(double d, double d2) {
        d = (double) (((long) (d * 100000.0d)) % 36000000);
        d2 = (double) (((long) (d2 * 100000.0d)) % 36000000);
        double d3 = (double) ((int) ((-O00000Oo(d, d2)) + d2));
        double d4 = (-O000000o((double) ((int) ((-O000000o(d, d2)) + d)), d3)) + d;
        int i = (d > 0.0d ? 1 : (d == 0.0d ? 0 : -1));
        int i2 = -1;
        d4 = (double) ((int) (d4 + ((double) (i > 0 ? 1 : -1))));
        d3 = (-O00000Oo(d4, d3)) + d2;
        if (d2 > 0.0d) {
            i2 = 1;
        }
        return DPoint.obtain(d4 / 100000.0d, ((double) ((int) (d3 + ((double) i2)))) / 100000.0d);
    }

    private static DPoint O0000O0o(double d, double d2) {
        DPoint obtain = DPoint.obtain();
        double d3 = (d * d) + (d2 * d2);
        double cos = (Math.cos(O00000Oo(d) + Math.atan2(d2, d)) * (O000000o(d2) + Math.sqrt(d3))) + 0.0065d;
        d = (Math.sin(O00000Oo(d) + Math.atan2(d2, d)) * (O000000o(d2) + Math.sqrt(d3))) + 0.006d;
        obtain.x = O000000o(cos, 8);
        obtain.y = O000000o(d, 8);
        return obtain;
    }

    private static LatLng O0000OOo(double d, double d2) {
        LatLng O0000Oo0 = O0000Oo0(d, d2);
        return new LatLng((d * 2.0d) - O0000Oo0.latitude, (d2 * 2.0d) - O0000Oo0.longitude);
    }

    private static LatLng O0000Oo0(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double O00000o = O00000o(d3, d4);
        d3 = O00000oO(d3, d4);
        double d5 = (d / 180.0d) * O000000o;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((O00000o0 * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new LatLng(d + ((O00000o * 180.0d) / (((O00000Oo * (1.0d - O00000o0)) / (d6 * sqrt)) * O000000o)), d2 + ((d3 * 180.0d) / (((O00000Oo / sqrt) * Math.cos(d5)) * O000000o)));
    }
}
