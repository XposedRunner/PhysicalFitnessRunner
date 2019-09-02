package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.FansListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.gt.O000000o;
import defpackage.gt.O00000Oo;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: FansListPImpl */
/* renamed from: iy */
public class iy extends iz<O00000Oo> implements O000000o<FansListBean> {
    private List<FansListBean> O0000O0o;
    private boolean O0000OOo;
    private long O0000Oo0;

    /* compiled from: FansListPImpl */
    /* renamed from: iy$1 */
    class 1 extends fw<FansListBean> {
        final /* synthetic */ Context O000000o;
        final /* synthetic */ iy O00000Oo;

        /* compiled from: FansListPImpl */
        /* renamed from: iy$1$1 */
        class 1 implements OnClickListener {
            final /* synthetic */ FansListBean O000000o;
            final /* synthetic */ int O00000Oo;
            final /* synthetic */ 1 O00000o0;

            /* compiled from: FansListPImpl */
            /* renamed from: iy$1$1$1 */
            class 1 implements com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o {
                final /* synthetic */ 1 O000000o;

                1(1 1) {
                }

                public void O000000o(int i) {
                }
            }

            1(1 1, FansListBean fansListBean, int i) {
            }

            public void onClick(View view) {
            }
        }

        /* compiled from: FansListPImpl */
        /* renamed from: iy$1$2 */
        class 2 implements OnClickListener {
            final /* synthetic */ FansListBean O000000o;
            final /* synthetic */ 1 O00000Oo;

            2(1 1, FansListBean fansListBean) {
            }

            public void onClick(View view) {
            }
        }

        1(iy iyVar, Context context, int i, List list, Context context2) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, FansListBean fansListBean, int i) {
        }
    }

    /* compiled from: FansListPImpl */
    /* renamed from: iy$2 */
    class 2 implements MyCallback<String> {
        final /* synthetic */ iy O000000o;

        /* compiled from: FansListPImpl */
        /* renamed from: iy$2$1 */
        class 1 extends TypeToken<List<FansListBean>> {
            final /* synthetic */ 2 O000000o;

            1(2 2) {
            }
        }

        2(iy iyVar) {
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

    /* compiled from: FansListPImpl */
    /* renamed from: iy$3 */
    class 3 extends BroadcastReceiver {
        final /* synthetic */ iy O000000o;

        3(iy iyVar) {
        }

        public void onReceive(Context context, Intent intent) {
        }
    }

    public iy(O00000Oo o00000Oo, Context context) {
    }

    public BroadcastReceiver O000000o() {
        return null;
    }

    public fw<FansListBean> O000000o(Context context) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, int i2) {
    }

    public void O000000o(Bundle bundle) {
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
    public void O00000Oo(android.content.Context r6) {
        /*
        r5 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iy.O00000Oo(android.content.Context):void");
    }

    public void O00000Oo(Bundle bundle) {
    }

    public void O00000o(Context context) {
    }

    public void O00000o0(Context context) {
    }

    public void O0000OoO() {
    }
}
