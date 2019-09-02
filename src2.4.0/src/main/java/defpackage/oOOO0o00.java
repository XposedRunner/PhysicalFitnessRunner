package defpackage;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Queue;

/* compiled from: Manager */
/* renamed from: oOOO0o00 */
public class oOOO0o00 extends Handler {
    private static oOOO0o00 O000000o;
    private final Queue<oOOOOO0O> O00000Oo;
    private boolean O00000o0;

    /* compiled from: Manager */
    /* renamed from: oOOO0o00$1 */
    class 1 implements OnGlobalLayoutListener {
        final /* synthetic */ View O000000o;
        final /* synthetic */ oOOOOO0O O00000Oo;
        final /* synthetic */ oOOO0o00 O00000o0;

        1(oOOO0o00 oooo0o00, View view, oOOOOO0O oooooo0o) {
        }

        @TargetApi(16)
        public void onGlobalLayout() {
        }
    }

    /* compiled from: Manager */
    /* renamed from: oOOO0o00$O000000o */
    private static final class O000000o {
        public static final int O000000o = 538183699;
        public static final int O00000Oo = 538183700;
        public static final int O00000o = 538183702;
        public static final int O00000o0 = 538183701;

        private O000000o() {
        }
    }

    private oOOO0o00() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0002
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
    public static synchronized defpackage.oOOO0o00 O000000o() {
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oOOO0o00.O000000o():oOOO0o00");
    }

    static /* synthetic */ void O000000o(oOOO0o00 oooo0o00, oOOOOO0O oooooo0o, int i, long j) {
    }

    private void O000000o(oOOOOO0O oooooo0o, int i) {
    }

    private void O000000o(oOOOOO0O oooooo0o, int i, long j) {
    }

    private void O000000o(boolean z) {
    }

    private long O00000o(oOOOOO0O oooooo0o) {
        return 0;
    }

    private void O00000oO(oOOOOO0O oooooo0o) {
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(oOOOOO0O oooooo0o) {
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(oOOOOO0O oooooo0o, boolean z) {
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo() {
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(oOOOOO0O oooooo0o) {
    }

    /* Access modifiers changed, original: protected */
    public void O00000o0(oOOOOO0O oooooo0o) {
    }

    public void handleMessage(Message message) {
    }
}
