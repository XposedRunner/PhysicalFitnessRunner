package com.zjwh.android_wh_physicalfitness.ui.mine;

import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SignIntegralBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import org.xutils.common.Callback.CancelledException;

class MineFragment$5 implements MyCallback<String> {
    final /* synthetic */ MineFragment O000000o;

    MineFragment$5(MineFragment mineFragment) {
        this.O000000o = mineFragment;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        O00Oo00.O000000o(responseError.getMessage());
    }

    public void onFinished() {
    }

    public void onSuccess(String str) {
        MineFragment.O000000o(this.O000000o, (SignIntegralBean) O000o000.O000000o().fromJson(str, SignIntegralBean.class));
        if (MineFragment.O0000Oo0(this.O000000o) != null) {
            MineFragment.O0000Oo(this.O000000o);
        }
    }
}
