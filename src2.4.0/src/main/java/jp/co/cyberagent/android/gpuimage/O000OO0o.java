package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageColorMatrixFilter */
public class O000OO0o extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform lowp mat4 colorMatrix;\nuniform lowp float intensity;\n\nvoid main()\n{\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 outputColor = textureColor * colorMatrix;\n    \n    gl_FragColor = (intensity * outputColor) + ((1.0 - intensity) * textureColor);\n}";
    private float O00000Oo;
    private int O00000o;
    private float[] O00000o0;
    private int O00000oO;

    public O000OO0o(float f, float[] fArr) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O000000o(float[] fArr) {
    }

    public void O00000Oo() {
    }
}
