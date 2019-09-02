package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.entity.DynamicBean;
import com.zjwh.android_wh_physicalfitness.entity.FansListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.gq.O000000o;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: DynamicFragmentPImpl */
/* renamed from: jl */
public class jl extends iu<O00000Oo> implements O000000o {
    public static final int O000000o = 1;
    public static final int O00000Oo = 2;
    public static final int O00000o = 3;
    public static final int O00000oO = 4;
    public static final int O00000oo = 5;
    public static final int O0000O0o = 6;
    public static final int O0000OOo = 7;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private List<FansListBean> O0000o;
    private boolean O0000o0;
    private int O0000o00;
    private boolean O0000o0O;
    private List<DynamicBean> O0000o0o;
    private Context O0000oO;
    private View O0000oO0;
    private O00000o0 O0000oOO;
    private O00000Oo O0000oOo;

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$10 */
    class 10 implements MyCallback<String> {
        final /* synthetic */ jl O000000o;

        10(jl jlVar) {
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

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$11 */
    class 11 implements MyCallback<String> {
        final /* synthetic */ int O000000o;
        final /* synthetic */ jl O00000Oo;

        11(jl jlVar, int i) {
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

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$1 */
    class 1 extends BroadcastReceiver {
        final /* synthetic */ jl O000000o;

        1(jl jlVar) {
        }

        public void onReceive(Context context, Intent intent) {
        }
    }

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ jl O00000o0;

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$2$1 */
        class 1 extends TypeToken<List<FansListBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(jl jlVar, int i, int i2) {
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

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$3 */
    class 3 implements MyCallback<String> {
        final /* synthetic */ FansListBean O000000o;
        final /* synthetic */ jl O00000Oo;

        3(jl jlVar, FansListBean fansListBean) {
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

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$4 */
    class 4 implements com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ jl O00000Oo;

        4(jl jlVar, int i) {
        }

        public void O000000o(int i) {
        }
    }

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$5 */
    class 5 implements com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ jl O00000Oo;

        5(jl jlVar, int i) {
        }

        public void O000000o(int i) {
        }
    }

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$6 */
    class 6 implements com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ jl O00000Oo;

        6(jl jlVar, int i) {
        }

        public void O000000o(int i) {
        }
    }

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$7 */
    class 7 implements com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ jl O00000Oo;

        7(jl jlVar, int i) {
        }

        public void O000000o(int i) {
        }
    }

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$8 */
    class 8 implements com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ jl O00000Oo;

        8(jl jlVar, int i) {
        }

        public void O000000o(int i) {
        }
    }

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$9 */
    class 9 implements CacheCallback {
        final /* synthetic */ jl O000000o;

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$9$1 */
        class 1 extends TypeToken<List<DynamicBean>> {
            final /* synthetic */ 9 O000000o;

            1(9 9) {
            }
        }

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$9$2 */
        class 2 implements OnClickListener {
            final /* synthetic */ 9 O000000o;

            2(9 9) {
            }

            public void onClick(View view) {
            }
        }

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$9$3 */
        class 3 implements OnClickListener {
            final /* synthetic */ 9 O000000o;

            3(9 9) {
            }

            public void onClick(View view) {
            }
        }

        9(jl jlVar) {
        }

        public boolean onCache(String str) {
            return false;
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

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$O000000o */
    public enum O000000o {
        Empty,
        Content,
        Error
    }

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$O00000Oo */
    private class O00000Oo extends fw<FansListBean> {
        final /* synthetic */ jl O000000o;

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$O00000Oo$1 */
        class 1 implements OnClickListener {
            final /* synthetic */ FansListBean O000000o;
            final /* synthetic */ O00000Oo O00000Oo;

            1(O00000Oo o00000Oo, FansListBean fansListBean) {
            }

            public void onClick(View view) {
            }
        }

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$O00000Oo$2 */
        class 2 implements OnClickListener {
            final /* synthetic */ FansListBean O000000o;
            final /* synthetic */ O00000Oo O00000Oo;

            2(O00000Oo o00000Oo, FansListBean fansListBean) {
            }

            public void onClick(View view) {
            }
        }

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$O00000Oo$3 */
        class 3 implements OnClickListener {
            final /* synthetic */ ga O000000o;
            final /* synthetic */ O00000Oo O00000Oo;

            3(O00000Oo o00000Oo, ga gaVar) {
            }

            public void onClick(View view) {
            }
        }

        O00000Oo(jl jlVar, Context context, int i, List<FansListBean> list) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, FansListBean fansListBean, int i) {
        }
    }

    /* compiled from: DynamicFragmentPImpl */
    /* renamed from: jl$O00000o0 */
    public class O00000o0 extends fx<DynamicBean> {
        final /* synthetic */ jl O000000o;

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$O00000o0$O000000o */
        class O000000o implements fy<DynamicBean> {
            final /* synthetic */ O00000o0 O000000o;

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O000000o$1 */
            class 1 implements OnClickListener {
                final /* synthetic */ DynamicBean O000000o;
                final /* synthetic */ O000000o O00000Oo;

                1(O000000o o000000o, DynamicBean dynamicBean) {
                }

                public void onClick(View view) {
                }
            }

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O000000o$2 */
            class 2 implements OnClickListener {
                final /* synthetic */ DynamicBean O000000o;
                final /* synthetic */ O000000o O00000Oo;

                2(O000000o o000000o, DynamicBean dynamicBean) {
                }

                public void onClick(View view) {
                }
            }

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O000000o$3 */
            class 3 implements OnClickListener {
                final /* synthetic */ ga O000000o;
                final /* synthetic */ DynamicBean O00000Oo;
                final /* synthetic */ O000000o O00000o0;

                3(O000000o o000000o, ga gaVar, DynamicBean dynamicBean) {
                }

                public void onClick(View view) {
                }
            }

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O000000o$4 */
            class 4 implements OnClickListener {
                final /* synthetic */ DynamicBean O000000o;
                final /* synthetic */ O000000o O00000Oo;

                4(O000000o o000000o, DynamicBean dynamicBean) {
                }

                public void onClick(View view) {
                }
            }

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O000000o$5 */
            class 5 implements OnClickListener {
                final /* synthetic */ DynamicBean O000000o;
                final /* synthetic */ O000000o O00000Oo;

                5(O000000o o000000o, DynamicBean dynamicBean) {
                }

                public void onClick(View view) {
                }
            }

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O000000o$6 */
            class 6 implements OnClickListener {
                final /* synthetic */ DynamicBean O000000o;
                final /* synthetic */ O000000o O00000Oo;

                6(O000000o o000000o, DynamicBean dynamicBean) {
                }

                public void onClick(View view) {
                }
            }

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O000000o$7 */
            class 7 implements OnClickListener {
                final /* synthetic */ DynamicBean O000000o;
                final /* synthetic */ O000000o O00000Oo;

                7(O000000o o000000o, DynamicBean dynamicBean) {
                }

                public void onClick(View view) {
                }
            }

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O000000o$8 */
            class 8 implements OnClickListener {
                final /* synthetic */ DynamicBean O000000o;
                final /* synthetic */ O000000o O00000Oo;

                8(O000000o o000000o, DynamicBean dynamicBean) {
                }

                public void onClick(View view) {
                }
            }

            O000000o(O00000o0 o00000o0) {
            }

            public int O000000o() {
                return 0;
            }

            public void O000000o(ga gaVar, DynamicBean dynamicBean, int i) {
            }

            public boolean O000000o(DynamicBean dynamicBean, int i) {
                return false;
            }
        }

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$O00000o0$O00000Oo */
        class O00000Oo implements fy<DynamicBean> {
            final /* synthetic */ O00000o0 O000000o;

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O00000Oo$1 */
            class 1 implements OnClickListener {
                final /* synthetic */ O00000Oo O000000o;

                1(O00000Oo o00000Oo) {
                }

                public void onClick(View view) {
                }
            }

            /* compiled from: DynamicFragmentPImpl */
            /* renamed from: jl$O00000o0$O00000Oo$2 */
            class 2 implements OnClickListener {
                final /* synthetic */ O00000Oo O000000o;

                2(O00000Oo o00000Oo) {
                }

                public void onClick(View view) {
                }
            }

            O00000Oo(O00000o0 o00000o0) {
            }

            public int O000000o() {
                return 0;
            }

            public void O000000o(ga gaVar, DynamicBean dynamicBean, int i) {
            }

            public boolean O000000o(DynamicBean dynamicBean, int i) {
                return false;
            }
        }

        /* compiled from: DynamicFragmentPImpl */
        /* renamed from: jl$O00000o0$O00000o0 */
        class O00000o0 implements fy<DynamicBean> {
            final /* synthetic */ O00000o0 O000000o;

            O00000o0(O00000o0 o00000o0) {
            }

            public int O000000o() {
                return 0;
            }

            public void O000000o(ga gaVar, DynamicBean dynamicBean, int i) {
            }

            public boolean O000000o(DynamicBean dynamicBean, int i) {
                return false;
            }
        }

        O00000o0(jl jlVar, Context context, List<DynamicBean> list) {
        }
    }

    public jl(O00000Oo o00000Oo, Context context) {
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
    private void O000000o(int r4, java.lang.String r5) {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jl.O000000o(int, java.lang.String):void");
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
    private void O000000o(android.content.Context r4, int r5, int r6, java.lang.String r7) {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jl.O000000o(android.content.Context, int, int, java.lang.String):void");
    }

    private void O000000o(Context context, FansListBean fansListBean) {
    }

    static /* synthetic */ void O000000o(jl jlVar, Context context, int i, int i2, String str) {
    }

    private void O000000o(boolean z, int i) {
    }

    private void O00000Oo(int i) {
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
    private void O00000o0(int r4) {
        /*
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jl.O00000o0(int):void");
    }

    public BroadcastReceiver O000000o() {
        return null;
    }

    public void O000000o(Bundle bundle) {
    }

    public boolean O000000o(int i) {
        return false;
    }

    public O00000o0 O00000Oo() {
        return null;
    }

    public void O00000Oo(Bundle bundle) {
    }

    public boolean O00000o() {
        return false;
    }

    public boolean O00000o0() {
        return false;
    }

    public boolean O00000oO() {
        return false;
    }

    public boolean O00000oo() {
        return false;
    }

    public void O0000O0o() {
    }

    public void O0000OOo() {
    }

    public Drawable O0000Oo() {
        return null;
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
    public void O0000Oo0() {
        /*
        r5 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jl.O0000Oo0():void");
    }
}
