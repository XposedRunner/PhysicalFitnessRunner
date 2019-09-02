package defpackage;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.TopicBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: TopicPImpl */
/* renamed from: jk */
public class jk extends iu<gx> implements gw<TopicBean> {
    private List<TopicBean> O000000o;
    private boolean O00000Oo;
    private int O00000o;
    private boolean O00000oO;

    /* compiled from: TopicPImpl */
    /* renamed from: jk$1 */
    class 1 extends fw<TopicBean> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ jk O00000Oo;

        /* compiled from: TopicPImpl */
        /* renamed from: jk$1$1 */
        class 1 implements OnClickListener {
            final /* synthetic */ TopicBean O000000o;
            final /* synthetic */ 1 O00000Oo;

            1(1 1, TopicBean topicBean) {
            }

            public void onClick(View view) {
            }
        }

        1(jk jkVar, Context context, int i, List list, Context context2) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, TopicBean topicBean, int i) {
        }
    }

    /* compiled from: TopicPImpl */
    /* renamed from: jk$2 */
    class 2 implements CacheCallback {
        final /* synthetic */ jk O000000o;

        /* compiled from: TopicPImpl */
        /* renamed from: jk$2$1 */
        class 1 extends TypeToken<List<TopicBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(jk jkVar) {
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

    public jk(gx gxVar) {
    }

    public fw<TopicBean> O000000o(Context context) {
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jk.O00000Oo(android.content.Context):void");
    }

    public void O00000o(Context context) {
    }

    public void O00000o0(Context context) {
    }

    public void O0000OoO() {
    }
}
