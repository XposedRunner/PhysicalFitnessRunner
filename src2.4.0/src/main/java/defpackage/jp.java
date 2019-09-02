package defpackage;

import android.os.Bundle;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.mine.ClassBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.hg.O000000o;
import defpackage.hg.O00000Oo;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: ChangeClassPImpl */
/* renamed from: jp */
public class jp extends iu<O00000Oo> implements O000000o {
    public static final String O000000o = "extra_depart_id";
    public static final String O00000Oo = "extra_depart_name";
    public static final String O00000o = "extra_class_id";
    public static final String O00000oO = "extra_class_name";
    public static final String O00000oo = "extra_unid";
    public static final String O0000O0o = "extra_school_name";
    private String O0000OOo;
    private int O0000Oo;
    private String O0000Oo0;
    private int O0000OoO;

    /* compiled from: ChangeClassPImpl */
    /* renamed from: jp$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ jp O000000o;

        /* compiled from: ChangeClassPImpl */
        /* renamed from: jp$1$1 */
        class 1 extends TypeToken<List<ClassBean>> {
            final /* synthetic */ 1 O000000o;

            1(1 1) {
            }
        }

        1(jp jpVar) {
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

    /* compiled from: ChangeClassPImpl */
    /* renamed from: jp$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ ClassBean O000000o;
        final /* synthetic */ jp O00000Oo;

        2(jp jpVar, ClassBean classBean) {
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

    public jp(O00000Oo o00000Oo) {
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
    public void O000000o(android.content.Context r5) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jp.O000000o(android.content.Context):void");
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
    public void O000000o(android.content.Context r5, com.zjwh.android_wh_physicalfitness.entity.mine.ClassBean r6) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jp.O000000o(android.content.Context, com.zjwh.android_wh_physicalfitness.entity.mine.ClassBean):void");
    }

    public void O000000o(Bundle bundle) {
    }

    public void O000000o(ClassBean classBean) {
    }

    public void O00000Oo(Bundle bundle) {
    }
}
