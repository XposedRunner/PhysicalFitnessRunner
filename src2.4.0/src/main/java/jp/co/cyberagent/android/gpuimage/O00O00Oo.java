package jp.co.cyberagent.android.gpuimage;

import android.graphics.PointF;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.util.LinkedList;

/* compiled from: GPUImageFilter */
public class O00O00Oo {
    public static final String O0000Oo = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    public static final String O0000Oo0 = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
    private final LinkedList<Runnable> O000000o;
    private final String O00000Oo;
    private boolean O00000o;
    private final String O00000o0;
    protected int O0000OoO;
    protected int O0000Ooo;
    protected int O0000o0;
    protected int O0000o00;
    protected int O0000o0O;
    protected int O0000o0o;

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass1(O00O00Oo o00O00Oo, int i, int i2) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ float O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass2(O00O00Oo o00O00Oo, int i, float f) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ float[] O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass3(O00O00Oo o00O00Oo, int i, float[] fArr) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ float[] O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass4(O00O00Oo o00O00Oo, int i, float[] fArr) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ float[] O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass5(O00O00Oo o00O00Oo, int i, float[] fArr) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ float[] O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass6(O00O00Oo o00O00Oo, int i, float[] fArr) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ PointF O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass7(O00O00Oo o00O00Oo, PointF pointF, int i) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ float[] O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass8(O00O00Oo o00O00Oo, int i, float[] fArr) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O00O00Oo$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ float[] O00000Oo;
        final /* synthetic */ O00O00Oo O00000o0;

        AnonymousClass9(O00O00Oo o00O00Oo, int i, float[] fArr) {
        }

        public void run() {
        }
    }

    public O00O00Oo(String str, String str2) {
    }

    public static String O000000o(InputStream inputStream) {
        return null;
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
    public static java.lang.String O000000o(java.lang.String r0, android.content.Context r1) {
        /*
        r0 = 0;	 Catch:{ Exception -> 0x0010 }
        return r0;	 Catch:{ Exception -> 0x0010 }
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O00O00Oo.O000000o(java.lang.String, android.content.Context):java.lang.String");
    }

    public void O000000o() {
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, float f) {
    }

    public void O000000o(int i, int i2) {
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, PointF pointF) {
    }

    public void O000000o(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, float[] fArr) {
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
    protected void O000000o(java.lang.Runnable r3) {
        /*
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O00O00Oo.O000000o(java.lang.Runnable):void");
    }

    public void O00000Oo() {
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(int i, int i2) {
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(int i, float[] fArr) {
    }

    /* Access modifiers changed, original: protected */
    public void O00000o(int i, float[] fArr) {
    }

    /* Access modifiers changed, original: protected */
    public void O00000o0(int i, float[] fArr) {
    }

    public final void O00000oO() {
    }

    /* Access modifiers changed, original: protected */
    public void O00000oO(int i, float[] fArr) {
    }

    public final void O00000oo() {
    }

    /* Access modifiers changed, original: protected */
    public void O00000oo(int i, float[] fArr) {
    }

    public void O0000O0o() {
    }

    /* Access modifiers changed, original: protected */
    public void O0000OOo() {
    }

    public boolean O0000Oo() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void O0000Oo0() {
    }

    public int O0000OoO() {
        return 0;
    }

    public int O0000Ooo() {
        return 0;
    }

    public int O0000o0() {
        return 0;
    }

    public int O0000o00() {
        return 0;
    }

    public int O0000o0O() {
        return 0;
    }

    public int O0000o0o() {
        return 0;
    }
}
