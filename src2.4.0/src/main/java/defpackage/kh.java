package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.zjwh.android_wh_physicalfitness.entity.PersonalRankBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import defpackage.hw.O000000o;
import defpackage.hw.O00000Oo;
import org.xutils.common.Callback.CancelledException;

/* compiled from: RankPersonalPImpl */
/* renamed from: kh */
public class kh extends iu<O00000Oo> implements O000000o {
    public static final String O000000o = "extra_rank_day";
    private PersonalRankBean O00000Oo;
    private String O00000o;
    private boolean O00000oO;
    private int O00000oo;
    private boolean O0000O0o;

    /* compiled from: RankPersonalPImpl */
    /* renamed from: kh$1 */
    class 1 implements CacheCallback {
        final /* synthetic */ kh O000000o;

        1(kh khVar) {
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

    public kh(O00000Oo o00000Oo) {
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kh.O000000o(android.content.Context):void");
    }

    public void O000000o(Bundle bundle) {
    }

    public void O00000Oo(Context context) {
    }

    public void O00000Oo(Bundle bundle) {
    }
}
