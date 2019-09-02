package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher */
/* renamed from: OO0oO */
public abstract class OO0oO<T> implements O0Oo0o0<T> {
    private static final String O000000o = "LocalUriFetcher";
    private final Uri O00000Oo;
    private T O00000o;
    private final Context O00000o0;

    public OO0oO(Context context, Uri uri) {
    }

    public final T O000000o(O00o0000 o00o0000) throws Exception {
        return null;
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
    public void O000000o() {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.OO0oO.O000000o():void");
    }

    public abstract void O000000o(T t) throws IOException;

    public abstract T O00000Oo(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public String O00000Oo() {
        return null;
    }

    public void O00000o0() {
    }
}
