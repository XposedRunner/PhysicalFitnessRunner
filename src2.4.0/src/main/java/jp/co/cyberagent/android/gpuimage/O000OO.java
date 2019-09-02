package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageContrastFilter */
public class O000OO extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float contrast;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(((textureColor.rgb - vec3(0.5)) * contrast + vec3(0.5)), textureColor.w);\n }";
    private int O00000Oo;
    private float O00000o0;

    public O000OO(float f) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O00000Oo() {
    }
}
