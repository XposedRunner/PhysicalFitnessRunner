package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImagePosterizeFilter */
public class O00o extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform highp float colorLevels;\n\nvoid main()\n{\n   highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   \n   gl_FragColor = floor((textureColor * colorLevels) + vec4(0.5)) / colorLevels;\n}";
    private int O00000Oo;
    private int O00000o0;

    public O00o(int i) {
    }

    public void O000000o() {
    }

    public void O000000o(int i) {
    }
}
