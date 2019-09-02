package com.autonavi.amap.mapcore;

public class AbstractNativeInstance {
    protected long nativeInstance = 0;

    public void createNativeInstace() {
    }

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        super.finalize();
    }

    public final long getNativeInstance() {
        return this.nativeInstance;
    }
}
