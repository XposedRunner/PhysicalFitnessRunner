package com.taobao.wireless.security.adapter.a;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import com.taobao.wireless.security.adapter.a.a.a;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
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
    private ISecurityGuardPlugin a;

    /*  JADX ERROR: NullPointerException in pass: ReSugarCode
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
        	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    /* renamed from: com.taobao.wireless.security.adapter.a.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: com.taobao.wireless.security.adapter.a.b.1.<clinit>():void, dex: 
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:254)
            	at jadx.core.ProcessClass.process(ProcessClass.java:29)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
            	... 10 more
            */
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: com.taobao.wireless.security.adapter.a.b.1.<clinit>():void, dex: 
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.a.b$AnonymousClass1.<clinit>():void");
        }
    }

    public b(ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.a = iSecurityGuardPlugin;
    }

    private String a(String[] strArr, int i, String str, int i2, String str2) throws SecException {
        int i3 = 0;
        while (i3 < strArr.length) {
            try {
                if (strArr[i3] != null) {
                    strArr[i3] = new String(strArr[i3].getBytes("UTF-8"), "UTF-8");
                }
                i3++;
            } catch (UnsupportedEncodingException unused) {
                throw new SecException("", 601);
            }
        }
        if (i != 0) {
            String a = a(strArr, str, i2, str2);
            return ((i2 == a.a.ordinal() || i2 == a.c.ordinal()) && a != null) ? a.toUpperCase() : a;
        } else {
            throw new SecException("", 601);
        }
    }

    private String a(String[] strArr, String str, int i, String str2) {
        return (String) this.a.getRouter().doCommand(10401, new Object[]{strArr, str, Integer.valueOf(i), str2});
    }

    private String[] a(Map<String, String> map) throws SecException {
        if (map == null || map.size() == 2) {
            String str = (String) map.get("INPUT");
            String a = ((com.alibaba.wireless.security.open.statickeyencrypt.a) this.a.getInterface(IStaticKeyEncryptComponent.class)).a((String) map.get("SEEDKEY"));
            if (str != null && !"".equals(str) && a != null && !"".equals(a)) {
                return new String[]{str, a};
            } else if (str == null || "".equals(str)) {
                String.format("Input map value invalid : key \"%1s\" not exits or the relative value is empty", new Object[]{"INPUT"});
                throw new SecException("", 601);
            } else {
                throw new SecException("", 606);
            }
        }
        String.format("Input map size invalid : required size is \"%d\" and actual size is \"%d\"", new Object[]{Integer.valueOf(2), Integer.valueOf(map.size())});
        throw new SecException("", 601);
    }

    private String[] b(Map<String, String> map) throws SecException {
        if (map == null || map.size() == 1) {
            String str = (String) map.get("INPUT");
            if (str == null || "".equals(str)) {
                String.format("Input map value invalid : key \"%1s\" not exits or the relative value is empty", new Object[]{"INPUT"});
                throw new SecException("", 601);
            }
            return new String[]{str};
        }
        String.format("Input map size invalid : required size is \"%d\" and actual size is \"%d\"", new Object[]{Integer.valueOf(1), Integer.valueOf(map.size())});
        throw new SecException("", 601);
    }

    private String[] c(Map<String, String> map) throws SecException {
        if (map == null || (map.size() >= 1 && map.size() <= 2)) {
            String str = "";
            if (map.size() == 2) {
                str = (String) map.get("ATLAS");
                if (str == null || str.length() <= 0) {
                    throw new SecException("", 601);
                }
            }
            String str2 = (String) map.get("INPUT");
            if (com.taobao.wireless.security.adapter.common.a.a(str2)) {
                String.format("Input map value invalid : some key not exits or the relative value is empty", new Object[0]);
                throw new SecException("", 601);
            }
            return new String[]{str2, str};
        }
        String.format("Input map size invalid : required size is 1 OR 2 and actual size is \"%d\"", new Object[]{Integer.valueOf(map.size())});
        throw new SecException("", 601);
    }

    public String a(SecurityGuardParamContext securityGuardParamContext, String str, boolean z) throws SecException {
        String[] a;
        String[] b;
        int i;
        String str2 = securityGuardParamContext.appKey;
        Map map = securityGuardParamContext.paramMap;
        a aVar = a.l[securityGuardParamContext.requestType];
        switch (AnonymousClass1.a[aVar.ordinal()]) {
            case 1:
                a = a(map);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                b = b(map);
                i = 1;
                break;
            case 8:
            case 9:
            case 10:
                a = c(map);
                break;
            default:
                b = null;
                i = 0;
                break;
        }
        b = a;
        i = 2;
        if (b == null || i == 0) {
            throw new SecException("", 601);
        }
        return a(b, i, str2, aVar.ordinal(), str);
    }
}
