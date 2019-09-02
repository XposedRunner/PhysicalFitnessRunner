package com.zjwh.android_wh_physicalfitness.activity;

import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import org.xutils.common.Callback.CancelledException;

class BindAccountActivity$8 implements MyCallback<String> {
    final /* synthetic */ BindAccountActivity O000000o;

    BindAccountActivity$8(BindAccountActivity bindAccountActivity) {
        this.O000000o = bindAccountActivity;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        O00Oo0.O000000o(this.O000000o, responseError.getMessage());
    }

    public void onFinished() {
    }

    public void onSuccess(String str) {
        try {
            BindAccountActivity.O00000oO(this.O000000o).setInfoComplete(true);
            BindAccountActivity.O00000oO(this.O000000o).setLogout(false);
            O00Oo0.O000000o(BindAccountActivity.O00000oO(this.O000000o));
            BindAccountActivity.O0000O0o(this.O000000o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
