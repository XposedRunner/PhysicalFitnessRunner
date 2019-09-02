package zhy.com.highlight.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.List;
import zhy.com.highlight.O00000Oo;
import zhy.com.highlight.O00000Oo.O0000O0o;

public class HighLightView extends FrameLayout {
    private static final int O000000o = 15;
    private static final int O00000Oo = 6;
    private static final PorterDuffXfermode O00000o0 = new PorterDuffXfermode(Mode.DST_OUT);
    private Bitmap O00000o;
    private Bitmap O00000oO;
    private Paint O00000oo;
    private List<O0000O0o> O0000O0o;
    private O00000Oo O0000OOo;
    private int O0000Oo;
    private LayoutInflater O0000Oo0;
    private final boolean O0000OoO;
    private int O0000Ooo;
    private O0000O0o O0000o00;

    public HighLightView(Context context, O00000Oo o00000Oo, int i, List<O0000O0o> list, boolean z) {
    }

    private LayoutParams O000000o(View view, O0000O0o o0000O0o) {
        return null;
    }

    private void O000000o(Bitmap bitmap) {
    }

    private void O000000o(O0000O0o o0000O0o) {
    }

    private void O00000Oo(O0000O0o o0000O0o) {
    }

    private void O00000o() {
    }

    private void O00000o0() {
    }

    private void O00000oO() {
    }

    private void O00000oo() {
    }

    public void O000000o() {
    }

    public boolean O00000Oo() {
        return false;
    }

    public O0000O0o getCurentViewPosInfo() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0001
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
    protected void onDraw(android.graphics.Canvas r4) {
        /*
        r3 = this;
        return;	 Catch:{ Exception -> 0x0008 }
        */
        throw new UnsupportedOperationException("Method not decompiled: zhy.com.highlight.view.HighLightView.onDraw(android.graphics.Canvas):void");
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
    }
}
