package jp.co.cyberagent.android.gpuimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import java.io.File;
import java.util.concurrent.Semaphore;
import jp.co.cyberagent.android.gpuimage.O00000Oo.O0000Oo0;

public class GPUImageView extends FrameLayout {
    public O0000O0o O000000o;
    private GLSurfaceView O00000Oo;
    private O00O00Oo O00000o;
    private O00000Oo O00000o0;
    private float O00000oO;

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageView$1 */
    class AnonymousClass1 implements OnGlobalLayoutListener {
        final /* synthetic */ Semaphore O000000o;
        final /* synthetic */ GPUImageView O00000Oo;

        AnonymousClass1(GPUImageView gPUImageView, Semaphore semaphore) {
        }

        public void onGlobalLayout() {
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageView$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Semaphore O000000o;
        final /* synthetic */ GPUImageView O00000Oo;

        AnonymousClass3(GPUImageView gPUImageView, Semaphore semaphore) {
        }

        public void run() {
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageView$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ Semaphore O00000o;
        final /* synthetic */ int[] O00000o0;
        final /* synthetic */ GPUImageView O00000oO;

        AnonymousClass6(GPUImageView gPUImageView, int i, int i2, int[] iArr, Semaphore semaphore) {
        }

        public void run() {
        }
    }

    private class O000000o extends GLSurfaceView {
        final /* synthetic */ GPUImageView O000000o;

        public O000000o(GPUImageView gPUImageView, Context context) {
        }

        public O000000o(GPUImageView gPUImageView, Context context, AttributeSet attributeSet) {
        }

        /* Access modifiers changed, original: protected */
        public void onMeasure(int i, int i2) {
        }
    }

    private class O00000Oo extends FrameLayout {
        final /* synthetic */ GPUImageView O000000o;

        public O00000Oo(GPUImageView gPUImageView, Context context) {
        }

        public O00000Oo(GPUImageView gPUImageView, Context context, AttributeSet attributeSet) {
        }

        public O00000Oo(GPUImageView gPUImageView, Context context, AttributeSet attributeSet, int i) {
        }

        private void O000000o() {
        }
    }

    public interface O00000o0 {
        void O000000o(Uri uri);
    }

    private class O00000o extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ GPUImageView O000000o;
        private final String O00000Oo;
        private final int O00000o;
        private final String O00000o0;
        private final int O00000oO;
        private final O00000o0 O00000oo;
        private final Handler O0000O0o;

        public O00000o(GPUImageView gPUImageView, String str, String str2, int i, int i2, O00000o0 o00000o0) {
        }

        public O00000o(GPUImageView gPUImageView, String str, String str2, O00000o0 o00000o0) {
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
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        private void O000000o(java.lang.String r4, java.lang.String r5, android.graphics.Bitmap r6) {
            /*
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GPUImageView$O00000o.O000000o(java.lang.String, java.lang.String, android.graphics.Bitmap):void");
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
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        protected java.lang.Void O000000o(java.lang.Void... r3) {
            /*
            r2 = this;
            r0 = 0;	 Catch:{ InterruptedException -> 0x001d }
            return r0;	 Catch:{ InterruptedException -> 0x001d }
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.GPUImageView$O00000o.O000000o(java.lang.Void[]):java.lang.Void");
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return null;
        }
    }

    public static class O0000O0o {
        int O000000o;
        int O00000Oo;

        public O0000O0o(int i, int i2) {
        }
    }

    public GPUImageView(Context context) {
    }

    public GPUImageView(Context context, AttributeSet attributeSet) {
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
    }

    public Bitmap O000000o(int i, int i2) throws InterruptedException {
        return null;
    }

    public void O000000o() {
    }

    public void O000000o(float f, float f2, float f3) {
    }

    public void O000000o(String str, String str2, int i, int i2, O00000o0 o00000o0) {
    }

    public void O000000o(String str, String str2, O00000o0 o00000o0) {
    }

    public Bitmap O00000Oo() throws InterruptedException {
        return null;
    }

    public void O00000o() {
    }

    public void O00000o0() {
    }

    public O00O00Oo getFilter() {
        return null;
    }

    public O00000Oo getGPUImage() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
    }

    public void setFilter(O00O00Oo o00O00Oo) {
    }

    public void setImage(Bitmap bitmap) {
    }

    public void setImage(Uri uri) {
    }

    public void setImage(File file) {
    }

    public void setRatio(float f) {
    }

    public void setRotation(O0o0000 o0o0000) {
    }

    public void setScaleType(O0000Oo0 o0000Oo0) {
    }
}
