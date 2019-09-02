package cn.jpush.android.d;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public final class c {
    public static String a(Context context, String str) {
        try {
            File d = d(context, str);
            if (d == null) {
                return "";
            }
            if (d.isFile()) {
                d.delete();
            }
            if (!d.exists()) {
                d.mkdirs();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d.getAbsolutePath());
            stringBuilder.append(File.separator);
            return stringBuilder.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.substring(str.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1, str.length());
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(File file) {
        try {
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return file.delete();
            }
            String[] list = file.list();
            if (list != null) {
                for (String file2 : list) {
                    File file3 = new File(file, file2);
                    if (file3.isDirectory()) {
                        a(file3);
                    } else {
                        file3.delete();
                    }
                }
            }
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        byte[] bytes;
        if (str2 != null) {
            try {
                bytes = str2.getBytes(HttpUtils.ENCODING_UTF_8);
            } catch (Exception unused) {
                return false;
            }
        }
        bytes = null;
        return b(str, bytes);
    }

    public static boolean a(String str, byte[] bArr) {
        return bArr != null && bArr.length > 0 && b(str, bArr);
    }

    public static String b(Context context, String str) {
        try {
            if (a.a()) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(absolutePath);
                stringBuilder.append("/Android/data/");
                stringBuilder.append(context.getPackageName());
                stringBuilder.append(File.separator);
                stringBuilder.append(str);
                stringBuilder.append(File.separator);
                String stringBuilder2 = stringBuilder.toString();
                File file = new File(stringBuilder2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return stringBuilder2;
            }
            File d = d(context, "rich");
            if (d != null && d.exists() && d.isDirectory()) {
                File[] listFiles = d.listFiles();
                if (listFiles != null && listFiles.length > 10) {
                    Arrays.sort(listFiles, new d());
                    a(listFiles[listFiles.length - 1]);
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder("rich");
            stringBuilder3.append(File.separator);
            stringBuilder3.append(str);
            return a(context, stringBuilder3.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b A:{Splitter:B:14:0x0027, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:24:0x003b, code skipped:
            r4 = th;
     */
    private static boolean b(java.lang.String r4, byte[] r5) {
        /*
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        if (r5 != 0) goto L_0x000c;
    L_0x000a:
        r5 = new byte[r1];
    L_0x000c:
        r0 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        r4 = r2.exists();	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        if (r4 != 0) goto L_0x002a;
    L_0x0018:
        r4 = r2.getParentFile();	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        if (r4 == 0) goto L_0x0027;
    L_0x001e:
        r3 = r4.exists();	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        if (r3 != 0) goto L_0x0027;
    L_0x0024:
        r4.mkdirs();	 Catch:{ Exception -> 0x0040, all -> 0x003b }
    L_0x0027:
        r2.createNewFile();	 Catch:{ Exception -> 0x002a, all -> 0x003b }
    L_0x002a:
        r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0040, all -> 0x003b }
        r4.write(r5);	 Catch:{ Exception -> 0x0041, all -> 0x0037 }
        a(r4);
        r4 = 1;
        return r4;
    L_0x0037:
        r5 = move-exception;
        r0 = r4;
        r4 = r5;
        goto L_0x003c;
    L_0x003b:
        r4 = move-exception;
    L_0x003c:
        a(r0);
        throw r4;
    L_0x0040:
        r4 = r0;
    L_0x0041:
        a(r4);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.d.c.b(java.lang.String, byte[]):boolean");
    }

    public static String c(Context context, String str) {
        try {
            if (a.a()) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(absolutePath);
                stringBuilder.append("/Android/data/");
                stringBuilder.append(context.getPackageName());
                stringBuilder.append(File.separator);
                stringBuilder.append(str);
                String stringBuilder2 = stringBuilder.toString();
                if (new File(stringBuilder2).exists()) {
                    return stringBuilder2;
                }
                f.c("DirectoryUtils", "Can't find developer picture resource in SDCard.");
                return "";
            }
            f.c("DirectoryUtils", "No SDCard found.");
            return "";
        } catch (Exception e) {
            f.c("DirectoryUtils", "Get developer picture resource failed.");
            e.printStackTrace();
            return "";
        }
    }

    private static File d(Context context, String str) {
        if (context != null) {
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                return new File(filesDir, str);
            }
        }
        return null;
    }
}
