package defpackage;

import android.os.Handler;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.zxing.activity.CaptureActivity;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* compiled from: DecodeThread */
/* renamed from: mj */
final class mj extends Thread {
    public static final String O000000o = "barcode_bitmap";
    private final CaptureActivity O00000Oo;
    private Handler O00000o;
    private final Hashtable<DecodeHintType, Object> O00000o0;
    private final CountDownLatch O00000oO;

    mj(CaptureActivity captureActivity, Vector<BarcodeFormat> vector, String str, ResultPointCallback resultPointCallback) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:3:0x0002 in {2, 4} preds:[]
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
    android.os.Handler O000000o() {
        /*
        r1 = this;
        r0 = 0;	 Catch:{ InterruptedException -> 0x0005 }
        return r0;	 Catch:{ InterruptedException -> 0x0005 }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mj.O000000o():android.os.Handler");
    }

    public void run() {
    }
}
