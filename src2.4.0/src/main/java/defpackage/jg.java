package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.MyOrderInfoBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.hd.O000000o;
import defpackage.hd.O00000Oo;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: MyOrderFragmentPImpl */
/* renamed from: jg */
public class jg extends iu<O00000Oo> implements O000000o {
    private Context O000000o;
    private List<MyOrderInfoBean> O00000Oo;
    private int O00000o;
    private boolean O00000oO;
    private int O00000oo;
    private int O0000O0o;

    /* compiled from: MyOrderFragmentPImpl */
    /* renamed from: jg$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ jg O000000o;

        /* compiled from: MyOrderFragmentPImpl */
        /* renamed from: jg$1$1 */
        class 1 extends TypeToken<List<MyOrderInfoBean>> {
            final /* synthetic */ 1 O000000o;

            1(1 1) {
            }
        }

        1(jg jgVar) {
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

    public jg(O00000Oo o00000Oo, Context context) {
    }

    public void O000000o() {
    }

    public void O000000o(int i) {
    }

    public void O000000o(Bundle bundle) {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(Bundle bundle) {
    }

    public void O00000o0() {
    }

    public void O0000OoO() {
    }
}
