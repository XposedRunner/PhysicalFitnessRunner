package com.autonavi.ae.gmap.maploader;

import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;

public class ProcessingTile {
    private static final SynchronizedPool<ProcessingTile> M_POOL = new SynchronizedPool(30);
    public long mCreateTime = 0;
    public String mKeyName;

    public ProcessingTile(String str) {
        setParams(str);
    }

    public static ProcessingTile obtain(String str) {
        ProcessingTile processingTile = (ProcessingTile) M_POOL.acquire();
        if (processingTile == null) {
            return new ProcessingTile(str);
        }
        processingTile.setParams(str);
        return processingTile;
    }

    private void setParams(String str) {
        this.mKeyName = str;
        this.mCreateTime = System.currentTimeMillis() / 1000;
    }

    public void recycle() {
        this.mKeyName = null;
        this.mCreateTime = 0;
        M_POOL.release(this);
    }
}
