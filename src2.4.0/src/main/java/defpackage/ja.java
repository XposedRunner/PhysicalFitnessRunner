package defpackage;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ActivitiesBean;
import com.zjwh.android_wh_physicalfitness.entity.BannerBean;
import com.zjwh.android_wh_physicalfitness.entity.DiscoverModuleBean;
import com.zjwh.android_wh_physicalfitness.entity.NewsBean;
import com.zjwh.android_wh_physicalfitness.entity.NoticeListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.TopicBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O0000OOo;
import defpackage.gu.O000000o;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: FindPImpl */
/* renamed from: ja */
public class ja extends iu<O00000Oo> implements O000000o {
    private List<NewsBean> O000000o;
    private List<BannerBean> O00000Oo;
    private List<TopicBean> O00000o;
    private List<ActivitiesBean> O00000oO;
    private List<NoticeListBean> O00000oo;
    private List<DiscoverModuleBean> O0000O0o;
    private boolean O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private boolean O0000OoO;
    private boolean O0000Ooo;

    /* compiled from: FindPImpl */
    /* renamed from: ja$10 */
    class 10 implements MyCallback<String> {
        final /* synthetic */ ja O000000o;

        /* compiled from: FindPImpl */
        /* renamed from: ja$10$1 */
        class 1 extends TypeToken<List<NoticeListBean>> {
            final /* synthetic */ 10 O000000o;

            1(10 10) {
            }
        }

        10(ja jaVar) {
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

    /* compiled from: FindPImpl */
    /* renamed from: ja$11 */
    class 11 implements CacheCallback {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ ja O00000Oo;

        /* compiled from: FindPImpl */
        /* renamed from: ja$11$1 */
        class 1 extends TypeToken<List<NewsBean>> {
            final /* synthetic */ 11 O000000o;

            1(11 11) {
            }
        }

        11(ja jaVar, Context context) {
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

    /* compiled from: FindPImpl */
    /* renamed from: ja$1 */
    class 1 extends TypeToken<List<BannerBean>> {
        final /* synthetic */ ja O000000o;

        1(ja jaVar) {
        }
    }

    /* compiled from: FindPImpl */
    /* renamed from: ja$2 */
    class 2 implements CacheCallback {
        final /* synthetic */ ja O000000o;

        /* compiled from: FindPImpl */
        /* renamed from: ja$2$1 */
        class 1 extends TypeToken<List<TopicBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(ja jaVar) {
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

    /* compiled from: FindPImpl */
    /* renamed from: ja$3 */
    class 3 implements CacheCallback {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ ja O00000Oo;

        /* compiled from: FindPImpl */
        /* renamed from: ja$3$1 */
        class 1 extends TypeToken<List<ActivitiesBean>> {
            final /* synthetic */ 3 O000000o;

            1(3 3) {
            }
        }

        3(ja jaVar, Context context) {
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

    /* compiled from: FindPImpl */
    /* renamed from: ja$4 */
    class 4 extends TypeToken<List<TopicBean>> {
        final /* synthetic */ ja O000000o;

        4(ja jaVar) {
        }
    }

    /* compiled from: FindPImpl */
    /* renamed from: ja$5 */
    class 5 extends TypeToken<List<NewsBean>> {
        final /* synthetic */ ja O000000o;

        5(ja jaVar) {
        }
    }

    /* compiled from: FindPImpl */
    /* renamed from: ja$6 */
    class 6 extends TypeToken<List<ActivitiesBean>> {
        final /* synthetic */ ja O000000o;

        6(ja jaVar) {
        }
    }

    /* compiled from: FindPImpl */
    /* renamed from: ja$7 */
    class 7 extends TypeToken<List<DiscoverModuleBean>> {
        final /* synthetic */ ja O000000o;

        7(ja jaVar) {
        }
    }

    /* compiled from: FindPImpl */
    /* renamed from: ja$8 */
    class 8 implements O0000OOo.O000000o {
        final /* synthetic */ ja O000000o;

        8(ja jaVar) {
        }

        public void O000000o() {
        }

        public void O000000o(List<BannerBean> list) {
        }
    }

    /* compiled from: FindPImpl */
    /* renamed from: ja$9 */
    class 9 implements CacheCallback {
        final /* synthetic */ ja O000000o;

        /* compiled from: FindPImpl */
        /* renamed from: ja$9$1 */
        class 1 extends TypeToken<List<DiscoverModuleBean>> {
            final /* synthetic */ 9 O000000o;

            1(9 9) {
            }
        }

        9(ja jaVar) {
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

    public ja(O00000Oo o00000Oo) {
    }

    private void O00000o(Context context) {
    }

    private void O00000oO(Context context) {
    }

    private void O00000oo(Context context) {
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
    private void O0000O0o(android.content.Context r5) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja.O0000O0o(android.content.Context):void");
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
    private void O0000OOo(android.content.Context r5) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja.O0000OOo(android.content.Context):void");
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
    private void O0000Oo0(android.content.Context r5) {
        /*
        r4 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja.O0000Oo0(android.content.Context):void");
    }

    public fa O000000o(Context context) {
        return null;
    }

    public void O000000o() {
    }

    public ez O00000Oo(Context context) {
        return null;
    }

    public void O00000Oo() {
    }

    public void O00000o0(Context context) {
    }
}
