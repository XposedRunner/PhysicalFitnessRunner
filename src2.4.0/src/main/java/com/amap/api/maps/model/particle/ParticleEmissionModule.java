package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public class ParticleEmissionModule extends AbstractNativeInstance {
    private final int rate;
    private final int rateTime;

    public ParticleEmissionModule(int i, int i2) {
        this.rate = i;
        this.rateTime = i2;
        createNativeInstace();
    }

    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateParticleEmissionModule(this.rate, this.rateTime);
        } catch (Throwable unused) {
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseParticleEmissonModule(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }
}
