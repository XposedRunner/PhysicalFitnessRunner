package defpackage;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ApplicationVersionSignature */
/* renamed from: oO0o0000 */
public final class oO0o0000 {
    private static final ConcurrentHashMap<String, O0O0OO> O000000o = new ConcurrentHashMap();

    private oO0o0000() {
    }

    public static O0O0OO O000000o(Context context) {
        return null;
    }

    static void O000000o() {
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private static defpackage.O0O0OO O00000Oo(android.content.Context r2) {
        /*
        r0 = 0;	 Catch:{ NameNotFoundException -> 0x000e }
        return r0;	 Catch:{ NameNotFoundException -> 0x000e }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oO0o0000.O00000Oo(android.content.Context):O0O0OO");
    }
}
