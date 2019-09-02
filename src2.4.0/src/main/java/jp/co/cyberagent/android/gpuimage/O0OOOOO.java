package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* compiled from: GPUImageTwoInputFilter */
public class O0OOOOO extends O00O00Oo {
    private static final String O000000o = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}";
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    private ByteBuffer O00000oO;
    private Bitmap O00000oo;

    /* compiled from: GPUImageTwoInputFilter */
    /* renamed from: jp.co.cyberagent.android.gpuimage.O0OOOOO$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Bitmap O000000o;
        final /* synthetic */ O0OOOOO O00000Oo;

        AnonymousClass1(O0OOOOO o0ooooo, Bitmap bitmap) {
        }

        public void run() {
        }
    }

    public O0OOOOO(String str) {
    }

    public O0OOOOO(String str, String str2) {
    }

    public void O000000o() {
    }

    public void O000000o(Bitmap bitmap) {
    }

    public void O000000o(O0o0000 o0o0000, boolean z, boolean z2) {
    }

    public void O00000o() {
    }

    public Bitmap O00000o0() {
        return null;
    }

    public void O0000O0o() {
    }

    /* Access modifiers changed, original: protected */
    public void O0000OOo() {
    }
}
