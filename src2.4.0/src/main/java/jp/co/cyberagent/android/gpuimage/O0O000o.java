package jp.co.cyberagent.android.gpuimage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.opengl.GLSurfaceView.Renderer;
import com.yalantis.ucrop.view.CropImageView;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.O00000Oo.O0000Oo0;

@TargetApi(11)
/* compiled from: GPUImageRenderer */
public class O0O000o implements PreviewCallback, Renderer {
    public static final int O000000o = -1;
    static final float[] O00000Oo = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private O00O00Oo O00000o;
    public final Object O00000o0;
    private int O00000oO;
    private SurfaceTexture O00000oo;
    private final FloatBuffer O0000O0o;
    private final FloatBuffer O0000OOo;
    private int O0000Oo;
    private IntBuffer O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private O0o0000 O0000o;
    private int O0000o0;
    private int O0000o00;
    private final Queue<Runnable> O0000o0O;
    private final Queue<Runnable> O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private O0000Oo0 O0000oOO;
    private float O0000oOo;
    private float O0000oo;
    private float O0000oo0;

    /* compiled from: GPUImageRenderer */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O0O000o$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ byte[] O000000o;
        final /* synthetic */ Size O00000Oo;
        final /* synthetic */ O0O000o O00000o;
        final /* synthetic */ Camera O00000o0;

        AnonymousClass1(O0O000o o0O000o, byte[] bArr, Size size, Camera camera) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageRenderer */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O0O000o$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Camera O000000o;
        final /* synthetic */ O0O000o O00000Oo;

        AnonymousClass2(O0O000o o0O000o, Camera camera) {
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
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void run() {
            /*
            r4 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O0O000o$AnonymousClass2.run():void");
        }
    }

    /* compiled from: GPUImageRenderer */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O0O000o$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ O00O00Oo O000000o;
        final /* synthetic */ O0O000o O00000Oo;

        AnonymousClass3(O0O000o o0O000o, O00O00Oo o00O00Oo) {
        }

        public void run() {
        }
    }

    /* compiled from: GPUImageRenderer */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O0O000o$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Bitmap O000000o;
        final /* synthetic */ boolean O00000Oo;
        final /* synthetic */ O0O000o O00000o0;

        AnonymousClass5(O0O000o o0O000o, Bitmap bitmap, boolean z) {
        }

        public void run() {
        }
    }

    public O0O000o(O00O00Oo o00O00Oo) {
    }

    private float O000000o(float f, float f2) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
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
    private void O000000o(java.util.Queue<java.lang.Runnable> r2) {
        /*
        r1 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O0O000o.O000000o(java.util.Queue):void");
    }

    static /* synthetic */ void O00000o(O0O000o o0O000o) {
    }

    private void O0000O0o() {
    }

    public void O000000o() {
    }

    public void O000000o(float f, float f2, float f3) {
    }

    public void O000000o(Bitmap bitmap) {
    }

    public void O000000o(Bitmap bitmap, boolean z) {
    }

    public void O000000o(Camera camera) {
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
        throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O0O000o.O000000o(java.lang.Runnable):void");
    }

    public void O000000o(O0000Oo0 o0000Oo0) {
    }

    public void O000000o(O00O00Oo o00O00Oo) {
    }

    public void O000000o(O0o0000 o0o0000) {
    }

    public void O000000o(O0o0000 o0o0000, boolean z, boolean z2) {
    }

    /* Access modifiers changed, original: protected */
    public int O00000Oo() {
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    protected void O00000Oo(java.lang.Runnable r3) {
        /*
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O0O000o.O00000Oo(java.lang.Runnable):void");
    }

    public void O00000Oo(O0o0000 o0o0000, boolean z, boolean z2) {
    }

    public O0o0000 O00000o() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public int O00000o0() {
        return 0;
    }

    public boolean O00000oO() {
        return false;
    }

    public boolean O00000oo() {
        return false;
    }

    public void onDrawFrame(GL10 gl10) {
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
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
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 r1, int r2, int r3) {
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O0O000o.onSurfaceChanged(javax.microedition.khronos.opengles.GL10, int, int):void");
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }
}
