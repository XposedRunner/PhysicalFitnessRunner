package com.taobao.dp;

import android.content.Context;
import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.taobao.dp.util.CallbackHelper;
import com.taobao.dp.util.a;
import com.taobao.dp.util.b;

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
public final class DeviceSecuritySDKImpl {
    private static final int SECURITY_TOKEN_LENGTH = 32;
    private static final int UTDID_LENGTH = 24;
    private static DeviceSecuritySDKImpl instance;
    private Context mContext;
    private int mEnv;
    private a mListenerHelper;
    private ISecurityGuardPlugin mPlugin;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.dp.DeviceSecuritySDKImpl.<clinit>():void, dex: 
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.dp.DeviceSecuritySDKImpl.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.dp.DeviceSecuritySDKImpl.<clinit>():void");
    }

    public DeviceSecuritySDKImpl(ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.mListenerHelper = null;
        this.mContext = null;
        this.mPlugin = null;
        this.mEnv = 0;
        this.mContext = iSecurityGuardPlugin.getContext();
        this.mPlugin = iSecurityGuardPlugin;
        this.mListenerHelper = new a();
        CallbackHelper.init(this);
    }

    private int getEnvironment(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return this.mEnv;
        }
    }

    private String getSecurityTokenNative(int i, boolean z) {
        IRouterComponent router = this.mPlugin.getRouter();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(z);
        return (String) router.doCommand(12302, objArr);
    }

    private void initUMIDNative(int i) {
        IRouterComponent router = this.mPlugin.getRouter();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(i);
        router.doCommand(12301, objArr);
    }

    private void resetClientDataNative(int i) {
        IRouterComponent router = this.mPlugin.getRouter();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(i);
        router.doCommand(12304, objArr);
    }

    private void setOnlineHostNative(String str) {
        IRouterComponent router = this.mPlugin.getRouter();
        Object[] objArr = new Object[1];
        objArr[0] = str;
        router.doCommand(12303, objArr);
    }

    public a getListenerHelper() {
        return this.mListenerHelper;
    }

    public String getSecurityToken(int i, boolean z) {
        String securityTokenNative = getSecurityTokenNative(i, z);
        return (securityTokenNative == null || "".equals(securityTokenNative) || !(securityTokenNative.length() == SECURITY_TOKEN_LENGTH || securityTokenNative.length() == UTDID_LENGTH)) ? "000000000000000000000000" : securityTokenNative;
    }

    public void init(IUMIDInitListenerEx iUMIDInitListenerEx) {
        int i = this.mEnv;
        this.mListenerHelper.a(i, iUMIDInitListenerEx);
        initUMIDNative(i);
    }

    public void initAsync(int i, IUMIDInitListenerEx iUMIDInitListenerEx) {
        i = getEnvironment(i);
        setEnvironment(i);
        this.mListenerHelper.a(i, iUMIDInitListenerEx);
        initUMIDNative(i);
    }

    public int initSync(int i) {
        i = getEnvironment(i);
        setEnvironment(i);
        b bVar = new b(i);
        this.mListenerHelper.a(i, bVar);
        initUMIDNative(i);
        try {
            synchronized (bVar) {
                if (!bVar.b()) {
                    bVar.wait(10000);
                }
            }
            return bVar.a();
        } catch (Exception unused) {
            return 999;
        }
    }

    public void registerListener(IUMIDInitListenerEx iUMIDInitListenerEx) {
        this.mListenerHelper.a(this.mEnv, iUMIDInitListenerEx);
    }

    public void setEnvironment(int i) {
        if (this.mEnv != i) {
            this.mEnv = i;
            resetClientDataNative(i);
        }
    }

    public synchronized void setOnlineHost(String str) throws IllegalArgumentException {
        if (str != null) {
            if (str.length() != 0) {
                setOnlineHostNative(str);
            }
        }
        throw new IllegalArgumentException("host is null");
    }
}
