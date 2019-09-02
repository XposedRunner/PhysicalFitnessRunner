package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;

public class SinglePointParticleShape extends ParticleShapeModule {
    private float[] point_3;

    public SinglePointParticleShape(float f, float f2, float f3) {
        this(f, f2, f3, false);
    }

    public SinglePointParticleShape(float f, float f2, float f3, boolean z) {
        this.point_3 = new float[3];
        this.point_3[0] = f;
        this.point_3[1] = f2;
        this.point_3[2] = f3;
        this.isUseRatio = z;
        createNativeInstace();
        this.type = 0;
    }

    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateSinglePointParticleShape(this.point_3[0], this.point_3[1], this.point_3[2], this.isUseRatio);
        } catch (Throwable unused) {
        }
    }

    public float[] getPoint() {
        return this.point_3;
    }
}
