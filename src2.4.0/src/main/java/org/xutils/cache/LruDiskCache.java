package org.xutils.cache;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import org.xutils.DbManager;
import org.xutils.common.task.PriorityExecutor;
import org.xutils.common.util.FileUtil;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.LogUtil;
import org.xutils.common.util.MD5;
import org.xutils.common.util.ProcessLock;
import org.xutils.config.DbConfigs;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.ex.FileLockedException;
import org.xutils.x;

public final class LruDiskCache {
    private static final String CACHE_DIR_NAME = "xUtils_cache";
    private static final HashMap<String, LruDiskCache> DISK_CACHE_MAP = new HashMap(5);
    private static final int LIMIT_COUNT = 5000;
    private static final long LIMIT_SIZE = 104857600;
    private static final int LOCK_WAIT = 3000;
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private static final long TRIM_TIME_SPAN = 1000;
    private boolean available = false;
    private final DbManager cacheDb = x.getDb(DbConfigs.HTTP.getConfig());
    private File cacheDir;
    private long diskCacheSize = LIMIT_SIZE;
    private long lastTrimTime = 0;
    private final Executor trimExecutor = new PriorityExecutor(1, true);

    private LruDiskCache(String str) {
        this.cacheDir = FileUtil.getCacheDir(str);
        if (this.cacheDir != null && (this.cacheDir.exists() || this.cacheDir.mkdirs())) {
            this.available = true;
        }
        deleteNoIndexFiles();
    }

