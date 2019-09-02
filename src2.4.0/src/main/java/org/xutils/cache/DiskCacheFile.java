package org.xutils.cache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.ProcessLock;

public final class DiskCacheFile extends File implements Closeable {
    DiskCacheEntity cacheEntity;
    ProcessLock lock;

    DiskCacheFile(DiskCacheEntity diskCacheEntity, String str, ProcessLock processLock) {
        super(str);
        this.cacheEntity = diskCacheEntity;
        this.lock = processLock;
    }

    public void close() throws IOException {
        IOUtil.closeQuietly(this.lock);
    }

    public DiskCacheFile commit() throws IOException {
        return getDiskCache().commitDiskCacheFile(this);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public DiskCacheEntity getCacheEntity() {
        return this.cacheEntity;
    }

    public LruDiskCache getDiskCache() {
        return LruDiskCache.getDiskCache(getParentFile().getName());
    }
}
