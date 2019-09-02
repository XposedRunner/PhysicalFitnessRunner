package defpackage;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.NewsBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: ArticlePImpl */
/* renamed from: ir */
public class ir extends iu<gx> implements gv {
    private List<NewsBean> O000000o;
    private boolean O00000Oo;
    private int O00000o;
    private boolean O00000oO;

    /* compiled from: ArticlePImpl */
    /* renamed from: ir$1 */
    class 1 extends fw<NewsBean> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ ir O00000Oo;

        /* compiled from: ArticlePImpl */
        /* renamed from: ir$1$1 */
        class 1 implements OnClickListener {
            final /* synthetic */ NewsBean O000000o;
            final /* synthetic */ 1 O00000Oo;

            1(1 1, NewsBean newsBean) {
            }

            public void onClick(View view) {
            }
        }

        1(ir irVar, Context context, int i, List list, Context context2) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, NewsBean newsBean, int i) {
        }
    }

    /* compiled from: ArticlePImpl */
    /* renamed from: ir$2 */
    class 2 implements CacheCallback {
        final /* synthetic */ ir O000000o;

        /* compiled from: ArticlePImpl */
        /* renamed from: ir$2$1 */
        class 1 extends TypeToken<List<NewsBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(ir irVar) {
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

    public ir(gx gxVar) {
    }

    public fw<NewsBean> O000000o(Context context) {
        return null;
    }

    public void O000000o() {
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ir.O00000Oo(android.content.Context):void");
    }

    public void O00000o(Context context) {
    }

    public void O00000o0(Context context) {
    }

    public void O0000OoO() {
    }
}
