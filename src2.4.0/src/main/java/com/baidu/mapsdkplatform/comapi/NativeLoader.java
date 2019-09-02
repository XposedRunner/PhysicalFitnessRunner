package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class NativeLoader {
    private static final String a = "NativeLoader";
    private static Context b;
    private static final Set<String> c = new HashSet();
    private static final Set<String> d = new HashSet();
    private static NativeLoader e;
    private static a f = a.ARMEABI;
    private static boolean g;
    private static String h;

    private enum a {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");
        
        private String f;

        private a(String str) {
            this.f = str;
        }

        public String a() {
            return this.f;
        }
    }

    private NativeLoader() {
    }

    @TargetApi(8)
    private String a() {
        return 8 <= VERSION.SDK_INT ? b.getPackageCodePath() : "";
    }

    private String a(a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lib/");
        stringBuilder.append(aVar.a());
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        return stringBuilder.toString();
    }

    private void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(a, "Close InputStream error", e);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    Log.e(a, "Close OutputStream error", e2);
                }
            }
        }
        fileOutputStream.flush();
        try {
            fileOutputStream.close();
        } catch (IOException e22) {
            Log.e(a, "Close OutputStream error", e22);
        }
    }

    private void a(Throwable th) {
        Log.e(a, "loadException", th);
        for (String str : d) {
            String str2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" Failed to load.");
            Log.e(str2, stringBuilder.toString());
        }
    }

    static void a(boolean z, String str) {
        g = z;
        h = str;
    }

    private boolean a(String str) {
        try {
            synchronized (c) {
                if (c.contains(str)) {
                    return true;
                }
                System.loadLibrary(str);
                synchronized (c) {
                    c.add(str);
                }
                return true;
            }
        } catch (Throwable unused) {
            return b(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094 A:{SYNTHETIC, Splitter:B:44:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a3 A:{SYNTHETIC, Splitter:B:51:0x00a3} */
    private boolean a(java.lang.String r7, com.baidu.mapsdkplatform.comapi.NativeLoader.a r8) {
        /*
        r6 = this;
        r0 = new java.io.File;
        r1 = r6.b();
        r0.<init>(r1, r7);
        r1 = r0.exists();
        r2 = 1;
        if (r1 == 0) goto L_0x001b;
    L_0x0010:
        r0 = r0.length();
        r3 = 0;
        r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x001b;
    L_0x001a:
        return r2;
    L_0x001b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r8 = r6.a(r8);
        r0.append(r8);
        r0.append(r7);
        r8 = r0.toString();
        r0 = 0;
        r1 = g;
        if (r1 != 0) goto L_0x0038;
    L_0x0033:
        r1 = r6.a();
        goto L_0x003a;
    L_0x0038:
        r1 = h;
    L_0x003a:
        r3 = 0;
        if (r1 == 0) goto L_0x00b0;
    L_0x003d:
        r4 = r1.isEmpty();
        if (r4 == 0) goto L_0x0044;
    L_0x0043:
        return r3;
    L_0x0044:
        r4 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x008a }
        r4.<init>(r1);	 Catch:{ Exception -> 0x008a }
        r8 = r4.getEntry(r8);	 Catch:{ Exception -> 0x0084, all -> 0x0082 }
        if (r8 != 0) goto L_0x005e;
    L_0x004f:
        if (r4 == 0) goto L_0x005d;
    L_0x0051:
        r4.close();	 Catch:{ IOException -> 0x0055 }
        return r3;
    L_0x0055:
        r7 = move-exception;
        r8 = a;
        r0 = "Release file failed";
        android.util.Log.e(r8, r0, r7);
    L_0x005d:
        return r3;
    L_0x005e:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0084, all -> 0x0082 }
        r1 = r6.b();	 Catch:{ Exception -> 0x0084, all -> 0x0082 }
        r0.<init>(r1, r7);	 Catch:{ Exception -> 0x0084, all -> 0x0082 }
        r7 = r4.getInputStream(r8);	 Catch:{ Exception -> 0x0084, all -> 0x0082 }
        r8 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0084, all -> 0x0082 }
        r8.<init>(r0);	 Catch:{ Exception -> 0x0084, all -> 0x0082 }
        r6.a(r7, r8);	 Catch:{ Exception -> 0x0084, all -> 0x0082 }
        if (r4 == 0) goto L_0x0081;
    L_0x0075:
        r4.close();	 Catch:{ IOException -> 0x0079 }
        return r2;
    L_0x0079:
        r7 = move-exception;
        r8 = a;
        r0 = "Release file failed";
        android.util.Log.e(r8, r0, r7);
    L_0x0081:
        return r2;
    L_0x0082:
        r7 = move-exception;
        goto L_0x00a1;
    L_0x0084:
        r7 = move-exception;
        r0 = r4;
        goto L_0x008b;
    L_0x0087:
        r7 = move-exception;
        r4 = r0;
        goto L_0x00a1;
    L_0x008a:
        r7 = move-exception;
    L_0x008b:
        r8 = a;	 Catch:{ all -> 0x0087 }
        r1 = "Copy library file error";
        android.util.Log.e(r8, r1, r7);	 Catch:{ all -> 0x0087 }
        if (r0 == 0) goto L_0x00a0;
    L_0x0094:
        r0.close();	 Catch:{ IOException -> 0x0098 }
        return r3;
    L_0x0098:
        r7 = move-exception;
        r8 = a;
        r0 = "Release file failed";
        android.util.Log.e(r8, r0, r7);
    L_0x00a0:
        return r3;
    L_0x00a1:
        if (r4 == 0) goto L_0x00af;
    L_0x00a3:
        r4.close();	 Catch:{ IOException -> 0x00a7 }
        goto L_0x00af;
    L_0x00a7:
        r8 = move-exception;
        r0 = a;
        r1 = "Release file failed";
        android.util.Log.e(r0, r1, r8);
    L_0x00af:
        throw r7;
    L_0x00b0:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.NativeLoader.a(java.lang.String, com.baidu.mapsdkplatform.comapi.NativeLoader$a):boolean");
    }

    private boolean a(String str, String str2) {
        return !a(str2, a.ARMV7) ? b(str, str2) : f(str2, str);
    }

    private String b() {
        File file = new File(b.getFilesDir(), "libs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            switch(com.baidu.mapsdkplatform.comapi.d.a[f.ordinal()]) {
                case 1: goto L_0x0036;
                case 2: goto L_0x0031;
                case 3: goto L_0x002c;
                case 4: goto L_0x0027;
                case 5: goto L_0x0022;
                default: goto L_0x0020;
            };
     */
    /* JADX WARNING: Missing block: B:11:0x0020, code skipped:
            r0 = false;
     */
    /* JADX WARNING: Missing block: B:12:0x0022, code skipped:
            r0 = d(r4, r0);
     */
    /* JADX WARNING: Missing block: B:13:0x0027, code skipped:
            r0 = e(r4, r0);
     */
    /* JADX WARNING: Missing block: B:14:0x002c, code skipped:
            r0 = b(r4, r0);
     */
    /* JADX WARNING: Missing block: B:15:0x0031, code skipped:
            r0 = a(r4, r0);
     */
    /* JADX WARNING: Missing block: B:16:0x0036, code skipped:
            r0 = c(r4, r0);
     */
    /* JADX WARNING: Missing block: B:17:0x003a, code skipped:
            r2 = c;
     */
    /* JADX WARNING: Missing block: B:18:0x003c, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            c.add(r4);
     */
    /* JADX WARNING: Missing block: B:21:0x0042, code skipped:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:22:0x0043, code skipped:
            return r0;
     */
    private boolean b(java.lang.String r4) {
        /*
        r3 = this;
        r0 = java.lang.System.mapLibraryName(r4);
        r1 = c;
        monitor-enter(r1);
        r2 = c;	 Catch:{ all -> 0x0047 }
        r2 = r2.contains(r4);	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r4 = 1;
        monitor-exit(r1);	 Catch:{ all -> 0x0047 }
        return r4;
    L_0x0012:
        monitor-exit(r1);	 Catch:{ all -> 0x0047 }
        r1 = com.baidu.mapsdkplatform.comapi.d.a;
        r2 = f;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0036;
            case 2: goto L_0x0031;
            case 3: goto L_0x002c;
            case 4: goto L_0x0027;
            case 5: goto L_0x0022;
            default: goto L_0x0020;
        };
    L_0x0020:
        r0 = 0;
        goto L_0x003a;
    L_0x0022:
        r0 = r3.d(r4, r0);
        goto L_0x003a;
    L_0x0027:
        r0 = r3.e(r4, r0);
        goto L_0x003a;
    L_0x002c:
        r0 = r3.b(r4, r0);
        goto L_0x003a;
    L_0x0031:
        r0 = r3.a(r4, r0);
        goto L_0x003a;
    L_0x0036:
        r0 = r3.c(r4, r0);
    L_0x003a:
        r2 = c;
        monitor-enter(r2);
        r1 = c;	 Catch:{ all -> 0x0044 }
        r1.add(r4);	 Catch:{ all -> 0x0044 }
        monitor-exit(r2);	 Catch:{ all -> 0x0044 }
        return r0;
    L_0x0044:
        r4 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0044 }
        throw r4;
    L_0x0047:
        r4 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0047 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.NativeLoader.b(java.lang.String):boolean");
    }

    private boolean b(String str, String str2) {
        if (a(str2, a.ARMEABI)) {
            return f(str2, str);
        }
        str2 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("found lib");
        stringBuilder.append(str);
        stringBuilder.append(".so error");
        Log.e(str2, stringBuilder.toString());
        return false;
    }

    @TargetApi(21)
    private static a c() {
        String str = VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
        if (str == null) {
            return a.ARMEABI;
        }
        if (str.contains("arm") && str.contains("v7")) {
            f = a.ARMV7;
        }
        if (str.contains("arm") && str.contains("64")) {
            f = a.ARM64;
        }
        if (str.contains("x86")) {
            f = str.contains("64") ? a.X86_64 : a.X86;
        }
        return f;
    }

    private boolean c(String str, String str2) {
        return !a(str2, a.ARM64) ? a(str, str2) : f(str2, str);
    }

    private boolean d(String str, String str2) {
        return !a(str2, a.X86) ? a(str, str2) : f(str2, str);
    }

    private boolean e(String str, String str2) {
        return !a(str2, a.X86_64) ? d(str, str2) : f(str2, str);
    }

    private boolean f(String str, String str2) {
        try {
            System.load(new File(b(), str).getAbsolutePath());
            synchronized (c) {
                c.add(str2);
            }
            return true;
        } catch (Throwable th) {
            synchronized (d) {
                d.add(str2);
                a(th);
                return false;
            }
        }
    }

    public static synchronized NativeLoader getInstance() {
        NativeLoader nativeLoader;
        synchronized (NativeLoader.class) {
            if (e == null) {
                e = new NativeLoader();
                f = c();
            }
            nativeLoader = e;
        }
        return nativeLoader;
    }

    public static void setContext(Context context) {
        b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        if (!g) {
            return a(str);
        } else if (h == null || h.isEmpty()) {
            Log.e(a, "Given custom so file path is null, please check!");
            return false;
        } else {
            return b(str);
        }
    }
}
