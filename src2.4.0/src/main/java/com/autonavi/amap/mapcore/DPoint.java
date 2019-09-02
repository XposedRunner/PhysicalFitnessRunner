package com.autonavi.amap.mapcore;

import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;

public class DPoint {
    private static final SynchronizedPool<DPoint> M_POOL = new SynchronizedPool(32);
    public double x;
    public double y;

    public DPoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public static DPoint obtain() {
        DPoint dPoint = (DPoint) M_POOL.acquire();
        if (dPoint == null) {
            return new DPoint();
        }
        dPoint.set(0.0d, 0.0d);
        return dPoint;
    }

    public static DPoint obtain(double d, double d2) {
        DPoint dPoint = (DPoint) M_POOL.acquire();
        if (dPoint == null) {
            return new DPoint(d, d2);
        }
        dPoint.set(d, d2);
        return dPoint;
    }

    private void set(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public void recycle() {
        M_POOL.release(this);
    }
}
