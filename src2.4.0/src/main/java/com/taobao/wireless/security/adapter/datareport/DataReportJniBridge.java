package com.taobao.wireless.security.adapter.datareport;

import android.content.Context;
import com.taobao.wireless.security.adapter.common.a;
import com.taobao.wireless.security.adapter.common.b;
import com.taobao.wireless.security.adapter.common.c;
import java.lang.reflect.Method;
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
public class DataReportJniBridge {
    private static int a;
    private static int b;
    private static Class c;
    private static Method d;
    private static Context e;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datareport.DataReportJniBridge.<clinit>():void, dex: 
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datareport.DataReportJniBridge.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datareport.DataReportJniBridge.<clinit>():void");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static int accsAvaiableBridge() {
        /*
        r0 = b;
        if (r0 != 0) goto L_0x0033;
    L_0x0004:
        r0 = com.taobao.wireless.security.adapter.datareport.DataReportJniBridge.class;
        monitor-enter(r0);
        r1 = b;	 Catch:{ all -> 0x0030 }
        if (r1 != 0) goto L_0x002e;
    L_0x000b:
        r1 = 1;
        r2 = "com.alibaba.wireless.security.open.securityguardaccsadapter.AccsAdapter";
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x002c }
        c = r2;	 Catch:{ ClassNotFoundException -> 0x002c }
        r2 = "com.alibaba.wireless.security.open.securityguardaccsadapter.AccsListner";
        java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x002c }
        r2 = c;	 Catch:{  }
        r3 = "registerListner";
        r4 = new java.lang.Class[r1];	 Catch:{  }
        r5 = 0;
        r6 = android.content.Context.class;
        r4[r5] = r6;	 Catch:{  }
        r2 = r2.getMethod(r3, r4);	 Catch:{  }
        d = r2;	 Catch:{  }
        a = r1;	 Catch:{ all -> 0x0030 }
    L_0x002c:
        b = r1;	 Catch:{ all -> 0x0030 }
    L_0x002e:
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        goto L_0x0033;
    L_0x0030:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        throw r1;
    L_0x0033:
        r0 = a;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datareport.DataReportJniBridge.accsAvaiableBridge():int");
    }

    public static void initialize(Context context) {
        e = context;
    }

    public static int registerAccsListnerBridge() {
        int i = 0;
        try {
            if (accsAvaiableBridge() == 0 || e == null) {
                return 0;
            }
            Method method = d;
            Class cls = c;
            Object[] objArr = new Object[1];
            objArr[0] = e;
            method.invoke(cls, objArr);
            i = 1;
            return i;
        } catch (Exception unused) {
        }
    }

    public static String sendReportBridge(String str, String str2, byte[] bArr) {
        HashMap hashMap;
        String[] strArr = new String[1];
        strArr[0] = str2;
        if (a.b(strArr)) {
            hashMap = new HashMap();
            hashMap.put("keyindex", str2);
        } else {
            hashMap = null;
        }
        b a = c.a(str, hashMap, bArr, null, 11000, 11000);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(a.b));
        stringBuilder.append("|");
        if (a.b == 200) {
            str = a.a;
        } else {
            if (a.b == 1002 && a.c != null && a.c.length() > 0) {
                str = a.c;
            }
            return stringBuilder.toString();
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
