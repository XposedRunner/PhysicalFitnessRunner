package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;

public class RectParticleShape extends ParticleShapeModule {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public RectParticleShape(float f, float f2, float f3, float f4, boolean z) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.isUseRatio = z;
        createNativeInstace();
        this.type = 1;
    }

    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateRectParticleShape(this.left, this.top, this.right, this.bottom, this.isUseRatio);
        } catch (Throwable unused) {
        }
    }

    public float[] getPoint() {
        return null;
    }
}
