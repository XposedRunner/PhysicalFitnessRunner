package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageHazeFilter */
public class O00O0o extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform lowp float distance;\nuniform highp float slope;\n\nvoid main()\n{\n\t//todo reconsider precision modifiers\t \n\t highp vec4 color = vec4(1.0);//todo reimplement as a parameter\n\n\t highp float  d = textureCoordinate.y * slope  +  distance; \n\n\t highp vec4 c = texture2D(inputImageTexture, textureCoordinate) ; // consider using unpremultiply\n\n\t c = (c - d * color) / (1.0 -d);\n\n\t gl_FragColor = c; //consider using premultiply(c);\n}\n";
    private float O00000Oo;
    private float O00000o;
    private int O00000o0;
    private int O00000oO;

    public O00O0o(float f, float f2) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(float f) {
    }
}
