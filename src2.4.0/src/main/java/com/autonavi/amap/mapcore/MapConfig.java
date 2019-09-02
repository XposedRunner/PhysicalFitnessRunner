package com.autonavi.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import java.util.concurrent.atomic.AtomicInteger;

public class MapConfig implements Cloneable {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private int anchorX = 0;
    private int anchorY = 0;
    private volatile double changeGridRatio = 1.0d;
    private volatile double changeRatio = 1.0d;
    private AtomicInteger changedCounter = new AtomicInteger(0);
    private int customBackgroundColor = -1;
    private String customTextureResourcePath;
    private Rectangle geoRectangle = new Rectangle();
    private int gridX = 0;
    private int gridY = 0;
    private boolean isBearingChanged = false;
    private boolean isBuildingEnable = true;
    private boolean isCenterChanged = false;
    private boolean isCustomStyleEnabled = false;
    private boolean isHideLogoEnable = true;
    private boolean isIndoorEnable = false;
    private boolean isMapTextEnable = true;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isProFunctionAuthEnable = true;
    private boolean isSetLimitZoomLevel;
    private boolean isTiltChanged = false;
    private boolean isTrafficEnabled = false;
    private boolean isUseProFunction = false;
    private boolean isWorldMapEnable = false;
    private boolean isZoomChanged = false;
    MapConfig lastMapconfig = null;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private String mCustomStyleID;
    private String mCustomStylePath;
    private String mMapLanguage = "zh_cn";
    private int mMapStyleMode = 0;
    private int mMapStyleState = 0;
    private int mMapStyleTime = 0;
    private IPoint mapGeoCenter = new IPoint(this.sX, this.sY);
    private int mapHeight;
    private float mapPerPixelUnitLength;
    private FPoint[] mapRect = null;
    private int mapWidth;
    private float mapZoomScale = 1.0f;
    public float maxZoomLevel = 20.0f;
    public float minZoomLevel = 3.0f;
    float[] mvpMatrix = new float[16];
    float[] projectionMatrix = new float[16];
    private float sC = 0.0f;
    private float sR = 0.0f;
    private int sX = 221010267;
    private int sY = 101697799;
    private float sZ = 10.0f;
    private float skyHeight;
    int[] tilsIDs = new int[100];
    float[] viewMatrix = new float[16];

    public MapConfig(boolean z) {
        if (z) {
            this.lastMapconfig = new MapConfig(false);
            this.lastMapconfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(0);
            this.lastMapconfig.setSY(0);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }

    private void changeRatio() {
        int sx = this.lastMapconfig.getSX();
        int sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = (double) (Math.abs(this.sX - sx) + Math.abs(this.sY - sy));
        double d = 1.0d;
        this.changeRatio = this.changeRatio == 0.0d ? 1.0d : this.changeRatio * 2.0d;
        this.changeRatio *= sz == this.sZ ? 1.0d : (double) Math.abs(sz - this.sZ);
        float f = 1.0f;
        sz = sc == this.sC ? 1.0f : Math.abs(sc - this.sC);
        if (sr != this.sR) {
            f = Math.abs(sr - this.sR);
        }
        double d2 = (double) sz;
        this.changeRatio *= d2;
        double d3 = (double) f;
        this.changeRatio *= d3;
        this.changeGridRatio = (double) (Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY));
        if (this.changeGridRatio != 0.0d) {
            d = this.changeGridRatio * 2.0d;
        }
        this.changeGridRatio = d;
        this.changeGridRatio *= d2;
        this.changeGridRatio *= d3;
    }

    public int getAnchorX() {
        return this.anchorX;
    }

