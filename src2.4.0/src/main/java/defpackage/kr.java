package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.if.O000000o;
import defpackage.if.O00000Oo;
import org.xutils.common.Callback.CancelledException;

/* compiled from: SportInfoPImpl */
/* renamed from: kr */
public class kr extends iu<O00000Oo> implements O000000o {
    public static final String O000000o = "extra_dis_total";
    public static final String O00000Oo = "extra_dis_valid";

    /* compiled from: SportInfoPImpl */
    /* renamed from: kr$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ kr O000000o;

        1(kr krVar) {
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

    public kr(O00000Oo o00000Oo) {
    }

    public void O000000o(Context context) {
    }

    public void O000000o(Bundle bundle) {
    }
}
