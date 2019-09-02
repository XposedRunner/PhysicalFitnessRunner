package org.xutils.common.util;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.xutils.x;

public final class ProcessLock implements Closeable {
    private static final DecimalFormat FORMAT = new DecimalFormat("0.##################");
    private static final String LOCK_FILE_DIR = "process_lock";
    private static final DoubleKeyValueMap<String, Integer, ProcessLock> LOCK_MAP = new DoubleKeyValueMap();
    private final File mFile;
    private final FileLock mFileLock;
    private final String mLockName;
    private final Closeable mStream;
    private final boolean mWriteMode;

    static {
        IOUtil.deleteFileOrDir(x.app().getDir(LOCK_FILE_DIR, 0));
    }

    private ProcessLock(String str, File file, FileLock fileLock, Closeable closeable, boolean z) {
        this.mLockName = str;
        this.mFileLock = fileLock;
        this.mFile = file;
        this.mStream = closeable;
        this.mWriteMode = z;
    }

    private static String customHash(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        double d = 0.0d;
        byte[] bytes = str.getBytes();
        for (int i = 0; i < str.length(); i++) {
            d = 0.005d * ((255.0d * d) + ((double) bytes[i]));
        }
        return FORMAT.format(d);
    }

    private static boolean isValid(FileLock fileLock) {
        return fileLock != null && fileLock.isValid();
    }

    private static void release(String str, FileLock fileLock, File file, Closeable closeable) {
        synchronized (LOCK_MAP) {
            if (fileLock != null) {
                Closeable channel;
                try {
                    LOCK_MAP.remove(str, Integer.valueOf(fileLock.hashCode()));
                    ConcurrentHashMap concurrentHashMap = LOCK_MAP.get(str);
                    if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
                        IOUtil.deleteFileOrDir(file);
                    }
                    if (fileLock.channel().isOpen()) {
                        fileLock.release();
                    }
                    channel = fileLock.channel();
                } catch (Throwable th) {
                    try {
                        LogUtil.e(th.getMessage(), th);
                        channel = fileLock.channel();
                    } catch (Throwable th2) {
                        IOUtil.closeQuietly(fileLock.channel());
                    }
                }
                IOUtil.closeQuietly(channel);
            }
            IOUtil.closeQuietly(closeable);
        }
    }

    public static ProcessLock tryLock(String str, boolean z) {
        return tryLockInternal(str, customHash(str), z);
    }

    public static ProcessLock tryLock(String str, boolean z, long j) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis() + j;
        String customHash = customHash(str);
        ProcessLock processLock = null;
        while (System.currentTimeMillis() < currentTimeMillis) {
            processLock = tryLockInternal(str, customHash, z);
            if (processLock != null) {
                break;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw e;
            } catch (Throwable unused) {
            }
        }
        return processLock;
    }

    private static ProcessLock tryLockInternal(String str, String str2, boolean z) {
        Throwable th;
        StringBuilder stringBuilder;
        synchronized (LOCK_MAP) {
            ProcessLock processLock;
            ConcurrentHashMap concurrentHashMap = LOCK_MAP.get(str);
            if (!(concurrentHashMap == null || concurrentHashMap.isEmpty())) {
                Iterator it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    processLock = (ProcessLock) ((Entry) it.next()).getValue();
                    if (processLock == null) {
                        it.remove();
                    } else if (!processLock.isValid()) {
                        it.remove();
                    } else if (z) {
                        return null;
                    } else if (processLock.mWriteMode) {
                        return null;
                    }
                }
            }
            Closeable fileOutputStream;
            Closeable channel;
            try {
                File file = new File(x.app().getDir(LOCK_FILE_DIR, 0), str2);
                if (file.exists() || file.createNewFile()) {
                    if (z) {
                        fileOutputStream = new FileOutputStream(file, false);
                        channel = fileOutputStream.getChannel();
                    } else {
                        fileOutputStream = new FileInputStream(file);
                        channel = fileOutputStream.getChannel();
                    }
                    if (channel != null) {
                        try {
                            FileLock tryLock = channel.tryLock(0, Long.MAX_VALUE, z ^ 1);
                            if (isValid(tryLock)) {
                                processLock = new ProcessLock(str, file, tryLock, fileOutputStream, z);
                                LOCK_MAP.put(str, Integer.valueOf(tryLock.hashCode()), processLock);
                                return processLock;
                            }
                            release(str, tryLock, file, fileOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("tryLock: ");
                            stringBuilder.append(str);
                            stringBuilder.append(", ");
                            stringBuilder.append(th.getMessage());
                            LogUtil.d(stringBuilder.toString());
                            IOUtil.closeQuietly(fileOutputStream);
                            IOUtil.closeQuietly(channel);
                            return null;
                        }
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("can not get file channel:");
                    stringBuilder.append(file.getAbsolutePath());
                    throw new IOException(stringBuilder.toString());
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                channel = fileOutputStream;
                stringBuilder = new StringBuilder();
                stringBuilder.append("tryLock: ");
                stringBuilder.append(str);
                stringBuilder.append(", ");
                stringBuilder.append(th.getMessage());
                LogUtil.d(stringBuilder.toString());
                IOUtil.closeQuietly(fileOutputStream);
                IOUtil.closeQuietly(channel);
                return null;
            }
        }
    }

    public void close() throws IOException {
        release();
    }

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public boolean isValid() {
        return isValid(this.mFileLock);
    }

    public void release() {
        release(this.mLockName, this.mFileLock, this.mFile, this.mStream);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mLockName);
        stringBuilder.append(": ");
        stringBuilder.append(this.mFile.getName());
        return stringBuilder.toString();
    }
}
