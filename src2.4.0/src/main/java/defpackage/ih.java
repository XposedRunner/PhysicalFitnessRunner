package defpackage;

import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: CrashHandler */
/* renamed from: ih */
public class ih implements UncaughtExceptionHandler {
    public static final String O000000o = "ih";
    private static ih O00000o0 = new ih();
    private boolean O00000Oo;
    private UncaughtExceptionHandler O00000o;

    private ih() {
    }

    public static ih O000000o() {
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:3:0x0002
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private java.lang.String O000000o(java.lang.Exception r4) {
        /*
        r3 = this;
        r0 = 0;	 Catch:{ Exception -> 0x002e }
        return r0;	 Catch:{ Exception -> 0x002e }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ih.O000000o(java.lang.Exception):java.lang.String");
    }

    public void O00000Oo() {
    }

    public void uncaughtException(Thread thread, Throwable th) {
    }
}
