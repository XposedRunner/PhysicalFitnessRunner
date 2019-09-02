package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.rollcall.RollCallClassInfoBean;
import com.zjwh.android_wh_physicalfitness.entity.rollcall.RollCallRankInfoBean;

/* compiled from: RollCallContract */
/* renamed from: hh */
public class hh {

    /* compiled from: RollCallContract */
    /* renamed from: hh$O00000Oo */
    public interface O00000Oo {
        void O000000o(BluetoothAdapter bluetoothAdapter);

        void O000000o(ResponseError responseError);

        void O000000o(RollCallClassInfoBean rollCallClassInfoBean);

        void O000000o(RollCallRankInfoBean rollCallRankInfoBean);

        void O000000o(boolean z);

        void O00000o();

        void O00000oO();

        void O00000oO(String str);

        void O0000OoO();
    }

    /* compiled from: RollCallContract */
    /* renamed from: hh$O000000o */
    public interface O000000o extends gy {
        void O000000o();

        void O000000o(Context context);

        void O00000Oo();

        void O00000Oo(Context context);
    }
}
