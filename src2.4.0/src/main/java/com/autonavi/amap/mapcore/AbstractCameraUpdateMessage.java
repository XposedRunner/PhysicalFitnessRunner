package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.ae.gmap.GLMapEngine;
import com.autonavi.ae.gmap.GLMapState;

public abstract class AbstractCameraUpdateMessage {
    public float amount;
    public int anchorX;
    public int anchorY;
    public float bearing = Float.NaN;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public Point focus = null;
    public Point geoPoint;
    public int height;
    public boolean isChangeFinished;
    public boolean isUseAnchor = false;
    public CancelableCallback mCallback;
    public long mDuration = 250;
    public MapConfig mapConfig;
    public Type nowType = Type.none;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public float tilt = Float.NaN;
    public int width;
    public float xPixel;
    public float yPixel;
    public float zoom = Float.NaN;

    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    /* Access modifiers changed, original: protected */
    public void changeCenterByAnchor(GLMapState gLMapState, Point point) {
        changeCenterByAnchor(gLMapState, point, this.anchorX, this.anchorY);
    }

    /* Access modifiers changed, original: protected */
    public void changeCenterByAnchor(GLMapState gLMapState, Point point, int i, int i2) {
        gLMapState.recalculate();
        Point anchorGeoPoint = getAnchorGeoPoint(gLMapState, i, i2);
        Point mapGeoCenter = gLMapState.getMapGeoCenter();
        gLMapState.setMapGeoCenter((mapGeoCenter.x + point.x) - anchorGeoPoint.x, (mapGeoCenter.y + point.y) - anchorGeoPoint.y);
    }

    public void generateMapAnimation(GLMapEngine gLMapEngine) {
        GLMapState newMapState = gLMapEngine.getNewMapState(1);
        runCameraUpdate(newMapState);
        Point mapGeoCenter = newMapState.getMapGeoCenter();
        gLMapEngine.addGroupAnimation(1, (int) this.mDuration, newMapState.getMapZoomer(), (int) newMapState.getMapAngle(), (int) newMapState.getCameraDegree(), mapGeoCenter.x, mapGeoCenter.y, this.mCallback);
        newMapState.recycle();
    }

    /* Access modifiers changed, original: protected */
    public Point getAnchorGeoPoint(GLMapState gLMapState, int i, int i2) {
        Point point = new Point();
        gLMapState.screenToP20Point(i, i2, point);
        return point;
    }

    public abstract void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage);

    /* Access modifiers changed, original: protected */
    public void normalChange(GLMapState gLMapState) {
        this.zoom = Float.isNaN(this.zoom) ? gLMapState.getMapZoomer() : this.zoom;
        this.bearing = Float.isNaN(this.bearing) ? gLMapState.getMapAngle() : this.bearing;
        this.tilt = Float.isNaN(this.tilt) ? gLMapState.getCameraDegree() : this.tilt;
        this.zoom = OOo000.O000000o(this.mapConfig, this.zoom);
        this.tilt = OOo000.O000000o(this.tilt, this.zoom);
        this.bearing = (float) (((((double) this.bearing) % 360.0d) + 360.0d) % 360.0d);
        if (this.focus != null && this.geoPoint == null) {
            this.geoPoint = getAnchorGeoPoint(gLMapState, this.focus.x, this.focus.y);
        }
        if (!Float.isNaN(this.zoom)) {
            gLMapState.setMapZoomer(this.zoom);
        }
        if (!Float.isNaN(this.bearing)) {
            gLMapState.setMapAngle(this.bearing);
        }
        if (!Float.isNaN(this.tilt)) {
            gLMapState.setCameraDegree(this.tilt);
        }
        if (this.focus != null) {
            changeCenterByAnchor(gLMapState, this.geoPoint, this.focus.x, this.focus.y);
            return;
        }
        Object obj = (this.geoPoint == null || (this.geoPoint.x == 0 && this.geoPoint.y == 0)) ? null : 1;
        if (obj != null) {
            gLMapState.setMapGeoCenter(this.geoPoint.x, this.geoPoint.y);
        }
    }

    public abstract void runCameraUpdate(GLMapState gLMapState);
}
