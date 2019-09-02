package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageScreenBlendFilter */
public class O0O0O0o extends O0OOOOO {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     mediump vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\n     mediump vec4 whiteColor = vec4(1.0);\n     gl_FragColor = whiteColor - ((whiteColor - textureColor2) * (whiteColor - textureColor));\n }";
}
