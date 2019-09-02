package com.bangcle.andJni;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: JniLib */
public class JniLib1557756502 {
    private static final String LIB_DIR = "lib";
    private static final String TAG = "LibraryLoaderHelper";
    private static boolean sLibrariesWereUnpacked;

    static {
        try {
            System.loadLibrary("deepknow");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, e.toString());
            try {
                tryLoadLibraryUsingWorkaround(getApplicationUsingReflection().getApplicationContext(), "deepknow");
                Log.e(TAG, "tryLoadLibraryUsingWorkaround over");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean InvokeBoolean(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return ((Boolean) method.invoke(obj, objArr2)).booleanValue();
    }

    public static byte InvokeByte(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return ((Byte) method.invoke(obj, objArr2)).byteValue();
    }

    public static char InvokeChar(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return ((Character) method.invoke(obj, objArr2)).charValue();
    }

    public static double InvokeDouble(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return ((Double) method.invoke(obj, objArr2)).doubleValue();
    }

    public static float InvokeFloat(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return ((Float) method.invoke(obj, objArr2)).floatValue();
    }

    public static int InvokeInt(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return ((Integer) method.invoke(obj, objArr2)).intValue();
    }

    public static long InvokeLong(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return ((Long) method.invoke(obj, objArr2)).longValue();
    }

    public static Object InvokeObject(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return method.invoke(obj, objArr2);
    }

    public static short InvokeShort(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        return ((Short) method.invoke(obj, objArr2)).shortValue();
    }

    public static void InvokeVoid(Object... objArr) throws Exception {
        int i = 0;
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[(objArr.length - 2)];
        while (i < objArr.length - 2) {
            objArr2[i] = objArr[i + 2];
            i++;
        }
        method.invoke(obj, objArr2);
    }

    public static native void a(Class cls, int i);

    public static void b() {
    }

    public static native byte cB(Object... objArr);

    public static native char cC(Object... objArr);

    public static native double cD(Object... objArr);

    public static native float cF(Object... objArr);

    public static native int cI(Object... objArr);

    public static native long cJ(Object... objArr);

    public static native Object cL(Object... objArr);

    public static native short cS(Object... objArr);

    public static native void cV(Object... objArr);

    public static native boolean cZ(Object... objArr);

    private static void deleteDirectorySync(File file) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!file2.delete()) {
                        String str = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to remove ");
                        stringBuilder.append(file2.getAbsolutePath());
                        Log.e(str, stringBuilder.toString());
                    }
                }
            }
            if (!file.delete()) {
                String str2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Failed to remove ");
                stringBuilder2.append(file.getAbsolutePath());
                Log.w(str2, stringBuilder2.toString());
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to remove old libs, ", e);
        }
    }

    public static Application getApplicationUsingReflection() throws Exception {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[]) null);
    }

    private static String getJniNameInApk(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lib/");
        stringBuilder.append(Build.CPU_ABI);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(System.mapLibraryName(str));
        return stringBuilder.toString();
    }

    private static String[] getSupportAbis() {
        if (VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        if (Build.CPU_ABI.equals("armeabi") || Build.CPU_ABI.equals("armeabi-v7a")) {
            return new String[]{"armeabi", "armeabi-v7a"};
        }
        return new String[]{Build.CPU_ABI};
    }

    public static File getWorkaroundLibDir(Context context) {
        File file = new File(context.getFilesDir().getParent(), ".cache");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private static File getWorkaroundLibFile(Context context, String str) {
        return new File(getWorkaroundLibDir(context), System.mapLibraryName(str));
    }

    private static ZipEntry getZipEntry(ZipFile zipFile, String str) {
        for (String str2 : getSupportAbis()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LIB_DIR);
            stringBuilder.append(File.separatorChar);
            stringBuilder.append(str2);
            stringBuilder.append(File.separatorChar);
            stringBuilder.append(System.mapLibraryName(str));
            ZipEntry entry = zipFile.getEntry(stringBuilder.toString());
            if (entry != null) {
                return entry;
            }
        }
        return null;
    }

    static boolean tryLoadLibraryUsingWorkaround(Context context, String str) {
        File workaroundLibFile = getWorkaroundLibFile(context, str);
        if (!workaroundLibFile.exists() && !unpackLibrariesOnce(context, str)) {
            return false;
        }
        try {
            System.load(workaroundLibFile.getAbsolutePath());
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b8 A:{SYNTHETIC, Splitter:B:48:0x00b8} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c5 A:{Catch:{ all -> 0x00bc, all -> 0x0094, IOException -> 0x00c9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b8 A:{SYNTHETIC, Splitter:B:48:0x00b8} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c5 A:{Catch:{ all -> 0x00bc, all -> 0x0094, IOException -> 0x00c9 }} */
    private static boolean unpackLibrariesOnce(android.content.Context r7, java.lang.String r8) {
        /*
        r0 = sLibrariesWereUnpacked;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = 1;
        sLibrariesWereUnpacked = r0;
        r2 = getWorkaroundLibDir(r7);
        deleteDirectorySync(r2);
        r3 = r7.getApplicationInfo();	 Catch:{ IOException -> 0x00f4 }
        r4 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x00f4 }
        r5 = new java.io.File;	 Catch:{ IOException -> 0x00f4 }
        r6 = r3.sourceDir;	 Catch:{ IOException -> 0x00f4 }
        r5.<init>(r6);	 Catch:{ IOException -> 0x00f4 }
        r4.<init>(r5, r0);	 Catch:{ IOException -> 0x00f4 }
        r5 = getZipEntry(r4, r8);	 Catch:{ IOException -> 0x00f4 }
        if (r5 != 0) goto L_0x004c;
    L_0x0026:
        r7 = "LibraryLoaderHelper";
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f4 }
        r8.<init>();	 Catch:{ IOException -> 0x00f4 }
        r0 = r3.sourceDir;	 Catch:{ IOException -> 0x00f4 }
        r8.append(r0);	 Catch:{ IOException -> 0x00f4 }
        r0 = " doesn't have file ";
        r8.append(r0);	 Catch:{ IOException -> 0x00f4 }
        r0 = r5.getName();	 Catch:{ IOException -> 0x00f4 }
        r8.append(r0);	 Catch:{ IOException -> 0x00f4 }
        r8 = r8.toString();	 Catch:{ IOException -> 0x00f4 }
        android.util.Log.e(r7, r8);	 Catch:{ IOException -> 0x00f4 }
        r4.close();	 Catch:{ IOException -> 0x00f4 }
        deleteDirectorySync(r2);	 Catch:{ IOException -> 0x00f4 }
        return r1;
    L_0x004c:
        r7 = getWorkaroundLibFile(r7, r8);	 Catch:{ IOException -> 0x00f4 }
        r8 = "LibraryLoaderHelper";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f4 }
        r3.<init>();	 Catch:{ IOException -> 0x00f4 }
        r6 = "Extracting native libraries into ";
        r3.append(r6);	 Catch:{ IOException -> 0x00f4 }
        r6 = r7.getAbsolutePath();	 Catch:{ IOException -> 0x00f4 }
        r3.append(r6);	 Catch:{ IOException -> 0x00f4 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x00f4 }
        android.util.Log.i(r8, r3);	 Catch:{ IOException -> 0x00f4 }
        r8 = r7.createNewFile();	 Catch:{ IOException -> 0x00c9 }
        if (r8 != 0) goto L_0x0076;
    L_0x0070:
        r8 = new java.io.IOException;	 Catch:{ IOException -> 0x00c9 }
        r8.<init>();	 Catch:{ IOException -> 0x00c9 }
        throw r8;	 Catch:{ IOException -> 0x00c9 }
    L_0x0076:
        r8 = 0;
        r3 = r4.getInputStream(r5);	 Catch:{ all -> 0x00b2 }
        r5 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00af }
        r5.<init>(r7);	 Catch:{ all -> 0x00af }
        r8 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r8 = new byte[r8];	 Catch:{ all -> 0x00ad }
    L_0x0084:
        r6 = r3.read(r8);	 Catch:{ all -> 0x00ad }
        if (r6 <= 0) goto L_0x008e;
    L_0x008a:
        r5.write(r8, r1, r6);	 Catch:{ all -> 0x00ad }
        goto L_0x0084;
    L_0x008e:
        if (r3 == 0) goto L_0x009b;
    L_0x0090:
        r3.close();	 Catch:{ all -> 0x0094 }
        goto L_0x009b;
    L_0x0094:
        r8 = move-exception;
        if (r5 == 0) goto L_0x009a;
    L_0x0097:
        r5.close();	 Catch:{ IOException -> 0x00c9 }
    L_0x009a:
        throw r8;	 Catch:{ IOException -> 0x00c9 }
    L_0x009b:
        if (r5 == 0) goto L_0x00a0;
    L_0x009d:
        r5.close();	 Catch:{ IOException -> 0x00c9 }
    L_0x00a0:
        r7.setReadable(r0, r1);	 Catch:{ IOException -> 0x00c9 }
        r7.setExecutable(r0, r1);	 Catch:{ IOException -> 0x00c9 }
        r7.setWritable(r0);	 Catch:{ IOException -> 0x00c9 }
        r4.close();	 Catch:{ IOException -> 0x00f4 }
        return r0;
    L_0x00ad:
        r8 = move-exception;
        goto L_0x00b6;
    L_0x00af:
        r0 = move-exception;
        r5 = r8;
        goto L_0x00b5;
    L_0x00b2:
        r0 = move-exception;
        r3 = r8;
        r5 = r3;
    L_0x00b5:
        r8 = r0;
    L_0x00b6:
        if (r3 == 0) goto L_0x00c3;
    L_0x00b8:
        r3.close();	 Catch:{ all -> 0x00bc }
        goto L_0x00c3;
    L_0x00bc:
        r8 = move-exception;
        if (r5 == 0) goto L_0x00c2;
    L_0x00bf:
        r5.close();	 Catch:{ IOException -> 0x00c9 }
    L_0x00c2:
        throw r8;	 Catch:{ IOException -> 0x00c9 }
    L_0x00c3:
        if (r5 == 0) goto L_0x00c8;
    L_0x00c5:
        r5.close();	 Catch:{ IOException -> 0x00c9 }
    L_0x00c8:
        throw r8;	 Catch:{ IOException -> 0x00c9 }
    L_0x00c9:
        r8 = move-exception;
        r0 = r7.exists();	 Catch:{ IOException -> 0x00f4 }
        if (r0 == 0) goto L_0x00f0;
    L_0x00d0:
        r0 = r7.delete();	 Catch:{ IOException -> 0x00f4 }
        if (r0 != 0) goto L_0x00f0;
    L_0x00d6:
        r0 = "LibraryLoaderHelper";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f4 }
        r3.<init>();	 Catch:{ IOException -> 0x00f4 }
        r5 = "Failed to delete ";
        r3.append(r5);	 Catch:{ IOException -> 0x00f4 }
        r7 = r7.getAbsolutePath();	 Catch:{ IOException -> 0x00f4 }
        r3.append(r7);	 Catch:{ IOException -> 0x00f4 }
        r7 = r3.toString();	 Catch:{ IOException -> 0x00f4 }
        android.util.Log.e(r0, r7);	 Catch:{ IOException -> 0x00f4 }
    L_0x00f0:
        r4.close();	 Catch:{ IOException -> 0x00f4 }
        throw r8;	 Catch:{ IOException -> 0x00f4 }
    L_0x00f4:
        r7 = move-exception;
        r8 = "LibraryLoaderHelper";
        r0 = "Failed to unpack native libraries";
        android.util.Log.e(r8, r0, r7);
        deleteDirectorySync(r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bangcle.andJni.JniLib1557756502.unpackLibrariesOnce(android.content.Context, java.lang.String):boolean");
    }
}
