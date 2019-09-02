package com.taobao.wireless.security.adapter.common;

import java.util.HashMap;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public class HttpUtil {
    private static String a = "HttpUtil";
    private static int b = 1000;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.common.HttpUtil.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.common.HttpUtil.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.HttpUtil.<clinit>():void");
    }

    public static String downloadFileBridge(String str, String str2) {
        return c.a(str, str2);
    }

    public static String sendSyncHttpGetRequestBridge(String str) {
        b a = c.a(str, null);
        return a != null ? a.a : null;
    }

    public static String sendSyncHttpPostRequestBridge(String str, String str2, String str3, int i, int i2) {
        String str4 = null;
        if (!(str == null || str.length() == 0 || str3 == null)) {
            if (str3.length() == 0) {
                return null;
            }
            byte[] bytes;
            if (i != 1) {
                if (i == 2) {
                    bytes = str3.replace("+", "%2B").getBytes();
                }
                bytes = str3.getBytes();
            } else if (str2 == null || str2.length() == 0) {
                return null;
            } else {
                String[] strArr = new String[1];
                strArr[0] = str2;
                if (a.b(strArr)) {
                    new HashMap().put("keyindex", str2);
                }
                bytes = str3.getBytes();
            }
            try {
                b a = c.a(str, null, bytes, "application/x-www-form-urlencoded;charset=UTF-8", i2 * b, i2 * b);
                if (a.b == 200) {
                    str4 = a.a;
                }
            } catch (Exception unused) {
            }
        }
        return str4;
    }
}
