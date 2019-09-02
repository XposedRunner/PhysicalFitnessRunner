package defpackage;

import android.os.Handler;
import android.os.Message;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.zxing.activity.CaptureActivity;
import java.util.Hashtable;

/* compiled from: DecodeHandler */
/* renamed from: mi */
final class mi extends Handler {
    private static final String O000000o = "mi";
    private final CaptureActivity O00000Oo;
    private final MultiFormatReader O00000o0;

    mi(CaptureActivity captureActivity, Hashtable<DecodeHintType, Object> hashtable) {
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
    private void O000000o(byte[] r9, int r10, int r11) {
        /*
        r8 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mi.O000000o(byte[], int, int):void");
    }

    public void handleMessage(Message message) {
    }
}
