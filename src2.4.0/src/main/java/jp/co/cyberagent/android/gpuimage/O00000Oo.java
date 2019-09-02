package jp.co.cyberagent.android.gpuimage;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.hardware.Camera;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Handler;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* compiled from: GPUImage */
public class O00000Oo {
    private final Context O000000o;
    private final O0O000o O00000Oo;
    private O00O00Oo O00000o;
    private GLSurfaceView O00000o0;
    private Bitmap O00000oO;
    private O0000Oo0 O00000oo;

    /* compiled from: GPUImage */
    private abstract class O00000Oo extends AsyncTask<Void, Void, Bitmap> {
        private final O00000Oo O000000o;
        final /* synthetic */ O00000Oo O00000Oo;
        private int O00000o;
        private int O00000o0;

        public O00000Oo(O00000Oo o00000Oo, O00000Oo o00000Oo2) {
        }

        private boolean O000000o(boolean z, boolean z2) {
            return false;
        }

        private int[] O000000o(int i, int i2) {
            return null;
        }

        private Bitmap O00000Oo() {
            return null;
        }

        private Bitmap O00000Oo(Bitmap bitmap) {
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
        private android.graphics.Bitmap O00000o0(android.graphics.Bitmap r10) {
            /*
            r9 = this;
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O00000Oo$O00000Oo.O00000o0(android.graphics.Bitmap):android.graphics.Bitmap");
        }

        public abstract int O000000o() throws IOException;

        public abstract Bitmap O000000o(Options options);

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0002
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
        protected android.graphics.Bitmap O000000o(java.lang.Void... r4) {
            /*
            r3 = this;
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O00000Oo$O00000Oo.O000000o(java.lang.Void[]):android.graphics.Bitmap");
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(Bitmap bitmap) {
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return null;
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ void onPostExecute(Object obj) {
        }
    }

    /* compiled from: GPUImage */
    private class O000000o extends O00000Oo {
        final /* synthetic */ O00000Oo O000000o;
        private final File O00000o0;

        public O000000o(O00000Oo o00000Oo, O00000Oo o00000Oo2, File file) {
        }

        /* Access modifiers changed, original: protected */
        public int O000000o() throws IOException {
            return 0;
        }

        /* Access modifiers changed, original: protected */
        public Bitmap O000000o(Options options) {
            return null;
        }
    }

    /* compiled from: GPUImage */
    private class O00000o0 extends O00000Oo {
        final /* synthetic */ O00000Oo O000000o;
        private final Uri O00000o0;

        public O00000o0(O00000Oo o00000Oo, O00000Oo o00000Oo2, Uri uri) {
        }

        /* Access modifiers changed, original: protected */
        public int O000000o() throws IOException {
            return 0;
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
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        protected android.graphics.Bitmap O000000o(android.graphics.BitmapFactory.Options r4) {
            /*
            r3 = this;
            r0 = 0;
            return r0;	 Catch:{ Exception -> 0x0043 }
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O00000Oo$O00000o0.O000000o(android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
        }
    }

    /* compiled from: GPUImage */
    public interface O00000o {
        void O000000o(Uri uri);
    }

    /* compiled from: GPUImage */
    public interface O0000O0o<T> {
        void O000000o(T t);
    }

    @Deprecated
    /* compiled from: GPUImage */
    private class O0000OOo extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ O00000Oo O000000o;
        private final Bitmap O00000Oo;
        private final String O00000o;
        private final String O00000o0;
        private final O00000o O00000oO;
        private final Handler O00000oo;

        public O0000OOo(O00000Oo o00000Oo, Bitmap bitmap, String str, String str2, O00000o o00000o) {
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
        private void O000000o(java.lang.String r4, java.lang.String r5, android.graphics.Bitmap r6) {
            /*
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O00000Oo$O0000OOo.O000000o(java.lang.String, java.lang.String, android.graphics.Bitmap):void");
        }

        /* Access modifiers changed, original: protected|varargs */
        public Void O000000o(Void... voidArr) {
            return null;
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return null;
        }
    }

    /* compiled from: GPUImage */
    public enum O0000Oo0 {
        CENTER_INSIDE,
        CENTER_CROP
    }

    public O00000Oo(Context context) {
    }

    public static void O000000o(Bitmap bitmap, List<O00O00Oo> list, O0000O0o<Bitmap> o0000O0o) {
    }

    private boolean O000000o(Context context) {
        return false;
    }

    private String O00000Oo(Uri uri) {
        return null;
    }

    @TargetApi(11)
    private void O00000Oo(Camera camera) {
    }

    private int O00000o() {
        return 0;
    }

    private int O00000oO() {
        return 0;
    }

    public void O000000o() {
    }

    public void O000000o(float f, float f2, float f3) {
    }

    public void O000000o(Bitmap bitmap) {
    }

    @Deprecated
    public void O000000o(Bitmap bitmap, String str, String str2, O00000o o00000o) {
    }

    public void O000000o(Camera camera) {
    }

    public void O000000o(Camera camera, int i, boolean z, boolean z2) {
    }

    public void O000000o(Uri uri) {
    }

    public void O000000o(GLSurfaceView gLSurfaceView) {
    }

    public void O000000o(File file) {
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Runnable runnable) {
    }

    @Deprecated
    public void O000000o(String str, String str2, O00000o o00000o) {
    }

    public void O000000o(O0000Oo0 o0000Oo0) {
    }

    public void O000000o(O00O00Oo o00O00Oo) {
    }

    public void O000000o(O0o0000 o0o0000) {
    }

    public void O000000o(O0o0000 o0o0000, boolean z, boolean z2) {
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public android.graphics.Bitmap O00000Oo(android.graphics.Bitmap r5) {
        /*
        r4 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O00000Oo.O00000Oo(android.graphics.Bitmap):android.graphics.Bitmap");
    }

    public void O00000Oo() {
    }

    public Bitmap O00000o0() {
        return null;
    }
}
