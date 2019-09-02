package com.autonavi.amap.mapcore.message;

import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;
import com.autonavi.amap.mapcore.IPoint;

public class RotateGestureMapMessage extends AbstractGestureMapMessage {
    private static final SynchronizedPool<RotateGestureMapMessage> M_POOL = new SynchronizedPool(256);
    public float angleDelta = 0.0f;
    public int pivotX = 0;
    public int pivotY = 0;

    public RotateGestureMapMessage(int i, float f, int i2, int i3) {
        super(i);
        setParams(i, f, i2, i3);
        this.angleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static RotateGestureMapMessage obtain(int i, float f, int i2, int i3) {
        RotateGestureMapMessage rotateGestureMapMessage = (RotateGestureMapMessage) M_POOL.acquire();
        if (rotateGestureMapMessage == null) {
            return new RotateGestureMapMessage(i, f, i2, i3);
        }
        rotateGestureMapMessage.reset();
        rotateGestureMapMessage.setParams(i, f, i2, i3);
        return rotateGestureMapMessage;
    }

    private void setParams(int i, float f, int i2, int i3) {
        setState(i);
        this.angleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    public int getType() {
        return 2;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        float mapAngle = gLMapState.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter) {
            gLMapState.setMapAngle(mapAngle);
            gLMapState.recalculate();
            return;
        }
        IPoint obtain;
        int i = this.pivotX;
        int i2 = this.pivotY;
        if (this.isUseAnchor) {
            i = this.anchorX;
            i2 = this.anchorY;
        }
        IPoint iPoint = null;
        if (i > 0 || i2 > 0) {
            iPoint = IPoint.obtain();
            obtain = IPoint.obtain();
            win2geo(gLMapState, i, i2, iPoint);
            gLMapState.setMapGeoCenter(iPoint.x, iPoint.y);
            IPoint iPoint2 = obtain;
            obtain = iPoint;
            iPoint = iPoint2;
        } else {
            obtain = null;
        }
        gLMapState.setMapAngle(mapAngle);
        gLMapState.recalculate();
        if (i > 0 || i2 > 0) {
            win2geo(gLMapState, i, i2, iPoint);
            if (obtain != null) {
                gLMapState.setMapGeoCenter((obtain.x * 2) - iPoint.x, (2 * obtain.y) - iPoint.y);
            }
            gLMapState.recalculate();
        }
        if (obtain != null) {
            obtain.recycle();
        }
        if (iPoint != null) {
            iPoint.recycle();
        }
    }
}
