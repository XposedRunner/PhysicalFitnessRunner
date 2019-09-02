package com.autonavi.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Environment;
import cn.jiguang.net.HttpUtils;
import com.amap.api.mapcore.util.ooOOOOoo;
import com.amap.api.maps.MapsInitializer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class FileUtil {
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static boolean checkCanWrite(File file) {
        if (file == null || !file.canWrite()) {
            return false;
        }
        File file2 = new File(file, "amap.tmp");
        try {
            file2.createNewFile();
            if (file2 == null || !file2.exists()) {
                return false;
            }
            try {
                file2.delete();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void copy(Context context, String str, File file) throws Exception {
        file.delete();
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        open.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }

    public static boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile()) {
                        if (!listFiles[i].delete()) {
                            return false;
                        }
                    } else if (!deleteFile(listFiles[i])) {
                        return false;
                    } else {
                        listFiles[i].delete();
                    }
                }
            }
        }
        file.delete();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00db A:{SKIP, Catch:{ Throwable -> 0x00e9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb A:{SKIP} */
    public static java.lang.String getExternalStroragePath(android.content.Context r17) {
        /*
        r0 = r17;
        r1 = android.os.Build.VERSION.SDK_INT;
        r3 = 12;
        if (r1 < r3) goto L_0x00e9;
    L_0x0008:
        r3 = "storage";
        r3 = r0.getSystemService(r3);	 Catch:{ Throwable -> 0x00e9 }
        r3 = (android.os.storage.StorageManager) r3;	 Catch:{ Throwable -> 0x00e9 }
        r4 = android.os.storage.StorageManager.class;
        r5 = "getVolumeList";
        r6 = 0;
        r7 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x00e9 }
        r4 = r4.getMethod(r5, r7);	 Catch:{ Throwable -> 0x00e9 }
        r5 = android.os.storage.StorageManager.class;
        r7 = "getVolumeState";
        r8 = 1;
        r9 = new java.lang.Class[r8];	 Catch:{ Throwable -> 0x00e9 }
        r10 = java.lang.String.class;
        r9[r6] = r10;	 Catch:{ Throwable -> 0x00e9 }
        r5 = r5.getMethod(r7, r9);	 Catch:{ Throwable -> 0x00e9 }
        r7 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00e9 }
        r4 = r4.invoke(r3, r7);	 Catch:{ Throwable -> 0x00e9 }
        r4 = (java.lang.Object[]) r4;	 Catch:{ Throwable -> 0x00e9 }
        java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x00e9 }
        r7 = "";
        r9 = "";
        r10 = r4.length;	 Catch:{ Throwable -> 0x00e9 }
        r11 = r9;
        r9 = r7;
        r7 = r6;
    L_0x003d:
        if (r7 >= r10) goto L_0x00c6;
    L_0x003f:
        r13 = r4[r7];	 Catch:{ Throwable -> 0x00e9 }
        r14 = r13.getClass();	 Catch:{ Throwable -> 0x00e9 }
        r15 = "getPath";
        r2 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x00e9 }
        r2 = r14.getMethod(r15, r2);	 Catch:{ Throwable -> 0x00e9 }
        r14 = r13.getClass();	 Catch:{ Throwable -> 0x00e9 }
        r15 = "isRemovable";
        r12 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x00e9 }
        r12 = r14.getMethod(r15, r12);	 Catch:{ Throwable -> 0x00e9 }
        r14 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00e9 }
        r14 = r2.invoke(r13, r14);	 Catch:{ Throwable -> 0x00e9 }
        r14 = (java.lang.String) r14;	 Catch:{ Throwable -> 0x00e9 }
        r15 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x00e9 }
        r8 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00e9 }
        r2 = r2.invoke(r13, r8);	 Catch:{ Throwable -> 0x00e9 }
        r15[r6] = r2;	 Catch:{ Throwable -> 0x00e9 }
        r2 = r5.invoke(r3, r15);	 Catch:{ Throwable -> 0x00e9 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00e9 }
        r8 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00e9 }
        r8 = r12.invoke(r13, r8);	 Catch:{ Throwable -> 0x00e9 }
        r8 = (java.lang.Boolean) r8;	 Catch:{ Throwable -> 0x00e9 }
        r12 = android.text.TextUtils.isEmpty(r14);	 Catch:{ Throwable -> 0x00e9 }
        if (r12 != 0) goto L_0x008c;
    L_0x007f:
        r12 = r14.toLowerCase();	 Catch:{ Throwable -> 0x00e9 }
        r13 = "private";
        r12 = r12.contains(r13);	 Catch:{ Throwable -> 0x00e9 }
        if (r12 == 0) goto L_0x008c;
    L_0x008b:
        goto L_0x00bd;
    L_0x008c:
        r8 = r8.booleanValue();	 Catch:{ Throwable -> 0x00e9 }
        if (r8 == 0) goto L_0x00bf;
    L_0x0092:
        if (r14 == 0) goto L_0x00bd;
    L_0x0094:
        if (r2 == 0) goto L_0x00bd;
    L_0x0096:
        r8 = "mounted";
        r2 = r2.equals(r8);	 Catch:{ Throwable -> 0x00e9 }
        if (r2 == 0) goto L_0x00bd;
    L_0x009e:
        r2 = 18;
        if (r1 > r2) goto L_0x00a3;
    L_0x00a2:
        goto L_0x00ba;
    L_0x00a3:
        r2 = 0;
        r0 = r0.getExternalFilesDirs(r2);	 Catch:{ Exception -> 0x00ba }
        if (r0 == 0) goto L_0x00b8;
    L_0x00aa:
        r2 = r0.length;	 Catch:{ Exception -> 0x00ba }
        r8 = 1;
        if (r2 <= r8) goto L_0x00b6;
    L_0x00ae:
        r0 = r0[r8];	 Catch:{ Exception -> 0x00ba }
        r0 = r0.getAbsolutePath();	 Catch:{ Exception -> 0x00ba }
        r2 = r0;
        goto L_0x00b9;
    L_0x00b6:
        r2 = r14;
        goto L_0x00b9;
    L_0x00b8:
        r2 = 0;
    L_0x00b9:
        r14 = r2;
    L_0x00ba:
        r0 = 18;
        goto L_0x00c9;
    L_0x00bd:
        r8 = 1;
        goto L_0x00c2;
    L_0x00bf:
        r8 = 1;
        r11 = r2;
        r9 = r14;
    L_0x00c2:
        r7 = r7 + 1;
        goto L_0x003d;
    L_0x00c6:
        r0 = 18;
        r14 = 0;
    L_0x00c9:
        if (r1 > r0) goto L_0x00db;
    L_0x00cb:
        if (r14 != 0) goto L_0x00da;
    L_0x00cd:
        if (r9 == 0) goto L_0x00da;
    L_0x00cf:
        if (r11 == 0) goto L_0x00da;
    L_0x00d1:
        r0 = "mounted";
        r0 = r11.equals(r0);	 Catch:{ Throwable -> 0x00e9 }
        if (r0 == 0) goto L_0x00da;
    L_0x00d9:
        r14 = r9;
    L_0x00da:
        return r14;
    L_0x00db:
        if (r9 == 0) goto L_0x00e8;
    L_0x00dd:
        if (r11 == 0) goto L_0x00e8;
    L_0x00df:
        r0 = "mounted";
        r0 = r11.equals(r0);	 Catch:{ Throwable -> 0x00e9 }
        if (r0 == 0) goto L_0x00e8;
    L_0x00e7:
        r14 = r9;
    L_0x00e8:
        return r14;
    L_0x00e9:
        r0 = android.os.Environment.getExternalStorageState();
        r1 = "mounted";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00fe;
    L_0x00f5:
        r0 = android.os.Environment.getExternalStorageDirectory();
        r0 = r0.toString();
        return r0;
    L_0x00fe:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.amap.mapcore.FileUtil.getExternalStroragePath(android.content.Context):java.lang.String");
    }

    public static String getMapBaseStorage(Context context) {
        if (context == null) {
            return null;
        }
        String string;
        StringBuilder stringBuilder;
        File file;
        String str = "map_base_path";
        if (VERSION.SDK_INT > 18) {
            str = "map_base_path_v44";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.trim().length() <= 0) {
            string = sharedPreferences.getString(str, "");
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(MapsInitializer.sdcardDir);
            stringBuilder.append(File.separatorChar);
            string = stringBuilder.toString();
        }
        if (string != null && string.length() > 2) {
            file = new File(string);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return string;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(context.getCacheDir().toString());
                stringBuilder.append(AeUtil.ROOTPATH);
                string = stringBuilder.toString();
                if (string != null && string.length() > 2) {
                    file = new File(string);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (file.isDirectory()) {
                        return string;
                    }
                }
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(getExternalStroragePath(context));
        stringBuilder.append(AeUtil.ROOTPATH);
        string = stringBuilder.toString();
        if (string != null && string.length() > 2) {
            file = new File(string);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory() && file.canWrite()) {
                Editor edit = sharedPreferences.edit();
                edit.putString(str, string);
                edit.commit();
                createNoMediaFileIfNotExist(string);
                return string;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(context.getCacheDir().toString());
        stringBuilder2.append(AeUtil.ROOTPATH);
        String stringBuilder3 = stringBuilder2.toString();
        if (stringBuilder3 != null && stringBuilder3.length() > 2) {
            File file2 = new File(stringBuilder3);
            if (!file2.exists()) {
                file2.mkdir();
            }
            if (file2.isDirectory()) {
                return stringBuilder3;
            }
        }
        return stringBuilder3;
    }

    public static String getName(String str) {
        return str == null ? null : str.substring(indexOfLastSeparator(str) + 1);
    }

    public static int indexOfLastSeparator(String str) {
        return str == null ? -1 : Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static byte[] readFileContents(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, TAG, "readFileContents");
            return null;
        }
    }

    public static byte[] readFileContentsFromAssets(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            int available = open.available();
            if (available == 0) {
                return null;
            }
            byte[] bArr = new byte[available];
            for (int i = 0; i < available; i += open.read(bArr, i, available - i)) {
            }
            open.close();
            return bArr;
        } catch (IOException unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            return null;
        }
    }

    public static void saveFile(String str, String str2, boolean z) {
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(absolutePath);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str2);
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, z);
            fileOutputStream.write(str.getBytes("utf-8"));
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    writeLock.unlock();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                writeLock.unlock();
            }
        }
        writeLock.unlock();
    }
}
