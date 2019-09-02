package com.autonavi.ae.gmap.glanimation;

import android.os.SystemClock;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.IPoint;

public class AdglMapAnimGroup extends AbstractAdglAnimation {
    public static final int CAMERA_MAX_DEGREE = 60;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    int endZoomDuration;
    boolean hasCheckParams;
    boolean hasMidZoom;
    int midZoomDuration;
    AbstractAdglAnimationParam2V moveParam = null;
    public boolean needMove;
    boolean needRotateCamera;
    boolean needRotateMap;
    boolean needZoom;
    AbstractAdglAnimationParam1V rotateCameraParam = null;
    AbstractAdglAnimationParam1V rotateMapParam = null;
    int startZoomDuration;
    AbstractAdglAnimationParam1V zoomEndParam = null;
    AbstractAdglAnimationParam1V zoomStartParam = null;

    public AdglMapAnimGroup(int i) {
        reset();
        this.duration = i;
    }

    public static boolean checkLevel(float f) {
        return f >= 3.0f && f <= 20.0f;
    }

    private void initZoomEndParam(float f, float f2, int i) {
        if (this.zoomEndParam == null) {
            this.zoomEndParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomEndParam.reset();
        this.zoomEndParam.setInterpolatorType(i, 1.0f);
        this.zoomEndParam.setToValue(f2);
        this.zoomEndParam.setFromValue(f);
    }

    private void initZoomStartParam(float f, int i) {
        if (this.zoomStartParam == null) {
            this.zoomStartParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomStartParam.reset();
        this.zoomStartParam.setInterpolatorType(i, 1.0f);
        this.zoomStartParam.setToValue(f);
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            float mapZoomer;
            float toValue;
            if (this.needZoom) {
                if (this.zoomStartParam == null) {
                    this.hasCheckParams = true;
                    return;
                }
                mapZoomer = gLMapState.getMapZoomer();
                this.zoomStartParam.setFromValue(mapZoomer);
                if (this.hasMidZoom) {
                    toValue = this.zoomStartParam.getToValue() - mapZoomer;
                    mapZoomer = this.zoomEndParam.getFromValue() - this.zoomEndParam.getToValue();
                    if (((double) Math.abs(toValue)) < 1.0E-6d || ((double) Math.abs(mapZoomer)) < 1.0E-6d) {
                        this.hasMidZoom = false;
                        this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
                        this.zoomStartParam.needToCaculate();
                        this.zoomEndParam = null;
                    } else {
                        this.zoomStartParam.needToCaculate();
                        this.zoomEndParam.needToCaculate();
                    }
                }
                if (!this.hasMidZoom && ((double) Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue())) < 1.0E-6d) {
                    this.needZoom = false;
                }
                if (this.needZoom) {
                    if (this.hasMidZoom) {
                        this.startZoomDuration = (this.duration - this.midZoomDuration) >> 1;
                        this.endZoomDuration = this.startZoomDuration;
                    } else {
                        this.startZoomDuration = this.duration;
                    }
                }
            }
            if (this.needMove && this.moveParam != null) {
                IPoint obtain = IPoint.obtain();
                gLMapState.getMapGeoCenter(obtain);
                int i = obtain.x;
                int i2 = obtain.y;
                obtain.recycle();
                this.moveParam.setFromValue((double) i, (double) i2);
                this.needMove = this.moveParam.needToCaculate();
            }
            if (this.needRotateMap && this.rotateMapParam != null) {
                mapZoomer = gLMapState.getMapAngle();
                toValue = this.rotateMapParam.getToValue();
                if (mapZoomer > 180.0f && toValue == 0.0f) {
                    toValue = 360.0f;
                }
                float f = (float) (((int) toValue) - ((int) mapZoomer));
                if (f > 180.0f) {
                    toValue -= 360.0f;
                } else if (f < -180.0f) {
                    toValue += 360.0f;
                }
                this.rotateMapParam.setFromValue(mapZoomer);
                this.rotateMapParam.setToValue(toValue);
                this.needRotateMap = this.rotateMapParam.needToCaculate();
            }
            if (this.needRotateCamera && this.rotateCameraParam != null) {
                this.rotateCameraParam.setFromValue(gLMapState.getCameraDegree());
                this.needRotateCamera = this.rotateCameraParam.needToCaculate();
            }
            if (this.needMove || this.needZoom || this.needRotateMap || this.needRotateCamera) {
                this.isOver = false;
            } else {
                this.isOver = true;
            }
            this.hasCheckParams = true;
            this.startTime = SystemClock.uptimeMillis();
        }
    }

