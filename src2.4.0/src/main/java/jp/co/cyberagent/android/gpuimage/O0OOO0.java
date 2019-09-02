package jp.co.cyberagent.android.gpuimage;

import android.graphics.Point;
import android.graphics.PointF;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: GPUImageToneCurveFilter */
public class O0OOO0 extends O00O00Oo {
    public static final String O000000o = " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D toneCurveTexture;\n\n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp float redCurveValue = texture2D(toneCurveTexture, vec2(textureColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(toneCurveTexture, vec2(textureColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(toneCurveTexture, vec2(textureColor.b, 0.0)).b;\n\n     gl_FragColor = vec4(redCurveValue, greenCurveValue, blueCurveValue, textureColor.a);\n }";
    private int[] O00000Oo;
    private PointF[] O00000o;
    private int O00000o0;
    private PointF[] O00000oO;
    private PointF[] O00000oo;
    private PointF[] O0000O0o;
    private ArrayList<Float> O0000OOo;
    private ArrayList<Float> O0000o;
    private ArrayList<Float> O0000oO;
    private ArrayList<Float> O0000oO0;

    private ArrayList<Point> O000000o(Point[] pointArr) {
        return null;
    }

    private ArrayList<Double> O00000Oo(Point[] pointArr) {
        return null;
    }

    private short O00000o0(InputStream inputStream) throws IOException {
        return (short) 0;
    }

    private void O00000o0() {
    }

    private ArrayList<Float> O00000oO(PointF[] pointFArr) {
        return null;
    }

    public void O000000o() {
    }

    public void O000000o(PointF[] pointFArr) {
    }

    public void O00000Oo() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0001
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void O00000Oo(java.io.InputStream r12) {
        /*
        r11 = this;
        return;	 Catch:{ IOException -> 0x005f }
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.O0OOO0.O00000Oo(java.io.InputStream):void");
    }

    public void O00000Oo(PointF[] pointFArr) {
    }

    public void O00000o(PointF[] pointFArr) {
    }

    public void O00000o0(PointF[] pointFArr) {
    }

    /* Access modifiers changed, original: protected */
    public void O0000OOo() {
    }
}
