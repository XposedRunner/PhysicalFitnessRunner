package com.autonavi.amap.mapcore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.mapcore.util.o0O0oo0o;
import com.amap.api.mapcore.util.oO0O000o;
import com.amap.api.mapcore.util.oO0O00o0;
import com.amap.api.mapcore.util.oOo0oooO;
import com.amap.api.mapcore.util.ooOOOOoo;
import com.amap.api.mapcore.util.r;
import com.amap.api.mapcore.util.s;
import com.autonavi.ae.gmap.GLMapEngine.InitParam;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@SuppressLint({"NewApi"})
public class AeUtil {
    private static final int BUFFER = 1024;
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    public static final String SO_FILENAME = "AMapSDK_MAP_v6_8_0";
    public static final String SO_FILENAME_NAVI = "AMapSDK_NAVI_v6_5_0";

    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    public interface ZipCompressProgressListener {
        void onFinishProgress(long j);
    }

    private static boolean checkEngineRes(File file) {
        File[] listFiles = file.listFiles();
        return listFiles != null && listFiles.length >= 2;
    }

    private static void decompress(File file, File file2, ZipInputStream zipInputStream, long j, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        UnZipFileBrake unZipFileBrake2 = unZipFileBrake;
        Object obj = null;
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            } else if (unZipFileBrake2 == null || !unZipFileBrake2.mIsAborted) {
                String name = nextEntry.getName();
                if (TextUtils.isEmpty(name) || name.contains("../")) {
                    obj = 1;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(file2.getPath());
                    stringBuilder.append(File.separator);
                    stringBuilder.append(name);
                    File file3 = new File(stringBuilder.toString());
                    fileProber(file3);
                    if (nextEntry.isDirectory()) {
                        file3.mkdirs();
                    } else {
                        i += decompressFile(file3, zipInputStream, (long) i, j, zipCompressProgressListener, unZipFileBrake2);
                    }
                    zipInputStream.closeEntry();
                }
            } else {
                zipInputStream.closeEntry();
                return;
            }
        }
        obj = 1;
        if (!(obj == null || file == null)) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0, null);
    }

    private static void decompress(InputStream inputStream, String str, long j, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress(null, new File(str), zipInputStream, j, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j, long j2, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            } else if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && zipCompressProgressListener != null) {
                    long j3 = ((j + ((long) i)) * 100) / j2;
                    if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                        zipCompressProgressListener.onFinishProgress(j3);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i;
            }
        }
    }

    private static void fileProber(File file) {
        file = file.getParentFile();
        if (!file.exists()) {
            fileProber(file);
            file.mkdir();
        }
    }

    public static InitParam initResource(final Context context) {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mapBaseStorage);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(ROOT_DATA_PATH_NAME);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(stringBuilder2);
        if (!file.exists()) {
            file.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                r.O000000o(1).O000000o(new s() {
                    public void runTask() {
                        AeUtil.loadEngineRes(mapBaseStorage, context);
                    }
                });
            } catch (o0O0oo0o e) {
                e.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        InitParam initParam = new InitParam();
        byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (readFileContentsFromAssets != null) {
            try {
                initParam.mConfigContent = new String(readFileContentsFromAssets, "utf-8");
                if (!initParam.mConfigContent.contains(ROOT_DATA_PATH_NAME)) {
                    throw new Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder3.append("map/");
        initParam.mOfflineDataPath = stringBuilder3.toString();
        initParam.mP3dCrossPath = stringBuilder2;
        return initParam;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0055=Splitter:B:31:0x0055, B:25:0x004b=Splitter:B:25:0x004b} */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005a A:{SYNTHETIC, Splitter:B:34:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A:{SYNTHETIC, Splitter:B:28:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0060 A:{SYNTHETIC, Splitter:B:37:0x0060} */
    private static void loadEngineRes(java.lang.String r3, android.content.Context r4) {
        /*
        r0 = new java.io.File;
        r1 = "res";
        r0.<init>(r3, r1);
        r3 = r0.exists();
        if (r3 == 0) goto L_0x0013;
    L_0x000d:
        r3 = r0.isDirectory();
        if (r3 != 0) goto L_0x0016;
    L_0x0013:
        r0.mkdirs();
    L_0x0016:
        r3 = checkEngineRes(r0);
        if (r3 != 0) goto L_0x0069;
    L_0x001c:
        r3 = 0;
        r4 = r4.getAssets();	 Catch:{ Exception -> 0x0054, OutOfMemoryError -> 0x004a }
        r1 = "ae/res.zip";
        r4 = r4.open(r1);	 Catch:{ Exception -> 0x0054, OutOfMemoryError -> 0x004a }
        r3 = r0.getAbsolutePath();	 Catch:{ Exception -> 0x0043, OutOfMemoryError -> 0x003e, all -> 0x0039 }
        decompress(r4, r3);	 Catch:{ Exception -> 0x0043, OutOfMemoryError -> 0x003e, all -> 0x0039 }
        if (r4 == 0) goto L_0x0069;
    L_0x0030:
        r4.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x0069;
    L_0x0034:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0069;
    L_0x0039:
        r3 = move-exception;
        r2 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x005e;
    L_0x003e:
        r3 = move-exception;
        r2 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x004b;
    L_0x0043:
        r3 = move-exception;
        r2 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x0055;
    L_0x0048:
        r4 = move-exception;
        goto L_0x005e;
    L_0x004a:
        r4 = move-exception;
    L_0x004b:
        r4.printStackTrace();	 Catch:{ all -> 0x0048 }
        if (r3 == 0) goto L_0x0069;
    L_0x0050:
        r3.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x0069;
    L_0x0054:
        r4 = move-exception;
    L_0x0055:
        r4.printStackTrace();	 Catch:{ all -> 0x0048 }
        if (r3 == 0) goto L_0x0069;
    L_0x005a:
        r3.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x0069;
    L_0x005e:
        if (r3 == 0) goto L_0x0068;
    L_0x0060:
        r3.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0068;
    L_0x0064:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x0068:
        throw r4;
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.amap.mapcore.AeUtil.loadEngineRes(java.lang.String, android.content.Context):void");
    }

    public static void loadLib(Context context) {
        try {
            if (oOo0oooO.O000000o().O000000o(context, OOo000.O00000oO(), oO0O00o0.O000000o(context).O00000o(), SO_FILENAME) && oO0O000o.O000000o().O000000o(context, OOo000.O00000oO())) {
                new MsgProcessor().nativeInitMsg();
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AeUtil", "loadLib");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0064 A:{SYNTHETIC, Splitter:B:42:0x0064} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006e A:{SYNTHETIC, Splitter:B:47:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0078 A:{SYNTHETIC, Splitter:B:53:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0082 A:{SYNTHETIC, Splitter:B:58:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0078 A:{SYNTHETIC, Splitter:B:53:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0082 A:{SYNTHETIC, Splitter:B:58:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0064 A:{SYNTHETIC, Splitter:B:42:0x0064} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006e A:{SYNTHETIC, Splitter:B:47:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0078 A:{SYNTHETIC, Splitter:B:53:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0082 A:{SYNTHETIC, Splitter:B:58:0x0082} */
    public static void readAssetsFileAndSave(java.lang.String r4, java.lang.String r5, android.content.Context r6) {
        /*
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = 0;
        r6 = r6.getAssets();	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r4 = r6.open(r4);	 Catch:{ Throwable -> 0x005d, all -> 0x005a }
        r6 = new java.io.File;	 Catch:{ Throwable -> 0x0055, all -> 0x0053 }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x0055, all -> 0x0053 }
        r5 = r6.exists();	 Catch:{ Throwable -> 0x0055, all -> 0x0053 }
        if (r5 == 0) goto L_0x001e;
    L_0x001b:
        r6.delete();	 Catch:{ Throwable -> 0x0055, all -> 0x0053 }
    L_0x001e:
        r6.createNewFile();	 Catch:{ Throwable -> 0x0055, all -> 0x0053 }
        r5 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0055, all -> 0x0053 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x0055, all -> 0x0053 }
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r6];	 Catch:{ Throwable -> 0x004e, all -> 0x004a }
    L_0x002a:
        r1 = 0;
        r2 = r4.read(r0, r1, r6);	 Catch:{ Throwable -> 0x004e, all -> 0x004a }
        if (r2 <= 0) goto L_0x0035;
    L_0x0031:
        r5.write(r0, r1, r2);	 Catch:{ Throwable -> 0x004e, all -> 0x004a }
        goto L_0x002a;
    L_0x0035:
        if (r4 == 0) goto L_0x003f;
    L_0x0037:
        r4.close();	 Catch:{ IOException -> 0x003b }
        goto L_0x003f;
    L_0x003b:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x003f:
        if (r5 == 0) goto L_0x0071;
    L_0x0041:
        r5.close();	 Catch:{ IOException -> 0x0045 }
        goto L_0x0071;
    L_0x0045:
        r4 = move-exception;
        r4.printStackTrace();
        goto L_0x0071;
    L_0x004a:
        r6 = move-exception;
        r0 = r5;
        r5 = r6;
        goto L_0x0076;
    L_0x004e:
        r6 = move-exception;
        r0 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x005f;
    L_0x0053:
        r5 = move-exception;
        goto L_0x0076;
    L_0x0055:
        r5 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x005f;
    L_0x005a:
        r5 = move-exception;
        r4 = r0;
        goto L_0x0076;
    L_0x005d:
        r5 = move-exception;
        r4 = r0;
    L_0x005f:
        r5.printStackTrace();	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x006c;
    L_0x0064:
        r0.close();	 Catch:{ IOException -> 0x0068 }
        goto L_0x006c;
    L_0x0068:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x006c:
        if (r4 == 0) goto L_0x0071;
    L_0x006e:
        r4.close();	 Catch:{ IOException -> 0x0045 }
    L_0x0071:
        return;
    L_0x0072:
        r5 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
    L_0x0076:
        if (r4 == 0) goto L_0x0080;
    L_0x0078:
        r4.close();	 Catch:{ IOException -> 0x007c }
        goto L_0x0080;
    L_0x007c:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0080:
        if (r0 == 0) goto L_0x008a;
    L_0x0082:
        r0.close();	 Catch:{ IOException -> 0x0086 }
        goto L_0x008a;
    L_0x0086:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x008a:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.amap.mapcore.AeUtil.readAssetsFileAndSave(java.lang.String, java.lang.String, android.content.Context):void");
    }
}
