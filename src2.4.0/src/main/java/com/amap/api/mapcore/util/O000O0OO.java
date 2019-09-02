package com.amap.api.mapcore.util;

import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: AbstractCameraZoomMessage */
public class O000O0OO extends AbstractCameraUpdateMessage {
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.zoom += this.amount;
    }

    public void runCameraUpdate(GLMapState gLMapState) {
        this.zoom = gLMapState.getMapZoomer() + this.amount;
        this.zoom = OOo000.O000000o(this.mapConfig, this.zoom);
        normalChange(gLMapState);
    }
}
