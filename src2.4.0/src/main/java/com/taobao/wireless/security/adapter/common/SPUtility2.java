package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.System;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public class SPUtility2 {
    private static Context a;
    private static d b;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.common.SPUtility2.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 9 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.common.SPUtility2.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.SPUtility2.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A:{SYNTHETIC, Splitter:B:32:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071 A:{SYNTHETIC, Splitter:B:25:0x0071} */
    private static int a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
        r0 = 0;
        r4 = r4.getFilesDir();	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r4 = r4.getAbsolutePath();	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        if (r4 == 0) goto L_0x006c;
    L_0x000b:
        r1 = r4.length();	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        if (r1 > 0) goto L_0x0012;
    L_0x0011:
        goto L_0x006c;
    L_0x0012:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r2.<init>();	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r2.append(r4);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r3 = java.io.File.separator;	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r2.append(r3);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r2.append(r5);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r3 = ".tmp";
        r2.append(r3);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r3.<init>();	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r3.append(r4);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r4 = java.io.File.separator;	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r3.append(r4);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r3.append(r5);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r4 = r3.toString();	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r4 = new java.io.OutputStreamWriter;	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r5.<init>(r1);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r4.write(r6);	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r4.close();	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r2.delete();	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        r4 = r1.renameTo(r2);	 Catch:{ Exception -> 0x0075, all -> 0x006e }
        if (r4 == 0) goto L_0x0064;
    L_0x0062:
        r4 = 0;
        return r4;
    L_0x0064:
        r4 = 5;
        return r4;
    L_0x0066:
        r5 = move-exception;
        r0 = r4;
        r4 = r5;
        goto L_0x006f;
    L_0x006a:
        r0 = r4;
        goto L_0x0075;
    L_0x006c:
        r4 = 4;
        return r4;
    L_0x006e:
        r4 = move-exception;
    L_0x006f:
        if (r0 == 0) goto L_0x0074;
    L_0x0071:
        r0.close();	 Catch:{ Exception -> 0x0074 }
    L_0x0074:
        throw r4;
    L_0x0075:
        r4 = 6;
        if (r0 == 0) goto L_0x007b;
    L_0x0078:
        r0.close();	 Catch:{ Exception -> 0x007b }
    L_0x007b:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.SPUtility2.a(android.content.Context, java.lang.String, java.lang.String):int");
    }

    private static int a(String str, String str2, String str3) {
        Context context = a;
        if (str2 != null && str2.length() > 0 && str != null && str.length() > 0) {
            try {
                JSONObject a = a(str);
                if (a == null) {
                    a = new JSONObject();
                }
                a.put(str2, str3);
                return a(context, str, a.toString());
            } catch (Exception unused) {
            }
        }
        return 2;
    }

    private static String a(String str, boolean z) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str))));
        str = bufferedReader.readLine();
        if (str == null) {
            str = "";
        }
        stringBuilder.append(str);
        if (!z) {
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) {
                    break;
                }
                stringBuilder.append(str);
            }
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e A:{SYNTHETIC, Splitter:B:24:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057 A:{SYNTHETIC, Splitter:B:16:0x0057} */
    private static org.json.JSONObject a(java.lang.String r5) {
        /*
        r0 = 0;
        r1 = a;	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r1 = r1.getFilesDir();	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r1 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r3.<init>();	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r3.append(r1);	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r1 = java.io.File.separator;	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r3.append(r1);	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r3.append(r5);	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r5 = r3.toString();	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r5 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r1 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r5.<init>(r1);	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005c, all -> 0x004f }
        r1.<init>();	 Catch:{ Exception -> 0x005c, all -> 0x004f }
    L_0x0038:
        r2 = r5.readLine();	 Catch:{ Exception -> 0x005c, all -> 0x004f }
        if (r2 == 0) goto L_0x0042;
    L_0x003e:
        r1.append(r2);	 Catch:{ Exception -> 0x005c, all -> 0x004f }
        goto L_0x0038;
    L_0x0042:
        r5.close();	 Catch:{ Exception -> 0x005c, all -> 0x004f }
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        r5.<init>(r1);	 Catch:{ Exception -> 0x005b, all -> 0x0054 }
        return r5;
    L_0x004f:
        r0 = move-exception;
        r4 = r0;
        r0 = r5;
        r5 = r4;
        goto L_0x0055;
    L_0x0054:
        r5 = move-exception;
    L_0x0055:
        if (r0 == 0) goto L_0x005a;
    L_0x0057:
        r0.close();	 Catch:{ Exception -> 0x005a }
    L_0x005a:
        throw r5;
    L_0x005b:
        r5 = r0;
    L_0x005c:
        if (r5 == 0) goto L_0x0061;
    L_0x005e:
        r5.close();	 Catch:{ Exception -> 0x0061 }
    L_0x0061:
        r5 = r0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.SPUtility2.a(java.lang.String):org.json.JSONObject");
    }

    private static void a(String str, String str2, boolean z) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str), z);
        fileOutputStream.write(str2.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /* JADX WARNING: Missing block: B:13:0x0039, code skipped:
            if (((java.lang.Integer) r1.invoke(r0, r7)).intValue() == 0) goto L_0x003b;
     */
    private static boolean a(int r7) {
        /*
        r0 = a;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 23;
        r3 = 0;
        r4 = 1;
        if (r1 < r2) goto L_0x003b;
    L_0x000a:
        r1 = r0.getApplicationInfo();
        r1 = r1.targetSdkVersion;
        if (r1 < r2) goto L_0x003b;
    L_0x0012:
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r3;
    L_0x0015:
        r1 = android.content.Context.class;
        r2 = "checkSelfPermission";
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x003c }
        r6 = java.lang.String.class;
        r5[r3] = r6;	 Catch:{ Throwable -> 0x003c }
        r1 = r1.getMethod(r2, r5);	 Catch:{ Throwable -> 0x003c }
        if (r1 == 0) goto L_0x003c;
    L_0x0025:
        r2 = "android.permission.READ_EXTERNAL_STORAGE";
        if (r7 != 0) goto L_0x002b;
    L_0x0029:
        r2 = "android.permission.WRITE_EXTERNAL_STORAGE";
    L_0x002b:
        r7 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x003c }
        r7[r3] = r2;	 Catch:{ Throwable -> 0x003c }
        r7 = r1.invoke(r0, r7);	 Catch:{ Throwable -> 0x003c }
        r7 = (java.lang.Integer) r7;	 Catch:{ Throwable -> 0x003c }
        r7 = r7.intValue();	 Catch:{ Throwable -> 0x003c }
        if (r7 != 0) goto L_0x003c;
    L_0x003b:
        r3 = 1;
    L_0x003c:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.SPUtility2.a(int):boolean");
    }

    private static boolean a(String str, String str2) {
        Context context = a;
        if (context == null || str2 == null || str2.length() <= 0 || str == null || str.length() <= 0) {
            return false;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
            str2 = "SGMANAGER_DATA2";
            JSONObject a = a(str2);
            if (a == null) {
                return false;
            }
            a.remove(str);
            return a(context, str2, a.toString()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String b(String str, String str2, String str3) {
        if (str2 == null || str2.length() <= 0 || str == null || str.length() <= 0) {
            return str3;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
            JSONObject a = a("SGMANAGER_DATA2");
            return a != null ? a.getString(str) : str3;
        } catch (Exception unused) {
            return str3;
        }
    }

    public static String getTempFile(String str) throws IOException {
        String rootDir = rootDir();
        if (rootDir != null) {
            File file = new File(rootDir, str);
            if (file.exists() || file.createNewFile()) {
                return file.getAbsolutePath();
            }
        }
        return "";
    }

    public static void init(Context context) {
        if (context != null) {
            a = context;
            b = new d(context, "sp.lock");
        }
    }

    public static String read(String str) {
        Throwable th;
        String str2 = "";
        try {
            if (!a(1)) {
                return str2;
            }
            str = getTempFile(str);
            synchronized (SPUtility2.class) {
                try {
                    str = b.a() ? a(str, true) : str2;
                    try {
                        b.b();
                        return str;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        str2 = str;
                        th = th3;
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    throw th;
                }
            }
        } catch (IOException unused) {
            return str2;
        }
    }

    /* JADX WARNING: Missing block: B:14:0x0026, code skipped:
            if (r3.length() > 0) goto L_0x002a;
     */
    public static java.lang.String readFromSPUnified(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
        if (r4 == 0) goto L_0x0042;
    L_0x0002:
        r0 = r4.length();
        if (r0 <= 0) goto L_0x0042;
    L_0x0008:
        if (r3 == 0) goto L_0x0042;
    L_0x000a:
        r0 = r3.length();
        if (r0 <= 0) goto L_0x0042;
    L_0x0010:
        r0 = com.taobao.wireless.security.adapter.common.SPUtility2.class;
        monitor-enter(r0);
        r1 = b;	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        r1 = r1.a();	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        r2 = 1;
        if (r1 != r2) goto L_0x0029;
    L_0x001c:
        r3 = b(r3, r4, r5);	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        if (r3 == 0) goto L_0x0029;
    L_0x0022:
        r4 = r3.length();	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        if (r4 <= 0) goto L_0x0029;
    L_0x0028:
        goto L_0x002a;
    L_0x0029:
        r3 = r5;
    L_0x002a:
        r4 = b;	 Catch:{ all -> 0x003f }
        r4.b();	 Catch:{ all -> 0x003f }
        r5 = r3;
        goto L_0x003d;
    L_0x0031:
        r3 = move-exception;
        r4 = b;	 Catch:{ all -> 0x003f }
        r4.b();	 Catch:{ all -> 0x003f }
        throw r3;	 Catch:{ all -> 0x003f }
    L_0x0038:
        r3 = b;	 Catch:{ all -> 0x003f }
        r3.b();	 Catch:{ all -> 0x003f }
    L_0x003d:
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        return r5;
    L_0x003f:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        throw r3;
    L_0x0042:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.SPUtility2.readFromSPUnified(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String readSS(Context context, String str) {
        String str2 = null;
        if (context != null) {
            try {
                if ((VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) && str != null && str.length() > 0) {
                    synchronized (SPUtility2.class) {
                        try {
                            if (b.a()) {
                                str2 = System.getString(context.getContentResolver(), str);
                            }
                            b.b();
                        } catch (Throwable th) {
                            b.b();
                        }
                    }
                    return str2;
                }
            } catch (Throwable unused) {
            }
        }
        return str2;
    }

    public static boolean removeFromSPUnified(String str, String str2, boolean z) {
        if (str2 != null && str2.length() > 0 && str != null && str.length() > 0) {
            synchronized (SPUtility2.class) {
                try {
                    if (b.a()) {
                        boolean a = a(str, str2);
                        b.b();
                        return a;
                    }
                    b.b();
                } catch (Throwable th) {
                    b.b();
                }
            }
        }
        return false;
    }

    public static String rootDir() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                stringBuilder.append("/");
                stringBuilder.append(".com.taobao.dp");
                File file = new File(stringBuilder.toString());
                if (file.exists() || file.mkdir()) {
                    return file.getAbsolutePath();
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int saveToFileUnifiedForNative(String str, String str2, String str3, boolean z) {
        int i = 1;
        if (str2 == null || str2.length() <= 0 || str == null || str.length() <= 0) {
            return 1;
        }
        synchronized (SPUtility2.class) {
            try {
                if (b.a()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("_");
                    stringBuilder.append(str2);
                    i = a("SGMANAGER_DATA2", stringBuilder.toString(), str3);
                }
                b.b();
            } catch (Throwable th) {
                b.b();
            }
        }
        return i;
    }

    public static boolean saveToSPUnified(String str, String str2, String str3, boolean z) {
        return saveToFileUnifiedForNative(str, str2, str3, z) == 0;
    }

    public static void write(String str, String str2) {
        try {
            if (a(0)) {
                str = getTempFile(str);
                if (str != null && str.length() > 0) {
                    synchronized (SPUtility2.class) {
                        try {
                            if (b.a()) {
                                a(str, str2, false);
                            }
                            b.b();
                        } catch (Throwable th) {
                            b.b();
                        }
                    }
                }
            }
        } catch (IOException unused) {
        }
    }

    public static boolean writeSS(Context context, String str, String str2) {
        boolean z = false;
        if (context != null) {
            try {
                if ((VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) && str != null && str.length() > 0) {
                    synchronized (SPUtility2.class) {
                        try {
                            if (b.a()) {
                                z = System.putString(context.getContentResolver(), str, str2);
                            }
                            b.b();
                        } catch (Throwable th) {
                            b.b();
                        }
                    }
                    return z;
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }
}
