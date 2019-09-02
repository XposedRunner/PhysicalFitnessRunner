package cn.jiguang.d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.b.a.a.f;
import cn.jiguang.d.d.d;
import cn.jiguang.d.e.a.a.a;
import cn.jiguang.d.h.e;
import cn.jiguang.d.h.t;
import cn.jiguang.e.c;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class g implements Runnable {
    public static AtomicLong a = new AtomicLong(0);
    public static AtomicBoolean b = new AtomicBoolean(false);
    private Context c;
    private Handler d;
    private volatile boolean e = false;
    private boolean f;
    private ExecutorService g;

    public g(Context context, Handler handler) {
        this.c = context;
        this.d = handler;
        this.f = true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:125:0x0501 in {3, 6, 10, 13, 16, 19, 22, 25, 32, 33, 34, 35, 39, 40, 43, 44, 45, 47, 50, 53, 54, 57, 58, 61, 62, 65, 66, 69, 70, 73, 74, 77, 79, 82, 83, 88, 91, 94, 97, 98, 101, 104, 107, 108, 109, 112, 116, 119, 121, 124, 131, 133, 135} preds:[]
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
    private boolean a(int r34) {
        /*
        r33 = this;
        r0 = r33;
        r1 = r34;
        r2 = r0.e;
        r3 = 0;
        if (r2 == 0) goto L_0x000a;
        return r3;
        if (r1 > 0) goto L_0x0014;
        r1 = "NetworkingClient";
        r2 = "login error,retry login too many times";
        cn.jiguang.e.c.a(r1, r2);
        return r3;
        r2 = r0.c;
        r2 = cn.jiguang.d.a.d.d(r2);
        r7 = 20480; // 0x5000 float:2.8699E-41 double:1.01185E-319;
        if (r2 == 0) goto L_0x002a;
        r2 = r0.c;
        r2 = cn.jiguang.d.a.d.e(r2);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x01db;
        r2 = r0.c;
        r11 = a;
        r11.get();
        r11 = cn.jiguang.d.h.e.d();
        r11 = r11.a();
        r12 = cn.jiguang.d.h.e.d();
        r12 = r12.a;
        r13 = cn.jiguang.d.h.e.d();
        r13 = r13.b();
        r14 = cn.jiguang.d.h.e.d();
        r14 = r14.c();
        r15 = cn.jiguang.d.d.f.a();
        r4 = r15.c();
        r15 = cn.jiguang.d.a.d.m(r2);
        r17 = r11;
        r10 = cn.jiguang.d.a.a.f();
        r6 = new java.util.Random;
        r6.<init>();
        r6 = r6.nextInt();
        r6 = java.lang.Math.abs(r6);
        cn.jiguang.d.h.a.a.a(r6);
        r8 = new cn.jiguang.api.utils.OutputDataUtil;
        r8.<init>(r7);
        r8.writeU16(r3);
        r9 = 19;
        r8.writeU8(r9);
        r8.writeU8(r3);
        r8.writeU64(r10);
        r9 = (long) r6;
        r8.writeU32(r9);
        r9 = 0;
        r8.writeU64(r9);
        r6 = r17;
        r6 = r6.getBytes();
        r8.writeByteArrayincludeLength(r6);
        r6 = r12.getBytes();
        r8.writeByteArrayincludeLength(r6);
        r6 = r13.getBytes();
        r8.writeByteArrayincludeLength(r6);
        r8.writeU8(r3);
        r6 = r14.getBytes();
        r8.writeByteArrayincludeLength(r6);
        r6 = cn.jiguang.d.d.f.a();
        r6.d();
        r8.writeU32(r4);
        r4 = r15.getBytes();
        r8.writeByteArrayincludeLength(r4);
        r4 = r8.current();
        r8.writeU16At(r4, r3);
        r4 = r8.toByteArray();
        r4 = cn.jiguang.d.e.a.a.b.a(r4, r3);
        if (r4 != 0) goto L_0x00d3;
        r2 = r3;
        goto L_0x01a2;
        r5 = cn.jiguang.d.g.c.a();
        r5 = r5.b();
        r4 = r5.a(r4);
        if (r4 == 0) goto L_0x00e2;
        goto L_0x00d0;
        r4 = cn.jiguang.d.g.c.a();
        r4 = r4.b();
        r5 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r4 = r4.a(r5);
        r5 = r4.a();
        if (r5 == 0) goto L_0x011a;
        r2 = "ConnectingHelper";
        r5 = new java.lang.StringBuilder;
        r6 = "Register failed - recv msg failed with error code:";
        r5.<init>(r6);
        r6 = r4.a();
        r5.append(r6);
        r6 = ",msg:";
        r5.append(r6);
        r4 = r4.c();
        r5.append(r4);
        r4 = r5.toString();
        cn.jiguang.e.c.c(r2, r4);
        goto L_0x00d0;
        r4 = r4.b();
        r4 = r4.array();
        r4 = cn.jiguang.d.e.a.a.a.a(r4);
        if (r4 != 0) goto L_0x0129;
        goto L_0x00d0;
        r5 = r4.getCommand();
        if (r5 == 0) goto L_0x0130;
        goto L_0x00d0;
        r4 = (cn.jiguang.d.e.a.f) r4;
        r5 = r4.code;
        cn.jiguang.d.a.a.a(r2, r5);
        r6 = cn.jiguang.d.b.d.a();
        r6.b(r5);
        if (r5 != 0) goto L_0x019c;
        r12 = r4.getJuid();
        r14 = r4.a();
        r5 = r4.b();
        r4 = r4.c();
        r6 = "ConnectingHelper";
        r8 = new java.lang.StringBuilder;
        r9 = "Register succeed - juid:";
        r8.<init>(r9);
        r8.append(r12);
        r9 = ", registrationId:";
        r8.append(r9);
        r8.append(r5);
        r9 = ", deviceId:";
        r8.append(r9);
        r8.append(r4);
        r8 = r8.toString();
        cn.jiguang.e.c.b(r6, r8);
        r6 = cn.jiguang.g.i.a(r5);
        if (r6 != 0) goto L_0x0193;
        r8 = 0;
        r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r6 != 0) goto L_0x0180;
        goto L_0x0193;
        cn.jiguang.g.a.f(r2, r4);
        r11 = r2;
        r15 = r5;
        r16 = r4;
        cn.jiguang.d.a.d.a(r11, r12, r14, r15, r16);
        r4 = "cn.jpush.android.intent.REGISTRATION";
        r6 = "cn.jpush.android.REGISTRATION_ID";
        cn.jiguang.g.a.a(r2, r4, r6, r5);
        r2 = 1;
        goto L_0x01a2;
        r2 = "ConnectingHelper";
        r4 = "Unexpected: registrationId/juid should not be empty. ";
        cn.jiguang.e.c.d(r2, r4);
        goto L_0x00d0;
        r4 = 1;
        cn.jiguang.d.d.d.a(r2, r5, r4);
        goto L_0x00d0;
        if (r2 != 0) goto L_0x01b8;
        r2 = cn.jiguang.d.a.a.j();
        if (r2 == 0) goto L_0x01b3;
        r2 = r0.d;
        r4 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r5 = 100;
        r2.sendEmptyMessageDelayed(r4, r5);
        r33.f();
        r2 = r3;
        goto L_0x01dc;
        r2 = r0.c;
        r4 = cn.jiguang.d.h.e.d();
        cn.jiguang.a.a.c.b.b(r2, r4);
        r2 = cn.jiguang.d.a.a.j();
        if (r2 == 0) goto L_0x01ca;
        cn.jiguang.d.a.a.h();
        r2 = r0.c;
        r4 = cn.jiguang.d.a.d.c(r2);
        r2 = cn.jiguang.d.i.f.a();
        r2 = r2.b();
        r2.b(r4);
        r2 = 1;
        if (r2 != 0) goto L_0x01df;
        return r3;
        r2 = r0.c;
        r4 = a;
        r4.get();
        r4 = cn.jiguang.d.a.d.c(r2);
        r6 = cn.jiguang.d.a.d.e(r2);
        r6 = cn.jiguang.g.i.b(r6);
        if (r6 != 0) goto L_0x01f6;
        r6 = "";
        r8 = cn.jiguang.d.a.b(r2);
        cn.jiguang.d.d.b.a();
        r9 = cn.jiguang.api.SdkType.JCORE;
        r9 = r9.name();
        r10 = "";
        r9 = cn.jiguang.d.d.b.d(r9, r10);
        r10 = android.text.TextUtils.isEmpty(r9);
        if (r10 != 0) goto L_0x0214;
        r9 = cn.jiguang.g.a.d(r9);
        goto L_0x0215;
        r9 = r3;
        cn.jiguang.d.d.b.a();
        r10 = cn.jiguang.api.SdkType.JANALYTICS;
        r10 = r10.name();
        r11 = "";
        r10 = cn.jiguang.d.d.b.d(r10, r11);
        r11 = android.text.TextUtils.isEmpty(r10);
        if (r11 != 0) goto L_0x022f;
        r10 = cn.jiguang.g.a.d(r10);
        goto L_0x0230;
        r10 = r3;
        cn.jiguang.d.d.b.a();
        r11 = cn.jiguang.api.SdkType.JSHARE;
        r11 = r11.name();
        r12 = "";
        r11 = cn.jiguang.d.d.b.d(r11, r12);
        r12 = android.text.TextUtils.isEmpty(r11);
        if (r12 != 0) goto L_0x024a;
        r11 = cn.jiguang.g.a.d(r11);
        goto L_0x024b;
        r11 = r3;
        cn.jiguang.d.d.b.a();
        r12 = cn.jiguang.api.SdkType.JPUSH;
        r12 = r12.name();
        r13 = "";
        r12 = cn.jiguang.d.d.b.d(r12, r13);
        r13 = android.text.TextUtils.isEmpty(r12);
        if (r13 != 0) goto L_0x0265;
        r12 = cn.jiguang.g.a.d(r12);
        goto L_0x0266;
        r12 = r3;
        cn.jiguang.d.d.b.a();
        r13 = cn.jiguang.api.SdkType.JSSP;
        r13 = r13.name();
        r14 = "";
        r13 = cn.jiguang.d.d.b.d(r13, r14);
        r14 = android.text.TextUtils.isEmpty(r13);
        if (r14 != 0) goto L_0x0280;
        r13 = cn.jiguang.g.a.d(r13);
        goto L_0x0281;
        r13 = r3;
        cn.jiguang.d.d.b.a();
        r14 = cn.jiguang.api.SdkType.JVERIFICATION;
        r14 = r14.name();
        r15 = "";
        r14 = cn.jiguang.d.d.b.d(r14, r15);
        r15 = android.text.TextUtils.isEmpty(r14);
        if (r15 != 0) goto L_0x029b;
        r14 = cn.jiguang.g.a.d(r14);
        goto L_0x029c;
        r14 = r3;
        cn.jiguang.d.h.e.d();
        r15 = cn.jiguang.d.h.e.c(r2);
        r7 = "ConnectingHelper";
        r3 = new java.lang.StringBuilder;
        r18 = r1;
        r1 = "Login with - juid:";
        r3.<init>(r1);
        r3.append(r4);
        r1 = ", appKey:";
        r3.append(r1);
        r3.append(r8);
        r1 = ", sdkVersion:";
        r3.append(r1);
        r3.append(r9);
        r1 = ", pushVersion:";
        r3.append(r1);
        r3.append(r12);
        r1 = ", analyticsVersion:";
        r3.append(r1);
        r3.append(r10);
        r1 = " ,shareVersion:";
        r3.append(r1);
        r3.append(r11);
        r1 = ",sspSdkVer:";
        r3.append(r1);
        r3.append(r13);
        r1 = ",verificationSdkVer:";
        r3.append(r1);
        r3.append(r14);
        r1 = ", pluginPlatformType:";
        r3.append(r1);
        r3.append(r15);
        r1 = r3.toString();
        cn.jiguang.e.c.b(r7, r1);
        r1 = cn.jiguang.d.d.f.a();
        r0 = r1.d();
        r3 = cn.jiguang.g.k.a(r2);
        r7 = cn.jiguang.g.a.i(r2);
        r19 = r7;
        r7 = cn.jiguang.a.a.b.f.a(r2);
        if (r7 == 0) goto L_0x0317;
        r7 = r7.e();
        r20 = r7;
        goto L_0x031a;
        r7 = "";
        goto L_0x0314;
        r7 = cn.jiguang.c.c.a(r2);
        r21 = r3;
        r3 = java.util.Locale.ENGLISH;
        r23 = r0;
        r22 = r15;
        r15 = 0;
        r0 = new java.lang.Object[r15];
        r0 = java.lang.String.format(r3, r7, r0);
        r0 = cn.jiguang.g.i.c(r0);
        if (r0 != 0) goto L_0x0336;
        r0 = "";
        goto L_0x033a;
        r0 = r0.toUpperCase();
        r1 = cn.jiguang.d.a.d.m(r2);
        r25 = r2;
        r2 = cn.jiguang.d.a.a.f();
        r26 = r0;
        r27 = r1;
        r0 = (long) r9;
        r28 = r8;
        r7 = (long) r12;
        r9 = (long) r10;
        r11 = (long) r11;
        r29 = r0;
        r0 = (long) r13;
        r13 = (long) r14;
        r15 = new cn.jiguang.api.utils.OutputDataUtil;
        r31 = r13;
        r13 = 20480; // 0x5000 float:2.8699E-41 double:1.01185E-319;
        r15.<init>(r13);
        r13 = 0;
        r15.writeU16(r13);
        r14 = 22;
        r15.writeU8(r14);
        r14 = 1;
        r15.writeU8(r14);
        r15.writeU64(r2);
        r2 = 0;
        r15.writeU32(r2);
        r15.writeU64(r4);
        r2 = 97;
        r15.writeU8(r2);
        r15.writeU8(r13);
        r15.writeU16(r13);
        r2 = r6.getBytes();
        r15.writeByteArrayincludeLength(r2);
        r15.writeU32(r7);
        r15.writeU32(r9);
        r15.writeU32(r11);
        r2 = r29;
        r15.writeU32(r2);
        r15.writeU32(r0);
        r0 = r31;
        r15.writeU32(r0);
        r0 = r28;
        r0 = r0.getBytes();
        r15.writeByteArrayincludeLength(r0);
        r15.writeU8(r13);
        r0 = r23;
        r15.writeU32(r0);
        r0 = r22;
        r15.writeU8(r0);
        r0 = r21;
        r15.writeU8(r0);
        r0 = r19;
        r0 = r0.getBytes();
        r15.writeByteArrayincludeLength(r0);
        r7 = r20;
        r0 = r7.getBytes();
        r15.writeByteArrayincludeLength(r0);
        r0 = r26;
        r0 = r0.getBytes();
        r15.writeByteArrayincludeLength(r0);
        r0 = r27;
        r0 = r0.getBytes();
        r15.writeByteArrayincludeLength(r0);
        r0 = r15.current();
        r1 = 0;
        r15.writeU16At(r0, r1);
        r0 = r15.toByteArray();
        r1 = 1;
        r0 = cn.jiguang.d.e.a.a.b.a(r0, r1);
        r1 = -1;
        if (r0 == 0) goto L_0x04c1;
        r2 = r0.length;
        if (r2 > 0) goto L_0x03f3;
        goto L_0x04c1;
        r2 = cn.jiguang.d.g.c.a();
        r2 = r2.b();
        r0 = r2.a(r0);
        if (r0 == 0) goto L_0x0403;
        goto L_0x04c1;
        r0 = cn.jiguang.d.g.c.a();
        r0 = r0.b();
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = r0.a(r2);
        r2 = r0.a();
        if (r2 == 0) goto L_0x043c;
        r2 = "ConnectingHelper";
        r3 = new java.lang.StringBuilder;
        r4 = "Login failed - recv msg failed wit error code:";
        r3.<init>(r4);
        r4 = r0.a();
        r3.append(r4);
        r4 = ",msg:";
        r3.append(r4);
        r0 = r0.c();
        r3.append(r0);
        r0 = r3.toString();
        cn.jiguang.e.c.c(r2, r0);
        goto L_0x04c1;
        r0 = r0.b();
        r0 = r0.array();
        r0 = cn.jiguang.d.e.a.a.a.a(r0);
        if (r0 != 0) goto L_0x0452;
        r0 = "ConnectingHelper";
        r2 = "Login failed - unknown command";
        cn.jiguang.e.c.c(r0, r2);
        goto L_0x04c1;
        r2 = r0 instanceof cn.jiguang.d.e.a.e;
        if (r2 != 0) goto L_0x045b;
        r0 = "ConnectingHelper";
        r2 = "Login failed - it is not LoginResponse";
        goto L_0x044e;
        r0 = (cn.jiguang.d.e.a.e) r0;
        r1 = r0.code;
        r2 = cn.jiguang.d.b.d.a();
        r2.a(r1);
        if (r1 != 0) goto L_0x049b;
        r2 = r0.getSid();
        r0 = r0.a();
        r3 = (long) r0;
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r3 * r5;
        r0 = r25;
        cn.jiguang.d.a.d.a(r0, r2);
        cn.jiguang.d.a.a.b(r3);
        r5 = "ConnectingHelper";
        r6 = new java.lang.StringBuilder;
        r7 = "Login succeed - sid:";
        r6.<init>(r7);
        r6.append(r2);
        r2 = ", serverTime;";
        r6.append(r2);
        r6.append(r3);
        r2 = r6.toString();
        cn.jiguang.e.c.b(r5, r2);
        cn.jiguang.d.d.d.a(r0, r3);
        goto L_0x04c1;
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        if (r1 != r0) goto L_0x04b0;
        r0 = "ConnectingHelper";
        r2 = new java.lang.StringBuilder;
        r3 = "Login failed with Local error - code:";
        r2.<init>(r3);
        r2.append(r1);
        r2 = r2.toString();
        goto L_0x044e;
        r0 = "ConnectingHelper";
        r2 = new java.lang.StringBuilder;
        r3 = "Login failed with server error - code:";
        r2.<init>(r3);
        r3 = cn.jiguang.g.h.a(r1);
        r2.append(r3);
        goto L_0x04ab;
        if (r1 >= 0) goto L_0x04c5;
        r0 = 0;
        return r0;
        if (r1 <= 0) goto L_0x0502;
        r0 = a;
        r2 = r0.get();
        r0 = r33;
        r4 = r0.d;
        r5 = 7306; // 0x1c8a float:1.0238E-41 double:3.6096E-320;
        r4 = android.os.Message.obtain(r4, r5);
        cn.jiguang.d.d.d.a(r4, r2);
        r2 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        if (r1 != r2) goto L_0x04e7;
        r1 = r0.c;
        cn.jiguang.g.a.n(r1);
        r1 = r18 + -1;
        goto L_0x0004;
        r2 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r1 != r2) goto L_0x04f9;
        cn.jiguang.d.a.a.i();
        r1 = r0.d;
        r2 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
        r3 = 100;
        r1.sendEmptyMessageDelayed(r2, r3);
        r1 = 0;
        return r1;
        r2 = 1012; // 0x3f4 float:1.418E-42 double:5.0E-321;
        if (r1 != r2) goto L_0x04f7;
        cn.jiguang.d.a.a.a();
        goto L_0x04f7;
        return r1;
        r0 = r33;
        r1 = a;
        r1 = r1.get();
        r3 = 0;
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 == 0) goto L_0x0538;
        r1 = a;
        r1 = r1.get();
        r3 = r0.d;
        r4 = 7304; // 0x1c88 float:1.0235E-41 double:3.6087E-320;
        r3 = android.os.Message.obtain(r3, r4);
        cn.jiguang.d.d.d.a(r3, r1);
        r1 = cn.jiguang.d.d.f.a();
        r2 = r0.c;
        r1 = r1.b(r2);
        if (r1 != 0) goto L_0x0536;
        r1 = "NetworkingClient";
        r2 = "need not keep tcp connect,will close connection";
        cn.jiguang.e.c.a(r1, r2);
        r1 = 0;
        return r1;
        r1 = 1;
        return r1;
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.g.a(int):boolean");
    }

    private boolean a(Context context) {
        e.d().a(context);
        try {
            a.set(Thread.currentThread().getId());
            f fVar = new f(context, this, a.get());
            if (fVar.b() != 0) {
                fVar.a();
                f();
                return false;
            } else if (a(2)) {
                fVar.a();
                return true;
            } else {
                fVar.a();
                f();
                return false;
            }
        } catch (UnsatisfiedLinkError e) {
            c.b("NetworkingClient", "长连接失败, jpush.so加载异常", e);
            return false;
        }
    }

    private void f() {
        StringBuilder stringBuilder = new StringBuilder("Action - closeConnection - connection:");
        stringBuilder.append(a.get());
        c.a("NetworkingClient", stringBuilder.toString());
        if (0 != a.get()) {
            try {
                b.set(true);
                a.set(0);
                cn.jiguang.d.g.c.a().b().a();
                b.set(false);
            } catch (Exception unused) {
            }
            this.f = false;
            if (cn.jiguang.d.d.f.a().f()) {
                d.a(Message.obtain(this.d, 7301), a.get());
            } else if (cn.jiguang.d.d.f.a().g() && JCoreInterface.getUid() == 0) {
                d.a(Message.obtain(this.d, 7301), a.get());
            }
        }
    }

    public final void a() {
        StringBuilder stringBuilder = new StringBuilder("Action - tryStop - connection:");
        stringBuilder.append(a.get());
        c.a("NetworkingClient", stringBuilder.toString());
        this.e = true;
        this.f = false;
        if (a.get() != 0) {
            cn.jiguang.d.g.c.a().b().a();
        }
    }

    public final synchronized void b() {
        if (this.f) {
            this.g = Executors.newSingleThreadExecutor();
            try {
                this.g.execute(this);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("execute networkingClient exception :");
                stringBuilder.append(th);
                c.c("NetworkingClient", stringBuilder.toString());
                a();
            }
        }
    }

    public final synchronized void c() {
        a();
        t.a(this.g);
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.f;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("Begin to run in ConnectingThread - id:");
        stringBuilder.append(Thread.currentThread().getId());
        c.b("NetworkingClient", stringBuilder.toString());
        try {
            if (a(this.c)) {
                while (!this.e) {
                    c.a("NetworkingClient", "Network listening...");
                    cn.jiguang.d.g.d a = cn.jiguang.d.g.c.a().b().a(0);
                    StringBuilder stringBuilder2;
                    if (a == null) {
                        break;
                    } else if (a.a() != 0) {
                        stringBuilder2 = new StringBuilder(" recv failed with error code:");
                        stringBuilder2.append(a.a());
                        stringBuilder2.append(",msg:");
                        stringBuilder2.append(a.c());
                        stringBuilder2.append(",No Break!!");
                        c.a("NetworkingClient", stringBuilder2.toString());
                        break;
                    } else {
                        ByteBuffer b = a.b();
                        int length = b.array().length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(b.array(), 0, bArr, 0, length);
                        a.a(this.c, bArr);
                        stringBuilder2 = new StringBuilder("Received bytes - len:");
                        stringBuilder2.append(b.array().length);
                        stringBuilder2.append(", connection:");
                        stringBuilder2.append(a.get());
                        stringBuilder2.append(", pkg:");
                        stringBuilder2.append(cn.jiguang.d.a.c);
                        c.a("NetworkingClient", stringBuilder2.toString());
                        if (0 == a.get()) {
                            c.c("NetworkingClient", "mConnection is reset to 0 when network listening. Break now.");
                            return;
                        }
                    }
                }
                if (this.e) {
                    stringBuilder = new StringBuilder("Break receiving by wantStop - connection:");
                    stringBuilder.append(a.get());
                    c.a("NetworkingClient", stringBuilder.toString());
                }
                f();
                return;
            }
            c.a("NetworkingClient", "prepare Push Channel failed , returned");
        } catch (Throwable th) {
            c.c("NetworkingClient", "run exception", th);
        }
    }
}
