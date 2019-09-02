package defpackage;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.DynamicMainHeadBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.CacheCallback;
import defpackage.gr.O000000o;
import defpackage.gr.O00000Oo;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: DynamicMainPImpl */
/* renamed from: jm */
public class jm extends iu<O00000Oo> implements O000000o {
    private boolean O000000o;

    /* compiled from: DynamicMainPImpl */
    /* renamed from: jm$1 */
    class 1 implements CacheCallback {
        final /* synthetic */ jm O000000o;

        /* compiled from: DynamicMainPImpl */
        /* renamed from: jm$1$1 */
        class 1 extends TypeToken<List<DynamicMainHeadBean>> {
            final /* synthetic */ 1 O000000o;

            1(1 1) {
            }
        }

        1(jm jmVar) {
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

    public jm(O00000Oo o00000Oo) {
    }

    public void O000000o(Context context) {
    }
}
