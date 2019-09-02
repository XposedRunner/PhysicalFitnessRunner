package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* compiled from: ServiceUtils */
public class o0O000o0 {
    public static int O000000o = -1;
    private static AssetManager O00000Oo = null;
    private static Resources O00000o = null;
    private static Resources O00000o0 = null;
    private static boolean O00000oO = true;
    private static Context O00000oo = null;
    private static String O0000O0o = "amap_resource";
    private static String O0000OOo = "1_0_0";
    private static String O0000Oo = ".jar";
    private static String O0000Oo0 = ".png";
    private static String O0000OoO = null;
    private static String O0000Ooo = null;
    private static Field O0000o = null;
    private static String O0000o0 = null;
    private static String O0000o00 = "";
    private static Theme O0000o0O;
    private static Theme O0000o0o;
    private static Activity O0000oO;
    private static Field O0000oO0;

    /* compiled from: ServiceUtils */
    static class O000000o implements FilenameFilter {
        O000000o() {
        }

        public boolean accept(File file, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(o0O000o0.O0000OOo);
            stringBuilder.append(o0O000o0.O0000Oo);
            return str.startsWith(o0O000o0.O0000O0o) && !str.endsWith(stringBuilder.toString());
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000O0o);
        stringBuilder.append(O0000OOo);
        stringBuilder.append(O0000Oo);
        O0000OoO = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(O0000O0o);
        stringBuilder.append(O0000OOo);
        stringBuilder.append(O0000Oo0);
        O0000Ooo = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(O0000o00);
        stringBuilder.append(O0000OoO);
        O0000o0 = stringBuilder.toString();
    }

