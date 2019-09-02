package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageGammaFilter */
public class O00O00o extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float gamma;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n }";
    private int O00000Oo;
    private float O00000o0;

    public O00O00o(float f) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O00000Oo() {
    }
}
