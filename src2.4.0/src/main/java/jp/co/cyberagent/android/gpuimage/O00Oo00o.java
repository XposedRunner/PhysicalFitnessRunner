package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageLevelsFilter */
public class O00Oo00o extends O00O00Oo {
    public static final String O000000o = " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform mediump vec3 levelMinimum;\n uniform mediump vec3 levelMiddle;\n uniform mediump vec3 levelMaximum;\n uniform mediump vec3 minOutput;\n uniform mediump vec3 maxOutput;\n \n void main()\n {\n     mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4( mix(minOutput, maxOutput, pow(min(max(textureColor.rgb -levelMinimum, vec3(0.0)) / (levelMaximum - levelMinimum  ), vec3(1.0)), 1.0 /levelMiddle)) , textureColor.a);\n }\n";
    private static final String O00000Oo = "O00Oo00o";
    private float[] O00000o;
    private int O00000o0;
    private int O00000oO;
    private float[] O00000oo;
    private int O0000O0o;
    private float[] O0000OOo;
    private int O0000o;
    private int O0000oO;
    private float[] O0000oO0;
    private float[] O0000oOO;

    private O00Oo00o(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5) {
    }

    public void O000000o() {
    }

    public void O000000o(float f, float f2, float f3) {
    }

    public void O000000o(float f, float f2, float f3, float f4, float f5) {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(float f, float f2, float f3) {
    }

    public void O00000Oo(float f, float f2, float f3, float f4, float f5) {
    }

    public void O00000o(float f, float f2, float f3) {
    }

    public void O00000o(float f, float f2, float f3, float f4, float f5) {
    }

    public void O00000o0() {
    }

    public void O00000o0(float f, float f2, float f3) {
    }

    public void O00000o0(float f, float f2, float f3, float f4, float f5) {
    }
}
