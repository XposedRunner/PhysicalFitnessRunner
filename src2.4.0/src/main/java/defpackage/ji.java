package defpackage;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.NoticeListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.hf.O000000o;
import defpackage.hf.O00000Oo;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

/* compiled from: NoticeListPImpl */
/* renamed from: ji */
public class ji extends iu<O00000Oo> implements O000000o {
    private List<NoticeListBean> O000000o;

    /* compiled from: NoticeListPImpl */
    /* renamed from: ji$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ ji O000000o;

        /* compiled from: NoticeListPImpl */
        /* renamed from: ji$1$1 */
        class 1 extends TypeToken<List<NoticeListBean>> {
            final /* synthetic */ 1 O000000o;

            1(1 1) {
            }
        }

        1(ji jiVar) {
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

    public ji(O00000Oo o00000Oo) {
    }

    public void O000000o(Context context) {
    }
}
