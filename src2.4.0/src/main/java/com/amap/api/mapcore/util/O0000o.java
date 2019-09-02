package com.amap.api.mapcore.util;

import android.util.Pair;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: AbstractCameraBoundsMessage */
public class O0000o extends AbstractCameraUpdateMessage {
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        Pair O000000o = OOo000.O000000o((AbstractCameraUpdateMessage) this, gLMapState, this.mapConfig);
        if (O000000o != null) {
            gLMapState.setMapZoomer(((Float) O000000o.first).floatValue());
            gLMapState.setMapGeoCenter(((IPoint) O000000o.second).x, ((IPoint) O000000o.second).y);
            gLMapState.setCameraDegree(0.0f);
            gLMapState.setMapAngle(0.0f);
        }
    }
}
