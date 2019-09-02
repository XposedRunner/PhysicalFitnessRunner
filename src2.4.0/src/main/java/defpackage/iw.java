package defpackage;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o00.O00000o;
import com.zjwh.sw.map.entity.RunPeopleBean;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.gp.O000000o;
import defpackage.gp.O00000Oo;
import java.io.File;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: CheatReportPImpl */
/* renamed from: iw */
public class iw extends iu<O00000Oo> implements O000000o {
    private RunPeopleBean O000000o;
    private List<RunPeopleBean> O00000Oo;
    private List<SWLatLng> O00000o;
    private List<File> O00000oO;
    private int O00000oo;
    private boolean O0000O0o;

    /* compiled from: CheatReportPImpl */
    /* renamed from: iw$1 */
    class 1 implements O00000o {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ iw O00000Oo;

        1(iw iwVar, Context context) {
        }

        public void O000000o() {
        }

        public void O000000o(File file) {
        }
    }

    /* compiled from: CheatReportPImpl */
    /* renamed from: iw$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ iw O00000Oo;

        /* compiled from: CheatReportPImpl */
        /* renamed from: iw$2$1 */
        class 1 extends TypeToken<List<RunPeopleBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(iw iwVar, Context context) {
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

    /* compiled from: CheatReportPImpl */
    /* renamed from: iw$3 */
    class 3 implements MyCallback<String> {
        final /* synthetic */ String O000000o;
        final /* synthetic */ iw O00000Oo;

        /* compiled from: CheatReportPImpl */
        /* renamed from: iw$3$1 */
        class 1 extends TypeToken<List<SWLatLng>> {
            final /* synthetic */ 3 O000000o;

            1(3 3) {
            }
        }

        3(iw iwVar, String str) {
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

    /* compiled from: CheatReportPImpl */
    /* renamed from: iw$4 */
    class 4 implements MyCallback<String> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ String O00000Oo;
        final /* synthetic */ iw O00000o;
        final /* synthetic */ int O00000o0;

        /* compiled from: CheatReportPImpl */
        /* renamed from: iw$4$1 */
        class 1 extends TypeToken<List<String>> {
            final /* synthetic */ 4 O000000o;

            1(4 4) {
            }
        }

        4(iw iwVar, Context context, String str, int i) {
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

    /* compiled from: CheatReportPImpl */
    /* renamed from: iw$5 */
    class 5 implements MyCallback<String> {
        final /* synthetic */ iw O000000o;

        5(iw iwVar) {
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

    public iw(O00000Oo o00000Oo) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0002
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
    private java.lang.String O000000o(double r3, double r5) {
        /*
        r2 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iw.O000000o(double, double):java.lang.String");
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
    private void O000000o(android.content.Context r4, java.lang.String r5) {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iw.O000000o(android.content.Context, java.lang.String):void");
    }

    private void O000000o(Context context, String str, int i) {
    }

    private void O000000o(Context context, List<String> list, String str, int i) {
    }

    public RunPeopleBean O000000o() {
        return null;
    }

    public void O000000o(int i) {
    }

    public void O000000o(int i, Context context) {
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
    public void O000000o(android.content.Context r4) {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iw.O000000o(android.content.Context):void");
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
    public void O000000o(android.content.Context r4, double r5, double r7, double r9, double r11) {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iw.O000000o(android.content.Context, double, double, double, double):void");
    }

    public void O000000o(Context context, String str, int i, int i2) {
    }

    public List<RunPeopleBean> O00000Oo() {
        return null;
    }

    public void O00000o() {
    }

    public List<SWLatLng> O00000o0() {
        return null;
    }
}
