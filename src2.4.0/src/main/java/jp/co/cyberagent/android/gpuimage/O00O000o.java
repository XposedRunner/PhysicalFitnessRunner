package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageFalseColorFilter */
public class O00O000o extends O00O00Oo {
    public static final String O000000o = "precision lowp float;\n\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform float intensity;\nuniform vec3 firstColor;\nuniform vec3 secondColor;\n\nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main()\n{\nlowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nfloat luminance = dot(textureColor.rgb, luminanceWeighting);\n\ngl_FragColor = vec4( mix(firstColor.rgb, secondColor.rgb, luminance), textureColor.a);\n}\n";
    private float[] O00000Oo;
    private float[] O00000o;
    private int O00000o0;
    private int O00000oO;

    public O00O000o(float f, float f2, float f3, float f4, float f5, float f6) {
    }

    public O00O000o(float[] fArr, float[] fArr2) {
    }

    public void O000000o() {
    }

    public void O000000o(float[] fArr) {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(float[] fArr) {
    }
}
