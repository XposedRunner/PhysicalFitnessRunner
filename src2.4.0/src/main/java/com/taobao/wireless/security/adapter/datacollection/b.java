package com.taobao.wireless.security.adapter.datacollection;

import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.taobao.wireless.security.adapter.common.SPUtility2;

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
public class b {
    private static final Object b = null;
    private static b c;
    private ISecurityGuardPlugin a;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.b.<clinit>():void, dex: 
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.b.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.b.<clinit>():void");
    }

    private b(ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.a = iSecurityGuardPlugin;
        DeviceInfoCapturer.initialize(iSecurityGuardPlugin, this);
    }

    public static b a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b(iSecurityGuardPlugin);
                }
            }
        }
        return c;
    }

    private void b() {
        this.a.getRouter().doCommand(10901, new Object[0]);
    }

    public String a() {
        String readFromSPUnified;
        synchronized (b) {
            readFromSPUnified = SPUtility2.readFromSPUnified("DataCollectionData", "key_nick", "");
        }
        return readFromSPUnified;
    }

    public String a(int i) {
        return null;
    }

    /* JADX WARNING: Missing block: B:16:0x002b, code skipped:
            return true;
     */
    public boolean a(java.lang.String r6) {
        /*
        r5 = this;
        r0 = b;
        monitor-enter(r0);
        if (r6 != 0) goto L_0x000a;
    L_0x0005:
        r6 = "";
        goto L_0x000a;
    L_0x0008:
        r6 = move-exception;
        goto L_0x002f;
    L_0x000a:
        r1 = r5.a();	 Catch:{ all -> 0x0008 }
        r2 = r6.equals(r1);	 Catch:{ all -> 0x0008 }
        if (r2 != 0) goto L_0x002c;
    L_0x0014:
        r2 = "DataCollectionData";
        r3 = "key_nick";
        r4 = 1;
        r6 = com.taobao.wireless.security.adapter.common.SPUtility2.saveToSPUnified(r2, r3, r6, r4);	 Catch:{ all -> 0x0008 }
        if (r6 == 0) goto L_0x002c;
    L_0x001f:
        if (r1 == 0) goto L_0x002a;
    L_0x0021:
        r6 = r1.length();	 Catch:{ all -> 0x0008 }
        if (r6 == 0) goto L_0x002a;
    L_0x0027:
        r5.b();	 Catch:{ all -> 0x0008 }
    L_0x002a:
        monitor-exit(r0);	 Catch:{ all -> 0x0008 }
        return r4;
    L_0x002c:
        r6 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x0008 }
        return r6;
    L_0x002f:
        monitor-exit(r0);	 Catch:{ all -> 0x0008 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.b.a(java.lang.String):boolean");
    }
}
