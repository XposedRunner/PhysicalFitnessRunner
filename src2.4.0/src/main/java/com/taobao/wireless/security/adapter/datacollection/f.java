package com.taobao.wireless.security.adapter.datacollection;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Process;

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
public class f {
    private static String a;
    private static PackageManager b;
    private static Context c;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.f.<clinit>():void, dex: 
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.f.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.f.<clinit>():void");
    }

    public static String a() {
        return a;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000e */
    /* JADX WARNING: Failed to process nested try/catch */
    public static void a(android.content.Context r1) {
        /*
        if (r1 == 0) goto L_0x0014;
    L_0x0002:
        r0 = b;
        if (r0 != 0) goto L_0x0014;
    L_0x0006:
        c = r1;
        r0 = r1.getPackageName();	 Catch:{ Throwable -> 0x000e }
        a = r0;	 Catch:{ Throwable -> 0x000e }
    L_0x000e:
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x0014 }
        b = r1;	 Catch:{ Throwable -> 0x0014 }
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.f.a(android.content.Context):void");
    }

    public static boolean a(String str) {
        try {
            PackageManager packageManager = b;
            if (packageManager != null) {
                return packageManager.hasSystemFeature(str);
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String b() {
        try {
            PackageManager packageManager = b;
            if (packageManager == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a, 0);
            return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c() {
        try {
            if (!(b == null || a == null)) {
                PackageInfo packageInfo = b.getPackageInfo(a, 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (!(str == null || str.length() == 0)) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean d() {
        try {
            if (b == null || a == null) {
                return false;
            }
            PackageInfo packageInfo = b.getPackageInfo(a, 0);
            return (packageInfo == null || (packageInfo.applicationInfo.flags & 1) == 0 || (packageInfo.applicationInfo.flags & 128) != 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean e() {
        try {
            int myPid = Process.myPid();
            if (c == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) c.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.importance == 100;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String f() {
        try {
            if (c == null) {
                return null;
            }
            Signature[] signatureArr = c.getPackageManager().getPackageInfo("android", 64).signatures;
            return (signatureArr == null || signatureArr.length <= 0) ? null : d.a(signatureArr[0].toCharsString());
        } catch (Exception unused) {
            return null;
        }
    }
}
