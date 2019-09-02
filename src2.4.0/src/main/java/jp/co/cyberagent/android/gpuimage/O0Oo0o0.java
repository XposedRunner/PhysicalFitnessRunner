package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageSubtractBlendFilter */
public class O0Oo0o0 extends O0OOOOO {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n   lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   lowp vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\n\n   gl_FragColor = vec4(textureColor.rgb - textureColor2.rgb, textureColor.a);\n }";
}
