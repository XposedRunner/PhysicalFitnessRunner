package com.baidu.location.indoor.mapversion.b;

import com.baidu.location.indoor.mapversion.IndoorJni;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {
    private static Lock a = new ReentrantLock();

    public static boolean a() {
        return IndoorJni.a;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 16, insn: 0x0071: MOVE  (r13 ?[OBJECT, ARRAY]) = (r16 ?[OBJECT, ARRAY]), block:B:21:?, method: com.baidu.location.indoor.mapversion.b.a.a(java.lang.String):boolean
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:162)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:184)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:133)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
    public static synchronized boolean a(java.lang.String r19) {
        /*
        r13 = r19;
        r14 = com.baidu.location.indoor.mapversion.b.a.class;
        monitor-enter(r14);
        r1 = a();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r2 = 0;
        if (r1 != 0) goto L_0x000e;
        monitor-exit(r14);
        return r2;
        r1 = com.baidu.location.indoor.mapversion.c.a.a();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r15 = r1.b(r13);	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1 = com.baidu.location.indoor.mapversion.c.a.a();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r11 = r1.c(r13);	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        if (r15 != 0) goto L_0x0022;
        monitor-exit(r14);
        return r2;
        r1 = "gcj02";	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r15.a(r1);	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r3 = r15.g;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1 = r15.a();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r4 = r1.a;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1 = r15.a();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r6 = r1.b;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1 = com.baidu.location.indoor.mapversion.c.a.a();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1 = r1.c();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        if (r1 != 0) goto L_0x0041;
        monitor-exit(r14);
        return r2;
        r2 = r15.a();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r8 = r2.d;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r8 = -r8;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r9 = r1.a(r8);	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r2 = r15.a();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r16 = r11;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r11 = r2.f;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r11 = -r11;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r11 = r1.b(r11);	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1 = a;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1.lock();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1 = r15.f;	 Catch:{ Exception -> 0x008f }
        r1 = r1.g;	 Catch:{ Exception -> 0x008f }
        r8 = (int) r1;	 Catch:{ Exception -> 0x008f }
        r1 = r15.f;	 Catch:{ Exception -> 0x008f }
        r1 = r1.h;	 Catch:{ Exception -> 0x008f }
        r2 = (int) r1;	 Catch:{ Exception -> 0x008f }
        r1 = r13;	 Catch:{ Exception -> 0x008f }
        r17 = r2;	 Catch:{ Exception -> 0x008f }
        r2 = r3;	 Catch:{ Exception -> 0x008f }
        r3 = r4;	 Catch:{ Exception -> 0x008f }
        r5 = r6;	 Catch:{ Exception -> 0x008f }
        r7 = r8;	 Catch:{ Exception -> 0x008f }
        r8 = r17;	 Catch:{ Exception -> 0x008f }
        r13 = r16;	 Catch:{ Exception -> 0x008f }
        com.baidu.location.indoor.mapversion.IndoorJni.setPfRdnt(r1, r2, r3, r5, r7, r8, r9, r11);	 Catch:{ Exception -> 0x008f }
        r1 = r15.f;	 Catch:{ Exception -> 0x008f }
        r1 = r1.g;	 Catch:{ Exception -> 0x008f }
        r1 = (int) r1;	 Catch:{ Exception -> 0x008f }
        r2 = r15.f;	 Catch:{ Exception -> 0x008f }
        r2 = r2.h;	 Catch:{ Exception -> 0x008f }
        r2 = (int) r2;	 Catch:{ Exception -> 0x008f }
        r4 = r13;	 Catch:{ Exception -> 0x008f }
        r3 = r19;	 Catch:{ Exception -> 0x008f }
        com.baidu.location.indoor.mapversion.IndoorJni.setPfGeoMap(r4, r3, r1, r2);	 Catch:{ Exception -> 0x008f }
        r1 = a;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1.unlock();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        goto L_0x0097;
        r0 = move-exception;
        r1 = r0;
        goto L_0x009a;
        r0 = move-exception;
        r1 = r0;
        r1.printStackTrace();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r1 = a;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        goto L_0x0088;
        r1 = 1;
        monitor-exit(r14);
        return r1;
        r2 = a;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r2.unlock();	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        throw r1;	 Catch:{ all -> 0x008c, all -> 0x00a0 }
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r14);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.b.a.a(java.lang.String):boolean");
    }

    /* JADX WARNING: Missing block: B:26:0x0071, code skipped:
            return r1;
     */
    public static synchronized double[] a(double r19, double r21, double r23, double r25, double r27) {
        /*
        r1 = r19;
        r3 = r21;
        r5 = com.baidu.location.indoor.mapversion.b.a.class;
        monitor-enter(r5);
        r6 = a();	 Catch:{ all -> 0x0078 }
        if (r6 != 0) goto L_0x0010;
    L_0x000d:
        r1 = 0;
        monitor-exit(r5);
        return r1;
    L_0x0010:
        r6 = com.baidu.location.indoor.mapversion.c.a.a();	 Catch:{ all -> 0x0078 }
        r6.a(r1, r3);	 Catch:{ all -> 0x0078 }
        r6 = com.baidu.location.indoor.mapversion.c.a.a();	 Catch:{ all -> 0x0078 }
        r6 = r6.c();	 Catch:{ all -> 0x0078 }
        r7 = r6.a(r1);	 Catch:{ all -> 0x0078 }
        r9 = r6.b(r3);	 Catch:{ all -> 0x0078 }
        r1 = 12;
        r1 = new double[r1];	 Catch:{ all -> 0x0078 }
        r1 = {-4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400};	 Catch:{ all -> 0x0078 }
        r2 = a;	 Catch:{ all -> 0x0078 }
        r2.lock();	 Catch:{ all -> 0x0078 }
        r17 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x004b }
        r11 = r23;
        r13 = r25;
        r15 = r27;
        r2 = com.baidu.location.indoor.mapversion.IndoorJni.setPfGps(r7, r9, r11, r13, r15, r17);	 Catch:{ Exception -> 0x004b }
        r1 = a;	 Catch:{ all -> 0x0078 }
        r1.unlock();	 Catch:{ all -> 0x0078 }
        r1 = r2;
        goto L_0x0055;
    L_0x0048:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0072;
    L_0x004b:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();	 Catch:{ all -> 0x0048 }
        r2 = a;	 Catch:{ all -> 0x0078 }
        r2.unlock();	 Catch:{ all -> 0x0078 }
    L_0x0055:
        r2 = 0;
        r2 = r1[r2];	 Catch:{ all -> 0x0078 }
        r7 = 0;
        r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r4 != 0) goto L_0x0070;
    L_0x005e:
        r2 = 1;
        r3 = r1[r2];	 Catch:{ all -> 0x0078 }
        r3 = r6.c(r3);	 Catch:{ all -> 0x0078 }
        r7 = 2;
        r8 = r1[r7];	 Catch:{ all -> 0x0078 }
        r8 = r6.d(r8);	 Catch:{ all -> 0x0078 }
        r1[r2] = r3;	 Catch:{ all -> 0x0078 }
        r1[r7] = r8;	 Catch:{ all -> 0x0078 }
    L_0x0070:
        monitor-exit(r5);
        return r1;
    L_0x0072:
        r2 = a;	 Catch:{ all -> 0x0078 }
        r2.unlock();	 Catch:{ all -> 0x0078 }
        throw r1;	 Catch:{ all -> 0x0078 }
    L_0x0078:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r5);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.b.a.a(double, double, double, double, double):double[]");
    }

    /* JADX WARNING: Missing block: B:29:0x0071, code skipped:
            return r2;
     */
    public static synchronized double[] a(com.baidu.location.BDLocation r13) {
        /*
        r0 = com.baidu.location.indoor.mapversion.b.a.class;
        monitor-enter(r0);
        r1 = a();	 Catch:{ all -> 0x0072 }
        if (r1 != 0) goto L_0x000c;
    L_0x0009:
        r13 = 0;
        monitor-exit(r0);
        return r13;
    L_0x000c:
        r1 = com.baidu.location.indoor.mapversion.c.a.a();	 Catch:{ all -> 0x0072 }
        r1 = r1.c();	 Catch:{ all -> 0x0072 }
        r2 = 12;
        r2 = new double[r2];	 Catch:{ all -> 0x0072 }
        r2 = {-4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400};	 Catch:{ all -> 0x0072 }
        if (r1 == 0) goto L_0x0070;
    L_0x001d:
        r3 = r13.getLongitude();	 Catch:{ all -> 0x0072 }
        r5 = r1.a(r3);	 Catch:{ all -> 0x0072 }
        r3 = r13.getLatitude();	 Catch:{ all -> 0x0072 }
        r7 = r1.b(r3);	 Catch:{ all -> 0x0072 }
        r13 = a;	 Catch:{ all -> 0x0072 }
        r13.lock();	 Catch:{ all -> 0x0072 }
        r9 = 4620693217682128896; // 0x4020000000000000 float:0.0 double:8.0;
        r11 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0045 }
        r13 = com.baidu.location.indoor.mapversion.IndoorJni.setPfWf(r5, r7, r9, r11);	 Catch:{ Exception -> 0x0045 }
        r2 = a;	 Catch:{ all -> 0x0072 }
        r2.unlock();	 Catch:{ all -> 0x0072 }
        r2 = r13;
        goto L_0x004e;
    L_0x0043:
        r13 = move-exception;
        goto L_0x006a;
    L_0x0045:
        r13 = move-exception;
        r13.printStackTrace();	 Catch:{ all -> 0x0043 }
        r13 = a;	 Catch:{ all -> 0x0072 }
        r13.unlock();	 Catch:{ all -> 0x0072 }
    L_0x004e:
        r13 = 0;
        r3 = r2[r13];	 Catch:{ all -> 0x0072 }
        r5 = 0;
        r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r13 != 0) goto L_0x0070;
    L_0x0057:
        r13 = 1;
        r3 = r2[r13];	 Catch:{ all -> 0x0072 }
        r3 = r1.c(r3);	 Catch:{ all -> 0x0072 }
        r5 = 2;
        r6 = r2[r5];	 Catch:{ all -> 0x0072 }
        r6 = r1.d(r6);	 Catch:{ all -> 0x0072 }
        r2[r13] = r3;	 Catch:{ all -> 0x0072 }
        r2[r5] = r6;	 Catch:{ all -> 0x0072 }
        goto L_0x0070;
    L_0x006a:
        r1 = a;	 Catch:{ all -> 0x0072 }
        r1.unlock();	 Catch:{ all -> 0x0072 }
        throw r13;	 Catch:{ all -> 0x0072 }
    L_0x0070:
        monitor-exit(r0);
        return r2;
    L_0x0072:
        r13 = move-exception;
        monitor-exit(r0);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.b.a.a(com.baidu.location.BDLocation):double[]");
    }

    /* JADX WARNING: Missing block: B:28:0x0061, code skipped:
            return r9;
     */
    public static synchronized double[] a(java.lang.String r7, double r8, double r10, double r12) {
        /*
        r7 = com.baidu.location.indoor.mapversion.b.a.class;
        monitor-enter(r7);
        r8 = a();	 Catch:{ all -> 0x0062 }
        if (r8 != 0) goto L_0x000c;
    L_0x0009:
        r8 = 0;
        monitor-exit(r7);
        return r8;
    L_0x000c:
        r8 = com.baidu.location.indoor.mapversion.c.a.a();	 Catch:{ all -> 0x0062 }
        r8 = r8.c();	 Catch:{ all -> 0x0062 }
        r9 = 12;
        r9 = new double[r9];	 Catch:{ all -> 0x0062 }
        r9 = {-4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400, -4616189618054758400};	 Catch:{ all -> 0x0062 }
        if (r8 == 0) goto L_0x0060;
    L_0x001d:
        r0 = a;	 Catch:{ all -> 0x0062 }
        r0.lock();	 Catch:{ all -> 0x0062 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0035 }
        r1 = r10;
        r3 = r12;
        r10 = com.baidu.location.indoor.mapversion.IndoorJni.setPfDr(r1, r3, r5);	 Catch:{ Exception -> 0x0035 }
        r9 = a;	 Catch:{ all -> 0x0062 }
        r9.unlock();	 Catch:{ all -> 0x0062 }
        r9 = r10;
        goto L_0x003e;
    L_0x0033:
        r8 = move-exception;
        goto L_0x005a;
    L_0x0035:
        r10 = move-exception;
        r10.printStackTrace();	 Catch:{ all -> 0x0033 }
        r10 = a;	 Catch:{ all -> 0x0062 }
        r10.unlock();	 Catch:{ all -> 0x0062 }
    L_0x003e:
        r10 = 0;
        r10 = r9[r10];	 Catch:{ all -> 0x0062 }
        r12 = 0;
        r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r0 != 0) goto L_0x0060;
    L_0x0047:
        r10 = 1;
        r11 = r9[r10];	 Catch:{ all -> 0x0062 }
        r11 = r8.c(r11);	 Catch:{ all -> 0x0062 }
        r13 = 2;
        r0 = r9[r13];	 Catch:{ all -> 0x0062 }
        r0 = r8.d(r0);	 Catch:{ all -> 0x0062 }
        r9[r10] = r11;	 Catch:{ all -> 0x0062 }
        r9[r13] = r0;	 Catch:{ all -> 0x0062 }
        goto L_0x0060;
    L_0x005a:
        r9 = a;	 Catch:{ all -> 0x0062 }
        r9.unlock();	 Catch:{ all -> 0x0062 }
        throw r8;	 Catch:{ all -> 0x0062 }
    L_0x0060:
        monitor-exit(r7);
        return r9;
    L_0x0062:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.b.a.a(java.lang.String, double, double, double):double[]");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:14:0x001c in {2, 5, 7, 13, 16} preds:[]
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
    public static void b() {
        /*
        r0 = a();
        if (r0 != 0) goto L_0x0007;
        return;
        r0 = a;
        r0.lock();
        com.baidu.location.indoor.mapversion.IndoorJni.initPf();	 Catch:{ Exception -> 0x0017 }
        r0 = a;
        r0.unlock();
        return;
        r0 = move-exception;
        goto L_0x001d;
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0015 }
        goto L_0x000f;
        return;
        r1 = a;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.b.a.b():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:14:0x001c in {2, 5, 7, 13, 16} preds:[]
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
    public static void c() {
        /*
        r0 = a();
        if (r0 != 0) goto L_0x0007;
        return;
        r0 = a;
        r0.lock();
        com.baidu.location.indoor.mapversion.IndoorJni.resetPf();	 Catch:{ Exception -> 0x0017 }
        r0 = a;
        r0.unlock();
        return;
        r0 = move-exception;
        goto L_0x001d;
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0015 }
        goto L_0x000f;
        return;
        r1 = a;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.b.a.c():void");
    }
}
