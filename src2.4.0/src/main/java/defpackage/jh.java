package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.zjwh.android_wh_physicalfitness.entity.NoticeDetailBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.he.O000000o;
import defpackage.he.O00000Oo;
import org.xutils.common.Callback.CancelledException;

/* compiled from: NoticeDetailPImpl */
/* renamed from: jh */
public class jh extends iu<O00000Oo> implements O000000o {
    public static final String O000000o = "extra_notice_id";
    private int O00000Oo;
    private NoticeDetailBean O00000o;

    /* compiled from: NoticeDetailPImpl */
    /* renamed from: jh$1 */
    class 1 implements MyCallback<String> {
        final /* synthetic */ jh O000000o;

        1(jh jhVar) {
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

    public jh(O00000Oo o00000Oo) {
    }

    public void O000000o(Context context) {
    }

    public void O000000o(Bundle bundle) {
    }
}
