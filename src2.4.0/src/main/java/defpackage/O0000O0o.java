package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;

/* compiled from: CharacterDecoder */
/* renamed from: O0000O0o */
public abstract class O0000O0o {
    public abstract int O000000o();

    /* Access modifiers changed, original: protected */
    public int O000000o(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        return 0;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
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
    public void O000000o(java.io.InputStream r4, java.io.OutputStream r5) throws java.io.IOException {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.O0000O0o.O000000o(java.io.InputStream, java.io.OutputStream):void");
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i) throws IOException {
    }

    public byte[] O000000o(InputStream inputStream) throws IOException {
        return null;
    }

    public byte[] O000000o(String str) throws IOException {
        return null;
    }

    public abstract int O00000Oo();

    public ByteBuffer O00000Oo(InputStream inputStream) throws IOException {
        return null;
    }

    public ByteBuffer O00000Oo(String str) throws IOException {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    /* Access modifiers changed, original: protected */
    public void O00000o(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    /* Access modifiers changed, original: protected */
    public int O00000o0(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
        return 0;
    }
}
