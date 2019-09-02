package com.alibaba.wireless.security.open.litevm;

import com.alibaba.wireless.security.mainplugin.b;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.litevm.LiteVMParamType.PARAM_TYPE;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

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
public class a {
    private static ISecurityGuardPlugin a;
    private static Object b;
    private static a c;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.alibaba.wireless.security.open.litevm.a.<clinit>():void, dex: 
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.alibaba.wireless.security.open.litevm.a.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.open.litevm.a.<clinit>():void");
    }

    private a(ISecurityGuardPlugin iSecurityGuardPlugin) throws ClassNotFoundException {
        a = iSecurityGuardPlugin;
    }

    private LiteVMInstance a(String str, String str2, byte[] bArr, Object[] objArr) throws SecException {
        return new LiteVMInstance(b.a(a, str, str2, bArr, objArr), str, str2);
    }

    private Object a(LiteVMInstance liteVMInstance, int i, LiteVMParameterWrapper[] liteVMParameterWrapperArr, int i2) throws SecException {
        if (liteVMInstance == null || !b(liteVMInstance)) {
            throw new SecException("LVM instance not valid", 2101);
        }
        LiteVMParameterWrapper[] liteVMParameterWrapperArr2 = null;
        if (liteVMParameterWrapperArr != null) {
            liteVMParameterWrapperArr2 = (LiteVMParameterWrapper[]) liteVMParameterWrapperArr.clone();
            int length = liteVMParameterWrapperArr2.length;
            for (int i3 = 0; i3 < length; i3++) {
                LiteVMParameterWrapper liteVMParameterWrapper = liteVMParameterWrapperArr2[i3];
                if (!(liteVMParameterWrapper == null || liteVMParameterWrapper.getType() != PARAM_TYPE.PARAM_TYPE_STRING.getValue() || liteVMParameterWrapper.getValue() == null)) {
                    try {
                        byte[] bytes = ((String) liteVMParameterWrapper.getValue()).getBytes("UTF-8");
                        byte[] bArr = new byte[(bytes.length + 1)];
                        for (int i4 = 0; i4 < bytes.length; i4++) {
                            bArr[i4] = bytes[i4];
                        }
                        bArr[bytes.length] = (byte) 0;
                        liteVMParameterWrapperArr2[i3] = new LiteVMParameterWrapper(PARAM_TYPE.PARAM_TYPE_STRING, bArr);
                    } catch (Exception unused) {
                        throw new SecException("LVM string param convert error", 2101);
                    }
                }
            }
        }
        return ((b) liteVMInstance.getImpl()).a(i, liteVMParameterWrapperArr2, i2, 12504);
    }

    public static Object a(Class cls, ISecurityGuardPlugin iSecurityGuardPlugin) throws ClassNotFoundException {
        Class.forName("com.alibaba.wireless.security.open.litevm.LiteVMInstance");
        if (b == null) {
            synchronized (a.class) {
                if (b == null && iSecurityGuardPlugin != null) {
                    c = new a(iSecurityGuardPlugin);
                    b = b.a(cls, new InvocationHandler() {
                        private boolean a(Object obj, Object obj2) {
                            if (obj2 == null || obj2.getClass() != obj.getClass()) {
                                return false;
                            }
                            try {
                                return equals(Proxy.getInvocationHandler(obj2));
                            } catch (Exception unused) {
                                return false;
                            }
                        }

                        public java.lang.Object invoke(java.lang.Object r6, java.lang.reflect.Method r7, java.lang.Object[] r8) throws java.lang.Throwable {
                            /*
                            r5 = this;
                            r7 = r7.getName();
                            r0 = r7.hashCode();
                            r1 = 3;
                            r2 = 2;
                            r3 = 1;
                            r4 = 0;
                            switch(r0) {
                                case -1776922004: goto L_0x006d;
                                case -1566653364: goto L_0x0063;
                                case -1376216685: goto L_0x0059;
                                case -1295482945: goto L_0x004e;
                                case -611610698: goto L_0x0044;
                                case -514295244: goto L_0x003a;
                                case 66098133: goto L_0x0030;
                                case 147696667: goto L_0x0025;
                                case 1109138392: goto L_0x001b;
                                case 1565934272: goto L_0x0011;
                                default: goto L_0x000f;
                            };
                        L_0x000f:
                            goto L_0x0077;
                        L_0x0011:
                            r0 = "callLiteVMLongMethod";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x0019:
                            r7 = 3;
                            goto L_0x0078;
                        L_0x001b:
                            r0 = "callLiteVMVoidMethod";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x0023:
                            r7 = 6;
                            goto L_0x0078;
                        L_0x0025:
                            r0 = "hashCode";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x002d:
                            r7 = 9;
                            goto L_0x0078;
                        L_0x0030:
                            r0 = "callLiteVMStringMethod";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x0038:
                            r7 = 4;
                            goto L_0x0078;
                        L_0x003a:
                            r0 = "destroyLiteVMInstance";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x0042:
                            r7 = 2;
                            goto L_0x0078;
                        L_0x0044:
                            r0 = "createLiteVMInstance";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x004c:
                            r7 = 0;
                            goto L_0x0078;
                        L_0x004e:
                            r0 = "equals";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x0056:
                            r7 = 8;
                            goto L_0x0078;
                        L_0x0059:
                            r0 = "reloadLiteVMInstance";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x0061:
                            r7 = 1;
                            goto L_0x0078;
                        L_0x0063:
                            r0 = "callLiteVMByteMethod";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x006b:
                            r7 = 5;
                            goto L_0x0078;
                        L_0x006d:
                            r0 = "toString";
                            r7 = r7.equals(r0);
                            if (r7 == 0) goto L_0x0077;
                        L_0x0075:
                            r7 = 7;
                            goto L_0x0078;
                        L_0x0077:
                            r7 = -1;
                        L_0x0078:
                            switch(r7) {
                                case 0: goto L_0x0132;
                                case 1: goto L_0x0122;
                                case 2: goto L_0x0116;
                                case 3: goto L_0x00fd;
                                case 4: goto L_0x00e4;
                                case 5: goto L_0x00cb;
                                case 6: goto L_0x00b2;
                                case 7: goto L_0x0091;
                                case 8: goto L_0x0086;
                                case 9: goto L_0x007d;
                                default: goto L_0x007b;
                            };
                        L_0x007b:
                            goto L_0x014b;
                        L_0x007d:
                            r6 = r5.hashCode();
                            r6 = java.lang.Integer.valueOf(r6);
                            return r6;
                        L_0x0086:
                            r7 = r8[r4];
                            r6 = r5.a(r6, r7);
                            r6 = java.lang.Boolean.valueOf(r6);
                            return r6;
                        L_0x0091:
                            r7 = new java.lang.StringBuilder;
                            r7.<init>();
                            r6 = r6.getClass();
                            r6 = r6.getName();
                            r7.append(r6);
                            r6 = "&ID=";
                            r7.append(r6);
                            r6 = r5.hashCode();
                            r7.append(r6);
                            r6 = r7.toString();
                            return r6;
                        L_0x00b2:
                            r6 = com.alibaba.wireless.security.open.litevm.a.c;
                            r7 = r8[r4];
                            r7 = (com.alibaba.wireless.security.open.litevm.LiteVMInstance) r7;
                            r0 = r8[r3];
                            r0 = (java.lang.Integer) r0;
                            r0 = r0.intValue();
                            r8 = r8[r2];
                            r8 = (com.alibaba.wireless.security.open.litevm.LiteVMParameterWrapper[]) r8;
                            r6.a(r7, r0, r8, r4);
                            goto L_0x014b;
                        L_0x00cb:
                            r6 = com.alibaba.wireless.security.open.litevm.a.c;
                            r7 = r8[r4];
                            r7 = (com.alibaba.wireless.security.open.litevm.LiteVMInstance) r7;
                            r0 = r8[r3];
                            r0 = (java.lang.Integer) r0;
                            r0 = r0.intValue();
                            r8 = r8[r2];
                            r8 = (com.alibaba.wireless.security.open.litevm.LiteVMParameterWrapper[]) r8;
                            r6 = r6.a(r7, r0, r8, r1);
                            return r6;
                        L_0x00e4:
                            r6 = com.alibaba.wireless.security.open.litevm.a.c;
                            r7 = r8[r4];
                            r7 = (com.alibaba.wireless.security.open.litevm.LiteVMInstance) r7;
                            r0 = r8[r3];
                            r0 = (java.lang.Integer) r0;
                            r0 = r0.intValue();
                            r8 = r8[r2];
                            r8 = (com.alibaba.wireless.security.open.litevm.LiteVMParameterWrapper[]) r8;
                            r6 = r6.a(r7, r0, r8, r2);
                            return r6;
                        L_0x00fd:
                            r6 = com.alibaba.wireless.security.open.litevm.a.c;
                            r7 = r8[r4];
                            r7 = (com.alibaba.wireless.security.open.litevm.LiteVMInstance) r7;
                            r0 = r8[r3];
                            r0 = (java.lang.Integer) r0;
                            r0 = r0.intValue();
                            r8 = r8[r2];
                            r8 = (com.alibaba.wireless.security.open.litevm.LiteVMParameterWrapper[]) r8;
                            r6 = r6.a(r7, r0, r8, r3);
                            return r6;
                        L_0x0116:
                            r6 = com.alibaba.wireless.security.open.litevm.a.c;
                            r7 = r8[r4];
                            r7 = (com.alibaba.wireless.security.open.litevm.LiteVMInstance) r7;
                            r6.a(r7);
                            goto L_0x014b;
                        L_0x0122:
                            r6 = com.alibaba.wireless.security.open.litevm.a.c;
                            r7 = r8[r4];
                            r7 = (com.alibaba.wireless.security.open.litevm.LiteVMInstance) r7;
                            r8 = r8[r3];
                            r8 = (byte[]) r8;
                            r6.a(r7, r8);
                            goto L_0x014b;
                        L_0x0132:
                            r6 = com.alibaba.wireless.security.open.litevm.a.c;
                            r7 = r8[r4];
                            r7 = (java.lang.String) r7;
                            r0 = r8[r3];
                            r0 = (java.lang.String) r0;
                            r2 = r8[r2];
                            r2 = (byte[]) r2;
                            r8 = r8[r1];
                            r8 = (java.lang.Object[]) r8;
                            r6 = r6.a(r7, r0, r2, r8);
                            return r6;
                        L_0x014b:
                            r6 = 0;
                            return r6;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.open.litevm.a$AnonymousClass1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
                        }
                    });
                }
            }
        }
        return b;
    }

    private void a(LiteVMInstance liteVMInstance) throws SecException {
        if (liteVMInstance == null || !b(liteVMInstance)) {
            throw new SecException("LVM instance not valid", 2101);
        }
        ((b) liteVMInstance.getImpl()).b();
    }

    private void a(LiteVMInstance liteVMInstance, byte[] bArr) throws SecException {
        if (liteVMInstance == null || !b(liteVMInstance)) {
            throw new SecException("lvm instance not valid", 2101);
        }
        ((b) liteVMInstance.getImpl()).a(bArr);
    }

    private boolean b(LiteVMInstance liteVMInstance) {
        if (liteVMInstance != null) {
            Object impl = liteVMInstance.getImpl();
            if (impl != null && (impl instanceof b)) {
                return ((b) impl).a();
            }
        }
        return false;
    }
}
