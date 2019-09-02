package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;

/* compiled from: MapLocationManagerActionHandler */
public final class ay extends Handler {
    ax O000000o = null;

    public ay(Looper looper, ax axVar) {
        super(looper);
        this.O000000o = axVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:41:0x006c in {2, 5, 8, 11, 13, 15, 18, 20, 23, 25, 28, 30, 33, 35, 38, 40} preds:[]
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
    public final void handleMessage(android.os.Message r3) {
        /*
        r2 = this;
        r0 = r3.what;
        switch(r0) {
            case 1001: goto L_0x005c;
            case 1002: goto L_0x004c;
            case 1003: goto L_0x003c;
            case 1004: goto L_0x0030;
            case 1005: goto L_0x0024;
            case 1006: goto L_0x0015;
            case 1007: goto L_0x0006;
            default: goto L_0x0005;
        };
        return;
        r3 = r2.O000000o;	 Catch:{ Throwable -> 0x000c }
        r3.O00000o();	 Catch:{ Throwable -> 0x000c }
        return;
        r3 = move-exception;
        r0 = "ClientActionHandler";
        r1 = "ACTION_DESTROY";
        com.amap.api.mapcore.util.bp.O000000o(r3, r0, r1);
        return;
        r3 = r2.O000000o;	 Catch:{ Throwable -> 0x001b }
        r3.O00000o0();	 Catch:{ Throwable -> 0x001b }
        return;
        r3 = move-exception;
        r0 = "ClientActionHandler";
        r1 = "ACTION_STOP_LOCATION";
        com.amap.api.mapcore.util.bp.O000000o(r3, r0, r1);
        return;
        r3 = r2.O000000o;	 Catch:{ Throwable -> 0x002a }
        r3.O00000Oo();	 Catch:{ Throwable -> 0x002a }
        return;
        r3 = move-exception;
        r0 = "ClientActionHandler";
        r1 = "ACTION_GET_LOCATION";
        goto L_0x0020;
        r3 = r2.O000000o;	 Catch:{ Throwable -> 0x0036 }
        r3.O000000o();	 Catch:{ Throwable -> 0x0036 }
        return;
        r3 = move-exception;
        r0 = "ClientActionHandler";
        r1 = "ACTION_START_LOCATION";
        goto L_0x0020;
        r3 = r3.obj;	 Catch:{ Throwable -> 0x0046 }
        r3 = (com.autonavi.amap.mapcore.Inner_3dMap_locationListener) r3;	 Catch:{ Throwable -> 0x0046 }
        r0 = r2.O000000o;	 Catch:{ Throwable -> 0x0046 }
        r0.O00000Oo(r3);	 Catch:{ Throwable -> 0x0046 }
        return;
        r3 = move-exception;
        r0 = "ClientActionHandler";
        r1 = "ACTION_REMOVE_LISTENER";
        goto L_0x0020;
        r3 = r3.obj;	 Catch:{ Throwable -> 0x0056 }
        r3 = (com.autonavi.amap.mapcore.Inner_3dMap_locationListener) r3;	 Catch:{ Throwable -> 0x0056 }
        r0 = r2.O000000o;	 Catch:{ Throwable -> 0x0056 }
        r0.O000000o(r3);	 Catch:{ Throwable -> 0x0056 }
        return;
        r3 = move-exception;
        r0 = "ClientActionHandler";
        r1 = "ACTION_SET_LISTENER";
        goto L_0x0020;
        r3 = r3.obj;	 Catch:{ Throwable -> 0x0066 }
        r3 = (com.autonavi.amap.mapcore.Inner_3dMap_locationOption) r3;	 Catch:{ Throwable -> 0x0066 }
        r0 = r2.O000000o;	 Catch:{ Throwable -> 0x0066 }
        r0.O000000o(r3);	 Catch:{ Throwable -> 0x0066 }
        return;
        r3 = move-exception;
        r0 = "ClientActionHandler";
        r1 = "ACTION_SET_OPTION";
        goto L_0x0020;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ay.handleMessage(android.os.Message):void");
    }
}
