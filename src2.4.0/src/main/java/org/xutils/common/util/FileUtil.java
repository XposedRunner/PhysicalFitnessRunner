package org.xutils.common.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.xutils.x;

public class FileUtil {
    private FileUtil() {
    }

    public static boolean copy(String str, String str2) {
        Closeable fileOutputStream;
        Throwable th;
        File file = new File(str);
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str2);
        IOUtil.deleteFileOrDir(file2);
        File parentFile = file2.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            Closeable closeable = null;
            try {
                Closeable fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    closeable = fileInputStream;
                    IOUtil.closeQuietly(closeable);
                    IOUtil.closeQuietly(fileOutputStream);
                    throw th;
                }
                try {
                    IOUtil.copy(fileInputStream, fileOutputStream);
                    z = true;
                    IOUtil.closeQuietly(fileInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileInputStream;
                    IOUtil.closeQuietly(closeable);
                    IOUtil.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                IOUtil.closeQuietly(closeable);
                IOUtil.closeQuietly(fileOutputStream);
                throw th;
            }
            IOUtil.closeQuietly(fileOutputStream);
        }
        return z;
    }

    public static Boolean existsSdcard() {
        return Boolean.valueOf(Environment.getExternalStorageState().equals("mounted"));
    }

    public static File getCacheDir(String str) {
        File externalCacheDir;
        if (existsSdcard().booleanValue()) {
            externalCacheDir = x.app().getExternalCacheDir();
            if (externalCacheDir == null) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Android/data/");
                stringBuilder.append(x.app().getPackageName());
                stringBuilder.append("/cache/");
                stringBuilder.append(str);
                externalCacheDir = new File(externalStorageDirectory, stringBuilder.toString());
            } else {
                externalCacheDir = new File(externalCacheDir, str);
            }
        } else {
            externalCacheDir = new File(x.app().getCacheDir(), str);
        }
        return (externalCacheDir.exists() || externalCacheDir.mkdirs()) ? externalCacheDir : null;
    }

    public static long getDiskAvailableSize() {
        if (!existsSdcard().booleanValue()) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static long getFileOrDirSize(File file) {
        long j = 0;
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int i = 0;
            while (i < listFiles.length) {
                i++;
                j += getFileOrDirSize(listFiles[i]);
            }
        }
        return j;
    }

    public static boolean isDiskAvailable() {
        return getDiskAvailableSize() > 10485760;
    }
}
