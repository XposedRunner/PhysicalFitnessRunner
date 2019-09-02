package com.baidu.mapsdkvi;

public class c {
    public String a;
    public int b;
    public int c;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:7:0x0026 in {2, 4, 5, 6} preds:[]
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
    public c(android.net.NetworkInfo r2) {
        /*
        r1 = this;
        r1.<init>();
        r0 = r2.getTypeName();
        r1.a = r0;
        r0 = r2.getType();
        r1.b = r0;
        r0 = com.baidu.mapsdkvi.d.a;
        r2 = r2.getState();
        r2 = r2.ordinal();
        r2 = r0[r2];
        switch(r2) {
            case 1: goto L_0x0024;
            case 2: goto L_0x0022;
            default: goto L_0x001e;
        };
        r2 = 0;
        r1.c = r2;
        return;
        r2 = 1;
        goto L_0x001f;
        r2 = 2;
        goto L_0x001f;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkvi.c.<init>(android.net.NetworkInfo):void");
    }
}