    public void doAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            if (!this.hasCheckParams) {
                commitAnimation(obj);
            }
            if (!this.isOver) {
                this.offsetTime = SystemClock.uptimeMillis() - this.startTime;
                if (((float) this.duration) == 0.0f) {
                    this.isOver = true;
                    return;
                }
                float f = ((float) this.offsetTime) / ((float) this.duration);
                if (f > 1.0f) {
                    this.isOver = true;
                    f = 1.0f;
                } else if (f < 0.0f) {
                    this.isOver = true;
                    return;
                }
                if (this.needZoom) {
                    float curValue;
                    gLMapState.getMapZoomer();
                    if (this.hasMidZoom) {
                        if (this.offsetTime <= ((long) this.startZoomDuration)) {
                            this.zoomStartParam.setNormalizedTime(((float) this.offsetTime) / ((float) this.startZoomDuration));
                            curValue = this.zoomStartParam.getCurValue();
                        } else if (this.offsetTime <= ((long) (this.startZoomDuration + this.midZoomDuration))) {
                            curValue = this.zoomStartParam.getToValue();
                        } else {
                            this.zoomEndParam.setNormalizedTime(((float) ((this.offsetTime - ((long) this.startZoomDuration)) - ((long) this.midZoomDuration))) / ((float) this.endZoomDuration));
                            curValue = this.zoomEndParam.getCurValue();
                        }
                        if (this.isOver) {
                            curValue = this.zoomEndParam.getToValue();
                        }
                    } else {
                        this.zoomStartParam.setNormalizedTime(f);
                        curValue = this.zoomStartParam.getCurValue();
                    }
                    gLMapState.setMapZoomer(curValue);
                }
                if (this.moveParam != null && this.needMove) {
                    this.moveParam.setNormalizedTime(f);
                    int fromXValue = (int) this.moveParam.getFromXValue();
                    int fromYValue = (int) this.moveParam.getFromYValue();
                    int toXValue = (int) this.moveParam.getToXValue();
                    int toYValue = (int) this.moveParam.getToYValue();
                    float curMult = this.moveParam.getCurMult();
                    gLMapState.setMapGeoCenter(fromXValue + ((int) (((float) (toXValue - fromXValue)) * curMult)), fromYValue + ((int) (((float) (toYValue - fromYValue)) * curMult)));
                }
                if (this.rotateMapParam != null && this.needRotateMap) {
                    this.rotateMapParam.setNormalizedTime(f);
                    gLMapState.setMapAngle((float) ((int) this.rotateMapParam.getCurValue()));
                }
                if (this.rotateCameraParam != null && this.needRotateCamera) {
                    this.rotateCameraParam.setNormalizedTime(f);
                    gLMapState.setCameraDegree((float) ((int) this.rotateCameraParam.getCurValue()));
                }
            }
        }
    }

    public boolean isValid() {
        return this.needRotateCamera || this.needRotateMap || this.needMove || this.needZoom;
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.needZoom = false;
        this.needMove = false;
        this.moveParam = null;
        this.needRotateMap = false;
        this.rotateMapParam = null;
        this.hasMidZoom = false;
        this.duration = 0;
        if (this.rotateMapParam != null) {
            this.rotateMapParam.reset();
        }
        if (this.moveParam != null) {
            this.moveParam.reset();
        }
        if (this.zoomStartParam != null) {
            this.zoomStartParam.reset();
        }
        if (this.zoomEndParam != null) {
            this.zoomEndParam.reset();
        }
        if (this.rotateCameraParam != null) {
            this.rotateCameraParam.reset();
        }
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setToCameraDegree(float f, int i) {
        this.needRotateCamera = false;
        if (f <= 60.0f && f >= 0.0f) {
            this.needRotateCamera = true;
            if (this.rotateCameraParam == null) {
                this.rotateCameraParam = new AbstractAdglAnimationParam1V();
            }
            this.rotateCameraParam.reset();
            this.rotateCameraParam.setInterpolatorType(i, 1.0f);
            this.rotateCameraParam.setToValue(f);
        }
    }

    public void setToMapAngle(float f, int i) {
        f %= 360.0f;
        this.needRotateMap = true;
        if (this.rotateMapParam == null) {
            this.rotateMapParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateMapParam.reset();
        this.rotateMapParam.setInterpolatorType(i, 1.0f);
        this.rotateMapParam.setToValue(f);
    }

    public void setToMapCenterGeo(int i, int i2, int i3) {
        if (i > 0 && i2 > 0) {
            this.needMove = true;
            if (this.moveParam == null) {
                this.moveParam = new AbstractAdglAnimationParam2V();
            }
            this.moveParam.reset();
            this.moveParam.setInterpolatorType(i3, 1.0f);
            this.moveParam.setToValue((double) i, (double) i2);
        }
    }

    public void setToMapLevel(float f, float f2, int i) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (i > 0 && i < this.duration) {
            this.midZoomDuration = i;
        }
        if (checkLevel(f) && checkLevel(f2)) {
            this.hasMidZoom = true;
            initZoomStartParam(f2, 0);
            initZoomEndParam(f2, f, 0);
        } else if (checkLevel(f)) {
            this.hasMidZoom = false;
            initZoomStartParam(f, 0);
        } else if (checkLevel(f2)) {
            this.hasMidZoom = false;
            initZoomStartParam(f2, 0);
        } else {
            this.needZoom = false;
        }
    }

    public void setToMapLevel(float f, int i) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (checkLevel(f)) {
            initZoomStartParam(f, i);
        } else {
            this.needZoom = false;
        }
    }

    public boolean typeEqueal(AdglMapAnimGroup adglMapAnimGroup) {
        return this.needRotateCamera == adglMapAnimGroup.needRotateCamera && this.needRotateMap == adglMapAnimGroup.needRotateMap && this.needZoom == adglMapAnimGroup.needZoom && this.needMove == adglMapAnimGroup.needMove;
    }
}
