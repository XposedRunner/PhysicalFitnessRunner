package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: AbstractCameraScrollMessage */
public class O000O00o extends AbstractCameraUpdateMessage {
    public void O000000o(GLMapState gLMapState, int i, int i2, Point point) {
        gLMapState.screenToP20Point(i, i2, point);
    }

    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        float f = this.xPixel;
        float f2 = (((float) this.width) / 2.0f) + f;
        f = (((float) this.height) / 2.0f) + this.yPixel;
        Point point = new Point();
        O000000o(gLMapState, (int) f2, (int) f, point);
        gLMapState.setMapGeoCenter(point.x, point.y);
    }
}
