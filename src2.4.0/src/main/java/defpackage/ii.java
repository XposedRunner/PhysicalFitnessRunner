package defpackage;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: AccelerometerListener */
/* renamed from: ii */
public class ii implements SensorEventListener, ik {
    private Context O000000o;
    private SensorManager O00000Oo;
    private float[] O00000o;
    private im O00000o0;
    private final int O00000oO;
    private float[] O00000oo;
    private int O0000O0o;
    private boolean O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private float O0000OoO;
    private float O0000Ooo;
    private float O0000o0;
    private long O0000o00;
    private float O0000o0O;

    public ii(Context context) {
    }

    private float O000000o(float[] fArr, int i) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    private void O000000o(float f) {
    }

    private boolean O000000o(float f, float f2) {
        return false;
    }

    private float O00000Oo(float f) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public void O000000o(im imVar) {
    }

    public boolean O000000o() {
        return false;
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
    public void O00000Oo() {
        /*
        r1 = this;
        return;	 Catch:{ Exception -> 0x000a }
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ii.O00000Oo():void");
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
    }
}
