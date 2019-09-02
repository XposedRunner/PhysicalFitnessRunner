package com.alibaba.wireless.security.mainplugin;

import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.atlasencrypt.a;
import com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class b {
    public static Object a(Class cls, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
    }

    public void a(HashMap<Class, Object> hashMap, SecurityGuardMainPlugin securityGuardMainPlugin) {
        hashMap.put(IAtlasEncryptComponent.class, new a(securityGuardMainPlugin));
        hashMap.put(IDataCollectionComponent.class, new com.alibaba.wireless.security.open.datacollection.a(securityGuardMainPlugin));
        hashMap.put(IDynamicDataEncryptComponent.class, new com.alibaba.wireless.security.open.dynamicdataencrypt.a(securityGuardMainPlugin));
        hashMap.put(IDynamicDataStoreComponent.class, new com.alibaba.wireless.security.open.dynamicdatastore.a(securityGuardMainPlugin));
        hashMap.put(IOpenSDKComponent.class, new com.alibaba.wireless.security.open.opensdk.a(securityGuardMainPlugin));
        hashMap.put(ISecureSignatureComponent.class, new com.alibaba.wireless.security.open.securesignature.a(securityGuardMainPlugin));
        hashMap.put(IStaticDataEncryptComponent.class, new com.alibaba.wireless.security.open.staticdataencrypt.a(securityGuardMainPlugin));
        hashMap.put(IStaticDataStoreComponent.class, new com.alibaba.wireless.security.open.staticdatastore.a(securityGuardMainPlugin));
        hashMap.put(IStaticKeyEncryptComponent.class, new com.alibaba.wireless.security.open.statickeyencrypt.a(securityGuardMainPlugin));
        hashMap.put(IUMIDComponent.class, new com.alibaba.wireless.security.open.umid.a(securityGuardMainPlugin));
        hashMap.put(ISafeTokenComponent.class, new com.alibaba.wireless.security.open.safetoken.a(securityGuardMainPlugin));
        try {
            Class cls = Class.forName("com.alibaba.wireless.security.open.litevm.ILiteVMComponent");
            if (cls != null) {
                Object a = com.alibaba.wireless.security.open.litevm.a.a(cls, (ISecurityGuardPlugin) securityGuardMainPlugin);
                if (a != null) {
                    hashMap.put(cls, a);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void a(java.util.HashMap<java.lang.Class, java.lang.Object> r2, java.lang.String r3, com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin r4) {
        /*
        r1 = this;
        r0 = r3.hashCode();
        switch(r0) {
            case -2107806319: goto L_0x007d;
            case -1726912853: goto L_0x0073;
            case -1360373035: goto L_0x0068;
            case -319873839: goto L_0x005d;
            case -308669071: goto L_0x0053;
            case -202074525: goto L_0x0049;
            case 1282550417: goto L_0x003f;
            case 1441811571: goto L_0x0034;
            case 1464630417: goto L_0x002a;
            case 1852512071: goto L_0x0020;
            case 1868651473: goto L_0x0014;
            case 2038834859: goto L_0x0009;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0087;
    L_0x0009:
        r0 = "com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x0011:
        r3 = 1;
        goto L_0x0088;
    L_0x0014:
        r0 = "com.alibaba.wireless.security.open.litevm.ILiteVMComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x001c:
        r3 = 11;
        goto L_0x0088;
    L_0x0020:
        r0 = "com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x0028:
        r3 = 0;
        goto L_0x0088;
    L_0x002a:
        r0 = "com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x0032:
        r3 = 7;
        goto L_0x0088;
    L_0x0034:
        r0 = "com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x003c:
        r3 = 8;
        goto L_0x0088;
    L_0x003f:
        r0 = "com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x0047:
        r3 = 4;
        goto L_0x0088;
    L_0x0049:
        r0 = "com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x0051:
        r3 = 2;
        goto L_0x0088;
    L_0x0053:
        r0 = "com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x005b:
        r3 = 5;
        goto L_0x0088;
    L_0x005d:
        r0 = "com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x0065:
        r3 = 10;
        goto L_0x0088;
    L_0x0068:
        r0 = "com.alibaba.wireless.security.open.umid.IUMIDComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x0070:
        r3 = 9;
        goto L_0x0088;
    L_0x0073:
        r0 = "com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x007b:
        r3 = 3;
        goto L_0x0088;
    L_0x007d:
        r0 = "com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0087;
    L_0x0085:
        r3 = 6;
        goto L_0x0088;
    L_0x0087:
        r3 = -1;
    L_0x0088:
        switch(r3) {
            case 0: goto L_0x00ee;
            case 1: goto L_0x00e6;
            case 2: goto L_0x00de;
            case 3: goto L_0x00d6;
            case 4: goto L_0x00ce;
            case 5: goto L_0x00c6;
            case 6: goto L_0x00be;
            case 7: goto L_0x00b6;
            case 8: goto L_0x00ae;
            case 9: goto L_0x00a6;
            case 10: goto L_0x009e;
            case 11: goto L_0x008c;
            default: goto L_0x008b;
        };
    L_0x008b:
        return;
    L_0x008c:
        r3 = "com.alibaba.wireless.security.open.litevm.ILiteVMComponent";
        r3 = java.lang.Class.forName(r3);	 Catch:{ Exception -> 0x00f8 }
        if (r3 == 0) goto L_0x00f8;
    L_0x0094:
        r4 = com.alibaba.wireless.security.open.litevm.a.a(r3, r4);	 Catch:{ Exception -> 0x00f8 }
        if (r4 == 0) goto L_0x00f8;
    L_0x009a:
        r2.put(r3, r4);	 Catch:{ Exception -> 0x00f8 }
        return;
    L_0x009e:
        r3 = com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent.class;
        r0 = new com.alibaba.wireless.security.open.safetoken.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00a6:
        r3 = com.alibaba.wireless.security.open.umid.IUMIDComponent.class;
        r0 = new com.alibaba.wireless.security.open.umid.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00ae:
        r3 = com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent.class;
        r0 = new com.alibaba.wireless.security.open.statickeyencrypt.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00b6:
        r3 = com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent.class;
        r0 = new com.alibaba.wireless.security.open.staticdatastore.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00be:
        r3 = com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent.class;
        r0 = new com.alibaba.wireless.security.open.staticdataencrypt.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00c6:
        r3 = com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent.class;
        r0 = new com.alibaba.wireless.security.open.securesignature.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00ce:
        r3 = com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent.class;
        r0 = new com.alibaba.wireless.security.open.opensdk.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00d6:
        r3 = com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent.class;
        r0 = new com.alibaba.wireless.security.open.dynamicdatastore.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00de:
        r3 = com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent.class;
        r0 = new com.alibaba.wireless.security.open.dynamicdataencrypt.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00e6:
        r3 = com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent.class;
        r0 = new com.alibaba.wireless.security.open.datacollection.a;
        r0.<init>(r4);
        goto L_0x00f5;
    L_0x00ee:
        r3 = com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent.class;
        r0 = new com.alibaba.wireless.security.open.atlasencrypt.a;
        r0.<init>(r4);
    L_0x00f5:
        r2.put(r3, r0);
    L_0x00f8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.mainplugin.b.a(java.util.HashMap, java.lang.String, com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin):void");
    }
}
