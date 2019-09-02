package defpackage;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.BannerBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfo;
import com.zjwh.android_wh_physicalfitness.entity.UploadEntity;
import com.zjwh.android_wh_physicalfitness.entity.database.SportRecord;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O0000OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o00;
import defpackage.hj.O000000o;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: RunHistoryPImpl */
/* renamed from: jt */
public class jt extends iu<O00000Oo> implements O000000o {
    private List<UploadEntity> O000000o;
    private List<SemesterInfo> O00000Oo;
    private List<BannerBean> O00000o;
    private boolean O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private long O0000Oo;
    private long O0000Oo0;
    private double O0000OoO;
    private double O0000Ooo;
    private boolean O0000o0;
    private boolean O0000o00;
    private O0000OOo.O000000o O0000o0O;

    /* compiled from: RunHistoryPImpl */
    /* renamed from: jt$1 */
    class 1 extends O00O0o00<Void> {
        final /* synthetic */ boolean O000000o;
        final /* synthetic */ Context O00000Oo;
        final /* synthetic */ jt O00000o0;

        1(jt jtVar, boolean z, Context context) {
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
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public java.lang.Void O000000o() throws java.lang.Exception {
            /*
            r15 = this;
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.jt$1.O000000o():java.lang.Void");
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(Void voidR) throws Exception {
        }

        public /* synthetic */ Object call() throws Exception {
            return null;
        }

        /* Access modifiers changed, original: protected */
        public void onPreExecute() throws Exception {
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ void onSuccess(Object obj) throws Exception {
        }
    }

    /* compiled from: RunHistoryPImpl */
    /* renamed from: jt$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ jt O000000o;

        2(jt jtVar) {
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

    /* compiled from: RunHistoryPImpl */
    /* renamed from: jt$3 */
    class 3 implements MyCallback<String> {
        final /* synthetic */ jt O000000o;

        3(jt jtVar) {
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

    /* compiled from: RunHistoryPImpl */
    /* renamed from: jt$4 */
    class 4 implements CacheCallback {
        final /* synthetic */ jt O000000o;

        /* compiled from: RunHistoryPImpl */
        /* renamed from: jt$4$1 */
        class 1 extends TypeToken<List<UploadEntity>> {
            final /* synthetic */ 4 O000000o;

            1(4 4) {
            }
        }

        4(jt jtVar) {
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

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void onSuccess(java.lang.String r5) {
            /*
            r4 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.jt$4.onSuccess(java.lang.String):void");
        }
    }

    /* compiled from: RunHistoryPImpl */
    /* renamed from: jt$5 */
    class 5 implements O0000OOo.O000000o {
        final /* synthetic */ jt O000000o;

        5(jt jtVar) {
        }

        public void O000000o() {
        }

        public void O000000o(List<BannerBean> list) {
        }
    }

    public jt(O00000Oo o00000Oo) {
    }

    private boolean O000000o(SportRecord sportRecord) {
        return false;
    }

    private void O00000o(Context context) {
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
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private void O00000o0(android.content.Context r5) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jt.O00000o0(android.content.Context):void");
    }

    private void O00000oO() {
    }

    private void O00000oo() {
    }

    static /* synthetic */ void O0000oO0(jt jtVar) {
    }

    public void O000000o() {
    }

    public void O000000o(int i) {
    }

    public void O000000o(Context context) {
    }

    public void O000000o(SemesterInfo semesterInfo, Context context) {
    }

    public void O000000o(boolean z) {
    }

    public void O000000o(boolean z, Context context) {
    }

    public List<SemesterInfo> O00000Oo() {
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
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void O00000Oo(android.content.Context r5) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jt.O00000Oo(android.content.Context):void");
    }

    public int O00000o() {
        return 0;
    }

    public boolean O00000o0() {
        return false;
    }

    public void O0000OoO() {
    }
}
