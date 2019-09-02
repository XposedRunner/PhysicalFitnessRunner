package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageColorInvertFilter */
public class O000OO00 extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    \n    gl_FragColor = vec4((1.0 - textureColor.rgb), textureColor.w);\n}";
}
