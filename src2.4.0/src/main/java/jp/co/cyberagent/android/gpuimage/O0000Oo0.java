package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageBilateralFilter */
public class O0000Oo0 extends O00O00Oo {
    public static final String O000000o = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nconst int GAUSSIAN_SAMPLES = 9;\nuniform vec2 singleStepOffset;\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[GAUSSIAN_SAMPLES];\nvoid main()\n{\n\tgl_Position = position;\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\tint multiplier = 0;\n\tvec2 blurStep;\n\tfor (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n\t{\n\t\tmultiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n\t\tblurStep = float(multiplier) * singleStepOffset;\n\t\tblurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n\t}\n}";
    public static final String O00000Oo = "uniform sampler2D inputImageTexture;\n const lowp int GAUSSIAN_SAMPLES = 9;\n varying highp vec2 textureCoordinate;\n varying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n uniform mediump float distanceNormalizationFactor;\n void main()\n {\n     lowp vec4 centralColor;\n     lowp float gaussianWeightTotal;\n     lowp vec4 sum;\n     lowp vec4 sampleColor;\n     lowp float distanceFromCentralColor;\n     lowp float gaussianWeight;\n     \n     centralColor = texture2D(inputImageTexture, blurCoordinates[4]);\n     gaussianWeightTotal = 0.18;\n     sum = centralColor * 0.18;\n     \n     sampleColor = texture2D(inputImageTexture, blurCoordinates[0]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.05 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[1]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.09 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[2]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.12 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[3]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.15 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[5]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.15 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[6]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.12 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[7]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.09 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     sampleColor = texture2D(inputImageTexture, blurCoordinates[8]);\n     distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.05 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sampleColor * gaussianWeight;\n     gl_FragColor = sum / gaussianWeightTotal;\n }";
    private int O00000o;
    private float O00000o0;
    private int O00000oO;

    public O0000Oo0(float f) {
    }

    private void O000000o(float f, float f2) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O000000o(int i, int i2) {
    }

    public void O00000Oo() {
    }
}
