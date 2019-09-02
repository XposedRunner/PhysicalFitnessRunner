package com.autonavi.amap.mapcore.tools;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class GLFileUtil {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void copy(Context context, String str, File file) throws Exception {
        file.delete();
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        try {
            open.read(bArr);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
            } finally {
                closeQuietly(fileOutputStream);
            }
        } finally {
            closeQuietly(open);
        }
    }

    public static void deleteFile(File file) {
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (file.isDirectory() && listFiles != null) {
                for (File deleteFile : listFiles) {
                    deleteFile(deleteFile);
                }
            }
            file.delete();
        }
    }

    public static File getCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            cacheDir = context.getDir("cache", 0);
        }
        if (cacheDir == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/data/data/");
            stringBuilder.append(context.getPackageName());
            stringBuilder.append("/app_cache");
            cacheDir = new File(stringBuilder.toString());
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static File getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = context.getDir("files", 0);
        }
        if (filesDir == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/data/data/");
            stringBuilder.append(context.getPackageName());
            stringBuilder.append("/app_files");
            filesDir = new File(stringBuilder.toString());
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        return filesDir;
    }

    public static byte[] readFileContents(String str) {
        Throwable th;
        Closeable fileInputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byteArrayOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                            closeQuietly(fileInputStream);
                            return bArr;
                        }
                    }
                } catch (Exception unused) {
                    closeQuietly(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            }
            closeQuietly(null);
            return null;
        } catch (Exception unused2) {
            fileInputStream = null;
            closeQuietly(fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        Throwable th;
        WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        Closeable closeable = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                    } catch (Exception unused) {
                        closeable = fileOutputStream;
                        writeLock.unlock();
                        closeQuietly(closeable);
                        return;
                    } catch (Throwable th2) {
                        closeable = fileOutputStream;
                        th = th2;
                        writeLock.unlock();
                        closeQuietly(closeable);
                        throw th;
                    }
                    return;
                }
            } catch (Exception unused2) {
                writeLock.unlock();
                closeQuietly(closeable);
                return;
            } catch (Throwable th3) {
                th = th3;
                writeLock.unlock();
                closeQuietly(closeable);
                throw th;
            }
        }
        writeLock.unlock();
        closeQuietly(null);
    }
}
