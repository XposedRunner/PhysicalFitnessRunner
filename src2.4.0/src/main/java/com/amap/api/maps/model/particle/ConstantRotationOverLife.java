package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;

public class ConstantRotationOverLife extends RotationOverLife {
    private float rotate = 0.0f;

    public ConstantRotationOverLife(float f) {
        this.rotate = f;
        this.type = 0;
        createNativeInstace();
    }

    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateConstantRotationOverLife(this.rotate);
        } catch (Throwable unused) {
        }
    }

    public float getRotate() {
        return this.rotate;
    }
}
