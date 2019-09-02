package com.autonavi.ae.gmap.gloverlay;

import android.graphics.Rect;
import com.amap.api.mapcore.util.ca;
import com.autonavi.ae.gmap.gloverlay.GLOverlay.EAMapOverlayTpye;

public class GLCrossVector extends GLOverlay {

    public static class AVectorCrossAttr {
        public boolean dayMode = true;
        public int fArrowBorderWidth;
        public int fArrowLineWidth;
        public int stAreaColor;
        public Rect stAreaRect;
        public int stArrowBorderColor;
        public int stArrowLineColor;
    }

    public GLCrossVector(int i, ca caVar, int i2) {
        super(i, caVar, i2);
        if (caVar != null && caVar.O000000o() != null) {
            this.mNativeInstance = caVar.O000000o().createOverlay(i, EAMapOverlayTpye.AMAPOVERLAY_VECTOR.ordinal());
        }
    }

    private static native void nativeAddVectorCar(long j, int i, int i2, int i3);

    private static native int nativeAddVectorData(long j, int[] iArr, byte[] bArr);

    private static native int nativeGetFBOTextureId(long j);

    private static native void nativeInitFBOTexture(long j, int i, int i2);

    private static native void nativeSetArrowResId(long j, boolean z, int i);

    private static native void nativeSetBackgroundResId(long j, int i);

    private static native void nativeSetCarResId(long j, int i);

    public void addVectorCar(int i, int i2, int i3) {
        nativeAddVectorCar(this.mNativeInstance, i, i2, i3);
    }

    public int addVectorItem(AVectorCrossAttr aVectorCrossAttr, byte[] bArr, int i) {
        if (aVectorCrossAttr == null || bArr == null || i == 0) {
            return -1;
        }
        return nativeAddVectorData(this.mNativeInstance, new int[]{aVectorCrossAttr.stAreaRect.left, aVectorCrossAttr.stAreaRect.top, aVectorCrossAttr.stAreaRect.right, aVectorCrossAttr.stAreaRect.bottom, aVectorCrossAttr.stAreaColor, aVectorCrossAttr.fArrowBorderWidth, aVectorCrossAttr.stArrowBorderColor, aVectorCrossAttr.fArrowLineWidth, aVectorCrossAttr.stArrowLineColor, aVectorCrossAttr.dayMode}, bArr);
    }

    public void addVectorRemainDis(int i) {
    }

    public int getFBOTextureId() {
        return nativeGetFBOTextureId(this.mNativeInstance);
    }

    public void initFBOTexture(int i, int i2) {
        nativeInitFBOTexture(this.mNativeInstance, i, i2);
    }

    public void setArrowResId(boolean z, int i) {
        nativeSetArrowResId(this.mNativeInstance, z, i);
    }

    public void setBackgroundResId(int i) {
        nativeSetBackgroundResId(this.mNativeInstance, i);
    }

    public void setCarResId(int i) {
        nativeSetCarResId(this.mNativeInstance, i);
    }

    public void setRoadResId(boolean z, int i) {
    }

    public void setSkyResId(boolean z, int i) {
    }
}
