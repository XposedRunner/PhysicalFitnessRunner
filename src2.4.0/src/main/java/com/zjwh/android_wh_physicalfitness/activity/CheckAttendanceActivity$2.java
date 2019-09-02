package com.zjwh.android_wh_physicalfitness.activity;

import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import org.xutils.common.Callback.CancelledException;

class CheckAttendanceActivity$2 implements MyCallback<String> {
    final /* synthetic */ CheckAttendanceActivity O000000o;

    CheckAttendanceActivity$2(CheckAttendanceActivity checkAttendanceActivity) {
        this.O000000o = checkAttendanceActivity;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        O00Oo00.O00000Oo(responseError.getMessage());
    }

    public void onFinished() {
        this.O000000o.O0000OoO();
        this.O000000o.O00000Oo.setEnabled(true);
    }

    public void onSuccess(String str) {
        this.O000000o.finish();
    }
}
