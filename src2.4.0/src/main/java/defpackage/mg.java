package defpackage;

import android.os.Handler;
import android.os.Message;
import com.google.zxing.BarcodeFormat;
import com.zxing.activity.CaptureActivity;
import java.util.Vector;

/* compiled from: CaptureActivityHandler */
/* renamed from: mg */
public final class mg extends Handler {
    private static final String O000000o = "mg";
    private final CaptureActivity O00000Oo;
    private O000000o O00000o;
    private final mj O00000o0;

    /* compiled from: CaptureActivityHandler */
    /* renamed from: mg$O000000o */
    private enum O000000o {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public mg(CaptureActivity captureActivity, Vector<BarcodeFormat> vector, String str) {
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void O000000o() {
        /*
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mg.O000000o():void");
    }

    public void O00000Oo() {
    }

    public void handleMessage(Message message) {
    }
}
