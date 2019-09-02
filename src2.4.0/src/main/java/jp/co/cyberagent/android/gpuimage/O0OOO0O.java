package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageToonFilter */
public class O0OOO0O extends O00000o {
    public static final String O000000o = "precision highp float;\n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate;\n\nvarying vec2 topTextureCoordinate;\nvarying vec2 topLeftTextureCoordinate;\nvarying vec2 topRightTextureCoordinate;\n\nvarying vec2 bottomTextureCoordinate;\nvarying vec2 bottomLeftTextureCoordinate;\nvarying vec2 bottomRightTextureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp float intensity;\nuniform highp float threshold;\nuniform highp float quantizationLevels;\n\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main()\n{\nvec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n\nfloat bottomLeftIntensity = texture2D(inputImageTexture, bottomLeftTextureCoordinate).r;\nfloat topRightIntensity = texture2D(inputImageTexture, topRightTextureCoordinate).r;\nfloat topLeftIntensity = texture2D(inputImageTexture, topLeftTextureCoordinate).r;\nfloat bottomRightIntensity = texture2D(inputImageTexture, bottomRightTextureCoordinate).r;\nfloat leftIntensity = texture2D(inputImageTexture, leftTextureCoordinate).r;\nfloat rightIntensity = texture2D(inputImageTexture, rightTextureCoordinate).r;\nfloat bottomIntensity = texture2D(inputImageTexture, bottomTextureCoordinate).r;\nfloat topIntensity = texture2D(inputImageTexture, topTextureCoordinate).r;\nfloat h = -topLeftIntensity - 2.0 * topIntensity - topRightIntensity + bottomLeftIntensity + 2.0 * bottomIntensity + bottomRightIntensity;\nfloat v = -bottomLeftIntensity - 2.0 * leftIntensity - topLeftIntensity + bottomRightIntensity + 2.0 * rightIntensity + topRightIntensity;\n\nfloat mag = length(vec2(h, v));\n\nvec3 posterizedImageColor = floor((textureColor.rgb * quantizationLevels) + 0.5) / quantizationLevels;\n\nfloat thresholdTest = 1.0 - step(threshold, mag);\n\ngl_FragColor = vec4(posterizedImageColor * thresholdTest, textureColor.a);\n}\n";
    int O00000o;
    float O00000o0;
    float O00000oO;
    int O00000oo;

    public O0OOO0O(float f, float f2) {
    }

    public void O000000o() {
    }

    public void O00000Oo() {
    }

    public void O00000o(float f) {
    }

    public void O00000oO(float f) {
    }
}
