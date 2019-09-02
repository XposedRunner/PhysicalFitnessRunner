package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: FileToStreamDecoder */
/* renamed from: o0O00Oo0 */
public class o0O00Oo0<T> implements O0O0o00<File, T> {
    private static final O000000o O000000o = new O000000o();
    private O0O0o00<InputStream, T> O00000Oo;
    private final O000000o O00000o0;

    /* compiled from: FileToStreamDecoder */
    /* renamed from: o0O00Oo0$O000000o */
    static class O000000o {
        O000000o() {
        }

        public InputStream O000000o(File file) throws FileNotFoundException {
            return null;
        }
    }

    public o0O00Oo0(O0O0o00<InputStream, T> o0O0o00) {
    }

    o0O00Oo0(O0O0o00<InputStream, T> o0O0o00, O000000o o000000o) {
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
    public defpackage.Oo0OOo<T> O000000o(java.io.File r3, int r4, int r5) throws java.io.IOException {
        /*
        r2 = this;
        r0 = 0;
        return r0;	 Catch:{ all -> 0x0015 }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o0O00Oo0.O000000o(java.io.File, int, int):Oo0OOo");
    }

    public String O000000o() {
        return null;
    }
}
