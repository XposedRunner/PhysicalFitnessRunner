package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageDifferenceBlendFilter */
public class O000OOo extends O0OOOOO {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     mediump vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\n     gl_FragColor = vec4(abs(textureColor2.rgb - textureColor.rgb), textureColor.a);\n }";
}