    private void deleteExpiry() {
        try {
            WhereBuilder b = WhereBuilder.b("expires", "<", Long.valueOf(System.currentTimeMillis()));
            List<DiskCacheEntity> findAll = this.cacheDb.selector(DiskCacheEntity.class).where(b).findAll();
            this.cacheDb.delete(DiskCacheEntity.class, b);
            if (findAll != null && findAll.size() > 0) {
                for (DiskCacheEntity path : findAll) {
                    String path2 = path.getPath();
                    if (!TextUtils.isEmpty(path2)) {
                        deleteFileWithLock(path2);
                    }
                }
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    private boolean deleteFileWithLock(String str) {
        Throwable th;
        Closeable tryLock;
        try {
            tryLock = ProcessLock.tryLock(str, true);
            if (tryLock != null) {
                try {
                    if (tryLock.isValid()) {
                        boolean deleteFileOrDir = IOUtil.deleteFileOrDir(new File(str));
                        IOUtil.closeQuietly(tryLock);
                        return deleteFileOrDir;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    IOUtil.closeQuietly(tryLock);
                    throw th;
                }
            }
            IOUtil.closeQuietly(tryLock);
            return false;
        } catch (Throwable th3) {
            th = th3;
            tryLock = null;
            IOUtil.closeQuietly(tryLock);
            throw th;
        }
    }

    private void deleteNoIndexFiles() {
        this.trimExecutor.execute(new Runnable() {
            public void run() {
                if (LruDiskCache.this.available) {
                    try {
                        File[] listFiles = LruDiskCache.this.cacheDir.listFiles();
                        if (listFiles != null) {
                            for (File file : listFiles) {
                                if (LruDiskCache.this.cacheDb.selector(DiskCacheEntity.class).where("path", "=", file.getAbsolutePath()).count() < 1) {
                                    IOUtil.deleteFileOrDir(file);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        });
    }

    public static synchronized LruDiskCache getDiskCache(String str) {
        LruDiskCache lruDiskCache;
        synchronized (LruDiskCache.class) {
            Object str2;
            if (TextUtils.isEmpty(str2)) {
                str2 = CACHE_DIR_NAME;
            }
            lruDiskCache = (LruDiskCache) DISK_CACHE_MAP.get(str2);
            if (lruDiskCache == null) {
                lruDiskCache = new LruDiskCache(str2);
                DISK_CACHE_MAP.put(str2, lruDiskCache);
            }
        }
        return lruDiskCache;
    }

    private void trimSize() {
        this.trimExecutor.execute(new Runnable() {
            public void run() {
                if (LruDiskCache.this.available) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - LruDiskCache.this.lastTrimTime >= LruDiskCache.TRIM_TIME_SPAN) {
                        List<Object> findAll;
                        String path;
                        LruDiskCache lruDiskCache;
                        StringBuilder stringBuilder;
                        LruDiskCache.this.lastTrimTime = currentTimeMillis;
                        LruDiskCache.this.deleteExpiry();
                        try {
                            int count = (int) LruDiskCache.this.cacheDb.selector(DiskCacheEntity.class).count();
                            if (count > 5010) {
                                findAll = LruDiskCache.this.cacheDb.selector(DiskCacheEntity.class).orderBy("lastAccess").orderBy("hits").limit(count - 5000).offset(0).findAll();
                                if (findAll != null && findAll.size() > 0) {
                                    for (Object obj : findAll) {
                                        path = obj.getPath();
                                        if (!TextUtils.isEmpty(path) && LruDiskCache.this.deleteFileWithLock(path)) {
                                            lruDiskCache = LruDiskCache.this;
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append(path);
                                            stringBuilder.append(LruDiskCache.TEMP_FILE_SUFFIX);
                                            if (lruDiskCache.deleteFileWithLock(stringBuilder.toString())) {
                                                LruDiskCache.this.cacheDb.delete(obj);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (DbException e) {
                            LogUtil.e(e.getMessage(), e);
                        }
                        while (FileUtil.getFileOrDirSize(LruDiskCache.this.cacheDir) > LruDiskCache.this.diskCacheSize) {
                            try {
                                findAll = LruDiskCache.this.cacheDb.selector(DiskCacheEntity.class).orderBy("lastAccess").orderBy("hits").limit(10).offset(0).findAll();
                                if (findAll != null && findAll.size() > 0) {
                                    for (Object obj2 : findAll) {
                                        path = obj2.getPath();
                                        if (!TextUtils.isEmpty(path) && LruDiskCache.this.deleteFileWithLock(path)) {
                                            lruDiskCache = LruDiskCache.this;
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append(path);
                                            stringBuilder.append(LruDiskCache.TEMP_FILE_SUFFIX);
                                            if (lruDiskCache.deleteFileWithLock(stringBuilder.toString())) {
                                                LruDiskCache.this.cacheDb.delete(obj2);
                                            }
                                        }
                                    }
                                }
                            } catch (DbException e2) {
                                LogUtil.e(e2.getMessage(), e2);
                            }
                        }
                    }
                }
            }
        });
    }

    public void clearCacheFiles() {
        IOUtil.deleteFileOrDir(this.cacheDir);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084 A:{Splitter:B:18:0x003f, ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:23:0x004b, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:24:0x004c, code skipped:
            r1 = r0;
            r0 = r4;
     */
    /* JADX WARNING: Missing block: B:35:0x0084, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:52:0x00ad, code skipped:
            org.xutils.common.util.IOUtil.closeQuietly((java.io.Closeable) r7);
            org.xutils.common.util.IOUtil.deleteFileOrDir(r7);
     */
    /* JADX WARNING: Missing block: B:56:0x00b9, code skipped:
            org.xutils.common.util.IOUtil.closeQuietly(r4);
            org.xutils.common.util.IOUtil.closeQuietly(r3);
            org.xutils.common.util.IOUtil.deleteFileOrDir(r4);
     */
    /* JADX WARNING: Missing block: B:57:0x00c3, code skipped:
            org.xutils.common.util.IOUtil.closeQuietly((java.io.Closeable) r7);
            org.xutils.common.util.IOUtil.deleteFileOrDir(r7);
     */
    public org.xutils.cache.DiskCacheFile commitDiskCacheFile(org.xutils.cache.DiskCacheFile r7) throws java.io.IOException {
        /*
        r6 = this;
        r0 = 0;
        if (r7 == 0) goto L_0x0011;
    L_0x0003:
        r1 = r7.length();
        r3 = 1;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 >= 0) goto L_0x0011;
    L_0x000d:
        org.xutils.common.util.IOUtil.closeQuietly(r7);
        return r0;
    L_0x0011:
        r1 = r6.available;
        if (r1 == 0) goto L_0x00cb;
    L_0x0015:
        if (r7 != 0) goto L_0x0019;
    L_0x0017:
        goto L_0x00cb;
    L_0x0019:
        r1 = r7.cacheEntity;
        r2 = r7.getName();
        r3 = ".tmp";
        r2 = r2.endsWith(r3);
        if (r2 == 0) goto L_0x00ca;
    L_0x0027:
        r2 = r1.getPath();	 Catch:{ InterruptedException -> 0x0096, all -> 0x0092 }
        r3 = 1;
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r3 = org.xutils.common.util.ProcessLock.tryLock(r2, r3, r4);	 Catch:{ InterruptedException -> 0x0096, all -> 0x0092 }
        if (r3 == 0) goto L_0x008c;
    L_0x0034:
        r4 = r3.isValid();	 Catch:{ InterruptedException -> 0x0089, all -> 0x0086 }
        if (r4 == 0) goto L_0x008c;
    L_0x003a:
        r4 = new org.xutils.cache.DiskCacheFile;	 Catch:{ InterruptedException -> 0x0089, all -> 0x0086 }
        r4.<init>(r1, r2, r3);	 Catch:{ InterruptedException -> 0x0089, all -> 0x0086 }
        r2 = r7.renameTo(r4);	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        if (r2 == 0) goto L_0x0067;
    L_0x0045:
        r0 = r6.cacheDb;	 Catch:{ DbException -> 0x0050 }
        r0.replace(r1);	 Catch:{ DbException -> 0x0050 }
        goto L_0x0058;
    L_0x004b:
        r0 = move-exception;
        r1 = r0;
        r0 = r4;
        goto L_0x00b7;
    L_0x0050:
        r0 = move-exception;
        r1 = r0.getMessage();	 Catch:{ InterruptedException -> 0x0084, all -> 0x004b }
        org.xutils.common.util.LogUtil.e(r1, r0);	 Catch:{ InterruptedException -> 0x0084, all -> 0x004b }
    L_0x0058:
        r6.trimSize();	 Catch:{ InterruptedException -> 0x0084, all -> 0x004b }
        if (r4 != 0) goto L_0x005e;
    L_0x005d:
        goto L_0x00a3;
    L_0x005e:
        org.xutils.common.util.IOUtil.closeQuietly(r7);
        org.xutils.common.util.IOUtil.deleteFileOrDir(r7);
        r7 = r4;
        goto L_0x00ca;
    L_0x0067:
        r1 = new java.io.IOException;	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        r2 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        r2.<init>();	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        r5 = "rename:";
        r2.append(r5);	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        r5 = r7.getAbsolutePath();	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        r2.append(r5);	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        r2 = r2.toString();	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        r1.<init>(r2);	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
        throw r1;	 Catch:{ InterruptedException -> 0x0084, all -> 0x0082 }
    L_0x0082:
        r1 = move-exception;
        goto L_0x00b7;
    L_0x0084:
        r0 = move-exception;
        goto L_0x009a;
    L_0x0086:
        r1 = move-exception;
        r4 = r0;
        goto L_0x00b7;
    L_0x0089:
        r1 = move-exception;
        r4 = r0;
        goto L_0x0099;
    L_0x008c:
        r1 = new org.xutils.ex.FileLockedException;	 Catch:{ InterruptedException -> 0x0089, all -> 0x0086 }
        r1.<init>(r2);	 Catch:{ InterruptedException -> 0x0089, all -> 0x0086 }
        throw r1;	 Catch:{ InterruptedException -> 0x0089, all -> 0x0086 }
    L_0x0092:
        r1 = move-exception;
        r3 = r0;
        r4 = r3;
        goto L_0x00b7;
    L_0x0096:
        r1 = move-exception;
        r3 = r0;
        r4 = r3;
    L_0x0099:
        r0 = r1;
    L_0x009a:
        r1 = r0.getMessage();	 Catch:{ all -> 0x00b4 }
        org.xutils.common.util.LogUtil.e(r1, r0);	 Catch:{ all -> 0x00b4 }
        if (r7 != 0) goto L_0x00ad;
    L_0x00a3:
        org.xutils.common.util.IOUtil.closeQuietly(r4);
        org.xutils.common.util.IOUtil.closeQuietly(r3);
        org.xutils.common.util.IOUtil.deleteFileOrDir(r4);
        goto L_0x00ca;
    L_0x00ad:
        org.xutils.common.util.IOUtil.closeQuietly(r7);
        org.xutils.common.util.IOUtil.deleteFileOrDir(r7);
        goto L_0x00ca;
    L_0x00b4:
        r0 = move-exception;
        r1 = r0;
        r0 = r7;
    L_0x00b7:
        if (r0 != 0) goto L_0x00c3;
    L_0x00b9:
        org.xutils.common.util.IOUtil.closeQuietly(r4);
        org.xutils.common.util.IOUtil.closeQuietly(r3);
        org.xutils.common.util.IOUtil.deleteFileOrDir(r4);
        goto L_0x00c9;
    L_0x00c3:
        org.xutils.common.util.IOUtil.closeQuietly(r7);
        org.xutils.common.util.IOUtil.deleteFileOrDir(r7);
    L_0x00c9:
        throw r1;
    L_0x00ca:
        return r7;
    L_0x00cb:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xutils.cache.LruDiskCache.commitDiskCacheFile(org.xutils.cache.DiskCacheFile):org.xutils.cache.DiskCacheFile");
    }

    public DiskCacheFile createDiskCacheFile(DiskCacheEntity diskCacheEntity) throws IOException {
        if (!this.available || diskCacheEntity == null) {
            return null;
        }
        diskCacheEntity.setPath(new File(this.cacheDir, MD5.md5(diskCacheEntity.getKey())).getAbsolutePath());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(diskCacheEntity.getPath());
        stringBuilder.append(TEMP_FILE_SUFFIX);
        String stringBuilder2 = stringBuilder.toString();
        ProcessLock tryLock = ProcessLock.tryLock(stringBuilder2, true);
        if (tryLock == null || !tryLock.isValid()) {
            throw new FileLockedException(diskCacheEntity.getPath());
        }
        DiskCacheFile diskCacheFile = new DiskCacheFile(diskCacheEntity, stringBuilder2, tryLock);
        if (!diskCacheFile.getParentFile().exists()) {
            diskCacheFile.mkdirs();
        }
        return diskCacheFile;
    }

    public DiskCacheEntity get(String str) {
        if (!this.available || TextUtils.isEmpty(str)) {
            return null;
        }
        DiskCacheEntity diskCacheEntity;
        try {
            diskCacheEntity = (DiskCacheEntity) this.cacheDb.selector(DiskCacheEntity.class).where("key", "=", str).findFirst();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            diskCacheEntity = null;
        }
        if (diskCacheEntity != null) {
            if (diskCacheEntity.getExpires() < System.currentTimeMillis()) {
                return null;
            }
            this.trimExecutor.execute(new Runnable() {
                public void run() {
                    diskCacheEntity.setHits(diskCacheEntity.getHits() + 1);
                    diskCacheEntity.setLastAccess(System.currentTimeMillis());
                    try {
                        LruDiskCache.this.cacheDb.update(diskCacheEntity, "hits", "lastAccess");
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            });
        }
        return diskCacheEntity;
    }

    public DiskCacheFile getDiskCacheFile(String str) throws InterruptedException {
        DiskCacheFile diskCacheFile = null;
        if (!this.available || TextUtils.isEmpty(str)) {
            return null;
        }
        Object obj = get(str);
        if (obj != null && new File(obj.getPath()).exists()) {
            ProcessLock tryLock = ProcessLock.tryLock(obj.getPath(), false, 3000);
            if (tryLock != null && tryLock.isValid()) {
                DiskCacheFile diskCacheFile2 = new DiskCacheFile(obj, obj.getPath(), tryLock);
                if (diskCacheFile2.exists()) {
                    diskCacheFile = diskCacheFile2;
                } else {
                    try {
                        this.cacheDb.delete(obj);
                    } catch (DbException e) {
                        LogUtil.e(e.getMessage(), e);
                    }
                }
            }
        }
        return diskCacheFile;
    }

    public void put(DiskCacheEntity diskCacheEntity) {
        if (this.available && diskCacheEntity != null && !TextUtils.isEmpty(diskCacheEntity.getTextContent()) && diskCacheEntity.getExpires() >= System.currentTimeMillis()) {
            try {
                this.cacheDb.replace(diskCacheEntity);
            } catch (DbException e) {
                LogUtil.e(e.getMessage(), e);
            }
            trimSize();
        }
    }

    public LruDiskCache setMaxSize(long j) {
        if (j > 0) {
            long diskAvailableSize = FileUtil.getDiskAvailableSize();
            if (diskAvailableSize > j) {
                this.diskCacheSize = j;
            } else {
                this.diskCacheSize = diskAvailableSize;
            }
        }
        return this;
    }
}
