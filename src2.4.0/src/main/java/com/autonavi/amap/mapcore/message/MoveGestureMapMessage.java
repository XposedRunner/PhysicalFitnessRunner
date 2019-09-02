package com.autonavi.amap.mapcore.message;

import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;
import com.autonavi.amap.mapcore.IPoint;

public class MoveGestureMapMessage extends AbstractGestureMapMessage {
    private static final SynchronizedPool<MoveGestureMapMessage> M_POOL = new SynchronizedPool(1024);
    static int newCount;
    public float touchDeltaX = 0.0f;
    public float touchDeltaY = 0.0f;

    public MoveGestureMapMessage(int i, float f, float f2) {
        super(i);
        this.touchDeltaX = f;
        this.touchDeltaY = f2;
        newCount++;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static synchronized MoveGestureMapMessage obtain(int i, float f, float f2) {
        MoveGestureMapMessage moveGestureMapMessage;
        synchronized (MoveGestureMapMessage.class) {
            moveGestureMapMessage = (MoveGestureMapMessage) M_POOL.acquire();
            if (moveGestureMapMessage == null) {
                moveGestureMapMessage = new MoveGestureMapMessage(i, f, f2);
            } else {
                moveGestureMapMessage.reset();
                moveGestureMapMessage.setParams(i, f, f2);
            }
        }
        return moveGestureMapMessage;
    }

    private void setParams(int i, float f, float f2) {
        setState(i);
        this.touchDeltaX = f;
        this.touchDeltaY = f2;
    }

    public int getType() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        int i = (int) this.touchDeltaX;
        int i2 = (int) this.touchDeltaY;
        float f = (float) (this.width >> 1);
        float f2 = (float) (this.height >> 1);
        if (this.isUseAnchor) {
            f = (float) this.anchorX;
            f2 = (float) this.anchorY;
        }
        i = (int) (f - ((float) i));
        i2 = (int) (f2 - ((float) i2));
        IPoint obtain = IPoint.obtain();
        win2geo(gLMapState, i, i2, obtain);
        gLMapState.setMapGeoCenter(obtain.x, obtain.y);
        gLMapState.recalculate();
        obtain.recycle();
    }
}
