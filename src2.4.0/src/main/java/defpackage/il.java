package defpackage;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.zjwh.android_wh_physicalfitness.receiver.O000000o;
import com.zjwh.android_wh_physicalfitness.receiver.O00000Oo;

/* compiled from: MySensorListener */
/* renamed from: il */
public class il implements SensorEventListener, O00000Oo {
    public static final int O000000o = 1;
    public static final int O00000Oo = 2;
    private static final String O00000o = "MySensorListener";
    public static final int O00000o0 = 3;
    private Context O00000oO;
    private SensorManager O00000oo;
    private float O0000O0o;
    private O000000o O0000OOo;
    private ii O0000Oo;
    private O000000o O0000Oo0;
    private io O0000OoO;
    private boolean O0000Ooo;
    private boolean O0000o00;

    /* compiled from: MySensorListener */
    /* renamed from: il$O000000o */
    public interface O000000o {
        void O000000o(float f);

        void O000000o(int i);

        void O00000Oo(float f);

        void O00000Oo(int i);

        void O00000o0(int i);
    }

    /* compiled from: MySensorListener */
    /* renamed from: il$1 */
    class 1 implements im {
        final /* synthetic */ il O000000o;

        1(il ilVar) {
        }

        public void O000000o(float f) {
        }

        public void O000000o(int i) {
        }
    }

    /* compiled from: MySensorListener */
    /* renamed from: il$2 */
    class 2 implements im {
        final /* synthetic */ il O000000o;

        2(il ilVar) {
        }

        public void O000000o(float f) {
        }

        public void O000000o(int i) {
        }
    }

    public il(Context context) {
    }

    public void O000000o() {
    }

    public void O000000o(O000000o o000000o) {
    }

    public void O00000Oo() {
    }

    public void O00000o() {
    }

    public void O00000o0() {
    }

    public void O00000oO() {
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void onSensorChanged(android.hardware.SensorEvent r6) {
        /*
        r5 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.il.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
