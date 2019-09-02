package jp.co.cyberagent.android.gpuimage;

import java.nio.FloatBuffer;

/* compiled from: GPUImageTransformFilter */
public class OO0oO extends O00O00Oo {
    public static final String O000000o = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform mat4 transformMatrix;\n uniform mat4 orthographicMatrix;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = transformMatrix * vec4(position.xyz, 1.0) * orthographicMatrix;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
    private int O00000Oo;
    private float[] O00000o;
    private int O00000o0;
    private float[] O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;

    public void O000000o() {
    }

    public void O000000o(int i, int i2) {
    }

    public void O000000o(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
    }

    public void O000000o(boolean z) {
    }

    public void O000000o(float[] fArr) {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(boolean z) {
    }

    public boolean O00000o() {
        return false;
    }

    public float[] O00000o0() {
        return null;
    }

    public boolean O0000o() {
        return false;
    }
}