    public int getAnchorY() {
        return this.anchorY;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public int[] getCurTileIds() {
        return this.tilsIDs;
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    /* Access modifiers changed, original: protected */
    public int getGridX() {
        return this.gridX;
    }

    /* Access modifiers changed, original: protected */
    public int getGridY() {
        return this.gridY;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public IPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    public int getMapHeight() {
        return this.mapHeight;
    }

    public String getMapLanguage() {
        return this.mMapLanguage;
    }

    public float getMapPerPixelUnitLength() {
        return this.mapPerPixelUnitLength;
    }

    public FPoint[] getMapRect() {
        return this.mapRect;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public int getMapStyleState() {
        return this.mMapStyleState;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    public int getMapWidth() {
        return this.mapWidth;
    }

    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float getSC() {
        return this.sC;
    }

    public float getSR() {
        return this.sR;
    }

    public int getSX() {
        return this.sX;
    }

    public int getSY() {
        return this.sY;
    }

    public float getSZ() {
        return this.sZ;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapStateChange() {
        boolean z;
        if (this.lastMapconfig != null) {
            int sx = this.lastMapconfig.getSX();
            int sy = this.lastMapconfig.getSY();
            float sz = this.lastMapconfig.getSZ();
            float sc = this.lastMapconfig.getSC();
            float sr = this.lastMapconfig.getSR();
            this.isCenterChanged = sx != this.sX;
            this.isCenterChanged = sy != this.sY ? true : this.isCenterChanged;
            this.isZoomChanged = sz != this.sZ;
            if (this.isZoomChanged) {
                if (sz <= this.minZoomLevel || this.sZ <= this.minZoomLevel || sz >= this.maxZoomLevel || this.sZ >= this.maxZoomLevel) {
                    this.isNeedUpdateZoomControllerState = true;
                } else {
                    this.isNeedUpdateZoomControllerState = false;
                }
            }
            this.isTiltChanged = sc != this.sC;
            this.isBearingChanged = sr != this.sR;
            z = this.isCenterChanged || this.isZoomChanged || this.isTiltChanged || this.isBearingChanged || this.isNeedUpdateMapRectNextFrame;
            if (z) {
                this.isNeedUpdateMapRectNextFrame = false;
                this.changedCounter.incrementAndGet();
                int i = (20 - ((int) this.sZ)) + 8;
                setGridXY(this.sX >> i, this.sY >> i);
                changeRatio();
            }
        } else {
            z = false;
        }
        return (this.sC < ((float) 45) || this.skyHeight != 0.0f) ? z : true;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    public void setAnchorX(int i) {
        this.anchorX = i;
    }

    public void setAnchorY(int i) {
        this.anchorY = i;
    }

    public void setBuildingEnable(boolean z) {
        this.isBuildingEnable = z;
    }

    public void setCustomBackgroundColor(int i) {
        this.customBackgroundColor = i;
    }

    public void setCustomStyleEnable(boolean z) {
        this.isCustomStyleEnabled = z;
    }

    public void setCustomStyleID(String str) {
        this.mCustomStyleID = str;
    }

    public void setCustomStylePath(String str) {
        this.mCustomStylePath = str;
    }

    public void setCustomTextureResourcePath(String str) {
        this.customTextureResourcePath = str;
    }

    /* Access modifiers changed, original: protected */
    public void setGridXY(int i, int i2) {
        if (this.lastMapconfig != null) {
            this.lastMapconfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i;
        this.gridY = i2;
    }

    public void setHideLogoEnble(boolean z) {
        this.isHideLogoEnable = z;
    }

    public void setIndoorEnable(boolean z) {
        this.isIndoorEnable = z;
    }

    public void setLimitIPoints(IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public void setLimitLatLngBounds(LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            resetMinMaxZoomPreference();
        }
    }

    public void setMapHeight(int i) {
        this.mapHeight = i;
    }

    public void setMapLanguage(String str) {
        this.mMapLanguage = str;
    }

    public void setMapPerPixelUnitLength(float f) {
        this.mapPerPixelUnitLength = f;
    }

    public void setMapRect(FPoint[] fPointArr) {
        if (this.lastMapconfig != null) {
            this.lastMapconfig.setMapRect(fPointArr);
        }
        this.mapRect = fPointArr;
    }

    public void setMapStyleMode(int i) {
        this.mMapStyleMode = i;
    }

    public void setMapStyleState(int i) {
        this.mMapStyleState = i;
    }

    public void setMapStyleTime(int i) {
        this.mMapStyleTime = i;
    }

    public void setMapTextEnable(boolean z) {
        this.isMapTextEnable = z;
    }

    public void setMapWidth(int i) {
        this.mapWidth = i;
    }

    public void setMapZoomScale(float f) {
        this.mapZoomScale = f;
    }

    public void setMaxZoomLevel(float f) {
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 3.0f) {
            f = 3.0f;
        }
        if (f < getMinZoomLevel()) {
            f = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f;
    }

    public void setMinZoomLevel(float f) {
        if (f < 3.0f) {
            f = 3.0f;
        }
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f > getMaxZoomLevel()) {
            f = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f;
    }

    public void setProFunctionAuthEnable(boolean z) {
        this.isProFunctionAuthEnable = z;
    }

    public void setSC(float f) {
        if (this.lastMapconfig != null) {
            this.lastMapconfig.setSC(this.sC);
        }
        this.sC = f;
    }

    public void setSR(float f) {
        if (this.lastMapconfig != null) {
            this.lastMapconfig.setSR(this.sR);
        }
        this.sR = f;
    }

    public void setSX(int i) {
        if (this.lastMapconfig != null) {
            this.lastMapconfig.setSX(this.sX);
        }
        this.sX = i;
        this.mapGeoCenter.x = this.sX;
    }

    public void setSY(int i) {
        if (this.lastMapconfig != null) {
            this.lastMapconfig.setSY(this.sY);
        }
        this.sY = i;
        this.mapGeoCenter.x = this.sY;
    }

    public void setSZ(float f) {
        if (this.lastMapconfig != null) {
            this.lastMapconfig.setSZ(this.sZ);
        }
        this.sZ = f;
    }

    public void setSkyHeight(float f) {
        this.skyHeight = f;
    }

    public void setTrafficEnabled(boolean z) {
        this.isTrafficEnabled = z;
    }

    public void setUseProFunction(boolean z) {
        this.isUseProFunction = z;
    }

    public void setWorldMapEnable(boolean z) {
        this.isWorldMapEnable = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" sX: ");
        stringBuilder.append(this.sX);
        stringBuilder.append(" sY: ");
        stringBuilder.append(this.sY);
        stringBuilder.append(" sZ: ");
        stringBuilder.append(this.sZ);
        stringBuilder.append(" sC: ");
        stringBuilder.append(this.sC);
        stringBuilder.append(" sR: ");
        stringBuilder.append(this.sR);
        stringBuilder.append(" skyHeight: ");
        stringBuilder.append(this.skyHeight);
        return stringBuilder.toString();
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public void updateMapRectNextFrame(boolean z) {
        this.isNeedUpdateMapRectNextFrame = z;
    }
}