    private static AssetManager O000000o(String str) {
        AssetManager assetManager;
        Throwable th;
        try {
            Class cls = Class.forName("android.content.res.AssetManager");
            assetManager = (AssetManager) cls.getConstructor((Class[]) null).newInstance((Object[]) null);
            try {
                cls.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            assetManager = null;
            ooOOOOoo.O00000o0(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager;
        }
        return assetManager;
    }

    public static Resources O000000o() {
        return O00000o0 == null ? O00000oo.getResources() : O00000o0;
    }

    private static Resources O000000o(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    public static View O000000o(Context context, int i, ViewGroup viewGroup) {
        View th;
        XmlResourceParser xml = O000000o().getXml(i);
        if (!O00000oO) {
            return LayoutInflater.from(context).inflate(xml, viewGroup);
        }
        try {
            th = LayoutInflater.from(new o0O000Oo(context, O000000o == -1 ? 0 : O000000o, o0O000o0.class.getClassLoader())).inflate(xml, viewGroup);
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            ooOOOOoo.O00000o0(th, "ResourcesUtil", "selfInflate(Activity activity, int resource, ViewGroup root)");
            th = null;
            return th;
        } finally {
            xml.close();
        }
        return th;
    }

    private static OutputStream O000000o(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(O0000o00, O0000OoO));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean O000000o(Context context) {
        try {
            O00000oo = context;
            File O00000Oo = O00000Oo(O00000oo);
            if (O00000Oo != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(O00000Oo.getAbsolutePath());
                stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                O0000o00 = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(O0000o00);
            stringBuilder2.append(O0000OoO);
            O0000o0 = stringBuilder2.toString();
            if (!O00000oO) {
                return true;
            }
            if (!O00000o0(context)) {
                return false;
            }
            O00000Oo = O000000o(O0000o0);
            O00000o0 = O000000o(context, O00000Oo);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static File O00000Oo(Context context) {
        File file;
        Exception e;
        Throwable th;
        File file2 = null;
        if (context == null) {
            if (context != null) {
                context.getFilesDir();
            }
            return null;
        }
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                try {
                    file2 = !externalStorageDirectory.canWrite() ? context.getFilesDir() : context.getExternalFilesDir("LBS");
                } catch (Exception e2) {
                    file = externalStorageDirectory;
                    e = e2;
                    file2 = file;
                    try {
                        e.printStackTrace();
                        if (file2 == null && context != null) {
                            file2 = context.getFilesDir();
                        }
                        return file2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (file2 == null && context != null) {
                            context.getFilesDir();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    file = externalStorageDirectory;
                    th = th3;
                    file2 = file;
                    context.getFilesDir();
                    throw th;
                }
            }
            file2 = context.getFilesDir();
            if (file2 == null && context != null) {
                context.getFilesDir();
            }
            return file2;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            file2 = context.getFilesDir();
            return file2;
        }
    }

    private static boolean O00000Oo(InputStream inputStream) throws IOException {
        File file = new File(O0000o0);
        long length = file.length();
        int available = inputStream.available();
        if (!file.exists() || length != ((long) available)) {
            return false;
        }
        inputStream.close();
        return true;
    }

    private static void O00000o(Context context) {
        O0000o00 = context.getFilesDir().getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000o00);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(O0000OoO);
        O0000o0 = stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0077 A:{SYNTHETIC, Splitter:B:40:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065 A:{SYNTHETIC, Splitter:B:34:0x0065} */
    private static boolean O00000o0(android.content.Context r4) {
        /*
        O00000o(r4);
        r0 = 0;
        r4 = r4.getResources();	 Catch:{ Throwable -> 0x0057 }
        r4 = r4.getAssets();	 Catch:{ Throwable -> 0x0057 }
        r1 = O0000Ooo;	 Catch:{ Throwable -> 0x0057 }
        r4 = r4.open(r1);	 Catch:{ Throwable -> 0x0057 }
        r0 = O00000Oo(r4);	 Catch:{ Throwable -> 0x0050, all -> 0x004b }
        r1 = 1;
        if (r0 == 0) goto L_0x002b;
    L_0x0019:
        if (r4 == 0) goto L_0x002a;
    L_0x001b:
        r4.close();	 Catch:{ IOException -> 0x001f }
        goto L_0x002a;
    L_0x001f:
        r4 = move-exception;
        r4.printStackTrace();
        r0 = "ResourcesUtil";
        r2 = "copyResourceJarToAppFilesDir(Context ctx)";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r4, r0, r2);
    L_0x002a:
        return r1;
    L_0x002b:
        O00000oO();	 Catch:{ Throwable -> 0x0050, all -> 0x004b }
        r0 = O000000o(r4);	 Catch:{ Throwable -> 0x0050, all -> 0x004b }
        if (r4 == 0) goto L_0x003a;
    L_0x0034:
        r4.close();	 Catch:{ IOException -> 0x0038 }
        goto L_0x003a;
    L_0x0038:
        r4 = move-exception;
        goto L_0x0040;
    L_0x003a:
        if (r0 == 0) goto L_0x004a;
    L_0x003c:
        r0.close();	 Catch:{ IOException -> 0x0038 }
        goto L_0x004a;
    L_0x0040:
        r4.printStackTrace();
        r0 = "ResourcesUtil";
        r2 = "copyResourceJarToAppFilesDir(Context ctx)";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r4, r0, r2);
    L_0x004a:
        return r1;
    L_0x004b:
        r0 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0075;
    L_0x0050:
        r0 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0058;
    L_0x0055:
        r4 = move-exception;
        goto L_0x0075;
    L_0x0057:
        r4 = move-exception;
    L_0x0058:
        r4.printStackTrace();	 Catch:{ all -> 0x0055 }
        r1 = "ResourcesUtil";
        r2 = "copyResourceJarToAppFilesDir(Context ctx)";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r4, r1, r2);	 Catch:{ all -> 0x0055 }
        r4 = 0;
        if (r0 == 0) goto L_0x0074;
    L_0x0065:
        r0.close();	 Catch:{ IOException -> 0x0069 }
        goto L_0x0074;
    L_0x0069:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "ResourcesUtil";
        r2 = "copyResourceJarToAppFilesDir(Context ctx)";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r1, r2);
    L_0x0074:
        return r4;
    L_0x0075:
        if (r0 == 0) goto L_0x0086;
    L_0x0077:
        r0.close();	 Catch:{ IOException -> 0x007b }
        goto L_0x0086;
    L_0x007b:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = "ResourcesUtil";
        r2 = "copyResourceJarToAppFilesDir(Context ctx)";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r1, r2);
    L_0x0086:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0O000o0.O00000o0(android.content.Context):boolean");
    }

    private static void O00000oO() {
        File[] listFiles = new File(O0000o00).listFiles(new O000000o());
        if (listFiles != null && listFiles.length > 0) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }
}
