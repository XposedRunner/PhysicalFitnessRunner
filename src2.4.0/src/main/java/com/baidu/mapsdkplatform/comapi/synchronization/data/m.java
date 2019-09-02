package com.baidu.mapsdkplatform.comapi.synchronization.data;

import cn.jiguang.net.HttpUtils;
import com.baidu.mapsdkplatform.comapi.synchronization.c.f;
import com.baidu.mapsdkplatform.comapi.synchronization.d.a;
import com.baidu.mapsdkplatform.comapi.synchronization.d.c;
import com.baidu.mapsdkplatform.comapi.synchronization.d.d;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;

public class m {
    private static final String a = "m";
    private static boolean e = true;
    private d b = new d();
    private boolean c = true;
    private boolean d = true;

    public m(f fVar) {
        a(fVar);
    }

    private void a(f fVar) {
        this.b.a("order_id", b(fVar));
        this.b.a("company", fVar.c());
        this.b.a("order_attr", fVar.b());
        this.b.a("status", String.valueOf(fVar.h()));
        this.b.a("pull_type", String.valueOf(fVar.i()));
        this.b.a("route_finger", fVar.d());
        this.b.a("traffic_finger", fVar.e());
        this.b.a("pos_num", String.valueOf(fVar.j()));
        c(fVar);
        d(fVar);
        if (this.c) {
            b();
        }
    }

    private String b(f fVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fVar.c().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append(fVar.a().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
        String a = c.a(stringBuffer.toString());
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The orderId = ");
        stringBuilder.append(stringBuffer.toString());
        stringBuilder.append("; result = ");
        stringBuilder.append(a);
        a.a(str, stringBuilder.toString());
        return a;
    }

    private void b() {
        String authToken = SyncSysInfo.getAuthToken();
        if (authToken == null) {
            a.b(a, "Token is null, permission check again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                String str = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Permission check result is: ");
                stringBuilder.append(permissionCheck);
                a.b(str, stringBuilder.toString());
            }
            authToken = SyncSysInfo.getAuthToken();
        }
        this.b.a("token", authToken);
    }

    private String c() {
        return e ? f.a() : f.b();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:8:0x001d in {2, 4, 7} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private void c(com.baidu.mapsdkplatform.comapi.synchronization.data.f r3) {
        /*
        r2 = this;
        r3 = r3.g();
        r0 = com.baidu.mapsdkplatform.comapi.synchronization.data.f.b.DRIVING;
        if (r0 != r3) goto L_0x0012;
        r3 = r2.b;
        r0 = "trip_mode";
        r1 = "driving";
        r3.a(r0, r1);
        return;
        r0 = com.baidu.mapsdkplatform.comapi.synchronization.data.f.b.RIDING;
        if (r0 != r3) goto L_0x0008;
        r3 = r2.b;
        r0 = "trip_mode";
        r1 = "riding";
        goto L_0x000e;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.data.m.c(com.baidu.mapsdkplatform.comapi.synchronization.data.f):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:14:0x0033 in {2, 4, 7, 10, 13} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private void d(com.baidu.mapsdkplatform.comapi.synchronization.data.f r3) {
        /*
        r2 = this;
        r3 = r3.f();
        r0 = com.baidu.mapsdkplatform.comapi.synchronization.data.f.a.BD09LL;
        if (r0 != r3) goto L_0x0012;
        r3 = r2.b;
        r0 = "coord_type";
        r1 = "bd09ll";
        r3.a(r0, r1);
        return;
        r0 = com.baidu.mapsdkplatform.comapi.synchronization.data.f.a.BD09MC;
        if (r0 != r3) goto L_0x001d;
        r3 = r2.b;
        r0 = "coord_type";
        r1 = "bd09mc";
        goto L_0x000e;
        r0 = com.baidu.mapsdkplatform.comapi.synchronization.data.f.a.GPS;
        if (r0 != r3) goto L_0x0028;
        r3 = r2.b;
        r0 = "coord_type";
        r1 = "wgs84";
        goto L_0x000e;
        r0 = com.baidu.mapsdkplatform.comapi.synchronization.data.f.a.COMMON;
        if (r0 != r3) goto L_0x0008;
        r3 = r2.b;
        r0 = "coord_type";
        r1 = "gcj02";
        goto L_0x000e;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.data.m.d(com.baidu.mapsdkplatform.comapi.synchronization.data.f):void");
    }

    /* Access modifiers changed, original: 0000 */
    public String a() {
        StringBuffer stringBuffer = new StringBuffer(this.b.a());
        stringBuffer.append(SyncSysInfo.getPhoneInfo());
        if (this.d) {
            String signMD5String = AppMD5.getSignMD5String(stringBuffer.toString());
            stringBuffer.append("&sign=");
            stringBuffer.append(signMD5String);
        }
        StringBuffer stringBuffer2 = new StringBuffer(c());
        stringBuffer2.append(HttpUtils.URL_AND_PARA_SEPARATOR);
        stringBuffer2.append(stringBuffer);
        return stringBuffer2.toString();
    }
}
