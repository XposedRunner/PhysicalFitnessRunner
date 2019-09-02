package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
public class j {
    private static Context a;
    private static WifiManager b;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.j.<clinit>():void, dex: 
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.j.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.j.<clinit>():void");
    }

    public static String a() {
        try {
            WifiInfo h = h();
            if (h != null) {
                return h.getSSID();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void a(Context context) {
        if (context != null && a == null) {
            a = context;
        }
        if (context != null && b == null) {
            try {
                b = (WifiManager) context.getSystemService("wifi");
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(String str) {
        return (str == null || str.equalsIgnoreCase("02:00:00:00:00:00") || str.equalsIgnoreCase("00:00:00:00:00:00")) ? false : true;
    }

    public static String b() {
        try {
            WifiInfo h = h();
            if (h != null) {
                return h.getBSSID();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0068 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0059 A:{SYNTHETIC, Splitter:B:37:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005e A:{SYNTHETIC, Splitter:B:41:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0068 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A:{SYNTHETIC, Splitter:B:25:0x004c} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A:{SYNTHETIC, Splitter:B:29:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0059 A:{SYNTHETIC, Splitter:B:37:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005e A:{SYNTHETIC, Splitter:B:41:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0068 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A:{SYNTHETIC, Splitter:B:25:0x004c} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A:{SYNTHETIC, Splitter:B:29:0x0051} */
    public static java.lang.String b(java.lang.String r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "/sys/class/net/";
        r1.append(r2);
        r1.append(r5);
        r5 = "/address";
        r1.append(r5);
        r5 = r1.toString();
        r1 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0055, all -> 0x0048 }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0055, all -> 0x0048 }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x0055, all -> 0x0048 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0055, all -> 0x0048 }
        r5 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r2 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r5.<init>(r2, r3);	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r2 = r5.readLine();	 Catch:{ Throwable -> 0x0057, all -> 0x003f }
        if (r5 == 0) goto L_0x0039;
    L_0x0036:
        r5.close();	 Catch:{ IOException -> 0x0039 }
    L_0x0039:
        if (r1 == 0) goto L_0x0062;
    L_0x003b:
        r1.close();	 Catch:{ IOException -> 0x0062 }
        goto L_0x0062;
    L_0x003f:
        r0 = move-exception;
        r4 = r0;
        r0 = r5;
        r5 = r4;
        goto L_0x004a;
    L_0x0044:
        r5 = move-exception;
        goto L_0x004a;
    L_0x0046:
        r5 = r0;
        goto L_0x0057;
    L_0x0048:
        r5 = move-exception;
        r1 = r0;
    L_0x004a:
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        r0.close();	 Catch:{ IOException -> 0x004f }
    L_0x004f:
        if (r1 == 0) goto L_0x0054;
    L_0x0051:
        r1.close();	 Catch:{ IOException -> 0x0054 }
    L_0x0054:
        throw r5;
    L_0x0055:
        r5 = r0;
        r1 = r5;
    L_0x0057:
        if (r5 == 0) goto L_0x005c;
    L_0x0059:
        r5.close();	 Catch:{ IOException -> 0x005c }
    L_0x005c:
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r1.close();	 Catch:{ IOException -> 0x0061 }
    L_0x0061:
        r2 = r0;
    L_0x0062:
        r5 = a(r2);
        if (r5 != 0) goto L_0x0069;
    L_0x0068:
        return r0;
    L_0x0069:
        r0 = r2;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.j.b(java.lang.String):java.lang.String");
    }

    public static String c() {
        try {
            WifiInfo h = h();
            if (h != null) {
                return String.valueOf(h.getRssi());
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        try {
            NetworkInterface byName = NetworkInterface.getByName(str);
            if (byName == null) {
                return null;
            }
            byte[] hardwareAddress = byName.getHardwareAddress();
            if (hardwareAddress == null || hardwareAddress.length == 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (byte valueOf : hardwareAddress) {
                Object[] objArr = new Object[1];
                objArr[0] = Byte.valueOf(valueOf);
                stringBuilder.append(String.format("%02x:", objArr));
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            str = stringBuilder.toString();
            if (!a(str)) {
                str = null;
            }
            return str;
        } catch (Throwable unused) {
            str = null;
        }
    }

    public static boolean d() {
        boolean z = false;
        try {
            String property;
            if (VERSION.SDK_INT > 14) {
                property = System.getProperty("http.proxyHost");
                if (property != null && property.length() > 0) {
                    z = true;
                }
                return z;
            }
            property = Proxy.getHost(a);
            if (property != null && property.length() > 0) {
                z = true;
            }
            return z;
        } catch (Throwable unused) {
        }
    }

    public static String e() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        List<WifiConfiguration> configuredNetworks = b.getConfiguredNetworks();
        if (configuredNetworks == null) {
            return str;
        }
        Field declaredField;
        Method method = null;
        try {
            declaredField = WifiConfiguration.class.getDeclaredField("enterpriseConfig");
            try {
                method = WifiEnterpriseConfig.class.getMethod("getIdentity", new Class[0]);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            declaredField = null;
        }
        Collections.sort(configuredNetworks, new Comparator<WifiConfiguration>() {
            /* renamed from: a */
            public int compare(WifiConfiguration wifiConfiguration, WifiConfiguration wifiConfiguration2) {
                return wifiConfiguration.networkId - wifiConfiguration2.networkId;
            }
        });
        int i = 0;
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            stringBuilder.append(Base64.encodeToString(wifiConfiguration.SSID.getBytes(), 2));
            stringBuilder.append("|");
            stringBuilder.append(wifiConfiguration.networkId);
            if (!(declaredField == null || method == null)) {
                try {
                    WifiEnterpriseConfig wifiEnterpriseConfig = (WifiEnterpriseConfig) declaredField.get(wifiConfiguration);
                    if (wifiEnterpriseConfig != null) {
                        String str2 = (String) method.invoke(wifiEnterpriseConfig, new Object[0]);
                        if (!(str2 == null || str2.equals(""))) {
                            stringBuilder.append("|");
                            stringBuilder.append(Base64.encodeToString(str2.getBytes(), 2));
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
            stringBuilder.append("&");
            int i2 = i + 1;
            if (i >= 20) {
                break;
            }
            i = i2;
        }
        stringBuilder.append(configuredNetworks.size());
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0013 A:{RETURN} */
    public static java.lang.String f() {
        /*
        r0 = 0;
        r1 = h();	 Catch:{ Throwable -> 0x000c }
        if (r1 == 0) goto L_0x000c;
    L_0x0007:
        r1 = r1.getMacAddress();	 Catch:{ Throwable -> 0x000c }
        goto L_0x000d;
    L_0x000c:
        r1 = r0;
    L_0x000d:
        r2 = a(r1);
        if (r2 != 0) goto L_0x0014;
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = r1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.j.f():java.lang.String");
    }

    public static String g() {
        String f;
        try {
            String[] strArr = new String[3];
            int i = 0;
            strArr[0] = "wlan0";
            strArr[1] = "eth1";
            strArr[2] = "eth0";
            while (i < strArr.length) {
                String str = strArr[i];
                String c = c(str);
                if (c != null) {
                    return c;
                }
                str = b(str);
                if (str != null) {
                    return str;
                }
                i++;
            }
            f = f();
            if (f != null) {
                return f;
            }
        } catch (Throwable unused) {
            f = null;
        }
        return f == null ? "" : f.toLowerCase();
    }

    private static WifiInfo h() {
        WifiManager wifiManager = b;
        return wifiManager != null ? wifiManager.getConnectionInfo() : null;
    }
}
