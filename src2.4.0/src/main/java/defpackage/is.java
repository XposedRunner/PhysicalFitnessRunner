package defpackage;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.AttendanceListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.gn.O000000o;
import defpackage.gn.O00000Oo;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: AttendanceListPImpl */
/* renamed from: is */
public class is extends iu<O00000Oo> implements O000000o {
    List<SemesterInfo> O000000o;
    private List<AttendanceListBean> O00000Oo;
    private int O00000o;
    private int O00000oO;
    private int O00000oo;
    private boolean O0000O0o;

    /* compiled from: AttendanceListPImpl */
    /* renamed from: is$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ is O000000o;

        1(is isVar) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
        }

        public void onFinished() {
        }

        public void onSuccess(String str) {
        }
    }

    /* compiled from: AttendanceListPImpl */
    /* renamed from: is$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ is O00000o0;

        /* compiled from: AttendanceListPImpl */
        /* renamed from: is$2$1 */
        class 1 extends TypeToken<List<AttendanceListBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(is isVar, int i, int i2) {
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
        }

        public void onFinished() {
        }

        public void onSuccess(String str) {
        }
    }

    public is(O00000Oo o00000Oo) {
    }

    public void O000000o() {
    }

    public void O000000o(Context context) {
    }

    public void O000000o(Context context, int i) {
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
    public void O000000o(android.content.Context r5, int r6, int r7) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.is.O000000o(android.content.Context, int, int):void");
    }

    public void O000000o(SemesterInfo semesterInfo) {
    }

    public int O00000Oo() {
        return 0;
    }

    public int O00000o0() {
        return 0;
    }
}
