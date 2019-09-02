package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public abstract class ParticleShapeModule extends AbstractNativeInstance {
    protected final int TYPE_DEFAULT = -1;
    protected final int TYPE_RECT = 1;
    protected final int TYPE_SINGLEPOINT = 0;
    protected boolean isUseRatio = false;
    protected int type = -1;

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseParticleShapeModule(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }

    public abstract float[] getPoint();

    public boolean isUseRatio() {
        return this.isUseRatio;
    }
}
