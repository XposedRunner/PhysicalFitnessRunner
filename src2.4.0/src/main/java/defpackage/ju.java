package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.mine.SportConcernFansBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.hl.O000000o;
import defpackage.hl.O00000Oo;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: SportConcernFansPImpl */
/* renamed from: ju */
public class ju extends iz<O00000Oo> implements O000000o {
    private int O0000O0o;
    private long O0000OOo;
    private List<SportConcernFansBean> O0000Oo;
    private boolean O0000Oo0;

    /* compiled from: SportConcernFansPImpl */
    /* renamed from: ju$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ ju O000000o;

        /* compiled from: SportConcernFansPImpl */
        /* renamed from: ju$1$1 */
        class 1 extends TypeToken<List<SportConcernFansBean>> {
            final /* synthetic */ 1 O000000o;

            1(1 1) {
            }
        }

        1(ju juVar) {
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

    /* compiled from: SportConcernFansPImpl */
    /* renamed from: ju$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ SportConcernFansBean O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ ju O00000o0;

        2(ju juVar, SportConcernFansBean sportConcernFansBean, int i) {
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

    /* compiled from: SportConcernFansPImpl */
    /* renamed from: ju$3 */
    class 3 extends BroadcastReceiver {
        final /* synthetic */ ju O000000o;

        3(ju juVar) {
        }

        public void onReceive(Context context, Intent intent) {
        }
    }

    public ju(O00000Oo o00000Oo) {
    }

    public BroadcastReceiver O000000o() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, int i2) {
    }

    public void O000000o(Context context) {
    }

    public void O000000o(Context context, int i, int i2, SportConcernFansBean sportConcernFansBean) {
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
    public void O000000o(android.content.Context r5, boolean r6) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ju.O000000o(android.content.Context, boolean):void");
    }

    public void O000000o(Bundle bundle) {
    }

    public void O00000Oo(Bundle bundle) {
    }
}
