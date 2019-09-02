package com.autonavi.amap.mapcore.message;

import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;
import com.autonavi.amap.mapcore.IPoint;

public class ScaleGestureMapMessage extends AbstractGestureMapMessage {
    private static final SynchronizedPool<ScaleGestureMapMessage> M_POOL = new SynchronizedPool(256);
    public int pivotX = 0;
    public int pivotY = 0;
    public float scaleDelta = 0.0f;

    public ScaleGestureMapMessage(int i, float f, int i2, int i3) {
        super(i);
        setParams(i, f, i2, i3);
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static ScaleGestureMapMessage obtain(int i, float f, int i2, int i3) {
        ScaleGestureMapMessage scaleGestureMapMessage = (ScaleGestureMapMessage) M_POOL.acquire();
        if (scaleGestureMapMessage == null) {
            return new ScaleGestureMapMessage(i, f, i2, i3);
        }
        scaleGestureMapMessage.reset();
        scaleGestureMapMessage.setParams(i, f, i2, i3);
        return scaleGestureMapMessage;
    }

    private void setMapZoomer(GLMapState gLMapState) {
        gLMapState.setMapZoomer(gLMapState.getMapZoomer() + this.scaleDelta);
        gLMapState.recalculate();
    }

    private void setParams(int i, float f, int i2, int i3) {
        setState(i);
        this.scaleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    public int getType() {
        return 1;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        if (this.isUseAnchor) {
            setMapZoomer(gLMapState);
            return;
        }
        IPoint obtain;
        int i = this.pivotX;
        int i2 = this.pivotY;
        if (this.isGestureScaleByMapCenter) {
            i = this.width >> 1;
            i2 = this.height >> 1;
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
        setMapZoomer(gLMapState);
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
