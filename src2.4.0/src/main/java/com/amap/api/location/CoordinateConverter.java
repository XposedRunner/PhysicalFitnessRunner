package com.amap.api.location;

import android.content.Context;
import com.loc.O0o00;
import com.loc.O0o0000;
import com.loc.OO000OO;

public class CoordinateConverter {
    DPoint a = null;
    private Context b;
    private CoordType c = null;
    private DPoint d = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.b = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return OO000OO.O000000o(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return O0o0000.O000000o(d, d2);
    }

    public synchronized DPoint convert() throws Exception {
        if (this.c == null) {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        } else if (this.d == null) {
            throw new IllegalArgumentException("转换坐标源不能为空");
        } else {
            if (this.d.getLongitude() <= 180.0d) {
                if (this.d.getLongitude() >= -180.0d) {
                    if (this.d.getLatitude() <= 90.0d) {
                        if (this.d.getLatitude() >= -90.0d) {
                            DPoint O000000o;
                            switch (this.c) {
                                case BAIDU:
                                    O000000o = O0o00.O000000o(this.d);
                                    break;
                                case MAPBAR:
                                    O000000o = O0o00.O00000Oo(this.b, this.d);
                                    break;
                                case MAPABC:
                                case SOSOMAP:
                                case ALIYUN:
                                case GOOGLE:
                                    O000000o = this.d;
                                    break;
                                case GPS:
                                    O000000o = O0o00.O000000o(this.b, this.d);
                                    break;
                                default:
                                    break;
                            }
                            this.a = O000000o;
                        }
                    }
                    throw new IllegalArgumentException("请传入合理纬度");
                }
            }
            throw new IllegalArgumentException("请传入合理经度");
        }
        return this.a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        if (dPoint == null) {
            try {
                throw new IllegalArgumentException("传入经纬度对象为空");
            } catch (Throwable th) {
            }
        } else {
            if (dPoint.getLongitude() <= 180.0d) {
                if (dPoint.getLongitude() >= -180.0d) {
                    if (dPoint.getLatitude() <= 90.0d) {
                        if (dPoint.getLatitude() >= -90.0d) {
                            this.d = dPoint;
                        }
                    }
                    throw new IllegalArgumentException("请传入合理纬度");
                }
            }
            throw new IllegalArgumentException("请传入合理经度");
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.c = coordType;
        return this;
    }
}
