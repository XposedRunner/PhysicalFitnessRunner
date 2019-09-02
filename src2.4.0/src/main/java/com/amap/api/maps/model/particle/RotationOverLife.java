package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public abstract class RotationOverLife extends AbstractNativeInstance {
    protected final int TYPE_CONSTANTROTATIONOVERLIFE = 0;
    protected final int TYPE_DEFAULT = -1;
    protected int type = -1;

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseRotationOverLife(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }

    public abstract float getRotate();
}
