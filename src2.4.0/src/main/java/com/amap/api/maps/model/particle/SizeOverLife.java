package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public abstract class SizeOverLife extends AbstractNativeInstance {
    public final int DEFAULT_SIZE = 0;
    protected final int TYPE_CURVESIZEOVERLIFE = 0;
    protected final int TYPE_DEFAULT = -1;
    protected int type = -1;

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseSizeOverLife(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }

    public abstract float getSizeX(float f);

    public abstract float getSizeY(float f);

    public abstract float getSizeZ(float f);
}
