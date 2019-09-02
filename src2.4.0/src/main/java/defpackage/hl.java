package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.mine.SportConcernFansBean;
import java.util.List;

/* compiled from: SportConcernFansContract */
/* renamed from: hl */
public class hl {

    /* compiled from: SportConcernFansContract */
    /* renamed from: hl$O00000Oo */
    public interface O00000Oo {
        void O000000o();

        void O000000o(int i);

        void O000000o(ResponseError responseError);

        void O000000o(List<SportConcernFansBean> list);

        void O000000o(boolean z);

        void O00000Oo();

        void O00000Oo(ResponseError responseError);

        void O00000o();

        void O00000o0();
    }

    /* compiled from: SportConcernFansContract */
    /* renamed from: hl$O000000o */
    public interface O000000o extends gy {
        BroadcastReceiver O000000o();

        void O000000o(Context context);

        void O000000o(Context context, int i, int i2, SportConcernFansBean sportConcernFansBean);

        void O000000o(Context context, boolean z);

        void O000000o(Bundle bundle);

        void O00000Oo(Bundle bundle);
    }
}
