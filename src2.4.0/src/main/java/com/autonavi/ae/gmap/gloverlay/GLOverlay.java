package com.autonavi.ae.gmap.gloverlay;

import com.amap.api.mapcore.util.ca;
import com.autonavi.ae.gmap.GLMapEngine;

public abstract class GLOverlay {
    protected boolean isNightStyle = false;
    protected int mCode;
    protected int mEngineID;
    protected ca mGLMapView;
    boolean mIsInBundle = false;
    protected int mItemPriority = 0;
    protected long mNativeInstance = 0;

    public enum EAMapOverlayTpye {
        AMAPOVERLAY_POINT,
        AMAPOVERLAY_POLYLINE,
        AMAPOVERLAY_POLYGON,
        AMAPOVERLAY_ARC,
        AMAPOVERLAY_ARROW,
        AMAPOVERLAY_VECTOR,
        AMAPOVERLAY_GROUP,
        AMAPOVERLAY_MODEL,
        AMAPOVERLAY_PLANE
    }

    public GLOverlay(int i, ca caVar, int i2) {
        this.mEngineID = i;
        this.mGLMapView = caVar;
        this.mCode = i2;
        this.mNativeInstance = 0;
        this.mItemPriority = 0;
    }

    private static native int nativeGetCount(long j);

    private static native int nativeGetOverlayPriority(long j);

    private static native int nativeGetSubType(long j);

    private static native int nativeGetType(long j);

    private static native boolean nativeIsClickable(long j);

    private static native boolean nativeIsVisible(long j);

    private static native void nativeRemoveAll(long j);

    private static native void nativeRemoveItem(long j, int i);

    private static native void nativeSetClickable(long j, boolean z);

    private static native void nativeSetMaxDisplayLevel(long j, float f);

    private static native void nativeSetMinDisplayLevel(long j, float f);

    private static native void nativeSetOverlayItemPriority(long j, int i);

    private static native void nativeSetOverlayOnTop(long j, boolean z);

    private static native void nativeSetOverlayPriority(long j, int i);

    private static native void nativeSetShownMaxCount(long j, int i);

    protected static native void nativeSetVisible(long j, boolean z);

    public void clearFocus() {
    }

    public int getCode() {
        return this.mCode;
    }

    public boolean getIsInBundle() {
        return this.mIsInBundle;
    }

    public long getNativeInstatnce() {
        return this.mNativeInstance;
    }

    public int getOverlayPriority() {
        return nativeGetOverlayPriority(this.mNativeInstance);
    }

    public int getSize() {
        return this.mNativeInstance == 0 ? 0 : nativeGetCount(this.mNativeInstance);
    }

    public int getSubType() {
        return this.mNativeInstance == 0 ? -1 : nativeGetSubType(this.mNativeInstance);
    }

    public int getType() {
        return this.mNativeInstance == 0 ? -1 : nativeGetType(this.mNativeInstance);
    }

    public boolean isClickable() {
        return this.mNativeInstance == 0 ? false : nativeIsClickable(this.mNativeInstance);
    }

    public boolean isVisible() {
        return this.mNativeInstance == 0 ? false : nativeIsVisible(this.mNativeInstance);
    }

    /* Access modifiers changed, original: 0000 */
    public void releaseInstance() {
        if (this.mNativeInstance != 0) {
            long j = this.mNativeInstance;
            this.mNativeInstance = 0;
            GLMapEngine.destroyOverlay(this.mEngineID, j);
        }
    }

    public void removeAll() {
        if (this.mNativeInstance != 0) {
            nativeRemoveAll(this.mNativeInstance);
            ca caVar = this.mGLMapView;
        }
    }

    public void removeItem(int i) {
        if (this.mNativeInstance != 0) {
            nativeRemoveItem(this.mNativeInstance, i);
        }
    }

    public void setClickable(boolean z) {
        if (this.mNativeInstance != 0) {
            nativeSetClickable(this.mNativeInstance, z);
        }
    }

    public void setMaxCountShown(int i) {
        nativeSetShownMaxCount(this.mNativeInstance, i);
    }

    public void setMaxDisplayLevel(float f) {
        nativeSetMaxDisplayLevel(this.mNativeInstance, f);
    }

    public void setMinDisplayLevel(float f) {
        nativeSetMinDisplayLevel(this.mNativeInstance, f);
    }

    public void setOverlayItemPriority(int i) {
        this.mItemPriority = i;
    }

    public void setOverlayOnTop(boolean z) {
        nativeSetOverlayOnTop(this.mNativeInstance, z);
    }

    public void setOverlayPriority(int i) {
        nativeSetOverlayPriority(this.mNativeInstance, i);
        if (this.mGLMapView != null && this.mGLMapView.O000000o() != null) {
            GLOverlayBundle overlayBundle = this.mGLMapView.O000000o().getOverlayBundle(this.mEngineID);
            if (overlayBundle != null) {
                overlayBundle.sortOverlay();
            }
        }
    }

    public void setVisible(boolean z) {
        if (this.mNativeInstance != 0) {
            nativeSetVisible(this.mNativeInstance, z);
        }
    }

    public void useNightStyle(boolean z) {
        this.isNightStyle = z;
    }
}
