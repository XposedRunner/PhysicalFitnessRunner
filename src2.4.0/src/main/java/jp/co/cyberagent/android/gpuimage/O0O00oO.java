package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageRGBFilter */
public class O0O00oO extends O00O00Oo {
    public static final String O000000o = "  varying highp vec2 textureCoordinate;\n  \n  uniform sampler2D inputImageTexture;\n  uniform highp float red;\n  uniform highp float green;\n  uniform highp float blue;\n  \n  void main()\n  {\n      highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n      \n      gl_FragColor = vec4(textureColor.r * red, textureColor.g * green, textureColor.b * blue, 1.0);\n  }\n";
    private int O00000Oo;
    private int O00000o;
    private float O00000o0;
    private float O00000oO;
    private int O00000oo;
    private float O0000O0o;
    private boolean O0000OOo;

    public O0O00oO(float f, float f2, float f3) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O00000Oo(float f) {
    }

    public void O00000o0(float f) {
    }
}
