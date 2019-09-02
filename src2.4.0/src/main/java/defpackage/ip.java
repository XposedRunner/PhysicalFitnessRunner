package defpackage;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ActivitiesBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: ActivitiesPImpl */
/* renamed from: ip */
public class ip extends iu<gx> implements gw<ActivitiesBean> {
    private List<ActivitiesBean> O000000o;
    private boolean O00000Oo;
    private int O00000o;
    private boolean O00000oO;

    /* compiled from: ActivitiesPImpl */
    /* renamed from: ip$1 */
    class 1 extends fw<ActivitiesBean> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ ip O00000Oo;

        /* compiled from: ActivitiesPImpl */
        /* renamed from: ip$1$1 */
        class 1 implements OnClickListener {
            final /* synthetic */ ActivitiesBean O000000o;
            final /* synthetic */ 1 O00000Oo;

            1(1 1, ActivitiesBean activitiesBean) {
            }

            public void onClick(View view) {
            }
        }

        1(ip ipVar, Context context, int i, List list, Context context2) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, ActivitiesBean activitiesBean, int i) {
        }
    }

    /* compiled from: ActivitiesPImpl */
    /* renamed from: ip$2 */
    class 2 implements CacheCallback {
        final /* synthetic */ ip O000000o;

        /* compiled from: ActivitiesPImpl */
        /* renamed from: ip$2$1 */
        class 1 extends TypeToken<List<ActivitiesBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(ip ipVar) {
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

    public ip(gx gxVar) {
    }

    public fw<ActivitiesBean> O000000o(Context context) {
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
    public void O00000Oo(android.content.Context r5) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ip.O00000Oo(android.content.Context):void");
    }

    public void O00000o(Context context) {
    }

    public void O00000o0(Context context) {
    }

    public void O0000OoO() {
    }
}
