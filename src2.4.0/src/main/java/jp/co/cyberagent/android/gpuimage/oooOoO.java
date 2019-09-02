package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageExposureFilter */
public class oooOoO extends O00O00Oo {
    public static final String O000000o = " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform highp float exposure;\n \n void main()\n {\n     highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(textureColor.rgb * pow(2.0, exposure), textureColor.w);\n } ";
    private int O00000Oo;
    private float O00000o0;

    public oooOoO(float f) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O00000Oo() {
    }
}
