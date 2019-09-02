package defpackage;

import android.content.Context;
import com.zjwh.android_wh_physicalfitness.entity.FansListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import org.xutils.common.Callback.CancelledException;

/* compiled from: FansPImpl */
/* renamed from: iz */
public abstract class iz<T> extends iu<T> {
    public static final String O000000o = "extra_user_id";
    public static final String O00000Oo = "extra_user_name";
    protected int O00000o;
    String O00000oO;
    protected Context O00000oo;

    /* compiled from: FansPImpl */
    /* renamed from: iz$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ FansListBean O000000o;
        final /* synthetic */ int O00000Oo;
        final /* synthetic */ iz O00000o0;

        1(iz izVar, FansListBean fansListBean, int i) {
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

    public abstract void O000000o(int i, int i2);

    /* Access modifiers changed, original: 0000 */
    public void O000000o(int i, int i2, FansListBean fansListBean) {
    }
}
