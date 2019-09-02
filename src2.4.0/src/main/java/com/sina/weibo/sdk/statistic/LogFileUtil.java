package com.sina.weibo.sdk.statistic;

import android.os.Environment;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.sina.weibo.sdk.utils.MD5;
import java.io.File;

class LogFileUtil {
    public static final String ANALYTICS_FILE_NAME = "app_logs";
    private static final String ANALYTICS_FILE_SUFFIX = ".txt";
    private static final String SDCARD_WEIBO_ANALYTICS_DIR = "/sina/weibo/.applogs/";

    LogFileUtil() {
    }

    public static boolean delete(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        file.delete();
        return true;
    }

    public static String getAppLogPath(String str) {
        String str2 = "";
        if (LogReport.getPackageName() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(MD5.hexdigest(LogReport.getPackageName()));
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            str2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(getSDPath());
        stringBuilder2.append(SDCARD_WEIBO_ANALYTICS_DIR);
        stringBuilder2.append(str2);
        stringBuilder2.append(str);
        stringBuilder2.append(ANALYTICS_FILE_SUFFIX);
        return stringBuilder2.toString();
    }

    public static String getAppLogs(String str) {
        return TextUtils.isEmpty(str) ? "" : readStringFromFile(str);
    }

    private static String getSDPath() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
        return externalStorageDirectory != null ? externalStorageDirectory.toString() : null;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0059=Splitter:B:33:0x0059, B:27:0x004f=Splitter:B:27:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0066 A:{SYNTHETIC, Splitter:B:40:0x0066} */
    /* JADX WARNING: Missing block: B:29:0x0052, code skipped:
            if (r4 != null) goto L_0x0054;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:35:0x005c, code skipped:
            if (r4 != null) goto L_0x0054;
     */
    private static java.lang.String readStringFromFile(java.lang.String r4) {
        /*
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r4 = "";
        return r4;
    L_0x0009:
        r0 = new java.io.File;
        r0.<init>(r4);
        r4 = r0.isFile();
        if (r4 == 0) goto L_0x006a;
    L_0x0014:
        r4 = r0.exists();
        if (r4 != 0) goto L_0x001b;
    L_0x001a:
        goto L_0x006a;
    L_0x001b:
        r4 = 0;
        r1 = new java.lang.StringBuilder;
        r2 = r0.length();
        r2 = (int) r2;
        r1.<init>(r2);
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0058, OutOfMemoryError -> 0x004e }
        r3 = new java.io.FileReader;	 Catch:{ IOException -> 0x0058, OutOfMemoryError -> 0x004e }
        r3.<init>(r0);	 Catch:{ IOException -> 0x0058, OutOfMemoryError -> 0x004e }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0058, OutOfMemoryError -> 0x004e }
    L_0x0030:
        r4 = r2.readLine();	 Catch:{ IOException -> 0x0048, OutOfMemoryError -> 0x0044, all -> 0x0040 }
        if (r4 == 0) goto L_0x003a;
    L_0x0036:
        r1.append(r4);	 Catch:{ IOException -> 0x0048, OutOfMemoryError -> 0x0044, all -> 0x0040 }
        goto L_0x0030;
    L_0x003a:
        if (r2 == 0) goto L_0x005f;
    L_0x003c:
        r2.close();	 Catch:{ IOException -> 0x005f }
        goto L_0x005f;
    L_0x0040:
        r4 = move-exception;
        r0 = r4;
        r4 = r2;
        goto L_0x0064;
    L_0x0044:
        r4 = move-exception;
        r0 = r4;
        r4 = r2;
        goto L_0x004f;
    L_0x0048:
        r4 = move-exception;
        r0 = r4;
        r4 = r2;
        goto L_0x0059;
    L_0x004c:
        r0 = move-exception;
        goto L_0x0064;
    L_0x004e:
        r0 = move-exception;
    L_0x004f:
        r0.printStackTrace();	 Catch:{ all -> 0x004c }
        if (r4 == 0) goto L_0x005f;
    L_0x0054:
        r4.close();	 Catch:{ IOException -> 0x005f }
        goto L_0x005f;
    L_0x0058:
        r0 = move-exception;
    L_0x0059:
        r0.printStackTrace();	 Catch:{ all -> 0x004c }
        if (r4 == 0) goto L_0x005f;
    L_0x005e:
        goto L_0x0054;
    L_0x005f:
        r4 = r1.toString();
        return r4;
    L_0x0064:
        if (r4 == 0) goto L_0x0069;
    L_0x0066:
        r4.close();	 Catch:{ IOException -> 0x0069 }
    L_0x0069:
        throw r0;
    L_0x006a:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogFileUtil.readStringFromFile(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A:{SYNTHETIC, Splitter:B:38:0x00a5} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1 A:{SYNTHETIC, Splitter:B:57:0x00c1} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6 A:{SYNTHETIC, Splitter:B:49:0x00b6} */
    /* JADX WARNING: Missing block: B:63:0x00ca, code skipped:
            return;
     */
    public static synchronized void writeToFile(java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
        r0 = com.sina.weibo.sdk.statistic.LogFileUtil.class;
        monitor-enter(r0);
        r1 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x00cb }
        if (r1 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r0);
        return;
    L_0x000b:
        r1 = "WBAgent";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cb }
        r2.<init>();	 Catch:{ all -> 0x00cb }
        r3 = "filePath:";
        r2.append(r3);	 Catch:{ all -> 0x00cb }
        r2.append(r9);	 Catch:{ all -> 0x00cb }
        r2 = r2.toString();	 Catch:{ all -> 0x00cb }
        com.sina.weibo.sdk.utils.LogUtil.i(r1, r2);	 Catch:{ all -> 0x00cb }
        if (r10 == 0) goto L_0x00c9;
    L_0x0023:
        r1 = r10.length();	 Catch:{ all -> 0x00cb }
        if (r1 != 0) goto L_0x002b;
    L_0x0029:
        goto L_0x00c9;
    L_0x002b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cb }
        r1.<init>(r10);	 Catch:{ all -> 0x00cb }
        r10 = 0;
        r2 = r1.charAt(r10);	 Catch:{ all -> 0x00cb }
        r3 = 91;
        r4 = 1;
        if (r2 != r3) goto L_0x003f;
    L_0x003a:
        r2 = "";
        r1.replace(r10, r4, r2);	 Catch:{ all -> 0x00cb }
    L_0x003f:
        r2 = r1.length();	 Catch:{ all -> 0x00cb }
        r2 = r2 - r4;
        r2 = r1.charAt(r2);	 Catch:{ all -> 0x00cb }
        r3 = 44;
        if (r2 == r3) goto L_0x005a;
    L_0x004c:
        r2 = r1.length();	 Catch:{ all -> 0x00cb }
        r2 = r2 - r4;
        r3 = r1.length();	 Catch:{ all -> 0x00cb }
        r4 = ",";
        r1.replace(r2, r3, r4);	 Catch:{ all -> 0x00cb }
    L_0x005a:
        r2 = new java.io.File;	 Catch:{ all -> 0x00cb }
        r2.<init>(r9);	 Catch:{ all -> 0x00cb }
        r9 = 0;
        r3 = r2.getParentFile();	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        r4 = r3.exists();	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        if (r4 != 0) goto L_0x006d;
    L_0x006a:
        r3.mkdirs();	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
    L_0x006d:
        r3 = r2.exists();	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        if (r3 != 0) goto L_0x0077;
    L_0x0073:
        r2.createNewFile();	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        goto L_0x0093;
    L_0x0077:
        r3 = r2.lastModified();	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        r5 = 0;
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 <= 0) goto L_0x0093;
    L_0x0081:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        r5 = r2.lastModified();	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        r7 = r3 - r5;
        r3 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x0093;
    L_0x0092:
        goto L_0x0094;
    L_0x0093:
        r10 = r11;
    L_0x0094:
        r11 = new java.io.FileWriter;	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        r11.<init>(r2, r10);	 Catch:{ IOException -> 0x00bf, all -> 0x00b3 }
        r9 = r1.toString();	 Catch:{ IOException -> 0x00b1, all -> 0x00ae }
        r11.write(r9);	 Catch:{ IOException -> 0x00b1, all -> 0x00ae }
        r11.flush();	 Catch:{ IOException -> 0x00b1, all -> 0x00ae }
        if (r11 == 0) goto L_0x00c7;
    L_0x00a5:
        r11.close();	 Catch:{ IOException -> 0x00a9 }
        goto L_0x00c7;
    L_0x00a9:
        r9 = move-exception;
    L_0x00aa:
        r9.printStackTrace();	 Catch:{ all -> 0x00cb }
        goto L_0x00c7;
    L_0x00ae:
        r10 = move-exception;
        r9 = r11;
        goto L_0x00b4;
    L_0x00b1:
        r9 = r11;
        goto L_0x00bf;
    L_0x00b3:
        r10 = move-exception;
    L_0x00b4:
        if (r9 == 0) goto L_0x00be;
    L_0x00b6:
        r9.close();	 Catch:{ IOException -> 0x00ba }
        goto L_0x00be;
    L_0x00ba:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x00cb }
    L_0x00be:
        throw r10;	 Catch:{ all -> 0x00cb }
    L_0x00bf:
        if (r9 == 0) goto L_0x00c7;
    L_0x00c1:
        r9.close();	 Catch:{ IOException -> 0x00c5 }
        goto L_0x00c7;
    L_0x00c5:
        r9 = move-exception;
        goto L_0x00aa;
    L_0x00c7:
        monitor-exit(r0);
        return;
    L_0x00c9:
        monitor-exit(r0);
        return;
    L_0x00cb:
        r9 = move-exception;
        monitor-exit(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogFileUtil.writeToFile(java.lang.String, java.lang.String, boolean):void");
    }
}
