package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageOpacityFilter */
public class O00o00 extends O00O00Oo {
    public static final String O000000o = "  varying highp vec2 textureCoordinate;\n  \n  uniform sampler2D inputImageTexture;\n  uniform lowp float opacity;\n  \n  void main()\n  {\n      lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n      \n      gl_FragColor = vec4(textureColor.rgb, textureColor.a * opacity);\n  }\n";
    private int O00000Oo;
    private float O00000o0;

    public O00o00(float f) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O00000Oo() {
    }
}
