package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import java.lang.reflect.Method;
import java.util.TimeZone;

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
public class DeviceInfoCapturer {
    private static Context a = null;
    private static b b = null;
    private static SecurityGuardMainPlugin c = null;
    private static boolean d = false;
    private static Object e;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.DeviceInfoCapturer.<clinit>():void, dex: 
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.DeviceInfoCapturer.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.DeviceInfoCapturer.<clinit>():void");
    }

    private DeviceInfoCapturer() {
    }

    private static String a() {
        Context context = a;
        String str = "";
        try {
            return ((IUMIDComponent) c.getInterface(IUMIDComponent.class)).getSecurityToken();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String b() {
        b bVar = b;
        return bVar != null ? bVar.a() : null;
    }

    private static String c() {
        b bVar = b;
        return bVar != null ? bVar.a(64) : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044 A:{SYNTHETIC, Splitter:B:16:0x0044} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044 A:{SYNTHETIC, Splitter:B:16:0x0044} */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044 A:{SYNTHETIC, Splitter:B:16:0x0044} */
    private static java.lang.String d() {
        /*
        r0 = -1;
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x003e }
        r3 = 8;
        r4 = 0;
        if (r2 <= r3) goto L_0x001e;
    L_0x0009:
        r2 = a;	 Catch:{ Throwable -> 0x003e }
        r2 = r2.getPackageManager();	 Catch:{ Throwable -> 0x003e }
        r3 = a;	 Catch:{ Throwable -> 0x003e }
        r3 = r3.getPackageName();	 Catch:{ Throwable -> 0x003e }
        r2 = r2.getPackageInfo(r3, r4);	 Catch:{ Throwable -> 0x003e }
        if (r2 == 0) goto L_0x003e;
    L_0x001b:
        r2 = r2.firstInstallTime;	 Catch:{ Throwable -> 0x003e }
        goto L_0x003f;
    L_0x001e:
        r2 = a;	 Catch:{ Throwable -> 0x003e }
        r2 = r2.getPackageManager();	 Catch:{ Throwable -> 0x003e }
        r3 = a;	 Catch:{ Throwable -> 0x003e }
        r3 = r3.getPackageName();	 Catch:{ Throwable -> 0x003e }
        r2 = r2.getApplicationInfo(r3, r4);	 Catch:{ Throwable -> 0x003e }
        if (r2 == 0) goto L_0x003e;
    L_0x0030:
        r2 = r2.sourceDir;	 Catch:{ Throwable -> 0x003e }
        if (r2 == 0) goto L_0x003e;
    L_0x0034:
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x003e }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x003e }
        r2 = r3.lastModified();	 Catch:{ Throwable -> 0x003e }
        goto L_0x003f;
    L_0x003e:
        r2 = r0;
    L_0x003f:
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        r0 = 0;
        if (r4 == 0) goto L_0x0054;
    L_0x0044:
        r1 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0054 }
        r4 = "yyyy-MM-dd HH:mm:ss.SSS";
        r1.<init>(r4);	 Catch:{ Exception -> 0x0054 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0054 }
        r1 = r1.format(r2);	 Catch:{ Exception -> 0x0054 }
        r0 = r1;
    L_0x0054:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.DeviceInfoCapturer.d():java.lang.String");
    }

    /* JADX WARNING: Missing block: B:71:0x016c, code skipped:
            return r5;
     */
    /* JADX WARNING: Missing block: B:73:0x0171, code skipped:
            if (com.taobao.wireless.security.adapter.datacollection.f.e() != false) goto L_0x0173;
     */
    /* JADX WARNING: Missing block: B:74:0x0173, code skipped:
            r5 = "1";
     */
    /* JADX WARNING: Missing block: B:75:0x0176, code skipped:
            r5 = "0";
     */
    /* JADX WARNING: Missing block: B:113:0x01df, code skipped:
            if (com.taobao.wireless.security.adapter.datacollection.f.a("android.hardware.wifi") != false) goto L_0x0173;
     */
    public static java.lang.String doCommandForString(int r5) {
        /*
        r0 = d;
        r1 = 1;
        if (r0 != 0) goto L_0x003b;
    L_0x0005:
        r0 = e;
        monitor-enter(r0);
        r2 = d;	 Catch:{ all -> 0x0038 }
        if (r2 != 0) goto L_0x0036;
    L_0x000c:
        r2 = a;	 Catch:{ all -> 0x0038 }
        com.taobao.wireless.security.adapter.datacollection.f.a(r2);	 Catch:{ all -> 0x0038 }
        r2 = a;	 Catch:{ all -> 0x0038 }
        com.taobao.wireless.security.adapter.datacollection.g.a(r2);	 Catch:{ all -> 0x0038 }
        r2 = a;	 Catch:{ all -> 0x0038 }
        com.taobao.wireless.security.adapter.datacollection.h.a(r2);	 Catch:{ all -> 0x0038 }
        r2 = a;	 Catch:{ all -> 0x0038 }
        com.taobao.wireless.security.adapter.datacollection.a.a(r2);	 Catch:{ all -> 0x0038 }
        r2 = a;	 Catch:{ all -> 0x0038 }
        com.taobao.wireless.security.adapter.datacollection.j.a(r2);	 Catch:{ all -> 0x0038 }
        r2 = a;	 Catch:{ all -> 0x0038 }
        com.taobao.wireless.security.adapter.datacollection.e.a(r2);	 Catch:{ all -> 0x0038 }
        r2 = a;	 Catch:{ all -> 0x0038 }
        com.taobao.wireless.security.adapter.datacollection.c.a(r2);	 Catch:{ all -> 0x0038 }
        r2 = a;	 Catch:{ all -> 0x0038 }
        com.taobao.wireless.security.adapter.datacollection.i.a(r2);	 Catch:{ all -> 0x0038 }
        d = r1;	 Catch:{ all -> 0x0038 }
    L_0x0036:
        monitor-exit(r0);	 Catch:{ all -> 0x0038 }
        goto L_0x003b;
    L_0x0038:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0038 }
        throw r5;
    L_0x003b:
        r0 = 9;
        r2 = 4;
        r3 = 2;
        r4 = 0;
        switch(r5) {
            case 0: goto L_0x01d9;
            case 1: goto L_0x01d0;
            case 2: goto L_0x01c7;
            case 3: goto L_0x01be;
            case 4: goto L_0x01b5;
            case 5: goto L_0x01ac;
            case 6: goto L_0x01a3;
            case 7: goto L_0x019c;
            case 8: goto L_0x0195;
            case 9: goto L_0x018e;
            case 10: goto L_0x0187;
            case 11: goto L_0x0180;
            case 12: goto L_0x0179;
            case 13: goto L_0x016d;
            default: goto L_0x0043;
        };
    L_0x0043:
        switch(r5) {
            case 100: goto L_0x0167;
            case 101: goto L_0x0162;
            case 102: goto L_0x015d;
            case 103: goto L_0x0158;
            case 104: goto L_0x0153;
            case 105: goto L_0x014e;
            case 106: goto L_0x0149;
            case 107: goto L_0x0144;
            case 108: goto L_0x01e2;
            case 109: goto L_0x013f;
            case 110: goto L_0x013a;
            case 111: goto L_0x0135;
            case 112: goto L_0x0130;
            case 113: goto L_0x012b;
            case 114: goto L_0x0126;
            case 115: goto L_0x0121;
            case 116: goto L_0x011c;
            case 117: goto L_0x0117;
            case 118: goto L_0x0112;
            case 119: goto L_0x010d;
            case 120: goto L_0x0107;
            case 121: goto L_0x0101;
            case 122: goto L_0x00fb;
            case 123: goto L_0x00f5;
            case 124: goto L_0x00ef;
            case 125: goto L_0x00e9;
            case 126: goto L_0x00e3;
            case 127: goto L_0x00dd;
            case 128: goto L_0x00d7;
            case 129: goto L_0x00d1;
            case 130: goto L_0x00cb;
            case 131: goto L_0x00c5;
            case 132: goto L_0x00bf;
            case 133: goto L_0x00b9;
            case 134: goto L_0x00b3;
            case 135: goto L_0x00ad;
            case 136: goto L_0x00a7;
            case 137: goto L_0x00a1;
            case 138: goto L_0x009b;
            case 139: goto L_0x0095;
            case 140: goto L_0x008f;
            case 141: goto L_0x0089;
            case 142: goto L_0x0083;
            case 143: goto L_0x007d;
            case 144: goto L_0x0077;
            case 145: goto L_0x0071;
            case 146: goto L_0x006b;
            case 147: goto L_0x0065;
            case 148: goto L_0x005f;
            case 149: goto L_0x01e2;
            case 150: goto L_0x0059;
            case 151: goto L_0x0053;
            case 152: goto L_0x004d;
            case 153: goto L_0x0047;
            default: goto L_0x0046;
        };
    L_0x0046:
        return r4;
    L_0x0047:
        r5 = com.taobao.wireless.security.adapter.datacollection.a.b();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x004d:
        r5 = com.taobao.wireless.security.adapter.datacollection.j.e();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0053:
        r5 = d();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0059:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.p();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x005f:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.c();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0065:
        r5 = g();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x006b:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.f();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0071:
        r5 = f();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0077:
        r5 = com.taobao.wireless.security.adapter.datacollection.f.f();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x007d:
        r5 = com.taobao.wireless.security.adapter.datacollection.f.b();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0083:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0089:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x008f:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.o();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0095:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.c(r3);	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x009b:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.b(r3);	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00a1:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.c(r2);	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00a7:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.b(r2);	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00ad:
        r5 = com.taobao.wireless.security.adapter.datacollection.i.a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00b3:
        r5 = com.taobao.wireless.security.adapter.datacollection.h.c();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00b9:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.n();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00bf:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.m();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00c5:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.l();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00cb:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.k();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00d1:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.d();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00d7:
        r5 = com.taobao.wireless.security.adapter.datacollection.e.c();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00dd:
        r5 = e();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00e3:
        r5 = c();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00e9:
        r5 = com.taobao.wireless.security.adapter.datacollection.e.b();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00ef:
        r5 = com.taobao.wireless.security.adapter.datacollection.j.c();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00f5:
        r5 = com.taobao.wireless.security.adapter.datacollection.f.c();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x00fb:
        r5 = com.taobao.wireless.security.adapter.datacollection.f.a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0101:
        r5 = b();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0107:
        r5 = a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x010d:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.j();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0112:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.i();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0117:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.h();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x011c:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.g();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0121:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.e();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0126:
        r5 = com.taobao.wireless.security.adapter.datacollection.c.b();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x012b:
        r5 = com.taobao.wireless.security.adapter.datacollection.a.a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0130:
        r5 = com.taobao.wireless.security.adapter.datacollection.e.a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0135:
        r5 = com.taobao.wireless.security.adapter.datacollection.j.b();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x013a:
        r5 = com.taobao.wireless.security.adapter.datacollection.j.a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x013f:
        r5 = com.taobao.wireless.security.adapter.datacollection.j.g();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0144:
        r5 = com.taobao.wireless.security.adapter.datacollection.h.e();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0149:
        r5 = com.taobao.wireless.security.adapter.datacollection.h.d();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x014e:
        r5 = com.taobao.wireless.security.adapter.datacollection.h.b();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0153:
        r5 = com.taobao.wireless.security.adapter.datacollection.h.a();	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0158:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.c(r0);	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x015d:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.b(r0);	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0162:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.c(r1);	 Catch:{ Exception -> 0x01e2 }
        goto L_0x016b;
    L_0x0167:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.b(r1);	 Catch:{ Exception -> 0x01e2 }
    L_0x016b:
        r4 = r5;
        return r4;
    L_0x016d:
        r5 = com.taobao.wireless.security.adapter.datacollection.f.e();	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x0173:
        r5 = "1";
        goto L_0x016b;
    L_0x0176:
        r5 = "0";
        goto L_0x016b;
    L_0x0179:
        r5 = com.taobao.wireless.security.adapter.datacollection.f.d();	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x017f:
        goto L_0x0173;
    L_0x0180:
        r5 = com.taobao.wireless.security.adapter.datacollection.j.d();	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x0186:
        goto L_0x0173;
    L_0x0187:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.a(r3);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x018d:
        goto L_0x0173;
    L_0x018e:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.a(r2);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x0194:
        goto L_0x0173;
    L_0x0195:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.a(r0);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x019b:
        goto L_0x0173;
    L_0x019c:
        r5 = com.taobao.wireless.security.adapter.datacollection.g.a(r1);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x01a2:
        goto L_0x0173;
    L_0x01a3:
        r5 = "android.hardware.nfc";
        r5 = com.taobao.wireless.security.adapter.datacollection.f.a(r5);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x01ab:
        goto L_0x0173;
    L_0x01ac:
        r5 = "android.hardware.location.gps";
        r5 = com.taobao.wireless.security.adapter.datacollection.f.a(r5);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x01b4:
        goto L_0x0173;
    L_0x01b5:
        r5 = "android.hardware.usb.accessory";
        r5 = com.taobao.wireless.security.adapter.datacollection.f.a(r5);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x01bd:
        goto L_0x0173;
    L_0x01be:
        r5 = "android.hardware.telephony";
        r5 = com.taobao.wireless.security.adapter.datacollection.f.a(r5);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x01c6:
        goto L_0x0173;
    L_0x01c7:
        r5 = "android.hardware.bluetooth_le";
        r5 = com.taobao.wireless.security.adapter.datacollection.f.a(r5);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x01cf:
        goto L_0x0173;
    L_0x01d0:
        r5 = "android.hardware.bluetooth";
        r5 = com.taobao.wireless.security.adapter.datacollection.f.a(r5);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x01d8:
        goto L_0x0173;
    L_0x01d9:
        r5 = "android.hardware.wifi";
        r5 = com.taobao.wireless.security.adapter.datacollection.f.a(r5);	 Catch:{ Exception -> 0x01e2 }
        if (r5 == 0) goto L_0x0176;
    L_0x01e1:
        goto L_0x0173;
    L_0x01e2:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.DeviceInfoCapturer.doCommandForString(int):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    private static java.lang.String e() {
        /*
        r0 = -1;
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x004a }
        r3 = 8;
        r4 = 0;
        if (r2 <= r3) goto L_0x0025;
    L_0x0009:
        r2 = a;	 Catch:{ Exception -> 0x004a }
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x004a }
        r3 = a;	 Catch:{ Exception -> 0x004a }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x004a }
        r2 = r2.getPackageInfo(r3, r4);	 Catch:{ Exception -> 0x004a }
        if (r2 == 0) goto L_0x004a;
    L_0x001b:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x004a }
        r5 = r2.firstInstallTime;	 Catch:{ Exception -> 0x004a }
        r2 = 0;
    L_0x0022:
        r7 = r3 - r5;
        goto L_0x004b;
    L_0x0025:
        r2 = a;	 Catch:{ Exception -> 0x004a }
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x004a }
        r3 = a;	 Catch:{ Exception -> 0x004a }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x004a }
        r2 = r2.getApplicationInfo(r3, r4);	 Catch:{ Exception -> 0x004a }
        if (r2 == 0) goto L_0x004a;
    L_0x0037:
        r2 = r2.sourceDir;	 Catch:{ Exception -> 0x004a }
        if (r2 == 0) goto L_0x004a;
    L_0x003b:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x004a }
        r5 = new java.io.File;	 Catch:{ Exception -> 0x004a }
        r5.<init>(r2);	 Catch:{ Exception -> 0x004a }
        r5 = r5.lastModified();	 Catch:{ Exception -> 0x004a }
        r2 = 0;
        goto L_0x0022;
    L_0x004a:
        r7 = r0;
    L_0x004b:
        r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r2 == 0) goto L_0x0054;
    L_0x004f:
        r0 = java.lang.String.valueOf(r7);
        return r0;
    L_0x0054:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.DeviceInfoCapturer.e():java.lang.String");
    }

    private static String f() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(timeZone.getID());
            stringBuilder.append(" ");
            stringBuilder.append(timeZone.getDisplayName(false, 0));
            return stringBuilder.toString();
        } catch (AssertionError | Exception unused) {
            return null;
        }
    }

    private static String g() {
        try {
            Class cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
            if (cls == null) {
                return null;
            }
            Method declaredMethod = cls.getDeclaredMethod("getGlobalUserData", new Class[0]);
            if (declaredMethod == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void initialize(ISecurityGuardPlugin iSecurityGuardPlugin, b bVar) {
        c = (SecurityGuardMainPlugin) iSecurityGuardPlugin;
        a = c.getContext();
        b = bVar;
        e = new Object();
    }
}
