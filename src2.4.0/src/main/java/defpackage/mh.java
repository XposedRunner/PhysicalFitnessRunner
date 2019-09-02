package defpackage;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import java.util.Vector;
import java.util.regex.Pattern;

/* compiled from: DecodeFormatManager */
/* renamed from: mh */
final class mh {
    static final Vector<BarcodeFormat> O000000o = new Vector(5);
    static final Vector<BarcodeFormat> O00000Oo = new Vector(O000000o.size() + 4);
    static final Vector<BarcodeFormat> O00000o = new Vector(1);
    static final Vector<BarcodeFormat> O00000o0 = new Vector(1);
    private static final Pattern O00000oO = Pattern.compile(",");

    static {
        O000000o.add(BarcodeFormat.UPC_A);
        O000000o.add(BarcodeFormat.UPC_E);
        O000000o.add(BarcodeFormat.EAN_13);
        O000000o.add(BarcodeFormat.EAN_8);
        O000000o.add(BarcodeFormat.RSS_14);
        O00000Oo.addAll(O000000o);
        O00000Oo.add(BarcodeFormat.CODE_39);
        O00000Oo.add(BarcodeFormat.CODE_93);
        O00000Oo.add(BarcodeFormat.CODE_128);
        O00000Oo.add(BarcodeFormat.ITF);
        O00000o0.add(BarcodeFormat.QR_CODE);
        O00000o.add(BarcodeFormat.DATA_MATRIX);
    }

    private mh() {
    }

    static Vector<BarcodeFormat> O000000o(Intent intent) {
        return null;
    }

    static Vector<BarcodeFormat> O000000o(Uri uri) {
        return null;
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
    private static java.util.Vector<com.google.zxing.BarcodeFormat> O000000o(java.lang.Iterable<java.lang.String> r2, java.lang.String r3) {
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mh.O000000o(java.lang.Iterable, java.lang.String):java.util.Vector");
    }
}
