package com.amap.api.mapcore.util;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: AbstractGlOverlay */
public abstract class O0Oo0o0 {
    private ca map;

    public void destroy() {
        ca caVar = this.map;
    }

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);
}
